package com.br.client.model.vd.entity;

public class eNFSEServicesConfiguration extends com.howmake.client.form.model.HowMGWTFormBean{
	public eNFSEServicesConfiguration(){
	}


	public String getStartSchedulerJobs(){
		return toString("startSchedulerJobs");
	}

	public void setStartSchedulerJobs(String value){
		setString("startSchedulerJobs",value);
	}


	public String getStartSchedulerJobsDate(){
		return toString("startSchedulerJobsDate");
	}

	public void setStartSchedulerJobsDate(String value){
		setString("startSchedulerJobsDate",value);
	}


	public String getInstanceNameScheduler(){
		return toString("instanceNameScheduler");
	}

	public void setInstanceNameScheduler(String value){
		setString("instanceNameScheduler",value);
	}


	public String getBasePath(){
		return toString("basePath");
	}

	public void setBasePath(String value){
		setString("basePath",value);
	}


	public String getUserID(){
		return toString("userID");
	}

	public void setUserID(String value){
		setString("userID",value);
	}


	public String getDateChange(){
		return toString("dateChange");
	}

	public void setDateChange(String value){
		setString("dateChange",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.vd.entity.eNFSEServicesConfiguration newInstance(){
		return new com.br.client.model.vd.entity.eNFSEServicesConfiguration();
	}
}