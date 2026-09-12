package com.br.client.panel.vd.vdw1000.UI;

import com.br.client.model.vd.entity.eNFSEEmitenteWS;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.vd.vdw1000.UI.servicos.WindowConfiguracaoServicos;
import com.br.client.panel.vd.vdw1000.util.NFSEUtilities;
import com.google.gwt.user.client.Window;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IconButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.IconMenuButton;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.ClickHandler;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import com.smartgwt.client.widgets.toolbar.RibbonBar;
import com.smartgwt.client.widgets.toolbar.RibbonGroup;

public abstract class PanelRibbonBarRPS extends PanelRibbonBarLayout{

	private com.br.client.model.vd.vdw1000.FormBean currentFormBeanConfiguration;
	
	private PanelRibbonBarSuporte panelRibbonBarSuporte;
	
	private MenuItem lastMenuItemExecute = null;
	private String lastOperacao;
	
	
	private WindowConfiguracaoServicos windowConfiguracaoServicos; 
	
	private String urlSitePrefeitura;
	
	private String backgroundOptions = "#FF4500";
	
	private Label paneEmitente = new Label();
	
	private eNFSEEmitenteWS currentEntityEmitente;
	
	public eNFSEEmitenteWS getCurrentEntityEmitente() {
		return currentEntityEmitente;
	}

	public void setCurrentEntityEmitente(eNFSEEmitenteWS currentEntityEmitente) {
		this.currentEntityEmitente = currentEntityEmitente;
	}

	private Label labelOption = new Label();
	
	public Label getLabelOption() {
		return labelOption;
	}
	
	private HowMGWTProperty propertyPeriodoInicial 	= new HowMGWTProperty("dataInicio", Tradutor.i18n.periodoInicial());
	public HowMGWTProperty getPropertyPeriodoInicial() {
		return propertyPeriodoInicial;
	}

	public HowMGWTProperty getPropertyPeriodoFinal() {
		return propertyPeriodoFinal;
	}
	private HowMGWTProperty propertyPeriodoFinal   	= new HowMGWTProperty("dataFim"   		, Tradutor.i18n.periodoFinal());
	
	private HowMGWTProperty propertyCodPlano   		= new HowMGWTProperty("codPlano"   		, "Nr Plano");
	private HowMGWTProperty propertyCodRPS     		= new HowMGWTProperty("codRPS"   		, "Nr RPS");
	private HowMGWTProperty propertyCodPedido 		= new HowMGWTProperty("codPedido"   	, "Nr Pedido");
	private HowMGWTProperty propertyNomeCliente		= new HowMGWTProperty("nomeCliente"   	, "Cliente");
	private HowMGWTProperty propertyCodNotaFiscal  	= new HowMGWTProperty("codNotaFiscal"   , "Cod NF");

	private VLayout topLayout = new VLayout();
	private VLayout mainRibbonBar = new VLayout();
	
    private RibbonBar ribbonBar = new RibbonBar();  
    private RibbonGroup menuArquivos = new RibbonGroup();  
    private Menu menuOptions = new Menu();

    MenuItem OPERACAO_ENVIAR_RPS_PARA_PROCESSAMENTO = new MenuItem(
    		NFSEUtilities.OPERACAO_ENVIAR_RPS_PARA_PROCESSAMENTO_DESC, 
    		"nfe/menu/enviarRPSParaProcessamento.png"
    );    

    private MenuItem OPERACAO_CANCELAR_ENVIO_RPS_NAO_PROCESSADAS = new MenuItem(
    		NFSEUtilities.OPERACAO_CANCELAR_ENVIO_RPS_NAO_PROCESSADAS_DESC, 
    		"nfe/menu/cancelarEnvioRPSNaoProcessadas.png"
    );
        
    private MenuItem OPERACAO_CARREGAR_NFSE_EMITIDAS = new MenuItem(
			NFSEUtilities.OPERACAO_CARREGAR_NFSE_EMITIDAS_DESC, 
			"nfe/menu/NFSE.png"
	);

//    private MenuItem OPERACAO_SINCRONIZAR_ERP_X_SERVIDOR_RPS = new MenuItem(
//			NFSEUtilities.OPERACAO_SINCRONIZAR_ERP_X_SERVIDOR_RPS_DESC, 
//			"nfe/menu/sincronizarERPSxServidorRPS.png"
//	);
    
    private IconButton BUTTON_OPERACAO_EXPORTAR_ARQUIVO_XML_NFSE_PARA_CONTADOR 	= getIconButton(NFSEUtilities.OPERACAO_EXPORTAR_ARQUIVO_XML_NFSE_PARA_CONTADOR_DESC, "exportarArquivoXMLNFSEParaContador", true); 
    private IconButton BUTTON_OPERACAO_EXPORTAR_ARQUIVOS_PDF_DANFES 			= getIconButton(NFSEUtilities.OPERACAO_EXPORTAR_ARQUIVOS_PDF_DANFES_DESC, "exportarArquivoPDFDANFE", true); 
    					 
//    private IconButton OPERACAO_EXPORTAR_ARQUIVO_PDF_NFSE 					= getIconButton(NFSEUtilities.OPERACAO_EXPORTAR_ARQUIVO_PDF_NFSE_DESC, "exportarArquivoPDF_NFSE", true); 
    private IconButton BUTTON_OPERACAO_ENVIAR_EMAIL_CONTRIBUINTE 				= getIconButton(NFSEUtilities.OPERACAO_ENVIAR_EMAIL_CONTRIBUINTE_DESC, "enviarEMAILContribuinte", true); 
    private IconButton BUTTON_OPERACAO_VISUALIZAR_HISTORICO 			 		= getIconButton(NFSEUtilities.OPERACAO_VISUALIZAR_HISTORICO_DESC, "visualizarHistorico", true);
   
    private IconButton OPERACAO_ENVIAR_RPS_PREFEITURA 							= getIconButton(NFSEUtilities.OPERACAO_ENVIAR_RPS_PREFEITURA_DESC, "enviarRPSParaProcessamento", true); 		
    private IconButton OPERACAO_SUPORTE_INTELIGENTE 							= getIconButton(NFSEUtilities.OPERACAO_SUPORTE_INTELIGENTE_DESC, "error", true);
    private IconButton OPERACAO_REENVIAR_RPS_PREFEITURA 						= getIconButton(NFSEUtilities.OPERACAO_REENVIAR_RPS_PREFEITURA_DESC, "enviarRPSParaProcessamento", true); 		
	
    private IconButton BUTTON_OPERACAO_CANCELAR_ENVIO_RPS						= getIconButton(NFSEUtilities.OPERACAO_CANCELAR_ENVIO_RPS__DESC, "cancelarEnvioRPSNaoProcessadas", true);	
	private IconButton BUTTON_OPERACAO_CANCELAR_NFSE							= getIconButton(NFSEUtilities.OPERACAO_CANCELAR_NFSE_DESC, "cancelarNFSENaPrefeitura", true);
	
	private IconButton BUTTON_OPERACAO_SINCRONIZAR_RPS_PENDENTES				= getIconButton(NFSEUtilities.OPERACAO_SINCRONIZR_RPS_PENDENTES_DESC, "sincronizarERPSxServidorRPS", true);

	
	private IconButton BUTTON_OPERACAO_MONITOR_INTEGRACAO						= getIconButton(NFSEUtilities.OPERACAO_MONITOR_INTEGRACAO_DESC, "monitorG2KA", true);
    private IconButton BUTTON_OPERACAO_CONFIGURAR_SERVICO 						= getIconButton(NFSEUtilities.OPERACAO_CONFIGURAR_SERVICO_DESC, "ConfigurarServico", true);
    private IconButton BUTTON_OPERACAO_ACESSO_SITE_PREFEITURA 					= getIconButton(NFSEUtilities.OPERACAO_ACESSAR_SITE_PREFEITURA_DESC, "sitePrefeitura", true);
	
    
    private IconButton BUTTON_OPERACAO_ACESSO_ADMINISTRATOR 					= getIconButton(NFSEUtilities.OPERACAO_ACESSAR_ADMINISTRADOR_DESC, "icon_Admin", true);   
	
	int iconSize = 32; 
    
    int heightMenu = 105;
    

    private IconButton actionVisualizarHistorico = getIconButton("Visualizar<br>"+Tradutor.i18n.formHistorico(), "visualizarHistorico", true);

	private PainelFiltroAdicional painelFiltroAdicional = new PainelFiltroAdicional(this);
	
    
    public PanelRibbonBarRPS(){

    	    	
		this.setWidth100();		
		this.setAutoHeight();
		
		topLayout.setWidth100();
		
		mainRibbonBar.setWidth100();
		
        ribbonBar.setWidth100();
        
                

        // ------------------------------------------------------------------------
        // 					Montagem menu de Opções 
        // ------------------------------------------------------------------------
        // Operação enivar RPS para processamento
        OPERACAO_ENVIAR_RPS_PARA_PROCESSAMENTO.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(MenuItemClickEvent event) {
				executeOperacao(
						OPERACAO_ENVIAR_RPS_PARA_PROCESSAMENTO, 
						NFSEUtilities.OPERACAO_NOTAS_FISCAIS_PENDENTES_PARA_ENVIO, 
						getPropertyPeriodoInicial().getHowmFormValueToString(), 
						getPropertyPeriodoFinal().getHowmFormValueToString(),
						getPropertyCodPlano().getHowmFormValueToString(),
						getPropertyCodRPS().getHowmFormValueToString(),
						getPropertyCodPedido().getHowmFormValueToString(),
						getPropertyNomeCliente().getHowmFormValueToString(),
						getPropertyCodNotaFiscal().getHowmFormValueToString()
				);
			}
		});        
        OPERACAO_ENVIAR_RPS_PARA_PROCESSAMENTO.setIconHeight(iconSize);
        OPERACAO_ENVIAR_RPS_PARA_PROCESSAMENTO.setIconWidth(iconSize);        
        menuOptions.addItem(OPERACAO_ENVIAR_RPS_PARA_PROCESSAMENTO);        

        
        // Operação cancelar envio RPS processadas.
        OPERACAO_CANCELAR_ENVIO_RPS_NAO_PROCESSADAS.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(MenuItemClickEvent event) {
				executeOperacao(
						OPERACAO_CANCELAR_ENVIO_RPS_NAO_PROCESSADAS, 
						NFSEUtilities.OPERACAO_AGUARDANDO_PROCESSAMENTO_NA_PREFEITURA, 
						getPropertyPeriodoInicial().getHowmFormValueToString(), 
						getPropertyPeriodoFinal().getHowmFormValueToString(),
						getPropertyCodPlano().getHowmFormValueToString(),
						getPropertyCodRPS().getHowmFormValueToString(),
						getPropertyCodPedido().getHowmFormValueToString(),
						getPropertyNomeCliente().getHowmFormValueToString(),
						getPropertyCodNotaFiscal().getHowmFormValueToString()						
				);
			}
		});
        OPERACAO_CANCELAR_ENVIO_RPS_NAO_PROCESSADAS.setIconHeight(iconSize);
        OPERACAO_CANCELAR_ENVIO_RPS_NAO_PROCESSADAS.setIconWidth(iconSize);        
        menuOptions.addItem(OPERACAO_CANCELAR_ENVIO_RPS_NAO_PROCESSADAS);

        
//        // Operação cancelar NFSe na prefeitura.
//        OPERACAO_CANCELAR_NFSE_NA_PREFEITURA.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(MenuItemClickEvent event) {
//				executeOperacao(OPERACAO_CANCELAR_ENVIO_RPS_NAO_PROCESSADAS, NFSEUtilities.OPERACAO_CANCELAR_NFSE_NA_PREFEITURA, getPropertyPeriodoInicial().getHowmFormValueToString(), getPropertyPeriodoFinal().getHowmFormValueToString());
//			}
//		});
//        OPERACAO_CANCELAR_NFSE_NA_PREFEITURA.setIconHeight(iconSize);
//        OPERACAO_CANCELAR_NFSE_NA_PREFEITURA.setIconWidth(iconSize);        
//        menuOptions.addItem(OPERACAO_CANCELAR_NFSE_NA_PREFEITURA);
        

        
        
        // Operação sincronizar ERP x Servidor RPS 
//        OPERACAO_SINCRONIZAR_ERP_X_SERVIDOR_RPS.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(MenuItemClickEvent event) {
//				executeOperacao(OPERACAO_CANCELAR_ENVIO_RPS_NAO_PROCESSADAS, NFSEUtilities.OPERACAO_SINCRONIZAR_ERP_X_SERVIDOR_RPS, getPropertyPeriodoInicial().getHowmFormValueToString(), getPropertyPeriodoFinal().getHowmFormValueToString());
//			}
//		});
//        OPERACAO_SINCRONIZAR_ERP_X_SERVIDOR_RPS.setIconHeight(iconSize);
//        OPERACAO_SINCRONIZAR_ERP_X_SERVIDOR_RPS.setIconWidth(iconSize);
//        menuOptions.addItem(OPERACAO_SINCRONIZAR_ERP_X_SERVIDOR_RPS);
        
        
        
        
        // Operação carregar NFSE emitidas 
        OPERACAO_CARREGAR_NFSE_EMITIDAS.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(MenuItemClickEvent event) {
				executeOperacao(
						OPERACAO_CARREGAR_NFSE_EMITIDAS, 
						NFSEUtilities.OPERACAO_EMITIDAS_NA_PREFEITURA, 
						getPropertyPeriodoInicial().getHowmFormValueToString(), 
						getPropertyPeriodoFinal().getHowmFormValueToString(),
						getPropertyCodPlano().getHowmFormValueToString(),
						getPropertyCodRPS().getHowmFormValueToString(),
						getPropertyCodPedido().getHowmFormValueToString(),
						getPropertyNomeCliente().getHowmFormValueToString(),
						getPropertyCodNotaFiscal().getHowmFormValueToString()						
				);
			}
		});
        OPERACAO_CARREGAR_NFSE_EMITIDAS.setIconHeight(iconSize);
        OPERACAO_CARREGAR_NFSE_EMITIDAS.setIconWidth(iconSize);        
        menuOptions.addItem(OPERACAO_CARREGAR_NFSE_EMITIDAS);
        

        
        
        // ------------------------------------------------------------------------
        // 					Fim montagem menu Opções 
        // ------------------------------------------------------------------------        

        
        // -----------------------------------------------------------------------
        // Incui o critório de consulta
        // -----------------------------------------------------------------------
        RibbonGroup menuFiltro = new RibbonGroup();  
        menuFiltro.setTitle("Crit&eacute;rio de Consulta");  
        menuFiltro.setTitleAlign(Alignment.LEFT);  
        menuFiltro.setNumRows(1);
        menuFiltro.setRowHeight(26);
        menuFiltro.setAlign(VerticalAlignment.TOP);
        menuFiltro.setHeight(heightMenu);
        
        VLayout criterioConsulta = new VLayout();
        criterioConsulta.setWidth100();
        criterioConsulta.setHeight(heightMenu);
        criterioConsulta.setBackgroundColor("#ffffff");

        int wLabel = 110;

    	propertyPeriodoInicial.setBound(wLabel, 130);
    	propertyPeriodoInicial.createHowMGWTFormDateItem();
    	criterioConsulta.addMember(propertyPeriodoInicial.getCanvas());

    	propertyPeriodoFinal.setBound(wLabel, 130);
    	propertyPeriodoFinal.createHowMGWTFormDateItem();    	
    	criterioConsulta.addMember(propertyPeriodoFinal.getCanvas());        

    	labelOption.setWidth(275);
    	labelOption.setHeight(24);
    	// labelOption.setWrap(false);
    	labelOption.setAlign(Alignment.CENTER);
    	labelOption.setBackgroundColor(backgroundOptions);

    	
    	criterioConsulta.addMember(labelOption);

        menuFiltro.addControl(criterioConsulta);

        // --------------------------- MENU - ARQUIVOS ----------------------------
        
        menuArquivos.setTitle("Arquivos");  
        menuArquivos.setTitleAlign(Alignment.LEFT);  
        menuArquivos.setNumRows(1);  
        menuArquivos.setRowHeight(26);
        menuArquivos.setHeight(heightMenu);
        
        
        IconMenuButton menuBuscar = getIconMenuButton("Buscar", "executar_consulta", menuOptions, true);
        menuBuscar.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if( HowMGWTUtilities.isEmpty(lastOperacao) ){
					return;
				}
				if( lastMenuItemExecute == null ){
					return;
				}
				executeOperacao(
						lastMenuItemExecute, 
						lastOperacao, 
						getPropertyPeriodoInicial().getHowmFormValueToString(), 
						getPropertyPeriodoFinal().getHowmFormValueToString(),
						getPropertyCodPlano().getHowmFormValueToString(),
						getPropertyCodRPS().getHowmFormValueToString(),
						getPropertyCodPedido().getHowmFormValueToString(),
						getPropertyNomeCliente().getHowmFormValueToString(),
						getPropertyCodNotaFiscal().getHowmFormValueToString()						
				);
			}
		});
        
        // menuArquivos.addControl(getIconButton("Novo", "nova_consulta", true));
        menuArquivos.addControl(menuBuscar);
        
        
        OPERACAO_ENVIAR_RPS_PREFEITURA.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				onEnviarRPSProcessamento();
			}
		});
        menuArquivos.addControl(OPERACAO_ENVIAR_RPS_PREFEITURA); 	

        OPERACAO_SUPORTE_INTELIGENTE.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				onSuporteInteligente();
			}
		});
        menuArquivos.addControl(OPERACAO_SUPORTE_INTELIGENTE);
        
        
        
        OPERACAO_REENVIAR_RPS_PREFEITURA.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				onEnviarRPSProcessamento();
			}
		});
        menuArquivos.addControl(OPERACAO_REENVIAR_RPS_PREFEITURA); 	
        
        
        menuArquivos.addControl(BUTTON_OPERACAO_CANCELAR_ENVIO_RPS);
        BUTTON_OPERACAO_CANCELAR_ENVIO_RPS.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onCancelarEnvioRPS();				
			}
		});
        
        
        menuArquivos.addControl(BUTTON_OPERACAO_SINCRONIZAR_RPS_PENDENTES);
        BUTTON_OPERACAO_SINCRONIZAR_RPS_PENDENTES.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				onForcarSincronismoRPS();				
			}
		});        
        
        // menuArquivos.addControl(BUTTON_OPERACAO_EXPORTAR_ARQUIVO_XML_NFSE_PARA_CONTADOR); 

        
        
        menuArquivos.addControl(BUTTON_OPERACAO_CANCELAR_NFSE);
        BUTTON_OPERACAO_CANCELAR_NFSE.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onCancelarEnvioRPS();				
			}
		});        
        
        

//        menuArquivos.addControl(OPERACAO_EXPORTAR_ARQUIVO_PDF_NFSE); 
        menuArquivos.addControl(BUTTON_OPERACAO_ENVIAR_EMAIL_CONTRIBUINTE); 

        menuArquivos.addControl(BUTTON_OPERACAO_MONITOR_INTEGRACAO);
        BUTTON_OPERACAO_MONITOR_INTEGRACAO.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				onMonitorG2KA();
			}
		});


        menuArquivos.addControl(BUTTON_OPERACAO_CONFIGURAR_SERVICO);
        BUTTON_OPERACAO_CONFIGURAR_SERVICO.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				onConfigurarServico();
			}
		});        
        

        menuArquivos.addControl(BUTTON_OPERACAO_EXPORTAR_ARQUIVOS_PDF_DANFES);
        BUTTON_OPERACAO_EXPORTAR_ARQUIVOS_PDF_DANFES.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onVisualizarNFSePrefeitura();
			}
		});        
        
        
        menuArquivos.addControl(BUTTON_OPERACAO_ACESSO_SITE_PREFEITURA);
        BUTTON_OPERACAO_ACESSO_SITE_PREFEITURA.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				onSitePrefeitura();
			}
		});        

                
        
        
//        // Operação exportar arquivo xml NFSE para o Contador 
//        OPERACAO_EXPORTAR_ARQUIVO_XML_NFSE_PARA_CONTADOR.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(MenuItemClickEvent event) {
//				onExcuteOperacao(NFSEUtilities.OPERACAO_EXPORTAR_ARQUIVO_XML_NFSE_PARA_CONTADOR, getPropertyPeriodoInicial().getHowmFormValueToString(), getPropertyPeriodoFinal().getHowmFormValueToString());
//			}
//		});
//        OPERACAO_EXPORTAR_ARQUIVO_XML_NFSE_PARA_CONTADOR.setIconHeight(iconSize);
//        OPERACAO_EXPORTAR_ARQUIVO_XML_NFSE_PARA_CONTADOR.setIconWidth(iconSize);        
//        
//        
//        
//        // Operação sincronizar ERP x Servidor RPS 
//        OPERACAO_EXPORTAR_ARQUIVOS_PDF_DANFES.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(MenuItemClickEvent event) {
//				onExcuteOperacao(NFSEUtilities.OPERACAO_EXPORTAR_ARQUIVOS_PDF_DANFES, getPropertyPeriodoInicial().getHowmFormValueToString(), getPropertyPeriodoFinal().getHowmFormValueToString());
//			}
//		});
//        OPERACAO_EXPORTAR_ARQUIVOS_PDF_DANFES.setIconHeight(iconSize);
//        OPERACAO_EXPORTAR_ARQUIVOS_PDF_DANFES.setIconWidth(iconSize);        
//        
//
//  
//        // Operação exportar arquivo PDF NFSE. 
//        OPERACAO_EXPORTAR_ARQUIVO_PDF_NFSE.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(MenuItemClickEvent event) {
//				onExcuteOperacao(NFSEUtilities.OPERACAO_EXPORTAR_ARQUIVO_PDF_NFSE, getPropertyPeriodoInicial().getHowmFormValueToString(), getPropertyPeriodoFinal().getHowmFormValueToString());
//			}
//		});
//        OPERACAO_EXPORTAR_ARQUIVO_PDF_NFSE.setIconHeight(iconSize);
//        OPERACAO_EXPORTAR_ARQUIVO_PDF_NFSE.setIconWidth(iconSize);        
//        
//
//        
//        
//        
//        // Operação exportar arquivo PDF NFSE. 
        BUTTON_OPERACAO_ENVIAR_EMAIL_CONTRIBUINTE.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {			
				onSendMail();	
			}
		});
        
 
        menuArquivos.addControl(BUTTON_OPERACAO_VISUALIZAR_HISTORICO); 
        BUTTON_OPERACAO_VISUALIZAR_HISTORICO.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {			
				onShowHistorico();	
			}
		});

                      
        menuArquivos.addControl( BUTTON_OPERACAO_ACESSO_ADMINISTRATOR );
        BUTTON_OPERACAO_ACESSO_ADMINISTRATOR.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				onShowPainelAdministrator();
			}
		});  
        
        
        
//        // --------------------------- MENU - HISTORICO ----------------------------
//        RibbonGroup menuHistorico = new RibbonGroup();  
//        menuHistorico.setTitle(Tradutor.i18n.formHistorico());  
//        menuHistorico.setTitleAlign(Alignment.LEFT);  
//        menuHistorico.setNumRows(1);  
//        menuHistorico.setRowHeight(26);
//        menuHistorico.setHeight(heightMenu);
//
//        actionVisualizarHistorico.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {			
//			@Override
//			public void onClick(ClickEvent event) {
//				actionVisualizarHistorico.setSelected(!actionVisualizarHistorico.isSelected());
//				onVisualizarHistorico(actionVisualizarHistorico.isSelected());
//			}
//		});
//        menuHistorico.addControl(actionVisualizarHistorico);
        
        
        
        
        ribbonBar.addMember(menuFiltro);
        ribbonBar.addMember(menuArquivos);
//        ribbonBar.addMember(menuHistorico);

        mainRibbonBar.addMember(ribbonBar);

        topLayout.addMember(mainRibbonBar); 
        
        mainRibbonBar.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(1, HowMGWTUtilities.backgroundSeparadora));
        mainRibbonBar.addMember(getPainelFiltroAdicional());
        mainRibbonBar.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(1, HowMGWTUtilities.backgroundSeparadora));
        // -------------------------------------------------------------------
        // Inclui um rótulo com ajuda para operar a tela.
        // -------------------------------------------------------------------
    	HTMLPane paneHelp = new HTMLPane();
    	paneHelp.setWidth100();
    	paneHelp.setHeight(15);
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setBorder(Tradutor.i18n.msgBorder());
     	paneHelp.setContents(Tradutor.i18n.msgLookupHelpNFSE());    	
    	mainRibbonBar.addMember(paneHelp);
    	
    	paneEmitente.setCanSelectText(true);
    	paneEmitente.setWidth100();
    	paneEmitente.setHeight(40);
    	paneEmitente.setBackgroundColor(backgroundOptions);
    	paneEmitente.setBorder(Tradutor.i18n.msgBorder());
    	paneEmitente.setContents("");
    	paneEmitente.setAlign(Alignment.CENTER);
    	mainRibbonBar.addMember(paneEmitente);

        this.addMember(topLayout);
	}



    protected void executeOperacao(MenuItem menuItem, String operacao, String dtInicio, String dtFim, String codPlano, String codRPS, String codPedido, String nomeCliente, String codNotaFiscal
    ){

    	this.lastMenuItemExecute = menuItem;
    	this.lastOperacao 		 = operacao;
    	
	    BUTTON_OPERACAO_EXPORTAR_ARQUIVO_XML_NFSE_PARA_CONTADOR.setDisabled(true); 
	    BUTTON_OPERACAO_EXPORTAR_ARQUIVOS_PDF_DANFES.setDisabled(true);
//	    OPERACAO_EXPORTAR_ARQUIVO_PDF_NFSE.setDisabled(true);
//	    OPERACAO_ENVIAR_EMAIL_CONTRIBUINTE.setDisabled(true);
	    
	    OPERACAO_SUPORTE_INTELIGENTE.setVisible(false);
	    
	    OPERACAO_ENVIAR_RPS_PREFEITURA.setVisible(false);
	    OPERACAO_REENVIAR_RPS_PREFEITURA.setVisible(false);
        BUTTON_OPERACAO_CANCELAR_ENVIO_RPS.setVisible(false);
        BUTTON_OPERACAO_CANCELAR_NFSE.setVisible(false);
        BUTTON_OPERACAO_ENVIAR_EMAIL_CONTRIBUINTE.setDisabled(true);
        BUTTON_OPERACAO_SINCRONIZAR_RPS_PENDENTES.setVisible(false);
        actionVisualizarHistorico.setDisabled(true);
	    
	    menuArquivos.redraw();
	    onShowSelect(true);
    	if( NFSEUtilities.OPERACAO_AGUARDANDO_PROCESSAMENTO_NA_PREFEITURA.equals(operacao)){
            BUTTON_OPERACAO_CANCELAR_ENVIO_RPS.setVisible(true);
            
            BUTTON_OPERACAO_SINCRONIZAR_RPS_PENDENTES.setVisible(true);
            actionVisualizarHistorico.setDisabled(false);
    	    OPERACAO_REENVIAR_RPS_PREFEITURA.setVisible(true);

    	}
    	else if( NFSEUtilities.OPERACAO_EMITIDAS_NA_PREFEITURA.equals(operacao)){

    	    BUTTON_OPERACAO_EXPORTAR_ARQUIVO_XML_NFSE_PARA_CONTADOR.setDisabled(false); 
    	    BUTTON_OPERACAO_EXPORTAR_ARQUIVOS_PDF_DANFES.setDisabled(false);
    	    BUTTON_OPERACAO_CANCELAR_NFSE.setVisible(true);
//    	    OPERACAO_EXPORTAR_ARQUIVO_PDF_NFSE.setDisabled(false);
//    	    OPERACAO_ENVIAR_EMAIL_CONTRIBUINTE.setDisabled(false);
    	    
    	    
    	    // TODO habilitado em 03/03/2014 - 12:07 - possibilita sincronizar status nfse emitida.  
            BUTTON_OPERACAO_SINCRONIZAR_RPS_PENDENTES.setVisible(true);
    	    actionVisualizarHistorico.setDisabled(false);
    	    
    	    
    	    BUTTON_OPERACAO_ENVIAR_EMAIL_CONTRIBUINTE.setDisabled(false);    	    
    	}
    	else if ( NFSEUtilities.OPERACAO_NOTAS_FISCAIS_PENDENTES_PARA_ENVIO.equals(operacao)){
    	    OPERACAO_ENVIAR_RPS_PREFEITURA.setVisible(true);

    		onShowSelect(false);
    	}
    	
    	
    	
    	
    	this.labelOption.setContents("<strong><font color='#ffffff'>"+menuItem.getTitle()+"</font></strong>");
    	
    	onExecuteOperacao(operacao, dtInicio, dtFim, codPlano, codRPS, codPedido, nomeCliente, codNotaFiscal);    	
    	onRefresMenu();
    }


    /**
     * Abstrações a serem implementadas.
     */
	protected abstract void onExecuteOperacao(String operacao, String dtInicio, String dtFim, String codPlano, String codRPS, String codPedido, String nomeCliente, String codNotaFiscal);
	// protected abstract void onVisualizarHistorico(boolean visualizarHistorico);
	protected abstract void onMonitorG2KA();
	protected abstract void onEnviarRPSProcessamento();
	
	
	
	
	
	
	
	public void onRefresMenu(){

		String dadosEmitente = "";
		dadosEmitente += "<table style=\"width:100%; heigth:100%; color:#FFFFFF;\">";
		
		dadosEmitente += "<tbody>";
		dadosEmitente += "<tr>";
		if( this.currentEntityEmitente != null && this.currentEntityEmitente.getEntityParametroWS() != null ){
			dadosEmitente += "<td width=140px;>";
			if( HowMGWTUtilities.getBoolean( this.currentEntityEmitente.getEntityParametroWS().getTipoOffLine() ) ){
				
			    BUTTON_OPERACAO_EXPORTAR_ARQUIVO_XML_NFSE_PARA_CONTADOR.setDisabled(true); 

		        dadosEmitente += "Integração : <strong>OFFLINE</strong>";
			}
			else{
				dadosEmitente += "Integração : <strong>WEB-Services</strong>"; 
			}
			dadosEmitente += "</td>";
			dadosEmitente += "<td width=150px;>";
			dadosEmitente += "CNPJ do Prestador : <strong>"+HowMGWTUtilities.formatCNPJ( this.currentEntityEmitente.getCnpj() ) +"</strong>" + "&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;<strong>"+this.currentEntityEmitente.getCodEmitente() +"-"+this.currentEntityEmitente.getNmFantasia()+"</strong>";
			dadosEmitente += "</td>";
			
			// Se não tiver configuração de monitoramento, então desabilita o botão.
			if( this.currentEntityEmitente.getEntityConfiguracaoWS() != null ){
				BUTTON_OPERACAO_MONITOR_INTEGRACAO.setDisabled(false);

				dadosEmitente += "<td width=120px;>";
				if ( HowMGWTUtilities.isEmpty( this.currentEntityEmitente.getEntityConfiguracaoWS().getNmSenhaMonitoramento() ) 
					|| 
					HowMGWTUtilities.isEmpty( this.currentEntityEmitente.getEntityConfiguracaoWS().getNmUsuario() ) ){
					dadosEmitente += "Monitoramento : <strong>Indisponivel por falta de configuração ...</strong>";
				}
				else{
					dadosEmitente += "Monitoramento : <strong>Disponivel</strong>";
				}
				dadosEmitente += "</td>";

			}
			else{
				BUTTON_OPERACAO_MONITOR_INTEGRACAO.setDisabled(true);
				dadosEmitente += "<td>";
				dadosEmitente += "Monitoramento : <strong>Indisponivel por falta de configuração ...</strong>";
				dadosEmitente += "</td>";
			}			
		}
		else{
		    BUTTON_OPERACAO_EXPORTAR_ARQUIVO_XML_NFSE_PARA_CONTADOR.setDisabled(true); 
		    BUTTON_OPERACAO_EXPORTAR_ARQUIVOS_PDF_DANFES.setDisabled(true);
//		    OPERACAO_EXPORTAR_ARQUIVO_PDF_NFSE.setDisabled(true);
//		    OPERACAO_ENVIAR_EMAIL_CONTRIBUINTE.setDisabled(true);
//	        OPERACAO_ENVIAR_RPS_PREFEITURA.setDisabled(true);
	        BUTTON_OPERACAO_CANCELAR_ENVIO_RPS.setDisabled(true);
	        BUTTON_OPERACAO_CANCELAR_NFSE.setDisabled(true);
	        BUTTON_OPERACAO_SINCRONIZAR_RPS_PENDENTES.setDisabled(true);
	        BUTTON_OPERACAO_MONITOR_INTEGRACAO.setDisabled(true);
	        actionVisualizarHistorico.setDisabled(true);
			dadosEmitente += "<td>";
	        dadosEmitente += "Emitente não Integrado ...";
			dadosEmitente += "</td>";
		}
		dadosEmitente += "</tr>";
		if( this.currentEntityEmitente != null && this.currentEntityEmitente.getEntityParametroWS() != null ){
			dadosEmitente += "<tr>";
			dadosEmitente += "<td>";
			dadosEmitente += "Cidade: <Strong>"+this.currentEntityEmitente.getCodMunicipio()+"-"+this.currentEntityEmitente.getMunicipio()+"</Strong>";
			dadosEmitente += "</td>";
			dadosEmitente += "<td>";
			dadosEmitente += "Pasta de Integração : <Strong>"+this.currentEntityEmitente.getEntityFilaWS().getPstint()+"</Strong>";
			dadosEmitente += "</td>";

			dadosEmitente += "<td>";			
			String controlaNumeracao = "";
			if(HowMGWTUtilities.getBoolean(this.currentEntityEmitente.getEntityConsultaWS().getIndControlaSubsequente())){
				dadosEmitente += "<Strong>Controla numeração na Prefeitura.</strong>";
			}						
			dadosEmitente += "</td>";
			
			dadosEmitente += "</tr>";		
		}
		dadosEmitente += "</tbody>";
		dadosEmitente += "</table>";

		paneEmitente.setContents(dadosEmitente);
		
	}

	public boolean isRefreshMenu(eNFSEEmitenteWS entityEmitente){
		if( this.currentEntityEmitente == null ){
			this.setCurrentEntityEmitente(entityEmitente);
			this.onRefresMenu();
			return false;
		}		
		return true;
	}

	
	public void configureSistema(com.br.client.model.vd.vdw1000.FormBean formBean){
		
		this.setCurrentFormBeanConfiguration(formBean);
		
		if( HowMGWTUtilities.isEmpty( formBean.getIndSendMailNFSEBoleto() ) || "0".equals(formBean.getIndSendMailNFSEBoleto())){
			this.BUTTON_OPERACAO_ENVIAR_EMAIL_CONTRIBUINTE.setVisible(false);
			this.menuArquivos.redraw();
		}

		urlSitePrefeitura = formBean.getUrlLinkPrefeitura();
		
		if( HowMGWTUtilities.isEmpty( urlSitePrefeitura )){
			this.BUTTON_OPERACAO_ACESSO_SITE_PREFEITURA.setVisible(false);
			this.menuArquivos.redraw();
		}
		
		if( HowMGWTUtilities.isEmpty( formBean.getUrlConsultaNFSePrefeitura() ) ){
			this.BUTTON_OPERACAO_EXPORTAR_ARQUIVOS_PDF_DANFES.setVisible(false);
			this.menuArquivos.redraw();			
		}
		
		if( HowMGWTUtilities.isEmpty( formBean.getSenhaSuporte() ) || HowMGWTUtilities.isEmpty( formBean.getUsuarioSuporte()  ) ){
			this.BUTTON_OPERACAO_ACESSO_ADMINISTRATOR.setVisible(false);
			this.menuArquivos.redraw();
		}
	}
	
	protected void onShowSelect(boolean selected){}
	
	protected  void onCancelarEnvioRPS(){}
	
	protected void onConfigurarServico(){
		if( windowConfiguracaoServicos == null ) {
			windowConfiguracaoServicos = new WindowConfiguracaoServicos();		
		}
		windowConfiguracaoServicos.showConfiguracoes(currentEntityEmitente);
	}

	protected void onSendMail(){}
	
	protected void onShowHistorico(){}
	
	protected void onForcarSincronismoRPS(){}
	
	protected void onVisualizarNFSePrefeitura(){}
	
	protected void onSitePrefeitura(){
		Window.open(this.urlSitePrefeitura, "Portal NFS-e", "");
	};

	protected void onShowPainelAdministrator(){
		if( panelRibbonBarSuporte == null ){
			panelRibbonBarSuporte = new PanelRibbonBarSuporte(this);					
		}
		topLayout.removeMember(mainRibbonBar);
		topLayout.addMember(panelRibbonBarSuporte);	
		topLayout.redraw();		
		panelRibbonBarSuporte.configure(lastOperacao);
		panelRibbonBarSuporte.getPanelLoginSuporte().configure(this.getCurrentFormBeanConfiguration().getUsuarioSuporte(), this.getCurrentFormBeanConfiguration().getSenhaSuporte() );
	}

	public void onBack(){
		topLayout.removeMember(panelRibbonBarSuporte);
		topLayout.addMember(mainRibbonBar);
		topLayout.redraw();				
	}

	// protected void onRegerarReenviarRPS(){}

	protected void onAnalisarRPS(){}
	protected void onDownloadAI(){}

	public com.br.client.model.vd.vdw1000.FormBean getCurrentFormBeanConfiguration() {
		return currentFormBeanConfiguration;
	}

	public void setCurrentFormBeanConfiguration(
			com.br.client.model.vd.vdw1000.FormBean currentFormBeanConfiguration) {
		this.currentFormBeanConfiguration = currentFormBeanConfiguration;
	}

	public HowMGWTProperty getPropertyCodPlano() {
		return propertyCodPlano;
	}

	public HowMGWTProperty getPropertyCodRPS() {
		return propertyCodRPS;
	}

	public HowMGWTProperty getPropertyCodPedido() {
		return propertyCodPedido;
	}

	public HowMGWTProperty getPropertyNomeCliente() {
		return propertyNomeCliente;
	}

	public HowMGWTProperty getPropertyCodNotaFiscal() {
		return propertyCodNotaFiscal;
	}

	public PainelFiltroAdicional getPainelFiltroAdicional() {
		return painelFiltroAdicional;
	}

	public PanelRibbonBarSuporte getPanelRibbonBarSuporte() {
		return panelRibbonBarSuporte;
	}

	public String getLastOperacao() {
		return lastOperacao;
	}
	
	public void onSuporteInteligente(){
		
	}
}