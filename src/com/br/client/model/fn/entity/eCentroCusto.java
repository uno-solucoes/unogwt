package com.br.client.model.fn.entity;

public class eCentroCusto extends com.howmake.client.form.model.HowMGWTFormBean{
	public eCentroCusto(){
	}


	public String getCentroCusto(){
		return toString("centroCusto");
	}

	public void setCentroCusto(String value){
		setString("centroCusto",value);
	}


	public String getDescAbrev(){
		return toString("descAbrev");
	}

	public void setDescAbrev(String value){
		setString("descAbrev",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
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


	public String getIndColaborador(){
		return toString("indColaborador");
	}

	public void setIndColaborador(String value){
		setString("indColaborador",value);
	}


	public String getSituacao(){
		return toString("situacao");
	}

	public void setSituacao(String value){
		setString("situacao",value);
	}


	public String getPerc(){
		return toString("perc");
	}

	public void setPerc(String value){
		setString("perc",value);
	}


	public String getCodObraRPS(){
		return toString("codObraRPS");
	}

	public void setCodObraRPS(String value){
		setString("codObraRPS",value);
	}


	public String getDtComprometida(){
		return toString("dtComprometida");
	}

	public void setDtComprometida(String value){
		setString("dtComprometida",value);
	}


	public String getDtConclusao(){
		return toString("dtConclusao");
	}

	public void setDtConclusao(String value){
		setString("dtConclusao",value);
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


	public String getCodArtRPS(){
		return toString("codArtRPS");
	}

	public void setCodArtRPS(String value){
		setString("codArtRPS",value);
	}


	public String getCodPedido(){
		return toString("codPedido");
	}

	public void setCodPedido(String value){
		setString("codPedido",value);
	}


	public String getTotalHorasContratadas(){
		return toString("totalHorasContratadas");
	}

	public void setTotalHorasContratadas(String value){
		setString("totalHorasContratadas",value);
	}


	public com.br.client.model.oc.entity.eCategoriaOcorrencia[] getCategorias(){
		Object obj = _self.get("categorias");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.oc.entity.eCategoriaOcorrencia[])obj;

	}

	public void setCategorias(com.br.client.model.oc.entity.eCategoriaOcorrencia[] value){
		_self.remove("categorias");
		if ( value != null )
			_self.put("categorias", value);

	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "categorias".equalsIgnoreCase(name) ){
			com.br.client.model.oc.entity.eCategoriaOcorrencia[] obj = new com.br.client.model.oc.entity.eCategoriaOcorrencia[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.oc.entity.eCategoriaOcorrencia)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "categorias".equalsIgnoreCase(name) ){
			com.br.client.model.oc.entity.eCategoriaOcorrencia obj = com.br.client.model.oc.entity.eCategoriaOcorrencia.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.fn.entity.eCentroCusto newInstance(){
		return new com.br.client.model.fn.entity.eCentroCusto();
	}
}