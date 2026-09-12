package com.howmake.client.form.partner;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.types.FieldType;

public class HowMGWTDataSource extends DataSourceField {
    public HowMGWTDataSource(){
 
    }

    public HowMGWTDataSource(JavaScriptObject jsObj){
        super(jsObj);
    }

    public HowMGWTDataSource(String name, FieldType type) {
        setName(name);
		setType(type);
        
    }

    public HowMGWTDataSource(String name, FieldType type, String title) {
        setName(name);
		setType(type);
		setTitle(title);
        
    }

    public HowMGWTDataSource(String name, FieldType type, String title, int length) {
        setName(name);
		setType(type);
		setTitle(title);
		setLength(length);
        
    }

    public HowMGWTDataSource(String name, FieldType type, String title, int length, boolean required) {
        setName(name);
		setType(type);
		setTitle(title);
		setLength(length);
		setRequired(required);
        
    }

	
}
