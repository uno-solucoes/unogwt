package com.br.client.model.fn.fnw0217;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public com.br.client.model.cd.entity.eEmpresa[] getEntityEmpresas(){
		Object obj = _self.get("entityEmpresas");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.cd.entity.eEmpresa[])obj;

	}

	public void setEntityEmpresas(com.br.client.model.cd.entity.eEmpresa[] value){
		_self.remove("entityEmpresas");
		if ( value != null )
			_self.put("entityEmpresas", value);

	}


	public com.br.client.model.ed.entity.eExcelWorksheet getWorksheet(){
		Object obj = _self.get("worksheet");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eExcelWorksheet)obj;

	}

	public void setWorksheet(com.br.client.model.ed.entity.eExcelWorksheet value){
		_self.remove("worksheet");
		if ( value != null )
			_self.put("worksheet", value);

	}


	public String getPath(){
		return toString("path");
	}

	public void setPath(String value){
		setString("path",value);
	}


	public String getFileName(){
		return toString("fileName");
	}

	public void setFileName(String value){
		setString("fileName",value);
	}


	public String getPapel(){
		return toString("papel");
	}

	public void setPapel(String value){
		setString("papel",value);
	}


	public String getOrientacao(){
		return toString("orientacao");
	}

	public void setOrientacao(String value){
		setString("orientacao",value);
	}


	public String getMargemLeft(){
		return toString("margemLeft");
	}

	public void setMargemLeft(String value){
		setString("margemLeft",value);
	}


	public String getMargemTop(){
		return toString("margemTop");
	}

	public void setMargemTop(String value){
		setString("margemTop",value);
	}


	public String getMargemRight(){
		return toString("margemRight");
	}

	public void setMargemRight(String value){
		setString("margemRight",value);
	}


	public String getMargemBottom(){
		return toString("margemBottom");
	}

	public void setMargemBottom(String value){
		setString("margemBottom",value);
	}


	public String getTitle(){
		return toString("title");
	}

	public void setTitle(String value){
		setString("title",value);
	}


	public String getSubTitle(){
		return toString("subTitle");
	}

	public void setSubTitle(String value){
		setString("subTitle",value);
	}


	public String getModulo(){
		return toString("modulo");
	}

	public void setModulo(String value){
		setString("modulo",value);
	}


	public com.br.client.model.fn.entity.eCentroCusto[] getEntityCentrosCustos(){
		Object obj = _self.get("entityCentrosCustos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.fn.entity.eCentroCusto[])obj;

	}

	public void setEntityCentrosCustos(com.br.client.model.fn.entity.eCentroCusto[] value){
		_self.remove("entityCentrosCustos");
		if ( value != null )
			_self.put("entityCentrosCustos", value);

	}


	public String getGeoScript(){
		return toString("geoScript");
	}

	public void setGeoScript(String value){
		setString("geoScript",value);
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


	public String getErroDetail(){
		return toString("erroDetail");
	}

	public void setErroDetail(String value){
		setString("erroDetail",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "entityEmpresas".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eEmpresa[] obj = new com.br.client.model.cd.entity.eEmpresa[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.cd.entity.eEmpresa)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "worksheet".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eExcelWorksheet obj = new com.br.client.model.ed.entity.eExcelWorksheet();
			_self.put(name,obj);
		}
		if ( "entityCentrosCustos".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.eCentroCusto[] obj = new com.br.client.model.fn.entity.eCentroCusto[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.fn.entity.eCentroCusto)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "entityEmpresas".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eEmpresa obj = com.br.client.model.cd.entity.eEmpresa.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "worksheet".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eExcelWorksheet obj = com.br.client.model.ed.entity.eExcelWorksheet.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityCentrosCustos".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.eCentroCusto obj = com.br.client.model.fn.entity.eCentroCusto.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.fn.fnw0217.FormBean newInstance(){
		return new com.br.client.model.fn.fnw0217.FormBean();
	}
}