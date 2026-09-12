package com.howmake.client.form.UI;

import com.howmake.client.form.partner.HowMGWTProperty;

public class HowMGWTGridTextItemMoney extends HowMGWTGridTextItem{

	public HowMGWTGridTextItemMoney( String name, String title, HowMGWTProperty property){
		super(name, title);		
		property.configureInputDecimal(getField(), "#,##0.00");
	}
	
	public HowMGWTGridTextItemMoney( String name, String title, HowMGWTProperty property, String mask){
		super(name, title);		
		property.configureInputDecimal(getField(), mask);
	}
	
}
