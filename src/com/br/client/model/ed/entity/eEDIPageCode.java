package com.br.client.model.ed.entity;

public class eEDIPageCode extends com.howmake.client.form.model.HowMGWTFormBean{
	public eEDIPageCode(){
	}


	public String getPageCode(){
		return toString("pageCode");
	}

	public void setPageCode(String value){
		setString("pageCode",value);
	}


	public String getPageTitle(){
		return toString("pageTitle");
	}

	public void setPageTitle(String value){
		setString("pageTitle",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.ed.entity.eEDIPageCode newInstance(){
		return new com.br.client.model.ed.entity.eEDIPageCode();
	}
}