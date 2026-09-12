package com.br.client.panel.vd.vdw1000.UI;


import com.br.client.configuracao.Configuracao;
import com.br.client.model.vd.entity.eNFSE;
import com.br.client.model.vd.entity.eNFSEEmitenteWS;
import com.br.client.model.vd.vdw1000.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.ed.edw0004.UI.WindowHistorico;
import com.br.client.panel.vd.vdw1000.util.NFSEUtilities;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Window;
import com.howmake.client.form.UI.HowMGWTFormToolbarEdit;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.UI.HowMGWTWindowDocumentHTML;
import com.howmake.client.form.UI.HowMGWTWindowDocumentHTMLResume;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.control.HowMGWTControlForm;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;


public class PanelResultadoConsulta  extends VLayout implements HowMGWTControlForm {

	private String usuarioG2KA;
	private String senhaG2KA;

	public String getSenhaG2KA() {
		return senhaG2KA;
	}
	public void setSenhaG2KA(String senhaG2KA) {
		this.senhaG2KA = senhaG2KA;
	}
	public String getUsuarioG2KA() {
		return usuarioG2KA;
	}

	public void setUsuarioG2KA(String usuarioG2KA) {
		this.usuarioG2KA = usuarioG2KA;
	}

	private WindowHistorico windowHistorico;
	private String lastMotivoCancelamento;
	
	private WindowMotivoCancelamento windowMotivoCancelamento = new WindowMotivoCancelamento(){

		@Override
		public void onConfirmar(String motivo) {
			lastMotivoCancelamento = motivo;
						
			SC.ask("Reabrir Pedido", "Deseja reabrir o pedido após o cancelamento ? ", new BooleanCallback() {
				
				@Override
				public void execute(Boolean value) {					
					cancelarEnvioRPS(lastMotivoCancelamento, HowMGWTUtilities.getString(HowMGWTUtilities.getBoolean(value)));					
				}
			});			
		};
	};			
	
	private String codEmpresa;
	private String operacao; 
	private String dtInicio;
	private String dtFim;
	private String codPlano;
	private String codRPS;
	private String codPedido;
	private String nomeCliente;
	private String codNotaFiscal;
	
	private eNFSEEmitenteWS currentEmitenteWS;
	private String currentCodEmitente;
	
	public String getCurrentCodEmitente() {
		return currentCodEmitente;
	}

	public void setCurrentCodEmitente(String currentCodEmitente) {
		this.currentCodEmitente = currentCodEmitente;
	}

	public eNFSEEmitenteWS getCurrentEmitenteWS() {
		return currentEmitenteWS;
	}

	public void setCurrentEmitenteWS(eNFSEEmitenteWS currentEmitenteWS) {
		this.currentEmitenteWS = currentEmitenteWS;
	}



	private ListGridRecord currentRecord;
	
	private PanelRibbonBarRPS filtroConsulta = new PanelRibbonBarRPS() {

		public void onSuporteInteligente() {
			
		};
		
		@Override
		protected void onExecuteOperacao(String operacao, String dtInicio, String dtFim, String codPlano, String codRPS, String codPedido, String nomeCliente, String codNotaFiscal){			
			load(Configuracao.getCodEmpresa(), operacao,  dtInicio, dtFim, codPlano, codRPS, codPedido, nomeCliente, codNotaFiscal);			
		}
		
		@Override
		protected void onMonitorG2KA() {
			// panelMonitorG2KA.onShowMonitor();
			Window.open("http://sorocaba.unoerp.com.br:6060/nfse?usuario="+getUsuarioG2KA()+"&senha="+getSenhaG2KA(), "Monitor de RPS-NeoGrid", "height=660px,width=960px ,directories=no,location=no,toolbar=no,menubar=no");
		}

		@Override
		protected void onEnviarRPSProcessamento() {
			onEnviarRPSProcessamentoImpl();			
		};
		
		@Override
		protected void onShowSelect(boolean selected) {
			if( selected ){				
				panelGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
			}
			else{
				panelGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
			}
		}
		
		@Override
		protected void onCancelarEnvioRPS() {
			
			ListGridRecord[] records = panelGrid.getSelectedRecords();

			if( records.length == 0 ){
				SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServicoProc());
				return;
			}
			windowMotivoCancelamento.show();
		};
		
		
		protected void onShowHistorico(){
			PanelResultadoConsulta.this.onShowHistorico();
		}
		
		protected void onSendMail() {

			ListGridRecord[] records = panelGrid.getSelectedRecords();
			
			if( records.length == 0 ){
				SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServicoProc());
				return;
			}
			PanelResultadoConsulta.this.onSendMail();
			
		};
		
		protected void onForcarSincronismoRPS() {
			ListGridRecord[] records = panelGrid.getSelectedRecords();
			
			if( records.length == 0 ){
				SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServicoProc());
				return;
			}
			PanelResultadoConsulta.this.onForcarSincronismoRPS();					
		};
		
		
		@Override
		protected void onVisualizarNFSePrefeitura() {
			ListGridRecord[] records = panelGrid.getSelectedRecords();

			if( records.length == 0 ){
				SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServicoProc());
				return;
			}
			
			PanelResultadoConsulta.this.onVisualizarNFSePrefeitura();
			
		};
		
		
		protected void onShowPainelAdministratorAccess() {
			ListGridRecord[] records = panelGrid.getSelectedRecords();

			if( records.length == 0 ){
				SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServicoProc());
				return;
			}
			
			PanelResultadoConsulta.this.onVisualizarAdministracao();
						
		};
		
//		@Override
//		protected void onRegerarReenviarRPS(){
//			PanelResultadoConsulta.this.onRegerarReenviarRPS();
//		}
		
		@Override
		protected void onAnalisarRPS() {
			PanelResultadoConsulta.this.onAnalisarRPS();
		}
		
		@Override
		protected void onDownloadAI() {
			PanelResultadoConsulta.this.onDownloadAI();
		}
 	};		
	
	
	private VLayout mainLayout = new VLayout();


	private PanelHistorico panelHistorico = new PanelHistorico();
	// private PanelG2KA panelMonitorG2KA;

  	private HowMGWTFormToolbarEdit formToolbarEdit;

	private HowMGWTFormProperties properties = new HowMGWTFormProperties();

	private HowMGWTProperty propertyFlagEnvio 				= properties.createProperty("flagEnvio"					, "Status"					 );

	private HowMGWTProperty propertyCodNotaFiscal			= properties.createProperty("codNotaFiscal"				,Tradutor.i18n.formCodNFERP());

	
	private HowMGWTProperty propertynrRps					= properties.createProperty("nrRps"						,Tradutor.i18n.formNrRps());

	private HowMGWTProperty propertyCodPedido				= properties.createProperty("codPedido"					,Tradutor.i18n.formCodPedido()); 



	private HowMGWTProperty propertyDataEmissao				= properties.createProperty("dataEmissao"				,Tradutor.i18n.formDtEmissao());
	
	private HowMGWTProperty propertySituacao				= properties.createProperty("situacao"					,Tradutor.i18n.formSituacao());
	private HowMGWTProperty propertyDescSituacao			= properties.createProperty("descSituacao"				,Tradutor.i18n.formSituacao()+" ERP");

	
	private HowMGWTProperty propertyCnpjPrestador			= properties.createProperty("cnpjPrestador"				,Tradutor.i18n.formCnpjPrestador());
	private HowMGWTProperty propertyNomeCliente				= properties.createProperty("nomeCliente"				,Tradutor.i18n.formClienteTomador());	
	
	// private ListGridField fieldValor		= new ListGridField("valor", 		Tradutor.i18n.formValor(), 		80);	// 7
	// private ListGridField fieldToolbar      = new ListGridField("toolbar",      " ",						    100);	// 8
	private HowMGWTProperty propertyCodNumeroNF				= properties.createProperty("codNumeroNF"				,"Numero NF");// 9
	private HowMGWTProperty propertyNomeArqNF    			= properties.createProperty("nomeArquivoNFe"					,"Arq NF");		// 10
	private HowMGWTProperty propertyRegistro     			= properties.createProperty("registro"					,"registro");	// 11
	private HowMGWTProperty propertyIdNfse					= properties.createProperty("idNfse"					,Tradutor.i18n.formID());
	private HowMGWTProperty propertyIdAtividade				= properties.createProperty("idAtividade"				,Tradutor.i18n.formIdAtividade());
	private HowMGWTProperty propertyIconAtividade			= properties.createProperty("IconAtividade"				,Tradutor.i18n.formSituacao()+" RPS"); // 14
	
	private HowMGWTProperty propertySituacaoIntegracao		= properties.createProperty("descSituacaoIntegracao"	,Tradutor.i18n.formSituacaoIntegracao()); // 14
	
	private HowMGWTProperty propertyNrNfseWs				= properties.createProperty("nrNfseWs"					,Tradutor.i18n.formNrNfseWs());
	
	private HowMGWTProperty propertySerie					= properties.createProperty("serie"						,Tradutor.i18n.formSerie());

	private HowMGWTProperty propertyRegistroUI				= properties.createProperty("RegistroUI"				,"#Reg.");	// 16
	

	private HowMGWTProperty propertyIndEnvCancelamento		= properties.createProperty("indEnvCancelamento"				,"");	// 16
	private HowMGWTProperty propertyDtEnvioCancelamento		= properties.createProperty("dtEnvioCancelamento"				,"");	// 16
	

	private HowMGWTProperty propertyDtInclusao				= properties.createProperty("dtInclusao"				,Tradutor.i18n.formDtInclusao());
	private HowMGWTProperty propertyDtCancelamento			= properties.createProperty("dtCancelamento"			,Tradutor.i18n.formDtCancelamento());
	private HowMGWTProperty propertyNmAtividade				= properties.createProperty("nmAtividade"				,Tradutor.i18n.formSituacao());
	private HowMGWTProperty propertyIdProtocolo				= properties.createProperty("idProtocolo"				,Tradutor.i18n.formNrProtocoloRecebimentoWs()); 
	private HowMGWTProperty propertyCodEmpresa				= properties.createProperty("codEmpresa"				,Tradutor.i18n.formCodEmpresa());
	private HowMGWTProperty propertyNrProtocoloRecebimentoWs= properties.createProperty("nrProtocoloRecebimentoWss"	,Tradutor.i18n.formNrProtocoloRecebimentoWs());
	private HowMGWTProperty propertyChave					= properties.createProperty("chave"						,Tradutor.i18n.formChave());
	
	
 	private HowMGWTListGrid panelGrid = new HowMGWTListGrid()
 	{
 		/**
 		 * Formata os campos da grid.
 		 */
 		@Override
 		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
 			if( getFieldName(colNum).equals(propertySituacaoIntegracao.getName()) ){
 				if( "1".equals( propertyIndEnvCancelamento.getHowMValue(record) ) ){
 					return "color:red;";
 				}
 			}
 			return super.getCellCSSText(record, rowNum, colNum);
 		};
 		
 		protected String getCellStyle(ListGridRecord record, int rowNum, int colNum) {
 			return super.getCellStyle(record, rowNum, colNum);
 		};
 		 		
 	};
 
	public PanelResultadoConsulta(){
		
		this.addMember(filtroConsulta);
		
		panelGrid.setCanSelectText(true);
		panelGrid.setShowRecordComponents(true);          
		panelGrid.setShowRecordComponentsByCell(true);  
		
		panelGrid.setWrapCells(true);  
		panelGrid.setFixedRecordHeights(false); 
	   
		
		propertyCodNotaFiscal.setType(ListGridFieldType.TEXT);		
		propertyCodNotaFiscal.setWidthColumn(70);		 
		propertyCodNotaFiscal.createHowMGWTListGridField();
		propertyCodNotaFiscal.getListField().setWrap(true);
		
		// propertyCodNotaFiscal.getListField().setHidden(true);

		
		/**
		 * ----------------------------------------------------------------------
		 * Cria a grid para listagem das solicitações de devolução
		 * ----------------------------------------------------------------------
		 */
		
		
		propertyFlagEnvio.setType(ListGridFieldType.TEXT);
		propertyFlagEnvio.setWidthColumn(40);
		propertyFlagEnvio.createHowMGWTListGridField();		

		propertyFlagEnvio.getListField().setAlign(Alignment.CENTER);  
		propertyFlagEnvio.getListField().setType(ListGridFieldType.IMAGE);  
		propertyFlagEnvio.getListField().setImageURLPrefix("nfe/"); 
		propertyFlagEnvio.getListField().setImageURLSuffix(".png"); 		

		
		
		propertyCodPedido.setType(ListGridFieldType.INTEGER);
		propertyCodPedido.setWidthColumn(66);		 
		propertyCodPedido.createHowMGWTListGridField();
		propertyCodPedido.getListField().setWrap(true);

		propertyCodPedido.getListField().setCellFormatter(new CellFormatter() {
			
			@Override
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
				if( HowMGWTUtilities.getInteger(value) == 0 ){
					return "";
				}
				else{
					return value.toString();
				}
			}
		});
		
		propertyDataEmissao.setType(ListGridFieldType.DATE);
		propertyDataEmissao.setWidthColumn(90);		 
		propertyDataEmissao.createHowMGWTListGridField();
		propertyDataEmissao.getListField().setWrap(true);
		
		/**
		 * Indica se o registro está P-Pendente E-Enviado
		 */
		propertySituacao.setType(ListGridFieldType.TEXT);
		propertySituacao.setWidthColumn(80);		 
		propertySituacao.createHowMGWTListGridField();
		propertySituacao.getListField().setWrap(true);
		propertySituacao.getListField().setCanHide(true);
		propertySituacao.getListField().setHidden(true);
		
		
		/**
		 * Descrição da situação da nota fiscal no UCommerce
		 */
		propertyDescSituacao.setType(ListGridFieldType.TEXT);
		propertyDescSituacao.setWidthColumn(80);
		propertyDescSituacao.createHowMGWTListGridField();
		propertyDescSituacao.getListField().setWrap(true);
		
		propertyCodNumeroNF.setType(ListGridFieldType.TEXT);
		propertyCodNumeroNF.setWidthColumn(80);		 
		propertyCodNumeroNF.createHowMGWTListGridField();
		propertyCodNumeroNF.getListField().setWrap(true);
		propertyCodNumeroNF.getListField().setHidden(true);

		propertyNomeArqNF.setType(ListGridFieldType.TEXT);
		propertyNomeArqNF.setWidthColumn(80);		 
		propertyNomeArqNF.createHowMGWTListGridField();
		propertyNomeArqNF.getListField().setWrap(true);
		propertyNomeArqNF.getListField().setHidden(true);

		propertyRegistro.setType(ListGridFieldType.TEXT);
		propertyRegistro.setWidthColumn(70);		 
		propertyRegistro.createHowMGWTListGridField();
		propertyRegistro.getListField().setWrap(true);
		propertyRegistro.getListField().setHidden(true);

		propertyIconAtividade.setType(ListGridFieldType.TEXT);
		propertyIconAtividade.setWidthColumn(50);		 
		propertyIconAtividade.createHowMGWTListGridField();
		propertyIconAtividade.getListField().setWrap(true);
		
		propertyIconAtividade.getListField().setAlign(Alignment.CENTER);  
		propertyIconAtividade.getListField().setType(ListGridFieldType.IMAGE);  
		propertyIconAtividade.getListField().setImageURLPrefix("");  
		propertyIconAtividade.getListField().setImageURLSuffix(""); 		

		
		propertySituacaoIntegracao.setType(ListGridFieldType.TEXT);
		propertySituacaoIntegracao.setWidthColumn(120);		 
		propertySituacaoIntegracao.createHowMGWTListGridField();
		propertySituacaoIntegracao.getListField().setWrap(true);

		
		

		propertyIdProtocolo.setType(ListGridFieldType.INTEGER);		
		propertyIdProtocolo.setWidthColumn(50);		 
		propertyIdProtocolo.createHowMGWTListGridField();
		propertyIdProtocolo.getListField().setWrap(true);
		propertyIdProtocolo.getListField().setHidden(true);

		propertyDtInclusao.setType(ListGridFieldType.TEXT);		
		propertyDtInclusao.setWidthColumn(115);		 
		propertyDtInclusao.createHowMGWTListGridField();
		propertyDtInclusao.getListField().setWrap(true);
		propertyDtInclusao.getListField().setHidden(true);		
		
		propertyDtCancelamento.setType(ListGridFieldType.TEXT);
		propertyDtCancelamento.setWidthColumn(115);
		propertyDtCancelamento.createHowMGWTListGridField();
		propertyDtCancelamento.getListField().setWrap(true);
		propertyDtCancelamento.getListField().setHidden(true);
		
		propertyIdNfse.setType(ListGridFieldType.TEXT);		
		propertyIdNfse.setWidthColumn(50);		 
		propertyIdNfse.createHowMGWTListGridField();
		propertyIdNfse.getListField().setWrap(true);
		propertyIdNfse.getListField().setHidden(true);

		propertyCodEmpresa.setType(ListGridFieldType.TEXT);		
		propertyCodEmpresa.setWidthColumn(90);		 
		propertyCodEmpresa.createHowMGWTListGridField();
		propertyCodEmpresa.getListField().setWrap(true);
		propertyCodEmpresa.getListField().setHidden(true);
				


		propertyCnpjPrestador.setType(ListGridFieldType.TEXT);		
		propertyCnpjPrestador.setWidthColumn(120);		 
		propertyCnpjPrestador.createHowMGWTListGridField();
		propertyCnpjPrestador.getListField().setWrap(true);
		propertyCnpjPrestador.getListField().setHidden(true);

		propertyRegistroUI.setType(ListGridFieldType.TEXT);		
		propertyRegistroUI.setWidthColumn(40);		 
		propertyRegistroUI.createHowMGWTListGridField();
		propertyRegistroUI.getListField().setWrap(true);
		
		
		propertynrRps.setType(ListGridFieldType.TEXT);		
		propertynrRps.setWidthColumn(50);		 
		propertynrRps.createHowMGWTListGridField();
		propertynrRps.getListField().setWrap(true);
		// propertynrRps.getListField().setHidden(true);
		
		propertyNrProtocoloRecebimentoWs.setType(ListGridFieldType.TEXT);		
		propertyNrProtocoloRecebimentoWs.setWidthColumn(110);		 
		propertyNrProtocoloRecebimentoWs.createHowMGWTListGridField();
		propertyNrProtocoloRecebimentoWs.getListField().setWrap(true);
		propertyNrProtocoloRecebimentoWs.getListField().setHidden(true);

		propertyChave.setType(ListGridFieldType.TEXT);		
		propertyChave.setWidthColumn(200);		 
		propertyChave.createHowMGWTListGridField();
		propertyChave.getListField().setWrap(true);
		propertyChave.getListField().setHidden(true);
		
		
		propertyIdAtividade.setType(ListGridFieldType.TEXT);		
		propertyIdAtividade.setWidthColumn(90);		 
		propertyIdAtividade.createHowMGWTListGridField();
		propertyIdAtividade.getListField().setWrap(true);
		propertyIdAtividade.getListField().setHidden(true);

		propertyNrNfseWs.setType(ListGridFieldType.TEXT);		
		propertyNrNfseWs.setWidthColumn(50);		 
		propertyNrNfseWs.createHowMGWTListGridField();
		propertyNrNfseWs.getListField().setWrap(true);
		

		propertySerie.setType(ListGridFieldType.TEXT);		
		propertySerie.setWidthColumn(40);		 
		propertySerie.createHowMGWTListGridField();
		propertySerie.getListField().setWrap(true);
		// propertySerie.getListField().setHidden(true);

		propertyNomeCliente.setType(ListGridFieldType.TEXT);		
		// propertyNomeCliente.setWidthColumn(250);		 
		propertyNomeCliente.createHowMGWTListGridField();
		propertyNomeCliente.getListField().setWrap(true);
		
		propertyNmAtividade.setType(ListGridFieldType.TEXT);		
		propertyNmAtividade.setWidthColumn(250);		 
		propertyNmAtividade.createHowMGWTListGridField();
		propertyNmAtividade.getListField().setWrap(true);
		propertyNmAtividade.getListField().setHidden(true);

		propertyIndEnvCancelamento.setType(ListGridFieldType.TEXT);		
		propertyIndEnvCancelamento.setWidthColumn(100);
		propertyIndEnvCancelamento.createHowMGWTListGridField();
		propertyIndEnvCancelamento.getListField().setHidden(true);

		propertyDtEnvioCancelamento.setType(ListGridFieldType.TEXT);		
		propertyDtEnvioCancelamento.setWidthColumn(100);		 
		propertyDtEnvioCancelamento.createHowMGWTListGridField();
		propertyDtEnvioCancelamento.getListField().setHidden(true);

		formToolbarEdit = new HowMGWTFormToolbarEdit(this, panelGrid);
		formToolbarEdit.getPanelList().setHeaderHeight(48);

		panelGrid.addRecordClickHandler(new RecordClickHandler() {			
			@Override
			public void onRecordClick(RecordClickEvent event) {
				currentRecord = event.getRecord();
				Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
					@Override
					public void execute() {
						System.out.println("Registro : "+currentRecord);
						panelHistorico.onRefreshHistorico(PanelResultadoConsulta.this, currentRecord);						
					}
				});

			}
		}); 

		mainLayout.addMember(formToolbarEdit.getPanelList());
		
		formToolbarEdit.getPanelList().setShowResizeBar(true);
		mainLayout.addMember(panelHistorico);
		
		formToolbarEdit.getActionGravar().setVisible(false);
		this.mainLayout.setWidth100();
		this.mainLayout.setHeight100();

		this.addMember(mainLayout);		
	}

	public String getHowMGWTTitle(){
		return Tradutor.i18n.formTituloVDW1000();
	}

	public String getHowMGWTPrograma(){
		return "VDW1000";
	}

	
	public ListGridRecord getCurrentRecord() {
		return currentRecord;
	}

	public PanelRibbonBarRPS getFiltroConsulta() {
		return filtroConsulta;
	}

	public PanelHistorico getPanelHistorico() {
		return panelHistorico;
	}

	public HowMGWTFormToolbarEdit getFormToolbarEdit() {
		return formToolbarEdit;
	}

	public HowMGWTProperty getPropertyFlagEnvio() {
		return propertyFlagEnvio;
	}

	public HowMGWTProperty getPropertynrRps() {
		return propertynrRps;
	}

	public HowMGWTProperty getPropertyCodPedido() {
		return propertyCodPedido;
	}

	public HowMGWTProperty getPropertyDataEmissao() {
		return propertyDataEmissao;
	}

	public HowMGWTProperty getPropertySituacao() {
		return propertySituacao;
	}

	public HowMGWTProperty getPropertyDescSituacao() {
		return propertyDescSituacao;
	}

	public HowMGWTProperty getPropertyCnpjPrestador() {
		return propertyCnpjPrestador;
	}

	public HowMGWTProperty getPropertyNomeCliente() {
		return propertyNomeCliente;
	}

	public HowMGWTProperty getPropertyCodNumeroNF() {
		return propertyCodNumeroNF;
	}

	public HowMGWTProperty getPropertyNomeArqNF() {
		return propertyNomeArqNF;
	}

	public HowMGWTProperty getPropertyRegistro() {
		return propertyRegistro;
	}

	public HowMGWTProperty getPropertyIdNfse() {
		return propertyIdNfse;
	}

	public HowMGWTProperty getPropertyIdAtividade() {
		return propertyIdAtividade;
	}

	public HowMGWTProperty getPropertyIconAtividade() {
		return propertyIconAtividade;
	}

	public HowMGWTProperty getPropertyNrNfseWs() {
		return propertyNrNfseWs;
	}

	public HowMGWTProperty getPropertySerie() {
		return propertySerie;
	}

	public HowMGWTProperty getPropertyRegistroUI() {
		return propertyRegistroUI;
	}

	public HowMGWTProperty getPropertyCodNotaFiscal() {
		return propertyCodNotaFiscal;
	}

	public HowMGWTProperty getPropertyDtInclusao() {
		return propertyDtInclusao;
	}

	public HowMGWTProperty getPropertyDtCancelamento() {
		return propertyDtCancelamento;
	}

	public HowMGWTProperty getPropertyNmAtividade() {
		return propertyNmAtividade;
	}

	public HowMGWTProperty getPropertyIdProtocolo() {
		return propertyIdProtocolo;
	}

	public HowMGWTProperty getPropertyCodEmpresa() {
		return propertyCodEmpresa;
	}

	public HowMGWTProperty getPropertyNrProtocoloRecebimentoWs() {
		return propertyNrProtocoloRecebimentoWs;
	}

	public HowMGWTProperty getPropertyChave() {
		return propertyChave;
	}

	public HowMGWTListGrid getPanelGrid() {
		return panelGrid;
	}
	
	
	/**
	 * --------------------------------------------------------------------
	 * Implementa a interface de manuteção dos dados do formulório.
	 * --------------------------------------------------------------------
	 */
	@Override
	public HowMGWTFormProperties getHowMProperties() {
		return properties;
	}

	@Override
	public void onHowMDeleteRecord() {}

	@Override
	public void onHowMEditRecord() {
 
	}

	
	/**
	 * Carrega os dados do banco de dados.
	 */
	@Override
	public void onHowMLoad(HowMGWTFormBean pFormBean) 
	{
	}

	@Override
	public void onHowMNewRecord() {}

	@Override
	public void onHowMRelation(ListGridRecord record) {}

	@Override
	public void onHowMSave() {}

	@Override
	public void onHowMSetValues(ListGridRecord record) {}
	
	

	
	/**
	 * @return the properties
	 */
	public HowMGWTFormProperties getProperties() {
		return properties;
	}

	
	/**
	 * Recarrega a última consulta executada.
	 */
	public void reload(){
		this.load(this.codEmpresa, this.operacao, this.dtInicio, this.dtFim, this.codPlano, this.codRPS, this.codPedido, this.nomeCliente, this.codNotaFiscal);		
	}
	
	
	public void load(String codEmpresa, String operacao , String dtInicio, String dtFim, String codPlano, String codRPS, String codPedido, String nomeCliente, String codNotaFiscal){

		this.codEmpresa = codEmpresa;
		this.operacao   = operacao;
		this.dtInicio   = dtInicio;
		this.dtFim      = dtFim;
		this.codPlano   = codPlano;
		this.codRPS     = codRPS;
		this.codPedido  = codPedido;
		this.nomeCliente= nomeCliente;
		this.codNotaFiscal = codNotaFiscal;

		formToolbarEdit.getPanelList().clearAllRecords();

		panelHistorico.onRefreshHistorico(this, null);

		// -------------------------------------------------------------------------------
		// Grava os dados no servidor.
		// -------------------------------------------------------------------------------
		HowMGWTWindowWait.showWait();		
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true))
					return;

				FormBean bean = (FormBean)formBean;

				if( bean.getEntityNFSEs() == null ){
					SC.say("não encontrou registros para o critório de consulta utilizado...");
					return;
				}

				ListGridRecord[] records = new ListGridRecord[bean.getEntityNFSEs().length];
				ListGridRecord record;
				int i = 0;
				for ( eNFSE nfse : bean.getEntityNFSEs() ){
				
					record = new ListGridRecord();

					propertyIdProtocolo.setHowMValue(record, nfse.getIdProtocolo()); 

					if( HowMGWTUtilities.isEmpty( nfse.getDtInclusao() )){
						propertyDtInclusao.setHowMValue(record, "" );						
					}
					else{
						propertyDtInclusao.setHowMValue(record, HowMGWTUtilities.getFormatDateTime( HowMGWTUtilities.getDate( nfse.getDtInclusao() ) ) );
					}
					
					if( HowMGWTUtilities.isEmpty( nfse.getDtCancelamento() )){
						propertyDtCancelamento.setHowMValue(record, "" );						
					}
					else{
						propertyDtCancelamento.setHowMValue(record, HowMGWTUtilities.getFormatDateTime( HowMGWTUtilities.getDate( nfse.getDtCancelamento() ) ) );
					}


					propertyCnpjPrestador.setHowMValue(record, HowMGWTUtilities.formatCNPJ( nfse.getCnpjPrestador() ));
					propertyChave.setHowMValue(record, nfse.getChave());
					propertySerie.setHowMValue(record, nfse.getSerie());

					propertyFlagEnvio.setHowMValue(record, nfse.getFlagEnvio());
					
					propertyIdNfse.setHowMValue(record, nfse.getIdNfse());
					propertyCodEmpresa.setHowMValue(record, nfse.getCodEmpresa());
					propertyCodNotaFiscal.setHowMValue(record, nfse.getCodNotaFiscal());
										
					propertynrRps.setHowMValue(record, nfse.getNrRps());
					propertyNrProtocoloRecebimentoWs.setHowMValue(record, nfse.getNrProtocoloRecebimentoWs());
					propertyIdAtividade.setHowMValue(record, nfse.getIdAtividade());
					propertyNrNfseWs.setHowMValue(record, nfse.getNrNfseWs());
					propertySerie.setHowMValue(record, nfse.getSerie());
					propertyNomeCliente.setHowMValue(record, nfse.getNomeCliente());
					propertyNmAtividade.setHowMValue(record, nfse.getNmAtividade());		
					
					propertyCodPedido.setHowMValue(record, nfse.getCodPedido());
					propertyDataEmissao.setHowMValue(record, nfse.getDtEmissao());
					propertySituacao.setHowMValue(record, nfse.getSituacao());
					
					
					propertyNomeCliente.setHowMValue(record, nfse.getDescCliente());					
					propertyRegistroUI.setHowMValue(record, nfse.getIndex());
					propertyRegistro.setHowMValue(record, nfse.getIndex());

					propertyIconAtividade.setHowMValue(record, nfse.getIconNfseAtividade());
					propertySituacaoIntegracao.setHowMValue(record, nfse.getDescSituacaoIntegracao());

					propertyIndEnvCancelamento.setHowMValue(record, nfse.getIndEnvCancelamento());
					propertyDtEnvioCancelamento.setHowMValue(record, nfse.getDtEnvioCancelamento());

					propertyNomeArqNF.setHowMValue(record, nfse.getNomeArquivoNFe());
					propertyDescSituacao.setHowMValue(record, nfse.getDescSituacao());

					if( "1".equals(nfse.getIndEnvCancelamento()) ){ // && !("12".equals(nfse.getIdAtividade()) )
						propertySituacaoIntegracao.setHowMValue(record, "Aguardando Cancelamento");
					}else{
						propertySituacaoIntegracao.setHowMValue(record, nfse.getDescSituacaoIntegracao());
					}
					
					records[i++] = record;
					
				}
				
				panelGrid.setData(records);
				
				HowMGWTWindowWait.hideWait();
			}

			@Override
			public void onError(Throwable err) {
				super.onError(err);
			}			
		};
	
		// Configura os filtros da consulta.
		
		FormBean formBean = new FormBean();
		formBean.setCodEmitente(this.getCurrentCodEmitente());
		formBean.setCodEmpresa(codEmpresa);
		formBean.setExecuteOperacao(operacao);
		formBean.setDtFim(dtFim);
		formBean.setDtInicio(dtInicio);
		
		formBean.setCodPlano(codPlano);
		formBean.setCodRPS(codRPS);
		formBean.setCodPedido(codPedido);
		formBean.setNomeCliente(nomeCliente);
		formBean.setCodNotaFiscal(codNotaFiscal);
	 	
		struts.request("vdw1000.do?method=buscaNotas",  "VDW1000Form", formBean.toSendBody("") );				
	}
	
	
		
	public void onExportarNFSEContador(String codEmpresa, String dtInicio, String dtFim){
		
		ListGridRecord[] records = panelGrid.getSelectedRecords();

		if( records.length == 0 ){
			SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServico());
			return;
		}

		HowMGWTWindowWait.showWait("Aguarde exportando arquivos XML NFS-e...");
		
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				FormBean form = (FormBean)formBean;
				HowMGWTWindowWait.hideWait();
				HowMGWTUtilities.downloadFile(form.getPathName(), form.getFileName());
			}
		};

		FormBean bean = new FormBean();
		bean.setCodEmpresa(codEmpresa);
		bean.setDtInicio(dtInicio);
		bean.setDtFim(dtFim);

		// Passa as nfse-s selecionadas pelo usuório.
		eNFSE[] NFSEs = new eNFSE[records.length];
		eNFSE nfse;
		int i = 0;
		for( ListGridRecord record : records ){
			nfse = new eNFSE();
			nfse.setIdNfse(propertyIdNfse.getHowMValue(record));
			nfse.setChave(propertyChave.getHowMValue(record));
			nfse.setNomeCliente(propertyNomeCliente.getHowMValue(record));
			nfse.setCodNotaFiscal(propertyCodNotaFiscal.getHowMValue(record));
			nfse.setCnpjPrestador(propertyCnpjPrestador.getHowMValue(record));
			NFSEs[i++] = nfse;
		}
		bean.setEntityNFSEs(NFSEs);
		
		bean.setCodEmpresa( codEmpresa );
		bean.setCodEmitente(this.getCurrentCodEmitente());
		
		struts.request("vdw1000.do?method=exportarNFSEContador",  "VDW1000Form", bean.toSendBody("") );		
	}
	
	
	
	
	public void onConfigureSistema(String codEmitente, eNFSEEmitenteWS entityEmitente ){
		this.setCurrentCodEmitente(codEmitente);
		this.setCurrentEmitenteWS(entityEmitente);

		
		
		filtroConsulta.isRefreshMenu(entityEmitente);

		filtroConsulta.executeOperacao(
					filtroConsulta.OPERACAO_ENVIAR_RPS_PARA_PROCESSAMENTO, 
					NFSEUtilities.OPERACAO_NOTAS_FISCAIS_PENDENTES_PARA_ENVIO, 
					filtroConsulta.getPropertyPeriodoInicial().getHowmFormValueToString(), 
					filtroConsulta.getPropertyPeriodoFinal().getHowmFormValueToString(),
					
					filtroConsulta.getPropertyCodPlano().getHowmFormValueToString(),
					filtroConsulta.getPropertyCodRPS().getHowmFormValueToString(),
					filtroConsulta.getPropertyCodPedido().getHowmFormValueToString(),
					filtroConsulta.getPropertyNomeCliente().getHowmFormValueToString(),
					filtroConsulta.getPropertyCodNotaFiscal().getHowmFormValueToString()
					
				);

		String usuario = "";
		String senha   = "";
		if( entityEmitente != null ){
			if( entityEmitente.getEntityConfiguracaoWS() != null ){
				if ( ! HowMGWTUtilities.isEmpty( entityEmitente.getEntityConfiguracaoWS().getNmUsuario() )
					 && 
					 ! HowMGWTUtilities.isEmpty( entityEmitente.getEntityConfiguracaoWS().getNmSenhaMonitoramento() )
				){
					usuario = entityEmitente.getEntityConfiguracaoWS().getNmUsuario();
					senha   = entityEmitente.getEntityConfiguracaoWS().getNmSenhaMonitoramento();
				}
			}
		}
		// panelMonitorG2KA = new PanelG2KA("http://sorocaba.unoerp.com.br:6060/nfse/",usuario,senha);
		this.setUsuarioG2KA(usuario);
		this.setSenhaG2KA(senha);

	}
	
	
	
	
	
	
	
	/**
	 * Cancela notas fiscais enviadas para o servidor...
	 */
	public void cancelarEnvioRPS(String motivo, String reabirPedido){
		
		ListGridRecord[] records = panelGrid.getSelectedRecords();

		if( records.length == 0 ){
			SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServicoProc());
			return;
		}

		HowMGWTWindowWait.showWait("Aguarde enviando RPS's para cancelamento...");
		
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				
				if( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ) {
					return;
				}				
				FormBean form = (FormBean)formBean;
				HowMGWTWindowWait.hideWait();
				reload();
			}
		};

		FormBean bean = new FormBean();
		bean.setCodEmpresa(Configuracao.getCodEmpresa());
		bean.setCodColaborador(Configuracao.getCodColaborador());

		// Passa as nfse-s selecionadas pelo usuório.
		eNFSE[] NFSEs = new eNFSE[records.length];
		eNFSE nfse;
		int i = 0;
		for( ListGridRecord record : records ){
			nfse = new eNFSE();

			nfse.setIndex(propertyRegistroUI.getHowMValue(record));				// #Reg
			nfse.setCnpjPrestador(propertyCnpjPrestador.getHowMValue(record));	// CNPJ
			nfse.setIdNfse(propertyIdNfse.getHowMValue(record));				// idNfse
			nfse.setCodNotaFiscal(propertyCodNotaFiscal.getHowMValue(record));
			nfse.setCodEmpresa(propertyCodEmpresa.getHowMValue(record));
			nfse.setDsMotivoCancelamento(motivo);
			nfse.setCodColaboradorCancelamento(Configuracao.getCodColaborador());
			NFSEs[i++] = nfse;
		}
		bean.setReabrirPedido(reabirPedido);
		bean.setEntityNFSEs(NFSEs);
		bean.setCodEmitente(this.currentEmitenteWS.getCodEmitente());
		struts.request("vdw1000.do?method=enviarRPSCancelamento",  "VDW1000Form", bean.toSendBody("") );		
				
	}
	
	
	private void onSendMail() {
		
		ListGridRecord[] records = panelGrid.getSelectedRecords();

		if( records.length == 0 ){
			SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServicoProc());
			return;
		}

		HowMGWTWindowWait.showWait("Aguarde agendando E-Mail para envio aos clientes...");
		
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				
				if( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ) {
					return;
				}				
				FormBean form = (FormBean)formBean;
				HowMGWTWindowWait.hideWait();
				reload();

				SC.say("E-mail agendado com sucesso...");
			}
		};

		FormBean bean = new FormBean();
		bean.setCodEmpresa(Configuracao.getCodEmpresa());
		bean.setCodColaborador(Configuracao.getCodColaborador());

		// Passa as nfse-s selecionadas pelo usuório.
		eNFSE[] NFSEs = new eNFSE[records.length];
		eNFSE nfse;
		int i = 0;
		for( ListGridRecord record : records ){
			nfse = new eNFSE();
			nfse.setIndex(propertyRegistroUI.getHowMValue(record));				// #Reg
			nfse.setCnpjPrestador(propertyCnpjPrestador.getHowMValue(record));	// CNPJ
			nfse.setIdNfse(propertyIdNfse.getHowMValue(record));				// idNfse
			nfse.setCodEmpresa(Configuracao.getCodEmpresa());					// CodEmpresa
			nfse.setCodNotaFiscal(propertyCodNotaFiscal.getHowMValue(record)); 	// CodNotaFiscal
			nfse.setNrNfseWs(propertyNrNfseWs.getHowMValue(record));			// nrNFSE
			nfse.setChave(propertyChave.getHowMValue(record));					// chave
			NFSEs[i++] = nfse;
		}
		bean.setEntityNFSEs(NFSEs);
		struts.request("vdw1000.do?method=enviarEmailCliente",  "VDW1000Form", bean.toSendBody("") );		
	}
	
	
	public void onForcarSincronismoRPS(){
		ListGridRecord[] records = panelGrid.getSelectedRecords();

		if( records.length == 0 ){
			SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServicoProc());
			return;
		}

		HowMGWTWindowWait.showWait("Aguarde agendando Sincronismo de RPS...");
		
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				
				if( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ) {
					return;
				}				
				FormBean form = (FormBean)formBean;
				HowMGWTWindowWait.hideWait();
				reload();

				SC.say("Sincronismo de RPS agendado com sucesso...");
			}
		};

		FormBean bean = new FormBean();
		bean.setCodEmpresa(Configuracao.getCodEmpresa());
		bean.setCodColaborador(Configuracao.getCodColaborador());

		// Passa as nfse-s selecionadas pelo usuório.
		eNFSE[] NFSEs = new eNFSE[records.length];
		eNFSE nfse;
		int i = 0;
		for( ListGridRecord record : records ){
			nfse = new eNFSE();
			nfse.setIndex(propertyRegistroUI.getHowMValue(record));				// #Reg
			nfse.setCnpjPrestador(propertyCnpjPrestador.getHowMValue(record));	// CNPJ
			nfse.setIdNfse(propertyIdNfse.getHowMValue(record));				// idNfse
			nfse.setCodEmpresa(Configuracao.getCodEmpresa());					// CodEmpresa
			nfse.setCodNotaFiscal(propertyCodNotaFiscal.getHowMValue(record)); 	// CodNotaFiscal
			nfse.setChave(propertyChave.getHowMValue(record));					// chave
			NFSEs[i++] = nfse;
		}
		bean.setEntityNFSEs(NFSEs);
		struts.request("vdw1000.do?method=sincronizarRPS",  "VDW1000Form", bean.toSendBody("") );		
	}
	
	
	
	
	
	
	/**
	 * Visualiza a NFS-e no site da prefeitura.
	 */
	protected void onVisualizarNFSePrefeitura(){
		ListGridRecord[] records = panelGrid.getSelectedRecords();

		if( records.length == 0 ){
			SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServicoProc());
			return;
		}

		HowMGWTWindowWait.showWait("Aguarde carregando visualização da NFS-e gerada na prefeitura...");
 

		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				
				if( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ) {
					return;
				}				
				FormBean form = (FormBean)formBean;

				if( form.getUrlConsultasNFSePrefeitura() != null && form.getUrlConsultasNFSePrefeitura().length > 0 ){
					Window.open(form.getUrlConsultasNFSePrefeitura()[0], "Visualizar NFS-e Prefeitura", "");
				}

				HowMGWTWindowWait.hideWait();				
			}
		};

		FormBean bean = new FormBean();
		bean.setCodEmpresa(Configuracao.getCodEmpresa());
		bean.setCodColaborador(Configuracao.getCodColaborador());

		// Passa as nfse-s selecionadas pelo usuório.
		eNFSE[] NFSEs = new eNFSE[records.length];
		eNFSE nfse;
		int i = 0;
		for( ListGridRecord record : records ){
			nfse = new eNFSE();
			nfse.setIndex(propertyRegistroUI.getHowMValue(record));				// #Reg
			nfse.setCnpjPrestador(propertyCnpjPrestador.getHowMValue(record));	// CNPJ
			nfse.setIdNfse(propertyIdNfse.getHowMValue(record));				// idNfse
			nfse.setCodEmpresa(Configuracao.getCodEmpresa());					// CodEmpresa
			nfse.setCodNotaFiscal(propertyCodNotaFiscal.getHowMValue(record)); 	// CodNotaFiscal
			nfse.setChave(propertyChave.getHowMValue(record));					// chave
			NFSEs[i++] = nfse;
		}
		bean.setEntityNFSEs(NFSEs);
		struts.request("vdw1000.do?method=visualizarNFSePrefeitura",  "VDW1000Form", bean.toSendBody("") );				
		
	}
	
	
	
	// Apresenta o histórico do registro
	public void onShowHistorico(){

		ListGridRecord[] records = panelGrid.getSelectedRecords();

		if( records.length == 0 ){
			SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServicoHist());
			return;
		}
		
		if ( windowHistorico == null ){
			windowHistorico = new WindowHistorico();
		}
		// Monta a chave de busca
		String[] chaves = new String[]{
			codEmpresa,
			propertyCodNotaFiscal.getHowMValue(currentRecord)
		};
		
		// if( filtroConsulta.OPERACAO_ENVIAR_RPS_PARA_PROCESSAMENTO.equals( this.operacao ) ){
		// Carrega os históricos do registro.
			windowHistorico.showHistorico("HIST&Oacute;RICO DE ENVIO NOTA FISCAL DE SERVI&Ccedil;O", "", chaves , "8");  //
//		}		
	}
	
	public void onVisualizarAdministracao(){
		ListGridRecord[] records = panelGrid.getSelectedRecords();

		if( records.length == 0 ){
			SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServicoProc());
			return;
		}

		Window.alert("Função Administrativa.");
		
//		HowMGWTWindowWait.showWait("Aguarde agendando Sincronismo de RPS...");
//		
//		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {
//
//			@Override
//			public void onResponse(HowMGWTFormBean formBean) {
//				
//				if( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ) {
//					return;
//				}				
//				FormBean form = (FormBean)formBean;
//				HowMGWTWindowWait.hideWait();
//				reload();
//
//				SC.say("Sincronismo de RPS agendado com sucesso...");
//			}
//		};
//
//		FormBean bean = new FormBean();
//		bean.setCodEmpresa(Configuracao.getCodEmpresa());
//		bean.setCodColaborador(Configuracao.getCodColaborador());
//
//		// Passa as nfse-s selecionadas pelo usuório.
//		eNFSE[] NFSEs = new eNFSE[records.length];
//		eNFSE nfse;
//		int i = 0;
//		for( ListGridRecord record : records ){
//			nfse = new eNFSE();
//			nfse.setIndex(propertyRegistroUI.getHowMValue(record));				// #Reg
//			nfse.setCnpjPrestador(propertyCnpjPrestador.getHowMValue(record));	// CNPJ
//			nfse.setIdNfse(propertyIdNfse.getHowMValue(record));				// idNfse
//			nfse.setCodEmpresa(Configuracao.getCodEmpresa());					// CodEmpresa
//			nfse.setCodNotaFiscal(propertyCodNotaFiscal.getHowMValue(record)); 	// CodNotaFiscal
//			nfse.setChave(propertyChave.getHowMValue(record));					// chave
//			NFSEs[i++] = nfse;
//		}
//		bean.setEntityNFSEs(NFSEs);
//		struts.request("vdw1000.do?method=sincronizarRPS",  "VDW1000Form", bean.toSendBody("") );				
	}

	
	
	
//	/**
//	 * Regera e envia a a RPS para processamento no Servidor, função utilizada pelo Suporte.
//	 */
//	protected void onRegerarReenviarRPS(){
//
//		ListGridRecord[] records = panelGrid.getSelectedRecords();
//
//		if( records.length == 0 ){
//			SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServicoProc());
//			return;
//		}
//
//		HowMGWTWindowWait.showWait("Aguarde recriando RPS, reenviando ...");
//		 
//
//		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {
//
//			@Override
//			public void onResponse(HowMGWTFormBean formBean) {
//				
//				if( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ) {
//					return;
//				}				
//				FormBean form = (FormBean)formBean;				
//
//				HowMGWTWindowWait.hideWait();
//			}
//		};
//
//		FormBean bean = new FormBean();
//		bean.setCodEmpresa(Configuracao.getCodEmpresa());
//		bean.setCodColaborador(Configuracao.getCodColaborador());
//
//		// Passa as nfse-s selecionadas pelo usuório.
//		eNFSE[] NFSEs = new eNFSE[records.length];
//		eNFSE nfse;
//		int i = 0;
//		for( ListGridRecord record : records ){
//									
//			nfse = new eNFSE();
//			nfse.setIndex(propertyRegistroUI.getHowMValue(record));				// #Reg
//			nfse.setCnpjPrestador(propertyCnpjPrestador.getHowMValue(record));	// CNPJ
//			nfse.setIdNfse(propertyIdNfse.getHowMValue(record));				// idNfse
//			nfse.setCodEmpresa(Configuracao.getCodEmpresa());					// CodEmpresa
//			nfse.setCodNotaFiscal(propertyCodNotaFiscal.getHowMValue(record)); 	// CodNotaFiscal
//			nfse.setChave(propertyChave.getHowMValue(record));					// chave
//			nfse.setNrRps(propertynrRps.getHowMValue(record));					// NrRPS			
//			
//			NFSEs[i++] = nfse;
//		}
//		bean.setEntityNFSEs(NFSEs);
//		struts.request("vdw1000.do?method=recriarRPSenviar",  "VDW1000Form", bean.toSendBody("") );				
//		
//	}	
//	
//	
	

	
	
	/**
	 * Regera e envia a a RPS para processamento no Servidor, função utilizada pelo Suporte.
	 */
	protected void onAnalisarRPS(){

		ListGridRecord[] records = panelGrid.getSelectedRecords();

		if( records.length == 0 ){
			SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServicoProc());
			return;
		}

		HowMGWTWindowWait.showWait("Aguarde analisando RPS, para suporte eletronico ...");
		 

		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				
				if( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ) {
					return;
				}				
				FormBean form = (FormBean)formBean;

				HowMGWTWindowDocumentHTMLResume.showDocument(form.getAnaliseRPS());
				
				HowMGWTWindowWait.hideWait();
			}
		};

		FormBean bean = new FormBean();
		bean.setCodEmpresa(Configuracao.getCodEmpresa());
		bean.setCodColaborador(Configuracao.getCodColaborador());

		// Passa as nfse-s selecionadas pelo usuório.
		eNFSE[] NFSEs = new eNFSE[records.length];
		eNFSE nfse;
		int i = 0;
		for( ListGridRecord record : records ){
			nfse = new eNFSE();
			nfse.setIndex(propertyRegistroUI.getHowMValue(record));				// #Reg
			nfse.setCnpjPrestador(propertyCnpjPrestador.getHowMValue(record));	// CNPJ
			nfse.setIdNfse(propertyIdNfse.getHowMValue(record));				// idNfse
			nfse.setCodEmpresa(Configuracao.getCodEmpresa());					// CodEmpresa
			nfse.setCodNotaFiscal(propertyCodNotaFiscal.getHowMValue(record)); 	// CodNotaFiscal
			nfse.setChave(propertyChave.getHowMValue(record));					// chave
			nfse.setNrRps(propertynrRps.getHowMValue(record));					// NrRPS
			NFSEs[i++] = nfse;
		}
		bean.setEntityNFSEs(NFSEs);
		struts.request("vdw1000.do?method=analisarRPS",  "VDW1000Form", bean.toSendBody("") );				
		
	}	
	
	
	public void onDownloadAI(){
		ListGridRecord[] records = panelGrid.getSelectedRecords();

		if( records.length == 0 ){
			SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServicoProc());
			return;
		}

		HowMGWTWindowWait.showWait("Aguarde analisando preparando arquivos para download ...");
		 
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				
				if( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ) {
					return;
				}				
				FormBean form = (FormBean)formBean;

				if( !HowMGWTUtilities.isEmpty( form.getDownloadFileName() ) ){
					HowMGWTUtilities.downloadFile(form.getDownloadPath(), form.getDownloadFileName());
				}
				else{
					SC.say("Arquivo de download nao esta disponivel...");
				}
				
				HowMGWTWindowWait.hideWait();
			}
		};

		FormBean bean = new FormBean();
		bean.setCodEmpresa(Configuracao.getCodEmpresa());
		bean.setCodColaborador(Configuracao.getCodColaborador());
		bean.setTipoDownload(filtroConsulta.getPanelRibbonBarSuporte().getPropertyTipoDownload().getHowMValue());
		
		// Passa as nfse-s selecionadas pelo usuório.
		eNFSE[] NFSEs = new eNFSE[records.length];
		eNFSE nfse;
		int i = 0;
		for( ListGridRecord record : records ){
			nfse = new eNFSE();
			nfse.setIndex(propertyRegistroUI.getHowMValue(record));				// #Reg
			nfse.setCnpjPrestador(propertyCnpjPrestador.getHowMValue(record));	// CNPJ
			nfse.setIdNfse(propertyIdNfse.getHowMValue(record));				// idNfse
			nfse.setCodEmpresa(Configuracao.getCodEmpresa());					// CodEmpresa
			nfse.setCodNotaFiscal(propertyCodNotaFiscal.getHowMValue(record)); 	// CodNotaFiscal
			nfse.setChave(propertyChave.getHowMValue(record));					// chave
			nfse.setNrRps(propertynrRps.getHowMValue(record));					// NrRPS
			nfse.setNomeArquivoNFe(propertyNomeArqNF.getHowMValue(record));		// Nome do arquivo			
			NFSEs[i++] = nfse;
		}
		bean.setEntityNFSEs(NFSEs);
		struts.request("vdw1000.do?method=downloadAI",  "VDW1000Form", bean.toSendBody("") );				

	}
	
	
	
	/**
	 * Retransmite os arquivos para o servidor HCINF-NeoGrid, usado quando 
	 * há problema de rede e a RPS não foi transmitida noramalmente pelo sistema.
	 */
	public void onRetransmitir(){
		ListGridRecord[] records = panelGrid.getSelectedRecords();

		if( records.length == 0 ){
			SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServicoProc());
			return;
		}

		HowMGWTWindowWait.showWait("Aguarde retransmitindo arquivo para processamento na prefeitura ...");
		 
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				
				if( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ) {
					return;
				}				
				FormBean form = (FormBean)formBean;

				SC.say("Arquivos retransmitidos com sucesso...");
				
				HowMGWTWindowWait.hideWait();
			}
		};

		FormBean bean = new FormBean();
		bean.setCodEmpresa(Configuracao.getCodEmpresa());
		bean.setCodColaborador(Configuracao.getCodColaborador());		
		
		// Passa as nfse-s selecionadas pelo usuório.
		eNFSE[] NFSEs = new eNFSE[records.length];
		eNFSE nfse;
		int i = 0;
		for( ListGridRecord record : records ){
			nfse = new eNFSE();
			nfse.setIndex(propertyRegistroUI.getHowMValue(record));				// #Reg
			nfse.setCnpjPrestador(propertyCnpjPrestador.getHowMValue(record));	// CNPJ
			nfse.setIdNfse(propertyIdNfse.getHowMValue(record));				// idNfse
			nfse.setCodEmpresa(Configuracao.getCodEmpresa());					// CodEmpresa
			nfse.setCodNotaFiscal(propertyCodNotaFiscal.getHowMValue(record)); 	// CodNotaFiscal
			nfse.setChave(propertyChave.getHowMValue(record));					// chave
			nfse.setNrRps(propertynrRps.getHowMValue(record));					// NrRPS
			nfse.setNomeArquivoNFe(propertyNomeArqNF.getHowMValue(record));		// Nome do arquivo			
			NFSEs[i++] = nfse;
		}
		bean.setEntityNFSEs(NFSEs);
		struts.request("vdw1000.do?method=enviarPrefeitura",  "VDW1000Form", bean.toSendBody("") );				

	}
	
	
	
	
	/**
	 * Consulta as pendencias que estão bloqueando o envio das RPS represadas na Etapa 1 e 2
	 */
	public void onVerificarPendencias(){

		HowMGWTWindowWait.showWait("Aguarde verificando problemas de transmissão de RPS ...");
		 
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				
				if( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ) {
					return;
				}				
				FormBean form = (FormBean)formBean;
				
				HowMGWTWindowWait.hideWait();
			}
		};

		FormBean bean = new FormBean();
		bean.setCodEmpresa(Configuracao.getCodEmpresa());
		bean.setCodColaborador(Configuracao.getCodColaborador());		
		
		struts.request("vdw1000.do?method=verificandoTransmissao",  "VDW1000Form", bean.toSendBody("") );				
	}

	public String getOperacao() {
		return operacao;
	}
	
	
	
	
	

	
	
	
	
	

	
	
	
	
	/**
	 * Implementa o envia de RPS para processamento
	 */
	public void onEnviarRPSProcessamentoImpl(){
		
		if( NFSEUtilities.OPERACAO_NOTAS_FISCAIS_PENDENTES_PARA_ENVIO.equalsIgnoreCase(this.operacao) ){
			this.monitorERPManual();
		}
		else if ( NFSEUtilities.OPERACAO_AGUARDANDO_PROCESSAMENTO_NA_PREFEITURA.equalsIgnoreCase(this.operacao)){
			this.monitorReenviar();
		}
		else{
			SC.say("não é permitido envio de registro neste modo de consulta...");
		}
	
	}
	
	
	
	/**
	 * Envia manualemente as notas para o sistema de mensageria.
	 */
	public void monitorERPManual(){
		
		ListGridRecord[] records = panelGrid.getSelectedRecords();

		if( records.length == 0 ){
			SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServico());
			return;
		}
		
		if( HowMGWTUtilities.getBoolean(this.getCurrentEmitenteWS().getEntityConsultaWS().getIndControlaSubsequente() ) ){
			if( records.length > 1 ){
				SC.say("Prefeitura contrala numeração! Por favor selecione somente um registro para envio...");
				return;
			}
		}

		HowMGWTWindowWait.showWait("Aguarde enviando RPS para sistema de mensageria...");
		
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {

				if( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ) {
					return;
				}
				
				FormBean form = (FormBean)formBean;
				HowMGWTWindowWait.hideWait();
				SC.say("Registro(s) enviado(s) com sucesso !!! <br>Acompanhe pelo monitoramento a recepção das notas na prefeitura...<HR>");
				reload();
			}
		};

		FormBean bean = new FormBean();
		bean.setCodEmpresa(codEmpresa);

		// Passa as nfse-s selecionadas pelo usuório.
		eNFSE[] NFSEs = new eNFSE[records.length];
		eNFSE nfse;
		int i = 0;
		for( ListGridRecord record : records ){
			nfse = new eNFSE();
			nfse.setCodNotaFiscal(propertyCodNotaFiscal.getHowMValue(record));
			NFSEs[i++] = nfse;
		}
		bean.setEntityNFSEs(NFSEs);
		bean.setCodEmitente(this.getCurrentCodEmitente());		
		struts.request("vdw1000.do?method=monitorERPManual",  "VDW1000Form", bean.toSendBody("") );		
	}
	
	/**
	 * Envia manualemente as notas para o sistema de mensageria.
	 */
	public void monitorReenviar(){
		
		ListGridRecord[] records = panelGrid.getSelectedRecords();

		if( records.length == 0 ){
			SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServico());
			return;
		}
		
		if( records.length > 1 ){
			SC.say("Para realizar o reenvio, selecione apenas uma RPS...");
			return;
		}

		HowMGWTWindowWait.showWait("Aguarde reenviando RPS...");
		
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {

				if( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ) {
					return;
				}
				
				FormBean form = (FormBean)formBean;
				HowMGWTWindowWait.hideWait();
				SC.say("Registro reenviado com sucesso !!!Acompanhe pelo monitoramento a recepção das notas na prefeitura...");
				reload();
			}
		};

		FormBean bean = new FormBean();
		bean.setCodEmpresa(codEmpresa);

		// Passa as nfse-s selecionadas pelo usuório.
		eNFSE[] NFSEs = new eNFSE[records.length];
		eNFSE nfse;
		int i = 0;
		for( ListGridRecord record : records ){
			nfse = new eNFSE();
			nfse.setCodNotaFiscal(propertyCodNotaFiscal.getHowMValue(record));
			nfse.setNrRps(propertynrRps.getHowMValue(record));
			NFSEs[i++] = nfse;
		}
		bean.setCodEmitente(this.currentEmitenteWS.getCodEmitente());
		bean.setEntityNFSEs(NFSEs);
		bean.setCodEmitente(this.getCurrentCodEmitente());		
		struts.request("vdw1000.do?method=monitorReenvio",  "VDW1000Form", bean.toSendBody("") );		
	}	

}