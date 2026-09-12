package com.howmake.client.form.UI;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class HowMGWTActionButtonTouch extends HLayout{
		 
	private HLayout leftLayout = new HLayout();
	private HLayout rigthLayout = new HLayout();

	private VLayout topLayout  = new VLayout();
	private VLayout bottonLayout = new VLayout();

	private String color;
	private String colorNav;
	
	private String textButton;
	
	private boolean selected	= false;
	private int     gapSelect   = 15;
	
	private Img topImg = new Img("agenda/topBorder.png");
	private Img bottonImg = new Img("agenda/bottonBorder.png");

	
	private VLayout centerLayout = new VLayout();
	// private Img actionImg = new Img("agenda/button_transparente_120_86.png");
	
	private Label labelButton = new Label();
	
	public HowMGWTActionButtonTouch(String text, String color, String colorNav){

		this.color 		= color;
		this.colorNav 	= colorNav;
		this.textButton = text;
		
		this.setWidth(120);
		this.setHeight(86);
	
		this.setAlign(VerticalAlignment.CENTER);
	
		leftLayout.setHeight100();
		leftLayout.setWidth(15);
		Img leftImg = new Img("agenda/leftBorder.png");
		leftImg.setWidth(15);
		leftImg.setHeight100();
		leftLayout.addMember(leftImg);
		
		rigthLayout.setHeight100();
		rigthLayout.setWidth(14);
		Img rightImg = new Img("agenda/rightBorder.png");
		rightImg.setWidth(14);
		rightImg.setHeight100();
		rigthLayout.addMember(rightImg);		
		
		topLayout.setHeight(4);
		topLayout.setWidth100();
		topImg.setHeight(4);
		topImg.setWidth100();
		topLayout.addMember(topImg);			
		
		bottonLayout.setHeight(8);
		bottonLayout.setWidth100();
		bottonImg.setHeight(8);
		bottonImg.setWidth100();
		bottonLayout.addMember(bottonImg);
		
		
		centerLayout.setWidth100();
		centerLayout.setHeight100();

		labelButton.setHeight100();
		labelButton.setWidth100();
		
		
		labelButton.setAlign(Alignment.CENTER);
		labelButton.setContents("<Strong><font color=#ffffff size=+1>"+text+"</font></Strong>");

		centerLayout.addMember(this.topLayout);
		centerLayout.addMember(this.labelButton);
		centerLayout.addMember(this.bottonLayout);
		
		this.addMember(leftLayout);
		this.addMember(centerLayout);
		this.addMember(rigthLayout);
		
		this.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if ( selected ){
					setBackgroundColor(HowMGWTActionButtonTouch.this.colorNav);
					setCursor(Cursor.DEFAULT);
					//setAnimateResizeTime(600);
					setWidth(HowMGWTActionButtonTouch.this.getWidth()-gapSelect);
					labelButton.setContents("<Strong><font color=#ffffff size=+1>"+textButton+"</font></Strong>");
					labelButton.redraw();
					selected = false;
					topImg.redraw();
					bottonImg.redraw();
					redraw();
				}
				else{
					setBackgroundColor(HowMGWTActionButtonTouch.this.color);				
					setCursor(Cursor.HAND);
					//setAnimateResizeTime(600);
					setWidth(HowMGWTActionButtonTouch.this.getWidth()+gapSelect);					
					labelButton.setContents("<Strong><font color=#ffffff size=+2>"+textButton+"</font></Strong>");
					labelButton.redraw();
					selected = true;
					topImg.redraw();
					bottonImg.redraw();
					redraw();

				}
			}
		});
		
//		this.addMouseOutHandler(new MouseOutHandler() {
//			
//			@Override
//			public void onMouseOut(MouseOutEvent event) {
//				setBackgroundColor(HowMGWTActionButtonTouch.this.color);				
//				setCursor(Cursor.HAND);
//				setWidth(HowMGWTActionButtonTouch.this.getWidth()-10);
//
//			}
//		});
//		
//		this.addMouseOverHandler(new MouseOverHandler() {
//			
//			@Override
//			public void onMouseOver(MouseOverEvent event) {
//				setBackgroundColor(HowMGWTActionButtonTouch.this.colorNav);
//				setCursor(Cursor.DEFAULT);
//				setWidth(HowMGWTActionButtonTouch.this.getWidth()+10);
//			}
//		});
		
	}

	/**
	 * @return the clicked
	 */
	public boolean isClicked() {
		return selected;
	}

	/**
	 * @param clicked the clicked to set
	 */
	public void setClicked(boolean clicked) {
		this.selected = clicked;
	}
	 
}
