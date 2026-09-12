package com.howmake.client.form.UI;

import java.util.LinkedHashMap;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.Services;
import com.br.client.panel.registro.UIPartner;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.howmake.client.form.model.HowMGWTPlugInInterface;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.types.ContentsType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

public abstract class HowMGWTReportViewer extends VLayout implements UIPartner , HowMGWTPlugInInterface{

	private SelectItem exportTypes				= new SelectItem();
	private ToolStripButton actionBuscar   	 	= new ToolStripButton(Tradutor.i18n.buscar());	
	private ToolStrip toolbar = new ToolStrip(); 

	private HTMLPane reportViewer = new HTMLPane();
	private Canvas filterPanel;
	
	private boolean iframeMode = false;
	
	private SectionStackSection sessionFiltroConsulta;
	 
    private HTMLPane paneHelp           	 	= new HTMLPane();	
	
	/**
	 * @return the exportTypes
	 */
	public SelectItem getExportTypes() {
		return exportTypes;
	}

	/**
	 * @param exportTypes the exportTypes to set
	 */
	public void setExportTypes(SelectItem exportTypes) {
		this.exportTypes = exportTypes;
	}

	/**
	 * @return the actionBuscar
	 */
	public ToolStripButton getActionBuscar() {
		return actionBuscar;
	}

	/**
	 * @param actionBuscar the actionBuscar to set
	 */
	public void setActionBuscar(ToolStripButton actionBuscar) {
		this.actionBuscar = actionBuscar;
	}
	
	public HowMGWTReportViewer(){
		this(null);
//		this( new VLayout());
//		this.getFilterPanel().setWidth100();
//		this.getFilterPanel().setHeight("40px");
	}
	
	public HowMGWTReportViewer(Canvas filtro){
		this.filterPanel = filtro;
		
		actionBuscar.setIcon("actions/search.png");    	
    	actionBuscar.setWidth("100px");		
    	
		
    	paneHelp.setBorder(Tradutor.i18n.msgBorder());
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setContents(Tradutor.i18n.msgLookupHelp());
		    	
    	
    	
       	// ---------------------------------------------------------------------------
    	// Gerenciador de relatórios
    	// ---------------------------------------------------------------------------
    	toolbar.setWidth100();
        
    	toolbar.addButton(actionBuscar);
        
    	toolbar.addSeparator();
        
        LinkedHashMap<String, String> value = new LinkedHashMap<String, String>();  
        value.put( Fabrica.REPORT_EXPORT_PDF , "Visualizar PDF");  
        value.put( Fabrica.REPORT_EXPORT_XLS,  "Visualizar Excel");  
        value.put( Fabrica.REPORT_EXPORT_CSV,  "Visualizar Excel CSV");  
        value.put( Fabrica.REPORT_EXPORT_DOC,  "Visualizar Word");  
        value.put( Fabrica.REPORT_EXPORT_PPT,  "Visualizar Power Point");  
        value.put( Fabrica.REPORT_EXPORT_XHTML,"Visualizar HTML");
        value.put( Fabrica.REPORT_EXPORT_XML  ,"Visualizar XML");
        
        LinkedHashMap<String, String> valueIcons = new LinkedHashMap<String, String>();  
        valueIcons.put( Fabrica.REPORT_EXPORT_PDF , Fabrica.REPORT_EXPORT_PDF);  
        valueIcons.put( Fabrica.REPORT_EXPORT_XLS,  Fabrica.REPORT_EXPORT_XLS);  
        valueIcons.put( Fabrica.REPORT_EXPORT_CSV,  Fabrica.REPORT_EXPORT_CSV);  
        valueIcons.put( Fabrica.REPORT_EXPORT_DOC,  Fabrica.REPORT_EXPORT_DOC);  
        valueIcons.put( Fabrica.REPORT_EXPORT_PPT,  Fabrica.REPORT_EXPORT_PPT);  
        valueIcons.put( Fabrica.REPORT_EXPORT_XHTML,Fabrica.REPORT_EXPORT_XHTML);
        valueIcons.put( Fabrica.REPORT_EXPORT_XML  ,Fabrica.REPORT_EXPORT_XML);
        
        exportTypes.setDefaultValue(Fabrica.REPORT_EXPORT_PDF);
        exportTypes.setValueMap(value);
        exportTypes.setValueIcons(valueIcons);          
        
        exportTypes.setImageURLPrefix("report/");  
        exportTypes.setImageURLSuffix(".png");  
        exportTypes.setTitle(Tradutor.i18n.formSelecionar());  
        exportTypes.setHint("<nobr>Selecione o tipo de Arquivo na Lista</nobr>");  
        toolbar.addFormItem(exportTypes); 
	    
		this.getActionBuscar().addClickHandler(new ClickHandler() { 
            public void onClick(ClickEvent event) {
            	executeReport();
            }
        });
		
		reportViewer.setContentsType(ContentsType.PAGE);  
		
		this.setWidth100();
		this.setHeight100();		
	}

	/**
	 * @return the toolbar
	 */
	public ToolStrip getToolbar() {
		return toolbar;
	}

	/**
	 * @param toolbar the toolbar to set
	 */
	public void setToolbar(ToolStrip toolbar) {
		this.toolbar = toolbar;
	}	
	
	
	/**
	 * Executa o relatório no servidor.
	 */
	public void executeReport(){
		
		// Cria a entidade 
		HowMGWTEntity entity = Fabrica.createEntity();		
		if ( ! onHowMExecuteReport(entity) )
			return;
		
		Fabrica.createParameter(entity, Fabrica.DEFAULT_REPORT_VISUALIZER 	, getExportTypes().getValueAsString() );

		String url =Configuracao.getNativeUnoUrlServiceDonwload();

//		if ( Configuracao.getNativeUnoUrlServiceDonwload().endsWith("//") )
//			url = Configuracao.getNativeUnoUrlServiceDonwload().substring(0,Configuracao.getNativeUnoUrlServiceDonwload().length()-2);
//		
//		if ( Configuracao.getNativeUnoUrlServiceDonwload().endsWith("/") )
//			url = Configuracao.getNativeUnoUrlServiceDonwload().substring(0,Configuracao.getNativeUnoUrlServiceDonwload().length()-1);
//		
		
		
		final String urlLocator = url;
		reportViewer.setContentsURL(urlLocator+"/UnoGWTClean.jsp");

		HowMGWTWindowWait.showWait();
		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
			
				public void onFailure(Throwable caught) {
					HowMGWTWindowWait.hideWait();		
					caught.printStackTrace();
					com.google.gwt.user.client.Window.alert(Tradutor.i18n.formEnderecoBase()+GWT.getHostPageBaseURL()+"\n"+caught.getMessage());
				}

				public void onSuccess(HowMGWTEntity result) {					
					
					// Recupera o endereço do relatório gerado.
					HowMProperty reportURL = result.getParameters().get("reportURL");
					
					Timer timer = new Timer() {

						@Override
						public void run() {
							HowMGWTWindowWait.hideWait();
						}
					};
					timer.schedule(10);
					if( isIframeMode() )
						reportViewer.setIFrameURL(urlLocator+"/"+reportURL.getValue());
					else
						reportViewer.setContentsURL(urlLocator+"/"+reportURL.getValue());					
				}
		};
				
		entity.setAction(Services.acaoExecuteReport);
				 
		Configuracao.getProxyStruts().executeQuery(entity, callback);
	}	

	/**
	 * Inicializa a interface do painel de execução do relatório.
	 */
	public void start(){
		
		
    	paneHelp.setWidth100();
    	paneHelp.setHeight(40);
    	
    	if( filterPanel instanceof Layout ){
    		((Layout)filterPanel).addMember(paneHelp);
    		((Layout)filterPanel).addMember(this.getToolbar());
    	}
    		
        SectionStack sectionStack = new SectionStack();          
        sectionStack.setWidth100();
        sectionStack.setHeight100();
  
        sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);  
        sectionStack.setAnimateSections(false);  
        sectionStack.setOverflow(Overflow.HIDDEN);  	    
	    if ( filterPanel != null){
		    filterPanel.setHeight("60px");
		    filterPanel.setShowHover(true);
		    
	        sessionFiltroConsulta = new SectionStackSection();  
	        sessionFiltroConsulta.setTitle(Tradutor.i18n.criterioConsulta());  
	        sessionFiltroConsulta.setExpanded(true);  
	        sessionFiltroConsulta.setItems(filterPanel);  	    
	    }
	    
        SectionStackSection sessionResultadoConsulta = new SectionStackSection();   
        sessionResultadoConsulta.setExpanded(true); 
        sessionResultadoConsulta.setShowHeader(false);
        sessionResultadoConsulta.setItems(reportViewer);  	  
	    
        if ( filterPanel != null)
        	sectionStack.setSections(sessionFiltroConsulta, sessionResultadoConsulta);
        else
        	sectionStack.setSections(sessionResultadoConsulta);
        
	    this.addMember(sectionStack);
	}	
	

	/**
	 * Sobrepor método para implementar a passagem de parametros para execução da consulta.
	 * @param entity Entidade onde serão adicionados os paremetros.
	 * @return Retorn true se o relatório deverá ser executado, caso contrório retornar
	 * false e mostrar mensagem para o usuório caso a validação do relatório não permita 
	 * a execução.
	 */
	protected abstract boolean onHowMExecuteReport(HowMGWTEntity entity);

	/**
	 * @return the filterPanel
	 */
	public Canvas getFilterPanel() {
		return filterPanel;
	}

	/**
	 * @param filterPanel the filterPanel to set
	 */
	public void setFilterPanel(Canvas filterPanel) {
		this.filterPanel = filterPanel;
	}

	public abstract String getHowMGWTTitle();
	public abstract String getHowMGWTPrograma();
	
	public String getHowMGWTFormTitle(){
		return this.getHowMGWTPrograma()+"-"+this.getHowMGWTTitle();
	}
	
	public void hideHowMGWTPlugIns(){
		if ( reportViewer != null )
			reportViewer.hide();
	}
	
	public void retoreHowMGWTPlugIns(){
		if ( reportViewer != null )
			reportViewer.show();
	}

	/**
	 * @return the iframeMode
	 */
	public boolean isIframeMode() {
		return iframeMode;
	}

	/**
	 * @param iframeMode the iframeMode to set
	 */
	public void setIframeMode(boolean iframeMode) {
		this.iframeMode = iframeMode;
	}
	

}