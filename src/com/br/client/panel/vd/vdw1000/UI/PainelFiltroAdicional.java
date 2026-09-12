package com.br.client.panel.vd.vdw1000.UI;

import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;

public class PainelFiltroAdicional extends HLayout{

	PainelFiltroAdicional( PanelRibbonBarRPS panelRibbonBarRPS){

		this.setWidth100();
		this.setHeight(24);
		
		this.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(6, ""));
		
		Label lblLocalizar = new Label("<strong>Localizar por : </strong>");
		lblLocalizar.setHeight(24);
		lblLocalizar.setValign(VerticalAlignment.CENTER);
		this.addMember(lblLocalizar);
		
//		panelRibbonBarRPS.getPropertyCodPlano().setBound(50,60);
//		panelRibbonBarRPS.getPropertyCodPlano().createHowMFieldTextItem();
//		this.addMember(panelRibbonBarRPS.getPropertyCodPlano().getCanvas());

		panelRibbonBarRPS.getPropertyCodRPS().setBound(50,60);
		panelRibbonBarRPS.getPropertyCodRPS().createHowMFieldTextItem();
		this.addMember(panelRibbonBarRPS.getPropertyCodRPS().getCanvas());

		panelRibbonBarRPS.getPropertyCodPedido().setBound(60,60);
		panelRibbonBarRPS.getPropertyCodPedido().createHowMFieldTextItem();
		this.addMember(panelRibbonBarRPS.getPropertyCodPedido().getCanvas());
		
		panelRibbonBarRPS.getPropertyCodPlano().setBound(50,60);
		panelRibbonBarRPS.getPropertyCodPlano().createHowMFieldTextItem();
		this.addMember(panelRibbonBarRPS.getPropertyCodPlano().getCanvas());
		
		panelRibbonBarRPS.getPropertyCodNotaFiscal().setBound(50,60);
		panelRibbonBarRPS.getPropertyCodNotaFiscal().createHowMFieldTextItem();
		this.addMember(panelRibbonBarRPS.getPropertyCodNotaFiscal().getCanvas());
		
//		panelRibbonBarRPS.getPropertyNomeCliente().setBound(50,180);
//		panelRibbonBarRPS.getPropertyNomeCliente().createHowMFieldTextItem();
//		this.addMember(panelRibbonBarRPS.getPropertyNomeCliente().getCanvas());

	}	
}