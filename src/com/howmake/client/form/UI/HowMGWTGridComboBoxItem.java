package com.howmake.client.form.UI;

import com.howmake.client.form.partner.HowMGWTFormField;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;

public class HowMGWTGridComboBoxItem  implements HowMGWTFormField{
	
	private ComboBoxItem field = new ComboBoxItem();
	

	public HowMGWTGridComboBoxItem(){		
	}
	
	public HowMGWTGridComboBoxItem(String name, String title){
		this();
		this.field.setName(name);
		this.field.setTitle(title);
	}
	/**
	 * @return the field
	 */
	public ComboBoxItem getField() {
		return field;
	}
	/**
	 * @param field the field to set
	 */
	public void setField(ComboBoxItem field) {
		this.field = field;
	}
	
	public void setHowMValue(Object value){
		if ( HowMGWTUtilities.isEmpty(value ))
			this.field.setValue("");
		else
			this.field.setValue(value);
	}

	public Object getHowMValue(){
		return this.field.getValue();
	}
	
	public String getHowMValueAsString(){
		Object valor = getHowMValue(); 
		if ( valor != null )
			return valor.toString();
		else
			return "";
	}	
	
	public void setHowMBound(int widthLabel, int widthField){
	}
	
	public void setHowMDisable(Boolean disabled){
	}
	
	
	public void setHowMBound(int widthLabel){
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
		return null;
	}

	public void howMFocusInItem() {
		// TODO Auto-generated method stub
		
	}
 

}