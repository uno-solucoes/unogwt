package com.br.client.model.vd.entity;

public class eNFSEConsultaWS extends com.howmake.client.form.model.HowMGWTFormBean{
	public eNFSEConsultaWS(){
	}


	public String getIdMunicipio(){
		return toString("idMunicipio");
	}

	public void setIdMunicipio(String value){
		setString("idMunicipio",value);
	}


	public String getImgLogoPrefeitura(){
		return toString("imgLogoPrefeitura");
	}

	public void setImgLogoPrefeitura(String value){
		setString("imgLogoPrefeitura",value);
	}


	public String getIndControlaSubsequente(){
		return toString("indControlaSubsequente");
	}

	public void setIndControlaSubsequente(String value){
		setString("indControlaSubsequente",value);
	}


	public String getNmModuloIntegracao(){
		return toString("nmModuloIntegracao");
	}

	public void setNmModuloIntegracao(String value){
		setString("nmModuloIntegracao",value);
	}


	public String getUrlConsultaNfse(){
		return toString("urlConsultaNfse");
	}

	public void setUrlConsultaNfse(String value){
		setString("urlConsultaNfse",value);
	}


	public String getUrlPortalNfse(){
		return toString("urlPortalNfse");
	}

	public void setUrlPortalNfse(String value){
		setString("urlPortalNfse",value);
	}


	public String getDtCorte(){
		return toString("dtCorte");
	}

	public void setDtCorte(String value){
		setString("dtCorte",value);
	}


	public com.br.client.model.vd.entity.eNFSEConsultaParametrosWS[] getEntityConsultaParametrosWS(){
		Object obj = _self.get("entityConsultaParametrosWS");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSEConsultaParametrosWS[])obj;

	}

	public void setEntityConsultaParametrosWS(com.br.client.model.vd.entity.eNFSEConsultaParametrosWS[] value){
		_self.remove("entityConsultaParametrosWS");
		if ( value != null )
			_self.put("entityConsultaParametrosWS", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "entityConsultaParametrosWS".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEConsultaParametrosWS[] obj = new com.br.client.model.vd.entity.eNFSEConsultaParametrosWS[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eNFSEConsultaParametrosWS)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "entityConsultaParametrosWS".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEConsultaParametrosWS obj = com.br.client.model.vd.entity.eNFSEConsultaParametrosWS.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.vd.entity.eNFSEConsultaWS newInstance(){
		return new com.br.client.model.vd.entity.eNFSEConsultaWS();
	}
}