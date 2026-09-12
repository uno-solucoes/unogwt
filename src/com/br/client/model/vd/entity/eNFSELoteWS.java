package com.br.client.model.vd.entity;

public class eNFSELoteWS extends com.howmake.client.form.model.HowMGWTFormBean{
	public eNFSELoteWS(){
	}


	public String getError(){
		return toString("error");
	}

	public void setError(String value){
		setString("error",value);
	}


	public String getErrorMsg(){
		return toString("errorMsg");
	}

	public void setErrorMsg(String value){
		setString("errorMsg",value);
	}


	public com.br.client.model.vd.entity.eNFSEStatusWS[] getEntityHistorico(){
		Object obj = _self.get("entityHistorico");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSEStatusWS[])obj;

	}

	public void setEntityHistorico(com.br.client.model.vd.entity.eNFSEStatusWS[] value){
		_self.remove("entityHistorico");
		if ( value != null )
			_self.put("entityHistorico", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "entityHistorico".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEStatusWS[] obj = new com.br.client.model.vd.entity.eNFSEStatusWS[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eNFSEStatusWS)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "entityHistorico".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEStatusWS obj = com.br.client.model.vd.entity.eNFSEStatusWS.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.vd.entity.eNFSELoteWS newInstance(){
		return new com.br.client.model.vd.entity.eNFSELoteWS();
	}
}