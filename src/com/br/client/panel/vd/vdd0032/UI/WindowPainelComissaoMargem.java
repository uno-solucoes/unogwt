package com.br.client.panel.vd.vdd0032.UI;

 
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.smartgwt.client.widgets.events.CloseClickHandler;
 

public class WindowPainelComissaoMargem extends HowMGWTWindow{

	private PainelComissaoMargem painelComissaoMargem = new PainelComissaoMargem();
	private JavaScriptObject parentObject;
	
	
	public WindowPainelComissaoMargem(){

		this.painelComissaoMargem.getPainelComissaoMargemControle().setParentWindow(this);

		this.setWidth("800");
		this.setHeight("500");
		this.centerInPage();
 		
		
		painelComissaoMargem.start();
	
		this.addItem(painelComissaoMargem);
		
	}
	
	@Override
	public void onHowMGWTClose(){
		if ( painelComissaoMargem.getPainelComissaoMargemControle().isChangeRecords() ){
			changeWindowPainelComissaoMargem(parentObject);
		}
	}

	public String getHowMGWTTitle(){
    	return  Tradutor.i18n.formTituloVDD0032();
	}
	
	public String getHowMGWTPrograma(){
		return "VDD0032";
	}
	
	
	public void showPainelComissaoMargem(JavaScriptObject parentObject){
		this.parentObject = parentObject;
		painelComissaoMargem.getPainelComissaoMargemControle().setChangeRecords(false);
		
		painelComissaoMargem.getPainelComissaoMargemControle().loadAll();
	}
 
	
	/**
	 * @return Retorna o endereço absoluto do contexto onde serão executados os serviços de donwload
	 * GWT.
	 */
	public static native void changeWindowPainelComissaoMargem( JavaScriptObject object) /*-{
	   object.changeWindowPainelComissaoMargem();	 
	}-*/;	
}
