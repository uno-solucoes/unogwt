package com.howmake.client.form.UI;


public class HowMGWTWindowDocumentHTML extends HowMGWTWindow{

	private static HowMGWTWindowDocumentHTML windowDocument;
	
	private HowMGWTLabel field = new HowMGWTLabel();
	
	public HowMGWTWindowDocumentHTML(){
 
		this.setWidth("800");
		this.setHeight("500");
		this.centerInPage();
		this.field.setWidth100();
		this.field.setHeight100();
		this.addItem(this.field);
	}
	
	@Override
	public String getHowMGWTPrograma() {		
		return "ERRO";
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
			windowDocument = new HowMGWTWindowDocumentHTML();
		}
		windowDocument.getField().setHowMValue(text);
		windowDocument.show();
	}
}