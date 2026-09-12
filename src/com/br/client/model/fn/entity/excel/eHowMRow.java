package com.br.client.model.fn.entity.excel;

public class eHowMRow extends com.howmake.client.form.model.HowMGWTFormBean{
	public eHowMRow(){
	}


	public com.br.client.model.fn.entity.excel.eHowMCell getDEFAULT_CELL(){
		Object obj = _self.get("DEFAULT_CELL");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.fn.entity.excel.eHowMCell)obj;

	}

	public void setDEFAULT_CELL(com.br.client.model.fn.entity.excel.eHowMCell value){
		_self.remove("DEFAULT_CELL");
		if ( value != null )
			_self.put("DEFAULT_CELL", value);

	}


	public String getHeader(){
		return toString("header");
	}

	public void setHeader(String value){
		setString("header",value);
	}


	public String getTotal(){
		return toString("total");
	}

	public void setTotal(String value){
		setString("total",value);
	}


	public com.br.client.model.fn.entity.excel.eHowMCell[] getCells(){
		Object obj = _self.get("cells");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.fn.entity.excel.eHowMCell[])obj;

	}

	public void setCells(com.br.client.model.fn.entity.excel.eHowMCell[] value){
		_self.remove("cells");
		if ( value != null )
			_self.put("cells", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "DEFAULT_CELL".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.excel.eHowMCell obj = new com.br.client.model.fn.entity.excel.eHowMCell();
			_self.put(name,obj);
		}
		if ( "cells".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.excel.eHowMCell[] obj = new com.br.client.model.fn.entity.excel.eHowMCell[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.fn.entity.excel.eHowMCell)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "DEFAULT_CELL".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.excel.eHowMCell obj = com.br.client.model.fn.entity.excel.eHowMCell.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "cells".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.excel.eHowMCell obj = com.br.client.model.fn.entity.excel.eHowMCell.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.fn.entity.excel.eHowMRow newInstance(){
		return new com.br.client.model.fn.entity.excel.eHowMRow();
	}
}