package com.br.client.panel.sv.svd0010.UI;

import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;

public abstract class PainelToolbar extends HLayout{
	
	public IButton actionNovo = new IButton("Novo");
	public IButton actionGravar = new IButton("Gravar");

	public PainelToolbar(){

		this.setHeight("26px");
		this.setWidth100();

		actionNovo.setIcon("actions/ico_novo.gif");
		actionNovo.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onNewRecord();
			}
		});
		
		actionGravar.setIcon("actions/save.png");
		actionGravar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onSave();
			}
		});
		
		this.addMember(actionNovo);
		this.addMember(actionGravar);
	}
	
	protected abstract void onNewRecord();
	protected abstract void onSave();

}
