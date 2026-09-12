package com.br.client.model.vd.vdd0032;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public com.br.client.model.vd.entity.eComissaoMargem[] getComissaoMargens(){
		Object obj = _self.get("comissaoMargens");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eComissaoMargem[])obj;

	}

	public void setComissaoMargens(com.br.client.model.vd.entity.eComissaoMargem[] value){
		_self.remove("comissaoMargens");
		if ( value != null )
			_self.put("comissaoMargens", value);

	}


	public com.br.client.model.vd.entity.eComissaoMargem getComissaoMargem(){
		Object obj = _self.get("comissaoMargem");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eComissaoMargem)obj;

	}

	public void setComissaoMargem(com.br.client.model.vd.entity.eComissaoMargem value){
		_self.remove("comissaoMargem");
		if ( value != null )
			_self.put("comissaoMargem", value);

	}


	public com.br.client.model.vd.entity.eComissaoMargemFaixa[] getComissaoMargemFaixas(){
		Object obj = _self.get("comissaoMargemFaixas");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eComissaoMargemFaixa[])obj;

	}

	public void setComissaoMargemFaixas(com.br.client.model.vd.entity.eComissaoMargemFaixa[] value){
		_self.remove("comissaoMargemFaixas");
		if ( value != null )
			_self.put("comissaoMargemFaixas", value);

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
		if ( "comissaoMargens".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eComissaoMargem[] obj = new com.br.client.model.vd.entity.eComissaoMargem[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eComissaoMargem)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "comissaoMargem".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eComissaoMargem obj = new com.br.client.model.vd.entity.eComissaoMargem();
			_self.put(name,obj);
		}
		if ( "comissaoMargemFaixas".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eComissaoMargemFaixa[] obj = new com.br.client.model.vd.entity.eComissaoMargemFaixa[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eComissaoMargemFaixa)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "comissaoMargens".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eComissaoMargem obj = com.br.client.model.vd.entity.eComissaoMargem.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "comissaoMargem".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eComissaoMargem obj = com.br.client.model.vd.entity.eComissaoMargem.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "comissaoMargemFaixas".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eComissaoMargemFaixa obj = com.br.client.model.vd.entity.eComissaoMargemFaixa.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.vd.vdd0032.FormBean newInstance(){
		return new com.br.client.model.vd.vdd0032.FormBean();
	}
}