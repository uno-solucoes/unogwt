package com.br.client.model.vd.entity;

public class eItemPedidoEtq extends com.howmake.client.form.model.HowMGWTFormBean{
	public eItemPedidoEtq(){
	}


	public String getCodProduto(){
		return toString("codProduto");
	}

	public void setCodProduto(String value){
		setString("codProduto",value);
	}


	public String getDescProduto(){
		return toString("descProduto");
	}

	public void setDescProduto(String value){
		setString("descProduto",value);
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


	public String getNrSequenciaEtq(){
		return toString("nrSequenciaEtq");
	}

	public void setNrSequenciaEtq(String value){
		setString("nrSequenciaEtq",value);
	}


	public String getCodLote(){
		return toString("codLote");
	}

	public void setCodLote(String value){
		setString("codLote",value);
	}


	public String getCodEmbalagem(){
		return toString("codEmbalagem");
	}

	public void setCodEmbalagem(String value){
		setString("codEmbalagem",value);
	}


	public String getLocalizacao(){
		return toString("localizacao");
	}

	public void setLocalizacao(String value){
		setString("localizacao",value);
	}


	public String getDescLocalizacao(){
		return toString("descLocalizacao");
	}

	public void setDescLocalizacao(String value){
		setString("descLocalizacao",value);
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


	public String getQtd(){
		return toString("qtd");
	}

	public void setQtd(String value){
		setString("qtd",value);
	}


	public String getNrSerie(){
		return toString("nrSerie");
	}

	public void setNrSerie(String value){
		setString("nrSerie",value);
	}


	public String getIndEstoque(){
		return toString("indEstoque");
	}

	public void setIndEstoque(String value){
		setString("indEstoque",value);
	}


	public String getVlCustoTotal(){
		return toString("vlCustoTotal");
	}

	public void setVlCustoTotal(String value){
		setString("vlCustoTotal",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getDtValidade(){
		return toString("dtValidade");
	}

	public void setDtValidade(String value){
		setString("dtValidade",value);
	}


	public String getDtProducao(){
		return toString("dtProducao");
	}

	public void setDtProducao(String value){
		setString("dtProducao",value);
	}


	public String getCodUA(){
		return toString("codUA");
	}

	public void setCodUA(String value){
		setString("codUA",value);
	}


	public String getCodOp(){
		return toString("codOp");
	}

	public void setCodOp(String value){
		setString("codOp",value);
	}


	public String getQtdTotal(){
		return toString("qtdTotal");
	}

	public void setQtdTotal(String value){
		setString("qtdTotal",value);
	}


	public String getNomeCliente(){
		return toString("nomeCliente");
	}

	public void setNomeCliente(String value){
		setString("nomeCliente",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.eItemPedidoEtq newInstance(){
		return new com.br.client.model.vd.entity.eItemPedidoEtq();
	}
}