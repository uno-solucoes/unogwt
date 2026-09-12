package com.br.client.model.vd.vdw1000;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public String getIndSendAutomatic(){
		return toString("indSendAutomatic");
	}

	public void setIndSendAutomatic(String value){
		setString("indSendAutomatic",value);
	}


	public String getNrUltimaNFSeValidada(){
		return toString("nrUltimaNFSeValidada");
	}

	public void setNrUltimaNFSeValidada(String value){
		setString("nrUltimaNFSeValidada",value);
	}


	public String getExecuteOperacao(){
		return toString("executeOperacao");
	}

	public void setExecuteOperacao(String value){
		setString("executeOperacao",value);
	}


	public String getIndSendMailNFSEBoleto(){
		return toString("indSendMailNFSEBoleto");
	}

	public void setIndSendMailNFSEBoleto(String value){
		setString("indSendMailNFSEBoleto",value);
	}


	public String getUrlLinkPrefeitura(){
		return toString("urlLinkPrefeitura");
	}

	public void setUrlLinkPrefeitura(String value){
		setString("urlLinkPrefeitura",value);
	}


	public String getUrlConsultaNFSePrefeitura(){
		return toString("urlConsultaNFSePrefeitura");
	}

	public void setUrlConsultaNFSePrefeitura(String value){
		setString("urlConsultaNFSePrefeitura",value);
	}


	public java.lang.String[] getUrlConsultasNFSePrefeitura(){
		Object obj = _self.get("urlConsultasNFSePrefeitura");
		if ( obj == null )
			return null;
		else
			return (java.lang.String[])obj;

	}

	public void setUrlConsultasNFSePrefeitura(java.lang.String[] value){
		_self.remove("urlConsultasNFSePrefeitura");
		if ( value != null )
			_self.put("urlConsultasNFSePrefeitura", value);

	}


	public String getUsuarioPrefeitura(){
		return toString("usuarioPrefeitura");
	}

	public void setUsuarioPrefeitura(String value){
		setString("usuarioPrefeitura",value);
	}


	public String getSenhaMonitoramento(){
		return toString("senhaMonitoramento");
	}

	public void setSenhaMonitoramento(String value){
		setString("senhaMonitoramento",value);
	}


	public String getNomeClasseEnvioPrefeitura(){
		return toString("nomeClasseEnvioPrefeitura");
	}

	public void setNomeClasseEnvioPrefeitura(String value){
		setString("nomeClasseEnvioPrefeitura",value);
	}


	public String getNomeClasseCancelaPrefeitura(){
		return toString("nomeClasseCancelaPrefeitura");
	}

	public void setNomeClasseCancelaPrefeitura(String value){
		setString("nomeClasseCancelaPrefeitura",value);
	}


	public String getNomeClasseConsultaPrefeitura(){
		return toString("nomeClasseConsultaPrefeitura");
	}

	public void setNomeClasseConsultaPrefeitura(String value){
		setString("nomeClasseConsultaPrefeitura",value);
	}


	public String getNomePastaCancelamento(){
		return toString("nomePastaCancelamento");
	}

	public void setNomePastaCancelamento(String value){
		setString("nomePastaCancelamento",value);
	}


	public String getNomePastaEnvio(){
		return toString("nomePastaEnvio");
	}

	public void setNomePastaEnvio(String value){
		setString("nomePastaEnvio",value);
	}


	public String getNrDiasPermiteCancelamento(){
		return toString("nrDiasPermiteCancelamento");
	}

	public void setNrDiasPermiteCancelamento(String value){
		setString("nrDiasPermiteCancelamento",value);
	}


	public String getIndPermiteCanclemantoForaMes(){
		return toString("indPermiteCanclemantoForaMes");
	}

	public void setIndPermiteCanclemantoForaMes(String value){
		setString("indPermiteCanclemantoForaMes",value);
	}


	public String getIndEnviaSerie(){
		return toString("indEnviaSerie");
	}

	public void setIndEnviaSerie(String value){
		setString("indEnviaSerie",value);
	}


	public String getIndEnviaDadosDebug(){
		return toString("indEnviaDadosDebug");
	}

	public void setIndEnviaDadosDebug(String value){
		setString("indEnviaDadosDebug",value);
	}


	public String getUsuarioSuporte(){
		return toString("usuarioSuporte");
	}

	public void setUsuarioSuporte(String value){
		setString("usuarioSuporte",value);
	}


	public String getSenhaSuporte(){
		return toString("senhaSuporte");
	}

	public void setSenhaSuporte(String value){
		setString("senhaSuporte",value);
	}


	public String getSuporteEmail(){
		return toString("suporteEmail");
	}

	public void setSuporteEmail(String value){
		setString("suporteEmail",value);
	}


	public String getAnaliseRPS(){
		return toString("analiseRPS");
	}

	public void setAnaliseRPS(String value){
		setString("analiseRPS",value);
	}


	public String getDownloadPath(){
		return toString("downloadPath");
	}

	public void setDownloadPath(String value){
		setString("downloadPath",value);
	}


	public String getDownloadFileName(){
		return toString("downloadFileName");
	}

	public void setDownloadFileName(String value){
		setString("downloadFileName",value);
	}


	public String getCodRPS(){
		return toString("codRPS");
	}

	public void setCodRPS(String value){
		setString("codRPS",value);
	}


	public String getCodPedido(){
		return toString("codPedido");
	}

	public void setCodPedido(String value){
		setString("codPedido",value);
	}


	public String getCodPlano(){
		return toString("codPlano");
	}

	public void setCodPlano(String value){
		setString("codPlano",value);
	}


	public String getNomeCliente(){
		return toString("nomeCliente");
	}

	public void setNomeCliente(String value){
		setString("nomeCliente",value);
	}


	public String getTipoDownload(){
		return toString("tipoDownload");
	}

	public void setTipoDownload(String value){
		setString("tipoDownload",value);
	}


	public com.br.client.model.vd.entity.eNFSEServicesConfiguration getEntityServicesConfiguration(){
		Object obj = _self.get("entityServicesConfiguration");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSEServicesConfiguration)obj;

	}

	public void setEntityServicesConfiguration(com.br.client.model.vd.entity.eNFSEServicesConfiguration value){
		_self.remove("entityServicesConfiguration");
		if ( value != null )
			_self.put("entityServicesConfiguration", value);

	}


	public String getChave(){
		return toString("chave");
	}

	public void setChave(String value){
		setString("chave",value);
	}


	public String getReabrirPedido(){
		return toString("reabrirPedido");
	}

	public void setReabrirPedido(String value){
		setString("reabrirPedido",value);
	}


	public String getReabrirOportunidade(){
		return toString("reabrirOportunidade");
	}

	public void setReabrirOportunidade(String value){
		setString("reabrirOportunidade",value);
	}


	public String getCodCliente(){
		return toString("codCliente");
	}

	public void setCodCliente(String value){
		setString("codCliente",value);
	}


	public String getNaoEnviados(){
		return toString("naoEnviados");
	}

	public void setNaoEnviados(String value){
		setString("naoEnviados",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getDtInicio(){
		return toString("dtInicio");
	}

	public void setDtInicio(String value){
		setString("dtInicio",value);
	}


	public String getDtFim(){
		return toString("dtFim");
	}

	public void setDtFim(String value){
		setString("dtFim",value);
	}


	public String getFileName(){
		return toString("fileName");
	}

	public void setFileName(String value){
		setString("fileName",value);
	}


	public String getPathName(){
		return toString("pathName");
	}

	public void setPathName(String value){
		setString("pathName",value);
	}


	public String getCodEmitente(){
		return toString("codEmitente");
	}

	public void setCodEmitente(String value){
		setString("codEmitente",value);
	}


	public String getDownloadURL(){
		return toString("downloadURL");
	}

	public void setDownloadURL(String value){
		setString("downloadURL",value);
	}


	public String getMsgWarning(){
		return toString("msgWarning");
	}

	public void setMsgWarning(String value){
		setString("msgWarning",value);
	}


	public com.br.client.model.vd.entity.eNFSE getEntityNFSE(){
		Object obj = _self.get("entityNFSE");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSE)obj;

	}

	public void setEntityNFSE(com.br.client.model.vd.entity.eNFSE value){
		_self.remove("entityNFSE");
		if ( value != null )
			_self.put("entityNFSE", value);

	}


	public com.br.client.model.vd.entity.eNFSE[] getEntityNFSEs(){
		Object obj = _self.get("entityNFSEs");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSE[])obj;

	}

	public void setEntityNFSEs(com.br.client.model.vd.entity.eNFSE[] value){
		_self.remove("entityNFSEs");
		if ( value != null )
			_self.put("entityNFSEs", value);

	}


	public String getNrUltimaRPSEmitida(){
		return toString("nrUltimaRPSEmitida");
	}

	public void setNrUltimaRPSEmitida(String value){
		setString("nrUltimaRPSEmitida",value);
	}


	public String getCodNotaFiscal(){
		return toString("codNotaFiscal");
	}

	public void setCodNotaFiscal(String value){
		setString("codNotaFiscal",value);
	}


	public com.br.client.model.vd.entity.eNFSELoteWS getEntityLoteWS(){
		Object obj = _self.get("entityLoteWS");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSELoteWS)obj;

	}

	public void setEntityLoteWS(com.br.client.model.vd.entity.eNFSELoteWS value){
		_self.remove("entityLoteWS");
		if ( value != null )
			_self.put("entityLoteWS", value);

	}


	public com.br.client.model.vd.entity.eNFSEHistoricoStatusWS[] getEntityHistoricosStatusWS(){
		Object obj = _self.get("entityHistoricosStatusWS");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSEHistoricoStatusWS[])obj;

	}

	public void setEntityHistoricosStatusWS(com.br.client.model.vd.entity.eNFSEHistoricoStatusWS[] value){
		_self.remove("entityHistoricosStatusWS");
		if ( value != null )
			_self.put("entityHistoricosStatusWS", value);

	}


	public com.br.client.model.vd.entity.eNFSEEmitenteWS getEntityEmitenteWS(){
		Object obj = _self.get("entityEmitenteWS");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSEEmitenteWS)obj;

	}

	public void setEntityEmitenteWS(com.br.client.model.vd.entity.eNFSEEmitenteWS value){
		_self.remove("entityEmitenteWS");
		if ( value != null )
			_self.put("entityEmitenteWS", value);

	}


	public com.br.client.model.vd.entity.eNFSEStatusWS getEntityNfseStatusWS(){
		Object obj = _self.get("entityNfseStatusWS");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.vd.entity.eNFSEStatusWS)obj;

	}

	public void setEntityNfseStatusWS(com.br.client.model.vd.entity.eNFSEStatusWS value){
		_self.remove("entityNfseStatusWS");
		if ( value != null )
			_self.put("entityNfseStatusWS", value);

	}


	public String getGeoScript(){
		return toString("geoScript");
	}

	public void setGeoScript(String value){
		setString("geoScript",value);
	}


	public String getLabelCustoTotal(){
		return toString("labelCustoTotal");
	}

	public void setLabelCustoTotal(String value){
		setString("labelCustoTotal",value);
	}


	public String getTitleCustoTotal(){
		return toString("titleCustoTotal");
	}

	public void setTitleCustoTotal(String value){
		setString("titleCustoTotal",value);
	}


	public String getErroDetail(){
		return toString("erroDetail");
	}

	public void setErroDetail(String value){
		setString("erroDetail",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "urlConsultasNFSePrefeitura".equalsIgnoreCase(name) ){
			java.lang.String[] obj = new java.lang.String[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isString()!= null )
					obj[i] = object.isString().stringValue();
				 
			}
		}
		if ( "entityServicesConfiguration".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEServicesConfiguration obj = new com.br.client.model.vd.entity.eNFSEServicesConfiguration();
			_self.put(name,obj);
		}
		if ( "entityNFSE".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSE obj = new com.br.client.model.vd.entity.eNFSE();
			_self.put(name,obj);
		}
		if ( "entityNFSEs".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSE[] obj = new com.br.client.model.vd.entity.eNFSE[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eNFSE)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "entityLoteWS".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSELoteWS obj = new com.br.client.model.vd.entity.eNFSELoteWS();
			_self.put(name,obj);
		}
		if ( "entityHistoricosStatusWS".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEHistoricoStatusWS[] obj = new com.br.client.model.vd.entity.eNFSEHistoricoStatusWS[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.vd.entity.eNFSEHistoricoStatusWS)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "entityEmitenteWS".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEEmitenteWS obj = new com.br.client.model.vd.entity.eNFSEEmitenteWS();
			_self.put(name,obj);
		}
		if ( "entityNfseStatusWS".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEStatusWS obj = new com.br.client.model.vd.entity.eNFSEStatusWS();
			_self.put(name,obj);
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "entityServicesConfiguration".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEServicesConfiguration obj = com.br.client.model.vd.entity.eNFSEServicesConfiguration.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityNFSE".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSE obj = com.br.client.model.vd.entity.eNFSE.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityNFSEs".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSE obj = com.br.client.model.vd.entity.eNFSE.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityLoteWS".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSELoteWS obj = com.br.client.model.vd.entity.eNFSELoteWS.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityHistoricosStatusWS".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEHistoricoStatusWS obj = com.br.client.model.vd.entity.eNFSEHistoricoStatusWS.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityEmitenteWS".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEEmitenteWS obj = com.br.client.model.vd.entity.eNFSEEmitenteWS.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityNfseStatusWS".equalsIgnoreCase(name) ){
			com.br.client.model.vd.entity.eNFSEStatusWS obj = com.br.client.model.vd.entity.eNFSEStatusWS.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.vd.vdw1000.FormBean newInstance(){
		return new com.br.client.model.vd.vdw1000.FormBean();
	}
}