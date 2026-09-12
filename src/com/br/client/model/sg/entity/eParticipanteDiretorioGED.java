package com.br.client.model.sg.entity;

public class eParticipanteDiretorioGED extends com.howmake.client.form.model.HowMGWTFormBean{
	public eParticipanteDiretorioGED(){
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getCodDiretorioGED(){
		return toString("codDiretorioGED");
	}

	public void setCodDiretorioGED(String value){
		setString("codDiretorioGED",value);
	}


	public String getIdColaborador(){
		return toString("idColaborador");
	}

	public void setIdColaborador(String value){
		setString("idColaborador",value);
	}


	public String getTpParticipacao(){
		return toString("tpParticipacao");
	}

	public void setTpParticipacao(String value){
		setString("tpParticipacao",value);
	}


	public String getParticipacao(){
		return toString("participacao");
	}

	public void setParticipacao(String value){
		setString("participacao",value);
	}


	public String getEmail(){
		return toString("email");
	}

	public void setEmail(String value){
		setString("email",value);
	}


	public String getNomeColaborador(){
		return toString("nomeColaborador");
	}

	public void setNomeColaborador(String value){
		setString("nomeColaborador",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.sg.entity.eParticipanteDiretorioGED newInstance(){
		return new com.br.client.model.sg.entity.eParticipanteDiretorioGED();
	}
}