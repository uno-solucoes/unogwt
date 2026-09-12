package com.br.client.panel.at.atw0117a.calendar;

import java.util.Date;

import com.br.client.panel.at.atw0117a.PainelCalendarioAno;
import com.br.client.panel.at.atw0117a.PainelCalendarioMensal;
import com.br.client.panel.at.atw0117a.PainelTop;
import com.howmake.client.form.model.HowMGWTTask;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


public class HowMGWTCalendar extends HLayout{

	private HowMGWTTask[] currentTask;
	
	private PainelCalendarioMensal  calendarioMensal;
	

	public PainelCalendarioMensal getCalendarioMensal() {
		return calendarioMensal;
	}

	public void setCalendarioMensal(PainelCalendarioMensal calendarioMensal) {
		this.calendarioMensal = calendarioMensal;		
	}


	private PainelCalendarioAno parentCalendarioAno;
	
	public PainelCalendarioAno getParentCalendarioAno() {
		return parentCalendarioAno;
	}

	public void setParentCalendarioAno(PainelCalendarioAno parentCalendarioAno) {
		this.parentCalendarioAno = parentCalendarioAno;
	}


	private Date currentDate   = new Date(); 
	
	public Date getCurrentDate() {
		return currentDate;
	}


	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}


	private VLayout mainLayout = new VLayout(); 

	private HowMGWTCalendarioMes calendar = new HowMGWTCalendarioMes(){
		public void onChangeData(Date data){
			getParentCalendarioAno().onShowDetail(HowMGWTCalendar.this, data);
		}		
	};

	private HLayout headerLabel 		  = new HLayout();
	private Label labelMes				  = new Label();
	// private ImgButton actionShowMes		  = new ImgButton();
	
	public HowMGWTCalendarioMes getCalendar() {
		return calendar;
	}


	public HowMGWTCalendar(){	

		this.setWidth100(); 
		this.setHeight100();	

		mainLayout.setWidth100();
		mainLayout.setHeight100();
		

		mainLayout.setBackgroundColor("#FFFFFF");		
		// mainLayout.setShowShadow(true);
		this.setMargin(6);
		this.setStyleName("DirectSaleShadow");		

		
		calendar.setWidth100();
		calendar.setHeight100();		
		
//		this.actionShowMes.setImageType(ImageStyle.CENTER);
//		this.actionShowMes.setImageWidth(16);
//		this.actionShowMes.setImageHeight(16);
//		this.actionShowMes.setWidth(22);		
//		this.actionShowMes.setHeight100();
//		this.actionShowMes.setSrc("agenda/ico_lupa.png");
		
//		headerLabel.addMember(this.actionShowMes);
		
		
		labelMes.setWidth100();
		labelMes.setHeight(22);
		labelMes.setAlign(Alignment.CENTER);
		
		
		headerLabel.setWidth100();
		headerLabel.setHeight(22);
		headerLabel.setBackgroundColor("#E0EEEE");

		headerLabel.addMember(labelMes);		
		
		this.mainLayout.addMember(headerLabel);
		
		this.mainLayout.addMember(calendar);
		

		this.addMember( this.mainLayout );
		
//		this.actionShowMes.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				// getParentCalendarioAno().onShowDetail(HowMGWTCalendar.this);
//				getParentCalendarioAno().onShowDetail(HowMGWTCalendar.this, null);
//			}
//		});
	}


	public void showCalendar(Date date){
		
		this.setCurrentDate(date);
		
		this.getCalendar().setChosenDate(date);
		String mes = HowMGWTUtilities.getMesAbrev(""+(date.getMonth()));
		this.labelMes.setContents("<font size=+2><Strong>"+mes+"</Strong></font>");
	}
	
	public void showTasks(HowMGWTTask[] tasks){
		
		if( tasks == null )
			tasks = new HowMGWTTask[0];

		if( this.calendarioMensal != null ){
			this.calendarioMensal.showTasks(tasks);
		}
		
		this.currentTask = tasks;
			
		this.getCalendar().setData(tasks);
	}
}
