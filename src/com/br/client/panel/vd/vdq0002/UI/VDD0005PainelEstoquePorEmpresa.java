package com.br.client.panel.vd.vdq0002.UI;

import com.br.client.configuracao.Configuracao;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.UI.HowMGWTIFrame;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.smartgwt.client.widgets.Window;

public class VDD0005PainelEstoquePorEmpresa  extends HowMGWTWindow{

	private HowMGWTIFrame frame = new HowMGWTIFrame();
	// private HTMLPane panel = new HTMLPane();
	public VDD0005PainelEstoquePorEmpresa(){

		this.setWidth("500px");
		this.setHeight("300px");
		this.centerInPage();

		this.setIsModal(true);
		this.addItem(frame);
		
		this.setDismissOnEscape(true);
	}

	public void showEstoque(String codProduto){
		String url = Configuracao.getNativeUnoUrlServiceDonwload()+"/vdd0005.do?method=prepListar&codProduto="+codProduto+" ";
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
		return "VDD005";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloVDD0005();
	}
	
}