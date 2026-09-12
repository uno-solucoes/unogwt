package com.br.client.panel.vd.vdp0001.model;

import java.util.ArrayList;
import java.util.TreeMap;

import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class RecordRelacaoVendas extends ListGridRecord{
	
	public RecordRelacaoVendas(ListGridField[] fields, TreeMap<String,Integer> headerPosition , String[] row ){
		int i = 0;
		for ( ListGridField field : fields ) {
			
			if ( "ND".equals( field.getAttribute("DataType") ) ){
				try{
					setAttribute( field.getName(), new Double(row[headerPosition.get(field.getName())]));
				}
				catch(Throwable er){						
					setAttribute( field.getName(), 0.0);
				}
				
			}
			else if ( "NI".equals( field.getAttribute("DataType") ) ){
				try{
					setAttribute( field.getName(), new Integer(row[headerPosition.get(field.getName())]));
				}
				catch(Throwable er){						
					setAttribute( field.getName(), 0);
				}
			}				
			else
				setAttribute( field.getName(), row[headerPosition.get(field.getName())]);
			
			i ++;
		}
	}
	
	public RecordRelacaoVendas(ArrayList<ListGridField> fields, String[] row ){
		int i = 0;
		for ( ListGridField field : fields) {				
			if ( "ND".equals( field.getAttribute("DataType") ) ){
					try{
						setAttribute( field.getName(), new Double(row[i]));
					}
					catch(Throwable er){						
						setAttribute( field.getName(), 0.0);
					}
			}
			else if ( "NI".equals( field.getAttribute("DataType") ) ){
				try{
					setAttribute( field.getName(), new Integer(row[i]));
				}
				catch(Throwable er){						
					setAttribute( field.getName(), 0.0);
				}
			}
			else
				setAttribute( field.getName(), row[i]);
			
			i ++;
		}
	}	
}
