package com.howmake.client.form.UI;

import com.br.client.panel.I18N.Tradutor;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class HowMGWTPanelInstrucaoFiltro extends VLayout{
   
    public HowMGWTPanelInstrucaoFiltro(){
    	this.setWidth100();

    	HTMLPane help = new HTMLPane();
    	this.setHeight(33);

    	HLayout borderTop = new HLayout();
    	borderTop.setWidth100();
    	borderTop.setHeight(6);
    	// borderTop.setBackgroundColor("blue");
    	
    	help.setBorder(Tradutor.i18n.msgBorder());
    	help.setBackgroundColor(Tradutor.i18n.msgColor());
    	help.setContents(Tradutor.i18n.msgLookupHelp());
    	help.setWidth100();
    	help.setHeight(32);
    	
    	HLayout border = new HLayout();
    	border.setWidth100();
    	border.setHeight(1);
    	border.setBackgroundColor("blue");
    	
    	this.addMember(borderTop);
    	this.addMember(help);
    	this.addMember(border);
    }
}
