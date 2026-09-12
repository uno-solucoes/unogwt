package com.br.client.model.ed.entity;

public class eExcelSheet extends com.howmake.client.form.model.HowMGWTFormBean{
	public eExcelSheet(){
	}


	public String getName(){
		return toString("name");
	}

	public void setName(String value){
		setString("name",value);
	}


	public String getIndex(){
		return toString("index");
	}

	public void setIndex(String value){
		setString("index",value);
	}


	public com.br.client.model.ed.entity.eExcelHeader[] getEntityHeader(){
		Object obj = _self.get("entityHeader");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eExcelHeader[])obj;

	}

	public void setEntityHeader(com.br.client.model.ed.entity.eExcelHeader[] value){
		_self.remove("entityHeader");
		if ( value != null )
			_self.put("entityHeader", value);

	}


	public com.br.client.model.ed.entity.eExcelCollectionHeader[] getEntityHeaders(){
		Object obj = _self.get("entityHeaders");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eExcelCollectionHeader[])obj;

	}

	public void setEntityHeaders(com.br.client.model.ed.entity.eExcelCollectionHeader[] value){
		_self.remove("entityHeaders");
		if ( value != null )
			_self.put("entityHeaders", value);

	}


	public com.br.client.model.ed.entity.eExcelRow[] getEntityRows(){
		Object obj = _self.get("entityRows");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eExcelRow[])obj;

	}

	public void setEntityRows(com.br.client.model.ed.entity.eExcelRow[] value){
		_self.remove("entityRows");
		if ( value != null )
			_self.put("entityRows", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "entityHeader".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eExcelHeader[] obj = new com.br.client.model.ed.entity.eExcelHeader[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.ed.entity.eExcelHeader)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "entityHeaders".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eExcelCollectionHeader[] obj = new com.br.client.model.ed.entity.eExcelCollectionHeader[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.ed.entity.eExcelCollectionHeader)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "entityRows".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eExcelRow[] obj = new com.br.client.model.ed.entity.eExcelRow[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.ed.entity.eExcelRow)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "entityHeader".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eExcelHeader obj = com.br.client.model.ed.entity.eExcelHeader.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityHeaders".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eExcelCollectionHeader obj = com.br.client.model.ed.entity.eExcelCollectionHeader.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityRows".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eExcelRow obj = com.br.client.model.ed.entity.eExcelRow.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.ed.entity.eExcelSheet newInstance(){
		return new com.br.client.model.ed.entity.eExcelSheet();
	}
}