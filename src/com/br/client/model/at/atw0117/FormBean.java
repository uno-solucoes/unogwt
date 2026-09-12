package com.br.client.model.at.atw0117;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getDataInicio(){
		return toString("dataInicio");
	}

	public void setDataInicio(String value){
		setString("dataInicio",value);
	}


	public String getDataFim(){
		return toString("dataFim");
	}

	public void setDataFim(String value){
		setString("dataFim",value);
	}


	public String getCodLocal(){
		return toString("codLocal");
	}

	public void setCodLocal(String value){
		setString("codLocal",value);
	}


	public com.br.client.model.cd.entity.eFeriado[] getEntityFeriados(){
		Object obj = _self.get("entityFeriados");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.cd.entity.eFeriado[])obj;

	}

	public void setEntityFeriados(com.br.client.model.cd.entity.eFeriado[] value){
		_self.remove("entityFeriados");
		if ( value != null )
			_self.put("entityFeriados", value);

	}


	public String getIndPodeSalvar(){
		return toString("indPodeSalvar");
	}

	public void setIndPodeSalvar(String value){
		setString("indPodeSalvar",value);
	}


	public String getIndPermiteAlterarCalendario(){
		return toString("indPermiteAlterarCalendario");
	}

	public void setIndPermiteAlterarCalendario(String value){
		setString("indPermiteAlterarCalendario",value);
	}


	public String getIndPermiteExcluirCalendario(){
		return toString("indPermiteExcluirCalendario");
	}

	public void setIndPermiteExcluirCalendario(String value){
		setString("indPermiteExcluirCalendario",value);
	}


	public String getIndPermiteIncluirCalendario(){
		return toString("indPermiteIncluirCalendario");
	}

	public void setIndPermiteIncluirCalendario(String value){
		setString("indPermiteIncluirCalendario",value);
	}


	public String getIndPermiteAprovarCalendario(){
		return toString("indPermiteAprovarCalendario");
	}

	public void setIndPermiteAprovarCalendario(String value){
		setString("indPermiteAprovarCalendario",value);
	}


	public com.br.client.model.at.entity.eTouchLocalEspaco[] getEntityTouchLocaisEspacos(){
		Object obj = _self.get("entityTouchLocaisEspacos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.at.entity.eTouchLocalEspaco[])obj;

	}

	public void setEntityTouchLocaisEspacos(com.br.client.model.at.entity.eTouchLocalEspaco[] value){
		_self.remove("entityTouchLocaisEspacos");
		if ( value != null )
			_self.put("entityTouchLocaisEspacos", value);

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


	public com.br.client.model.at.entity.eTouchResumo[] getEntityTouchResumo(){
		Object obj = _self.get("entityTouchResumo");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.at.entity.eTouchResumo[])obj;

	}

	public void setEntityTouchResumo(com.br.client.model.at.entity.eTouchResumo[] value){
		_self.remove("entityTouchResumo");
		if ( value != null )
			_self.put("entityTouchResumo", value);

	}


	public com.br.client.model.at.entity.eTouchAgenda getEntityTouchAgenda(){
		Object obj = _self.get("entityTouchAgenda");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.at.entity.eTouchAgenda)obj;

	}

	public void setEntityTouchAgenda(com.br.client.model.at.entity.eTouchAgenda value){
		_self.remove("entityTouchAgenda");
		if ( value != null )
			_self.put("entityTouchAgenda", value);

	}


	public String getLogotipo(){
		return toString("logotipo");
	}

	public void setLogotipo(String value){
		setString("logotipo",value);
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
		if ( "entityFeriados".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eFeriado[] obj = new com.br.client.model.cd.entity.eFeriado[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.cd.entity.eFeriado)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "entityTouchLocaisEspacos".equalsIgnoreCase(name) ){
			com.br.client.model.at.entity.eTouchLocalEspaco[] obj = new com.br.client.model.at.entity.eTouchLocalEspaco[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.at.entity.eTouchLocalEspaco)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "entityTouchAgendas".equalsIgnoreCase(name) ){
			com.br.client.model.at.entity.eTouchAgenda[] obj = new com.br.client.model.at.entity.eTouchAgenda[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.at.entity.eTouchAgenda)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "entityTouchResumo".equalsIgnoreCase(name) ){
			com.br.client.model.at.entity.eTouchResumo[] obj = new com.br.client.model.at.entity.eTouchResumo[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.at.entity.eTouchResumo)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "entityTouchAgenda".equalsIgnoreCase(name) ){
			com.br.client.model.at.entity.eTouchAgenda obj = new com.br.client.model.at.entity.eTouchAgenda();
			_self.put(name,obj);
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "entityFeriados".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eFeriado obj = com.br.client.model.cd.entity.eFeriado.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityTouchLocaisEspacos".equalsIgnoreCase(name) ){
			com.br.client.model.at.entity.eTouchLocalEspaco obj = com.br.client.model.at.entity.eTouchLocalEspaco.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityTouchAgendas".equalsIgnoreCase(name) ){
			com.br.client.model.at.entity.eTouchAgenda obj = com.br.client.model.at.entity.eTouchAgenda.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityTouchResumo".equalsIgnoreCase(name) ){
			com.br.client.model.at.entity.eTouchResumo obj = com.br.client.model.at.entity.eTouchResumo.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityTouchAgenda".equalsIgnoreCase(name) ){
			com.br.client.model.at.entity.eTouchAgenda obj = com.br.client.model.at.entity.eTouchAgenda.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.at.atw0117.FormBean newInstance(){
		return new com.br.client.model.at.atw0117.FormBean();
	}
}