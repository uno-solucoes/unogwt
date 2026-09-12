package com.br.client.panel.business.UI;

import java.util.LinkedHashMap;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.Services;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.howmake.client.form.UI.HowMGWTSelectItem;
import com.howmake.shared.HowMGWTEntity;

public class UCFieldSituacaoCliente extends HowMGWTSelectItem{

	private LinkedHashMap< String, String > situacoes = new LinkedHashMap<String, String>();
	
	public UCFieldSituacaoCliente(){
		this.getField().setName("situacaoCliente");
		this.getField().setTitle(Tradutor.i18n.formSituacao() );
	}
	
	public void start(){
		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				com.google.gwt.user.client.Window.alert(Tradutor.i18n.formEnderecoBase()+": "+GWT.getHostPageBaseURL()+"\n"+caught.getMessage());
			}

			public void onSuccess(HowMGWTEntity result) {
				  showResult(result);
			}
		};

		HowMGWTEntity entity = Fabrica.createEntity();
		entity.setAction("");
				
		
		entity.setAction(Services.acaoListaSituacoesCliente);
		Configuracao.getProxyStruts().executeQuery(entity, callback);			
	}
	
	/**
	 * Apresenta o resultado das situacoes que o cliente possui.
	 * @param result
	 */
	public void showResult(HowMGWTEntity result){
		System.out.println(result);
		this.situacoes.clear();
		
		String[] keys = new String[result.getData().size()];
		int i = 0;
		for ( String[] row : result.getData() ){
			situacoes.put(row[0], row[1]);
			keys[i] = row[0];
			i ++;
		}
		this.getField().setValueMap(keys);
		getField().setDefaultValue(Tradutor.i18n.formTodos());
	}

	public String getValueAsString(){
		if ( "Todos".equalsIgnoreCase(this.situacoes.get(this.getField().getValueAsString()) )) 
				return "";
		
		return this.situacoes.get(this.getField().getValueAsString());
	}
}