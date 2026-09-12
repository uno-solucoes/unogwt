package com.howmake.client.form.UI;

import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ImageStyle;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;


public class HowMGWTWindowDocumentHTMLError extends HowMGWTWindow{

	private static HowMGWTWindowDocumentHTMLError windowDocument;
	
	private HLayout mainLayout = new HLayout();
	
	private HowMGWTLabel field = new HowMGWTLabel();

	private HowMGWTActionVerLog actionLog = new HowMGWTActionVerLog();
	
	
	private String detalhe;
	
	public HowMGWTWindowDocumentHTMLError(){
 
		VLayout mainVLayout = new VLayout();
		mainVLayout.setWidth100();
		mainVLayout.setHeight100();
		
		VLayout imgLayout = new VLayout();
		imgLayout.setWidth(64);
		imgLayout.setHeight100();
		
		
		Img img = new Img("message/stop.png");
		img.setImageType(ImageStyle.CENTER);
		imgLayout.addMember(img);
			

		imgLayout.setBackgroundColor("#Abcdfe");		
		
		mainLayout.addMember(imgLayout);
		
		this.setWidth("600");
		this.setHeight("200");		
				
		this.centerInPage();
		
		
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		this.field.setMargin(5);
		this.field.setBorder("1px solid "+HowMGWTUtilities.backgroundSeparadora);
		this.field.setWidth100();
		this.field.setHeight100();
		
		this.field.setAlign(Alignment.CENTER);
		

		mainLayout.addMember(this.field);

		mainVLayout.addMember(mainLayout);
		
		
		ToolStrip toolbar = new ToolStrip();
		toolbar.setAlign(Alignment.CENTER);
		toolbar.setWidth100();
		
		HowMGWTActionOK actionOK = new HowMGWTActionOK();
		toolbar.addMember(actionOK);
		actionOK.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {			
				windowDocument.hide();
			}
		});
		
		
		toolbar.addMember(actionLog);
		actionLog.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {			
				showLog();
			}
		});
		actionLog.setVisible(true);
		toolbar.redraw();		
		
		
		mainVLayout.addMember(toolbar);
		
		
		this.addItem(mainVLayout);
	}
	
	@Override
	public String getHowMGWTPrograma() {		
		return "Erro no Processamento";
	}

	@Override
	public String getHowMGWTTitle() {
		return "";// Tradutor.i18n.formTituloProgracao();
	}	

	/**
	 * @return the field
	 */
	public HowMGWTLabel getField() {
		return field;
	}	
	
	public static void showDocument(String text){
		if ( windowDocument == null ){
			windowDocument = new HowMGWTWindowDocumentHTMLError();
		}
		text = HowMGWTUtilities.replace(text, "java.lang.Exception: ","").trim();
		text = HowMGWTUtilities.replace(text, "java.lang.Exception:","").trim();
		windowDocument.getField().setHowMValue(text);
		windowDocument.setDetalhe("");
		windowDocument.show();
	}
	
	public static void showDocument(String text, String detail){
		if ( windowDocument == null ){
			windowDocument = new HowMGWTWindowDocumentHTMLError();
		}
		text = HowMGWTUtilities.replace(text, "java.lang.Exception:","").trim();
		windowDocument.getField().setHowMValue(text);
		windowDocument.setDetalhe(detail);
		
		windowDocument.show();
	}
	
	public void showLog(){
		HowMGWTWindowDocumentHTMLResume.showDocument(this.getDetalhe());
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
		if( !HowMGWTUtilities.isEmpty(detalhe) ){
			this.actionLog.setVisible(true);
		}
		else{
			this.actionLog.setVisible(false);
		}
	}
}