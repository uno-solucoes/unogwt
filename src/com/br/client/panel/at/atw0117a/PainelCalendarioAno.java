package com.br.client.panel.at.atw0117a;


import java.util.Date;

import com.br.client.configuracao.Configuracao;
import com.br.client.model.at.atw0117.FormBean;
import com.br.client.model.at.entity.eTouchLocalEspaco;
import com.br.client.model.at.entity.eTouchResumo;
import com.br.client.model.cd.entity.eFeriado;
import com.br.client.panel.at.atw0117a.calendar.HowMGWTCalendar;
import com.google.gwt.core.client.Scheduler;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.model.HowMGWTTask;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


public class PainelCalendarioAno extends HLayout{

	private boolean viewMes = false;
	
	public boolean isViewMes() {
		return viewMes;
	}

	public void setViewMes(boolean viewMes) {
		this.viewMes = viewMes;
	}

	private HLayout globalLayout = new HLayout();
	
	private eTouchLocalEspaco[] touchLocalEspacos;

	public eTouchLocalEspaco[] getTouchLocalEspacos() {
		return touchLocalEspacos;
	}

	public void setTouchLocalEspacos(eTouchLocalEspaco[] touchLocalEspacos) {
		this.touchLocalEspacos = touchLocalEspacos;
	}

	private PainelCalendarioMensal painelCalendarioMensal = new PainelCalendarioMensal();

	public PainelCalendarioMensal getPainelCalendarioMensal() {
		return painelCalendarioMensal;
	}

	public VLayout mainLayout = new VLayout();

	private Date currentDate = new Date();
	
	private HowMGWTCalendar mes1  = new HowMGWTCalendar();
	private HowMGWTCalendar mes2  = new HowMGWTCalendar();
	private HowMGWTCalendar mes3  = new HowMGWTCalendar();
	private HowMGWTCalendar mes4  = new HowMGWTCalendar();
	private HowMGWTCalendar mes5  = new HowMGWTCalendar();
	private HowMGWTCalendar mes6  = new HowMGWTCalendar();
	private HowMGWTCalendar mes7  = new HowMGWTCalendar();
	private HowMGWTCalendar mes8  = new HowMGWTCalendar();
	private HowMGWTCalendar mes9  = new HowMGWTCalendar();
	private HowMGWTCalendar mes10 = new HowMGWTCalendar();
	private HowMGWTCalendar mes11 = new HowMGWTCalendar();
	private HowMGWTCalendar mes12 = new HowMGWTCalendar();

	HowMGWTCalendar[] calendars   = new HowMGWTCalendar[]{
			mes1,
			mes2,
			mes3,
			mes4,
			mes5,
			mes6,
			mes7,
			mes8,
			mes9,
			mes10,
			mes11,
			mes12
	};
	
	private HLayout line1Layout = new HLayout();
	private HLayout line2Layout = new HLayout();
	private HLayout line3Layout = new HLayout();
	
	private PainelTop parentPainelTop;
	
	private PainelLocais painelLocais = new PainelLocais(this);
	
	public PainelCalendarioAno(PainelTop painelTop){

		this.parentPainelTop = painelTop;
		
		globalLayout.setWidth100();
		globalLayout.setHeight100();
		
		
		painelCalendarioMensal.setWidth100();
		painelCalendarioMensal.setHeight100();
		
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setPadding(10);
		mainLayout.setBackgroundColor("#FFFFFF");
				
		
		globalLayout.addMember(painelLocais);
		
		this.line1Layout.setWidth100();
		this.line1Layout.setHeight100();
		this.mainLayout.addMember(this.line1Layout);
		
		line1Layout.addMember(mes1);
		line1Layout.addMember(mes2);
		line1Layout.addMember(mes3);
		line1Layout.addMember(mes4);
		

		// ---------------------------------------------------------------------------------------------

		this.line2Layout.setWidth100();
		this.line2Layout.setHeight100();

		line2Layout.addMember(mes5);
		line2Layout.addMember(mes6);
		line2Layout.addMember(mes7);
		line2Layout.addMember(mes8);		

		this.mainLayout.addMember(this.line2Layout);

		// ---------------------------------------------------------------------------------------------

		this.line3Layout.setWidth100();
		this.line3Layout.setHeight100();
		this.mainLayout.addMember(this.line3Layout);

		line3Layout.addMember(mes9);
		line3Layout.addMember(mes10);
		line3Layout.addMember(mes11);
		line3Layout.addMember(mes12);		

		this.globalLayout.addMember(this.mainLayout);		

		this.globalLayout.addMember(this.painelCalendarioMensal);
		this.painelCalendarioMensal.setVisible(false);

		this.setMargin(10);

		globalLayout.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(5, ""));

		this.addMember(globalLayout);

		painelCalendarioMensal.setParentPainelCalendarioAno(this);

		for ( HowMGWTCalendar cal : calendars ){			
			cal.setParentCalendarioAno(this);
			cal.getCalendar().setParentPainelTop(painelTop);
		}
		
		loadConfiguracoes();		
	}


	
	public PainelTop getParentPainelTop() {
		return parentPainelTop;
	}

	public void showPeriodCalendar(Date date, boolean loaderCalendar){
		this.currentDate = date;

		int mesAtual = this.currentDate.getMonth();
		int anoAtual = this.currentDate.getYear();
		int i 		 = 0;
		
		HowMGWTTask[] tasks = new HowMGWTTask[]{}; 
		
		for ( HowMGWTCalendar cal : calendars ){
			
			Date dataCalendar = new Date(anoAtual, i , 1);
			
			i ++;
			
			cal.showCalendar(dataCalendar);
			cal.showTasks(tasks);
		}
		if( loaderCalendar ){
			loadCalendar();
		}
	
	}
	
	
	public void refreshDate(HowMGWTTask[] tasks){
		int i 		 = 0;
		int mesAtual = this.currentDate.getMonth();
		int anoAtual = this.currentDate.getYear();
		for ( HowMGWTCalendar cal : calendars ){			
			Date dataCalendar = new Date(anoAtual, i , 1);

			i ++;			
			cal.showTasks(tasks);
		}
	}

	
	
	
	
	public void load(){
		
		HowMGWTWindowWait.showWait("Aguarde carregando eventos da agenda...");		
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()){
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, false)){ 
					return;
				}
				try{
					FormBean bean = (FormBean)formBean;					
					if( bean.getEntityTouchLocaisEspacos() != null && bean.getEntityTouchLocaisEspacos().length > 0 ){
						try{
								eTouchLocalEspaco[] touchLocalEspacos = bean.getEntityTouchLocaisEspacos();
								
							
						} 						
						catch(Throwable er){
							er.printStackTrace();
						}
						HowMGWTWindowWait.hideWait();
					}
					else{
						HowMGWTWindowWait.hideWait();
						SC.say("não encontrou registros ");
					}
				}
				catch(Throwable err){
					err.printStackTrace();
				}
				
			}			
		};
		FormBean bean = new FormBean();		
 
		Date dataFim = mes12.getCurrentDate();
		
		bean.setDataInicio(HowMGWTUtilities.getFormatDateDB(mes1.getCurrentDate()));
		bean.setDataFim(HowMGWTUtilities.getFormatDateDB(dataFim));
		bean.setCodEmpresa(Configuracao.getCodEmpresa());
		
		// Executa a carga de dados no servidor.
		struts.request(
				"atw0117.do?method=findAllLocalEspacos", 
				"ATW0117Form", 
				bean.toSendBody("")
		);
		
	}
	
	
	public HowMGWTTask[] onLoadCalendar(FormBean formBean){
		FormBean bean = (FormBean)formBean;
		HowMGWTTask[] tasks = new HowMGWTTask[0];
		if( bean.getEntityTouchResumo() != null &&bean.getEntityTouchResumo().length > 0 ){
			HowMGWTTask task;
			int id = 0;
			if ( bean.getEntityTouchResumo() != null ){
				tasks = new HowMGWTTask[bean.getEntityTouchResumo().length];
				for ( eTouchResumo resumo : bean.getEntityTouchResumo() ){
					task = new HowMGWTTask();
					task.setEventId(id);							
					task.setName( "" );
					task.setDescription( "" );
					task.setStartDate(HowMGWTUtilities.getDate(resumo.getData()));
					task.setEndDate(HowMGWTUtilities.getDate(resumo.getData()));
					task.setHowMUserObject(resumo);
//					eFeriado feriado = getPainelCalendarioMensal().getParentPainelCalendarioAno().getParentPainelTop().getMapFeriados().get(resumo.getData());
//					// if( feriado != null ){
//						task.setEventWindowStyle("agendaVillaButtonYellow");
//					// }								
					tasks[id] = task;

					id ++;
				}
			}
		}		
		if( isViewMes() ){
			getPainelCalendarioMensal().onRefreshChangeLocal();
		}		
		return tasks;
	}
	
	
	public void loadCalendar(){

		HowMGWTWindowWait.showWait("Aguarde atualizando os eventos da agenda...");

		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()){
			@Override
			public void onResponse(HowMGWTFormBean formBean) {

				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, false)){ 
					return;
				}
				try{
					HowMGWTTask[] tasks = onLoadCalendar((FormBean) formBean);
					refreshDate(tasks);
					HowMGWTWindowWait.hideWait();												

				}
				catch(Throwable err){
					err.printStackTrace();
				}
				
			}			
		};
		FormBean bean = new FormBean();			
		
		HowMGWTUtilities.getDefaultCalendar().setTime(mes1.getCurrentDate());		
				
		Date dtInicio = HowMGWTUtilities.getDefaultCalendar().getFirstDateMonth();
		
		HowMGWTUtilities.getDefaultCalendar().setTime(mes12.getCurrentDate());
		Date dtFim    = HowMGWTUtilities.getDefaultCalendar().getLastDateMonth();
		
		bean.setCodEmpresa(Configuracao.getCodEmpresa());
		
		bean.setDataInicio(HowMGWTUtilities.getFormatDateDB(dtInicio));
		bean.setDataFim(HowMGWTUtilities.getFormatDateDB(dtFim));
		bean.setCodLocal(this.parentPainelTop.getEntityLocalEspaco().getCodLocal());		
		
		// Executa a carga de dados no servidor.
		struts.request(
				"atw0117.do?method=findResumo", 
				"ATW0117Form", 
				bean.toSendBody("")
		);
		
	}
	

	
	

	
	
	
	
	
	
	
	
	
	/**
	 * Carrega as configurações iniciais da agenda 
	 */
	public void loadConfiguracoes(){
		HowMGWTWindowWait.showWait("Aguarde carregando eventos da agenda...");		
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()){
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, false)){ 
					return;
				}
				try{
					FormBean bean = (FormBean)formBean;					
					if( bean.getEntityTouchLocaisEspacos() != null && bean.getEntityTouchLocaisEspacos().length > 0 ){
						try{
							eTouchLocalEspaco[] touchLocalEspacos = bean.getEntityTouchLocaisEspacos();							

							painelCalendarioMensal.setPermiteAlterarCalendario( HowMGWTUtilities.getBoolean( bean.getIndPermiteAlterarCalendario() ) );
							painelCalendarioMensal.setPermiteAprovarCalendario( HowMGWTUtilities.getBoolean( bean.getIndPermiteAprovarCalendario() ) ); 
							painelCalendarioMensal.setPermiteExcluirCalendario( HowMGWTUtilities.getBoolean( bean.getIndPermiteExcluirCalendario() ) );
							painelCalendarioMensal.setPermiteIncluirCalendario( HowMGWTUtilities.getBoolean( bean.getIndPermiteIncluirCalendario() ) );

							painelLocais.showLocais(touchLocalEspacos);
							parentPainelTop.showFeriados(bean.getEntityFeriados());							

							Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {

								@Override
								public void execute() {
									showPeriodCalendar(currentDate,true);										
								}
							});

						} 						
						catch(Throwable er){
							er.printStackTrace();
						}
						HowMGWTWindowWait.hideWait();
					}
					else{
						HowMGWTWindowWait.hideWait();
						SC.say("não encontrou registros ");
					}
				}
				catch(Throwable err){
					err.printStackTrace();
				}
				
			}			
		};
		FormBean bean = new FormBean();		
 
		Date dataFim = mes12.getCurrentDate();
		
		bean.setDataInicio(HowMGWTUtilities.getFormatDateDB(mes1.getCurrentDate()));
		bean.setDataFim(HowMGWTUtilities.getFormatDateDB(dataFim));
		bean.setCodEmpresa(Configuracao.getCodEmpresa());
		// Executa a carga de dados no servidor.
		struts.request(
				"atw0117.do?method=findAllLocalEspacos", 
				"ATW0117Form", 
				bean.toSendBody("")
		);
	}


	
	

	/**
	 * Carrega as configurações iniciais da agenda 
	 */
	public void loadFeriados(){
		HowMGWTWindowWait.showWait("Aguarde carregando eventos da agenda...");		
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()){
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, false)){ 
					return;
				}
				FormBean bean = (FormBean)formBean;		 		
				parentPainelTop.showFeriados(bean.getEntityFeriados());		
			}			
		};
		FormBean bean = new FormBean();		

		Date dataFim = mes12.getCurrentDate();	
		bean.setDataInicio(HowMGWTUtilities.getFormatDateDB(mes1.getCurrentDate()));
		bean.setDataFim(HowMGWTUtilities.getFormatDateDB(dataFim));
		bean.setCodEmpresa(Configuracao.getCodEmpresa());
		// Executa a carga de dados no servidor.
		struts.request(
				"atw0117.do?method=findAllLocalEspacos", 
				"ATW0117Form", 
				bean.toSendBody("")
		);
	}






	public void onShowDetail(final HowMGWTCalendar calendar, Date data){
		if( data != null )
			getPainelCalendarioMensal().getCalendarioMensalDetalhado().setChosenDate(data);
		
		getPainelCalendarioMensal().onShowChangeData(data);
		onShowDetail(calendar);
	}
	
	public void onShowDetail(final HowMGWTCalendar calendar){
		this.mainLayout.animateHide(AnimationEffect.SLIDE);
		this.painelCalendarioMensal.animateShow(AnimationEffect.SLIDE);
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
			
			@Override
			public void execute() {
				setViewMes(true);
				painelCalendarioMensal.showMes(calendar);
			}
		});		
	}

	public void onShowCalendar(boolean changed){
		this.mainLayout.animateShow(AnimationEffect.SLIDE);
		this.painelCalendarioMensal.animateHide(AnimationEffect.SLIDE);
		setViewMes(false);
	}	

	/**
	 * Recebe este evento sempre que for alterado o local do evento.
	 * @param localEspaco
	 */
	public void showLocal(eTouchLocalEspaco localEspaco){
		this.parentPainelTop.refreshLocal(localEspaco);
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
			@Override
			public void execute() {
				showPeriodCalendar(currentDate, true);		
			}
		});
	 }
	
	
	public void anoAnterior(){
		
		Date data = new Date(this.currentDate.getYear()-1,this.currentDate.getMonth(),1);
		this.currentDate = data;		
		showPeriodCalendar(currentDate,false);
		loadFeriados();
		showPeriodCalendar(currentDate,true);
		parentPainelTop.refreshTitle(data);				
	}
	
	public void proximoAno(){

		Date data = new Date(this.currentDate.getYear()+1,this.currentDate.getMonth(),1);
		this.currentDate = data;
		showPeriodCalendar(currentDate, false);
		loadFeriados();
		showPeriodCalendar(currentDate, true);
		parentPainelTop.refreshTitle(data);		
	}

	public void refreshAno(){
		showPeriodCalendar(currentDate, true);
		parentPainelTop.refreshTitle(currentDate);		
	}	
}