package com.br.client.model.ed.entity;

public class eEDIPedido extends com.howmake.client.form.model.HowMGWTFormBean{
	public eEDIPedido(){
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getCodPedido(){
		return toString("codPedido");
	}

	public void setCodPedido(String value){
		setString("codPedido",value);
	}


	public String getCodCliente(){
		return toString("codCliente");
	}

	public void setCodCliente(String value){
		setString("codCliente",value);
	}


	public String getCodReserva(){
		return toString("codReserva");
	}

	public void setCodReserva(String value){
		setString("codReserva",value);
	}


	public com.br.client.model.cd.entity.eCliente getCliente(){
		Object obj = _self.get("cliente");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.cd.entity.eCliente)obj;

	}

	public void setCliente(com.br.client.model.cd.entity.eCliente value){
		_self.remove("cliente");
		if ( value != null )
			_self.put("cliente", value);

	}


	public com.br.client.model.ed.entity.eEDIPedidoVendaItem[] getItens(){
		Object obj = _self.get("itens");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eEDIPedidoVendaItem[])obj;

	}

	public void setItens(com.br.client.model.ed.entity.eEDIPedidoVendaItem[] value){
		_self.remove("itens");
		if ( value != null )
			_self.put("itens", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "cliente".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eCliente obj = new com.br.client.model.cd.entity.eCliente();
			_self.put(name,obj);
		}
		if ( "itens".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDIPedidoVendaItem[] obj = new com.br.client.model.ed.entity.eEDIPedidoVendaItem[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.ed.entity.eEDIPedidoVendaItem)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "cliente".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eCliente obj = com.br.client.model.cd.entity.eCliente.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "itens".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDIPedidoVendaItem obj = com.br.client.model.ed.entity.eEDIPedidoVendaItem.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.ed.entity.eEDIPedido newInstance(){
		return new com.br.client.model.ed.entity.eEDIPedido();
	}
}