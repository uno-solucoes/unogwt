package com.br.client.model.vd.entity;

public class eNFSEStatusWS extends com.howmake.client.form.model.HowMGWTFormBean{
	public eNFSEStatusWS(){
	}


	public String getChaveNFSE(){
		return toString("chaveNFSE");
	}

	public void setChaveNFSE(String value){
		setString("chaveNFSE",value);
	}


	public String getCmsgSefaz(){
		return toString("cmsgSefaz");
	}

	public void setCmsgSefaz(String value){
		setString("cmsgSefaz",value);
	}


	public String getCodStat(){
		return toString("codStat");
	}

	public void setCodStat(String value){
		setString("codStat",value);
	}


	public String getCStat(){
		return toString("cStat");
	}

	public void setCStat(String value){
		setString("cStat",value);
	}


	public String getDataEmissao(){
		return toString("dataEmissao");
	}

	public void setDataEmissao(String value){
		setString("dataEmissao",value);
	}


	public String getDestinatario(){
		return toString("destinatario");
	}

	public void setDestinatario(String value){
		setString("destinatario",value);
	}


	public String getDataHoraRecebimento(){
		return toString("dataHoraRecebimento");
	}

	public void setDataHoraRecebimento(String value){
		setString("dataHoraRecebimento",value);
	}


	public String getDataAlteracao(){
		return toString("dataAlteracao");
	}

	public void setDataAlteracao(String value){
		setString("dataAlteracao",value);
	}


	public String getEMails(){
		return toString("eMails");
	}

	public void setEMails(String value){
		setString("eMails",value);
	}


	public String getEMailsSucesso(){
		return toString("eMailsSucesso");
	}

	public void setEMailsSucesso(String value){
		setString("eMailsSucesso",value);
	}


	public String getMunicipio(){
		return toString("municipio");
	}

	public void setMunicipio(String value){
		setString("municipio",value);
	}


	public String getMunicipioPrestacao(){
		return toString("municipioPrestacao");
	}

	public void setMunicipioPrestacao(String value){
		setString("municipioPrestacao",value);
	}


	public String getNNf(){
		return toString("nNf");
	}

	public void setNNf(String value){
		setString("nNf",value);
	}


	public String getNProtocoloCancelamento(){
		return toString("nProtocoloCancelamento");
	}

	public void setNProtocoloCancelamento(String value){
		setString("nProtocoloCancelamento",value);
	}


	public String getNProtocoloEnvio(){
		return toString("nProtocoloEnvio");
	}

	public void setNProtocoloEnvio(String value){
		setString("nProtocoloEnvio",value);
	}


	public String getNProtocoloRecebimento(){
		return toString("nProtocoloRecebimento");
	}

	public void setNProtocoloRecebimento(String value){
		setString("nProtocoloRecebimento",value);
	}


	public String getNumeroNFSE(){
		return toString("numeroNFSE");
	}

	public void setNumeroNFSE(String value){
		setString("numeroNFSE",value);
	}


	public String getQtdEmissao(){
		return toString("qtdEmissao");
	}

	public void setQtdEmissao(String value){
		setString("qtdEmissao",value);
	}


	public String getQtdEnvioEmail(){
		return toString("qtdEnvioEmail");
	}

	public void setQtdEnvioEmail(String value){
		setString("qtdEnvioEmail",value);
	}


	public String getQtdRetornada(){
		return toString("qtdRetornada");
	}

	public void setQtdRetornada(String value){
		setString("qtdRetornada",value);
	}


	public String getSerie(){
		return toString("serie");
	}

	public void setSerie(String value){
		setString("serie",value);
	}


	public String getTipoIntegracao(){
		return toString("tipoIntegracao");
	}

	public void setTipoIntegracao(String value){
		setString("tipoIntegracao",value);
	}


	public String getTipoAmbiente(){
		return toString("tipoAmbiente");
	}

	public void setTipoAmbiente(String value){
		setString("tipoAmbiente",value);
	}


	public String getTipoEnvio(){
		return toString("tipoEnvio");
	}

	public void setTipoEnvio(String value){
		setString("tipoEnvio",value);
	}


	public String getTipoImpressao(){
		return toString("tipoImpressao");
	}

	public void setTipoImpressao(String value){
		setString("tipoImpressao",value);
	}


	public String getMotivo(){
		return toString("motivo");
	}

	public void setMotivo(String value){
		setString("motivo",value);
	}


	public String getMsgSefaz(){
		return toString("msgSefaz");
	}

	public void setMsgSefaz(String value){
		setString("msgSefaz",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.eNFSEStatusWS newInstance(){
		return new com.br.client.model.vd.entity.eNFSEStatusWS();
	}
}