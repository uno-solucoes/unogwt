package com.br.client.panel.vd.vdw1000.UI;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.smartgwt.client.types.ContentsType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class PanelG2KA extends HowMGWTWindow{

	private HTMLPane paneG2KA = new HTMLPane();	
	
	private String urlNFSE	= "http://sorocaba.unoerp.com.br:6060/nfse/"; 
	private String user		= "";
	private String senha	= "";
	
	IButton actionReload 	= new IButton();
	
	VLayout mainLayout = new VLayout();
	
	public PanelG2KA(String urlNFSE, String user, String senha){

		this.user 		= user;
		this.senha 		= senha;
		this.urlNFSE 	= urlNFSE; 
		
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		ToolStrip tools = new ToolStrip();
		tools.setWidth100();		

		actionReload.setIcon("actions/refresh.png");
		actionReload.setTitle("Recarregar");
		tools.addMember(actionReload);
		actionReload.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				reloadSistemaG2KA();
			}
		});

		mainLayout.addMember(tools);
				
		this.urlNFSE 	= urlNFSE;
		this.user    	= user;
		this.senha		= senha;

		paneG2KA.setWidth100();
		paneG2KA.setHeight100();

		paneG2KA.setOverflow(Overflow.AUTO);
		
		paneG2KA.setContentsType(ContentsType.PAGE);
		
		mainLayout.addMember(paneG2KA);
		
		this.addItem(mainLayout);
	}	
	
	@Override
	public String getHowMGWTTitle() {
		return "NFS-e Monitor";
	}

	@Override
	public String getHowMGWTPrograma() {
		return "VDW1000M";
	}
	
	public void onShowMonitor(){
		setWidth(960);
		setHeight(660);
		this.centerInPage();
		this.show();		
		loadSistemaG2KA();
	}
	
	
	/**
	 * Carrega a tela de monitoramento da G2KA.
	 */
	public void loadSistemaG2KA(){			
		show();			
		HowMGWTWindowWait.showWait("Aguarde carregando NFS-e Monitor");
		paneG2KA.setContentsURL(urlNFSE +"?usuario="+user+"&senha="+senha);
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {			
			@Override
			public void execute() {

				Timer timer = new Timer() {
					@Override
					public void run() {
						HowMGWTWindowWait.hideWait();
					}
				};
				timer.schedule(1400);
			}
		});
	}
	
		
	/**
	 * Recarrega a pagina de monitormanto G2KA e reconnecta o usuório associado a empresa.
	 */
	public void reloadSistemaG2KA(){
		HowMGWTWindowWait.showWait("Aguarde carregando NFS-e Monitor");
		paneG2KA.setContentsURL(null);
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {			
			@Override
			public void execute() {
				paneG2KA.setContentsURL(urlNFSE +"?usuario="+user+"&senha="+senha);
				Timer timer = new Timer() {					
					@Override
					public void run() {
						HowMGWTWindowWait.hideWait();
					}
				};
				timer.schedule(1400);
			}
		});
	}
	
	
//	public void findIFrameAll(){
//		NodeList<Element> nodes = Document.get().getElementsByTagName("iframe");
//		System.out.println("Nos : "+nodes.getLength());
//		for ( int i = 0 ; i < nodes.getLength(); i++ ){			
//			 Node node = nodes.getItem(i);
//			 
//			 System.out.println(node);			 
//			 findIFrame(((IFrameElement)node).getContentDocument());			
//		};
//	}	
//
//	public void findIFrame(Node parentNode){
//		NodeList<Node> nodes = parentNode.getChildNodes();
//		for ( int i = 0 ; i < nodes.getLength(); i++ ){
//			
//			Node node = nodes.getItem(i);
//			if( node.toString().startsWith("<iframe")  ){
//				
//				IFrameElement iframe = (IFrameElement)node;
//				System.out.println("Item : "+node);
//				
//				System.out.println("iframe : "+node);
//				
//				findIFrame(iframe.getContentDocument());
//			}
//			else{
//				System.out.println("Item : "+node);
//				findIFrame(node);
//			}			
//		};		
//	}
}