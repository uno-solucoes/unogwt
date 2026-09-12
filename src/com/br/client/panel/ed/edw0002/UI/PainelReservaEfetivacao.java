package com.br.client.panel.ed.edw0002.UI;

import com.br.client.model.ed.entity.eEDI;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.ed.edw0004.UI.WindowHistorico;
import com.howmake.client.form.UI.HowMGWTFormToolbarEdit;
import com.howmake.client.form.control.HowMGWTControlForm;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelReservaEfetivacao extends HLayout implements HowMGWTControlForm{ 

	private WindowHistorico windowHistorico;
	private ListGridRecord currentRecord;
	
	private PainelMonitorEDIControle parentMonitorEDIControle;
	
	public static final int SISTEMA_PEDIDO_SITUACAO_CANCELADO  = 200;
	
	public static final String ACTION_RESERVA_ESTOQUE		   = "1";
	public static final String ACTION_CANCELA_RESERVA_ESTOQUE  = "2";
	public static final String ACTION_EFETIVA_RESERVA		   = "3";
	
	private WindowConfirmaAcao windowConfirmaAcao;
	
	private HowMGWTFormProperties properties = new HowMGWTFormProperties();
	
	private HowMGWTProperty propertyCodEDI					= properties.createProperty("codEDI", 				Tradutor.i18n.formCodEDI());
	
	private HowMGWTProperty propertyCodEdiPedidoItem		= properties.createProperty("codEdiPedidoItem", 	"ID Pedido Item");
	
	private HowMGWTProperty propertyCodPedido				= properties.createProperty("codPedido", 			Tradutor.i18n.formCodigoPedido());

	private HowMGWTProperty propertyCodProduto  			= properties.createProperty("codProduto", 			Tradutor.i18n.formCodProduto());
	
	private HowMGWTProperty propertyItemPedido				= properties.createProperty("itemPedido", 			Tradutor.i18n.formItem());
	private HowMGWTProperty propertyDescricao				= properties.createProperty("descComercial",  		Tradutor.i18n.formDescricao());
	private HowMGWTProperty propertyPrecoVenda  			= properties.createProperty("vlPrecoVenda", 		Tradutor.i18n.formPrecoVenda());
	private HowMGWTProperty propertyQtde					= properties.createProperty("qtde",					Tradutor.i18n.formQtde());

    
	private HowMGWTProperty propertyDataReserva 			= properties.createProperty("dtReservaEstoque", 	Tradutor.i18n.formReserva());
	private HowMGWTProperty propertyDataEfetivacaoReserva	= properties.createProperty("dtEfetivacaoPedido", 	Tradutor.i18n.formEfetivacaoReserva());
	private HowMGWTProperty propertySituacao    			= properties.createProperty("situacao",				Tradutor.i18n.formSituacao());
	
	private HowMGWTProperty propertyEDISaldoEstoque			= properties.createProperty("ediSaldo", 			Tradutor.i18n.formSaldoEstoqueEDI());
	private HowMGWTProperty propertyEDIPrecoVenda			= properties.createProperty("ediPrecoVenda", 		Tradutor.i18n.formPrecoVendaEDI());
	
	private HowMGWTProperty propertyPedidoItemSituacao		= properties.createProperty("pedidoItemSituacao", 	""); 
	
	private HowMGWTProperty propertyMensagem				= properties.createProperty("mensagem", 			Tradutor.i18n.formMensagem());

	private HowMGWTProperty propertyNrVerificacoesEdi		= properties.createProperty("nrVerificacoesEdi", 	"");
	private HowMGWTProperty propertyDtUltimaVerificacao 	= properties.createProperty("dtUltimaVerificacao", 	"");
	
	private HowMGWTProperty propertyCodReservaEDI    		= properties.createProperty("codReservaEDI",		Tradutor.i18n.formCodReservaEDI());	
	private HowMGWTProperty propertyCodPedidoEDI    		= properties.createProperty("codPedidoEDI",			Tradutor.i18n.formCodPedidoEDI());

	
	
	IButton actionHistorico 		= new IButton("");
	IButton actionEstoque 			= new IButton("");
	IButton actionCancelaEstoque 	= new IButton("");
	IButton actionEfetivaReserva 	= new IButton("");

	private HowMGWTFormToolbarEdit formToolbarEdit;
	
	public PainelReservaEfetivacao(PainelMonitorEDIControle parentMonitorEDIControle){
		
		this.parentMonitorEDIControle = parentMonitorEDIControle;
		
		this.setWidth100();
		this.setHeight(120);
		
		HLayout mainLayout = new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight(150);
		
		VLayout hLayout = new VLayout();
		hLayout.setHeight100();
		hLayout.setWidth100();
		
		int widthLabel = 90;

		// --------------------------------------------------------------------
		
		HLayout hProduto = new HLayout();
		hProduto.setWidth100();
		hProduto.setHeight(22);
		propertyCodProduto.setBound(widthLabel, 130);
		propertyCodProduto.createHowMGWTFormFieldTextItem();

		propertyDescricao.setBound(widthLabel, 400);
		propertyDescricao.createHowMGWTFormFieldTextItem();
		
		hProduto.addMember(propertyCodProduto.getCanvas());
		hProduto.addMember(propertyDescricao.getCanvas());
		hLayout.addMember(hProduto);		
		
		// --------------------------------------------------------------------

		HLayout hEstoque = new HLayout();
		hEstoque.setWidth100();
		hEstoque.setHeight(22);
		
		propertyQtde.setBound(widthLabel, 130);
		propertyQtde.createHowMGWTFormFieldTextItem();
		
		propertyPrecoVenda.setBound(widthLabel, 100);
		propertyPrecoVenda.createHowMGWTFormFieldTextItem();
		
		propertySituacao.setBound(165, 130);
		propertySituacao.createHowMGWTFormFieldSelectItem();

		hEstoque.addMember(propertyQtde.getCanvas());
		hEstoque.addMember(propertyPrecoVenda.getCanvas());
		hEstoque.addMember(propertySituacao.getCanvas());
		hLayout.addMember(hEstoque);
		
 
		
		this.propertySituacao.getHowMGWTEditorSelectItem().getField().setDefaultValue("");
		this.propertySituacao.getHowMGWTEditorSelectItem().getField().setValueMap(PainelMonitorEDI.getEDISituacoes());
				
		
		
		// --------------------------------------------------------------------		
		
		HLayout hSituacao = new HLayout();
		hSituacao.setWidth100();
		hSituacao.setHeight(22);
		
		propertyDataReserva.setBound(widthLabel, 130);
		propertyDataReserva.createHowMGWTFormFieldTextItem();


		propertyDataEfetivacaoReserva.setBound(widthLabel, 130);
		propertyDataEfetivacaoReserva.createHowMGWTFormFieldTextItem();
		

		propertyDataReserva.setType(ListGridFieldType.DATE);

		propertyDataEfetivacaoReserva.setType(ListGridFieldType.DATE);		
		
		hSituacao.addMember(propertyDataReserva.getCanvas());
		hSituacao.addMember(propertyDataEfetivacaoReserva.getCanvas());
		hLayout.addMember(hSituacao);

		HLayout hCodigosEDI = new HLayout();
		hCodigosEDI.setWidth100();
		hCodigosEDI.setHeight(22);
		
		
		propertyCodReservaEDI.setBound(widthLabel, 130);
		propertyCodReservaEDI.createHowMGWTFormFieldTextItem();
		
		propertyCodPedidoEDI.setBound(widthLabel, 130);
		propertyCodPedidoEDI.createHowMGWTFormFieldTextItem();

		hCodigosEDI.addMember(propertyCodReservaEDI.getCanvas());
		hCodigosEDI.addMember(propertyCodPedidoEDI.getCanvas());

		
		hLayout.addMember(hCodigosEDI);
		
		
		

		HLayout tools = new HLayout();
		tools.setWidth100();
		tools.setHeight(24);
		
		
		
		// ------------------------------------------------------------------------
		// ações do usuório
		
		// Action Histórico
		// ------------------------------------------------------------------------
		actionHistorico.setTitle(Tradutor.i18n.formHistorico());
		actionHistorico.setIcon("actions/btn_history.png");
		actionHistorico.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				showHistorico();
			}
		});
		tools.addMember(actionHistorico);		
		tools.addMember(getSeparator());
		
		// Action Reserva Estoque
		// ------------------------------------------------------------------------
		actionEstoque.setTitle(Tradutor.i18n.formReservaEstoque());
		actionEstoque.setIcon("actions/approve.png");
		actionEstoque.setWidth(140);
		actionEstoque.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				confirmaAcao(ACTION_RESERVA_ESTOQUE);
			}
		});
		tools.addMember(actionEstoque);		
		tools.addMember(getSeparator());

		
		// Action Cancela Reserva Estoque
		// ------------------------------------------------------------------------
		actionCancelaEstoque.setTitle(Tradutor.i18n.formCancelaReservaEstoque());
		actionCancelaEstoque.setIcon("actions/og_delete.gif");
		actionCancelaEstoque.setWidth(170);
		actionCancelaEstoque.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				confirmaAcao(ACTION_CANCELA_RESERVA_ESTOQUE);
			}
		});
		tools.addMember(actionCancelaEstoque);		
		tools.addMember(getSeparator());
		
		
		// Action Efetiva Reserva Estoque
		// ------------------------------------------------------------------------
		actionEfetivaReserva.setTitle(Tradutor.i18n.formEfetivaReservaEstoque());
		actionEfetivaReserva.setIcon("actions/approve.png");
		actionEfetivaReserva.setWidth(166);
		actionEfetivaReserva.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				confirmaAcao(ACTION_EFETIVA_RESERVA);
			}
		});
		tools.addMember(actionEfetivaReserva);		
		
		
		
		
		hLayout.addMember(tools);
		
		// --------------------------------------------------------------------
		
		Img img = new Img("logos/estoque.gif");
		img.setWidth(120);
		img.setHeight(120);
		this.addMember(img);
		this.addMember(hLayout);
		
 		propertyCodProduto.getFormField().setHowMDisable(true);
		
 		propertyDescricao.getFormField().setHowMDisable(true);
		propertyPrecoVenda.getFormField().setHowMDisable(true);
		propertyQtde.getFormField().setHowMDisable(true);
	    
		propertyDataReserva.getFormField().setHowMDisable(true);
		propertyDataEfetivacaoReserva.getFormField().setHowMDisable(true);
		propertySituacao.getFormField().setHowMDisable(true);
		
		propertyCodReservaEDI.getFormField().setHowMDisable(true);
		propertyCodPedidoEDI.getFormField().setHowMDisable(true);
		
		actionHistorico.setDisabled(true);
		actionEstoque.setDisabled(true);
		actionCancelaEstoque.setDisabled(true);
		actionEfetivaReserva.setDisabled(true);
		
		formToolbarEdit = new HowMGWTFormToolbarEdit(this);
		
	}	
	
	private HLayout getSeparator(){
		HLayout sep = new HLayout();
		sep.setWidth(6);
		sep.setHeight(2);
		return sep;
	}

	@Override
	public HowMGWTFormProperties getHowMProperties() {
		return properties;
	}

	@Override
	public void onHowMDeleteRecord() {}

	@Override
	public void onHowMEditRecord() {}

	@Override
	public void onHowMLoad(HowMGWTFormBean formBean) {}

	@Override
	public void onHowMNewRecord() {}

	@Override
	public void onHowMSave() {}

	@Override
	public void onHowMSetValues(ListGridRecord record) {}
	
	@Override
	public void onHowMRelation(ListGridRecord record) {
		
		this.currentRecord = record;
		
		if ( record == null ){
			this.actionHistorico.setDisabled(true);
			this.actionEstoque.setDisabled(true);			
			this.actionCancelaEstoque.setDisabled(true);			
			this.actionEfetivaReserva.setDisabled(true);
			formToolbarEdit.newRecord();
			return;
		}
		formToolbarEdit.convertRecordToForm(record);
		
		String situacao = propertySituacao.getHowMValue() ;
		
		this.actionHistorico.setDisabled(false);
		this.actionEstoque.setDisabled(true);			
		this.actionCancelaEstoque.setDisabled(true);
		this.actionEfetivaReserva.setDisabled(true);			

		
		eEDI edi = PainelMonitorEDIControle.mapObjectsEDIs.get(propertyCodEDI.getHowMValue(this.currentRecord));
		
		int situacaoPedido = HowMGWTUtilities.getInteger(propertyPedidoItemSituacao.getHowMValue(this.currentRecord));
		if ( situacaoPedido != SISTEMA_PEDIDO_SITUACAO_CANCELADO ){
			if ( 
				HowMGWTUtilities.isEquals(PainelMonitorEDI.SITUACAO_AGUARDANDO_RESERVA, situacao) 
			){
				if ( situacaoPedido >= HowMGWTUtilities.getInteger(edi.getSituacaoPedidoReserva() ))
					this.actionEstoque.setDisabled(false);			
			}
			else if ( HowMGWTUtilities.isEquals(PainelMonitorEDI.SITUACAO_RESERVADO, situacao)){
				this.actionCancelaEstoque.setDisabled(false);			
				if ( situacaoPedido >= HowMGWTUtilities.getInteger(edi.getSituacaoPedidoEfetivacao() ))
					this.actionEfetivaReserva.setDisabled(false);			
			}
			else if ( HowMGWTUtilities.isEquals(PainelMonitorEDI.SITUACAO_RESERVA_EFETIVADA, situacao)){
			}
		}
	}
		
	public void confirmaAcao(String acao){
		if ( windowConfirmaAcao == null ){
			windowConfirmaAcao = new WindowConfirmaAcao(){
				@Override
				protected void onHowMGWTClose() {
					if ( parentMonitorEDIControle != null ){
						System.out.print("onHowMGWTClose()");
						PainelReservaEfetivacao.this.onHowMRelation(parentMonitorEDIControle.getToolbarEdit().getPanelList().getSelectedRecord());
					}
				}	
			};
			windowConfirmaAcao.setParentMonitorEDIControle(this.parentMonitorEDIControle);
		}
		String codEDI 		= propertyCodEDI.getHowMValue(currentRecord);
		String descEDI		= PainelMonitorEDIControle.mapEDIs.get(codEDI);
		String codPedido	= propertyCodPedido.getHowMValue(currentRecord); 
		String codProduto	= propertyCodProduto.getHowMValue(currentRecord);
		
		windowConfirmaAcao.showExecutaAcao(codEDI, descEDI, codPedido, codProduto, acao);
	}
 
	// Apresenta o histórico do registro
	public void showHistorico(){
		if ( windowHistorico == null ){
			windowHistorico = new WindowHistorico();
		}
		// Monta a chave de busca
		String[] chaves = new String[]{
			propertyCodEdiPedidoItem.getHowMValue(currentRecord)
		};
		// Carrega os históricos do registro.
		windowHistorico.showHistorico(parentMonitorEDIControle.getDescHist().toUpperCase(), "", chaves , parentMonitorEDIControle.getTpHist());
	}
	
}