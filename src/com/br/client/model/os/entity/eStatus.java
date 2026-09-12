package com.br.client.model.os.entity;

public class eStatus extends com.howmake.client.form.model.HowMGWTFormBean{
	public eStatus(){
	}


	public String getCodStatus(){
		return toString("codStatus");
	}

	public void setCodStatus(String value){
		setString("codStatus",value);
	}


	public String getDescAbrev(){
		return toString("descAbrev");
	}

	public void setDescAbrev(String value){
		setString("descAbrev",value);
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


	public static final com.br.client.model.os.entity.eStatus newInstance(){
		return new com.br.client.model.os.entity.eStatus();
	}
}