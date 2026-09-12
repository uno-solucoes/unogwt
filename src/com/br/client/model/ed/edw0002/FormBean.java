package com.br.client.model.ed.edw0002;

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


	public com.br.client.model.ed.entity.eEDI[] getEdi(){
		Object obj = _self.get("edi");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eEDI[])obj;

	}

	public void setEdi(com.br.client.model.ed.entity.eEDI[] value){
		_self.remove("edi");
		if ( value != null )
			_self.put("edi", value);

	}


	public com.br.client.model.ed.entity.eEDIPedidoVendaItem[] getPedidoItens(){
		Object obj = _self.get("pedidoItens");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eEDIPedidoVendaItem[])obj;

	}

	public void setPedidoItens(com.br.client.model.ed.entity.eEDIPedidoVendaItem[] value){
		_self.remove("pedidoItens");
		if ( value != null )
			_self.put("pedidoItens", value);

	}


	public com.br.client.model.ed.entity.eEDIPedidoVendaItem getEdiPedidoVenda(){
		Object obj = _self.get("ediPedidoVenda");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eEDIPedidoVendaItem)obj;

	}

	public void setEdiPedidoVenda(com.br.client.model.ed.entity.eEDIPedidoVendaItem value){
		_self.remove("ediPedidoVenda");
		if ( value != null )
			_self.put("ediPedidoVenda", value);

	}


	public String getCodEDI(){
		return toString("codEDI");
	}

	public void setCodEDI(String value){
		setString("codEDI",value);
	}


	public String getCodPedido(){
		return toString("codPedido");
	}

	public void setCodPedido(String value){
		setString("codPedido",value);
	}


	public String getNrSequencia(){
		return toString("nrSequencia");
	}

	public void setNrSequencia(String value){
		setString("nrSequencia",value);
	}


	public String getCodCliente(){
		return toString("codCliente");
	}

	public void setCodCliente(String value){
		setString("codCliente",value);
	}


	public String getDtInicio(){
		return toString("dtInicio");
	}

	public void setDtInicio(String value){
		setString("dtInicio",value);
	}


	public String getDtFim(){
		return toString("dtFim");
	}

	public void setDtFim(String value){
		setString("dtFim",value);
	}


	public String getSituacao(){
		return toString("situacao");
	}

	public void setSituacao(String value){
		setString("situacao",value);
	}


	public String getCodProduto(){
		return toString("codProduto");
	}

	public void setCodProduto(String value){
		setString("codProduto",value);
	}


	public String getIndAtivo(){
		return toString("indAtivo");
	}

	public void setIndAtivo(String value){
		setString("indAtivo",value);
	}


	public com.br.client.model.ed.entity.eEDIPedido getEdiPedido(){
		Object obj = _self.get("ediPedido");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eEDIPedido)obj;

	}

	public void setEdiPedido(com.br.client.model.ed.entity.eEDIPedido value){
		_self.remove("ediPedido");
		if ( value != null )
			_self.put("ediPedido", value);

	}


	public String getTpHist(){
		return toString("tpHist");
	}

	public void setTpHist(String value){
		setString("tpHist",value);
	}


	public String getDescHist(){
		return toString("descHist");
	}

	public void setDescHist(String value){
		setString("descHist",value);
	}


	public String getTipoOperacao(){
		return toString("tipoOperacao");
	}

	public void setTipoOperacao(String value){
		setString("tipoOperacao",value);
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
			com.br.client.model.ed.entity.eEDI[] obj = new com.br.client.model.ed.entity.eEDI[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.ed.entity.eEDI)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "pedidoItens".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDIPedidoVendaItem[] obj = new com.br.client.model.ed.entity.eEDIPedidoVendaItem[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.ed.entity.eEDIPedidoVendaItem)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "ediPedidoVenda".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDIPedidoVendaItem obj = new com.br.client.model.ed.entity.eEDIPedidoVendaItem();
			_self.put(name,obj);
		}
		if ( "ediPedido".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDIPedido obj = new com.br.client.model.ed.entity.eEDIPedido();
			_self.put(name,obj);
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
		if ( "pedidoItens".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDIPedidoVendaItem obj = com.br.client.model.ed.entity.eEDIPedidoVendaItem.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "ediPedidoVenda".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDIPedidoVendaItem obj = com.br.client.model.ed.entity.eEDIPedidoVendaItem.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "ediPedido".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDIPedido obj = com.br.client.model.ed.entity.eEDIPedido.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.ed.edw0002.FormBean newInstance(){
		return new com.br.client.model.ed.edw0002.FormBean();
	}
}