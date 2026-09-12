package com.br.client.panel.vd.vdq0001.UI;

import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.NumberFormat;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;

public class ResultadoConsulta extends HowMGWTListGrid {
	
	private ListGridField fieldCodPedido				= new ListGridField("codPedido", 			Tradutor.i18n.formCodigoPedido()	, 	 60);	
	private ListGridField fieldNomeCliente				= new ListGridField("nomeCliente", 			Tradutor.i18n.formCliente()     	, 	310);
	private ListGridField fieldDtEntregaComprometida	= new ListGridField("dtEntregaComprometida",Tradutor.i18n.formDataEntregaComp()	,    80);		
	private ListGridField fieldSituacao					= new ListGridField("situacao",				Tradutor.i18n.formSituacao()		,   110);
	private ListGridField fieldNomeVendedor				= new ListGridField("nomeVendedor", 		Tradutor.i18n.formVendedor()		,   110);
	private ListGridField fieldMoeda					= new ListGridField("moeda", 				Tradutor.i18n.formMoeda()		    , 	 50);
	private ListGridField fieldVlTotalPedido			= new ListGridField("vlTotalPedido", 		Tradutor.i18n.formTotalPedido()		, 	 90);
	private ListGridField fieldSelecionar				= new ListGridField("fieldSelecionar", 	    " "									, 	 40);
 	
	public ResultadoConsulta(){
 
		initUI();
		onHowMInitEntityControl();
	}

	public void initUI(){
		
		this.setDataPageSize(1000);
		this.setShowAllRecords(false);

		
		fieldDtEntregaComprometida.setWrap(true);
		
		
		CellFormatter formatterDouble = new CellFormatter() {
	        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
	            if(value == null) return null;
	            try{
	            	return " "+NumberFormat.getFormat("###,###,###,###,###,###,###.00").format(new Double(value.toString()));
	            }
	            catch(Throwable er){
	            	return " "+value.toString();
	            }
	        }
		};  
		fieldVlTotalPedido.setType(ListGridFieldType.FLOAT);		
		fieldVlTotalPedido.setAlign(Alignment.RIGHT);
		fieldVlTotalPedido.setCellFormatter(formatterDouble);		
	
		this.setFields(
				fieldCodPedido,
				fieldNomeCliente,
				fieldDtEntregaComprometida,	
				fieldSituacao,
				fieldNomeVendedor,
				fieldMoeda,
				fieldVlTotalPedido,
				fieldSelecionar
		);
		
		this.setCanResizeFields(true);   
		this.setHeaderHeight(40);
 
		this.setShowAllRecords(false); 
	}
 
	/**
	 * Permite criar componentes para representar ações dentro da grid.
	 */
	@Override
	protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) {
		String fieldName = this.getFieldName(colNum);
		
		if ( fieldName.equalsIgnoreCase(fieldSelecionar.getName())){

			IButton actionSelect = new IButton("");  
			actionSelect.setHeight(18);  
			actionSelect.setWidth(32);                      
			actionSelect.setIcon("actions/ico_editar.gif");
			actionSelect.setPrompt(Tradutor.i18n.formPromptSelecionarItem());  
			
			actionSelect.addClickHandler(new ClickHandler() {  
	            public void onClick(ClickEvent event) {  
	            	onHowMSelectRecord(record);
	            }  
	        });  
			return actionSelect;  			
		}
		return super.createRecordComponent(record, colNum);
	}
	
	/**
	 * Permite Rendererizar dados da grid.
	 */
    @Override  
    protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {  
 
        return super.getCellCSSText(record, rowNum, colNum);  
    }

	/**
	 * @return the fieldCodPedido
	 */
	public ListGridField getFieldCodPedido() {
		return fieldCodPedido;
	}

	/**
	 * @param fieldCodPedido the fieldCodPedido to set
	 */
	public void setFieldCodPedido(ListGridField fieldCodPedido) {
		this.fieldCodPedido = fieldCodPedido;
	}	
	
}
