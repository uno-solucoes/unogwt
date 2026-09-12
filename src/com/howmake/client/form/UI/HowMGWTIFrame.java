package com.howmake.client.form.UI;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Frame;

public class HowMGWTIFrame extends Frame {

	public HowMGWTIFrame(){
		this.setWidth("100%");
		this.setHeight("99%");
		this.getElement().getStyle().setBorderWidth(0.0, Unit.PX);
		this.getElement().getStyle().setPadding(0.0, Unit.PX);
	}
	
}
