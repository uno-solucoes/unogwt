package com.br.client.model.oc.entity;

public class eLigacaoOcorrencia extends com.howmake.client.form.model.HowMGWTFormBean{
	public eLigacaoOcorrencia(){
	}


	public String getCodCliente(){
		return toString("codCliente");
	}

	public void setCodCliente(String value){
		setString("codCliente",value);
	}


	public String getCodContato(){
		return toString("codContato");
	}

	public void setCodContato(String value){
		setString("codContato",value);
	}


	public String getCodLigacao(){
		return toString("codLigacao");
	}

	public void setCodLigacao(String value){
		setString("codLigacao",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getCodOcorrencia(){
		return toString("codOcorrencia");
	}

	public void setCodOcorrencia(String value){
		setString("codOcorrencia",value);
	}


	public String getDtReferencia(){
		return toString("dtReferencia");
	}

	public void setDtReferencia(String value){
		setString("dtReferencia",value);
	}


	public String getHoraIni(){
		return toString("horaIni");
	}

	public void setHoraIni(String value){
		setString("horaIni",value);
	}


	public String getHoraFim(){
		return toString("horaFim");
	}

	public void setHoraFim(String value){
		setString("horaFim",value);
	}


	public String getTelefone(){
		return toString("telefone");
	}

	public void setTelefone(String value){
		setString("telefone",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getDdd(){
		return toString("ddd");
	}

	public void setDdd(String value){
		setString("ddd",value);
	}


	public String getRamal(){
		return toString("ramal");
	}

	public void setRamal(String value){
		setString("ramal",value);
	}


	public String getTpTelefone(){
		return toString("tpTelefone");
	}

	public void setTpTelefone(String value){
		setString("tpTelefone",value);
	}


	public String getTempoLigacao(){
		return toString("tempoLigacao");
	}

	public void setTempoLigacao(String value){
		setString("tempoLigacao",value);
	}


	public String getHrRetorno(){
		return toString("hrRetorno");
	}

	public void setHrRetorno(String value){
		setString("hrRetorno",value);
	}


	public String getDtRetorno(){
		return toString("dtRetorno");
	}

	public void setDtRetorno(String value){
		setString("dtRetorno",value);
	}


	public String getCodStatus(){
		return toString("codStatus");
	}

	public void setCodStatus(String value){
		setString("codStatus",value);
	}


	public String getCodOportunidade(){
		return toString("codOportunidade");
	}

	public void setCodOportunidade(String value){
		setString("codOportunidade",value);
	}


	public String getMensagemEmail(){
		return toString("mensagemEmail");
	}

	public void setMensagemEmail(String value){
		setString("mensagemEmail",value);
	}


	public String getNomeColaborador(){
		return toString("nomeColaborador");
	}

	public void setNomeColaborador(String value){
		setString("nomeColaborador",value);
	}


	public String getNomeCategoria(){
		return toString("nomeCategoria");
	}

	public void setNomeCategoria(String value){
		setString("nomeCategoria",value);
	}


	public String getIdColaborador(){
		return toString("idColaborador");
	}

	public void setIdColaborador(String value){
		setString("idColaborador",value);
	}


	public String getDtInicial(){
		return toString("dtInicial");
	}

	public void setDtInicial(String value){
		setString("dtInicial",value);
	}


	public String getDtFim(){
		return toString("dtFim");
	}

	public void setDtFim(String value){
		setString("dtFim",value);
	}


	public String getNomeCliente(){
		return toString("nomeCliente");
	}

	public void setNomeCliente(String value){
		setString("nomeCliente",value);
	}


	public String getDescMotivo(){
		return toString("descMotivo");
	}

	public void setDescMotivo(String value){
		setString("descMotivo",value);
	}


	public String getNomeContato(){
		return toString("nomeContato");
	}

	public void setNomeContato(String value){
		setString("nomeContato",value);
	}


	public String getTempoAtendimento(){
		return toString("tempoAtendimento");
	}

	public void setTempoAtendimento(String value){
		setString("tempoAtendimento",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.oc.entity.eLigacaoOcorrencia newInstance(){
		return new com.br.client.model.oc.entity.eLigacaoOcorrencia();
	}
}