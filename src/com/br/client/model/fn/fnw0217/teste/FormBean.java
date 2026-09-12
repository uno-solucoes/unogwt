package com.br.client.model.fn.fnw0217.teste;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public com.br.client.model.fn.fnw0217.teste.EntityPlanoContas[] getEntityPlanoConta(){
		Object obj = _self.get("entityPlanoConta");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.fn.fnw0217.teste.EntityPlanoContas[])obj;

	}

	public void setEntityPlanoConta(com.br.client.model.fn.fnw0217.teste.EntityPlanoContas[] value){
		_self.remove("entityPlanoConta");
		if ( value != null )
			_self.put("entityPlanoConta", value);

	}


	public com.br.client.model.fn.fnw0217.teste.EntityPlanoContas[] getEntityPlanoContas(){
		Object obj = _self.get("entityPlanoContas");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.fn.fnw0217.teste.EntityPlanoContas[])obj;

	}

	public void setEntityPlanoContas(com.br.client.model.fn.fnw0217.teste.EntityPlanoContas[] value){
		_self.remove("entityPlanoContas");
		if ( value != null )
			_self.put("entityPlanoContas", value);

	}


	public String getGeoScript(){
		return toString("geoScript");
	}

	public void setGeoScript(String value){
		setString("geoScript",value);
	}


	public String getLabelCustoTotal(){
		return toString("labelCustoTotal");
	}

	public void setLabelCustoTotal(String value){
		setString("labelCustoTotal",value);
	}


	public String getTitleCustoTotal(){
		return toString("titleCustoTotal");
	}

	public void setTitleCustoTotal(String value){
		setString("titleCustoTotal",value);
	}


	public String getErroDetail(){
		return toString("erroDetail");
	}

	public void setErroDetail(String value){
		setString("erroDetail",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "entityPlanoConta".equalsIgnoreCase(name) ){
			com.br.client.model.fn.fnw0217.teste.EntityPlanoContas[] obj = new com.br.client.model.fn.fnw0217.teste.EntityPlanoContas[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.fn.fnw0217.teste.EntityPlanoContas)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "entityPlanoContas".equalsIgnoreCase(name) ){
			com.br.client.model.fn.fnw0217.teste.EntityPlanoContas[] obj = new com.br.client.model.fn.fnw0217.teste.EntityPlanoContas[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.fn.fnw0217.teste.EntityPlanoContas)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "entityPlanoConta".equalsIgnoreCase(name) ){
			com.br.client.model.fn.fnw0217.teste.EntityPlanoContas obj = com.br.client.model.fn.fnw0217.teste.EntityPlanoContas.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityPlanoContas".equalsIgnoreCase(name) ){
			com.br.client.model.fn.fnw0217.teste.EntityPlanoContas obj = com.br.client.model.fn.fnw0217.teste.EntityPlanoContas.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.fn.fnw0217.teste.FormBean newInstance(){
		return new com.br.client.model.fn.fnw0217.teste.FormBean();
	}
}