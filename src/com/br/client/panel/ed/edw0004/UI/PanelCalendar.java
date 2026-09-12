package com.br.client.panel.ed.edw0004.UI;
 
/* 
 * Smart GWT (GWT for SmartClient) 
 * Copyright 2008 and beyond, Isomorphic Software, Inc. 
 * 
 * Smart GWT is free software; you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License version 3 
 * as published by the Free Software Foundation.  Smart GWT is also 
 * available under typical commercial license terms - see 
 * http://smartclient.com/license 
 * 
 * This software is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * Lesser General Public License for more details. 
 */  
  
import java.util.Date;

import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
import com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent;
import com.smartgwt.client.widgets.calendar.events.DayBodyClickHandler;
  
public class PanelCalendar extends Calendar {  

    @Override   
    public String getDayBodyHTML(Date date, CalendarEvent[] events, Calendar calendar, int rowNum, int colNum) {  
        String returnStr = date.getDate() + "";  
        if(events != null && events.length > 0) {  
            returnStr += imgHTML("actions/btn_history.png", 16, 16, "image", "style='margin-top:6px'", null);  
        }  
        return returnStr;  
    }  

    public PanelCalendar() {  
        DataSource eventDS = new DataSource();  
        DataSourceSequenceField eventIdField = new DataSourceSequenceField("eventId");  
        eventIdField.setPrimaryKey(true);  
  
        DataSourceTextField nameField = new DataSourceTextField("name");  
        DataSourceTextField descField = new DataSourceTextField("description");  
        DataSourceDateField startDateField = new DataSourceDateField("startDate");  
        DataSourceDateField endDateField = new DataSourceDateField("endDate");  
  
        eventDS.setFields(eventIdField, nameField, descField, startDateField, endDateField);  
        eventDS.setClientOnly(true);  
        eventDS.setTestData( new CalendarEvent[]{} );  
  
        this.setWidth100();  
        this.setHeight(220);  
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
        this.addDayBodyClickHandler(new DayBodyClickHandler() {  
            public void onDayBodyClick(DayBodyClickEvent event) {  
                String nameStr = "";  
                CalendarEvent[] events = event.getEvents();
                boolean showEvent = false;
                if(events.length == 0) {  

                } else {  
                    // for (CalendarEvent calEvent : events) {  
                        // nameStr += calEvent.getName() + "<br/>";  
                    // }
                    // nameStr += "<br>"+HowMGWTUtilities.getFormatDateDB(event.getDate());
                	showEvent = true;
                }  
                onSelectData(event.getDate(), showEvent);
            }  
        });
    }
    
    protected void onSelectData(Date data, boolean showEvent){}
}