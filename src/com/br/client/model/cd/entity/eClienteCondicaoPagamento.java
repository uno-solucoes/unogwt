package com.br.client.model.cd.entity;

public class eClienteCondicaoPagamento extends com.howmake.client.form.model.HowMGWTFormBean{
	public eClienteCondicaoPagamento(){
	}


	public String getCodCliente(){
		return toString("codCliente");
	}

	public void setCodCliente(String value){
		setString("codCliente",value);
	}


	public String getCodCondPagto(){
		return toString("codCondPagto");
	}

	public void setCodCondPagto(String value){
		setString("codCondPagto",value);
	}


	public String getVlMinimoVenda(){
		return toString("vlMinimoVenda");
	}

	public void setVlMinimoVenda(String value){
		setString("vlMinimoVenda",value);
	}


	public String getDescCondicaoPagamento(){
		return toString("descCondicaoPagamento");
	}

	public void setDescCondicaoPagamento(String value){
		setString("descCondicaoPagamento",value);
	}


	public int getOPERATION_INSERT(){
		return toInteger("OPERATION_INSERT");
	}

	public void setOPERATION_INSERT(int value){
		setInteger("OPERATION_INSERT",value);
	}


	public int getOPERATION_UPDATE(){
		return toInteger("OPERATION_UPDATE");
	}

	public void setOPERATION_UPDATE(int value){
		setInteger("OPERATION_UPDATE",value);
	}


	public int getOPERATION_DELETE(){
		return toInteger("OPERATION_DELETE");
	}

	public void setOPERATION_DELETE(int value){
		setInteger("OPERATION_DELETE",value);
	}


	public int getOPERATION_QUERY(){
		return toInteger("OPERATION_QUERY");
	}

	public void setOPERATION_QUERY(int value){
		setInteger("OPERATION_QUERY",value);
	}


	public int getRowID(){
		return toInteger("rowID");
	}

	public void setRowID(int value){
		setInteger("rowID",value);
	}


	public int getOperation(){
		return toInteger("operation");
	}

	public void setOperation(int value){
		setInteger("operation",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.cd.entity.eClienteCondicaoPagamento newInstance(){
		return new com.br.client.model.cd.entity.eClienteCondicaoPagamento();
	}
}