package com.br.client.panel.fn.fnw0015.UI;

import java.util.ArrayList;

import com.br.client.model.fn.entity.eBoletimCaixa;
import com.br.client.model.vd.entity.ePerformanceVendasDetalhes;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.NumberFormat;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Autofit;
import com.smartgwt.client.types.GroupStartOpen;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SummaryFunctionType;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PainelTitulos extends HowMGWTListGrid{
		
	public ListGridField fieldContaBancaria		= new ListGridField("ContaBancaria", 	Tradutor.i18n.formContaBancaria() );
	public ListGridField fieldPlanoConta		= new ListGridField("PlanoConta", 	    Tradutor.i18n.formPlanoConta(),   90);
	public ListGridField fieldDescPlanoConta	= new ListGridField("DescPlanoConta", 	Tradutor.i18n.formDescricao() );
	public ListGridField fieldValor				= new ListGridField("Valor", 			Tradutor.i18n.formValor(),        90);
	
	public PainelTitulos(){		
		
		this.setWrapCells(true);
		this.fieldPlanoConta.setWrap(true);
		this.fieldContaBancaria.setWrap(true);
		
		this.setWidth100();
		this.setAutoHeight();
		this.setHeight(90);
		this.setFixedRecordHeights(false);
        this.setAutoFitMaxRecords(4000); 
        
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
        
        
        fieldPlanoConta.setShowGroupSummary(false);  
        fieldPlanoConta.setShowGridSummary(false);  

        fieldDescPlanoConta.setShowGroupSummary(false);  
        fieldDescPlanoConta.setShowGridSummary(false);  

        fieldContaBancaria.setShowGridSummary(true);        
        
        fieldDescPlanoConta.setWrap(true);
		
        this.setShowAllColumns(true);
		this.setShowAllRecords(true);
		
        this.setGroupByMaxRecords(4000);
        this.setGroupStartOpen(GroupStartOpen.ALL);   
        this.setShowGridSummary(true);  
        this.setShowGroupSummary(true);         
        this.setGroupByField(fieldContaBancaria.getName());  
        
		this.setFields(
				fieldContaBancaria,
				fieldPlanoConta,
				fieldDescPlanoConta,
				fieldValor	
		);		
		
		this.setCanResizeFields(true);
		this.setHeaderHeight(44);
 		
		
		onHowMInitEntityControl();		
	}

	/**
	 * Carrega os dados dos títulos para a tabela.
	 * @param titulos
	 */
	public void load(ArrayList<eBoletimCaixa> titulos){
		ListGridRecord[] records = new ListGridRecord[titulos.size()];
		ListGridRecord record;
		int i = 0;
		for ( eBoletimCaixa titulo : titulos ){
			record = new ListGridRecord();
			record.setAttribute(fieldContaBancaria.getName()	, titulo.getContaCorrente().trim());
			
			String conta = "";
			if ( !HowMGWTUtilities.isEmpty(titulo.getConta()))
				conta += titulo.getConta();
			
			if ( !HowMGWTUtilities.isEmpty(titulo.getSubConta())){
				if ( HowMGWTUtilities.isEmpty(conta) )
					conta += titulo.getSubConta();
				else
					conta += "."+titulo.getSubConta();
			}

			record.setAttribute(fieldPlanoConta.getName()		, conta);			
			
			record.setAttribute(fieldDescPlanoConta.getName()	, titulo.getDescConta());
			record.setAttribute(fieldValor.getName() 			, titulo.getValor());
			records[i] = record;
			i ++;
		}
		this.setData(records);		
	}
}