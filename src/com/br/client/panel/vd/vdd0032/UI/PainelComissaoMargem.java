package com.br.client.panel.vd.vdd0032.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.UIPartner;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelComissaoMargem  extends VLayout implements UIPartner{

	PainelComissaoMargemControle painelComissaoMargemControle = new PainelComissaoMargemControle();
	
	
	public PainelComissaoMargem(){
		
	} 

	@Override
	public void start() {
		this.addMember( painelComissaoMargemControle );
	}

	public String getHowMGWTTitle(){
		return Tradutor.i18n.formTituloVDD0032();
	}

	public String getHowMGWTPrograma(){
		return "VDD0032";
	}

	/**
	 * @return the painelComissaoMargemControle
	 */
	public PainelComissaoMargemControle getPainelComissaoMargemControle() {
		return painelComissaoMargemControle;
	}
}
