package com.br.client.model.oc.entity;

public class eCategoriaProblemaOcorrencia extends com.howmake.client.form.model.HowMGWTFormBean{
	public eCategoriaProblemaOcorrencia(){
	}


	public String getCodProblema(){
		return toString("codProblema");
	}

	public void setCodProblema(String value){
		setString("codProblema",value);
	}


	public String getCodCategoria(){
		return toString("codCategoria");
	}

	public void setCodCategoria(String value){
		setString("codCategoria",value);
	}


	public String getPrioridade(){
		return toString("prioridade");
	}

	public void setPrioridade(String value){
		setString("prioridade",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.oc.entity.eCategoriaProblemaOcorrencia newInstance(){
		return new com.br.client.model.oc.entity.eCategoriaProblemaOcorrencia();
	}
}