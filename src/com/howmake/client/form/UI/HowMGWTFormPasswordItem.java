package com.howmake.client.form.UI;

import com.google.gwt.core.client.Scheduler;
import com.howmake.client.form.partner.HowMGWTFormField;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class HowMGWTFormPasswordItem extends DynamicForm implements HowMGWTFormField{

	private PasswordItem  field = new PasswordItem();

	public HowMGWTFormPasswordItem(){		
		this.setItems(this.field);
	}

	public HowMGWTFormPasswordItem(String name, String title){
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
