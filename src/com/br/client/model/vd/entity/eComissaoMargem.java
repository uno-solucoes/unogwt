package com.br.client.model.vd.entity;

public class eComissaoMargem extends com.howmake.client.form.model.HowMGWTFormBean{
	public eComissaoMargem(){
	}


	public String getCodMargem(){
		return toString("codMargem");
	}

	public void setCodMargem(String value){
		setString("codMargem",value);
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


	public com.br.client.model.vd.entity.eComissaoMargemFaixa[] getComissaoMagemFaixas(){
		Object obj = _self.get("comissaoMagemFaixas");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eComissaoMargemFaixa[])obj;

	}

	public void setComissaoMagemFaixas(com.br.client.model.vd.entity.eComissaoMargemFaixa[] value){
		_self.remove("comissaoMagemFaixas");
		if ( value != null )
			_self.put("comissaoMagemFaixas", value);

	}


	public int getOperacao(){
		return toInteger("operacao");
	}

	public void setOperacao(int value){
		setInteger("operacao",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "comissaoMagemFaixas".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eComissaoMargemFaixa[] obj = new com.br.client.model.vd.entity.eComissaoMargemFaixa[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eComissaoMargemFaixa)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "comissaoMagemFaixas".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eComissaoMargemFaixa obj = com.br.client.model.vd.entity.eComissaoMargemFaixa.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.vd.entity.eComissaoMargem newInstance(){
		return new com.br.client.model.vd.entity.eComissaoMargem();
	}
}