package com.br.client.model.vd.vdw0800;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public com.br.client.model.vd.entity.eNFSECidade[] getCidades(){
		Object obj = _self.get("cidades");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSECidade[])obj;

	}

	public void setCidades(com.br.client.model.vd.entity.eNFSECidade[] value){
		_self.remove("cidades");
		if ( value != null )
			_self.put("cidades", value);

	}


	public com.br.client.model.vd.entity.eNFSEEstatisticas[] getParticipacaoPadroesVariacoes(){
		Object obj = _self.get("participacaoPadroesVariacoes");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSEEstatisticas[])obj;

	}

	public void setParticipacaoPadroesVariacoes(com.br.client.model.vd.entity.eNFSEEstatisticas[] value){
		_self.remove("participacaoPadroesVariacoes");
		if ( value != null )
			_self.put("participacaoPadroesVariacoes", value);

	}


	public com.br.client.model.vd.entity.eNFSEEstatisticas[] getParticipacaoPadroes(){
		Object obj = _self.get("participacaoPadroes");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSEEstatisticas[])obj;

	}

	public void setParticipacaoPadroes(com.br.client.model.vd.entity.eNFSEEstatisticas[] value){
		_self.remove("participacaoPadroes");
		if ( value != null )
			_self.put("participacaoPadroes", value);

	}


	public com.br.client.model.vd.entity.eNFSEEstatisticas[] getParticipacaoEstados(){
		Object obj = _self.get("participacaoEstados");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSEEstatisticas[])obj;

	}

	public void setParticipacaoEstados(com.br.client.model.vd.entity.eNFSEEstatisticas[] value){
		_self.remove("participacaoEstados");
		if ( value != null )
			_self.put("participacaoEstados", value);

	}


	public com.br.client.model.vd.entity.eNFSEEstatisticas[] getParticipacaoGeral(){
		Object obj = _self.get("participacaoGeral");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSEEstatisticas[])obj;

	}

	public void setParticipacaoGeral(com.br.client.model.vd.entity.eNFSEEstatisticas[] value){
		_self.remove("participacaoGeral");
		if ( value != null )
			_self.put("participacaoGeral", value);

	}


	public int getOPERATION_INSERT(){
		return toInteger("OPERATION_INSERT");
	}

	public void setOPERATION_INSERT(int value){
		setInteger("OPERATION_INSERT",value);
	}


	public int getOPERATION_UPDATE(){
		return toInteger("OPERATION_UPDATE");
	}

	public void setOPERATION_UPDATE(int value){
		setInteger("OPERATION_UPDATE",value);
	}


	public int getOPERATION_DELETE(){
		return toInteger("OPERATION_DELETE");
	}

	public void setOPERATION_DELETE(int value){
		setInteger("OPERATION_DELETE",value);
	}


	public int getOPERATION_QUERY(){
		return toInteger("OPERATION_QUERY");
	}

	public void setOPERATION_QUERY(int value){
		setInteger("OPERATION_QUERY",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "cidades".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSECidade[] obj = new com.br.client.model.vd.entity.eNFSECidade[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eNFSECidade)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "participacaoPadroesVariacoes".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEEstatisticas[] obj = new com.br.client.model.vd.entity.eNFSEEstatisticas[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eNFSEEstatisticas)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "participacaoPadroes".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEEstatisticas[] obj = new com.br.client.model.vd.entity.eNFSEEstatisticas[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eNFSEEstatisticas)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "participacaoEstados".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEEstatisticas[] obj = new com.br.client.model.vd.entity.eNFSEEstatisticas[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eNFSEEstatisticas)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "participacaoGeral".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEEstatisticas[] obj = new com.br.client.model.vd.entity.eNFSEEstatisticas[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eNFSEEstatisticas)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "cidades".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSECidade obj = com.br.client.model.vd.entity.eNFSECidade.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "participacaoPadroesVariacoes".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEEstatisticas obj = com.br.client.model.vd.entity.eNFSEEstatisticas.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "participacaoPadroes".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEEstatisticas obj = com.br.client.model.vd.entity.eNFSEEstatisticas.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "participacaoEstados".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEEstatisticas obj = com.br.client.model.vd.entity.eNFSEEstatisticas.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "participacaoGeral".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEEstatisticas obj = com.br.client.model.vd.entity.eNFSEEstatisticas.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.vd.vdw0800.FormBean newInstance(){
		return new com.br.client.model.vd.vdw0800.FormBean();
	}
}