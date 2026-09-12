package com.br.client.model.eq.eqd0018;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public String getCodPedido(){
		return toString("codPedido");
	}

	public void setCodPedido(String value){
		setString("codPedido",value);
	}


	public String getNomeClientePedido(){
		return toString("nomeClientePedido");
	}

	public void setNomeClientePedido(String value){
		setString("nomeClientePedido",value);
	}


	public String getNomeClienteNota(){
		return toString("nomeClienteNota");
	}

	public void setNomeClienteNota(String value){
		setString("nomeClienteNota",value);
	}


	public String getNrNotaFiscal(){
		return toString("nrNotaFiscal");
	}

	public void setNrNotaFiscal(String value){
		setString("nrNotaFiscal",value);
	}


	public String getCodNotaFiscal(){
		return toString("codNotaFiscal");
	}

	public void setCodNotaFiscal(String value){
		setString("codNotaFiscal",value);
	}


	public String getSerie(){
		return toString("serie");
	}

	public void setSerie(String value){
		setString("serie",value);
	}


	public String getNrSerie(){
		return toString("nrSerie");
	}

	public void setNrSerie(String value){
		setString("nrSerie",value);
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getCodProduto(){
		return toString("codProduto");
	}

	public void setCodProduto(String value){
		setString("codProduto",value);
	}


	public String getNomeProduto(){
		return toString("nomeProduto");
	}

	public void setNomeProduto(String value){
		setString("nomeProduto",value);
	}


	public String getCodCliente(){
		return toString("codCliente");
	}

	public void setCodCliente(String value){
		setString("codCliente",value);
	}


	public String getNomeCliente(){
		return toString("nomeCliente");
	}

	public void setNomeCliente(String value){
		setString("nomeCliente",value);
	}


	public String getCorpo(){
		return toString("corpo");
	}

	public void setCorpo(String value){
		setString("corpo",value);
	}


	public String getValorTotalSaida(){
		return toString("valorTotalSaida");
	}

	public void setValorTotalSaida(String value){
		setString("valorTotalSaida",value);
	}


	public String getValorTotalDevolvido(){
		return toString("valorTotalDevolvido");
	}

	public void setValorTotalDevolvido(String value){
		setString("valorTotalDevolvido",value);
	}


	public java.lang.String[] getCheckGeraEmbalagem(){
		Object obj = _self.get("checkGeraEmbalagem");
		if ( obj == null )
			return null;
		else
			return (java.lang.String[])obj;

	}

	public void setCheckGeraEmbalagem(java.lang.String[] value){
		_self.remove("checkGeraEmbalagem");
		if ( value != null )
			_self.put("checkGeraEmbalagem", value);

	}


	public String getCbarras(){
		return toString("cbarras");
	}

	public void setCbarras(String value){
		setString("cbarras",value);
	}


	public com.br.client.model.vd.entity.eNotaFiscalItemEtq[] getItensEtq(){
		Object obj = _self.get("itensEtq");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNotaFiscalItemEtq[])obj;

	}

	public void setItensEtq(com.br.client.model.vd.entity.eNotaFiscalItemEtq[] value){
		_self.remove("itensEtq");
		if ( value != null )
			_self.put("itensEtq", value);

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
		if ( "checkGeraEmbalagem".equalsIgnoreCase(name) ){
			java.lang.String[] obj = new java.lang.String[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isString()!= null )
					obj[i] = object.isString().stringValue();
				 
			}
		}
		if ( "itensEtq".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNotaFiscalItemEtq[] obj = new com.br.client.model.vd.entity.eNotaFiscalItemEtq[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eNotaFiscalItemEtq)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "itensEtq".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNotaFiscalItemEtq obj = com.br.client.model.vd.entity.eNotaFiscalItemEtq.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.eq.eqd0018.FormBean newInstance(){
		return new com.br.client.model.eq.eqd0018.FormBean();
	}
}