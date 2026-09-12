package com.br.client.panel.oc.ocw0001.UI;

import java.util.Date;
import java.util.LinkedHashMap;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.Services;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTTask;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.server.HowMUtilities;
import com.howmake.shared.HowMGWTEntity;
import com.smartgwt.client.types.BackgroundRepeat;
import com.smartgwt.client.types.BkgndRepeat;
import com.smartgwt.client.types.TimeFormatter;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
import com.smartgwt.client.widgets.calendar.events.CalendarEventAdded;
import com.smartgwt.client.widgets.calendar.events.CalendarEventChangedEvent;
import com.smartgwt.client.widgets.calendar.events.CalendarEventClick;
import com.smartgwt.client.widgets.calendar.events.CalendarEventRemoveClick;
import com.smartgwt.client.widgets.calendar.events.CalendarEventRemoved;
import com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent;
import com.smartgwt.client.widgets.calendar.events.DayBodyClickHandler;
import com.smartgwt.client.widgets.calendar.events.EventAddedHandler;
import com.smartgwt.client.widgets.calendar.events.EventChangedHandler;
import com.smartgwt.client.widgets.calendar.events.EventClickHandler;
import com.smartgwt.client.widgets.calendar.events.EventRemoveClickHandler;
import com.smartgwt.client.widgets.calendar.events.EventRemovedHandler;
import com.smartgwt.client.widgets.events.VisibilityChangedEvent;
import com.smartgwt.client.widgets.events.VisibilityChangedHandler;
import com.smartgwt.client.widgets.form.fields.HeaderItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

@SuppressWarnings("deprecation")
public class GoogleAgenda extends Calendar {
 	
	HeaderItem fieldAgendaKey = new HeaderItem("AGENDA_KEY"); 
    
    public  TextItem fieldName;
    private TextItem fieldNameSummary;
    private TextAreaItem fieldObservacao;
    private TextItem fieldEndereco;
            
    private SelectItem startHours = new SelectItem("startHours", Tradutor.i18n.formDe());
    private SelectItem endHours   = new SelectItem("endHours",   Tradutor.i18n.formAte());
    
    // startHours
    // startMinutes
    // startAMPM
    
    // endHours
    // endMinutes
    // endAMPM
    
    private boolean controle = false;
    
	private String agendaKey;
	private String tipoAgenda;
	private String descricao;
	private String codResponsavel;
	private String observacao;
	private String onde;
	
	public GoogleAgenda(String tipoAgenda, String labelAgenda, String agendaKey, String descricao, String codResponsavel , String observacao, String onde) {
 		
		this.tipoAgenda 	= tipoAgenda;
		this.agendaKey 		= agendaKey;
		this.tipoAgenda 	= tipoAgenda;
		this.descricao  	= descricao;
		this.codResponsavel = codResponsavel;
		this.observacao 	= observacao;
		this.onde 			= onde;
		
		this.setBackgroundImage(Tradutor.i18n.cfgImagesGeralIdioma()+"bgTabAgenda.gif");
		this.setBackgroundRepeat(BackgroundRepeat.REPEAT);
		
		this.setEventWindowStyle("agendaEditWindow");
		
		this.setTimeFormatter(TimeFormatter.TOSHORTPADDED24HOURTIME);
		// this.setDateFormatter(DateDisplayFormat.TOEUROPEANSHORTDATE);
		
		// Vai para a pasta da visão por semana
		// this.setShowWeekends(true);
		// Vai para a visão mensal.
		setShowMonthView(true);
		// Vai para a visão diária.
		// setShowDayView(false);

        this.setCanEditEvents(true);
        // this.setScrollToWorkday(true);


        this.setFirstDayOfWeek(0); // MONDAY
 
        
        this.setWorkdays(new int[]{0,1,2,3,4,5,6});
    
		// Habilita os sabados e domingos para margar agenda.
		// Mostra o horório de trabalho destacado pela cor amarela.
		this.setShowWorkday(false);
		// Seta a hora de inicio do expediente.
		this.setWorkdayStart("08:00");
		// Seta a hora fim do expediente
		this.setWorkdayEnd("18:00");
 
		// Indica que será apresentado o diálogo de edição dos eventos da Agenda.

		fieldName = new TextItem(getNameField(), Tradutor.i18n.formObservacao());
		fieldName.setDefaultValue(tipoAgenda+":"+agendaKey+":"+descricao);	
		fieldName.setDisabled(true);
		fieldName.setVisible(false); 
		
		fieldNameSummary = new TextItem(getNameField(), Tradutor.i18n.formObservacao());
		fieldNameSummary.setDefaultValue(tipoAgenda+":"+agendaKey+":"+descricao);	
		fieldNameSummary.setDisabled(true);
		fieldNameSummary.setVisible(false);


	    fieldAgendaKey.setTitle(labelAgenda);	    
	    fieldAgendaKey.setWidth(100);
	    fieldAgendaKey.setDisabled(true);
	    fieldAgendaKey.setDefaultValue(labelAgenda+" : "+agendaKey+"-"+descricao);
  	    	    
		fieldObservacao = new TextAreaItem(getDescriptionField(), "Observação");
		fieldObservacao.setMinHeight(100);
		fieldObservacao.setWidth(450);
		fieldObservacao.setDefaultValue(observacao);
		fieldObservacao.setTitle(Tradutor.i18n.formObservacao());
		
		fieldEndereco = new TextItem("onde","endereço");		
		fieldEndereco.setHeight(22);
		fieldEndereco.setWidth(450);
		fieldEndereco.setDefaultValue(onde);
		
		fieldEndereco.setTitle(Tradutor.i18n.formEndereco());

		
		this.setEventDialogFields(fieldAgendaKey,fieldName, fieldObservacao, fieldEndereco);		
		
        HeaderItem eventOptions = new HeaderItem();  
        eventOptions.setDefaultValue( labelAgenda + " : "+agendaKey+"-"+descricao );	        
        this.setEventEditorFields(eventOptions, fieldNameSummary, startHours, endHours, fieldObservacao,  fieldEndereco);
        
		//this.setAutoFetchData(true);

		this.setData(new CalendarEvent[] {});

		// Habilita ou Desabilita a edição da tarefa.
		// setShowQuickEventDialog(false);
		// Desabilita a exclusão de evento.
		// setCanDeleteEvents(false);
		// Habilita ou Desabilita a criação de evento.
		// setCanCreateEvents(true);
		// setCanDragReposition(false);
		// setCanEditEvents(false);

		
		// -----------------------------------------------------------
		// Controle de edição dos dados da Agenda.
		// Controla a gravação de um novo item da agenda.
		// -----------------------------------------------------------
		addEventAddedHandler(new EventAddedHandler() {
			@Override
			public void onEventAdded(final CalendarEventAdded event) {
				
				if ( controle ){
									
					event.getEvent().setAttribute(fieldAgendaKey.getName()  , GoogleAgenda.this.tipoAgenda+":"+GoogleAgenda.this.agendaKey+":"+GoogleAgenda.this.descricao );
					event.getEvent().setCanEdit(true);					
					
					incluirAgenda(event.getEvent());
					return;
				}

				controle = true;
				
				
				CalendarEvent calendarEvent = event.getEvent();
				removeEvent(event.getEvent());				
				
				LinkedHashMap< String , String > mapOther = new LinkedHashMap<String, String>();
				mapOther.put(fieldEndereco.getName(), calendarEvent.getAttribute(fieldEndereco.getName()) );

				String observacao = calendarEvent.getDescription();				
				addEvent(
							calendarEvent.getAttributeAsDate(getStartDateField())
							,calendarEvent.getAttributeAsDate(getEndDateField())
							,GoogleAgenda.this.tipoAgenda+":"+GoogleAgenda.this.agendaKey+":"+GoogleAgenda.this.descricao
							,observacao
							,mapOther			
				);				
				
				controle = false;
						
			}
		});

		this.addEventRemoveClickHandler(new EventRemoveClickHandler() {
			
			@Override
			public void onEventRemoveClick(CalendarEventRemoveClick event) {
				if ( ! event.getEvent().getCanEdit() ){
					SC.say(Tradutor.i18n.formGoogleItemAgendaNaoPodeSerExluido());
					event.cancel();
				}
				
			}
		});
		
		
		// -----------------------------------------------------------
		// Controla a remoção do item da agenda.
		// -----------------------------------------------------------
		this.addEventRemovedHandler(new EventRemovedHandler() {

			@Override
			public void onEventRemoved(CalendarEventRemoved event) {
				if( controle )
					return;								
				excluirAgenda(event.getEvent());
			}
		});

		// -----------------------------------------------------------
		// Controla a alteração do item da agenda.
		// -----------------------------------------------------------
		this.addEventChangedHandler(new EventChangedHandler() {

			@Override
			public void onEventChanged(CalendarEventChangedEvent event) {
		
				currentUpdateEvent = event.getEvent();
				Timer timer = new Timer() {
					@Override
					public void run() {
					    alterarAgenda(currentUpdateEvent);						
					}
				};		
				timer.schedule(60);
			}
		});
						
 
						
		
		setSnapVGap(2);
		setSnapHGap(2);
		setSnapToGrid(false);
		setSnapResizeToGrid(false);
		setExtraSpace(0);

		this.draw();	

		Timer timer = new Timer() {
			
			@Override
			public void run() {
				Date now = new Date();
				Date dataInicio = new Date(now.getYear(), now.getMonth(), -4, 0, 0, 0);
				Date dataFim 	= new Date(now.getYear(), now.getMonth() + 6, 23, 59, 59);
				
				loadTarefas(dataInicio, dataFim);
			}			
		};
		timer.schedule(30);
	}


	/**
	 * Carrega as tarefas do google agenda.
	 */
	public void loadTarefas(Date dataInicio, Date dataFim) {
		HowMGWTWindowWait.showWait(Tradutor.i18n.formGoogleAguardeConectandoGoogleAgenda());
		HowMGWTEntity entity = Fabrica.createEntity();
		entity.setAction(Services.acaoOCW0001);
		// entity.set
		Fabrica.createParameter(entity, "dataInicio", dataInicio);
		Fabrica.createParameter(entity, "dataFim", dataFim);
		Fabrica.createParameter(entity, "AGENDA_Type", this.tipoAgenda);
		Fabrica.createParameter(entity, "AGENDA_KEY" , this.agendaKey );
		Fabrica.createParameter(entity, "AGENDA_CodResponsavel" , this.codResponsavel);

		
		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>() {

			public void onFailure(Throwable caught) {
				HowMGWTWindowWait.hideWait();
				caught.printStackTrace();
				com.google.gwt.user.client.Window.alert(Tradutor.i18n.formEnderecoBase()+ GWT.getHostPageBaseURL() + "\n" + caught.getMessage());
			}

			public void onSuccess(HowMGWTEntity result) {
				if( HowMGWTUtilities.isAnalyseEntityIsError(result))
					return;
				
				HowMGWTTask[] eventos = new HowMGWTTask[result.getData().size()];
				int i = 0;
				for (String[] row : result.getData()) {
					eventos[i] = new HowMGWTTask(row);
					i++;
				}
				setData(eventos);

				HowMGWTWindowWait.hideWait();
			}
		};
		Configuracao.getProxyStruts().executeQuery(entity, callback);
	}
 
	
	private CalendarEvent currentInsertEvent;
	
	
	/**
	 * Incluir um novo evento na agenda.
	 */
	public void incluirAgenda( CalendarEvent event){
		currentInsertEvent = event;
		
		HowMGWTWindowWait.showWait();
		HowMGWTEntity entity = Fabrica.createEntity();
		entity.setAction(Services.acaoOCW0001);
 
		Fabrica.createParameter(entity, "acao", "incluirAgenda");
		Fabrica.createParameter(entity, "AGENDA_Type"			, this.tipoAgenda);
		Fabrica.createParameter(entity, "AGENDA_KEY" 			, this.agendaKey );
		Fabrica.createParameter(entity, "AGENDA_Name"			, event.getAttributeAsString(fieldAgendaKey.getName()));
		Fabrica.createParameter(entity, "AGENDA_Description"	, event.getAttributeAsString(fieldObservacao.getName()));
		Fabrica.createParameter(entity, "AGENDA_StartDate"  	, event.getAttributeAsDate(getStartDateField()));
		Fabrica.createParameter(entity, "AGENDA_FinishDate" 	, event.getAttributeAsDate(getEndDateField()));		
		Fabrica.createParameter(entity, "AGENDA_CodResponsavel" , this.codResponsavel);
		Fabrica.createParameter(entity, "AGENDA_Onde"			, event.getAttributeAsString(fieldEndereco.getName()));
		
		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>() {

			public void onFailure(Throwable caught) {
 				currentInsertEvent = null;
				HowMGWTWindowWait.hideWait();
				caught.printStackTrace();
				com.google.gwt.user.client.Window.alert(Tradutor.i18n.formEnderecoBase()+ GWT.getHostPageBaseURL() + "\n" + caught.getMessage());
			}

			public void onSuccess(HowMGWTEntity result) {
				if( HowMGWTUtilities.isAnalyseEntityIsError(result)){
	 				currentInsertEvent = null;
					return;
				}
				
				HowMGWTTask[] eventos = new HowMGWTTask[result.getData().size()];
				int i = 0;
				for (String[] row : result.getData()) {
					eventos[i] = new HowMGWTTask(row);
					currentInsertEvent.setAttribute("AGENDA_ID", eventos[i].getGoogleID());
					currentInsertEvent.setCanEdit(true);
					i++;
				}
 				HowMGWTWindowWait.hideWait();
 				currentInsertEvent = null;
			}
		};
		Configuracao.getProxyStruts().executeQuery(entity, callback);
		
	}
	
	private CalendarEvent currentUpdateEvent;
	/**
	 * Incluir um novo evento na agenda.
	 */
	public void alterarAgenda( CalendarEvent event){
		currentUpdateEvent = event;
		
		HowMGWTWindowWait.showWait();
		HowMGWTEntity entity = Fabrica.createEntity();
		entity.setAction(Services.acaoOCW0001);
 
		Fabrica.createParameter(entity, "acao", "alterarAgenda");
		Fabrica.createParameter(entity, "AGENDA_Type"			, this.tipoAgenda);
		Fabrica.createParameter(entity, "AGENDA_KEY" 			, this.agendaKey );
		Fabrica.createParameter(entity, "AGENDA_ID"				, event.getAttributeAsString("AGENDA_ID"));		
		Fabrica.createParameter(entity, "AGENDA_Name"			, event.getAttributeAsString(fieldAgendaKey.getName()));
		Fabrica.createParameter(entity, "AGENDA_Description"	, event.getAttributeAsString(fieldObservacao.getName()));
		Fabrica.createParameter(entity, "AGENDA_StartDate"  	, event.getAttributeAsDate(getStartDateField()));
		Fabrica.createParameter(entity, "AGENDA_FinishDate" 	, event.getAttributeAsDate(getEndDateField()));	
		Fabrica.createParameter(entity, "AGENDA_CodResponsavel" , this.codResponsavel);
		Fabrica.createParameter(entity, "AGENDA_Onde"			, event.getAttributeAsString(fieldEndereco.getName()));
		

		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>() {

			public void onFailure(Throwable caught) {
 				currentUpdateEvent = null;
				HowMGWTWindowWait.hideWait();
				caught.printStackTrace();
				com.google.gwt.user.client.Window.alert(Tradutor.i18n.formEnderecoBase()+ GWT.getHostPageBaseURL() + "\n" + caught.getMessage());
			}

			public void onSuccess(HowMGWTEntity result) {
				if( HowMGWTUtilities.isAnalyseEntityIsError(result)){
	 				currentUpdateEvent = null;
					return;
				}
				
				HowMGWTTask[] eventos = new HowMGWTTask[result.getData().size()];
				int i = 0;
				for (String[] row : result.getData()) {
					eventos[i] = new HowMGWTTask(row);
					i++;
				}
 				HowMGWTWindowWait.hideWait();
 				currentUpdateEvent = null;
			}
		};
		Configuracao.getProxyStruts().executeQuery(entity, callback);
		
	}
	
	
	
	private CalendarEvent currentDeleteEvent;
	public void excluirAgenda(CalendarEvent event){
		currentDeleteEvent = event;
		
		HowMGWTWindowWait.showWait();
		HowMGWTEntity entity = Fabrica.createEntity();
		entity.setAction(Services.acaoOCW0001);
 
		Fabrica.createParameter(entity, "acao", "excluirAgenda");
		Fabrica.createParameter(entity, "AGENDA_KEY"			, this.agendaKey );
		Fabrica.createParameter(entity, "AGENDA_Type"			, this.tipoAgenda);
		Fabrica.createParameter(entity, "AGENDA_KEY" 			, this.agendaKey );
		Fabrica.createParameter(entity, "AGENDA_ID"				, event.getAttributeAsString("AGENDA_ID"));
		Fabrica.createParameter(entity, "AGENDA_CodResponsavel" , this.codResponsavel);		
		
		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>() {

			public void onFailure(Throwable caught) {
 				currentDeleteEvent = null;
				HowMGWTWindowWait.hideWait();
				caught.printStackTrace();
				com.google.gwt.user.client.Window.alert(Tradutor.i18n.formEnderecoBase()+ GWT.getHostPageBaseURL() + "\n" + caught.getMessage());
			}

			public void onSuccess(HowMGWTEntity result) {
				if( HowMGWTUtilities.isAnalyseEntityIsError(result)){
	 				currentDeleteEvent = null;
					return;
				}
				
				HowMGWTTask[] eventos = new HowMGWTTask[result.getData().size()];
				int i = 0;
				for (String[] row : result.getData()) {
					eventos[i] = new HowMGWTTask(row);
					i++;
				}
 				HowMGWTWindowWait.hideWait();
 				currentDeleteEvent = null;
			}
		};
		Configuracao.getProxyStruts().executeQuery(entity, callback);
	}
}