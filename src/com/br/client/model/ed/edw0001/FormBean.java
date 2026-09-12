package com.br.client.model.ed.edw0001;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public com.br.client.model.ed.entity.eEDI[] getEdis(){
		Object obj = _self.get("edis");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eEDI[])obj;

	}

	public void setEdis(com.br.client.model.ed.entity.eEDI[] value){
		_self.remove("edis");
		if ( value != null )
			_self.put("edis", value);

	}


	public com.br.client.model.ed.entity.eEDI getEdi(){
		Object obj = _self.get("edi");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eEDI)obj;

	}

	public void setEdi(com.br.client.model.ed.entity.eEDI value){
		_self.remove("edi");
		if ( value != null )
			_self.put("edi", value);

	}


	public com.br.client.model.ed.entity.eEDISituacoes[] getSituacoes(){
		Object obj = _self.get("situacoes");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eEDISituacoes[])obj;

	}

	public void setSituacoes(com.br.client.model.ed.entity.eEDISituacoes[] value){
		_self.remove("situacoes");
		if ( value != null )
			_self.put("situacoes", value);

	}


	public com.br.client.model.eq.entity.eDeposito[] getDepositos(){
		Object obj = _self.get("depositos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.eq.entity.eDeposito[])obj;

	}

	public void setDepositos(com.br.client.model.eq.entity.eDeposito[] value){
		_self.remove("depositos");
		if ( value != null )
			_self.put("depositos", value);

	}


	public com.br.client.model.cd.entity.eProduto[] getProdutos(){
		Object obj = _self.get("produtos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.cd.entity.eProduto[])obj;

	}

	public void setProdutos(com.br.client.model.cd.entity.eProduto[] value){
		_self.remove("produtos");
		if ( value != null )
			_self.put("produtos", value);

	}


	public com.br.client.model.ed.entity.eEDIProduto[] getEdiProdutos(){
		Object obj = _self.get("ediProdutos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eEDIProduto[])obj;

	}

	public void setEdiProdutos(com.br.client.model.ed.entity.eEDIProduto[] value){
		_self.remove("ediProdutos");
		if ( value != null )
			_self.put("ediProdutos", value);

	}


	public java.lang.String[] getClassesBO(){
		Object obj = _self.get("classesBO");
		if ( obj == null )
			return null;
		else
			return (java.lang.String[])obj;

	}

	public void setClassesBO(java.lang.String[] value){
		_self.remove("classesBO");
		if ( value != null )
			_self.put("classesBO", value);

	}


	public int[] getTeste(){
		return toIntegerArray("teste");
	}

	public void setTeste(int[] value){
		setIntegerArray("teste",value);
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
		if ( "edis".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDI[] obj = new com.br.client.model.ed.entity.eEDI[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.ed.entity.eEDI)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "edi".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDI obj = new com.br.client.model.ed.entity.eEDI();
			_self.put(name,obj);
		}
		if ( "situacoes".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDISituacoes[] obj = new com.br.client.model.ed.entity.eEDISituacoes[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.ed.entity.eEDISituacoes)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "depositos".equalsIgnoreCase(name) ){
			com.br.client.model.eq.entity.eDeposito[] obj = new com.br.client.model.eq.entity.eDeposito[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.eq.entity.eDeposito)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "produtos".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eProduto[] obj = new com.br.client.model.cd.entity.eProduto[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.cd.entity.eProduto)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "ediProdutos".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDIProduto[] obj = new com.br.client.model.ed.entity.eEDIProduto[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.ed.entity.eEDIProduto)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "classesBO".equalsIgnoreCase(name) ){
			java.lang.String[] obj = new java.lang.String[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isString()!= null )
					obj[i] = object.isString().stringValue();
				 
			}
		}
		if ( "teste".equalsIgnoreCase(name) ){
			int[] obj = new int[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isNumber()!= null )
					obj[i] = new Double(object.isNumber().doubleValue()).intValue();
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "edis".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDI obj = com.br.client.model.ed.entity.eEDI.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "edi".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDI obj = com.br.client.model.ed.entity.eEDI.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "situacoes".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDISituacoes obj = com.br.client.model.ed.entity.eEDISituacoes.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "depositos".equalsIgnoreCase(name) ){
			com.br.client.model.eq.entity.eDeposito obj = com.br.client.model.eq.entity.eDeposito.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "produtos".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eProduto obj = com.br.client.model.cd.entity.eProduto.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "ediProdutos".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDIProduto obj = com.br.client.model.ed.entity.eEDIProduto.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.ed.edw0001.FormBean newInstance(){
		return new com.br.client.model.ed.edw0001.FormBean();
	}
}