package com.br.client.panel.vd.vdw0031.UI;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import com.br.client.configuracao.UcommerceConstantes;
import com.br.client.model.vd.entity.eNotaFiscalItemEtq;
import com.br.client.model.vd.entity.eSolicitacaoDevolucaoItem;
import com.br.client.model.vd.vdw0031.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.NumberFormat;
import com.howmake.client.form.UI.HowMGWTFormToolbarEdit;
import com.howmake.client.form.UI.HowMGWTLabel;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.control.HowMGWTControlForm;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellSavedEvent;
import com.smartgwt.client.widgets.grid.events.CellSavedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelSolicitacaoDevolucaoItem extends VLayout implements HowMGWTControlForm{

	private boolean error = false;
	
	private WindowPanelEditSolicitacaoDevolucao parentEditPanel;
	private FormBean currentFormBean;
	
	private HowMGWTFormProperties properties = new HowMGWTFormProperties();

	private HowMGWTProperty propertyCodSolicitacaoDevolucao = properties.createProperty("codSolicitacaoDevolucao"	,Tradutor.i18n.formCodSolicitacaoDevolucao());
	private HowMGWTProperty propertyCodEmpresa				= properties.createProperty("codEmpresa"				,Tradutor.i18n.formCodEmpresa());
	private HowMGWTProperty propertyCodNotaFiscal			= properties.createProperty("codNotaFiscal"				,Tradutor.i18n.formCodNotaFiscal());

	private HowMGWTProperty propertyNrSequenciaSolicitacao	= properties.createProperty("nrSequenciaSolicitacao"	,Tradutor.i18n.formNrSequenciaSolicitacao());
	private HowMGWTProperty propertyCodPedido				= properties.createProperty("codPedido"					,Tradutor.i18n.formPedido());
	private HowMGWTProperty propertyNrNotaFiscal			= properties.createProperty("nrNotaFiscal"				,Tradutor.i18n.formNrNotaFiscal() );
	private HowMGWTProperty propertyNrSequenciaNF			= properties.createProperty("nrSequenciaNF"				,Tradutor.i18n.formSeqNF());

	private HowMGWTProperty propertyTpFreteSaida			= properties.createProperty("tpFreteSaida"				,Tradutor.i18n.tpFreteSaida());
	
	private HowMGWTProperty propertyCodProduto				= properties.createProperty("codProduto"				,Tradutor.i18n.formCodProduto());
	private HowMGWTProperty propertyDescProduto				= properties.createProperty("descProduto"				,Tradutor.i18n.formDescComercial());

	private HowMGWTProperty propertyNrSequenciaEtq			= properties.createProperty("nrSequenciaEtq"			,"Sequencia ETQ");

	private HowMGWTProperty propertyCdLote					= properties.createProperty("cdLote"					,Tradutor.i18n.formlote());
	private HowMGWTProperty propertyNrSerie					= properties.createProperty("nrSerie"					,Tradutor.i18n.formNrSerie());
		
	private HowMGWTProperty propertyQtdeEnviada				= properties.createProperty("qtdeEnviada"				,Tradutor.i18n.formQtdeSaida());
	private HowMGWTProperty propertyQtde					= properties.createProperty("qtde"						,Tradutor.i18n.formQtdeEntrada());
	private HowMGWTProperty propertyPrecoUnitSaida			= properties.createProperty("precoUnit"					,Tradutor.i18n.formPrecoUniSaida());
	private HowMGWTProperty propertyUN						= properties.createProperty("un"						,Tradutor.i18n.formUn());

	private HowMGWTProperty propertyOperador				= properties.createProperty("operacao"					, "Operacao");
	
	private HowMGWTProperty propertyTools					= properties.createProperty("tools"						, " " );
	
	private HowMGWTLabel labelTotal = new HowMGWTLabel();
	
	private HowMGWTListGrid panelGrid = new HowMGWTListGrid(){
		/**
		 * Verifica se deverá ser controlado a edição das células dos registros da grid.
		 */
		@Override
		public boolean canEditCell(int rowNum, int colNum) {

			String fieldName = this.getFieldName(colNum);
			ListGridRecord record 	 = (ListGridRecord)this.getRecord(rowNum);
			if ( propertyQtde.getName().equals(fieldName)){

				String operador = propertyOperador.getHowMValue(record);
				if ( (""+HowMGWTUtilities.OPERATION_DELETE ).equals(operador)){
					return false;
				}
			}			
			return super.canEditCell(rowNum, colNum);
		}
		
		
        @Override  
        protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) {  

            String fieldName = this.getFieldName(colNum);  

            if (fieldName.equals("tools")) {  

				if ( "true".equals( currentFormBean.getPermiteCadastrarSolicitacaoDevolucao()) ){

					/**
					 * Se tiver permissão para alterar mostra o icone para exclusão de registro.
					 */
					if ( "true".equals(currentFormBean.getPermiteCadastrarSolicitacaoDevolucao()) ){
	
						// Se já estiver aprovado ou renjeitado não permite mais a alteração.
						String situacao = parentEditPanel.getParentPanel().getPropertySituacao().getHowMValue();
						if ( situacao.equals(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_AGUARDANDO_APROVACAO) ){
			            	HLayout recordCanvas = new HLayout();  
			                recordCanvas.setHeight(22);
			                recordCanvas.setWidth(22);
			                recordCanvas.setAlign(Alignment.CENTER);  
			                
			                ImgButton editDelete = new ImgButton();  
			                editDelete.setShowDown(false);  
			                editDelete.setShowRollOver(false);  
			                editDelete.setLayoutAlign(Alignment.CENTER);  
			                
			        		String operador = propertyOperador.getHowMValue(record);
			        		if( (""+HowMGWTUtilities.OPERATION_DELETE).equals(operador)){	                
			        			editDelete.setSrc("actions/og_delete.gif");
				        		editDelete.setPrompt(Tradutor.i18n.formDesmarcarExcluir());  
			        		}
			        		else{
			        			editDelete.setSrc("actions/remove.png");
				        		editDelete.setPrompt(Tradutor.i18n.formMarcarComoExcluido());  
			        		}
			                editDelete.setHeight(16);  
			                editDelete.setWidth(16);  
			                editDelete.addClickHandler(new ClickHandler() {  
			                    public void onClick(ClickEvent event) {  
			                        onDeleteRecord(record);
			                    }  
			                });  
			                recordCanvas.addMember(editDelete);
			                setRefreshTotal(panelGrid.getRecords());
			                return recordCanvas;
						}
					}
				};
            }
            return null;
        }
    };
	HowMGWTFormToolbarEdit formToolbarEdit;
	public PainelSolicitacaoDevolucaoItem(WindowPanelEditSolicitacaoDevolucao parentEditPanel){
		
		this.parentEditPanel = parentEditPanel;
		
		VLayout totalLayout = new VLayout();
		totalLayout.setWidth100();
		totalLayout.setHeight(24);
		labelTotal.setWidth100();
		labelTotal.setHeight100();
		totalLayout.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(4,""));
		totalLayout.addMember(labelTotal);
		totalLayout.setBackgroundColor("#ECECEC");
		
		panelGrid.setWrapCells(true);  
		panelGrid.setFixedRecordHeights(false); 	
		
		propertyNrSequenciaSolicitacao.setWidthColumn(30);
		propertyCodPedido.setWidthColumn(45);
		propertyNrNotaFiscal.setWidthColumn(45);
		propertyTpFreteSaida.setWidthColumn(100);
		
		propertyCodProduto.setWidthColumn(110);
				
		
		propertyDescProduto.setWidthColumn(180);
 
		
		propertyCdLote.setWidthColumn(70);
		propertyNrSerie.setWidthColumn(110);
		
		
		propertyQtdeEnviada.setWidthColumn(70);
		
		propertyPrecoUnitSaida.setWidthColumn(60);
		propertyUN.setWidthColumn(25);

		
		propertyQtde.setWidthColumn(80);
		
		propertyTools.setWidthColumn(24);
		
		
		propertyNrSequenciaSolicitacao.createHowMGWTListGridField();
		
		propertyCodPedido.createHowMGWTListGridField();
		propertyNrNotaFiscal.createHowMGWTListGridField();
		propertyTpFreteSaida.createHowMGWTListGridField();
		
		propertyCodProduto.createHowMGWTListGridField();
		propertyDescProduto.createHowMGWTListGridField();
		
		propertyCdLote.createHowMGWTListGridField();
		propertyNrSerie.createHowMGWTListGridField();
		
		propertyQtdeEnviada.createHowMGWTListGridField();
		propertyPrecoUnitSaida.createHowMGWTListGridField();

		propertyUN.createHowMGWTListGridField();

		propertyPrecoUnitSaida.getListField().setWrap(true);
		propertyTpFreteSaida.getListField().setWrap(true);
		
		panelGrid.setHeaderHeight(36);
		
		propertyQtde.createHowMGWTListGridField();
		
		propertyTools.createHowMGWTListGridField();
		propertyTools.getListField().setCanDragResize(false);
		propertyTools.getListField().setCanReorder(false);
		propertyTools.getListField().setCanSort(false);
		propertyTools.getListField().setCanHide(false);

		
		
		LinkedHashMap< String, String> mapTipoFrete = new LinkedHashMap<String, String>();
		mapTipoFrete.put(""												, " ");		
		mapTipoFrete.put(UcommerceConstantes.SISTEMA_FRETE_TIPO_CIF		, Tradutor.i18n.formCif());
		mapTipoFrete.put(UcommerceConstantes.SISTEMA_FRETE_TIPO_FOB		, Tradutor.i18n.formCustoFOB());
		mapTipoFrete.put(UcommerceConstantes.SISTEMA_FRETE_TIPO_CIFD	, Tradutor.i18n.formCifd());

		propertyTpFreteSaida.getListField().setValueMap(mapTipoFrete);
		propertyTpFreteSaida.getListField().setDefaultValue("");
		
		propertyQtde.createFormatDouble("#,##0.00");
		propertyQtdeEnviada.createFormatDouble("#,##0.00");
		propertyPrecoUnitSaida.createFormatDouble("#,##0.00");

		propertyQtde.getListField().addCellSavedHandler(new CellSavedHandler() {			
		
			@Override
			public void onCellSaved(CellSavedEvent event) {
				if ( event != null ){
					if ( ! HowMGWTUtilities.isEquals(event.getOldValue(), event.getNewValue())){
						String value = propertyOperador.getHowMValue((ListGridRecord)event.getRecord());
						if( (""+HowMGWTUtilities.OPERATION_INSERT).equals(value)){
							
						}
						else if( (""+HowMGWTUtilities.OPERATION_QUERY).equals(value) || HowMGWTUtilities.isEmpty(value) ){
							propertyOperador.setHowMValue((ListGridRecord)event.getRecord(), ""+HowMGWTUtilities.OPERATION_UPDATE);
						}
						else if( (""+HowMGWTUtilities.OPERATION_UPDATE).equals(value)){
							
						}
						else if( (""+HowMGWTUtilities.OPERATION_DELETE).equals(value)){
							
						}						
						setRefreshTotal(panelGrid.getRecords());
					}
				}
			}
		});
		
	    /**
	     * Define o agrupamento e os totalizadores.
	     */
	    panelGrid.setShowRecordComponents(true);   
	    panelGrid.setShowRecordComponentsByCell(true);
	    
	    panelGrid.setShowAllColumns(true);
	    panelGrid.setShowAllRecords(true);
	    panelGrid.setDataPageSize(2000);
	    
	    // panelGrid.setAutoSaveEdits(false);
	    formToolbarEdit = new HowMGWTFormToolbarEdit(this, panelGrid);
		this.addMember(formToolbarEdit.getPanelList() );

		this.addMember(totalLayout);
		
	}

	@Override
	public HowMGWTFormProperties getHowMProperties() {
		return properties;
	}

	@Override
	public void onHowMDeleteRecord() {
	}

	@Override
	public void onHowMEditRecord() {
		
	}

	@Override
	public void onHowMLoad(HowMGWTFormBean formBean) {
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
	}
	

	public void importarNotas(ArrayList<eNotaFiscalItemEtq> itens){


		double totalValorSaida     = 0.00;
		double totalValorDevolvido = 0.00;

		TreeMap<String, String> mapNotas = new TreeMap<String, String>();
 		
		ListGridRecord[] records = panelGrid.getRecords();
		String key = "";
		for ( ListGridRecord record : records){
			key = propertyCodNotaFiscal.getHowMValue(record)+"-"+
				  propertyCodProduto.getHowMValue(record)	+"-"+
				  propertyNrSequenciaNF.getHowMValue(record)+"-"+
				  propertyNrSequenciaEtq.getHowMValue(record);
			mapNotas.put(key, " ");
		}		
		ListGridRecord record;

		for ( eNotaFiscalItemEtq item : itens ){
			// Verifica se a nota fiscal item já foi selecionada, se 
			// sim, então ignora.
			key = 	item.getCodNotaFiscal()	+ "-" +
					item.getCodProduto()   	+ "-" +
					item.getNrSequenciaNf() + "-"+
					item.getNrSequenciaEtq();

			if ( mapNotas.get(key ) != null ){
				continue;
			}
			
			record = new ListGridRecord();

			propertyCodNotaFiscal.setHowMValue(record,  item.getCodNotaFiscal() );
			propertyCodPedido.setHowMValue(record, 		item.getCodPedido()		);
			propertyNrNotaFiscal.setHowMValue(record, 	item.getCodNotaFiscal()	);
			propertyNrSequenciaNF.setHowMValue(record, 	item.getNrSequenciaNf()	);
			propertyTpFreteSaida.setHowMValue(record,   item.getTpFrete() 		);

			propertyCodProduto.setHowMValue(record, 	item.getCodProduto()  	);
			propertyDescProduto.setHowMValue(record, 	item.getDescProduto() 	);
			propertyCodEmpresa.setHowMValue(record, 	item.getCodEmpresa()	);
			propertyQtdeEnviada.setHowMValue(record, 	item.getQtd()			);
			propertyPrecoUnitSaida.setHowMValue(record, item.getPrecoVenda()	);
			propertyUN.setHowMValue(record,				item.getUn()			);
			propertyQtde.setHowMValue(record,			item.getQtd()			);
			
			propertyNrSequenciaEtq.setHowMValue(record, item.getNrSequenciaEtq());
			propertyCdLote.setHowMValue(record, 		item.getCodLote()		);
			propertyNrSerie.setHowMValue(record, 		item.getNrSerie()		);
						
			
			propertyOperador.setHowMValue(record, 		""+HowMGWTUtilities.OPERATION_INSERT);
			
			this.formToolbarEdit.getPanelList().addData(record);
			int row = panelGrid.getRecordIndex(record);
			int col = panelGrid.getFieldNum(propertyTools.getName());
			
			panelGrid.refreshRecordComponent(row, col);
		}
		this.setRefreshTotal(panelGrid.getRecords());
	}	
	
	
	/**
	 * Recalcula os totais 
	 */
	public void setRefreshTotal(ListGridRecord[] records){

		double totalValorDevolvido = 0.00;
		double totalValorSaida     = 0.00;

		for ( ListGridRecord record : records){
			// não contabiliza registros marcados para exclusão.
			String operador = propertyOperador.getHowMValue(record);
			if ( (""+HowMGWTUtilities.OPERATION_DELETE ).equals(operador))
				continue;
			
			double qtdeDevolvido = HowMGWTUtilities.getDouble(propertyQtde.getHowMValue(record));
			double qtdeSaida	 = HowMGWTUtilities.getDouble(propertyQtdeEnviada.getHowMValue(record));
			double precoUnit 	 = HowMGWTUtilities.getDouble(propertyPrecoUnitSaida.getHowMValue(record));
			
			totalValorDevolvido += qtdeDevolvido * precoUnit;
			totalValorSaida 	+= qtdeSaida	 * precoUnit;
		}

		String sTotalValorDevolvido = NumberFormat.getFormat("#,##0.00").format(HowMGWTUtilities.getDouble(totalValorDevolvido));
		String sTotalValorSaida		= NumberFormat.getFormat("#,##0.00").format(HowMGWTUtilities.getDouble(totalValorSaida));
		this.labelTotal.setHowMValue("<center> Total Saida :&nbsp;&nbsp; <b>"+sTotalValorSaida+"</b>&nbsp;&nbsp;&nbsp;&nbsp; Total Devolvido :&nbsp;&nbsp; <b>"+sTotalValorDevolvido+"</b></center");
	}

	/**
	 * @return the currentFormBean
	 */
	public FormBean getCurrentFormBean() {
		return currentFormBean;
	}

	/**
	 * @param currentFormBean the currentFormBean to set
	 */
	public void setCurrentFormBean(FormBean currentFormBean) {
		this.currentFormBean = currentFormBean;
	}

	public void onDeleteRecord(ListGridRecord record){
		
		String operador = propertyOperador.getHowMValue(record);
		if( (""+HowMGWTUtilities.OPERATION_DELETE).equals(operador)){
			propertyOperador.setHowMValue(record, record.getAttribute(propertyOperador.getName()+"OLD"));			
		}
		else{
			record.setAttribute(propertyOperador.getName()+"OLD", operador);
			propertyOperador.setHowMValue(record, ""+HowMGWTUtilities.OPERATION_DELETE);
		}
		int row = panelGrid.getRecordIndex(record);
		int col = panelGrid.getFieldNum(propertyTools.getName());
		
		if ( HowMGWTUtilities.isEmpty( propertyNrSequenciaSolicitacao.getHowMValue(record) ) )
			this.panelGrid.removeData(record);
		else
			panelGrid.refreshRecordComponent(row, col);		
	}

	/**
	 * Configura a edição do componente.
	 */
	public void configure(){
		this.propertyQtde.getListField().setCanEdit(false);
		
		ListGridRecord[] records = panelGrid.getRecords();
		
		double totalValorDevolvido = 0.00;
		double totalValorSaida     = 0.00;
		if ( "true".equals(currentFormBean.getPermiteCadastrarSolicitacaoDevolucao()) ){
			
			// Se já estiver aprovado ou renjeitado não permite mais a alteração.
			String situacao = parentEditPanel.getParentPanel().getPropertySituacao().getHowMValue();
			if ( situacao.equals(UcommerceConstantes.SOLICITACAO_DEVOLUCAO_SITUACAO_AGUARDANDO_APROVACAO) ){
				this.propertyQtde.getListField().setCanEdit(true);
			}
		}

		for ( ListGridRecord record : records){
			int row = panelGrid.getRecordIndex(record);
			int col = panelGrid.getFieldNum(propertyTools.getName());
			
			panelGrid.refreshRecordComponent(row, col);
		}
	}
	
	/**
	 * 
	 * @return Valida os dados dos itens e retorna a relação de items que ser encaminhados 
	 * para o servidor para serem salvos no banco de dados.
	 * 
	 */
	public eSolicitacaoDevolucaoItem[] validaItens(){
		
		error = false;
		
		ListGridRecord[] records = this.panelGrid.getRecords();
		eSolicitacaoDevolucaoItem[] solicitacaoItems = new eSolicitacaoDevolucaoItem[records.length];
		eSolicitacaoDevolucaoItem item;
		int i = 0 ;
		
		double qtdeEnviada = 0.00;
		double qtdeRecebida = 0.00;
				
		String msgError = "";
		String msgComp  = "";
		int    row      = -1;
		for ( ListGridRecord record : records ){
			item = new eSolicitacaoDevolucaoItem();
			formToolbarEdit.convertRecordToFormBean(record, item);
			solicitacaoItems[i++] = item;
			
			qtdeEnviada  = item.toDouble(propertyQtdeEnviada.getName());
			qtdeRecebida = item.toDouble(propertyQtde.getName());
					
			row = panelGrid.getRecordIndex(record);
			
			// Se quantidade recebida menor ou igual a zero,
			// não permite o recebimento.
			if ( qtdeRecebida <= 0 ){
				formToolbarEdit.getPanelList().setFieldError(row, propertyQtde.getName(), Tradutor.i18n.msgQuantidadeDevolvidaDeveSerMaiorQueZero() );			
				error = true;
			}
			
			// Se quantidade recebida maior que a quantidade enviada
			// não permite o recebimento.
			else if ( qtdeRecebida > qtdeEnviada ){
				formToolbarEdit.getPanelList().setFieldError(row, propertyQtde.getName(), Tradutor.i18n.msgQuantidadeDevolvidaDevSerMenorOuIgualQuantidadeSaida() );
				error = true;
			}
		}
		return solicitacaoItems;
	}
	

	/**
	 * Carrega os itens da solicitação.
	 * @param itens
	 */
	public void loadItens(eSolicitacaoDevolucaoItem[] itens){
		this.panelGrid.clearAllRecords();
		if ( itens == null ){
			return;
		}
		ListGridRecord[] records = new ListGridRecord[itens.length];
		ListGridRecord record;
		
		int i = 0;
		for ( eSolicitacaoDevolucaoItem item : itens ){
			record = new ListGridRecord();
			formToolbarEdit.convertFormBeanToRecord(record, item);
			records[i] = record;
			i ++;
		}
		this.panelGrid.setData(records);
		this.setRefreshTotal(records);
		
	}

	/**
	 * @return the panelGrid
	 */
	public HowMGWTListGrid getPanelGrid() {
		return panelGrid;
	}

	/**
	 * @return the error
	 */
	public boolean isError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(boolean error) {
		this.error = error;
	}
}