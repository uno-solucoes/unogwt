package com.br.client.panel.ed.edw0004.UI;

import java.util.Date;

import com.br.client.model.ed.edw0004.FormBean;
import com.br.client.model.ed.entity.eEDIHist;
import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTFormToolbarEdit;
import com.howmake.client.form.UI.HowMGWTLabel;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.control.HowMGWTControlForm;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.RecordLayout;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class WindowHistorico extends HowMGWTWindow implements HowMGWTControlForm{
	
	private String[] chave;
	private String tipoHistorico;
	
	private VLayout mainLayout = new VLayout();
	private PanelCalendar panelCalendar = new PanelCalendar(){
		protected void onSelectData(Date data, boolean showEvent) {
			WindowHistorico.this.onSelectData(data, showEvent);
		};
	};
	
	private HowMGWTLabel labelHistorico = new HowMGWTLabel();
	
	private HowMGWTListGrid listDatas = new HowMGWTListGrid();
	private HowMGWTFormProperties propertiesDatas = new HowMGWTFormProperties();
	private HowMGWTProperty propertyDataHistorico = new HowMGWTProperty("dataHistorico", Tradutor.i18n.formHistorico());
	
	private HowMGWTFormToolbarEdit formToolbarEdit;
	
	private HowMGWTFormProperties properties = new HowMGWTFormProperties();

	HowMGWTProperty propertySeqHistEdi 		= properties.createProperty("seqHistEdi", 			"SeqHistEdi");
	HowMGWTProperty propertyTpHist 			= properties.createProperty("tpHist", 				"TpHist");
	HowMGWTProperty propertyChave 			= properties.createProperty("chave", 				"chave");
 
	HowMGWTProperty propertyTpOperacao 		= properties.createProperty("tpOperacao", 			"tpOperacao");
	HowMGWTProperty propertyDescricao 		= properties.createProperty("descricao", 			"descricao");
	HowMGWTProperty propertyCodColaborador 	= properties.createProperty("descricao", 			"descricao");

	HowMGWTProperty propertyDtImplant 		= properties.createProperty("dtImplant", 			"dtImplant");

	HowMGWTProperty propertyRelatorio 		= properties.createProperty("relatorio", 			"relatorio");
	
	public WindowHistorico(){

		propertyDataHistorico.setType(ListGridFieldType.DATE);
		propertyDataHistorico.setWidthColumn(100);
		propertyDataHistorico.createHowMGWTListGridField();
			        
		propertyDataHistorico.createFormatDate("dd/MM/yyyy");
		listDatas.setFields(propertyDataHistorico.getListField());
		
		// Intercepta a navegação do registro.
		listDatas.addRecordClickHandler(new RecordClickHandler(){              
        	public void onRecordClick(RecordClickEvent event) {  
                ListGridRecord record = (ListGridRecord)event.getRecord();
                Date data = HowMGWTUtilities.getDate(propertyDataHistorico.getHowMValue(record));
                onSelectData( data, true );
        	}
        });		
		
		this.setWidth("700");
		this.setHeight("90%");
		this.centerInPage();
		
		HLayout hTitulo = new HLayout();
		hTitulo.setWidth100();
		hTitulo.setHeight(50);
		
		VLayout vTitulo = new VLayout();
		vTitulo.setWidth100();
		vTitulo.setHeight(50);
		vTitulo.setAlign(Alignment.CENTER);
		
		labelHistorico.setWidth100();		
		labelHistorico.setHeight(26);
		vTitulo.addMember(labelHistorico);
				
		Img img = new Img("tools/bot_history.png");
		img.setWidth(48);
		img.setHeight(48);
		hTitulo.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(6, ""));
		hTitulo.addMember(img);
		hTitulo.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(10, ""));
		hTitulo.addMember(vTitulo);

		mainLayout.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(5, ""));
		mainLayout.addMember(hTitulo);
		mainLayout.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(1, "#5CACEE"));
		
		mainLayout.addMember(panelCalendar);
		
		
		propertyRelatorio.setWidthColumn(1024);
		propertyRelatorio.createHowMGWTListGridField();
		
		
		
		formToolbarEdit = new HowMGWTFormToolbarEdit(this);
		
		
		
		
		
		HLayout navDatas = new HLayout();
		navDatas.setWidth100();
		navDatas.setHeight100();
		
		
		listDatas.setWidth(122);
		listDatas.setHeight100();

		navDatas.addMember(listDatas);
		
		formToolbarEdit.getPanelList().setWrapCells(true);  
		formToolbarEdit.getPanelList().setFixedRecordHeights(false); 
		
		navDatas.addMember(formToolbarEdit.getPanelList());
		
		mainLayout.addMember(navDatas);
 

		this.addItem(mainLayout);

		this.setIsModal(true);		
	}
	
	public String getHowMGWTTitle(){
    	return  Tradutor.i18n.tituloVisualizarHistorico();
	}
	
	public String getHowMGWTPrograma(){
		return "EDW0004";
	}


	public void showHistorico(String titulo, String descricao, String[] chave, String tipoHistorico){

		this.chave 			= chave;
		this.tipoHistorico 	= tipoHistorico;
	
		this.labelHistorico.setHowMValue("<html><body><FONT style=\"font-size: 180%; margin-top: -1em; font-family: Helvetica, Arial, sans-serif; font-weight: bold; color:#5CACEE; \">"+titulo+"</FONT></body></html>");		

		this.show();
		
		loadDatas();		
	}
	

	@Override
	public HowMGWTFormProperties getHowMProperties() {		
		return properties;
	}

	@Override
	public void onHowMDeleteRecord() {}

	@Override
	public void onHowMEditRecord() {}

	@Override
	public void onHowMLoad(HowMGWTFormBean formBean) {}

	@Override
	public void onHowMNewRecord() {}

	@Override
	public void onHowMRelation(ListGridRecord record) {}

	@Override
	public void onHowMSave() {}

	@Override
	public void onHowMSetValues(ListGridRecord record) {}
	
  
	public void loadDatas(){
		HowMGWTWindowWait.showWait();
		
		this.formToolbarEdit.getPanelList().clearAllRecords();
		
		this.listDatas.clearAllRecords();
		this.panelCalendar.setData(new CalendarEvent[0]);
		
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				FormBean bean = (FormBean)formBean;
				if ( bean.getDatasHistoricas() != null ){
					RecordList recordList = new RecordList();
					ListGridRecord record;
					
					CalendarEvent[] task = new CalendarEvent[bean.getDatasHistoricas().length];
					int i = 0;
					for ( String data : bean.getDatasHistoricas() ){
						record = new ListGridRecord();
						propertyDataHistorico.setHowMValue(record, data);
						recordList.add(record);
						task[i++] = new CalendarEvent(i,data,data,HowMGWTUtilities.getDate(data),HowMGWTUtilities.getDate(data),false,"");
					}
					listDatas.setData(recordList);
					panelCalendar.setData(task);
				}
				HowMGWTWindowWait.hideWait();
			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
			}			
		};					 
		formBean.setTpHistorico(this.tipoHistorico);
		formBean.setChave(this.chave);
		String body =  HowMGWTUtilities.getGWTBeanTransfer(formBean.toJsonObject("").toString());

		struts.request("edw0004.do?method=buscarDatas",  "EDW0004Form", body);						
	}
	
    protected void onSelectData(Date data, boolean showEvent){

    	if ( ! showEvent ){
    		this.formToolbarEdit.getPanelList().clearAllRecords();
    		return;
    	}
    	    	
    	HowMGWTWindowWait.showWait();
 		
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				FormBean bean = (FormBean)formBean;
				if ( bean.getHistoricos() != null ){
					RecordList recordList = new RecordList();
					ListGridRecord record;

					for ( eEDIHist data : bean.getHistoricos() ){
						record = new ListGridRecord();
						propertyRelatorio.setHowMValue(record, data.getRelatorio());
						recordList.add(record);
					}
					formToolbarEdit.getPanelList().setData(recordList);
				}
				HowMGWTWindowWait.hideWait();
			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
			}			
		};			
		
		formBean.setDtHist(HowMGWTUtilities.getFormatDateDB(data));
		formBean.setTpHistorico(this.tipoHistorico);
		formBean.setChave(this.chave);
		String body =  HowMGWTUtilities.getGWTBeanTransfer(formBean.toJsonObject("").toString());

		struts.request("edw0004.do?method=buscarHistorico",  "EDW0004Form", body);						    	
    }	
}