package com.br.client.panel.vd.vdw0035.UI;

import com.br.client.configuracao.Configuracao;
import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class FiltroConsulta  extends VLayout{ 

	private HowMGWTProperty propertyPeriodoInicial = new HowMGWTProperty("dataInicio", Tradutor.i18n.periodoInicial());
	private HowMGWTProperty propertyPeriodoFinal   = new HowMGWTProperty("dataFim"   , Tradutor.i18n.periodoFinal());
  
    private IButton actionBuscar   			= new IButton(Tradutor.i18n.buscar());  
   //  private IButton actionExportarContador  = new IButton(Tradutor.i18n.exportarNFSEContador());  

    
    public FiltroConsulta(){
    	initUI();
    }
    
    public void initUI(){
 
    	this.setWidth100();
    	this.setAutoHeight();
    	
    	actionBuscar.setIcon("actions/search.png");
    	
    	HLayout layoutDatas = new HLayout();
    	layoutDatas.setWidth100();


    	propertyPeriodoInicial.setBound(100, 150);
    	propertyPeriodoInicial.createHowMGWTFormDateItem();
    	layoutDatas.addMember(propertyPeriodoInicial.getCanvas());

    	
    	propertyPeriodoFinal.setBound(100, 150);
    	propertyPeriodoFinal.createHowMGWTFormDateItem();    	
    	layoutDatas.addMember(propertyPeriodoFinal.getCanvas());

    	
    	actionBuscar.setWidth("100px");


    	layoutDatas.addMember(actionBuscar);

    	layoutDatas.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(10,""));

//    	actionExportarContador.setWidth(130);
//    	layoutDatas.addMember(actionExportarContador);

    	this.addMember(layoutDatas);

       	HLayout layoutNaoEnviados = new HLayout();
    	layoutNaoEnviados.setWidth100();
    	
    	
    	HTMLPane paneHelp = new HTMLPane();
    	paneHelp.setWidth100();
    	paneHelp.setHeight(30);
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setBorder(Tradutor.i18n.msgBorder());
     	paneHelp.setContents(Tradutor.i18n.msgLookupHelp());    	
    	this.addMember(paneHelp);
    	

    	actionBuscar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onBuscar(Configuracao.getCodEmpresa(), propertyPeriodoInicial.getHowmFormValueToString(),  propertyPeriodoFinal.getHowmFormValueToString());
			}
		});
    	
    	
//    	actionExportarContador.addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				onExportarNFSEContador(Configuracao.getCodEmpresa(), propertyPeriodoInicial.getHowmFormValueToString(), propertyPeriodoFinal.getHowmFormValueToString());
//			}
//		});
    	
    }

	/**
	 * @return the actionBuscar
	 */
	public IButton getActionBuscar() {
		return actionBuscar;
	}

	/**
	 * @param actionBuscar the actionBuscar to set
	 */
	public void setActionBuscar(IButton actionBuscar) {
		this.actionBuscar = actionBuscar;
	}
	

	public void onExportarNFSEContador(String codEmpresa, String dtInicio, String dtFim){}
	
	
	
	public void onBuscar(String codEmpresa, String dtInicio, String dtFim){}
	
}

