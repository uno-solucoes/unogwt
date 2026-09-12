package com.br.client.panel.at.atw0117;
 

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
 

public class ActionData  extends Canvas{
	
	private int mesCorrente = 0;
	
	Img img;
	Label labelText;
	Label rightLabelText;
	
	public ActionData(){

		int wWidth = 120;
		
		this.setWidth(wWidth);
		this.setHeight(54);
			
		img = new Img("agenda/actionData.png");
		labelText = new Label();
		rightLabelText = new Label();
		
		labelText.setAlign(Alignment.CENTER);
		
		img.setParentElement(this);
		img.setWidth(wWidth);
		img.setHeight(54);
	
		img.animateShow(AnimationEffect.SLIDE);
		
		labelText.setAlign(Alignment.CENTER);
		
		labelText.setParentElement(this);
		labelText.setWidth(wWidth);

		labelText.setHeight(54);
		labelText.setContents("");
				
		labelText.show();
		rightLabelText.show();
	}
	
	public void setLabel(String label){
		labelText.setContents(label);
	}

	/**
	 * @return the mesCorrente
	 */
	public int getMesCorrente() {
		return mesCorrente;
	}

	/**
	 * @param mesCorrente the mesCorrente to set
	 */
	public void setMesCorrente(int mesCorrente) {
		this.mesCorrente = mesCorrente;
	}
}
