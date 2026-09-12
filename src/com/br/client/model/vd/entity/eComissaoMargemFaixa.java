package com.br.client.model.vd.entity;

public class eComissaoMargemFaixa extends com.howmake.client.form.model.HowMGWTFormBean{
	public eComissaoMargemFaixa(){
	}


	public String getCodMargem(){
		return toString("codMargem");
	}

	public void setCodMargem(String value){
		setString("codMargem",value);
	}


	public String getSeqComissaoMargemFaixa(){
		return toString("seqComissaoMargemFaixa");
	}

	public void setSeqComissaoMargemFaixa(String value){
		setString("seqComissaoMargemFaixa",value);
	}


	public String getPercMargemIni(){
		return toString("percMargemIni");
	}

	public void setPercMargemIni(String value){
		setString("percMargemIni",value);
	}


	public String getPercMargemFim(){
		return toString("percMargemFim");
	}

	public void setPercMargemFim(String value){
		setString("percMargemFim",value);
	}


	public String getPercComissaoVendedor(){
		return toString("percComissaoVendedor");
	}

	public void setPercComissaoVendedor(String value){
		setString("percComissaoVendedor",value);
	}


	public int getOperacao(){
		return toInteger("operacao");
	}

	public void setOperacao(int value){
		setInteger("operacao",value);
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


	public static final com.br.client.model.vd.entity.eComissaoMargemFaixa newInstance(){
		return new com.br.client.model.vd.entity.eComissaoMargemFaixa();
	}
}