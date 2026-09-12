package com.br.client.model.cd.entity;

public class eProdutoEmpresa extends com.howmake.client.form.model.HowMGWTFormBean{
	public eProdutoEmpresa(){
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


	public String getQtdMinEtq(){
		return toString("qtdMinEtq");
	}

	public void setQtdMinEtq(String value){
		setString("qtdMinEtq",value);
	}


	public String getCodDeposito(){
		return toString("codDeposito");
	}

	public void setCodDeposito(String value){
		setString("codDeposito",value);
	}


	public String getLocalizacao(){
		return toString("localizacao");
	}

	public void setLocalizacao(String value){
		setString("localizacao",value);
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


	public String getVlCustoMedio(){
		return toString("vlCustoMedio");
	}

	public void setVlCustoMedio(String value){
		setString("vlCustoMedio",value);
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


	public String getClassificacao(){
		return toString("classificacao");
	}

	public void setClassificacao(String value){
		setString("classificacao",value);
	}


	public String getVlCustoCIF(){
		return toString("vlCustoCIF");
	}

	public void setVlCustoCIF(String value){
		setString("vlCustoCIF",value);
	}


	public String getVlCustoFOB(){
		return toString("vlCustoFOB");
	}

	public void setVlCustoFOB(String value){
		setString("vlCustoFOB",value);
	}


	public String getClassFiscal(){
		return toString("classFiscal");
	}

	public void setClassFiscal(String value){
		setString("classFiscal",value);
	}


	public String getSituacao(){
		return toString("situacao");
	}

	public void setSituacao(String value){
		setString("situacao",value);
	}


	public String getTpProdutoSped(){
		return toString("tpProdutoSped");
	}

	public void setTpProdutoSped(String value){
		setString("tpProdutoSped",value);
	}


	public String getCodFornecedor(){
		return toString("codFornecedor");
	}

	public void setCodFornecedor(String value){
		setString("codFornecedor",value);
	}


	public String getMoedaCompra(){
		return toString("moedaCompra");
	}

	public void setMoedaCompra(String value){
		setString("moedaCompra",value);
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


	public String getNomeFantasia(){
		return toString("nomeFantasia");
	}

	public void setNomeFantasia(String value){
		setString("nomeFantasia",value);
	}


	public String getIndSelecionado(){
		return toString("indSelecionado");
	}

	public void setIndSelecionado(String value){
		setString("indSelecionado",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.cd.entity.eProdutoEmpresa newInstance(){
		return new com.br.client.model.cd.entity.eProdutoEmpresa();
	}
}