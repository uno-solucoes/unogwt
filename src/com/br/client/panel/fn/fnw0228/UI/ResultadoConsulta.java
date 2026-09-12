package com.br.client.panel.fn.fnw0228.UI;


import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.model.ed.entity.eExcelCell;
import com.br.client.model.ed.entity.eExcelCollectionHeader;
import com.br.client.model.ed.entity.eExcelHeader;
import com.br.client.model.ed.entity.eExcelRow;
import com.br.client.model.ed.entity.eExcelSheet;
import com.br.client.model.ed.entity.eExcelWorksheet;
import com.br.client.model.fn.fnw0217.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.fn.fnw0228.model.EPlanoContas;
import com.br.client.panel.fn.fnw0228.model.OptionView;
import com.br.client.panel.registro.Services;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.howmake.client.form.UI.HowMGWTPrintDialog;
import com.howmake.client.form.UI.HowMGWTWindowDocument;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HOWMGWTDataSourceQuery;
import com.howmake.client.form.model.HowMGWTCallImpl;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTPDF;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AutoFitWidthApproach;
import com.smartgwt.client.types.RecordSummaryFunctionType;
import com.smartgwt.client.types.SummaryFunctionType;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.ClickHandler;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class ResultadoConsulta extends HLayout{

	private HowMGWTPrintDialog printDialog;
	
	private boolean callCentroCusto = true; 
	
	private EPlanoContas currentContextRecord;
	private int currentContextColumn;
	private int currentContextRow;
	private PainelDetalhes painelDetalhes;
	
	private Menu contextMenu = new Menu();  

	private Tree treeDataRecords;

	private FiltroConsulta filtroConsulta;

    // private com.smartgwt.client.widgets.Window winModal = new com.smartgwt.client.widgets.Window();
    private HTMLPanel htmlPanel = new HTMLPanel("<center><font>"+Tradutor.i18n.formAguardeProcessandoConsulta()+"</font></center>");       

	private boolean executeTimer = false;
	private Timer timer;

	private boolean showAllPlanoContas = false;

	private EPlanoContas contaReceitas 		= EPlanoContas.createContaReceita();
	private EPlanoContas contaDespesas 		= EPlanoContas.createContaDespesas();	
	private EPlanoContas contaResultado 	= EPlanoContas.createContaResultado();
	private EPlanoContas contaNullReceita 	= EPlanoContas.createNullContaReceita();
	private EPlanoContas contaNullDespesa 	= EPlanoContas.createNullContaDespesa();
	
	private String mesAtual = "";
	private String atrasados= "";	
	
	private TreeMap<String, EPlanoContas> planoContas    = new TreeMap<String, EPlanoContas>();
	private TreeMap<String, EPlanoContas> planoContasPai = new TreeMap<String, EPlanoContas>();
	private TreeMap<String,String> grupos= new TreeMap<String,String>();
	private HeaderSpan[] spans;
	private TreeGrid treeGrid;
	private EPlanoContas[] oCurrentPlanoContas;
	private ArrayList<EPlanoContas> aContasValidas = new ArrayList<EPlanoContas>();
	
	private EPlanoContas[] contasPai = new EPlanoContas[0];
	private CellFormatter formatterDouble;
	
	public ResultadoConsulta(boolean callCentroCusto){

		this.callCentroCusto = callCentroCusto;
		
	    contextMenu.setShowShadow(true);  
	    contextMenu.setShadowDepth(10);
	    
	    if( ! callCentroCusto ){
	        MenuItem showDetailsContaMes = new MenuItem("Detalhes Conta Mes ",    "actions/ico_mais.gif", "");  
	        showDetailsContaMes.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(MenuItemClickEvent event) {
					showDetail(PainelDetalhes.OPTION_CONTA_MES);
				}
			});
	        
	        // MenuItem exportCsv   = new MenuItem("Exportar CSV", "icons/16/export1.png",            "");  
	        contextMenu.setItems(showDetailsContaMes);
	    }
	    
		formatterDouble = new CellFormatter() {
	        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
	            if(value == null) return null;
	            try{
	            	return NumberFormat.getFormat("###,###,###,###,###,###,##0.00").format(new Double(value.toString()));
	            }
	            catch(Throwable er){
	            	return NumberFormat.getFormat("###,###,###,###,###,###,##0.00").format(0.0);
	            }
	        }
		};		
		
		contaReceitas.setIcon("actions/sum.png");
		contaDespesas.setIcon("actions/sum.png");
		contaResultado.setIcon("actions/sum.png");

		
		this.setWidth100();
		this.setHeight100();

		onBuscaPlanoContas();						// Carrega o plano de contas.

		grupos.put("01", Tradutor.i18n.formGrupo01());
		grupos.put("02", Tradutor.i18n.formGrupo02());
		grupos.put("03", Tradutor.i18n.formGrupo03());
		grupos.put("04", Tradutor.i18n.formTitulosEmitidos());
		
 
		treeGrid = new TreeGrid();
		
		// Cria as colunas
		TreeGridField campo = new TreeGridField("DescricaoConta" , Tradutor.i18n.formConta(), 320);
		campo.setAttribute("grupoTitle", "" );
		campo.setAttribute("grupo", "DS");
		campo.setFrozen(true);
		campo.setCanHide(false);
		campo.setCanReorder(false);	
		campo.setCanFreeze(false);
		campo.setCanSort(false);
		campo.setCanSortClientOnly(false);
		
		treeGrid.setFields(campo);
		
		this.addMember(treeGrid);		
		
		
	}
 
	/**
7	 * Encaminha a requisição para o servidor para executar a consulta.
	 */
	private boolean onBuscaPlanoContas() {
		
		HowMGWTWindowWait.showWait();
        
		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
			
				public void onFailure(Throwable caught) {
					HowMGWTWindowWait.hideWait();
					caught.printStackTrace();
					com.google.gwt.user.client.Window.alert(Tradutor.i18n.formEnderecoBase()+GWT.getHostPageBaseURL()+"\n"+caught.getMessage());
				}

				public void onSuccess(HowMGWTEntity result) {
					if ( result.getData().size() == 0){
						HowMGWTWindowWait.hideWait();
						Window.alert(Tradutor.i18n.alertNaoEncontrouRegistros());
						return;
					}					
					showResult(result);
				}
		};
		HowMGWTEntity entity = Fabrica.createEntity();
		entity.setAction(Services.acaoSelectInEmpresa);
		
		HowMProperty pSelect = new HowMProperty(Fabrica.DEFAULT_SELECT, EPlanoContas.getSelectPlanoContas());
		entity.getParameters().put(pSelect.getName(), pSelect);
		
		Configuracao.getProxyStruts().executeQuery(entity, callback);
		return true;
	}
	
	/**
	 * Carrega o Plano de Contas.
	 * @param result
	 */
	public void showResult(HowMGWTEntity result){
				
		// Inclui contas adicionais para totalização de para 
		// agrupamento de receitas e despesas sem conta associada.
		planoContas.put(contaReceitas.getKey(), contaReceitas);
		planoContas.put(contaDespesas.getKey(), contaDespesas);
		planoContas.put(contaNullDespesa.getKey(), contaNullDespesa);
		planoContas.put(contaNullReceita.getKey(), contaNullReceita);
		
		for ( String[] row : result.getData() ){
			EPlanoContas conta = new EPlanoContas(row);
			planoContas.put(conta.getKey(), conta);			
			planoContasPai.put( conta.getParent(), conta);
		}

		Object[] entry = planoContas.keySet().toArray();

		oCurrentPlanoContas = new EPlanoContas[entry.length];
		ArrayList<EPlanoContas> oContasPai = new ArrayList<EPlanoContas>();
		int i = 0;
		// Percorre o plano de contas e corrige os niveis de aninhamento do plano.
		for ( Object obj : entry){
			EPlanoContas conta = planoContas.get(obj.toString());
			oCurrentPlanoContas[i] = conta;
			// Verifica se a conta é folha.
			conta.setFolha(false);
			// Se encontrar encontrar a conta nas contas pai,
			// significa que é uma conta filha.
			EPlanoContas contaPai = this.planoContasPai.get(obj.toString());
			if (  contaPai == null ){
				conta.setFolha(true);
				markContaNivelZero(conta,this.planoContasPai.get(conta.getParent()));
			}
			else{
				oContasPai.add(conta);
			}			
			i ++;
		}
 		
		contasPai = new EPlanoContas[oContasPai.size()];
		i = 0;
		for ( EPlanoContas plano : oContasPai){
			contasPai[i] = plano;
			// markContaNivelZero(plano,plano);
			i ++;
		}
		HowMGWTWindowWait.hideWait();
		
		
		System.out.println("Plano de Contas carregado com sucesso...");
	}
 
	
	
	/**
	 * <HR>
	 * Executa a consulta no banco de dados para carga da movimentação do balancete.
	 */
	public void buscarMovimentacao(){
		if ( ! this.filtroConsulta.getFieldListarDespesas().getField().getValueAsBoolean().booleanValue()  
			 &&
			 ! this.filtroConsulta.getFieldListarReceitas().getField().getValueAsBoolean().booleanValue()
		){
			SC.say("Informe Receita/Despesa para executar a consulta");
			return;
		}
		
		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
				
				public void onFailure(Throwable caught) {
					caught.printStackTrace();
					HowMGWTWindowWait.hideWait();
					com.google.gwt.user.client.Window.alert(Tradutor.i18n.formEnderecoBase()+GWT.getHostPageBaseURL()+"\n"+caught.getMessage());
				}
	
				public void onSuccess(final HowMGWTEntity result) {
					if ( result.getThrowable() != null ){
						HowMGWTWindowWait.hideWait();
						com.google.gwt.user.client.Window.alert(result.getThrowable().toString());
					}
					else{
						if (treeGrid != null ){
							if ( treeDataRecords != null ){
								treeDataRecords.destroy();
								treeDataRecords = null;
							}
							treeGrid.clear();
							removeMember(treeGrid);
							treeGrid.destroy(); 
							treeGrid = null;
						}		
						
						// Zera os totalizadores das contas.
						for ( EPlanoContas conta : oCurrentPlanoContas){
							conta.clearLinks();
						}	
						validaPlanoContas(result);
				
					}
				}
		};
		HowMGWTEntity entity = Fabrica.createEntity();
		entity.setAction(Services.acaoSelectInEmpresa);

		HowMGWTWindowWait.showWait();
        
		String sql = getSelect(false,null, null, null, callCentroCusto);
		
		System.out.println(sql);
		htmlPanel.getElement().setInnerHTML("<center><font>"+Tradutor.i18n.msgSelecionandoDadosNoBancoDados()+"</font></center>");

		HOWMGWTDataSourceQuery.LAST_SQL = sql;
		HowMProperty pSelect = new HowMProperty(Fabrica.DEFAULT_SELECT, sql);
		entity.getParameters().put(pSelect.getName(), pSelect);
		
		Configuracao.getProxyStruts().executeQuery(entity, callback);
	}
	
	/**
	 * Retorna o sql para recuperar o balancete ou os detalhes do balancete.
	 * @param selectDetail
	 * @param consideraBoleto
	 * @param consideraDesconto
	 * @param consideraImpostos
	 * @return
	 */
	public String getSelect( boolean selectDetail, String mesRef, String conta, String sequencia, boolean centroCusto){
		Date dataInicio 			= this.getFiltroConsulta().getFieldDataInicio().getField().getValueAsDate();
		dataInicio          		= new Date(dataInicio.getYear(), dataInicio.getMonth(), 1);
		
		Date dataFim    			= this.getFiltroConsulta().getFieldDataFim().getField().getValueAsDate();
		dataFim 					= new Date(dataFim.getYear(),dataFim.getMonth()+1,0);
				
		OptionView optionView		= this.getFiltroConsulta().getOptionView();
		
		String sql = EPlanoContas.getSelectTitulosOK(
				centroCusto,
				optionView,
				// this.getFiltroConsulta().getFieldGrupo04().getField().getValueAsBoolean().booleanValue(),
				this.getFiltroConsulta().getFieldNaoListarTransferencias().getField().getValueAsBoolean().booleanValue(),
				dataInicio,
				dataFim,
				this.filtroConsulta.getFieldListarReceitas().getField().getValueAsBoolean().booleanValue(),
				this.filtroConsulta.getFieldListarDespesas().getField().getValueAsBoolean().booleanValue(),
				selectDetail,
				conta,
				mesRef,
				sequencia,
				this.filtroConsulta.getFieldCentroCusto().getSelectCCusto(),				
				HowMGWTUtilities.replace(HowMGWTUtilities.replace( HowMGWTUtilities.getString(filtroConsulta.getPropertyEmpresas().getHowmFormValue()),"[",""),"]",""),
				HowMGWTUtilities.getBoolean(filtroConsulta.getPropertyCCustoSubstring3().getHowmFormValue())
		);

		String sqlFinal = "";

		if( selectDetail ){
			return sql;
		}
		else{
			if( centroCusto ){
				sqlFinal += "select\n";
				sqlFinal += "	sequencia,\n";	
				sqlFinal += "	upper(centroCusto) as mesRef,\n";
				sqlFinal += "	tipoConta,\n";
				sqlFinal += "	conta,\n";
				sqlFinal += "	sum(valor)\n";
				sqlFinal += "from (\n";
				sqlFinal += sql;
				sqlFinal += ") as workPlanoContas\n";	
				sqlFinal += "where sequencia in ( "+optionView.getSequencias()+")\n";
				if( ! HowMGWTUtilities.isEmpty(this.filtroConsulta.getFieldPlanoContas().getSelectPlanoContas()) ){
					sqlFinal += " and "+HowMGWTUtilities.replace( this.getPlanoContasCriteria(this.filtroConsulta.getFieldPlanoContas().getSelectPlanoContas()) , "-", "")+"\n";
				}
				sqlFinal += "group by \n";
				sqlFinal += "	sequencia,\n";	
				sqlFinal += "	upper(centroCusto),\n";
				sqlFinal += "	tipoConta,\n";
				sqlFinal += "	conta\n";
				sqlFinal += "order by \n";
				sqlFinal += "	sequencia,\n";	
				sqlFinal += "	upper(centroCusto),\n";
				sqlFinal += "	tipoConta,\n";
				sqlFinal += "	conta\n";
			}
			else{
				sqlFinal += "select\n";
				sqlFinal += "	sequencia,\n";	
				sqlFinal += "	mesRef,\n";
				sqlFinal += "	tipoConta,\n";
				sqlFinal += "	conta,\n";
				sqlFinal += "	sum(valor)\n";
				sqlFinal += "from (\n";
				sqlFinal += sql;
				sqlFinal += ") as workPlanoContas\n";
				sqlFinal += "where sequencia in ( "+optionView.getSequencias()+")\n";
	
				if( ! HowMGWTUtilities.isEmpty(this.filtroConsulta.getFieldPlanoContas().getSelectPlanoContas()) ){
					sqlFinal += " and "+HowMGWTUtilities.replace( this.getPlanoContasCriteria(this.filtroConsulta.getFieldPlanoContas().getSelectPlanoContas()) , "-", "")+"\n";
				}
	
				sqlFinal += "group by \n";
				sqlFinal += "	sequencia,\n";	
				sqlFinal += "	mesRef,\n";
				sqlFinal += "	tipoConta,\n";
				sqlFinal += "	conta\n";
				sqlFinal += "order by \n";
				sqlFinal += "	sequencia,\n";	
				sqlFinal += "	mesRef,\n";
				sqlFinal += "	tipoConta,\n";
				sqlFinal += "	conta\n";
			}		
		}

		System.out.println("================================================================================================");
		System.out.println("=========================== SQL - Consulta Resultado Financeiro ================================");
		System.out.println("================================================================================================");
		System.out.println(sqlFinal);
		
		return sqlFinal;		
	}
	
	
	/**
	 * <HR>
	 * Monta a matriz para apresentar o resultado dos dados.
	 * @param resultMovimentacao Objeto com os dados do resultado da consulta que 
	 * será visualizada na grid.
	 */
	public void showResultMovimentacao(HowMGWTEntity resultMovimentacao){
		
	    TreeMap<String, Integer> map = new TreeMap<String, Integer>();
	    
		String key;
		// Cria o mapa registros que irao formar a matriz.
		for ( String[] row : resultMovimentacao.getData() ){
			

			if( this.isCallCentroCusto() ){
				// System.out.println("Centro de Custo "+filtroConsulta.getDescCentroCusto(row[1]));
				
				row[1] = filtroConsulta.getDescCentroCusto(row[1]);
			}

			if( this.callCentroCusto ){
				key = HowMGWTUtilities.getRPad(row[0],"0",2) + "!"+row[1];
			}
			else{
				key = HowMGWTUtilities.getRPad(row[0],"0",2) + "!"+HowMGWTUtilities.getRPad(row[1],"0",7);				
			}

			if ( map.get(key) == null ){
				map.put(key, new Integer(0));
			}

			EPlanoContas plano = planoContas.get(row[3]);
			if ( plano != null){
				String codConta;
				String tipoConta=null;
				String tipoContaPai=null;
				codConta = row[3];
				EPlanoContas plano1 = planoContas.get(codConta);
				if ( plano1 != null){
					tipoConta 	= row[2];
					tipoContaPai= getTipoContaRoot(0, planoContas.get(plano1.getParent()) );
					if(!tipoConta.equalsIgnoreCase(tipoContaPai)){ 
							if(row[4].indexOf("-")==-1)
								row[4]="-"+row[4];
							else{
								row[4]=row[4].replace("-", "");
							}
					}
				}
				plano.linkResult(row, "dim_"+key);

			}else{
				if ( EPlanoContas.TIPO_CONTA_RECEITA.equalsIgnoreCase(row[2]) ){
					this.contaNullReceita.linkResult(row, "dim_"+key );
					row[3] = this.contaNullReceita.getKey(); 
					// System.out.println("Plano não encontrado : "+row[3]+" : " + plano+ " incluso como receita.");
				}
				else if ( EPlanoContas.TIPO_CONTA_DESPESA.equalsIgnoreCase(row[2]) ){
					this.contaNullReceita.linkResult(row, "dim_"+key );
					row[3] = this.contaNullDespesa.getKey(); 
					// System.out.println("Plano não encontrado : "+row[3]+" : " + plano+ " incluso como despesa.");
				}		
			}
		}
		
		Object[] entry;
		int i;

		
		// Cria as colunas
		ArrayList<TreeGridField> campos = new ArrayList<TreeGridField>();
		TreeGridField campo = new TreeGridField("DescricaoConta" , Tradutor.i18n.formConta(), 320);
		
		campo.setAttribute("grupoTitle", "" );
		campo.setAttribute("grupo", "DS");
		
		campo.setFrozen(true);
		campo.setCanHide(false);
		campo.setCanReorder(false);	
		campo.setCanFreeze(false);
		campo.setCanSort(false);
		campo.setCanSortClientOnly(false);
		campos.add(campo);
		
		TreeGridField fieldDEscricao = campo;
		
		
		entry = map.keySet().toArray();
		int column = campos.size();
		
		ArrayList<String> grupo01 = new ArrayList<String>();
		ArrayList<String> grupo02 = new ArrayList<String>();
		ArrayList<String> grupo03 = new ArrayList<String>();
		ArrayList<String> grupo04 = new ArrayList<String>();
		
		String fieldName;
		
		
		// ----------------------------------------------------------
		// Cria os campos para apresentação das dimensões.
		// ----------------------------------------------------------
		for ( Object obj : entry ){
			String[] controle = obj.toString().split("!");
			String grupo = controle[0];
			String mes   = controle[1];

			fieldName = "dim_"+obj.toString();

			String nomeMesAno = "";
			
			// -------------------------------------------------------------------------
			// Imprime rotulos
			// -------------------------------------------------------------------------
			if( this.callCentroCusto ){
				nomeMesAno = mes; // Centro de Custo.
			}
			else{
				nomeMesAno = HowMGWTUtilities.getMeses().get(mes.substring(0,2));
				if( nomeMesAno == null || HowMGWTUtilities.getInteger(grupo) == HowMGWTUtilities.getInteger(EPlanoContas.grupoAtrasos)){
					nomeMesAno = "Em Atraso"; // Impresa o texto em atraso.
//					Date dataRef = this.filtroConsulta.getFieldMesReferencia().getField().getValueAsDate();
					mes = "12:2099";
				}
				else{
					nomeMesAno += " / "+mes.substring(3); // Imprime o rotulo para quando é pago ou a vencer.
				}
			}
			
			if( isCallCentroCusto() ){
				campo = new TreeGridField( fieldName , nomeMesAno , 170);
			}
			else{
				campo = new TreeGridField( fieldName , nomeMesAno , 100);	
			}
 			campo.setAttribute("mesRef", ""+mes);
 			campo.setAttribute("sequencia", ""+HowMGWTUtilities.getInteger(grupo));
 			
 			
			if ( HowMGWTUtilities.strZero(HowMGWTUtilities.getInteger(EPlanoContas.grupoAtrasos), 2).equals(grupo) ){
				grupo02.add(fieldName);
				campo.setAttribute("grupoTitle", Tradutor.i18n.formGrupo02() );
			}
			else if ( HowMGWTUtilities.strZero(HowMGWTUtilities.getInteger(EPlanoContas.grupoDataAtual), 2).equals(grupo) ){
				grupo01.add(fieldName);
				mesAtual = fieldName;
				campo.setAttribute("grupoTitle", Tradutor.i18n.formGrupo01() );	
			}
			else if ( HowMGWTUtilities.strZero(HowMGWTUtilities.getInteger(EPlanoContas.grupoPagos), 2).equals(grupo) ){
				grupo03.add(fieldName);
				campo.setAttribute("grupoTitle", Tradutor.i18n.formGrupo03() );
			}
			else if ( HowMGWTUtilities.strZero(HowMGWTUtilities.getInteger(EPlanoContas.grupoPervisao), 2).equals(grupo) ){
				grupo04.add(fieldName);
				campo.setAttribute("grupoTitle", Tradutor.i18n.formTitulosEmitidos() );	
			}

			campo.setAttribute("grupo", grupo);
			campo.setCanReorder(false);	
			campo.setCanFreeze(false);
			campo.setCellFormatter(formatterDouble);
			campo.setAlign(Alignment.RIGHT);
			campo.setSummaryFunction(SummaryFunctionType.SUM);
			campo.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
			campo.setShowGridSummary(true);
			campo.setShowGroupSummary(true);
			campo.setCanSort(false);
			campo.setCanSortClientOnly(false);
			campo.setCanHide(false);
			
			if( isCallCentroCusto() ){
				// campo.setWrap(true);
				if( HowMGWTUtilities.getBoolean( getFiltroConsulta().getPropertyCCustoSubstring3().getHowmFormValue())){
					campo.setWidth(90);
				}
				else{
					campo.setAutoFitWidth(true);					
					campo.setAutoFitWidthApproach(AutoFitWidthApproach.TITLE);
				}
			}
			
			
			campos.add(campo);
		}
		// Cria o campo para apresentação do total geral.
		campo = new TreeGridField( "totalGeral" , Tradutor.i18n.formTotalGeral() , 100);
		campo.setAttribute("grupoTitle", "" );	
		campo.setAttribute("grupo", "TG");
		campo.setCanReorder(false);	
		campo.setCanFreeze(false);
		campo.setCellFormatter(formatterDouble);
		campo.setAlign(Alignment.RIGHT);
		campo.setSummaryFunction(SummaryFunctionType.SUM);
		campo.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
		campo.setShowGridSummary(true);
		campo.setShowGroupSummary(true);
		campo.setCanSort(false);
		campo.setCanSortClientOnly(false);
		campos.add(campo);	
 
		// ---------------------------------------------------------------------
		// Monta os grupos de cabeçalho.
		// ---------------------------------------------------------------------
		ArrayList<HeaderSpan> headerSpan = new ArrayList<HeaderSpan>();
		
		computeHeaderSpan(headerSpan, grupo01, "01");
		computeHeaderSpan(headerSpan, grupo02, "02");
		computeHeaderSpan(headerSpan, grupo03, "03");
		computeHeaderSpan(headerSpan, grupo04, "04");	
		
		// Converte para um array
		spans = new HeaderSpan[headerSpan.size()];
		for ( i = 0; i < headerSpan.size(); i ++ )
			spans[i] = headerSpan.get(i);
				
		// Converte a lista de campos para um array.
		ListGridField[] aCampos = new ListGridField[campos.size()];
		for ( i = 0 ; i < campos.size(); i ++ )
			aCampos[i] = campos.get(i);

		// Limpa os totalizadores
    	contaDespesas.clearLinks();
    	contaReceitas.clearLinks();
    	contaResultado.clearLinks();		
	    // Inicializa as variáveis totalizadores dos agrupadores principais.
	    for ( ListGridField field : aCampos){
	    	if ( field.getName().startsWith("dim_")){
		    	contaDespesas.incluirLinkTotalResult(field.getName());
		    	contaReceitas.incluirLinkTotalResult(field.getName());
		    	contaResultado.incluirLinkTotalResult(field.getName());
	    	}
	    }
		
		
		
		// -------------------------------------------------------------------------------
		


		treeGrid = new TreeGrid(){
			   @Override
			    protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) { 
 
				    ListGridField field = getField(colNum);
				    EPlanoContas conta = (EPlanoContas)record;
				   
				    String grupo = getField(colNum).getAttribute("grupo");
				    
				    String style 		= "";
				    String color 		= "";
				    String font  		= "";
				    String background 	= "";
			        if ( 
			        	conta == contaResultado 
			        	&& 
			        	HowMGWTUtilities.getDouble(record.getAttribute(getFieldName(colNum))) < 0 
			        )
			        	color = "color:red;"; 
			        else if ( // Problema no plano de contas
			        		getFieldName(colNum) != null && 
			        		getFieldName(colNum).equals("DescricaoConta") && contasComProblema.get(conta.getKey()) != null
			        )
			        	color = "color:#ffffff; background-color:red; ";
				    else if ( // Verde
			    		getFieldName(colNum).equals(mesAtual)
			    	)   
			        	color =  "color:green;";  
			        else if ( // vermelho
			    		grupo != null && HowMGWTUtilities.strZero(HowMGWTUtilities.getInteger(EPlanoContas.grupoAtrasos), 2).equals(grupo)
			        )   
			        	color =  "color:red;";  
			        else if ( // black
			        		getFieldName(colNum).equals("totalGeral") 
			        		||
			        		getFieldName(colNum).equals("DescricaoConta")
			        )   
			            color = "color:black;"; 
			    	
			        else{ 			        	
			        	if ( grupo != null ){
			        		if ( "03".equals(grupo) )
			        			color = "color:green;";
			        		else if ( "04".equals(grupo) )
			        			color = "color:blue;";
			        	}
			        }
			        
			        // Marca o fundo com uma cor diferenciada para linhas totalizadoras.
			    	if ( ! conta.isFolha() ){
			    		font 		= "font-weight:bold;";
			        	background	= "background-color:#E8E8E8;";
			    	}

			    	String key = "";
			    	key = conta.getKey()+"-"+field.getAttribute("mesRef")+"-"+field.getAttribute("sequencia");
	        		if ( contasComProblema.get(key) != null )
			        	color = "color:#ffffff; background-color:red; ";
			    	
			        style += color + font + background;
			        return style;
			    }  
			   
			   
			   			
		};
       
		treeGrid.setAnimateFolders(false);
		treeGrid.setAnimateRemoveRecord(false);

		treeGrid.setWidth100();
		treeGrid.setHeight100();
		treeGrid.setHeaderHeight(45);		
		treeGrid.setCanAutoFitFields(false);
		treeGrid.setShowAllRecords(false); 				// Mostra todos os registros
		treeGrid.setShowAllColumns(false);				// Mostra todas as colunas.
		treeGrid.setDataPageSize(1000);

		// Seta os campos da grid.
		treeGrid.setFields(aCampos);
		treeGrid.setHeaderSpans( spans ) ;

		treeGrid.setFolderIcon("actions/user_group.png");
		treeGrid.setNodeIcon("actions/financialAccount.png");
		treeGrid.setShowOpenIcons(false);
		treeGrid.setShowDropIcons(false);

		this.addMember(treeGrid);

		treeDataRecords = new Tree();

	    treeDataRecords.setModelType(TreeModelType.PARENT);  	// Define a forma que os dados serão apresentados.
	    treeDataRecords.setIdField("Conta");  					// Define o campo chave para montagem da árvore.
	    treeDataRecords.setParentIdField("ContaPai");  		// Define o campo pai para formação da hierarquia da árvore.
	    treeDataRecords.setNameProperty("DescricaoConta");		// Define o campo que será apresetnado como texto do campo da árvore
	    treeDataRecords.setShowRoot(false);  					// não apresenta o nó principal ou o primeiro nó da árvore.

	    // Crias as variáveis totalizadoras para os campos.
	    for ( EPlanoContas conta : contasPai ){
	    	for ( ListGridField field : aCampos )
	    		if ( field.getName().startsWith("dim_"))
	    			conta.incluirLinkTotalResult(field.getName());
	    }
	    
		// ---------------------------------------------------------------------------------------------------
		// Calcula o total das contas.
		// ---------------------------------------------------------------------------------------------------
		for ( EPlanoContas conta : oCurrentPlanoContas){
			// Verifica se a conta é folha.
			if ( conta.isFolha()   ){
				if ( conta == contaReceitas ) 
					continue;
				if ( conta == contaDespesas )
					continue;
				
				if ( conta == contaResultado )
					continue;
				
				conta.linkTotal();			
				summaryParentConta(0 , conta, planoContas.get(conta.getParent()));
			}
		}

		// ---------------------------------------------------------------------------------------------------
		// Calcula o total das contas.
		// ---------------------------------------------------------------------------------------------------
		for ( EPlanoContas conta : contasPai)
			conta.linkTotal();

		// Totaliza as receitas e 
		contaReceitas.linkTotal();
		contaDespesas.linkTotal();
		contaResultado.refreshTotal(contaReceitas, contaDespesas);
		
		// Exclui as contas não utilizadas no resultado
		aContasValidas.clear();
		for ( EPlanoContas conta : oCurrentPlanoContas){
			if ( conta.getTotalGeral() != 0.0 ){
				aContasValidas.add(conta);
				// Remove as contas filhas caso haja alguma setada.
				conta.setChildren(new  TreeNode[0]);
			}
			else if ( showAllPlanoContas )
				aContasValidas.add(conta);
			
		}
		aContasValidas.add(contaResultado);

		EPlanoContas[] contas = new EPlanoContas[aContasValidas.size()];
		i = 0;
		for ( EPlanoContas conta : aContasValidas){	
			contas[i] = conta;
			i ++;
		}


		
		
		
		
		
		
		
		// -------------------------------------------------------------------------------------
		// Verifica se há alguma conta com problema de hierarquia.
		// -------------------------------------------------------------------------------------
		String codConta;
		String tipoConta;
		String tipoContaPai;
		for ( String[] row : resultMovimentacao.getData() ){
			codConta = row[3];
			EPlanoContas plano = planoContas.get(codConta);
			if ( plano != null){

				tipoConta 	= row[2];
				tipoContaPai= getTipoContaRoot(0, planoContas.get(plano.getParent()) );
				if ( tipoContaPai!= null && !tipoConta.equalsIgnoreCase(tipoContaPai)){
					System.out.println("Conta : "+codConta+" - "+tipoConta+" : "+tipoContaPai);
					contasComProblema.put(codConta, codConta);
				}			
			}
		}		
		
		
		
		
		
		
		
		
		
		
		
		
		
		htmlPanel.getElement().setInnerHTML("<center><font>Aguarde !!! Formatando Informacoes do Balancete...</font></center>");		
		treeDataRecords.setData(contas);
		treeGrid.setData(treeDataRecords);
		treeGrid.getData().openAll();
		
		Timer timer = new Timer() {	
			@Override
			public void run() {
				HowMGWTWindowWait.hideWait();
			}
		};
		timer.schedule(60);
		
 
		treeGrid.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {				 
				if ( event.getKeyName() != null ){
					if ( event.isCtrlKeyDown() && "E".equals(event.getKeyName()) ){
						exportarMovimentacao();
						event.cancel();
					}
					if ( event.isCtrlKeyDown() && "J".equals(event.getKeyName())){
						HowMGWTWindowDocument.showDocument(HOWMGWTDataSourceQuery.LAST_SQL);
						event.cancel();
					}
				}
			}
		});
				
		
//		if( this.callCentroCusto){
//			
//		}
//		else{
//			treeGrid.addCellContextClickHandler(new CellContextClickHandler() {
//				
//				@Override
//				public void onCellContextClick(CellContextClickEvent event) {
//					
//					if ( event.getRecord() != null ){
//						currentContextRecord = (EPlanoContas)event.getRecord();
//						currentContextColumn = event.getColNum();
//						currentContextRow	 = event.getRowNum();					
//						if ( currentContextRecord.isFolha() ){
//							event.cancel();						
//							contextMenu.showContextMenu();
//						}
//					}
//				}
//			});
//		}
    }
 
	
	/**
	 * Retorna um HeaderSpan para um conjunto de campos.
	 * @param fields
	 * @param grupo
	 * @return
	 */
	public void computeHeaderSpan(ArrayList headerList , ArrayList<String> fields, String grupo){
		if ( fields.size() == 0 )
			return;
		
		String[] aFields = new String[fields.size()];
		int i = 0;
		for ( String field : fields){
			aFields[i] = field;
			i ++;
		}
		headerList.add(new HeaderSpan(grupos.get(grupo), aFields));
	}
	
	/**
	 * Marca a conta root pra Receita ou Despesa conforme o nó filho
	 * @param conta pai variável
	 */
	public void markContaNivelZero(EPlanoContas contaFolha ,EPlanoContas contaPaiVariavel ){	
		if ( contaPaiVariavel != null ){
						
			if ( contaPaiVariavel.isAgrupadorPrincipal() )
				return;
			
			if( contaPaiVariavel.isVisited() )
				return;
			
 
			contaPaiVariavel.setVisited(true);
			EPlanoContas contaPai = planoContas.get(contaPaiVariavel.getParent());
			if ( contaPai  != null ){
					markContaNivelZero(contaFolha, contaPai);
			}
			else{ // Encontrou a conta principal, marca como root.
				if ( !contaPaiVariavel.isRootNode() ){
					System.out.println("Conta Pai parent: "+contaPaiVariavel.getParent()+"-"+"Conta Pai Key: "+contaPaiVariavel.getKey()+"-"+contaPaiVariavel.getTipoConta()+ " conta folha receita : "+contaFolha.isReceita());
					contaPaiVariavel.setRootNode(true);
					contaPaiVariavel.setReceita(contaFolha.isReceita());
				}
			}
		}
	}	
	
	/**
	 * Atualiza os totais das contas pai de forma recursiva.
	 * @param contaFilhaOriginal
	 */
	public void summaryParentConta(int nivel , EPlanoContas contaFolha, EPlanoContas contaPaiVariavel ){
		if ( contaPaiVariavel != null ){
			
			if ( contaPaiVariavel.getKey().equals(contaPaiVariavel.getParent()) ){ 
				System.out.println("Plano de contas com problema de recursividade : Conta["+contaPaiVariavel.getKey()+"]-Conta Pai["+contaPaiVariavel.getParent()+"]");
				return;
			}
			contaPaiVariavel.summary(contaFolha);
			if ( contaPaiVariavel.getParent() != null ){
				EPlanoContas contaPai = planoContas.get(contaPaiVariavel.getParent()) ;
				if ( nivel > 200 ){
					if( contaPai != null){
						System.out.println("contaPai : ["+contaPai.getKey()+"]-["+contaPai.getParent()+"]");
					}
					System.out.println("contaFilha : ["+contaFolha.getKey()+"]-["+contaFolha.getParent()+"]");
					
					return;
				}
				this.summaryParentConta(nivel+1, contaFolha,  contaPai); 
				
			}
		}
	}

	/**
	 * Atualiza os totais das contas pai de forma recursiva.
	 * @param contaFilhaOriginal
	 */
	public int getNivelConta(int nivel , EPlanoContas contaFolha, EPlanoContas contaPaiVariavel ){
		if ( contaPaiVariavel != null ){
			if ( contaPaiVariavel.getKey().equals(contaPaiVariavel.getParent()) ){ 
				return nivel;
			}			 
			if ( contaPaiVariavel.getParent() != null ){
				EPlanoContas contaPai = planoContas.get(contaPaiVariavel.getParent()) ;
				if ( nivel > 200 )
					return nivel;
				return this.getNivelConta(nivel+1, contaFolha,  contaPai); 				
			}
		}
		return nivel;
	}	

	
	
	
	/**
	 * Atualiza os totais das contas pai de forma recursiva.
	 * @param contaFilhaOriginal
	 */
	public String getTipoContaRoot(int nivel , EPlanoContas contaPaiVariavel ){
		if ( contaPaiVariavel != null ){
			if ( contaPaiVariavel.getKey().equals(contaPaiVariavel.getParent()) ){ 
				return contaPaiVariavel.getTipoConta() ;
			}			 
			if ( contaPaiVariavel.getParent() != null ){
				EPlanoContas contaPai = planoContas.get(contaPaiVariavel.getParent()) ;
				if ( contaPai == null )
					return contaPaiVariavel.getTipoConta() ;
				if ( nivel > 200 )
					return null;
				return this.getTipoContaRoot(nivel+1,contaPai); 				
			}
		}
		return null;
	}		
	
	
	
	
	/**
	 * @return the filtroConsulta
	 */
	public FiltroConsulta getFiltroConsulta() {
		return filtroConsulta;
	}


	
	
	/**
	 * @param filtroConsulta the filtroConsulta to set
	 */
	public void setFiltroConsulta(FiltroConsulta filtroConsulta) {
		this.filtroConsulta = filtroConsulta;
		
		this.filtroConsulta.getActionExportarExcel().addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				HowMGWTWindowWait.showWait("Aguarde gerando planilha excel no servidor");
				Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {					
					@Override
					public void execute() {
						exportarParaArquivo("exportarExcel");
					}
				});				
			}
		});
		
		this.filtroConsulta.getActionExportarPDF().addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showPrintDialog();
			}
		});


		this.filtroConsulta.getActionImprimir().addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				print();
			}
		});
	}
 	
	
	/**
	 * 18/08/2011 - Cobrar 14:00 horas.
	 * Prepara o resultado apresentado na tela para exportar para o excel.
	 */
	public void exportarMovimentacao(){
		ListGridField[] fields = treeGrid.getFields();

		String exp = "" ;

		TreeMap<String, String> imprime = new TreeMap<String, String>();
		String grupoDesc = "";
		for ( ListGridField field : fields ){			
			if( "TG".equals(field.getAttribute("grupo")) ){
				exp += "Total ;";				
				continue;
			}
			grupoDesc = field.getAttribute("grupoTitle");
			if ( HowMGWTUtilities.isEmpty(grupoDesc) )
				exp += " ;";
			else{
				
				if ( imprime.get(grupoDesc) == null ){
					imprime.put(grupoDesc, grupoDesc);
					exp += grupoDesc+";";
				}
				else
					exp += " ;";
			}
		}
		exp += "\n";
		
		for ( ListGridField field : fields ){
			if( "TG".equals(field.getAttribute("grupo")) ){
				exp += "Geral ;";
				continue;
			}
			exp += field.getTitle()+";";
		}
		treeGrid.getTreeFieldTitle();
		exp += "\n";
		Object obj;
		int level;

		// Recupera somente os nós que estão expandidos.
		TreeNode[]  nodes = treeGrid.getData().getOpenList(treeGrid.getData().getRoot());
		for (TreeNode node : nodes ){
			EPlanoContas conta = (EPlanoContas)node;
			// Imprime os campos na linha
			for ( ListGridField field : fields ){
				obj = conta.getAttribute(field.getName());
				// Inclui o nivel na frente da descrição
				if( "DS".equals(field.getAttribute("grupo")) ){
					level = getNivelConta(0 , conta, planoContas.get(conta.getParent()));
					exp += " "+HowMGWTUtilities.getSpaces(level*4);
					exp += obj + ";";
					continue;
				}
				if (HowMGWTUtilities.isEmpty(obj))
					exp += " ;";
				else 
					// Formata os valores 
					exp += HowMGWTUtilities.replace(NumberFormat.getFormat("###,###,###,###,###,###,##0.00").format(HowMGWTUtilities.getDouble(obj.toString())),".","")+";";
			}	
			exp += "\n";
		}
		HowMGWTWindowDocument.showDocument(exp);
	}


	
	/**
	 * 18/08/2011 - Cobrar 16:00 horas.
	 * Prepara o resultado apresentado na tela para exportar para o excel.
	 */
	public void exportarParaArquivo(String metodo){
		
		ListGridField[] fields = treeGrid.getFields();

		String exp = "" ;

		ArrayList<ArrayList> rows = new ArrayList<ArrayList>();
		
		ArrayList<eExcelCell> row;
		
		TreeMap<String, String> imprime = new TreeMap<String, String>();
		String grupoDesc = "";
		
		row = new ArrayList<eExcelCell>();
		
		eExcelCell cell;
		
		for ( ListGridField field : fields ){	
			cell = new eExcelCell();
			if( "TG".equals(field.getAttribute("grupo")) ){
				cell.setValue("Total");				
				row.add(cell);
				continue;
			}
			grupoDesc = field.getAttribute("grupoTitle");
			if ( HowMGWTUtilities.isEmpty(grupoDesc) ){
				cell.setValue("");
				row.add(cell);
			}
			else{
				
				if ( imprime.get(grupoDesc) == null ){
					imprime.put(grupoDesc, grupoDesc);
					cell.setValue(grupoDesc);					
					row.add(cell);
				}
				else{
					cell.setValue("");
					row.add(cell);
				}
			}
		}
		rows.add(row);		
		
		row = new ArrayList<eExcelCell>();
		for ( ListGridField field : fields ){
			cell = new eExcelCell();
			
			if( "TG".equals(field.getAttribute("grupo")) ){
				cell.setValue("Geral");
				row.add(cell);
				continue;
			}
			if( "&nbsp;".equals(field.getTitle())){
				cell.setValue("");
			}
			else{
				cell.setValue(field.getTitle());
			}
			row.add(cell);
		}
		treeGrid.getTreeFieldTitle();
		exp += "\n";
		Object obj;
		int level = 0;
		rows.add(row);

		// Recupera somente os nós que estão expandidos.
		TreeNode[]  nodes = treeGrid.getData().getOpenList(treeGrid.getData().getRoot());
		for (TreeNode node : nodes ){
			
			row = new ArrayList<eExcelCell>();
			
			EPlanoContas conta = (EPlanoContas)node;
			// Imprime os campos na linha
			for ( ListGridField field : fields ){
				cell = new eExcelCell();
				
				obj = conta.getAttribute(field.getName());
				// Inclui o nivel na frente da descrição
				if( "DS".equals(field.getAttribute("grupo")) ){
					level = getNivelConta(0 , conta, planoContas.get(conta.getParent()));
					cell.setValue(" "+HowMGWTUtilities.getSpaces(level*4)+obj);
					row.add(cell);
					continue;
				} 
				if (HowMGWTUtilities.isEmpty(obj)){
					cell.setValue(" ");
					row.add(cell);
				}
				else{
					// Formata os valores 
					cell.setValue(HowMGWTUtilities.replace(NumberFormat.getFormat("###,###,###,###,###,###,##0.00").format(HowMGWTUtilities.getDouble(obj.toString())),".",""));
					row.add(cell);
				}
			}	
			rows.add(row);

		}
 
		eExcelWorksheet worksheet = new eExcelWorksheet();
		eExcelSheet  pasta  	  = new eExcelSheet();
		pasta.setName("Resultado financeiro");
		
		eExcelSheet[] pastas 	  = new eExcelSheet[1];
		pastas[0] 				  = pasta;

		eExcelHeader[] cabecalho;
		eExcelHeader header;
		eExcelCollectionHeader[] cabecalhos = new eExcelCollectionHeader[2];
		eExcelCollectionHeader collectionHeader;
		pasta.setEntityHeaders(cabecalhos);		
		
		eExcelRow linha;
		eExcelRow[] linhas 		  = new eExcelRow[rows.size()-2];
		
		pasta.setEntityRows(linhas);
		
		worksheet.setEntitySheets(pastas);
		
 		for ( int i = 0; i < rows.size(); i ++){
			row = rows.get(i);
			//  monta o cabeçalho da planilha com as duas primeiras
			// linhas configuradas como cabecalho.
			if( i < 2 ){
				collectionHeader = new eExcelCollectionHeader();					
				cabecalho = new eExcelHeader[row.size()];				
				for( int j = 0; j < row.size() ; j ++ ){					
					cell = row.get(j);
					header = new eExcelHeader();					
					
					// if( this.callCentroCusto ){
						if( j == 0){							
							header.setType("C");
						}
						else{
							header.setType("N");
						}
						
//						ListGridField field = fields[j];						
//						header.setWidth(field.getWidth());
						
//					}
//					else{
//						if( j == 0){
//							header.setType("C");
//							// header.setWidth("45");
//						}
//						else{
//							header.setType("N");
//							// header.setWidth("13");							
//						}
						
						ListGridField field = fields[j];
						if( metodo.equals( "exportarPDF")){
							header.setWidth(field.getWidth());													
						}
						else{
							if( j == 0){
								header.setWidth("45");
							}
							else{
								header.setWidth("13");
							}
							
						}
					
						
						String nrSequencia = field.getAttribute("sequencia");
						String grupo       = field.getAttribute("grupo");
						header.setForegroundExcel("");
						header.setForegroundPDF("");
						if( HowMGWTUtilities.isEmpty(nrSequencia)){
							nrSequencia = grupo;				//  DS - Descrição / TG - Total Geral  
						}							
						header.setControle(nrSequencia);		// 	1 - Data de Corte / 3 - Pago / 4 - Previsão / 
//					}
											
					header.setColumnName(cell.getValue());
					header.setCell(""+j);
					cabecalho[j] = header;
				}
				collectionHeader.setEntityHeader(cabecalho);
				cabecalhos[i] 	 = collectionHeader;
			}
			// Monta os dados da planilha
			else{
				linha = new eExcelRow();
				eExcelCell[] values = new eExcelCell[row.size()];
				for( int j = 0; j< row.size() ; j ++ ){
					cell = row.get(j);

					if( j == 0 ){
						values[j] = cell;
						
					}
					else{
						values[j] = cell;
						cell.setValue(""+HowMGWTUtilities.getDouble(cell.getValue()));
					}
					values[j] = cell;
					
				}
				linha.setCells(values); 
				linhas[i-2] = linha;
			}
		}

		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if(HowMGWTControl.isRefreshFormShowMessage(formBean, false))
					return;

				FormBean bean = (FormBean)formBean;
				HowMGWTUtilities.downloadFile(bean.getPath(), bean.getFileName());
				
				if ( printDialog != null ){
					printDialog.hide();
				}
			}
		};

		FormBean formBean = new FormBean();		
		formBean.setWorksheet(worksheet);
		
		if( printDialog != null ){
			formBean.setPapel(printDialog.getPropertyPageSize().getHowmFormValueToString());		
			formBean.setOrientacao(printDialog.getPropertyOrientacao().getHowmFormValueToString());		
		}		
		else{
			formBean.setPapel(HowMGWTPDF.PAPEL_AU);		
			formBean.setOrientacao(HowMGWTPDF.ORIENTACAO_PAIGAGEM);
		}
		formBean.setMargemLeft(HowMGWTPDF.margemLeft);
		formBean.setMargemTop(HowMGWTPDF.margemTop);
		formBean.setMargemRight(HowMGWTPDF.margemRight);
		formBean.setMargemBottom(HowMGWTPDF.margemBottom);
		
		if( this.callCentroCusto ){			
			formBean.setTitle(Tradutor.i18n.formTituloFNW0224() );
			formBean.setSubTitle("Centro de Custo");
			formBean.setModulo("FNW0224");
		}
		else{			
			formBean.setTitle(Tradutor.i18n.formTituloFNW0223());
			formBean.setSubTitle("Mes");
			formBean.setModulo("FNW0223");
		}
		
		struts.request("fnw0217.do?method="+metodo, "SGW0217Form", formBean.toSendBody(""));
	}
	
	
	
	
	
	
	
	/**
	 * Apresenta detalhadamente como o resultado da celula foir sumarizado.
	 * @param record
	 */
	public void showDetail(final int option){
		if ( painelDetalhes == null )
			painelDetalhes	= new PainelDetalhes();
	
		SC.confirm("&Aacute;rea Restrita ...", Tradutor.i18n.msgRestricaoAcesso() , new BooleanCallback() {					
			@Override
			public void execute(Boolean value) {
				showDetail(option, true);
			}
		});		
		
	}
	
	public void showDetail( int option, boolean show){
		painelDetalhes.showDetalhes(option ,this.currentContextRecord, this.currentContextColumn, this.currentContextRow, this, planoContas , callCentroCusto );		
	}

	/**
	 * @return the treeGrid
	 */
	public TreeGrid getTreeGrid() {
		return treeGrid;
	}
	
	
	/**
	 * Detecta e armazena as contas com problema.
	 */
	private TreeMap<String,String> contasComProblema = new TreeMap<String,String>();
	public void validaPlanoContas(final HowMGWTEntity resultBalancete){				
		
		contasComProblema.clear();
		String sqlAux = "";
		sqlAux = "select sequencia, mesRef ,conta, count(1)\n";
		sqlAux += "from (\n";
		sqlAux += getSelect(false,null, null,null,callCentroCusto);
		sqlAux += ") as resultadoValidacao\n";
		sqlAux += "group by sequencia, mesRef ,conta\n";
		sqlAux += "having count(1) > 1\n";
		// Seleciona as contas no banco de dados com problema de plano.
		HOWMGWTDataSourceQuery.executeQuery(sqlAux, new HowMGWTCallImpl() {			
			@Override
			public void onSuccess(HowMGWTEntity result) {
				if ( result.getData() != null ){
					for ( String[] row : result.getData() ){
						if ( contasComProblema.get(row[2]) == null )
							contasComProblema.put(row[2], row[2]);
						contasComProblema.put(row[2]+"-"+row[1]+"-"+row[0], row[2]);
					}
				}				
				Timer timer = new Timer() {
					
					@Override
					public void run() {
						showResultMovimentacao(resultBalancete);	
						Timer timer = new Timer() {
							
							@Override
							public void run() {
								htmlPanel.getElement().setInnerHTML("<center><font>"+Tradutor.i18n.msgAnalisandoPlanoContas()+"</font></center>");								
							}
						};
						timer.schedule(60);								
					}
				};
				timer.schedule(60);
			}
		});
	}
	
	public void print(){
		this.showPrintPreview(this.treeGrid);
	}
	
	
	
	
	public String getPlanoContasCriteria(String planoContas){
		if ( HowMGWTUtilities.isEmpty(planoContas) ){
			return planoContas;
		}
		
		String modelo = planoContas;
		
		planoContas = 
			"("
				+
				HowMGWTUtilities.replace(modelo, "${FIELD}", " conta  " )
				+
			")";
		return planoContas;
	}

	public boolean isCallCentroCusto() {
		return callCentroCusto;
	}

	public void setCallCentroCusto(boolean callCentroCusto) {
		this.callCentroCusto = callCentroCusto;
	}
	
	
	/**
	 * Cria o diálogo para exportar arquivo formato PDF.
	 */
	public void showPrintDialog(){
		if( printDialog == null ){
			printDialog = new HowMGWTPrintDialog(){
				
				@Override
				protected void onHowMInit() {				
					super.onHowMInit();				
					printDialog.getPropertyOrientacao().setHowmFormValue(HowMGWTPDF.ORIENTACAO_PAIGAGEM);
				}
				
				public void onPrint(){
					HowMGWTWindowWait.showWait("Aguarde gerando PDF no servidor");
					Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {					
						@Override
						public void execute() {
							exportarParaArquivo("exportarPDF");
						}
					});
				}
			};
		}
		printDialog.show();
	}
}