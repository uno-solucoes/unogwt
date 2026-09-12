package com.br.client.model.eq.entity;

public class eDeposito extends com.howmake.client.form.model.HowMGWTFormBean{
	public eDeposito(){
	}


	public String getCodDeposito(){
		return toString("codDeposito");
	}

	public void setCodDeposito(String value){
		setString("codDeposito",value);
	}


	public String getDescAbrev(){
		return toString("descAbrev");
	}

	public void setDescAbrev(String value){
		setString("descAbrev",value);
	}


	public String getConsSaldo(){
		return toString("consSaldo");
	}

	public void setConsSaldo(String value){
		setString("consSaldo",value);
	}


	public String getIndPlanejamento(){
		return toString("indPlanejamento");
	}

	public void setIndPlanejamento(String value){
		setString("indPlanejamento",value);
	}


	public String getIndProducao(){
		return toString("indProducao");
	}

	public void setIndProducao(String value){
		setString("indProducao",value);
	}


	public String getIndSeparacao(){
		return toString("indSeparacao");
	}

	public void setIndSeparacao(String value){
		setString("indSeparacao",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public com.br.client.model.eq.entity.eSaldoDeposito[] getSaldos(){
		Object obj = _self.get("saldos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.eq.entity.eSaldoDeposito[])obj;

	}

	public void setSaldos(com.br.client.model.eq.entity.eSaldoDeposito[] value){
		_self.remove("saldos");
		if ( value != null )
			_self.put("saldos", value);

	}


	public com.br.client.model.eq.entity.eSaldoTerceiro[] getSaldosTerceiros(){
		Object obj = _self.get("saldosTerceiros");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.eq.entity.eSaldoTerceiro[])obj;

	}

	public void setSaldosTerceiros(com.br.client.model.eq.entity.eSaldoTerceiro[] value){
		_self.remove("saldosTerceiros");
		if ( value != null )
			_self.put("saldosTerceiros", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "saldos".equalsIgnoreCase(name) ){
			com.br.client.model.eq.entity.eSaldoDeposito[] obj = new com.br.client.model.eq.entity.eSaldoDeposito[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.eq.entity.eSaldoDeposito)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "saldosTerceiros".equalsIgnoreCase(name) ){
			com.br.client.model.eq.entity.eSaldoTerceiro[] obj = new com.br.client.model.eq.entity.eSaldoTerceiro[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.eq.entity.eSaldoTerceiro)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "saldos".equalsIgnoreCase(name) ){
			com.br.client.model.eq.entity.eSaldoDeposito obj = com.br.client.model.eq.entity.eSaldoDeposito.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "saldosTerceiros".equalsIgnoreCase(name) ){
			com.br.client.model.eq.entity.eSaldoTerceiro obj = com.br.client.model.eq.entity.eSaldoTerceiro.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.eq.entity.eDeposito newInstance(){
		return new com.br.client.model.eq.entity.eDeposito();
	}
}