package com.howmake.client.form.model;

import java.util.TreeMap;

import com.howmake.client.form.partner.HowMGWTFormField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.grid.ListGridField;

public class HowMGWTLinkField {

	private Object source;
	private Object target;
	
	public HowMGWTLinkField(ListGridField source, HowMGWTFormField target){
		this.source = source;
		this.target = target;
	}

	public HowMGWTLinkField(HowMGWTFormField target, ListGridField source){
		this.source = source;
		this.target = target;
	}
	
	public void setTargetValue(Record record){
		((HowMGWTFormField)target).setHowMValue(record.getAttributeAsObject(((ListGridField)this.source).getName()));
	}
	
}
