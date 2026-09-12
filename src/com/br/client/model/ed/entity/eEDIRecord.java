package com.br.client.model.ed.entity;

public class eEDIRecord extends com.howmake.client.form.model.HowMGWTFormBean{
	public eEDIRecord(){
	}


	public String getTipoErro(){
		return toString("tipoErro");
	}

	public void setTipoErro(String value){
		setString("tipoErro",value);
	}


	public String getCanEdit(){
		return toString("canEdit");
	}

	public void setCanEdit(String value){
		setString("canEdit",value);
	}


	public String getMsg(){
		return toString("msg");
	}

	public void setMsg(String value){
		setString("msg",value);
	}


	public String getIgnoreSave(){
		return toString("ignoreSave");
	}

	public void setIgnoreSave(String value){
		setString("ignoreSave",value);
	}


	public java.lang.String[] getRowData(){
		Object obj = _self.get("rowData");
		if ( obj == null )
			return null;
		else
			return (java.lang.String[])obj;

	}

	public void setRowData(java.lang.String[] value){
		_self.remove("rowData");
		if ( value != null )
			_self.put("rowData", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "rowData".equalsIgnoreCase(name) ){
			java.lang.String[] obj = new java.lang.String[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isString()!= null )
					obj[i] = object.isString().stringValue();
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.ed.entity.eEDIRecord newInstance(){
		return new com.br.client.model.ed.entity.eEDIRecord();
	}
}