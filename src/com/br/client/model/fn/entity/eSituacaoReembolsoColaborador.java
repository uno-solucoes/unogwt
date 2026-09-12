package com.br.client.model.fn.entity;

public class eSituacaoReembolsoColaborador extends com.howmake.client.form.model.HowMGWTFormBean{
	public eSituacaoReembolsoColaborador(){
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getSitReembolso(){
		return toString("sitReembolso");
	}

	public void setSitReembolso(String value){
		setString("sitReembolso",value);
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


	public static final com.br.client.model.fn.entity.eSituacaoReembolsoColaborador newInstance(){
		return new com.br.client.model.fn.entity.eSituacaoReembolsoColaborador();
	}
}