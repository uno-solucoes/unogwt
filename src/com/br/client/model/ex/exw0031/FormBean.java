package com.br.client.model.ex.exw0031;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean {

	public FormBean(){
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


	public String getDestinatario(){
		return toString("destinatario");
	}

	public void setDestinatario(String value){
		setString("destinatario",value);
	}


	public com.br.client.model.sg.entity.eArquivoGED[] getArquivoGEDs(){
		Object obj = _self.get("arquivoGEDs");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.sg.entity.eArquivoGED[])obj;

	}

	public void setArquivoGEDs(com.br.client.model.sg.entity.eArquivoGED[] value){
		_self.remove("arquivoGEDs");
		if ( value != null )
			_self.put("arquivoGEDs", value);

	}


	public com.br.client.model.sg.entity.eDiretorioGED[] getDiretorioGEDs(){
		Object obj = _self.get("diretorioGEDs");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.sg.entity.eDiretorioGED[])obj;

	}

	public void setDiretorioGEDs(com.br.client.model.sg.entity.eDiretorioGED[] value){
		_self.remove("diretorioGEDs");
		if ( value != null )
			_self.put("diretorioGEDs", value);

	}


	public String getIndAnexar(){
		return toString("indAnexar");
	}

	public void setIndAnexar(String value){
		setString("indAnexar",value);
	}


	public String getIndUltimaRevisao(){
		return toString("indUltimaRevisao");
	}

	public void setIndUltimaRevisao(String value){
		setString("indUltimaRevisao",value);
	}


	public boolean getPermissaoExcluir(){
		return toBoolean("permissaoExcluir");
	}

	public void setPermissaoExcluir(boolean value){
		setBoolean("permissaoExcluir",value);
	}


	public String getEnviarPara(){
		return toString("enviarPara");
	}

	public void setEnviarPara(String value){
		setString("enviarPara",value);
	}


	public String getFindFilter(){
		return toString("findFilter");
	}

	public void setFindFilter(String value){
		setString("findFilter",value);
	}


	public com.br.client.model.sg.entity.eFileNode getEntityFileNode(){
		Object obj = _self.get("entityFileNode");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.sg.entity.eFileNode)obj;

	}

	public void setEntityFileNode(com.br.client.model.sg.entity.eFileNode value){
		_self.remove("entityFileNode");
		if ( value != null )
			_self.put("entityFileNode", value);

	}


	public com.br.client.model.sg.entity.eFileNode[] getEntityFileNodes(){
		Object obj = _self.get("entityFileNodes");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.sg.entity.eFileNode[])obj;

	}

	public void setEntityFileNodes(com.br.client.model.sg.entity.eFileNode[] value){
		_self.remove("entityFileNodes");
		if ( value != null )
			_self.put("entityFileNodes", value);

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
		if ( "arquivoGEDs".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eArquivoGED[] obj = new com.br.client.model.sg.entity.eArquivoGED[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.sg.entity.eArquivoGED)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "diretorioGEDs".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eDiretorioGED[] obj = new com.br.client.model.sg.entity.eDiretorioGED[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.sg.entity.eDiretorioGED)loadCustom(name, object.isObject());
				 
			}
		}
		if ( "entityFileNode".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eFileNode obj = new com.br.client.model.sg.entity.eFileNode();
			_self.put(name,obj);
		}
		if ( "entityFileNodes".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eFileNode[] obj = new com.br.client.model.sg.entity.eFileNode[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.sg.entity.eFileNode)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "arquivoGEDs".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eArquivoGED obj = com.br.client.model.sg.entity.eArquivoGED.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "diretorioGEDs".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eDiretorioGED obj = com.br.client.model.sg.entity.eDiretorioGED.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityFileNode".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eFileNode obj = com.br.client.model.sg.entity.eFileNode.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityFileNodes".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eFileNode obj = com.br.client.model.sg.entity.eFileNode.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.ex.exw0031.FormBean newInstance(){
		return new com.br.client.model.ex.exw0031.FormBean();
	}
	
}
