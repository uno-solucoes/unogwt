package com.br.client.model.fn.fnw0016;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public java.lang.String[] getDatas(){
		Object obj = _self.get("datas");
		if ( obj == null )
			return null;
		else
			return (java.lang.String[])obj;

	}

	public void setDatas(java.lang.String[] value){
		_self.remove("datas");
		if ( value != null )
			_self.put("datas", value);

	}


	public java.lang.String[] getImpostos(){
		Object obj = _self.get("impostos");
		if ( obj == null )
			return null;
		else
			return (java.lang.String[])obj;

	}

	public void setImpostos(java.lang.String[] value){
		_self.remove("impostos");
		if ( value != null )
			_self.put("impostos", value);

	}


	public String getTpRegime(){
		return toString("tpRegime");
	}

	public void setTpRegime(String value){
		setString("tpRegime",value);
	}


	public String getExclusoesContas(){
		return toString("exclusoesContas");
	}

	public void setExclusoesContas(String value){
		setString("exclusoesContas",value);
	}


	public String getIndSimplesNacional(){
		return toString("indSimplesNacional");
	}

	public void setIndSimplesNacional(String value){
		setString("indSimplesNacional",value);
	}


	public String getImpostoLucroPresumido(){
		return toString("impostoLucroPresumido");
	}

	public void setImpostoLucroPresumido(String value){
		setString("impostoLucroPresumido",value);
	}


	public com.br.client.model.fn.entity.eRelatorioOperacionalImposto[] getRelatorio(){
		Object obj = _self.get("relatorio");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.fn.entity.eRelatorioOperacionalImposto[])obj;

	}

	public void setRelatorio(com.br.client.model.fn.entity.eRelatorioOperacionalImposto[] value){
		_self.remove("relatorio");
		if ( value != null )
			_self.put("relatorio", value);

	}


	public com.br.client.model.fn.entity.excel.eHowMWorksheet getWorksheet(){
		Object obj = _self.get("worksheet");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.fn.entity.excel.eHowMWorksheet)obj;

	}

	public void setWorksheet(com.br.client.model.fn.entity.excel.eHowMWorksheet value){
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
		if ( "datas".equalsIgnoreCase(name) ){
			java.lang.String[] obj = new java.lang.String[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isString()!= null )
					obj[i] = object.isString().stringValue();
				 
			}
		}
		if ( "impostos".equalsIgnoreCase(name) ){
			java.lang.String[] obj = new java.lang.String[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isString()!= null )
					obj[i] = object.isString().stringValue();
				 
			}
		}
		if ( "relatorio".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.eRelatorioOperacionalImposto[] obj = new com.br.client.model.fn.entity.eRelatorioOperacionalImposto[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.fn.entity.eRelatorioOperacionalImposto)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "worksheet".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.excel.eHowMWorksheet obj = new com.br.client.model.fn.entity.excel.eHowMWorksheet();
			_self.put(name,obj);
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "relatorio".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.eRelatorioOperacionalImposto obj = com.br.client.model.fn.entity.eRelatorioOperacionalImposto.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "worksheet".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.excel.eHowMWorksheet obj = com.br.client.model.fn.entity.excel.eHowMWorksheet.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.fn.fnw0016.FormBean newInstance(){
		return new com.br.client.model.fn.fnw0016.FormBean();
	}
}