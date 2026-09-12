package com.br.client.panel.vd.vdw0800.UI;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTCheckboxItem;
import com.howmake.client.form.UI.HowMGWTTextItem;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelFiltro extends VLayout{

	public HowMGWTTextItem fieldCodigoIBGE 	= new HowMGWTTextItem("codigoIBGE", 		 Tradutor.i18n.formCodigoIBGE());
	public HowMGWTTextItem fieldNomeMunicipio	= new HowMGWTTextItem("nomeMunicipio", 		 Tradutor.i18n.formNomeMunicipio());
	public HowMGWTTextItem fieldPadrao 		= new HowMGWTTextItem("padrao", 			 Tradutor.i18n.formPadrao());
	public HowMGWTCheckboxItem fieldForcaPadrao= new HowMGWTCheckboxItem("fieldForcaPadrao",Tradutor.i18n.formMunicipiosComPadrao()); 
	
	IButton actionBuscar 				= new IButton(Tradutor.i18n.buscar());
	
	public PainelFiltro(){    
		
		fieldCodigoIBGE.setTitleWidth(80);
		fieldCodigoIBGE.getField().setWidth(80);
		fieldCodigoIBGE.setWidth(160);
		
		fieldPadrao.setTitleWidth(60);
		fieldPadrao.getField().setWidth(120);
		fieldPadrao.setWidth(180);
		
		fieldNomeMunicipio.setTitleWidth(100);
		fieldNomeMunicipio.getField().setWidth(200);
		fieldNomeMunicipio.setWidth(300);
		
		fieldForcaPadrao.getField().setValue(true);
		fieldForcaPadrao.setAlign(Alignment.LEFT);
		fieldForcaPadrao.setTitleWidth(160);
		fieldForcaPadrao.getField().setWidth(20);
		fieldForcaPadrao.setWidth(180);
		
		this.setWidth100();
		this.setHeight("60px");
		
		HLayout hcidade = new HLayout();
		hcidade.setWidth100();
		hcidade.setHeight("24px");
		
		hcidade.addMember(fieldCodigoIBGE);
		hcidade.addMember(fieldNomeMunicipio);
		hcidade.addMember(fieldPadrao);
		hcidade.addMember(fieldForcaPadrao);
		
		HLayout hSep = new HLayout();
		hSep.setWidth(20);
		hcidade.addMember(hSep);
		hcidade.addMember(actionBuscar);
		
		
		actionBuscar.setWidth(100);
		actionBuscar.setIcon("actions/search.png"); 
	    actionBuscar.addClickHandler(new ClickHandler() { 
            public void onClick(ClickEvent event) {            
            	onBuscar();
            }
        });				
		
		this.addMember(hcidade);
		
		HTMLPane paneHelp           			= new HTMLPane();
    	paneHelp.setBorder(Tradutor.i18n.msgBorder());
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setContents(Tradutor.i18n.msgLookupHelp());
    	paneHelp.setWidth100();
    	// paneHelp.setBorder("1px solid blue");
    	paneHelp.setHeight("36px");
    	    	    	
    	HLayout line = new HLayout();
    	line.setWidth100();
    	line.setHeight(1);
    	line.setBackgroundColor("blue");
    	this.addMember(line);
    	
    	this.addMember(paneHelp);		
	}


	public void onBuscar(){
		
	}
}
