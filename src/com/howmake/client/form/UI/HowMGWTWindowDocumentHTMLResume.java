package com.howmake.client.form.UI;

import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


public class HowMGWTWindowDocumentHTMLResume extends HowMGWTWindow{

	private static HowMGWTWindowDocumentHTMLResume windowDocument;
	
	private HLayout mainLayout = new HLayout();
	
	private HowMGWTLabel field = new HowMGWTLabel();
	
	public HowMGWTWindowDocumentHTMLResume(){
 
		VLayout imgLayout = new VLayout();
		imgLayout.setWidth(128);
		imgLayout.setHeight100();
		
		
		Img img = new Img("nfe/analise/analise_result.png");
		imgLayout.addMember(img);
		
		imgLayout.setBackgroundColor("#Abcdfe");
		
		
		mainLayout.addMember(imgLayout);
		
		this.setWidth("800");
		this.setHeight("500");
				
		this.centerInPage();
		
		
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		this.field.setMargin(10);
		this.field.setWidth100();
		this.field.setHeight100();
		
		mainLayout.addMember(this.field);
		
		this.addItem(mainLayout);
	}
	
	@Override
	public String getHowMGWTPrograma() {		
		return "Resumo Processamento";
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
			windowDocument = new HowMGWTWindowDocumentHTMLResume();
		}
		windowDocument.getField().setHowMValue(text);
		windowDocument.show();
	}
}