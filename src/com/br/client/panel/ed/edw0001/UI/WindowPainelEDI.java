package com.br.client.panel.ed.edw0001.UI;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTWindow;

public class WindowPainelEDI extends HowMGWTWindow{

	private PainelEDI painelEDI = new PainelEDI();
	
	public WindowPainelEDI(){

		this.setWidth("90%");
		this.setHeight("90%");
		this.centerInPage();

		painelEDI.start();
	
		this.addItem(painelEDI);
	}
	
	public String getHowMGWTTitle(){
    	return  Tradutor.i18n.formTituloEDW0001();
	}
	
	public String getHowMGWTPrograma(){
		return "EDW0001";
	}
}
