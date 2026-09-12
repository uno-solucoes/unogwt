package com.br.client.panel.oc.ocw0001.UI;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.smartgwt.client.types.BkgndRepeat;
import com.smartgwt.client.widgets.grid.HoverCustomizer;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class GoogleAgendaTaskListGrid extends HowMGWTListGrid{

	public ListGridField fieldData 			= new ListGridField("Data", 				Tradutor.i18n.formData()				,   70);
	public ListGridField fieldHoraInicio	= new ListGridField("HrInicio", 			Tradutor.i18n.formHoraInicio()			,   60);
	public ListGridField fieldHoraFim  		= new ListGridField("HrFim", 				Tradutor.i18n.formHoraFim()				,   60);
	public ListGridField fieldNome  		= new ListGridField("Evento", 				Tradutor.i18n.formNomeEvento()			,  270);	
	public ListGridField fieldObservacao 	= new ListGridField("Observacao", 			Tradutor.i18n.formObservacao());
	
	public GoogleAgendaTaskListGrid(){

		this.setCellHeight(50);
		
		this.setFields(
				fieldData,
				fieldHoraInicio,
				fieldHoraFim,
				fieldNome,
				fieldObservacao
			);

        this.onHowMInitEntityControl();
 
        this.setCanAutoFitFields(false);   
        
        this.setWrapCells(true);  
        this.setFixedRecordHeights(false);  
        
        for ( ListGridField field :  this.getFields()){
        	field.setCanHide(false);
//        	field.setCanReorder(false);
//        	field.setCanGroupBy(false);
//        	field.setCanFreeze(false);
//        	field.setCanSort(false);
//        	field.setCanSortClientOnly(false);
			field.setWrap(true);
			field.setCanEdit(false);

	    }
        
        this.setSortField(fieldData.getName());
        
		this.onHowMInitEntityControl();
 
		this.setShowAllRecords(true);
	}	
}
