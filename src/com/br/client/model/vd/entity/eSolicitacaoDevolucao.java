package com.br.client.model.vd.entity;

public class eSolicitacaoDevolucao extends com.howmake.client.form.model.HowMGWTFormBean{
	public eSolicitacaoDevolucao(){
	}


	public String getCodSolicitacaoDevolucao(){
		return toString("codSolicitacaoDevolucao");
	}

	public void setCodSolicitacaoDevolucao(String value){
		setString("codSolicitacaoDevolucao",value);
	}


	public String getCodMotivoDevolucao(){
		return toString("codMotivoDevolucao");
	}

	public void setCodMotivoDevolucao(String value){
		setString("codMotivoDevolucao",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getSituacao(){
		return toString("situacao");
	}

	public void setSituacao(String value){
		setString("situacao",value);
	}


	public String getCodCliente(){
		return toString("codCliente");
	}

	public void setCodCliente(String value){
		setString("codCliente",value);
	}


	public String getCodColaboradorSolicitante(){
		return toString("codColaboradorSolicitante");
	}

	public void setCodColaboradorSolicitante(String value){
		setString("codColaboradorSolicitante",value);
	}


	public String getDtSolicitacao(){
		return toString("dtSolicitacao");
	}

	public void setDtSolicitacao(String value){
		setString("dtSolicitacao",value);
	}


	public String getCodColaboradorAprovador(){
		return toString("codColaboradorAprovador");
	}

	public void setCodColaboradorAprovador(String value){
		setString("codColaboradorAprovador",value);
	}


	public String getDtAprovacao(){
		return toString("dtAprovacao");
	}

	public void setDtAprovacao(String value){
		setString("dtAprovacao",value);
	}


	public String getObsAprovador(){
		return toString("obsAprovador");
	}

	public void setObsAprovador(String value){
		setString("obsAprovador",value);
	}


	public String getNomeCliente(){
		return toString("nomeCliente");
	}

	public void setNomeCliente(String value){
		setString("nomeCliente",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getNomeColaborador(){
		return toString("nomeColaborador");
	}

	public void setNomeColaborador(String value){
		setString("nomeColaborador",value);
	}


	public String getNomeColaboradorSolicitante(){
		return toString("nomeColaboradorSolicitante");
	}

	public void setNomeColaboradorSolicitante(String value){
		setString("nomeColaboradorSolicitante",value);
	}


	public String getNomeColaboradorAprovador(){
		return toString("nomeColaboradorAprovador");
	}

	public void setNomeColaboradorAprovador(String value){
		setString("nomeColaboradorAprovador",value);
	}


	public String getDescMotivo(){
		return toString("descMotivo");
	}

	public void setDescMotivo(String value){
		setString("descMotivo",value);
	}


	public String getOperacao(){
		return toString("operacao");
	}

	public void setOperacao(String value){
		setString("operacao",value);
	}


	public com.br.client.model.vd.entity.eSolicitacaoDevolucaoItem[] getEntitySolicitacoesDevolucaoItem(){
		Object obj = _self.get("entitySolicitacoesDevolucaoItem");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eSolicitacaoDevolucaoItem[])obj;

	}

	public void setEntitySolicitacoesDevolucaoItem(com.br.client.model.vd.entity.eSolicitacaoDevolucaoItem[] value){
		_self.remove("entitySolicitacoesDevolucaoItem");
		if ( value != null )
			_self.put("entitySolicitacoesDevolucaoItem", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "entitySolicitacoesDevolucaoItem".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eSolicitacaoDevolucaoItem[] obj = new com.br.client.model.vd.entity.eSolicitacaoDevolucaoItem[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eSolicitacaoDevolucaoItem)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "entitySolicitacoesDevolucaoItem".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eSolicitacaoDevolucaoItem obj = com.br.client.model.vd.entity.eSolicitacaoDevolucaoItem.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.vd.entity.eSolicitacaoDevolucao newInstance(){
		return new com.br.client.model.vd.entity.eSolicitacaoDevolucao();
	}
}