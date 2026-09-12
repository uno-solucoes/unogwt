package com.br.client.model.fn.entity;

public class eBoletimCaixa extends com.howmake.client.form.model.HowMGWTFormBean{
	public eBoletimCaixa(){
	}


	public String getTipoTitulo(){
		return toString("tipoTitulo");
	}

	public void setTipoTitulo(String value){
		setString("tipoTitulo",value);
	}


	public String getCodBanco(){
		return toString("codBanco");
	}

	public void setCodBanco(String value){
		setString("codBanco",value);
	}


	public String getNomeBanco(){
		return toString("nomeBanco");
	}

	public void setNomeBanco(String value){
		setString("nomeBanco",value);
	}


	public String getContaCorrente(){
		return toString("contaCorrente");
	}

	public void setContaCorrente(String value){
		setString("contaCorrente",value);
	}


	public String getConta(){
		return toString("conta");
	}

	public void setConta(String value){
		setString("conta",value);
	}


	public String getSubConta(){
		return toString("subConta");
	}

	public void setSubConta(String value){
		setString("subConta",value);
	}


	public String getCodEspecie(){
		return toString("codEspecie");
	}

	public void setCodEspecie(String value){
		setString("codEspecie",value);
	}


	public String getDescConta(){
		return toString("descConta");
	}

	public void setDescConta(String value){
		setString("descConta",value);
	}


	public double getValor(){
		return toDouble("valor");
	}

	public void setValor(double value){
		setDouble("valor",value);
	}


	public double getSaldoInicial(){
		return toDouble("saldoInicial");
	}

	public void setSaldoInicial(double value){
		setDouble("saldoInicial",value);
	}


	public double getValorEntrada(){
		return toDouble("valorEntrada");
	}

	public void setValorEntrada(double value){
		setDouble("valorEntrada",value);
	}


	public double getValorSaida(){
		return toDouble("valorSaida");
	}

	public void setValorSaida(double value){
		setDouble("valorSaida",value);
	}


	public double getSaldoAtual(){
		return toDouble("saldoAtual");
	}

	public void setSaldoAtual(double value){
		setDouble("saldoAtual",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.fn.entity.eBoletimCaixa newInstance(){
		return new com.br.client.model.fn.entity.eBoletimCaixa();
	}
}