package com.br.client.panel.fn.fnw0235.UI;


import java.util.Date;

import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PainelDetalhesTituloBaixas extends HowMGWTListGrid{
	
	ListGridField fieldDataVencimento = new ListGridField("dataVencimento",Tradutor.i18n.formDtPagamento(), 100);
	ListGridField fieldValorBaixa 	  = new ListGridField("valorBaixa",Tradutor.i18n.formValorBaixa() , 100);
	
	public PainelDetalhesTituloBaixas(){
	
		CellFormatter formatterDouble = new CellFormatter() {
	        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
	            if(value == null) return null;
	            try{
	            	return NumberFormat.getFormat("###,###,###,###,###,###,##0.00").format(new Double(value.toString()));
	            }
	            catch(Throwable er){
	            	return NumberFormat.getFormat("###,###,###,###,###,###,##0.00").format(0.0);
	            }
	        }
		};		
		fieldValorBaixa.setType(ListGridFieldType.FLOAT);
		fieldValorBaixa.setCellFormatter(formatterDouble);
		fieldValorBaixa.setAlign(Alignment.RIGHT);
		
		fieldDataVencimento.setType(ListGridFieldType.DATE);
		formatterDouble = new CellFormatter() {
	        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
	            if(value == null) return null;
	            try{
	            	return DateTimeFormat.getFormat("dd/MM/yyyy").format((Date)value);
	            }
	            catch(Throwable er){
	            	return "Erro data";
	            }
	        }
		};		
		fieldDataVencimento.setCellFormatter(formatterDouble);
		
		this.setFields(fieldDataVencimento, fieldValorBaixa);
		
		onHowMInitHeader();
		onHowMInitEntityControl();		
	}
	
}
