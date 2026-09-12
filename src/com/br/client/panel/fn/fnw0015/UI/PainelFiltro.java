package com.br.client.panel.fn.fnw0015.UI;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTDateItem;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelFiltro extends VLayout{

	public 	HowMGWTDateItem fieldData 	 = new HowMGWTDateItem("data" 		, Tradutor.i18n.formData());
	private HLayout hLayout = new HLayout();

	public PainelFiltro(){

		hLayout.setHeight("30px");
		hLayout.setWidth100();
		
		hLayout.addMember(fieldData);

		HLayout sep = new HLayout();
		sep.setWidth("50px");
		hLayout.addMember(sep);
		
		IButton actionBuscar   = new IButton(Tradutor.i18n.buscar());
		actionBuscar.setWidth(100);
		actionBuscar.setIcon("actions/search.png"); 
	    actionBuscar.addClickHandler(new ClickHandler() { 
            public void onClick(ClickEvent event) {            
            	onBuscar();
            }
        });		
		
	    hLayout.addMember(actionBuscar);

	    IButton actionImprimir = new IButton(Tradutor.i18n.formImprimir());
    	actionImprimir.setIcon("actions/print.png");
		actionImprimir.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onShowPrint();
			}
		});		
		hLayout.addMember(actionImprimir);
	    
	    
	    
		this.addMember(hLayout);
		HTMLPane paneHelp           			= new HTMLPane();
    	paneHelp.setBorder(Tradutor.i18n.msgBorder());
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setContents(Tradutor.i18n.msgLookupHelp());
    	paneHelp.setWidth100();
    	paneHelp.setHeight("36px");
    	    	    	
    	this.addMember(paneHelp);
	
    	HLayout hLine = new HLayout();
    	hLine.setWidth100();
    	hLine.setHeight("1px");
    	hLine.setBackgroundColor("blue");
    	this.addMember(hLine);
    	
    	this.setHeight("66px");
	}
	
	public void onBuscar(){}
	public void onShowPrint(){};
}
