package com.br.client.panel.vd.vdd0030.UI;

import com.br.client.model.vd.vdw0025.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.UIPartner;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.smartgwt.client.util.PrintPreviewCallback;
import com.smartgwt.client.util.PrintProperties;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.PrintCanvas;
import com.smartgwt.client.widgets.PrintWindow;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class WindowPerformanceVenda extends HowMGWTWindow implements UIPartner{
	
	private String descColaborador;
	private String descFamiliaComercial;
	private String tipoAplicacao;
	
	private PainelResultado painelResultado = new PainelResultado();
	 
	public WindowPerformanceVenda(){
 
		this.setWidth("90%");
		this.setCanDragResize(true);
		this.setHeight("620px");
		this.setIsModal(true);
		this.centerInPage();
	
		initUI();		
		
		this.setDismissOnEscape(true);
	}
 
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Monta a interface gráfica da tela de busca de produtos.
	 */
	public void initUI(){

		ToolStrip toolbar = new ToolStrip();
		toolbar.setWidth100();
		toolbar.setHeight("24px");
		
	    IButton actionImprimir = new IButton(Tradutor.i18n.formImprimir());
    	actionImprimir.setIcon("actions/print.png");
		actionImprimir.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				showPrint();
			}
		});		
		toolbar.addChild(actionImprimir);
		
		painelResultado.initUI();
		VLayout mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
 
		mainLayout.addMember(toolbar);
		mainLayout.addMember(painelResultado);
	    this.addItem(mainLayout); 
	}

	public String getHowMGWTTitle(){
		return Tradutor.i18n.formTituloVDD0030();
	}
	public String getHowMGWTPrograma(){
		return "VDD0030";
	}
	
	
	/**
	 * Apresenta os detalhes na tela e carrega os dados do servidor.
	 * @param descColaborador
	 * @param descFamiliaComercial
	 * @param tipoAplicacao
	 */
	public void show(String descColaborador, String descFamiliaComercial, String tipoAplicacao){
		
		this.descColaborador 	  = descColaborador;
		this.descFamiliaComercial = descFamiliaComercial;
		this.tipoAplicacao 		  = tipoAplicacao;
				
	    com.br.client.model.vd.vdd0030.FormBean formBean = new com.br.client.model.vd.vdd0030.FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( isGwtCheckSecurity() ){			
					setWidth("90%");
					setHeight("620px");
					centerInPage();
					show();

					
					buscar();
				}
			}
		};			
		struts.setGwtCheckSecurity(true);
		struts.requestFormBean("vdd0030",  "VDD0030Form");
	}

	public void buscar(){
		HowMGWTWindowWait.showWait();
		String param = "";
		param += "&descColaborador="+descColaborador;
		param += "&descFamiliaComercial="+descFamiliaComercial;
		param += "&tipoAplicacao="+tipoAplicacao;
		
	    FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				painelResultado.loadResult((FormBean)formBean);
				HowMGWTWindowWait.hideWait();
				
				Timer timer = new Timer() {
					
					@Override
					public void run() {
						focus();
						painelResultado.focus();
					}
				};
				timer.schedule(50);					
			}
		};			
		struts.request("vdw0025.do?method=buscarDetalhesPerformanceVendas"+param,  "VDW0025Form", "");		
	}
	
	@Override
	protected void onHowMGWTClose() {
		// TODO Auto-generated method stub
		super.onHowMGWTClose();
		painelResultado.clearAllRecords();
	}
	
	public void showPrint(){
		Object[] printers = new Object[1];
		printers[0] = this.painelResultado;
		
		PrintProperties printProperties = new PrintProperties();
		
		Canvas.showPrintPreview(printers, printProperties, Tradutor.i18n.formTituloVDD0030(), new PrintPreviewCallback() {
			
			@Override
			public void execute(PrintCanvas printCanvas, PrintWindow printWindow) {
				// TODO Auto-generated method stub
				printWindow.setWidth("740px");
				printWindow.setHeight("90%");
				printWindow.centerInPage();
				
			}
		});
	}
}