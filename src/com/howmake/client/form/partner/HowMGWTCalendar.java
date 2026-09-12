package com.howmake.client.form.partner;

import java.util.Date;

public class HowMGWTCalendar {

	Date time = new Date();
	
	public HowMGWTCalendar(){		
	}
	
	public HowMGWTCalendar(Date time){
		this.time = time;
	}
	
	public int getFirstDayMonth(){
		return 1;
	}
	
	public int getLastDayMonth(){
		return this.getLastDateMonth().getDate();
	}
	
	public Date getLastDateMonth(){
		Date dtFim    = new Date(time.getYear(),time.getMonth(),32,23,59,59);
		if( dtFim.getMonth() != time.getMonth() )
			if( time.getMonth() == 11)
				dtFim = new Date(time.getYear()+1, dtFim.getMonth(), 0, 23,59,59);
			else
				dtFim = new Date(time.getYear(), dtFim.getMonth(), 0, 23,59,59);		
		return dtFim;
	}

	public Date getFirstDateMonth(){
		Date dtInicio   = new Date(time.getYear(),time.getMonth(),1,0,0,0);
		return dtInicio;
		
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	
}
