package com.howmake.client.form.UI;

import com.google.gwt.http.client.URL;

public class HowMGWTChartWindow extends HowMGWTWindowBase{

	
	private HowMGWTChartPane chartPanel = new HowMGWTChartPane();
	
	public HowMGWTChartWindow(HowMGWTChartPane chartPanel){

		this.chartPanel.setTitle(chartPanel.getChart().getTitle());
		this.chartPanel.showToolbar(false);
		this.chartPanel.setWidth100();
		this.chartPanel.setHeight100();

		this.setWidth("80%");
		this.setHeight("80%");		
		this.setCanDragResize(false);
		this.centerInPage();
		this.setIsModal(true);

		this.addItem(this.chartPanel);

		this.show();

		this.chartPanel.getChart().setColumns(chartPanel.getChart().getColumns());
		this.chartPanel.getChart().setContentsURL(URL.encode(chartPanel.getChart().getRequestZoom()));

	}
	
}
