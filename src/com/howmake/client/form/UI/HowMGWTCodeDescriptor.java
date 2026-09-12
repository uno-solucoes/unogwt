package com.howmake.client.form.UI;

import com.howmake.client.form.partner.HowMGWTFormField;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class HowMGWTCodeDescriptor extends HLayout implements HowMGWTFormField{

	private HowMGWTTextItem field     = new HowMGWTTextItem();
	
	private HowMGWTLabel messageLabel = new HowMGWTLabel();
//	{
//		public void setHowMValue(Object value) {
//			super.setHowMValue("<B>"+ value+ "</B>");			
//		};
//	};
	
	public HowMGWTCodeDescriptor(){		
		super();
		messageLabel.setOverflow(Overflow.HIDDEN);
		messageLabel.setStyleName("formTitleMandatory");
	}
	
	public HowMGWTCodeDescriptor(String name, String title){
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
	public HowMGWTLabel getMessageLabel() {
		return messageLabel;
	}

	/**
	 * @param messageLabel the messageLabel to set
	 */
	public void setMessageLabel(HowMGWTLabel messageLabel) {
		this.messageLabel = messageLabel;
	}

	/**
	 * @return the field
	 */
	public HowMGWTTextItem getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(HowMGWTTextItem field) {
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
	

	public String getHowMLabelTitle(){
		return this.field.getTitle();
	}
}