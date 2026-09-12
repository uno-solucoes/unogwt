package com.br.client.panel.vd.vdq0002.UI;

import java.util.Date;

import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Window;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.UI.HowMGWTPanelSectionStack;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.HoverCustomizer;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PainelUtimasVendasCliente extends HowMGWTListGrid {

	private HowMGWTPanelSectionStack sessionVendasCliente;
	
	ListGridField fieldCliente 		= new ListGridField("fieldCliente"		,Tradutor.i18n.formCliente()	,  50);	
	ListGridField fieldNotaFiscal 	= new ListGridField("NotaFiscal"		,Tradutor.i18n.formNumeroNF()   ,  50);
	ListGridField fieldData 		= new ListGridField("fieldData"			,Tradutor.i18n.formData()		,  65);
	ListGridField fieldQtde			= new ListGridField("fieldQtde"			,Tradutor.i18n.formQtde()		,  60);
	ListGridField fieldValorVenda 	= new ListGridField("fieldValorVenda"	,Tradutor.i18n.formValor() 		,  70);

	public PainelUtimasVendasCliente(){
		
		fieldData.setType(ListGridFieldType.DATE);
		fieldQtde.setType(ListGridFieldType.FLOAT);
		fieldValorVenda.setType(ListGridFieldType.FLOAT);
		
		CellFormatter formatterDate = new CellFormatter(){
	        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
	            if(value == null) return null;
	            try{
	            	return DateTimeFormat.getFormat("dd/MM/yyyy").format((Date)value);
	            }
	            catch(Throwable er){
	            	return value.toString();
	            }
	        }
		};
		fieldData.setCellFormatter(formatterDate);
		
		CellFormatter formatterDouble = new CellFormatter() {
	        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
	            if(value == null) return null;
	            try{
	            	return NumberFormat.getFormat("###,###,###,###,###,###,##0.00").format(new Double(value.toString()));
	            }
	            catch(Throwable er){
	            	return value.toString();
	            }
	        }
		};
		fieldQtde.setCellFormatter(formatterDouble);
		fieldValorVenda.setCellFormatter(formatterDouble);
		
		this.setFields(fieldCliente,fieldNotaFiscal, fieldData, fieldQtde, fieldValorVenda );
		
		HoverCustomizer clienteHover = new HoverCustomizer() {  
            public String hoverHTML(Object value, ListGridRecord record, int rowNum, int colNum) {                  
                return record.getAttribute(fieldCliente.getName());  
            }  
        };
		
        fieldNotaFiscal.setShowHover(true);
        fieldData.setShowHover(true);
        fieldQtde.setShowHover(true);
        fieldValorVenda.setShowHover(true);

        fieldNotaFiscal.setHoverCustomizer(clienteHover);
        fieldData.setHoverCustomizer(clienteHover);
        fieldQtde.setHoverCustomizer(clienteHover);
        fieldValorVenda.setHoverCustomizer(clienteHover);        
        
        this.setCanAutoFitFields(false);       
		
        for ( ListGridField field :  this.getFields()){
        	field.setCanHide(false);
        	field.setCanReorder(false);
        	field.setCanGroupBy(false);
        	field.setCanFreeze(false);
        	field.setCanSort(false);
        	field.setCanSortClientOnly(false);
			field.setWrap(true);
        }			
		this.onHowMInitEntityControl();
		fieldCliente.setHidden(true);
		this.setShowAllRecords(true);
	}

	public void setParentSession(HowMGWTPanelSectionStack sessionVendasCliente){
		this.sessionVendasCliente = sessionVendasCliente;
	}

	private int rowLoad = 0;
	// Detecta a carga dos registros.
	public void onHowMStartLoadDatabaseRecord(){
		rowLoad = 0;
	}	
	
	public void onHowMLoadDatabaseRecord(Record record){
		if ( rowLoad == 0 ){
			this.sessionVendasCliente.getSession().setTitle(Tradutor.i18n.formUltimasVendasCliente()+" : <font color=blue><b>"+record.getAttribute(fieldCliente.getName())+"</b></font>");
			this.sessionVendasCliente.setTitle(Tradutor.i18n.formUltimasVendasCliente()+" : <font color=blue><b>"+record.getAttribute(fieldCliente.getName())+"</b></font>");
		}
		rowLoad ++;
	}

}