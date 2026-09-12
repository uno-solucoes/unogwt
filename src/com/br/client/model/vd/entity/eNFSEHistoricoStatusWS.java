package com.br.client.model.vd.entity;

public class eNFSEHistoricoStatusWS extends com.howmake.client.form.model.HowMGWTFormBean{
	public eNFSEHistoricoStatusWS(){
	}


	public String getDtHistorico(){
		return toString("dtHistorico");
	}

	public void setDtHistorico(String value){
		setString("dtHistorico",value);
	}


	public String getMsgHistorico(){
		return toString("msgHistorico");
	}

	public void setMsgHistorico(String value){
		setString("msgHistorico",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.eNFSEHistoricoStatusWS newInstance(){
		return new com.br.client.model.vd.entity.eNFSEHistoricoStatusWS();
	}
}