package com.howmake.client.form.UI;

import com.google.gwt.core.client.Scheduler;
import com.howmake.client.form.partner.HowMGWTFormField;
import com.smartgwt.client.types.TextAreaWrap;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;

public class HowMGWTFormTextAreaItem extends DynamicForm implements HowMGWTFormField{

	private TextAreaItem field = new TextAreaItem();

	public HowMGWTFormTextAreaItem(){
        field.setWidth("*");  
        field.setHeight("*");  	
		field.setWrap(TextAreaWrap.OFF);
		this.setNumCols(1);
		this.setItems(this.field);
        this.setColWidths("*");      
        
	}
	public HowMGWTFormTextAreaItem(String name, String title){
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
	
	
	public void setHowMBound(int widthLabel){
		this.setTitleWidth(widthLabel);
		this.setWidth100();
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
		return this;
	}


	public void howMFocusInItem() {
		// --------------------------------------------------------------------------------
		// Schedula a entrada de focus para após a montagem da tela.
		// --------------------------------------------------------------------------------
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {			
			public void execute() {				
				getField().focusInItem();				
			}
		});	
		// --------------------------------------------------------------------------------
	}
 

}
