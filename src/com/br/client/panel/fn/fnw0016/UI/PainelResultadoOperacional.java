package com.br.client.panel.fn.fnw0016.UI;

import com.br.client.model.fn.entity.excel.eHowMWorksheet;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.UIPartner;
import com.google.gwt.user.client.Window;
import com.smartgwt.client.util.PrintPreviewCallback;
import com.smartgwt.client.util.PrintProperties;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.PrintCanvas;
import com.smartgwt.client.widgets.PrintWindow;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelResultadoOperacional extends VLayout implements UIPartner{

	private PainelResult painelResult;
	
	private PainelMontagemConsulta montagemConsulta = new PainelMontagemConsulta(){
		@Override
		public void onLoad(eHowMWorksheet worksheet){
			PainelResultadoOperacional.this.onLoad(worksheet);
		};
		
		public void onImprimirConsulta() {
			PainelResultadoOperacional.this.onImprimirConsulta();
		};
	};
 
	public PainelResultadoOperacional(){
		this.setWidth100();
		this.setHeight100();
		
		montagemConsulta.setAutoHeight();
		
	}
	
	public void start(){
	
		this.addMember( montagemConsulta );
		montagemConsulta.refreshDatas();
	}

	public String getHowMGWTTitle(){
		return Tradutor.i18n.formTituloFNW0016();
	}

	public String getHowMGWTPrograma(){
		return "FNW0016";
	}

	
	public void onLoad(eHowMWorksheet worksheet){
		if ( painelResult != null )
			this.removeMember(painelResult);
		
		painelResult = null;
			
		painelResult = new PainelResult(worksheet);
		this.addMember(painelResult);
		this.montagemConsulta.setPainelResult(painelResult);
	}

	public void onImprimirConsulta(){
		Object[] printers = new Object[1];
		printers[0] = this.painelResult;
		
		PrintProperties printProperties = new PrintProperties();
		
		Canvas.showPrintPreview(printers, printProperties, Tradutor.i18n.formTituloFNW0016(), new PrintPreviewCallback() {
			
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