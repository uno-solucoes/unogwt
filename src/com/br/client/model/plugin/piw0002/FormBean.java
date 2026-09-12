package com.br.client.model.plugin.piw0002;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public com.br.client.model.plugin.entity.eEventTask getEntityTarefa(){
		Object obj = _self.get("entityTarefa");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.plugin.entity.eEventTask)obj;

	}

	public void setEntityTarefa(com.br.client.model.plugin.entity.eEventTask value){
		_self.remove("entityTarefa");
		if ( value != null )
			_self.put("entityTarefa", value);

	}


	public com.br.client.model.plugin.entity.eEventTask getEntityTarefas(){
		Object obj = _self.get("entityTarefas");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.plugin.entity.eEventTask)obj;

	}

	public void setEntityTarefas(com.br.client.model.plugin.entity.eEventTask value){
		_self.remove("entityTarefas");
		if ( value != null )
			_self.put("entityTarefas", value);

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


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "entityTarefa".equalsIgnoreCase(name) ){
			com.br.client.model.plugin.entity.eEventTask obj = new com.br.client.model.plugin.entity.eEventTask();
			_self.put(name,obj);
		}
		if ( "entityTarefas".equalsIgnoreCase(name) ){
			com.br.client.model.plugin.entity.eEventTask obj = new com.br.client.model.plugin.entity.eEventTask();
			_self.put(name,obj);
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "entityTarefa".equalsIgnoreCase(name) ){
			com.br.client.model.plugin.entity.eEventTask obj = com.br.client.model.plugin.entity.eEventTask.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityTarefas".equalsIgnoreCase(name) ){
			com.br.client.model.plugin.entity.eEventTask obj = com.br.client.model.plugin.entity.eEventTask.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.plugin.piw0002.FormBean newInstance(){
		return new com.br.client.model.plugin.piw0002.FormBean();
	}
}