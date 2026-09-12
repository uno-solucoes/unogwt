package com.howmake.client.form.UI;

import com.howmake.client.form.partner.HowMGWTFormField;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.ContentsType;
import com.smartgwt.client.widgets.HTMLPane;

public class HowMGWTLabel extends HTMLPane implements HowMGWTFormField{

	public HowMGWTLabel(){
		this.setContentsType(ContentsType.FRAGMENT);	
	}

	public HowMGWTLabel(String contents){
		super();
		this.setContents(contents);
	}
	
	public void setHowMValue(Object value){
		if ( value != null ){
			String text = value.toString();
//			text = HowMGWTUtilities.replace(text, "&nbsp;", "");
//			text = HowMGWTUtilities.replace(text, "<B>", "");
//			text = HowMGWTUtilities.replace(text, "</B>", "");
//			text = HowMGWTUtilities.replace(text, "<b>", "");
//			text = HowMGWTUtilities.replace(text, "</b>", "");
//		
			if ( HowMGWTUtilities.isEmpty( text )){
				this.setContents(" ");
				return;
			}
			this.setContents(value.toString());
			return;
		}		
		this.setContents(" ");
	}
	
	public Object getHowMValue(){
		return this.getContents();
	}
	
	public Object getHowMValueNoTag(){
		String text = this.getContents();
		return text;
	}

	public String getHowMValueAsString(){
		return this.getContents();
	}
	
	public void setHowMBound(int widthLabel, int widthField){
		this.setWidth(widthLabel);
	}
	
	public void setHowMDisable(Boolean disabled){
		this.setDisabled(disabled);
	}
	
	public String getHowMLabelTitle(){
		return this.getContents();
	}
}