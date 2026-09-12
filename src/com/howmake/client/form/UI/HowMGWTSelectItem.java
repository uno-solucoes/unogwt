package com.howmake.client.form.UI;

import com.howmake.client.form.partner.HowMGWTFormField;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;

public class HowMGWTSelectItem extends DynamicForm implements HowMGWTFormField{
	
	private SelectItem field = new SelectItem();
	

	public HowMGWTSelectItem(){		
		this.setItems(this.field);
	}
	public HowMGWTSelectItem(String name, String title){
		this();
		this.field.setName(name);
		this.field.setTitle(title);
	}
	/**
	 * @return the field
	 */
	public SelectItem getField() {
		return field;
	}
	/**
	 * @param field the field to set
	 */
	public void setField(SelectItem field) {
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