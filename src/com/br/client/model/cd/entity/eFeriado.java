package com.br.client.model.cd.entity;

public class eFeriado extends com.howmake.client.form.model.HowMGWTFormBean{
	public eFeriado(){
	}


	public String getDtFeriado(){
		return toString("dtFeriado");
	}

	public void setDtFeriado(String value){
		setString("dtFeriado",value);
	}


	public String getNomeFeriado(){
		return toString("nomeFeriado");
	}

	public void setNomeFeriado(String value){
		setString("nomeFeriado",value);
	}


	public String getDiaSemana(){
		return toString("diaSemana");
	}

	public void setDiaSemana(String value){
		setString("diaSemana",value);
	}


	public String getTpFeriado(){
		return toString("tpFeriado");
	}

	public void setTpFeriado(String value){
		setString("tpFeriado",value);
	}


	public String getSigla_uf(){
		return toString("sigla_uf");
	}

	public void setSigla_uf(String value){
		setString("sigla_uf",value);
	}


	public String getNrSequenciaFeriado(){
		return toString("nrSequenciaFeriado");
	}

	public void setNrSequenciaFeriado(String value){
		setString("nrSequenciaFeriado",value);
	}


	public String getCidade(){
		return toString("cidade");
	}

	public void setCidade(String value){
		setString("cidade",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.cd.entity.eFeriado newInstance(){
		return new com.br.client.model.cd.entity.eFeriado();
	}
}