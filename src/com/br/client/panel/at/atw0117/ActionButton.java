package com.br.client.panel.at.atw0117;

import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.widgets.AnimationCallback;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

public class ActionButton extends Img{

	private int w = TouchScreenConstantes.DEFAULT_WIDTH_OPTIONS;
	private int h = 105;
	private double pn= 0.60;
	private double pa= TouchScreenConstantes.DEFAULT_PERCENT_AMPLIADO;
	private int animationTime = 150;	
	
	public ActionButton(String iconName){
		
		this.setSrc(iconName);
		
		this.setCursor(Cursor.HAND);
		ClickHandler clickHandle = new ClickHandler() {	
			@Override
			public void onClick(ClickEvent event) {
				onConfigure(ActionButton.this);
			}
		};
		
		this.setShowShadow(true);
		
		this.setWidth((int)(w*pn));
		this.setHeight((int)(h*pn));
		this.addClickHandler(clickHandle);		
       
		this.addClickHandler(clickHandle);
	}

	/**
	 * @return the w
	 */
	public int getW() {
		return w;
	}

	/**
	 * @param w the w to set
	 */
	public void setW(int w) {
		this.w = w;
	}

	/**
	 * @return the h
	 */
	public int getH() {
		return h;
	}

	/**
	 * @param h the h to set
	 */
	public void setH(int h) {
		this.h = h;
	}

	/**
	 * @return the pn
	 */
	public double getPn() {
		return pn;
	}

	/**
	 * @param pn the pn to set
	 */
	public void setPn(double pn) {
		this.pn = pn;
	}

	/**
	 * @return the pa
	 */
	public double getPa() {
		return pa;
	}

	/**
	 * @param pa the pa to set
	 */
	public void setPa(double pa) {
		this.pa = pa;
	}
	
	
	public void onConfigure(ActionButton action) {
	}
	
	public void selectButton(){
		animateResize((int)(w*pa), (int)(h*pa), new AnimationCallback() {
			@Override
			public void execute(boolean earlyFinish) {
			}				
		},animationTime);
	}

	public void deselectButton(){
		this.animateResize((int)(w*pn), (int)(h*pn), new AnimationCallback() {				
			@Override
			public void execute(boolean earlyFinish) {		
		
			}
		},animationTime);
	}

}
