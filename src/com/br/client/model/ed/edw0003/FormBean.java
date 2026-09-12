package com.br.client.model.ed.edw0003;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public String getFileName(){
		return toString("fileName");
	}

	public void setFileName(String value){
		setString("fileName",value);
	}


	public String getLayoutName(){
		return toString("layoutName");
	}

	public void setLayoutName(String value){
		setString("layoutName",value);
	}


	public String getPathTemp(){
		return toString("pathTemp");
	}

	public void setPathTemp(String value){
		setString("pathTemp",value);
	}


	public com.br.client.model.ed.entity.eEDILayout[] getLayouts(){
		Object obj = _self.get("layouts");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eEDILayout[])obj;

	}

	public void setLayouts(com.br.client.model.ed.entity.eEDILayout[] value){
		_self.remove("layouts");
		if ( value != null )
			_self.put("layouts", value);

	}


	public com.br.client.model.ed.entity.eEDIRecord[] getDataRecords(){
		Object obj = _self.get("dataRecords");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eEDIRecord[])obj;

	}

	public void setDataRecords(com.br.client.model.ed.entity.eEDIRecord[] value){
		_self.remove("dataRecords");
		if ( value != null )
			_self.put("dataRecords", value);

	}


	public int getTotalRecords(){
		return toInteger("totalRecords");
	}

	public void setTotalRecords(int value){
		setInteger("totalRecords",value);
	}


	public com.br.client.model.ed.entity.eEDIPageCode[] getEntityPages(){
		Object obj = _self.get("entityPages");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eEDIPageCode[])obj;

	}

	public void setEntityPages(com.br.client.model.ed.entity.eEDIPageCode[] value){
		_self.remove("entityPages");
		if ( value != null )
			_self.put("entityPages", value);

	}


	public String getCodePage(){
		return toString("codePage");
	}

	public void setCodePage(String value){
		setString("codePage",value);
	}


	public String getLabelCustoTotal(){
		return toString("labelCustoTotal");
	}

	public void setLabelCustoTotal(String value){
		setString("labelCustoTotal",value);
	}


	public String getTitleCustoTotal(){
		return toString("titleCustoTotal");
	}

	public void setTitleCustoTotal(String value){
		setString("titleCustoTotal",value);
	}


	public String getErroDetail(){
		return toString("erroDetail");
	}

	public void setErroDetail(String value){
		setString("erroDetail",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "layouts".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDILayout[] obj = new com.br.client.model.ed.entity.eEDILayout[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.ed.entity.eEDILayout)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "dataRecords".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDIRecord[] obj = new com.br.client.model.ed.entity.eEDIRecord[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.ed.entity.eEDIRecord)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "entityPages".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDIPageCode[] obj = new com.br.client.model.ed.entity.eEDIPageCode[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.ed.entity.eEDIPageCode)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "layouts".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDILayout obj = com.br.client.model.ed.entity.eEDILayout.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "dataRecords".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDIRecord obj = com.br.client.model.ed.entity.eEDIRecord.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityPages".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDIPageCode obj = com.br.client.model.ed.entity.eEDIPageCode.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.ed.edw0003.FormBean newInstance(){
		return new com.br.client.model.ed.edw0003.FormBean();
	}
}