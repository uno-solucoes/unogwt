package com.br.client.panel.ed.edw0002.UI;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTWindow;

public class WindowMonitorEDIControle  extends HowMGWTWindow{

	private PainelMonitorEDIControle painelMonitorEDIControle = new PainelMonitorEDIControle();
	
	
	public WindowMonitorEDIControle(){
		
		this.setWidth("80%");
		this.setHeight("80%");
		
		this.centerInPage();		
		this.setIsModal(true);
		
		painelMonitorEDIControle.setWidth100();
		painelMonitorEDIControle.setHeight100();
		this.addItem(painelMonitorEDIControle);
	}
	
	public String getHowMGWTTitle(){
		return  Tradutor.i18n.formTituloEDW0002();
	}
	
	public String getHowMGWTPrograma(){
		return "EDW0002";
	}

	public void showMonitor( String codPedido , String codProduto ){
		this.show();
		painelMonitorEDIControle.executeQuery(codPedido);
	}

}
