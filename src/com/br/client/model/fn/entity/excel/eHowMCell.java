package com.br.client.model.fn.entity.excel;

public class eHowMCell extends com.howmake.client.form.model.HowMGWTFormBean{
	public eHowMCell(){
	}


	public String getRow(){
		return toString("row");
	}

	public void setRow(String value){
		setString("row",value);
	}


	public String getCol(){
		return toString("col");
	}

	public void setCol(String value){
		setString("col",value);
	}


	public String getBackgroundColor(){
		return toString("backgroundColor");
	}

	public void setBackgroundColor(String value){
		setString("backgroundColor",value);
	}


	public String getMargin(){
		return toString("margin");
	}

	public void setMargin(String value){
		setString("margin",value);
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


	public String getAlign(){
		return toString("align");
	}

	public void setAlign(String value){
		setString("align",value);
	}


	public String getFormat(){
		return toString("format");
	}

	public void setFormat(String value){
		setString("format",value);
	}


	public String getDecimals(){
		return toString("decimals");
	}

	public void setDecimals(String value){
		setString("decimals",value);
	}


	public String getFontType(){
		return toString("fontType");
	}

	public void setFontType(String value){
		setString("fontType",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.fn.entity.excel.eHowMCell newInstance(){
		return new com.br.client.model.fn.entity.excel.eHowMCell();
	}
}