package com.br.client.model.cd.entity;

public class eImagemProduto extends com.howmake.client.form.model.HowMGWTFormBean{
	public eImagemProduto(){
	}


	public String getCodProduto(){
		return toString("codProduto");
	}

	public void setCodProduto(String value){
		setString("codProduto",value);
	}


	public String getCodImagem(){
		return toString("codImagem");
	}

	public void setCodImagem(String value){
		setString("codImagem",value);
	}


	public String getTpImg(){
		return toString("tpImg");
	}

	public void setTpImg(String value){
		setString("tpImg",value);
	}


	public String getImagem(){
		return toString("imagem");
	}

	public void setImagem(String value){
		setString("imagem",value);
	}


	public String getImagemExibicao(){
		return toString("imagemExibicao");
	}

	public void setImagemExibicao(String value){
		setString("imagemExibicao",value);
	}


	public String getDtUltimaAtualizacao(){
		return toString("dtUltimaAtualizacao");
	}

	public void setDtUltimaAtualizacao(String value){
		setString("dtUltimaAtualizacao",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.cd.entity.eImagemProduto newInstance(){
		return new com.br.client.model.cd.entity.eImagemProduto();
	}
}