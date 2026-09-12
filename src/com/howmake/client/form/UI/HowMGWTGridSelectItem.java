package com.howmake.client.form.UI;

import com.howmake.client.form.partner.HowMGWTFormField;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;

public class HowMGWTGridSelectItem  implements HowMGWTFormField{
	
	private SelectItem field = new SelectItem();
	

	public HowMGWTGridSelectItem(){		
	}
	public HowMGWTGridSelectItem(String name, String title){
		this();
		this.field.setName(name);
		this.field.setTitle(title);
	}
	/**
	 * @return the field
	 */
	public SelectItem getField() {
		return field;
	}
	/**
	 * @param field the field to set
	 */
	public void setField(SelectItem field) {
		this.field = field;
	}
	
	public void setHowMValue(Object value){
		if( this.getField().isMultiple() != null && this.getField().isMultiple() ){
			if( HowMGWTUtilities.isEmpty(value))
				this.field.setValues();
			else{
				String[] values = value.toString().split(",");
				this.field.setValues(values);
			}
		}
		else{
			if ( HowMGWTUtilities.isEmpty(value ))
				this.field.setValue("");
			else
				this.field.setValue(value);
		}
	}

	public Object getHowMValue(){
		if( this.getField().isMultiple() != null && this.getField().isMultiple() ){
			if ( this.field.getValues() != null && this.field.getValues().length > 0 ){
				String ret = "";
				for ( String value : this.field.getValues() ){
					if ( HowMGWTUtilities.isEmpty( ret ))
						ret += value;
					else
						ret += ","+value;
				}
				return ret;
			}
			else
				return "";
		}
		else
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