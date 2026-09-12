package com.howmake.client.form.UI;

import com.smartgwt.client.types.ContentsType;
import com.smartgwt.client.types.HeaderControls;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.HeaderControl;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

public class HowMGWTWindowHelp extends HowMGWTWindowBase{

	private static HowMGWTWindowHelp defaultWindowHelp;

	private HTMLPane helpPane = new HTMLPane();
	
	private HowMGWTWindowHelp(){
        this.setWidth("860px");
        this.setHeight("600px");
        this.setMaximized(false);
        this.setCanDrag(false);
        this.setCanDragResize(false);
        this.setShowMinimizeButton(false);
        // this.setCanDragReposition(false);
        this.setIsModal(true);
        this.setTitle("Ajuda do Sistema");
        
       ClickHandler closeHandler = new ClickHandler() {  
            public void onClick(ClickEvent event) {  
            	HowMGWTWindowHelp.this.hide();
            }  
        };

        HeaderControl close = new HeaderControl(HeaderControl.CLOSE, closeHandler);  
        
        this.setHeaderControls(HeaderControls.HEADER_LABEL, close);
        this.centerInPage();

        
		helpPane.setWidth100();
        helpPane.setHeight100();
        helpPane.setContentsType(ContentsType.PAGE);
        
        this.addItem(helpPane);
	}

	/**
	 * Mostra o Help para o usuório.
	 * @param modulo
	 */
	public static final void showHelp(String modulo){
		if( defaultWindowHelp == null ){
			defaultWindowHelp = new HowMGWTWindowHelp();
		}
		defaultWindowHelp.show(modulo);
	}

	private void show(String modulo){
		
		// (gwt_) Removido conforme solicitado pelo Marcio
		String help = "http://www.unoerp.com.br/manual_html/index.html?"+modulo.trim().toLowerCase()+".htm";
		// this.show();
		// this.getHelpPane().setContentsURL("http://localhost:8080/Desenv/vdq0002.do?method=prepListar&filtraNOP=true");
		// this.getHelpPane().setContentsURL(help);
		// System.out.println("Ajuda : "+help);
	
		com.google.gwt.user.client.Window.open(help, "HELP", "");
	}
	
	/**
	 * @return the helpPane
	 */
	public HTMLPane getHelpPane() {
		return helpPane;
	}

	/**
	 * @param helpPane the helpPane to set
	 */
	public void setHelpPane(HTMLPane helpPane) {
		this.helpPane = helpPane;
	}
}