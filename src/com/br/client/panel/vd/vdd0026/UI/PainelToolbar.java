package com.br.client.panel.vd.vdd0026.UI;

import com.br.client.panel.I18N.Tradutor;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;

public abstract class PainelToolbar extends HLayout{
	
 
	public IButton actionGravar = new IButton(Tradutor.i18n.formImprimirEtiquetas());

	public PainelToolbar(){
		this.setHeight("26px");
		this.setWidth100();

		actionGravar.setWidth("140px");
		actionGravar.setIcon("actions/print.png");
		actionGravar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onSave();
			}
		});
		
 
		this.addMember(actionGravar);
	}
 
	protected abstract void onSave();

}
