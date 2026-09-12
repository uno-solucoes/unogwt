package com.br.client.model.vd.entity;

public class eHistoricoPedido extends com.howmake.client.form.model.HowMGWTFormBean{
	public eHistoricoPedido(){
	}


	public String getSeqHistPedido(){
		return toString("seqHistPedido");
	}

	public void setSeqHistPedido(String value){
		setString("seqHistPedido",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getNrSequencia(){
		return toString("nrSequencia");
	}

	public void setNrSequencia(String value){
		setString("nrSequencia",value);
	}


	public String getCodPedido(){
		return toString("codPedido");
	}

	public void setCodPedido(String value){
		setString("codPedido",value);
	}


	public String getCodControle(){
		return toString("codControle");
	}

	public void setCodControle(String value){
		setString("codControle",value);
	}


	public String getDtReferencia(){
		return toString("dtReferencia");
	}

	public void setDtReferencia(String value){
		setString("dtReferencia",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getCodNotaFiscal(){
		return toString("codNotaFiscal");
	}

	public void setCodNotaFiscal(String value){
		setString("codNotaFiscal",value);
	}


	public String getNrSequenciaNf(){
		return toString("nrSequenciaNf");
	}

	public void setNrSequenciaNf(String value){
		setString("nrSequenciaNf",value);
	}


	public String getDescControle(){
		return toString("descControle");
	}

	public void setDescControle(String value){
		setString("descControle",value);
	}


	public String getDescTpHist(){
		return toString("descTpHist");
	}

	public void setDescTpHist(String value){
		setString("descTpHist",value);
	}


	public String getIdColaborador(){
		return toString("idColaborador");
	}

	public void setIdColaborador(String value){
		setString("idColaborador",value);
	}


	public String getTpHistorico(){
		return toString("tpHistorico");
	}

	public void setTpHistorico(String value){
		setString("tpHistorico",value);
	}


	public String getOrigem(){
		return toString("origem");
	}

	public void setOrigem(String value){
		setString("origem",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.eHistoricoPedido newInstance(){
		return new com.br.client.model.vd.entity.eHistoricoPedido();
	}
}