package com.br.client.panel.sg.sgw0027.model;

import java.util.Set;

import com.howmake.client.form.UI.HowMGWTListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ENFSE {
	
	 /**
	  * Conver um registro de uma grid para um registro no formato de array de strings.
	  * @param record
	  * @param grid
	  * @return
	  */
	 public static final String[] convertRecordToRow(ListGridRecord record, HowMGWTListGrid grid){
		 String[] row = new String[grid.getHeaderPositions().size()];

         Set keys = grid.getHeaderPositions().keySet();
         Object[] objects = keys.toArray();
 
         String sKey;
         Integer sPosition;
         for(Object key : objects) {
        	 sKey = key.toString();
        	 sPosition = (Integer)grid.getHeaderPositions().get(key);
        	 row[sPosition.intValue()] = record.getAttribute(sKey);
         }
         return row;
	 }
}
