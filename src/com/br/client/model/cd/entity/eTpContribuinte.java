package com.br.client.model.cd.entity;

public class eTpContribuinte extends com.howmake.client.form.model.HowMGWTFormBean{
	public eTpContribuinte(){
	}


	public String getTpContribuinte(){
		return toString("tpContribuinte");
	}

	public void setTpContribuinte(String value){
		setString("tpContribuinte",value);
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


	public String getIndIpiBaseIcms(){
		return toString("indIpiBaseIcms");
	}

	public void setIndIpiBaseIcms(String value){
		setString("indIpiBaseIcms",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.cd.entity.eTpContribuinte newInstance(){
		return new com.br.client.model.cd.entity.eTpContribuinte();
	}
}