package com.br.client.model.sv.svd0010;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getTpOwner(){
		return toString("tpOwner");
	}

	public void setTpOwner(String value){
		setString("tpOwner",value);
	}


	public String getCodPlano(){
		return toString("codPlano");
	}

	public void setCodPlano(String value){
		setString("codPlano",value);
	}


	public String getCodParcelaPagto(){
		return toString("codParcelaPagto");
	}

	public void setCodParcelaPagto(String value){
		setString("codParcelaPagto",value);
	}


	public String getPercComissao(){
		return toString("percComissao");
	}

	public void setPercComissao(String value){
		setString("percComissao",value);
	}


	public com.br.client.model.sv.entity.ePlanoServicoComissaoExcecao[] getExcecoes(){
		Object obj = _self.get("excecoes");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.sv.entity.ePlanoServicoComissaoExcecao[])obj;

	}

	public void setExcecoes(com.br.client.model.sv.entity.ePlanoServicoComissaoExcecao[] value){
		_self.remove("excecoes");
		if ( value != null );
			_self.put("excecoes", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "excecoes".equalsIgnoreCase(name) ){
			com.br.client.model.sv.entity.ePlanoServicoComissaoExcecao[] obj = new com.br.client.model.sv.entity.ePlanoServicoComissaoExcecao[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.sv.entity.ePlanoServicoComissaoExcecao)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "excecoes".equalsIgnoreCase(name) ){
			com.br.client.model.sv.entity.ePlanoServicoComissaoExcecao obj = com.br.client.model.sv.entity.ePlanoServicoComissaoExcecao.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.sv.svd0010.FormBean newInstance(){
		return new com.br.client.model.sv.svd0010.FormBean();
	}
}