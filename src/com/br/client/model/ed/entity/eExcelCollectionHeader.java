package com.br.client.model.ed.entity;

public class eExcelCollectionHeader extends com.howmake.client.form.model.HowMGWTFormBean{
	public eExcelCollectionHeader(){
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
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "entityHeader".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eExcelHeader obj = com.br.client.model.ed.entity.eExcelHeader.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.ed.entity.eExcelCollectionHeader newInstance(){
		return new com.br.client.model.ed.entity.eExcelCollectionHeader();
	}
}