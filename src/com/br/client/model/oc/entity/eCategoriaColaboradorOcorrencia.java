package com.br.client.model.oc.entity;

public class eCategoriaColaboradorOcorrencia extends com.howmake.client.form.model.HowMGWTFormBean{
	public eCategoriaColaboradorOcorrencia(){
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getCodCategoria(){
		return toString("codCategoria");
	}

	public void setCodCategoria(String value){
		setString("codCategoria",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.oc.entity.eCategoriaColaboradorOcorrencia newInstance(){
		return new com.br.client.model.oc.entity.eCategoriaColaboradorOcorrencia();
	}
}