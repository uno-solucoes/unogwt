package com.br.client.model.vd.entity;

public class ePedidoCheque extends com.howmake.client.form.model.HowMGWTFormBean{
	public ePedidoCheque(){
	}


	public String getCodChequePedido(){
		return toString("codChequePedido");
	}

	public void setCodChequePedido(String value){
		setString("codChequePedido",value);
	}


	public String getCodPedido(){
		return toString("codPedido");
	}

	public void setCodPedido(String value){
		setString("codPedido",value);
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getChequeBanco(){
		return toString("chequeBanco");
	}

	public void setChequeBanco(String value){
		setString("chequeBanco",value);
	}


	public String getChequeNr(){
		return toString("chequeNr");
	}

	public void setChequeNr(String value){
		setString("chequeNr",value);
	}


	public String getChequeAgencia(){
		return toString("chequeAgencia");
	}

	public void setChequeAgencia(String value){
		setString("chequeAgencia",value);
	}


	public String getChequeCcorrente(){
		return toString("chequeCcorrente");
	}

	public void setChequeCcorrente(String value){
		setString("chequeCcorrente",value);
	}


	public String getChequeTitular(){
		return toString("chequeTitular");
	}

	public void setChequeTitular(String value){
		setString("chequeTitular",value);
	}


	public String getChequeDocumento(){
		return toString("chequeDocumento");
	}

	public void setChequeDocumento(String value){
		setString("chequeDocumento",value);
	}


	public String getDtVencimento(){
		return toString("dtVencimento");
	}

	public void setDtVencimento(String value){
		setString("dtVencimento",value);
	}


	public String getVlCheque(){
		return toString("vlCheque");
	}

	public void setVlCheque(String value){
		setString("vlCheque",value);
	}


	public String getVlFaturado(){
		return toString("vlFaturado");
	}

	public void setVlFaturado(String value){
		setString("vlFaturado",value);
	}


	public String getCodCheque(){
		return toString("codCheque");
	}

	public void setCodCheque(String value){
		setString("codCheque",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getSaldoCheque(){
		return toString("saldoCheque");
	}

	public void setSaldoCheque(String value){
		setString("saldoCheque",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.ePedidoCheque newInstance(){
		return new com.br.client.model.vd.entity.ePedidoCheque();
	}
}