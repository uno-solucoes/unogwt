package com.br.client.panel.vd.vdw0031.UI;

import java.util.Date;
import java.util.LinkedHashMap;

import com.br.client.configuracao.UcommerceConstantes;
import com.br.client.model.ed.entity.eEDI;
import com.br.client.model.vd.entity.eMotivoDevolucao;
import com.br.client.model.vd.entity.eSolicitacaoDevolucao;
import com.br.client.model.vd.vdw0031.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.FactoryUCommerce;
import com.br.client.panel.registro.UIPartner;
import com.howmake.client.form.UI.HowMGWTFormToolbarEdit;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.UI.HowMGWTPanelInstrucaoFiltro;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.control.HowMGWTControlForm;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTListField;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.ExpansionMode;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelSolicitacaoDevolucao extends VLayout implements HowMGWTControlForm , UIPartner{

	private FormBean currentFormBean;
	
	private WindowPanelEditSolicitacaoDevolucao windowPanelEditSolicitacaoDevolucao;

	private HowMGWTFormProperties propertiesFiltro = new HowMGWTFormProperties();

	
	private HowMGWTProperty propertyFiltroDtSolicitacaoInicio 			= propertiesFiltro.createProperty("dtSolicitacaoInicial", 	Tradutor.i18n.formDtSolicitacao()+" de ");
	private HowMGWTProperty propertyFiltroDtSolicitacaoFinal 	  		= propertiesFiltro.createProperty("dtSolicitacaoFinal", 	Tradutor.i18n.formAte());
	
	private HowMGWTProperty propertyFiltroDtAprovacaoInicio 			= propertiesFiltro.createProperty("dtAprovacaoInicial", 	Tradutor.i18n.formDtAprovacaoReprovacao()+" de ");
	private HowMGWTProperty propertyFiltroDtAprovacaoFinal 	  			= propertiesFiltro.createProperty("dtAprovacaoFinal", 		Tradutor.i18n.formAte());
	
	private HowMGWTProperty propertyFiltroCodNotaFiscal 				= propertiesFiltro.createProperty("codNotaFiscal", 			Tradutor.i18n.formCodNotaFiscal());
	private HowMGWTProperty propertyFiltroNumeroNota 	  				= propertiesFiltro.createProperty("nrNotaFiscal", 			Tradutor.i18n.formNrNotaFiscal());
	private HowMGWTProperty propertyFiltroSerieNota 	  				= propertiesFiltro.createProperty("serieNotaFiscal", 		Tradutor.i18n.formNrNotaFiscal());
	private HowMGWTProperty propertyFiltroCodCliente 					= propertiesFiltro.createProperty("codCliente", 			Tradutor.i18n.formCodigoCliente());
	private HowMGWTProperty propertyFiltroCodPedido 	  				= propertiesFiltro.createProperty("codPedido", 				Tradutor.i18n.formCodPedido());
	private HowMGWTProperty propertyFiltroCodColaborador				= propertiesFiltro.createProperty("codColaborador", 		Tradutor.i18n.formCodVendedor());
	private HowMGWTProperty propertyFiltroSituacao 	  					= propertiesFiltro.createProperty("codSituacao", 			Tradutor.i18n.formSituacao());

	private HowMGWTFormToolbarEdit formToolbarEdit;

	private HowMGWTFormProperties properties = new HowMGWTFormProperties();

	private HowMGWTProperty propertyCodSolicitacaoDevolucao		= properties.createProperty("codSolicitacaoDevolucao",	Tradutor.i18n.formCodSolicitacaoDevolucao());
	private HowMGWTProperty propertyCodMotivoDevolucao			= properties.createProperty("codMotivoDevolucao", 		Tradutor.i18n.formCodMotivoDevolucao());
	private HowMGWTProperty propertyDescMotivoDevolucao			= properties.createProperty("descMotivo", 				Tradutor.i18n.formDescMotivoDevolucao());

	private HowMGWTProperty propertyDescricao					= properties.createProperty("descricao", 				Tradutor.i18n.formDescricao());
	private HowMGWTProperty propertySituacao					= properties.createProperty("situacao", 				Tradutor.i18n.formSituacao());
	private HowMGWTProperty propertyCodCliente					= properties.createProperty("codCliente", 				Tradutor.i18n.formCodCliente());	
	private HowMGWTProperty propertyNomeCliente					= properties.createProperty("nomeCliente", 				Tradutor.i18n.formNomeCliente());
	private HowMGWTProperty propertyCodColaboradorSolicitante	= properties.createProperty("codColaboradorSolicitante",Tradutor.i18n.formCodColaboradorSolicitante());
    private HowMGWTProperty propertyNomeColaboradorSolicitante	= properties.createProperty("nomeColaboradorSolicitante",Tradutor.i18n.formNomeColaboradorSolicitante());
	private HowMGWTProperty propertyDtSolicitacao				= properties.createProperty("dtSolicitacao", 			Tradutor.i18n.formDtSolicitacao());
	private HowMGWTProperty propertyCodColaboradorAprovador		= properties.createProperty("codColaboradorAprovador", 	Tradutor.i18n.formCodColaboradorAprovadorReprovador());
    private HowMGWTProperty propertyNomeColaboradorAprovador	= properties.createProperty("nomeColaboradorAprovador", Tradutor.i18n.formNomeColaboradorAprovador());
	private HowMGWTProperty propertyDtAprovacao					= properties.createProperty("dtAprovacao", 				Tradutor.i18n.formDtAprovacaoReprovacao());
	private HowMGWTProperty propertyObsAprovador				= properties.createProperty("obsAprovador", 			Tradutor.i18n.formObsAprovador());

	private HowMGWTProperty propertyCodColaborador				= properties.createProperty("codColaborador", 			Tradutor.i18n.formCodColaborador());
	private HowMGWTProperty propertyNomeColaborador				= properties.createProperty("nomeColaborador", 			Tradutor.i18n.formNomeColaborador());
	
	
	private HowMGWTListGrid panelGrid = new HowMGWTListGrid();
	private VLayout mainFiltro = new VLayout();
	
	private boolean showDetalhes = false;
	
	public PainelSolicitacaoDevolucao(){
		
		int widthLabel = 200;

		panelGrid.setWrapCells(true);  
		panelGrid.setFixedRecordHeights(false);  		
		
		/** 
         * -----------------------------------------------------------------------
	     * Configuração Critórios de consulta.    
		 * -----------------------------------------------------------------------
         */ 
		
		propertyFiltroDtSolicitacaoInicio.setBound(widthLabel, 100);
		propertyFiltroDtSolicitacaoFinal.setBound(25, 100);
		
		propertyFiltroDtAprovacaoInicio.setBound(widthLabel, 100);
		propertyFiltroDtAprovacaoFinal.setBound(25, 100);

		
		propertyFiltroDtSolicitacaoInicio.createHowMGWTFormDateItem();
		propertyFiltroDtSolicitacaoFinal.createHowMGWTFormDateItem();		
		propertyFiltroDtAprovacaoInicio.createHowMGWTFormDateItem();
		propertyFiltroDtAprovacaoFinal.createHowMGWTFormDateItem();	
		
		Date hoje = new Date();
		
		int dia = hoje.getDate();
		int month = hoje.getMonth();
		
		Date ontem = new Date( hoje.getYear(), month, dia-1 );
		
		propertyFiltroDtSolicitacaoInicio.getHowMGWTEditorDateItem().getField().setValue(ontem);		
		propertyFiltroDtSolicitacaoFinal.getHowMGWTEditorDateItem().getField().setValue(hoje);

		propertyFiltroDtSolicitacaoInicio.getHowMGWTEditorDateItem().getField().setInputFormat(Tradutor.i18n.formInputFormatDiaMesAno());
		propertyFiltroDtSolicitacaoInicio.getHowMGWTEditorDateItem().getField().setUseMask(true);
		propertyFiltroDtSolicitacaoInicio.getHowMGWTEditorDateItem().getField().setUseTextField(true);

		propertyFiltroDtSolicitacaoFinal.getHowMGWTEditorDateItem().getField().setInputFormat(Tradutor.i18n.formInputFormatDiaMesAno());
		propertyFiltroDtSolicitacaoFinal.getHowMGWTEditorDateItem().getField().setUseMask(true);
		propertyFiltroDtSolicitacaoFinal.getHowMGWTEditorDateItem().getField().setUseTextField(true);
		

		propertyFiltroDtAprovacaoInicio.getHowMGWTEditorDateItem().getField().setInputFormat(Tradutor.i18n.formInputFormatDiaMesAno());
		propertyFiltroDtAprovacaoInicio.getHowMGWTEditorDateItem().getField().setUseMask(true);
		propertyFiltroDtAprovacaoInicio.getHowMGWTEditorDateItem().getField().setUseTextField(true);

		propertyFiltroDtAprovacaoFinal.getHowMGWTEditorDateItem().getField().setInputFormat(Tradutor.i18n.formInputFormatDiaMesAno());
		propertyFiltroDtAprovacaoFinal.getHowMGWTEditorDateItem().getField().setUseMask(true);
		propertyFiltroDtAprovacaoFinal.getHowMGWTEditorDateItem().getField().setUseTextField(true);


		propertyFiltroNumeroNota.setBound(widthLabel, 80);
		propertyFiltroSituacao.setBound(widthLabel,200);
		propertyFiltroCodColaborador.setBound(widthLabel, 80);
		propertyFiltroCodCliente.setBound(widthLabel, 80);
		propertyFiltroCodPedido.setBound(widthLabel, 80);	

		propertyFiltroNumeroNota.createHowMGWTFormFieldTextItem();

		propertyFiltroSituacao.createHowMGWTFormFieldSelectItem();

		LinkedHashMap< String, String> mapSituacoes = new LinkedHashMap<String, String>();
		mapSituacoes.put(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_TODOS, Tradutor.i18n.formSituacaoTodos());
		mapSituacoes.put(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_AGUARDANDO_APROVACAO, Tradutor.i18n.formSituacaoAguardandoAprovacao());
		mapSituacoes.put(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_NAO_APROVADO, Tradutor.i18n.formSituacaoNaoAprovado());
		mapSituacoes.put(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_APROVADO, Tradutor.i18n.formSituacaoAprovado());
		propertyFiltroSituacao.getHowMGWTEditorSelectItem().getField().setValueMap(mapSituacoes);
		propertyFiltroSituacao.getHowMGWTEditorSelectItem().getField().setDefaultValue(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_AGUARDANDO_APROVACAO);

		FactoryUCommerce.createLookupBuscaVendedor(propertyFiltroCodColaborador);
		FactoryUCommerce.createLookupBuscaCliente(propertyFiltroCodCliente);
		FactoryUCommerce.createLookupBuscaPedido(propertyFiltroCodPedido);

		// Data solicitação
		HLayout dtSolicitacaoLayout = new HLayout();
		dtSolicitacaoLayout.setWidth100();
		dtSolicitacaoLayout.setHeight(22);		
		dtSolicitacaoLayout.addMember(propertyFiltroDtSolicitacaoInicio.getCanvas());
		dtSolicitacaoLayout.addMember(propertyFiltroDtSolicitacaoFinal.getCanvas());	

		// Data aprovação/reprovação
		HLayout dtAprovacaoLayout = new HLayout();
		dtAprovacaoLayout.setWidth100();
		dtAprovacaoLayout.setHeight(22);		
		dtAprovacaoLayout.addMember(propertyFiltroDtAprovacaoInicio.getCanvas());
		dtAprovacaoLayout.addMember(propertyFiltroDtAprovacaoFinal.getCanvas());

		mainFiltro.addMember(dtSolicitacaoLayout);
		mainFiltro.addMember(dtAprovacaoLayout);

		mainFiltro.addMember(propertyFiltroNumeroNota.getCanvas());
		mainFiltro.addMember(propertyFiltroSituacao.getCanvas());
		mainFiltro.addMember(propertyFiltroCodColaborador.getCanvas());
		mainFiltro.addMember(propertyFiltroCodCliente.getCanvas());
		mainFiltro.addMember(propertyFiltroCodPedido.getCanvas());

		mainFiltro.addMember(new HowMGWTPanelInstrucaoFiltro());



		/**
		 * ----------------------------------------------------------------------
		 * Cria a grid para listagem das solicitações de devolução
		 * ----------------------------------------------------------------------
		 */
		propertyCodSolicitacaoDevolucao.setType(ListGridFieldType.INTEGER);
		
		propertyCodSolicitacaoDevolucao.setWidthColumn(70);
		propertyDescMotivoDevolucao.setWidthColumn(160);
		
		propertyDescricao.setWidthColumn(300);
		propertySituacao.setWidthColumn(130);
		propertyCodCliente.setWidthColumn(50);
		propertyNomeCliente.setWidthColumn(260);
		propertyDtSolicitacao.setWidthColumn(110);
		propertyDtAprovacao.setWidthColumn(110);
		propertyObsAprovador.setWidthColumn(300);
		
		propertyNomeColaboradorSolicitante.setWidthColumn(100);
		propertyNomeColaboradorAprovador.setWidthColumn(100);
	
		propertyCodSolicitacaoDevolucao.createHowMGWTListGridField();
		propertyDescMotivoDevolucao.createHowMGWTListGridField();
		
		propertyDescricao.createHowMGWTListGridField();
		propertySituacao.createHowMGWTListGridField();
		propertyCodCliente.createHowMGWTListGridField();
		propertyNomeCliente.createHowMGWTListGridField();
		propertyNomeColaboradorSolicitante.createHowMGWTListGridField();

		propertyDtSolicitacao.createHowMGWTListGridField();
		propertyNomeColaboradorAprovador.createHowMGWTListGridField();
		propertyDtAprovacao.createHowMGWTListGridField();
		propertyObsAprovador.createHowMGWTListGridField();

		propertyCodSolicitacaoDevolucao.getListField().setWrap(true);
		propertyDescMotivoDevolucao.getListField().setWrap(true);		
		propertyDescricao.getListField().setWrap(true);
		propertySituacao.getListField().setWrap(true);
		propertyCodCliente.getListField().setWrap(true);
		propertyNomeCliente.getListField().setWrap(true);
		propertyNomeColaboradorSolicitante.getListField().setWrap(true);
		propertyDtSolicitacao.getListField().setWrap(true);
		propertyNomeColaboradorAprovador.getListField().setWrap(true);
		
		propertyDtAprovacao.getListField().setWrap(true);
		propertyObsAprovador.getListField().setWrap(true);

		propertySituacao.getListField().setValueMap(mapSituacoes);
		propertySituacao.getListField().setDefaultValue(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_TODOS);
			
		formToolbarEdit = new HowMGWTFormToolbarEdit(this, panelGrid);
		formToolbarEdit.getPanelList().setHeaderHeight(48);
		
		mainFiltro.setWidth100();
		mainFiltro.setHeight(120);
		this.addMember(mainFiltro);
		
		this.addMember(formToolbarEdit);
		this.addMember(formToolbarEdit.getPanelList());		
		formToolbarEdit.createActionEditar();
		formToolbarEdit.getActionGravar().setVisible(false);
		formToolbarEdit.createActionBuscar();
	

		
		configuraPemissoes();
	}
	
	@Override
	public void start() {
		int widthLabel = 120;
	}


	
	public String getHowMGWTTitle(){
		return Tradutor.i18n.formTituloVDW0031();
	}

	public String getHowMGWTPrograma(){
		return "VDW0031";
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
		editSolicitacao(false);
	}

	
	/**
	 * Carrega os dados do banco de dados.
	 */
	@Override
	public void onHowMLoad(HowMGWTFormBean pFormBean) 
	{
		formToolbarEdit.getPanelList().clearAllRecords();
		
		// -------------------------------------------------------------------------------
		// Grava os dados no servidor.
		// -------------------------------------------------------------------------------
		HowMGWTWindowWait.showWait();		
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true))
					return;

				RecordList recordList = new RecordList();
				ListGridRecord record;
				
				FormBean bean = (FormBean)formBean;
				if ( bean.getSolicitacoesDevolucao() != null ){
					for ( eSolicitacaoDevolucao solicitacaoDevolucao : bean.getSolicitacoesDevolucao()){
						record = new ListGridRecord();
						formToolbarEdit.convertFormBeanToRecord(record, solicitacaoDevolucao );
						recordList.add(record);
					}
				}
				formToolbarEdit.getPanelList().setData(recordList);
				
				HowMGWTWindowWait.hideWait();
			}

			@Override
			public void onError(Throwable err) {
				super.onError(err);
			}			
		};
	
		// Configura os filtros da consulta.
		
		FormBean formBean = new FormBean();
		
		formBean.setDtSolicitacaoInicial(HowMGWTUtilities.getFormatDateDBStart(HowMGWTUtilities.getDate(propertyFiltroDtSolicitacaoInicio.getHowMValue())));
		formBean.setDtSolicitacaoFinal(HowMGWTUtilities.getFormatDateDBStart(HowMGWTUtilities.getDate(propertyFiltroDtSolicitacaoFinal.getHowMValue())));

		formBean.setDtAprovacaoInicial(HowMGWTUtilities.getFormatDateDBStart(HowMGWTUtilities.getDate(propertyFiltroDtAprovacaoInicio.getHowMValue())));
		formBean.setDtAprovacaoFinal(HowMGWTUtilities.getFormatDateDBStart(HowMGWTUtilities.getDate(propertyFiltroDtAprovacaoFinal.getHowMValue())));

		formBean.setNrNotaFiscal(propertyFiltroNumeroNota.getHowMValue());
	  	// private HowMGWTProperty propertyFiltroSerieNota 	  				= propertiesFiltro.createProperty("serieNotaFiscal", 		Tradutor.i18n.formNrNotaFiscal());
	
		formBean.setCodSituacao(propertyFiltroSituacao.getHowMValue());
		formBean.setCodColaborador(propertyFiltroCodColaborador.getHowMValue());
		formBean.setCodCliente(propertyFiltroCodCliente.getHowMValue());
		formBean.setCodPedido(propertyFiltroCodPedido.getHowMValue());
		
		struts.request("vdw0031.do?method=buscar",  "VDW0031Form", formBean.toSendBody("") );								
	}

	@Override
	public void onHowMNewRecord() {
		if ( formToolbarEdit != null && formToolbarEdit.isActionKeyPressed() ){
			formToolbarEdit.newRecord();
			editSolicitacao(true);
		}		
	}

	@Override
	public void onHowMRelation(ListGridRecord record) {}

	@Override
	public void onHowMSave() {}

	@Override
	public void onHowMSetValues(ListGridRecord record) {}
	
	
	public void editSolicitacao(boolean newRecord ) {
		
		if ( windowPanelEditSolicitacaoDevolucao == null )
			windowPanelEditSolicitacaoDevolucao = new WindowPanelEditSolicitacaoDevolucao(this);
		
				
		
		if ( newRecord ){
			// Seta as opções permitidas na edição 
			LinkedHashMap< String, String> mapSituacoesEdicao = new LinkedHashMap<String, String>();
			mapSituacoesEdicao.put(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_AGUARDANDO_APROVACAO, Tradutor.i18n.formSituacaoAguardandoAprovacao());
			mapSituacoesEdicao.put(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_NAO_APROVADO, Tradutor.i18n.formSituacaoNaoAprovado());
			mapSituacoesEdicao.put(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_APROVADO, Tradutor.i18n.formSituacaoAprovado());
			propertySituacao.getHowMGWTEditorSelectItem().getField().setValueMap(mapSituacoesEdicao);
			propertySituacao.getHowMGWTEditorSelectItem().getField().setDefaultValue(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_AGUARDANDO_APROVACAO);
		
			windowPanelEditSolicitacaoDevolucao.newRecord(this.currentFormBean);
		
		}
		else{
			ListGridRecord selectRecord = formToolbarEdit.getPanelList().getSelectedRecord();

			if ( HowMGWTUtilities.isEquals( propertySituacao.getHowMValue(selectRecord), UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_AGUARDANDO_APROVACAO )){
				// Seta as opções permitidas na edição 
				LinkedHashMap< String, String> mapSituacoesEdicao = new LinkedHashMap<String, String>();
				mapSituacoesEdicao.put(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_AGUARDANDO_APROVACAO, Tradutor.i18n.formSituacaoAguardandoAprovacao());
				
				mapSituacoesEdicao.put(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_NAO_APROVADO, Tradutor.i18n.formSituacaoNaoAprovado());
				mapSituacoesEdicao.put(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_APROVADO, Tradutor.i18n.formSituacaoAprovado());
				
				
				propertySituacao.getHowMGWTEditorSelectItem().getField().setValueMap(mapSituacoesEdicao);
				propertySituacao.getHowMGWTEditorSelectItem().getField().setDefaultValue(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_AGUARDANDO_APROVACAO);
			}
			else if ( HowMGWTUtilities.isEquals( propertySituacao.getHowMValue(selectRecord), UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_NAO_APROVADO )){
				// Seta as opções permitidas na edição 
				LinkedHashMap< String, String> mapSituacoesEdicao = new LinkedHashMap<String, String>();
				mapSituacoesEdicao.put(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_NAO_APROVADO, Tradutor.i18n.formSituacaoNaoAprovado());
				propertySituacao.getHowMGWTEditorSelectItem().getField().setValueMap(mapSituacoesEdicao);
				propertySituacao.getHowMGWTEditorSelectItem().getField().setDefaultValue(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_NAO_APROVADO);
			}
			else if ( HowMGWTUtilities.isEquals( propertySituacao.getHowMValue(selectRecord), UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_APROVADO )){
				// Seta as opções permitidas na edição 
				LinkedHashMap< String, String> mapSituacoesEdicao = new LinkedHashMap<String, String>();
				mapSituacoesEdicao.put(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_APROVADO, Tradutor.i18n.formSituacaoNaoAprovado());
				propertySituacao.getHowMGWTEditorSelectItem().getField().setValueMap(mapSituacoesEdicao);
				propertySituacao.getHowMGWTEditorSelectItem().getField().setDefaultValue(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_APROVADO);
			}		
			windowPanelEditSolicitacaoDevolucao.editRecord(this.currentFormBean, selectRecord, showDetalhes);
		}
	}
	
	
	
	/**
	 * -----------------------------------------------------------------------
	 * Propriedades compartilhadas.
	 * -----------------------------------------------------------------------
	 */

	/**
	 * @return the properties
	 */
	public HowMGWTFormProperties getProperties() {
		return properties;
	}

	/**
	 * @return the formToolbarEdit
	 */
	public HowMGWTFormToolbarEdit getFormToolbarEdit() {
		return formToolbarEdit;
	}

	/**
	 * @return the propertyCodSolicitacaoDevolucao
	 */
	public HowMGWTProperty getPropertyCodSolicitacaoDevolucao() {
		return propertyCodSolicitacaoDevolucao;
	}

	/**
	 * @return the propertyCodMotivoDevolucao
	 */
	public HowMGWTProperty getPropertyCodMotivoDevolucao() {
		return propertyCodMotivoDevolucao;
	}

	/**
	 * @return the propertyDescricao
	 */
	public HowMGWTProperty getPropertyDescricao() {
		return propertyDescricao;
	}

	/**
	 * @return the propertySituacao
	 */
	public HowMGWTProperty getPropertySituacao() {
		return propertySituacao;
	}

	/**
	 * @return the propertyCodCliente
	 */
	public HowMGWTProperty getPropertyCodCliente() {
		return propertyCodCliente;
	}

	/**
	 * @return the propertyNomeCliente
	 */
	public HowMGWTProperty getPropertyNomeCliente() {
		return propertyNomeCliente;
	}

	/**
	 * @return the propertyCodColaboradorSolicitante
	 */
	public HowMGWTProperty getPropertyCodColaboradorSolicitante() {
		return propertyCodColaboradorSolicitante;
	}

	/**
	 * @return the propertyDtSolicitacao
	 */
	public HowMGWTProperty getPropertyDtSolicitacao() {
		return propertyDtSolicitacao;
	}

	/**
	 * @return the propertyCodColaboradorAprovador
	 */
	public HowMGWTProperty getPropertyCodColaboradorAprovador() {
		return propertyCodColaboradorAprovador;
	}

	/**
	 * @return the propertyDtAprovacao
	 */
	public HowMGWTProperty getPropertyDtAprovacao() {
		return propertyDtAprovacao;
	}

	/**
	 * @return the propertyObsAprovador
	 */
	public HowMGWTProperty getPropertyObsAprovador() {
		return propertyObsAprovador;
	}

	/**
	 * @return the propertyCodColaborador
	 */
	public HowMGWTProperty getPropertyCodColaborador() {
		return propertyCodColaborador;
	}

	/**
	 * @return the propertyNomeColaborador
	 */
	public HowMGWTProperty getPropertyNomeColaborador() {
		return propertyNomeColaborador;
	}

	/**
	 * @return the propertyNomeColaboradorSolicitante
	 */
	public HowMGWTProperty getPropertyNomeColaboradorSolicitante() {
		return propertyNomeColaboradorSolicitante;
	}

	/**
	 * @return the propertyNomeColaboradorAprovador
	 */
	public HowMGWTProperty getPropertyNomeColaboradorAprovador() {
		return propertyNomeColaboradorAprovador;
	}	
	
	
	
	
	
	public void configuraPemissoes(){
		FormBean formBean = new FormBean();
		
		formToolbarEdit.getActionNovo().setDisabled(true);
		this.showDetalhes = false;
		// -------------------------------------------------------------------------------
		// Grava os dados no servidor.
		// -------------------------------------------------------------------------------
		HowMGWTWindowWait.showWait();		
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true))
					return;

				FormBean bean = (FormBean)formBean;
				currentFormBean = bean;
				/**
				 * Se tiver permissão para cadastrar, permite editar a solicitação
				 * somente se estiver com a situação Aguardando aprovação.
				 */
				if ( "true".equals(bean.getPermiteCadastrarSolicitacaoDevolucao()) ){
					formToolbarEdit.getActionNovo().setVisible(true);					
				}
				else{
					formToolbarEdit.getActionNovo().setVisible(false);
				}
				
				
				/**
				 * Se tiver permissão para aprovar ou rejeitar permite edição da solicitação.
				 */
				if ( "true".equals(currentFormBean.getPermiteAprovacaoReprovacaoSolicitacaoDevolucao()) 
					 ||
					 "true".equals(currentFormBean.getPermiteCadastrarSolicitacaoDevolucao())
				){
					formToolbarEdit.getActionEditar().setVisible(true);
				}
				else{
					formToolbarEdit.getActionEditar().setVisible(false);					
				}
								
				HowMGWTWindowWait.hideWait();
				formToolbarEdit.getActionNovo().setDisabled(false);

				if ( ! formToolbarEdit.getActionEditar().isVisible() && !formToolbarEdit.getActionNovo().isVisible() ){
					formToolbarEdit.getActionEditar().setVisible(true);					
					formToolbarEdit.getActionEditar().setTitle("Detalhes");
					showDetalhes = true;
				}			
			}

			@Override
			public void onError(Throwable err) {
				formToolbarEdit.getActionNovo().setDisabled(false);
				super.onError(err);
			}			
		};

		eSolicitacaoDevolucao solicitacao = new eSolicitacaoDevolucao();		
		solicitacao.setCodSolicitacaoDevolucao("");
		formBean.setSolicitacaoDevolucao(solicitacao);

		String body = HowMGWTUtilities.getGWTBeanTransfer(formBean.toJsonObject("").toString());

		
		struts.request("vdw0031.do?method=configuraSolicitacaoDevolucao",  "VDW0031Form", body);	
	}

	/**
	 * @return the currentFormBean
	 */
	public FormBean getCurrentFormBean() {
		return currentFormBean;
	}

	/**
	 * @return the propertyDescMotivoDevolucao
	 */
	public HowMGWTProperty getPropertyDescMotivoDevolucao() {
		return propertyDescMotivoDevolucao;
	}

}
