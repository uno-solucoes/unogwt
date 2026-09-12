package com.br.client.model.cd.entity;

public class eProdutoArquivo extends com.howmake.client.form.model.HowMGWTFormBean{
	public eProdutoArquivo(){
	}


	public String getCodProduto(){
		return toString("codProduto");
	}

	public void setCodProduto(String value){
		setString("codProduto",value);
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


	public String getIndAnexaCompra(){
		return toString("indAnexaCompra");
	}

	public void setIndAnexaCompra(String value){
		setString("indAnexaCompra",value);
	}


	public String getIndAnexaVenda(){
		return toString("indAnexaVenda");
	}

	public void setIndAnexaVenda(String value){
		setString("indAnexaVenda",value);
	}


	public int getGed(){
		return toInteger("ged");
	}

	public void setGed(int value){
		setInteger("ged",value);
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


	public static final com.br.client.model.cd.entity.eProdutoArquivo newInstance(){
		return new com.br.client.model.cd.entity.eProdutoArquivo();
	}
}