package com.br.client.panel.ed.edw0003.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.UIPartner;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelLayoutManager extends VLayout implements UIPartner{
	
	
	private PainelLayoutControle painelLayoutControle = new PainelLayoutControle();
	
	public PainelLayoutManager(){
 
	}
	
	@Override
	public void start() {
		this.addMember(painelLayoutControle);
	}	
	
	public String getHowMGWTTitle(){
		return Tradutor.i18n.formTituloEDW0003();
	}

	public String getHowMGWTPrograma(){
		return "EDW0003";
	}

}