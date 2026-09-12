package com.br.client.model.vd.entity;

public class eNFSEConfiguracaoWS extends com.howmake.client.form.model.HowMGWTFormBean{
	public eNFSEConfiguracaoWS(){
	}


	public String getNmSenhaMonitoramento(){
		return toString("nmSenhaMonitoramento");
	}

	public void setNmSenhaMonitoramento(String value){
		setString("nmSenhaMonitoramento",value);
	}


	public String getNmUsuario(){
		return toString("nmUsuario");
	}

	public void setNmUsuario(String value){
		setString("nmUsuario",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.eNFSEConfiguracaoWS newInstance(){
		return new com.br.client.model.vd.entity.eNFSEConfiguracaoWS();
	}
}