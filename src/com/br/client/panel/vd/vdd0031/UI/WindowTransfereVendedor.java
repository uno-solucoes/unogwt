package com.br.client.panel.vd.vdd0031.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.UIPartner;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

public class WindowTransfereVendedor extends HowMGWTWindow implements UIPartner{
	
	private JavaScriptObject parentObject;
	private String clientesSelecionados;
 
	private PainelTransfereVendedor painelTransfereVendedor = new PainelTransfereVendedor();
	 
	public WindowTransfereVendedor(){
 
		this.setWidth("600px");
		this.setHeight("140px");
		this.setIsModal(true);
		this.centerInPage();
	
		this.start();
		
		this.setDismissOnEscape(true);
	}
 
	@Override
	public void start() {
		
		VLayout mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		mainLayout.addMember(painelTransfereVendedor);
		
		this.painelTransfereVendedor.actionAtualizar.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				String msg = Tradutor.i18n.msgConfirmaTransferenciaClientesVendedor();
				msg += painelTransfereVendedor.fieldColaborador.getField().getHowMValue()+"-";
				msg += painelTransfereVendedor.fieldColaborador.getMessageLabel().getHowMValue();
				SC.confirm(msg,new BooleanCallback() {					
					@Override
					public void execute(Boolean value) {
						trasferirClientes();
					}
				});				
			}
		});
		
		this.painelTransfereVendedor.actionCancelar.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				cancelar();
			}
		});
		
		this.addItem(mainLayout);
	}

	public String getHowMGWTTitle(){
		return Tradutor.i18n.formTituloVDD0031();
	}
	public String getHowMGWTPrograma(){
		return "VDD0031";
	}
	
	/**
	 * Apresenta os detalhes na tela e carrega os dados do servidor.
	 * @param descColaborador
	 * @param descFamiliaComercial
	 * @param tipoAplicacao
	 */
	public void show(JavaScriptObject parentObject , String clientes){
		
		this.parentObject = parentObject;
		
		String[] aClientes = clientes.split(",");
		
		this.clientesSelecionados = clientes;
		
		int qtdeCLientes = aClientes.length;
		if ( qtdeCLientes == 1)
			this.painelTransfereVendedor.fieldMessage.setHowMValue("<h3>"+qtdeCLientes+" "+Tradutor.i18n.formClienteSelecionado()+"<h3>");
		else
			this.painelTransfereVendedor.fieldMessage.setHowMValue("<h3>"+qtdeCLientes+" "+Tradutor.i18n.formClientesSelecionados()+"<h3>");


	    com.br.client.model.vd.vdd0031.FormBean formBean = new com.br.client.model.vd.vdd0031.FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( isGwtCheckSecurity() ){					 
					show();
				}
			}
		};
		struts.setGwtCheckSecurity(true);
		struts.requestFormBean("vdd0031",  "VDD0031Form");

	}

	
	/**
	 * Transfere os clientes para o vendedor.
	 */
	public void trasferirClientes(){
		HowMGWTWindowWait.showWait();
	    com.br.client.model.vd.vdd0031.FormBean formBean = new com.br.client.model.vd.vdd0031.FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				HowMGWTWindowWait.hideWait();
				if ( ! HowMGWTControl.isRefreshFormShowMessage(formBean)){
						WindowTransfereVendedor.this.hide();
						onHowMReloadClientes(parentObject);
				}
			}
		};
		String codVendedor = painelTransfereVendedor.fieldColaborador.getField().getHowMValueAsString();
		System.out.println("Vendedor : "+codVendedor);
		struts.setGwtCheckSecurity(true);
		struts.request("vdd0031.do?method=transferirClientes&clientesSelecionados="+this.clientesSelecionados+"&codVendedor="+codVendedor,  "VDD0031Form", "");
	}
	
	/**
	 * Cancela a operação
	 */
	public void cancelar(){
		this.painelTransfereVendedor.fieldColaborador.getField().setHowMValue("");
		this.painelTransfereVendedor.fieldColaborador.getMessageLabel().setHowMValue("");
		this.painelTransfereVendedor.fieldMessage.setHowMValue("");
		this.hide();
	}
	
	public native void onHowMReloadClientes(JavaScriptObject object) /*-{
	  return object.onHowMReloadClientes();
	}-*/;	
 
}