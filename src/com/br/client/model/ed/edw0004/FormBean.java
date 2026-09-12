package com.br.client.model.ed.edw0004;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public String getTpHistorico(){
		return toString("tpHistorico");
	}

	public void setTpHistorico(String value){
		setString("tpHistorico",value);
	}


	public java.lang.String[] getChave(){
		Object obj = _self.get("chave");
		if ( obj == null )
			return null;
		else
			return (java.lang.String[])obj;

	}

	public void setChave(java.lang.String[] value){
		_self.remove("chave");
		if ( value != null )
			_self.put("chave", value);

	}


	public String getDtHist(){
		return toString("dtHist");
	}

	public void setDtHist(String value){
		setString("dtHist",value);
	}


	public java.lang.String[] getDatasHistoricas(){
		Object obj = _self.get("datasHistoricas");
		if ( obj == null )
			return null;
		else
			return (java.lang.String[])obj;

	}

	public void setDatasHistoricas(java.lang.String[] value){
		_self.remove("datasHistoricas");
		if ( value != null )
			_self.put("datasHistoricas", value);

	}


	public com.br.client.model.ed.entity.eEDIHist[] getHistoricos(){
		Object obj = _self.get("historicos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eEDIHist[])obj;

	}

	public void setHistoricos(com.br.client.model.ed.entity.eEDIHist[] value){
		_self.remove("historicos");
		if ( value != null )
			_self.put("historicos", value);

	}


	public int getOPERATION_INSERT(){
		return toInteger("OPERATION_INSERT");
	}

	public void setOPERATION_INSERT(int value){
		setInteger("OPERATION_INSERT",value);
	}


	public int getOPERATION_UPDATE(){
		return toInteger("OPERATION_UPDATE");
	}

	public void setOPERATION_UPDATE(int value){
		setInteger("OPERATION_UPDATE",value);
	}


	public int getOPERATION_DELETE(){
		return toInteger("OPERATION_DELETE");
	}

	public void setOPERATION_DELETE(int value){
		setInteger("OPERATION_DELETE",value);
	}


	public int getOPERATION_QUERY(){
		return toInteger("OPERATION_QUERY");
	}

	public void setOPERATION_QUERY(int value){
		setInteger("OPERATION_QUERY",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "chave".equalsIgnoreCase(name) ){
			java.lang.String[] obj = new java.lang.String[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isString()!= null )
					obj[i] = object.isString().stringValue();
				 
			}
		}
		if ( "datasHistoricas".equalsIgnoreCase(name) ){
			java.lang.String[] obj = new java.lang.String[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isString()!= null )
					obj[i] = object.isString().stringValue();
				 
			}
		}
		if ( "historicos".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDIHist[] obj = new com.br.client.model.ed.entity.eEDIHist[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.ed.entity.eEDIHist)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "historicos".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDIHist obj = com.br.client.model.ed.entity.eEDIHist.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.ed.edw0004.FormBean newInstance(){
		return new com.br.client.model.ed.edw0004.FormBean();
	}
}