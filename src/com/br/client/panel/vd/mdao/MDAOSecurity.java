package com.br.client.panel.vd.mdao;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.entity.eModulo;
import com.howmake.client.form.model.HOWMGWTDataSourceQuery;
import com.howmake.client.form.model.HowMGWTCall;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.shared.HowMGWTEntity;

public abstract class MDAOSecurity {	
	private eModulo modulo;
	public  MDAOSecurity(final String codModulo){
		modulo = new eModulo();
		
		modulo.setCorpo("001");
		
		String sql = "";
		sql += "select ";
		sql += "       corpo,  ";
		sql += "       cod_layout, "; 
		sql += "       nome_layout,  ";
		sql += "       sg_programa.tp_funcao,		   ";
		sql += "       sg_programa.comando,			   ";
		sql += "       sg_programa.nome_programa_en,   ";    
		sql += "       sg_programa.nome_programa_pt_BR ";
		sql += "from sg_programa  ";
		sql += "  	 left outer join sg_programa_empresa " ;
		sql += "     on	";
		sql += "		sg_programa_empresa.programa    = sg_programa.programa ";
		sql += " 		and ";
		sql += "		sg_programa_empresa.cod_empresa = "+Configuracao.getCodEmpresa()+" ";
		sql += "where ";
		sql += "	sg_programa.programa    = '"+codModulo+"' ";
		sql += "limit 1 ";
				
		HOWMGWTDataSourceQuery.executeQuery(sql, new HowMGWTCall() {
			
			@Override
			public void onSuccess(HowMGWTEntity result) {
				// Se não encontrar corpo cadastrado avalia que deverá apresentar struts ou gwt.
				if( result.getData().size() == 0 ){
					onFound(modulo);
				}
				else{
					String[] row = result.getData().get(0);
					
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
	
	protected abstract void onFound(eModulo modulo);
	
	protected abstract void onError();
 
}
