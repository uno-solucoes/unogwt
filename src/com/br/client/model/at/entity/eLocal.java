package com.br.client.model.at.entity;

public class eLocal extends com.howmake.client.form.model.HowMGWTFormBean{
	public eLocal(){
	}


	public String getCodLocal(){
		return toString("codLocal");
	}

	public void setCodLocal(String value){
		setString("codLocal",value);
	}


	public String getCodTipoLocal(){
		return toString("codTipoLocal");
	}

	public void setCodTipoLocal(String value){
		setString("codTipoLocal",value);
	}


	public String getDescricaoAbreviada(){
		return toString("descricaoAbreviada");
	}

	public void setDescricaoAbreviada(String value){
		setString("descricaoAbreviada",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public int getSITUACAO_CONFIRMADA(){
		return toInteger("SITUACAO_CONFIRMADA");
	}

	public void setSITUACAO_CONFIRMADA(int value){
		setInteger("SITUACAO_CONFIRMADA",value);
	}


	public int getSITUACAO_RESERVADA(){
		return toInteger("SITUACAO_RESERVADA");
	}

	public void setSITUACAO_RESERVADA(int value){
		setInteger("SITUACAO_RESERVADA",value);
	}


	public int getSITUACAO_SEM_AGENDAMENTO(){
		return toInteger("SITUACAO_SEM_AGENDAMENTO");
	}

	public void setSITUACAO_SEM_AGENDAMENTO(int value){
		setInteger("SITUACAO_SEM_AGENDAMENTO",value);
	}


	public com.br.client.model.at.entity.eTipoLocal getTipoLocal(){
		Object obj = _self.get("tipoLocal");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.at.entity.eTipoLocal)obj;

	}

	public void setTipoLocal(com.br.client.model.at.entity.eTipoLocal value){
		_self.remove("tipoLocal");
		if ( value != null )
			_self.put("tipoLocal", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "tipoLocal".equalsIgnoreCase(name) ){
			com.br.client.model.at.entity.eTipoLocal obj = new com.br.client.model.at.entity.eTipoLocal();
			_self.put(name,obj);
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "tipoLocal".equalsIgnoreCase(name) ){
			com.br.client.model.at.entity.eTipoLocal obj = com.br.client.model.at.entity.eTipoLocal.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.at.entity.eLocal newInstance(){
		return new com.br.client.model.at.entity.eLocal();
	}
}