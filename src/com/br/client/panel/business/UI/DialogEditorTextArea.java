package com.br.client.panel.business.UI;

import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.core.client.JavaScriptObject;
import com.howmake.client.form.UI.HowMGWTTextAreaItem;
import com.howmake.client.form.UI.HowMGWTWindowBase;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class DialogEditorTextArea  extends HowMGWTWindowBase{

	private VLayout mainArea = new VLayout();
	private ToolStrip tools  = new ToolStrip();
	private boolean canEdit  = true;
	
	private JavaScriptObject parentDOM;
	
	private HowMGWTTextAreaItem textAreaEditor = new HowMGWTTextAreaItem();
	
	public DialogEditorTextArea(){
		this.setWidth("350px");
		this.setHeight("250px");
		
		this.setShowHeader(true);
	 
		mainArea.setWidth100();
		mainArea.setHeight100();
		
		this.textAreaEditor.getField().setShowTitle(false);
		this.textAreaEditor.setWidth100();
		this.textAreaEditor.setHeight100();
		
		
		IButton actionOK = new IButton(Tradutor.i18n.formOK());  
		actionOK.setWidth(80);  
		actionOK.setShowRollOver(true);  
		actionOK.setShowDisabled(true);
		actionOK.setShowDisabledIcon(true);
		actionOK.setShowDown(true);  
		actionOK.setIcon("actions/approve.png");  
		
		actionOK.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				 hide();
				 if ( canEdit )
					 DialogEditorTextArea.setValueInParent(parentDOM,textAreaEditor.getHowMValueAsString());
				 else
					 DialogEditorTextArea.setValueShowInParent(parentDOM);
			}
		});
		

		IButton actionCancelar = new IButton(Tradutor.i18n.formCancelar());  
		actionCancelar.setWidth(80);  
		actionCancelar.setShowRollOver(true);  
		actionCancelar.setShowDisabled(true);
		actionCancelar.setShowDisabledIcon(true);
		actionCancelar.setShowDown(true);  
		actionCancelar.setIcon("actions/btn_cancel.png");  
		
		actionCancelar.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				 hide();
			}
		});
		
		HLayout hl = new HLayout();
		hl.setHeight("22px");
		hl.addMember(actionOK);
		hl.addMember(actionCancelar);
		
		this.tools.addChild(hl);
		
		this.tools.setWidth100();
		this.tools.setHeight("22px");
		
		mainArea.addMember(this.textAreaEditor);
		mainArea.addMember(this.tools);
		
		this.addItem(this.mainArea);		
		
		this.centerInPage();
		
		this.setCanDragResize(true);
        this.setIsModal(true);
 
		this.setTitle(Tradutor.i18n.formObservacao());
		
		this.setDismissOnEscape(true);		
	}
	
	/**
	 * Permite setar o valor do campo do html no editor de textos.
	 * @param fieldReference Campo de referencia para retorno da informação.
	 * @param valor Valor do campo.
	 * @param method metodo que será acionado para reatualizar a tela.
	 */
	public void showEditor(JavaScriptObject parentDOM, String valor, boolean canEdit){
		this.parentDOM		= parentDOM;
		this.textAreaEditor.setHowMValue(valor);
		this.canEdit 		= canEdit;
		this.textAreaEditor.getField().setDisabled(!canEdit);
		this.show();
	}

	/**
	 * @return Retorna o endereço absoluto do contexto onde serão executados os serviços de donwload
	 * GWT.
	 */
	public static native void setValueShowInParent( JavaScriptObject object ) /*-{
	   object.focus();	  
	}-*/;	
	
	
	/**
	 * @return Retorna o endereço absoluto do contexto onde serão executados os serviços de donwload
	 * GWT.
	 */
	public static native void setValueInParent( JavaScriptObject object ,  String valor) /*-{
	   object.value = valor;
	   object.onchange();
	   object.focus();
	}-*/;	
}
