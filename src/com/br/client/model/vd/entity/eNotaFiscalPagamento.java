package com.br.client.model.vd.entity;

public class eNotaFiscalPagamento extends com.howmake.client.form.model.HowMGWTFormBean{
	public eNotaFiscalPagamento(){
	}


	public String getCodNotaFiscal(){
		return toString("codNotaFiscal");
	}

	public void setCodNotaFiscal(String value){
		setString("codNotaFiscal",value);
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getCodParcela(){
		return toString("codParcela");
	}

	public void setCodParcela(String value){
		setString("codParcela",value);
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


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getCodPedido(){
		return toString("codPedido");
	}

	public void setCodPedido(String value){
		setString("codPedido",value);
	}


	public boolean getBaixaAutomatica(){
		return toBoolean("baixaAutomatica");
	}

	public void setBaixaAutomatica(boolean value){
		setBoolean("baixaAutomatica",value);
	}


	public String getVlSaldoParcela(){
		return toString("vlSaldoParcela");
	}

	public void setVlSaldoParcela(String value){
		setString("vlSaldoParcela",value);
	}


	public String getTpPagto(){
		return toString("tpPagto");
	}

	public void setTpPagto(String value){
		setString("tpPagto",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.eNotaFiscalPagamento newInstance(){
		return new com.br.client.model.vd.entity.eNotaFiscalPagamento();
	}
}