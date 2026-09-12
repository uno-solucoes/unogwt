package com.br.client.model.vd.entity;

public class eNFSEControle extends com.howmake.client.form.model.HowMGWTFormBean{
	public eNFSEControle(){
	}


	public boolean getKillJobCancelamento(){
		return toBoolean("killJobCancelamento");
	}

	public void setKillJobCancelamento(boolean value){
		setBoolean("killJobCancelamento",value);
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


	public String getNrRps(){
		return toString("nrRps");
	}

	public void setNrRps(String value){
		setString("nrRps",value);
	}


	public String getIdNfse(){
		return toString("idNfse");
	}

	public void setIdNfse(String value){
		setString("idNfse",value);
	}


	public String getIndLock(){
		return toString("indLock");
	}

	public void setIndLock(String value){
		setString("indLock",value);
	}


	public String getIndModeloNovo(){
		return toString("indModeloNovo");
	}

	public void setIndModeloNovo(String value){
		setString("indModeloNovo",value);
	}


	public String getTxtError(){
		return toString("txtError");
	}

	public void setTxtError(String value){
		setString("txtError",value);
	}


	public String getIndError(){
		return toString("indError");
	}

	public void setIndError(String value){
		setString("indError",value);
	}


	public String getChaveRPS(){
		return toString("chaveRPS");
	}

	public void setChaveRPS(String value){
		setString("chaveRPS",value);
	}


	public String getSerieRPS(){
		return toString("serieRPS");
	}

	public void setSerieRPS(String value){
		setString("serieRPS",value);
	}


	public String getChaveRPSCancelamento(){
		return toString("chaveRPSCancelamento");
	}

	public void setChaveRPSCancelamento(String value){
		setString("chaveRPSCancelamento",value);
	}


	public String getNmArquivoCancelamento(){
		return toString("nmArquivoCancelamento");
	}

	public void setNmArquivoCancelamento(String value){
		setString("nmArquivoCancelamento",value);
	}


	public String getNrNFSE(){
		return toString("nrNFSE");
	}

	public void setNrNFSE(String value){
		setString("nrNFSE",value);
	}


	public String getReabrirPedido(){
		return toString("reabrirPedido");
	}

	public void setReabrirPedido(String value){
		setString("reabrirPedido",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.eNFSEControle newInstance(){
		return new com.br.client.model.vd.entity.eNFSEControle();
	}
}