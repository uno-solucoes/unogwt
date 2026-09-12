package com.br.client.panel.ed.edw0002.UI;

import java.util.Date;
import java.util.LinkedHashMap;

import com.br.client.model.ed.edw0002.FormBean;
import com.br.client.model.ed.entity.eEDI;
import com.br.client.model.ed.entity.eEDIPedidoVendaItem;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.FactoryUCommerce;
import com.br.client.panel.ed.edw0001.UI.WindowPainelEDI;
import com.howmake.client.form.UI.HowMGWTFormToolbarEdit;
import com.howmake.client.form.UI.HowMGWTLabel;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.UI.HowMGWTPanelInstrucaoFiltro;
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
import com.smartgwt.client.types.Side;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

public class PainelMonitorEDIControle extends VLayout implements HowMGWTControlForm{

	private VLayout mainPainelFiltro;
	
    private HowMGWTLabel labelMessage = new HowMGWTLabel();
    private boolean modoPedido = false;
	
	private String tpHist;
	private String descHist;
	
	public static LinkedHashMap< String, eEDI> mapObjectsEDIs = new LinkedHashMap<String, eEDI>();
	public static LinkedHashMap< String, String > mapEDIs = new LinkedHashMap<String, String>();
	
	private HowMGWTFormProperties propertiesFiltro = new HowMGWTFormProperties();
	
	private HowMGWTProperty propertyEDI 					= propertiesFiltro.createProperty("codEDI", 		Tradutor.i18n.formCodEDI());
	
	private HowMGWTProperty propertyDataInicio 				= propertiesFiltro.createProperty("dtInicio", 		Tradutor.i18n.formDataInicio());
	private HowMGWTProperty propertyDataFim					= propertiesFiltro.createProperty("dtFim", 			Tradutor.i18n.formDataFim());

	private HowMGWTProperty propertyCodPedidoFiltro			= propertiesFiltro.createProperty("codPedido", 		Tradutor.i18n.formCodigoPedido());
	private HowMGWTProperty propertyCodCliente  			= propertiesFiltro.createProperty("codCliente", 	Tradutor.i18n.formCodigoCliente());
	
	private HowMGWTProperty propertySituacaoFiltro    		= propertiesFiltro.createProperty("situacao",		Tradutor.i18n.formSituacao());

	private PainelReservaEfetivacao painelReservaEfetivacao = new PainelReservaEfetivacao(this);
	
	private HowMGWTFormProperties properties = new HowMGWTFormProperties();
	
	private HowMGWTProperty propertyCodEmpresa				= properties.createProperty("codEmpresa", 			Tradutor.i18n.formCodEmpresa());
	private HowMGWTProperty propertyCodEDI					= properties.createProperty("codEDI", 				Tradutor.i18n.formCodEDI());
	private HowMGWTProperty propertyCodEdiPedidoItem		= properties.createProperty("codEdiPedidoItem", 	Tradutor.i18n.formCodEdiPedidoItem());

	private HowMGWTProperty propertyCodPedido				= properties.createProperty("codPedido", 			Tradutor.i18n.formCodigoPedido());

	private HowMGWTProperty propertyCodProduto  			= properties.createProperty("codProduto", 			Tradutor.i18n.formCodProduto());
	
	private HowMGWTProperty propertyItemPedido				= properties.createProperty("nrSequencia", 			Tradutor.i18n.formItem());
	private HowMGWTProperty propertyDescricao				= properties.createProperty("descComercial",  			Tradutor.i18n.formDescricao());
	private HowMGWTProperty propertyPrecoVenda  			= properties.createProperty("vlPrecoVenda", 		Tradutor.i18n.formPrecoVenda());
	private HowMGWTProperty propertyQtde					= properties.createProperty("qtde",					Tradutor.i18n.formQtde());
    
	private HowMGWTProperty propertyDataReserva 			= properties.createProperty("dtReservaEstoque", 	Tradutor.i18n.formReserva());
	private HowMGWTProperty propertyDataEfetivacaoReserva	= properties.createProperty("dtEfetivacaoPedido", 	Tradutor.i18n.formEfetivacaoReserva());
	private HowMGWTProperty propertySituacao    			= properties.createProperty("situacao",				Tradutor.i18n.formSituacao());
  
	private HowMGWTProperty propertyCodReservaEDI    		= properties.createProperty("codReservaEDI",		Tradutor.i18n.formCodReservaEDI());	
	private HowMGWTProperty propertyCodPedidoEDI    		= properties.createProperty("codPedidoEDI",			Tradutor.i18n.formCodPedidoEDI());
 
	private HowMGWTProperty propertyEDISaldoEstoque			= properties.createProperty("ediSaldo", 			Tradutor.i18n.formSaldoEstoqueEDI());
	private HowMGWTProperty propertyEDIPrecoVenda			= properties.createProperty("ediPrecoVenda", 		Tradutor.i18n.formPrecoVendaEDI());

	private HowMGWTProperty propertyPedidoItemSituacao		= properties.createProperty("pedidoItemSituacao", 	""); 
	private HowMGWTProperty propertyMensagem				= properties.createProperty("mensagem", 			Tradutor.i18n.formMensagem());

	private HowMGWTProperty propertyNrVerificacoesEdi		= properties.createProperty("nrVerificacoesEdi", 	"");
	private HowMGWTProperty propertyDtUltimaVerificacao 	= properties.createProperty("dtUltimaVerificacao", 	"");
		
	private HowMGWTProperty propertyIndAtivo 				= properties.createProperty("indAtivo", 			"");
	
	
	private HowMGWTFormToolbarEdit toolbarEdit;
	
	private WindowPainelEDI painelEDI;
	
    private TabSet tabSet = new TabSet();  
    
    private VLayout painelLog = new VLayout();
    
    private HowMGWTListGrid panelList = new HowMGWTListGrid(){
		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
			String bgColor = "";
			String fieldName = getFieldName(colNum);

			if( HowMGWTUtilities.getInteger( propertyNrVerificacoesEdi.getHowMValue(record) ) > 0 
				&& 
				propertyCodProduto.getName().equalsIgnoreCase(fieldName) 
			){
				bgColor = "background-color:"+Tradutor.i18n.colorLayoutErro()+";";							
			}
			
			if ( "0".equals( propertyIndAtivo.getHowMValue(record) ) ){
				bgColor = "background-color:"+Tradutor.i18n.colorProdutoInativo()+";";				
			}
			return bgColor;
		};    	
    };
    
	
	public PainelMonitorEDIControle(){

		this.setWidth100();
		this.setHeight100();		

		this.addMember(createFilters());
		this.addMember(createList());
		
		HLayout indErro = new HLayout();
		indErro.setWidth100();
		indErro.setHeight(22);
		indErro.addMember(HowMGWTUtilities.getCanvasIndicator(18, 22, Tradutor.i18n.colorLayoutErro(), "1px solid #FF0000"));
		indErro.addMember(HowMGWTUtilities.getCanvasLabelIndicator(22, new HowMGWTLabel("Erros de processamento."))); 
		this.addMember(indErro);
		
		HLayout indInativo = new HLayout();
		indInativo.setWidth100();
		indInativo.setHeight(22);
		indInativo.addMember(HowMGWTUtilities.getCanvasIndicator(18, 22, Tradutor.i18n.colorProdutoInativo(), "1px solid #CD919E"));
		indInativo.addMember(HowMGWTUtilities.getCanvasLabelIndicator(22, new HowMGWTLabel("Produto inativo."))); 
		this.addMember(indInativo);
		
		
		
		
		this.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(1, "rgb(170,170,170)"));
		this.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(2, ""));
				
		
		
	    tabSet.setTabBarPosition(Side.TOP);  
	    tabSet.setTabBarThickness(34);
	   
	    tabSet.setWidth100();  
	    tabSet.setHeight(200);  	
		
	    Tab tabLayout = new Tab(Tradutor.i18n.formReservaEstoqueEfetivacaoReserva(), "tools/bot_network.png");
	    tabLayout.setPane(painelReservaEfetivacao);
	    
        tabSet.addTab(tabLayout);
        
	    Tab tabLog = new Tab(Tradutor.i18n.formLog(), "tools/bot_log.png");
	    
	    
	    HLayout messagelayout = new HLayout();
	    messagelayout.setWidth100();
	    messagelayout.setHeight100();
	    
	    messagelayout.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(10, ""));
	    
	    labelMessage.setWidth100();
	    labelMessage.setHeight100();
	    
	    messagelayout.addMember(labelMessage);
	    
	    painelLog.addMember(messagelayout);
	    
	    tabLog.setPane(painelLog);
		tabSet.addTab(tabLog);
	    
		this.addMember(tabSet);		
 		

		this.propertySituacaoFiltro.getHowMGWTEditorSelectItem().getField().setDefaultValue("");
		this.propertySituacaoFiltro.getHowMGWTEditorSelectItem().getField().setValueMap(PainelMonitorEDI.getEDISituacoes());
		
		
		
		this.loadEDIs();
	}
	
	
	/**
	 * @return Cria e retorna um cavas para apresentar os filtros de consulta do usuório.
	 */
	public VLayout createFilters(){
		VLayout filterLayout = new VLayout();
		filterLayout.setWidth100();
		filterLayout.setHeight(300);
	
		int widthLabel = 110;
		propertyEDI.setBound(widthLabel, 300);
		propertyEDI.createHowMGWTFormFieldSelectItem();		
		
		propertyDataInicio.setBound(widthLabel, 150);
		propertyDataInicio.createHowMGWTFormDateItem();
		
		propertyDataFim.setBound(widthLabel, 150);
		propertyDataFim.createHowMGWTFormDateItem();
		
		propertyCodPedidoFiltro.setBound(widthLabel, 80);
		FactoryUCommerce.createLookupBuscaPedido(propertyCodPedidoFiltro);

		propertyCodCliente.setBound(widthLabel, 80);
		FactoryUCommerce.createLookupBuscaCliente(propertyCodCliente);

		
		HLayout hSituacao = new HLayout();
		hSituacao.setWidth100();
		hSituacao.setHeight(22);
		
		propertySituacaoFiltro.setBound(widthLabel, 140);
		propertySituacaoFiltro.createHowMGWTFormFieldSelectItem();
		hSituacao.addMember(propertySituacaoFiltro.getCanvas());
		
		
		HLayout sepAction = new HLayout();
		sepAction.setWidth(240);
		sepAction.setHeight(2);
		hSituacao.addMember(sepAction);
		
		IButton actionBuscar = new IButton(Tradutor.i18n.buscar());
		actionBuscar.setIcon("actions/search.png");
		actionBuscar.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				executeQuery();
			}
		});
		
		hSituacao.addMember(actionBuscar);
		
		
		/** ------------------------------------------------------------------------- */
		IButton actionPainelEDI = new IButton(Tradutor.i18n.formConfiguracaoEDI());
		actionBuscar.setIcon("");
		actionPainelEDI.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if ( painelEDI == null ){
					painelEDI = new WindowPainelEDI();
				}
				painelEDI.show();
			}
		});
		hSituacao.addMember(actionPainelEDI);
		/** ------------------------------------------------------------------------- */

		
		
		// ------------------------------------------------------------------------
		// Constroi a interface do usuório para solicitação dos filtros de consulta
		// ------------------------------------------------------------------------		
		filterLayout.addMember(propertyEDI.getCanvas());
	
		// Datas
		HLayout hLayoutDatas = new HLayout();
		hLayoutDatas.setWidth100();
		hLayoutDatas.setHeight(22);
		hLayoutDatas.addMember(propertyDataInicio.getCanvas());
		hLayoutDatas.addMember(propertyDataFim.getCanvas());
		filterLayout.addMember(hLayoutDatas);
		
		// Lookups
		filterLayout.addMember(propertyCodPedidoFiltro.getCanvas());
		filterLayout.addMember(propertyCodCliente.getCanvas());
		filterLayout.addMember(hSituacao);

		filterLayout.addMember(new HowMGWTPanelInstrucaoFiltro());
		
		filterLayout.setHeight(180);
		
		// Seta o objeto de gerenciamento de filtro.
		mainPainelFiltro = filterLayout;
		
		return filterLayout;
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
		
		
		
		// Cria os campos para apresentação dos dados.
		this.propertyCodPedido.createHowMGWTListGridField();
		this.propertyItemPedido.createHowMGWTListGridField();
		this.propertyCodProduto.createHowMGWTListGridField();
		this.propertyDescricao.createHowMGWTListGridField();		
		this.propertyPrecoVenda.createHowMGWTListGridField();
		this.propertyQtde.createHowMGWTListGridField();
		this.propertySituacao.createHowMGWTListGridField();
		
		this.propertyDataEfetivacaoReserva.createHowMGWTListGridField();
		this.propertyDataReserva.createHowMGWTListGridField();
 
		propertyDtUltimaVerificacao.setType(ListGridFieldType.DATE);

		propertyEDISaldoEstoque.setWidthColumn(100);
		propertyEDIPrecoVenda.setWidthColumn(100); 

		propertyEDIPrecoVenda.setType(ListGridFieldType.FLOAT);
		propertyEDISaldoEstoque.setType(ListGridFieldType.FLOAT);
		
		propertyEDISaldoEstoque.createHowMGWTListGridField();
		propertyEDIPrecoVenda.createHowMGWTListGridField();
		
		propertyEDISaldoEstoque.getListField().setAlign(Alignment.RIGHT);
		propertyEDIPrecoVenda.getListField().setAlign(Alignment.RIGHT);
		
		propertyEDISaldoEstoque.createFormatDouble( "###,###,###,##0", "");
		propertyEDIPrecoVenda.createFormatDouble( "###,###,###,##0.00" , "" );		

		propertyQtde.getListField().setType(ListGridFieldType.FLOAT);
		propertyQtde.getListField().setAlign(Alignment.RIGHT);
		propertyQtde.createFormatDouble("###,###,###,##0");

		propertyPrecoVenda.setType(ListGridFieldType.FLOAT);
		propertyPrecoVenda.getListField().setAlign(Alignment.RIGHT);
		propertyPrecoVenda.createFormatDouble("###,###,###,##0.00");

		propertyDataReserva.setType(ListGridFieldType.DATE);
		propertyDataReserva.getListField().setAlign(Alignment.CENTER);
		propertyDataReserva.createFormatDate(Tradutor.i18n.formFormatDateTime());

		propertyDataEfetivacaoReserva.setType(ListGridFieldType.DATE);
		propertyDataEfetivacaoReserva.getListField().setAlign(Alignment.CENTER);
		propertyDataEfetivacaoReserva.createFormatDate(Tradutor.i18n.formFormatDateTime());

		
		this.propertySituacao.getListField().setValueMap(PainelMonitorEDI.getEDISituacoes());
		
		// Define a ordem que será visualizada as colunas.
		int order = 1;
		this.propertyCodPedidoFiltro.setOderList(order++);
		this.propertyItemPedido.setOderList(order++);
		this.propertyCodProduto.setOderList(order++);
		this.propertyDescricao.setOderList(order++);
		this.propertyPrecoVenda.setOderList(order++);
		this.propertyQtde.setOderList(order++);
		this.propertySituacao.setOderList(order++);

		
		toolbarEdit = new HowMGWTFormToolbarEdit(this, panelList);

		toolbarEdit.getPanelList().setWidth100();
		toolbarEdit.getPanelList().setHeight100();
		resultLayout.addMember(toolbarEdit.getPanelList());
		
		
		return resultLayout;
		
	}
	
	
 
	
	
	
	
	// ---------------------------------------------------------------------------------
	// Implementação controle
	// ---------------------------------------------------------------------------------
	@Override
	public HowMGWTFormProperties getHowMProperties() {		
		return properties;
	}

	@Override
	public void onHowMDeleteRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHowMEditRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHowMLoad(HowMGWTFormBean formBean) {
		
		this.toolbarEdit.getPanelList().clearAllRecords();
		
		FormBean bean = (FormBean)formBean;

		this.setTpHist(bean.getTpHist());
		this.setDescHist(bean.getDescHist());

		if ( bean.getPedidoItens() == null || bean.getPedidoItens().length == 0 ){
			SC.say(Tradutor.i18n.formNaoExisteItensParaMostrar());
			return;
		}

		RecordList records = this.toolbarEdit.getPanelList().getRecordList();

		for ( eEDIPedidoVendaItem item : bean.getPedidoItens() ){
			ListGridRecord record = toolbarEdit.convertFormBeanToRecord(item);	
			records.add(record);			
		}		
 	}

	@Override
	public void onHowMNewRecord() {}

	@Override
	public void onHowMRelation(ListGridRecord record) {}

	@Override
	public void onHowMSave() {}

	@Override
	public void onHowMSetValues(ListGridRecord record) {
		painelReservaEfetivacao.onHowMRelation(record);

		labelMessage.setHowMValue("");
		
		if ( record != null ){

			String erro = ""; 
			if( HowMGWTUtilities.getInteger( propertyNrVerificacoesEdi.getHowMValue(record) ) > 0  )
				erro = "<font color=red><b>"+Tradutor.i18n.msgMensagemErroUltimoProcessamento()+"</b></font><hr>";
			
			Date data = HowMGWTUtilities.getDate(propertyDtUltimaVerificacao.getHowMValue(record));
			
			labelMessage.setHowMValue(
					erro
					+
					"&Uacute;ltimo processamento : "
					+
					"<b>"+HowMGWTUtilities.getFormatDateTime(data)+"</b><br>"
					+
					"Produto : "
					+
					"<b>"+propertyCodProduto.getHowMValue(record)+"</b>"
					+
					"<hr>"
					+
					propertyMensagem.getHowMValue(record)
			);
		}

	}
	
	
	
	/**
	 * Executa a consulta no banco de dados.
	 */
	public void loadEDIs(){
		mapEDIs.clear();
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
				String ediPadrao = "";
				if ( bean.getEdis() != null ){
					for ( eEDI edi : bean.getEdis() ){
						mapObjectsEDIs.put(edi.getCodEdi(), edi);
						mapEDIs.put(edi.getCodEdi(), edi.getNomeServico());
						if( HowMGWTUtilities.isEmpty(ediPadrao))
							ediPadrao = edi.getCodEdi();
					}
				}
				else{
					mapEDIs.put("",  "");
				}
				propertyEDI.getHowMGWTEditorSelectItem().getField().setDefaultValue(ediPadrao);
				propertyEDI.getHowMGWTEditorSelectItem().getField().setValueMap(mapEDIs);					
				HowMGWTWindowWait.hideWait();
			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
				toolbarEdit.onHowMConfigureStatusNewRecord();
			}			
		};					 
		String body = "";
		struts.request("edw0002.do?method=buscarEDIs",  "EDW0002Form", body);				
	}	

	/**
	 * Executa a consulta no banco de dados.
	 */
	public void executeQuery(){
		HowMGWTWindowWait.showWait();
		
		painelReservaEfetivacao.onHowMRelation(null );
		
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
				toolbarEdit.onHowMConfigureStatusNewRecord();
			}			
		};					 
		propertiesFiltro.loadFormValues(formBean);
		if ( modoPedido ){
			formBean.setCodEDI(null);
		}
		String body =  HowMGWTUtilities.getGWTBeanTransfer(formBean.toJsonObject("").toString());
		
		struts.request("edw0002.do?method=buscarEdiPedidos",  "EDW0002Form", body);				
	}

	/**
	 * Executa consulta usando o código do edi e o código do pedido ao carregar janela de 
	 * monitoramento.
	 * @param codEDI
	 * @param codPedido
	 */
	public void executeQuery(String codPedido){
		mainPainelFiltro.setVisible(false);
		Date oldDate = new Date(2012-1900,0,0);
		modoPedido = true;
		this.propertyDataInicio.getHowMGWTEditorDateItem().setHowMValue(oldDate);
		this.propertyCodPedidoFiltro.getHowMGWTEditorCodeDescriptor().getField().setHowMValue(codPedido);
		this.executeQuery();
	}

	
	/**
	 * @return the toolbarEdit
	 */
	public HowMGWTFormToolbarEdit getToolbarEdit() {
		return toolbarEdit;
	}


	/**
	 * @return the tpHist
	 */
	public String getTpHist() {
		return tpHist;
	}


	/**
	 * @param tpHist the tpHist to set
	 */
	public void setTpHist(String tpHist) {
		this.tpHist = tpHist;
	}


	/**
	 * @return the descHist
	 */
	public String getDescHist() {
		return descHist;
	}


	/**
	 * @param descHist the descHist to set
	 */
	public void setDescHist(String descHist) {
		this.descHist = descHist;
	}
	
}
