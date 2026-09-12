package com.br.client.model.vd.vdw0035;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
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


	public String getFileName(){
		return toString("fileName");
	}

	public void setFileName(String value){
		setString("fileName",value);
	}


	public String getPathName(){
		return toString("pathName");
	}

	public void setPathName(String value){
		setString("pathName",value);
	}


	public String getCodEmitente(){
		return toString("codEmitente");
	}

	public void setCodEmitente(String value){
		setString("codEmitente",value);
	}


	public String getDownloadURL(){
		return toString("downloadURL");
	}

	public void setDownloadURL(String value){
		setString("downloadURL",value);
	}


	public String getMsgWarning(){
		return toString("msgWarning");
	}

	public void setMsgWarning(String value){
		setString("msgWarning",value);
	}


	public com.br.client.model.vd.entity.eNFSE getEntityNFSE(){
		Object obj = _self.get("entityNFSE");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSE)obj;

	}

	public void setEntityNFSE(com.br.client.model.vd.entity.eNFSE value){
		_self.remove("entityNFSE");
		if ( value != null )
			_self.put("entityNFSE", value);

	}


	public com.br.client.model.vd.entity.eNFSE[] getEntityNFSEs(){
		Object obj = _self.get("entityNFSEs");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSE[])obj;

	}

	public void setEntityNFSEs(com.br.client.model.vd.entity.eNFSE[] value){
		_self.remove("entityNFSEs");
		if ( value != null )
			_self.put("entityNFSEs", value);

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
		if ( "entityNFSE".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSE obj = new com.br.client.model.vd.entity.eNFSE();
			_self.put(name,obj);
		}
		if ( "entityNFSEs".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSE[] obj = new com.br.client.model.vd.entity.eNFSE[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eNFSE)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "entityNFSE".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSE obj = com.br.client.model.vd.entity.eNFSE.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityNFSEs".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSE obj = com.br.client.model.vd.entity.eNFSE.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.vd.vdw0035.FormBean newInstance(){
		return new com.br.client.model.vd.vdw0035.FormBean();
	}
}