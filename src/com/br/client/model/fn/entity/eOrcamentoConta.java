package com.br.client.model.fn.entity;

public class eOrcamentoConta extends com.howmake.client.form.model.HowMGWTFormBean{
	public eOrcamentoConta(){
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getCodOrcamento(){
		return toString("codOrcamento");
	}

	public void setCodOrcamento(String value){
		setString("codOrcamento",value);
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


	public String getContaSubContaPai(){
		return toString("contaSubContaPai");
	}

	public void setContaSubContaPai(String value){
		setString("contaSubContaPai",value);
	}


	public String getDescConta(){
		return toString("descConta");
	}

	public void setDescConta(String value){
		setString("descConta",value);
	}


	public String getCcusto(){
		return toString("ccusto");
	}

	public void setCcusto(String value){
		setString("ccusto",value);
	}


	public String getTpLancamento(){
		return toString("tpLancamento");
	}

	public void setTpLancamento(String value){
		setString("tpLancamento",value);
	}


	public String getVlPrevisto1(){
		return toString("vlPrevisto1");
	}

	public void setVlPrevisto1(String value){
		setString("vlPrevisto1",value);
	}


	public String getVlPrevisto2(){
		return toString("vlPrevisto2");
	}

	public void setVlPrevisto2(String value){
		setString("vlPrevisto2",value);
	}


	public String getVlPrevisto3(){
		return toString("vlPrevisto3");
	}

	public void setVlPrevisto3(String value){
		setString("vlPrevisto3",value);
	}


	public String getCodFormaPagto(){
		return toString("codFormaPagto");
	}

	public void setCodFormaPagto(String value){
		setString("codFormaPagto",value);
	}


	public String getCodCondPagto(){
		return toString("codCondPagto");
	}

	public void setCodCondPagto(String value){
		setString("codCondPagto",value);
	}


	public String getContaSubConta(){
		return toString("contaSubConta");
	}

	public void setContaSubConta(String value){
		setString("contaSubConta",value);
	}


	public String getCodLinha(){
		return toString("codLinha");
	}

	public void setCodLinha(String value){
		setString("codLinha",value);
	}


	public String getDescAbrev(){
		return toString("descAbrev");
	}

	public void setDescAbrev(String value){
		setString("descAbrev",value);
	}


	public java.lang.String[] getListaContasOrcamento(){
		Object obj = _self.get("listaContasOrcamento");
		if ( obj == null )
			return null;
		else
			return (java.lang.String[])obj;

	}

	public void setListaContasOrcamento(java.lang.String[] value){
		_self.remove("listaContasOrcamento");
		if ( value != null )
			_self.put("listaContasOrcamento", value);

	}


	public String getContasComValor(){
		return toString("contasComValor");
	}

	public void setContasComValor(String value){
		setString("contasComValor",value);
	}


	public String getSomaAditivos(){
		return toString("somaAditivos");
	}

	public void setSomaAditivos(String value){
		setString("somaAditivos",value);
	}


	public String getVlPrevisao(){
		return toString("vlPrevisao");
	}

	public void setVlPrevisao(String value){
		setString("vlPrevisao",value);
	}


	public String getVlOrcamentoTotal(){
		return toString("vlOrcamentoTotal");
	}

	public void setVlOrcamentoTotal(String value){
		setString("vlOrcamentoTotal",value);
	}


	public String getVlFaturadoEmAberto(){
		return toString("vlFaturadoEmAberto");
	}

	public void setVlFaturadoEmAberto(String value){
		setString("vlFaturadoEmAberto",value);
	}


	public String getVlReceitasRealizadas(){
		return toString("vlReceitasRealizadas");
	}

	public void setVlReceitasRealizadas(String value){
		setString("vlReceitasRealizadas",value);
	}


	public String getVlSubTotal(){
		return toString("vlSubTotal");
	}

	public void setVlSubTotal(String value){
		setString("vlSubTotal",value);
	}


	public String getVlRetencao(){
		return toString("vlRetencao");
	}

	public void setVlRetencao(String value){
		setString("vlRetencao",value);
	}


	public String getVlSaldoFaturar(){
		return toString("vlSaldoFaturar");
	}

	public void setVlSaldoFaturar(String value){
		setString("vlSaldoFaturar",value);
	}


	public String getVlAditivos(){
		return toString("vlAditivos");
	}

	public void setVlAditivos(String value){
		setString("vlAditivos",value);
	}


	public String getVlTotalProjetado(){
		return toString("vlTotalProjetado");
	}

	public void setVlTotalProjetado(String value){
		setString("vlTotalProjetado",value);
	}


	public String getPercentual(){
		return toString("percentual");
	}

	public void setPercentual(String value){
		setString("percentual",value);
	}


	public String getVlSaldoCompras(){
		return toString("vlSaldoCompras");
	}

	public void setVlSaldoCompras(String value){
		setString("vlSaldoCompras",value);
	}


	public String getVlCompromissado(){
		return toString("vlCompromissado");
	}

	public void setVlCompromissado(String value){
		setString("vlCompromissado",value);
	}


	public String getVlSaldoConta(){
		return toString("vlSaldoConta");
	}

	public void setVlSaldoConta(String value){
		setString("vlSaldoConta",value);
	}


	public String getContaTotalizadora(){
		return toString("contaTotalizadora");
	}

	public void setContaTotalizadora(String value){
		setString("contaTotalizadora",value);
	}


	public String getSubContaTotalizadora(){
		return toString("subContaTotalizadora");
	}

	public void setSubContaTotalizadora(String value){
		setString("subContaTotalizadora",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "listaContasOrcamento".equalsIgnoreCase(name) ){
			java.lang.String[] obj = new java.lang.String[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isString()!= null )
					obj[i] = object.isString().stringValue();
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.fn.entity.eOrcamentoConta newInstance(){
		return new com.br.client.model.fn.entity.eOrcamentoConta();
	}
}