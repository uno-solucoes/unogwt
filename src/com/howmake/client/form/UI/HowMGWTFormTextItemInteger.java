package com.howmake.client.form.UI;

import com.howmake.client.form.partner.HowMGWTProperty;

public class HowMGWTFormTextItemInteger extends HowMGWTFormTextItem{

	public HowMGWTFormTextItemInteger(String name, String title, HowMGWTProperty property){
		super(name, title);
		
		property.configureInputInteger(this.getField());
	}
	
}
