

package com.howmake.client.form.UI;

import com.smartgwt.client.widgets.IButton;

public class HowMGWTActionOK extends IButton{

	public HowMGWTActionOK(){
		
		this.setWidth(60);
		this.setTitle("OK");
		this.setIcon("actions/accept.png");
		
	}
	
	public HowMGWTActionOK(String text){
		super();
		this.setWidth(100);
		this.setTitle(text);
	}
	
}
