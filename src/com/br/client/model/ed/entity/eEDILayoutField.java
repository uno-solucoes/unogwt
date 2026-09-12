package com.br.client.model.ed.entity;

public class eEDILayoutField extends com.howmake.client.form.model.HowMGWTFormBean{
	public eEDILayoutField(){
	}


	public String getIndex(){
		return toString("index");
	}

	public void setIndex(String value){
		setString("index",value);
	}


	public String getPrimaryKey(){
		return toString("primaryKey");
	}

	public void setPrimaryKey(String value){
		setString("primaryKey",value);
	}


	public String getName(){
		return toString("name");
	}

	public void setName(String value){
		setString("name",value);
	}


	public String getLabel(){
		return toString("label");
	}

	public void setLabel(String value){
		setString("label",value);
	}


	public String getType(){
		return toString("type");
	}

	public void setType(String value){
		setString("type",value);
	}


	public String getLength(){
		return toString("length");
	}

	public void setLength(String value){
		setString("length",value);
	}


	public String getDecimals(){
		return toString("decimals");
	}

	public void setDecimals(String value){
		setString("decimals",value);
	}


	public String getMandatory(){
		return toString("mandatory");
	}

	public void setMandatory(String value){
		setString("mandatory",value);
	}


	public String getMask(){
		return toString("mask");
	}

	public void setMask(String value){
		setString("mask",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.ed.entity.eEDILayoutField newInstance(){
		return new com.br.client.model.ed.entity.eEDILayoutField();
	}
}