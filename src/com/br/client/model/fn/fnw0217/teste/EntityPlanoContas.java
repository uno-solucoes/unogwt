package com.br.client.model.fn.fnw0217.teste;

public class EntityPlanoContas extends com.howmake.client.form.model.HowMGWTFormBean{
	public EntityPlanoContas(){
	}


	public String getConta(){
		return toString("conta");
	}

	public void setConta(String value){
		setString("conta",value);
	}


	public String getContaPai(){
		return toString("contaPai");
	}

	public void setContaPai(String value){
		setString("contaPai",value);
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


	public static final com.br.client.model.fn.fnw0217.teste.EntityPlanoContas newInstance(){
		return new com.br.client.model.fn.fnw0217.teste.EntityPlanoContas();
	}
}