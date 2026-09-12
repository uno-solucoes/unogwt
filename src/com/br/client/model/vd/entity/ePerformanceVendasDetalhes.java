package com.br.client.model.vd.entity;

public class ePerformanceVendasDetalhes extends com.howmake.client.form.model.HowMGWTFormBean{
	public ePerformanceVendasDetalhes(){
	}


	public String getCodPedido(){
		return toString("codPedido");
	}

	public void setCodPedido(String value){
		setString("codPedido",value);
	}


	public String getCodProduto(){
		return toString("codProduto");
	}

	public void setCodProduto(String value){
		setString("codProduto",value);
	}


	public String getDescComercial(){
		return toString("descComercial");
	}

	public void setDescComercial(String value){
		setString("descComercial",value);
	}


	public String getQtde(){
		return toString("qtde");
	}

	public void setQtde(String value){
		setString("qtde",value);
	}


	public String getCodFamiliaComercial(){
		return toString("codFamiliaComercial");
	}

	public void setCodFamiliaComercial(String value){
		setString("codFamiliaComercial",value);
	}


	public String getFamiliaComercial(){
		return toString("familiaComercial");
	}

	public void setFamiliaComercial(String value){
		setString("familiaComercial",value);
	}


	public String getCodAplicacao(){
		return toString("codAplicacao");
	}

	public void setCodAplicacao(String value){
		setString("codAplicacao",value);
	}


	public String getTipoAplicacao(){
		return toString("tipoAplicacao");
	}

	public void setTipoAplicacao(String value){
		setString("tipoAplicacao",value);
	}


	public String getPrecoVenda(){
		return toString("precoVenda");
	}

	public void setPrecoVenda(String value){
		setString("precoVenda",value);
	}


	public String getPrecoTotal(){
		return toString("precoTotal");
	}

	public void setPrecoTotal(String value){
		setString("precoTotal",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getNomeColaborador(){
		return toString("nomeColaborador");
	}

	public void setNomeColaborador(String value){
		setString("nomeColaborador",value);
	}


	public String getCodOportunidade(){
		return toString("codOportunidade");
	}

	public void setCodOportunidade(String value){
		setString("codOportunidade",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.ePerformanceVendasDetalhes newInstance(){
		return new com.br.client.model.vd.entity.ePerformanceVendasDetalhes();
	}
}