package com.br.client.model.sg.entity;

public class eFile extends com.howmake.client.form.model.HowMGWTFormBean{
	public eFile(){
	}


	public int getSTORE_TYPE_FILE(){
		return toInteger("STORE_TYPE_FILE");
	}

	public void setSTORE_TYPE_FILE(int value){
		setInteger("STORE_TYPE_FILE",value);
	}


	public int getSTORE_TYPE_DIRECTORY(){
		return toInteger("STORE_TYPE_DIRECTORY");
	}

	public void setSTORE_TYPE_DIRECTORY(int value){
		setInteger("STORE_TYPE_DIRECTORY",value);
	}


	public int getSTORE_TYPE_LINK(){
		return toInteger("STORE_TYPE_LINK");
	}

	public void setSTORE_TYPE_LINK(int value){
		setInteger("STORE_TYPE_LINK",value);
	}


	public String getOwner(){
		return toString("owner");
	}

	public void setOwner(String value){
		setString("owner",value);
	}


	public String getName(){
		return toString("name");
	}

	public void setName(String value){
		setString("name",value);
	}


	public String getPath(){
		return toString("path");
	}

	public void setPath(String value){
		setString("path",value);
	}


	public String getType(){
		return toString("type");
	}

	public void setType(String value){
		setString("type",value);
	}


	public String getSize(){
		return toString("size");
	}

	public void setSize(String value){
		setString("size",value);
	}


	public String getSelected(){
		return toString("selected");
	}

	public void setSelected(String value){
		setString("selected",value);
	}


	public String getPrivilegies(){
		return toString("privilegies");
	}

	public void setPrivilegies(String value){
		setString("privilegies",value);
	}


	public String getStoreType(){
		return toString("storeType");
	}

	public void setStoreType(String value){
		setString("storeType",value);
	}


	public com.br.client.model.sg.entity.eFile getParentFile(){
		Object obj = _self.get("parentFile");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.sg.entity.eFile)obj;

	}

	public void setParentFile(com.br.client.model.sg.entity.eFile value){
		_self.remove("parentFile");
		if ( value != null )
			_self.put("parentFile", value);

	}


	public com.br.client.model.sg.entity.eFile[] getListFiles(){
		Object obj = _self.get("listFiles");
		if ( obj == null )
			return null;
		else
			return (com.br.client.model.sg.entity.eFile[])obj;

	}

	public void setListFiles(com.br.client.model.sg.entity.eFile[] value){
		_self.remove("listFiles");
		if ( value != null )
			_self.put("listFiles", value);

	}


	public boolean getError(){
		return toBoolean("error");
	}

	public void setError(boolean value){
		setBoolean("error",value);
	}


	public String getMessage(){
		return toString("message");
	}

	public void setMessage(String value){
		setString("message",value);
	}


	public String getDeleted(){
		return toString("deleted");
	}

	public void setDeleted(String value){
		setString("deleted",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
		if ( "parentFile".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eFile obj = new com.br.client.model.sg.entity.eFile();
			_self.put(name,obj);
		}
		if ( "listFiles".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eFile[] obj = new com.br.client.model.sg.entity.eFile[array.size()];
			_self.put(name,obj);
			for ( int i = 0 ; i < array.size(); i ++ ){
				com.google.gwt.json.client.JSONValue object = array.get(i);
				if ( object.isObject() != null )
					obj[i] = (com.br.client.model.sg.entity.eFile)loadCustom(name, object.isObject());
				 
			}
		}
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		if ( "parentFile".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eFile obj = com.br.client.model.sg.entity.eFile.newInstance();
			obj.load(null , value);
			return obj;
		}
		if ( "listFiles".equalsIgnoreCase(name) ){
			com.br.client.model.sg.entity.eFile obj = com.br.client.model.sg.entity.eFile.newInstance();
			obj.load(null , value);
			return obj;
		}
		return null;
	}


	public static final com.br.client.model.sg.entity.eFile newInstance(){
		return new com.br.client.model.sg.entity.eFile();
	}
}