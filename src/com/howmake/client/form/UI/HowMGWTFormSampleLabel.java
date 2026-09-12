package com.howmake.client.form.UI;

import com.howmake.client.form.partner.HowMGWTFormField;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;

public class HowMGWTFormSampleLabel extends Label implements HowMGWTFormField{

	public HowMGWTFormSampleLabel(){
		this.setHeight(22);
		this.setAlign(Alignment.CENTER);	
	}

	public HowMGWTFormSampleLabel(String contents){
		super();
		this.setHeight(22);
		this.setAlign(Alignment.CENTER);
		this.setContents(contents);
	}
	
	public void setHowMValue(Object value){
		if ( value != null ){
			String text = value.toString();
			if ( HowMGWTUtilities.isEmpty( text )){
				this.setContents("");
				return;
			}
			this.setContents(value.toString());
			return;
		}		
		this.setContents("");
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
	
	
	public void setHowMBound(int widthLabel){
		this.setWidth(widthLabel);
	}	
	
	public void setHowMFocusInItem(){
	}
	
	public void setHowMLabelTitle(String label){
		 
	}
	
	
	public String getHowMLabelTitle(){
		return "";
	}

	
	public DynamicForm getHowMForm(){
		return null;
	}

	public void howMFocusInItem() {
	}
 
	
}