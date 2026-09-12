package com.br.client.model.cd.entity;

public class eFormaPagamento extends com.howmake.client.form.model.HowMGWTFormBean{
	public eFormaPagamento(){
	}


	public String getCodFormaPagto(){
		return toString("codFormaPagto");
	}

	public void setCodFormaPagto(String value){
		setString("codFormaPagto",value);
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


	public String getTpPagto(){
		return toString("tpPagto");
	}

	public void setTpPagto(String value){
		setString("tpPagto",value);
	}


	public String getConciliacaoAutomatica(){
		return toString("conciliacaoAutomatica");
	}

	public void setConciliacaoAutomatica(String value){
		setString("conciliacaoAutomatica",value);
	}


	public String getIndConcilia(){
		return toString("indConcilia");
	}

	public void setIndConcilia(String value){
		setString("indConcilia",value);
	}


	public String getIndBaixaPdv(){
		return toString("indBaixaPdv");
	}

	public void setIndBaixaPdv(String value){
		setString("indBaixaPdv",value);
	}


	public String getIndPdv(){
		return toString("indPdv");
	}

	public void setIndPdv(String value){
		setString("indPdv",value);
	}


	public String getIndTef(){
		return toString("indTef");
	}

	public void setIndTef(String value){
		setString("indTef",value);
	}


	public String getTefGp(){
		return toString("tefGp");
	}

	public void setTefGp(String value){
		setString("tefGp",value);
	}


	public String getTefCmd(){
		return toString("tefCmd");
	}

	public void setTefCmd(String value){
		setString("tefCmd",value);
	}


	public String getIndRevenda(){
		return toString("indRevenda");
	}

	public void setIndRevenda(String value){
		setString("indRevenda",value);
	}


	public String getCodBanco(){
		return toString("codBanco");
	}

	public void setCodBanco(String value){
		setString("codBanco",value);
	}


	public String getIndSelecionado(){
		return toString("indSelecionado");
	}

	public void setIndSelecionado(String value){
		setString("indSelecionado",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.cd.entity.eFormaPagamento newInstance(){
		return new com.br.client.model.cd.entity.eFormaPagamento();
	}
}