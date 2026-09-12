package com.br.client.model.vd.entity;

public class eItemPedido extends com.howmake.client.form.model.HowMGWTFormBean{
	public eItemPedido(){
	}


	public String getCodProdutoCliente(){
		return toString("codProdutoCliente");
	}

	public void setCodProdutoCliente(String value){
		setString("codProdutoCliente",value);
	}


	public String getQtdUnitaria(){
		return toString("qtdUnitaria");
	}

	public void setQtdUnitaria(String value){
		setString("qtdUnitaria",value);
	}


	public String getQtd(){
		return toString("qtd");
	}

	public void setQtd(String value){
		setString("qtd",value);
	}


	public String getQtdy(){
		return toString("qtdy");
	}

	public void setQtdy(String value){
		setString("qtdy",value);
	}


	public String getQtdAtendida(){
		return toString("qtdAtendida");
	}

	public void setQtdAtendida(String value){
		setString("qtdAtendida",value);
	}


	public String getPercDesconto(){
		return toString("percDesconto");
	}

	public void setPercDesconto(String value){
		setString("percDesconto",value);
	}


	public String getObsItem(){
		return toString("obsItem");
	}

	public void setObsItem(String value){
		setString("obsItem",value);
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


	public String getNrSequenciaPai(){
		return toString("nrSequenciaPai");
	}

	public void setNrSequenciaPai(String value){
		setString("nrSequenciaPai",value);
	}


	public String getValorDesconto(){
		return toString("valorDesconto");
	}

	public void setValorDesconto(String value){
		setString("valorDesconto",value);
	}


	public String getMotivoDesconto(){
		return toString("motivoDesconto");
	}

	public void setMotivoDesconto(String value){
		setString("motivoDesconto",value);
	}


	public String getMotivoPrecoVenda(){
		return toString("motivoPrecoVenda");
	}

	public void setMotivoPrecoVenda(String value){
		setString("motivoPrecoVenda",value);
	}


	public String getVlCotacao(){
		return toString("vlCotacao");
	}

	public void setVlCotacao(String value){
		setString("vlCotacao",value);
	}


	public String getVlCotacaoCusto(){
		return toString("vlCotacaoCusto");
	}

	public void setVlCotacaoCusto(String value){
		setString("vlCotacaoCusto",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getCodReducao(){
		return toString("codReducao");
	}

	public void setCodReducao(String value){
		setString("codReducao",value);
	}


	public String getDescComercial(){
		return toString("descComercial");
	}

	public void setDescComercial(String value){
		setString("descComercial",value);
	}


	public String getCodEan(){
		return toString("codEan");
	}

	public void setCodEan(String value){
		setString("codEan",value);
	}


	public String getPrecoSugerido(){
		return toString("precoSugerido");
	}

	public void setPrecoSugerido(String value){
		setString("precoSugerido",value);
	}


	public String getVlPrecoSugerido(){
		return toString("vlPrecoSugerido");
	}

	public void setVlPrecoSugerido(String value){
		setString("vlPrecoSugerido",value);
	}


	public String getCodAgrupamento(){
		return toString("codAgrupamento");
	}

	public void setCodAgrupamento(String value){
		setString("codAgrupamento",value);
	}


	public String getNop(){
		return toString("nop");
	}

	public void setNop(String value){
		setString("nop",value);
	}


	public String getImgItem(){
		return toString("imgItem");
	}

	public void setImgItem(String value){
		setString("imgItem",value);
	}


	public String getSiglaClassFiscal(){
		return toString("siglaClassFiscal");
	}

	public void setSiglaClassFiscal(String value){
		setString("siglaClassFiscal",value);
	}


	public int getIndexItem(){
		return toInteger("indexItem");
	}

	public void setIndexItem(int value){
		setInteger("indexItem",value);
	}


	public int getIndexTermo(){
		return toInteger("indexTermo");
	}

	public void setIndexTermo(int value){
		setInteger("indexTermo",value);
	}


	public String getDescAbrevTermo(){
		return toString("descAbrevTermo");
	}

	public void setDescAbrevTermo(String value){
		setString("descAbrevTermo",value);
	}


	public String getRazaoSocialFornecedor(){
		return toString("razaoSocialFornecedor");
	}

	public void setRazaoSocialFornecedor(String value){
		setString("razaoSocialFornecedor",value);
	}


	public String getOrdem(){
		return toString("ordem");
	}

	public void setOrdem(String value){
		setString("ordem",value);
	}


	public int[] getStatusArquivos(){
		return toIntegerArray("statusArquivos");
	}

	public void setStatusArquivos(int[] value){
		setIntegerArray("statusArquivos",value);
	}


	public com.br.client.model.vd.entity.eItemPedidoArquivo[] getArquivosItem(){
		Object obj = _self.get("arquivosItem");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eItemPedidoArquivo[])obj;

	}

	public void setArquivosItem(com.br.client.model.vd.entity.eItemPedidoArquivo[] value){
		_self.remove("arquivosItem");
		if ( value != null );
			_self.put("arquivosItem", value);

	}


	public String getSaldo(){
		return toString("saldo");
	}

	public void setSaldo(String value){
		setString("saldo",value);
	}


	public String getPrazoEntregaProjetado(){
		return toString("prazoEntregaProjetado");
	}

	public void setPrazoEntregaProjetado(String value){
		setString("prazoEntregaProjetado",value);
	}


	public String getQtdEstoque(){
		return toString("qtdEstoque");
	}

	public void setQtdEstoque(String value){
		setString("qtdEstoque",value);
	}


	public String getQtdCalculada(){
		return toString("qtdCalculada");
	}

	public void setQtdCalculada(String value){
		setString("qtdCalculada",value);
	}


	public String getDtComprometida(){
		return toString("dtComprometida");
	}

	public void setDtComprometida(String value){
		setString("dtComprometida",value);
	}


	public String getQtdPlanejada(){
		return toString("qtdPlanejada");
	}

	public void setQtdPlanejada(String value){
		setString("qtdPlanejada",value);
	}


	public String getQtdDisponivel(){
		return toString("qtdDisponivel");
	}

	public void setQtdDisponivel(String value){
		setString("qtdDisponivel",value);
	}


	public String getQtdMultipla(){
		return toString("qtdMultipla");
	}

	public void setQtdMultipla(String value){
		setString("qtdMultipla",value);
	}


	public int getCasasDecimais(){
		return toInteger("casasDecimais");
	}

	public void setCasasDecimais(int value){
		setInteger("casasDecimais",value);
	}


	public String getVlTotalCustoTotal(){
		return toString("vlTotalCustoTotal");
	}

	public void setVlTotalCustoTotal(String value){
		setString("vlTotalCustoTotal",value);
	}


	public String getDescTecnica(){
		return toString("descTecnica");
	}

	public void setDescTecnica(String value){
		setString("descTecnica",value);
	}


	public String getVlFrete(){
		return toString("vlFrete");
	}

	public void setVlFrete(String value){
		setString("vlFrete",value);
	}


	public boolean getPermiteAlterarPreco(){
		return toBoolean("permiteAlterarPreco");
	}

	public void setPermiteAlterarPreco(boolean value){
		setBoolean("permiteAlterarPreco",value);
	}


	public String getObservacaoTecnica(){
		return toString("observacaoTecnica");
	}

	public void setObservacaoTecnica(String value){
		setString("observacaoTecnica",value);
	}


	public String getImprimeNF(){
		return toString("imprimeNF");
	}

	public void setImprimeNF(String value){
		setString("imprimeNF",value);
	}


	public String getDescNotaFiscal(){
		return toString("descNotaFiscal");
	}

	public void setDescNotaFiscal(String value){
		setString("descNotaFiscal",value);
	}


	public String getDescNotaFiscalAbaFiscal(){
		return toString("descNotaFiscalAbaFiscal");
	}

	public void setDescNotaFiscalAbaFiscal(String value){
		setString("descNotaFiscalAbaFiscal",value);
	}


	public String getDtReservaEstoque(){
		return toString("dtReservaEstoque");
	}

	public void setDtReservaEstoque(String value){
		setString("dtReservaEstoque",value);
	}


	public String getHoraReserva(){
		return toString("horaReserva");
	}

	public void setHoraReserva(String value){
		setString("horaReserva",value);
	}


	public String getPrecoVendaST(){
		return toString("precoVendaST");
	}

	public void setPrecoVendaST(String value){
		setString("precoVendaST",value);
	}


	public String getDtImpressaoEtiqueta(){
		return toString("dtImpressaoEtiqueta");
	}

	public void setDtImpressaoEtiqueta(String value){
		setString("dtImpressaoEtiqueta",value);
	}


	public String getQtdeEtiquetas(){
		return toString("qtdeEtiquetas");
	}

	public void setQtdeEtiquetas(String value){
		setString("qtdeEtiquetas",value);
	}


	public String getIndAleracaoDesNota(){
		return toString("indAleracaoDesNota");
	}

	public void setIndAleracaoDesNota(String value){
		setString("indAleracaoDesNota",value);
	}


	public boolean getEmissao(){
		return toBoolean("emissao");
	}

	public void setEmissao(boolean value){
		setBoolean("emissao",value);
	}


	public String getPrecoVenda(){
		return toString("precoVenda");
	}

	public void setPrecoVenda(String value){
		setString("precoVenda",value);
	}


	public String getPrecoVendaSemDesconto(){
		return toString("precoVendaSemDesconto");
	}

	public void setPrecoVendaSemDesconto(String value){
		setString("precoVendaSemDesconto",value);
	}


	public String getPrecoVendaOriginal(){
		return toString("precoVendaOriginal");
	}

	public void setPrecoVendaOriginal(String value){
		setString("precoVendaOriginal",value);
	}


	public String getPrecoUnitBase(){
		return toString("precoUnitBase");
	}

	public void setPrecoUnitBase(String value){
		setString("precoUnitBase",value);
	}


	public String getPrecoTotal(){
		return toString("precoTotal");
	}

	public void setPrecoTotal(String value){
		setString("precoTotal",value);
	}


	public String getPrecoTotalSemDesconto(){
		return toString("precoTotalSemDesconto");
	}

	public void setPrecoTotalSemDesconto(String value){
		setString("precoTotalSemDesconto",value);
	}


	public String getPrecoTotalComIPI(){
		return toString("precoTotalComIPI");
	}

	public void setPrecoTotalComIPI(String value){
		setString("precoTotalComIPI",value);
	}


	public int getSituacaoEstoque(){
		return toInteger("situacaoEstoque");
	}

	public void setSituacaoEstoque(int value){
		setInteger("situacaoEstoque",value);
	}


	public String getQtdAFaturar(){
		return toString("qtdAFaturar");
	}

	public void setQtdAFaturar(String value){
		setString("qtdAFaturar",value);
	}


	public boolean getBooFaturar(){
		return toBoolean("booFaturar");
	}

	public void setBooFaturar(boolean value){
		setBoolean("booFaturar",value);
	}


	public String getValorICMS(){
		return toString("valorICMS");
	}

	public void setValorICMS(String value){
		setString("valorICMS",value);
	}


	public String getValorISS(){
		return toString("valorISS");
	}

	public void setValorISS(String value){
		setString("valorISS",value);
	}


	public String getValorIPI(){
		return toString("valorIPI");
	}

	public void setValorIPI(String value){
		setString("valorIPI",value);
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
		if ( value != null );
			_self.put("etqs", value);

	}


	public int[] getStatusEtqs(){
		return toIntegerArray("statusEtqs");
	}

	public void setStatusEtqs(int[] value){
		setIntegerArray("statusEtqs",value);
	}


	public String getMargem(){
		return toString("margem");
	}

	public void setMargem(String value){
		setString("margem",value);
	}


	public double getVlMargem(){
		return toDouble("vlMargem");
	}

	public void setVlMargem(double value){
		setDouble("vlMargem",value);
	}


	public String getIndEspecial(){
		return toString("indEspecial");
	}

	public void setIndEspecial(String value){
		setString("indEspecial",value);
	}


	public String getTbPrecoItem(){
		return toString("tbPrecoItem");
	}

	public void setTbPrecoItem(String value){
		setString("tbPrecoItem",value);
	}


	public String getIndAvisaEstoque(){
		return toString("indAvisaEstoque");
	}

	public void setIndAvisaEstoque(String value){
		setString("indAvisaEstoque",value);
	}


	public String getCodOpcaoColuna(){
		return toString("codOpcaoColuna");
	}

	public void setCodOpcaoColuna(String value){
		setString("codOpcaoColuna",value);
	}


	public String getCodOpcaoLinha(){
		return toString("codOpcaoLinha");
	}

	public void setCodOpcaoLinha(String value){
		setString("codOpcaoLinha",value);
	}


	public String getLucroUnit(){
		return toString("lucroUnit");
	}

	public void setLucroUnit(String value){
		setString("lucroUnit",value);
	}


	public String getLucroTotal(){
		return toString("lucroTotal");
	}

	public void setLucroTotal(String value){
		setString("lucroTotal",value);
	}


	public String getLucro(){
		return toString("lucro");
	}

	public void setLucro(String value){
		setString("lucro",value);
	}


	public String getCodOp(){
		return toString("codOp");
	}

	public void setCodOp(String value){
		setString("codOp",value);
	}


	public String getTipoItem(){
		return toString("tipoItem");
	}

	public void setTipoItem(String value){
		setString("tipoItem",value);
	}


	public String getVlBaseIPI(){
		return toString("vlBaseIPI");
	}

	public void setVlBaseIPI(String value){
		setString("vlBaseIPI",value);
	}


	public String getPercReducao(){
		return toString("percReducao");
	}

	public void setPercReducao(String value){
		setString("percReducao",value);
	}


	public String getAliquotaICMS(){
		return toString("aliquotaICMS");
	}

	public void setAliquotaICMS(String value){
		setString("aliquotaICMS",value);
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


	public String getAliquotaICMSST(){
		return toString("aliquotaICMSST");
	}

	public void setAliquotaICMSST(String value){
		setString("aliquotaICMSST",value);
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


	public boolean getDisponivel(){
		return toBoolean("disponivel");
	}

	public void setDisponivel(boolean value){
		setBoolean("disponivel",value);
	}


	public String getQtdVolumes(){
		return toString("qtdVolumes");
	}

	public void setQtdVolumes(String value){
		setString("qtdVolumes",value);
	}


	public String getIndPromocaoAux(){
		return toString("indPromocaoAux");
	}

	public void setIndPromocaoAux(String value){
		setString("indPromocaoAux",value);
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


	public String getCodFornecedor(){
		return toString("codFornecedor");
	}

	public void setCodFornecedor(String value){
		setString("codFornecedor",value);
	}


	public String getClassFiscal(){
		return toString("classFiscal");
	}

	public void setClassFiscal(String value){
		setString("classFiscal",value);
	}


	public String getClassificacao(){
		return toString("classificacao");
	}

	public void setClassificacao(String value){
		setString("classificacao",value);
	}


	public String getCodDeposito(){
		return toString("codDeposito");
	}

	public void setCodDeposito(String value){
		setString("codDeposito",value);
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
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


	public String getIndEstoque(){
		return toString("indEstoque");
	}

	public void setIndEstoque(String value){
		setString("indEstoque",value);
	}


	public String getIndFantasma(){
		return toString("indFantasma");
	}

	public void setIndFantasma(String value){
		setString("indFantasma",value);
	}


	public String getIndQtdFracionada(){
		return toString("indQtdFracionada");
	}

	public void setIndQtdFracionada(String value){
		setString("indQtdFracionada",value);
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


	public String getIndEstrutMercado(){
		return toString("indEstrutMercado");
	}

	public void setIndEstrutMercado(String value){
		setString("indEstrutMercado",value);
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


	public String getCodEAN(){
		return toString("codEAN");
	}

	public void setCodEAN(String value){
		setString("codEAN",value);
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
		if ( value != null );
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
		if ( value != null );
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
		if ( value != null );
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
		if ( value != null );
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
		if ( value != null );
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


	public String getValorII(){
		return toString("valorII");
	}

	public void setValorII(String value){
		setString("valorII",value);
	}


	public String getValorPIS(){
		return toString("valorPIS");
	}

	public void setValorPIS(String value){
		setString("valorPIS",value);
	}


	public String getValorFrete(){
		return toString("valorFrete");
	}

	public void setValorFrete(String value){
		setString("valorFrete",value);
	}


	public String getValorCOFINS(){
		return toString("valorCOFINS");
	}

	public void setValorCOFINS(String value){
		setString("valorCOFINS",value);
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


	public String getCustoTotal(){
		return toString("custoTotal");
	}

	public void setCustoTotal(String value){
		setString("custoTotal",value);
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


	public com.br.client.model.cd.entity.eProdutoArquivo[] getArquivos(){
		Object obj = _self.get("arquivos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.cd.entity.eProdutoArquivo[])obj;

	}

	public void setArquivos(com.br.client.model.cd.entity.eProdutoArquivo[] value){
		_self.remove("arquivos");
		if ( value != null );
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
		if ( value != null );
			_self.put("descArquivoProduto", value);

	}


	public String getIndReservaPedido(){
		return toString("indReservaPedido");
	}

	public void setIndReservaPedido(String value){
		setString("indReservaPedido",value);
	}


	public String getDiasValidade(){
		return toString("diasValidade");
	}

	public void setDiasValidade(String value){
		setString("diasValidade",value);
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
		if ( value != null );
			_self.put("grupos", value);

	}


	public String getCodRoteiro(){
		return toString("codRoteiro");
	}

	public void setCodRoteiro(String value){
		setString("codRoteiro",value);
	}


	public String getVlCustoSetup(){
		return toString("vlCustoSetup");
	}

	public void setVlCustoSetup(String value){
		setString("vlCustoSetup",value);
	}


	public String getVlCustoMO(){
		return toString("vlCustoMO");
	}

	public void setVlCustoMO(String value){
		setString("vlCustoMO",value);
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


	public String getVlCustoMPPA(){
		return toString("vlCustoMPPA");
	}

	public void setVlCustoMPPA(String value){
		setString("vlCustoMPPA",value);
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


	public String getTipoAliquota(){
		return toString("tipoAliquota");
	}

	public void setTipoAliquota(String value){
		setString("tipoAliquota",value);
	}


	public String getCodTemplateEtiqueta(){
		return toString("codTemplateEtiqueta");
	}

	public void setCodTemplateEtiqueta(String value){
		setString("codTemplateEtiqueta",value);
	}


	public int getIdRecord(){
		return toInteger("idRecord");
	}

	public void setIdRecord(int value){
		setInteger("idRecord",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "statusArquivos".equalsIgnoreCase(name) ){
			int[] obj = new int[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isNumber()!= null )
					obj[i] = new Double(object.isNumber().doubleValue()).intValue();
				 
			}
		}
		if ( "arquivosItem".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eItemPedidoArquivo[] obj = new com.br.client.model.vd.entity.eItemPedidoArquivo[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eItemPedidoArquivo)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "etqs".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eItemPedidoEtq[] obj = new com.br.client.model.vd.entity.eItemPedidoEtq[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eItemPedidoEtq)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "statusEtqs".equalsIgnoreCase(name) ){
			int[] obj = new int[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isNumber()!= null )
					obj[i] = new Double(object.isNumber().doubleValue()).intValue();
				 
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
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "arquivosItem".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eItemPedidoArquivo obj = com.br.client.model.vd.entity.eItemPedidoArquivo.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "etqs".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eItemPedidoEtq obj = com.br.client.model.vd.entity.eItemPedidoEtq.newInstance();
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
		return null;
	}


	public static final com.br.client.model.vd.entity.eItemPedido newInstance(){
		return new com.br.client.model.vd.entity.eItemPedido();
	}
}