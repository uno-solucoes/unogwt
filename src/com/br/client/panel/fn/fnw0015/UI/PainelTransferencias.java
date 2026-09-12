package com.br.client.panel.fn.fnw0015.UI;

import com.br.client.model.fn.entity.eBoletimCaixa;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.NumberFormat;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Autofit;
import com.smartgwt.client.types.GroupStartOpen;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SummaryFunctionType;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PainelTransferencias extends HowMGWTListGrid{

	public ListGridField fieldContaBancaria		= new ListGridField("ContaBancaria", 	Tradutor.i18n.formContaBancaria()    );
	public ListGridField fieldDescricao 		= new ListGridField("descricao", 	    Tradutor.i18n.formDescricao(),    100);
	public ListGridField fieldValor				= new ListGridField("Valor", 			Tradutor.i18n.formValor(),         90);
	
	public PainelTransferencias(){		
		
		this.setWrapCells(true);
			
		this.setFixedRecordHeights(false);
		this.setAutoHeight();
		this.setWidth("500px");
		this.setHeight(90);
		this.setAutoFitMaxRecords(1000); 
        this.setAutoFitMaxColumns(4);
        this.setAutoFitData(Autofit.VERTICAL);  		
 
 
		CellFormatter formatValor = new CellFormatter() {				
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if(value == null) return null;  
                NumberFormat nf = NumberFormat.getFormat("R$ ###,###,###,###,###,###,##0.00");
                try {  
                    return nf.format(((Number) value).doubleValue());  
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        };
 
        fieldValor.setCellFormatter(formatValor);
        fieldValor.setType(ListGridFieldType.FLOAT);
        
        fieldValor.setSummaryFunction(SummaryFunctionType.SUM);  
        fieldValor.setShowGridSummary(true);  
        fieldValor.setShowGroupSummary(true); 
        
        fieldDescricao.setShowGroupSummary(false);  
        fieldDescricao.setShowGridSummary(false);  

        fieldContaBancaria.setShowGridSummary(true);  
        
		this.setFields(
				fieldContaBancaria,
				fieldDescricao,
				fieldValor	
		);		
		
		this.setCanResizeFields(true);
		this.setHeaderHeight(44);
		this.setShowAllRecords(false);

        this.setGroupByField(fieldContaBancaria.getName());  
		
        this.setGroupStartOpen(GroupStartOpen.ALL);   
        this.setShowGridSummary(true);  
        this.setShowGroupSummary(true);  		
		
		onHowMInitEntityControl();		
	}

	/**
	 * Carrega os dados dos títulos para a tabela.
	 * @param titulos
	 */
	public void load(eBoletimCaixa[] titulos){
		this.clearAllRecords(); 
		if ( titulos == null )
			return;
		
		RecordList records = new RecordList();
		ListGridRecord record;
		for ( eBoletimCaixa titulo : titulos ){
			record = new ListGridRecord();
			record.setAttribute(fieldContaBancaria.getName()	, titulo.getContaCorrente());
 			record.setAttribute(fieldDescricao.getName()		, titulo.getTipoTitulo());			
			record.setAttribute(fieldValor.getName() 			, titulo.getValor());
			records.add(record);
		}
		this.setData(records);		
	}
}