package com.br.client.model.oc.entity;

public class eFUPApontamento extends com.howmake.client.form.model.HowMGWTFormBean{
	public eFUPApontamento(){
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


	public String getDtReferencia(){
		return toString("dtReferencia");
	}

	public void setDtReferencia(String value){
		setString("dtReferencia",value);
	}


	public String getDtInicial(){
		return toString("dtInicial");
	}

	public void setDtInicial(String value){
		setString("dtInicial",value);
	}


	public String getDtFinal(){
		return toString("dtFinal");
	}

	public void setDtFinal(String value){
		setString("dtFinal",value);
	}


	public String getCodPlano(){
		return toString("codPlano");
	}

	public void setCodPlano(String value){
		setString("codPlano",value);
	}


	public String getCodOcorrencia(){
		return toString("codOcorrencia");
	}

	public void setCodOcorrencia(String value){
		setString("codOcorrencia",value);
	}


	public String getCodCategoria(){
		return toString("codCategoria");
	}

	public void setCodCategoria(String value){
		setString("codCategoria",value);
	}


	public String getDescCategoria(){
		return toString("descCategoria");
	}

	public void setDescCategoria(String value){
		setString("descCategoria",value);
	}


	public String getDescCategoriaPai(){
		return toString("descCategoriaPai");
	}

	public void setDescCategoriaPai(String value){
		setString("descCategoriaPai",value);
	}


	public String getDescAbrev(){
		return toString("descAbrev");
	}

	public void setDescAbrev(String value){
		setString("descAbrev",value);
	}


	public String getCodCliente(){
		return toString("codCliente");
	}

	public void setCodCliente(String value){
		setString("codCliente",value);
	}


	public String getNomeCliente(){
		return toString("nomeCliente");
	}

	public void setNomeCliente(String value){
		setString("nomeCliente",value);
	}


	public String getCodStatus(){
		return toString("codStatus");
	}

	public void setCodStatus(String value){
		setString("codStatus",value);
	}


	public String getDescStatus(){
		return toString("descStatus");
	}

	public void setDescStatus(String value){
		setString("descStatus",value);
	}


	public String getHrsDiferenc(){
		return toString("hrsDiferenc");
	}

	public void setHrsDiferenc(String value){
		setString("hrsDiferenc",value);
	}


	public String getHrsNormais(){
		return toString("hrsNormais");
	}

	public void setHrsNormais(String value){
		setString("hrsNormais",value);
	}


	public String getTotalHoras(){
		return toString("totalHoras");
	}

	public void setTotalHoras(String value){
		setString("totalHoras",value);
	}


	public String getObservacao(){
		return toString("observacao");
	}

	public void setObservacao(String value){
		setString("observacao",value);
	}


	public String getTpLinha(){
		return toString("tpLinha");
	}

	public void setTpLinha(String value){
		setString("tpLinha",value);
	}


	public String getTpAgrupamento(){
		return toString("tpAgrupamento");
	}

	public void setTpAgrupamento(String value){
		setString("tpAgrupamento",value);
	}


	public String getMostraDetalhes(){
		return toString("mostraDetalhes");
	}

	public void setMostraDetalhes(String value){
		setString("mostraDetalhes",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getOrigem(){
		return toString("origem");
	}

	public void setOrigem(String value){
		setString("origem",value);
	}


	public String getQtdMinutos(){
		return toString("qtdMinutos");
	}

	public void setQtdMinutos(String value){
		setString("qtdMinutos",value);
	}


	public String getDiaSemana(){
		return toString("diaSemana");
	}

	public void setDiaSemana(String value){
		setString("diaSemana",value);
	}


	public String getTpHora(){
		return toString("tpHora");
	}

	public void setTpHora(String value){
		setString("tpHora",value);
	}


	public String getCorpo(){
		return toString("corpo");
	}

	public void setCorpo(String value){
		setString("corpo",value);
	}


	public String getCcusto(){
		return toString("ccusto");
	}

	public void setCcusto(String value){
		setString("ccusto",value);
	}


	public String getNomeCcusto(){
		return toString("nomeCcusto");
	}

	public void setNomeCcusto(String value){
		setString("nomeCcusto",value);
	}


	public String getPorcentagem(){
		return toString("porcentagem");
	}

	public void setPorcentagem(String value){
		setString("porcentagem",value);
	}


	public String getPorcentagemTotal(){
		return toString("porcentagemTotal");
	}

	public void setPorcentagemTotal(String value){
		setString("porcentagemTotal",value);
	}


	public boolean getDiaUtil(){
		return toBoolean("diaUtil");
	}

	public void setDiaUtil(boolean value){
		setBoolean("diaUtil",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.oc.entity.eFUPApontamento newInstance(){
		return new com.br.client.model.oc.entity.eFUPApontamento();
	}
}