package com.br.client.model.vd.vdd0033;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public String getCodNotaFiscal(){
		return toString("codNotaFiscal");
	}

	public void setCodNotaFiscal(String value){
		setString("codNotaFiscal",value);
	}


	public String getNomeCliente(){
		return toString("nomeCliente");
	}

	public void setNomeCliente(String value){
		setString("nomeCliente",value);
	}


	public com.br.client.model.vd.entity.eImprimeCertificado[] getImprimeCertificados(){
		Object obj = _self.get("imprimeCertificados");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eImprimeCertificado[])obj;

	}

	public void setImprimeCertificados(com.br.client.model.vd.entity.eImprimeCertificado[] value){
		_self.remove("imprimeCertificados");
		if ( value != null )
			_self.put("imprimeCertificados", value);

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
		if ( "imprimeCertificados".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eImprimeCertificado[] obj = new com.br.client.model.vd.entity.eImprimeCertificado[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eImprimeCertificado)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "imprimeCertificados".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eImprimeCertificado obj = com.br.client.model.vd.entity.eImprimeCertificado.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.vd.vdd0033.FormBean newInstance(){
		return new com.br.client.model.vd.vdd0033.FormBean();
	}
}