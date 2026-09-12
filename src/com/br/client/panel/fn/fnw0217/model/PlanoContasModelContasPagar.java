package com.br.client.panel.fn.fnw0217.model;

import java.util.Date;

import com.howmake.client.form.partner.HowMGWTUtilities;

public class PlanoContasModelContasPagar extends PlanoContasModel{
	
	/**
	 * Permite recupera os sql para consultar no banco de dados os dados para montar o balancete contas a pagar.
	 * @param periodo
	 * @param periodoFim
	 * @param dataReferencia
	 * @param dataReferenciaAtrasos
	 * @param naoListaTransferencias
	 */
	public PlanoContasModelContasPagar( Date periodo, Date periodoFim, Date dataReferencia, Date dataReferenciaAtrasos, boolean detalhaMes, Date detalhaData, Date detalhaDataFim,boolean showCentroCusto, boolean ccustoSubstring3){
		super(periodo, periodoFim, dataReferencia,  dataReferenciaAtrasos, detalhaMes, detalhaData, detalhaDataFim , showCentroCusto ,ccustoSubstring3);
	}
	
	
	protected String getSelectAtrasosVersaoMarcio(String data){		

		String sql = "";
		
		sql += "-- ------------------------------------------------------\n";
		sql += "-- Contas a Pagar - Titulos em Atraso - Versao Marcio\n";
		sql += "-- ------------------------------------------------------\n";	
		
		sql += "select * from ( \n";
		sql += "select\n";
		sql += "        "+EPlanoContas.grupoAtrasos+" as sequencia,	\n";
		sql += "        CONCAT( LPAD( MONTH(cast("+data+" as date)), 2, '0') , ':',YEAR(cast("+data+" as date)) ) as mesRef,\n";
		sql += "		"+this.getCentroCusto();
		sql += "        '"+TIPO_CONTA_DESPESA+"' as tipoConta,\n";
		sql += "        CONCAT(ifnull(tipa.conta, '"+contaNullDespesa+"' ),ifnull(tipa.sub_conta, '"+contaNullDespesa+"')) 	as conta,  		\n";
		sql += getDetailSelect("tipa.dt_vencimento");						
		// Problemas encontrados que fazem com que nao bata o relatorio.
		// 1 - Fonecedor com Codigo 0.
		// 2 - Data de Vencimento No fup esta como <= foi colocado aqui para ficar igual.
		// 3 - O Relatorio nao bate no mes 08 porque tem um titulo que esta com cod fornecedor = 0, deveria estar como null ou com um codigo de fornecedor valido.
		// 4 - Este titulo esta com cod_fornecedor = 0 deveria esta como null, ja que nao possui relacao com ninguem.
		sql += "	sum( calcularJurosPagar(tipa.cod_empresa,tipa.cod_titulo,tipa.cod_parcela,tipa.cod_fornecedor , tipa.cod_especie  , cast("+getFiltroDataReferencia()+" as date) , '1' ) "+getCentroCustoPercRateio()+" ) as valor\n";  // cast("+filtroDataReferencia+" as date) era assim.
		sql += "FROM\n"; 
		sql += "	fn_titulo_pagar  as tipa\n";
		sql += getCentroCustoRateio();
		sql += getPlanoConta();
		sql += "	LEFT JOIN cd_forma_pagto \n";
		sql += "	ON\n";
		sql += "				cd_forma_pagto.cod_forma_pagto = tipa.cod_forma_pagto\n"; 
		sql += "	LEFT JOIN fn_centro_custo \n";
		sql += "	ON \n";
		sql += "			fn_centro_custo.ccusto = tipa.ccusto\n"; 						
		sql += "	WHERE \n";
		sql += "		tipa.cod_empresa in ("+this.getCodEmpresa()+")\n";
		sql += "		AND\n";
		sql += "		tipa.situacao < 30 \n";
		sql += "		AND \n";
		sql += "		tipa.dt_vencimento < cast("+getFiltroDataReferenciaFim()+" as date) \n"; //    AND     tipa.dt_vencimento <= cast("+getFiltroDataReferenciaFim()+" as date)
		sql += "		\n";

		if( !HowMGWTUtilities.isEmpty( this.getTpPlanoConta() ) && !"0".equals( this.getTpPlanoConta() ) ){
			sql += "		AND fn_plano_conta.tp_plano_conta = "+ this.getTpPlanoConta() + "\n";
		}
		
	    // Filtro por Centro de Custo - OC-38540
	    if ( !HowMGWTUtilities.isEmpty(this.getCcusto())){
	    	sql += "    "+this.getCcusto()+"\n";
		}
        if ( naoListaTransferencias ){
        	sql += " 	and\n";		
        	sql += " 	tipa.cod_especie <> 97\n";
        }
		if ( isVerificaFlagBanco() ){
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
		sql += "        CONCAT( MONTH(cast("+data+" as date)) , ':',YEAR(cast("+data+" as date)) ),\n";
		sql += "		"+this.getCentroCustoOrderBy();
		sql += "        '"+TIPO_CONTA_DESPESA+"',\n";       
		sql += "        CONCAT(ifnull(tipa.conta, '"+contaNullDespesa+"' ),ifnull(tipa.sub_conta, '"+contaNullDespesa+"'))\n";

		sql += getDetailGroupBy("tipa.dt_vencimento");		
		
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
	 * @param data
	 * @return
	 */
	@Override
	protected String getSelectAtrasos(String data){
		String sql = "";
		
		sql += "-- ------------------------------------------------------\n";
		sql += "-- Contas a Pagar - títulos em Atraso - Versão Original\n";
		sql += "-- ------------------------------------------------------\n";	
		
		
		sql += "select * from ( \n";
		sql += "select\n";
		sql += "        "+EPlanoContas.grupoAtrasos+" as sequencia,	\n";
		sql += "        CONCAT( LPAD( MONTH(cast("+data+" as date)), 2, '0') , ':',YEAR(cast("+data+" as date)) ) as mesRef,\n";
		sql += "		"+this.getCentroCusto();
		sql += "        '"+TIPO_CONTA_DESPESA+"' as tipoConta,\n";       
		sql += "        CONCAT(ifnull(tipa.conta, '"+contaNullDespesa+"' ),ifnull(tipa.sub_conta, '"+contaNullDespesa+"')) 	as conta,  		\n";

		sql += getDetailSelect("tipa.dt_vencimento");		

		sql += "	sum( calcularJurosPagar(tipa.cod_empresa,tipa.cod_titulo,tipa.cod_parcela,tipa.cod_fornecedor,tipa.cod_especie,cast("+data+" as date) , '1' )  "+getCentroCustoPercRateio()+" ) as valor\n";
	
		sql += "from\n";
		sql += " 	fn_titulo_pagar tipa\n";
		sql += getCentroCustoRateio();
		sql += getPlanoConta();
		sql += "where\n";
		sql += " 	tipa.situacao < 30 \n";
		
		if( !HowMGWTUtilities.isEmpty( this.getTpPlanoConta() ) && !"0".equals( this.getTpPlanoConta() ) ){
			sql += "		AND fn_plano_conta.tp_plano_conta = "+ this.getTpPlanoConta() + "\n";
		}
		
	    // Filtro por Centro de Custo - OC-38540
	    if ( !HowMGWTUtilities.isEmpty(this.getCcusto())){
	    	sql += "    "+this.getCcusto()+"\n";
		}
		
        if ( naoListaTransferencias ){
        	sql += " 	and\n";		
        	sql += " 	tipa.cod_especie <> 97\n";
        }
		sql += "	and\n";
		
		sql += " 	tipa.dt_vencimento <  "+data+"\n";

		sql += "	and\n";
		sql += " 	tipa.cod_empresa in ("+this.getCodEmpresa()+")\n";
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
		sql += "	        	sum(ifnull((hist.vl_baixa * hist.vl_cotacao ),0)) \n";
		sql += "	        from \n";
		sql += "	        	fn_titulo_pagar_hist as hist \n";
		sql += "			where \n";
		sql += "				hist.cod_empresa     = tipa.cod_empresa \n";
		sql += "				and \n";
		sql += "				hist.cod_titulo      = tipa.cod_titulo \n";
		sql += "				and \n";
		sql += "				hist.cod_parcela     = tipa.cod_parcela \n";
		sql += "				and \n";
		sql += "				hist.cod_fornecedor  = tipa.cod_fornecedor \n";
		sql += "				and \n";
		sql += "				hist.cod_especie     = tipa.cod_especie \n";
		sql += "				and \n";
		sql += "				hist.tp_hist = 30 \n";
		sql += "				and \n";

		sql += "				hist.dt_referencia < cast( "+data+"   as date ) \n";			
		
		sql += "		) IS NULL \n";
		sql += "        	THEN \n";
		sql += "				0.0 \n";
		sql += "			ELSE \n";
		sql += "			( \n";
		sql += "				select \n";
		sql += "	                sum(ifnull(hist.vl_baixa * hist.vl_cotacao,0)) \n";
		sql += "	       		from fn_titulo_pagar_hist as hist \n";
		sql += "	            where \n";
		sql += "	            	hist.cod_empresa     = tipa.cod_empresa \n";
		sql += "        			and \n";
		sql += "        			hist.cod_titulo      = tipa.cod_titulo \n";
		sql += "        			and \n";
		sql += "        			hist.cod_parcela     = tipa.cod_parcela \n";
		sql += "        			and \n";
		sql += "        			hist.cod_fornecedor  = tipa.cod_fornecedor \n";
		sql += "        			and \n";
		sql += "	            	hist.cod_especie     = tipa.cod_especie \n";
		sql += "        			and \n";
		sql += "        			hist.tp_hist = 30 \n";
		sql += "        			and \n";
		
		sql += "				hist.dt_referencia < cast( "+data+"   as date ) \n";			
		

		sql += "             )\n";
		sql += "        END\n";
		sql += " ) > 0\n";                  
		sql += "GROUP BY\n";
		sql += "        "+EPlanoContas.grupoDataAtual+",	\n";
		sql += "        CONCAT( MONTH(cast("+data+" as date)) , ':',YEAR(cast("+data+" as date)) ),\n";
		sql += "		"+this.getCentroCustoOrderBy();
		sql += "        '"+TIPO_CONTA_DESPESA+"',\n";       
		sql += "        CONCAT(ifnull(tipa.conta, '"+contaNullDespesa+"' ),ifnull(tipa.sub_conta, '"+contaNullDespesa+"'))\n";
		sql += getDetailGroupBy("tipa.dt_vencimento");		

		
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
	 * Retorna o sql para recupar os dados dos titulos pagos contas a receber.
	 * @param codEmpresa Codigo da Empresa
	 * @param data Data de Inicio
	 * @param dataFim Data fim
	 * @param naoListaTransferencias Indica se lista ou nao as transferências. 
	 * @param tipoGrupo Tipo de grupo que será considerado para o período a ser consultado.
	 * @return
	 */
	@Override
	protected String getSelectPago(String data, String dataFim, String tipoGrupo){
		String sql = "";
		
		sql += "-- ------------------------------------------------------\n";
		sql += "-- Contas a Pagar - títulos Pago\n";
		sql += "-- ------------------------------------------------------\n";	
		
		
		sql += "SELECT\n";
		sql += "        "+tipoGrupo+" as sequencia,	\n";
		sql += "        CONCAT( LPAD( MONTH(hist.dt_referencia), 2, '0' ) , ':',YEAR(hist.dt_referencia) )  mesRef,\n";
		sql += "		"+this.getCentroCusto();
		sql += "        '"+TIPO_CONTA_DESPESA+"' as tipoConta,\n";       
		sql += "        CONCAT(ifnull(tipa.conta, '"+contaNullDespesa+"' ),ifnull(tipa.sub_conta, '"+contaNullDespesa+"')) 	as conta,  		\n";
		sql += getDetailSelect("hist.dt_referencia");
		
		 
		sql += "        sum(ifnull(hist.vl_baixa * hist.vl_cotacao,0)  "+getCentroCustoPercRateio()+"  )  as valor\n";
		
		sql += "FROM  \n";
	    sql += "	fn_titulo_pagar  as tipa\n";
	    sql += getCentroCustoRateio();
	    sql += getPlanoConta();
		sql += "	INNER JOIN fn_titulo_pagar_hist hist\n";
		sql += "       ON\n";
		sql += "          hist.cod_empresa = tipa.cod_empresa\n";
		sql += "          AND\n";
		sql += "          hist.cod_titulo = tipa.cod_titulo\n";
		sql += "          AND\n";
		sql += "          hist.cod_parcela = tipa.cod_parcela\n";
		sql += "          AND\n";
		sql += "          hist.cod_fornecedor = tipa.cod_fornecedor\n";
		sql += "          AND\n";
		sql += "          hist.cod_especie = tipa.cod_especie\n";
		sql += " 	INNER JOIN fn_especie\n";
		sql += "       ON\n";
		sql += "             fn_especie.cod_especie = tipa.cod_especie\n";
		sql += " 	LEFT JOIN cd_fornecedor\n";
		sql += "      ON\n";
		sql += "         tipa.cod_fornecedor = cd_fornecedor.cod_fornecedor\n";
		sql += " 	LEFT JOIN sg_colaborador\n";
		sql += "      ON\n";
		sql += "         tipa.cod_colaborador = sg_colaborador.cod_colaborador\n";
		
		sql += " 	LEFT JOIN cd_forma_pagto\n";
		sql += "      ON\n";
		sql += "         cd_forma_pagto.cod_forma_pagto = hist.cod_forma_pagto\n";
		sql += " 	LEFT JOIN fn_cheque_terceiros\n";
		sql += "      ON hist.cod_cheque = fn_cheque_terceiros.cod_cheque\n";
		
        sql += "WHERE \n";
        sql += "	tipa.cod_empresa in ("+this.getCodEmpresa()+") \n";
        
        if ( isVerificaFlagBanco() ){
			sql += "	and exists( select 1 from cd_banco\n";
			sql += "	where \n";
			sql += "		cd_banco.cod_empresa 	= tipa.cod_empresa \n";
			sql += "		and \n";
			sql += "		cd_banco.cod_banco 		= tipa.cod_banco \n";
			sql += "		and \n";
			sql += "		cd_banco.ind_considera_result_financeiro = '1' \n";
			sql += ")\n";
		}
        
        if( !HowMGWTUtilities.isEmpty( this.getTpPlanoConta() ) && !"0".equals( this.getTpPlanoConta() ) ){
			sql += "		AND fn_plano_conta.tp_plano_conta = "+ this.getTpPlanoConta() + "\n";
		}
        
	    // Filtro por Centro de Custo - OC-38540
	    if ( !HowMGWTUtilities.isEmpty(this.getCcusto())){
	    	sql += "    "+this.getCcusto()+"\n";
		}
        
        sql += "	AND\n";
        sql += "	hist.tp_hist = 30 \n";
        sql += "	AND\n";
        sql += "	hist.dt_referencia >= "+data+"\n";
        sql += "	AND\n";
        sql += "	hist.dt_referencia <= "+dataFim+"\n"; 
        if ( naoListaTransferencias ){
	        sql += "	AND \n";
	        sql += "	( \n";
	        sql += "		tipa.cod_especie <> 97 \n";
	        sql += "	)\n"; 
        }
	    if ( this.isShowDetail()){
	    	if ( !HowMGWTUtilities.isEmpty(this.getContaContabil())){
		    	sql += "	AND\n";
		    	sql += "	CONCAT(ifnull(tipa.conta, '"+contaNullDespesa+"' ),ifnull(tipa.sub_conta, '"+contaNullDespesa+"')) = '"+this.getContaContabil()+"'\n";
	    	}
	    	if ( !HowMGWTUtilities.isEmpty(this.getMes())){
		    	sql += "	AND\n";
		    	sql += "	MONTH(hist.dt_referencia) = "+this.getMes()+"\n";		    	
		    	sql += "	AND\n";
		    	sql += "	YEAR(hist.dt_referencia) = "+this.getAno()+"\n";
	    	}
	    }         
        sql += "GROUP BY\n";
		sql += "        "+tipoGrupo+",\n";
		// sql += "        MONTH(hist.dt_referencia),\n";
		sql += "        CONCAT( MONTH(hist.dt_referencia) , ':',YEAR(hist.dt_referencia) ) ,\n";
		sql += "		"+this.getCentroCustoOrderBy();
		sql += "        '"+TIPO_CONTA_DESPESA+"',\n";       
		sql += "        CONCAT(ifnull(tipa.conta, '"+contaNullDespesa+"' ),ifnull(tipa.sub_conta, '"+contaNullDespesa+"'))\n";
        sql += this.getDetailGroupBy("hist.dt_referencia");
		return sql;
	}
	
	
	
	/**
	 * Retorna os titulos que estao vencendo em um determinado período
	 * @param data Data inicio que será realizada a consulta.
	 * @param dataFim Data fim 
	 * @param tipoGrupo Tipo de grupo que será apresentado os titulos em vencimento
	 * @return
	 */
	@Override
	protected String getSelectTitulosVencimento(String data, String dataFim, String tipoGrupo){
		String sql = "";

		sql += "-- ------------------------------------------------------\n";
		sql += "-- Contas a Pagar - títulos a Vencer (Previsão)\n";
		sql += "-- ------------------------------------------------------\n";	
		
		
		sql += "SELECT\n";
		sql += "        "+tipoGrupo+" as sequencia,	\n";
		sql += "        CONCAT( LPAD( MONTH(tipa.dt_vencimento), 2, '0' ) , ':',YEAR(tipa.dt_vencimento) )  mesRef,\n";
		sql += "		"+this.getCentroCusto();
		sql += "        '"+TIPO_CONTA_DESPESA+"' as tipoConta,\n";
		
		
		sql += "        CONCAT(ifnull(tipa.conta, '"+contaNullDespesa+"' ),ifnull(tipa.sub_conta, '"+contaNullDespesa+"')) 	as conta,  		\n";
		sql += getDetailSelect("tipa.dt_vencimento");
		
		if (EPlanoContas.grupoPervisao.equals(tipoGrupo)){
			sql += "        sum( calcularJurosPagar(tipa.cod_empresa,tipa.cod_titulo,tipa.cod_parcela,tipa.cod_fornecedor,tipa.cod_especie,cast("+data+" as date) , '1' ) "+getCentroCustoPercRateio()+" )  as valor\n";
		}		
		else{
			sql += "		SUM((\n"; 
			sql += "			( tipa.vl_total_titulo - tipa.vl_total_baixa - \n";
			sql += "      		(     ifnull( tipa.vl_iss , 0 )\n";
			sql += "	                + ifnull( tipa.vl_ir,0) \n";
			sql += "	                + ifnull( tipa.vl_pis, 0 ) \n";
			sql += "	                + ifnull( tipa.vl_cofins , 0 ) \n";
			sql += "	                + ifnull( tipa.vl_cs , 0 ) \n";
			sql += "            ) ) "+getCentroCustoPercRateio()+"\n";
			sql += "      	)  * getVlCotacao( tipa.cod_empresa, tipa.cod_titulo, tipa.cod_parcela, tipa.cod_fornecedor, tipa.cod_especie ) )   as valor\n";
			
		}		

		
		sql += "FROM\n";
	    sql += "	fn_titulo_pagar as tipa\n";
	    sql += getCentroCustoRateio();
	    sql += getPlanoConta();
	    sql += "WHERE\n";
	    sql += "	tipa.dt_vencimento  between "+data+"  and  "+dataFim+"\n";

	    if ( isVerificaFlagBanco() ){
	    	sql += "	and exists( select 1 from cd_banco\n";
			sql += "	where \n";
			sql += "		cd_banco.cod_empresa 	= tipa.cod_empresa \n";
			sql += "		and \n";
			sql += "		cd_banco.cod_banco 		= tipa.cod_banco \n";
			sql += "		and \n";
			sql += "		cd_banco.ind_considera_result_financeiro = '1' \n";
			sql += ")\n";
		}
	    
	    if( !HowMGWTUtilities.isEmpty( this.getTpPlanoConta() ) && !"0".equals( this.getTpPlanoConta() ) ){
			sql += "		AND fn_plano_conta.tp_plano_conta = "+ this.getTpPlanoConta() + "\n";
		}
	    
	    // Filtro por Centro de Custo - OC-38540
	    if ( !HowMGWTUtilities.isEmpty(this.getCcusto())){
	    	sql += "    "+this.getCcusto()+"\n";
		}
	    
	    sql += "	AND\n";
	    // OC: 39705 - restringe situações válidas ignorando alguamas situações conforme solicitado
	    sql += "	tipa.situacao < 30 \n";
	    if ( this.naoListaTransferencias ){
		    sql += "	AND\n";
		    sql += "	tipa.cod_especie <> 97 \n";
		}
	    if ( this.isShowDetail()){
	    	if ( ! HowMGWTUtilities.isEmpty(this.getContaContabil())){
		    	sql += "	AND\n";
		    	sql += "	CONCAT(ifnull(tipa.conta, '"+contaNullDespesa+"' ),ifnull(tipa.sub_conta, '"+contaNullDespesa+"')) = '"+this.getContaContabil()+"'\n";
	    	}
	    	if ( !HowMGWTUtilities.isEmpty(this.getMes())){
		    	sql += "	AND\n";
		    	sql += "	MONTH(tipa.dt_vencimento) = "+this.getMes()+"\n";
		    	sql += "	AND\n";
		    	sql += "	YEAR(tipa.dt_vencimento) = "+this.getAno()+"\n";
	    	}	   
	    }
		sql += "	AND\n";
	    sql += "	tipa.cod_empresa in ("+this.getCodEmpresa()+")\n";
	    sql += "GROUP BY\n";
		sql += "        "+tipoGrupo+",	\n";
		// sql += "        MONTH(tipa.dt_vencimento),\n";
		sql += "        CONCAT( MONTH(tipa.dt_vencimento) , ':',YEAR(tipa.dt_vencimento) ),\n";
		sql += "		"+this.getCentroCustoOrderBy();
		sql += "        '"+TIPO_CONTA_DESPESA+"',\n";       
		sql += "        CONCAT(ifnull(tipa.conta, '"+contaNullDespesa+"' ),ifnull(tipa.sub_conta, '"+contaNullDespesa+"'))\n";
	    sql += this.getDetailGroupBy("tipa.dt_vencimento");
	    return sql;
	}	
	
	
	/**
	 * @return Retorna o conjunto de sql para relacionamento com o rateio contas a pagar.
	 */
	@Override
	public String getCentroCustoRateio(){
		if ( this.isCCusto() || this.isShowCentroCusto() ){
			String sql = "";
			sql += "	LEFT JOIN fn_titulo_pagar_rateio \n";
			sql += "		ON \n";
			sql += "			fn_titulo_pagar_rateio.cod_titulo     = tipa.cod_titulo \n";
			sql += "			AND \n";
			sql += "			fn_titulo_pagar_rateio.cod_empresa    = tipa.cod_empresa \n";
			sql += "			AND \n";
			sql += "			fn_titulo_pagar_rateio.cod_parcela    = tipa.cod_parcela \n";
			sql += "			AND \n";
			sql += "			fn_titulo_pagar_rateio.cod_fornecedor = tipa.cod_fornecedor \n";
			sql += "			AND \n";
			sql += "			fn_titulo_pagar_rateio.cod_especie    = tipa.cod_especie \n";
			
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
	
	@Override
	public String getCentroCustoPercRateio(){
		if ( this.isCCusto() || this.isShowCentroCusto() )
			return " * ifnull(fn_titulo_pagar_rateio.perc_rateio,1) ";
		else
			return "";
	}
	
	/**
	 * Retorna os campos que serão inclusos no groyp by da consulta caso o showDetail esteja ligado.
	 * @return
	 */
	protected String getDetailSelect(String data){
	    if ( this.isShowDetail() ){
	    	String sql = "";
	    	sql += "	"+data+" as data,\n";
	    	sql += "	tipa.cod_titulo,\n";
	    	sql += "	tipa.cod_parcela,\n";
	    	sql += "	tipa.cod_fornecedor as pessoa, \n";
	    	sql += "	tipa.cod_especie as chave, \n";
	    	
	    	return sql;
	    }
	    return "";
	}
	
	
	
	/**
	 * Retorna os campos que serão inclusos no groyp by da consulta caso o showDetail esteja ligado.
	 * @return
	 */
	protected String getDetailGroupBy(String data){
	    if ( this.isShowDetail() ){
	    	String sql = "";
	    	sql += "    ,\n";
	    	sql += "	"+data+",\n";
	    	sql += "	tipa.cod_titulo,\n";
	    	sql += "	tipa.cod_parcela,\n";
	    	sql += "	tipa.cod_fornecedor, \n";
	    	sql += "	tipa.cod_especie\n";
	    	return sql;
	    }
	    return "";
	}

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
				HowMGWTUtilities.replace(modelo, "${FIELD}", " fn_titulo_pagar_rateio.ccusto  ")
				+
				" OR "
				+
				HowMGWTUtilities.replace(modelo, "${FIELD}", " tipa.ccusto ")
				+
			")";
		this.ccusto = " AND "+ccusto;
		
	}

	
	
 
	@Override
	public String getCentroCusto(){
		if( this.isCcustoSubstring3() ){
			if( this.isCCusto() || this.isShowCentroCusto() ){
				return "	replace(replace(substring( ifnull(ifnull(fn_titulo_pagar_rateio.ccusto,tipa.ccusto),'S/CC')  ,1,3),'.',''),'_','') as centroCusto,\n";
			}
			else{
				return "	substring( ifnull(tipa.ccusto,'S/CC')  ,1,3) as centroCusto,\n";
			}			
		}
		else{
			if( this.isCCusto() || this.isShowCentroCusto() ){
				return "	ifnull(ifnull(fn_titulo_pagar_rateio.ccusto,tipa.ccusto),'S/CC') as centroCusto,\n";
			}
			else{
				return "	ifnull(tipa.ccusto,'S/CC') as centroCusto,\n";
			}
		}
	}
	
	@Override
	public String getCentroCustoOrderBy(){
//		if( isCcustoSubstring3() ){
//			if( this.isCCusto() || this.isShowCentroCusto() ){
//				return "	replace(replace(substring( ifnull(ifnull(fn_titulo_pagar_rateio.ccusto,tipa.ccusto),'S/CC') ,1,3 ),'.',''),'_',''),\n";
//			}
//			else{
//				return "	substring( tipa.ccusto ,1,3 ) ,\n";
//			}			
//		}
//		else{
//			if( this.isCCusto() || this.isShowCentroCusto() ){
//				return "	ifnull(ifnull(fn_titulo_pagar_rateio.ccusto,tipa.ccusto),'S/CC'),\n";
//			}
//			else{
				return "	centroCusto,\n";
//			}
//		}
	};
	
}