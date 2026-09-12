package com.howmake.client.form.UI;

import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.user.client.Timer;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.layout.HLayout;

public class HowMGWTWindowWait extends HowMGWTWindowBase{

	private static HowMGWTWindowWait defaultWindowHelp;

	private HTMLPane helpPane = new HTMLPane();
	
	private HowMGWTWindowWait(){
		
        this.setWidth("320px");
        this.setHeight("60px");
        this.setMaximized(false);
        this.setCanDrag(false);
        this.setCanDragResize(false);
        this.setShowMinimizeButton(false);
        this.setCanDragReposition(false);
        this.setIsModal(true);
        this.setTitle("Em Processamento");

        this.centerInPage();

        HLayout hLayout = new HLayout();
        hLayout.setWidth100();
        hLayout.setHeight100();

        final Img image = new Img("loading.gif", 28,28); 
        image.setWidth("28");
        image.setHeight("28");

        hLayout.addMember(image);
        
        // hLayout.addMember(helpPane);
        helpPane.setMargin(6);
        hLayout.addMember(helpPane);
        this.addItem(hLayout);
	}
	
	

	/**
	 * Mostra o Help para o usuório.
	 * @param modulo
	 */
	public static final void setMessage(String mensagem){
		if( defaultWindowHelp == null ){
			defaultWindowHelp = new HowMGWTWindowWait();
		}
		defaultWindowHelp.getHelpPane().setContents(mensagem);
	}

	
	/**
	 * Mostra o Help para o usuório.
	 * @param modulo
	 */
	public static final void showWait(String title){
		if( defaultWindowHelp == null ){
			defaultWindowHelp = new HowMGWTWindowWait();
		}
		
		defaultWindowHelp.show(title);
	}	
	
	/**
	 * Mostra o Help para o usuório.
	 * @param modulo
	 */
	public static final void showWait(){
		if( defaultWindowHelp == null ){
			defaultWindowHelp = new HowMGWTWindowWait();
		}
		
		defaultWindowHelp.show(Tradutor.i18n.msgWaitProcess());
	}
 
	/**
	 * Apresenta uma janela com um icone animado para indicar 
	 * processamento de dados no servidor.
	 * @param mensagem
	 */
	public void show(String mensagem){
		
		this.helpPane.setContents(mensagem);
		defaultWindowHelp.show();
		
	}
	
	/**
	 * Mostra o Help para o usuório.
	 * @param modulo
	 */
	public static final void hideWait(){
		if( defaultWindowHelp == null ){
			defaultWindowHelp = new HowMGWTWindowWait();
		}
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				defaultWindowHelp.hide();
			}
		};
		timer.schedule(20);
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