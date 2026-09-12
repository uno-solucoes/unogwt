package com.howmake.client.form.model;
 
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.google.gwt.user.client.Window;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class HowMGWTDataRecord extends ListGridRecord{
	
	public HowMGWTDataRecord(){
		
	}
	
 	public HowMGWTDataRecord(HowMGWTListGrid grid, Map<String,Integer> headerPosition , String[] row ){

	    Object[] objects = headerPosition.keySet().toArray();

	    String sKey;
	    Integer sPosition;
	    ListGridField field;

	    for(Object key : objects) {
	      	 sKey = key.toString();
  	      	 	      	 
	      	 sPosition = (Integer)headerPosition.get(key);
	       	 field     = grid.getHowMGWTFields().get(sKey);

	       	 if ( field != null )
	       			 this.loadListValue(sKey, field.getType(), row, sPosition);
	       	 else	       		 
	       		 this.loadListValue(sKey, (ListGridFieldType)null, row, sPosition);
	    }
	}
 	
 	
	
 	public HowMGWTDataRecord(DataSource dataSource, Map<String,Integer> headerPosition , String[] row ){

	    Object[] objects = headerPosition.keySet().toArray();

	    String sKey;
	    Integer sPosition;
	    DataSourceField field;

	    for(Object key : objects) {
	      	 sKey = key.toString();
  	      	 
	      	 sPosition = (Integer)headerPosition.get(key);
	       	 field     = dataSource.getField(sKey);
	       	 if ( field != null )
	       		 this.loadValue(sKey, field.getType(), row, sPosition);
	       	 else	       		 
	       		 this.loadValue(sKey, (FieldType)null, row, sPosition);
	    }
	} 	
 	
 	/**
 	 * Carrega o valor do campo para a mmemória do registro
 	 * @param fieldName
 	 * @param fieldType
 	 * @param row
 	 * @param sPosition
 	 */
 	public void loadValue(String fieldName, FieldType fieldType, String[] row, Integer sPosition){
 		if ( fieldType != null ){
			if ( FieldType.FLOAT.equals( fieldType ) ){
				if ( ! HowMGWTUtilities.isEmpty(row[sPosition]))
					setAttribute( fieldName , new Double(row[sPosition]) );
				else
					setAttribute( fieldName , new Double(0.00) );						
			}
			else if ( FieldType.INTEGER.equals( fieldType ) ){
				if ( ! HowMGWTUtilities.isEmpty(row[sPosition]))
					setAttribute( fieldName, new Integer(row[sPosition]));
				else
					setAttribute( fieldName, new Integer(0) );
			}
			else if ( FieldType.DATE.equals(fieldType)){
				if ( ! HowMGWTUtilities.isEmpty(row[sPosition]))
					setAttribute( fieldName , new Date((new Long(row[sPosition])).longValue()));
				else					
					setAttribute( fieldName , (Date)null);
			}
			else if ( FieldType.BOOLEAN.equals( fieldType ) ){
				if ( ! HowMGWTUtilities.isEmpty(row[sPosition]))
					setAttribute( fieldName , new Boolean(row[sPosition]));
				else
					setAttribute( fieldName , "");
			}
			else{
				if ( ! HowMGWTUtilities.isEmpty(row[sPosition]))
					setAttribute( fieldName , row[sPosition]);
				else
					setAttribute( fieldName , "");
			}
		}
       	 else{
			if ( ! HowMGWTUtilities.isEmpty(row[sPosition]))
       			setAttribute( fieldName , row[sPosition]);
			else
				setAttribute( fieldName , "");
       	 } 		
 	}
 	
 	/**
 	 * Carrega o valor do campo para a mmemória do registro
 	 * @param fieldName
 	 * @param fieldType
 	 * @param row
 	 * @param sPosition
 	 */
 	public void loadListValue(String fieldName, ListGridFieldType fieldType, String[] row, Integer sPosition){ 	
 		if ( fieldType != null ){
 			
			if ( ListGridFieldType.FLOAT.equals( fieldType ) ){
				if ( ! HowMGWTUtilities.isEmpty(row[sPosition]))
					setAttribute( fieldName , new Double(row[sPosition]) );
				else
					setAttribute( fieldName , new Double(0.00) );						
			}
			else if ( ListGridFieldType.INTEGER.equals( fieldType ) ){
				if ( ! HowMGWTUtilities.isEmpty(row[sPosition]))
					setAttribute( fieldName, new Integer(row[sPosition]));
				else
					setAttribute( fieldName, new Integer(0) );
			}
			else if ( ListGridFieldType.DATE.equals(fieldType)){
				if ( ! HowMGWTUtilities.isEmpty(row[sPosition]))
					setAttribute( fieldName , new Date((new Long(row[sPosition])).longValue()));
				else					
					setAttribute( fieldName , (Date)null);
			}
			else if ( ListGridFieldType.BOOLEAN.equals( fieldType ) ){
				if ( ! HowMGWTUtilities.isEmpty(row[sPosition]))
					setAttribute( fieldName , new Boolean(row[sPosition]));
				else
					setAttribute( fieldName , "");
			}
			else{
				if ( ! HowMGWTUtilities.isEmpty(row[sPosition]))
					setAttribute( fieldName , row[sPosition]);
				else
					setAttribute( fieldName , "");
			}
		}
       	 else{
			if ( ! HowMGWTUtilities.isEmpty(row[sPosition]))
       			setAttribute( fieldName , row[sPosition]);
			else
				setAttribute( fieldName , "");
       	 } 		
 	} 	
 
}