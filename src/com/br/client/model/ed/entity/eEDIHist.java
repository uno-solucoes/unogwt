package com.br.client.model.ed.entity;

public class eEDIHist extends com.howmake.client.form.model.HowMGWTFormBean{
	public eEDIHist(){
	}


	public String getSeqHistEdi(){
		return toString("seqHistEdi");
	}

	public void setSeqHistEdi(String value){
		setString("seqHistEdi",value);
	}


	public String getTpHist(){
		return toString("tpHist");
	}

	public void setTpHist(String value){
		setString("tpHist",value);
	}


	public String getChave(){
		return toString("chave");
	}

	public void setChave(String value){
		setString("chave",value);
	}


	public String getTpOperacao(){
		return toString("tpOperacao");
	}

	public void setTpOperacao(String value){
		setString("tpOperacao",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getDtImplant(){
		return toString("dtImplant");
	}

	public void setDtImplant(String value){
		setString("dtImplant",value);
	}


	public String getRelatorio(){
		return toString("relatorio");
	}

	public void setRelatorio(String value){
		setString("relatorio",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.ed.entity.eEDIHist newInstance(){
		return new com.br.client.model.ed.entity.eEDIHist();
	}
}