package com.br.client.model.ed.entity;

public class eEDIProduto extends com.howmake.client.form.model.HowMGWTFormBean{
	public eEDIProduto(){
	}


	public String getCodEDI(){
		return toString("codEDI");
	}

	public void setCodEDI(String value){
		setString("codEDI",value);
	}


	public String getCodProduto(){
		return toString("codProduto");
	}

	public void setCodProduto(String value){
		setString("codProduto",value);
	}


	public String getDtVigenciaInicio(){
		return toString("dtVigenciaInicio");
	}

	public void setDtVigenciaInicio(String value){
		setString("dtVigenciaInicio",value);
	}


	public String getDtVigenciaFinal(){
		return toString("dtVigenciaFinal");
	}

	public void setDtVigenciaFinal(String value){
		setString("dtVigenciaFinal",value);
	}


	public String getPrioridadeReserva(){
		return toString("prioridadeReserva");
	}

	public void setPrioridadeReserva(String value){
		setString("prioridadeReserva",value);
	}


	public boolean getIndAtivo(){
		return toBoolean("indAtivo");
	}

	public void setIndAtivo(boolean value){
		setBoolean("indAtivo",value);
	}


	public String getDescComercial(){
		return toString("descComercial");
	}

	public void setDescComercial(String value){
		setString("descComercial",value);
	}


	public int getOperacao(){
		return toInteger("operacao");
	}

	public void setOperacao(int value){
		setInteger("operacao",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getEdiSaldo(){
		return toString("ediSaldo");
	}

	public void setEdiSaldo(String value){
		setString("ediSaldo",value);
	}


	public String getEdiPrecoVenda(){
		return toString("ediPrecoVenda");
	}

	public void setEdiPrecoVenda(String value){
		setString("ediPrecoVenda",value);
	}


	public String getMensagemEDI(){
		return toString("mensagemEDI");
	}

	public void setMensagemEDI(String value){
		setString("mensagemEDI",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.ed.entity.eEDIProduto newInstance(){
		return new com.br.client.model.ed.entity.eEDIProduto();
	}
}