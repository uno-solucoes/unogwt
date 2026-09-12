package com.br.client.model.ed.entity;

public class eExcelHeader extends com.howmake.client.form.model.HowMGWTFormBean{
	public eExcelHeader(){
	}


	public String getColumnName(){
		return toString("columnName");
	}

	public void setColumnName(String value){
		setString("columnName",value);
	}


	public String getCell(){
		return toString("cell");
	}

	public void setCell(String value){
		setString("cell",value);
	}


	public String getType(){
		return toString("type");
	}

	public void setType(String value){
		setString("type",value);
	}


	public String getWidth(){
		return toString("width");
	}

	public void setWidth(String value){
		setString("width",value);
	}


	public String getBackground(){
		return toString("background");
	}

	public void setBackground(String value){
		setString("background",value);
	}


	public String getAlign(){
		return toString("align");
	}

	public void setAlign(String value){
		setString("align",value);
	}


	public String getColSpan(){
		return toString("colSpan");
	}

	public void setColSpan(String value){
		setString("colSpan",value);
	}


	public String getRowSpan(){
		return toString("rowSpan");
	}

	public void setRowSpan(String value){
		setString("rowSpan",value);
	}


	public String getId(){
		return toString("id");
	}

	public void setId(String value){
		setString("id",value);
	}


	public String getParentId(){
		return toString("parentId");
	}

	public void setParentId(String value){
		setString("parentId",value);
	}


	public String getForegroundPDF(){
		return toString("foregroundPDF");
	}

	public void setForegroundPDF(String value){
		setString("foregroundPDF",value);
	}


	public String getForegroundExcel(){
		return toString("foregroundExcel");
	}

	public void setForegroundExcel(String value){
		setString("foregroundExcel",value);
	}


	public String getControle(){
		return toString("controle");
	}

	public void setControle(String value){
		setString("controle",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.ed.entity.eExcelHeader newInstance(){
		return new com.br.client.model.ed.entity.eExcelHeader();
	}
}