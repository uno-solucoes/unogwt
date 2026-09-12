package com.br.client.model.cd.entity;

public class ePrecoItem extends com.howmake.client.form.model.HowMGWTFormBean{
	public ePrecoItem(){
	}


	public String getCodProduto(){
		return toString("codProduto");
	}

	public void setCodProduto(String value){
		setString("codProduto",value);
	}


	public String getTbPreco(){
		return toString("tbPreco");
	}

	public void setTbPreco(String value){
		setString("tbPreco",value);
	}


	public String getQtdMin(){
		return toString("qtdMin");
	}

	public void setQtdMin(String value){
		setString("qtdMin",value);
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


	public String getSituacao(){
		return toString("situacao");
	}

	public void setSituacao(String value){
		setString("situacao",value);
	}


	public String getMoeda(){
		return toString("moeda");
	}

	public void setMoeda(String value){
		setString("moeda",value);
	}


	public String getDtAlteracao(){
		return toString("dtAlteracao");
	}

	public void setDtAlteracao(String value){
		setString("dtAlteracao",value);
	}


	public String getIndAjustePrecoItem(){
		return toString("indAjustePrecoItem");
	}

	public void setIndAjustePrecoItem(String value){
		setString("indAjustePrecoItem",value);
	}


	public String getIndPrecoVariado(){
		return toString("indPrecoVariado");
	}

	public void setIndPrecoVariado(String value){
		setString("indPrecoVariado",value);
	}


	public String getPercVariacaoMax(){
		return toString("percVariacaoMax");
	}

	public void setPercVariacaoMax(String value){
		setString("percVariacaoMax",value);
	}


	public String getPercVariacaoMin(){
		return toString("percVariacaoMin");
	}

	public void setPercVariacaoMin(String value){
		setString("percVariacaoMin",value);
	}


	public String getPonto(){
		return toString("ponto");
	}

	public void setPonto(String value){
		setString("ponto",value);
	}


	public String getPercVariacao(){
		return toString("percVariacao");
	}

	public void setPercVariacao(String value){
		setString("percVariacao",value);
	}


	public String getPrecoOriginal(){
		return toString("precoOriginal");
	}

	public void setPrecoOriginal(String value){
		setString("precoOriginal",value);
	}


	public double getPerc(){
		return toDouble("perc");
	}

	public void setPerc(double value){
		setDouble("perc",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.cd.entity.ePrecoItem newInstance(){
		return new com.br.client.model.cd.entity.ePrecoItem();
	}
}