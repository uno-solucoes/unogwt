package com.br.client.panel.eq.eqd0018;

import java.util.ArrayList;

import com.br.client.model.eq.eqd0018.FormBean;
import com.br.client.model.vd.entity.eNotaFiscalItemEtq;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.FactoryUCommerce;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Window;
import com.howmake.client.form.UI.HowMGWTFormToolbarEdit;
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
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.RecordSummaryFunctionType;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public abstract class WindowPainelNotasFiscais  extends HowMGWTWindow implements HowMGWTControlForm{
	
	private HowMGWTFormProperties propertiesFiltro 		= new HowMGWTFormProperties();
	private HowMGWTFormProperties properties			= new HowMGWTFormProperties();

	public HowMGWTProperty propertyCodCliente			= propertiesFiltro.createProperty("codCliente",		Tradutor.i18n.formCodCliente() );
	private HowMGWTProperty propertySerie				= propertiesFiltro.createProperty("serie",			Tradutor.i18n.formSerie());
	private HowMGWTProperty propertyCbarras				= propertiesFiltro.createProperty("cbarras", 		Tradutor.i18n.formCodBarra());
	private HowMGWTProperty propertyCodProdutoFiltro	= propertiesFiltro.createProperty("codProduto",		Tradutor.i18n.formCodProduto() );
	
	private HowMGWTProperty propertyCodPedidoFiltro		= propertiesFiltro.createProperty("codPedido", 		Tradutor.i18n.formPedido());
	private HowMGWTProperty propertyNrSerieFiltro		= propertiesFiltro.createProperty("nrSerie", 		Tradutor.i18n.formNrSerie() );

	
	public HowMGWTProperty propertyCodPedido			= properties.createProperty("codPedido", 			Tradutor.i18n.formPedido());
	public HowMGWTProperty propertyCodNotaFiscal		= properties.createProperty("codNotaFiscal",		"Cod Nota Fiscal" );
	public HowMGWTProperty propertyNrNotaFiscal			= properties.createProperty("nrNotaFiscal",			Tradutor.i18n.formNrNotaFiscal() );
	public HowMGWTProperty propertyTpFreteSaida			= properties.createProperty("tpFrete"				,Tradutor.i18n.tpFreteSaida());

	
	public HowMGWTProperty propertySequenciaNF			= properties.createProperty("nrSequenciaNf",		Tradutor.i18n.formSeqNF() );

	public HowMGWTProperty propertyCodLote				= properties.createProperty("codLote",				Tradutor.i18n.formSeqNF() );
	public HowMGWTProperty propertyNrSequenciaEtq		= properties.createProperty("nrSequenciaEtq",		Tradutor.i18n.formSeqNF() );
	 

	
	public HowMGWTProperty propertyCodProduto			= properties.createProperty("codProduto",	Tradutor.i18n.formCodProduto() );
	public HowMGWTProperty propertyDescProduto 			= properties.createProperty("descProduto", 	Tradutor.i18n.formDescComercial() );
	public HowMGWTProperty propertyNrSerie				= properties.createProperty("nrSerie", 		Tradutor.i18n.formNrSerie() );
	public HowMGWTProperty propertyQtdSaida				= properties.createProperty("qtd", 			Tradutor.i18n.formQtdeSaida());
	public HowMGWTProperty propertyQtdEntrada			= properties.createProperty("qtdDevolvida", Tradutor.i18n.formQtdeEntrada());
	public HowMGWTProperty propertyPrecoUnitSaida		= properties.createProperty("precoVenda",	Tradutor.i18n.formPrecoUniSaida());
	public HowMGWTProperty propertyValorTotal			= properties.createProperty("valorTotal",	Tradutor.i18n.formValorTotal());
	public HowMGWTProperty propertyUN					= properties.createProperty("un",			Tradutor.i18n.formUn());
	
	private VLayout mainLayout = new VLayout();
	private VLayout mainFiltro = new VLayout();
	
	private HowMGWTFormToolbarEdit formToolbarEdit;
	
	private HowMGWTListGrid panelGrid = new HowMGWTListGrid();
	
	
	private IButton actionImportar = new IButton(Tradutor.i18n.formImportar());
	
	public WindowPainelNotasFiscais(){
		
 		this.setIsModal(true);
		this.setWidth("900");
		this.setHeight("650");
		this.centerInPage();		
		
		panelGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		panelGrid.setWrapCells(true);  
		panelGrid.setFixedRecordHeights(false); 	
 		
 		mainLayout.setWidth100();
 		mainLayout.setHeight100();
 		 		
 		mainFiltro.setWidth100();
 		mainFiltro.setAutoHeight();

 		int widthLabel = 80;

 		// Monta formulório de filtro.
 		
 		propertyCodCliente.setBound(widthLabel, 80);
 		propertyCodProdutoFiltro.setBound(widthLabel, 130);
 		propertyNrNotaFiscal.setBound(widthLabel, 100);
		propertySerie.setBound(30, 30); 		
 		propertyCodPedidoFiltro.setBound(widthLabel, 100);
 		propertyNrSerieFiltro.setBound(widthLabel, 150);	
 		propertyCbarras.setBound(widthLabel, 200);

 		FactoryUCommerce.createLookupBuscaCliente(propertyCodCliente);
 		FactoryUCommerce.createLookupBuscaProduto(propertyCodProdutoFiltro);
 		
 		// propertyCodProdutoFiltro.createHowMGWTFormFieldTextItem();
 		
 		propertyNrNotaFiscal.createHowMGWTFormFieldTextItem();
 		propertySerie.createHowMGWTFormFieldTextItem();
 		
 		FactoryUCommerce.createLookupBuscaPedido(propertyCodPedidoFiltro);
 		propertyNrSerieFiltro.createHowMGWTFormFieldTextItem();
 		propertyCbarras.createHowMGWTFormFieldTextItem();

 		mainFiltro.addMember(propertyCodCliente.getCanvas());
 		mainFiltro.addMember(propertyCodProdutoFiltro.getCanvas());
 		
 		HLayout nfLayout = new HLayout();
 		nfLayout.setWidth100();
 		nfLayout.setHeight(22);

 		nfLayout.addMember(propertyNrNotaFiscal.getCanvas());
 		nfLayout.addMember(propertySerie.getCanvas()); 

 		mainFiltro.addMember(nfLayout);

 		mainFiltro.addMember(propertyCodPedidoFiltro.getCanvas());
 		mainFiltro.addMember(propertyNrSerieFiltro.getCanvas());	
 		mainFiltro.addMember(propertyCbarras.getCanvas());

 		mainLayout.addMember(mainFiltro);
 
 		// -------------------------------------------------------------------------
 		// Configura colunas da grid de resultado.
 		// ------------------------------------------------------------------------- 		
 		propertyCodPedido.setWidthColumn(55);
 		propertyNrNotaFiscal.setWidthColumn(55);
 		
 		
 		propertySequenciaNF.setWidthColumn(30);
 		
 		propertyCodProduto.setWidthColumn(115);
 		propertyDescProduto.setWidthColumn(180);
 		propertyNrSerie.setWidthColumn(110);
 		
 		propertyQtdSaida.setWidthColumn(55);
 		propertyPrecoUnitSaida.setWidthColumn(90);
 		propertyValorTotal.setWidthColumn(80);
 		propertyUN.setWidthColumn(30);
 
  		propertyValorTotal.setType(ListGridFieldType.FLOAT);
		
 		propertyCodPedido.createHowMGWTListGridField();
 		propertyNrNotaFiscal.createHowMGWTListGridField();
 		propertySequenciaNF.createHowMGWTListGridField();
 		propertyCodProduto.createHowMGWTListGridField();
 		propertyDescProduto.createHowMGWTListGridField();
 		propertyNrSerie.createHowMGWTListGridField();
 		propertyQtdSaida.createHowMGWTListGridField();
 		propertyPrecoUnitSaida.createHowMGWTListGridField();
 		propertyValorTotal.createHowMGWTListGridField();
 		
 		propertyUN.createHowMGWTListGridField();
 		
 		propertyQtdSaida.createFormatDouble(" #,##0.00");
 		propertyPrecoUnitSaida.createFormatDouble(" #,##0.00"); 		
 		
 		propertyValorTotal.getListField().setRecordSummaryFunction(RecordSummaryFunctionType.SUM);
 		propertyValorTotal.createFormatDouble("#,##0.00");
  		
 		propertyQtdSaida.getListField().setShowGroupSummary(false);
 		propertyPrecoUnitSaida.getListField().setShowGroupSummary(false); 				

 		propertyQtdSaida.getListField().setShowGridSummary(false);
 		propertyPrecoUnitSaida.getListField().setShowGridSummary(false); 				

 		propertyValorTotal.getListField().setShowGridSummary(true);  
 		
 		
		CellFormatter formatter = new CellFormatter() {
		        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
		        	if ( HowMGWTUtilities.isEmpty( record.getAttribute(propertyCodNotaFiscal.getName()) ) )
		        			return "";
		        	
		        	return NumberFormat.getFormat("#,##0.00").format(HowMGWTUtilities.getDouble(value));
		        }
		};
		propertyQtdSaida.getListField().setType(ListGridFieldType.FLOAT);
		propertyQtdSaida.getListField().setCellFormatter(formatter);
		
		propertyPrecoUnitSaida.getListField().setType(ListGridFieldType.FLOAT);
		propertyPrecoUnitSaida.getListField().setCellFormatter(formatter);
		
 		
 		panelGrid.setWidth100();
 		panelGrid.setHeight100();
 		
 		formToolbarEdit = new HowMGWTFormToolbarEdit(this, panelGrid);

 		formToolbarEdit.getActionNovo().setVisible(false);
 		formToolbarEdit.getActionGravar().setVisible(false); 
 		
 		
 		formToolbarEdit.createActionBuscar(); 
 		formToolbarEdit.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(300,""));
 		
 		actionImportar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				 
				ListGridRecord[]  records = panelGrid.getSelectedRecords();
				if ( records.length == 0 ){
					SC.say(Tradutor.i18n.msgNaoHaRegistrosParaImportacao());
					return;					
				}
				ArrayList<eNotaFiscalItemEtq> itens = new ArrayList<eNotaFiscalItemEtq>();
				eNotaFiscalItemEtq item;
				for ( ListGridRecord record : records ){
					item = new eNotaFiscalItemEtq();
					formToolbarEdit.convertRecordToFormBean(record, item);	
					itens.add(item);
				}
				onImportarNotas(itens);
				hide();
				
			}
		});
 		actionImportar.setWidth(100);
 		actionImportar.setIcon("actions/approve.png");
 		formToolbarEdit.addMember(actionImportar);

 		
 		mainLayout.addMember(formToolbarEdit);
 		mainLayout.addMember(panelGrid);
 	
 		
 		this.addItem(mainLayout);
 	 		
	}
	
	
	/**
	 * Visualiza a janela para consulta de notas fiscais.
	 * @param codCliente
	 * @param nomeCliente
	 */
	public void showNotas(String codCliente, String nomeCliente ){
				
		this.panelGrid.clearAllRecords();
		
		this.propertyCodCliente.getFormField().setHowMDisable(true);
		
		this.propertyCodCliente.getHowMGWTEditorCodeDescriptor().getField().setHowMValue(codCliente);
		this.propertyCodCliente.getHowMGWTEditorCodeDescriptor().getMessageLabel().setHowMValue(nomeCliente);
		
		
 		propertyCodPedidoFiltro.getHowMGWTEditorCodeDescriptor().getField().setHowMValue("");
 		propertyCodPedidoFiltro.getHowMGWTEditorCodeDescriptor().getMessageLabel().setHowMValue("");
 		
 		propertyCodProdutoFiltro.getHowMGWTEditorCodeDescriptor().getField().setHowMValue("");
 		propertyCodProdutoFiltro.getHowMGWTEditorCodeDescriptor().getMessageLabel().setHowMValue("");
 		
 		propertyNrSerieFiltro.setHowmFormValue("");
 		propertyNrNotaFiscal.setHowmFormValue("");
 		propertyCbarras.setHowmFormValue("");
 		
		
		this.show();
	}

	public String getHowMGWTTitle(){
    	return  Tradutor.i18n.formTituloEQD0018();
	}

	public String getHowMGWTPrograma(){
		return "EQD0018";
	}

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
	public void onHowMLoad(HowMGWTFormBean pFormBean) {
		 
		panelGrid.clearAllRecords();

		FormBean formBean = new FormBean();

		// -------------------------------------------------------------------------------
		// Grava os dados no servidor.
		// -------------------------------------------------------------------------------
		HowMGWTWindowWait.showWait();		
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, false)){
					return;
				}

				FormBean bean = (FormBean)formBean;
				RecordList recordList = new RecordList();
				ListGridRecord record;
				ListGridRecord lastRecord = null;

				if ( bean.getItensEtq() != null ){	
					for ( eNotaFiscalItemEtq itemEtq : bean.getItensEtq()){
						record = new ListGridRecord();
						formToolbarEdit.convertFormBeanToRecord(record, itemEtq );
						
						double qtd        = HowMGWTUtilities.getDouble(record.getAttribute(propertyQtdSaida.getName()));
						double precoUnit  = HowMGWTUtilities.getDouble(record.getAttribute(propertyPrecoUnitSaida.getName()));
						double valorTotal = qtd * precoUnit;
						 
						record.setAttribute(propertyValorTotal.getName(), valorTotal );
						
						if ( lastRecord == null )
							lastRecord = record;
						recordList.add(record);
					}
					formToolbarEdit.getPanelList().setData(recordList);				

					panelGrid.setShowGridSummary(true);  

					formToolbarEdit.onHowMConfigureStatus(lastRecord);
				}

				HowMGWTWindowWait.hideWait();
			}

			@Override
			public void onError(Throwable err) {
				Window.alert("Erro  : "+err);
				super.onError(err);
			}			
		};

		formBean.setCodCliente(propertyCodCliente.getHowMValue());			// ok
		formBean.setCodProduto(propertyCodProdutoFiltro.getHowMValue());			
		formBean.setNrNotaFiscal(propertyNrNotaFiscal.getHowMValue());		// ok
		formBean.setSerie(propertySerie.getHowMValue());					// ok
		formBean.setCodPedido(propertyCodPedidoFiltro.getHowMValue());
		formBean.setNrSerie(propertyNrSerieFiltro.getHowMValue());
		formBean.setCbarras(propertyCbarras.getHowMValue());				// ok
 
		String body = HowMGWTUtilities.getGWTBeanTransfer(formBean.toJsonObject("").toString());
		
		struts.request("eqd0018.do?method=buscar",  "EQD0018Form", body);						
		
	}

	@Override
	public void onHowMNewRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHowMRelation(ListGridRecord record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHowMSave() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHowMSetValues(ListGridRecord record) {
		// TODO Auto-generated method stub
		
	}
	
	
	public abstract void onImportarNotas(ArrayList<eNotaFiscalItemEtq> itens);

}
