package com.br.client.panel.fn.fnw0015.UI;

import java.util.ArrayList;
import java.util.Date;

import com.br.client.model.fn.entity.eBoletimCaixa;
import com.br.client.model.fn.fnw0015.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.UIPartner;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.howmake.client.form.UI.HowMGWTLabel;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.PrintPreviewCallback;
import com.smartgwt.client.util.PrintProperties;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.PrintCanvas;
import com.smartgwt.client.widgets.PrintWindow;
import com.smartgwt.client.widgets.WidgetCanvas;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ResizedEvent;
import com.smartgwt.client.widgets.events.ResizedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelBoletimCaixa extends VLayout implements UIPartner{

	// Desenha Entradas e Saidas.
	HLayout painelTitulos = new HLayout();
	
	HLayout sep2 = new HLayout();

	
	private Window parentWindow;
	
	private PainelFiltro paninelFiltro 					= new PainelFiltro(){
		public void onBuscar() {
			executeQuery();
		};
		
		public void onShowPrint() {
			executeShowPrint();
		};
	};
	private VLayout boletimCaixa 						= new VLayout();
	private PainelTitulos painelTitulosEntrada 			= new PainelTitulos();
	private PainelTitulos painelTitulosSaida			= new PainelTitulos();
	private PainelTransferencias painelTransferencias	= new PainelTransferencias();
	private PainelPosicaoCaixa painelPosicaoCaixa		= new PainelPosicaoCaixa();

	@Override
	public void start() {
		// TODO Auto-generated method stub
		this.setWidth100();
		this.setHeight100();
		this.setOverflow(Overflow.CLIP_V);
		
		this.createReportLayout();		 
		
	}

	public String getHowMGWTTitle(){
		return Tradutor.i18n.formTituloFNW0015();
	}

	public String getHowMGWTPrograma(){
		return "FNW0015";
	}
 
	public void createReportLayout(){
		
		sep2.setWidth(20);

		boletimCaixa.setAutoHeight();
		boletimCaixa.setHeight(100);
		boletimCaixa.setMinHeight(100);

		this.addMember(paninelFiltro);
		String titleBar = "#B2DFEE";

		boletimCaixa.addMember(new PainelTitle("#FFFF00", "<H2>"+Tradutor.i18n.formBoletimDeCaixa().toUpperCase()+"</H2>",270, 46));

		HLayout painelTitulosTitle = new HLayout();
		painelTitulosTitle.setWidth100();

		PainelTitle titleEntrada = new PainelTitle(titleBar, Tradutor.i18n.formEntradas().toUpperCase() );
		// titleEntrada.setWidth(painelTitulosEntrada.getWidth());
		painelTitulosTitle.addMember(titleEntrada);
	
		HLayout sep1 = new HLayout();
		sep1.setWidth(20);
		painelTitulosTitle.addMember(sep1);				
		
		PainelTitle titleSaida   = new PainelTitle(titleBar, Tradutor.i18n.formSaidas().toUpperCase()  );
		// titleSaida.setWidth(painelTitulosSaida.getWidth());
		painelTitulosTitle.addMember(titleSaida);
	
		this.boletimCaixa.addMember(painelTitulosTitle);	
		
 
		painelTitulos.addMember(painelTitulosEntrada);
 		painelTitulos.addMember(sep2);				
		painelTitulos.addMember(painelTitulosSaida);
	
		boletimCaixa.addMember(painelTitulos);
	
		int width = painelTitulosEntrada.getWidth()+painelTitulosSaida.getWidth()+sep2.getWidth();
		
		HLayout sepTitulos = new HLayout();

		// -----------------------------------------------------------------------
		// Desenha as Transferências
		// -----------------------------------------------------------------------
		boletimCaixa.addMember(new PainelTitle(titleBar, Tradutor.i18n.formTransferencias().toUpperCase()));

		HLayout hPainelTransferencias = new HLayout();
		hPainelTransferencias.addMember(painelTransferencias);		
		boletimCaixa.addMember(hPainelTransferencias);	

		// -----------------------------------------------------------------------
		// Posição de Caixa
		// -----------------------------------------------------------------------
		boletimCaixa.addMember(new PainelTitle(titleBar, Tradutor.i18n.formPosicaoDeCaixa().toUpperCase()));

		HLayout hPainelPosicaoCaixa = new HLayout();
		hPainelPosicaoCaixa.addMember(painelPosicaoCaixa);
		this.boletimCaixa.addMember(hPainelPosicaoCaixa);

		// this.boletimCaixa.setWidth(width);
		this.addMember(boletimCaixa);
	}

	/**
	 * @return the parentWindow
	 */
	public Window getParentWindow() {
		return parentWindow;
	}

	/**
	 * @param parentWindow the parentWindow to set
	 */
	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}
	
	
	public void executeQuery(){
		HowMGWTWindowWait.showWait();
		
	    FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {

				ArrayList<eBoletimCaixa> titulosEntrada = new ArrayList<eBoletimCaixa>();
				ArrayList<eBoletimCaixa> titulosSaida   = new ArrayList<eBoletimCaixa>();
				
				FormBean bean = (FormBean)formBean;
				if ( bean.getTitulos() != null ){
					for ( eBoletimCaixa titulo : bean.getTitulos()){
						if ( "CR".equals(titulo.getTipoTitulo())){
							titulosEntrada.add(titulo);
						}
						else{
							titulosSaida.add(titulo);							
						}							
					}
				}
				painelTitulos.removeMember(painelTitulosEntrada);
		 		painelTitulos.removeMember(sep2);				
				painelTitulos.removeMember(painelTitulosSaida);					
					
				painelTitulosEntrada 		= new PainelTitulos();
				painelTitulosSaida			= new PainelTitulos();				
				
				painelTitulos.addMember(painelTitulosEntrada);
		 		painelTitulos.addMember(sep2);				
				painelTitulos.addMember(painelTitulosSaida);
				
				painelTitulosEntrada.load(titulosEntrada);
				painelTitulosSaida.load(titulosSaida);

				painelTransferencias.load(bean.getTransferencias());
				painelPosicaoCaixa.load(bean.getPosicaoCaixa());
				
				HowMGWTWindowWait.hideWait();
				
				boletimCaixa.redraw();
			}
		};			
		Date date = paninelFiltro.fieldData.getField().getValueAsDate();
		String dataInicio = HowMGWTUtilities.getRPad(""+(date.getYear()+1900),"0",4)+"-"+
							HowMGWTUtilities.getRPad(""+(date.getMonth()+1)  ,"0",2)+"-"+
							HowMGWTUtilities.getRPad(""+ date.getDate()      ,"0",2);
		
		struts.request("fnw0015.do?method=buscar&dataInicio="+dataInicio+" 00:00:00&dataFim="+dataInicio+" 23:59:59",  "FNW0015Form", "");			
	}
	
	public void executeShowPrint(){
		Object[] printers = new Object[1];
		printers[0] = this.boletimCaixa;
		
		PrintProperties printProperties = new PrintProperties();
		
		Canvas.showPrintPreview(printers, printProperties, Tradutor.i18n.formTituloFNW0015(), new PrintPreviewCallback() {
			
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
