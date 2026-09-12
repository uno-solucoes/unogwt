package com.br.client.model.vd.entity;

public class eNFSEConsultaParametrosWS extends com.howmake.client.form.model.HowMGWTFormBean{
	public eNFSEConsultaParametrosWS(){
	}


	public String getDsValor(){
		return toString("dsValor");
	}

	public void setDsValor(String value){
		setString("dsValor",value);
	}


	public String getNmParametro(){
		return toString("nmParametro");
	}

	public void setNmParametro(String value){
		setString("nmParametro",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.eNFSEConsultaParametrosWS newInstance(){
		return new com.br.client.model.vd.entity.eNFSEConsultaParametrosWS();
	}
}