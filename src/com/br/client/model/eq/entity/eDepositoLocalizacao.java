package com.br.client.model.eq.entity;

public class eDepositoLocalizacao extends com.howmake.client.form.model.HowMGWTFormBean{
	public eDepositoLocalizacao(){
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getCodDeposito(){
		return toString("codDeposito");
	}

	public void setCodDeposito(String value){
		setString("codDeposito",value);
	}


	public String getDescDeposito(){
		return toString("descDeposito");
	}

	public void setDescDeposito(String value){
		setString("descDeposito",value);
	}


	public String getLocalizacao(){
		return toString("localizacao");
	}

	public void setLocalizacao(String value){
		setString("localizacao",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getCodCliente(){
		return toString("codCliente");
	}

	public void setCodCliente(String value){
		setString("codCliente",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.eq.entity.eDepositoLocalizacao newInstance(){
		return new com.br.client.model.eq.entity.eDepositoLocalizacao();
	}
}