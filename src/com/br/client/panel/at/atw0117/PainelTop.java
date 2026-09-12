package com.br.client.panel.at.atw0117;

import java.util.Date;

import com.br.client.panel.at.atw0117.component.PainelNavegador;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelTop extends HLayout{
 
	private boolean created = false;
	private Img logotipo = new Img();
 
//	private ActionData actionAno = new ActionData();	
//	private ActionData actionMes = new ActionData();
	
	private Date currentDate;

	private PainelNavegador painelNavegador = new PainelNavegador(){		
		protected void onCalendarSelectDate(Date currentDate) {
			if ( ! created )
				return;
			PainelTop.this.onCalendarSelectDate(currentDate);
		};
	};

	public PainelTop(){
		
		this.setBackgroundImage("agenda/cabecalho.jpg");
		
		this.setWidth100();
		this.setHeight((int)(200*.50));
	
		this.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(10, ""));
		
		VLayout vLayout = new VLayout();
		vLayout.setAutoWidth();
		vLayout.setHeight100();
		vLayout.setAlign(Alignment.CENTER);
		
		// logotipo.setSrc("agenda/logo-villa-bisutti.png");
		logotipo.setWidth((int)(423*.50));
		logotipo.setHeight((int)(151*.50));
		
		vLayout.addMember(logotipo);
		
		this.addMember(vLayout);
		this.addMember(painelNavegador);
		this.created = true;

	}
	
	public void setData(Date data){
		
		this.currentDate = data;
		
 	}

	
	protected void onCalendarSelectDate(Date currentDate) {}
	
	public void onRefreshTopDate(Date navegateDate){
		painelNavegador.onRefreshTopDate(navegateDate);
	}

	/**
	 * @return the logotipo
	 */
	public Img getLogotipo() {
		return logotipo;
	}

	/**
	 * @return the currentDate
	 */
	public Date getCurrentDate() {
		return currentDate;
	}

	/**
	 * @param currentDate the currentDate to set
	 */
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
 
}