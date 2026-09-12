package com.br.client.model.vd.entity;

public class ePagamentoPedido extends com.howmake.client.form.model.HowMGWTFormBean{
	public ePagamentoPedido(){
	}


	public String getCodParcela(){
		return toString("codParcela");
	}

	public void setCodParcela(String value){
		setString("codParcela",value);
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


	public String getDtVencimento(){
		return toString("dtVencimento");
	}

	public void setDtVencimento(String value){
		setString("dtVencimento",value);
	}


	public String getVlTotalParcela(){
		return toString("vlTotalParcela");
	}

	public void setVlTotalParcela(String value){
		setString("vlTotalParcela",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getFormaPagto(){
		return toString("formaPagto");
	}

	public void setFormaPagto(String value){
		setString("formaPagto",value);
	}


	public String getDescFormaPagto(){
		return toString("descFormaPagto");
	}

	public void setDescFormaPagto(String value){
		setString("descFormaPagto",value);
	}


	public String getNomeCliente(){
		return toString("nomeCliente");
	}

	public void setNomeCliente(String value){
		setString("nomeCliente",value);
	}


	public String getNop(){
		return toString("nop");
	}

	public void setNop(String value){
		setString("nop",value);
	}


	public String getMoeda(){
		return toString("moeda");
	}

	public void setMoeda(String value){
		setString("moeda",value);
	}


	public boolean getBaixaAutomatica(){
		return toBoolean("baixaAutomatica");
	}

	public void setBaixaAutomatica(boolean value){
		setBoolean("baixaAutomatica",value);
	}


	public String getDescCondPagto(){
		return toString("descCondPagto");
	}

	public void setDescCondPagto(String value){
		setString("descCondPagto",value);
	}


	public String getIndAntecipacaoSt(){
		return toString("indAntecipacaoSt");
	}

	public void setIndAntecipacaoSt(String value){
		setString("indAntecipacaoSt",value);
	}


	public boolean getFlagTempEditado(){
		return toBoolean("flagTempEditado");
	}

	public void setFlagTempEditado(boolean value){
		setBoolean("flagTempEditado",value);
	}


	public String getEspecie(){
		return toString("especie");
	}

	public void setEspecie(String value){
		setString("especie",value);
	}


	public String getNomeEspecie(){
		return toString("nomeEspecie");
	}

	public void setNomeEspecie(String value){
		setString("nomeEspecie",value);
	}


	public String getCodEspecie(){
		return toString("codEspecie");
	}

	public void setCodEspecie(String value){
		setString("codEspecie",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.ePagamentoPedido newInstance(){
		return new com.br.client.model.vd.entity.ePagamentoPedido();
	}
}