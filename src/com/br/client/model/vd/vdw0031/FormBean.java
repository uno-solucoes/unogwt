package com.br.client.model.vd.vdw0031;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public String getDtSolicitacaoInicial(){
		return toString("dtSolicitacaoInicial");
	}

	public void setDtSolicitacaoInicial(String value){
		setString("dtSolicitacaoInicial",value);
	}


	public String getDtSolicitacaoFinal(){
		return toString("dtSolicitacaoFinal");
	}

	public void setDtSolicitacaoFinal(String value){
		setString("dtSolicitacaoFinal",value);
	}


	public String getDtAprovacaoInicial(){
		return toString("dtAprovacaoInicial");
	}

	public void setDtAprovacaoInicial(String value){
		setString("dtAprovacaoInicial",value);
	}


	public String getDtAprovacaoFinal(){
		return toString("dtAprovacaoFinal");
	}

	public void setDtAprovacaoFinal(String value){
		setString("dtAprovacaoFinal",value);
	}


	public String getCodNotaFiscal(){
		return toString("codNotaFiscal");
	}

	public void setCodNotaFiscal(String value){
		setString("codNotaFiscal",value);
	}


	public String getNrNotaFiscal(){
		return toString("nrNotaFiscal");
	}

	public void setNrNotaFiscal(String value){
		setString("nrNotaFiscal",value);
	}


	public String getSerieNotaFiscal(){
		return toString("serieNotaFiscal");
	}

	public void setSerieNotaFiscal(String value){
		setString("serieNotaFiscal",value);
	}


	public String getCodCliente(){
		return toString("codCliente");
	}

	public void setCodCliente(String value){
		setString("codCliente",value);
	}


	public String getCodPedido(){
		return toString("codPedido");
	}

	public void setCodPedido(String value){
		setString("codPedido",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getCodSituacao(){
		return toString("codSituacao");
	}

	public void setCodSituacao(String value){
		setString("codSituacao",value);
	}


	public String getCodSolicitacaoDevolucao(){
		return toString("codSolicitacaoDevolucao");
	}

	public void setCodSolicitacaoDevolucao(String value){
		setString("codSolicitacaoDevolucao",value);
	}


	public com.br.client.model.vd.entity.eMotivoDevolucao[] getMotivosDevolucao(){
		Object obj = _self.get("motivosDevolucao");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eMotivoDevolucao[])obj;

	}

	public void setMotivosDevolucao(com.br.client.model.vd.entity.eMotivoDevolucao[] value){
		_self.remove("motivosDevolucao");
		if ( value != null )
			_self.put("motivosDevolucao", value);

	}


	public com.br.client.model.vd.entity.eSolicitacaoDevolucao getSolicitacaoDevolucao(){
		Object obj = _self.get("solicitacaoDevolucao");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eSolicitacaoDevolucao)obj;

	}

	public void setSolicitacaoDevolucao(com.br.client.model.vd.entity.eSolicitacaoDevolucao value){
		_self.remove("solicitacaoDevolucao");
		if ( value != null )
			_self.put("solicitacaoDevolucao", value);

	}


	public com.br.client.model.vd.entity.eSolicitacaoDevolucao[] getSolicitacoesDevolucao(){
		Object obj = _self.get("solicitacoesDevolucao");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eSolicitacaoDevolucao[])obj;

	}

	public void setSolicitacoesDevolucao(com.br.client.model.vd.entity.eSolicitacaoDevolucao[] value){
		_self.remove("solicitacoesDevolucao");
		if ( value != null )
			_self.put("solicitacoesDevolucao", value);

	}


	public com.br.client.model.vd.entity.eSolicitacaoDevolucaoItem[] getSolicitacoesDevolucaoItem(){
		Object obj = _self.get("solicitacoesDevolucaoItem");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eSolicitacaoDevolucaoItem[])obj;

	}

	public void setSolicitacoesDevolucaoItem(com.br.client.model.vd.entity.eSolicitacaoDevolucaoItem[] value){
		_self.remove("solicitacoesDevolucaoItem");
		if ( value != null )
			_self.put("solicitacoesDevolucaoItem", value);

	}


	public String getPermiteCadastrarSolicitacaoDevolucao(){
		return toString("permiteCadastrarSolicitacaoDevolucao");
	}

	public void setPermiteCadastrarSolicitacaoDevolucao(String value){
		setString("permiteCadastrarSolicitacaoDevolucao",value);
	}


	public String getPermiteAprovacaoReprovacaoSolicitacaoDevolucao(){
		return toString("permiteAprovacaoReprovacaoSolicitacaoDevolucao");
	}

	public void setPermiteAprovacaoReprovacaoSolicitacaoDevolucao(String value){
		setString("permiteAprovacaoReprovacaoSolicitacaoDevolucao",value);
	}


	public int getOPERATION_INSERT(){
		return toInteger("OPERATION_INSERT");
	}

	public void setOPERATION_INSERT(int value){
		setInteger("OPERATION_INSERT",value);
	}


	public int getOPERATION_UPDATE(){
		return toInteger("OPERATION_UPDATE");
	}

	public void setOPERATION_UPDATE(int value){
		setInteger("OPERATION_UPDATE",value);
	}


	public int getOPERATION_DELETE(){
		return toInteger("OPERATION_DELETE");
	}

	public void setOPERATION_DELETE(int value){
		setInteger("OPERATION_DELETE",value);
	}


	public int getOPERATION_QUERY(){
		return toInteger("OPERATION_QUERY");
	}

	public void setOPERATION_QUERY(int value){
		setInteger("OPERATION_QUERY",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "motivosDevolucao".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eMotivoDevolucao[] obj = new com.br.client.model.vd.entity.eMotivoDevolucao[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eMotivoDevolucao)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "solicitacaoDevolucao".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eSolicitacaoDevolucao obj = new com.br.client.model.vd.entity.eSolicitacaoDevolucao();
			_self.put(name,obj);
		}
		if ( "solicitacoesDevolucao".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eSolicitacaoDevolucao[] obj = new com.br.client.model.vd.entity.eSolicitacaoDevolucao[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eSolicitacaoDevolucao)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "solicitacoesDevolucaoItem".equalsIgnoreCase(name) ){
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
		if ( "motivosDevolucao".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eMotivoDevolucao obj = com.br.client.model.vd.entity.eMotivoDevolucao.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "solicitacaoDevolucao".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eSolicitacaoDevolucao obj = com.br.client.model.vd.entity.eSolicitacaoDevolucao.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "solicitacoesDevolucao".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eSolicitacaoDevolucao obj = com.br.client.model.vd.entity.eSolicitacaoDevolucao.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "solicitacoesDevolucaoItem".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eSolicitacaoDevolucaoItem obj = com.br.client.model.vd.entity.eSolicitacaoDevolucaoItem.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.vd.vdw0031.FormBean newInstance(){
		return new com.br.client.model.vd.vdw0031.FormBean();
	}
}