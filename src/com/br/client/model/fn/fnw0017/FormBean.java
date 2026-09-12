package com.br.client.model.fn.fnw0017;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public String getCodOrcamento(){
		return toString("codOrcamento");
	}

	public void setCodOrcamento(String value){
		setString("codOrcamento",value);
	}


	public String getNomeOrcamento(){
		return toString("nomeOrcamento");
	}

	public void setNomeOrcamento(String value){
		setString("nomeOrcamento",value);
	}


	public String getCenario(){
		return toString("cenario");
	}

	public void setCenario(String value){
		setString("cenario",value);
	}


	public String getNomeCenario(){
		return toString("nomeCenario");
	}

	public void setNomeCenario(String value){
		setString("nomeCenario",value);
	}


	public String getDtInicial(){
		return toString("dtInicial");
	}

	public void setDtInicial(String value){
		setString("dtInicial",value);
	}


	public String getPercComissao(){
		return toString("percComissao");
	}

	public void setPercComissao(String value){
		setString("percComissao",value);
	}


	public String getPercDespOperacional(){
		return toString("percDespOperacional");
	}

	public void setPercDespOperacional(String value){
		setString("percDespOperacional",value);
	}


	public String getPercIrCsll(){
		return toString("percIrCsll");
	}

	public void setPercIrCsll(String value){
		setString("percIrCsll",value);
	}


	public String getPercImpostoVendas(){
		return toString("percImpostoVendas");
	}

	public void setPercImpostoVendas(String value){
		setString("percImpostoVendas",value);
	}
	
	


	public com.br.client.model.fn.entity.eCenario[] getCenarios(){
		Object obj = _self.get("cenarios");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.fn.entity.eCenario[])obj;

	}

	public void setCenarios(com.br.client.model.fn.entity.eCenario[] value){
		_self.remove("cenarios");
		if ( value != null )
			_self.put("cenarios", value);

	}


	public com.br.client.model.fn.entity.eOrcamentoConta[] getContas(){
		Object obj = _self.get("contas");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.fn.entity.eOrcamentoConta[])obj;

	}

	public void setContas(com.br.client.model.fn.entity.eOrcamentoConta[] value){
		_self.remove("contas");
		if ( value != null )
			_self.put("contas", value);

	}


	public com.br.client.model.fn.entity.eOrcamentoConta[] getTotais(){
		Object obj = _self.get("totais");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.fn.entity.eOrcamentoConta[])obj;

	}

	public void setTotais(com.br.client.model.fn.entity.eOrcamentoConta[] value){
		_self.remove("totais");
		if ( value != null )
			_self.put("totais", value);

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
		if ( "cenarios".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.eCenario[] obj = new com.br.client.model.fn.entity.eCenario[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.fn.entity.eCenario)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "contas".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.eOrcamentoConta[] obj = new com.br.client.model.fn.entity.eOrcamentoConta[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.fn.entity.eOrcamentoConta)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "totais".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.eOrcamentoConta[] obj = new com.br.client.model.fn.entity.eOrcamentoConta[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.fn.entity.eOrcamentoConta)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "cenarios".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.eCenario obj = com.br.client.model.fn.entity.eCenario.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "contas".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.eOrcamentoConta obj = com.br.client.model.fn.entity.eOrcamentoConta.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "totais".equalsIgnoreCase(name) ){
			com.br.client.model.fn.entity.eOrcamentoConta obj = com.br.client.model.fn.entity.eOrcamentoConta.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.fn.fnw0017.FormBean newInstance(){
		return new com.br.client.model.fn.fnw0017.FormBean();
	}
}