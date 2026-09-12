package com.br.client.model.vd.entity;

public class eTpAgrupamento extends com.howmake.client.form.model.HowMGWTFormBean{
	public eTpAgrupamento(){
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


	public String getCodAgrupamento(){
		return toString("codAgrupamento");
	}

	public void setCodAgrupamento(String value){
		setString("codAgrupamento",value);
	}


	public String getDescAbrev(){
		return toString("descAbrev");
	}

	public void setDescAbrev(String value){
		setString("descAbrev",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getQtd(){
		return toString("qtd");
	}

	public void setQtd(String value){
		setString("qtd",value);
	}


	public String getIndUhs(){
		return toString("indUhs");
	}

	public void setIndUhs(String value){
		setString("indUhs",value);
	}


	public String getIcone(){
		return toString("icone");
	}

	public void setIcone(String value){
		setString("icone",value);
	}


	public double getVlUnitarioAgrupamento(){
		return toDouble("vlUnitarioAgrupamento");
	}

	public void setVlUnitarioAgrupamento(double value){
		setDouble("vlUnitarioAgrupamento",value);
	}


	public double getVlTotalItens(){
		return toDouble("vlTotalItens");
	}

	public void setVlTotalItens(double value){
		setDouble("vlTotalItens",value);
	}


	public com.br.client.model.cd.entity.eFamiliaComercial[] getFamiliasComerciais(){
		Object obj = _self.get("familiasComerciais");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.cd.entity.eFamiliaComercial[])obj;

	}

	public void setFamiliasComerciais(com.br.client.model.cd.entity.eFamiliaComercial[] value){
		_self.remove("familiasComerciais");
		if ( value != null );
			_self.put("familiasComerciais", value);

	}


	public com.br.client.model.cd.entity.eFamiliaComercial[] getFamComercServicos(){
		Object obj = _self.get("famComercServicos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.cd.entity.eFamiliaComercial[])obj;

	}

	public void setFamComercServicos(com.br.client.model.cd.entity.eFamiliaComercial[] value){
		_self.remove("famComercServicos");
		if ( value != null );
			_self.put("famComercServicos", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "familiasComerciais".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eFamiliaComercial[] obj = new com.br.client.model.cd.entity.eFamiliaComercial[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.cd.entity.eFamiliaComercial)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "famComercServicos".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eFamiliaComercial[] obj = new com.br.client.model.cd.entity.eFamiliaComercial[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.cd.entity.eFamiliaComercial)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "familiasComerciais".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eFamiliaComercial obj = com.br.client.model.cd.entity.eFamiliaComercial.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "famComercServicos".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eFamiliaComercial obj = com.br.client.model.cd.entity.eFamiliaComercial.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.vd.entity.eTpAgrupamento newInstance(){
		return new com.br.client.model.vd.entity.eTpAgrupamento();
	}
}