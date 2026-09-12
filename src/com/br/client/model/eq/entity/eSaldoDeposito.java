package com.br.client.model.eq.entity;

public class eSaldoDeposito extends com.howmake.client.form.model.HowMGWTFormBean{
	public eSaldoDeposito(){
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getCodProduto(){
		return toString("codProduto");
	}

	public void setCodProduto(String value){
		setString("codProduto",value);
	}


	public String getCodDeposito(){
		return toString("codDeposito");
	}

	public void setCodDeposito(String value){
		setString("codDeposito",value);
	}


	public String getCodLote(){
		return toString("codLote");
	}

	public void setCodLote(String value){
		setString("codLote",value);
	}


	public String getDtEntrada(){
		return toString("dtEntrada");
	}

	public void setDtEntrada(String value){
		setString("dtEntrada",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getSaldoEstoque(){
		return toString("saldoEstoque");
	}

	public void setSaldoEstoque(String value){
		setString("saldoEstoque",value);
	}


	public String getSaldoPedido(){
		return toString("saldoPedido");
	}

	public void setSaldoPedido(String value){
		setString("saldoPedido",value);
	}


	public String getNomeEmpresa(){
		return toString("nomeEmpresa");
	}

	public void setNomeEmpresa(String value){
		setString("nomeEmpresa",value);
	}


	public String getDescProduto(){
		return toString("descProduto");
	}

	public void setDescProduto(String value){
		setString("descProduto",value);
	}


	public String getDescDeposito(){
		return toString("descDeposito");
	}

	public void setDescDeposito(String value){
		setString("descDeposito",value);
	}


	public String getCodEmbalagem(){
		return toString("codEmbalagem");
	}

	public void setCodEmbalagem(String value){
		setString("codEmbalagem",value);
	}


	public String getLocalizacao(){
		return toString("localizacao");
	}

	public void setLocalizacao(String value){
		setString("localizacao",value);
	}


	public String getDescLocalizacao(){
		return toString("descLocalizacao");
	}

	public void setDescLocalizacao(String value){
		setString("descLocalizacao",value);
	}


	public String getEtiqueta(){
		return toString("etiqueta");
	}

	public void setEtiqueta(String value){
		setString("etiqueta",value);
	}


	public String getCodPedidoVenda(){
		return toString("codPedidoVenda");
	}

	public void setCodPedidoVenda(String value){
		setString("codPedidoVenda",value);
	}


	public String getNrSerie(){
		return toString("nrSerie");
	}

	public void setNrSerie(String value){
		setString("nrSerie",value);
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


	public String getVlTotalProduto(){
		return toString("vlTotalProduto");
	}

	public void setVlTotalProduto(String value){
		setString("vlTotalProduto",value);
	}


	public String getVlTotalPrecoProduto(){
		return toString("vlTotalPrecoProduto");
	}

	public void setVlTotalPrecoProduto(String value){
		setString("vlTotalPrecoProduto",value);
	}


	public String getVlTotalPrecoProdutoPromocional(){
		return toString("vlTotalPrecoProdutoPromocional");
	}

	public void setVlTotalPrecoProdutoPromocional(String value){
		setString("vlTotalPrecoProdutoPromocional",value);
	}


	public String getVlTotalCustoProduto(){
		return toString("vlTotalCustoProduto");
	}

	public void setVlTotalCustoProduto(String value){
		setString("vlTotalCustoProduto",value);
	}


	public String getPrecoUnit(){
		return toString("precoUnit");
	}

	public void setPrecoUnit(String value){
		setString("precoUnit",value);
	}


	public String getPrecoUnitPromocional(){
		return toString("precoUnitPromocional");
	}

	public void setPrecoUnitPromocional(String value){
		setString("precoUnitPromocional",value);
	}


	public String getPrecoTotal(){
		return toString("precoTotal");
	}

	public void setPrecoTotal(String value){
		setString("precoTotal",value);
	}


	public String getVlCustoTotal(){
		return toString("vlCustoTotal");
	}

	public void setVlCustoTotal(String value){
		setString("vlCustoTotal",value);
	}


	public String getVlCustoTotalUnit(){
		return toString("vlCustoTotalUnit");
	}

	public void setVlCustoTotalUnit(String value){
		setString("vlCustoTotalUnit",value);
	}


	public String getVlCustoMedio(){
		return toString("vlCustoMedio");
	}

	public void setVlCustoMedio(String value){
		setString("vlCustoMedio",value);
	}


	public String getVlCustoMedioTotal(){
		return toString("vlCustoMedioTotal");
	}

	public void setVlCustoMedioTotal(String value){
		setString("vlCustoMedioTotal",value);
	}


	public String getVlCustoUnit(){
		return toString("vlCustoUnit");
	}

	public void setVlCustoUnit(String value){
		setString("vlCustoUnit",value);
	}


	public String getVlCustoFOB(){
		return toString("vlCustoFOB");
	}

	public void setVlCustoFOB(String value){
		setString("vlCustoFOB",value);
	}


	public String getVlCustoFOBUnit(){
		return toString("vlCustoFOBUnit");
	}

	public void setVlCustoFOBUnit(String value){
		setString("vlCustoFOBUnit",value);
	}


	public String getVlCustoCIF(){
		return toString("vlCustoCIF");
	}

	public void setVlCustoCIF(String value){
		setString("vlCustoCIF",value);
	}


	public String getVlCustoCIFUnit(){
		return toString("vlCustoCIFUnit");
	}

	public void setVlCustoCIFUnit(String value){
		setString("vlCustoCIFUnit",value);
	}


	public String getMoeda(){
		return toString("moeda");
	}

	public void setMoeda(String value){
		setString("moeda",value);
	}


	public String getMoedaCompra(){
		return toString("moedaCompra");
	}

	public void setMoedaCompra(String value){
		setString("moedaCompra",value);
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


	public String getTabelaPreco(){
		return toString("tabelaPreco");
	}

	public void setTabelaPreco(String value){
		setString("tabelaPreco",value);
	}


	public String getCodFamiliaComercial(){
		return toString("codFamiliaComercial");
	}

	public void setCodFamiliaComercial(String value){
		setString("codFamiliaComercial",value);
	}


	public String getSaldoTotal(){
		return toString("saldoTotal");
	}

	public void setSaldoTotal(String value){
		setString("saldoTotal",value);
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


	public String getQtdTransferir(){
		return toString("qtdTransferir");
	}

	public void setQtdTransferir(String value){
		setString("qtdTransferir",value);
	}


	public String getCustoTotal(){
		return toString("custoTotal");
	}

	public void setCustoTotal(String value){
		setString("custoTotal",value);
	}


	public String getVlSaldoCustoTotal(){
		return toString("vlSaldoCustoTotal");
	}

	public void setVlSaldoCustoTotal(String value){
		setString("vlSaldoCustoTotal",value);
	}


	public String getDemanda(){
		return toString("demanda");
	}

	public void setDemanda(String value){
		setString("demanda",value);
	}


	public String getUnidadeMedida(){
		return toString("unidadeMedida");
	}

	public void setUnidadeMedida(String value){
		setString("unidadeMedida",value);
	}


	public String getPerda(){
		return toString("perda");
	}

	public void setPerda(String value){
		setString("perda",value);
	}


	public String getCodEan(){
		return toString("codEan");
	}

	public void setCodEan(String value){
		setString("codEan",value);
	}


	public String getSaldoReal(){
		return toString("saldoReal");
	}

	public void setSaldoReal(String value){
		setString("saldoReal",value);
	}


	public String getChecado(){
		return toString("checado");
	}

	public void setChecado(String value){
		setString("checado",value);
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


	public String getQtdSelecionada(){
		return toString("qtdSelecionada");
	}

	public void setQtdSelecionada(String value){
		setString("qtdSelecionada",value);
	}


	public String getDtValidade(){
		return toString("dtValidade");
	}

	public void setDtValidade(String value){
		setString("dtValidade",value);
	}


	public String getDtProducao(){
		return toString("dtProducao");
	}

	public void setDtProducao(String value){
		setString("dtProducao",value);
	}


	public String getCodProdutoSintegra(){
		return toString("codProdutoSintegra");
	}

	public void setCodProdutoSintegra(String value){
		setString("codProdutoSintegra",value);
	}


	public String getNcmSH(){
		return toString("ncmSH");
	}

	public void setNcmSH(String value){
		setString("ncmSH",value);
	}


	public String getCodGrupo(){
		return toString("codGrupo");
	}

	public void setCodGrupo(String value){
		setString("codGrupo",value);
	}


	public String getDescGrupo(){
		return toString("descGrupo");
	}

	public void setDescGrupo(String value){
		setString("descGrupo",value);
	}


	public String getAliquotaICMS(){
		return toString("aliquotaICMS");
	}

	public void setAliquotaICMS(String value){
		setString("aliquotaICMS",value);
	}


	public String getVlICMS(){
		return toString("vlICMS");
	}

	public void setVlICMS(String value){
		setString("vlICMS",value);
	}


	public String getSituacao(){
		return toString("situacao");
	}

	public void setSituacao(String value){
		setString("situacao",value);
	}


	public String getCnpjTerceiro(){
		return toString("cnpjTerceiro");
	}

	public void setCnpjTerceiro(String value){
		setString("cnpjTerceiro",value);
	}


	public String getInscricaoEstatual(){
		return toString("inscricaoEstatual");
	}

	public void setInscricaoEstatual(String value){
		setString("inscricaoEstatual",value);
	}


	public String getUfTeceiro(){
		return toString("ufTeceiro");
	}

	public void setUfTeceiro(String value){
		setString("ufTeceiro",value);
	}


	public String getObservacao(){
		return toString("observacao");
	}

	public void setObservacao(String value){
		setString("observacao",value);
	}


	public String getDescricaoTecnica(){
		return toString("descricaoTecnica");
	}

	public void setDescricaoTecnica(String value){
		setString("descricaoTecnica",value);
	}


	public boolean getSelecionado(){
		return toBoolean("selecionado");
	}

	public void setSelecionado(boolean value){
		setBoolean("selecionado",value);
	}


	public String getCodUa(){
		return toString("codUa");
	}

	public void setCodUa(String value){
		setString("codUa",value);
	}


	public String getDescTecnica(){
		return toString("descTecnica");
	}

	public void setDescTecnica(String value){
		setString("descTecnica",value);
	}


	public String getCodMarca(){
		return toString("codMarca");
	}

	public void setCodMarca(String value){
		setString("codMarca",value);
	}


	public String getDescMarca(){
		return toString("descMarca");
	}

	public void setDescMarca(String value){
		setString("descMarca",value);
	}


	public String getRazaoSocialEmpresa(){
		return toString("razaoSocialEmpresa");
	}

	public void setRazaoSocialEmpresa(String value){
		setString("razaoSocialEmpresa",value);
	}


	public String getCodEmpresaDeposito(){
		return toString("codEmpresaDeposito");
	}

	public void setCodEmpresaDeposito(String value){
		setString("codEmpresaDeposito",value);
	}


	public String getDiasVencer(){
		return toString("diasVencer");
	}

	public void setDiasVencer(String value){
		setString("diasVencer",value);
	}


	public String getQtdMin(){
		return toString("qtdMin");
	}

	public void setQtdMin(String value){
		setString("qtdMin",value);
	}


	public String getLocalizacaoProduto(){
		return toString("localizacaoProduto");
	}

	public void setLocalizacaoProduto(String value){
		setString("localizacaoProduto",value);
	}


	public String getNfEntrada(){
		return toString("nfEntrada");
	}

	public void setNfEntrada(String value){
		setString("nfEntrada",value);
	}


	public String getDescAbrev(){
		return toString("descAbrev");
	}

	public void setDescAbrev(String value){
		setString("descAbrev",value);
	}


	public String getConsSaldo(){
		return toString("consSaldo");
	}

	public void setConsSaldo(String value){
		setString("consSaldo",value);
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


	public static final com.br.client.model.eq.entity.eSaldoDeposito newInstance(){
		return new com.br.client.model.eq.entity.eSaldoDeposito();
	}
}