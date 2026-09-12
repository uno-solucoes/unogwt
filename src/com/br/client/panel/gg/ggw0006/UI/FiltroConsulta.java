 package com.br.client.panel.gg.ggw0006.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.UI.UCFieldLookupBuscaCliente;
import com.br.client.panel.business.UI.UCFieldLookupBuscaPedido;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

public class FiltroConsulta  extends VLayout{ 
 
    
    private UCFieldLookupBuscaPedido fieldCodigoPedido 		= new UCFieldLookupBuscaPedido();  
 
    private HTMLPane paneHelp           						= new HTMLPane();
    
    public FiltroConsulta(){
    	initUI();
    }
    
    public void initUI(){
 
    	this.setHeight("65px");
    	
    	paneHelp.setBorder(Tradutor.i18n.msgBorder());
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setContents(Tradutor.i18n.msgLookupHelp());
 
    	
    	fieldCodigoPedido.setWidth100();
    	this.addMember(fieldCodigoPedido);
    
 
    	
    	paneHelp.setWidth100();
    	this.addMember(paneHelp);
    }


	/**
	 * @return the paneHelp
	 */
	public HTMLPane getPaneHelp() {
		return paneHelp;
	}

	/**
	 * @param paneHelp the paneHelp to set
	 */
	public void setPaneHelp(HTMLPane paneHelp) {
		this.paneHelp = paneHelp;
	}

	/**
	 * @return the fieldCodigoPedido
	 */
	public UCFieldLookupBuscaPedido getFieldCodigoPedido() {
		return fieldCodigoPedido;
	}

	/**
	 * @param fieldCodigoPedido the fieldCodigoPedido to set
	 */
	public void setFieldCodigoPedido(UCFieldLookupBuscaPedido fieldCodigoPedido) {
		this.fieldCodigoPedido = fieldCodigoPedido;
	}
 
}
