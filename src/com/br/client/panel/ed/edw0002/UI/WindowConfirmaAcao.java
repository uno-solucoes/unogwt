package com.br.client.panel.ed.edw0002.UI;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import com.br.client.model.ed.edw0002.FormBean;
import com.br.client.model.ed.entity.eEDIPedidoVendaItem;
import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTFormToolbarEdit;
import com.howmake.client.form.UI.HowMGWTLabel;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.control.HowMGWTControlForm;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class WindowConfirmaAcao  extends HowMGWTWindow implements HowMGWTControlForm{

	private PainelMonitorEDIControle parentMonitorEDIControle;
	private VLayout mainLayout = new VLayout();

	
	private HowMGWTLabel labelMessage = new HowMGWTLabel();
	private HowMGWTLabel labelMessageTitle = new HowMGWTLabel("<font color=blue><b>MENSAGENS</b></font>");
	
	private HLayout alertMessage = new HLayout();
	private HowMGWTLabel labelAlert = new HowMGWTLabel();
	
	private String codEDI;
	private String descEDI;
	private String codPedido;
	private String selectProduto; 
	private String acao = "";
	
	private HowMGWTFormToolbarEdit formToolbarEdit;
	
	private HowMGWTFormProperties propertiesForm = new HowMGWTFormProperties();
	
	private HowMGWTProperty propertyEDI 					= propertiesForm.createProperty("codEDI", 			Tradutor.i18n.formCodEDI());	
	private HowMGWTProperty propertyCodPedidoForm			= propertiesForm.createProperty("codPedido", 		Tradutor.i18n.formCodigoPedido());
	private HowMGWTProperty propertyTipoOperacao			= propertiesForm.createProperty("tipoOperacao", 	Tradutor.i18n.formTipoOperacao());
 
	private HowMGWTFormProperties properties = new HowMGWTFormProperties();
	
	private HowMGWTProperty propertyCodEmpresa				= properties.createProperty("codEmpresa", 			Tradutor.i18n.formCodEmpresa());
	private HowMGWTProperty propertyCodEDI					= properties.createProperty("codEDI", 				Tradutor.i18n.formCodEDI());
	private HowMGWTProperty propertyCodEdiPedidoItem		= properties.createProperty("codEdiPedidoItem", 	Tradutor.i18n.formCodEdiPedidoItem());

	private HowMGWTProperty propertyCodPedido				= properties.createProperty("codPedido", 			Tradutor.i18n.formCodigoPedido());

	private HowMGWTProperty propertyCodProduto  			= properties.createProperty("codProduto", 			Tradutor.i18n.formCodProduto());

	private HowMGWTProperty propertyItemPedido				= properties.createProperty("nrSequencia", 			Tradutor.i18n.formItem());
	private HowMGWTProperty propertyDescricao				= properties.createProperty("descComercial",  		Tradutor.i18n.formDescricao());
	private HowMGWTProperty propertyPrecoVenda  			= properties.createProperty("vlPrecoVenda", 		Tradutor.i18n.formPrecoVenda());
	private HowMGWTProperty propertyQtde					= properties.createProperty("qtde",					Tradutor.i18n.formQtde());

	private HowMGWTProperty propertyDataReserva 			= properties.createProperty("dtReservaEstoque", 	Tradutor.i18n.formReserva());
	private HowMGWTProperty propertyDataEfetivacaoReserva	= properties.createProperty("dtEfetivacaoPedido", 	Tradutor.i18n.formEfetivacaoReserva());
	private HowMGWTProperty propertySituacao    			= properties.createProperty("situacao",				Tradutor.i18n.formSituacao());

	private HowMGWTProperty propertyCodReservaEDI    		= properties.createProperty("codReservaEDI",		Tradutor.i18n.formCodReservaEDI());	
	private HowMGWTProperty propertyCodPedidoEDI    		= properties.createProperty("codPedidoEDI",			Tradutor.i18n.formCodPedidoEDI());

	private HowMGWTProperty propertyEDISaldoEstoque			= properties.createProperty("ediSaldo", 			Tradutor.i18n.formSaldoEstoqueEDI());
	private HowMGWTProperty propertyEDIPrecoVenda			= properties.createProperty("ediPrecoVenda", 		Tradutor.i18n.formPrecoVendaEDI());

	private HowMGWTProperty propertyMensagem				= properties.createProperty("mensagem", 			Tradutor.i18n.formMensagem());
	private HowMGWTProperty propertyNrVerificacoesEdi		= properties.createProperty("nrVerificacoesEdi", 	"");
	private HowMGWTProperty propertyDtUltimaVerificacao 	= properties.createProperty("dtUltimaVerificacao", 	"");

	private HowMGWTProperty propertyIndAtivo 				= properties.createProperty("indAtivo", 			"");
	
	private HLayout indLayout = new HLayout();

	private IButton actionExecutarOperacao 					= new IButton(Tradutor.i18n.formExecutarOperacao());
	private IButton actionCancelar 							= new IButton(Tradutor.i18n.formCancelar());
	
	private boolean permiteEfetivacao 						= true;
	
	// Customização da lista.
	private HowMGWTListGrid panelList = new HowMGWTListGrid(){		
		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
			String bgColor = "";
			if( "1".equals(propertyTipoOperacao.getHowMValue())){ 
				if ( HowMGWTUtilities.isEquals( selectProduto, propertyCodProduto.getHowMValue(record) ) )
					if ( ! acao.equals(PainelReservaEfetivacao.ACTION_EFETIVA_RESERVA) ) 
						bgColor = "background-color:"+Tradutor.i18n.colorLayoutDestaque();			
			}
			String fieldName = formToolbarEdit.getPanelList().getFieldName(colNum);

			if( HowMGWTUtilities.getInteger( propertyNrVerificacoesEdi.getHowMValue(record) ) > 0 
				&& 
				propertyCodProduto.getName().equalsIgnoreCase(fieldName) 
			){
				bgColor = "background-color:"+Tradutor.i18n.colorLayoutErro()+";";							
			}
			
			return bgColor;
		};
	};	
	
	public WindowConfirmaAcao(){
 
		this.setWidth("700");
		this.setHeight("80%");
		this.centerInPage();

		mainLayout.addMember(createTopForm());
		mainLayout.addMember(createList());
		
		/** --------------------------------------------------------------------------------- */
		VLayout mainLabelMessage = new VLayout();
		mainLabelMessage.setWidth100();
		mainLabelMessage.setHeight(200);
		
		mainLabelMessage.addMember(HowMGWTUtilities.getCanvasLabelIndicator(22, labelMessageTitle ));
		mainLabelMessage.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(1, "red"));
		labelMessage.setWidth100();
		labelMessage.setHeight100();
		labelMessage.setOverflow(Overflow.AUTO);
		mainLabelMessage.addMember(labelMessage);
		mainLabelMessage.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(1, "blue"));
		
		
		mainLayout.addMember(mainLabelMessage);
		
		indLayout.setWidth100();
		indLayout.setHeight(22); 
		indLayout.addMember(HowMGWTUtilities.getCanvasIndicator(18, 22, Tradutor.i18n.colorLayoutDestaque(), "1px solid #F4A460"));

		HowMGWTLabel labelIndicador = new HowMGWTLabel(Tradutor.i18n.formRegistroSelecionadoParaOperacao());
		indLayout.addMember(HowMGWTUtilities.getCanvasLabelIndicator(22, labelIndicador));

		mainLayout.addMember(indLayout);
		
		
		ToolStrip tools = new ToolStrip();
		tools.setWidth100();
		tools.setHeight(26);
		tools.setAlign(Alignment.CENTER);

		actionExecutarOperacao.setIcon("actions/approve.png");
		actionCancelar.setIcon("actions/ico_close.png");
		
		actionExecutarOperacao.setWidth(150);
		actionCancelar.setWidth(90);
		
		tools.addMember(actionExecutarOperacao);
		tools.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(10, ""));
		tools.addMember(actionCancelar);
		
		/**
		 * Adiciona o evento para executar a operação
		 */
		actionExecutarOperacao.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SC.confirm(Tradutor.i18n.msgConfirmaExecucaoProcesso() , new BooleanCallback() {
										@Override
					public void execute(Boolean value) {
						if ( value.booleanValue() ){
							executaAcao();
						}
					}
				});
			}
		});
		
		/**
		 * Adiciona o evento para cancelar a operação
		 */
		actionCancelar.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				hide();
				onHowMGWTClose();
			}
		});
		
		HLayout indErro = new HLayout();
		indErro.setWidth100();
		indErro.setHeight(22);
		indErro.addMember(HowMGWTUtilities.getCanvasIndicator(18, 22, Tradutor.i18n.colorLayoutErro(), "1px solid #FF0000"));
		indErro.addMember(HowMGWTUtilities.getCanvasLabelIndicator(22, new HowMGWTLabel("Erros de processamento."))); 
		
		mainLayout.addMember(indErro);
		
		
		alertMessage.setWidth100();
		alertMessage.setHeight(22);
		alertMessage.addMember(HowMGWTUtilities.getCanvasIndicator(18, 22, Tradutor.i18n.colorLayoutErro(), "1px solid #FF0000"));
		alertMessage.addMember(HowMGWTUtilities.getCanvasLabelIndicator(22, labelAlert)); 
		mainLayout.addMember(alertMessage);
		
		
		
		
		mainLayout.addMember(tools);

		this.addItem(mainLayout);

		this.setIsModal(true);

	}
	
	/**
	 * @return Cria e retorna um cavas para apresentar os filtros de consulta do usuório.
	 */
	public VLayout createTopForm(){
		VLayout formTop = new VLayout();
		formTop.setWidth100();
		formTop.setHeight(300);
	
		int widthLabel = 110;
		HLayout layoutEDI = new HLayout();
		layoutEDI.setWidth100();
		layoutEDI.setHeight(22);
		
		propertyEDI.setBound(widthLabel, 60);
		propertyCodPedidoForm.setBound(widthLabel, 70);
		propertyTipoOperacao.setBound(widthLabel, 300);
 
		propertyEDI.createHowMGWTFormCodeDescriptor();
		propertyCodPedidoForm.createHowMGWTFormFieldTextItem();
		propertyTipoOperacao.createHowMGWTFormFieldSelectItem();
		
		

		propertyEDI.getCanvas().setDisabled(true);
		propertyCodPedidoForm.getCanvas().setDisabled(true);
		
		formTop.addMember(propertyEDI.getCanvas());
		formTop.addMember(propertyCodPedidoForm.getCanvas());
		formTop.addMember(propertyTipoOperacao.getCanvas());
				
		propertyTipoOperacao.getHowMGWTEditorSelectItem().getField().addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if( "1".equals(propertyTipoOperacao.getHowMValue())){
					indLayout.setVisible(true);
					panelList.redraw();
				}
				else{
					indLayout.setVisible(false);
					panelList.redraw();					
				}
			}
		});
		
		formTop.setHeight(80);
		
		return formTop;
	}	
	
	
	/**
	 * @return Cria e retorna um canvas para apresentação dos dados de monitoramento do EDI.
	 */
	public VLayout createList(){
		VLayout resultLayout = new VLayout();
		resultLayout.setWidth100();
		resultLayout.setHeight100();
		
		// Seta primeiro os tamanhos das colunas
		this.propertyCodPedido.setWidthColumn(70);
		this.propertyItemPedido.setWidthColumn(40);
		this.propertyCodProduto.setWidthColumn(140);
		this.propertyPrecoVenda.setWidthColumn(100);
		this.propertyQtde.setWidthColumn(60);
		this.propertySituacao.setWidthColumn(110);
		this.propertyDataEfetivacaoReserva.setWidthColumn(130);
		this.propertyDataReserva.setWidthColumn(130);
		
		
		this.propertyDtUltimaVerificacao.setType(ListGridFieldType.DATE);
		
		// Cria os campos para apresentação dos dados.
		this.propertyCodPedido.createHowMGWTListGridField();
		this.propertyItemPedido.createHowMGWTListGridField();
		this.propertyCodProduto.createHowMGWTListGridField();
		this.propertyDescricao.createHowMGWTListGridField();		
		this.propertyPrecoVenda.createHowMGWTListGridField();
		this.propertyQtde.createHowMGWTListGridField();
		this.propertySituacao.createHowMGWTListGridField();
		
//		this.propertyDataEfetivacaoReserva.createHowMGWTListGridField();
// 		this.propertyDataReserva.createHowMGWTListGridField();
 

//		propertyEDISaldoEstoque.setWidthColumn(100);
//		propertyEDIPrecoVenda.setWidthColumn(100); 

		propertyEDIPrecoVenda.setType(ListGridFieldType.FLOAT);
		propertyEDISaldoEstoque.setType(ListGridFieldType.FLOAT);
		
//		propertyEDISaldoEstoque.createHowMGWTListGridField();
//		propertyEDIPrecoVenda.createHowMGWTListGridField();
		
//		propertyEDISaldoEstoque.getListField().setAlign(Alignment.RIGHT);
//		propertyEDIPrecoVenda.getListField().setAlign(Alignment.RIGHT);
		
//		propertyEDISaldoEstoque.createFormatDouble( "###,###,###,##0", "");
//		propertyEDIPrecoVenda.createFormatDouble( "###,###,###,##0.00" , "" );		

		propertyQtde.getListField().setType(ListGridFieldType.FLOAT);
		propertyQtde.getListField().setAlign(Alignment.RIGHT);
		propertyQtde.createFormatDouble("###,###,###,##0");

		propertyPrecoVenda.setType(ListGridFieldType.FLOAT);
		propertyPrecoVenda.getListField().setAlign(Alignment.RIGHT);
		propertyPrecoVenda.createFormatDouble("###,###,###,##0.00");

		propertyDataReserva.setType(ListGridFieldType.DATE);
// 		propertyDataReserva.getListField().setAlign(Alignment.CENTER);
//		propertyDataReserva.createFormatDate(Tradutor.i18n.formFormatDateTime());

		propertyDataEfetivacaoReserva.setType(ListGridFieldType.DATE);
//		propertyDataEfetivacaoReserva.getListField().setAlign(Alignment.CENTER);
//		propertyDataEfetivacaoReserva.createFormatDate(Tradutor.i18n.formFormatDateTime());

		
		this.propertySituacao.getListField().setValueMap(PainelMonitorEDI.getEDISituacoes());
		
		// Define a ordem que será visualizada as colunas.
		int order = 1;
		this.propertyCodPedido.setOderList(order++);
		this.propertyItemPedido.setOderList(order++);
		this.propertyCodProduto.setOderList(order++);
		this.propertyDescricao.setOderList(order++);
		this.propertyPrecoVenda.setOderList(order++);
		this.propertyQtde.setOderList(order++);
		this.propertySituacao.setOderList(order++);

		formToolbarEdit = new HowMGWTFormToolbarEdit(this,panelList);
		
		formToolbarEdit.getPanelList().setWidth100();
		formToolbarEdit.getPanelList().setHeight100();
		resultLayout.addMember(formToolbarEdit.getPanelList());
		
		return resultLayout;
		
	}	
	
	
	public void showExecutaAcao(String codEDI, String descEDI, String codPedido, String selectProduto, String acao){
		
		alertMessage.setVisible(false);
		actionExecutarOperacao.setDisabled(false);
		
		labelMessageTitle.setHowMValue("<font color=blue><b>MENSAGENS</b></font>");
		labelMessage.setHowMValue("");
		
		this.codEDI 		= codEDI;
		this.descEDI 		= descEDI;
		this.codPedido 		= codPedido;
		this.selectProduto 	= selectProduto;
		this.acao 			= acao;

		this.propertyEDI.getFormField().setHowMValue(codEDI);
		this.propertyEDI.getHowMGWTEditorCodeDescriptor().getMessageLabel().setHowMValue(descEDI);
		
		this.propertyCodPedidoForm.getFormField().setHowMValue(codPedido);
		
		LinkedHashMap<String, String> mapAcoes = new LinkedHashMap<String , String>();
		if ( acao.equals(PainelReservaEfetivacao.ACTION_RESERVA_ESTOQUE) ){
			mapAcoes.put("1", Tradutor.i18n.formReservaEstoqueItem());
			mapAcoes.put("2", "<font color=red>"+Tradutor.i18n.formReservaEstoquePedido()+"</font>");
		}
		else if ( acao.equals(PainelReservaEfetivacao.ACTION_CANCELA_RESERVA_ESTOQUE) ){
			mapAcoes.put("2", "<font color=red>"+Tradutor.i18n.formCancelaReservaPedido()+"</font>");
		}
		else if ( acao.equals(PainelReservaEfetivacao.ACTION_EFETIVA_RESERVA) ){
			mapAcoes.put("2", "<font color=red>"+Tradutor.i18n.formEfetivaReservaPedido()+"</font>");
		}
		
		// Se for efetivação ou reserva, só permite ação para o pedido todo.
		if ( 
			acao.equals(PainelReservaEfetivacao.ACTION_EFETIVA_RESERVA) 
			||
			acao.equals(PainelReservaEfetivacao.ACTION_CANCELA_RESERVA_ESTOQUE )
		){
			propertyTipoOperacao.getHowMGWTEditorSelectItem().getField().setDefaultValue("2");
			propertyTipoOperacao.getCanvas().setDisabled(true);
			indLayout.setVisible(false);
			panelList.redraw();
		}
		else{
			propertyTipoOperacao.getHowMGWTEditorSelectItem().getField().setDefaultValue("1");
			propertyTipoOperacao.getCanvas().setDisabled(false);
		}
		
		propertyTipoOperacao.getHowMGWTEditorSelectItem().getField().setValueMap(mapAcoes);	
		
		this.show();
		
		executeQuery();
	}
	
	public String getHowMGWTTitle(){
    	return  Tradutor.i18n.formAdministracaoManual();
	}
	
	public String getHowMGWTPrograma(){
		return "EDW0002";
	}

	@Override
	public HowMGWTFormProperties getHowMProperties() {
		return properties;
	}
	

	/**
	 * @return the parentMonitorEDIControle
	 */
	public PainelMonitorEDIControle getParentMonitorEDIControle() {
		return parentMonitorEDIControle;
	}

	/**
	 * @param parentMonitorEDIControle the parentMonitorEDIControle to set
	 */
	public void setParentMonitorEDIControle(
			PainelMonitorEDIControle parentMonitorEDIControle) {
		this.parentMonitorEDIControle = parentMonitorEDIControle;
	}		

	@Override
	public void onHowMDeleteRecord() {
	}

	@Override
	public void onHowMEditRecord() {
	}

	@Override
	public void onHowMLoad(HowMGWTFormBean formBean) {
		this.formToolbarEdit.getPanelList().clearAllRecords();
		
		FormBean bean = (FormBean)formBean;
		if ( bean.getPedidoItens() == null || bean.getPedidoItens().length == 0 ){
			SC.say(Tradutor.i18n.formNaoExisteItensParaMostrar());
			return;
		}

		RecordList records = this.formToolbarEdit.getPanelList().getRecordList();
		
		ListGridRecord firstRecord = null;
		
		permiteEfetivacao = true;
		for ( eEDIPedidoVendaItem item : bean.getPedidoItens() ){
			
			// Se item for inativo, ignora.
			if ( "0".equals(item.getIndAtivo() ) )
				continue;
			
			if ( acao.equals(PainelReservaEfetivacao.ACTION_RESERVA_ESTOQUE) ){
				if ( 
					! PainelMonitorEDI.SITUACAO_AGUARDANDO_RESERVA.equals( item.getSituacao() ) 
				)
					continue;
			}
			else if ( acao.equals(PainelReservaEfetivacao.ACTION_CANCELA_RESERVA_ESTOQUE) ){
				if ( 
						! PainelMonitorEDI.SITUACAO_RESERVADO.equals( item.getSituacao() )
						&& 
						! PainelMonitorEDI.SITUACAO_AGUARDANDO_RESERVA.equals( item.getSituacao() )
				)
					continue;
			}
			else if ( acao.equals(PainelReservaEfetivacao.ACTION_EFETIVA_RESERVA ) ){
				if ( 
					! PainelMonitorEDI.SITUACAO_RESERVADO.equals( item.getSituacao() ) 
					&& 
					! PainelMonitorEDI.SITUACAO_AGUARDANDO_RESERVA.equals( item.getSituacao() )
				)
					continue;
				if ( PainelMonitorEDI.SITUACAO_AGUARDANDO_RESERVA.equals( item.getSituacao()  ) ){
						permiteEfetivacao = false;
						actionExecutarOperacao.setDisabled(true);
				}
			}
			
			ListGridRecord record = formToolbarEdit.convertFormBeanToRecord(item);	
			records.add(record);
			if ( firstRecord == null )
				firstRecord = record;
		}
		if ( firstRecord != null )
			showMessage(firstRecord);
		
		labelAlert.setHowMValue("");
		if ( acao.equals(PainelReservaEfetivacao.ACTION_EFETIVA_RESERVA ) && ! permiteEfetivacao ){
			labelAlert.setHowMValue("<font color=red><b>"+Tradutor.i18n.msgEfetivacaoNaoPermitidaHaItensAguardandoReservaEstoque()+"</b></font>");
			alertMessage.setVisible(true);
		}
	}

	@Override
	public void onHowMNewRecord() {
	}

	@Override
	public void onHowMRelation(ListGridRecord record) {
	}

	@Override
	public void onHowMSave() {
	}

	@Override
	public void onHowMSetValues(ListGridRecord record) {
		showMessage(record);
	}
	
	
	
	/**
	 * Executa a consulta no banco de dados.
	 */
	public void executeQuery(){
		HowMGWTWindowWait.showWait();
		
		formToolbarEdit.getPanelList().clearAllRecords();
		
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
			}			
		};					 
		String body =  HowMGWTUtilities.getGWTBeanTransfer(propertiesForm.getFormSendFilter(formBean));
		
		struts.request("edw0002.do?method=buscarEdiPedidos",  "EDW0002Form", body);				
	}	

	
	
	
	/**
	 * Executa a consulta no banco de dados.
	 */
	public void executaAcao(){
		HowMGWTWindowWait.showWait();
				
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true ) ){
					HowMGWTWindowWait.hideWait();
					return;
				}
				
				FormBean bean = (FormBean)formBean;

				eEDIPedidoVendaItem[] itens = null;
				if ( acao.equals(PainelReservaEfetivacao.ACTION_RESERVA_ESTOQUE))
					itens = bean.getPedidoItens();
				else
					itens = bean.getEdiPedido().getItens();
				
				if ( itens != null ){
					
					TreeMap<String, ListGridRecord>  mapRecords = new TreeMap<String, ListGridRecord>();
					TreeMap<String, ListGridRecord>  mapRecordsMonitor = new TreeMap<String, ListGridRecord>();
					if ( parentMonitorEDIControle != null ){
						ListGridRecord[] records = parentMonitorEDIControle.getToolbarEdit().getPanelList().getRecords();
						// Carrega o mapa de registros 
						for ( ListGridRecord record : records)
							mapRecordsMonitor.put(propertyCodPedido.getHowMValue(record)+"-"+propertyCodProduto.getHowMValue(record), record);
					}
						
					ListGridRecord[] records = formToolbarEdit.getPanelList().getRecords();
					// Carrega o mapa de registros 
					for ( ListGridRecord record : records)
						mapRecords.put(propertyCodPedido.getHowMValue(record)+"-"+propertyCodProduto.getHowMValue(record), record);
					
					boolean ocorreuErros = false;
					ListGridRecord record;
					// Atualiza os dados da tela, verifica se 
					// foi realizado com sucesso.
					int idx = -1;
					
					ListGridRecord firstRecord = null;
					for(eEDIPedidoVendaItem item : itens){
						// Atualiza a lista de execução
						record = mapRecords.get(codPedido+"-"+item.getCodProduto());
						idx = -1;
						if ( record != null ){	
							idx = formToolbarEdit.getPanelList().getRecordIndex(record);
							record = formToolbarEdit.convertFormBeanToRecord(record, item);
							formToolbarEdit.getPanelList().refreshRow(idx);
						}
						
						if ( firstRecord == null )
							firstRecord = record;
						
						
						// Atualiza o monitor
						record = mapRecordsMonitor.get(codPedido+"-"+item.getCodProduto());
						if ( record != null ){	
							if ( parentMonitorEDIControle != null ){
								record = parentMonitorEDIControle.getToolbarEdit().convertFormBeanToRecord(record, item);
								int index = parentMonitorEDIControle.getToolbarEdit().getPanelList().getRecordIndex(record);
								parentMonitorEDIControle.getToolbarEdit().getPanelList().refreshRow(index);
							}
						}
						
						// Se maior que zero, então ocorreu erro durante o processamento.
						if ( HowMGWTUtilities.getInteger( item.getNrVerificacoesEdi() ) > 0 ){
							ocorreuErros = true;
						}
						else{
							
						}
					}
					HowMGWTWindowWait.hideWait();

					if ( ocorreuErros ){
						showMessage(firstRecord);
						SC.say(Tradutor.i18n.msgOperacaoFinalizadaComErro());
					}
					else{						
						showMessage(firstRecord);
						SC.say(Tradutor.i18n.msgOperacaoFinalizadaComSucesso());
					}
				}
				actionExecutarOperacao.setDisabled(true);
 
			}
			
			@Override
			public void onError(Throwable err) {
				HowMGWTWindowWait.hideWait();
				super.onError(err);
			}			
		};

		propertiesForm.loadFormValues(formBean);
		formBean.setTipoOperacao(this.acao);

		if ( propertyTipoOperacao.getHowMValue().equals("1"))
			formBean.setCodProduto(selectProduto);
		else
			formBean.setCodProduto("");

		String body =  HowMGWTUtilities.getGWTBeanTransfer(formBean.toJsonObject("").toString());

		struts.request("edw0002.do?method=executaAcao",  "EDW0002Form", body);		
	}	
	
	public void showMessage(ListGridRecord record){
		
		labelMessageTitle.setHowMValue("<font color=blue><b>"+Tradutor.i18n.msgMensagemUltimoProcessamento()+"</b></font>");
		labelMessage.setHowMValue("");
		
		if ( record != null ){
			
			if( HowMGWTUtilities.getInteger( propertyNrVerificacoesEdi.getHowMValue(record) ) > 0  )
				labelMessageTitle.setHowMValue("<font color=red><b>"+Tradutor.i18n.msgMensagemErroUltimoProcessamento()+"</b></font>");
			
			Date data = HowMGWTUtilities.getDate(propertyDtUltimaVerificacao.getHowMValue(record));
			
			labelMessage.setHowMValue(
					"&Uacute;ltimo processamento : "
					+
					"<b>"+HowMGWTUtilities.getFormatDateTime(data)+"</b><br>"
					+
					"Produto : "
					+
					"<b>"+propertyCodProduto.getHowMValue(record)+"</b>"
					+
					"<br>"
					+
					propertyMensagem.getHowMValue(record)
			);
		}
	}
}
