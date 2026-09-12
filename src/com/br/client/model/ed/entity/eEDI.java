package com.br.client.model.ed.entity;

public class eEDI extends com.howmake.client.form.model.HowMGWTFormBean{
	public eEDI(){
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getCodEdi(){
		return toString("codEdi");
	}

	public void setCodEdi(String value){
		setString("codEdi",value);
	}


	public String getNomeServico(){
		return toString("nomeServico");
	}

	public void setNomeServico(String value){
		setString("nomeServico",value);
	}


	public String getEnderecoWebService(){
		return toString("enderecoWebService");
	}

	public void setEnderecoWebService(String value){
		setString("enderecoWebService",value);
	}


	public String getUsuario(){
		return toString("usuario");
	}

	public void setUsuario(String value){
		setString("usuario",value);
	}


	public String getSenha(){
		return toString("senha");
	}

	public void setSenha(String value){
		setString("senha",value);
	}


	public String getClasseBO(){
		return toString("classeBO");
	}

	public void setClasseBO(String value){
		setString("classeBO",value);
	}


	public String getSituacaoPedidoReserva(){
		return toString("situacaoPedidoReserva");
	}

	public void setSituacaoPedidoReserva(String value){
		setString("situacaoPedidoReserva",value);
	}


	public String getSituacaoPedidoEfetivacao(){
		return toString("situacaoPedidoEfetivacao");
	}

	public void setSituacaoPedidoEfetivacao(String value){
		setString("situacaoPedidoEfetivacao",value);
	}


	public String getCodDeposito(){
		return toString("codDeposito");
	}

	public void setCodDeposito(String value){
		setString("codDeposito",value);
	}


	public String getIndAmbiente(){
		return toString("indAmbiente");
	}

	public void setIndAmbiente(String value){
		setString("indAmbiente",value);
	}


	public String getNrErrosEnvioEmail(){
		return toString("nrErrosEnvioEmail");
	}

	public void setNrErrosEnvioEmail(String value){
		setString("nrErrosEnvioEmail",value);
	}


	public String getEMail(){
		return toString("eMail");
	}

	public void setEMail(String value){
		setString("eMail",value);
	}


	public String getTipoEntregaCorreio(){
		return toString("tipoEntregaCorreio");
	}

	public void setTipoEntregaCorreio(String value){
		setString("tipoEntregaCorreio",value);
	}


	public String getCodFornecedor(){
		return toString("codFornecedor");
	}

	public void setCodFornecedor(String value){
		setString("codFornecedor",value);
	}


	public String getNomeFornecedor(){
		return toString("nomeFornecedor");
	}

	public void setNomeFornecedor(String value){
		setString("nomeFornecedor",value);
	}


	public String getCodCondPagamento(){
		return toString("codCondPagamento");
	}

	public void setCodCondPagamento(String value){
		setString("codCondPagamento",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public com.br.client.model.ed.entity.eEDIProduto[] getProdutos(){
		Object obj = _self.get("produtos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.ed.entity.eEDIProduto[])obj;

	}

	public void setProdutos(com.br.client.model.ed.entity.eEDIProduto[] value){
		_self.remove("produtos");
		if ( value != null )
			_self.put("produtos", value);

	}


	public String getCrontabFrequencia(){
		return toString("crontabFrequencia");
	}

	public void setCrontabFrequencia(String value){
		setString("crontabFrequencia",value);
	}


	public String getCrontabTipoFrequencia(){
		return toString("crontabTipoFrequencia");
	}

	public void setCrontabTipoFrequencia(String value){
		setString("crontabTipoFrequencia",value);
	}


	public int getOperacao(){
		return toInteger("operacao");
	}

	public void setOperacao(int value){
		setInteger("operacao",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "produtos".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDIProduto[] obj = new com.br.client.model.ed.entity.eEDIProduto[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.ed.entity.eEDIProduto)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "produtos".equalsIgnoreCase(name) ){
			com.br.client.model.ed.entity.eEDIProduto obj = com.br.client.model.ed.entity.eEDIProduto.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.ed.entity.eEDI newInstance(){
		return new com.br.client.model.ed.entity.eEDI();
	}
}