package com.br.client.model.oc.entity;

public class eProblemaSolucaoOcorrencia extends com.howmake.client.form.model.HowMGWTFormBean{
	public eProblemaSolucaoOcorrencia(){
	}


	public String getCodSolucao(){
		return toString("codSolucao");
	}

	public void setCodSolucao(String value){
		setString("codSolucao",value);
	}


	public String getCodProblema(){
		return toString("codProblema");
	}

	public void setCodProblema(String value){
		setString("codProblema",value);
	}


	public String getPrioridade(){
		return toString("prioridade");
	}

	public void setPrioridade(String value){
		setString("prioridade",value);
	}


	public String getResponsavel(){
		return toString("responsavel");
	}

	public void setResponsavel(String value){
		setString("responsavel",value);
	}


	public String getCodMotivo(){
		return toString("codMotivo");
	}

	public void setCodMotivo(String value){
		setString("codMotivo",value);
	}


	public String getResposta(){
		return toString("resposta");
	}

	public void setResposta(String value){
		setString("resposta",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.oc.entity.eProblemaSolucaoOcorrencia newInstance(){
		return new com.br.client.model.oc.entity.eProblemaSolucaoOcorrencia();
	}
}