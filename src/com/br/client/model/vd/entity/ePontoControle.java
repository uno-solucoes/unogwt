package com.br.client.model.vd.entity;

public class ePontoControle extends com.howmake.client.form.model.HowMGWTFormBean{
	public ePontoControle(){
	}


	public String getCodControle(){
		return toString("codControle");
	}

	public void setCodControle(String value){
		setString("codControle",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getTempoMaximo(){
		return toString("tempoMaximo");
	}

	public void setTempoMaximo(String value){
		setString("tempoMaximo",value);
	}


	public String getMsgAviso(){
		return toString("msgAviso");
	}

	public void setMsgAviso(String value){
		setString("msgAviso",value);
	}


	public String getEmailAviso(){
		return toString("emailAviso");
	}

	public void setEmailAviso(String value){
		setString("emailAviso",value);
	}


	public String getIsChecked(){
		return toString("isChecked");
	}

	public void setIsChecked(String value){
		setString("isChecked",value);
	}


	public String getTextoEmailCliente(){
		return toString("textoEmailCliente");
	}

	public void setTextoEmailCliente(String value){
		setString("textoEmailCliente",value);
	}


	public String getTextoEmailRevenda(){
		return toString("textoEmailRevenda");
	}

	public void setTextoEmailRevenda(String value){
		setString("textoEmailRevenda",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.ePontoControle newInstance(){
		return new com.br.client.model.vd.entity.ePontoControle();
	}
}