package com.br.client.model.vd.vdw0030;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public com.br.client.model.vd.entity.eMotivoDevolucao getMotivoDevolucao(){
		Object obj = _self.get("motivoDevolucao");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eMotivoDevolucao)obj;

	}

	public void setMotivoDevolucao(com.br.client.model.vd.entity.eMotivoDevolucao value){
		_self.remove("motivoDevolucao");
		if ( value != null )
			_self.put("motivoDevolucao", value);

	}


	public com.br.client.model.vd.entity.eMotivoDevolucao[] getMotivosDevolucao(){
		Object obj = _self.get("motivosDevolucao");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eMotivoDevolucao[])obj;

	}

	public void setMotivosDevolucao(com.br.client.model.vd.entity.eMotivoDevolucao[] value){
		_self.remove("motivosDevolucao");
		if ( value != null )
			_self.put("motivosDevolucao", value);

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
		if ( "motivoDevolucao".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eMotivoDevolucao obj = new com.br.client.model.vd.entity.eMotivoDevolucao();
			_self.put(name,obj);
		}
		if ( "motivosDevolucao".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eMotivoDevolucao[] obj = new com.br.client.model.vd.entity.eMotivoDevolucao[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eMotivoDevolucao)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "motivoDevolucao".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eMotivoDevolucao obj = com.br.client.model.vd.entity.eMotivoDevolucao.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "motivosDevolucao".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eMotivoDevolucao obj = com.br.client.model.vd.entity.eMotivoDevolucao.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.vd.vdw0030.FormBean newInstance(){
		return new com.br.client.model.vd.vdw0030.FormBean();
	}
}