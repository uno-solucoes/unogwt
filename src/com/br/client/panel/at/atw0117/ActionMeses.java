package com.br.client.panel.at.atw0117;

import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.BackgroundRepeat;
import com.smartgwt.client.types.BkgndRepeat;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;

public class ActionMeses extends HLayout{


	private int mes 		= 1 ;
	private Label labelText = new Label();

	private boolean selected = false;
	
	public ActionMeses(){
	
		int width 	= 40;
		int height	= 36;
		
		labelText.setContents("");
						
		this.setShowShadow(true);
		this.setWidth(width);
		this.setHeight(height);

		labelText.setBackgroundImage("agenda/action_mes_abrev_label.png");
		labelText.setBackgroundRepeat(BackgroundRepeat.NO_REPEAT);
		labelText.setWidth(width);
		labelText.setHeight(height);
		labelText.setAlign(Alignment.CENTER);		

		labelText.setCursor(Cursor.HAND);

		labelText.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				onSelected(true);
				onActionMes(ActionMeses.this);
			}
		});		

		this.addMember(labelText);
	}

	public void setLabel(String text){
		this.labelText.setContents(text);
	}

	public void onSelected(boolean selected){
		this.selected = selected;
		if ( selected )
			labelText.setBackgroundImage("agenda/action_mes_abrev_label_Selected.png");
		else
			labelText.setBackgroundImage("agenda/action_mes_abrev_label.png");			
	}
	
	protected void onActionMes(ActionMeses actionMeses){};
	
	public void setMes(int mes){
		this.mes = mes;
		this.setLabel("<strong>"+HowMGWTUtilities.getMeses().get(HowMGWTUtilities.strZero(mes,2)).substring(0,3)+"</strong>");
	}
	
	public int getMes(){
		return mes;
	}
}