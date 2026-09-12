package com.br.client.panel.cc.ccq0003.UI;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
 
public class ResultadoConsulta extends HowMGWTListGrid {
 
	private ListGridField fieldCodigo			= new ListGridField("codigo", 			Tradutor.i18n.formCodigo(), 	 50);	
	private ListGridField fieldNome				= new ListGridField("Nome", 			Tradutor.i18n.formNome(), 		200);
	private ListGridField fieldCNPJ				= new ListGridField("CNPJ", 			Tradutor.i18n.formCnpj(), 		130);
	private ListGridField fieldCidade			= new ListGridField("Cidade", 			Tradutor.i18n.formCidade(), 	130);
	
	private ListGridField selecionar			= new ListGridField("selecionar", 		Tradutor.i18n.formSelecionar(),  70);
 	
	public ResultadoConsulta(){
 
		initUI();
		onHowMInitEntityControl();
	}

	public void initUI(){
		
		this.setDataPageSize(1000);
		this.setShowAllRecords(false);
		this.setFields(
				fieldCodigo,
				fieldNome,
				fieldCNPJ,
				fieldCidade,
				selecionar				
		);
		
		this.setCanResizeFields(true);   
		this.setHeaderHeight(25);
		// this.setShowAllRecords(true); 

	 
        this.addRecordClickHandler(new RecordClickHandler(){  
            public void onRecordClick(RecordClickEvent event) {  
                Record record = event.getRecord();  
                System.out.println("Selecionou : "+record);
            }  
        });		
		
	}
 
	/**
	 * Permite criar componentes para representar ações dentro da grid.
	 */
	@Override
	protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) {
		String fieldName = this.getFieldName(colNum);
		
		if ( fieldName.equalsIgnoreCase(selecionar.getName())){

			IButton actionSelect = new IButton("");  
			actionSelect.setHeight(18);  
			actionSelect.setWidth(65);                      
			actionSelect.setIcon("actions/ico_editar.gif");  
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
	 * @return the fieldCodigo
	 */
	public ListGridField getFieldCodigo() {
		return fieldCodigo;
	}

	/**
	 * @return the fieldNomeColaborador
	 */
	public ListGridField getFieldNomeFornecedor() {
		return fieldNome;
	}

}
