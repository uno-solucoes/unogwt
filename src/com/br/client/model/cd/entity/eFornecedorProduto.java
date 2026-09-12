package com.br.client.model.cd.entity;

public class eFornecedorProduto extends com.howmake.client.form.model.HowMGWTFormBean{
	public eFornecedorProduto(){
	}


	public String getCodProduto(){
		return toString("codProduto");
	}

	public void setCodProduto(String value){
		setString("codProduto",value);
	}


	public String getCodProdutoFornec(){
		return toString("codProdutoFornec");
	}

	public void setCodProdutoFornec(String value){
		setString("codProdutoFornec",value);
	}


	public String getCodFornecedor(){
		return toString("codFornecedor");
	}

	public void setCodFornecedor(String value){
		setString("codFornecedor",value);
	}


	public String getDescricaoFornec(){
		return toString("descricaoFornec");
	}

	public void setDescricaoFornec(String value){
		setString("descricaoFornec",value);
	}


	public String getVlCustoTotal(){
		return toString("vlCustoTotal");
	}

	public void setVlCustoTotal(String value){
		setString("vlCustoTotal",value);
	}


	public String getDtValorCustoTotal(){
		return toString("dtValorCustoTotal");
	}

	public void setDtValorCustoTotal(String value){
		setString("dtValorCustoTotal",value);
	}


	public String getObservacao(){
		return toString("observacao");
	}

	public void setObservacao(String value){
		setString("observacao",value);
	}


	public String getDescComercialFornec(){
		return toString("descComercialFornec");
	}

	public void setDescComercialFornec(String value){
		setString("descComercialFornec",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.cd.entity.eFornecedorProduto newInstance(){
		return new com.br.client.model.cd.entity.eFornecedorProduto();
	}
}