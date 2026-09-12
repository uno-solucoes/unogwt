package com.howmake.client.form.UI;

import com.howmake.client.form.partner.HowMGWTProperty;

public class HowMGWTFormTextItemMoney extends HowMGWTFormTextItem{

	public HowMGWTFormTextItemMoney( String name, String title, HowMGWTProperty property){
		super(name, title);		
		property.configureInputDecimal(getField(), "#,##0.00");		
	}
}
