package com.br.client.model.vd.entity;

public class eNotaFiscalItemEtq extends com.howmake.client.form.model.HowMGWTFormBean{
	public eNotaFiscalItemEtq(){
	}


	public String getCodProduto(){
		return toString("codProduto");
	}

	public void setCodProduto(String value){
		setString("codProduto",value);
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getCodNotaFiscal(){
		return toString("codNotaFiscal");
	}

	public void setCodNotaFiscal(String value){
		setString("codNotaFiscal",value);
	}


	public String getNrSequencia(){
		return toString("nrSequencia");
	}

	public void setNrSequencia(String value){
		setString("nrSequencia",value);
	}


	public String getNrSequenciaNf(){
		return toString("nrSequenciaNf");
	}

	public void setNrSequenciaNf(String value){
		setString("nrSequenciaNf",value);
	}


	public String getNrSequenciaEtq(){
		return toString("nrSequenciaEtq");
	}

	public void setNrSequenciaEtq(String value){
		setString("nrSequenciaEtq",value);
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


	public String getLocalizacao(){
		return toString("localizacao");
	}

	public void setLocalizacao(String value){
		setString("localizacao",value);
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


	public String getQtd(){
		return toString("qtd");
	}

	public void setQtd(String value){
		setString("qtd",value);
	}


	public String getQtdDevolvida(){
		return toString("qtdDevolvida");
	}

	public void setQtdDevolvida(String value){
		setString("qtdDevolvida",value);
	}


	public String getNrSerie(){
		return toString("nrSerie");
	}

	public void setNrSerie(String value){
		setString("nrSerie",value);
	}


	public String getDescProduto(){
		return toString("descProduto");
	}

	public void setDescProduto(String value){
		setString("descProduto",value);
	}


	public String getIndEstoque(){
		return toString("indEstoque");
	}

	public void setIndEstoque(String value){
		setString("indEstoque",value);
	}


	public String getVlCustoTotal(){
		return toString("vlCustoTotal");
	}

	public void setVlCustoTotal(String value){
		setString("vlCustoTotal",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
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


	public String getNrNotaFiscal(){
		return toString("nrNotaFiscal");
	}

	public void setNrNotaFiscal(String value){
		setString("nrNotaFiscal",value);
	}


	public String getPrecoVenda(){
		return toString("precoVenda");
	}

	public void setPrecoVenda(String value){
		setString("precoVenda",value);
	}


	public String getCodPedido(){
		return toString("codPedido");
	}

	public void setCodPedido(String value){
		setString("codPedido",value);
	}


	public String getChecado(){
		return toString("checado");
	}

	public void setChecado(String value){
		setString("checado",value);
	}


	public String getChecadoGeraEmbalagem(){
		return toString("checadoGeraEmbalagem");
	}

	public void setChecadoGeraEmbalagem(String value){
		setString("checadoGeraEmbalagem",value);
	}


	public String getCodUa(){
		return toString("codUa");
	}

	public void setCodUa(String value){
		setString("codUa",value);
	}


	public String getDtRetorno(){
		return toString("dtRetorno");
	}

	public void setDtRetorno(String value){
		setString("dtRetorno",value);
	}


	public String getCbarras(){
		return toString("cbarras");
	}

	public void setCbarras(String value){
		setString("cbarras",value);
	}


	public String getCodOp(){
		return toString("codOp");
	}

	public void setCodOp(String value){
		setString("codOp",value);
	}


	public String getCodOpComponente(){
		return toString("codOpComponente");
	}

	public void setCodOpComponente(String value){
		setString("codOpComponente",value);
	}


	public String getIndItemPai(){
		return toString("indItemPai");
	}

	public void setIndItemPai(String value){
		setString("indItemPai",value);
	}


	public String getTpFrete(){
		return toString("tpFrete");
	}

	public void setTpFrete(String value){
		setString("tpFrete",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.eNotaFiscalItemEtq newInstance(){
		return new com.br.client.model.vd.entity.eNotaFiscalItemEtq();
	}
}