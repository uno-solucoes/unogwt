package com.br.client.model.ed.entity;

public class eEDIPedidoVendaItem extends com.howmake.client.form.model.HowMGWTFormBean{
	public eEDIPedidoVendaItem(){
	}


	public String getCodEdiPedidoItem(){
		return toString("codEdiPedidoItem");
	}

	public void setCodEdiPedidoItem(String value){
		setString("codEdiPedidoItem",value);
	}


	public String getCodEDI(){
		return toString("codEDI");
	}

	public void setCodEDI(String value){
		setString("codEDI",value);
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


	public String getNrSequencia(){
		return toString("nrSequencia");
	}

	public void setNrSequencia(String value){
		setString("nrSequencia",value);
	}


	public String getCodProduto(){
		return toString("codProduto");
	}

	public void setCodProduto(String value){
		setString("codProduto",value);
	}


	public String getVlPrecoVenda(){
		return toString("vlPrecoVenda");
	}

	public void setVlPrecoVenda(String value){
		setString("vlPrecoVenda",value);
	}


	public String getQtde(){
		return toString("qtde");
	}

	public void setQtde(String value){
		setString("qtde",value);
	}


	public String getCodReservaEDI(){
		return toString("codReservaEDI");
	}

	public void setCodReservaEDI(String value){
		setString("codReservaEDI",value);
	}


	public String getCodPedidoEDI(){
		return toString("codPedidoEDI");
	}

	public void setCodPedidoEDI(String value){
		setString("codPedidoEDI",value);
	}


	public String getDtReservaEstoque(){
		return toString("dtReservaEstoque");
	}

	public void setDtReservaEstoque(String value){
		setString("dtReservaEstoque",value);
	}


	public String getDtEfetivacaoPedido(){
		return toString("dtEfetivacaoPedido");
	}

	public void setDtEfetivacaoPedido(String value){
		setString("dtEfetivacaoPedido",value);
	}


	public String getSituacao(){
		return toString("situacao");
	}

	public void setSituacao(String value){
		setString("situacao",value);
	}


	public String getDtUltimaVerificacao(){
		return toString("dtUltimaVerificacao");
	}

	public void setDtUltimaVerificacao(String value){
		setString("dtUltimaVerificacao",value);
	}


	public String getNrVerificacoesEdi(){
		return toString("nrVerificacoesEdi");
	}

	public void setNrVerificacoesEdi(String value){
		setString("nrVerificacoesEdi",value);
	}


	public String getDtAlteracaoSituacao(){
		return toString("dtAlteracaoSituacao");
	}

	public void setDtAlteracaoSituacao(String value){
		setString("dtAlteracaoSituacao",value);
	}


	public String getNrErrosEnvio(){
		return toString("nrErrosEnvio");
	}

	public void setNrErrosEnvio(String value){
		setString("nrErrosEnvio",value);
	}


	public String getEmail(){
		return toString("email");
	}

	public void setEmail(String value){
		setString("email",value);
	}


	public String getTipoEntregaCorreio(){
		return toString("tipoEntregaCorreio");
	}

	public void setTipoEntregaCorreio(String value){
		setString("tipoEntregaCorreio",value);
	}


	public String getIndAtivo(){
		return toString("indAtivo");
	}

	public void setIndAtivo(String value){
		setString("indAtivo",value);
	}


	public String getPedidoItemPrecoVenda(){
		return toString("pedidoItemPrecoVenda");
	}

	public void setPedidoItemPrecoVenda(String value){
		setString("pedidoItemPrecoVenda",value);
	}


	public String getPedidoItemQtde(){
		return toString("pedidoItemQtde");
	}

	public void setPedidoItemQtde(String value){
		setString("pedidoItemQtde",value);
	}


	public String getPedidoItemSituacao(){
		return toString("pedidoItemSituacao");
	}

	public void setPedidoItemSituacao(String value){
		setString("pedidoItemSituacao",value);
	}


	public String getDescComercial(){
		return toString("descComercial");
	}

	public void setDescComercial(String value){
		setString("descComercial",value);
	}


	public String getCodCliente(){
		return toString("codCliente");
	}

	public void setCodCliente(String value){
		setString("codCliente",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getEdiSaldo(){
		return toString("ediSaldo");
	}

	public void setEdiSaldo(String value){
		setString("ediSaldo",value);
	}


	public String getEdiPrecoVenda(){
		return toString("ediPrecoVenda");
	}

	public void setEdiPrecoVenda(String value){
		setString("ediPrecoVenda",value);
	}


	public String getEMail(){
		return toString("eMail");
	}

	public void setEMail(String value){
		setString("eMail",value);
	}


	public String getNomeColaborador(){
		return toString("nomeColaborador");
	}

	public void setNomeColaborador(String value){
		setString("nomeColaborador",value);
	}


	public String getDescProduto(){
		return toString("descProduto");
	}

	public void setDescProduto(String value){
		setString("descProduto",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.ed.entity.eEDIPedidoVendaItem newInstance(){
		return new com.br.client.model.ed.entity.eEDIPedidoVendaItem();
	}
}