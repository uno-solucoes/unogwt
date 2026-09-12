package com.br.client.model.vd.entity;

public class eNFSEParametroWS extends com.howmake.client.form.model.HowMGWTFormBean{
	public eNFSEParametroWS(){
	}


	public String getAtivo(){
		return toString("ativo");
	}

	public void setAtivo(String value){
		setString("ativo",value);
	}


	public String getPadrao(){
		return toString("padrao");
	}

	public void setPadrao(String value){
		setString("padrao",value);
	}


	public String getPathEntrada(){
		return toString("pathEntrada");
	}

	public void setPathEntrada(String value){
		setString("pathEntrada",value);
	}


	public String getTipoOffLine(){
		return toString("tipoOffLine");
	}

	public void setTipoOffLine(String value){
		setString("tipoOffLine",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.eNFSEParametroWS newInstance(){
		return new com.br.client.model.vd.entity.eNFSEParametroWS();
	}
}