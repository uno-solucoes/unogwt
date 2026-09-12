package com.howmake.client.form.UI;

import com.br.client.configuracao.Configuracao;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.user.client.Window;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
// htmlPane.setContentsType(ContentsType.PAGE);
public class HowMGWTImgButtonDonwload extends HLayout{

	private String fileName = "";
	private String path     = "";
	
	private ImgButton actionDownload = new ImgButton();

	private boolean download = false;
	
	public HowMGWTImgButtonDonwload(){
		
		actionDownload.setShowDown(false);  
		actionDownload.setShowRollOver(false);  
		actionDownload.setLayoutAlign(Alignment.CENTER);   
		actionDownload.setPrompt(Tradutor.i18n.downloadArquivo());  
		actionDownload.setHeight(16);  
		actionDownload.setWidth(16); 
		hiddenDownload();
		
		actionDownload.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
 
            	if ( fileName == null || fileName.trim().length() == 0){            		
            		return;
            	}
            	
            	// String url = "unogwt/HowMDownload?PATH=C:\\Trabalho\\dev\\apache-tomcat-6.0.18\\webapps\\UCOMMERCE\\Desenv\\empresa\\notafiscal\\nfse\\&FILE_NAME=nfse3169.xml"; 
            	String url = "";
            	url += Configuracao.getNativeUnoUrlServiceDonwload();
            	if ( url.endsWith("/"));
            	else
            		url += "/";
            	url += "unogwt/HowMDownload?PATH="+path+"&FILE_NAME="+fileName;
            	Window.open(url, "DONWLOAD", "");
            }  
        });
		this.addMember(actionDownload);
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the actionDownload
	 */
	public ImgButton getActionDownload() {
		return actionDownload;
	}

	/**
	 * @param actionDownload the actionDownload to set
	 */
	public void setActionDownload(ImgButton actionDownload) {
		this.actionDownload = actionDownload;
	}
	
	public void showDownload(){
		 actionDownload.setSrc("actions/download.png");
		 download = true;
	}
	public void hiddenDownload(){
		actionDownload.setSrc("actions/transparence.png");
		download = false;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
}
