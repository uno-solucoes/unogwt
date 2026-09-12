package com.br.client.model.ed.entity;

public class eExcelWorksheet extends com.howmake.client.form.model.HowMGWTFormBean{
	public eExcelWorksheet(){
	}


	public String getFileName(){
		return toString("fileName");
	}

	public void setFileName(String value){
		setString("fileName",value);
	}


	public String getTitle(){
		return toString("title");
	}

	public void setTitle(String value){
		setString("title",value);
	}


	public String getDtVigenciaInicio(){
		return toString("dtVigenciaInicio");
	}

	public void setDtVigenciaInicio(String value){
		setString("dtVigenciaInicio",value);
	}


	public String getDtVigenciaFim(){
		return toString("dtVigenciaFim");
	}

	public void setDtVigenciaFim(String value){
		setString("dtVigenciaFim",value);
	}


	public String getParentKey(){
		return toString("parentKey");
	}

	public void setParentKey(String value){
		setString("parentKey",value);
	}


	public String getType(){
		return toString("type");
	}

	public void setType(String value){
		setString("type",value);
	}


	public com.br.client.model.ed.entity.eExcelSheet[] getEntitySheets(){
		Object obj = _self.get("entitySheets");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eExcelSheet[])obj;

	}

	public void setEntitySheets(com.br.client.model.ed.entity.eExcelSheet[] value){
		_self.remove("entitySheets");
		if ( value != null )
			_self.put("entitySheets", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "entitySheets".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eExcelSheet[] obj = new com.br.client.model.ed.entity.eExcelSheet[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.ed.entity.eExcelSheet)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "entitySheets".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eExcelSheet obj = com.br.client.model.ed.entity.eExcelSheet.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.ed.entity.eExcelWorksheet newInstance(){
		return new com.br.client.model.ed.entity.eExcelWorksheet();
	}
}