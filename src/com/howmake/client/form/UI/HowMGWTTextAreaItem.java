package com.howmake.client.form.UI;

import com.howmake.client.form.partner.HowMGWTFormField;
import com.smartgwt.client.types.TextAreaWrap;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;

public class HowMGWTTextAreaItem extends DynamicForm implements HowMGWTFormField{

	private TextAreaItem field = new TextAreaItem();

	public HowMGWTTextAreaItem(){
        field.setWidth("*");  
        field.setHeight("*");  	
		field.setWrap(TextAreaWrap.OFF);
		this.setNumCols(1);
		this.setItems(this.field);
        this.setColWidths("*");        
	}
	public HowMGWTTextAreaItem(String name, String title){
		this();
		this.field.setName(name);
		this.field.setTitle(title);
		
	}
	
	/**
	 * @return the field
	 */
	public TextAreaItem getField() {
		return field;
	}
	/**
	 * @param field the field to set
	 */
	public void setField(TextAreaItem field) {
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
		this.setTitleWidth(widthLabel);
		this.getField().setWidth(widthField);
		this.setWidth(widthLabel+widthField+6);
	}
	
	public void setHowMDisable(Boolean disabled){
		// this.getField().setDisabled(disabled);
		this.setDisabled(disabled);
	}
	
	
	public String getHowMLabelTitle(){
		return this.field.getTitle();
	}
}

