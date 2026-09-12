package com.br.client.model.cd.entity;

public class eGrupoProdutoItem extends com.howmake.client.form.model.HowMGWTFormBean{
	public eGrupoProdutoItem(){
	}


	public String getCodGrupoProduto(){
		return toString("codGrupoProduto");
	}

	public void setCodGrupoProduto(String value){
		setString("codGrupoProduto",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getDescAbrev(){
		return toString("descAbrev");
	}

	public void setDescAbrev(String value){
		setString("descAbrev",value);
	}


	public String getCodProduto(){
		return toString("codProduto");
	}

	public void setCodProduto(String value){
		setString("codProduto",value);
	}


	public String getCodGrupoPai(){
		return toString("codGrupoPai");
	}

	public void setCodGrupoPai(String value){
		setString("codGrupoPai",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.cd.entity.eGrupoProdutoItem newInstance(){
		return new com.br.client.model.cd.entity.eGrupoProdutoItem();
	}
}