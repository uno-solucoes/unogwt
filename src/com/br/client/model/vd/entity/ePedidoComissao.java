package com.br.client.model.vd.entity;

public class ePedidoComissao extends com.howmake.client.form.model.HowMGWTFormBean{
	public ePedidoComissao(){
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


	public String getTpOwner(){
		return toString("tpOwner");
	}

	public void setTpOwner(String value){
		setString("tpOwner",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getNomeColaborador(){
		return toString("nomeColaborador");
	}

	public void setNomeColaborador(String value){
		setString("nomeColaborador",value);
	}


	public String getTpItem(){
		return toString("tpItem");
	}

	public void setTpItem(String value){
		setString("tpItem",value);
	}


	public String getTpComissao(){
		return toString("tpComissao");
	}

	public void setTpComissao(String value){
		setString("tpComissao",value);
	}


	public String getPercComissao(){
		return toString("percComissao");
	}

	public void setPercComissao(String value){
		setString("percComissao",value);
	}


	public String getDescOwner(){
		return toString("descOwner");
	}

	public void setDescOwner(String value){
		setString("descOwner",value);
	}


	public String getPercVdr0020(){
		return toString("percVdr0020");
	}

	public void setPercVdr0020(String value){
		setString("percVdr0020",value);
	}


	public boolean getExiste(){
		return toBoolean("existe");
	}

	public void setExiste(boolean value){
		setBoolean("existe",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.ePedidoComissao newInstance(){
		return new com.br.client.model.vd.entity.ePedidoComissao();
	}
}