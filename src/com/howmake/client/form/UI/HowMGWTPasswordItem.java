package com.howmake.client.form.UI;

import com.howmake.client.form.partner.HowMGWTFormField;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class HowMGWTPasswordItem extends DynamicForm implements HowMGWTFormField{

	private PasswordItem  field = new PasswordItem();

	public HowMGWTPasswordItem(){		
		this.setItems(this.field);
	}

	public HowMGWTPasswordItem(String name, String title){
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
	public void setField(PasswordItem field) {
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
