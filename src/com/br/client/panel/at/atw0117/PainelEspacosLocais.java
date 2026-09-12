package com.br.client.panel.at.atw0117;


import java.util.ArrayList;
import java.util.Date;

import com.br.client.configuracao.Configuracao;
import com.br.client.model.at.atw0117.FormBean;
import com.br.client.model.at.entity.eTouchLocalEspaco;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelEspacosLocais extends VLayout{

	
	private Label labelMesLeft = new Label();
	private Label labelMesRight= new Label();
	
	private int tipoArea;
	
	private boolean created = false;
	
	private ActionButtonEspacoLocal actionButtonEspacoLocalLabel;
	
	private eTouchLocalEspaco[] touchLocalEspacos;
	
	private PainelTop painelTop;

	private Date firstCurrentDateNavegate;
	private Date firstCurrentDate 			= new Date();
	private Date currentDateNavegate		= firstCurrentDate;
	private Date lastCurrentDate;	
	
	private PainelDetalheEspacosLocais detalheEspacosLocais;
	
	ArrayList<ActionButtonCalendar> rowHeaderDayOfWeek 	= new ArrayList();
	ArrayList<ActionButtonCalendar> rowHeaderDayOfMonth = new ArrayList();

	private PainelAgendaTouchScreen parentTouchScreen;
	
	public PainelEspacosLocais(PainelAgendaTouchScreen touchScreen){
		this.parentTouchScreen = touchScreen;
		lastCurrentDate    = new Date( firstCurrentDate.getYear(), firstCurrentDate.getMonth(), firstCurrentDate.getDate()+TouchScreenConstantes.DEFAULT_MAX_DAY);
	}
	
	/**
	 * @return the painelTop
	 */
	public PainelTop getPainelTop() {
		return painelTop;
	}

	/**
	 * @param painelTop the painelTop to set
	 */
	public void setPainelTop(PainelTop painelTop) {
		this.painelTop = painelTop;
	}

	/**
	 * @return the touchLocalEspacos
	 */
	public eTouchLocalEspaco[] getTouchLocalEspacos() {
		return touchLocalEspacos;
	}

	/**
	 * @param touchLocalEspacos the touchLocalEspacos to set
	 */
	public void setTouchLocalEspacos(eTouchLocalEspaco[] touchLocalEspacos) {
		this.touchLocalEspacos = touchLocalEspacos;
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
					getPainelTop().getLogotipo().setSrc(bean.getLogotipo());
					
					if( bean.getEntityTouchLocaisEspacos() != null && bean.getEntityTouchLocaisEspacos().length > 0 ){
						try{
							// Se não estiver criado o calendário cria os elementos de apresentação
							// da agenda.
							if( ! created ){
								createCalendar(bean.getEntityTouchLocaisEspacos());
								created = true;
							}
							else{
								touchLocalEspacos = bean.getEntityTouchLocaisEspacos();
								configureData(currentDateNavegate);
							} 
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
 
		Date dataFim = new Date(firstCurrentDate.getYear(), firstCurrentDate.getMonth(), firstCurrentDate.getDate()+TouchScreenConstantes.DEFAULT_MAX_DAY);
		
		bean.setDataInicio(HowMGWTUtilities.getFormatDateDB(firstCurrentDate));
		bean.setDataFim(HowMGWTUtilities.getFormatDateDB(dataFim));
		bean.setCodEmpresa(Configuracao.getCodEmpresa());
		// Executa a carga de dados no servidor.
		struts.request(
				"atw0117.do?method=findAllLocalEspacos", 
				"ATW0117Form", 
				bean.toSendBody("")
		);
		
	}	
	
	
	private ImgButton actionLeft	= new ImgButton();
	private ImgButton actionRight	= new ImgButton();
	
	
	/**
	 * Cria os itens de calendário conforme os espaços e locais
	 * definidos na agenda.
	 * @param touchLocalEspacos
	 */
	public void createCalendar(eTouchLocalEspaco[] touchLocalEspacos){
		
		try{
			this.setTouchLocalEspacos(touchLocalEspacos);
			
			VLayout calendarioDiasSemana = new VLayout();
			calendarioDiasSemana.setWidth100();
			calendarioDiasSemana.setHeight100();
			calendarioDiasSemana.setMargin(5);




			

			HLayout topMeses = new HLayout();
			topMeses.setWidth100();
			topMeses.setHeight(26);
			
			topMeses.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(170, ""));

			labelMesLeft.setBorder("1px dotted #FFF0F5");
			labelMesLeft.setContents("<strong>Mes corrente</strong>");
			labelMesLeft.setHeight100();
			labelMesLeft.setWidth100();
			labelMesLeft.setAlign(Alignment.CENTER);

			labelMesRight.setBorder("1px dotted #FF4500");
			labelMesRight.setContents("<strong>Proximo Mes</strong>");
			labelMesRight.setHeight100();
			labelMesRight.setAlign(Alignment.CENTER);
			
			
			topMeses.addMember(labelMesLeft);
			topMeses.addMember(labelMesRight);
 		
			
			calendarioDiasSemana.addMember(topMeses);
			





			HLayout topDiasSemana = new HLayout();
			topDiasSemana.setWidth100();
			topDiasSemana.setHeight(54);
	
			// Dia do mes - Monta o cabeçalho com os dias da semana
			// Exemplo :
			// ===>             30    1     2     3     4     5     6     7     8     9
			//                  sab   dom   seg   ter   qua   qui   sex   sab   dom   seg
			for ( int i = 0; i <= TouchScreenConstantes.DEFAULT_MAX_DAY ; i ++){
			
				if ( i == 0 ){					
	
					topDiasSemana.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(TouchScreenConstantes.DEFAULT_WIDTH_ACTION_BUTTON_ESPACO_LOCAL-48, ""));
					
					actionLeft.setImageHeight(48);
					actionLeft.setImageWidth(48);
					actionLeft.setWidth(48);
					actionLeft.setHeight(48);
					actionLeft.setSrc("agenda/actionSetaEsquerda.png");
					actionLeft.addClickHandler(new ClickHandler() {					
						@Override
						public void onClick(ClickEvent event) {
							currentDateNavegate = firstCurrentDateNavegate;
							configureData(firstCurrentDateNavegate);
							onRefreshTopDate(firstCurrentDateNavegate);
						}
					});
					topDiasSemana.addMember(actionLeft);		
					
				}
				else{
					ActionButtonCalendar actionButtonCalendar = new ActionButtonCalendar(false);
					actionButtonCalendar.configureMouseOverOut();
					actionButtonCalendar.setCursor(Cursor.HAND);
					actionButtonCalendar.setLabel("<font size=4><strong> </strong></font>");
					actionButtonCalendar.setColumn(i);
					actionButtonCalendar.addClickHandler(new ClickHandler() {					
						@Override
						public void onClick(ClickEvent event) { 
							if( tipoArea == 0 && detalheEspacosLocais.getTouchLocalEspacos() != null && detalheEspacosLocais.getTouchLocalEspacos().length > 0 )
								tipoArea = HowMGWTUtilities.getInteger(detalheEspacosLocais.getTouchLocalEspacos()[0].getCodTipoLocal());
								
							for( ActionButtonCalendar dayOfMounth : rowHeaderDayOfMonth ){
								dayOfMounth.setSelected(false);
							}
							ActionButtonCalendar calendar = (ActionButtonCalendar)event.getSource();
							detalheEspacosLocais.setCurrentActionButtonCalendar(calendar);
							calendar.setTipoArea(tipoArea);
							calendar.setSelected(true);
							detalheEspacosLocais.showAgendaDia(true);
						}
					});
					topDiasSemana.addMember(actionButtonCalendar);
					rowHeaderDayOfMonth.add(actionButtonCalendar);
				}
			}
			actionRight.setWidth(48);
			actionRight.setHeight(48);
			actionRight.setImageHeight(48);
			actionRight.setImageWidth(48);
			actionRight.setSrc("agenda/actionSetaDireita.png");		
			actionRight.addClickHandler(new ClickHandler() {					
				@Override
				public void onClick(ClickEvent event) {
					currentDateNavegate = lastCurrentDate;
					configureData(currentDateNavegate);
					onRefreshTopDate(currentDateNavegate);
				}
			});
			topDiasSemana.addMember(actionRight);
			
			calendarioDiasSemana.addMember(topDiasSemana);
	
			HLayout topDiasMes = new HLayout();
			topDiasMes.setWidth100();
			topDiasMes.setHeight(54);
	
			// Dia da semana - Monta o cabeçalho com os dias da semana
			// Exemplo :
			//                  30    1     2     3     4     5     6     7     8     9
			// ===> ESPACO/DIA  sab   dom   seg   ter   qua   qui   sex   sab   dom   seg
			for ( int i = 0; i <= TouchScreenConstantes.DEFAULT_MAX_DAY ; i ++){
				if ( i == 0 ){					
					actionButtonEspacoLocalLabel = new ActionButtonEspacoLocal(false,null);
					topDiasMes.addMember(actionButtonEspacoLocalLabel);
					actionButtonEspacoLocalLabel.setLabel("<font size=4><strong>ESPACO/DIA</strong></font>");
				}
				else{
					ActionButtonCalendar actionButtonCalendar = new ActionButtonCalendar(false);
					topDiasMes.addMember(actionButtonCalendar);
					actionButtonCalendar.setLabel("<font size=4><strong> </strong></font>");
				
					rowHeaderDayOfWeek.add(actionButtonCalendar);
				}
			}
			calendarioDiasSemana.addMember(topDiasMes);
	
			// -----------------------------------------------------------------------------------
			// Cria os espaços e locais e tabula a utilização do espaço..
			// Exemplo : 
			// ===>  CASA DO ATOR   1    0    1    0   1    0    0   0    1    1		
			// -----------------------------------------------------------------------------------
			detalheEspacosLocais = new PainelDetalheEspacosLocais();
			detalheEspacosLocais.createDetalheEspacoLocais(this,touchLocalEspacos, rowHeaderDayOfMonth);
	
			calendarioDiasSemana.addMember(detalheEspacosLocais);
	
			configureData(firstCurrentDate);
			 
			this.addMember(calendarioDiasSemana);
		}
		catch(Throwable err){
			err.printStackTrace();
		}
	}

	/**
	 * Configura o painel conforme tipo de área passado como parametro.
	 * @param tipoArea
	 */
	public void showTipoArea(int tipoArea){
		this.tipoArea = tipoArea;
		if( TouchScreenConstantes.TIPO_ESPACO == tipoArea )
			actionButtonEspacoLocalLabel.setLabel("<font size=4><strong>ESPACO/DIA</strong></font>");
		if( TouchScreenConstantes.TIPO_LOCAL  == tipoArea )
			actionButtonEspacoLocalLabel.setLabel("<font size=4><strong>LOCAL/DIA</strong></font>");

		detalheEspacosLocais.showTipoArea(tipoArea);
	}

	
	
	/**
	 * Configura a data conforme a navegação do sistema.
	 * @param dataRef
	 */
	public void configureData(Date dataRef){

		if ( ! HowMGWTUtilities.isEquals( HowMGWTUtilities.getFormatDateDB(dataRef), HowMGWTUtilities.getFormatDateDB(this.firstCurrentDate) ) ){

			this.firstCurrentDate = dataRef;
			load();
			return;
		}
		
		this.firstCurrentDate = dataRef;
		this.firstCurrentDateNavegate = dataRef;
	
		int i = 0;
		Date dateRet = dataRef;
		Date date 	 = dataRef;
		
		int wLeft = 0;
		int wRight   = 0;
		
		String leftMes 	= "";
		String rigthMes = "";
		
		int currentMonth = dataRef.getMonth();
		
		for ( ActionButtonCalendar buttonCalendar : rowHeaderDayOfMonth ){

			int day = date.getDate();
			
			if( currentMonth == date.getMonth() ){
				wLeft += buttonCalendar.getWidth();
				if ( HowMGWTUtilities.isEmpty(leftMes))
					leftMes = HowMGWTUtilities.getMeses().get(HowMGWTUtilities.strZero(date.getMonth()+1,2)).substring(0,3);
			}
			else{
				wRight   += buttonCalendar.getWidth();
				if ( HowMGWTUtilities.isEmpty(rigthMes))
					rigthMes = HowMGWTUtilities.getMeses().get(HowMGWTUtilities.strZero(date.getMonth()+1,2)).substring(0,3);
			}
			
			buttonCalendar.setLabel("<font size=4><strong>"+day+"</strong></font>");
			buttonCalendar.setWeekAction(rowHeaderDayOfWeek.get(i));
			buttonCalendar.setDateCalendar(date);
			buttonCalendar.setTipoArea(this.tipoArea);
			rowHeaderDayOfWeek.get(i).setLabel("<font size=4><strong>"+DateTimeFormat.getFormat("EEE").format(date)+"</strong></font>");

			date 	= new Date(date.getYear(), 		date.getMonth(), 	date.getDate()+1);
			dateRet = new Date(dateRet.getYear(), 	dateRet.getMonth(), dateRet.getDate()-1);
			this.lastCurrentDate = date;	
			this.firstCurrentDateNavegate = dateRet;
			

			i ++;
		}

		this.showLotacaoAgenda(this.getTouchLocalEspacos());
		
		painelTop.setData(this.firstCurrentDate);
		
		this.labelMesRight.setWidth(wRight);
		this.labelMesLeft.setWidth(wLeft);
		
		this.labelMesLeft.setContents("<font size=3 color=#FFFFFF><strong>"+leftMes.toUpperCase()+"</strong></font>");
		this.labelMesRight.setContents("<font size=3 color=#FF4500><strong>"+rigthMes.toUpperCase()+"</strong></font>");
		
		if( this.detalheEspacosLocais != null )
			this.detalheEspacosLocais.refreshAgendaDia();
	}

	
	public void showLotacaoAgenda(eTouchLocalEspaco[] touchLocaisEspacos){
		
		this.touchLocalEspacos = touchLocaisEspacos;

		if( touchLocaisEspacos == null )
			return;

		for( eTouchLocalEspaco touchLocalEspaco : touchLocaisEspacos){
			ActionButtonEspacoLocal actionButtonEspacoLocal = this.detalheEspacosLocais.getActionsButtonEspacoLocal().get(touchLocalEspaco.getCodLocal());
			if ( actionButtonEspacoLocal == null )
				continue;
			
			actionButtonEspacoLocal.showLotacaoLocaisEspacos(touchLocalEspaco);
		}
	}

	/**
	 * @return the currentDateNavegate
	 */
	public Date getCurrentDateNavegate() {
		return currentDateNavegate;
	}

	/**
	 * @param currentDateNavegate the currentDateNavegate to set
	 */
	public void setCurrentDateNavegate(Date currentDateNavegate) {
		this.currentDateNavegate = currentDateNavegate;
	}

	/**
	 * @return the firstCurrentDate
	 */
	public Date getFirstCurrentDate() {
		return firstCurrentDate;
	}

	/**
	 * @param firstCurrentDate the firstCurrentDate to set
	 */
	public void setFirstCurrentDate(Date firstCurrentDate) {
		this.firstCurrentDate = firstCurrentDate;
	}
	
	protected void onRefreshTopDate(Date navegateDate){}
	
 
	
	public void onShowDetail(ActionButtonCalendar actionCalendar){
		// SC.say("Clicou em "+actionCalendar.getTipoArea()+"- Linha : "+actionCalendar.getRow() +" Coluna : " + actionCalendar.getColumn());
	
		for( ActionButtonCalendar dayOfMounth : rowHeaderDayOfMonth ){
			dayOfMounth.setSelected(false);
		}
		eTouchLocalEspaco touchEspaco =actionCalendar.getParentPainelDetalheEspacosLocais().getTouchLocalEspacos()[actionCalendar.getRow()];
		
		this.tipoArea = HowMGWTUtilities.getInteger(touchEspaco.getCodTipoLocal());
		ActionButtonEspacoLocal actionButtonEspacoLocal = actionCalendar.getParentPainelDetalheEspacosLocais().getActionsButtonEspacoLocal().get(touchEspaco.getCodLocal());
		detalheEspacosLocais.setCurrentActionButtonEspacoLocal(actionButtonEspacoLocal);
		
		
		ActionButtonCalendar calendar = rowHeaderDayOfMonth.get(actionCalendar.getColumn());
		detalheEspacosLocais.setCurrentActionButtonCalendar(calendar);
		calendar.setTipoArea(tipoArea);
		calendar.setSelected(true);
		detalheEspacosLocais.showAgendaDia(true);
 
	}	
}