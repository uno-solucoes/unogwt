 package com.br.client.panel.vd.vdw0028.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.UI.UCFieldLookupBuscaCliente;
import com.br.client.panel.business.UI.UCFieldLookupBuscaColaborador;
import com.howmake.client.form.UI.HowMGWTDateItem;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class FiltroConsulta  extends VLayout{ 
 
    public UCFieldLookupBuscaCliente fieldLookupBuscaCliente = new UCFieldLookupBuscaCliente();
    public UCFieldLookupBuscaColaborador fieldBuscarColaborador 	 = new UCFieldLookupBuscaColaborador();
    
    public HowMGWTDateItem fieldDataInicial = new HowMGWTDateItem("DataInicio", Tradutor.i18n.formDataInicio());
	public HowMGWTDateItem fieldDataFim 	 = new HowMGWTDateItem("DataFim", Tradutor.i18n.formDataFim());
 	
    private HTMLPane paneHelp           						= new HTMLPane();
    
    public FiltroConsulta(){
    	initUI();
    	fieldBuscarColaborador.getLookupBuscaColaborador().getpTpColaborador().setValue(null);
    }
    
    public void initUI(){
 
    	fieldLookupBuscaCliente.setWidth100();
    	fieldBuscarColaborador.setWidth100();
    	
    	fieldDataInicial.setWidth("280PX");
    	fieldDataFim.setWidth("280PX");
    	
    	HLayout datas = new HLayout();
    	datas.setWidth100();
    	datas.setHeight("22px");

    	// -------------------------------------------------------------------
    	
    	// Configura datas - inicio e Fim.
    	datas.addMember(fieldDataInicial);
    	datas.addMember(fieldDataFim);
    	this.addMember(datas);

    	
    	// Configura lookup buscar colaborador;
    	this.addMember(fieldBuscarColaborador);
    	
    	// Configura lookup buscar cliente.
    	this.addMember(fieldLookupBuscaCliente);

    	// -------------------------------------------------------------------

    	this.setHeight("65px");

    	paneHelp.setBorder(Tradutor.i18n.msgBorder());
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setContents(Tradutor.i18n.msgLookupHelp());
     	
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
 
}
