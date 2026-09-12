package com.br.client.panel.sg.sgq0014.UI;

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
 
	private ListGridField fieldCodigo			= new ListGridField("codigo", 			Tradutor.i18n.formCodigo(), 	 80);	
	private ListGridField fieldNomeColaborador	= new ListGridField("nomeColaborador", 	Tradutor.i18n.formNome(), 		200);
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
				fieldNomeColaborador,
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
//        if ( // Azul
//    		getFieldName(colNum).equals("valorCotacoesEnviadasPorEmailDia") 
//        )   
//        	return "color:blue;";  
        return super.getCellCSSText(record, rowNum, colNum);  
    }

	/**
	 * @return the fieldCodigo
	 */
	public ListGridField getFieldCodigo() {
		return fieldCodigo;
	}

	/**
	 * @param fieldCodigo the fieldCodigo to set
	 */
	public void setFieldCodigo(ListGridField fieldCodigo) {
		this.fieldCodigo = fieldCodigo;
	}

	/**
	 * @return the fieldNomeColaborador
	 */
	public ListGridField getFieldNomeColaborador() {
		return fieldNomeColaborador;
	}

	/**
	 * @param fieldNomeColaborador the fieldNomeColaborador to set
	 */
	public void setFieldNomeColaborador(ListGridField fieldNomeColaborador) {
		this.fieldNomeColaborador = fieldNomeColaborador;
	}
 

}
