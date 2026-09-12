package com.howmake.client.form.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.Services;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.howmake.client.form.UI.HowMGWReportViewerWindow;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HOWMGWTDataSourceQuery;
import com.howmake.client.form.model.HowMGWTCall;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.util.SC;

public abstract class HowMGWTExecuteReportExternalWindow {

	private String width;
	private String height;
	private String programCode;
	private String strutsAction;
	
	private String corpo;
	private String cod_layout;
	private String nomeLayout;	
	
	private String tp_funcao;
	private String comando;
	private String nome_programa_en;
	private String nome_programa_pt_BR;	
	
	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}
	

	/**
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}


	/**
	 * @param width the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}	


	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}
	
	
	/**
	 * Executa o relatório no servidor.
	 */
	public void executeReport(){

		corpo 	   			= "001";
		cod_layout 			= null;
		nomeLayout 			= null;
		tp_funcao  			= null;
		comando	   			= null;
		nome_programa_en 	= null;
		nome_programa_pt_BR = null;	
		
		String sql = "";
		
		sql += "select ";
		sql += "       corpo,  ";
		sql += "       cod_layout, "; 
		sql += "       nome_layout,  ";
		sql += "       sg_programa.tp_funcao,		   ";
		sql += "       sg_programa.comando,			   ";
		sql += "       sg_programa.nome_programa_en,   ";    
		sql += "       sg_programa.nome_programa_pt_BR ";
		sql += "from sg_programa  ";
		sql += "  	 left outer join sg_programa_empresa " ;
		sql += "     on	";
		sql += "		sg_programa_empresa.programa    = sg_programa.programa ";
		sql += " 		and ";
		sql += "		sg_programa_empresa.cod_empresa = "+Configuracao.getCodEmpresa()+" ";
		sql += "where ";
		sql += "	sg_programa.programa    = '"+this.programCode+"' ";
		sql += "limit 1 ";
		
		HOWMGWTDataSourceQuery.executeQuery(sql, new HowMGWTCall() {
			@Override
			public void onSuccess(HowMGWTEntity result) {			
				// Se não encontrar corpo cadastrado avalia que deverá apresentar struts ou gwt.
				if( result.getData().size() == 0 ){
					SC.say(Tradutor.i18n.msgUsuarioNaoTemPrivilegio()+" : "+programCode);
				}
				else{
					String[] row = result.getData().get(0);
					
					corpo 	  			= row[0];
					cod_layout 			= row[1];
					nomeLayout 			= row[2];
					tp_funcao  			= row[3];
					comando	   			= row[4];
					nome_programa_en 	= row[5];
					nome_programa_pt_BR = row[6];	
					
					// Se corpo for null ou branco seta para 001 - Corpo padrão
					if ( HowMGWTUtilities.isEmpty(corpo) )
						corpo = "001";
					
					// Se nome do Layout não informado.
					if ( HowMGWTUtilities.isEmpty(nomeLayout)){
						// Se houver ação atribuida, executa a ação
						if ( getStrutsAction() != null ){
							showReportWindow(getStrutsAction());
						}
						// Caso contrório executa o relatório no servidor.
						else{
							setWidth("950");
							setHeight("650");
							executeReportServer();
						}
					}
					else{
						// Verfica se o layout é GWT, se form executa o relatório no servidor.
						if ( "GWT".equals( nomeLayout ) ){
							setWidth("950");
							setHeight("650");
							executeReportServer();
						}
						// Se não for GWT e a ação struts estiver informada, então executa a ação struts.
						else if ( ! HowMGWTUtilities.isEmpty(getStrutsAction()) ){
							showReportWindow(getStrutsAction());
						}
						// Se não for nenhuma das condições acima executa o relatório.
						else{
							setWidth("950");
							setHeight("650");
							executeReportServer();
						}
					}
				}
			}
			
			@Override
			public boolean onFailure(Throwable caught) {				 
				SC.say(caught.getMessage());
				caught.printStackTrace();
				return true;
			}
		});
		
	}	
	
	public void executeReportServer(){
		// Cria a entidade 
		HowMGWTEntity entity = Fabrica.createEntity();		
		if ( ! onHowMExecuteReport(entity) )
			return;
		
		Fabrica.createParameter(entity, Fabrica.DEFAULT_REPORT_VISUALIZER 	, Fabrica.REPORT_EXPORT_PDF );

		String url =Configuracao.getNativeUnoUrlServiceDonwload();
		final String urlLocator = url;

		HowMGWTWindowWait.showWait();
		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
			
				public void onFailure(Throwable caught) {
					HowMGWTWindowWait.hideWait();		
					caught.printStackTrace();
					com.google.gwt.user.client.Window.alert(Tradutor.i18n.formEnderecoBase()+GWT.getHostPageBaseURL()+"\n"+caught.getMessage());
				}

				public void onSuccess(HowMGWTEntity result) {					
					
					Logger logger = Logger.getLogger("");
					
					// Recupera o endereço do relatório gerado.
					HowMProperty reportURL = result.getParameters().get("reportURL");

					logger.log(Level.ALL, "URL Locator: " + urlLocator);
					
					String url = urlLocator+"/"+reportURL.getValue();
				
					logger.log(Level.ALL, "URL: " + url);
					
//					String urlPreview = "";
					
//					urlPreview += Configuracao.getNativeUnoUrlServiceDonwload();
//					urlPreview += "/UnoGWTReportPreview.jsp";
//					urlPreview += "?GWT_PROGRAMA="+programCode;
//					urlPreview += "&GWT_TITLE="+nome_programa_pt_BR;
//					urlPreview += "&GWT_CORPO="+corpo;
//					urlPreview += "&GWT_VERSAO_PROGRAMA=01";
//					urlPreview += "&GWT_VERSAO_CORPO=01";
//					urlPreview += "&GWT_URL="+url;
										
					HowMGWReportViewerWindow reportViewer = new HowMGWReportViewerWindow();
					reportViewer.setWidth(getWidth()+"px");
					reportViewer.setHeight(getHeight()+"px");
					reportViewer.showReport(url,programCode, nome_programa_pt_BR, result);
					
					Timer timer = new Timer() {

						@Override
						public void run() {
							HowMGWTWindowWait.hideWait();
						}
					};
					timer.schedule(10);
					// showReportWindow(urlPreview);
				}
		};
				
		entity.setAction(Services.acaoExecuteReport);
				 
		Configuracao.getProxyStruts().executeQuery(entity, callback);		
	}
	
	/**
	 * Apresenta o resultado do relatório em uma nova janela.
	 * @param url
	 */
	public void showReportWindow(String url ){

		String feature = "";
		feature += "left=100, ";
		feature += "top=50, "; 

		if ( getWidth() == null )
			setWidth("940");
		
		if ( getHeight() == null )
			setHeight("650");
		
		feature += "width="+getWidth()+", ";
		feature += "height="+getHeight()+", ";

		feature += "location=0, ";
		feature += "toolbar=0, ";
		feature += "address=0, ";
		feature += "center=0, ";
		feature += "menubar=0, ";
		feature += "personalbar=0, ";
		feature += "directories=0, ";
		feature += "status=1, ";
		feature += "resizable=1, ";
		feature += "dependent=1 ";
//
//		// Window.alert("Feature : "+feature );
//
////		feature += "dom.disable_window_open_feature.menubar, ";
////		feature += "dom.disable_window_open_feature.toolbar, ";
////		feature += "dom.disable_window_open_feature.location, ";
////		feature += "dom.disable_window_open_feature.personalbar, ";
		
		Logger logger = Logger.getLogger("");
		logger.log(Level.ALL, "URL: " + url);
		
//
		com.google.gwt.user.client.Window.open(url, this.programCode , feature );
	
//		HowMGWReportViewerWindow reportViewer = new HowMGWReportViewerWindow();
//		reportViewer.setWidth(getWidth()+"px");
//		reportViewer.setHeight(getHeight()+"px");
//		reportViewer.showReport(url,programCode, nome_programa_pt_BR,null);
		
	}
	
	

	/**
	 * Sobrepor método para implementar a passagem de parametros para execução da consulta.
	 * @param entity Entidade onde serão adicionados os parametros.
	 * @return Retorn true se o relatório deverá ser executado, caso contrório retornar
	 * false e mostrar mensagem para o usuório caso a validação do relatório não permita 
	 * a execução.
	 */
	protected abstract boolean onHowMExecuteReport(HowMGWTEntity entity);


	/**
	 * @return the programCode
	 */
	public String getProgramCode() {
		return programCode;
	}


	/**
	 * @param programCode the programCode to set
	 */
	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}


	/**
	 * @return the strutsAction
	 */
	public String getStrutsAction() {
		return strutsAction;
	}


	/**
	 * @param strutsAction the strutsAction to set
	 */
	public void setStrutsAction(String strutsAction) {
		this.strutsAction = strutsAction;
	}

}
