package com.br.client.model.vd.entity;

public class eImprimeCertificado extends com.howmake.client.form.model.HowMGWTFormBean{
	public eImprimeCertificado(){
	}


	public String getCodFornecedor(){
		return toString("codFornecedor");
	}

	public void setCodFornecedor(String value){
		setString("codFornecedor",value);
	}


	public String getCodProduto(){
		return toString("codProduto");
	}

	public void setCodProduto(String value){
		setString("codProduto",value);
	}


	public String getDescComercial(){
		return toString("descComercial");
	}

	public void setDescComercial(String value){
		setString("descComercial",value);
	}


	public String getCodLote(){
		return toString("codLote");
	}

	public void setCodLote(String value){
		setString("codLote",value);
	}


	public String getNrCertificado(){
		return toString("nrCertificado");
	}

	public void setNrCertificado(String value){
		setString("nrCertificado",value);
	}


	public String getCodNotaFiscal(){
		return toString("codNotaFiscal");
	}

	public void setCodNotaFiscal(String value){
		setString("codNotaFiscal",value);
	}


	public String getImprime(){
		return toString("imprime");
	}

	public void setImprime(String value){
		setString("imprime",value);
	}


	public String getSelected(){
		return toString("selected");
	}

	public String getCodDocumento(){
		return toString("codDocumento");
	}

	public void setCodDocumento(String value){
		setString("codDocumento",value);
	}

	
	public void setSelected(String value){
		setString("selected",value);
	}


	public com.br.client.model.sg.entity.eFile[] getAnexos(){
		Object obj = _self.get("anexos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.sg.entity.eFile[])obj;

	}

	public void setAnexos(com.br.client.model.sg.entity.eFile[] value){
		_self.remove("anexos");
		if ( value != null )
			_self.put("anexos", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "anexos".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eFile[] obj = new com.br.client.model.sg.entity.eFile[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.sg.entity.eFile)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "anexos".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eFile obj = com.br.client.model.sg.entity.eFile.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.vd.entity.eImprimeCertificado newInstance(){
		return new com.br.client.model.vd.entity.eImprimeCertificado();
	}
}