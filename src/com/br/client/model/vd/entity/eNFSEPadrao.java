package com.br.client.model.vd.entity;

public class eNFSEPadrao extends com.howmake.client.form.model.HowMGWTFormBean{
	public eNFSEPadrao(){
	}


	public int getCdPadrao(){
		return toInteger("cdPadrao");
	}

	public void setCdPadrao(int value){
		setInteger("cdPadrao",value);
	}


	public String getSchemaXSD(){
		return toString("schemaXSD");
	}

	public void setSchemaXSD(String value){
		setString("schemaXSD",value);
	}


	public String getNomePadrao(){
		return toString("nomePadrao");
	}

	public void setNomePadrao(String value){
		setString("nomePadrao",value);
	}


	public String getVariacao(){
		return toString("variacao");
	}

	public void setVariacao(String value){
		setString("variacao",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.eNFSEPadrao newInstance(){
		return new com.br.client.model.vd.entity.eNFSEPadrao();
	}
}