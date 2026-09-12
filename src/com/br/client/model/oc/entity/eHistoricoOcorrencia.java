package com.br.client.model.oc.entity;

public class eHistoricoOcorrencia extends com.howmake.client.form.model.HowMGWTFormBean{
	public eHistoricoOcorrencia(){
	}


	public String getSeqHistOcorrencia(){
		return toString("seqHistOcorrencia");
	}

	public void setSeqHistOcorrencia(String value){
		setString("seqHistOcorrencia",value);
	}


	public String getCodOcorrencia(){
		return toString("codOcorrencia");
	}

	public void setCodOcorrencia(String value){
		setString("codOcorrencia",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getDtReferencia(){
		return toString("dtReferencia");
	}

	public void setDtReferencia(String value){
		setString("dtReferencia",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getTpHistorico(){
		return toString("tpHistorico");
	}

	public void setTpHistorico(String value){
		setString("tpHistorico",value);
	}


	public String getNomeColaborador(){
		return toString("nomeColaborador");
	}

	public void setNomeColaborador(String value){
		setString("nomeColaborador",value);
	}


	public String getIndHistExtranet(){
		return toString("indHistExtranet");
	}

	public void setIndHistExtranet(String value){
		setString("indHistExtranet",value);
	}


	public String getMotivoOcorrencia(){
		return toString("motivoOcorrencia");
	}

	public void setMotivoOcorrencia(String value){
		setString("motivoOcorrencia",value);
	}


	public String getCodStatus(){
		return toString("codStatus");
	}

	public void setCodStatus(String value){
		setString("codStatus",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.oc.entity.eHistoricoOcorrencia newInstance(){
		return new com.br.client.model.oc.entity.eHistoricoOcorrencia();
	}
}