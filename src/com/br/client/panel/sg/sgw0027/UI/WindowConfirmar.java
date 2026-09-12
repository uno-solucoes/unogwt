package com.br.client.panel.sg.sgw0027.UI;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.partner.HowMGWTConstants;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class WindowConfirmar extends HowMGWTWindow{

	private HLayout hLayout = new HLayout();
	private Label message = new Label();
	private HowMGWTProperty propertyMotivo;
	
	private IButton actionConfirmar = new IButton(Tradutor.i18n.formOK());
	private IButton actionCancel    = new IButton(Tradutor.i18n.formCancelar());
	
	public WindowConfirmar(String inputLabel){
		
		this.setIsModal(true);
		this.setShowModalMask(true);
		this.setModalMaskOpacity(HowMGWTConstants.WINDOW_MODAL_MASK_OPACITY);
		
		propertyMotivo = new HowMGWTProperty("motivo", inputLabel);
		propertyMotivo.setBound(200, 200);
		propertyMotivo.createHowMGWTFormFieldTextItem();
		
		hLayout.setWidth100();
		hLayout.setHeight100();
		
		hLayout.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(10, ""));
		Img imgConfirmar = new Img();
		imgConfirmar.setSrc("message/confirm.png");
		imgConfirmar.setWidth(32);
		imgConfirmar.setHeight(32);
		hLayout.addMember(imgConfirmar);
		hLayout.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(10, "" ));

		VLayout vLayout = new VLayout();
		vLayout.setHeight100();
		vLayout.setWidth100();

		message.setWidth100();
		message.setHeight100();
		vLayout.addMember(message);
	
		vLayout.addMember(propertyMotivo.getCanvas());

		HLayout hTools = new HLayout();
		hTools.setWidth100();
		hTools.setHeight(30);
		hTools.setAlign(Alignment.CENTER);
		
		actionConfirmar.setWidth(70);
		actionCancel.setWidth(70);
		hTools.addMember(actionConfirmar);
		hTools.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(5,""));
		hTools.addMember(actionCancel);

		actionCancel.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				WindowConfirmar.this.hide();
			}
		});
		vLayout.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(5,""));
		vLayout.addMember(hTools);
		hLayout.addMember(vLayout);
		
		this.addItem(hLayout);
	}

	@Override
	public String getHowMGWTPrograma() {
		return "";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formConfirmar();
	}
	
	public void confirme(int width, int height, String msg){
		this.setWidth(width);
		this.setHeight(height);
		this.centerInPage();
		this.message.setContents(msg);
		this.show();
	}

	/**
	 * @return the actionConfirmar
	 */
	public IButton getActionConfirmar() {
		return actionConfirmar;
	}
	
	public String getMotivo(){
		return this.propertyMotivo.getHowMValue();
	}
}
