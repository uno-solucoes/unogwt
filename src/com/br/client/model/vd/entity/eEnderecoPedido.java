package com.br.client.model.vd.entity;

public class eEnderecoPedido extends com.howmake.client.form.model.HowMGWTFormBean{
	public eEnderecoPedido(){
	}


	public String getTpEndereco(){
		return toString("tpEndereco");
	}

	public void setTpEndereco(String value){
		setString("tpEndereco",value);
	}


	public String getCodPedido(){
		return toString("codPedido");
	}

	public void setCodPedido(String value){
		setString("codPedido",value);
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getCep(){
		return toString("cep");
	}

	public void setCep(String value){
		setString("cep",value);
	}


	public String getCidade(){
		return toString("cidade");
	}

	public void setCidade(String value){
		setString("cidade",value);
	}


	public String getUf(){
		return toString("uf");
	}

	public void setUf(String value){
		setString("uf",value);
	}


	public String getBairro(){
		return toString("bairro");
	}

	public void setBairro(String value){
		setString("bairro",value);
	}


	public String getEndereco(){
		return toString("endereco");
	}

	public void setEndereco(String value){
		setString("endereco",value);
	}


	public String getNumero(){
		return toString("numero");
	}

	public void setNumero(String value){
		setString("numero",value);
	}


	public String getReferencia(){
		return toString("referencia");
	}

	public void setReferencia(String value){
		setString("referencia",value);
	}


	public String getComplemento(){
		return toString("complemento");
	}

	public void setComplemento(String value){
		setString("complemento",value);
	}


	public String getPais(){
		return toString("pais");
	}

	public void setPais(String value){
		setString("pais",value);
	}


	public String getCompleLog(){
		return toString("compleLog");
	}

	public void setCompleLog(String value){
		setString("compleLog",value);
	}


	public String getTipoLogradouro(){
		return toString("tipoLogradouro");
	}

	public void setTipoLogradouro(String value){
		setString("tipoLogradouro",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.eEnderecoPedido newInstance(){
		return new com.br.client.model.vd.entity.eEnderecoPedido();
	}
}