package com.howmake.client.form.UI;

import com.br.client.configuracao.Configuracao;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.HeaderControls;
import com.smartgwt.client.widgets.HeaderControl;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
 

public abstract class HowMGWTWindow extends HowMGWTWindowBase {

	private Label labelCorpo;
	private boolean canClose = true;
	
	public HowMGWTWindow(){
		this(true);
	}
	
	public HowMGWTWindow(boolean canClose){
	
		this.canClose = canClose;
		
		// Monta o título a ser setado na janela.
		String title = "";
		title += this.getHowMGWTPrograma();
		title += " - " + this.getHowMGWTTitle();
		this.setTitle(title);
		
		
		this.addCloseClickHandler(new CloseClickHandler(){

			@Override
			public void onCloseClick(CloseClickEvent event) {
				if ( HowMGWTWindow.this.canClose ){
	            	HowMGWTWindow.this.hide();
	            	onHowMGWTClose();
				}
			}
			
		});
		
		ClickHandler helpHandler = new ClickHandler() {  
            public void onClick(ClickEvent event) {  
            	HowMGWTWindowHelp.showHelp(getHowMGWTPrograma());
            }  
        };
        
       ClickHandler closeHandler = new ClickHandler() {  
            public void onClick(ClickEvent event) {  
            	if ( HowMGWTWindow.this.canClose ){
	            	HowMGWTWindow.this.hide();
	            	onHowMGWTClose();
            	}
            }  
        };
        
        HeaderControl help = new HeaderControl(HeaderControl.HELP, helpHandler); 

        HeaderControl close = new HeaderControl(HeaderControl.CLOSE, closeHandler);  
        
        labelCorpo = new Label(Configuracao.getNativeUnoCorpoGWT());
        labelCorpo.setAlign(Alignment.RIGHT);
        this.setHeaderControls(HeaderControls.HEADER_LABEL, labelCorpo ,help,close);
    		
		
	}
	
	public abstract String getHowMGWTTitle();
	public abstract String getHowMGWTPrograma();
	
	protected void onHowMGWTClose(){
		
	}

	/**
	 * @return the labelCorpo
	 */
	public Label getLabelCorpo() {
		return labelCorpo;
	}

	/**
	 * @param labelCorpo the labelCorpo to set
	 */
	public void setLabelCorpo(Label labelCorpo) {
		this.labelCorpo = labelCorpo;
	}

	/**
	 * @return the canClose
	 */
	public boolean isCanClose() {
		return canClose;
	}

	/**
	 * @param canClose the canClose to set
	 */
	public void setCanClose(boolean canClose) {
		this.canClose = canClose;
	}
}
