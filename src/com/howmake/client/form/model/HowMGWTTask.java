package com.howmake.client.form.model;

import java.util.Date;

import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
 
public class HowMGWTTask extends CalendarEvent{

	private boolean birday;

	private Object howMUserObject;
 
 
	public HowMGWTTask(){
	}
	
	public HowMGWTTask(String[] row){
			
        setEventId(HowMGWTUtilities.getInteger(row[0]));
		setName(row[1]);
		setDescription(row[2]);
		setGoogleObservacao(row[2]);
		setStartDate(new Date(HowMGWTUtilities.getLong(row[3])));
		setEndDate(new Date(HowMGWTUtilities.getLong(row[4])));
		setCanEdit(HowMGWTUtilities.getBoolean(row[5]));
		setEventWindowStyle(row[6]);
		setBirday(HowMGWTUtilities.getBoolean(row[7]));		
		this.setGoogleID(row[8]);
		this.setGoogleOnde(row[9]);

	}

	/**
	 * @return the birday
	 */
	public boolean isBirday() {
		return birday;
	}

	/**
	 * @param birday the birday to set
	 */
	public void setBirday(boolean birday) {
		this.birday = birday;
	}

 

	/**
	 * @return the googleID
	 */
	public String getGoogleID() {
		return this.getAttributeAsString("AGENDA_ID");
	}

	/**
	 * @param googleID the googleID to set
	 */
	public void setGoogleID(String googleID) {
		this.setAttribute("AGENDA_ID", googleID);
	}

	
	/**
	 * @return the googleID
	 */
	public String getGoogleOnde() {
		return this.getAttributeAsString("onde");
	}

	/**
	 * @param googleID the googleID to set
	 */
	public void setGoogleOnde(String googleOnde) {
		this.setAttribute("onde", googleOnde);
	}	
	
	
	/**
	 * @return the googleID
	 */
	public String getGoogleObservacao() {
		return this.getAttributeAsString("observacao");
	}

	/**
	 * @param googleID the googleID to set
	 */
	public void setGoogleObservacao(String googleObservacao) {
		this.setAttribute("observacao", googleObservacao);
	}		
	
	/**
	 * @return the howMUserObject
	 */
	public Object getHowMUserObject() {
		return howMUserObject;
	}

	/**
	 * @param howMUserObject the howMUserObject to set
	 */
	public void setHowMUserObject(Object howMUserObject) {
		this.howMUserObject = howMUserObject;
	}

//	/**
//	 * @return the agendaKey
//	 */
//	public String getAgendaKey() {
//		return this.getAttributeAsString("AGENDA_KEY");
//	}
//
//	/**
//	 * @param agendaKey the agendaKey to set
//	 */
//	public void setAgendaKey(String agendaKey) {
//		this.setAttribute("AGENDA_KEY", agendaKey);
//	}
	
 }

