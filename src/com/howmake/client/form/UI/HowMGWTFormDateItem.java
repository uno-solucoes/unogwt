package com.howmake.client.form.UI;

import java.util.Date;

import com.google.gwt.core.client.Scheduler;
import com.howmake.client.I18N.HowMTradutor;
import com.howmake.client.form.partner.HowMGWTFormField;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.DateDisplayFormatter;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.FormItemValueFormatter;
import com.smartgwt.client.widgets.form.FormItemValueParser;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;

public class HowMGWTFormDateItem extends DynamicForm implements HowMGWTFormField {
	private DateItem	field	= new DateItem();

	public HowMGWTFormDateItem() {
		this.setItems(this.field);
	}

	public HowMGWTFormDateItem(String name, String title) {
		this();
		this.field.setName(name);
		this.field.setTitle(title);
		this.field.setAttribute("inputFormat", HowMTradutor.i18n.formInputFormatDiaMesAno());		
		
		
		
		this.setHowMUseMask(true);
	}

	/**
	 * @return the field
	 */
	public DateItem getField() {
		return field;
	}

	/**
	 * @param field
	 *            the field to set
	 */
	public void setField(DateItem field) {
		this.field = field;
	}

	public void setHowMValue(Object value) {
		this.field.setValue(value);
	}

	public Object getHowMValue() {
		return getHowMValueAsString();
	}

	public String getHowMValueAsString() {
		Object obj = this.field.getValue();
		if (obj instanceof Date)
			return HowMGWTUtilities.getFormatDate(this.field.getValueAsDate());
		else if (obj instanceof String)
			return obj.toString();
		else
			return "";
	}

	public void setHowMBound(int widthLabel, int widthField) {
		this.setTitleWidth(widthLabel + 7);
		this.getField().setWidth(widthField);
		this.setWidth(widthLabel + 7 + widthField + 26);
	}

	public void setHowMDisable(Boolean disabled) {
		// this.getField().setDisabled(disabled);
		this.setDisabled(disabled);
	}

	public void setHowMBound(int widthLabel) {
		this.setTitleWidth(widthLabel);
		this.setWidth100();
	}

	public void setHowMFocusInItem() {
		this.field.focusInItem();
	}

	public void setHowMLabelTitle(String label) {
		this.field.setTitle(label);
	}

	public String getHowMLabelTitle() {
		return this.field.getTitle();
	}

	
	public void setHowMUseMask(boolean useMask){
		if( ! useMask )
			return ;

		this.getField().setUseMask(useMask);
		this.getField().setUseTextField(useMask);
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