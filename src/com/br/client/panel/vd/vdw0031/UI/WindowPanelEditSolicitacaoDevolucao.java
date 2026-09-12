package com.br.client.panel.vd.vdw0031.UI;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import com.br.client.configuracao.UcommerceConstantes;
import com.br.client.model.vd.entity.eMotivoDevolucao;
import com.br.client.model.vd.entity.eNotaFiscalItemEtq;
import com.br.client.model.vd.entity.eSolicitacaoDevolucao;
import com.br.client.model.vd.entity.eSolicitacaoDevolucaoItem;
import com.br.client.model.vd.vdw0031.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.FactoryUCommerce;
import com.br.client.panel.eq.eqd0018.WindowPainelNotasFiscais;
import com.howmake.client.form.UI.HowMGWTFormToolbarEdit;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.control.HowMGWTControlForm;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;

public class WindowPanelEditSolicitacaoDevolucao extends HowMGWTWindow implements HowMGWTControlForm{

	private boolean novoRegistro = true;
	private boolean excluirRegistro = true;
	
	private boolean showDetalhes;
	
	private WindowPainelNotasFiscais windowPainelNotasFiscais;
	
	private ListGridRecord currentRecord;
	private eSolicitacaoDevolucao currentSolicitacaoDevolucao;
	private FormBean currentFormBean;

	private PainelSolicitacaoDevolucao parentPanel;

	private VLayout mainLayout = new VLayout();
	private VLayout mainForm = new VLayout();
	private VLayout mainFormAprovacaoShow = new VLayout();
	private VLayout mainFormAprovacao = new VLayout();

	private IButton actionSelecionarNotasFiscais = new IButton(Tradutor.i18n.formSelecionarNotasFiscais());
	
	private HowMGWTFormToolbarEdit formToolbarEdit;

	private PainelSolicitacaoDevolucaoItem painelSolicitacaoDevolucaoItem ;

	public WindowPanelEditSolicitacaoDevolucao(PainelSolicitacaoDevolucao parentPanel){

		painelSolicitacaoDevolucaoItem = new PainelSolicitacaoDevolucaoItem(this);
		actionSelecionarNotasFiscais.setWidth(120);
		actionSelecionarNotasFiscais.setIcon("actions/nf.png");
		actionSelecionarNotasFiscais.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				selecionarNotas();
			}
		});
		
		mainLayout.setWidth100();
		mainLayout.setHeight100();

		this.parentPanel = parentPanel;

		this.setWidth("980");
		this.setHeight("600");
		this.centerInPage();
 		this.setIsModal(true);
 		
		/**
		 * -----------------------------------------------------------------------
	     * Configura os campos para edição no formulório de manutenção da soliciatação.
		 * -----------------------------------------------------------------------
		 */	

		int widthLabelFormEdit = 150;		 
		parentPanel.getPropertyCodSolicitacaoDevolucao().setBound(widthLabelFormEdit, 80);
		parentPanel.getPropertyCodMotivoDevolucao().setBound(widthLabelFormEdit, 400);
		parentPanel.getPropertyDescricao().setBound(widthLabelFormEdit, 400);
		parentPanel.getPropertySituacao().setBound(widthLabelFormEdit, 400);
		parentPanel.getPropertyDtSolicitacao().setBound(widthLabelFormEdit, 150);	
		parentPanel.getPropertyDtAprovacao().setBound(widthLabelFormEdit, 150);
		parentPanel.getPropertyObsAprovador().setBound(widthLabelFormEdit, 400);

		parentPanel.getPropertyCodCliente().setBound(widthLabelFormEdit, 80);
		parentPanel.getPropertyCodColaboradorSolicitante().setBound(widthLabelFormEdit, 80);
		parentPanel.getPropertyCodColaboradorAprovador().setBound(widthLabelFormEdit, 80);

		parentPanel.getPropertyDtSolicitacao().setType(ListGridFieldType.DATE);
		parentPanel.getPropertyDtAprovacao().setType(ListGridFieldType.DATE);
		
		parentPanel.getPropertyCodSolicitacaoDevolucao().createHowMGWTFormFieldTextItem();
		parentPanel.getPropertyCodMotivoDevolucao().createHowMGWTFormFieldSelectItem();
		parentPanel.getPropertyDescricao().createHowMGWTFormFieldTextItem();
		parentPanel.getPropertySituacao().createHowMGWTFormFieldSelectItem();
		parentPanel.getPropertyDtSolicitacao().createHowMGWTFormFieldTextItem();		
		parentPanel.getPropertyDtAprovacao().createHowMGWTFormFieldTextItem();
		parentPanel.getPropertyObsAprovador().createHowMGWTFormFieldAreaItem();

		FactoryUCommerce.createLookupBuscaCliente(parentPanel.getPropertyCodCliente());
		FactoryUCommerce.createLookupBuscaVendedor(parentPanel.getPropertyCodColaboradorSolicitante());
		FactoryUCommerce.createLookupBuscaVendedor(parentPanel.getPropertyCodColaboradorAprovador());

		parentPanel.getPropertyCodMotivoDevolucao().setMandatory(true);
		parentPanel.getPropertyDescricao().setMandatory(true);
		parentPanel.getPropertyCodCliente().setMandatory(true);




		parentPanel.getPropertyCodColaboradorSolicitante().getFormField().setHowMDisable(true);
		parentPanel.getPropertyDtSolicitacao().getFormField().setHowMDisable(true);

		parentPanel.getPropertyCodColaboradorAprovador().getFormField().setHowMDisable(true);
		parentPanel.getPropertyDtAprovacao().getFormField().setHowMDisable(true);

		parentPanel.getPropertyCodSolicitacaoDevolucao().getFormField().setHowMDisable(true);



		mainForm.addMember(parentPanel.getPropertyCodSolicitacaoDevolucao().getCanvas());
		mainForm.addMember(parentPanel.getPropertyCodCliente().getCanvas());

		mainForm.addMember(parentPanel.getPropertyCodMotivoDevolucao().getCanvas());
		mainForm.addMember(parentPanel.getPropertyDescricao().getCanvas());
		mainForm.addMember(parentPanel.getPropertySituacao().getCanvas());

		mainForm.addMember(parentPanel.getPropertyCodColaboradorSolicitante().getCanvas());
		mainForm.addMember(parentPanel.getPropertyDtSolicitacao().getCanvas());

		mainFormAprovacao.setWidth100();
		mainFormAprovacao.setHeight(66);

		mainFormAprovacao.addMember(parentPanel.getPropertyCodColaboradorAprovador().getCanvas());
		mainFormAprovacao.addMember(parentPanel.getPropertyDtAprovacao().getCanvas());
		mainFormAprovacao.addMember(parentPanel.getPropertyObsAprovador().getCanvas());
		mainForm.addMember(mainFormAprovacao);

		parentPanel.getPropertySituacao().getHowMGWTEditorSelectItem().getField().addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				configureSituacao();
			}
		});

		
		mainForm.setWidth100();
		mainForm.setAutoHeight();

		
		formToolbarEdit = new HowMGWTFormToolbarEdit(this, parentPanel.getFormToolbarEdit().getPanelList(), false);

		formToolbarEdit.createActionDelete();
		
		formToolbarEdit.addMember(actionSelecionarNotasFiscais);

		mainLayout.addMember(formToolbarEdit);
		
		formToolbarEdit.getActionNovo().setVisible(false);
		

		mainLayout.addMember(mainForm);

		painelSolicitacaoDevolucaoItem.setWidth100();
		painelSolicitacaoDevolucaoItem.setHeight100();
		mainLayout.addMember(painelSolicitacaoDevolucaoItem);
		
		this.addItem(mainLayout);
	}

	public String getHowMGWTTitle(){
    	return  Tradutor.i18n.formTituloVDW0031();
	}

	public String getHowMGWTPrograma(){
		return "VDW0031";
	}

	public void editRecord(FormBean currentConfiguracao, ListGridRecord currentRecord, boolean showDetalhes){	
		this.excluirRegistro = false;
		this.showDetalhes = showDetalhes;
		this.painelSolicitacaoDevolucaoItem.setCurrentFormBean(currentConfiguracao);
		this.currentRecord = currentRecord;
		this.novoRegistro  = false;
		this.show();
		configureRegistro();
	}

	public void newRecord(FormBean currentConfiguracao){
		this.excluirRegistro = false;
		this.formToolbarEdit.getActionDelete().setDisabled(true);
		this.painelSolicitacaoDevolucaoItem.setCurrentFormBean(currentConfiguracao);
		mainFormAprovacao.setVisible(false);
		this.currentRecord = null;
		this.novoRegistro = true;
		this.show();
		configureRegistro();
	}

	@Override
	public HowMGWTFormProperties getHowMProperties() {		
		return parentPanel.getProperties();
	}
	
	@Override
	public void onHowMDeleteRecord() {
		// Solicita confirmação para exclusão do registro.
		SC.confirm(Tradutor.i18n.msgConfirmaExclusaoArquivosSelecionados(), new BooleanCallback() {
			
			@Override
			public void execute(Boolean value) {
				if ( value.booleanValue() ){
					excluirRegistro = true;
					onHowMSave();					
				}
			}
		});
	}

	@Override
	public void onHowMEditRecord() {}


	@Override
	public void onHowMLoad(HowMGWTFormBean formBean) {}


	@Override
	public void onHowMNewRecord() {}


	@Override
	public void onHowMRelation(ListGridRecord record) {}


	@Override
	public void onHowMSave() {
		eSolicitacaoDevolucaoItem[] itens = painelSolicitacaoDevolucaoItem.validaItens();		
		if ( excluirRegistro ){
			;
		}else{
			if ( itens == null || itens.length == 0){
				SC.say(Tradutor.i18n.msgInformeNoMinimoUmItemDevolucao());
				return;			
			}
			
			if ( painelSolicitacaoDevolucaoItem.isError() ){
				SC.say(Tradutor.i18n.msgDadosInformadosInvalidos());
				return;							
			}
		}
		// -------------------------------------------------------------------------------
		// Grava os dados no servidor.
		// -------------------------------------------------------------------------------
		HowMGWTWindowWait.showWait();		
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts( new FormBean() ) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true))
					return;

				FormBean bean = (FormBean)formBean;

				if( excluirRegistro ){
					parentPanel.getFormToolbarEdit().removeRecord(currentRecord);
					parentPanel.getFormToolbarEdit().getActionEditar().setDisabled(true);
					WindowPanelEditSolicitacaoDevolucao.this.hide();
				}
				else{
					// Recupera o diplayValue da comboBox de motivos.
					// String descMotivo = parentPanel.getPropertyCodMotivoDevolucao().getHowMGWTEditorSelectItem().getField().getDisplayValue();
	
					if ( novoRegistro ){
						currentRecord = parentPanel.getFormToolbarEdit().addRecord(bean.getSolicitacaoDevolucao());
						parentPanel.getPropertyCodSolicitacaoDevolucao().getFormField().setHowMValue(bean.getSolicitacaoDevolucao().getCodSolicitacaoDevolucao());
					}
					else
						currentRecord =parentPanel.getFormToolbarEdit().refreshRecord(bean.getSolicitacaoDevolucao());
	
					novoRegistro = false;
					currentFormBean = bean;
					currentSolicitacaoDevolucao = bean.getSolicitacaoDevolucao();
	
					configureRegistro();
				}				
				HowMGWTWindowWait.hideWait();
			}

			@Override
			public void onError(Throwable err) {
				super.onError(err);
			}			
		};

		FormBean formBean = new FormBean();

		eSolicitacaoDevolucao solicitacaoDevolucao = new eSolicitacaoDevolucao();	
		formToolbarEdit.convertFormToFormBean(solicitacaoDevolucao);
		if( novoRegistro )
			solicitacaoDevolucao.setOperacao(""+HowMGWTUtilities.OPERATION_INSERT);
		else
			solicitacaoDevolucao.setOperacao(""+HowMGWTUtilities.OPERATION_UPDATE);

		solicitacaoDevolucao.setObject(this.parentPanel.getPropertyCodColaborador().getName(), currentSolicitacaoDevolucao.getCodColaborador());
		solicitacaoDevolucao.setObject(this.parentPanel.getPropertyNomeColaborador().getName(), currentSolicitacaoDevolucao.getNomeColaborador());	

		solicitacaoDevolucao.setObject(this.parentPanel.getPropertyNomeColaboradorSolicitante().getName(), this.parentPanel.getPropertyCodColaboradorSolicitante().getHowMGWTEditorCodeDescriptor().getMessageLabel().getHowMValueNoTag());
	
		if ( HowMGWTUtilities.isEquals( parentPanel.getPropertySituacao().getHowMValue(),  UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_AGUARDANDO_APROVACAO ) ){
			this.parentPanel.getPropertyCodColaboradorAprovador().getFormField().setHowMValue("");
			this.parentPanel.getPropertyDtAprovacao().getFormField().setHowMValue("");
			this.parentPanel.getPropertyObsAprovador().getFormField().setHowMValue("");
		}

		if( excluirRegistro )
			solicitacaoDevolucao.setOperacao( ""+HowMGWTUtilities.OPERATION_DELETE );
	
		formBean.setSolicitacaoDevolucao(solicitacaoDevolucao);
		solicitacaoDevolucao.setEntitySolicitacoesDevolucaoItem(itens);
		
		String body = HowMGWTUtilities.getGWTBeanTransfer(formBean.toJsonObject("").toString());
		struts.request("vdw0031.do?method=save",  "VDW0031Form", body );						
	}


	@Override
	public void onHowMSetValues(ListGridRecord record) {}



	/**
	 * Configura o registro para edição ou inserção
	 */
	public void configureRegistro(){
		painelSolicitacaoDevolucaoItem.getPanelGrid().clearAllRecords();
		painelSolicitacaoDevolucaoItem.setRefreshTotal(painelSolicitacaoDevolucaoItem.getPanelGrid().getRecords());
		FormBean formBean = new FormBean();

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
				currentSolicitacaoDevolucao = bean.getSolicitacaoDevolucao();				
				currentFormBean = bean;
								
				LinkedHashMap< String, String> mapMotivoDevolucao = new LinkedHashMap<String, String>();
				mapMotivoDevolucao.put("", "");

				if ( bean.getMotivosDevolucao() != null ){
					for ( eMotivoDevolucao motivoDevolucao : bean.getMotivosDevolucao() ){
						mapMotivoDevolucao.put(motivoDevolucao.getCodMotivoDevolucao(), motivoDevolucao.getDescAbrev());
					}
				}
				parentPanel.getPropertyCodMotivoDevolucao().getHowMGWTEditorSelectItem().getField().setValueMap(mapMotivoDevolucao);

				

				/**
				 * Se tiver permissão para aprovar ou rejeitar permite edição da solicitação.
				 */
				if ( "true".equals(currentFormBean.getPermiteAprovacaoReprovacaoSolicitacaoDevolucao()) ){
					parentPanel.getPropertySituacao().getHowMGWTEditorSelectItem().setHowMDisable(false);
				}
				else{
					parentPanel.getPropertySituacao().getHowMGWTEditorSelectItem().setHowMDisable(true);
				}				

				if ( 
						HowMGWTUtilities.isEquals( parentPanel.getPropertySituacao().getHowMValue(),  UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_NAO_APROVADO )
						||
						HowMGWTUtilities.isEquals(parentPanel.getPropertySituacao().getHowMValue(), 	UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_APROVADO )
				){		
					parentPanel.getPropertySituacao().getFormField().setHowMDisable(true);
					actionSelecionarNotasFiscais.setVisible(false);
					parentPanel.getPropertyCodMotivoDevolucao().getFormField().setHowMDisable(true);
					parentPanel.getPropertyDescricao().getFormField().setHowMDisable(true);
					parentPanel.getPropertyObsAprovador().getFormField().setHowMDisable(true);				
					parentPanel.getPropertySituacao().getFormField().setHowMDisable(true);
					formToolbarEdit.getActionGravar().setVisible(false);
					formToolbarEdit.getActionDelete().setVisible(false);					
				}
				else{
					if ( showDetalhes ){
						actionSelecionarNotasFiscais.setVisible(false);						
						parentPanel.getPropertyCodMotivoDevolucao().getFormField().setHowMDisable(true);
						parentPanel.getPropertyDescricao().getFormField().setHowMDisable(true);
						parentPanel.getPropertyObsAprovador().getFormField().setHowMDisable(true);
						parentPanel.getPropertySituacao().getFormField().setHowMDisable(true);
						formToolbarEdit.getActionGravar().setVisible(false);
						formToolbarEdit.getActionDelete().setVisible(false);
					}
					else{
						actionSelecionarNotasFiscais.setVisible(true);
						parentPanel.getPropertyCodMotivoDevolucao().getFormField().setHowMDisable(false);
						parentPanel.getPropertyDescricao().getFormField().setHowMDisable(false);
						parentPanel.getPropertyObsAprovador().getFormField().setHowMDisable(false);
						formToolbarEdit.getActionGravar().setVisible(true);
						if ( ! novoRegistro )
							formToolbarEdit.getActionDelete().setVisible(true);
					}
				}
					
				painelSolicitacaoDevolucaoItem.loadItens(currentSolicitacaoDevolucao.getEntitySolicitacoesDevolucaoItem());
					
				// Configura um novo registro
				if ( novoRegistro )
					configureNewMode();
				else
					configureEditMode();
				
				painelSolicitacaoDevolucaoItem.configure();
				
				HowMGWTWindowWait.hideWait();
			}

			@Override
			public void onError(Throwable err) {
				super.onError(err);
			}			
		};

		// Configura o objecto de solicitação para recuperar a solicitação e 
		// os itens correspondentes.
		eSolicitacaoDevolucao solicitacao = new eSolicitacaoDevolucao();				
	
		String codSolicitacao = null;
		if ( ! novoRegistro )
			codSolicitacao = parentPanel.getPropertyCodSolicitacaoDevolucao().getHowMValue(this.currentRecord);

		solicitacao.setCodSolicitacaoDevolucao(codSolicitacao);
		formBean.setSolicitacaoDevolucao(solicitacao);

		String body = HowMGWTUtilities.getGWTBeanTransfer(formBean.toJsonObject("").toString());
		
		struts.request("vdw0031.do?method=configuraSolicitacaoDevolucao",  "VDW0031Form", body);				
	}

	public void configureEditMode(){

		formToolbarEdit.onHowMConfigureStatus(this.currentRecord);

		this.parentPanel.getPropertyCodCliente().getFormField().setHowMDisable(true);
		formToolbarEdit.convertRecordToForm(this.currentRecord);
		this.parentPanel.getPropertyCodCliente().getHowMGWTEditorCodeDescriptor().getMessageLabel().setHowMValue(this.currentRecord.getAttribute(this.parentPanel.getPropertyNomeCliente().getName()));
		this.parentPanel.getPropertyCodColaboradorSolicitante().getHowMGWTEditorCodeDescriptor().getMessageLabel().setHowMValue(this.currentRecord.getAttribute(this.parentPanel.getPropertyNomeColaboradorSolicitante().getName()));
		
		this.parentPanel.getPropertyCodColaboradorAprovador().getHowMGWTEditorCodeDescriptor().getMessageLabel().setHowMValue(this.currentRecord.getAttribute(this.parentPanel.getPropertyNomeColaboradorAprovador().getName()));

		configureSituacao();
	}
	
	/**
	 * Configura o modo de novo registro
	 */
	public void configureNewMode(){

		formToolbarEdit.convertFormBeanToForm(currentSolicitacaoDevolucao);
		this.parentPanel.getPropertyCodCliente().getFormField().setHowMDisable(false);
		this.parentPanel.getPropertyCodCliente().getHowMGWTEditorCodeDescriptor().getMessageLabel().setHowMValue("");

		
		parentPanel.getPropertyCodColaboradorSolicitante().getHowMGWTEditorCodeDescriptor().getField().setHowMValue( currentSolicitacaoDevolucao.getCodColaboradorSolicitante());
		parentPanel.getPropertyCodColaboradorSolicitante().getHowMGWTEditorCodeDescriptor().getMessageLabel().setHowMValue( currentSolicitacaoDevolucao.getNomeColaboradorSolicitante());				
		Date date = HowMGWTUtilities.getDate( currentSolicitacaoDevolucao.getDtSolicitacao() );
		parentPanel.getPropertyDtSolicitacao().getHowMGWTEditorFieldText().setHowMValue( HowMGWTUtilities.getFormatDateTime(date ) );	
	}

	/**
	 * Configura a tela conforme a situacao da solicitação de devolução.
	 */
	public void configureSituacao(){
		if ( 
				HowMGWTUtilities.isEquals( parentPanel.getPropertySituacao().getHowMValue(),  UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_NAO_APROVADO )
				||
				HowMGWTUtilities.isEquals(parentPanel.getPropertySituacao().getHowMValue(), 	UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_APROVADO )
		){
			parentPanel.getPropertyCodColaboradorAprovador().getHowMGWTEditorCodeDescriptor().getField().setHowMValue(currentSolicitacaoDevolucao.getCodColaboradorSolicitante());
			parentPanel.getPropertyCodColaboradorAprovador().getHowMGWTEditorCodeDescriptor().getMessageLabel().setHowMValue(currentSolicitacaoDevolucao.getNomeColaboradorSolicitante());
			Date now = new Date();
			parentPanel.getPropertyDtAprovacao().getHowMGWTEditorFieldText().setHowMValue(HowMGWTUtilities.getFormatDateTime(now));
			mainFormAprovacao.setVisible(true);
		}
		else{
			parentPanel.getPropertyCodColaboradorAprovador().getHowMGWTEditorCodeDescriptor().getField().setHowMValue("");
			parentPanel.getPropertyCodColaboradorAprovador().getHowMGWTEditorCodeDescriptor().getMessageLabel().setHowMValue("");				
			parentPanel.getPropertyDtAprovacao().getHowMGWTEditorFieldText().setHowMValue("");
			mainFormAprovacao.setVisible(false);
		}
	}
	
	
	/**
	 * Permite selecionar as notas fiscais do cliente que serão devolvidas.
	 */
	public void selecionarNotas(){
		if (HowMGWTUtilities.isEmpty( parentPanel.getPropertyCodCliente().getHowMValue() ) ){
			SC.say(Tradutor.i18n.msgInformePrimeiroCliente());
			return;
		}

		if ( windowPainelNotasFiscais == null ){
			windowPainelNotasFiscais = new WindowPainelNotasFiscais(){
				@Override
				public void onImportarNotas(ArrayList<eNotaFiscalItemEtq> itens) {
					painelSolicitacaoDevolucaoItem.importarNotas(itens);
				}
			};
		}
	
		windowPainelNotasFiscais.showNotas( parentPanel.getPropertyCodCliente().getHowMGWTEditorCodeDescriptor().getField().getHowMValueAsString(), 
											parentPanel.getPropertyCodCliente().getHowMGWTEditorCodeDescriptor().getMessageLabel().getHowMValueAsString() );
	}

	/**
	 * @return the parentPanel
	 */
	public PainelSolicitacaoDevolucao getParentPanel() {
		return parentPanel;
	}

	/**
	 * @return the showDetalhes
	 */
	public boolean isShowDetalhes() {
		return showDetalhes;
	}

	/**
	 * @param showDetalhes the showDetalhes to set
	 */
	public void setShowDetalhes(boolean showDetalhes) {
		this.showDetalhes = showDetalhes;
	}

}