package com.br.client.model.cd.cdd0007;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public String getCodCliente(){
		return toString("codCliente");
	}

	public void setCodCliente(String value){
		setString("codCliente",value);
	}


	public com.br.client.model.cd.entity.eClienteCondicaoPagamento[] getCondicoesPagamento(){
		Object obj = _self.get("condicoesPagamento");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.cd.entity.eClienteCondicaoPagamento[])obj;

	}

	public void setCondicoesPagamento(com.br.client.model.cd.entity.eClienteCondicaoPagamento[] value){
		_self.remove("condicoesPagamento");
		if ( value != null );
			_self.put("condicoesPagamento", value);

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
		if ( "condicoesPagamento".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eClienteCondicaoPagamento[] obj = new com.br.client.model.cd.entity.eClienteCondicaoPagamento[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.cd.entity.eClienteCondicaoPagamento)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "condicoesPagamento".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eClienteCondicaoPagamento obj = com.br.client.model.cd.entity.eClienteCondicaoPagamento.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.cd.cdd0007.FormBean newInstance(){
		return new com.br.client.model.cd.cdd0007.FormBean();
	}
}