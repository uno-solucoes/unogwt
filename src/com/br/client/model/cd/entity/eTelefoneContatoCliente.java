package com.br.client.model.cd.entity;

public class eTelefoneContatoCliente extends com.howmake.client.form.model.HowMGWTFormBean{
	public eTelefoneContatoCliente(){
	}


	public String getCodTelefone(){
		return toString("codTelefone");
	}

	public void setCodTelefone(String value){
		setString("codTelefone",value);
	}


	public String getRamal(){
		return toString("ramal");
	}

	public void setRamal(String value){
		setString("ramal",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getTelefone(){
		return toString("telefone");
	}

	public void setTelefone(String value){
		setString("telefone",value);
	}


	public String getDdd(){
		return toString("ddd");
	}

	public void setDdd(String value){
		setString("ddd",value);
	}


	public String getTpTelefone(){
		return toString("tpTelefone");
	}

	public void setTpTelefone(String value){
		setString("tpTelefone",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.cd.entity.eTelefoneContatoCliente newInstance(){
		return new com.br.client.model.cd.entity.eTelefoneContatoCliente();
	}
}