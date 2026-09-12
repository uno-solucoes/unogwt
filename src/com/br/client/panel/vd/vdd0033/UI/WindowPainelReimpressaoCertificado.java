package com.br.client.panel.vd.vdd0033.UI;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTWindow;

public class WindowPainelReimpressaoCertificado extends HowMGWTWindow{

	private PainelReimpressaoCertificado painelReimpressaoCertificado = new PainelReimpressaoCertificado();
	
	public WindowPainelReimpressaoCertificado(){
		
		this.addItem(painelReimpressaoCertificado);
		
		this.setWidth("600");
		this.setHeight("500");
		this.centerInPage();
		this.setIsModal(true);

	}
	
	@Override
	public void onHowMGWTClose(){
		
	}
	
	public String getHowMGWTTitle(){
    	return  Tradutor.i18n.formTituloVDD0033();
	}
	
	public String getHowMGWTPrograma(){
		return "VDD0033";
	}
	
	public void show(String codNotaFiscal){
	
		this.show();
	
		painelReimpressaoCertificado.setCodNotaFiscal(codNotaFiscal);
				
	}
	
}
