package com.br.client.model.sg.entity;

public class eDiretorioGED extends com.howmake.client.form.model.HowMGWTFormBean{
	public eDiretorioGED(){
	}


	public String getCodDiretorio(){
		return toString("codDiretorio");
	}

	public void setCodDiretorio(String value){
		setString("codDiretorio",value);
	}


	public String getCodDiretorioPai(){
		return toString("codDiretorioPai");
	}

	public void setCodDiretorioPai(String value){
		setString("codDiretorioPai",value);
	}


	public String getNomeDiretorio(){
		return toString("nomeDiretorio");
	}

	public void setNomeDiretorio(String value){
		setString("nomeDiretorio",value);
	}


	public String getSituacao(){
		return toString("situacao");
	}

	public void setSituacao(String value){
		setString("situacao",value);
	}


	public String getCodColaboradorImplant(){
		return toString("codColaboradorImplant");
	}

	public void setCodColaboradorImplant(String value){
		setString("codColaboradorImplant",value);
	}


	public String getCodColaborador(){
		return toString("codColaborador");
	}

	public void setCodColaborador(String value){
		setString("codColaborador",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getPath(){
		return toString("path");
	}

	public void setPath(String value){
		setString("path",value);
	}


	public String getOrigem(){
		return toString("origem");
	}

	public void setOrigem(String value){
		setString("origem",value);
	}


	public String getQtdArquivos(){
		return toString("qtdArquivos");
	}

	public void setQtdArquivos(String value){
		setString("qtdArquivos",value);
	}


	public com.br.client.model.sg.entity.eParticipanteDiretorioGED[] getParticipanteDiretorioGEDs(){
		Object obj = _self.get("participanteDiretorioGEDs");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.sg.entity.eParticipanteDiretorioGED[])obj;

	}

	public void setParticipanteDiretorioGEDs(com.br.client.model.sg.entity.eParticipanteDiretorioGED[] value){
		_self.remove("participanteDiretorioGEDs");
		if ( value != null )
			_self.put("participanteDiretorioGEDs", value);

	}


	public String getIndTodosParticipantes(){
		return toString("indTodosParticipantes");
	}

	public void setIndTodosParticipantes(String value){
		setString("indTodosParticipantes",value);
	}


	public String getAbsolutePath(){
		return toString("absolutePath");
	}

	public void setAbsolutePath(String value){
		setString("absolutePath",value);
	}


	public String getIndVisitado(){
		return toString("indVisitado");
	}

	public void setIndVisitado(String value){
		setString("indVisitado",value);
	}


	public com.br.client.model.sg.entity.eArquivoGED getEntityArquivo(){
		Object obj = _self.get("entityArquivo");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.sg.entity.eArquivoGED)obj;

	}

	public void setEntityArquivo(com.br.client.model.sg.entity.eArquivoGED value){
		_self.remove("entityArquivo");
		if ( value != null )
			_self.put("entityArquivo", value);

	}


	public com.br.client.model.sg.entity.eArquivoGED[] getEntityArquivos(){
		Object obj = _self.get("entityArquivos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.sg.entity.eArquivoGED[])obj;

	}

	public void setEntityArquivos(com.br.client.model.sg.entity.eArquivoGED[] value){
		_self.remove("entityArquivos");
		if ( value != null )
			_self.put("entityArquivos", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "participanteDiretorioGEDs".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eParticipanteDiretorioGED[] obj = new com.br.client.model.sg.entity.eParticipanteDiretorioGED[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.sg.entity.eParticipanteDiretorioGED)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "entityArquivo".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eArquivoGED obj = new com.br.client.model.sg.entity.eArquivoGED();
			_self.put(name,obj);
		}
		if ( "entityArquivos".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eArquivoGED[] obj = new com.br.client.model.sg.entity.eArquivoGED[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.sg.entity.eArquivoGED)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "participanteDiretorioGEDs".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eParticipanteDiretorioGED obj = com.br.client.model.sg.entity.eParticipanteDiretorioGED.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityArquivo".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eArquivoGED obj = com.br.client.model.sg.entity.eArquivoGED.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityArquivos".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eArquivoGED obj = com.br.client.model.sg.entity.eArquivoGED.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.sg.entity.eDiretorioGED newInstance(){
		return new com.br.client.model.sg.entity.eDiretorioGED();
	}
}