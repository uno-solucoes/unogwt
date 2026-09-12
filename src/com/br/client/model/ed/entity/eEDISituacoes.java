package com.br.client.model.ed.entity;

public class eEDISituacoes extends com.howmake.client.form.model.HowMGWTFormBean{
	public eEDISituacoes(){
	}


	public String getCodSituacao(){
		return toString("codSituacao");
	}

	public void setCodSituacao(String value){
		setString("codSituacao",value);
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


	public static final com.br.client.model.ed.entity.eEDISituacoes newInstance(){
		return new com.br.client.model.ed.entity.eEDISituacoes();
	}
}