package com.howmake.client.form.UI;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.user.client.ui.Image;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.MouseOutEvent;
import com.smartgwt.client.widgets.events.MouseOutHandler;
import com.smartgwt.client.widgets.events.MouseOverEvent;
import com.smartgwt.client.widgets.events.MouseOverHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class HowMGWTChartPane extends VLayout{

	private HLayout hTitle = new HLayout();
	private HowMGWTLabel label = new HowMGWTLabel();
	private HowMGWTChart chart = new HowMGWTChart();
	private HLayout toolbar = new HLayout();
	private Image button = new Image();

	
	public HowMGWTChartPane(){
		
		this.setWidth100();
		this.setHeight100();
		
		hTitle.setWidth100();
		hTitle.setHeight(30);
		hTitle.setOverflow(Overflow.HIDDEN);
		label.setOverflow(Overflow.HIDDEN);
		
		hTitle.addMember(label);
		
		this.addMember(hTitle);
		
//		HLayout sep = new HLayout();
//		sep.setWidth100();
//		sep.setHeight(1);
//		sep.setBackgroundColor("blue");
//		this.addMember(sep);
	
		this.addMember(chart);
	

//		HLayout sep1 = new HLayout();
//		sep1.setWidth100();
//		sep1.setHeight(1);
//		sep1.setBackgroundColor("blue");
//		this.addMember(sep1);
	

		
		toolbar.setWidth100();
		toolbar.setHeight(20);
		toolbar.setAlign(Alignment.RIGHT);
		
		button.getElement().getStyle().setCursor(Cursor.POINTER);
		button.setUrl("images/actions/btn_zoom_in.png");
		button.setWidth("16px");
		button.setHeight("16px");
		toolbar.addMember(button);
		
		this.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				HowMGWTChartWindow chartZoom = new HowMGWTChartWindow(HowMGWTChartPane.this);
			}
		});
		
		this.addMember(toolbar);
		
		this.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {	
				button.setVisible(false);
			}
		});
		
		this.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				button.setVisible(true);				
			}
		});

		button.setVisible(false);
 
	}
	
	public void setTitle(String title){
		this.getChart().setTitle(title);
		this.label.setHowMValue("<center><h3>"+title+"</h3></center>");
	}

	/**
	 * @return the chart
	 */
	public HowMGWTChart getChart() {
		return chart;
	}
	
	public void showToolbar(boolean visible){
		this.toolbar.setVisible(visible);
	}
}
