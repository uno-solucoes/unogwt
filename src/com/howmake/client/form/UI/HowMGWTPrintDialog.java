package com.howmake.client.form.UI;

import java.util.LinkedHashMap;

import com.google.gwt.user.client.Timer;
import com.howmake.client.form.partner.HowMGWTPDF;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class HowMGWTPrintDialog extends HowMGWTWindowBase{
	
	HowMGWTProperty propertyPageSize 	= new HowMGWTProperty("pageSize"		, "Tamanho do Papel");
	HowMGWTProperty propertyOrientacao 	= new HowMGWTProperty("Orientacao"		, "Orienta&ccedil;&atilde;o");
	
//	HowMGWTProperty propertyMargemLef   = new HowMGWTProperty("margemEsquerda"	, "Margem Esquerda");
//	HowMGWTProperty propertyMargemTop   = new HowMGWTProperty("margemTopo"		, "Margem Esquerda");
//	HowMGWTProperty propertyMargemRigth = new HowMGWTProperty("margemDireita"	, "Margem Direita");
//	HowMGWTProperty propertyMargemBottom= new HowMGWTProperty("margemRodape"	, "Margem Rodape");

	public HowMGWTPrintDialog(){

		VLayout mainLayout = new VLayout(5);
		VLayout bodyLayout = new VLayout();
		bodyLayout.setWidth100();
		bodyLayout.setHeight100();
		
		HLayout toolbar = new HLayout(10);		
		
		propertyPageSize.setBound(130, 200);
		propertyPageSize.createHowMFieldSelectItem();
		bodyLayout.addMember(propertyPageSize.getCanvas());
		
		LinkedHashMap< String , String > mapPageSize = new LinkedHashMap<String, String>();
		mapPageSize.put(HowMGWTPDF.PAPEL_AU, "Auto Ajuste");
		mapPageSize.put(HowMGWTPDF.PAPEL_A0, "A0");
		mapPageSize.put(HowMGWTPDF.PAPEL_A1, "A1");
		mapPageSize.put(HowMGWTPDF.PAPEL_A2, "A2");
		mapPageSize.put(HowMGWTPDF.PAPEL_A3, "A3");
		mapPageSize.put(HowMGWTPDF.PAPEL_A4, "A4");		
		propertyPageSize.getHowMFieldSelectItemEditor().getField().setValueMap(mapPageSize);
		propertyPageSize.setHowmFormValue(HowMGWTPDF.PAPEL_AU);
		
		propertyOrientacao.setBound(130, 200);
		propertyOrientacao.createHowMFieldSelectItem();
		bodyLayout.addMember(propertyOrientacao.getCanvas());
		
		LinkedHashMap< String , String > mapOrientacao = new LinkedHashMap<String, String>();
		mapOrientacao.put(HowMGWTPDF.ORIENTACAO_FOTO, "Retrato");
		mapOrientacao.put(HowMGWTPDF.ORIENTACAO_PAIGAGEM, "Paisagem");
		propertyOrientacao.getHowMFieldSelectItemEditor().getField().setValueMap(mapOrientacao);

		propertyOrientacao.setHowmFormValue(HowMGWTPDF.ORIENTACAO_PAIGAGEM);

		toolbar.setWidth100();
		toolbar.setHeight(34);
		toolbar.setAlign(Alignment.CENTER);


		HowMGWTActionOK actionOK = new HowMGWTActionOK();
		actionOK.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onPrint();
			}
		});
		toolbar.addMember(actionOK);
		
		HowMGWTActionCancel actionCancel = new HowMGWTActionCancel();
		actionCancel.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				onClose();
			}
		});
		toolbar.addMember(actionCancel);
		
		
		mainLayout.addMember(bodyLayout);
		mainLayout.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(1, HowMGWTUtilities.backgroundSeparadora ));
		mainLayout.addMember(toolbar);
		
		this.addItem(mainLayout);
		
		this.setWidth("350px");
		this.setHeight("130px");
		this.setShowHeader(true);	

        this.setIsModal(true);
		this.setDismissOnOutsideClick(true);
		this.setDismissOnEscape(true);     
		
		this.setDismissOnEscape(true);

		this.addCloseClickHandler(new CloseClickHandler() {
			
			@Override
			public void onCloseClick(CloseClickEvent event) {
				onClose();		
			}
		}); 

		this.setTitle("Exportar");
		
		this.centerInPage();
		
	}
 	
	protected void onHowMInit(){}
	
	
	@Override
	public boolean isVisible() {
//		if ( this.load ){
//			return false;
//		}
		return super.isVisible();
	}
 
	@Override
	public void show() {
		super.show();
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				setCanFocus(true);
				focus();
				propertyPageSize.setFocus();
			}
		};
		timer.schedule(60);
	}


	public HowMGWTProperty getPropertyPageSize() {
		return propertyPageSize;
	}


	public void setPropertyPageSize(HowMGWTProperty propertyPageSize) {
		this.propertyPageSize = propertyPageSize;
	}


	public HowMGWTProperty getPropertyOrientacao() {
		return propertyOrientacao;
	}


	public void setPropertyOrientacao(HowMGWTProperty propertyOrientacao) {
		this.propertyOrientacao = propertyOrientacao;
	}
	
	
	protected void onPrint(){}
	
	protected void onClose(){
		this.hide();
	}
}