package com.br.client.model.sg.entity;

public class eFileNode extends com.howmake.client.form.model.HowMGWTFormBean{
	public eFileNode(){
	}


	public String getKey(){
		return toString("key");
	}

	public void setKey(String value){
		setString("key",value);
	}


	public String getParentKey(){
		return toString("parentKey");
	}

	public void setParentKey(String value){
		setString("parentKey",value);
	}


	public String getDescricao(){
		return toString("descricao");
	}

	public void setDescricao(String value){
		setString("descricao",value);
	}


	public String getIcon(){
		return toString("icon");
	}

	public void setIcon(String value){
		setString("icon",value);
	}


	public com.br.client.model.sg.entity.eDiretorioGED getEntityPasta(){
		Object obj = _self.get("entityPasta");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.sg.entity.eDiretorioGED)obj;

	}

	public void setEntityPasta(com.br.client.model.sg.entity.eDiretorioGED value){
		_self.remove("entityPasta");
		if ( value != null )
			_self.put("entityPasta", value);

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


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "entityPasta".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eDiretorioGED obj = new com.br.client.model.sg.entity.eDiretorioGED();
			_self.put(name,obj);
		}
		if ( "entityArquivo".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eArquivoGED obj = new com.br.client.model.sg.entity.eArquivoGED();
			_self.put(name,obj);
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "entityPasta".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eDiretorioGED obj = com.br.client.model.sg.entity.eDiretorioGED.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityArquivo".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eArquivoGED obj = com.br.client.model.sg.entity.eArquivoGED.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.sg.entity.eFileNode newInstance(){
		return new com.br.client.model.sg.entity.eFileNode();
	}
}