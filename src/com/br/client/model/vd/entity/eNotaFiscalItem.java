package com.br.client.model.vd.entity;

public class eNotaFiscalItem extends com.howmake.client.form.model.HowMGWTFormBean{
	public eNotaFiscalItem(){
	}


	public String getCodProdutoCliente(){
		return toString("codProdutoCliente");
	}

	public void setCodProdutoCliente(String value){
		setString("codProdutoCliente",value);
	}


	public String getAliqISS(){
		return toString("aliqISS");
	}

	public void setAliqISS(String value){
		setString("aliqISS",value);
	}


	public String getVlBaseISS(){
		return toString("vlBaseISS");
	}

	public void setVlBaseISS(String value){
		setString("vlBaseISS",value);
	}


	public String getValorISS(){
		return toString("valorISS");
	}

	public void setValorISS(String value){
		setString("valorISS",value);
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getNrNotaFiscal(){
		return toString("nrNotaFiscal");
	}

	public void setNrNotaFiscal(String value){
		setString("nrNotaFiscal",value);
	}


	public String getCodNrNotaFiscal(){
		return toString("codNrNotaFiscal");
	}

	public void setCodNrNotaFiscal(String value){
		setString("codNrNotaFiscal",value);
	}


	public String getSerie(){
		return toString("serie");
	}

	public void setSerie(String value){
		setString("serie",value);
	}


	public String getNrSequenciaNf(){
		return toString("nrSequenciaNf");
	}

	public void setNrSequenciaNf(String value){
		setString("nrSequenciaNf",value);
	}


	public String getCodPedido(){
		return toString("codPedido");
	}

	public void setCodPedido(String value){
		setString("codPedido",value);
	}


	public String getMargemBruta(){
		return toString("margemBruta");
	}

	public void setMargemBruta(String value){
		setString("margemBruta",value);
	}


	public String getCustoUnitProdutoAtual(){
		return toString("custoUnitProdutoAtual");
	}

	public void setCustoUnitProdutoAtual(String value){
		setString("custoUnitProdutoAtual",value);
	}


	public String getCustoUnitPedido(){
		return toString("custoUnitPedido");
	}

	public void setCustoUnitPedido(String value){
		setString("custoUnitPedido",value);
	}


	public String getCustoTotalPedido(){
		return toString("custoTotalPedido");
	}

	public void setCustoTotalPedido(String value){
		setString("custoTotalPedido",value);
	}


	public String getCustoTotalItem(){
		return toString("custoTotalItem");
	}

	public void setCustoTotalItem(String value){
		setString("custoTotalItem",value);
	}


	public String getNrSequencia(){
		return toString("nrSequencia");
	}

	public void setNrSequencia(String value){
		setString("nrSequencia",value);
	}


	public String getNrSequenciaPai(){
		return toString("nrSequenciaPai");
	}

	public void setNrSequenciaPai(String value){
		setString("nrSequenciaPai",value);
	}


	public String getNomeFantasia(){
		return toString("nomeFantasia");
	}

	public void setNomeFantasia(String value){
		setString("nomeFantasia",value);
	}


	public String getQtd(){
		return toString("qtd");
	}

	public void setQtd(String value){
		setString("qtd",value);
	}


	public String getCcusto(){
		return toString("ccusto");
	}

	public void setCcusto(String value){
		setString("ccusto",value);
	}


	public String getPrecoTotal(){
		return toString("precoTotal");
	}

	public void setPrecoTotal(String value){
		setString("precoTotal",value);
	}


	public String getPrecoVenda(){
		return toString("precoVenda");
	}

	public void setPrecoVenda(String value){
		setString("precoVenda",value);
	}


	public String getPrecoVendaOriginal(){
		return toString("precoVendaOriginal");
	}

	public void setPrecoVendaOriginal(String value){
		setString("precoVendaOriginal",value);
	}


	public String getAliquotaICMSSuframa(){
		return toString("aliquotaICMSSuframa");
	}

	public void setAliquotaICMSSuframa(String value){
		setString("aliquotaICMSSuframa",value);
	}


	public String getDescricaoProduto(){
		return toString("descricaoProduto");
	}

	public void setDescricaoProduto(String value){
		setString("descricaoProduto",value);
	}


	public String getVlBaseIPI(){
		return toString("vlBaseIPI");
	}

	public void setVlBaseIPI(String value){
		setString("vlBaseIPI",value);
	}


	public String getPercDesconto(){
		return toString("percDesconto");
	}

	public void setPercDesconto(String value){
		setString("percDesconto",value);
	}


	public String getNumerosSerie(){
		return toString("numerosSerie");
	}

	public void setNumerosSerie(String value){
		setString("numerosSerie",value);
	}


	public String getValorDesconto(){
		return toString("valorDesconto");
	}

	public void setValorDesconto(String value){
		setString("valorDesconto",value);
	}


	public com.br.client.model.vd.entity.eItemPedidoEtq[] getEtqs(){
		Object obj = _self.get("etqs");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eItemPedidoEtq[])obj;

	}

	public void setEtqs(com.br.client.model.vd.entity.eItemPedidoEtq[] value){
		_self.remove("etqs");
		if ( value != null )
			_self.put("etqs", value);

	}


	public com.br.client.model.vd.entity.eNotaFiscalItemEtq[] getNotaEtqs(){
		Object obj = _self.get("notaEtqs");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNotaFiscalItemEtq[])obj;

	}

	public void setNotaEtqs(com.br.client.model.vd.entity.eNotaFiscalItemEtq[] value){
		_self.remove("notaEtqs");
		if ( value != null )
			_self.put("notaEtqs", value);

	}


	public String getPercReducaoST(){
		return toString("percReducaoST");
	}

	public void setPercReducaoST(String value){
		setString("percReducaoST",value);
	}


	public int getSituacaoEstoque(){
		return toInteger("situacaoEstoque");
	}

	public void setSituacaoEstoque(int value){
		setInteger("situacaoEstoque",value);
	}


	public String getPrecoOriginal(){
		return toString("precoOriginal");
	}

	public void setPrecoOriginal(String value){
		setString("precoOriginal",value);
	}


	public String getCodEAN(){
		return toString("codEAN");
	}

	public void setCodEAN(String value){
		setString("codEAN",value);
	}


	public String getCST(){
		return toString("CST");
	}

	public void setCST(String value){
		setString("CST",value);
	}


	public String getIndEstoque(){
		return toString("indEstoque");
	}

	public void setIndEstoque(String value){
		setString("indEstoque",value);
	}


	public String getCodFornecedor(){
		return toString("codFornecedor");
	}

	public void setCodFornecedor(String value){
		setString("codFornecedor",value);
	}


	public String getPorcentagemRentabilidade(){
		return toString("porcentagemRentabilidade");
	}

	public void setPorcentagemRentabilidade(String value){
		setString("porcentagemRentabilidade",value);
	}


	public String getTpTotal(){
		return toString("tpTotal");
	}

	public void setTpTotal(String value){
		setString("tpTotal",value);
	}


	public String getTpLinha(){
		return toString("tpLinha");
	}

	public void setTpLinha(String value){
		setString("tpLinha",value);
	}


	public String getDescNotaFiscalItem(){
		return toString("descNotaFiscalItem");
	}

	public void setDescNotaFiscalItem(String value){
		setString("descNotaFiscalItem",value);
	}


	public String getSiglaClassFiscal(){
		return toString("siglaClassFiscal");
	}

	public void setSiglaClassFiscal(String value){
		setString("siglaClassFiscal",value);
	}


	public String getVlBonusCreditado(){
		return toString("vlBonusCreditado");
	}

	public void setVlBonusCreditado(String value){
		setString("vlBonusCreditado",value);
	}


	public String getTpRegistro(){
		return toString("tpRegistro");
	}

	public void setTpRegistro(String value){
		setString("tpRegistro",value);
	}


	public String getTpReceita(){
		return toString("tpReceita");
	}

	public void setTpReceita(String value){
		setString("tpReceita",value);
	}


	public String getVlUnitario(){
		return toString("vlUnitario");
	}

	public void setVlUnitario(String value){
		setString("vlUnitario",value);
	}


	public String getVlTotal(){
		return toString("vlTotal");
	}

	public void setVlTotal(String value){
		setString("vlTotal",value);
	}


	public String getCodNotaFiscal(){
		return toString("codNotaFiscal");
	}

	public void setCodNotaFiscal(String value){
		setString("codNotaFiscal",value);
	}


	public String getTpNotaFiscal(){
		return toString("tpNotaFiscal");
	}

	public void setTpNotaFiscal(String value){
		setString("tpNotaFiscal",value);
	}


	public String getCodLote(){
		return toString("codLote");
	}

	public void setCodLote(String value){
		setString("codLote",value);
	}


	public String getNcm(){
		return toString("ncm");
	}

	public void setNcm(String value){
		setString("ncm",value);
	}


	public String getDtEmissaoNf(){
		return toString("dtEmissaoNf");
	}

	public void setDtEmissaoNf(String value){
		setString("dtEmissaoNf",value);
	}


	public String getObsItem(){
		return toString("obsItem");
	}

	public void setObsItem(String value){
		setString("obsItem",value);
	}


	public boolean getBooFaturar(){
		return toBoolean("booFaturar");
	}

	public void setBooFaturar(boolean value){
		setBoolean("booFaturar",value);
	}


	public String getVlCustoUnit(){
		return toString("vlCustoUnit");
	}

	public void setVlCustoUnit(String value){
		setString("vlCustoUnit",value);
	}


	public String getINotaFiscal(){
		return toString("iNotaFiscal");
	}

	public void setINotaFiscal(String value){
		setString("iNotaFiscal",value);
	}


	public String getAliquotaPIS(){
		return toString("aliquotaPIS");
	}

	public void setAliquotaPIS(String value){
		setString("aliquotaPIS",value);
	}


	public String getValorPIS(){
		return toString("valorPIS");
	}

	public void setValorPIS(String value){
		setString("valorPIS",value);
	}


	public String getVlBasePIS(){
		return toString("vlBasePIS");
	}

	public void setVlBasePIS(String value){
		setString("vlBasePIS",value);
	}


	public String getValorCOFINS(){
		return toString("valorCOFINS");
	}

	public void setValorCOFINS(String value){
		setString("valorCOFINS",value);
	}


	public String getVlBaseCOFINS(){
		return toString("vlBaseCOFINS");
	}

	public void setVlBaseCOFINS(String value){
		setString("vlBaseCOFINS",value);
	}


	public String getAliquotaCOFINS(){
		return toString("aliquotaCOFINS");
	}

	public void setAliquotaCOFINS(String value){
		setString("aliquotaCOFINS",value);
	}


	public String getValorII(){
		return toString("valorII");
	}

	public void setValorII(String value){
		setString("valorII",value);
	}


	public String getVlBaseII(){
		return toString("vlBaseII");
	}

	public void setVlBaseII(String value){
		setString("vlBaseII",value);
	}


	public String getAliquotaII(){
		return toString("aliquotaII");
	}

	public void setAliquotaII(String value){
		setString("aliquotaII",value);
	}


	public String getPercReducao(){
		return toString("percReducao");
	}

	public void setPercReducao(String value){
		setString("percReducao",value);
	}


	public String getVlBaseICMS(){
		return toString("vlBaseICMS");
	}

	public void setVlBaseICMS(String value){
		setString("vlBaseICMS",value);
	}


	public String getPercBaseICMSST(){
		return toString("percBaseICMSST");
	}

	public void setPercBaseICMSST(String value){
		setString("percBaseICMSST",value);
	}


	public String getPercIVAST(){
		return toString("percIVAST");
	}

	public void setPercIVAST(String value){
		setString("percIVAST",value);
	}


	public String getVlBaseICMSSubst(){
		return toString("vlBaseICMSSubst");
	}

	public void setVlBaseICMSSubst(String value){
		setString("vlBaseICMSSubst",value);
	}


	public String getVlICMSSubst(){
		return toString("vlICMSSubst");
	}

	public void setVlICMSSubst(String value){
		setString("vlICMSSubst",value);
	}


	public String getPercDiferimento(){
		return toString("percDiferimento");
	}

	public void setPercDiferimento(String value){
		setString("percDiferimento",value);
	}


	public String getCt(){
		return toString("ct");
	}

	public void setCt(String value){
		setString("ct",value);
	}


	public String getCfop(){
		return toString("cfop");
	}

	public void setCfop(String value){
		setString("cfop",value);
	}


	public String getCsosn(){
		return toString("csosn");
	}

	public void setCsosn(String value){
		setString("csosn",value);
	}


	public String getVlItemFrete(){
		return toString("vlItemFrete");
	}

	public void setVlItemFrete(String value){
		setString("vlItemFrete",value);
	}


	public String getVlItemSeguro(){
		return toString("vlItemSeguro");
	}

	public void setVlItemSeguro(String value){
		setString("vlItemSeguro",value);
	}


	public String getVlItemDesconto(){
		return toString("vlItemDesconto");
	}

	public void setVlItemDesconto(String value){
		setString("vlItemDesconto",value);
	}


	public String getNrAdicao(){
		return toString("nrAdicao");
	}

	public void setNrAdicao(String value){
		setString("nrAdicao",value);
	}


	public String getSeqAdicao(){
		return toString("seqAdicao");
	}

	public void setSeqAdicao(String value){
		setString("seqAdicao",value);
	}


	public String getImprimeNF(){
		return toString("imprimeNF");
	}

	public void setImprimeNF(String value){
		setString("imprimeNF",value);
	}


	public String getCodOp(){
		return toString("codOp");
	}

	public void setCodOp(String value){
		setString("codOp",value);
	}


	public String getPercBaseISS(){
		return toString("percBaseISS");
	}

	public void setPercBaseISS(String value){
		setString("percBaseISS",value);
	}


	public String getNrPedCompraCli(){
		return toString("nrPedCompraCli");
	}

	public void setNrPedCompraCli(String value){
		setString("nrPedCompraCli",value);
	}


	public String getIdCodProdutoPromocao(){
		return toString("idCodProdutoPromocao");
	}

	public void setIdCodProdutoPromocao(String value){
		setString("idCodProdutoPromocao",value);
	}


	public String getIdProdutoOracle(){
		return toString("idProdutoOracle");
	}

	public void setIdProdutoOracle(String value){
		setString("idProdutoOracle",value);
	}


	public String getArea(){
		return toString("area");
	}

	public void setArea(String value){
		setString("area",value);
	}


	public String getNomeOrcamento(){
		return toString("nomeOrcamento");
	}

	public void setNomeOrcamento(String value){
		setString("nomeOrcamento",value);
	}


	public String getDepositoSeparacao(){
		return toString("depositoSeparacao");
	}

	public void setDepositoSeparacao(String value){
		setString("depositoSeparacao",value);
	}


	public String getIndBaixaEstoque(){
		return toString("indBaixaEstoque");
	}

	public void setIndBaixaEstoque(String value){
		setString("indBaixaEstoque",value);
	}


	public String getIndGeraCR(){
		return toString("indGeraCR");
	}

	public void setIndGeraCR(String value){
		setString("indGeraCR",value);
	}


	public String getCustoUnitEntrada(){
		return toString("custoUnitEntrada");
	}

	public void setCustoUnitEntrada(String value){
		setString("custoUnitEntrada",value);
	}


	public String getCustoTotalEntrada(){
		return toString("custoTotalEntrada");
	}

	public void setCustoTotalEntrada(String value){
		setString("custoTotalEntrada",value);
	}


	public String getRentabilidadeBrutaTrile(){
		return toString("rentabilidadeBrutaTrile");
	}

	public void setRentabilidadeBrutaTrile(String value){
		setString("rentabilidadeBrutaTrile",value);
	}


	public String getCotacaoRecebimento(){
		return toString("cotacaoRecebimento");
	}

	public void setCotacaoRecebimento(String value){
		setString("cotacaoRecebimento",value);
	}


	public String getMoedaEntradaRecebimento(){
		return toString("moedaEntradaRecebimento");
	}

	public void setMoedaEntradaRecebimento(String value){
		setString("moedaEntradaRecebimento",value);
	}


	public String getEntradaSifrao(){
		return toString("entradaSifrao");
	}

	public void setEntradaSifrao(String value){
		setString("entradaSifrao",value);
	}


	public String getTotalSifrao(){
		return toString("totalSifrao");
	}

	public void setTotalSifrao(String value){
		setString("totalSifrao",value);
	}


	public String getCustoTotalGuea(){
		return toString("custoTotalGuea");
	}

	public void setCustoTotalGuea(String value){
		setString("custoTotalGuea",value);
	}


	public String getCodOpcaoLinha(){
		return toString("codOpcaoLinha");
	}

	public void setCodOpcaoLinha(String value){
		setString("codOpcaoLinha",value);
	}


	public String getCodProdutoPaiVtex(){
		return toString("codProdutoPaiVtex");
	}

	public void setCodProdutoPaiVtex(String value){
		setString("codProdutoPaiVtex",value);
	}


	public String getDescTecnicaPai(){
		return toString("descTecnicaPai");
	}

	public void setDescTecnicaPai(String value){
		setString("descTecnicaPai",value);
	}


	public String getCodProduto(){
		return toString("codProduto");
	}

	public void setCodProduto(String value){
		setString("codProduto",value);
	}


	public String getCodProdutoSimilar(){
		return toString("codProdutoSimilar");
	}

	public void setCodProdutoSimilar(String value){
		setString("codProdutoSimilar",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getCodLinha(){
		return toString("codLinha");
	}

	public void setCodLinha(String value){
		setString("codLinha",value);
	}


	public String getCodClassFiscal(){
		return toString("codClassFiscal");
	}

	public void setCodClassFiscal(String value){
		setString("codClassFiscal",value);
	}


	public String getMoeda(){
		return toString("moeda");
	}

	public void setMoeda(String value){
		setString("moeda",value);
	}


	public String getCodTribIcms(){
		return toString("codTribIcms");
	}

	public void setCodTribIcms(String value){
		setString("codTribIcms",value);
	}


	public String getDescComercialFornecedor(){
		return toString("descComercialFornecedor");
	}

	public void setDescComercialFornecedor(String value){
		setString("descComercialFornecedor",value);
	}


	public String getClassFiscal(){
		return toString("classFiscal");
	}

	public void setClassFiscal(String value){
		setString("classFiscal",value);
	}


	public String getDescComercial(){
		return toString("descComercial");
	}

	public void setDescComercial(String value){
		setString("descComercial",value);
	}


	public String getClassificacao(){
		return toString("classificacao");
	}

	public void setClassificacao(String value){
		setString("classificacao",value);
	}


	public String getDescTecnica(){
		return toString("descTecnica");
	}

	public void setDescTecnica(String value){
		setString("descTecnica",value);
	}


	public String getDescTecnicaTitle(){
		return toString("descTecnicaTitle");
	}

	public void setDescTecnicaTitle(String value){
		setString("descTecnicaTitle",value);
	}


	public String getDescNotaFiscal(){
		return toString("descNotaFiscal");
	}

	public void setDescNotaFiscal(String value){
		setString("descNotaFiscal",value);
	}


	public String getCodProdutoNotaFiscal(){
		return toString("codProdutoNotaFiscal");
	}

	public void setCodProdutoNotaFiscal(String value){
		setString("codProdutoNotaFiscal",value);
	}


	public String getCodDeposito(){
		return toString("codDeposito");
	}

	public void setCodDeposito(String value){
		setString("codDeposito",value);
	}


	public String getUn(){
		return toString("un");
	}

	public void setUn(String value){
		setString("un",value);
	}


	public String getDescPda(){
		return toString("descPda");
	}

	public void setDescPda(String value){
		setString("descPda",value);
	}


	public String getSituacao(){
		return toString("situacao");
	}

	public void setSituacao(String value){
		setString("situacao",value);
	}


	public String getIndFantasma(){
		return toString("indFantasma");
	}

	public void setIndFantasma(String value){
		setString("indFantasma",value);
	}


	public String getIndItensExclusivo(){
		return toString("indItensExclusivo");
	}

	public void setIndItensExclusivo(String value){
		setString("indItensExclusivo",value);
	}


	public String getIndQtdFracionada(){
		return toString("indQtdFracionada");
	}

	public void setIndQtdFracionada(String value){
		setString("indQtdFracionada",value);
	}


	public String getIndQtdFracionadaProducao(){
		return toString("indQtdFracionadaProducao");
	}

	public void setIndQtdFracionadaProducao(String value){
		setString("indQtdFracionadaProducao",value);
	}


	public String getQtdMinEtq(){
		return toString("qtdMinEtq");
	}

	public void setQtdMinEtq(String value){
		setString("qtdMinEtq",value);
	}


	public String getQtdPorEmbalagem(){
		return toString("qtdPorEmbalagem");
	}

	public void setQtdPorEmbalagem(String value){
		setString("qtdPorEmbalagem",value);
	}


	public String getQtdMax(){
		return toString("qtdMax");
	}

	public void setQtdMax(String value){
		setString("qtdMax",value);
	}


	public String getPesoBruto(){
		return toString("pesoBruto");
	}

	public void setPesoBruto(String value){
		setString("pesoBruto",value);
	}


	public String getPesoLiquido(){
		return toString("pesoLiquido");
	}

	public void setPesoLiquido(String value){
		setString("pesoLiquido",value);
	}


	public String getTpAquisicao(){
		return toString("tpAquisicao");
	}

	public void setTpAquisicao(String value){
		setString("tpAquisicao",value);
	}


	public String getIndFaturado(){
		return toString("indFaturado");
	}

	public void setIndFaturado(String value){
		setString("indFaturado",value);
	}


	public String getLoteEconomico(){
		return toString("loteEconomico");
	}

	public void setLoteEconomico(String value){
		setString("loteEconomico",value);
	}


	public String getDtImplant(){
		return toString("dtImplant");
	}

	public void setDtImplant(String value){
		setString("dtImplant",value);
	}


	public String getDtAlteracao(){
		return toString("dtAlteracao");
	}

	public void setDtAlteracao(String value){
		setString("dtAlteracao",value);
	}


	public String getCodColaboradorAlteracao(){
		return toString("codColaboradorAlteracao");
	}

	public void setCodColaboradorAlteracao(String value){
		setString("codColaboradorAlteracao",value);
	}


	public String getCodTributacaoISS(){
		return toString("codTributacaoISS");
	}

	public void setCodTributacaoISS(String value){
		setString("codTributacaoISS",value);
	}


	public String getCodTributacaoIPI(){
		return toString("codTributacaoIPI");
	}

	public void setCodTributacaoIPI(String value){
		setString("codTributacaoIPI",value);
	}


	public String getAliquotaIPI(){
		return toString("aliquotaIPI");
	}

	public void setAliquotaIPI(String value){
		setString("aliquotaIPI",value);
	}


	public String getAliquotaISS(){
		return toString("aliquotaISS");
	}

	public void setAliquotaISS(String value){
		setString("aliquotaISS",value);
	}


	public String getIndServico(){
		return toString("indServico");
	}

	public void setIndServico(String value){
		setString("indServico",value);
	}


	public String getIndBonificacao(){
		return toString("indBonificacao");
	}

	public void setIndBonificacao(String value){
		setString("indBonificacao",value);
	}


	public String getIndCreditaBonus(){
		return toString("indCreditaBonus");
	}

	public void setIndCreditaBonus(String value){
		setString("indCreditaBonus",value);
	}


	public String getIndPromocao(){
		return toString("indPromocao");
	}

	public void setIndPromocao(String value){
		setString("indPromocao",value);
	}


	public String getDun14(){
		return toString("dun14");
	}

	public void setDun14(String value){
		setString("dun14",value);
	}


	public String getIndIPIDiferenciado(){
		return toString("indIPIDiferenciado");
	}

	public void setIndIPIDiferenciado(String value){
		setString("indIPIDiferenciado",value);
	}


	public String getLeadTime(){
		return toString("leadTime");
	}

	public void setLeadTime(String value){
		setString("leadTime",value);
	}


	public String getOrigem(){
		return toString("origem");
	}

	public void setOrigem(String value){
		setString("origem",value);
	}


	public String getTempoFabricacao(){
		return toString("tempoFabricacao");
	}

	public void setTempoFabricacao(String value){
		setString("tempoFabricacao",value);
	}


	public String getVlCustoTotal(){
		return toString("vlCustoTotal");
	}

	public void setVlCustoTotal(String value){
		setString("vlCustoTotal",value);
	}


	public String getDtVlCustoTotal(){
		return toString("dtVlCustoTotal");
	}

	public void setDtVlCustoTotal(String value){
		setString("dtVlCustoTotal",value);
	}


	public String getVlCustoFOB(){
		return toString("vlCustoFOB");
	}

	public void setVlCustoFOB(String value){
		setString("vlCustoFOB",value);
	}


	public String getVlCustoCIF(){
		return toString("vlCustoCIF");
	}

	public void setVlCustoCIF(String value){
		setString("vlCustoCIF",value);
	}


	public String getVlCustoMedio(){
		return toString("vlCustoMedio");
	}

	public void setVlCustoMedio(String value){
		setString("vlCustoMedio",value);
	}


	public String getVlCustoMedioEstrutura(){
		return toString("vlCustoMedioEstrutura");
	}

	public void setVlCustoMedioEstrutura(String value){
		setString("vlCustoMedioEstrutura",value);
	}


	public String getVlCustoTotalEstrutura(){
		return toString("vlCustoTotalEstrutura");
	}

	public void setVlCustoTotalEstrutura(String value){
		setString("vlCustoTotalEstrutura",value);
	}


	public String getMoedaCompra(){
		return toString("moedaCompra");
	}

	public void setMoedaCompra(String value){
		setString("moedaCompra",value);
	}


	public String getIndEcommerce(){
		return toString("indEcommerce");
	}

	public void setIndEcommerce(String value){
		setString("indEcommerce",value);
	}


	public String getIndRevenda(){
		return toString("indRevenda");
	}

	public void setIndRevenda(String value){
		setString("indRevenda",value);
	}


	public String getCodProdutoFornec(){
		return toString("codProdutoFornec");
	}

	public void setCodProdutoFornec(String value){
		setString("codProdutoFornec",value);
	}


	public String getLocalizacao(){
		return toString("localizacao");
	}

	public void setLocalizacao(String value){
		setString("localizacao",value);
	}


	public String getAjusteProduto(){
		return toString("ajusteProduto");
	}

	public void setAjusteProduto(String value){
		setString("ajusteProduto",value);
	}


	public String getTpCalculoIPI(){
		return toString("tpCalculoIPI");
	}

	public void setTpCalculoIPI(String value){
		setString("tpCalculoIPI",value);
	}


	public String getDescProduto(){
		return toString("descProduto");
	}

	public void setDescProduto(String value){
		setString("descProduto",value);
	}


	public String getNomeFornecedor(){
		return toString("nomeFornecedor");
	}

	public void setNomeFornecedor(String value){
		setString("nomeFornecedor",value);
	}


	public String getLogoFornecedor(){
		return toString("logoFornecedor");
	}

	public void setLogoFornecedor(String value){
		setString("logoFornecedor",value);
	}


	public String getAltura(){
		return toString("altura");
	}

	public void setAltura(String value){
		setString("altura",value);
	}


	public String getLargura(){
		return toString("largura");
	}

	public void setLargura(String value){
		setString("largura",value);
	}


	public String getComprimento(){
		return toString("comprimento");
	}

	public void setComprimento(String value){
		setString("comprimento",value);
	}


	public String getDiametro(){
		return toString("diametro");
	}

	public void setDiametro(String value){
		setString("diametro",value);
	}


	public String getProfundidade(){
		return toString("profundidade");
	}

	public void setProfundidade(String value){
		setString("profundidade",value);
	}


	public String getDescFamiliaComercial(){
		return toString("descFamiliaComercial");
	}

	public void setDescFamiliaComercial(String value){
		setString("descFamiliaComercial",value);
	}


	public String getUnidade(){
		return toString("unidade");
	}

	public void setUnidade(String value){
		setString("unidade",value);
	}


	public String getTpRosca(){
		return toString("tpRosca");
	}

	public void setTpRosca(String value){
		setString("tpRosca",value);
	}


	public String getFppPasso(){
		return toString("fppPasso");
	}

	public void setFppPasso(String value){
		setString("fppPasso",value);
	}


	public String getBitola(){
		return toString("bitola");
	}

	public void setBitola(String value){
		setString("bitola",value);
	}


	public String getAcabamento(){
		return toString("acabamento");
	}

	public void setAcabamento(String value){
		setString("acabamento",value);
	}


	public String getTpNorma(){
		return toString("tpNorma");
	}

	public void setTpNorma(String value){
		setString("tpNorma",value);
	}


	public String getNormaAcabamento(){
		return toString("normaAcabamento");
	}

	public void setNormaAcabamento(String value){
		setString("normaAcabamento",value);
	}


	public String getCodNorma(){
		return toString("codNorma");
	}

	public void setCodNorma(String value){
		setString("codNorma",value);
	}


	public String getCst(){
		return toString("cst");
	}

	public void setCst(String value){
		setString("cst",value);
	}


	public String getFatorInternacao(){
		return toString("fatorInternacao");
	}

	public void setFatorInternacao(String value){
		setString("fatorInternacao",value);
	}


	public String getVlCustoInternado(){
		return toString("vlCustoInternado");
	}

	public void setVlCustoInternado(String value){
		setString("vlCustoInternado",value);
	}


	public String getCor(){
		return toString("cor");
	}

	public void setCor(String value){
		setString("cor",value);
	}


	public String getDescCor(){
		return toString("descCor");
	}

	public void setDescCor(String value){
		setString("descCor",value);
	}


	public String getStatus(){
		return toString("status");
	}

	public void setStatus(String value){
		setString("status",value);
	}


	public String getIndPdv(){
		return toString("indPdv");
	}

	public void setIndPdv(String value){
		setString("indPdv",value);
	}


	public String getCodAtividadeRPS(){
		return toString("codAtividadeRPS");
	}

	public void setCodAtividadeRPS(String value){
		setString("codAtividadeRPS",value);
	}


	public String getAliqIBPT(){
		return toString("aliqIBPT");
	}

	public void setAliqIBPT(String value){
		setString("aliqIBPT",value);
	}


	public String getIndSped(){
		return toString("indSped");
	}

	public void setIndSped(String value){
		setString("indSped",value);
	}


	public String getCodProdutoOrigem(){
		return toString("codProdutoOrigem");
	}

	public void setCodProdutoOrigem(String value){
		setString("codProdutoOrigem",value);
	}


	public String getCodProdutoPaiOrigem(){
		return toString("codProdutoPaiOrigem");
	}

	public void setCodProdutoPaiOrigem(String value){
		setString("codProdutoPaiOrigem",value);
	}


	public String getConta(){
		return toString("conta");
	}

	public void setConta(String value){
		setString("conta",value);
	}


	public String getSubConta(){
		return toString("subConta");
	}

	public void setSubConta(String value){
		setString("subConta",value);
	}


	public String getTpInventario(){
		return toString("tpInventario");
	}

	public void setTpInventario(String value){
		setString("tpInventario",value);
	}


	public String getPrecoUnit(){
		return toString("precoUnit");
	}

	public void setPrecoUnit(String value){
		setString("precoUnit",value);
	}


	public String getPrecoMinimo(){
		return toString("precoMinimo");
	}

	public void setPrecoMinimo(String value){
		setString("precoMinimo",value);
	}


	public String getPrecoMaximo(){
		return toString("precoMaximo");
	}

	public void setPrecoMaximo(String value){
		setString("precoMaximo",value);
	}


	public String getPrecificacao(){
		return toString("precificacao");
	}

	public void setPrecificacao(String value){
		setString("precificacao",value);
	}


	public String getCodCliente(){
		return toString("codCliente");
	}

	public void setCodCliente(String value){
		setString("codCliente",value);
	}


	public com.br.client.model.cd.entity.eProdutoEmpresa[] getEmpresas(){
		Object obj = _self.get("empresas");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.cd.entity.eProdutoEmpresa[])obj;

	}

	public void setEmpresas(com.br.client.model.cd.entity.eProdutoEmpresa[] value){
		_self.remove("empresas");
		if ( value != null )
			_self.put("empresas", value);

	}


	public String getSeqNrSerie(){
		return toString("seqNrSerie");
	}

	public void setSeqNrSerie(String value){
		setString("seqNrSerie",value);
	}


	public String getSiglaNrSerie(){
		return toString("siglaNrSerie");
	}

	public void setSiglaNrSerie(String value){
		setString("siglaNrSerie",value);
	}


	public String getDigitosNrSerie(){
		return toString("digitosNrSerie");
	}

	public void setDigitosNrSerie(String value){
		setString("digitosNrSerie",value);
	}


	public String getCustoConfigurador(){
		return toString("custoConfigurador");
	}

	public void setCustoConfigurador(String value){
		setString("custoConfigurador",value);
	}


	public String getPrecoVendaConfigurador(){
		return toString("precoVendaConfigurador");
	}

	public void setPrecoVendaConfigurador(String value){
		setString("precoVendaConfigurador",value);
	}


	public String getObservacaoConfigurador(){
		return toString("observacaoConfigurador");
	}

	public void setObservacaoConfigurador(String value){
		setString("observacaoConfigurador",value);
	}


	public boolean getAtualizadoCusto(){
		return toBoolean("atualizadoCusto");
	}

	public void setAtualizadoCusto(boolean value){
		setBoolean("atualizadoCusto",value);
	}


	public boolean getAtualizadoPreco(){
		return toBoolean("atualizadoPreco");
	}

	public void setAtualizadoPreco(boolean value){
		setBoolean("atualizadoPreco",value);
	}


	public String getVlICMS(){
		return toString("vlICMS");
	}

	public void setVlICMS(String value){
		setString("vlICMS",value);
	}


	public String getVlICMSST(){
		return toString("vlICMSST");
	}

	public void setVlICMSST(String value){
		setString("vlICMSST",value);
	}


	public String getCodFamiliaComercial(){
		return toString("codFamiliaComercial");
	}

	public void setCodFamiliaComercial(String value){
		setString("codFamiliaComercial",value);
	}


	public String getCodConfigurador(){
		return toString("codConfigurador");
	}

	public void setCodConfigurador(String value){
		setString("codConfigurador",value);
	}


	public com.br.client.model.cd.entity.eImagemProduto[] getImagens(){
		Object obj = _self.get("imagens");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.cd.entity.eImagemProduto[])obj;

	}

	public void setImagens(com.br.client.model.cd.entity.eImagemProduto[] value){
		_self.remove("imagens");
		if ( value != null )
			_self.put("imagens", value);

	}


	public int[] getStatusImagens(){
		return toIntegerArray("statusImagens");
	}

	public void setStatusImagens(int[] value){
		setIntegerArray("statusImagens",value);
	}


	public com.br.client.model.cd.entity.ePrecoItem[] getPrecos(){
		Object obj = _self.get("precos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.cd.entity.ePrecoItem[])obj;

	}

	public void setPrecos(com.br.client.model.cd.entity.ePrecoItem[] value){
		_self.remove("precos");
		if ( value != null )
			_self.put("precos", value);

	}


	public int[] getStatusPrecos(){
		return toIntegerArray("statusPrecos");
	}

	public void setStatusPrecos(int[] value){
		setIntegerArray("statusPrecos",value);
	}


	public com.br.client.model.cd.entity.eFornecedorProduto[] getFornecedores(){
		Object obj = _self.get("fornecedores");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.cd.entity.eFornecedorProduto[])obj;

	}

	public void setFornecedores(com.br.client.model.cd.entity.eFornecedorProduto[] value){
		_self.remove("fornecedores");
		if ( value != null )
			_self.put("fornecedores", value);

	}


	public com.br.client.model.cd.entity.eFornecedorProduto[] getAntFornecedores(){
		Object obj = _self.get("antFornecedores");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.cd.entity.eFornecedorProduto[])obj;

	}

	public void setAntFornecedores(com.br.client.model.cd.entity.eFornecedorProduto[] value){
		_self.remove("antFornecedores");
		if ( value != null )
			_self.put("antFornecedores", value);

	}


	public int[] getStatusFornecedores(){
		return toIntegerArray("statusFornecedores");
	}

	public void setStatusFornecedores(int[] value){
		setIntegerArray("statusFornecedores",value);
	}


	public String getSqlUpdate(){
		return toString("sqlUpdate");
	}

	public void setSqlUpdate(String value){
		setString("sqlUpdate",value);
	}


	public String getCustoFinanceiro(){
		return toString("custoFinanceiro");
	}

	public void setCustoFinanceiro(String value){
		setString("custoFinanceiro",value);
	}


	public String getCustoAdministrativo(){
		return toString("custoAdministrativo");
	}

	public void setCustoAdministrativo(String value){
		setString("custoAdministrativo",value);
	}


	public String getCustoCIF(){
		return toString("custoCIF");
	}

	public void setCustoCIF(String value){
		setString("custoCIF",value);
	}


	public String getValorIPI(){
		return toString("valorIPI");
	}

	public void setValorIPI(String value){
		setString("valorIPI",value);
	}


	public String getValorFrete(){
		return toString("valorFrete");
	}

	public void setValorFrete(String value){
		setString("valorFrete",value);
	}


	public String getValorICMS(){
		return toString("valorICMS");
	}

	public void setValorICMS(String value){
		setString("valorICMS",value);
	}


	public String getCustoImportacao(){
		return toString("custoImportacao");
	}

	public void setCustoImportacao(String value){
		setString("custoImportacao",value);
	}


	public String getCustoLanded(){
		return toString("custoLanded");
	}

	public void setCustoLanded(String value){
		setString("custoLanded",value);
	}


	public String getAliquotaICMS(){
		return toString("aliquotaICMS");
	}

	public void setAliquotaICMS(String value){
		setString("aliquotaICMS",value);
	}


	public String getAliquotaICMSFrete(){
		return toString("aliquotaICMSFrete");
	}

	public void setAliquotaICMSFrete(String value){
		setString("aliquotaICMSFrete",value);
	}


	public String getPercComissao(){
		return toString("percComissao");
	}

	public void setPercComissao(String value){
		setString("percComissao",value);
	}


	public String getAliquotaCPMF(){
		return toString("aliquotaCPMF");
	}

	public void setAliquotaCPMF(String value){
		setString("aliquotaCPMF",value);
	}


	public String getImpostoLP(){
		return toString("impostoLP");
	}

	public void setImpostoLP(String value){
		setString("impostoLP",value);
	}


	public String getAjusteTabPreco(){
		return toString("ajusteTabPreco");
	}

	public void setAjusteTabPreco(String value){
		setString("ajusteTabPreco",value);
	}


	public String getIndMateriaPrima(){
		return toString("indMateriaPrima");
	}

	public void setIndMateriaPrima(String value){
		setString("indMateriaPrima",value);
	}


	public String getCodProdutoSintegra(){
		return toString("codProdutoSintegra");
	}

	public void setCodProdutoSintegra(String value){
		setString("codProdutoSintegra",value);
	}


	public String getCodProdutoECommerce(){
		return toString("codProdutoECommerce");
	}

	public void setCodProdutoECommerce(String value){
		setString("codProdutoECommerce",value);
	}


	public String getCodProdutoRps(){
		return toString("codProdutoRps");
	}

	public void setCodProdutoRps(String value){
		setString("codProdutoRps",value);
	}


	public String getCodServicoFederal(){
		return toString("codServicoFederal");
	}

	public void setCodServicoFederal(String value){
		setString("codServicoFederal",value);
	}


	public String getTpImpressao(){
		return toString("tpImpressao");
	}

	public void setTpImpressao(String value){
		setString("tpImpressao",value);
	}


	public String getDtUltimaContagem(){
		return toString("dtUltimaContagem");
	}

	public void setDtUltimaContagem(String value){
		setString("dtUltimaContagem",value);
	}


	public String getDtUltimaAtualizacao(){
		return toString("dtUltimaAtualizacao");
	}

	public void setDtUltimaAtualizacao(String value){
		setString("dtUltimaAtualizacao",value);
	}


	public String getDtUltimaAtualizacaoVTex(){
		return toString("DtUltimaAtualizacaoVTex");
	}

	public void setDtUltimaAtualizacaoVTex(String value){
		setString("DtUltimaAtualizacaoVTex",value);
	}


	public String getDiasGarantiaProduto(){
		return toString("diasGarantiaProduto");
	}

	public void setDiasGarantiaProduto(String value){
		setString("diasGarantiaProduto",value);
	}


	public String getDiasGarantiaOS(){
		return toString("diasGarantiaOS");
	}

	public void setDiasGarantiaOS(String value){
		setString("diasGarantiaOS",value);
	}


	public String getCodTermoGarantia(){
		return toString("codTermoGarantia");
	}

	public void setCodTermoGarantia(String value){
		setString("codTermoGarantia",value);
	}


	public String getIndPoliticaPreco(){
		return toString("indPoliticaPreco");
	}

	public void setIndPoliticaPreco(String value){
		setString("indPoliticaPreco",value);
	}


	public int[] getStatusArquivos(){
		return toIntegerArray("statusArquivos");
	}

	public void setStatusArquivos(int[] value){
		setIntegerArray("statusArquivos",value);
	}


	public com.br.client.model.cd.entity.eProdutoArquivo[] getArquivos(){
		Object obj = _self.get("arquivos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.cd.entity.eProdutoArquivo[])obj;

	}

	public void setArquivos(com.br.client.model.cd.entity.eProdutoArquivo[] value){
		_self.remove("arquivos");
		if ( value != null )
			_self.put("arquivos", value);

	}


	public com.br.client.model.cd.entity.eProdutoArquivo[] getDescArquivoProduto(){
		Object obj = _self.get("descArquivoProduto");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.cd.entity.eProdutoArquivo[])obj;

	}

	public void setDescArquivoProduto(com.br.client.model.cd.entity.eProdutoArquivo[] value){
		_self.remove("descArquivoProduto");
		if ( value != null )
			_self.put("descArquivoProduto", value);

	}


	public String getIndReservaPedido(){
		return toString("indReservaPedido");
	}

	public void setIndReservaPedido(String value){
		setString("indReservaPedido",value);
	}


	public String getQtdMultipla(){
		return toString("qtdMultipla");
	}

	public void setQtdMultipla(String value){
		setString("qtdMultipla",value);
	}


	public String getDiasValidade(){
		return toString("diasValidade");
	}

	public void setDiasValidade(String value){
		setString("diasValidade",value);
	}


	public String getVolumetria(){
		return toString("volumetria");
	}

	public void setVolumetria(String value){
		setString("volumetria",value);
	}


	public String getTpCodBarra(){
		return toString("tpCodBarra");
	}

	public void setTpCodBarra(String value){
		setString("tpCodBarra",value);
	}


	public String getCodGrupoProduto(){
		return toString("codGrupoProduto");
	}

	public void setCodGrupoProduto(String value){
		setString("codGrupoProduto",value);
	}


	public String getDescGrupoProduto(){
		return toString("descGrupoProduto");
	}

	public void setDescGrupoProduto(String value){
		setString("descGrupoProduto",value);
	}


	public String getPrioridadeGrupoProduto(){
		return toString("prioridadeGrupoProduto");
	}

	public void setPrioridadeGrupoProduto(String value){
		setString("prioridadeGrupoProduto",value);
	}


	public String getSaldoEstoque(){
		return toString("saldoEstoque");
	}

	public void setSaldoEstoque(String value){
		setString("saldoEstoque",value);
	}


	public String getModelo(){
		return toString("modelo");
	}

	public void setModelo(String value){
		setString("modelo",value);
	}


	public String getIndPossuiGrade(){
		return toString("indPossuiGrade");
	}

	public void setIndPossuiGrade(String value){
		setString("indPossuiGrade",value);
	}


	public String getCodCaracteristicaLinha(){
		return toString("codCaracteristicaLinha");
	}

	public void setCodCaracteristicaLinha(String value){
		setString("codCaracteristicaLinha",value);
	}


	public String getCodCaracteristicaColuna(){
		return toString("codCaracteristicaColuna");
	}

	public void setCodCaracteristicaColuna(String value){
		setString("codCaracteristicaColuna",value);
	}


	public String getReferencia(){
		return toString("referencia");
	}

	public void setReferencia(String value){
		setString("referencia",value);
	}


	public String getEstoque(){
		return toString("estoque");
	}

	public void setEstoque(String value){
		setString("estoque",value);
	}


	public com.br.client.model.cd.entity.eGrupoProdutoItem[] getGrupos(){
		Object obj = _self.get("grupos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.cd.entity.eGrupoProdutoItem[])obj;

	}

	public void setGrupos(com.br.client.model.cd.entity.eGrupoProdutoItem[] value){
		_self.remove("grupos");
		if ( value != null )
			_self.put("grupos", value);

	}


	public String getCodRoteiro(){
		return toString("codRoteiro");
	}

	public void setCodRoteiro(String value){
		setString("codRoteiro",value);
	}


	public String getAliquotaICMSST(){
		return toString("aliquotaICMSST");
	}

	public void setAliquotaICMSST(String value){
		setString("aliquotaICMSST",value);
	}


	public String getVlCustoSetup(){
		return toString("vlCustoSetup");
	}

	public void setVlCustoSetup(String value){
		setString("vlCustoSetup",value);
	}


	public String getVlCustoGGF(){
		return toString("vlCustoGGF");
	}

	public void setVlCustoGGF(String value){
		setString("vlCustoGGF",value);
	}


	public String getVlCustoTotalPA(){
		return toString("vlCustoTotalPA");
	}

	public void setVlCustoTotalPA(String value){
		setString("vlCustoTotalPA",value);
	}


	public String getVlCustoMedioPA(){
		return toString("vlCustoMedioPA");
	}

	public void setVlCustoMedioPA(String value){
		setString("vlCustoMedioPA",value);
	}


	public String getVlCustoMPPA(){
		return toString("vlCustoMPPA");
	}

	public void setVlCustoMPPA(String value){
		setString("vlCustoMPPA",value);
	}


	public String getVlCustoMPEmbalagem(){
		return toString("vlCustoMPEmbalagem");
	}

	public void setVlCustoMPEmbalagem(String value){
		setString("vlCustoMPEmbalagem",value);
	}


	public String getVlCustoSetupPA(){
		return toString("vlCustoSetupPA");
	}

	public void setVlCustoSetupPA(String value){
		setString("vlCustoSetupPA",value);
	}


	public String getVlCustoServicoPA(){
		return toString("vlCustoServicoPA");
	}

	public void setVlCustoServicoPA(String value){
		setString("vlCustoServicoPA",value);
	}


	public String getVlCustoGGFPA(){
		return toString("vlCustoGGFPA");
	}

	public void setVlCustoGGFPA(String value){
		setString("vlCustoGGFPA",value);
	}


	public String getDifCustoPA(){
		return toString("difCustoPA");
	}

	public void setDifCustoPA(String value){
		setString("difCustoPA",value);
	}


	public String getTotalHoras(){
		return toString("totalHoras");
	}

	public void setTotalHoras(String value){
		setString("totalHoras",value);
	}


	public String getQtdReportada(){
		return toString("qtdReportada");
	}

	public void setQtdReportada(String value){
		setString("qtdReportada",value);
	}


	public String getVlCustoMO(){
		return toString("vlCustoMO");
	}

	public void setVlCustoMO(String value){
		setString("vlCustoMO",value);
	}


	public String getVlCustoFixo(){
		return toString("vlCustoFixo");
	}

	public void setVlCustoFixo(String value){
		setString("vlCustoFixo",value);
	}


	public String getVlCustoAuxiliar(){
		return toString("vlCustoAuxiliar");
	}

	public void setVlCustoAuxiliar(String value){
		setString("vlCustoAuxiliar",value);
	}


	public String getDifCustoMedioPA(){
		return toString("difCustoMedioPA");
	}

	public void setDifCustoMedioPA(String value){
		setString("difCustoMedioPA",value);
	}


	public String getVlCustoFOBPA(){
		return toString("vlCustoFOBPA");
	}

	public void setVlCustoFOBPA(String value){
		setString("vlCustoFOBPA",value);
	}


	public String getVlCustoCIFPA(){
		return toString("vlCustoCIFPA");
	}

	public void setVlCustoCIFPA(String value){
		setString("vlCustoCIFPA",value);
	}


	public String getDifCustoFOBPA(){
		return toString("difCustoFOBPA");
	}

	public void setDifCustoFOBPA(String value){
		setString("difCustoFOBPA",value);
	}


	public String getDifCustoCIFPA(){
		return toString("difCustoCIFPA");
	}

	public void setDifCustoCIFPA(String value){
		setString("difCustoCIFPA",value);
	}


	public String getTempoDevolucaoLocacao(){
		return toString("tempoDevolucaoLocacao");
	}

	public void setTempoDevolucaoLocacao(String value){
		setString("tempoDevolucaoLocacao",value);
	}


	public String getVlCustoLocacao(){
		return toString("vlCustoLocacao");
	}

	public void setVlCustoLocacao(String value){
		setString("vlCustoLocacao",value);
	}


	public String getTbPreco(){
		return toString("tbPreco");
	}

	public void setTbPreco(String value){
		setString("tbPreco",value);
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


	public String getObs(){
		return toString("obs");
	}

	public void setObs(String value){
		setString("obs",value);
	}


	public String getPossuiKit(){
		return toString("possuiKit");
	}

	public void setPossuiKit(String value){
		setString("possuiKit",value);
	}


	public String getVarMaxDesc(){
		return toString("varMaxDesc");
	}

	public void setVarMaxDesc(String value){
		setString("varMaxDesc",value);
	}


	public String getDecimaisQtd(){
		return toString("decimaisQtd");
	}

	public void setDecimaisQtd(String value){
		setString("decimaisQtd",value);
	}


	public String getDecimaisPrecoUnit(){
		return toString("decimaisPrecoUnit");
	}

	public void setDecimaisPrecoUnit(String value){
		setString("decimaisPrecoUnit",value);
	}


	public String getSitTributaria(){
		return toString("sitTributaria");
	}

	public void setSitTributaria(String value){
		setString("sitTributaria",value);
	}


	public String getCstPis(){
		return toString("cstPis");
	}

	public void setCstPis(String value){
		setString("cstPis",value);
	}


	public String getAliqPis(){
		return toString("aliqPis");
	}

	public void setAliqPis(String value){
		setString("aliqPis",value);
	}


	public String getCstCofins(){
		return toString("cstCofins");
	}

	public void setCstCofins(String value){
		setString("cstCofins",value);
	}


	public String getAliqCofins(){
		return toString("aliqCofins");
	}

	public void setAliqCofins(String value){
		setString("aliqCofins",value);
	}


	public String getCstIpi(){
		return toString("cstIpi");
	}

	public void setCstIpi(String value){
		setString("cstIpi",value);
	}


	public String getTipoAliquota(){
		return toString("tipoAliquota");
	}

	public void setTipoAliquota(String value){
		setString("tipoAliquota",value);
	}


	public String getIndEcommerceEstoque(){
		return toString("indEcommerceEstoque");
	}

	public void setIndEcommerceEstoque(String value){
		setString("indEcommerceEstoque",value);
	}


	public String getCodTemplateEtiqueta(){
		return toString("codTemplateEtiqueta");
	}

	public void setCodTemplateEtiqueta(String value){
		setString("codTemplateEtiqueta",value);
	}


	public String getLote(){
		return toString("lote");
	}

	public void setLote(String value){
		setString("lote",value);
	}


	public String getQuantidade(){
		return toString("quantidade");
	}

	public void setQuantidade(String value){
		setString("quantidade",value);
	}


	public String getEmbalagem(){
		return toString("embalagem");
	}

	public void setEmbalagem(String value){
		setString("embalagem",value);
	}


	public String getQtdLinhas(){
		return toString("qtdLinhas");
	}

	public void setQtdLinhas(String value){
		setString("qtdLinhas",value);
	}


	public String getRemessaWhirlpool(){
		return toString("remessaWhirlpool");
	}

	public void setRemessaWhirlpool(String value){
		setString("remessaWhirlpool",value);
	}


	public String getTransporte(){
		return toString("transporte");
	}

	public void setTransporte(String value){
		setString("transporte",value);
	}


	public String getPlaca(){
		return toString("placa");
	}

	public void setPlaca(String value){
		setString("placa",value);
	}


	public String getDescDepositoPadrao(){
		return toString("descDepositoPadrao");
	}

	public void setDescDepositoPadrao(String value){
		setString("descDepositoPadrao",value);
	}


	public String getSaldoTotal(){
		return toString("saldoTotal");
	}

	public void setSaldoTotal(String value){
		setString("saldoTotal",value);
	}


	public boolean getSelecionado(){
		return toBoolean("selecionado");
	}

	public void setSelecionado(boolean value){
		setBoolean("selecionado",value);
	}


	public String getFci(){
		return toString("fci");
	}

	public void setFci(String value){
		setString("fci",value);
	}


	public String getIndMontagem(){
		return toString("indMontagem");
	}

	public void setIndMontagem(String value){
		setString("indMontagem",value);
	}


	public String getCodStatus(){
		return toString("codStatus");
	}

	public void setCodStatus(String value){
		setString("codStatus",value);
	}


	public com.br.client.model.os.entity.eStatus[] getAllStatus(){
		Object obj = _self.get("allStatus");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.os.entity.eStatus[])obj;

	}

	public void setAllStatus(com.br.client.model.os.entity.eStatus[] value){
		_self.remove("allStatus");
		if ( value != null )
			_self.put("allStatus", value);

	}


	public String getNomeResponsavel(){
		return toString("nomeResponsavel");
	}

	public void setNomeResponsavel(String value){
		setString("nomeResponsavel",value);
	}


	public String getCodCategoria(){
		return toString("codCategoria");
	}

	public void setCodCategoria(String value){
		setString("codCategoria",value);
	}


	public String getDescCategoria(){
		return toString("descCategoria");
	}

	public void setDescCategoria(String value){
		setString("descCategoria",value);
	}


	public String getCodModalidade(){
		return toString("codModalidade");
	}

	public void setCodModalidade(String value){
		setString("codModalidade",value);
	}


	public com.br.client.model.os.entity.eModalidade[] getAllModalidades(){
		Object obj = _self.get("allModalidades");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.os.entity.eModalidade[])obj;

	}

	public void setAllModalidades(com.br.client.model.os.entity.eModalidade[] value){
		_self.remove("allModalidades");
		if ( value != null )
			_self.put("allModalidades", value);

	}


	public String getIndGeraOsFaturamento(){
		return toString("indGeraOsFaturamento");
	}

	public void setIndGeraOsFaturamento(String value){
		setString("indGeraOsFaturamento",value);
	}


	public String getIndProdutoMontado(){
		return toString("indProdutoMontado");
	}

	public void setIndProdutoMontado(String value){
		setString("indProdutoMontado",value);
	}


	public String getCodResponsavel(){
		return toString("codResponsavel");
	}

	public void setCodResponsavel(String value){
		setString("codResponsavel",value);
	}


	public String getIndInativaFilhosGrade(){
		return toString("indInativaFilhosGrade");
	}

	public void setIndInativaFilhosGrade(String value){
		setString("indInativaFilhosGrade",value);
	}


	public boolean getIndIntegraPDVEPOC(){
		return toBoolean("indIntegraPDVEPOC");
	}

	public void setIndIntegraPDVEPOC(boolean value){
		setBoolean("indIntegraPDVEPOC",value);
	}


	public String getNCM(){
		return toString("NCM");
	}

	public void setNCM(String value){
		setString("NCM",value);
	}


	public String getSkuMagento(){
		return toString("skuMagento");
	}

	public void setSkuMagento(String value){
		setString("skuMagento",value);
	}


	public String getSituacaoIntegracaoMagento(){
		return toString("situacaoIntegracaoMagento");
	}

	public void setSituacaoIntegracaoMagento(String value){
		setString("situacaoIntegracaoMagento",value);
	}


	public String getCodProdutoServico(){
		return toString("codProdutoServico");
	}

	public void setCodProdutoServico(String value){
		setString("codProdutoServico",value);
	}


	public String getDescProdutoServico(){
		return toString("descProdutoServico");
	}

	public void setDescProdutoServico(String value){
		setString("descProdutoServico",value);
	}


	public String getVlPromocaoEcommerce(){
		return toString("vlPromocaoEcommerce");
	}

	public void setVlPromocaoEcommerce(String value){
		setString("vlPromocaoEcommerce",value);
	}


	public String getIsPromocaoEcommerce(){
		return toString("isPromocaoEcommerce");
	}

	public void setIsPromocaoEcommerce(String value){
		setString("isPromocaoEcommerce",value);
	}


	public String getQtdEnviada(){
		return toString("qtdEnviada");
	}

	public void setQtdEnviada(String value){
		setString("qtdEnviada",value);
	}


	public String getCodEmpresaDestino(){
		return toString("codEmpresaDestino");
	}

	public void setCodEmpresaDestino(String value){
		setString("codEmpresaDestino",value);
	}


	public String getTpProdutoSped(){
		return toString("tpProdutoSped");
	}

	public void setTpProdutoSped(String value){
		setString("tpProdutoSped",value);
	}


	public String getCodProdutoMagento(){
		return toString("codProdutoMagento");
	}

	public void setCodProdutoMagento(String value){
		setString("codProdutoMagento",value);
	}


	public String getTpProdutoMagento(){
		return toString("tpProdutoMagento");
	}

	public void setTpProdutoMagento(String value){
		setString("tpProdutoMagento",value);
	}


	public int getMostraNaLista(){
		return toInteger("mostraNaLista");
	}

	public void setMostraNaLista(int value){
		setInteger("mostraNaLista",value);
	}


	public String getCodPromocao(){
		return toString("codPromocao");
	}

	public void setCodPromocao(String value){
		setString("codPromocao",value);
	}


	public String getWebServiceMethod(){
		return toString("webServiceMethod");
	}

	public void setWebServiceMethod(String value){
		setString("webServiceMethod",value);
	}


	public String getChecked(){
		return toString("checked");
	}

	public void setChecked(String value){
		setString("checked",value);
	}


	public String getObsItemSubstring(){
		return toString("obsItemSubstring");
	}

	public void setObsItemSubstring(String value){
		setString("obsItemSubstring",value);
	}


	public String getDtReferencia(){
		return toString("dtReferencia");
	}

	public void setDtReferencia(String value){
		setString("dtReferencia",value);
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


	public String getConsideraItemOuEstrutura(){
		return toString("consideraItemOuEstrutura");
	}

	public void setConsideraItemOuEstrutura(String value){
		setString("consideraItemOuEstrutura",value);
	}


	public String getIndSeparacaoAutomatica(){
		return toString("indSeparacaoAutomatica");
	}

	public void setIndSeparacaoAutomatica(String value){
		setString("indSeparacaoAutomatica",value);
	}


	public String getSiglaUf(){
		return toString("siglaUf");
	}

	public void setSiglaUf(String value){
		setString("siglaUf",value);
	}


	public String getPercIvaSt(){
		return toString("percIvaSt");
	}

	public void setPercIvaSt(String value){
		setString("percIvaSt",value);
	}


	public com.br.client.model.cd.entity.eICMSRegraItem[] getItensICMSRegra(){
		Object obj = _self.get("itensICMSRegra");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.cd.entity.eICMSRegraItem[])obj;

	}

	public void setItensICMSRegra(com.br.client.model.cd.entity.eICMSRegraItem[] value){
		_self.remove("itensICMSRegra");
		if ( value != null )
			_self.put("itensICMSRegra", value);

	}


	public int getIdRecord(){
		return toInteger("idRecord");
	}

	public void setIdRecord(int value){
		setInteger("idRecord",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "etqs".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eItemPedidoEtq[] obj = new com.br.client.model.vd.entity.eItemPedidoEtq[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eItemPedidoEtq)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "notaEtqs".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNotaFiscalItemEtq[] obj = new com.br.client.model.vd.entity.eNotaFiscalItemEtq[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eNotaFiscalItemEtq)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "empresas".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eProdutoEmpresa[] obj = new com.br.client.model.cd.entity.eProdutoEmpresa[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.cd.entity.eProdutoEmpresa)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "imagens".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eImagemProduto[] obj = new com.br.client.model.cd.entity.eImagemProduto[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.cd.entity.eImagemProduto)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "statusImagens".equalsIgnoreCase(name) ){
			int[] obj = new int[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isNumber()!= null )
					obj[i] = new Double(object.isNumber().doubleValue()).intValue();
				 
			}
		}
		if ( "precos".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.ePrecoItem[] obj = new com.br.client.model.cd.entity.ePrecoItem[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.cd.entity.ePrecoItem)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "statusPrecos".equalsIgnoreCase(name) ){
			int[] obj = new int[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isNumber()!= null )
					obj[i] = new Double(object.isNumber().doubleValue()).intValue();
				 
			}
		}
		if ( "fornecedores".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eFornecedorProduto[] obj = new com.br.client.model.cd.entity.eFornecedorProduto[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.cd.entity.eFornecedorProduto)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "antFornecedores".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eFornecedorProduto[] obj = new com.br.client.model.cd.entity.eFornecedorProduto[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.cd.entity.eFornecedorProduto)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "statusFornecedores".equalsIgnoreCase(name) ){
			int[] obj = new int[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isNumber()!= null )
					obj[i] = new Double(object.isNumber().doubleValue()).intValue();
				 
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
		if ( "arquivos".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eProdutoArquivo[] obj = new com.br.client.model.cd.entity.eProdutoArquivo[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.cd.entity.eProdutoArquivo)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "descArquivoProduto".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eProdutoArquivo[] obj = new com.br.client.model.cd.entity.eProdutoArquivo[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.cd.entity.eProdutoArquivo)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "grupos".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eGrupoProdutoItem[] obj = new com.br.client.model.cd.entity.eGrupoProdutoItem[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.cd.entity.eGrupoProdutoItem)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "allStatus".equalsIgnoreCase(name) ){
			com.br.client.model.os.entity.eStatus[] obj = new com.br.client.model.os.entity.eStatus[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.os.entity.eStatus)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "allModalidades".equalsIgnoreCase(name) ){
			com.br.client.model.os.entity.eModalidade[] obj = new com.br.client.model.os.entity.eModalidade[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.os.entity.eModalidade)loadCustom(name, object.isObject());
				 
			}
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
		if ( "itensICMSRegra".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eICMSRegraItem[] obj = new com.br.client.model.cd.entity.eICMSRegraItem[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.cd.entity.eICMSRegraItem)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "etqs".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eItemPedidoEtq obj = com.br.client.model.vd.entity.eItemPedidoEtq.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "notaEtqs".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNotaFiscalItemEtq obj = com.br.client.model.vd.entity.eNotaFiscalItemEtq.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "empresas".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eProdutoEmpresa obj = com.br.client.model.cd.entity.eProdutoEmpresa.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "imagens".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eImagemProduto obj = com.br.client.model.cd.entity.eImagemProduto.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "precos".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.ePrecoItem obj = com.br.client.model.cd.entity.ePrecoItem.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "fornecedores".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eFornecedorProduto obj = com.br.client.model.cd.entity.eFornecedorProduto.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "antFornecedores".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eFornecedorProduto obj = com.br.client.model.cd.entity.eFornecedorProduto.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "arquivos".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eProdutoArquivo obj = com.br.client.model.cd.entity.eProdutoArquivo.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "descArquivoProduto".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eProdutoArquivo obj = com.br.client.model.cd.entity.eProdutoArquivo.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "grupos".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eGrupoProdutoItem obj = com.br.client.model.cd.entity.eGrupoProdutoItem.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "allStatus".equalsIgnoreCase(name) ){
			com.br.client.model.os.entity.eStatus obj = com.br.client.model.os.entity.eStatus.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "allModalidades".equalsIgnoreCase(name) ){
			com.br.client.model.os.entity.eModalidade obj = com.br.client.model.os.entity.eModalidade.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "saldos".equalsIgnoreCase(name) ){
			com.br.client.model.eq.entity.eSaldoDeposito obj = com.br.client.model.eq.entity.eSaldoDeposito.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "itensICMSRegra".equalsIgnoreCase(name) ){
			com.br.client.model.cd.entity.eICMSRegraItem obj = com.br.client.model.cd.entity.eICMSRegraItem.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.vd.entity.eNotaFiscalItem newInstance(){
		return new com.br.client.model.vd.entity.eNotaFiscalItem();
	}
}