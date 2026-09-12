package com.br.client.panel.at.atw0117.component;

import java.util.Date;

import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelNavegador extends VLayout{
	
	private PainelNavegadorAno navegadorAno = new PainelNavegadorAno(){
		protected void onRefreshCalendario(){
			navegadorMeses.setYear(this.getYear());
		}		
	};
	private PainelNavegadorMeses navegadorMeses = new PainelNavegadorMeses(){ 
		protected void onRefreshCalendario() {
			System.out.println("Selecionou data :"+HowMGWTUtilities.getFormatDate(this.getCurrentDate()));
			onCalendarSelectDate(this.getCurrentDate());			
		}
	};
	
	public PainelNavegador(){
		
		this.setWidth100();
		this.setAutoHeight();
		
		this.addMember(navegadorAno);
		this.addMember(navegadorMeses);
		
	}
	
	
	protected void onCalendarSelectDate(Date currentDate){}

	public void onRefreshTopDate(Date navegateDate){
		navegadorAno.setYear(navegateDate.getYear());
		navegadorMeses.onRefreshDataHeader(navegateDate);
	}
	
}
