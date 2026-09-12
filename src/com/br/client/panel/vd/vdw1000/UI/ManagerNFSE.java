package com.br.client.panel.vd.vdw1000.UI;

import com.br.client.configuracao.Configuracao;
import com.br.client.model.vd.vdw1000.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.UIPartner;
import com.br.client.panel.vd.vdw1000.UI.servicos.WindowConfiguracaoServicos;
import com.google.gwt.core.client.Scheduler;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.widgets.layout.VLayout;

public class ManagerNFSE extends VLayout implements UIPartner{
	
	private PanelResultadoConsulta painelResultado;
	
	@Override
	public void start() {	 
		
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {			
			@Override
			public void execute() {
				loadConfiguracao();				
			}
		});
	}

	
	
	public String getHowMGWTTitle(){
		return Tradutor.i18n.formTituloVDW1000();
	}

	public String getHowMGWTPrograma(){
		return "VDW1000";
	}	
	
	
	
	
	
	/**
	 * Carrega as configurações para envio de RPS.
	 */
	public void loadConfiguracao(){		
		HowMGWTWindowWait.showWait("Aguarde inicializando WebServices...");

		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {

				// Se der erro apresenta o erro e finaliza o componente
				if( HowMGWTControl.isRefreshFormShowMessage(formBean, true)){					
					return;
				}
				
				FormBean form = (FormBean)formBean;
				HowMGWTWindowWait.hideWait();
				
				// Se o emitente não encontrado,  então direciona para a versão antiga
				// do gerenciador de RPS.
				if( form.getEntityEmitenteWS() == null ){
					setVisible(false);
					onShowVersaoOLDNFSE();
					return;
				}
				
				// Se a configuração da consulta não configurada, então direciona para a versão antiga
				// do gerenciador de RPS. 
				if( form.getEntityEmitenteWS().getEntityConsultaWS() == null ){
					setVisible(false);
					onShowVersaoOLDNFSE();
					return;					
				}
				
				String nmModulo = form.getEntityEmitenteWS().getEntityConsultaWS().getNmModuloIntegracao();
				
				// Se módulo não informado então direciona para a versão antiga
				// do gerenciador de RPS.
				if( HowMGWTUtilities.isEmpty( nmModulo ) ){
					setVisible(false);
					onShowVersaoOLDNFSE();
					return;					
				}
				
				// Se módulo diferente de VDW1000, então redireciona para a versão antiga 
				// do gerenciador de RPS.
				if ( ! getHowMGWTPrograma().equalsIgnoreCase(nmModulo)){
					setVisible(false);
					onShowVersaoOLDNFSE();
					return;					
				}

				painelResultado = new PanelResultadoConsulta();
				addMember(painelResultado);
				painelResultado.getFiltroConsulta().configureSistema(form);
				painelResultado.onConfigureSistema(form.getCodEmitente(), form.getEntityEmitenteWS() );
			}
		};
		FormBean bean = new FormBean();
		bean.setCodEmpresa(Configuracao.getCodEmpresa());
		struts.request("vdw1000.do?method=configuracao",  "VDW1000Form", bean.toSendBody("") );		
	}
	
	protected void onShowVersaoOLDNFSE(){};
}
