package com.br.client.panel.vd.vdw1000.UI;

import java.util.LinkedHashMap;

import com.br.client.panel.vd.vdw1000.util.NFSEUtilities;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.IconButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.toolbar.RibbonBar;
import com.smartgwt.client.widgets.toolbar.RibbonGroup;

public class PanelRibbonBarSuporte extends PanelRibbonBarLayout{

    private RibbonBar ribbonBar = new RibbonBar();  
    private RibbonGroup menuArquivos = new RibbonGroup();      

    private PanelRibbonBarRPS parentRibbonBar;
    
	int iconSize = 32; 

    int heightMenu = 105;

    private IconButton BUTTON_OPERACAO_ADMIN_VOLTAR				 		= getIconButton(NFSEUtilities.OPERACAO_ACESSAR_ADMIN_BACK_DESC			 		, "icon_back"				, true); 
    // private IconButton BUTTON_OPERACAO_ADMIN_REGERAR_RPS_REENVIAR 		= getIconButton(NFSEUtilities.OPERACAO_ACESSAR_ADMIN_REGERAR_RPS_REENVIAR_DESC	, "icon_edit_send"			, true); 
    private IconButton BUTTON_OPERACAO_ADMIN_ANALISAR_RPS			 	= getIconButton(NFSEUtilities.OPERACAO_ACESSAR_ADMIN_ANALISAR_RPS_DESC		  	, "icon_analisar_documento"	, true);
    private IconButton BUTTON_OPERACAO_ADMIN_DAWNLOAD_AI			 	= getIconButton(NFSEUtilities.OPERACAO_ACESSAR_ADMIN_DOWNLOAD_AI_DESC		  	, "ico_download_big"		, true);

    private HowMGWTProperty propertyTipoDownload 						= new HowMGWTProperty("tipoDownload", "Tipo Download");
    
    private PanelLoginSuporte panelLoginSuporte 						= new PanelLoginSuporte(){
    	protected void onConnect() {
    		// BUTTON_OPERACAO_ADMIN_REGERAR_RPS_REENVIAR.setDisabled(false);
    		BUTTON_OPERACAO_ADMIN_ANALISAR_RPS.setDisabled(false);
    		BUTTON_OPERACAO_ADMIN_DAWNLOAD_AI.setDisabled(false);
    		propertyTipoDownload.getCanvas().setDisabled(false);
    		this.setVisible(false);
    		ribbonBar.redraw();
    	};
    };
    
	public PanelRibbonBarSuporte(PanelRibbonBarRPS parentRibbonbBar){

		this.parentRibbonBar = parentRibbonbBar;

        menuArquivos.setTitle("Suporte");  
        menuArquivos.setTitleAlign(Alignment.LEFT);  
        menuArquivos.setNumRows(1);  
        menuArquivos.setRowHeight(26);
        menuArquivos.setHeight(heightMenu);

		this.setWidth100();
		this.setHeight100();

		ribbonBar.setWidth100();

        ribbonBar.addMember(menuArquivos);        

        menuArquivos.addControl(BUTTON_OPERACAO_ADMIN_VOLTAR);
        BUTTON_OPERACAO_ADMIN_VOLTAR.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PanelRibbonBarSuporte.this.parentRibbonBar.onBack();
			}
		});        

        
//        if( "1".equals( this.parentRibbonBar.getCurrentFormBeanConfiguration().getIndEnviaDadosDebug() ) ){
//	        menuArquivos.addControl(BUTTON_OPERACAO_ADMIN_REGERAR_RPS_REENVIAR);
//	        BUTTON_OPERACAO_ADMIN_REGERAR_RPS_REENVIAR.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
//				
//				@Override
//				public void onClick(ClickEvent event) {
//					PanelRibbonBarSuporte.this.parentRibbonBar.onRegerarReenviarRPS();
//				}
//			});
//        }
        
        menuArquivos.addControl(BUTTON_OPERACAO_ADMIN_ANALISAR_RPS);
        BUTTON_OPERACAO_ADMIN_ANALISAR_RPS.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PanelRibbonBarSuporte.this.parentRibbonBar.onAnalisarRPS();
			}
			
		});        


        propertyTipoDownload.setBound(0,110);
        propertyTipoDownload.createHowMFieldSelectItem();
        propertyTipoDownload.getHowMFieldSelectItemEditor().getField().setTitleOrientation(TitleOrientation.TOP);
        menuArquivos.addControl(propertyTipoDownload.getCanvas());
        
        LinkedHashMap<String, String> mapTiposDownload = new LinkedHashMap<String, String>();
        mapTiposDownload.put("Conferencia", "Conferencia");
        mapTiposDownload.put("Integracao" , "Integracao");
        propertyTipoDownload.getHowMFieldSelectItemEditor().getField().setValueMap(mapTiposDownload);        
        propertyTipoDownload.setHowmFormValue("Integracao");
        
        
        
        menuArquivos.addControl(BUTTON_OPERACAO_ADMIN_DAWNLOAD_AI);
        BUTTON_OPERACAO_ADMIN_DAWNLOAD_AI.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PanelRibbonBarSuporte.this.parentRibbonBar.onDownloadAI();
			}			
		});        
        
       //  BUTTON_OPERACAO_ADMIN_REGERAR_RPS_REENVIAR.setDisabled(true);
        BUTTON_OPERACAO_ADMIN_ANALISAR_RPS.setDisabled(true);
        BUTTON_OPERACAO_ADMIN_DAWNLOAD_AI.setDisabled(true);
        propertyTipoDownload.getCanvas().setDisabled(true);

        menuArquivos.addControl(panelLoginSuporte);
        
        
        this.addMember(ribbonBar); 

		
	}

	
	public void configure(String lastOperacao){
		
//		if("1".equals(parentRibbonBar.getCurrentFormBeanConfiguration().getIndEnviaDadosDebug() )){
//		
//			if( NFSEUtilities.OPERACAO_NOTAS_FISCAIS_PENDENTES_PARA_ENVIO.equals(lastOperacao)){
//				BUTTON_OPERACAO_ADMIN_REGERAR_RPS_REENVIAR.setVisible(false);
//			}
//			else{
//				BUTTON_OPERACAO_ADMIN_REGERAR_RPS_REENVIAR.setVisible(true);
//			}
//		}
//		else{
//			BUTTON_OPERACAO_ADMIN_REGERAR_RPS_REENVIAR.setVisible(false);
//		}
		this.ribbonBar.redraw();		
	}


	public PanelLoginSuporte getPanelLoginSuporte() {
		return panelLoginSuporte;
	}


	public HowMGWTProperty getPropertyTipoDownload() {
		return propertyTipoDownload;
	}
}
