package com.br.client.panel.at.atw0117.component;

import java.util.Date;
 
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;

public class PainelNavegadorAno extends HLayout{

	private int year = (new Date()).getYear();
	
	private Img imgAno = new Img();

	
	private ImgButton actionLeft	= new ImgButton();
	private ImgButton actionRight	= new ImgButton();
	
	private Label labelAno = new Label();
	
	
	public PainelNavegadorAno(){

		this.setWidth100();
		this.setHeight(56);		
		this.setAlign(Alignment.CENTER);		

 
		
		actionLeft.setImageHeight(48);
		actionLeft.setImageWidth(48);
		actionLeft.setWidth(48);
		actionLeft.setHeight(48);
		actionLeft.setSrc("agenda/actionSetaEsquerda.png");
		actionLeft.addClickHandler(new ClickHandler() {					
			@Override
			public void onClick(ClickEvent event) {
				year --;
				labelAno.setContents("<FONT SIZE=5><STRONG>"+(year+1900)+"</STRONG></FONT>");
				onRefreshCalendario();
			}
		});		
		this.addMember(actionLeft);
		
		imgAno.setWidth(80);
		imgAno.setHeight(54);
		imgAno.setSrc("agenda/actionCalendar.png");
		this.addMember(imgAno);
		
		labelAno.setParentElement(imgAno);
		labelAno.setLeft(13);
		labelAno.setTop(10);
		labelAno.setWidth(70);
		labelAno.setHeight(50);
		labelAno.setContents("<FONT SIZE=5><STRONG>"+(year+1900)+"</STRONG></FONT>");
		labelAno.show();
		
		
		actionRight.setWidth(48);
		actionRight.setHeight(48);
		actionRight.setImageHeight(48);
		actionRight.setImageWidth(48);
		actionRight.setSrc("agenda/actionSetaDireita.png");		
		actionRight.addClickHandler(new ClickHandler() {					
			@Override
			public void onClick(ClickEvent event) {
				year ++;
				labelAno.setContents("<FONT SIZE=5><STRONG>"+(year+1900)+"</STRONG></FONT>");
				onRefreshCalendario();
			}
		});	
		this.addMember(actionRight);
 
	}

	protected void onRefreshCalendario(){}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
		labelAno.setContents("<FONT SIZE=5><STRONG>"+(year+1900)+"</STRONG></FONT>");
	}
 
}
