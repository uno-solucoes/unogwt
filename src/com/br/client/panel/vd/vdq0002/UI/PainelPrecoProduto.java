package com.br.client.panel.vd.vdq0002.UI;

import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.NumberFormat;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PainelPrecoProduto extends HowMGWTListGrid {

	ListGridField fieldTabela 		= new ListGridField("fieldTabela"		,Tradutor.i18n.formTabelaPreco()	, 90);
	ListGridField fieldQtdeMinima 	= new ListGridField("fieldQtdeMinima"	,Tradutor.i18n.formQtdeMinima()		,  80);
	ListGridField fieldValor 		= new ListGridField("fieldValor"		,Tradutor.i18n.formValor() 			,  70);
	
	public PainelPrecoProduto(){
		
		this.setFields(fieldTabela, fieldQtdeMinima, fieldValor);
		
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

		fieldQtdeMinima.setType(ListGridFieldType.FLOAT);
		fieldValor.setType(ListGridFieldType.FLOAT);
		
		fieldQtdeMinima.setCellFormatter(formatterDouble);
		fieldValor.setCellFormatter(formatterDouble);
		
		
		this.onHowMInitEntityControl();

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
		
	}
	
}
