package com.br.client.panel.vd.vdw0004;

import com.br.client.configuracao.Configuracao;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.UI.HowMGWTIFrame;
import com.howmake.client.form.UI.HowMGWTWindow;

public class NotasFiscais extends HowMGWTWindow{

	private HowMGWTIFrame frame = new HowMGWTIFrame();
	 
	public NotasFiscais(){

		this.setWidth("640px");
		this.setHeight("120px");
		this.centerInPage();

		this.setIsModal(true);
		
		this.frame.getElement().getStyle().setOverflowY(Overflow.HIDDEN);
		this.addItem(frame);
		
  
		this.setDismissOnEscape(true);		
	}

	public void showConsulta(String codNotaFiscal){
		String url = Configuracao.getNativeUnoUrlServiceDonwload()+"/vdw0004.do?method=buscar&codNotaFiscal="+codNotaFiscal+" ";
		frame.setUrl(url);
		
		this.show();
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				setCanFocus(true);
				focus();
			}
		};
		timer.schedule(60);

	}

	@Override
	public String getHowMGWTPrograma() {
		return "VDW0004";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloVDW0004();
	}
	
}