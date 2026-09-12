package com.br.client.panel.sg.sgw0102.UI;

import com.br.client.model.sg.sgw0102.FormBean;
import com.google.gwt.core.client.Scheduler;
import com.howmake.client.form.UI.HowMGWTTreeGrid;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.grid.events.DataArrivedEvent;
import com.smartgwt.client.widgets.grid.events.DataArrivedHandler;

public class PanelFileNavegator extends HowMGWTTreeGrid{

	private HowMGWTProperty propertyCodDiretorio		= new HowMGWTProperty("key"			, "key");
	private HowMGWTProperty propertyCodDiretorioPai 	= new HowMGWTProperty("parentKey"	, "Parent Key");
	private HowMGWTProperty propertyDescricao			= new HowMGWTProperty("descricao"   , "Nome Arquivo");

	
	public PanelFileNavegator(){
		
		this.setWidth100();
		this.setHeight100();
	
		setShowResizeBar(true);
		setResizeBarSize(1);
		
		this.setHowMKeyName("key");
		this.setHowMParentKeyName("parentKey");
		this.setHowmFieldName("name");
		
		this.setHowMCustomIcon(true);		
		this.setHowMCustomContext("ged/types/");
		this.setHowmIconName("icon");
		// this.setHowMIconSize(32);
		
		propertyDescricao.createHowMGWTListGridField();
		this.getHowMFields().add(propertyDescricao);		
		
		propertyCodDiretorio.setWidthColumn(60);
		propertyCodDiretorio.createHowMGWTListGridField();
		this.getHowMFields().add(propertyCodDiretorio);
		this.propertyCodDiretorio.getListField().setHidden(true);
		

		propertyCodDiretorioPai.setWidthColumn(60);
		propertyCodDiretorioPai.createHowMGWTListGridField();
		this.getHowMFields().add(propertyCodDiretorioPai);
		this.propertyCodDiretorioPai.getListField().setHidden(true);

		this.setHowMBeanName("entityFileNode");
		this.setHowMArrayObjectName("entityFileNodes");
		
		this.setHowMplaceHolder("não existem pastas para mostrar...");

		this.setHowMShowAllRecords(true);

		this.setHowMSelectionAppearance(SelectionAppearance.ROW_STYLE);
		
		this.onHowMInitialize();
				
	}
		
	public void showDirectory(FormBean formBean){
		this.executeHowMAction(formBean);
	}
	
	@Override
	public void onHowMFinishLoadTreeGrid() {	
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
			
			@Override
			public void execute() {
				getHowMTreeGrid().getData().openAll(); 
			}
		});		
	}

}
