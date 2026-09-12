package com.howmake.client.form.model;

import com.howmake.shared.HowMGWTEntity;

public interface HowMGWTCall {
	
	public boolean onFailure(Throwable caught);
	
	public void onSuccess(HowMGWTEntity result);
	
}
