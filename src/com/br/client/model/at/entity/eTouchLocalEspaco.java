package com.br.client.model.at.entity;

public class eTouchLocalEspaco extends com.howmake.client.form.model.HowMGWTFormBean{
	public eTouchLocalEspaco(){
	}


	public String getCodLocal(){
		return toString("codLocal");
	}

	public void setCodLocal(String value){
		setString("codLocal",value);
	}


	public String getCodTipoLocal(){
		return toString("codTipoLocal");
	}

	public void setCodTipoLocal(String value){
		setString("codTipoLocal",value);
	}


	public String getDescAbrevLocal(){
		return toString("descAbrevLocal");
	}

	public void setDescAbrevLocal(String value){
		setString("descAbrevLocal",value);
	}


	public String getDescricaoLocal(){
		return toString("descricaoLocal");
	}

	public void setDescricaoLocal(String value){
		setString("descricaoLocal",value);
	}


	public String getDescaAbrevTipoLocal(){
		return toString("descaAbrevTipoLocal");
	}

	public void setDescaAbrevTipoLocal(String value){
		setString("descaAbrevTipoLocal",value);
	}


	public com.br.client.model.at.entity.eTouchAgenda[] getEntityTouchAgendas(){
		Object obj = _self.get("entityTouchAgendas");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.at.entity.eTouchAgenda[])obj;

	}

	public void setEntityTouchAgendas(com.br.client.model.at.entity.eTouchAgenda[] value){
		_self.remove("entityTouchAgendas");
		if ( value != null )
			_self.put("entityTouchAgendas", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "entityTouchAgendas".equalsIgnoreCase(name) ){
			com.br.client.model.at.entity.eTouchAgenda[] obj = new com.br.client.model.at.entity.eTouchAgenda[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.at.entity.eTouchAgenda)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "entityTouchAgendas".equalsIgnoreCase(name) ){
			com.br.client.model.at.entity.eTouchAgenda obj = com.br.client.model.at.entity.eTouchAgenda.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.at.entity.eTouchLocalEspaco newInstance(){
		return new com.br.client.model.at.entity.eTouchLocalEspaco();
	}
}