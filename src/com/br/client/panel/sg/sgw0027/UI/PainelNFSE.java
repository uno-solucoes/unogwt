package com.br.client.panel.sg.sgw0027.UI;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.UnoRpcRequestBuilder;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.UIPartner;
import com.br.client.panel.sg.sgw0027.model.eConstants;
import com.gargoylesoftware.htmlunit.javascript.host.Node;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ContentsType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.types.TabBarControls;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;

public class PainelNFSE  extends VLayout implements UIPartner{

	private IButton actionEnviar 	= new IButton("Enviar");
	private IButton actionMarcar    = new IButton("Marcar Todos");
    private IButton actionDesmarcar = new IButton("Desmarcar Todos");
    
    private VLayout toolbarCheckList = new VLayout();
    
    private Tab tabPrefeitura;
    
    private ToolbarVertical verticalBar = new ToolbarVertical();

    private VLayout paneHelp = new VLayout();

    final TabSet tabSetManager = new TabSet();  

    private HTMLPane sitePrefeitura = new HTMLPane();
    private HTMLPane ultimaRPS = new HTMLPane();


	// Critório de consulta.
	FiltroConsulta filtroConsulta = new FiltroConsulta();

	// Relação de Vendas
    ResultadoConsulta resultadoConsulta = new ResultadoConsulta();	

	public PainelNFSE(){
		this.resultadoConsulta.setPainelNFSE(this);
		initUI();
		initListners();
		this.resultadoConsulta.setFiltroConsulta(this.filtroConsulta);
		this.resultadoConsulta.setPaneHelp(this.paneHelp);
		this.verticalBar.setResultadoConsulta(this.resultadoConsulta);
        sitePrefeitura.setContentsType(ContentsType.PAGE);  

	}

	public void start(){
		initProxy();		
		this.resultadoConsulta.loadParameters();
	}

	public void initUI(){
	    this.setWidth100();   
		
        SectionStack sectionStack = new SectionStack();          
        sectionStack.setWidth100();
        sectionStack.setHeight100();
  
        sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);  
        sectionStack.setAnimateSections(false);  
        sectionStack.setOverflow(Overflow.HIDDEN);  	    
	    

	    filtroConsulta.setHeight("60px");
	    filtroConsulta.setShowHover(true);
	    
        SectionStackSection sessionFiltroConsulta = new SectionStackSection();  
        sessionFiltroConsulta.setTitle(Tradutor.i18n.criterioConsulta());  
        sessionFiltroConsulta.setExpanded(true);  
        sessionFiltroConsulta.setItems(filtroConsulta);  	    

        HLayout desktop = new HLayout();

         
        ImgButton pane = new ImgButton();
        pane.setSrc("icon_nfse.jpg");
		pane.setShowDown(false);  
		pane.setShowRollOver(false);  
		pane.setLayoutAlign(Alignment.CENTER);
        pane.setHeight(145);
        pane.setWidth100();
        toolbarCheckList.addMember(pane);
 
        actionEnviar.setIcon("actions/ok.png");
        actionEnviar.setWidth("180px");
        actionEnviar.setAlign(Alignment.LEFT);
        actionEnviar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				resultadoConsulta.enviar();
			}
		});
        
 
        
        
        actionMarcar.setWidth("110px");
        actionMarcar.setIcon("actions/approve.png");
        actionMarcar.setAlign(Alignment.LEFT);
        actionMarcar.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				resultadoConsulta.setSelectRecords(true);
			}
		});
        // toolbar.addMember(actionMarcar);
        


        actionDesmarcar.setWidth("140px");
        actionDesmarcar.setIcon("actions/exclamation.png");
        actionDesmarcar.setAlign(Alignment.LEFT);
        actionDesmarcar.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				resultadoConsulta.setSelectRecords(false);
			}
		});
        // toolbar.addMember(actionDesmarcar);
        
        
        // Ajuda
        // ---------------------------------------------------------------------
        
        paneHelp.setBackgroundColor("FFFFFF");
		paneHelp.setLayoutAlign(Alignment.LEFT);
        paneHelp.setHeight100();
        paneHelp.setWidth100();

        ultimaRPS.setAlign(Alignment.CENTER);
        ultimaRPS.setWidth100();
        ultimaRPS.setHeight(20);
        ultimaRPS.setBackgroundColor("F0EEE7");
        ultimaRPS.setContents("");        
        
        
        
        HTMLPane checkList = new HTMLPane();
        checkList.setAlign(Alignment.CENTER);
        checkList.setWidth100();
        checkList.setHeight(20);
        checkList.setBackgroundColor("F0EEE7");
        checkList.setContents("<center><B>CheckList</B><center>");

        HTMLPane separator = new HTMLPane();
        separator.setBackgroundColor("FFFFFF");
        separator.setWidth100();
        separator.setContents("");
        separator.setHeight(12);
        toolbarCheckList.addMember(separator);

        toolbarCheckList.addMember(ultimaRPS);
        toolbarCheckList.addMember(checkList);
        toolbarCheckList.addMember(paneHelp);        
        // ---------------------------------------------------------------------
        

        tabSetManager.setTabBarPosition(Side.TOP);  
  
        //required so that the select item doesnt touch the tab pane  
        tabSetManager.setTabBarThickness(25);  
        tabSetManager.setTabBarAlign(Side.LEFT);  
        tabSetManager.setWidth100();
        tabSetManager.setHeight100();
        
        HLayout toolbarTabRPS = new HLayout();   
        toolbarTabRPS.setPadding(2);  
        toolbarTabRPS.setMargin(0);  
        toolbarTabRPS.addMember(actionEnviar);
        toolbarTabRPS.addMember(actionMarcar);
        toolbarTabRPS.addMember(actionDesmarcar);
  
        tabSetManager.addTabSelectedHandler(new TabSelectedHandler() {
			
			@Override
			public void onTabSelected(TabSelectedEvent event) {
				if ( event.getTabNum() == 0 ){
					actionEnviar.setVisible(true);
					actionDesmarcar.setVisible(true);
					actionMarcar.setVisible(true);
				}
				else{
					actionEnviar.setVisible(false);
					actionDesmarcar.setVisible(false);
					actionMarcar.setVisible(false);					
				}
			}
		});
        
        // Inclui uma toolbar na tab
        tabSetManager.setTabBarControls(TabBarControls.TAB_SCROLLER, TabBarControls.TAB_PICKER, toolbarTabRPS); 
        
        Tab tabListagem = new Tab("Listagem");  
        tabListagem.setPane(resultadoConsulta);  
        tabSetManager.addTab(tabListagem);   
        
        desktop.addMember(tabSetManager);
        
        toolbarCheckList.setBorder("1px rgb(133,169,182) solid");     
        
        desktop.addMember(verticalBar);
        verticalBar.setToolbarCheckList(toolbarCheckList);
  
        toolbarCheckList.setWidth(240);                
        desktop.addMember(toolbarCheckList);
       
        
        // ----------------------------------------------------------------------
        
        SectionStackSection sessionResultadoConsulta = new SectionStackSection();   
        sessionResultadoConsulta.setExpanded(true); 
        sessionResultadoConsulta.setShowHeader(false);
        sessionResultadoConsulta.setItems(desktop);  	  
	    
        sectionStack.setSections(sessionFiltroConsulta, sessionResultadoConsulta);
                
	    this.addMember(sectionStack);
	    
	}
	
	public void initListners(){
		// Inclui um listner para executar a ação buscar.
		this.filtroConsulta.getActionBuscar().addClickHandler(new ClickHandler() { 
            public void onClick(ClickEvent event) {
            	
            	resultadoConsulta.buscar();
            }
        });
 		
 
		this.filtroConsulta.getFieldNaoEnviados().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
			}
		});

	}	
 
	public void initProxy(){
		UnoRpcRequestBuilder rpcRequestBuider = new UnoRpcRequestBuilder();
		((ServiceDefTarget)Configuracao.getProxyStruts()).setRpcRequestBuilder(rpcRequestBuider);
	}

	/**
	 * @return the actionEnviar
	 */
	public IButton getActionEnviar() {
		return actionEnviar;
	}

	/**
	 * @param actionEnviar the actionEnviar to set
	 */
	public void setActionEnviar(IButton actionEnviar) {
		this.actionEnviar = actionEnviar;
	}
	
	public void showSitePrefeitura(String padrao, String site){

        if ( 
        		eConstants.SISTEMA_ISSINTEL.equals(padrao) 
        		|| 
        		eConstants.SISTEMA_GINFES.equals(padrao) 
        		|| 
        		eConstants.SISTEMA_ISSDIGITAL.equals(padrao) 
        ){

        	if ( tabPrefeitura == null ){
	            tabPrefeitura = new Tab("Site Prefeitura");  
	            tabPrefeitura.setPane(sitePrefeitura);              
	            tabSetManager.addTab(tabPrefeitura);     		
        	} 
            sitePrefeitura.setContentsURL(site);
            
        }
	}

	/**
	 * @return the ultimaRPS
	 */
	public HTMLPane getUltimaRPS() {
		return ultimaRPS;
	}

	/**
	 * @param ultimaRPS the ultimaRPS to set
	 */
	public void setUltimaRPS(HTMLPane ultimaRPS) {
		this.ultimaRPS = ultimaRPS;
	}

	/**
	 * @return the tabSetManager
	 */
	public TabSet getTabSetManager() {
		return tabSetManager;
	}
}
