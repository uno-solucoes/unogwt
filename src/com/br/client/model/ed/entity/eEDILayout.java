package com.br.client.model.ed.entity;

public class eEDILayout extends com.howmake.client.form.model.HowMGWTFormBean{
	public eEDILayout(){
	}


	public String getDelimiter(){
		return toString("delimiter");
	}

	public void setDelimiter(String value){
		setString("delimiter",value);
	}


	public String getRowStartRead(){
		return toString("rowStartRead");
	}

	public void setRowStartRead(String value){
		setString("rowStartRead",value);
	}


	public String getTableName(){
		return toString("tableName");
	}

	public void setTableName(String value){
		setString("tableName",value);
	}


	public String getTableTitle(){
		return toString("tableTitle");
	}

	public void setTableTitle(String value){
		setString("tableTitle",value);
	}


	public String getClassValidate(){
		return toString("classValidate");
	}

	public void setClassValidate(String value){
		setString("classValidate",value);
	}


	public com.br.client.model.ed.entity.eEDILayoutField[] getFields(){
		Object obj = _self.get("fields");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eEDILayoutField[])obj;

	}

	public void setFields(com.br.client.model.ed.entity.eEDILayoutField[] value){
		_self.remove("fields");
		if ( value != null )
			_self.put("fields", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "fields".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDILayoutField[] obj = new com.br.client.model.ed.entity.eEDILayoutField[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.ed.entity.eEDILayoutField)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "fields".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDILayoutField obj = com.br.client.model.ed.entity.eEDILayoutField.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.ed.entity.eEDILayout newInstance(){
		return new com.br.client.model.ed.entity.eEDILayout();
	}
}