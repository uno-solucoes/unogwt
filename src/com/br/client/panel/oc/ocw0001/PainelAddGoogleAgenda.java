package com.br.client.panel.oc.ocw0001;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.oc.ocw0001.UI.GoogleAgenda;
import com.br.client.panel.oc.ocw0001.UI.GoogleAgendaTaskListGrid;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.howmake.client.form.UI.HowMGWTLabel;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.model.HowMGWTDataRecord;
import com.howmake.client.form.partner.HowMGWTConstants;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.types.BackgroundRepeat;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.TabDeselectedEvent;
import com.smartgwt.client.widgets.tab.events.TabDeselectedHandler;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;

public class PainelAddGoogleAgenda extends HowMGWTWindow{
	
	private GoogleAgenda googleAgenda;
	private GoogleAgendaTaskListGrid grid = new GoogleAgendaTaskListGrid();
	
	private String tipoAgenda;
	private String labelAgenda;
	private String codOC;
	private String descricao;
	private String codResponsavel;
	private String observacao;
	private String onde;
	
	public PainelAddGoogleAgenda(String tipoAgenda, String labelAgenda, String codOC, String descricao, String codResponsavel, String observacao, String onde){		
		
		this.tipoAgenda 	= tipoAgenda;
		this.labelAgenda 	= labelAgenda;
		this.codOC 			= codOC;
		this.descricao		= descricao;
		this.codResponsavel = codResponsavel;
		this.observacao     = observacao;
		this.onde			= onde;
		
		// Olhar Mais tarde : http://www.freemacware.com/task-list/ 'emuito legal

		HLayout hl = new HLayout();
		hl.setWidth100();
		hl.setHeight100();
		
//		VLayout margin = new VLayout();
//		//margin.setWidth(66);
//		margin.setHeight100();
//		margin.setBackgroundImage( Tradutor.i18n.cfgImagesGeralIdioma()+"bgEspiral.gif");
//		margin.setBackgroundRepeat(BackgroundRepeat.REPEAT_Y);
		
		TabSet leftTabSet = new TabSet();  
        leftTabSet.setTabBarPosition(Side.LEFT);  
        leftTabSet.setTabBarAlign(Side.TOP); 
        leftTabSet.setWidth100();  
        leftTabSet.setWidth100(); 
        leftTabSet.setBackgroundImage(Tradutor.i18n.cfgImagesGeralIdioma()+"bgTabAgenda.gif");
		leftTabSet.setBackgroundRepeat(BackgroundRepeat.REPEAT);
		leftTabSet.setTabBarThickness(36);

		leftTabSet.addTabDeselectedHandler(new TabDeselectedHandler() {
			
			@Override
			public void onTabDeselected(TabDeselectedEvent event) {
				if( event.getTabNum() == 1){
					grid.animateShow(AnimationEffect.SLIDE);
					grid.setAnimateResizeTime(160);	
			
				}
				else{
							
				}
			}
		});
		
		
		leftTabSet.addTabSelectedHandler(new TabSelectedHandler() {
			
			@Override
			public void onTabSelected(TabSelectedEvent event) {
				if ( event.getTabNum() == 1 ){
					loadTaskList();
				}
				else if ( event.getTabNum() == 0){
				}
			}
		});
 
		this.setModalMaskOpacity(HowMGWTConstants.WINDOW_MODAL_MASK_OPACITY);		  
		this.setShowModalMask(true);		

//		this.setWidth((Window.getClientWidth()-100)+"px");
//		this.setHeight((Window.getClientHeight()-100)+"px");
		
		this.setWidth100();
		this.setHeight100();
		this.setCanDragResize(false);

		
		this.centerInPage();
		this.setDismissOnEscape(true);		
		this.setIsModal(true);	

		googleAgenda = new GoogleAgenda(tipoAgenda, labelAgenda, codOC, descricao, this.codResponsavel, observacao, onde);
		googleAgenda.setWidth100();
		googleAgenda.setHeight100();
					
        Tab tabAgenda = new Tab("", Tradutor.i18n.cfgImagesGeralIdioma()+"tabAgendaGoogle.gif");  
        tabAgenda.setPane(googleAgenda);        
        
        
        
        VLayout vlTodo = new VLayout();
        vlTodo.setWidth100();
        vlTodo.setHeight100();
        vlTodo.setOpacity(100);
        vlTodo.setBackgroundImage(Tradutor.i18n.cfgImagesGeralIdioma()+"bgTabAgenda.gif");
        vlTodo.setBackgroundRepeat(BackgroundRepeat.REPEAT);
         
        HowMGWTLabel labelTitulo = new HowMGWTLabel();
        labelTitulo.setWidth100();
        labelTitulo.setHeight(45);
        labelTitulo.setHowMValue("<h2>"+Tradutor.i18n.formListaTarefasAgendadas()+" : <font color=blue>"+labelAgenda+":"+tipoAgenda+":<B>"+codOC+"</B></font></h2>");
        labelTitulo.setOpacity(100);
        labelTitulo.setOverflow(Overflow.HIDDEN);
		
        vlTodo.addMember(labelTitulo);
        
        grid.setHeight100();
        grid.setWidth100();
        grid.setOpacity(100);
        vlTodo.addMember(grid);
        
        Tab tabListaTarefas = new Tab("", Tradutor.i18n.cfgImagesGeralIdioma()+"tabListaTarefas.gif"); 
        tabListaTarefas.setPrompt(Tradutor.i18n.formListaTarefasAgendadas()+" : <font color=blue>"+labelAgenda+":"+tipoAgenda+":<B>"+codOC+"</B></font>");
        tabListaTarefas.setPane(vlTodo);

        
        
        leftTabSet.addTab(tabAgenda);
        leftTabSet.addTab(tabListaTarefas);
        
//        hl.addMember(margin);
        hl.addMember(leftTabSet);
        
		this.addItem(hl);
	}
	
	public String getHowMGWTTitle(){
		return Tradutor.i18n.formTituloOCW0001GA();
	}
	public String getHowMGWTPrograma(){
		return "OCW0001GA";
	}
	
	public void showAddGoogleAgenda(String oc){


		this.show();

	}
	
	
	/**
	 * Carrega a lista de tarefas do documento relacionado.
	 */
	public void loadTaskList(){
		
		this.googleAgenda.getRecordList();
		
		String key = this.tipoAgenda+":"+this.codOC;
		
		HowMGWTDataRecord record;
		
		RecordList todoRecords = new RecordList();
		RecordList eventRecords = googleAgenda.getRecordList();
		for ( int i = 0 ; i < eventRecords.getLength() ; i ++ ){
			Record task = eventRecords.get(i);
			if( task.getAttributeAsString(googleAgenda.getNameField()).startsWith(key)){
				record = new HowMGWTDataRecord();
				record.setAttribute(grid.fieldData.getName()		, DateTimeFormat.getFormat("dd/MM/yyyy").format(task.getAttributeAsDate(googleAgenda.getStartDateField())));
				record.setAttribute(grid.fieldHoraInicio.getName()	, DateTimeFormat.getFormat("HH:mi").format(task.getAttributeAsDate(googleAgenda.getStartDateField())));
				record.setAttribute(grid.fieldHoraFim.getName()		, DateTimeFormat.getFormat("HH:mi").format(task.getAttributeAsDate(googleAgenda.getEndDateField())));

				record.setAttribute(grid.fieldNome.getName()		, task.getAttributeAsString(googleAgenda.getNameField()));
				record.setAttribute(grid.fieldObservacao.getName()	, task.getAttributeAsString(googleAgenda.getDescriptionField()));
				todoRecords.add(record);
			}
		}
		grid.setData(todoRecords);
	}
}