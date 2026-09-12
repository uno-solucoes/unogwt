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

public class PainelPosicaoCaixa extends HowMGWTListGrid{

	public ListGridField fieldContaBancaria		= new ListGridField("ContaBancaria", 	Tradutor.i18n.formContaBancaria(),200);
	public ListGridField fieldSaldoInicial 		= new ListGridField("saldoInicial", 	Tradutor.i18n.formSaldoInicial(), 100);
	public ListGridField fieldValorEntrada		= new ListGridField("valorEntrada", 	Tradutor.i18n.formValorEntrada(), 100);
	public ListGridField fieldValorSaida		= new ListGridField("valorSaida", 		Tradutor.i18n.formValorSaida(),   100);
	public ListGridField fieldSaldoAtual		= new ListGridField("saldoAtual", 		Tradutor.i18n.formSaldoAtual(),   100);

	public PainelPosicaoCaixa() { 		
		
		this.setWrapCells(true);
			
		this.setFixedRecordHeights(false);
		this.setAutoWidth();
		// this.setWidth("200px");
		// this.setWidth("650px");
		this.setAutoHeight();
		this.setHeight(90);
		this.setAutoFitMaxRecords(1000); 
        this.setAutoFitMaxColumns(5);
        this.setAutoFitData(Autofit.BOTH);
 
 
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
 
        fieldSaldoInicial.setCellFormatter(formatValor);
        fieldSaldoInicial.setType(ListGridFieldType.FLOAT);        
        fieldSaldoInicial.setSummaryFunction(SummaryFunctionType.SUM);  
        fieldSaldoInicial.setShowGridSummary(true);  
        fieldSaldoInicial.setShowGroupSummary(true); 

        fieldValorEntrada.setCellFormatter(formatValor);
        fieldValorEntrada.setType(ListGridFieldType.FLOAT);        
        fieldValorEntrada.setSummaryFunction(SummaryFunctionType.SUM);  
        fieldValorEntrada.setShowGridSummary(true);  
        fieldValorEntrada.setShowGroupSummary(true); 
 
        fieldValorSaida.setCellFormatter(formatValor);
        fieldValorSaida.setType(ListGridFieldType.FLOAT);        
        fieldValorSaida.setSummaryFunction(SummaryFunctionType.SUM);  
        fieldValorSaida.setShowGridSummary(true);  
        fieldValorSaida.setShowGroupSummary(true); 
 
        fieldSaldoAtual.setCellFormatter(formatValor);
        fieldSaldoAtual.setType(ListGridFieldType.FLOAT);        
        fieldSaldoAtual.setSummaryFunction(SummaryFunctionType.SUM);  
        fieldSaldoAtual.setShowGridSummary(true);  
        fieldSaldoAtual.setShowGroupSummary(true); 
 
        

        fieldContaBancaria.setShowGridSummary(true);  
        
		this.setFields(
				fieldContaBancaria,
				fieldSaldoInicial,
				fieldValorEntrada,
				fieldValorSaida,
				fieldSaldoAtual
		);		
		
		this.setCanResizeFields(true);
		this.setHeaderHeight(44);
		this.setShowAllRecords(false);
 
		
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
			
			record.setAttribute(fieldSaldoInicial.getName()	, titulo.getSaldoInicial());
			record.setAttribute(fieldValorEntrada.getName()	, titulo.getValorEntrada());
			record.setAttribute(fieldSaldoAtual.getName()	, titulo.getSaldoAtual());
			record.setAttribute(fieldValorSaida.getName()	, titulo.getValorSaida());
 		
			records.add(record);
		}
		this.setData(records);		
	}
}