package com.br.client.panel.vd.vdq0002.UI;

import java.util.TreeMap;

import com.br.client.configuracao.Configuracao;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Frame;
import com.howmake.client.form.UI.HowMGWTIFrame;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.ibm.icu.text.SelectFormat;
import com.smartgwt.client.data.XJSONDataSource;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.Window;

public class VDD0004PainelSimulacaoEstoque extends HowMGWTWindow{

	private HowMGWTIFrame frame = new HowMGWTIFrame();
	// private HTMLPane panel = new HTMLPane();
	public VDD0004PainelSimulacaoEstoque(){

		this.setWidth("740px");
		this.setHeight("620px");
		this.centerInPage();

		this.setIsModal(true);
		this.addItem(frame);
		
  
		this.setDismissOnEscape(true);		
	}

	public void showSimulacao(String codProduto){
		String url = Configuracao.getNativeUnoUrlServiceDonwload()+"/vdd0004.do?method=prepListar&codProduto="+codProduto+" ";
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
		return "VDD0004";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloVDD0004();
	}
	
	
}