package com.howmake.client.form.UI;

import com.google.gwt.core.client.Scheduler;
import com.howmake.client.form.partner.HowMGWTFormField;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class HowMGWTFormCodeDescriptor extends HLayout implements HowMGWTFormField{

	private HowMGWTFormTextItem field     = new HowMGWTFormTextItem();
	
	private HowMGWTFormLabel messageLabel = new HowMGWTFormLabel();
//	{
//		public void setHowMValue(Object value) {
//			super.setHowMValue("<B>"+ value+ "</B>");			
//		};
//	};
	
	public HowMGWTFormCodeDescriptor(){		
		super();
		messageLabel.setOverflow(Overflow.HIDDEN);
		messageLabel.setStyleName("formTitleMandatory");
	}
	
	public HowMGWTFormCodeDescriptor(String name, String title){
		this();
		this.getField().getField().setName(name);
		this.getField().getField().setTitle(title);
		
		this.addMember(this.field);

		this.getField().setWidth("255px");
		VLayout vLayout = new VLayout();
		vLayout.setHeight(26);
		vLayout.setWidth100();
		vLayout.setMargin(6);
		this.getMessageLabel().setWidth100();
		vLayout.addMember(this.getMessageLabel());
		this.addMember(vLayout);
	}

	/**
	 * @return the messageLabel
	 */
	public HowMGWTFormLabel getMessageLabel() {
		return messageLabel;
	}

	/**
	 * @param messageLabel the messageLabel to set
	 */
	public void setMessageLabel(HowMGWTFormLabel messageLabel) {
		this.messageLabel = messageLabel;
	}

	/**
	 * @return the field
	 */
	public HowMGWTFormTextItem getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(HowMGWTFormTextItem field) {
		this.field = field;
	}

 
	
	
	
	
	
	
	public void setHowMValue(Object value){
		this.getField().setHowMValue(value);
		this.messageLabel.setTitle("");
	}
	
	public Object getHowMValue(){
		return this.getField().getHowMValue();
	}

	public String getHowMValueAsString(){
		return this.getField().getHowMValueAsString();
	}
	
	public void setHowMBound(int widthLabel, int widthField){
		this.getField().setHowMBound(widthField, widthField);
	}	
	
	public void setHowMDisable(Boolean disabled){
		// this.getField().setDisabled(disabled);
		this.getField().setHowMDisable(disabled);
		this.getMessageLabel().setHowMDisable(disabled);
	}		
	
	public void setHowMBound(int widthLabel){
		this.getField().setTitleWidth(widthLabel);
		this.setWidth100();
	}
	
	public void setHowMFocusInItem(){
		this.field.getField().focusInItem();
	}
	
	public void setHowMLabelTitle(String label){
		this.field.getField().setTitle(label);
	}

	public String getHowMLabelTitle(){
		return this.field.getField().getTitle();
	}

	public DynamicForm getHowMForm(){
		return field.getHowMForm();
	}
	
	public void howMFocusInItem() {
		this.field.howMFocusInItem();
	}
	
 

}