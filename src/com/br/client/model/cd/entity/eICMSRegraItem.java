package com.br.client.model.cd.entity;

public class eICMSRegraItem extends com.howmake.client.form.model.HowMGWTFormBean{
	public eICMSRegraItem(){
	}


	public String getCodRegraIcms(){
		return toString("codRegraIcms");
	}

	public void setCodRegraIcms(String value){
		setString("codRegraIcms",value);
	}


	public String getNrSequencia(){
		return toString("nrSequencia");
	}

	public void setNrSequencia(String value){
		setString("nrSequencia",value);
	}


	public String getCodMensagem(){
		return toString("codMensagem");
	}

	public void setCodMensagem(String value){
		setString("codMensagem",value);
	}


	public String getTpContribuinte(){
		return toString("tpContribuinte");
	}

	public void setTpContribuinte(String value){
		setString("tpContribuinte",value);
	}


	public String getCodTpContribuinte(){
		return toString("codTpContribuinte");
	}

	public void setCodTpContribuinte(String value){
		setString("codTpContribuinte",value);
	}


	public String getCodOrigemFiscal(){
		return toString("codOrigemFiscal");
	}

	public void setCodOrigemFiscal(String value){
		setString("codOrigemFiscal",value);
	}


	public String getOrigemFiscal(){
		return toString("origemFiscal");
	}

	public void setOrigemFiscal(String value){
		setString("origemFiscal",value);
	}


	public String getSiglaUf(){
		return toString("siglaUf");
	}

	public void setSiglaUf(String value){
		setString("siglaUf",value);
	}


	public String getPercBasePropria(){
		return toString("percBasePropria");
	}

	public void setPercBasePropria(String value){
		setString("percBasePropria",value);
	}


	public String getPercBaseSt(){
		return toString("percBaseSt");
	}

	public void setPercBaseSt(String value){
		setString("percBaseSt",value);
	}


	public String getAliquotaIcmsPropria(){
		return toString("aliquotaIcmsPropria");
	}

	public void setAliquotaIcmsPropria(String value){
		setString("aliquotaIcmsPropria",value);
	}


	public String getAliquotaIcmsSt(){
		return toString("aliquotaIcmsSt");
	}

	public void setAliquotaIcmsSt(String value){
		setString("aliquotaIcmsSt",value);
	}


	public String getPercDiferimento(){
		return toString("percDiferimento");
	}

	public void setPercDiferimento(String value){
		setString("percDiferimento",value);
	}


	public String getPercIvaSt(){
		return toString("percIvaSt");
	}

	public void setPercIvaSt(String value){
		setString("percIvaSt",value);
	}


	public String getCodTribIcms(){
		return toString("codTribIcms");
	}

	public void setCodTribIcms(String value){
		setString("codTribIcms",value);
	}


	public String getCsosn(){
		return toString("csosn");
	}

	public void setCsosn(String value){
		setString("csosn",value);
	}


	public String getClassFiscal(){
		return toString("classFiscal");
	}

	public void setClassFiscal(String value){
		setString("classFiscal",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getCodColaboradorAlteracao(){
		return toString("codColaboradorAlteracao");
	}

	public void setCodColaboradorAlteracao(String value){
		setString("codColaboradorAlteracao",value);
	}


	public String getDtImplant(){
		return toString("dtImplant");
	}

	public void setDtImplant(String value){
		setString("dtImplant",value);
	}


	public String getDtAlteracao(){
		return toString("dtAlteracao");
	}

	public void setDtAlteracao(String value){
		setString("dtAlteracao",value);
	}


	public String getDescColaboradorImplant(){
		return toString("descColaboradorImplant");
	}

	public void setDescColaboradorImplant(String value){
		setString("descColaboradorImplant",value);
	}


	public String getDescColaboradorAlteracao(){
		return toString("descColaboradorAlteracao");
	}

	public void setDescColaboradorAlteracao(String value){
		setString("descColaboradorAlteracao",value);
	}


	public String getDescricaoAltItem(){
		return toString("descricaoAltItem");
	}

	public void setDescricaoAltItem(String value){
		setString("descricaoAltItem",value);
	}


	public String getPrecoUnit(){
		return toString("precoUnit");
	}

	public void setPrecoUnit(String value){
		setString("precoUnit",value);
	}


	public String getVlBaseIcmsSt(){
		return toString("vlBaseIcmsSt");
	}

	public void setVlBaseIcmsSt(String value){
		setString("vlBaseIcmsSt",value);
	}


	public String getVlFinalItem(){
		return toString("vlFinalItem");
	}

	public void setVlFinalItem(String value){
		setString("vlFinalItem",value);
	}


	public String getAliquotaFCP(){
		return toString("aliquotaFCP");
	}

	public void setAliquotaFCP(String value){
		setString("aliquotaFCP",value);
	}


	public String getPercBaseIcmsDest(){
		return toString("percBaseIcmsDest");
	}

	public void setPercBaseIcmsDest(String value){
		setString("percBaseIcmsDest",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.cd.entity.eICMSRegraItem newInstance(){
		return new com.br.client.model.cd.entity.eICMSRegraItem();
	}
}