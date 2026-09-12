package com.br.client.panel.vd.vdw0800.UI;

import com.br.client.model.vd.vdw0800.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.UIPartner;
 
import com.howmake.client.form.UI.HowMGWTUploadDialog;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelNFSE extends VLayout implements UIPartner{

	public static final int OPTION_LIST_CIDADES 		= 1;
	public static final int OPTION_CHART_ESTATISTICAS 	= 2;
	public static final int OPTION_PAINEL_LINKS 		= 3;	
	private int oldOption = OPTION_LIST_CIDADES;
	
	private HLayout mainLayout = new HLayout();
	private HLayout bodyLayout = new HLayout();
	
	private PainelLinksCidade painelLinksCidade = new PainelLinksCidade();

	private PainelFiltro painelFiltro = new PainelFiltro(){
		public void onBuscar(){
			executeBuscar();
		}		
	};
	private PainelToolbar painelToolbarVertical = new PainelToolbar();
	private PainelListaCidades painelListaCidades = new PainelListaCidades(){
	
		@Override
		public void onHowMFinishLoadDatabaseRecord() {
			painelToolbarVertical.actionLinks.setDisabled(true);
		}
		
	};
		
	private PainelChartParticipacaoPadroes painelEstatisticas = new PainelChartParticipacaoPadroes();
	
	public PainelNFSE(){
		
	}

	@Override
	public void start() {

		this.painelToolbarVertical.setParentNFSE(this);
		
		this.addMember(painelFiltro);
	 
		this.mainLayout.setWidth100();
		this.mainLayout.setHeight100();

		this.bodyLayout.setWidth100();
		this.bodyLayout.setHeight100();
		
		
		bodyLayout.addMember(painelListaCidades);
		bodyLayout.addMember(painelEstatisticas);
		bodyLayout.addMember(painelLinksCidade);
		
		mainLayout.addMember(painelToolbarVertical);
		mainLayout.addMember(bodyLayout);
		
		this.addMember(mainLayout);
		
		painelEstatisticas.setVisible(false);
		painelLinksCidade.setVisible(false);
	
		
		this.painelListaCidades.addRecordClickHandler(new RecordClickHandler() {
			
			@Override
			public void onRecordClick(RecordClickEvent event) {
				painelToolbarVertical.actionLinks.setDisabled(false);
			}
		});
		
	}
	

	public String getHowMGWTTitle(){
		return Tradutor.i18n.formTituloVDW0800();
	}

	public String getHowMGWTPrograma(){
		return "VNW0800";
	}
	
	
	public void executeBuscar(){
		if ( HowMGWTUtilities.isEmpty(painelFiltro.fieldCodigoIBGE.getHowMValueAsString())    &&
			 HowMGWTUtilities.isEmpty(painelFiltro.fieldNomeMunicipio.getHowMValueAsString()) &&
			 HowMGWTUtilities.isEmpty(painelFiltro.fieldPadrao.getHowMValueAsString())
		){
			SC.say(Tradutor.i18n.msgInformeMinimoCamposCriterios());
			return;
		}

		HowMGWTWindowWait.showWait();

		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {

				painelListaCidades.load(( FormBean)formBean);
				System.out.println("Executou consulta");
				HowMGWTWindowWait.hideWait();
			}
		};					 
		String body = "";
		body += "&codCidade="+painelFiltro.fieldCodigoIBGE.getHowMValueAsString();
		body += "&nomeCidade="+painelFiltro.fieldNomeMunicipio.getHowMValueAsString();
		body += "&padrao="+painelFiltro.fieldPadrao.getHowMValueAsString();
		body += "&forcaPadrao="+painelFiltro.fieldForcaPadrao.getField().getValueAsBoolean();
		struts.request("vdw0800.do?method=buscarCidades",  "VDW0800Form", body);	
		
	}
	
	public void showPanel(int option){

		if ( oldOption == option )
			return;
			
		this.painelListaCidades.setVisible(false);
		this.painelEstatisticas.setVisible(false);
		this.painelLinksCidade.setVisible(false);
		
		switch (option) {
		case OPTION_LIST_CIDADES:
			this.painelListaCidades.setVisible(true);
			this.oldOption = option;
			break;
		case OPTION_CHART_ESTATISTICAS:
			this.painelEstatisticas.setVisible(true);
			this.painelEstatisticas.drawChart();
			this.oldOption = option;			
			break;
		case OPTION_PAINEL_LINKS:
			this.painelLinksCidade.setVisible(true);
			this.painelLinksCidade.drawLinks(this.painelListaCidades.getSelectedRecord());
			this.oldOption = option;			
			break;
		default:
			this.painelListaCidades.setVisible(true);
			this.oldOption = OPTION_LIST_CIDADES;
			break;
		}
	}
}
