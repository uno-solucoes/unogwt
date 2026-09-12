package com.br.client.model.fn.entity.excel;

public class eHowMWorksheet extends com.howmake.client.form.model.HowMGWTFormBean{
	public eHowMWorksheet(){
	}


	public String getFileName(){
		return toString("fileName");
	}

	public void setFileName(String value){
		setString("fileName",value);
	}


	public com.br.client.model.fn.entity.excel.eHowMRow[] getRows(){
		Object obj = _self.get("rows");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.fn.entity.excel.eHowMRow[])obj;

	}

	public void setRows(com.br.client.model.fn.entity.excel.eHowMRow[] value){
		_self.remove("rows");
		if ( value != null )
			_self.put("rows", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "rows".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.excel.eHowMRow[] obj = new com.br.client.model.fn.entity.excel.eHowMRow[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.fn.entity.excel.eHowMRow)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "rows".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.excel.eHowMRow obj = com.br.client.model.fn.entity.excel.eHowMRow.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.fn.entity.excel.eHowMWorksheet newInstance(){
		return new com.br.client.model.fn.entity.excel.eHowMWorksheet();
	}
}