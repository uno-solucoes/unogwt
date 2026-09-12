package com.br.client.model.sg.sgw1000;

public class FormBean extends com.howmake.client.form.model.HowMGWTFormBean{
	public FormBean(){
	}


	public com.br.client.model.sg.entity.eVersaoLiberada getEntityVersaoLiberada(){
		Object obj = _self.get("entityVersaoLiberada");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.sg.entity.eVersaoLiberada)obj;

	}

	public void setEntityVersaoLiberada(com.br.client.model.sg.entity.eVersaoLiberada value){
		_self.remove("entityVersaoLiberada");
		if ( value != null )
			_self.put("entityVersaoLiberada", value);

	}


	public com.br.client.model.sg.entity.eVersaoLiberada[] getEntityVersoesLiberadas(){
		Object obj = _self.get("entityVersoesLiberadas");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.sg.entity.eVersaoLiberada[])obj;

	}

	public void setEntityVersoesLiberadas(com.br.client.model.sg.entity.eVersaoLiberada[] value){
		_self.remove("entityVersoesLiberadas");
		if ( value != null )
			_self.put("entityVersoesLiberadas", value);

	}


	public String getVersaoAtualBaseDados(){
		return toString("versaoAtualBaseDados");
	}

	public void setVersaoAtualBaseDados(String value){
		setString("versaoAtualBaseDados",value);
	}


	public String getVersaoAtualUCommerce(){
		return toString("versaoAtualUCommerce");
	}

	public void setVersaoAtualUCommerce(String value){
		setString("versaoAtualUCommerce",value);
	}


	public String getVersaoAtualRevenda(){
		return toString("versaoAtualRevenda");
	}

	public void setVersaoAtualRevenda(String value){
		setString("versaoAtualRevenda",value);
	}


	public String getVersaoAtualExtranet(){
		return toString("versaoAtualExtranet");
	}

	public void setVersaoAtualExtranet(String value){
		setString("versaoAtualExtranet",value);
	}


	public String getVersaoAtualBoleto(){
		return toString("versaoAtualBoleto");
	}

	public void setVersaoAtualBoleto(String value){
		setString("versaoAtualBoleto",value);
	}


	public String getVersaoAtualEis(){
		return toString("versaoAtualEis");
	}

	public void setVersaoAtualEis(String value){
		setString("versaoAtualEis",value);
	}


	public String getVersaoAtualJDK(){
		return toString("versaoAtualJDK");
	}

	public void setVersaoAtualJDK(String value){
		setString("versaoAtualJDK",value);
	}


	public String getVersaoAtualTomcat(){
		return toString("versaoAtualTomcat");
	}

	public void setVersaoAtualTomcat(String value){
		setString("versaoAtualTomcat",value);
	}


	public String getVersaoAtualCMS(){
		return toString("versaoAtualCMS");
	}

	public void setVersaoAtualCMS(String value){
		setString("versaoAtualCMS",value);
	}


	public String getIndRevenda(){
		return toString("indRevenda");
	}

	public void setIndRevenda(String value){
		setString("indRevenda",value);
	}


	public String getIndExtranet(){
		return toString("indExtranet");
	}

	public void setIndExtranet(String value){
		setString("indExtranet",value);
	}


	public String getIndEis(){
		return toString("indEis");
	}

	public void setIndEis(String value){
		setString("indEis",value);
	}


	public String getIndBoleto(){
		return toString("indBoleto");
	}

	public void setIndBoleto(String value){
		setString("indBoleto",value);
	}


	public String getIndJdk(){
		return toString("indJdk");
	}

	public void setIndJdk(String value){
		setString("indJdk",value);
	}


	public String getIndTomcat(){
		return toString("indTomcat");
	}

	public void setIndTomcat(String value){
		setString("indTomcat",value);
	}


	public String getIndCMS(){
		return toString("indCMS");
	}

	public void setIndCMS(String value){
		setString("indCMS",value);
	}


	public String getNomeCliente(){
		return toString("nomeCliente");
	}

	public void setNomeCliente(String value){
		setString("nomeCliente",value);
	}


	public String getTempDir(){
		return toString("tempDir");
	}

	public void setTempDir(String value){
		setString("tempDir",value);
	}


	public String getPathUCommerce(){
		return toString("pathUCommerce");
	}

	public void setPathUCommerce(String value){
		setString("pathUCommerce",value);
	}


	public String getUserMySql(){
		return toString("userMySql");
	}

	public void setUserMySql(String value){
		setString("userMySql",value);
	}


	public String getPassMySql(){
		return toString("passMySql");
	}

	public void setPassMySql(String value){
		setString("passMySql",value);
	}


	public String getPathBoleto(){
		return toString("pathBoleto");
	}

	public void setPathBoleto(String value){
		setString("pathBoleto",value);
	}


	public String getCodClienteUC(){
		return toString("codClienteUC");
	}

	public void setCodClienteUC(String value){
		setString("codClienteUC",value);
	}


	public String getCaminhoBackup(){
		return toString("caminhoBackup");
	}

	public void setCaminhoBackup(String value){
		setString("caminhoBackup",value);
	}


	public String getIpServidor(){
		return toString("ipServidor");
	}

	public void setIpServidor(String value){
		setString("ipServidor",value);
	}


	public String getPortaAtualizador(){
		return toString("portaAtualizador");
	}

	public void setPortaAtualizador(String value){
		setString("portaAtualizador",value);
	}


	public String getAplicacao(){
		return toString("aplicacao");
	}

	public void setAplicacao(String value){
		setString("aplicacao",value);
	}


	public String getTxtAtualizador(){
		return toString("txtAtualizador");
	}

	public void setTxtAtualizador(String value){
		setString("txtAtualizador",value);
	}


	public String getIdUsuario(){
		return toString("idUsuario");
	}

	public void setIdUsuario(String value){
		setString("idUsuario",value);
	}


	public String getUrl(){
		return toString("url");
	}

	public void setUrl(String value){
		setString("url",value);
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
		if ( "entityVersaoLiberada".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eVersaoLiberada obj = new com.br.client.model.sg.entity.eVersaoLiberada();
			_self.put(name,obj);
		}
		if ( "entityVersoesLiberadas".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eVersaoLiberada[] obj = new com.br.client.model.sg.entity.eVersaoLiberada[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.sg.entity.eVersaoLiberada)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "entityVersaoLiberada".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eVersaoLiberada obj = com.br.client.model.sg.entity.eVersaoLiberada.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "entityVersoesLiberadas".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eVersaoLiberada obj = com.br.client.model.sg.entity.eVersaoLiberada.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.sg.sgw1000.FormBean newInstance(){
		return new com.br.client.model.sg.sgw1000.FormBean();
	}
}