package com.br.client.panel.vd.mdao;

import com.br.client.configuracao.Configuracao;
import com.br.client.panel.vd.entity.eModuloVDQ0002;
import com.howmake.client.form.model.HOWMGWTDataSourceQuery;
import com.howmake.client.form.model.HowMGWTCall;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.shared.HowMGWTEntity;

public abstract class MDAOSecurityVDQ0002 {	
	private eModuloVDQ0002 modulo;
	public  MDAOSecurityVDQ0002(final String codModulo){
		
		eModuloVDQ0002.getMAPCotacoes().clear();
		
		modulo = new eModuloVDQ0002();
		
		modulo.setCorpo("0001");
		modulo.setIndBuscaAproximadaProduto(true);
		modulo.setIndBuscaMultiplaProduto(true);
		String sql = "";
		sql += "select \n";
		sql += "       corpo,  \n";
		sql += "       cod_layout, \n"; 
		sql += "       nome_layout,  \n";
		sql += "       sg_programa.tp_funcao,		   \n";
		sql += "       sg_programa.comando,			   \n";
		sql += "       sg_programa.nome_programa_en,   \n";    
		sql += "       sg_programa.nome_programa_pt_BR,\n";
		sql += "	   'modulo' as tipo				   \n";
		sql += "from sg_programa  \n";
		sql += "  	 left outer join sg_programa_empresa \n" ;
		sql += "     on	\n";
		sql += "		sg_programa_empresa.programa    = sg_programa.programa \n";
		sql += " 		and \n";
		sql += "		sg_programa_empresa.cod_empresa = "+Configuracao.getCodEmpresa()+" \n";
		sql += "where ";
		sql += "	sg_programa.programa    = '"+codModulo+"' \n";
		sql += "union\n";
		sql += "select \n";
		sql += "	cd_param_empresa.valor as corpo,\n";
		sql += "	'' as cod_layout, \n";
		sql += "	'' as nome_layout, \n";
		sql += "	'' as tp_funcao, \n";
		sql += "	cd_param_empresa.nome_param as comando, \n";
		sql += "    '' as nome_programa_en, \n";
		sql += "	'' as nome_programa_pt_BR, \n";
		sql += "	'param' as tipo \n";
		sql += "from  \n";
		sql += "     cd_param_empresa  \n";
		sql += "where  \n";
		sql += "      cd_param_empresa.nome_param in ('indBuscaAproximadaProduto','indBuscaMultiplaProduto','qtdCasasDecimaisQtdProduto', 'qtdCasasDecimaisPrecoUnitProduto', 'tbPrecoPadrao')  \n";
		sql += "      and   \n";    
		sql += "      cod_empresa =  "+Configuracao.getCodEmpresa()+" \n";
		sql += "union\n";
		sql += "SELECT \n";
	    sql += " 	cd_moeda_cotacao.vl_cotacao, \n";
	    sql += "	'', \n";
	    sql += "	'', \n";
	    sql += "	'', \n";
	    sql += "	cd_moeda_cotacao.moeda, \n";
	    sql += "	'', \n";
	    sql += "	'', \n";
	    sql += "	'moeda' \n";
	    sql += "FROM \n";
	    sql += "	cd_moeda_cotacao inner join \n";
	    sql += "	( \n";
	    sql += "		select  \n";
	    sql += "			moeda, max(dt_cotacao) as dtCotacao \n";
	    sql += "		from  \n";
	    sql += "			cd_moeda_cotacao  \n";
	    sql += "		group by \n";
	    sql += "			moeda \n";
	    sql += "	) as cotacaoDistinct \n";
	    sql += "	ON \n";
	    sql += "		cotacaoDistinct.moeda     = cd_moeda_cotacao.moeda  \n";
	    sql += "		and \n";
	    sql += "		cotacaoDistinct.dtCotacao = cd_moeda_cotacao.dt_cotacao  \n";
	    sql += "		and  \n";
	    sql += "		dt_cotacao <= now() \n";
		
		
		
		
		HOWMGWTDataSourceQuery.executeQuery(sql, new HowMGWTCall() {
			
			@Override
			public void onSuccess(HowMGWTEntity result) {
				// Se não encontrar corpo cadastrado avalia que deverá apresentar struts ou gwt.
				if( result.getData().size() == 0 ){
					onFound(modulo);
					return;
				}
				else{					
					for ( String row[] : result.getData() ){
						if ( "moeda".equals( row[7] ) ){
							eModuloVDQ0002.getMAPCotacoes().put(row[4], HowMGWTUtilities.getObjectDouble(row[0]));
						}
						else if ( "modulo".equals( row[7] ) ){
							modulo.setCorpo(row[0]);
							modulo.setCodLayout(row[1]);
							modulo.setNomeLayout(row[2]);
							modulo.setTpFuncao(row[3]);
							modulo.setComando(row[4]);
							modulo.setNomeProgramaEnEN(row[5]);
							modulo.setNomeProgramaPtBR(row[6]);	
					
							// Se corpo for null ou branco seta para 001 - Corpo padrão
							if ( HowMGWTUtilities.isEmpty(modulo.getCorpo()) )
								modulo.setCorpo("001");
						}
						else if ( "param".equals(row[7])){
							
							if ( "indBuscaAproximadaProduto".equals(row[4] )){
								if( "1".equals(row[0]) )
									modulo.setIndBuscaAproximadaProduto(true);
								else
									modulo.setIndBuscaAproximadaProduto(false);
							}
							else if ( "indBuscaMultiplaProduto".equals(row[4]) ){
								if( "1".equals(row[0]) )
									modulo.setIndBuscaMultiplaProduto(true);
								else
									modulo.setIndBuscaMultiplaProduto(false);
							}
							else if ( "qtdCasasDecimaisQtdProduto".equals(row[4])){
								eModuloVDQ0002.PARAM_qtdCasasDecimaisQtdProduto = HowMGWTUtilities.getInteger(row[0]);
							}
							else if ( "qtdCasasDecimaisPrecoUnitProduto".equals(row[4])){
								eModuloVDQ0002.PARAM_qtdCasasDecimaisPrecoUnitProduto = HowMGWTUtilities.getInteger(row[0]);
							}
							else if ( "tbPrecoPadrao".equals(row[4])){
								if ( ! HowMGWTUtilities.isEmpty( row[0] ) )
								eModuloVDQ0002.PARAM_TabelaPrecoPadrao = row[0];
							}
						}
					}
					// 05/04/2012 - 10:37
					// Fixado a pedido do Marcio, somente para a Morelate.
					// Seria melhor corrigir o erro no UCommerce em Valida Formatos
					// do que fixar em zero no programa.
					if ( "0002".equals( modulo.getCorpo()) )
						eModuloVDQ0002.PARAM_qtdCasasDecimaisQtdProduto = 0;
					onFound(modulo);
				}
			}
			
			@Override
			public boolean onFailure(Throwable caught) {
				modulo = null;
				onError();
				return false;
			}
		});		
	}
	
	protected abstract void onFound(eModuloVDQ0002 modulo);
	
	protected abstract void onError();
 
}
