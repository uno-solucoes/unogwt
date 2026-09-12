package com.br.client.panel.fn.fnw0223.model;

import java.util.ArrayList;
import java.util.Date;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.widgets.tree.TreeNode;

public class EPlanoContas extends TreeNode{ 
		
	static final String contaNullDespesa 		 = "-2";
	static final String contaNullReceita 		 = "-3";	
	
	public static final String CONTA_RECEITA		= "+";
	public static final String CONTA_DESPESA 		= "-";
	public static final String CONTA_RESULTADO 		= "=";
	public static final String CONTA_NULL_DESPESA 	= contaNullDespesa;
	public static final String CONTA_NULL_RECEITA 	= contaNullReceita;
	
	public static final String TIPO_CONTA_RECEITA  = "20";
	public static final String TIPO_CONTA_DESPESA  = "10";
	
	private String key;
	private String parent;
	ArrayList<String> totalAttributes = new ArrayList<String>();
	private double totalGeral = 0.0;
	private boolean folha = false;
	private boolean rootNode  = false;
	private boolean receita   = false;
	private boolean agrupadorPrincipal = false;
 	
	private boolean visited = false;
	private String tipoConta = "";
	
 	public EPlanoContas(String[] row){

		String conta				= row[0];
		String subConta				= row[1];
		String descricao			= row[2];
		tipoConta					= row[3];
		String contaTotalizadora	= row[4];
		String subContaTotalizadora = row[5];

		this.key 		= conta+subConta;
		this.parent 	= contaTotalizadora+subContaTotalizadora;

        setAttribute("Conta", 	        key);  
        setAttribute("ContaPai",        parent);  
        if ( 
        		getKey().trim().equals(CONTA_DESPESA) 
        		|| 
        		getKey().trim().equals(CONTA_RECEITA) 
        		|| 
        		getKey().trim().equals(CONTA_RESULTADO)
        		||
        		conta.trim().equals(CONTA_NULL_DESPESA )
        		||
        		conta.trim().equals(CONTA_NULL_RECEITA)
        )
        	// 
        	// setAttribute( "DescricaoConta",   "("+key+") - "+"("+parent+") "+tipoConta+"_"+descricao );

        	setAttribute( "DescricaoConta",  descricao );
        else
        	// tipoConta+"_"+
        	//  "("+parent+") "+
        	// setAttribute( "DescricaoConta", "("+key+") - "+"("+parent+") "+tipoConta+"_"+conta+"."+subConta+"-"+descricao );        	
        	setAttribute( "DescricaoConta", conta+"."+subConta+"-"+descricao );
       
        if ( "20".equals( HowMGWTUtilities.getString(tipoConta).trim() ))
        	receita = true;
        else
        	receita = false;
   }
	
	public void clearLinks(){
		
		if ( totalAttributes == null )
			return;
		
		for ( String attr : totalAttributes ){			
			setAttribute(attr,(Double)null);
		}
		this.setTotalGeral(0.0);
		totalAttributes.clear();
	}
	
	public void linkResult(String[] row, String dimension){
		if ( row[4] != null ){
			setAttribute(dimension, new Double(row[4]));
			totalAttributes.add(dimension);
		}
		else{
			setAttribute(dimension, new Double(0));
			totalAttributes.add(dimension);			
		}
	}
	
	
	public void incluirLinkTotalResult(String dimension){
		setAttribute(dimension, new Double(0.0));
		totalAttributes.add(dimension);
	}	
	
	public void linkTotal(){
		totalGeral = 0.0;
		for ( String attr : totalAttributes ){			
			double item = getAttributeAsDouble(attr);
			totalGeral += item;
		}
		setAttribute("totalGeral", new Double(totalGeral));
	}
	
	/**
	 * Atualiza os totais gerais das contas principais.
	 * @param contaReceita
	 * @param contaDespesa
	 */
	public void refreshTotal(EPlanoContas contaReceita, EPlanoContas contaDespesa){
		Double receita;
		Double despesa;
		Double resultado;
		this.setTotalGeral(0.0);
		for ( String attr : this.getTotalAttributes() ){
			receita = contaReceita.getAttributeAsDouble(attr);		
			despesa = contaDespesa.getAttributeAsDouble(attr);
		
			if ( receita == null )
				receita = new Double(0.0);
			if ( despesa == null )
				despesa = new Double(0.0);
			resultado = receita.doubleValue() - despesa.doubleValue();
			this.setAttribute(attr, resultado);
		}
		linkTotal();
	}
	
	/**
	 * Sumariza a conta pai.
	 * @param contaFolha
	 */
	public void summary(EPlanoContas contaFolha){
		
		Double valor;
		Double item;
		for ( String attr : contaFolha.getTotalAttributes() ){
			item  = contaFolha.getAttributeAsDouble(attr);
			valor = this.getAttributeAsDouble(attr);
			if ( item != null ){
				if ( valor == null )
					valor = 0.0;
				this.setAttribute(attr, valor.doubleValue() + item.doubleValue());				
			}
		}
	}

	public static final String grupoAtrasos 	 = "1";
	public static final String grupoDataAtual    = "2";	
	public static final String grupoPagos 	 	 = "3";
	public static final String grupoPervisao 	 = "4";
	
	
	/**
	 * Cria uma conta para receita Null
	 * @return
	 */
	public static EPlanoContas createNullContaReceita(){
		String[] row = getRow(CONTA_NULL_RECEITA, CONTA_NULL_RECEITA, "CR-Conta Indefinida", TIPO_CONTA_RECEITA, CONTA_RECEITA, "");
		EPlanoContas conta = new EPlanoContas(row);
		conta.setAgrupadorPrincipal(false);
		conta.setFolha(false);
		return conta;
	}

	/**
	 * Cria uma conta para despesa Null
	 * @return
	 */
	public static EPlanoContas createNullContaDespesa(){
		String[] row = getRow(CONTA_NULL_DESPESA, CONTA_NULL_DESPESA, "CP-Conta Indefinida", TIPO_CONTA_DESPESA, CONTA_DESPESA, "");
		EPlanoContas conta = new EPlanoContas(row);
		conta.setAgrupadorPrincipal(false);
		conta.setFolha(false);
		return conta;
	}	

		
	
	/**
	 * Cria uma conta para receita
	 * @return
	 */
	public static EPlanoContas createContaReceita(){
		String[] row = getRow(CONTA_RECEITA, "", Tradutor.i18n.totalReceita(), TIPO_CONTA_RECEITA, null, null);
		EPlanoContas conta = new EPlanoContas(row);
		conta.setAgrupadorPrincipal(true);
		conta.setFolha(false);
		return conta;
	}
	

	/**
	 * Cria uma conta para receita
	 * @return
	 */
	public static EPlanoContas createContaResultado(){
		String[] row = getRow( CONTA_RESULTADO, "", Tradutor.i18n.totalResultado(), "RS", null,null);
		EPlanoContas conta = new EPlanoContas(row);
		conta.setAgrupadorPrincipal(true);
		conta.setFolha(false);
		return conta;
	}	
	
	/**
	 * Cria uma conta para receita
	 * @return
	 */
	public static EPlanoContas createContaDespesas(){
		String[] row = getRow(CONTA_DESPESA, "", Tradutor.i18n.totalDespesa(), TIPO_CONTA_DESPESA, null, null);
		EPlanoContas conta = new EPlanoContas(row);
		conta.setAgrupadorPrincipal(true);
		conta.setFolha(false);
		return conta;
	}

	
	private static String[] getRow(String conta, String subConta, String descricao, String tpConta, String contaPai, String subContaPai){
		if ( contaPai == null )
			contaPai = "ROOT";
		
		if ( subContaPai == null )
			subContaPai = "ROOT";
		 
		String[] row = new String[]{
				conta,
				subConta,
				descricao,
				tpConta,
				contaPai,
				subContaPai
		};
		return row;
	}
	
	public static final String getSelectPlanoContas(){
		String sql = "";
		sql  = "select ";
		sql += "	conta, ";
		sql += "	sub_conta, ";
		sql += "	desc_abrev, ";
		sql += "	tp_conta, ";
		sql += "	conta_totalizadora, ";
		sql += "	sub_conta_totalizadora ";
		sql += "from ";
		sql += "	fn_plano_conta plcop ";

		sql += "order by ";
		sql += "	conta_totalizadora, ";
		sql += "	sub_conta_totalizadora ";
		return sql;
	}
	
	
	/**
	 * Retorna o sql para recuperação dos títulos 
	 * @return
	 */
	public static final String getSelectTitulosOK(	
			boolean showCentroCusto,
			OptionView optionView,
			boolean naoListaTransferencias,
			Date periodoInicio,
			Date periodoFim,
			boolean listReceita,
			boolean listDespesas,
			boolean showDetail,
			String  contaContabil,
			String  mes,
			String sequencia,
			String cCusto,			
			String codEmpresa,
			boolean ccustoSubstring3
			
	){

		PlanoContasModel daoCP = new PlanoContasModelContasPagar(periodoInicio, periodoFim, showCentroCusto , ccustoSubstring3);
		PlanoContasModel daoCR = new PlanoContasModel(periodoInicio, periodoFim,  showCentroCusto, ccustoSubstring3);

		daoCP.setNaoListaTransferencias(naoListaTransferencias );
		daoCR.setNaoListaTransferencias(naoListaTransferencias );

		daoCP.setShowDetail(showDetail);
		daoCR.setShowDetail(showDetail);

		daoCP.setCodEmpresa(codEmpresa);
		daoCR.setCodEmpresa(codEmpresa);

		daoCP.setCcusto(cCusto);
		daoCR.setCcusto(cCusto);

		daoCR.setMes(mes);
		daoCR.setContaContabil(contaContabil);
		daoCR.setSequencia(sequencia);
		
		daoCP.setMes(mes);
		daoCP.setContaContabil(contaContabil);
		daoCP.setSequencia(sequencia);
		
		String select = "" ;

		if( listReceita ){
			select += daoCR.getSelectTitulosAVencer();
		}

		if( listReceita && listDespesas ){
			select += "\n";
			select += "UNION ALL";
			select += "\n";
		}

		if ( listDespesas ){
			select += daoCP.getSelectTitulosAVencer();
		}
				
		
		System.out.println("\n\n\n\n\n\n");
		System.out.println(select);
		System.out.println("\n\n\n\n\n\n");
		return select;
	}


	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the parent
	 */
	public String getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

	/**
	 * @return the total
	 */
	public double getTotalGeral() {
		return totalGeral;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotalGeral(double total) {
		this.totalGeral = total;
	}

	/**
	 * @return the folha
	 */
	public boolean isFolha() {
		return folha;
	}

	/**
	 * @param folha the folha to set
	 */
	public void setFolha(boolean folha) {
		this.folha = folha;
	}

	/**
	 * @return the totalAttributes
	 */
	public ArrayList<String> getTotalAttributes() {
		return totalAttributes;
	}

	/**
	 * @param totalAttributes the totalAttributes to set
	 */
	public void setTotalAttributes(ArrayList<String> totalAttributes) {
		this.totalAttributes = totalAttributes;
	}

	/**
	 * @return the rootNode
	 */
	public boolean isRootNode() {
		return rootNode;
	}

	/**
	 * @param rootNode the rootNode to set
	 */
	public void setRootNode(boolean rootNode) {
		this.rootNode = rootNode;
	}

	/**
	 * @return the receita
	 */
	public boolean isReceita() {
		return receita;
	}

	/**
	 * @param receita the receita to set
	 */
	public void setReceita(boolean receita) {
		if ( this.isRootNode() ){
			if ( receita )
				setParent(CONTA_RECEITA);
			else
				setParent(CONTA_DESPESA);
			
			setAttribute("ContaPai", getParent());
		}
		this.receita = receita;
	}

	/**
	 * @return the agrupadorPrincipal
	 */
	public boolean isAgrupadorPrincipal() {
		return agrupadorPrincipal;
	}

	/**
	 * @param agrupadorPrincipal the agrupadorPrincipal to set
	 */
	public void setAgrupadorPrincipal(boolean agrupadorPrincipal) {
		this.agrupadorPrincipal = agrupadorPrincipal;
	}

	/**
	 * @return the visited
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/**
	 * @return the tipoConta
	 */
	public String getTipoConta() {
		return tipoConta;
	}

	/**
	 * @param tipoConta the tipoConta to set
	 */
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
}