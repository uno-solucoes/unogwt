package com.br.client.model.fn.entity;

public class eTituloPagarRateio extends com.howmake.client.form.model.HowMGWTFormBean{
	public eTituloPagarRateio(){
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getCodTitulo(){
		return toString("codTitulo");
	}

	public void setCodTitulo(String value){
		setString("codTitulo",value);
	}


	public String getCodParcela(){
		return toString("codParcela");
	}

	public void setCodParcela(String value){
		setString("codParcela",value);
	}


	public String getCodFornecedor(){
		return toString("codFornecedor");
	}

	public void setCodFornecedor(String value){
		setString("codFornecedor",value);
	}


	public String getCodEspecie(){
		return toString("codEspecie");
	}

	public void setCodEspecie(String value){
		setString("codEspecie",value);
	}


	public String getCcusto(){
		return toString("ccusto");
	}

	public void setCcusto(String value){
		setString("ccusto",value);
	}


	public String getDescCcusto(){
		return toString("descCcusto");
	}

	public void setDescCcusto(String value){
		setString("descCcusto",value);
	}


	public String getPercRateio(){
		return toString("percRateio");
	}

	public void setPercRateio(String value){
		setString("percRateio",value);
	}


	public String getValorRateio(){
		return toString("valorRateio");
	}

	public void setValorRateio(String value){
		setString("valorRateio",value);
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


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.fn.entity.eTituloPagarRateio newInstance(){
		return new com.br.client.model.fn.entity.eTituloPagarRateio();
	}
}