package com.br.client;
 

import java.util.logging.Level;
import java.util.logging.Logger;

import org.timepedia.exporter.client.ExporterUtil;



// import com.allen_sauer.gwt.log.client.Log;
import com.br.client.configuracao.Configuracao;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.cd.cdq0101.UI.LookupBuscaCliente;
import com.br.client.panel.ed.edw0001.UI.PainelEDI;
import com.br.client.panel.ed.edw0002.UI.PainelMonitorEDI;
import com.br.client.panel.ed.edw0003.UI.PainelLayoutManager;
import com.br.client.panel.fn.fnw0015.UI.PainelBoletimCaixa;
import com.br.client.panel.fn.fnw0016.UI.PainelResultadoOperacional;
import com.br.client.panel.registro.UIPartner;
import com.br.client.panel.sg.sgw0027.UI.PainelNFSE;
import com.br.client.panel.vd.vdp0001.UI.PainelGerenciador;
import com.br.client.panel.vd.vdw0030.UI.PainelMotivosDevolucao;
import com.br.client.panel.vd.vdw0031.UI.PainelSolicitacaoDevolucao;
import com.br.client.panel.vd.vdw0035.UI.ManagerNFSE;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.user.client.ui.RootPanel;
import com.howmake.client.form.UI.HowMGWTWindowBase;
import com.howmake.client.form.UI.HowMGWTWindowHelp;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.partner.HowMGWTNavigator;
import com.smartgwt.client.types.HeaderControls;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HeaderControl;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class UnoGWT implements EntryPoint    {

	
	
    public static UIPartner partner = null;
     
    private HowMGWTWindowBase currentWindow;
    
    public void onModuleLoad() {   
    
//    	Window.addWindowClosingHandler(new Window.ClosingHandler() {
//			
//			@Override
//			public void onWindowClosing(ClosingEvent event) {
//				event.setMessage("Deseja realmente sair do sistema ?");
//				
//			}
//		});

//    	if( 1 == 2){
//    		VLayout mainLayout = new VLayout();
//    		mainLayout.setWidth100();
//    		mainLayout.setHeight100();
//    		
//    		HowMGWTUpload upload = new HowMGWTUpload();
//    		upload.setBackgroundColor("rgb(230,230,230)");
//    		
//    		mainLayout.addMember(upload);
//    		
//    		mainLayout.show();
//    		return;
//    	}
    	
    	
    	// ScriptInjector    	
    	// com.google.gwt.core.client.ScriptInjector;
    	
    	
    	String styleInject = "";

		styleInject += ".DirectSaleShadow{\n";
		styleInject += "	-webkit-box-shadow: 6px 5px 10px 0px rgba(50, 50, 50, 100); ";
		styleInject += "	box-shadow: 6px 5px 10px 0px rgba(50, 50, 50, 100);\n";							
		styleInject += "}\n";	
		
		StyleInjector.inject(styleInject, true);
    	
    	
    	
    	// Oculta o div de leitura dos componentes GWT.
    	RootPanel root = RootPanel.get("loadingWrapper");
    	root.setVisible(false);
 
    	GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
				
			@Override
			public void onUncaughtException(Throwable e) {
				HowMGWTWindowWait.hideWait();
				e.printStackTrace();
				
				Logger logger = Logger.getLogger("");
				logger.log(Level.ALL, "Ex caught!", e);
				
				String st = "";
				if ( e.getStackTrace() != null ){
					
					st ="<hr>"+e.getClass().getName() + ": " + e.getMessage()+"<hr>";
					for (StackTraceElement ste : e.getStackTrace())
						st += "<br>" + ste.toString();				
				}	
				SC.say("Erro: " +e.getMessage()+"<hr>Causa:<br/>"+st);
			}
		});
 
//    	Log.setCurrentLogLevel(Log.getLowestLogLevel()); 
//
//    	Log.setUncaughtExceptionHandler(); 
//
//    	Log.info( "HowM" );     	
    	    	
    	// Exporta as classes para acesso pelo JavaScript
    	
    
    	ExporterUtil.exportAll();
     
    	
    	// Inicializa o objeto de gateway para conversação com o GWT.
    	Configuracao.nativeUnoGWTInitializeGateway();
    	

//    	Configuracao cfg = new Configuracao();

    	// Utilizado em modo de desenvolvimento
    	Configuracao.setBaseUrlServices(Configuracao.getNativeUnoUrlService());  
    	
    	if ( "AGENT".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){
    		HowMGWTNavigator.showAgentBrowser();
    		return;
    	}
        if ( "SERVICE".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){
        	return;
        }    	
    	
    	
    	HowMGWTWindowBase window = new HowMGWTWindowBase();  
        window.setTitle("Sistema Gerenciador de Modulos UNOSolucoes");  
        window.setShowCloseButton(false);
        window.setShowMaximizeButton(false);
        window.setShowMinimizeButton(false);
        window.setWidth100();  
        window.setHeight100();  
        
        
        currentWindow = window;
        
        
		ClickHandler clickHandler = new ClickHandler() {  
            public void onClick(ClickEvent event) {  
//                String src = ((HeaderControl) event.getSource()).getSrc();  
                HowMGWTWindowHelp.showHelp(Configuracao.getNativeUnoProgramaGWT());  
            }  
        };

        HeaderControl help = new HeaderControl(HeaderControl.HELP, clickHandler); 
 
        
        Label labelBodyVersion = new Label(Configuracao.getUnoCorpoGWT()+" "+Configuracao.getUnoVersionGWT());
        labelBodyVersion.setWrap(false);
        
        window.setHeaderControls(HeaderControls.HEADER_LABEL, labelBodyVersion ,help);
              
    	
        HLayout mainLayout = new HLayout();   
        mainLayout.setWidth100();
        mainLayout.setHeight100();
        
        mainLayout.addMember(window);


        if ( 		"VDP0001".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new PainelGerenciador();
        	// window.setShowHeader(true);
        	window.setTitle(Tradutor.i18n.formTituloVDP0001());
        }
        else if ( 	"SGW0027".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new PainelNFSE();
        	// window.setShowHeader(true);
        	window.setTitle(Tradutor.i18n.formTituloSGW0027());
        }
        else if (   "FNW0217".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new com.br.client.panel.fn.fnw0217.UI.PainelGerenciador(false);
        	window.setTitle(Tradutor.i18n.formTituloFNW0217());
        }else if (   "FNW0235".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new com.br.client.panel.fn.fnw0235.UI.PainelGerenciador(true);
        	window.setTitle(Tradutor.i18n.formTituloFNW0235());
        }
        else if (   "FNW0223".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new com.br.client.panel.fn.fnw0223.UI.PainelGerenciador(false);
        	window.setTitle(Tradutor.i18n.formTituloFNW0223());
        }
        else if (   "FNW0224".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new com.br.client.panel.fn.fnw0223.UI.PainelGerenciador(true);
        	window.setTitle(Tradutor.i18n.formTituloFNW0224());
        } 
        else if (   "FNW0228".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new com.br.client.panel.fn.fnw0228.UI.PainelGerenciador(false);
        	window.setTitle(Tradutor.i18n.formTituloFNW0228());
        }
        else if (   "FNW0229".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new com.br.client.panel.fn.fnw0228.UI.PainelGerenciador(true);
        	window.setTitle(Tradutor.i18n.formTituloFNW0229());
        }
        else if (   "FNW0230".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new com.br.client.panel.fn.fnw0230.UI.PainelGerenciador(false);
        	window.setTitle(Tradutor.i18n.formTituloFNW0230());
        }
        else if (   "teste".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new com.br.client.panel.fn.fnw0223.teste.PainelGerenciador();
        	window.setTitle(Tradutor.i18n.formTituloFNW0230());
        }
        else if (   "FNW0221".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new com.br.client.panel.fn.fnw0217.UI.PainelGerenciador(true);
        	window.setTitle(Tradutor.i18n.formTituloFNW0221());
        }        
        else if (   "FNW0017".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new com.br.client.panel.fn.fnw0017.UI.ManagerEbitida();
        	// window.setShowHeader(true);
        	window.setTitle(Tradutor.i18n.formTituloFNW0017());
        }
        else if (  "FNR0010".equals(Configuracao.getNativeUnoProgramaGWT())){        	
        	partner = new com.br.client.panel.fn.fnr0010.UI.PainelGerenciador();
        	// window.setShowHeader(true);
        	window.setTitle(Tradutor.i18n.formTituloFNR0010());
        	window.setTitle(((com.br.client.panel.fn.fnr0010.UI.PainelGerenciador)partner).getHowMGWTFormTitle());

        }
        else if (  "GGW0006".equals(Configuracao.getNativeUnoProgramaGWT())){        	
        	partner = new com.br.client.panel.gg.ggw0006.UI.PainelGerenciadorRentabilidade();
        	// window.setShowHeader(true);
        	window.setTitle(((com.br.client.panel.gg.ggw0006.UI.PainelGerenciadorRentabilidade)partner).getHowMGWTFormTitle());
        }        
        else if (  "VDW0028".equals(Configuracao.getNativeUnoProgramaGWT())){        	
        	partner = new com.br.client.panel.vd.vdw0028.UI.PainelAutorizacaoDevolucao();
        	// window.setShowHeader(true);
        	window.setTitle(((com.br.client.panel.vd.vdw0028.UI.PainelAutorizacaoDevolucao)partner).getHowMGWTFormTitle());        	
        }                        
        else if (  "FNR0011".equals(Configuracao.getNativeUnoProgramaGWT())){        	
        	partner = new com.br.client.panel.fn.fnr0011.UI.PainelGerenciador();
        	// window.setShowHeader(true);
        	window.setTitle(((com.br.client.panel.fn.fnr0011.UI.PainelGerenciador)partner).getHowMGWTFormTitle());
        }
        else if (  "FNW0015".equals(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new com.br.client.panel.fn.fnw0015.UI.PainelBoletimCaixa();
        	PainelBoletimCaixa boletimCaixa = (PainelBoletimCaixa)partner;
        	// window.setShowHeader(true);
        	boletimCaixa.setParentWindow(window);
        	window.setTitle(boletimCaixa.getHowMGWTPrograma()+"-"+boletimCaixa.getHowMGWTTitle());
        }
        else if (  "VDW0800".equals(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new com.br.client.panel.vd.vdw0800.UI.PainelNFSE();
        	com.br.client.panel.vd.vdw0800.UI.PainelNFSE painelNFSE = (com.br.client.panel.vd.vdw0800.UI.PainelNFSE)partner;
        	// window.setShowHeader(true);
        	window.setTitle(painelNFSE.getHowMGWTPrograma()+"-"+painelNFSE.getHowMGWTTitle());
        }
        else if (  "EDW0001".equals(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new PainelEDI();
        	PainelEDI painelEDI = (PainelEDI)partner;
        	// window.setShowHeader(true);
        	window.setTitle(painelEDI.getHowMGWTPrograma()+"-"+painelEDI.getHowMGWTTitle());        	
        }
        else if (  "EDW0002".equals(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new PainelMonitorEDI();
        	PainelMonitorEDI painelMonitorEDI = (PainelMonitorEDI)partner;
        	// window.setShowHeader(true);
        	window.setTitle(painelMonitorEDI.getHowMGWTPrograma()+"-"+painelMonitorEDI.getHowMGWTTitle());
        }
        else if (  "FNW0016".equals(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new PainelResultadoOperacional();
        	PainelResultadoOperacional painelResultadoOperacional = (PainelResultadoOperacional)partner;
        	// window.setShowHeader(true);
        	window.setTitle(painelResultadoOperacional.getHowMGWTPrograma()+"-"+painelResultadoOperacional.getHowMGWTTitle());
        }
        
        
        
        
        else if (  "EDW0003".equals(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new PainelLayoutManager();
        	PainelLayoutManager painelLayoutManager = (PainelLayoutManager)partner;
        	// window.setShowHeader(true);
        	window.setTitle(painelLayoutManager.getHowMGWTPrograma()+"-"+painelLayoutManager.getHowMGWTTitle());
        }
        
        else if (  "VDW0030".equals(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new PainelMotivosDevolucao();
        	PainelMotivosDevolucao painelLayoutManager = (PainelMotivosDevolucao)partner;
        	// window.setShowHeader(true);
        	window.setTitle(painelLayoutManager.getHowMGWTPrograma()+"-"+painelLayoutManager.getHowMGWTTitle());
        }
        
        else if (  "VDW0031".equals(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new PainelSolicitacaoDevolucao();
        	PainelSolicitacaoDevolucao painelLayoutManager = (PainelSolicitacaoDevolucao)partner;
        	// window.setShowHeader(true);
        	window.setTitle(painelLayoutManager.getHowMGWTPrograma()+"-"+painelLayoutManager.getHowMGWTTitle());
        }
        
        else if (  "VDW0035".equals(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new ManagerNFSE();
        	ManagerNFSE painelLayoutManager = (ManagerNFSE)partner;
        	// window.setShowHeader(true);
        	window.setTitle(painelLayoutManager.getHowMGWTPrograma()+"-"+painelLayoutManager.getHowMGWTTitle());
        }
        else if (  "VDW1000".equals(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new com.br.client.panel.vd.vdw1000.UI.ManagerNFSE(){
        		protected void onShowVersaoOLDNFSE(){
                	partner = new PainelNFSE();
                	// window.setShowHeader(true);
                	currentWindow.setTitle(Tradutor.i18n.formTituloSGW0027());
                    partner.start();
                    currentWindow.addItem((Canvas)partner);   
                	
        		};
        	};
        	com.br.client.panel.vd.vdw1000.UI.ManagerNFSE painelLayoutManager = (com.br.client.panel.vd.vdw1000.UI.ManagerNFSE)partner;
        	// window.setShowHeader(true);
        	window.setTitle(painelLayoutManager.getHowMGWTPrograma()+"-"+painelLayoutManager.getHowMGWTTitle());
        }
        else if (   "CDQ0101".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT() )){
        	mainLayout.draw(); 
        	partner = new LookupBuscaCliente();
        	((com.smartgwt.client.widgets.Window)partner).show();
        	return;
        }
        else if (   "CDQ0001".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT() )){        		
        	mainLayout.draw(); 
        	partner = new com.br.client.panel.vd.vdq0001.UI.LookupBuscarPedido();
        	((com.smartgwt.client.widgets.Window)partner).show();
        	return;

        }     
        else if (   "VDQ0002".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new com.br.client.panel.vd.vdq0002.UI.PainelGerenciador(true);
        	((com.smartgwt.client.widgets.Window)partner).show();
        	return;        
        }
        else if (   "OCW0001".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new com.br.client.panel.oc.ocw0001.grantt.PainelGerenciadorGrantt();
        	
        	((com.smartgwt.client.widgets.Window)partner).show();
        	return;        
        }
        else if (   "ATW0117".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){

        	partner = new com.br.client.panel.at.atw0117a.ManagerAgenda();
        	
        	((com.smartgwt.client.widgets.Window)partner).show();
        	return;        

        	
//        	partner = new com.br.client.panel.at.atw0117.PainelAgendaTouchScreen();
//        	
//        	((com.smartgwt.client.widgets.Window)partner).show();
//        	return;        
        }

        else if (   "ATW0117a".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){
        	partner = new com.br.client.panel.at.atw0117a.ManagerAgenda();
        	
        	((com.smartgwt.client.widgets.Window)partner).show();
        	return;        
        }

        
        
        else if ( "SERVICE".equalsIgnoreCase(Configuracao.getNativeUnoProgramaGWT())){
        	return;
        }
        else{
           
            String msg = Tradutor.i18n.erroProgramaInformadoNaoEncontrado();
            msg = msg.replaceAll("_programa_", Configuracao.getNativeUnoProgramaGWT());

            SC.say(msg);
        	return;
        }
        partner.start();
        
  
        window.addItem((Canvas)partner);   
        
        mainLayout.draw(); 
    }
}