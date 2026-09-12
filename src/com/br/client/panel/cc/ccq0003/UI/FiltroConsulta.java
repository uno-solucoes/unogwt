package com.br.client.panel.cc.ccq0003.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.UI.UCFieldSituacaoColaborador;
import com.howmake.client.form.UI.HowMGWTTextItem;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

public class FiltroConsulta  extends VLayout{ 
 
    
    private HowMGWTTextItem fieldCodFornecedor	 	= new HowMGWTTextItem("codigoFornecedor", 	Tradutor.i18n.formCodigo()    );  
    private HowMGWTTextItem fieldNomeFornecedor   	= new HowMGWTTextItem("nomeFornecedor"	,	Tradutor.i18n.formNomeFornecedor()); 
    
    private HTMLPane paneHelp           			= new HTMLPane();
 
    public FiltroConsulta(){
    	initUI();
    }
    
    public void initUI(){
 
    	paneHelp.setBorder(Tradutor.i18n.msgBorder());
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setContents(Tradutor.i18n.msgLookupHelp());
 
    	fieldCodFornecedor.setWidth100();
    	this.addMember(fieldCodFornecedor);
    	
    	fieldNomeFornecedor.setWidth100();
    	this.addMember(fieldNomeFornecedor);
 
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

	
	
	public void clearFilters(){
	    fieldCodFornecedor.setHowMValue("");  
	    fieldNomeFornecedor.setHowMValue(""); 
	}

	/**
	 * @return the fieldCodFornecedor
	 */
	public HowMGWTTextItem getFieldCodFornecedor() {
		return fieldCodFornecedor;
	}

	/**
	 * @return the fieldNomeFornecedor
	 */
	public HowMGWTTextItem getFieldNomeFornecedor() {
		return fieldNomeFornecedor;
	}
}
