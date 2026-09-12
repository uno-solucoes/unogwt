package com.br.client.model.vd.entity;

public class eNFSECidade extends com.howmake.client.form.model.HowMGWTFormBean{
	public eNFSECidade(){
	}


	public int getCodMunicipio(){
		return toInteger("codMunicipio");
	}

	public void setCodMunicipio(int value){
		setInteger("codMunicipio",value);
	}


	public int getUf(){
		return toInteger("uf");
	}

	public void setUf(int value){
		setInteger("uf",value);
	}


	public String getSiglaUF(){
		return toString("siglaUF");
	}

	public void setSiglaUF(String value){
		setString("siglaUF",value);
	}


	public String getNome(){
		return toString("nome");
	}

	public void setNome(String value){
		setString("nome",value);
	}


	public int getCdPadrao(){
		return toInteger("cdPadrao");
	}

	public void setCdPadrao(int value){
		setInteger("cdPadrao",value);
	}


	public String getUrls(){
		return toString("urls");
	}

	public void setUrls(String value){
		setString("urls",value);
	}


	public com.br.client.model.vd.entity.eNFSEPadrao getEntityPadrao(){
		Object obj = _self.get("entityPadrao");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSEPadrao)obj;

	}

	public void setEntityPadrao(com.br.client.model.vd.entity.eNFSEPadrao value){
		_self.remove("entityPadrao");
		if ( value != null )
			_self.put("entityPadrao", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "entityPadrao".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEPadrao obj = new com.br.client.model.vd.entity.eNFSEPadrao();
			_self.put(name,obj);
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "entityPadrao".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEPadrao obj = com.br.client.model.vd.entity.eNFSEPadrao.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.vd.entity.eNFSECidade newInstance(){
		return new com.br.client.model.vd.entity.eNFSECidade();
	}
}