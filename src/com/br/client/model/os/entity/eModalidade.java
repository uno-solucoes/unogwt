package com.br.client.model.os.entity;

public class eModalidade extends com.howmake.client.form.model.HowMGWTFormBean{
	public eModalidade(){
	}


	public String getCodModalidade(){
		return toString("codModalidade");
	}

	public void setCodModalidade(String value){
		setString("codModalidade",value);
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


	public String getNop(){
		return toString("nop");
	}

	public void setNop(String value){
		setString("nop",value);
	}


	public String getDescNop(){
		return toString("descNop");
	}

	public void setDescNop(String value){
		setString("descNop",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.os.entity.eModalidade newInstance(){
		return new com.br.client.model.os.entity.eModalidade();
	}
}