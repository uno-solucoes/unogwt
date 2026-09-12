package com.br.client.model.vd.entity;

public class eNFSEEmitenteWS extends com.howmake.client.form.model.HowMGWTFormBean{
	public eNFSEEmitenteWS(){
	}


	public String getAtivo(){
		return toString("ativo");
	}

	public void setAtivo(String value){
		setString("ativo",value);
	}


	public String getBairro(){
		return toString("bairro");
	}

	public void setBairro(String value){
		setString("bairro",value);
	}


	public String getCep(){
		return toString("cep");
	}

	public void setCep(String value){
		setString("cep",value);
	}


	public String getCerali(){
		return toString("cerali");
	}

	public void setCerali(String value){
		setString("cerali",value);
	}


	public String getCnpj(){
		return toString("cnpj");
	}

	public void setCnpj(String value){
		setString("cnpj",value);
	}


	public String getCodEmitente(){
		return toString("codEmitente");
	}

	public void setCodEmitente(String value){
		setString("codEmitente",value);
	}


	public String getCodMunicipio(){
		return toString("codMunicipio");
	}

	public void setCodMunicipio(String value){
		setString("codMunicipio",value);
	}


	public String getDevModel(){
		return toString("devModel");
	}

	public void setDevModel(String value){
		setString("devModel",value);
	}


	public String getNmFantasia(){
		return toString("nmFantasia");
	}

	public void setNmFantasia(String value){
		setString("nmFantasia",value);
	}


	public String getGmt(){
		return toString("gmt");
	}

	public void setGmt(String value){
		setString("gmt",value);
	}


	public String getIe(){
		return toString("ie");
	}

	public void setIe(String value){
		setString("ie",value);
	}


	public String getIsOnline(){
		return toString("isOnline");
	}

	public void setIsOnline(String value){
		setString("isOnline",value);
	}


	public String getKstpss(){
		return toString("kstpss");
	}

	public void setKstpss(String value){
		setString("kstpss",value);
	}


	public String getLogradouro(){
		return toString("logradouro");
	}

	public void setLogradouro(String value){
		setString("logradouro",value);
	}


	public String getMunicipio(){
		return toString("municipio");
	}

	public void setMunicipio(String value){
		setString("municipio",value);
	}


	public String getProvCnf(){
		return toString("provCnf");
	}

	public void setProvCnf(String value){
		setString("provCnf",value);
	}


	public String getProvCnfGen(){
		return toString("provCnfGen");
	}

	public void setProvCnfGen(String value){
		setString("provCnfGen",value);
	}


	public String getRazaoSocial(){
		return toString("razaoSocial");
	}

	public void setRazaoSocial(String value){
		setString("razaoSocial",value);
	}


	public String getTpCerDig(){
		return toString("tpCerDig");
	}

	public void setTpCerDig(String value){
		setString("tpCerDig",value);
	}


	public String getUf(){
		return toString("uf");
	}

	public void setUf(String value){
		setString("uf",value);
	}


	public com.br.client.model.vd.entity.eNFSEConfiguracaoWS getEntityConfiguracaoWS(){
		Object obj = _self.get("entityConfiguracaoWS");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSEConfiguracaoWS)obj;

	}

	public void setEntityConfiguracaoWS(com.br.client.model.vd.entity.eNFSEConfiguracaoWS value){
		_self.remove("entityConfiguracaoWS");
		if ( value != null )
			_self.put("entityConfiguracaoWS", value);

	}


	public com.br.client.model.vd.entity.eNFSEFilaWS getEntityFilaWS(){
		Object obj = _self.get("entityFilaWS");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSEFilaWS)obj;

	}

	public void setEntityFilaWS(com.br.client.model.vd.entity.eNFSEFilaWS value){
		_self.remove("entityFilaWS");
		if ( value != null )
			_self.put("entityFilaWS", value);

	}


	public com.br.client.model.vd.entity.eNFSEConsultaWS getEntityConsultaWS(){
		Object obj = _self.get("entityConsultaWS");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSEConsultaWS)obj;

	}

	public void setEntityConsultaWS(com.br.client.model.vd.entity.eNFSEConsultaWS value){
		_self.remove("entityConsultaWS");
		if ( value != null )
			_self.put("entityConsultaWS", value);

	}


	public com.br.client.model.vd.entity.eNFSEParametroWS getEntityParametroWS(){
		Object obj = _self.get("entityParametroWS");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSEParametroWS)obj;

	}

	public void setEntityParametroWS(com.br.client.model.vd.entity.eNFSEParametroWS value){
		_self.remove("entityParametroWS");
		if ( value != null )
			_self.put("entityParametroWS", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "entityConfiguracaoWS".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEConfiguracaoWS obj = new com.br.client.model.vd.entity.eNFSEConfiguracaoWS();
			_self.put(name,obj);
		}
		if ( "entityFilaWS".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEFilaWS obj = new com.br.client.model.vd.entity.eNFSEFilaWS();
			_self.put(name,obj);
		}
		if ( "entityConsultaWS".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEConsultaWS obj = new com.br.client.model.vd.entity.eNFSEConsultaWS();
			_self.put(name,obj);
		}
		if ( "entityParametroWS".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEParametroWS obj = new com.br.client.model.vd.entity.eNFSEParametroWS();
			_self.put(name,obj);
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "entityConfiguracaoWS".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEConfiguracaoWS obj = com.br.client.model.vd.entity.eNFSEConfiguracaoWS.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityFilaWS".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEFilaWS obj = com.br.client.model.vd.entity.eNFSEFilaWS.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityConsultaWS".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEConsultaWS obj = com.br.client.model.vd.entity.eNFSEConsultaWS.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityParametroWS".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEParametroWS obj = com.br.client.model.vd.entity.eNFSEParametroWS.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.vd.entity.eNFSEEmitenteWS newInstance(){
		return new com.br.client.model.vd.entity.eNFSEEmitenteWS();
	}
}