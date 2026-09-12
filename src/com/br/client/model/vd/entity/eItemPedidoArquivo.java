package com.br.client.model.vd.entity;

public class eItemPedidoArquivo extends com.howmake.client.form.model.HowMGWTFormBean{
	public eItemPedidoArquivo(){
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getCodPedido(){
		return toString("codPedido");
	}

	public void setCodPedido(String value){
		setString("codPedido",value);
	}


	public String getNrSequencia(){
		return toString("nrSequencia");
	}

	public void setNrSequencia(String value){
		setString("nrSequencia",value);
	}


	public String getCodArq(){
		return toString("codArq");
	}

	public void setCodArq(String value){
		setString("codArq",value);
	}


	public String getArquivo(){
		return toString("arquivo");
	}

	public void setArquivo(String value){
		setString("arquivo",value);
	}


	public String getNomeArquivo(){
		return toString("nomeArquivo");
	}

	public void setNomeArquivo(String value){
		setString("nomeArquivo",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public boolean getArquivoProduto(){
		return toBoolean("arquivoProduto");
	}

	public void setArquivoProduto(boolean value){
		setBoolean("arquivoProduto",value);
	}


	public int getGed(){
		return toInteger("ged");
	}

	public void setGed(int value){
		setInteger("ged",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.eItemPedidoArquivo newInstance(){
		return new com.br.client.model.vd.entity.eItemPedidoArquivo();
	}
}