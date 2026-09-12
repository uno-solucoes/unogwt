package com.br.client.model.sg.entity;

public class eArquivoGEDLog extends com.howmake.client.form.model.HowMGWTFormBean{
	public eArquivoGEDLog(){
	}


	public String getCodLog(){
		return toString("codLog");
	}

	public void setCodLog(String value){
		setString("codLog",value);
	}


	public String getCodArquivo(){
		return toString("codArquivo");
	}

	public void setCodArquivo(String value){
		setString("codArquivo",value);
	}


	public String getCodDiretorio(){
		return toString("codDiretorio");
	}

	public void setCodDiretorio(String value){
		setString("codDiretorio",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getNomeColaborador(){
		return toString("NomeColaborador");
	}

	public void setNomeColaborador(String value){
		setString("NomeColaborador",value);
	}


	public String getIdUsuario(){
		return toString("idUsuario");
	}

	public void setIdUsuario(String value){
		setString("idUsuario",value);
	}


	public String getData(){
		return toString("data");
	}

	public void setData(String value){
		setString("data",value);
	}


	public String getTpAcao(){
		return toString("tpAcao");
	}

	public void setTpAcao(String value){
		setString("tpAcao",value);
	}


	public String getNomeAcao(){
		return toString("nomeAcao");
	}

	public void setNomeAcao(String value){
		setString("nomeAcao",value);
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


	public static final com.br.client.model.sg.entity.eArquivoGEDLog newInstance(){
		return new com.br.client.model.sg.entity.eArquivoGEDLog();
	}
}