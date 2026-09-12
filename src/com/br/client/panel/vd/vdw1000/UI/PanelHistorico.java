package com.br.client.panel.vd.vdw1000.UI;



import com.br.client.configuracao.Configuracao;
import com.br.client.model.vd.entity.eNFSELoteWS;
import com.br.client.model.vd.vdw1000.FormBean;
import com.google.gwt.user.client.Window;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.ContentsType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class PanelHistorico extends HLayout{

//	private PaineMonitoraWorkflowJobs panelMonitorWorkflowJobs = new PaineMonitoraWorkflowJobs(); 
//	public PaineMonitoraWorkflowJobs getPanelMonitorWorkflowJobs() {
//		return panelMonitorWorkflowJobs;
//	}


	private HTMLPane paneHistorico = new HTMLPane();
	
	private Label labelLog = new Label();
	private Label labelmonitorLayout = new Label();

	public PanelHistorico()
	{
		this.setWidth100();
		this.setHeight("20%");	

//		VLayout monitorLayout = new VLayout();
//		monitorLayout.setWidth100();
//		monitorLayout.setHeight100();
//		
//	 	ToolStrip monitorLayoutTools = new ToolStrip();
//	 	monitorLayoutTools.setWidth100();
//	 	monitorLayoutTools.setHeight(26);
//	 	monitorLayout.addMember(monitorLayoutTools);
		
//		labelmonitorLayout.setContents("<strong>Monitoramento automatica do processamento de RPS</strong>");
//		labelmonitorLayout.setWrap(false);
//		labelmonitorLayout.setWidth100();
//		monitorLayoutTools.addMember(labelmonitorLayout);

		// monitorLayout.addMember(panelMonitorWorkflowJobs);
//		this.addMember(monitorLayout);
		
		
		this.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(1, HowMGWTUtilities.backgroundSeparadora));
		

//		Img imgAnimation = new Img();
//		imgAnimation.setSrc("nfse/radar.gif");
//		imgAnimation.setImageType(ImageStyle.STRETCH);
//		
//		this.addMember(imgAnimation);
//		
//		this.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(1, HowMGWTUtilities.backgroundSeparadora));

		VLayout logLayout = new VLayout();
		logLayout.setWidth100();
		logLayout.setHeight100();
		
	 	ToolStrip historicoTools = new ToolStrip();
    	historicoTools.setWidth100();
    	historicoTools.setHeight(26);
		logLayout.addMember(historicoTools);
		
		labelLog.setContents("<strong>Clique em um registro na lista acima para visualizar o LOG</strong>");
		labelLog.setWrap(false);
		labelLog.setWidth100();
		historicoTools.addMember(labelLog);
		    	
		paneHistorico.setContentsType(ContentsType.FRAGMENT);
		paneHistorico.setOverflow(Overflow.AUTO);
		paneHistorico.setWidth100();
		paneHistorico.setHeight100();
		
		logLayout.addMember(paneHistorico);
		
		this.addMember(logLayout);
	}
	
	public void showHistorico(eNFSELoteWS loteWS){
		String html = " ";
		if ( loteWS == null ){
		}
		else if( "1".equals( loteWS.getError() ) && !HowMGWTUtilities.isEmpty( loteWS.getErrorMsg() ) ){
			html += loteWS.getErrorMsg();
		}
		else{
			if ( ! HowMGWTUtilities.isEmpty( loteWS.getErrorMsg() ) ){
				html += loteWS.getErrorMsg();
			}
		}
		if( HowMGWTUtilities.isEmpty( html )){
			html = " ";
		}
		paneHistorico.setContents(html);
	}	
	
	public void onRefreshHistorico(PanelResultadoConsulta panelResultadoConsulta, ListGridRecord record){
		if( record == null ){
			paneHistorico.setContents(" ");
			return;
		}
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				FormBean form = (FormBean)formBean;
				showHistorico(form.getEntityLoteWS());
			}
		};
		FormBean bean = new FormBean();
		bean.setCodEmitente(panelResultadoConsulta.getCurrentCodEmitente());
		bean.setCodEmpresa(Configuracao.getCodEmpresa());
		bean.setCodNotaFiscal(panelResultadoConsulta.getPropertyCodNotaFiscal().getHowMValue(record));		
		struts.request("vdw1000.do?method=buscarHistorico",  "VDW1000Form", bean.toSendBody("") );
	}	

}