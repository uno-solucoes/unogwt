package com.br.client.model.sg.entity;

public class eVersaoLiberada extends com.howmake.client.form.model.HowMGWTFormBean{
	public eVersaoLiberada(){
	}


	public String getSistema(){
		return toString("sistema");
	}

	public void setSistema(String value){
		setString("sistema",value);
	}


	public String getDataLiberacao(){
		return toString("dataLiberacao");
	}

	public void setDataLiberacao(String value){
		setString("dataLiberacao",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getVersao(){
		return toString("versao");
	}

	public void setVersao(String value){
		setString("versao",value);
	}


	public String getCriticidade(){
		return toString("criticidade");
	}

	public void setCriticidade(String value){
		setString("criticidade",value);
	}


	public String getSlideImage(){
		return toString("slideImage");
	}

	public void setSlideImage(String value){
		setString("slideImage",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.sg.entity.eVersaoLiberada newInstance(){
		return new com.br.client.model.sg.entity.eVersaoLiberada();
	}
}