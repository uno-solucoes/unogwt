package com.howmake.client.form.UI;

import com.google.gwt.core.client.Scheduler;
import com.howmake.client.form.partner.HowMGWTFormField;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.FormItem;

public class HowMGWTFormCheckboxItem extends DynamicForm implements HowMGWTFormField{
 
	private CheckboxItem field = new CheckboxItem();

	private String howMSelectValue;
	private String howMUnselectValue;
	
	public HowMGWTFormCheckboxItem(){		
		this.setItems(this.field);
	}
	public HowMGWTFormCheckboxItem(String name, String title){
		this();
		this.field.setName(name);
		this.field.setTitle(title);
	}
	
	/**
	 * @return the field
	 */
	public CheckboxItem getField() {
		return field;
	}
	/**
	 * @param field the field to set
	 */
	public void setField(CheckboxItem field) {
		this.field = field;
	}
	
	public void setHowMValue(Object value){
	
		if( ! HowMGWTUtilities.isEmpty(this.getHowMUnselectValue()) || ! HowMGWTUtilities.isEmpty(this.getHowMSelectValue())){
			 		
			if (  HowMGWTUtilities.isEquals(HowMGWTUtilities.getCBoolean(value), this.getHowMSelectValue() ))
				this.field.setValue(true);
			else if ( HowMGWTUtilities.isEquals(value, this.getHowMUnselectValue() ))
				this.field.setValue(false);
			else 
				this.field.setValue(false);
		}			
		else
			this.field.setValue(value);
		
	}
	
	public Object getHowMValue(){

		if( !HowMGWTUtilities.isEmpty(this.getHowMUnselectValue()) || !HowMGWTUtilities.isEmpty(this.getHowMSelectValue())){
			
			if( this.field.getValueAsBoolean().booleanValue() ){
				if ( ! HowMGWTUtilities.isEmpty( this.getHowMSelectValue() ) )
					return this.getHowMSelectValue();
				else
					return this.field.getValue();
			}
			else{
				if ( ! HowMGWTUtilities.isEmpty( this.getHowMUnselectValue() ) )
					return this.getHowMUnselectValue();
				else
					return this.field.getValue();				
			}
		}			
		else
			return this.field.getValue();
	
	}
	
	public String getHowMValueAsString(){
		return HowMGWTUtilities.getString(this.getHowMValue());
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
	/**
	 * @return the howMSelectValue
	 */
	public String getHowMSelectValue() {
		return howMSelectValue;
	}
	/**
	 * @param howMSelectValue the howMSelectValue to set
	 */
	public void setHowMSelectValue(String howMSelectValue) {
		this.howMSelectValue = howMSelectValue;
	}
	/**
	 * @return the howMUnselectValue
	 */
	public String getHowMUnselectValue() {
		return howMUnselectValue;
	}
	/**
	 * @param howMUnselectValue the howMUnselectValue to set
	 */
	public void setHowMUnselectValue(String howMUnselectValue) {
		this.howMUnselectValue = howMUnselectValue;
	}
	
	public void setTitleStyle(String styleName) {	
		this.getField().setTextBoxStyle(styleName);
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