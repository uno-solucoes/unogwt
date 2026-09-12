package com.br.client.model.oc.entity;

public class eCategoriaOcorrencia extends com.howmake.client.form.model.HowMGWTFormBean{
	public eCategoriaOcorrencia(){
	}


	public String getCodCategoria(){
		return toString("codCategoria");
	}

	public void setCodCategoria(String value){
		setString("codCategoria",value);
	}


	public String getCodCategoriaPai(){
		return toString("codCategoriaPai");
	}

	public void setCodCategoriaPai(String value){
		setString("codCategoriaPai",value);
	}


	public String getNomeCategoria(){
		return toString("nomeCategoria");
	}

	public void setNomeCategoria(String value){
		setString("nomeCategoria",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getEmail(){
		return toString("email");
	}

	public void setEmail(String value){
		setString("email",value);
	}


	public String getExtranet(){
		return toString("extranet");
	}

	public void setExtranet(String value){
		setString("extranet",value);
	}


	public String getIndPainelCategoria(){
		return toString("indPainelCategoria");
	}

	public void setIndPainelCategoria(String value){
		setString("indPainelCategoria",value);
	}


	public String getSituacao(){
		return toString("situacao");
	}

	public void setSituacao(String value){
		setString("situacao",value);
	}


	public String getPrioridade(){
		return toString("prioridade");
	}

	public void setPrioridade(String value){
		setString("prioridade",value);
	}


	public String getTpOcorrencia(){
		return toString("tpOcorrencia");
	}

	public void setTpOcorrencia(String value){
		setString("tpOcorrencia",value);
	}


	public String getDtDeadline(){
		return toString("dtDeadline");
	}

	public void setDtDeadline(String value){
		setString("dtDeadline",value);
	}


	public int[] getStatusArquivos(){
		return toIntegerArray("statusArquivos");
	}

	public void setStatusArquivos(int[] value){
		setIntegerArray("statusArquivos",value);
	}


	public com.br.client.model.oc.entity.eCategoriaArquivo[] getArquivos(){
		Object obj = _self.get("arquivos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.oc.entity.eCategoriaArquivo[])obj;

	}

	public void setArquivos(com.br.client.model.oc.entity.eCategoriaArquivo[] value){
		_self.remove("arquivos");
		if ( value != null )
			_self.put("arquivos", value);

	}


	public com.br.client.model.oc.entity.eProblemaOcorrencia[] getProblemas(){
		Object obj = _self.get("problemas");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.oc.entity.eProblemaOcorrencia[])obj;

	}

	public void setProblemas(com.br.client.model.oc.entity.eProblemaOcorrencia[] value){
		_self.remove("problemas");
		if ( value != null )
			_self.put("problemas", value);

	}


	public com.br.client.model.oc.entity.eCategoriaProblemaOcorrencia[] getProblemasCategoria(){
		Object obj = _self.get("problemasCategoria");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.oc.entity.eCategoriaProblemaOcorrencia[])obj;

	}

	public void setProblemasCategoria(com.br.client.model.oc.entity.eCategoriaProblemaOcorrencia[] value){
		_self.remove("problemasCategoria");
		if ( value != null )
			_self.put("problemasCategoria", value);

	}


	public com.br.client.model.oc.entity.eCategoriaColaboradorOcorrencia[] getColaboradores(){
		Object obj = _self.get("colaboradores");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.oc.entity.eCategoriaColaboradorOcorrencia[])obj;

	}

	public void setColaboradores(com.br.client.model.oc.entity.eCategoriaColaboradorOcorrencia[] value){
		_self.remove("colaboradores");
		if ( value != null )
			_self.put("colaboradores", value);

	}


	public com.br.client.model.oc.entity.eFUPApontamento[] getApontamentos(){
		Object obj = _self.get("apontamentos");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.oc.entity.eFUPApontamento[])obj;

	}

	public void setApontamentos(com.br.client.model.oc.entity.eFUPApontamento[] value){
		_self.remove("apontamentos");
		if ( value != null )
			_self.put("apontamentos", value);

	}


	public String getTotalHoraNormal(){
		return toString("totalHoraNormal");
	}

	public void setTotalHoraNormal(String value){
		setString("totalHoraNormal",value);
	}


	public String getTotalHoraDiferenciada(){
		return toString("totalHoraDiferenciada");
	}

	public void setTotalHoraDiferenciada(String value){
		setString("totalHoraDiferenciada",value);
	}


	public String getTotalHoraTotal(){
		return toString("totalHoraTotal");
	}

	public void setTotalHoraTotal(String value){
		setString("totalHoraTotal",value);
	}


	public String getTpHora(){
		return toString("tpHora");
	}

	public void setTpHora(String value){
		setString("tpHora",value);
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


	public String getCcusto(){
		return toString("ccusto");
	}

	public void setCcusto(String value){
		setString("ccusto",value);
	}


	public String getTotalHorasContratadas(){
		return toString("totalHorasContratadas");
	}

	public void setTotalHorasContratadas(String value){
		setString("totalHorasContratadas",value);
	}


	public String getTotalHorasPrevistas(){
		return toString("totalHorasPrevistas");
	}

	public void setTotalHorasPrevistas(String value){
		setString("totalHorasPrevistas",value);
	}


	public com.br.client.model.oc.entity.eOcorrencia[] getOcorrencias(){
		Object obj = _self.get("ocorrencias");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.oc.entity.eOcorrencia[])obj;

	}

	public void setOcorrencias(com.br.client.model.oc.entity.eOcorrencia[] value){
		_self.remove("ocorrencias");
		if ( value != null )
			_self.put("ocorrencias", value);

	}


	public boolean getPai(){
		return toBoolean("pai");
	}

	public void setPai(boolean value){
		setBoolean("pai",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "statusArquivos".equalsIgnoreCase(name) ){
			int[] obj = new int[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isNumber()!= null )
					obj[i] = new Double(object.isNumber().doubleValue()).intValue();
				 
			}
		}
		if ( "arquivos".equalsIgnoreCase(name) ){
			com.br.client.model.oc.entity.eCategoriaArquivo[] obj = new com.br.client.model.oc.entity.eCategoriaArquivo[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.oc.entity.eCategoriaArquivo)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "problemas".equalsIgnoreCase(name) ){
			com.br.client.model.oc.entity.eProblemaOcorrencia[] obj = new com.br.client.model.oc.entity.eProblemaOcorrencia[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.oc.entity.eProblemaOcorrencia)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "problemasCategoria".equalsIgnoreCase(name) ){
			com.br.client.model.oc.entity.eCategoriaProblemaOcorrencia[] obj = new com.br.client.model.oc.entity.eCategoriaProblemaOcorrencia[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.oc.entity.eCategoriaProblemaOcorrencia)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "colaboradores".equalsIgnoreCase(name) ){
			com.br.client.model.oc.entity.eCategoriaColaboradorOcorrencia[] obj = new com.br.client.model.oc.entity.eCategoriaColaboradorOcorrencia[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.oc.entity.eCategoriaColaboradorOcorrencia)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "apontamentos".equalsIgnoreCase(name) ){
			com.br.client.model.oc.entity.eFUPApontamento[] obj = new com.br.client.model.oc.entity.eFUPApontamento[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.oc.entity.eFUPApontamento)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "ocorrencias".equalsIgnoreCase(name) ){
			com.br.client.model.oc.entity.eOcorrencia[] obj = new com.br.client.model.oc.entity.eOcorrencia[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.oc.entity.eOcorrencia)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "arquivos".equalsIgnoreCase(name) ){
			com.br.client.model.oc.entity.eCategoriaArquivo obj = com.br.client.model.oc.entity.eCategoriaArquivo.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "problemas".equalsIgnoreCase(name) ){
			com.br.client.model.oc.entity.eProblemaOcorrencia obj = com.br.client.model.oc.entity.eProblemaOcorrencia.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "problemasCategoria".equalsIgnoreCase(name) ){
			com.br.client.model.oc.entity.eCategoriaProblemaOcorrencia obj = com.br.client.model.oc.entity.eCategoriaProblemaOcorrencia.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "colaboradores".equalsIgnoreCase(name) ){
			com.br.client.model.oc.entity.eCategoriaColaboradorOcorrencia obj = com.br.client.model.oc.entity.eCategoriaColaboradorOcorrencia.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "apontamentos".equalsIgnoreCase(name) ){
			com.br.client.model.oc.entity.eFUPApontamento obj = com.br.client.model.oc.entity.eFUPApontamento.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "ocorrencias".equalsIgnoreCase(name) ){
			com.br.client.model.oc.entity.eOcorrencia obj = com.br.client.model.oc.entity.eOcorrencia.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.oc.entity.eCategoriaOcorrencia newInstance(){
		return new com.br.client.model.oc.entity.eCategoriaOcorrencia();
	}
}