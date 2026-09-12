package com.br.client.model.fn.fnw0015;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public com.br.client.model.fn.entity.eBoletimCaixa[] getTitulos(){
		Object obj = _self.get("titulos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.fn.entity.eBoletimCaixa[])obj;

	}

	public void setTitulos(com.br.client.model.fn.entity.eBoletimCaixa[] value){
		_self.remove("titulos");
		if ( value != null );
			_self.put("titulos", value);

	}


	public com.br.client.model.fn.entity.eBoletimCaixa[] getTransferencias(){
		Object obj = _self.get("transferencias");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.fn.entity.eBoletimCaixa[])obj;

	}

	public void setTransferencias(com.br.client.model.fn.entity.eBoletimCaixa[] value){
		_self.remove("transferencias");
		if ( value != null );
			_self.put("transferencias", value);

	}


	public com.br.client.model.fn.entity.eBoletimCaixa[] getPosicaoCaixa(){
		Object obj = _self.get("posicaoCaixa");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.fn.entity.eBoletimCaixa[])obj;

	}

	public void setPosicaoCaixa(com.br.client.model.fn.entity.eBoletimCaixa[] value){
		_self.remove("posicaoCaixa");
		if ( value != null );
			_self.put("posicaoCaixa", value);

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
		if ( "titulos".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.eBoletimCaixa[] obj = new com.br.client.model.fn.entity.eBoletimCaixa[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.fn.entity.eBoletimCaixa)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "transferencias".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.eBoletimCaixa[] obj = new com.br.client.model.fn.entity.eBoletimCaixa[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.fn.entity.eBoletimCaixa)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "posicaoCaixa".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.eBoletimCaixa[] obj = new com.br.client.model.fn.entity.eBoletimCaixa[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.fn.entity.eBoletimCaixa)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "titulos".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.eBoletimCaixa obj = com.br.client.model.fn.entity.eBoletimCaixa.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "transferencias".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.eBoletimCaixa obj = com.br.client.model.fn.entity.eBoletimCaixa.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "posicaoCaixa".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.eBoletimCaixa obj = com.br.client.model.fn.entity.eBoletimCaixa.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.fn.fnw0015.FormBean newInstance(){
		return new com.br.client.model.fn.fnw0015.FormBean();
	}
}