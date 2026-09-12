package com.br.client.panel.at.atw0117a;


import java.util.Date;

import com.br.client.configuracao.Configuracao;
import com.br.client.model.at.atw0117.FormBean;
import com.br.client.model.at.entity.eTouchAgenda;
import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;


public class PainelCalendarioAgendaDia   extends HowMGWTListGrid{
	
	private boolean init = false;
	
	private int maskQtde = 2;
	
	public ListGridField fieldIdTask			= new ListGridField("idTask", 	    "#ID", 	     					50);
	public ListGridField fieldhoraInicio		= new ListGridField("horaInicio", 	Tradutor.i18n.formHoraInicio(), 50);
	public ListGridField fieldhoraFim			= new ListGridField("horaFim", 		Tradutor.i18n.formHoraFim(),  	50);
	public ListGridField fieldAssunto		    = new ListGridField("assunto", 		"Assunto",        			   140);
	public ListGridField fieldCliente			= new ListGridField("cliente", 	    Tradutor.i18n.formCliente());
	
	public PainelCalendarioAgendaDia(){
		 
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
					
		fieldIdTask.setHidden(true);
		
		fieldCliente.setAutoFitWidth(true);
		
		this.setFields(
			fieldIdTask,
			fieldhoraInicio,
			fieldhoraFim,
			fieldAssunto,
			fieldCliente
		);		
		
		
		
		this.setAutoFitFieldWidths(true);
		
		this.setCanResizeFields(true);
		// this.setHeaderHeight(22);
		this.setShowAllRecords(true);
		
		onHowMInitEntityControl();
 
	}
	
	/**
	 * Carrega os dados do agendamento do dia, visualiza os dados em AGENDAMENTOS.
	 * @param data
	 * @param codLocal
	 */
	public void load(Date data, String codLocal){

		this.clearAllRecords();
		
		HowMGWTWindowWait.showWait("Aguarde carregando eventos do dia...");		
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()){
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, false)){
					onSelectRecord(null);					
					return;
				}
				try{
					FormBean bean = (FormBean)formBean;					
					if( bean.getEntityTouchAgendas() != null ){
						
						RecordList records = new RecordList();
						ListGridRecord record;
						eTouchAgenda currentAgenda = null;
						for ( eTouchAgenda detalhe : bean.getEntityTouchAgendas()){
							
							record = new ListGridRecord();

							record.setAttribute(fieldIdTask.getName()		, detalhe.getCodAgenda());
							record.setAttribute(fieldhoraInicio.getName()	, HowMGWTUtilities.getFormatTime( HowMGWTUtilities.getDate( detalhe.getDtAgendaIni() )) );
							record.setAttribute(fieldhoraFim.getName()		, HowMGWTUtilities.getFormatTime( HowMGWTUtilities.getDate( detalhe.getDtAgendaFim() )));
							record.setAttribute(fieldAssunto.getName()		, detalhe.getAssunto());
							record.setAttribute(fieldCliente.getName()		, detalhe.getNomeCliente());							

							record.setAttribute("OBJ_CALENDAR", detalhe);
							
							if( currentAgenda == null )
								currentAgenda = detalhe;
							
							records.add(record);
						}
						setData(records);
						
						onSelectRecord(currentAgenda);
					}
					else
						onSelectRecord(null);
					HowMGWTWindowWait.hideWait();
				}
				catch(Throwable err){
					err.printStackTrace();
				}
				
			}			
		};
		FormBean bean = new FormBean();		
 
		bean.setDataInicio(HowMGWTUtilities.getFormatDateDB(data));
		bean.setDataFim(HowMGWTUtilities.getFormatDateDB(data));
		bean.setCodEmpresa(Configuracao.getCodEmpresa());
		bean.setCodLocal(codLocal);
		
		// Executa a carga de dados no servidor.
		struts.request(
				"atw0117.do?method=findEventosDia", 
				"ATW0117Form", 
				bean.toSendBody("")
		);
		
	}
	
	
	public eTouchAgenda getTouchAgenda(Record record){

		return (eTouchAgenda)record.getAttributeAsObject("OBJ_CALENDAR");	

	}
	

	public void onSelectRecord(eTouchAgenda touchAgenda){}
	
}