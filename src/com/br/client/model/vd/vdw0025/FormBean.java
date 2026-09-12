package com.br.client.model.vd.vdw0025;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public String getMoedaPadrao(){
		return toString("moedaPadrao");
	}

	public void setMoedaPadrao(String value){
		setString("moedaPadrao",value);
	}


	public com.br.client.model.vd.entity.ePerformanceVendasDetalhes[] getListaDetalhePerformanceVendas(){
		Object obj = _self.get("listaDetalhePerformanceVendas");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.ePerformanceVendasDetalhes[])obj;

	}

	public void setListaDetalhePerformanceVendas(com.br.client.model.vd.entity.ePerformanceVendasDetalhes[] value){
		_self.remove("listaDetalhePerformanceVendas");
		if ( value != null );
			_self.put("listaDetalhePerformanceVendas", value);

	}


	public String getCdOportunidadeOportunidadeFUP(){
		return toString("cdOportunidadeOportunidadeFUP");
	}

	public void setCdOportunidadeOportunidadeFUP(String value){
		setString("cdOportunidadeOportunidadeFUP",value);
	}


	public String getFiltroResponsavelOportunidadeFUP(){
		return toString("filtroResponsavelOportunidadeFUP");
	}

	public void setFiltroResponsavelOportunidadeFUP(String value){
		setString("filtroResponsavelOportunidadeFUP",value);
	}


	public String getCdColaboradorOportunidadeFUP(){
		return toString("cdColaboradorOportunidadeFUP");
	}

	public void setCdColaboradorOportunidadeFUP(String value){
		setString("cdColaboradorOportunidadeFUP",value);
	}


	public String getIdColaboradorOportunidadeFUP(){
		return toString("idColaboradorOportunidadeFUP");
	}

	public void setIdColaboradorOportunidadeFUP(String value){
		setString("idColaboradorOportunidadeFUP",value);
	}


	public String getCdFamiliaComercialOportunidadeFUP(){
		return toString("cdFamiliaComercialOportunidadeFUP");
	}

	public void setCdFamiliaComercialOportunidadeFUP(String value){
		setString("cdFamiliaComercialOportunidadeFUP",value);
	}


	public String getNmFamiliaComercialOportunidadeFUP(){
		return toString("nmFamiliaComercialOportunidadeFUP");
	}

	public void setNmFamiliaComercialOportunidadeFUP(String value){
		setString("nmFamiliaComercialOportunidadeFUP",value);
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


	public int getTpAgrupamento(){
		return toInteger("tpAgrupamento");
	}

	public void setTpAgrupamento(int value){
		setInteger("tpAgrupamento",value);
	}


	public String getSomaTotalVlTotalFaturado(){
		return toString("somaTotalVlTotalFaturado");
	}

	public void setSomaTotalVlTotalFaturado(String value){
		setString("somaTotalVlTotalFaturado",value);
	}


	public String getSomaTotalMeta(){
		return toString("somaTotalMeta");
	}

	public void setSomaTotalMeta(String value){
		setString("somaTotalMeta",value);
	}


	public String getSomaTotalMetaAtingida(){
		return toString("somaTotalMetaAtingida");
	}

	public void setSomaTotalMetaAtingida(String value){
		setString("somaTotalMetaAtingida",value);
	}


	public String getSomaTotalVlFaltaMeta(){
		return toString("somaTotalVlFaltaMeta");
	}

	public void setSomaTotalVlFaltaMeta(String value){
		setString("somaTotalVlFaltaMeta",value);
	}


	public int getOPERATION_INSERT(){
		return toInteger("OPERATION_INSERT");
	}

	public void setOPERATION_INSERT(int value){
		setInteger("OPERATION_INSERT",value);
	}


	public int getOPERATION_UPDATE(){
		return toInteger("OPERATION_UPDATE");
	}

	public void setOPERATION_UPDATE(int value){
		setInteger("OPERATION_UPDATE",value);
	}


	public int getOPERATION_DELETE(){
		return toInteger("OPERATION_DELETE");
	}

	public void setOPERATION_DELETE(int value){
		setInteger("OPERATION_DELETE",value);
	}


	public int getOPERATION_QUERY(){
		return toInteger("OPERATION_QUERY");
	}

	public void setOPERATION_QUERY(int value){
		setInteger("OPERATION_QUERY",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "listaDetalhePerformanceVendas".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.ePerformanceVendasDetalhes[] obj = new com.br.client.model.vd.entity.ePerformanceVendasDetalhes[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.ePerformanceVendasDetalhes)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "listaDetalhePerformanceVendas".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.ePerformanceVendasDetalhes obj = com.br.client.model.vd.entity.ePerformanceVendasDetalhes.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.vd.vdw0025.FormBean newInstance(){
		return new com.br.client.model.vd.vdw0025.FormBean();
	}
}