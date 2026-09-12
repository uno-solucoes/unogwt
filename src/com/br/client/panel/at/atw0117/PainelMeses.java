package com.br.client.panel.at.atw0117;


import java.util.ArrayList;
import java.util.Date;

import com.br.client.configuracao.Configuracao;
import com.br.client.model.at.atw0117.FormBean;
import com.br.client.model.at.entity.eTouchResumo;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.model.HowMGWTTask;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
import com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent;
import com.smartgwt.client.widgets.calendar.events.DayBodyClickHandler;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelMeses extends Window{

	private Date currentDate	= new Date();
	private int year 			= currentDate.getYear();
	private int month  			= currentDate.getMonth();
	
	private PanelCalendar painelCalendario = new PanelCalendar();

	private ActionMeses currentActionMes;
	private HLayout windowLayout = new HLayout();
	
	private VLayout mainLayout = new VLayout();
	
	private Img imgAno = new Img();
	private ArrayList<ActionMeses> actionMeses = new ArrayList<ActionMeses>();
	
	private ImgButton actionLeft	= new ImgButton();
	private ImgButton actionRight	= new ImgButton();
	
	private Label labelAno = new Label();
	
	public PainelMeses(){
	
		this.setShowModalMask(true);
		this.setModalMaskOpacity(5);
		this.setIsModal(true);
		
		this.setShowHeader(false);
		this.setShowEdges(false);
		
		int heightPanel = 570;
		int widthPanel  = 500;
		
		this.windowLayout.setOverflow(Overflow.HIDDEN);
		this.setOverflow(Overflow.HIDDEN);
		this.setCanDragResize(false);
		this.setCanDragReposition(false);
		// this.setShowHeader(false);
		this.setShowEdges(false);
		
		windowLayout.setWidth100();
		windowLayout.setHeight100();
		
 		this.setShowShadow(true);
				
		this.mainLayout.setWidth(widthPanel-40);
		this.mainLayout.setHeight(heightPanel-6);
		this.mainLayout.setMargin(2);
		this.mainLayout.setShowShadow(true);
 
		this.setStyleName("calendarVillaBisutti");

		this.mainLayout.setMargin(10);
		this.mainLayout.setStyleName("calendarVillaBisuttiNav");
		
		this.setHeight(heightPanel);
		this.setWidth(widthPanel);
		
		HLayout navegacaoAno = new HLayout();
		navegacaoAno.setWidth100();
		navegacaoAno.setHeight(80);
		navegacaoAno.setAlign(Alignment.CENTER);
		
		actionLeft.setImageHeight(48);
		actionLeft.setImageWidth(48);
		actionLeft.setWidth(48);
		actionLeft.setHeight(48);
		actionLeft.setSrc("agenda/actionSetaEsquerda.png");
		actionLeft.addClickHandler(new ClickHandler() {					
			@Override
			public void onClick(ClickEvent event) {
				year --;
				onRefreshCalendario();
			}
		});		
		navegacaoAno.addMember(actionLeft);
		
		imgAno.setWidth(80);
		imgAno.setHeight(80);
		imgAno.setSrc("agenda/actionCalendar.png");
		navegacaoAno.addMember(imgAno);
		
		labelAno.setParentElement(imgAno);
		labelAno.setLeft(10);
		labelAno.setTop(25);
		labelAno.setWidth(70);
		labelAno.setHeight(50);
		labelAno.setContents("<FONT SIZE=5><STRONG>2012</STRONG></FONT>");
		labelAno.show();
		
		
		actionRight.setWidth(48);
		actionRight.setHeight(48);
		actionRight.setImageHeight(48);
		actionRight.setImageWidth(48);
		actionRight.setSrc("agenda/actionSetaDireita.png");		
		actionRight.addClickHandler(new ClickHandler() {					
			@Override
			public void onClick(ClickEvent event) {
				year ++;
				onRefreshCalendario();
			}
		});	
		navegacaoAno.addMember(actionRight);
		mainLayout.addMember(navegacaoAno);
		
		
		ActionMeses actionData;
		
		HLayout centerNavegacaoMeses = new HLayout();
		centerNavegacaoMeses.setWidth100();
		centerNavegacaoMeses.setAutoHeight();
		centerNavegacaoMeses.setAlign(Alignment.CENTER);
		
		VLayout navegacaoMeses = new VLayout();
		navegacaoMeses.setAutoWidth();
		navegacaoMeses.setHeight100();
		
		HLayout mesestTop = new HLayout();
		mesestTop.setWidth100();
		mesestTop.setHeight100();
		
		HLayout mesesCenter = new HLayout();
		mesesCenter.setWidth100();
		mesesCenter.setHeight100();

		HLayout mesesBottom = new HLayout();
		mesesBottom.setWidth100();
		mesesBottom.setHeight100();

		for ( int i = 1; i < 13 ; i ++){
			actionData = new ActionMeses(){
				@Override
				protected void onActionMes(ActionMeses actionMeses) {
					PainelMeses.this.onActionMes(actionMeses);
				}
			};
			actionData.setMes(i);
	
			if ( i < 5 ){
				mesestTop.addMember(actionData);
				mesestTop.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(5,""));
			}
			else if ( i < 9) {
				mesesCenter.addMember(actionData);
				mesesCenter.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(5,""));				
			}
			else{
				mesesBottom.addMember(actionData);
				mesesBottom.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(5,""));				
			}
			this.actionMeses.add(actionData);
		}

		navegacaoMeses.addMember(mesestTop);
		navegacaoMeses.addMember(mesesCenter);
		navegacaoMeses.addMember(mesesBottom);
		
		centerNavegacaoMeses.addMember(navegacaoMeses);
		
		
		painelCalendario.addDayBodyClickHandler(new DayBodyClickHandler(){  
            public void onDayBodyClick(DayBodyClickEvent event) {  
                String nameStr = "";  
                CalendarEvent[] events = event.getEvents();  
//                if( events.length > 0 ) {
//	                currentDate = events[0].getStartDate();
//                }
//                else{
                	
//                }
                currentDate = event.getDate();
            	PainelMeses.this.animateHide(AnimationEffect.FLY);
            	Timer timer = new Timer() {

					@Override
					public void run() {
						onCalendarSelectDate(currentDate);
					}

				};
				timer.schedule(500);
            }  
		});  
		  
		
		this.mainLayout.addMember(centerNavegacaoMeses);
		this.mainLayout.addMember(painelCalendario);
		
		


		
 
		windowLayout.addMember(this.mainLayout);

		
		VLayout toolbar = new VLayout();
		toolbar.setWidth(40);
		toolbar.setHeight100();
		toolbar.setAlign(Alignment.CENTER);
		
		ImgButton actionVoltar = new ImgButton();
		actionVoltar.setWidth(48);
		actionVoltar.setHeight(48);			
		actionVoltar.setSrc("agenda/action_voltar_loop.png");
		toolbar.addMember(actionVoltar);
		
		actionVoltar.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {				
				animateHide(AnimationEffect.FLY);
			}
		});
		toolbar.addMember(actionVoltar);
		windowLayout.addMember(toolbar);
		
		
		
		
		this.addItem(windowLayout);
		
		
		
		// this.addMember(windowLayout);
	}

	/**
	 * @return the mainLayout
	 */
	public VLayout getMainLayout() {
		return mainLayout;
	}

	/**
	 * @param mainLayout the mainLayout to set
	 */
	public void setMainLayout(VLayout mainLayout) {
		this.mainLayout = mainLayout;
	}
	
	public void onActionMes(ActionMeses actionMes){

		if ( this.currentActionMes != null ){
			this.currentActionMes.onSelected(false);
		}
		actionMes.onSelected(true);
		this.currentActionMes = actionMes;
		
		setMonth(actionMes.getMes());
		onRefreshCalendario();

	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	
	public void setCurrentDate(Date currentDate){
		this.year 			= currentDate.getYear();
		this.month 			= currentDate.getMonth()+1;
		this.currentDate 	= currentDate;
		
		currentActionMes = actionMeses.get(this.month-1);
		currentActionMes.setMes(this.month);
		currentActionMes.onSelected(true);
		
		onRefreshCalendario();
	}

	public void onRefreshCalendario(){
		labelAno.setContents("<FONT SIZE=5><STRONG>"+(year+1900)+"</STRONG></FONT>");
		this.currentDate = new Date(this.year, this.month-1,1,0,0,0);
		painelCalendario.setChosenDate(currentDate);
		
		loadCalendar();
	}
 
	public void loadCalendar(){
		
		HowMGWTWindowWait.showWait("Aguarde carregando calendario do mes...");

		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()){
			@Override
			public void onResponse(HowMGWTFormBean formBean) {

				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, false)){ 
					return;
				}
				try{
					FormBean bean = (FormBean)formBean;
					if( bean.getEntityTouchResumo() != null &&bean.getEntityTouchResumo().length > 0 ){
 
						HowMGWTTask task;
						int id = 0;
						HowMGWTTask[] tasks = new HowMGWTTask[0];
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
								tasks[id] = task;
	
								id ++;
							}
						}
						painelCalendario.setData(tasks);
							
						HowMGWTWindowWait.hideWait();												
					}
				}
				catch(Throwable err){
					err.printStackTrace();
				}
				
			}			
		};
		FormBean bean = new FormBean();		
		
		HowMGWTUtilities.getDefaultCalendar().setTime(this.currentDate);		
		Date dtInicio = HowMGWTUtilities.getDefaultCalendar().getFirstDateMonth();
		Date dtFim    = HowMGWTUtilities.getDefaultCalendar().getLastDateMonth();
		
		bean.setCodEmpresa(Configuracao.getCodEmpresa());
		bean.setDataInicio(HowMGWTUtilities.getFormatDateDB(dtInicio));
		bean.setDataFim(HowMGWTUtilities.getFormatDateDB(dtFim));
		// Executa a carga de dados no servidor.
		struts.request(
				"atw0117.do?method=findResumo", 
				"ATW0117Form", 
				bean.toSendBody("")
		);
		
	}
	
	public void onCalendarSelectDate(Date currentDate){		
	}
}