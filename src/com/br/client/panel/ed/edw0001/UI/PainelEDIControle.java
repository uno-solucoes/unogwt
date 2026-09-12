package com.br.client.panel.ed.edw0001.UI;

import java.util.LinkedHashMap;

import com.br.client.model.ed.edw0001.FormBean;
import com.br.client.model.ed.entity.eEDI;
import com.br.client.model.ed.entity.eEDIProduto;
import com.br.client.model.ed.entity.eEDISituacoes;
import com.br.client.model.eq.entity.eDeposito;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.FactoryUCommerce;
import com.br.client.panel.business.UI.UCFieldLookupBuscaFornecedor;
import com.br.client.panel.vd.vdq0002.UI.PainelGerenciador;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.howmake.client.form.UI.HowMGWTFormToolbarEdit;
import com.howmake.client.form.UI.HowMGWTLabel;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.control.HowMGWTControlForm;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
 
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelEDIControle extends VLayout implements HowMGWTControlForm{

	private Img actionLixeira;
	private Img actionVoltarLixeira;
	
	private PainelEDIListaProdutos painelEDIListaProdutos = new PainelEDIListaProdutos();
	
	private PainelGerenciador painelBuscaProduto;
	
	private HowMGWTFormProperties properties = new HowMGWTFormProperties(){
		public void onHowMChangeLookup(HowMGWTProperty property) {
			if ( property == propertyCodFornecedor ){
				getPainelBuscaProduto().getFiltroConsulta().setCodFonecedor(""+property.getFormField().getHowMValue());
			}
		};
	};

	private ListGridRecord currentRecord = null;
	/**
	 * Declara as propriedades de edição do formulório.
	 */
	public HowMGWTProperty propertyCodEDI					 	= properties.createProperty("codEdi"						, Tradutor.i18n.formReg());
	public HowMGWTProperty propertyAmbiente						= properties.createProperty("indAmbiente"					, Tradutor.i18n.formAmbiente());
	public HowMGWTProperty propertyNomeServico			 	 	= properties.createProperty("nomeServico"					, Tradutor.i18n.formNomeServico());	
	public HowMGWTProperty propertyEnderecoServico 			 	= properties.createProperty("enderecoWebService"			, Tradutor.i18n.formEnderecoServico());
	public HowMGWTProperty propertyUsuario 					 	= properties.createProperty("usuario"						, Tradutor.i18n.formUsuario());
	public HowMGWTProperty propertySenha 						= properties.createProperty("senha"							, Tradutor.i18n.formSenha());
	public HowMGWTProperty propertySituacaoReservaEstoque 		= properties.createProperty("situacaoPedidoReserva"			, Tradutor.i18n.formSituacaoReservaEstoque());
	public HowMGWTProperty propertySituacaoConfirmacaoPedido  	= properties.createProperty("situacaoPedidoEfetivacao"	 	, Tradutor.i18n.formSituacaoConfirmacaoPedido());
	public HowMGWTProperty propertyClasseNegocio 			    = properties.createProperty("classeBO"						, Tradutor.i18n.formClasseNegocio());
	public HowMGWTProperty propertyDeposito				 		= properties.createProperty("codDeposito"					, Tradutor.i18n.formDeposito());
	public HowMGWTProperty propertyCodEmpresa				 	= properties.createProperty("codEmpresa"					, Tradutor.i18n.formCodEmpresa());
	
	public HowMGWTProperty propertyCrontabFrequencia			= properties.createProperty("crontabFrequencia"				, Tradutor.i18n.formCrontabFrequencia());
	public HowMGWTProperty propertyCrontabTipoFrequencia		= properties.createProperty("crontabTipoFrequencia"			, Tradutor.i18n.formCrontabTipoFrequencia());
	
	public HowMGWTProperty propertyNrErrosEnvioEmail			= properties.createProperty("nrErrosEnvioEmail"				, Tradutor.i18n.formNrErrosEnvioEmail());
	public HowMGWTProperty propertyEMail						= properties.createProperty("eMail"							, Tradutor.i18n.formEMailAdministrador());
	public HowMGWTProperty propertyTipoEntregaCorreio			= properties.createProperty("tipoEntregaCorreio"			, Tradutor.i18n.formTipoEntregaCorreio());

	public HowMGWTProperty propertyCodFornecedor				= properties.createProperty("codFornecedor"					, Tradutor.i18n.formCodFornecedor());
	public HowMGWTProperty propertyNomeFornecedor				= properties.createProperty("nomeFornecedor"				, Tradutor.i18n.formNomeFornecedor());
		
	// Cria a instancia da listagem somente após a configuração dos dados 
	// das propriedades
	
	private HowMGWTFormToolbarEdit formToolbarEdit;

	/*
	 * Construtor padrão
	 */
	public PainelEDIControle(){
		 
		this.setWidth100();
		this.setHeight(220);
		
		int widthLabel = 130;
		
		HLayout mainLayout = new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		VLayout layoutEDI = new VLayout();
		layoutEDI.setWidth100();
		layoutEDI.setHeight100();
		
		HLayout hEdiAmbiente = new HLayout();
		hEdiAmbiente.setWidth100();
		hEdiAmbiente.setHeight(22);
		
		propertyCodEDI.setBound(widthLabel, 40);
		propertyCodEDI.setWidthColumn(40);
		propertyCodEDI.createHowMGWTFormFieldTextItem();
		propertyCodEDI.createHowMGWTListGridField();

		propertyAmbiente.setBound(100, 110);
		propertyAmbiente.createHowMGWTFormFieldSelectItem();
		
		hEdiAmbiente.addMember(propertyCodEDI.getCanvas());
		hEdiAmbiente.addMember(propertyAmbiente.getCanvas());
		
		
		
		propertyNomeServico.setBound(widthLabel, 380);
		propertyNomeServico.createHowMGWTFormFieldTextItem();
		propertyNomeServico.createHowMGWTListGridField();
		propertyNomeServico.setMandatory(true);
		
		propertyEnderecoServico.setBound(widthLabel, 380);
		propertyEnderecoServico.createHowMGWTFormFieldTextItem();
		propertyEnderecoServico.setMandatory(true);
		
		// Cria um layout para incluir dois campos na horizontal.
		// --------------------------------------------------------------------------
		HLayout hUsuarioSenha = new HLayout();
		hUsuarioSenha.setWidth100();
		hUsuarioSenha.setHeight(22);
		
		propertyUsuario.setBound(widthLabel, 122);
		propertyUsuario.createHowMGWTFormFieldTextItem();
		propertyUsuario.setMandatory(true);
		
		propertySenha.setBound(widthLabel, 122);
		propertySenha.createHowMGWTFormFieldPasswordItem();
		propertySenha.setMandatory(true);
		
		
		hUsuarioSenha.addMember(propertyUsuario.getCanvas());
		hUsuarioSenha.addMember(propertySenha.getCanvas());
		
		
		// Inclui um layout para incluir dois campos na horizontal.
		HLayout hSituacoes = new HLayout();
		hSituacoes.setWidth100();
		hSituacoes.setHeight(22);
		propertySituacaoReservaEstoque.setBound(widthLabel, 122);
		propertySituacaoReservaEstoque.createHowMGWTFormFieldSelectItem();
		propertySituacaoReservaEstoque.setMandatory(true);
		
		propertySituacaoConfirmacaoPedido.setBound(widthLabel, 122);
		propertySituacaoConfirmacaoPedido.createHowMGWTFormFieldSelectItem();
		propertySituacaoConfirmacaoPedido.setMandatory(true);
		
		hSituacoes.addMember(propertySituacaoReservaEstoque.getCanvas());
		hSituacoes.addMember(propertySituacaoConfirmacaoPedido.getCanvas());
	
		
		
		propertyClasseNegocio.setBound(widthLabel, 380);
		propertyClasseNegocio.createHowMGWTFormFieldSelectItem();
		propertyClasseNegocio.setMandatory(true);

		
		propertyDeposito.setBound(widthLabel, 150);
		propertyDeposito.createHowMGWTFormFieldSelectItem();
		propertyDeposito.setMandatory(true);

		propertyCodFornecedor.setMandatory(true);
		propertyCodFornecedor.setBound(widthLabel, 80);
		FactoryUCommerce.createLookupBuscaFornecedor(propertyCodFornecedor);

		
		
		// Criar Toolbar 
		// Cria o objeto de toolbar e adiciona no topo do formulório de controle.
		this.formToolbarEdit = new HowMGWTFormToolbarEdit(this);
		this.addMember(formToolbarEdit);

		
		// Acionar membros no Layout.
		layoutEDI.addMember(hEdiAmbiente);
		layoutEDI.addMember(this.propertyNomeServico.getCanvas());
		layoutEDI.addMember(this.propertyEnderecoServico.getCanvas());
		layoutEDI.addMember(hUsuarioSenha);
		layoutEDI.addMember(hSituacoes);
		layoutEDI.addMember(propertyClasseNegocio.getCanvas());
		layoutEDI.addMember(propertyDeposito.getCanvas());
		layoutEDI.addMember(propertyCodFornecedor.getCanvas());
		
		layoutEDI.setWidth(400);
		mainLayout.addMember(layoutEDI);
		
		
		/** 
		 * --------------------------------------------------------------- 
		 * Configuração Crontab.
		 * --------------------------------------------------------------- 
		 */		
		VLayout vMainLayoutCrontab = new VLayout();
		vMainLayoutCrontab.setWidth100();
		vMainLayoutCrontab.setHeight100();
		vMainLayoutCrontab.setBackgroundColor("#fff55f");


		HowMGWTLabel labelTitulo = new HowMGWTLabel("<font color=blue size=+1>"+Tradutor.i18n.formCrontab()+"</font>");
		labelTitulo.setWidth100();
		labelTitulo.setHeight(22);
		vMainLayoutCrontab.addMember(labelTitulo);

		
		HLayout hLayoutCrontab = new HLayout();
		hLayoutCrontab.setWidth100();
		hLayoutCrontab.setHeight(56);

		Img img = new Img();
		img.setSrc("logos/logo_crontab.png");
		img.setWidth(64);
		img.setHeight(64);		
		hLayoutCrontab.addMember(img);		
		
		VLayout layoutCrontab = new VLayout();
		layoutCrontab.setWidth100();
		layoutCrontab.setHeight100();
				
		int widthLabelCrontab = 140;
		
		propertyCrontabFrequencia.setBound(widthLabelCrontab, 60);
		propertyCrontabTipoFrequencia.setBound(widthLabelCrontab, 100);

		propertyCrontabFrequencia.createHowMGWTFormFieldTextItem();
		propertyCrontabTipoFrequencia.createHowMGWTFormFieldSelectItem();

		propertyCrontabFrequencia.getHowMGWTEditorFieldText().setHowMValue("1");
		
		LinkedHashMap< String, String > tipoFrequenciaBO = new LinkedHashMap<String, String>();
		
		tipoFrequenciaBO.put("Dia",  "Dia");
		tipoFrequenciaBO.put("Hora", "Hora");
		tipoFrequenciaBO.put("Minuto", "Minuto");
		
		this.propertyCrontabTipoFrequencia.getHowMGWTEditorSelectItem().getField().setDefaultValue("Dia");
		this.propertyCrontabTipoFrequencia.getHowMGWTEditorSelectItem().getField().setValueMap(tipoFrequenciaBO);
		 
		layoutCrontab.addMember(this.propertyCrontabFrequencia.getCanvas());
		layoutCrontab.addMember(this.propertyCrontabTipoFrequencia.getCanvas());
		
		hLayoutCrontab.addMember(layoutCrontab);

	
		vMainLayoutCrontab.addMember(hLayoutCrontab);

		/** 
		 * --------------------------------------------------------------- 
		 * Configurações Adaministrativas
		 * --------------------------------------------------------------- 
		 */

		int widthOtherLabel = 200;
		propertyNrErrosEnvioEmail.setBound(widthOtherLabel, 60);
		propertyEMail.setBound(widthOtherLabel, 200);

		propertyNrErrosEnvioEmail.createHowMGWTFormFieldTextItem();
		propertyEMail.createHowMGWTFormFieldTextItem();
		
		vMainLayoutCrontab.addMember(propertyNrErrosEnvioEmail.getCanvas());
		vMainLayoutCrontab.addMember(propertyEMail.getCanvas());
		

		/** 
		 * --------------------------------------------------------------- 
		 * Outras informações administrativas.
		 * --------------------------------------------------------------- 
		 */
		
		VLayout outrasInf = new VLayout();
		outrasInf.setWidth100();
		outrasInf.setHeight100();
		outrasInf.setBackgroundColor("#ffffff");
		

		HowMGWTLabel labelTituloECommerce = new HowMGWTLabel("<font color=blue size=+1>"+Tradutor.i18n.formConfiguracoesAdicionais()+"</font>");
		labelTitulo.setWidth100();
		labelTitulo.setHeight(22);
		outrasInf.addMember(labelTituloECommerce);
		
		
		propertyTipoEntregaCorreio.setBound(widthOtherLabel, 120);
		
		propertyTipoEntregaCorreio.createHowMGWTFormFieldSelectItem();

		LinkedHashMap< String, String > tipoEntregaCorreio = new LinkedHashMap<String, String>();
		
		tipoEntregaCorreio.put("1", "SEDEX");
		tipoEntregaCorreio.put("2", "E-SEDEX");
		tipoEntregaCorreio.put("3", "PAC");
		
		this.propertyTipoEntregaCorreio.getHowMGWTEditorSelectItem().getField().setDefaultValue("1");
		this.propertyTipoEntregaCorreio.getHowMGWTEditorSelectItem().getField().setValueMap(tipoEntregaCorreio);
		
		
		outrasInf.addMember(propertyTipoEntregaCorreio.getCanvas());
		
		
		
		vMainLayoutCrontab.addMember(outrasInf);
		
		
		mainLayout.addMember(vMainLayoutCrontab);
		
		this.addMember(mainLayout);
	}
  
	/**
	 * @return the formToolbarEdit
	 */
	public HowMGWTFormToolbarEdit getFormToolbarEdit() {
		return formToolbarEdit;
	}	
	

	/**
	 * @return the painelEDIListaProdutos
	 */
	public PainelEDIListaProdutos getPainelEDIListaProdutos() {
		return painelEDIListaProdutos;
	}
 	
	
	
	
	
	
	// ------------------------------------------------------------------------
	// Implementação da interface de controle do formulório.
	// ------------------------------------------------------------------------
	 
	
	/**
	 * Retorna as propriedades do formulório.
	 */
	public HowMGWTFormProperties getHowMProperties(){
		return properties;
	}
	
	/**
	 * Carrega os dados para a cache prepara os dados para visualização do usuório.
	 */
	@Override
	public void onHowMLoad(HowMGWTFormBean formBean) {
				
		getPainelEDIListaProdutos().onHowMRelation(null);
		this.formToolbarEdit.getPanelList().clearAllRecords();
		
		RecordList records = new RecordList();
		FormBean bean = (FormBean)formBean;		  
		
		// -------------------------------------------------------------------
		// Ambiente 
		// -------------------------------------------------------------------
		LinkedHashMap< String, String > ambiente = new LinkedHashMap<String, String>();
		ambiente.put("0", Tradutor.i18n.formTipoAmbienteHomologacao());
		ambiente.put("1", Tradutor.i18n.formTipoAmbienteProducao());		
		this.propertyAmbiente.getHowMGWTEditorSelectItem().getField().setDefaultValue("0");
		this.propertyAmbiente.getHowMGWTEditorSelectItem().getField().setValueMap(ambiente);
		
		// -------------------------------------------------------------------
		// Carrega classesNegocio
		// -------------------------------------------------------------------
		LinkedHashMap< String, String > classesBO = new LinkedHashMap<String, String>();
		String classePadrao = "";

		if ( bean.getClassesBO() != null ){
			for( String classeBO : bean.getClassesBO() ){
				classesBO.put(classeBO, classeBO);
				if( HowMGWTUtilities.isEmpty(classePadrao))
					classePadrao = classeBO;
			}
		}else{
			classesBO.put("",  "");
			this.propertyClasseNegocio.getHowMGWTEditorSelectItem().getField().setDefaultValue(classePadrao);
		}
		this.propertyClasseNegocio.getHowMGWTEditorSelectItem().getField().setValueMap(classesBO);
		 
		
		
		// -------------------------------------------------------------------
		// Carrega os depositos		
		// -------------------------------------------------------------------
		LinkedHashMap< String, String > depositos = new LinkedHashMap<String, String>();
		String depositoPadrao = "";
		if ( bean.getDepositos() != null ){
			for( eDeposito deposito : bean.getDepositos() ){
				depositos.put(deposito.getCodDeposito(), deposito.getDescAbrev());
				if( HowMGWTUtilities.isEmpty(depositoPadrao))
					depositoPadrao = deposito.getCodDeposito();
			}
		}else{
			depositos.put("",  "");
			this.propertyDeposito.getHowMGWTEditorSelectItem().getField().setDefaultValue(depositoPadrao);
		}
		this.propertyDeposito.getHowMGWTEditorSelectItem().getField().setValueMap(depositos);

		
		
		// -------------------------------------------------------------------
		// Carrega os dados de situações do Pedido
		// -------------------------------------------------------------------
		LinkedHashMap< String, String > situacoes = new LinkedHashMap<String, String>();
		String situacaoPadrao = "";
		if ( bean.getSituacoes() != null ){
			for( eEDISituacoes situacao : bean.getSituacoes() ){
				situacoes.put(situacao.getCodSituacao(), situacao.getDescricao());
				if( HowMGWTUtilities.isEmpty(depositoPadrao))
					situacaoPadrao = situacao.getCodSituacao();
			}
		}else{
			situacoes.put("",  "");
			this.propertySituacaoConfirmacaoPedido.getHowMGWTEditorSelectItem().getField().setDefaultValue(situacaoPadrao);
			this.propertySituacaoReservaEstoque.getHowMGWTEditorSelectItem().getField().setDefaultValue(situacaoPadrao);
		}
		this.propertySituacaoConfirmacaoPedido.getHowMGWTEditorSelectItem().getField().setValueMap(situacoes);
		this.propertySituacaoReservaEstoque.getHowMGWTEditorSelectItem().getField().setValueMap(situacoes);
		
						
		
		// -------------------------------------------------------------------
		// Carrega os dados de EDIs.
		// -------------------------------------------------------------------
		currentRecord = null;
		
		if( bean.getEdis() != null ){
			// Carrega os dados de EDI e prepara a visualização para o 
			// usuório.
			for ( eEDI edi : bean.getEdis() ){
				ListGridRecord record = new ListGridRecord();
				for ( HowMGWTProperty prop : this.getHowMProperties().getProperties() ){
					record.setAttribute(prop.getName(), edi.toString(prop.getName()));
				}
				((UCFieldLookupBuscaFornecedor)propertyCodFornecedor.getCanvas()).getMessageLabel().setHowMValue(propertyNomeFornecedor.getHowMValue(record));
				records.add(record);
				if ( currentRecord == null )
					currentRecord = record;
			}
		}
		// Aciona o controlador para carregar os dados
		this.formToolbarEdit.getPanelList().setData(records);
		if ( currentRecord != null  ){
			formToolbarEdit.getPanelList().selectRecord(currentRecord);
			formToolbarEdit.onHowMConfigureStatus(currentRecord);					
		}
		
	}

	/**
	 * Seta os valores selecionados no resultado e apresenta no painel.
	 */
	public void onHowMSetValues(ListGridRecord record){
		
		// Se objeto já estiver criado então limpa os dados da tela.
		if ( painelBuscaProduto != null )
			painelBuscaProduto.clearAllScreen();
		
		for ( HowMGWTProperty prop : this.getHowMProperties().getProperties() ){
			if( prop.getFormField() != null ){
				prop.getFormField().setHowMValue(record.getAttributeAsObject(prop.getName()));
				// Removido o campo editar para não precisar controlar o enable e disable de todas as 
				// funcionalidades.
				// prop.getFormField().setHowMDisable(true);
			}
		}
		if ( record != null ){
			((UCFieldLookupBuscaFornecedor)propertyCodFornecedor.getCanvas()).getMessageLabel().setHowMValue(propertyNomeFornecedor.getHowMValue(record));	
		}
		
		getPainelBuscaProduto().getFiltroConsulta().setCodFonecedor(""+propertyCodFornecedor.getFormField().getHowMValue());
		
		getPainelEDIListaProdutos().onHowMRelation(record);

	}
 
	/**
	 * Evento disparado quando o botão da barra de ferramentas é pressionado.
	 */
	@Override
	public void onHowMDeleteRecord() {
		// TODO Auto-generated method stub
		
	}
 
	/**
	 * Coloca a tela em modo edição
	 */
	@Override
	public void onHowMEditRecord() {
		for ( HowMGWTProperty prop : this.getHowMProperties().getProperties() ){
			if( prop.getFormField() != null ){
				prop.getFormField().setHowMDisable(false);
			}
		}	
		propertyCodEDI.getFormField().setHowMDisable(true);		
	}
 
	/**
	 * Prepara a tela para um novo registro.
	 */
	@Override
	public void onHowMNewRecord() {
		// Se objeto já estiver criado então limpa os dados da tela.
		if ( painelBuscaProduto != null )
			painelBuscaProduto.clearAllScreen();
		
		for ( HowMGWTProperty prop : this.getHowMProperties().getProperties() ){
			if( prop.getFormField() != null ){
				prop.getFormField().setHowMDisable(false);
				prop.getFormField().setHowMValue(null);
			}
		}	
		((UCFieldLookupBuscaFornecedor)propertyCodFornecedor.getCanvas()).getMessageLabel().setHowMValue("");	

		propertyCodEDI.getFormField().setHowMDisable(true);
		
		getPainelEDIListaProdutos().onHowMRelation(null);
	}
 
	
	
	
	
	/**
	 * Evento disparado quando o botão gravar da barra de ferramentas é pressionado.
	 */
	@Override
	public void onHowMSave() {
		
		HowMGWTWindowWait.showWait();		
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				HowMGWTWindowWait.hideWait();

				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true ) )
					return;
				
				String msg = ((UCFieldLookupBuscaFornecedor)propertyCodFornecedor.getCanvas()).getMessageLabel().getHowMValueAsString();
				
				ListGridRecord record;
				FormBean bean = (FormBean)formBean;
				if ( HowMGWTUtilities.isEmpty(propertyCodEDI.getHowMValue()) ){
					propertyCodEDI.getFormField().setHowMValue(bean.getEdi().getCodEdi());
					record = formToolbarEdit.addRecord();
				}
				else{
					record = formToolbarEdit.refreshRecord();
				}
				getPainelEDIListaProdutos().onHowMRelation(record);

				record.setAttribute(propertyNomeFornecedor.getName(), msg );

				((UCFieldLookupBuscaFornecedor)propertyCodFornecedor.getCanvas()).getMessageLabel().setHowMValue(msg);
				
				SC.say("Registro gravado com sucesso...");
			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
			}			
		};			
		
		eEDI edi = new eEDI();
		edi.setCodEmpresa(propertyCodEmpresa.getHowMValue(this.formToolbarEdit.getPanelList().getSelectedRecord()));
		edi.setCodEdi(this.propertyCodEDI.getHowMValue());
		edi.setNomeServico(this.propertyNomeServico.getHowMValue());
		edi.setEnderecoWebService(this.propertyEnderecoServico.getHowMValue());
		edi.setUsuario(this.propertyUsuario.getHowMValue());
		edi.setSenha(this.propertySenha.getHowMValue());
		edi.setSituacaoPedidoEfetivacao(this.propertySituacaoConfirmacaoPedido.getHowMValue());
		edi.setSituacaoPedidoReserva(this.propertySituacaoReservaEstoque.getHowMValue());
		edi.setClasseBO(this.propertyClasseNegocio.getHowMValue());
		edi.setCodDeposito(this.propertyDeposito.getHowMValue());
		edi.setIndAmbiente(this.propertyAmbiente.getHowMValue());
		edi.setCrontabFrequencia(this.propertyCrontabFrequencia.getHowMValue());
		edi.setCrontabTipoFrequencia(this.propertyCrontabTipoFrequencia.getHowMValue());
		
		
		
		edi.setNrErrosEnvioEmail(this.propertyNrErrosEnvioEmail.getHowMValue());
		edi.setEMail(this.propertyEMail.getHowMValue());
		edi.setTipoEntregaCorreio(this.propertyTipoEntregaCorreio.getHowMValue());
		
		edi.setCodFornecedor(this.propertyCodFornecedor.getHowMValue());
		
		
		if ( HowMGWTUtilities.isEmpty(edi.getCodEdi()) ) 
			edi.setOperacao(HowMGWTUtilities.OPERATION_INSERT );
		else
			edi.setOperacao(HowMGWTUtilities.OPERATION_UPDATE );
		
		eEDIProduto[] ediProdutos = this.getPainelEDIListaProdutos().getItens();
				
		JSONArray array = new JSONArray();
		int i = 0 ;
		for ( eEDIProduto cItem :  ediProdutos ){
			JSONObject object = cItem.toJsonObject("");
			 array.set(i, object);
			 i ++ ;
		}

		JSONObject objectBean = new JSONObject();
		objectBean.put("edi",  			edi.toJsonObject(""));
		objectBean.put("ediProdutos", 	array);

		String body = HowMGWTUtilities.getGWTBeanTransfer(objectBean.toString());

		struts.request("edw0001.do?method=gravarEDI",  "EDW0001Form", body);			 		
	}	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// --------------------------------------------------------------------------
	// Carga de dados 
	// --------------------------------------------------------------------------
 
	/**
	 * Executa a consulta no banco de dados.
	 */
	public void executeQuery(){
		HowMGWTWindowWait.showWait();		
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true ) ){
					HowMGWTWindowWait.hideWait();
					return;
				}

				onHowMLoad(formBean);
				HowMGWTWindowWait.hideWait();
			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
				formToolbarEdit.onHowMConfigureStatusNewRecord();
			}			
		};					 
		String body = "";
		struts.request("edw0001.do?method=buscarEDI",  "EDW0001Form", body);				
	}

	@Override
	public void onHowMRelation(ListGridRecord record) {}

	/**
	 * @return the painelBuscaProduto
	 */
	public PainelGerenciador getPainelBuscaProduto() {
		return painelBuscaProduto;
	}

	/**
	 * @param painelBuscaProduto the painelBuscaProduto to set
	 */
	public void setPainelBuscaProduto(PainelGerenciador painelBuscaProduto) {
		this.painelBuscaProduto = painelBuscaProduto;
	}

	/**
	 * @return the actionLixeira
	 */
	public Img getActionLixeira() {
		return actionLixeira;
	}

	/**
	 * @param actionLixeira the actionLixeira to set
	 */
	public void setActionLixeira(Img actionLixeira) {
		this.actionLixeira = actionLixeira;
	}

	/**
	 * @return the actionVoltarLixeira
	 */
	public Img getActionVoltarLixeira() {
		return actionVoltarLixeira;
	}

	/**
	 * @param actionVoltarLixeira the actionVoltarLixeira to set
	 */
	public void setActionVoltarLixeira(Img actionVoltarLixeira) {
		this.actionVoltarLixeira = actionVoltarLixeira;
	}

	
	
}
