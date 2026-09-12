package com.br.client.model.vd.entity;

public class ePedidoBarreira extends com.howmake.client.form.model.HowMGWTFormBean{
	public ePedidoBarreira(){
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


	public String getCodBarreira(){
		return toString("codBarreira");
	}

	public void setCodBarreira(String value){
		setString("codBarreira",value);
	}


	public String getObservacao(){
		return toString("observacao");
	}

	public void setObservacao(String value){
		setString("observacao",value);
	}


	public String getDescr(){
		return toString("descr");
	}

	public void setDescr(String value){
		setString("descr",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.ePedidoBarreira newInstance(){
		return new com.br.client.model.vd.entity.ePedidoBarreira();
	}
}