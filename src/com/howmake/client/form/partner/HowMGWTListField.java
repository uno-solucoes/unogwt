package com.howmake.client.form.partner;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.widgets.grid.ListGridField;

public class HowMGWTListField extends ListGridField{
	
    public HowMGWTListField(){
        super();
    }

    public HowMGWTListField(JavaScriptObject jsObj){
        super(jsObj);
    }

    public HowMGWTListField(String name) {
        super(name);
        
    }

    public HowMGWTListField(String name, int width) {
    	super(name, width);
    }

    public HowMGWTListField(String name, String title) {
    	super(name, title);
        
    }

    public HowMGWTListField(String name, String title, int width) {
    	super(name,title, width);
    }
	
}
