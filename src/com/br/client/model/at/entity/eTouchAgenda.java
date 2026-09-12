package com.br.client.model.at.entity;

public class eTouchAgenda extends com.howmake.client.form.model.HowMGWTFormBean{
	public eTouchAgenda(){
	}


	public String getCodAgenda(){
		return toString("codAgenda");
	}

	public void setCodAgenda(String value){
		setString("codAgenda",value);
	}


	public String getCodLocal(){
		return toString("codLocal");
	}

	public void setCodLocal(String value){
		setString("codLocal",value);
	}


	public String getCodOrganizador(){
		return toString("codOrganizador");
	}

	public void setCodOrganizador(String value){
		setString("codOrganizador",value);
	}


	public String getCodPedido(){
		return toString("codPedido");
	}

	public void setCodPedido(String value){
		setString("codPedido",value);
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getDtImplant(){
		return toString("dtImplant");
	}

	public void setDtImplant(String value){
		setString("dtImplant",value);
	}


	public String getDtAgendaIni(){
		return toString("dtAgendaIni");
	}

	public void setDtAgendaIni(String value){
		setString("dtAgendaIni",value);
	}


	public String getDtAgendaFim(){
		return toString("dtAgendaFim");
	}

	public void setDtAgendaFim(String value){
		setString("dtAgendaFim",value);
	}


	public String getAssunto(){
		return toString("assunto");
	}

	public void setAssunto(String value){
		setString("assunto",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getSituacao(){
		return toString("situacao");
	}

	public void setSituacao(String value){
		setString("situacao",value);
	}


	public String getCodCliente(){
		return toString("codCliente");
	}

	public void setCodCliente(String value){
		setString("codCliente",value);
	}


	public String getNomeCliente(){
		return toString("nomeCliente");
	}

	public void setNomeCliente(String value){
		setString("nomeCliente",value);
	}


	public String getColaborador(){
		return toString("colaborador");
	}

	public void setColaborador(String value){
		setString("colaborador",value);
	}


	public String getLocal(){
		return toString("local");
	}

	public void setLocal(String value){
		setString("local",value);
	}


	public String getTipoLocal(){
		return toString("tipoLocal");
	}

	public void setTipoLocal(String value){
		setString("tipoLocal",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.at.entity.eTouchAgenda newInstance(){
		return new com.br.client.model.at.entity.eTouchAgenda();
	}
}