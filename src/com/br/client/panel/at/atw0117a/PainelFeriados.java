package com.br.client.panel.at.atw0117a;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;

import com.br.client.model.cd.entity.eFeriado;
import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.partner.HowMGWTNavigator;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PainelFeriados    extends HowMGWTListGrid{

	private boolean init = false;
	
	private int maskQtde = 2;
	
	public ListGridField fieldData				= new ListGridField("data", 		"", 65);
	public ListGridField fieldDiaSemana			= new ListGridField("diaSemana", 	"", 70);
	public ListGridField fieldFeriado		    = new ListGridField("feriado", 		"", 120);

	public PainelFeriados(){

		// this.setMargin(6);
		this.setStyleName("DirectSaleShadow");		
		
		initUI();	
	}
	
	public void initUI(){
		
		if ( init )
			return;
		
		init = true;
		
		this.setWidth100();
		this.setHeight100();
		
		this.setWrapCells(true);
		this.setFixedRecordHeights(false);
							
		this.setFields(
			fieldData,
			fieldDiaSemana,
			fieldFeriado
		);		

		this.setAutoFitFieldWidths(true);
		
		this.setCanResizeFields(true);
		this.setShowAllRecords(true);
		this.setShowHeader(false);

		onHowMInitEntityControl();
				
	}
	
	
	/**
	 * Carrega os dados para a listagem.
	 * @param form
	 */
	public void showFeriados(eFeriado[] feriados){

		this.clearAllRecords();
		if( feriados == null ){
			RecordList records = new RecordList();
			this.setData(records);
			return;
		}
		
		RecordList records = new RecordList();
		ListGridRecord record;
		
		DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("EEEE");
		
		for ( eFeriado feriado : feriados ){
			record = new ListGridRecord();

			
			Date data = HowMGWTUtilities.getDate(feriado.getDtFeriado());
			
 
			
			record.setAttribute(fieldData.getName()			, HowMGWTUtilities.getFormatDate(data));
			record.setAttribute(fieldDiaSemana.getName()	, dateTimeFormat.format(data));
			record.setAttribute(fieldFeriado.getName()		, feriado.getNomeFeriado());
		
			records.add(record);
		}
		this.setData(records);
	}	

}