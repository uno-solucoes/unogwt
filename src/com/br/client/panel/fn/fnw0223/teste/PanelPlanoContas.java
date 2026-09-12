package com.br.client.panel.fn.fnw0223.teste;

import com.br.client.model.sg.sgw0102.FormBean;
import com.google.gwt.core.client.Scheduler;
import com.howmake.client.form.UI.HowMGWTTreeGrid;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.grid.events.DataArrivedEvent;
import com.smartgwt.client.widgets.grid.events.DataArrivedHandler;

public class PanelPlanoContas extends HowMGWTTreeGrid{

	private HowMGWTProperty propertyConta		= new HowMGWTProperty("conta"		, "Conta");
	private HowMGWTProperty propertyContaPai 	= new HowMGWTProperty("contaPai"	, "Conta Pai");
	private HowMGWTProperty propertyNome		= new HowMGWTProperty("descricao"   , "Nome da Conta");
	
	public PanelPlanoContas(){
		
		this.setWidth100();
		this.setHeight100();
	
		setShowResizeBar(true);
		setResizeBarSize(1);
		
		this.setHowMKeyName("conta");
		this.setHowMParentKeyName("contaPai");
		this.setHowmFieldName("descricao");
		
		this.setHowMCustomIcon(true);		
		this.setHowMCustomContext("ged/types/");
		this.setHowmIconName("icon");		
		this.setHowMShowHeader(true);
		
		propertyConta.setWidthColumn(120);
		propertyConta.createHowMGWTListGridField();
		this.getHowMFields().add(propertyConta);
		// this.propertyConta.getListField().setHidden(true);
		
		propertyContaPai.setWidthColumn(120);
		propertyContaPai.createHowMGWTListGridField();
		this.getHowMFields().add(propertyContaPai);
		// this.propertyContaPai.getListField().setHidden(true);

		propertyNome.setWidthColumn(800);
		propertyNome.createHowMGWTListGridField();
		this.getHowMFields().add(propertyNome);		
		

		
		this.setHowMBeanName("entityPlanoConta");
		this.setHowMArrayObjectName("entityPlanoContas");

		this.setHowMplaceHolder("não existem pastas para mostrar...");

		this.setHowMShowAllRecords(true);

		this.setHowMSelectionAppearance(SelectionAppearance.ROW_STYLE);
		
		this.onHowMInitialize();
				
	}		
}
