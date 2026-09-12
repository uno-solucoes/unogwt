package com.howmake.client.form.UI;

import com.howmake.client.form.partner.HowMGWTFormField;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class HowMGWTGridTextItem implements HowMGWTFormField{

	private TextItem field = new TextItem();

	public HowMGWTGridTextItem(){		
 
	}
	public HowMGWTGridTextItem(String name, String title){
		this();
		this.field.setName(name);
		this.field.setTitle(title);
	}
	
	/**
	 * @return the field
	 */
	public TextItem getField() {
		return field;
	}
	/**
	 * @param field the field to set
	 */
	public void setField(TextItem field) {
		this.field = field;
	}
	
	public void setHowMValue(Object value){
		this.field.setValue(value);
	}
	
	public Object getHowMValue(){
		return this.field.getValue();
	}
	
	public String getHowMValueAsString(){
		return this.field.getValueAsString();
	}

	public void setHowMBound(int widthLabel, int widthField){
 
	}
	
	public void setHowMDisable(Boolean disabled){
 
	}

	public void setHowMBound(int widthLabel){
 
	}
	
	public void setHowMFocusInItem(){
		this.field.focusInItem();
	}
	
	public void setHowMLabelTitle(String label){
		this.field.setTitle(label);
	}
	
	
	public String getHowMLabelTitle(){
		return this.field.getTitle();
	}
	

	public DynamicForm getHowMForm(){
		return null;
	}

	public void howMFocusInItem() {
	}
 
}
