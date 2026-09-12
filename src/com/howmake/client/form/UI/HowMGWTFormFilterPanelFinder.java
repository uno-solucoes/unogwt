package com.howmake.client.form.UI;

import com.smartgwt.client.widgets.form.fields.PickerIcon;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemClickHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyUpEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyUpHandler;
import com.smartgwt.client.widgets.layout.HLayout;

public abstract class HowMGWTFormFilterPanelFinder extends HLayout{
	
	private HowMGWTFormTextItem howMField = new HowMGWTFormTextItem("Localizar","Localizar");
	
	private PickerIcon howMActionClear    = new PickerIcon(PickerIcon.CLEAR);
	private PickerIcon howMActionFind     = new PickerIcon(PickerIcon.SEARCH);
	
	public HowMGWTFormFilterPanelFinder(){
		this.setHeight(22);
		this.setWidth100();
	
		howMField.setWidth100();
		howMField.setTitleWidth(70);
		howMField.getField().setWidth("100%");
				
		howMActionClear.addFormItemClickHandler(new FormItemClickHandler() {
			
			public void onFormItemClick(FormItemIconClickEvent event) {
				howMField.setHowMValue("");
			}
		});
		
		howMActionFind.addFormItemClickHandler(new FormItemClickHandler() {
			
			public void onFormItemClick(FormItemIconClickEvent event) {
				onHowMExecuteQuery(getHowMField().getHowMValueAsString());
			}

		});

		this.howMField.getField().addKeyUpHandler(new KeyUpHandler() {			
			public void onKeyUp(KeyUpEvent event) {
				if ( "Enter".equalsIgnoreCase(event.getKeyName() )) 
					onHowMExecuteQuery(getHowMField().getHowMValueAsString());
			}
		});
		
		this.howMField.getField().setIcons(howMActionFind, howMActionClear);
	
	
		this.addMember(this.howMField);
	
	}

	/**
	 * @return the howMField
	 */
	public HowMGWTFormTextItem getHowMField() {
		return howMField;
	}

	/**
	 * @param howMField the howMField to set
	 */
	public void setHowMField(HowMGWTFormTextItem howMField) {
		this.howMField = howMField;
	}

	/**
	 * @return the howMActionFind
	 */
	public PickerIcon getHowMActionFind() {
		return howMActionFind;
	}

	/**
	 * @param howMActionFind the howMActionFind to set
	 */
	public void setHowMActionFind(PickerIcon howMActionFind) {
		this.howMActionFind = howMActionFind;
	}
	
	
	public abstract void onHowMExecuteQuery(String value);
}
