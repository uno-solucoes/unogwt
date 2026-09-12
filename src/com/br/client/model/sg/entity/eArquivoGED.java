package com.br.client.model.sg.entity;

public class eArquivoGED extends com.howmake.client.form.model.HowMGWTFormBean{
	public eArquivoGED(){
	}


	public String getCodArquivo(){
		return toString("codArquivo");
	}

	public void setCodArquivo(String value){
		setString("codArquivo",value);
	}


	public String getNomeArquivo(){
		return toString("nomeArquivo");
	}

	public void setNomeArquivo(String value){
		setString("nomeArquivo",value);
	}


	public String getVersaoArquivo(){
		return toString("versaoArquivo");
	}

	public void setVersaoArquivo(String value){
		setString("versaoArquivo",value);
	}


	public String getArquivo(){
		return toString("arquivo");
	}

	public void setArquivo(String value){
		setString("arquivo",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getCodDiretorio(){
		return toString("codDiretorio");
	}

	public void setCodDiretorio(String value){
		setString("codDiretorio",value);
	}


	public String getNomeDiretorio(){
		return toString("nomeDiretorio");
	}

	public void setNomeDiretorio(String value){
		setString("nomeDiretorio",value);
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


	public String getIdUsuario(){
		return toString("idUsuario");
	}

	public void setIdUsuario(String value){
		setString("idUsuario",value);
	}


	public String getData(){
		return toString("data");
	}

	public void setData(String value){
		setString("data",value);
	}


	public String getTpAcao(){
		return toString("tpAcao");
	}

	public void setTpAcao(String value){
		setString("tpAcao",value);
	}


	public String getCodOportunidade(){
		return toString("codOportunidade");
	}

	public void setCodOportunidade(String value){
		setString("codOportunidade",value);
	}


	public String getRevisao(){
		return toString("revisao");
	}

	public void setRevisao(String value){
		setString("revisao",value);
	}


	public String getAbsolutePath(){
		return toString("absolutePath");
	}

	public void setAbsolutePath(String value){
		setString("absolutePath",value);
	}


	public com.br.client.model.sg.entity.eArquivoGEDLog[] getArquivoGEDLogs(){
		Object obj = _self.get("arquivoGEDLogs");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.sg.entity.eArquivoGEDLog[])obj;

	}

	public void setArquivoGEDLogs(com.br.client.model.sg.entity.eArquivoGEDLog[] value){
		_self.remove("arquivoGEDLogs");
		if ( value != null )
			_self.put("arquivoGEDLogs", value);

	}


	public com.br.client.model.sg.entity.eDiretorioGED getEntityDiretorioGED(){
		Object obj = _self.get("entityDiretorioGED");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.sg.entity.eDiretorioGED)obj;

	}

	public void setEntityDiretorioGED(com.br.client.model.sg.entity.eDiretorioGED value){
		_self.remove("entityDiretorioGED");
		if ( value != null )
			_self.put("entityDiretorioGED", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "arquivoGEDLogs".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eArquivoGEDLog[] obj = new com.br.client.model.sg.entity.eArquivoGEDLog[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.sg.entity.eArquivoGEDLog)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "entityDiretorioGED".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eDiretorioGED obj = new com.br.client.model.sg.entity.eDiretorioGED();
			_self.put(name,obj);
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "arquivoGEDLogs".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eArquivoGEDLog obj = com.br.client.model.sg.entity.eArquivoGEDLog.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityDiretorioGED".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eDiretorioGED obj = com.br.client.model.sg.entity.eDiretorioGED.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.sg.entity.eArquivoGED newInstance(){
		return new com.br.client.model.sg.entity.eArquivoGED();
	}
}