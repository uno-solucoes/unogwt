package com.howmake.client.form.model.entity;

 
public class HowMGWTPageCache extends com.howmake.client.form.model.HowMGWTFormBean{
	public HowMGWTPageCache(){
	}


	public String getAction(){
		return toString("action");
	}

	public void setAction(String value){
		setString("action",value);
	}


	public String getFirstRecord(){
		return toString("firstRecord");
	}

	public void setFirstRecord(String value){
		setString("firstRecord",value);
	}


	public String getLastRecord(){
		return toString("lastRecord");
	}

	public void setLastRecord(String value){
		setString("lastRecord",value);
	}


	public String getCurrentRecord(){
		return toString("currentRecord");
	}

	public void setCurrentRecord(String value){
		setString("currentRecord",value);
	}


	public String getPageSize(){
		return toString("pageSize");
	}

	public void setPageSize(String value){
		setString("pageSize",value);
	}


	public String getMaxRecords(){
		return toString("maxRecords");
	}

	public void setMaxRecords(String value){
		setString("maxRecords",value);
	}
 
}