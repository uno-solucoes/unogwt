package com.br.client.model.vd.entity;

public class eSolicitacaoDevolucaoItem extends com.howmake.client.form.model.HowMGWTFormBean{
	public eSolicitacaoDevolucaoItem(){
	}


	public String getCodSolicitacaoDevolucao(){
		return toString("codSolicitacaoDevolucao");
	}

	public void setCodSolicitacaoDevolucao(String value){
		setString("codSolicitacaoDevolucao",value);
	}


	public String getNrSequenciaSolicitacao(){
		return toString("nrSequenciaSolicitacao");
	}

	public void setNrSequenciaSolicitacao(String value){
		setString("nrSequenciaSolicitacao",value);
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getCodNotaFiscal(){
		return toString("codNotaFiscal");
	}

	public void setCodNotaFiscal(String value){
		setString("codNotaFiscal",value);
	}


	public String getNrSequenciaNF(){
		return toString("nrSequenciaNF");
	}

	public void setNrSequenciaNF(String value){
		setString("nrSequenciaNF",value);
	}


	public String getNrSequenciaEtq(){
		return toString("nrSequenciaEtq");
	}

	public void setNrSequenciaEtq(String value){
		setString("nrSequenciaEtq",value);
	}


	public String getQtde(){
		return toString("qtde");
	}

	public void setQtde(String value){
		setString("qtde",value);
	}


	public String getCodPedido(){
		return toString("codPedido");
	}

	public void setCodPedido(String value){
		setString("codPedido",value);
	}


	public String getQtdeEnviada(){
		return toString("qtdeEnviada");
	}

	public void setQtdeEnviada(String value){
		setString("qtdeEnviada",value);
	}


	public String getNrNotaFiscal(){
		return toString("nrNotaFiscal");
	}

	public void setNrNotaFiscal(String value){
		setString("nrNotaFiscal",value);
	}


	public String getCdLote(){
		return toString("cdLote");
	}

	public void setCdLote(String value){
		setString("cdLote",value);
	}


	public String getNrSerie(){
		return toString("nrSerie");
	}

	public void setNrSerie(String value){
		setString("nrSerie",value);
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


	public String getUn(){
		return toString("un");
	}

	public void setUn(String value){
		setString("un",value);
	}


	public String getPrecoUnit(){
		return toString("precoUnit");
	}

	public void setPrecoUnit(String value){
		setString("precoUnit",value);
	}


	public String getTpFreteSaida(){
		return toString("tpFreteSaida");
	}

	public void setTpFreteSaida(String value){
		setString("tpFreteSaida",value);
	}


	public String getOperacao(){
		return toString("operacao");
	}

	public void setOperacao(String value){
		setString("operacao",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.eSolicitacaoDevolucaoItem newInstance(){
		return new com.br.client.model.vd.entity.eSolicitacaoDevolucaoItem();
	}
}