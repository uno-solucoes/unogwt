package com.br.client.model.oc.entity;

public class eArquivoOcorrencia extends com.howmake.client.form.model.HowMGWTFormBean{
	public eArquivoOcorrencia(){
	}


	public String getCodOcorrencia(){
		return toString("codOcorrencia");
	}

	public void setCodOcorrencia(String value){
		setString("codOcorrencia",value);
	}


	public String getCodArq(){
		return toString("codArq");
	}

	public void setCodArq(String value){
		setString("codArq",value);
	}


	public String getArquivo(){
		return toString("arquivo");
	}

	public void setArquivo(String value){
		setString("arquivo",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getNomeArquivo(){
		return toString("nomeArquivo");
	}

	public void setNomeArquivo(String value){
		setString("nomeArquivo",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.oc.entity.eArquivoOcorrencia newInstance(){
		return new com.br.client.model.oc.entity.eArquivoOcorrencia();
	}
}