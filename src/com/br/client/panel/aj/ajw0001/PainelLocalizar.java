package com.br.client.panel.aj.ajw0001;

import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.NumberFormat;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PainelLocalizar extends HowMGWTListGrid{
	
	public ListGridField fieldID		= new ListGridField("ContaBancaria", 	Tradutor.i18n.formID()    , 60  );
	public ListGridField fieldGrupo     = new ListGridField("ContaBancaria", 	Tradutor.i18n.formGrupo() , 130 );
	public ListGridField fieldTitulo	= new ListGridField("PlanoConta", 	    Tradutor.i18n.formArtigo()      );

	public PainelLocalizar(){
		
		this.setWrapCells(true);
		this.fieldGrupo.setWrap(true);
		this.fieldTitulo.setWrap(true);
		
		this.setWidth100();
		this.setWidth100();
		
		this.setFixedRecordHeights(false);
	
		CellFormatter formatValor = new CellFormatter() {				
	        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
	            if(value == null) return null;  
	            NumberFormat nf = NumberFormat.getFormat("R$ ###,###,###,###,###,###,##0.00");
	            try {  
	                return nf.format(((Number) value).doubleValue());  
	            } catch (Exception e) {  
	                return value.toString();  
	            }  
	        }  
	    };

	    this.setShowAllColumns(true);
		this.setShowAllRecords(true);
       
	    
		this.setFields(
				fieldID,
				fieldGrupo,
				fieldTitulo
		);		
		
		this.setCanResizeFields(true);
		this.setHeaderHeight(22);
			
		onHowMInitEntityControl();	
	}	
}
