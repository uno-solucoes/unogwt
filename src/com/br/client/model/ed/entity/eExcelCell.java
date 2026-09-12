package com.br.client.model.ed.entity;

public class eExcelCell extends com.howmake.client.form.model.HowMGWTFormBean{
	public eExcelCell(){
	}


	public String getBold(){
		return toString("bold");
	}

	public void setBold(String value){
		setString("bold",value);
	}


	public String getBackground(){
		return toString("background");
	}

	public void setBackground(String value){
		setString("background",value);
	}


	public String getValue(){
		return toString("value");
	}

	public void setValue(String value){
		setString("value",value);
	}


	public String getType(){
		return toString("type");
	}

	public void setType(String value){
		setString("type",value);
	}


	public String getPrintZero(){
		return toString("printZero");
	}

	public void setPrintZero(String value){
		setString("printZero",value);
	}


	public String getAlign(){
		return toString("align");
	}

	public void setAlign(String value){
		setString("align",value);
	}


	public String getIndent(){
		return toString("indent");
	}

	public void setIndent(String value){
		setString("indent",value);
	}


	public String getTotalizador(){
		return toString("totalizador");
	}

	public void setTotalizador(String value){
		setString("totalizador",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.ed.entity.eExcelCell newInstance(){
		return new com.br.client.model.ed.entity.eExcelCell();
	}
}