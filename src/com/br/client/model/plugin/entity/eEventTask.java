package com.br.client.model.plugin.entity;

public class eEventTask extends com.howmake.client.form.model.HowMGWTFormBean{
	public eEventTask(){
	}


	public String getFeriado(){
		return toString("feriado");
	}

	public void setFeriado(String value){
		setString("feriado",value);
	}


	public String getCanEdit(){
		return toString("canEdit");
	}

	public void setCanEdit(String value){
		setString("canEdit",value);
	}


	public String getId(){
		return toString("id");
	}

	public void setId(String value){
		setString("id",value);
	}


	public String getGoogleID(){
		return toString("googleID");
	}

	public void setGoogleID(String value){
		setString("googleID",value);
	}


	public String getTitulo(){
		return toString("titulo");
	}

	public void setTitulo(String value){
		setString("titulo",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getDataFim(){
		return toString("dataFim");
	}

	public void setDataFim(String value){
		setString("dataFim",value);
	}


	public String getDataInicio(){
		return toString("dataInicio");
	}

	public void setDataInicio(String value){
		setString("dataInicio",value);
	}


	public String getRecursivaData(){
		return toString("recursivaData");
	}

	public void setRecursivaData(String value){
		setString("recursivaData",value);
	}


	public String getOnde(){
		return toString("onde");
	}

	public void setOnde(String value){
		setString("onde",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.plugin.entity.eEventTask newInstance(){
		return new com.br.client.model.plugin.entity.eEventTask();
	}
}