package com.br.client.model.fn.entity;

public class eComissaoPagto extends com.howmake.client.form.model.HowMGWTFormBean{
	public eComissaoPagto(){
	}


	public String getNrSequenciaPagto(){
		return toString("nrSequenciaPagto");
	}

	public void setNrSequenciaPagto(String value){
		setString("nrSequenciaPagto",value);
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getCodTitulo(){
		return toString("codTitulo");
	}

	public void setCodTitulo(String value){
		setString("codTitulo",value);
	}


	public String getCodParcela(){
		return toString("codParcela");
	}

	public void setCodParcela(String value){
		setString("codParcela",value);
	}


	public String getCodFornecedor(){
		return toString("codFornecedor");
	}

	public void setCodFornecedor(String value){
		setString("codFornecedor",value);
	}


	public String getNrSequencia(){
		return toString("nrSequencia");
	}

	public void setNrSequencia(String value){
		setString("nrSequencia",value);
	}


	public String getCodEspecie(){
		return toString("codEspecie");
	}

	public void setCodEspecie(String value){
		setString("codEspecie",value);
	}


	public String getSerie(){
		return toString("serie");
	}

	public void setSerie(String value){
		setString("serie",value);
	}


	public String getCodParcelaPagar(){
		return toString("codParcelaPagar");
	}

	public void setCodParcelaPagar(String value){
		setString("codParcelaPagar",value);
	}


	public String getCodTituloPagar(){
		return toString("codTituloPagar");
	}

	public void setCodTituloPagar(String value){
		setString("codTituloPagar",value);
	}


	public String getDtImplant(){
		return toString("dtImplant");
	}

	public void setDtImplant(String value){
		setString("dtImplant",value);
	}


	public String getCodNotaFiscal(){
		return toString("codNotaFiscal");
	}

	public void setCodNotaFiscal(String value){
		setString("codNotaFiscal",value);
	}


	public String getCodPedido(){
		return toString("codPedido");
	}

	public void setCodPedido(String value){
		setString("codPedido",value);
	}


	public String getVlComissao(){
		return toString("vlComissao");
	}

	public void setVlComissao(String value){
		setString("vlComissao",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getCodRevenda(){
		return toString("codRevenda");
	}

	public void setCodRevenda(String value){
		setString("codRevenda",value);
	}


	public String getTpOwner(){
		return toString("tpOwner");
	}

	public void setTpOwner(String value){
		setString("tpOwner",value);
	}


	public String getCodPlano(){
		return toString("codPlano");
	}

	public void setCodPlano(String value){
		setString("codPlano",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.fn.entity.eComissaoPagto newInstance(){
		return new com.br.client.model.fn.entity.eComissaoPagto();
	}
}