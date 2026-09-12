package com.br.client.model.ed.entity;

public class eExcelRow extends com.howmake.client.form.model.HowMGWTFormBean{
	public eExcelRow(){
	}


	public String getRowNum(){
		return toString("rowNum");
	}

	public void setRowNum(String value){
		setString("rowNum",value);
	}


	public com.br.client.model.ed.entity.eExcelCell[] getCells(){
		Object obj = _self.get("cells");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eExcelCell[])obj;

	}

	public void setCells(com.br.client.model.ed.entity.eExcelCell[] value){
		_self.remove("cells");
		if ( value != null )
			_self.put("cells", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "cells".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eExcelCell[] obj = new com.br.client.model.ed.entity.eExcelCell[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.ed.entity.eExcelCell)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "cells".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eExcelCell obj = com.br.client.model.ed.entity.eExcelCell.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.ed.entity.eExcelRow newInstance(){
		return new com.br.client.model.ed.entity.eExcelRow();
	}
}