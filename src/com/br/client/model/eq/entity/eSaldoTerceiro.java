package com.br.client.model.eq.entity;

public class eSaldoTerceiro extends com.howmake.client.form.model.HowMGWTFormBean{
	public eSaldoTerceiro(){
	}


	public String getCodProduto(){
		return toString("codProduto");
	}

	public void setCodProduto(String value){
		setString("codProduto",value);
	}


	public String getCodLote(){
		return toString("codLote");
	}

	public void setCodLote(String value){
		setString("codLote",value);
	}


	public String getCodEmbalagem(){
		return toString("codEmbalagem");
	}

	public void setCodEmbalagem(String value){
		setString("codEmbalagem",value);
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getCodCliente(){
		return toString("codCliente");
	}

	public void setCodCliente(String value){
		setString("codCliente",value);
	}


	public String getSaldoTerceiros(){
		return toString("saldoTerceiros");
	}

	public void setSaldoTerceiros(String value){
		setString("saldoTerceiros",value);
	}


	public String getNrSerie(){
		return toString("nrSerie");
	}

	public void setNrSerie(String value){
		setString("nrSerie",value);
	}


	public String getUn(){
		return toString("un");
	}

	public void setUn(String value){
		setString("un",value);
	}


	public String getDescProduto(){
		return toString("descProduto");
	}

	public void setDescProduto(String value){
		setString("descProduto",value);
	}


	public String getCodFornecedor(){
		return toString("codFornecedor");
	}

	public void setCodFornecedor(String value){
		setString("codFornecedor",value);
	}


	public String getNomeCliente(){
		return toString("nomeCliente");
	}

	public void setNomeCliente(String value){
		setString("nomeCliente",value);
	}


	public String getCodDeposito(){
		return toString("codDeposito");
	}

	public void setCodDeposito(String value){
		setString("codDeposito",value);
	}


	public String getSaldoEstoque(){
		return toString("saldoEstoque");
	}

	public void setSaldoEstoque(String value){
		setString("saldoEstoque",value);
	}


	public String getConsSaldo(){
		return toString("consSaldo");
	}

	public void setConsSaldo(String value){
		setString("consSaldo",value);
	}


	public String getDescAbrev(){
		return toString("descAbrev");
	}

	public void setDescAbrev(String value){
		setString("descAbrev",value);
	}


	public String getDescDeposito(){
		return toString("descDeposito");
	}

	public void setDescDeposito(String value){
		setString("descDeposito",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public com.br.client.model.cd.entity.eProduto getProduto(){
		Object obj = _self.get("produto");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.cd.entity.eProduto)obj;

	}

	public void setProduto(com.br.client.model.cd.entity.eProduto value){
		_self.remove("produto");
		if ( value != null )
			_self.put("produto", value);

	}


	public String getLocalizacao(){
		return toString("localizacao");
	}

	public void setLocalizacao(String value){
		setString("localizacao",value);
	}


	public String getCodPedidoVenda(){
		return toString("codPedidoVenda");
	}

	public void setCodPedidoVenda(String value){
		setString("codPedidoVenda",value);
	}


	public String getCustoTotal(){
		return toString("custoTotal");
	}

	public void setCustoTotal(String value){
		setString("custoTotal",value);
	}


	public String getCodNotaFiscal(){
		return toString("codNotaFiscal");
	}

	public void setCodNotaFiscal(String value){
		setString("codNotaFiscal",value);
	}


	public String getNrSequenciaNf(){
		return toString("nrSequenciaNf");
	}

	public void setNrSequenciaNf(String value){
		setString("nrSequenciaNf",value);
	}


	public String getDtRetorno(){
		return toString("dtRetorno");
	}

	public void setDtRetorno(String value){
		setString("dtRetorno",value);
	}


	public String getPrecoTabela(){
		return toString("precoTabela");
	}

	public void setPrecoTabela(String value){
		setString("precoTabela",value);
	}


	public String getPrecoVenda(){
		return toString("precoVenda");
	}

	public void setPrecoVenda(String value){
		setString("precoVenda",value);
	}


	public String getQtdSelecionada(){
		return toString("qtdSelecionada");
	}

	public void setQtdSelecionada(String value){
		setString("qtdSelecionada",value);
	}


	public String getVlCustoUnit(){
		return toString("vlCustoUnit");
	}

	public void setVlCustoUnit(String value){
		setString("vlCustoUnit",value);
	}


	public String getTpLinha(){
		return toString("tpLinha");
	}

	public void setTpLinha(String value){
		setString("tpLinha",value);
	}


	public String getDescTotal(){
		return toString("descTotal");
	}

	public void setDescTotal(String value){
		setString("descTotal",value);
	}


	public String getIndPlanejamento(){
		return toString("indPlanejamento");
	}

	public void setIndPlanejamento(String value){
		setString("indPlanejamento",value);
	}


	public String getIndProducao(){
		return toString("indProducao");
	}

	public void setIndProducao(String value){
		setString("indProducao",value);
	}


	public String getIndSeparacao(){
		return toString("indSeparacao");
	}

	public void setIndSeparacao(String value){
		setString("indSeparacao",value);
	}


	public String getIndRequisicaoMateriais(){
		return toString("indRequisicaoMateriais");
	}

	public void setIndRequisicaoMateriais(String value){
		setString("indRequisicaoMateriais",value);
	}


	public String getTpEstoque(){
		return toString("tpEstoque");
	}

	public void setTpEstoque(String value){
		setString("tpEstoque",value);
	}


	public String getDiasAvisoVencimento(){
		return toString("diasAvisoVencimento");
	}

	public void setDiasAvisoVencimento(String value){
		setString("diasAvisoVencimento",value);
	}


	public com.br.client.model.eq.entity.eSaldoDeposito[] getSaldos(){
		Object obj = _self.get("saldos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.eq.entity.eSaldoDeposito[])obj;

	}

	public void setSaldos(com.br.client.model.eq.entity.eSaldoDeposito[] value){
		_self.remove("saldos");
		if ( value != null )
			_self.put("saldos", value);

	}


	public com.br.client.model.eq.entity.eSaldoTerceiro[] getSaldosTerceiros(){
		Object obj = _self.get("saldosTerceiros");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.eq.entity.eSaldoTerceiro[])obj;

	}

	public void setSaldosTerceiros(com.br.client.model.eq.entity.eSaldoTerceiro[] value){
		_self.remove("saldosTerceiros");
		if ( value != null )
			_self.put("saldosTerceiros", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "produto".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eProduto obj = new com.br.client.model.cd.entity.eProduto();
			_self.put(name,obj);
		}
		if ( "saldos".equalsIgnoreCase(name) ){
			com.br.client.model.eq.entity.eSaldoDeposito[] obj = new com.br.client.model.eq.entity.eSaldoDeposito[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.eq.entity.eSaldoDeposito)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "saldosTerceiros".equalsIgnoreCase(name) ){
			com.br.client.model.eq.entity.eSaldoTerceiro[] obj = new com.br.client.model.eq.entity.eSaldoTerceiro[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.eq.entity.eSaldoTerceiro)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "produto".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eProduto obj = com.br.client.model.cd.entity.eProduto.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "saldos".equalsIgnoreCase(name) ){
			com.br.client.model.eq.entity.eSaldoDeposito obj = com.br.client.model.eq.entity.eSaldoDeposito.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "saldosTerceiros".equalsIgnoreCase(name) ){
			com.br.client.model.eq.entity.eSaldoTerceiro obj = com.br.client.model.eq.entity.eSaldoTerceiro.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.eq.entity.eSaldoTerceiro newInstance(){
		return new com.br.client.model.eq.entity.eSaldoTerceiro();
	}
}