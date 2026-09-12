package com.br.client.panel.fn.fnw0223.model;

import java.util.Date;

import com.howmake.client.form.partner.HowMGWTUtilities;

public class PlanoContasModelContasPagar extends PlanoContasModel{

	/**
	 * Permite recupera os sql para consultar no banco de dados os dados para montar o balancete contas a pagar.
	 * @param periodoInicio
	 * @param periodoFim
	 * @param dataReferencia
	 * @param dataReferenciaAtrasos
	 * @param naoListaTransferencias
	 */
	public PlanoContasModelContasPagar( Date periodoInicio, Date periodoFim,  boolean showCentroCusto, boolean ccustoSubstring3){
		super(periodoInicio, periodoFim,  showCentroCusto ,ccustoSubstring3);
	}
	
 
  
	/**
	 * Retorna os títulos que estão vencendo em um determinado período
	 * @param dataInicio Data inicio que será realizada a consulta.
	 * @param dataFim Data fim 
	 * @param tipoGrupo Tipo de grupo que será apresentado os títulos em vencimento
	 * @return
	 */
	@Override
	protected String getSelectTitulosVencimento(String dataInicio, String dataFim, String tipoGrupo){
		String sql = "";

		sql += "SELECT\n";
		sql += "        "+tipoGrupo+" as sequencia,	\n";
		sql += "        CONCAT( MONTH(tipa.dt_emissao) , ':',YEAR(tipa.dt_emissao) )  mesRef,\n";
		sql += "		"+this.getCentroCusto();
		sql += "        '"+TIPO_CONTA_DESPESA+"' as tipoConta,\n";       
		sql += "        CONCAT(ifnull(tipa.conta, '"+contaNullDespesa+"' ),ifnull(tipa.sub_conta, '"+contaNullDespesa+"')) 	as conta,  		\n";
		sql += getDetailSelect("tipa.dt_emissao");
		sql += "		SUM(\n"; 
		sql += "			( tipa.vl_total_titulo - tipa.vl_total_baixa -  \n";
		sql += "      		(     ifnull( tipa.vl_iss , 0 )\n";
		sql += "	                + ifnull( tipa.vl_ir,0) \n";
		sql += "	                + ifnull( tipa.vl_pis, 0 ) \n";
		sql += "	                + ifnull( tipa.vl_cofins , 0 ) \n";
		sql += "	                + ifnull( tipa.vl_cs , 0 ) \n";
		sql += "            ) ) "+getCentroCustoPercRateio()+"\n";
		sql += "      	)  as valor  \n";
		sql += "FROM\n";
	    sql += "	fn_titulo_pagar as tipa\n";
		if ( isVerificaFlagBanco() ){
			sql += "	LEFT JOIN cd_banco \n";
			sql += "	on\n";
			sql += "		cd_banco.cod_empresa 	= tipa.cod_empresa \n";
			sql += "		and \n";
			sql += "		cd_banco.cod_banco 		= tipa.cod_banco \n";
		}   
	    sql += getCentroCustoRateio();
	    sql += "WHERE\n";
	    sql += "	tipa.dt_emissao between  "+dataInicio+"  and  "+dataFim+"\n";
	    
	    if ( isVerificaFlagBanco() ){
			sql += "		and \n";
			sql += "		cd_banco.ind_considera_result_financeiro = '1' \n";
		}
	    
	    // Filtro por Centro de Custo - OC-38540
	    if ( !HowMGWTUtilities.isEmpty(this.getCcusto())){
	    	sql += "    "+this.getCcusto()+"\n";
		}
	    
	    sql += "	AND\n";
	    // OC: 39705 - restringe situações válidas ignorando alguamas situações conforme solicitado
	    sql += "	tipa.situacao IN( 5,10,15,20,30,95,100 )\n";
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
		    	sql += "	MONTH(tipa.dt_emissao) = "+this.getMes()+"\n";
		    	sql += "	AND\n";
		    	sql += "	YEAR(tipa.dt_emissao) = "+this.getAno()+"\n";
	    	}	   
	    }
		sql += "	AND\n";
	    sql += "	tipa.cod_empresa in ("+this.getCodEmpresa()+")\n";
	    sql += "GROUP BY\n";
		sql += "        "+tipoGrupo+",	\n";
		sql += "        CONCAT( MONTH(tipa.dt_emissao) , ':',YEAR(tipa.dt_emissao) ),\n";
		sql += "		"+this.getCentroCustoOrderBy();
		sql += "        '"+TIPO_CONTA_DESPESA+"',\n";       
		sql += "        CONCAT(ifnull(tipa.conta, '"+contaNullDespesa+"' ),ifnull(tipa.sub_conta, '"+contaNullDespesa+"'))\n";
	    sql += this.getDetailGroupBy("tipa.dt_emissao");
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
		if( isCcustoSubstring3() ){
			if( this.isCCusto() || this.isShowCentroCusto() ){
				return "	replace(replace(substring( ifnull(ifnull(fn_titulo_pagar_rateio.ccusto,tipa.ccusto),'S/CC') ,1,3 ),'.',''),'_',''),\n";
			}
			else{
				return "	substring( tipa.ccusto ,1,3 ) ,\n";
			}			
		}
		else{
			if( this.isCCusto() || this.isShowCentroCusto() ){
				return "	ifnull(ifnull(fn_titulo_pagar_rateio.ccusto,tipa.ccusto),'S/CC'),\n";
			}
			else{
				return "	tipa.ccusto,\n";
			}
		}
	};
	
}