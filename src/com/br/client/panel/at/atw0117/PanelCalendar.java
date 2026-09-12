package com.br.client.panel.at.atw0117;

import java.util.Date;

import com.br.client.model.at.entity.eTouchResumo;
import com.howmake.client.form.model.HowMGWTTask;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
import com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent;
import com.smartgwt.client.widgets.calendar.events.DayBodyClickHandler;
import com.smartgwt.client.widgets.events.HoverEvent;
import com.smartgwt.client.widgets.events.HoverHandler;

public class PanelCalendar extends Calendar{

	public PanelCalendar(){
		
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
	    this.setHeight(300);  
	    this.setShowDayView(false);  
	    this.setShowWeekView(false);  
	    this.setShowOtherDays(false);  
	    this.setShowDayHeaders(false);  
	    this.setShowDatePickerButton(false);  
	    this.setShowAddEventButton(false);  
	    this.setDisableWeekends(false);          
	    this.setShowDateChooser(false);  
	    this.setCanCreateEvents(false);  
	    
	    this.setDataSource(eventDS);  
	    this.setAutoFetchData(true);  
	    

	    this.addHoverHandler(new HoverHandler() {
			
			@Override
			public void onHover(HoverEvent event) {
				System.out.println("Event : "+event.getSource());
			}
		});
	}    
     
    
    @Override   
    public String getDayBodyHTML(Date date, CalendarEvent[] events, Calendar calendar, int rowNum, int colNum) {  
        String returnStr = date.getDate() + "";  
        if(events != null && events.length > 0) {  
        	HowMGWTTask task = (HowMGWTTask)events[0];
        	eTouchResumo resumo = (eTouchResumo)task.getHowMUserObject();
        	
        	// returnStr += "<br/>";

            if ( HowMGWTUtilities.getInteger(resumo.getReservaConfirmada()) > 0  ){
                returnStr += "<br/>"+imgHTML("actions/ok.png", 16, 16, "image", "style=''", null)+"("+resumo.getReservaConfirmada()+")";              	
        	}
        	if ( HowMGWTUtilities.getInteger(resumo.getReservaPreContrato()) > 0){        		
                returnStr += "<br/>"+imgHTML("actions/btn_history.png", 16, 16, "image", "style=''", null)+"("+resumo.getReservaPreContrato()+")";  
        	}
        }  
        return returnStr;  
    }   


}
