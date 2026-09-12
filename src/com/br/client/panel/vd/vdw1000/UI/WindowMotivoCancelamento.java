package com.br.client.panel.vd.vdw1000.UI;

import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.partner.HowMGWTConstants;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class WindowMotivoCancelamento extends HowMGWTWindow {

	private HLayout mainLayout = new HLayout();

	private Img img = new Img("window/messages/info.png");
	
	private VLayout formLayout = new VLayout();
	
	private HowMGWTProperty propertyMotivoCancelamento = new HowMGWTProperty("motivoCancelamento", "Informe o motivo do cancelamento");
	
	private IButton actionOK = new IButton("Enviar para Cancelamento");
	private IButton actionFechar = new IButton("Fechar");
	
	public WindowMotivoCancelamento(){

		this.setWidth(460);
		this.setHeight(120);

		this.setShowModalMask(true);
		this.setModalMaskOpacity(HowMGWTConstants.WINDOW_MODAL_MASK_OPACITY);
		this.setIsModal(true);

		this.centerInPage();

		mainLayout.setWidth100();
		mainLayout.setHeight100();

		VLayout imgVLayout = new VLayout();
		imgVLayout.setWidth(48);
		imgVLayout.setHeight100();
		imgVLayout.setStyleName("directSalesHeader");

		img.setWidth(48);
		img.setHeight(48);		
		imgVLayout.addMember(img);

		mainLayout.addMember(imgVLayout);

		
		propertyMotivoCancelamento.setBound(110, 270);
		
		propertyMotivoCancelamento.createHowMGWTFormFieldAreaItem();
		propertyMotivoCancelamento.getCanvas().setHeight(48);		

		formLayout.setWidth100();
		formLayout.setHeight100();
		formLayout.addMember(propertyMotivoCancelamento.getCanvas());

		actionOK.setWidth(140);
		actionFechar.setWidth(70);
		
		HLayout tools = new HLayout();
		tools.setWidth100();
		tools.setHeight(32);
		tools.setAlign(Alignment.CENTER);
		
		tools.addMember(actionOK);
		tools.addMember(actionFechar);
		
		this.actionOK.addClickHandler(new ClickHandler(){
			
			public void onClick(ClickEvent event) {

				if( HowMGWTUtilities.isEmpty( propertyMotivoCancelamento.getHowmFormValue() ) ){
					SC.say("Informe o motivo do cancelamento para continuar...");
					return;
				}
				
				if( HowMGWTUtilities.getString(propertyMotivoCancelamento.getHowmFormValue()).length() < 15 ){
					SC.say("Informe no minimo 15 caracteres para o motivo do cancelamento...");
					return;
				}

				onConfirmar(propertyMotivoCancelamento.getHowmFormValueToString());
				hide();
			}
		});

		this.actionFechar.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		
		formLayout.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(10, "" ));
		formLayout.addMember(tools);
		
		mainLayout.addMember(formLayout);
		this.addItem(mainLayout);

	}
	
	
	@Override
	public String getHowMGWTTitle() {
		return "Enviar para Cancelamento";
	}

	@Override
	public String getHowMGWTPrograma() {
		return "VDW1000C";
	}

	public void onConfirmar(String motivo){
		
	}
		
}