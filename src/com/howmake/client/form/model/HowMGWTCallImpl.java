package com.howmake.client.form.model;

public abstract  class HowMGWTCallImpl implements HowMGWTCall{
	@Override
	public boolean onFailure(Throwable caught){
		return true;
	}	
}