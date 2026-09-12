package com.br.client.model.fn.entity;

public class eTituloReceberRateio extends com.howmake.client.form.model.HowMGWTFormBean{
	public eTituloReceberRateio(){
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


	public String getSerie(){
		return toString("serie");
	}

	public void setSerie(String value){
		setString("serie",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.fn.entity.eTituloReceberRateio newInstance(){
		return new com.br.client.model.fn.entity.eTituloReceberRateio();
	}
}