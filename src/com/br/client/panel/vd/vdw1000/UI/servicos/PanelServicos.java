package com.br.client.panel.vd.vdw1000.UI.servicos;

import java.util.LinkedHashMap;

import com.br.client.model.vd.entity.eNFSEEmitenteWS;
import com.br.client.model.vd.entity.eNFSEServicesConfiguration;
import com.br.client.model.vd.vdw1000.FormBean;
import com.howmake.client.form.UI.HowMGWTPanelDocumentBar;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

public class PanelServicos extends VLayout{

	private eNFSEEmitenteWS currentEntityEmitente;
	private eNFSEServicesConfiguration currentServicesConfiguration;
	
	HowMGWTFormProperties properties = new HowMGWTFormProperties();

	HowMGWTProperty propertyInicializarServicoAgendamento 			= properties.createProperty("iniciarServicoAgendamento", 			"Serviço de Agendamento ?");
	// HowMGWTProperty propertyInicializarServicoWorkflow 	  		= properties.createProperty("iniciarServicoWorkflow"   , 			"Serviço de Workflow ?");

	HowMGWTProperty propertyUltimaDataInicializacaoAgendamento 		= properties.createProperty("ultimaDataInicializacaoAgendamento", 	"Data da última inicialização Serviço de Agendamento");
	// HowMGWTProperty propertyUltimaDataInicializacaoWorkflow		= properties.createProperty("ultimaDataInicializacaoWorkflow", "Data da última inicialização Serviço de Workflow");
	
	HowMGWTProperty propertyNmInstanciaServicos						= properties.createProperty("nmInstanciaServico", 					"Nome da Instância do Serviço");	
	HowMGWTProperty propertyDataUltimaAlteracao						= properties.createProperty("ultimaAlteracao", 						"Data da última Atualização");
	
	HowMGWTProperty propertyUltimaRPSEmitida						= properties.createProperty("nrUltimaRPSEmitida", 					"Ultima RPS Emitida");
	HowMGWTProperty propertyModoMonitoramento						= properties.createProperty("modoMonitoramento", 					"Modo Monitoramento");

	ToolStripButton actionSave = new ToolStripButton();
	ToolStripButton actionCriarSchedulerMonitoramento = new ToolStripButton();
	ToolStripButton actionMonitoramentoManual	      = new ToolStripButton();
	
	public PanelServicos(){
	
		this.setWidth100();
		this.setHeight100();
		
		int wLabel = 275;

		VLayout formLayout = new VLayout();
		formLayout.setWidth100();
		formLayout.setHeight100();
				
		
		propertyNmInstanciaServicos.setBound(wLabel, 200);
		propertyNmInstanciaServicos.createHowMGWTFormFieldTextItem();
		formLayout.addMember(propertyNmInstanciaServicos.getCanvas());
		propertyNmInstanciaServicos.getCanvas().setDisabled(true);

		propertyDataUltimaAlteracao.setBound(wLabel, 90);
		propertyDataUltimaAlteracao.createHowMGWTFormFieldTextItem();
		formLayout.addMember(propertyDataUltimaAlteracao.getCanvas());
		propertyDataUltimaAlteracao.getCanvas().setDisabled(true);		

		propertyInicializarServicoAgendamento.setBound(wLabel, 90);
		propertyInicializarServicoAgendamento.createHowMGWTFormFieldSelectItem();
		formLayout.addMember(propertyInicializarServicoAgendamento.getCanvas());

		propertyUltimaDataInicializacaoAgendamento.setBound(wLabel, 130);		
		propertyUltimaDataInicializacaoAgendamento.createHowMGWTFormFieldTextItem();
		formLayout.addMember(propertyUltimaDataInicializacaoAgendamento.getCanvas());
		propertyUltimaDataInicializacaoAgendamento.getCanvas().setDisabled(true);

//		propertyInicializarServicoWorkflow.setBound(wLabel, 90);
//		propertyInicializarServicoWorkflow.createHowMGWTFormFieldSelectItem();
//		formLayout.addMember(propertyInicializarServicoWorkflow.getCanvas());		
//
//		propertyUltimaDataInicializacaoWorkflow.setBound(wLabel, 130);		
//		propertyUltimaDataInicializacaoWorkflow.createHowMGWTFormFieldTextItem();
//		formLayout.addMember(propertyUltimaDataInicializacaoWorkflow.getCanvas());
//		propertyUltimaDataInicializacaoWorkflow.getCanvas().setDisabled(true);

		LinkedHashMap< String , String > mapSimNao = new LinkedHashMap<String, String>();
		mapSimNao.put("1", "Inicializado");
		mapSimNao.put("0", "Parado");		

		propertyInicializarServicoAgendamento.getHowMGWTEditorSelectItem().getField().setValueMap(mapSimNao);

		propertyUltimaRPSEmitida.setBound(wLabel, 60);		
		propertyUltimaRPSEmitida.createHowMGWTFormFieldTextItem();
		formLayout.addMember(propertyUltimaRPSEmitida.getCanvas());	
		
		propertyModoMonitoramento.setBound(wLabel, 250);
		propertyModoMonitoramento.createHowMFieldSelectItem();

		LinkedHashMap<String, String> mapModoMonitoramento = new LinkedHashMap<String, String>();
		mapModoMonitoramento.put("0", "Monitoramento Manual");
		mapModoMonitoramento.put("1", "Monitoramento Automático");
		propertyModoMonitoramento.getHowMFieldSelectItemEditor().getField().setValueMap(mapModoMonitoramento);
		propertyModoMonitoramento.getHowMFieldSelectItemEditor().getField().setCanEdit(false);
		formLayout.addMember(propertyModoMonitoramento.getCanvas());
		propertyModoMonitoramento.setHowmFormValue("1");

		this.addMember(formLayout);

		ToolStrip tools = new ToolStrip();
		tools.setWidth100();
		tools.setHeight(26);
		tools.setAlign(Alignment.CENTER);

		
		actionSave.setTitle("Aplicar");
		actionSave.setIcon("actions/save.png");
		actionSave.setPrompt("Inicializa ou para os serviços do sistema");		
		tools.addMember(actionSave);
		this.actionSave.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				saveConfigureServicos();
			}
		});
		
		
		
		actionCriarSchedulerMonitoramento.setTitle("Monitoramento Automático");
		actionCriarSchedulerMonitoramento.setIcon("nfe/nfe_refresh.png");
		actionCriarSchedulerMonitoramento.setPrompt("Cria uma tarefa para realizar o monitoramento das RPS emitidas automaticamente");		
		tools.addMember(actionCriarSchedulerMonitoramento);
		this.actionCriarSchedulerMonitoramento.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				criarTarefaParaMonitoramento();
			}
		});
		
		
		actionMonitoramentoManual.setTitle("Monitoramento Manual");
		actionMonitoramentoManual.setIcon("nfe/nfe_refresh.png");
		actionMonitoramentoManual.setPrompt("Passa o processamento automático para modo Manual, no modo Manual, o usuório seleciona as RPS que desenja enviar para a prefeitura...");		
		tools.addMember(actionMonitoramentoManual);
		this.actionMonitoramentoManual.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				criarMonitoramentoManual();
			}
		});		
		
		this.addMember(tools);
	}

	public void showServicos(eNFSEEmitenteWS currentEntityEmitente){
		this.currentEntityEmitente = currentEntityEmitente;
		loadServicos();
	}	
	
	
	/**
	 * Carrega as configurações dos serviços de Workflow e Agendamento.
	 */
	public void loadServicos(){

		currentServicesConfiguration = null;
		
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				
				if( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ){
					return;
				}
				FormBean bean = (FormBean) formBean;
				
				currentServicesConfiguration = bean.getEntityServicesConfiguration();
				if( HowMGWTUtilities.isEmpty( bean.getEntityServicesConfiguration().getStartSchedulerJobs() ) ){
					propertyInicializarServicoAgendamento.setHowmFormValue( "0" );
				}
				else{
					propertyInicializarServicoAgendamento.setHowmFormValue( bean.getEntityServicesConfiguration().getStartSchedulerJobs() );
				}
				
				propertyUltimaDataInicializacaoAgendamento.setHowmFormValue(bean.getEntityServicesConfiguration().getStartSchedulerJobsDate());					

				
				propertyUltimaRPSEmitida.setHowmFormValue(bean.getEntityServicesConfiguration().getBasePath());
				propertyNmInstanciaServicos.setHowmFormValue(bean.getEntityServicesConfiguration().getInstanceNameScheduler());
				propertyDataUltimaAlteracao.setHowmFormValue(bean.getEntityServicesConfiguration().getDateChange());
				
				propertyUltimaRPSEmitida.setHowmFormValue(bean.getNrUltimaRPSEmitida());
				
				propertyModoMonitoramento.setHowmFormValue(bean.getIndSendAutomatic());
			}
		};
		FormBean bean = new FormBean();
		struts.request("vdw1000.do?method=loadConfigureServicos", "VDW1000Form", bean.toSendBody(""));
	}

	
	public void saveConfigureServicos(){
		HowMGWTWindowWait.showWait("Aguarde atualizando serviços..");
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				
				if( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ){
					return;
				}
				
				// TODO Auto-generated method stub
				FormBean bean = (FormBean) formBean;
				SC.say("Serviço atualizado com sucesso ...");				
			}			
		};
		FormBean bean = new FormBean();
		bean.setEntityServicesConfiguration(currentServicesConfiguration);
		
		bean.getEntityServicesConfiguration().setStartSchedulerJobs( propertyInicializarServicoAgendamento.getHowmFormValueToString() );
		bean.setNrUltimaRPSEmitida(propertyUltimaRPSEmitida.getHowmFormValueToString());					
				
		struts.request("vdw1000.do?method=saveConfigureServicos", "VDW1000Form", bean.toSendBody(""));		
	}
	
	
	
	public void criarTarefaParaMonitoramento(){
		HowMGWTWindowWait.showWait("Aguarde criando tarefa para monitoramento...");
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				
				if( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ){
					return;
				}
				
				FormBean bean = (FormBean) formBean;
				SC.say("Tarefa para monitoramento de RPS, criada com sucesso ...");
				
				propertyModoMonitoramento.setHowmFormValue(bean.getIndSendAutomatic());
			}			
		};
		FormBean bean = new FormBean();
				
		struts.request("vdw1000.do?method=criarJobMonitoraEmpresaEnvioRPSPrefeitura", "VDW1000Form", bean.toSendBody(""));				
	}
	
	
	public void criarMonitoramentoManual(){
		HowMGWTWindowWait.showWait("Aguarde configurando monitoramento Manual...");
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				
				if( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ){
					return;
				}
				
				FormBean bean = (FormBean) formBean;
				SC.say("Monitoramento Manual configurado com sucesso ...");				
				
				propertyModoMonitoramento.setHowmFormValue(bean.getIndSendAutomatic());
			}			
		};
		FormBean bean = new FormBean();
				
		struts.request("vdw1000.do?method=configuraModoManual", "VDW1000Form", bean.toSendBody(""));				
	}	
}