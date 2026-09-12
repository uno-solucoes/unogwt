package com.br.client.model.at.entity;

public class eTipoLocal extends com.howmake.client.form.model.HowMGWTFormBean{
	public eTipoLocal(){
	}


	public String getCodTipoLocal(){
		return toString("codTipoLocal");
	}

	public void setCodTipoLocal(String value){
		setString("codTipoLocal",value);
	}


	public String getDescricaoAbreviada(){
		return toString("descricaoAbreviada");
	}

	public void setDescricaoAbreviada(String value){
		setString("descricaoAbreviada",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.at.entity.eTipoLocal newInstance(){
		return new com.br.client.model.at.entity.eTipoLocal();
	}
}