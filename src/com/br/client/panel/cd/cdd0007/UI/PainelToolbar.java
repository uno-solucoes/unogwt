package com.br.client.panel.cd.cdd0007.UI;

import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;

public abstract class PainelToolbar extends HLayout{
	
 
	public IButton actionGravar = new IButton("Gravar");

	public PainelToolbar(){

		this.setHeight("26px");
		this.setWidth100();
 		
		actionGravar.setIcon("actions/save.png");
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
