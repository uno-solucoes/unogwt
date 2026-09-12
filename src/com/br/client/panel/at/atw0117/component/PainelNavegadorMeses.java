package com.br.client.panel.at.atw0117.component;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

import com.br.client.panel.at.atw0117.ActionMeses;
 
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelNavegadorMeses extends HLayout{

	private int year;
	private int month;	
	private int day;
	
	private ActionMeses currentActionMes;	
	
	private ArrayList<ActionMeses> actionMeses = new ArrayList<ActionMeses>();

	public PainelNavegadorMeses(){
	
		Date currentDate	= new Date();
		year 			= currentDate.getYear();
		month  			= currentDate.getMonth();	
		day				= currentDate.getDate();
		
		ActionMeses actionData;
		
		HLayout centerNavegacaoMeses = new HLayout();
		centerNavegacaoMeses.setWidth100();
		centerNavegacaoMeses.setAutoHeight();
		centerNavegacaoMeses.setAlign(Alignment.CENTER);
 
		for ( int i = 1; i < 13 ; i ++){
			actionData = new ActionMeses(){
				@Override
				protected void onActionMes(ActionMeses actionMeses) {
					PainelNavegadorMeses.this.onActionMes(actionMeses);
				}
			};
			actionData.setMes(i);
	
			centerNavegacaoMeses.addMember(actionData);
			centerNavegacaoMeses.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(5,""));
			this.actionMeses.add(actionData);
		}
 
		refreshData();
		
		this.addMember(centerNavegacaoMeses);
	}
	
	
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
		refreshData();
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	
	private void onActionMes(ActionMeses actionMes){

		setMonth(actionMes.getMes()-1);
		refreshData();
		
 
	} 

	private void refreshData(){

		Date data 	= new Date(this.getYear(), getMonth() , this.getDay() );
		this.day 	= data.getDate();
		this.month 	= data.getMonth();
		this.year  	= data.getYear();
		
		if ( this.currentActionMes != null ){
			this.currentActionMes.onSelected(false);
		}
		actionMeses.get(this.getMonth()).onSelected(true);
		this.currentActionMes = actionMeses.get(this.getMonth());
		
		onRefreshCalendario();
		
	}
	
	public void onRefreshDataHeader(Date data){
		this.day 	= data.getDate();
		this.month 	= data.getMonth();
		this.year  	= data.getYear();
		
		if ( this.currentActionMes != null ){
			this.currentActionMes.onSelected(false);
		}
		actionMeses.get(this.getMonth()).onSelected(true);
		this.currentActionMes = actionMeses.get(this.getMonth());		
	}
	
	protected void onRefreshCalendario(){}

 

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}


	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}


	/**
	 * @return the currentActionMes
	 */
	public ActionMeses getCurrentActionMes() {
		return currentActionMes;
	}


	/**
	 * @param currentActionMes the currentActionMes to set
	 */
	public void setCurrentActionMes(ActionMeses currentActionMes) {
		this.currentActionMes = currentActionMes;
	}


	/**
	 * @return the actionMeses
	 */
	public ArrayList<ActionMeses> getActionMeses() {
		return actionMeses;
	}


	/**
	 * @param actionMeses the actionMeses to set
	 */
	public void setActionMeses(ArrayList<ActionMeses> actionMeses) {
		this.actionMeses = actionMeses;
	}
	
	public Date getCurrentDate(){
		return new Date(this.getYear(), this.getMonth(), this.getDay() );
	}
}