package com.br.client.model.at.entity;

public class eTouchResumo extends com.howmake.client.form.model.HowMGWTFormBean{
	public eTouchResumo(){
	}


	public String getData(){
		return toString("data");
	}

	public void setData(String value){
		setString("data",value);
	}


	public String getTotal(){
		return toString("total");
	}

	public void setTotal(String value){
		setString("total",value);
	}


	public String getReservaDeInteresse(){
		return toString("reservaDeInteresse");
	}

	public void setReservaDeInteresse(String value){
		setString("reservaDeInteresse",value);
	}


	public String getReservaConfirmada(){
		return toString("reservaConfirmada");
	}

	public void setReservaConfirmada(String value){
		setString("reservaConfirmada",value);
	}


	public String getReservaContratoAssinado(){
		return toString("reservaContratoAssinado");
	}

	public void setReservaContratoAssinado(String value){
		setString("reservaContratoAssinado",value);
	}


	public String getReservaPreContrato(){
		return toString("reservaPreContrato");
	}

	public void setReservaPreContrato(String value){
		setString("reservaPreContrato",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.at.entity.eTouchResumo newInstance(){
		return new com.br.client.model.at.entity.eTouchResumo();
	}
}