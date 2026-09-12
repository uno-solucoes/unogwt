package com.br.client.panel.fn.fnw0217.model;

 
import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.howmake.client.form.partner.HowMGWTUtilities;
 

public class PlanoContasModel {


	private boolean ccustoSubstring3	= false;
	private boolean verificaFlagBanco 	= true;
	
	static final String contaNullDespesa 		 = EPlanoContas.CONTA_NULL_DESPESA;
	static final String contaNullReceita 		 = EPlanoContas.CONTA_NULL_RECEITA;
	
	private DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyy-MM-dd");
	
	public static final String TIPO_CONTA_RECEITA  = EPlanoContas.TIPO_CONTA_RECEITA;
	public static final String TIPO_CONTA_DESPESA  = EPlanoContas.TIPO_CONTA_DESPESA;	
 
	boolean naoListaTransferencias 	= true;
	
	private String dataAtualInicio;
	private String dataAtualFim;
	private String dataInicio;	
	private String dataFim;
	private Date dataReferencia;
	// private Date dataReferenciaFim;
	
	private String filtroDataReferencia;
	private String filtroDataReferenciaFim;

	public String centroCusto;
	
	private String codEmpresa;
	private String tpPlanoConta;
	
	public String getTpPlanoConta() {
		return tpPlanoConta;
	}

	public void setTpPlanoConta(String tpPlanoConta) {
		this.tpPlanoConta = tpPlanoConta;
	}





	private String mes;
	private String ano;
	
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}





	private String sequencia;
	private String contaContabil;
	
	private boolean detalhaMes;

	private String detalhaDataInicio;
	private String detalhaDataFim;
	
	protected String ccusto;
	
	private boolean showDetail = false;
	private boolean showCentroCusto;
	
	
	/**
	 * Permite recupera os sql para consultar no banco de dados os dados para montar o balancete contas a receber.
	 * @param periodoInicio
	 * @param periodoFim
	 * @param dataReferencia
	 * @param dataReferenciaAtrasos
	 * @param naoListaTransferencias
	 */
	public PlanoContasModel( Date periodoInicio, Date periodoFim, Date dataReferencia, Date dataReferenciaAtrasos, boolean detalhaMes, Date detalhaDataInicio, Date detalhaDataFim, boolean showCentroCusto, 
							 boolean ccustoSubstring3){
		
		this.dataReferencia     = dataReferencia;
		
		this.dataInicio 		= " '"+dateTimeFormat.format(periodoInicio)+" 00:00:00' ";
		this.dataFim    		= " '"+dateTimeFormat.format(periodoFim)   +" 23:59:59' ";

//		Era assim antes do Marcio pedir para alterar as data e incluir um período inicial e final praa 
//		data de corte.
//		this.dataAtualInicio  	= " '"+dateTimeFormat.format(dataReferenciaAtrasos)+" 00:00:00' ";
//		this.dataAtualFim     	= " '"+dateTimeFormat.format(dataReferencia)+" 23:59:59' ";
//		this.dataAtualAtrasos 	= " '"+dateTimeFormat.format(dataReferenciaAtrasos)+" 00:00:00' ";

		this.dataAtualInicio  	= " '"+dateTimeFormat.format(dataReferencia)+" 00:00:00' ";
		
		// Era assim antes do marcio pedir para remover a data de referencia fim.
		// 02/09/2014
		this.dataAtualFim     	= " '"+dateTimeFormat.format(dataReferencia)+" 23:59:59' ";
		
		this.filtroDataReferencia  	= " '"+dateTimeFormat.format(dataReferencia)+" 00:00:00' ";
		this.filtroDataReferenciaFim  = " '"+dateTimeFormat.format(dataReferencia)+" 23:59:59' ";
		
		this.detalhaMes			= detalhaMes;
		this.detalhaDataInicio	= " '"+dateTimeFormat.format(detalhaDataInicio)+" 00:00:00' ";
		this.detalhaDataFim		= " '"+dateTimeFormat.format(detalhaDataFim)+" 23:59:59' ";;

		this.ccustoSubstring3 	= ccustoSubstring3;
		
		this.showCentroCusto 	= showCentroCusto;
	}
	
	public boolean isVerificaFlagBanco() {
		return verificaFlagBanco;
	}

	public void setVerificaFlagBanco(boolean verificaFlagBanco) {
		this.verificaFlagBanco = verificaFlagBanco;
	}
	
	public boolean isDetalhaMes() {
		return detalhaMes;
	}

	public void setDetalhaMes(boolean detalhaMes) {
		this.detalhaMes = detalhaMes;
	}

	public String getDetalhaDataInicio() {
		return detalhaDataInicio;
	}

	public void setDetalhaDataInicio(String detalhaDataInicio) {
		this.detalhaDataInicio = detalhaDataInicio;
	}

	public String getDetalhaDataFim() {
		return detalhaDataFim;
	}

	public void setDetalhaDataFim(String detalhaDataFim) {
		this.detalhaDataFim = detalhaDataFim;
	}	



	/**
	 * @return the ListaTransferencias
	 */
	public boolean isNaoListaTransferencias() {
		return naoListaTransferencias;
	}



	/**
	 * @param listaTransferencias the naoListaTransferencias to set
	 */
	public void setNaoListaTransferencias(boolean listaTransferencias) {
		this.naoListaTransferencias = listaTransferencias;
	}



	/**
	 * @return the codEmpresa
	 */
	public String getCodEmpresa() {
		return codEmpresa;
	}



	/**
	 * @param codEmpresa the codEmpresa to set
	 */
	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}
	
	
	/**
	 * Retorna o sql para recupera os atrasos
	 * @param dataInicio
	 * @return
	 */
	protected String getSelectAtrasosVersaoMarcio(String dataInicio){	 
			String sql = "";
			
			sql += "-- ------------------------------------------------------\n";
			sql += "-- Contas a Receber - títulos em Atraso - Versão Marcio\n";
			sql += "-- ------------------------------------------------------\n";	

			
			sql += "select * from ( \n";
			sql += "select\n";
			sql += "        "+EPlanoContas.grupoAtrasos+" as sequencia,	\n";
			sql += "        CONCAT( LPAD( MONTH(cast("+dataInicio+" as date)), 2, '0' ) , ':',YEAR(cast("+dataInicio+" as date)) ) as mesRef,\n";
			sql += "		"+this.getCentroCusto();
			sql += "        '"+TIPO_CONTA_RECEITA+"' as tipoConta,\n";
			sql += "        CONCAT(ifnull(tipa.conta, '"+contaNullReceita+"' ),ifnull(tipa.sub_conta, '"+contaNullReceita+"')) 	as conta,  		\n";
			sql += getDetailSelect("tipa.dt_vencimento");		
					
			sql += "	sum( calcularJurosReceber(tipa.cod_empresa,tipa.cod_titulo,tipa.cod_parcela,tipa.serie, " + "cast("+getFiltroDataReferenciaFim()+" as date) , '1' ) "+getCentroCustoPercRateio()+" ) as valor\n";  // cast("+filtroDataReferencia+" as date) era assim.
			sql += "FROM\n"; 
			sql += "	fn_titulo_receber  as tipa\n";
			sql += getCentroCustoRateio();
			sql += getPlanoConta();
			sql += "	LEFT JOIN cd_forma_pagto \n";
			sql += "	ON\n";
			sql += "				cd_forma_pagto.cod_forma_pagto = tipa.cod_forma_pagto\n"; 
			sql += "	LEFT JOIN cd_cliente \n";
			sql += "	ON \n";
			sql += "			cd_cliente.cod_cliente = tipa.cod_cliente\n"; 				
			sql += "	LEFT JOIN vd_pedido \n";
			sql += "	ON \n";
			sql += "			vd_pedido.cod_pedido = tipa.cod_pedido\n"; 
			sql += "			AND \n";
			sql += "			vd_pedido.cod_empresa  in ("+this.getCodEmpresa()+")\n";
			sql += "	LEFT JOIN sg_colaborador \n";
			sql += "	ON \n";
			sql += "			sg_colaborador.cod_colaborador = vd_pedido.cod_colaborador\n"; 
			sql += "	LEFT JOIN fn_centro_custo \n";
			sql += "	ON \n";
			sql += "			fn_centro_custo.ccusto = tipa.ccusto\n"; 						
			sql += "	WHERE \n";
			sql += "		tipa.cod_empresa in ("+this.getCodEmpresa()+")\n"; 
			sql += "		AND tipa.situacao < '30'   \n";
			sql += "		AND ( \n";
			sql += "				     tipa.dt_vencimento < cast("+filtroDataReferenciaFim+" as date) \n";
			
			// ( tipa.dt_vencimento >= cast("+filtroDataReferencia+" as date)   AND
			sql += "			)  \n";
			
		    // Filtro por Centro de Custo - OC-38540
		    if ( !HowMGWTUtilities.isEmpty(this.getCcusto())){
		    	sql += "    "+this.getCcusto()+"\n";
			}
	        
		    if ( naoListaTransferencias ){
	        	sql += " 	and\n";		
	        	sql += " 	tipa.cod_especie <> 97\n";
	        }
			
		    if( !HowMGWTUtilities.isEmpty( this.getTpPlanoConta() ) && !"0".equals( this.getTpPlanoConta() ) ){
				sql += "		AND fn_plano_conta.tp_plano_conta = "+ this.getTpPlanoConta() + "\n";
			}
		    
		    if ( verificaFlagBanco ){
				sql += "	and exists( select 1 from cd_banco\n";
				sql += "	where \n";
				sql += "		cd_banco.cod_empresa 	= tipa.cod_empresa \n";
				sql += "		and \n";
				sql += "		cd_banco.cod_banco 		= tipa.cod_banco \n";
				sql += "		and \n";
				sql += "		cd_banco.ind_considera_result_financeiro = '1' \n";
				sql += ")\n";
			}
			sql += "GROUP BY\n";
			sql += "        "+EPlanoContas.grupoAtrasos+",	\n";
			// sql += "        MONTH(cast("+dataInicio+" as date)),\n";
			sql += "        CONCAT( MONTH(cast("+dataInicio+" as date)) , ':',YEAR(cast("+dataInicio+" as date)) ),\n";
			sql += "		"+this.getCentroCustoOrderBy();
			sql += "        '"+TIPO_CONTA_RECEITA+"',\n";       
			sql += "        CONCAT(ifnull(tipa.conta, '"+contaNullReceita+"' ),ifnull(tipa.sub_conta, '"+contaNullReceita+"'))\n";

			// sql += getDetailGroupBy("cast("+dataInicio+" as date)");		
			sql += getDetailGroupBy("tipa.dt_vencimento");		
			
//			sql += "HAVING\n";
//			sql += "   	valor > 0\n";
			sql += ") as resultQuery\n";
			if ( this.isShowDetail() ){
				sql += "where \n";

		    	if ( !HowMGWTUtilities.isEmpty(this.getContaContabil())){
			    	sql += " conta = '"+this.getContaContabil()+"'\n";
		    	}
		    	if ( !HowMGWTUtilities.isEmpty(this.getMes())){
			    	sql += "	AND\n";
			    	sql += "	mesRef = '"+HowMGWTUtilities.getLPad(this.getMes(), "0", 2) +":"+this.getAno()+"'\n";
		    	}			
			}
			return sql;
		}
		
	
	
	/**
	 * Retorna o sql para recupera os atrasos
	 * @param dataInicio
	 * @return
	 */
	protected String getSelectAtrasos(String dataInicio){
		String sql = "";
		
		sql += "-- ------------------------------------------------------\n";
		sql += "-- Contas a Receber - títulos em Atraso - Versão Original\n";
		sql += "-- ------------------------------------------------------\n";	
		
		sql += "select * from ( \n";
		sql += "select\n";
		sql += "        "+EPlanoContas.grupoAtrasos+" as sequencia,	\n";
		sql += "        CONCAT( LPAD( MONTH(cast("+dataInicio+" as date)), 2, '0' ) , ':',YEAR(cast("+dataInicio+" as date)) ) as mesRef,\n";
		sql += "		"+this.getCentroCusto();
		sql += "        '"+TIPO_CONTA_RECEITA+"' as tipoConta,\n";
		sql += "        CONCAT(ifnull(tipa.conta, '"+contaNullReceita+"' ),ifnull(tipa.sub_conta, '"+contaNullReceita+"')) 	as conta,  		\n";
//		sql += getDetailSelect("cast("+dataInicio+" as date)");		
		sql += getDetailSelect("tipa.dt_vencimento");		
		
		sql += "	sum( calcularJurosReceber(tipa.cod_empresa,tipa.cod_titulo,tipa.cod_parcela,tipa.serie, cast("+dataInicio+" as date) , '1' ) "+getCentroCustoPercRateio()+" ) as valor\n";
		sql += "from\n";
		sql += " 	fn_titulo_receber tipa\n";
		sql += getCentroCustoRateio();
		sql += getPlanoConta();

		sql += "where\n";
	    // OC: 39705 - restringe situações válidas ignorando algumas situações conforme solicitado
		sql += " 	tipa.situacao < 30 \n";
		
	    // Filtro por Centro de Custo - OC-38540
	    if ( !HowMGWTUtilities.isEmpty(this.getCcusto())){
	    	sql += "    "+this.getCcusto()+"\n";
		}
        if ( naoListaTransferencias ){
        	sql += " 	and\n";		
        	sql += " 	tipa.cod_especie <> 97\n";
        }
		sql += "	and\n";
//      Removido, porque para os atrasos não faz sentido.		
//		// Filtro para Detalha Mes - OC:63384
//		if( this.isDetalhaMes() ){
//			sql += " 	tipa.dt_vencimento    >=  "+this.getDetalhaDataInicio()+"\n";
//			sql += " 	and\n";
//			sql += " 	tipa.dt_vencimento    <=  "+this.getDetalhaDataFim()+"\n";
//		}
//		else{
			sql += " 	tipa.dt_vencimento    <  "+dataInicio+"\n";
//		}
		sql += "	and\n";
		sql += " 	tipa.cod_empresa    in ("+this.getCodEmpresa()+")\n";
		
		if( !HowMGWTUtilities.isEmpty( this.getTpPlanoConta() ) && !"0".equals( this.getTpPlanoConta() ) ){
			sql += "		AND fn_plano_conta.tp_plano_conta = "+ this.getTpPlanoConta() + "\n";
		}
		
		if ( verificaFlagBanco ){
			sql += "	and exists( select 1 from cd_banco\n";
			sql += "	where \n";
			sql += "		cd_banco.cod_empresa 	= tipa.cod_empresa \n";
			sql += "		and \n";
			sql += "		cd_banco.cod_banco 		= tipa.cod_banco \n";
			sql += "		and \n";
			sql += "		cd_banco.ind_considera_result_financeiro = '1' \n";
			sql += ")\n";
		}
		
		
		sql += "	and\n";
		sql += " 	(\n";
		sql += "		(\n"; 
		sql += "			tipa.vl_total_titulo - \n";
		sql += "      		(     ifnull( tipa.vl_iss , 0 )\n";
		sql += "	                + ifnull( tipa.vl_ir,0) \n";
		sql += "	                + ifnull( tipa.vl_pis, 0 ) \n";
		sql += "	                + ifnull( tipa.vl_cofins , 0 ) \n";
		sql += "	                + ifnull( tipa.vl_cs , 0 ) \n";
		sql += "            )\n";
		sql += "      	)  -  \n";
		sql += "        CASE WHEN \n";
		sql += "		( \n";
		sql += "			select \n";
		sql += "	        	sum(ifnull(hist.vl_baixa,0)) \n";
		sql += "	        from \n";
		sql += "	        	fn_titulo_receber_hist as hist \n";
		sql += "			where \n";
		sql += "				hist.cod_empresa     = tipa.cod_empresa \n";
		sql += "				and \n";
		sql += "				hist.cod_titulo      = tipa.cod_titulo \n";
		sql += "				and \n";
		sql += "				hist.cod_parcela     = tipa.cod_parcela \n";
		sql += "				and \n";
		sql += "				hist.serie     = tipa.serie \n";
		sql += "				and \n";
		sql += "				hist.tp_hist = 30 \n";
		sql += "				and \n";
		
		sql += "				hist.dt_referencia < cast( "+dataInicio+"   as date ) \n";			
			
		if ( verificaFlagBanco ){
			sql += "	and exists( select 1 from cd_banco \n";
			sql += "	where\n";
			sql += "		cd_banco.cod_empresa 	= hist.cod_empresa \n";
			sql += "		and \n";
			sql += "		cd_banco.cod_banco 		= hist.cod_banco \n";
			sql += "		and \n";
			sql += "		cd_banco.ind_considera_result_financeiro = '1' \n";
			sql += ")\n";
		}	
			
		sql += "		) IS NULL \n";
		sql += "        	THEN \n";
		sql += "				0.0 \n";
		sql += "			ELSE \n";
		sql += "			( \n";
		sql += "				select \n";
		sql += "	                sum(ifnull(hist.vl_baixa,0)) \n";
		sql += "	       		from fn_titulo_receber_hist as hist \n";
		sql += "	            where \n";
		sql += "	            	hist.cod_empresa     = tipa.cod_empresa \n";
		sql += "        			and \n";
		sql += "        			hist.cod_titulo      = tipa.cod_titulo \n";
		sql += "        			and \n";
		sql += "        			hist.cod_parcela     = tipa.cod_parcela \n";
		sql += "        			and \n";
		sql += "        			hist.serie     = tipa.serie \n";
		sql += "        			and \n";
		sql += "        			hist.tp_hist = 30 \n";
		sql += "        			and \n";
		
		sql += "				hist.dt_referencia < cast( "+dataInicio+"   as date ) \n";			

		if ( verificaFlagBanco ){
			sql += "	and exists (select 1 from  cd_banco \n";
			sql += "	where \n";
			sql += "		cd_banco.cod_empresa 	= hist.cod_empresa \n";
			sql += "		and \n";
			sql += "		cd_banco.cod_banco 		= hist.cod_banco \n";
			sql += "		and \n";
			sql += "		cd_banco.ind_considera_result_financeiro = '1' \n";
			sql += ")\n";
		}				

			
		sql += "             )\n";
		sql += "        END\n";
		sql += " ) > 0\n";                  
		sql += "GROUP BY\n";
		sql += "        "+EPlanoContas.grupoAtrasos+",	\n";
		// sql += "        MONTH(cast("+dataInicio+" as date)),\n";
		sql += "        CONCAT( MONTH(cast("+dataInicio+" as date)) , ':',YEAR(cast("+dataInicio+" as date)) ),\n";
		sql += "		"+this.getCentroCustoOrderBy();
		sql += "        '"+TIPO_CONTA_RECEITA+"',\n";       
		sql += "        CONCAT(ifnull(tipa.conta, '"+contaNullReceita+"' ),ifnull(tipa.sub_conta, '"+contaNullReceita+"'))\n";

		// sql += getDetailGroupBy("cast("+dataInicio+" as date)");		
		sql += getDetailGroupBy("tipa.dt_vencimento");		
		
//		sql += "HAVING\n";
//		sql += "   	valor > 0\n";
		sql += ") as resultQuery\n";
		if ( this.isShowDetail() ){
			sql += "where \n";

	    	if ( !HowMGWTUtilities.isEmpty(this.getContaContabil())){
		    	sql += " conta = '"+this.getContaContabil()+"'\n";
	    	}
	    	if ( !HowMGWTUtilities.isEmpty(this.getMes())){
		    	sql += "	AND\n";
		    	sql += "	mesRef = '"+HowMGWTUtilities.getLPad(this.getMes(), "0", 2) +":"+this.getAno()+"'\n";
	    	}			
		}
		return sql;
	}
	
	
	
	/**
	 * Retorna o sql para recupar os dados dos títulos pagos contas a receber.
	 * @param codEmpresa código da Empresa
	 * @param dataInicio Data de inicio
	 * @param dataFim Data fim
	 * @param naoListaTransferencias Indica se lista ou não as transferências. 
	 * @param tipoGrupo Tipo de grupo que será considerado para o período a ser consultado.
	 * @return
	 */
	protected String getSelectPago(String dataInicio, String dataFim, String tipoGrupo){
		String sql = "";
		
		sql += "-- ------------------------------------------------------\n";
		sql += "-- Contas a Receber - títulos Pagos\n";
		sql += "-- ------------------------------------------------------\n";	

		
		sql += "SELECT\n";
		sql += "        "+tipoGrupo+" as sequencia,	\n";
		sql += "        CONCAT( LPAD( MONTH(hist.dt_referencia), 2, '0') , ':',YEAR(hist.dt_referencia) )  mesRef,\n";
		sql += "		"+this.getCentroCusto();
		sql += "        '"+TIPO_CONTA_RECEITA+"' as tipoConta,\n";       
		sql += "        CONCAT(ifnull(tipa.conta, '"+contaNullReceita+"' ),ifnull(tipa.sub_conta, '"+contaNullReceita+"')) 	as conta,  		\n";
		sql += getDetailSelect("hist.dt_referencia");
		sql += "        sum(ifnull(hist.vl_baixa,0)"+getCentroCustoPercRateio()+") as valor\n";
		sql += "FROM  \n";
		sql += "	fn_titulo_receber_hist  as hist\n";
		sql += "	LEFT JOIN cd_forma_pagto \n";
        sql += "		ON \n";
        sql += "			cd_forma_pagto.cod_forma_pagto = hist.cod_forma_pagto \n";
        sql += "	INNER JOIN fn_titulo_receber as tipa\n";
        sql += "		ON \n";
        sql += "			hist.cod_empresa = tipa.cod_empresa\n";
        sql += "			AND\n";
        sql += "			hist.cod_titulo = tipa.cod_titulo\n";
        sql += "			AND\n";
        sql += "			hist.cod_parcela = tipa.cod_parcela\n";
        sql += "			AND\n";
        sql += "			hist.serie = tipa.serie\n";
		sql += getCentroCustoRateio();
		sql += getPlanoConta();
        sql += "	LEFT JOIN fn_especie \n";
        sql += "		ON \n";
        sql += "			fn_especie.cod_especie = tipa.cod_especie \n";
        sql += "	LEFT JOIN vd_pedido \n";
        sql += "		ON \n";
        sql += "			vd_pedido.cod_pedido = tipa.cod_pedido\n";
        sql += "			AND\n";  
        sql += "			vd_pedido.cod_empresa = tipa.cod_empresa\n";
        sql += "	LEFT JOIN vd_nota_fiscal\n";
        sql += "		ON \n"; 
        sql += "			vd_nota_fiscal.cod_nota_fiscal = tipa.cod_nota_fiscal\n";
        sql += "			AND\n";
        sql += "			vd_nota_fiscal.cod_empresa = tipa.cod_empresa\n"; 
        sql += "	LEFT JOIN sg_colaborador \n";
        sql += "		ON \n";
        sql += "			sg_colaborador.cod_colaborador = vd_nota_fiscal.cod_colaborador \n";
        sql += "WHERE \n";
        sql += "	tipa.cod_empresa in ("+this.getCodEmpresa()+")\n";
        
	    // Filtro por Centro de Custo - OC-38540
	    if ( !HowMGWTUtilities.isEmpty(this.getCcusto())){
	    	sql += "   "+this.getCcusto()+"\n";	    	
		}        
        sql += "	AND\n";
        sql += "	hist.tp_hist = 30 \n";
        sql += "	AND\n";
        sql += "	hist.dt_referencia >= "+dataInicio+"\n";
        sql += "	AND\n";
        sql += "	hist.dt_referencia <= "+dataFim+"\n";
        
        if( !HowMGWTUtilities.isEmpty( this.getTpPlanoConta() ) && !"0".equals( this.getTpPlanoConta() ) ){
			sql += "		AND fn_plano_conta.tp_plano_conta = "+ this.getTpPlanoConta() + "\n";
		}
        
        if ( naoListaTransferencias ){
	        sql += "	AND \n";
	        sql += "	( \n";
	        sql += "		tipa.cod_especie <> 97 \n";
	        sql += "		OR\n";
	        sql += "		tipa.cod_especie is null \n";
	        sql += "	)\n"; 
        }
	    if ( this.isShowDetail()){
	    	if ( ! HowMGWTUtilities.isEmpty(this.getContaContabil())){
		    	sql += "	AND\n";
		    	sql += "	CONCAT(ifnull(tipa.conta, '"+contaNullReceita+"' ),ifnull(tipa.sub_conta, '"+contaNullReceita+"')) = '"+this.getContaContabil()+"'\n";
	    	}
	    	if ( ! HowMGWTUtilities.isEmpty(this.getMes())){
			    sql += "	AND\n";
		    	sql += "	MONTH(hist.dt_referencia) = "+this.getMes()+"\n";
			    sql += "	AND\n";
		    	sql += "	YEAR(hist.dt_referencia) = "+this.getAno()+"\n";
	    	}
	    }
	    
	    if( verificaFlagBanco ){
	    	sql += "	and exists( select 1 from cd_banco\n";
			sql += "	where \n";
			sql += "		cd_banco.cod_empresa 	= hist.cod_empresa \n";
			sql += "		and \n";
			sql += "		cd_banco.cod_banco 		= hist.cod_banco \n";
			sql += "		and \n";
			sql += "		cd_banco.ind_considera_result_financeiro = '1' \n";
			sql += ")\n";
	    }
        
        sql += "GROUP BY\n";
		sql += "        "+tipoGrupo+",\n";
	//	sql += "        MONTH(hist.dt_referencia),\n";
		sql += "        CONCAT( MONTH(hist.dt_referencia) , ':',YEAR(hist.dt_referencia) ),\n";
		sql += "		"+this.getCentroCustoOrderBy();
		sql += "        '"+TIPO_CONTA_RECEITA+"',\n";       
		sql += "        CONCAT(ifnull(tipa.conta, '"+contaNullReceita+"' ),ifnull(tipa.sub_conta, '"+contaNullReceita+"'))\n";
		sql += getDetailGroupBy("hist.dt_referencia");
	
        return sql;
	}
	
	
	
	/**
	 * Retorna os títulos que estão vencendo em um determinado período
	 * @param dataInicio Data inicio que será realizada a consulta.
	 * @param dataFim Data fim 
	 * @param tipoGrupo Tipo de grupo que será apresentado os títulos em vencimento
	 * @return
	 */
	protected String getSelectTitulosVencimento(String dataInicio, String dataFim, String tipoGrupo){
		String sql = "";

		sql += "-- ------------------------------------------------------\n";
		sql += "-- Contas a Receber - t�tulos a Vencer - Previs�o\n";
		sql += "-- ------------------------------------------------------\n";	

		
		sql += "SELECT\n";
		sql += "        "+tipoGrupo+" as sequencia,	\n";
		sql += "        CONCAT( LPAD( MONTH(tipa.dt_vencimento), 2, '0' ) , ':',YEAR(tipa.dt_vencimento) ) as mesRef,\n";
		sql += "		"+this.getCentroCusto();
		sql += "        '"+TIPO_CONTA_RECEITA+"' as tipoConta,\n";       
		sql += "        CONCAT(ifnull(tipa.conta, '"+contaNullReceita+"' ),ifnull(tipa.sub_conta, '"+contaNullReceita+"')) 	as conta,\n";
		sql += getDetailSelect("tipa.dt_vencimento");		
		if (EPlanoContas.grupoPervisao.equals(tipoGrupo)){
			sql += "        sum( calcularJurosReceber(tipa.cod_empresa,tipa.cod_titulo,tipa.cod_parcela,tipa.serie, " + "cast("+getFiltroDataReferenciaFim()+" as date) , '1' ) "+getCentroCustoPercRateio()+" ) as valor\n";
		}
		else{
			sql += "        sum( ( tipa.vl_total_titulo - tipa.vl_total_baixa - ( ifnull(vl_iss,0) + ifnull(vl_ir,0) + ifnull(vl_pis,0) + ifnull(vl_cofins,0) + ifnull(vl_cs,0) + ifnull(vl_desconto,0) + ifnull(vl_inss,0)) ) "+getCentroCustoPercRateio()+" ) as valor\n";
		}		
		sql += "FROM\n";
	    sql += "	fn_titulo_receber as tipa\n";
		sql += getCentroCustoRateio();
		sql += getPlanoConta();
		
	    sql += "WHERE\n";
	    
	    sql += "	tipa.dt_vencimento between  "+dataInicio+"  and "+dataFim+"\n";
	    
	    if( !HowMGWTUtilities.isEmpty( this.getTpPlanoConta() ) && !"0".equals( this.getTpPlanoConta() ) ){
			sql += "		AND fn_plano_conta.tp_plano_conta = "+ this.getTpPlanoConta() + "\n";
		}
	    
	    // Filtro por Centro de Custo - OC-38540
	    if ( !HowMGWTUtilities.isEmpty(this.getCcusto())){
	    	sql += "    "+this.getCcusto()+"\n";
		}
	    sql += "	AND\n";
	    // OC: 39705 - restringe situações válidas ignorando alguamas situações conforme solicitado
	    sql += "	tipa.situacao < 30\n";
	    if ( this.naoListaTransferencias ){
		    sql += "	AND\n";
		    sql += "	tipa.cod_especie <> 97 \n";
		}
	    if ( this.isShowDetail()){
	    	if ( ! HowMGWTUtilities.isEmpty(this.getContaContabil() ) ){
		    	sql += "	AND\n";
		    	sql += "	CONCAT(ifnull(tipa.conta, '"+contaNullReceita+"' ),ifnull(tipa.sub_conta, '"+contaNullReceita+"')) = '"+this.getContaContabil()+"'\n";
	    	}
	    	if ( !HowMGWTUtilities.isEmpty(this.getMes())){
		    	sql += "	AND\n";
		    	sql += "	MONTH(tipa.dt_vencimento) = "+this.getMes()+"\n";
			    sql += "	AND\n";
		    	sql += "	YEAR(tipa.dt_vencimento) = "+this.getAno()+"\n";
	    	}
	    }
	    
	    if( verificaFlagBanco ){
	    	
	    	sql += "	and exists( select 1 from cd_banco\n";
			sql += "	where \n";
			sql += "		cd_banco.cod_empresa 	= tipa.cod_empresa \n";
			sql += "		and \n";
			sql += "		cd_banco.cod_banco 		= tipa.cod_banco \n";
			sql += "		and \n";
			sql += "		cd_banco.ind_considera_result_financeiro = '1' \n";
			sql += ")\n";
	    	
	    }
	    
		sql += "	AND\n";
	    sql += "	tipa.cod_empresa in ("+this.getCodEmpresa()+")\n";
	    sql += "GROUP BY\n";
		sql += "        "+tipoGrupo+",	\n";
		// sql += "        MONTH(tipa.dt_vencimento),\n";
		sql += "        CONCAT( MONTH(tipa.dt_vencimento) , ':',YEAR(tipa.dt_vencimento) ),\n";
		sql += "		"+this.getCentroCustoOrderBy();
		sql += "        '"+TIPO_CONTA_RECEITA+"',\n";       
		sql += "        CONCAT(ifnull(tipa.conta, '"+contaNullReceita+"' ),ifnull(tipa.sub_conta, '"+contaNullReceita+"'))\n";
		sql += getDetailGroupBy("tipa.dt_vencimento");
		return sql;
	}
	
	
	/**
	 * Retorna o sql para recupar os dados dos títulos pagos 
	 * no mes atual.
	 * @param dataInicio Data de inicio
	 * @param dataFim Data fim
	 * @param naoListaTransferencias Indica se lista ou não as transferências. 
	 * @param tipoGrupo Tipo de grupo que será considerado para o período a ser consultado.
	 * @return
	 */
	public String getSelectMesAtualPago(){
		if( this.isDetalhaMes() ){
			return getSelectPago(this.detalhaDataInicio, this.detalhaDataFim, EPlanoContas.grupoDataAtual);
		}
		else{
			return getSelectPago(this.dataAtualInicio, this.dataAtualFim, EPlanoContas.grupoDataAtual);
		}
	}

	/**
	 * Retorna o sql para recupar os dados dos títulos pagos 
	 * no mes atual.
	 * @param dataInicio Data de inicio
	 * @param dataFim Data fim
	 * @param naoListaTransferencias Indica se lista ou não as transferências. 
	 * @param tipoGrupo Tipo de grupo que será considerado para o período a ser consultado.
	 * @return
	 */
	public String getSelectOutrosMesesPago(){
	
		Date dataFimPagos = new Date(this.dataReferencia.getYear(),this.dataReferencia.getMonth()+1, 0);
		String dataFimOutrosPagos = " '"+dateTimeFormat.format(dataFimPagos)+" 23:59:59' ";
		return getSelectPago(this.dataInicio, dataFimOutrosPagos, EPlanoContas.grupoPagos);
	}	
	
	/**
	 * @return Retorna o sql para recuperar os titulos que estão vencidos em um determinado período.
	 */
	public String getSelectTitulosAVencer(){
		Date dataInicioVencimento = this.dataReferencia;		
		String dataInicioOutrosVencimentos = " '"+dateTimeFormat.format(dataInicioVencimento)+" 00:00:00' ";
		return getSelectTitulosVencimento(dataInicioOutrosVencimentos, this.dataFim, EPlanoContas.grupoPervisao);		
	}
	
	/**
	 * @return Retorna o sql para recuperar os titulos que estão vencidos em um determinado período.
	 */
	public String getSelectTitulosAVencerMesAtual(){
		if( this.isDetalhaMes() ){
			return getSelectTitulosVencimento(this.detalhaDataInicio, this.detalhaDataFim, EPlanoContas.grupoDataAtual);
		}
		else{
			return getSelectTitulosVencimento(this.dataAtualInicio, this.dataAtualFim, EPlanoContas.grupoDataAtual);
		}

	}

	public String getSelectAtrasos(){
		return this.getSelectAtrasosVersaoMarcio(filtroDataReferenciaFim);
	}




	/**
	 * @return the detail
	 */
	public boolean isShowDetail() {
		return showDetail;
	}





	/**
	 * @param detail the detail to set
	 */
	public void setShowDetail(boolean detail) {
		this.showDetail = detail;
	}
	
	/**
	 * Retorna os campos que serão inclusos no groyp by da consulta caso o showDetail esteja ligado.
	 * @return
	 */
	protected String getDetailSelect(String data){
	    if ( this.showDetail ){
	    	String sql = "";
	    	sql += "	"+data+" as data,\n";
	    	sql += "	tipa.cod_titulo,\n";
	    	sql += "	tipa.cod_parcela,\n";
	    	sql += "	'' as pessoa, \n";
	    	sql += "	tipa.serie as chave, \n";
	    	return sql;
	    }
	    return "";
	}
	
	
	
	/**
	 * Retorna os campos que serão inclusos no groyp by da consulta caso o showDetail esteja ligado.
	 * @return
	 */
	protected String getDetailGroupBy(String data){
	    if ( this.showDetail ){
	    	String sql = "";
	    	sql += "    ,\n";
	    	sql += "	"+data+",\n";
	    	sql += "	tipa.cod_titulo,\n";
	    	sql += "	tipa.cod_parcela,\n";
	    	sql += "	'' , \n";
	    	sql += "	tipa.serie \n";
	    	return sql;
	    }
	    return "";
	}





	/**
	 * @return the mes
	 */
	public String getMes() {
		return mes;
	}





	/**
	 * @param mes the mes to set
	 */
	public void setMes(String mes) {
		// Se o dois pontos estiver contido na expressão mes, então
		// o ano está na expressão, neste caso separa mes e ano.
		if( mes != null && mes.indexOf(":") > 0 ){
			String[] parts = mes.split(":");
			mes = parts[0];
			ano = parts[1];
		}
		this.mes = mes;
	}





	/**
	 * @return the sequencia
	 */
	public String getSequencia() {
		return sequencia;
	}





	/**
	 * @param sequencia the sequencia to set
	 */
	public void setSequencia(String sequencia) {
		this.sequencia = sequencia;
	}





	/**
	 * @return the contaContabil
	 */
	public String getContaContabil() {
		return contaContabil;
	}





	/**
	 * @param contaContabil the contaContabil to set
	 */
	public void setContaContabil(String contaContabil) {
		this.contaContabil = contaContabil;
	}





	/**
	 * @return the ccusto
	 */
	public String getCcusto() {
		return ccusto;
	}
	
	
	
	
//	public String getCcusto(boolean rateio, String tabela){
//		if(HowMGWTUtilities.isEmpty( this.getCentroCustoRateio()  )){
//			return ccusto;
//		}		
//		else{
//			if( HowMGWTUtilities.isEmpty( ccusto ) ){
//				return "";
//			}						
//			else if( rateio ){							
//				String newCCusto = ccusto; 
//				newCCusto = HowMGWTUtilities.replace(newCCusto, "AND", "");
//				newCCusto = HowMGWTUtilities.replace(newCCusto, " (", "");
//				newCCusto = newCCusto.substring(0,newCCusto.trim().length()-1);
//				newCCusto = HowMGWTUtilities.replace(newCCusto, "\n", "");
//				
//				String filtro = "\n";
//				filtro += " AND  (  ";
//					filtro += newCCusto;
//					filtro += " OR ";
//					filtro += HowMGWTUtilities.replace(newCCusto, "tipa.", tabela+".");		
//				filtro += ") \n";
//				return filtro;
//			}
//			else{
//				return ccusto;
//			}
//		}		
//	}

	/**
	 * @param ccusto the ccusto to set
	 */	
	public void setCcusto(String ccusto) {
		
		if ( HowMGWTUtilities.isEmpty(ccusto) ){
			this.ccusto = ccusto;
			return;
		}
		
		String modelo = ccusto;
		
		ccusto = 
			"("
				+
				HowMGWTUtilities.replace(modelo, "${FIELD}", " fn_titulo_receber_rateio.ccusto  ")
				+
				" OR "
				+
				HowMGWTUtilities.replace(modelo, "${FIELD}", " tipa.ccusto ")
				+
			")";
		this.ccusto = " AND "+ccusto;
		
	}
	
	
	
	public boolean isCCusto(){
		return !HowMGWTUtilities.isEmpty(ccusto);
	}

	public String getCentroCusto(){
		
		if( this.ccustoSubstring3 ){
			if( this.isCCusto() || this.isShowCentroCusto() ){
				return "	replace(replace(substring( ifnull(ifnull(fn_titulo_receber_rateio.ccusto,tipa.ccusto),'S/CC') ,1,3),'.',''),'_','') as centroCusto,\n";
			}
			else{
				return "	substring( ifnull(tipa.ccusto,'S/CC')  ,1,3) as centroCusto,\n";
			}			
		}
		else{
			if( this.isCCusto() || this.isShowCentroCusto() ){
				return "	ifnull(ifnull(fn_titulo_receber_rateio.ccusto,tipa.ccusto),'S/CC') as centroCusto,\n";
			}
			else{
				return "	ifnull(tipa.ccusto,'S/CC') as centroCusto,\n";
			}
		}
	}
	
	public String getCentroCustoOrderBy(){
//		if( ccustoSubstring3 ){
//			if( this.isCCusto() || this.isShowCentroCusto() ){
//				return "	replace(replace(substring(ifnull(ifnull(fn_titulo_receber_rateio.ccusto,tipa.ccusto),'S/CC') ,1,3 ),'.',''),'_',''),\n";
//			}
//			else{
//				return "	substring( tipa.ccusto ,1,3 ) ,\n";
//			}			
//		}
//		else{
//			if( this.isCCusto() || this.isShowCentroCusto() ){
//				return "	ifnull(ifnull(fn_titulo_receber_rateio.ccusto,tipa.ccusto),'S/CC'),\n";
//			}
//			else{
				return "	centroCusto,\n";
//			}
//		}
	};
	

	
	public String getCentroCustoPercRateio(){
		if ( this.isCCusto() || this.isShowCentroCusto() )
			return " * ifnull(fn_titulo_receber_rateio.perc_rateio,1) ";
		else
			return "";
	}
	
	
	/**
	 * @return Retorna o conjunto de sql para relacionamento com o rateio contas a pagar.
	 */
	public String getCentroCustoRateio(){
		if ( this.isCCusto() || this.isShowCentroCusto() ){
			String sql = "";
			sql += "	LEFT JOIN fn_titulo_receber_rateio \n";
			sql += "		ON \n";
			sql += "			fn_titulo_receber_rateio.cod_titulo     = tipa.cod_titulo \n";
			sql += "			AND \n";
			sql += "			fn_titulo_receber_rateio.cod_parcela    = tipa.cod_parcela \n";
			sql += "			AND \n";
			sql += "			fn_titulo_receber_rateio.serie    		= tipa.serie \n";
			sql += "			AND \n";
			sql += "			fn_titulo_receber_rateio.cod_empresa    = tipa.cod_empresa \n";
			
			if ( !HowMGWTUtilities.isEmpty(this.getCcusto())){
		    	sql += "   "+this.getCcusto()+"\n";	    	
			}
			
			return sql;
		}
		return "";
	}
	
	/**
	 * @return Retorna o conjunto de sql para relacionamento com o rateio contas a pagar.
	 */
	public String getPlanoConta(){
		if( !HowMGWTUtilities.isEmpty( this.getTpPlanoConta() ) && !"0".equals( this.getTpPlanoConta() ) ){
			String sql = "";
			sql += "	LEFT JOIN fn_plano_conta \n";
			sql += "		ON \n";
			sql += "			fn_plano_conta.conta     = tipa.conta \n";
			sql += "			AND \n";
			sql += "			fn_plano_conta.sub_conta    = tipa.sub_conta \n";
						
			return sql;
		}
		return "";
	}

	public boolean isShowCentroCusto() {
		return showCentroCusto;
	}

	public void setShowCentroCusto(boolean showCentroCusto) {
		this.showCentroCusto = showCentroCusto;
	}

	public boolean isCcustoSubstring3() {
		return ccustoSubstring3;
	}

	public void setCcustoSubstring3(boolean ccustoSubstring3) {
		this.ccustoSubstring3 = ccustoSubstring3;
	}

	public String getFiltroDataReferencia() {
		return filtroDataReferencia;
	}

	public String getFiltroDataReferenciaFim() {
		return filtroDataReferenciaFim;
	}	
}