package com.br.client.panel.at.atw0117a.calendar;

import java.util.Date;

import com.br.client.model.at.entity.eTouchResumo;
import com.br.client.model.cd.entity.eFeriado;
import com.br.client.panel.at.atw0117a.PainelTop;
import com.br.client.panel.at.atw0117a.ReservaUtil;
import com.howmake.client.form.model.HowMGWTTask;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
import com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent;
import com.smartgwt.client.widgets.calendar.events.DayBodyClickHandler;
import com.smartgwt.client.widgets.events.HoverEvent;
import com.smartgwt.client.widgets.events.HoverHandler;
import com.smartgwt.client.widgets.layout.HLayout;

 
public class HowMGWTCalendarioMes extends Calendar{

	private PainelTop parentPainelTop;
	
	int widthBandeira 	= 16; 
	int heightBandeira 	= 16;
	int widthText		= 24;
	boolean showTotal   = true;
	
	@Override   
	public String getDayBodyHTML(Date date, CalendarEvent[] events, Calendar calendar, int rowNum, int colNum) {  		
    	int height  = calendar.getHeight();

    	double heightCell = ( (double)height/(double)5 ) - 6;    	

    	String bkg 		 = "background-color: rgb(60,179,113); ";

    	eFeriado feriado = parentPainelTop.getMapFeriados().get(HowMGWTUtilities.getFormatDateDB(date));	    	
    	if( feriado == null ){
    		bkg 		 = "";
    	}    	
    	
		if(events != null && events.length > 0) {  
	    
			String font = "font-family:Times, serif; font-size:11; margin:0px; ";
			String fontEventos = "font-family: serif; font-size:"+(showTotal ? "9" : "4" )+"; margin:0px; padding:0px; ";
			
	    	String returnStr = "";
	    	
			heightCell = heightCell - 4;
	    	
	    	returnStr += "<table border=0px; style=\"width:100%; heigth:"+heightCell+"px; margin:0px; padding:0px; border:0px none; "+bkg+" \">";
	    	
	    	returnStr += "<tbody>";
	    	returnStr += "<tr>";
	    	returnStr += "<td  rowspan=3 style=\""+font+"; width:24px; \">";
	    	
	    	returnStr += date.getDate() + "";
	    	
	    	returnStr += "</td>";
	    	returnStr += "</tr>";
	    	
	    	
	    	HowMGWTTask task = (HowMGWTTask)events[0];
	    	
	    	eTouchResumo resumo = (eTouchResumo)task.getHowMUserObject();
	    	
 
	    	returnStr += "<tr>";
	    	returnStr += "<td style=\"width:"+(widthBandeira+( showTotal ? widthText : 4 ) )+"px; "+fontEventos+" text-align:center; ";	
	        if ( HowMGWTUtilities.getInteger(resumo.getReservaConfirmada()) > 0  ){
	        	
	        	returnStr += "  \">"; 
	            returnStr += ""+imgHTML(ReservaUtil.bandeiraReservaConfirmada16, widthBandeira, heightBandeira, "image", "style=''", null)+( showTotal ? "("+resumo.getReservaConfirmada()+")" : "" ); 
	    	}
	        else{
	        	returnStr += "  \">";
	        }
	    	returnStr += "</td>";
	    	returnStr += "</tr>";

	    	
	    	
	    	
	    	returnStr += "<tr>";
	    	returnStr += "<td style=\"width:"+(widthBandeira+( showTotal ? widthText : 4 ) )+"px; "+fontEventos+" text-align:center; ";	
	        if ( HowMGWTUtilities.getInteger(resumo.getReservaPreContrato()) > 0  ){
	        	
	        	returnStr += "  \">"; 
	            returnStr += ""+imgHTML(ReservaUtil.bandeiraReservaPreContrato16, widthBandeira, heightBandeira, "image", "style=''", null)+( showTotal ? "("+resumo.getReservaPreContrato()+")" : "" ); 
	    	}
	        else{
	        	returnStr += "  \">";
	        }
	    	returnStr += "</td>";
	    	returnStr += "</tr>";
	    	
	    	
	    	

	    	
	    	returnStr += "<tr>";
	    	returnStr += "<td style=\"width:"+(widthBandeira+( showTotal ? widthText : 4 ) )+"px; "+fontEventos+" text-align:center; ";	
	        if ( HowMGWTUtilities.getInteger(resumo.getReservaContratoAssinado()) > 0  ){
	        	
	        	returnStr += "  \">"; 
	            returnStr += ""+imgHTML(ReservaUtil.bandeiraReservaContratoAssinado16, widthBandeira, heightBandeira, "image", "style=''", null)+( showTotal ? "("+resumo.getReservaContratoAssinado()+")" : "" ); 
	    	}
	        else{
	        	returnStr += "  \">";
	        }
	    	returnStr += "</td>";
	    	returnStr += "</tr>";
	    	
	    	
	    	
	    	
	    	
	    	returnStr += "<tr>";
	    	returnStr += "<td style=\"width:"+(widthBandeira+( showTotal ? widthText : 4 ) )+"px; "+fontEventos+" text-align:center; ";

	    	if ( HowMGWTUtilities.getInteger(resumo.getReservaDeInteresse()) > 0){
	        	
	    		returnStr += "  \">"; 
	        	
	            returnStr += ""+imgHTML(ReservaUtil.bandeiraReservaDeInteresse16, widthBandeira, heightBandeira, "image", "style=''", null)+ ( showTotal ? "("+resumo.getReservaDeInteresse()+")" : "");  
	    	}
	    	else{
	        	returnStr += "  \">";
	        }

	    	returnStr += "</td>";
	    	returnStr += "</tr>"; 
	    	returnStr += "</tbody>";
	    	returnStr += "</table>";
	    	return returnStr;
	    }  
	    else{
	    	
	    	String style 	 = "style=\"width:100%; height:"+heightCell+"px; ";
	    	
	    	String font 	 = "font-family:Times, serif; font-size:11; margin:0px; ";

	    	style += bkg ;	    		
	    	style += font;
	    	
	    	String returnStr = "<DIV "+style+"\">";

	    	returnStr += date.getDate() + "";
	    	returnStr += "</DIV>";
	    	
	    	return returnStr;
	    }
	}   
	
	public HowMGWTCalendarioMes(){

	    DataSource eventDS = new DataSource();  
	    DataSourceSequenceField eventIdField = new DataSourceSequenceField("eventId");  
	    eventIdField.setPrimaryKey(true);  
	
	    DataSourceTextField nameField = new DataSourceTextField("name");  
	    DataSourceTextField descField = new DataSourceTextField("description");  
	    DataSourceDateField startDateField = new DataSourceDateField("startDate");
	    DataSourceDateField endDateField = new DataSourceDateField("endDate");  
	
	    eventDS.setFields(eventIdField, nameField, descField, startDateField, endDateField);  
	    eventDS.setClientOnly(true);  
	    eventDS.setTestData( new CalendarEvent[]{});

	    this.setAlign(Alignment.CENTER);
	    
	    this.setWidth100();  
	    this.setHeight100(); 
	    
	    this.setShowDayView(false);  
	    this.setShowWeekView(false);  
	    this.setShowOtherDays(false);  
	    this.setShowDayHeaders(false);  
	    this.setShowDatePickerButton(false);  
	    this.setShowAddEventButton(false);  
	    this.setDisableWeekends(false);          
	    this.setShowDateChooser(false);  
	    this.setCanCreateEvents(false);
	    
	    this.setShowControlsBar(false);      // Remove a barra de navegação de meses	    
	    this.setShowCustomScrollbars(false);
	    this.setScrollToWorkday(false);
	    
	    this.setWidth100();
	    this.setHeight100();
	    	    
	    this.setDataSource(eventDS);  
	    this.setAutoFetchData(true); 	    	    
	    
//	    this.addHoverHandler(new HoverHandler() {
//			
//			@Override
//			public void onHover(HoverEvent event) {
//				System.out.println("Event : "+event.getSource());
//			}
//		});
	    
	    
	    this.addDayBodyClickHandler(new DayBodyClickHandler(){  
	            public void onDayBodyClick(DayBodyClickEvent event) {
	            	
	            	onChangeData(event.getDate());
//	                String nameStr = "";  
//	                CalendarEvent[] events = event.getEvents();  
//	                if(events.length == 0) {  
//	                    nameStr = "No events";  
//	                } else {  
//	                    for (CalendarEvent calEvent : events) {  
//	                        nameStr += calEvent.getName() + "<br/>";  
//	                    }  
//	                }  
//	                SC.say(nameStr);  
	            }  
	    });
	}
	
	public void onChangeData(Date data){
		
	}

	public int getWidthBandeira() {
		return widthBandeira;
	}

	public void setWidthBandeira(int widthBandeira) {
		this.widthBandeira = widthBandeira;
	}

	public int getHeightBandeira() {
		return heightBandeira;
	}

	public void setHeightBandeira(int heightBandeira) {
		this.heightBandeira = heightBandeira;
	}

	public boolean isShowTotal() {
		return showTotal;
	}

	public void setShowTotal(boolean showTotal) {
		this.showTotal = showTotal;
	}
	
	
	public void setParentPainelTop(PainelTop parentPainelTop){
		this.parentPainelTop = parentPainelTop;
	}
	
	public PainelTop getParentPainelTop(){
		return parentPainelTop;
	}
}