package com.br.client.model.vd.entity;

public class eNFSEEstatisticas extends com.howmake.client.form.model.HowMGWTFormBean{
	public eNFSEEstatisticas(){
	}


	public String getLabel(){
		return toString("label");
	}

	public void setLabel(String value){
		setString("label",value);
	}


	public String getValue(){
		return toString("value");
	}

	public void setValue(String value){
		setString("value",value);
	}


	public String getValue1(){
		return toString("value1");
	}

	public void setValue1(String value){
		setString("value1",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.eNFSEEstatisticas newInstance(){
		return new com.br.client.model.vd.entity.eNFSEEstatisticas();
	}
}