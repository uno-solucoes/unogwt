package com.br.client.model.oc.entity;

public class eCategoriaArquivo extends com.howmake.client.form.model.HowMGWTFormBean{
	public eCategoriaArquivo(){
	}


	public String getCodCategoria(){
		return toString("codCategoria");
	}

	public void setCodCategoria(String value){
		setString("codCategoria",value);
	}


	public String getCodArq(){
		return toString("codArq");
	}

	public void setCodArq(String value){
		setString("codArq",value);
	}


	public String getArquivo(){
		return toString("arquivo");
	}

	public void setArquivo(String value){
		setString("arquivo",value);
	}


	public String getNomeArquivo(){
		return toString("nomeArquivo");
	}

	public void setNomeArquivo(String value){
		setString("nomeArquivo",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public int[] getStatusArquivo(){
		return toIntegerArray("statusArquivo");
	}

	public void setStatusArquivo(int[] value){
		setIntegerArray("statusArquivo",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "statusArquivo".equalsIgnoreCase(name) ){
			int[] obj = new int[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isNumber()!= null )
					obj[i] = new Double(object.isNumber().doubleValue()).intValue();
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.oc.entity.eCategoriaArquivo newInstance(){
		return new com.br.client.model.oc.entity.eCategoriaArquivo();
	}
}