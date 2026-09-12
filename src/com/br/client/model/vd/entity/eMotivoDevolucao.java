package com.br.client.model.vd.entity;

public class eMotivoDevolucao extends com.howmake.client.form.model.HowMGWTFormBean{
	public eMotivoDevolucao(){
	}


	public String getCodMotivoDevolucao(){
		return toString("codMotivoDevolucao");
	}

	public void setCodMotivoDevolucao(String value){
		setString("codMotivoDevolucao",value);
	}


	public String getDescAbrev(){
		return toString("descAbrev");
	}

	public void setDescAbrev(String value){
		setString("descAbrev",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getOperacao(){
		return toString("operacao");
	}

	public void setOperacao(String value){
		setString("operacao",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.eMotivoDevolucao newInstance(){
		return new com.br.client.model.vd.entity.eMotivoDevolucao();
	}
}