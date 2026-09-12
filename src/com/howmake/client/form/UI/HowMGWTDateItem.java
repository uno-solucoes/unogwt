package com.howmake.client.form.UI;

import java.util.Date;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.partner.HowMGWTFormField;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;

public class HowMGWTDateItem extends DynamicForm implements HowMGWTFormField{
	private DateItem field = new DateItem();

	public HowMGWTDateItem(){		
		this.setItems(this.field);
	}
	public HowMGWTDateItem(String name, String title){
		this();
		this.field.setName(name);
		this.field.setTitle(title);
		this.field.setAttribute("inputFormat", Tradutor.i18n.formInputFormatDiaMesAno());
		this.field.setEndDate( HowMGWTUtilities.getDate( "2099-12-31" ) );
	}

	/**
	 * @return the field
	 */
	public DateItem getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(DateItem field) {
		this.field = field;
	}

	public void setHowMValue(Object value){
		this.field.setValue(value);
	}

	public Object getHowMValue(){
		Object obj = this.field.getValue();
		if (obj instanceof Date)
			return HowMGWTUtilities.getFormatDate(this.field.getValueAsDate());
		else if (obj instanceof String)
			return obj.toString();
		else
			return "";
	}

	public String getHowMValueAsString(){
		if ( this.field.getValue() != null )
			return this.field.getValue().toString();
		else
			return "";
	}

	public void setHowMBound(int widthLabel, int widthField){
		this.setTitleWidth(widthLabel);
		this.getField().setWidth(widthField);
		this.setWidth(widthLabel+widthField+38);
	}

	public void setHowMDisable(Boolean disabled){
		// this.getField().setDisabled(disabled);
		this.setDisabled(disabled);
	}	
	
	
	public void setHowMUseMask(boolean useMask){
		if( ! useMask )
			return ;

		this.getField().setUseMask(useMask);
		this.getField().setUseTextField(useMask);
	}
	
	public String getHowMLabelTitle(){
		return this.field.getTitle();
	}
}