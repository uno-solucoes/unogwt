package com.br.client.panel.vd.vdq0002.UI;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.grid.HoverCustomizer;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PainelGruposProduto extends HowMGWTListGrid {

	ListGridField fieldDescGrupoProduto 		= new ListGridField("fieldDescGrupoProduto"		,Tradutor.i18n.formGrupoProduto()	, 250);

	public PainelGruposProduto(){
		this.setFields(fieldDescGrupoProduto);
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

        
        this.setShowHover(true);  
        fieldDescGrupoProduto.setShowHover(true);
        fieldDescGrupoProduto.setHoverCustomizer(new HoverCustomizer() {  
            public String hoverHTML(Object value, ListGridRecord record, int rowNum, int colNum) {                  
                return record.getAttribute(fieldDescGrupoProduto.getName());  
            }  
        });         
	}

	
}