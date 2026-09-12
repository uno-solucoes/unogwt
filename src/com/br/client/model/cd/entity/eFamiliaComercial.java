package com.br.client.model.cd.entity;

public class eFamiliaComercial extends com.howmake.client.form.model.HowMGWTFormBean{
	public eFamiliaComercial(){
	}


	public String getCodFamiliaComercial(){
		return toString("codFamiliaComercial");
	}

	public void setCodFamiliaComercial(String value){
		setString("codFamiliaComercial",value);
	}


	public String getDescAbrev(){
		return toString("descAbrev");
	}

	public void setDescAbrev(String value){
		setString("descAbrev",value);
	}


	public String getPrioridade(){
		return toString("prioridade");
	}

	public void setPrioridade(String value){
		setString("prioridade",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getTempoEstimadoVenda(){
		return toString("tempoEstimadoVenda");
	}

	public void setTempoEstimadoVenda(String value){
		setString("tempoEstimadoVenda",value);
	}


	public String getPercMargemLucro(){
		return toString("percMargemLucro");
	}

	public void setPercMargemLucro(String value){
		setString("percMargemLucro",value);
	}


	public String getVlTotalFamComercial(){
		return toString("vlTotalFamComercial");
	}

	public void setVlTotalFamComercial(String value){
		setString("vlTotalFamComercial",value);
	}


	public com.br.client.model.vd.entity.eItemPedido[] getItensPedido(){
		Object obj = _self.get("itensPedido");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eItemPedido[])obj;

	}

	public void setItensPedido(com.br.client.model.vd.entity.eItemPedido[] value){
		_self.remove("itensPedido");
		if ( value != null );
			_self.put("itensPedido", value);

	}


	public com.br.client.model.vd.entity.eItemPedido[] getServicos(){
		Object obj = _self.get("servicos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eItemPedido[])obj;

	}

	public void setServicos(com.br.client.model.vd.entity.eItemPedido[] value){
		_self.remove("servicos");
		if ( value != null );
			_self.put("servicos", value);

	}


	public com.br.client.model.oc.entity.eArquivoOcorrencia[] getArquivos(){
		Object obj = _self.get("arquivos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.oc.entity.eArquivoOcorrencia[])obj;

	}

	public void setArquivos(com.br.client.model.oc.entity.eArquivoOcorrencia[] value){
		_self.remove("arquivos");
		if ( value != null );
			_self.put("arquivos", value);

	}


	public int[] getStatusArquivos(){
		return toIntegerArray("statusArquivos");
	}

	public void setStatusArquivos(int[] value){
		setIntegerArray("statusArquivos",value);
	}


	public String getTipo(){
		return toString("tipo");
	}

	public void setTipo(String value){
		setString("tipo",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "itensPedido".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eItemPedido[] obj = new com.br.client.model.vd.entity.eItemPedido[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eItemPedido)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "servicos".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eItemPedido[] obj = new com.br.client.model.vd.entity.eItemPedido[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eItemPedido)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "arquivos".equalsIgnoreCase(name) ){
			com.br.client.model.oc.entity.eArquivoOcorrencia[] obj = new com.br.client.model.oc.entity.eArquivoOcorrencia[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.oc.entity.eArquivoOcorrencia)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "statusArquivos".equalsIgnoreCase(name) ){
			int[] obj = new int[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isNumber()!= null )
					obj[i] = new Double(object.isNumber().doubleValue()).intValue();
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "itensPedido".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eItemPedido obj = com.br.client.model.vd.entity.eItemPedido.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "servicos".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eItemPedido obj = com.br.client.model.vd.entity.eItemPedido.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "arquivos".equalsIgnoreCase(name) ){
			com.br.client.model.oc.entity.eArquivoOcorrencia obj = com.br.client.model.oc.entity.eArquivoOcorrencia.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.cd.entity.eFamiliaComercial newInstance(){
		return new com.br.client.model.cd.entity.eFamiliaComercial();
	}
}