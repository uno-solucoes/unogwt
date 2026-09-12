package com.br.client.panel.at.atw0117a.calendar;

import java.util.Date;

import com.br.client.model.at.entity.eTouchResumo;
import com.br.client.model.cd.entity.eFeriado;
import com.br.client.panel.at.atw0117a.PainelTop;
import com.br.client.panel.at.atw0117a.ReservaUtil;
import com.howmake.client.form.model.HowMGWTTask;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.Criterion;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Hilite;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
import com.smartgwt.client.widgets.calendar.Lane;
import com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent;
import com.smartgwt.client.widgets.calendar.events.DayBodyClickHandler;
import com.smartgwt.client.widgets.events.HoverEvent;
import com.smartgwt.client.widgets.events.HoverHandler;
import com.smartgwt.client.widgets.grid.ListGrid;

public class HowMGWTCalendarioMesDetalhado  extends Calendar{

	private PainelTop parentPainelTop; 
	
	public PainelTop getParentPainelTop() {
		return parentPainelTop;
	}

	public void setParentPainelTop(PainelTop parentPainelTop) {
		this.parentPainelTop = parentPainelTop;
	}

	private int widthBandeira	= 32;
	private int heightBandeira	= 32;
		

// não tem ação neste componente.
//	@Override
//	public String getDateCSSText(Date date, Integer rowNum, Integer colNum, ListGrid viewer) {
//		
//		System.out.println("Data CSS:"+date+" - "+rowNum+" - "+colNum);
//		
//		return super.getDateCSSText(date, rowNum, colNum, viewer);
//	}
//	
//	@Override
//	public String getDateStyle(Date date, Integer rowNum, Integer colNum, ListGrid viewer) {
//		System.out.println("Data :"+date+" - "+rowNum+" - "+colNum);
//		
//		return super.getDateStyle(date, rowNum, colNum, viewer);
//	}
	
	@Override   
	public String getDayBodyHTML(Date date, CalendarEvent[] events, Calendar calendar, int rowNum, int colNum) {  

    	int height  = calendar.getHeight();

    	double heightCell = ( (double)height/(double)5 ) - 10;    	
    	
    	String bkg 		 = "background-color: rgb(60,179,113); ";

    	eFeriado feriado = parentPainelTop.getMapFeriados().get(HowMGWTUtilities.getFormatDateDB(date));	    	
    	if( feriado == null ){
    		bkg 		 = "";
    	}

		if(events != null && events.length > 0) {  
	    
			heightCell = heightCell - 4;
			
			String font = "font-family:Times, serif; font-size:30; margin:0px; ";
			String fontEventosYellow = "font-family: serif; font-size:18; margin:0px; padding:0px; color:blue;";
			String fontEventosRed    = "font-family: serif; font-size:18; margin:0px; padding:0px; color:red;";
			
	    	String returnStr = "";
   	
	    	returnStr += "<table border=0px; style=\"width:100%; Height:"+heightCell+"px; margin:0px; padding:0px; border:0px none; "+bkg+" \">";
	    	returnStr += "<tbody>";
	    	returnStr += "<tr>";
	    	returnStr += "<td  rowspan=3 style=\""+font+" Height:"+heightCell+"px; \">";
	    	
	    	returnStr += date.getDate() + "";
	    	
	    	returnStr += "</td>";
	    	returnStr += "</tr>";
	    	
	    	
	    	HowMGWTTask task = (HowMGWTTask)events[0];	    		    	
	    	
	    	eTouchResumo resumo = (eTouchResumo)task.getHowMUserObject();
	    	
	    	returnStr += "<tr>";
	        if ( HowMGWTUtilities.getInteger(resumo.getReservaConfirmada()) > 0  ){ 
		    	returnStr += "<td style=\"width:100%; Height:"+(this.getHeightBandeira()+4)+"px;"+fontEventosRed+" text-align:center; ";
	        	returnStr += "  \">";  
	        	
	            returnStr += ""+imgHTML(ReservaUtil.bandeiraReservaConfirmada, widthBandeira, heightBandeira, "image", "style=''", null)+"("+resumo.getReservaConfirmada()+")";              	
	    	}
	        else{
		    	returnStr += "<td style=\"width:100%; Height:1px; text-align:center; ";
	        	returnStr += "  \">";
	        }
	    	returnStr += "</td>";
	    	returnStr += "</tr>";
	    	
	    	
	    	returnStr += "<tr>";

	    	if ( HowMGWTUtilities.getInteger(resumo.getReservaDeInteresse()) > 0){

		    	returnStr += "<td style=\"width:100%; height:Height:"+(this.getHeightBandeira()+4)+"px"+fontEventosYellow+" text-align:center; ";

	    		returnStr += " \">"; 
	        	
	    		returnStr += ""+imgHTML(ReservaUtil.bandeiraReservaDeInteresse, widthBandeira, heightBandeira, "image", "style=''", null)+"("+resumo.getReservaDeInteresse()+")";  
	    	}
	    	else{
		    	returnStr += "<td style=\"width:100%; height:Height:1px; text-align:center; ";
	        	returnStr += "  \">";
	        }

	    	if ( HowMGWTUtilities.getInteger(resumo.getReservaPreContrato()) > 0){

		    	returnStr += "<td style=\"width:100%; height:Height:"+(this.getHeightBandeira()+4)+"px"+fontEventosYellow+" text-align:center; ";

	    		returnStr += " \">"; 
	        	
	    		returnStr += ""+imgHTML(ReservaUtil.bandeiraReservaPreContrato, widthBandeira, heightBandeira, "image", "style=''", null)+"("+resumo.getReservaPreContrato()+")";  
	    	}
	    	else{
		    	returnStr += "<td style=\"width:100%; height:Height:1px; text-align:center; ";
	        	returnStr += "  \">";
	        }	    	

	    	if ( HowMGWTUtilities.getInteger(resumo.getReservaContratoAssinado()) > 0){

		    	returnStr += "<td style=\"width:100%; height:Height:"+(this.getHeightBandeira()+4)+"px"+fontEventosYellow+" text-align:center; ";

	    		returnStr += " \">"; 
	        	
	    		returnStr += ""+imgHTML(ReservaUtil.bandeiraReservaContratoAssinado, widthBandeira, heightBandeira, "image", "style=''", null)+"("+resumo.getReservaContratoAssinado()+")";  
	    	}
	    	else{
		    	returnStr += "<td style=\"width:100%; height:Height:1px; text-align:center; ";
	        	returnStr += "  \">";
	        }	    	
	    	

	    	if ( HowMGWTUtilities.getInteger(resumo.getReservaContratoAssinado()) > 0){

		    	returnStr += "<td style=\"width:100%; height:Height:"+(this.getHeightBandeira()+4)+"px"+fontEventosYellow+" text-align:center; ";

	    		returnStr += " \">"; 
	        	
	    		returnStr += ""+imgHTML(ReservaUtil.bandeiraReservaContratoAssinado, widthBandeira, heightBandeira, "image", "style=''", null)+"("+resumo.getReservaContratoAssinado()+")";  
	    	}
	    	else{
		    	returnStr += "<td style=\"width:100%; height:Height:1px; text-align:center; ";
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
	    	
	    	String img 		 = ""+imgHTML("agenda/feriados/feriado_drink.png", widthBandeira, heightBandeira, "image", "style=''", null);
	    	String font 	 = "font-family:Times, serif; font-size:30; margin:0px; ";

	    	style += bkg ;	    		
	    	style += font;
	    	
	    	String returnStr = "<DIV "+style+"\">";

	    	returnStr += date.getDate() + "";
	    	returnStr += "</DIV>";

	    	return returnStr;
	    	
	    }
				
	}   
	
	public HowMGWTCalendarioMesDetalhado(){
						
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
	    	    
	    
	    this.addHoverHandler(new HoverHandler() {
			
			@Override
			public void onHover(HoverEvent event) {
				System.out.println("Event : "+event.getSource());
			}
		});
	    
	    this.addDayBodyClickHandler(new DayBodyClickHandler(){  
	            public void onDayBodyClick(DayBodyClickEvent event) {  	            	
	            	onChangeData(event.getDate());
	            }  
	    });
	}
	
	public void showTasks(HowMGWTTask[] tasks){
		if( tasks == null )
			tasks = new HowMGWTTask[0];
		
		this.setData(tasks);
	}
	
	public void onChangeData(Date data){}

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
}