package com.br.client.model.fn.entity;

public class eCenario extends com.howmake.client.form.model.HowMGWTFormBean{
	public eCenario(){
	}


	public String getCenario(){
		return toString("cenario");
	}

	public void setCenario(String value){
		setString("cenario",value);
	}


	public String getNome(){
		return toString("nome");
	}

	public void setNome(String value){
		setString("nome",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.fn.entity.eCenario newInstance(){
		return new com.br.client.model.fn.entity.eCenario();
	}
}