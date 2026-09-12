package com.howmake.client.form.UI;


public class HowMGWTWindowDocument extends HowMGWTWindow{

	private static HowMGWTWindowDocument windowDocument;
	
	private HowMGWTTextAreaItem field = new HowMGWTTextAreaItem();
	
	public HowMGWTWindowDocument(){
		this.field.getField().setShowTitle(false);
		this.centerInPage();
		this.setWidth("800px");
		this.setHeight("700px");
		this.field.setWidth100();
		this.field.setHeight100();
		this.addItem(this.field);
	}
	
	@Override
	public String getHowMGWTPrograma() {		
		return "LOG";
	}

	@Override
	public String getHowMGWTTitle() {
		return ""; // Tradutor.i18n.formTituloProgracao();
	}	

	/**
	 * @return the field
	 */
	public HowMGWTTextAreaItem getField() {
		return field;
	}	
	
	public static void showDocument(String text){
		if ( windowDocument == null ){
			windowDocument = new HowMGWTWindowDocument();
		}
		windowDocument.getField().setHowMValue(text);
		windowDocument.show();
	}
}