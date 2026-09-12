package com.howmake.client.form.UI;

import com.howmake.client.I18N.HowMTradutor;
import com.howmake.client.form.partner.HowMGWTFormField;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.layout.HLayout;

public class HowMGWTFormDateItemRange extends HLayout implements HowMGWTFormField { 

	private HowMGWTFormDateItem fieldItemStart = new HowMGWTFormDateItem();
	private HowMGWTFormDateItem fieldItemEnd   = new HowMGWTFormDateItem();

	public HowMGWTFormDateItemRange(){
		
		this.addMember(this.fieldItemStart);
		this.addMember(this.fieldItemEnd);

		this.fieldItemStart.getField().setAttribute("inputFormat", HowMTradutor.i18n.formInputFormatDiaMesAno());		
		this.fieldItemEnd.getField().setAttribute("inputFormat", HowMTradutor.i18n.formInputFormatDiaMesAno());		
		
		this.fieldItemStart.getField().setTitle("Data de");
		this.fieldItemEnd.getField().setTitle("até");
		
		this.setHowMUseMask(true);
	}
	
	public HowMGWTFormDateItemRange(String name, String title){
		this();
		this.fieldItemStart.getField().setTitle(title);
		this.fieldItemEnd.getField().setTitle("até");		
	}

	/**
	 * @return the field
	 */
	public HowMGWTFormDateItemRange getField() {
		return this;
	}

	public void setHowMValue(Object value) {
		if ( HowMGWTUtilities.isEmpty( value ) ){
			this.fieldItemStart.setHowMValue("");
			this.fieldItemEnd.setHowMValue("");
		}
		else{
			
			String range = value.toString();
			
			String[] datas = range.split(",");
			
			if( datas.length > 1 ){
				this.fieldItemStart.setHowMValue(HowMGWTUtilities.getDate(datas[0]));
				this.fieldItemEnd.setHowMValue(HowMGWTUtilities.getDate(datas[1]));
			}
			else{
				if( datas.length > 0 )
					this.fieldItemStart.setHowMValue(HowMGWTUtilities.getDate(datas[0]));
				else
					this.fieldItemStart.setHowMValue("");
					
				this.fieldItemEnd.setHowMValue("");
			}
		}
	}

	public Object getHowMValue() {
		
		Object date1 = fieldItemStart.getHowMValue();
		Object date2 = fieldItemEnd.getHowMValue();
		
		String date = "";
	
		if( ! HowMGWTUtilities.isEmpty(date1) )
			date += date1.toString()+",";

		if( ! HowMGWTUtilities.isEmpty(date2) )
			date += date2.toString()+",";

		return date;
	}

	public String getHowMValueAsString() {
		Object value = this.getHowMValue();
		if ( HowMGWTUtilities.isEmpty(value))
			return "";
		else 
			return value.toString();
	}

	public void setHowMBound(int widthLabel, int widthField) {
		this.fieldItemStart.setHowMBound(widthLabel, widthField);
		this.fieldItemEnd.setHowMBound(20,widthField);
		this.setAutoWidth();
		this.setHeight(22);
	}

	public void setHowMDisable(Boolean disabled) {
		this.setDisabled(disabled);
	}

	public void setHowMBound(int widthLabel) {
		this.setWidth100();
	}

	public void setHowMFocusInItem() {
		this.fieldItemStart.getField().focusInItem();
	}

	public void setHowMLabelTitle(String label) {
		this.fieldItemStart.getField().setTitle(label);
	}

	public String getHowMLabelTitle() {
		return this.fieldItemStart.getField().getTitle();
	}

	
	public void setHowMUseMask(boolean useMask){
		if( ! useMask )
			return ;

		this.fieldItemStart.getField().setUseMask(useMask);
		this.fieldItemStart.getField().setUseTextField(useMask);

		this.fieldItemEnd.getField().setUseMask(useMask);
		this.fieldItemEnd.getField().setUseTextField(useMask);
	}	
	
	public void setTitleStyle(String style){
		this.fieldItemStart.getField().setTitleStyle(style);
		this.fieldItemEnd.getField().setTitleStyle(style);
	}

	public DynamicForm getHowMForm(){
		return fieldItemStart.getHowMForm();
	}

	public void howMFocusInItem() {
		fieldItemStart.howMFocusInItem();
	}
 
}
