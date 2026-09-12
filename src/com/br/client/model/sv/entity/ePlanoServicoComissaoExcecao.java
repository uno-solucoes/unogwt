package com.br.client.model.sv.entity;

public class ePlanoServicoComissaoExcecao extends com.howmake.client.form.model.HowMGWTFormBean{
	public ePlanoServicoComissaoExcecao(){
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getTpOwner(){
		return toString("tpOwner");
	}

	public void setTpOwner(String value){
		setString("tpOwner",value);
	}


	public String getCodPlano(){
		return toString("codPlano");
	}

	public void setCodPlano(String value){
		setString("codPlano",value);
	}


	public String getCodParcelaPagto(){
		return toString("codParcelaPagto");
	}

	public void setCodParcelaPagto(String value){
		setString("codParcelaPagto",value);
	}


	public String getPercComissao(){
		return toString("percComissao");
	}

	public void setPercComissao(String value){
		setString("percComissao",value);
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


	public static final com.br.client.model.sv.entity.ePlanoServicoComissaoExcecao newInstance(){
		return new com.br.client.model.sv.entity.ePlanoServicoComissaoExcecao();
	}
}