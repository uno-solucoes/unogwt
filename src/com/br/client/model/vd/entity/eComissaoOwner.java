package com.br.client.model.vd.entity;

public class eComissaoOwner extends com.howmake.client.form.model.HowMGWTFormBean{
	public eComissaoOwner(){
	}


	public String getTpOwner(){
		return toString("tpOwner");
	}

	public void setTpOwner(String value){
		setString("tpOwner",value);
	}


	public String getTpColaborador(){
		return toString("tpColaborador");
	}

	public void setTpColaborador(String value){
		setString("tpColaborador",value);
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


	public static final com.br.client.model.vd.entity.eComissaoOwner newInstance(){
		return new com.br.client.model.vd.entity.eComissaoOwner();
	}
}