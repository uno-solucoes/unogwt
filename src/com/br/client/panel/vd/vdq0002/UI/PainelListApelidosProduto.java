package com.br.client.panel.vd.vdq0002.UI;

import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.BlurEvent;
import com.smartgwt.client.widgets.form.fields.events.BlurHandler;
import com.smartgwt.client.widgets.form.fields.events.KeyPressEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyPressHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.HoverCustomizer;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PainelListApelidosProduto extends HowMGWTListGrid{
	
	private ListGridField fieldApelido			 = new ListGridField("apelido", 	      Tradutor.i18n.formApelido()		  ,  100);
	private ListGridField fieldDescricao 	     = new ListGridField("descricaoProduto ", Tradutor.i18n.formDescricaoProduto(),  250);

	public PainelListApelidosProduto(){
		
		this.setFields(
				fieldApelido,
				fieldDescricao			
		);
	    this.onHowMInitEntityControl();			

        for ( ListGridField field :  this.getFields()){
        	field.setCanHide(false);
        	field.setCanReorder(false);
        	field.setCanGroupBy(false);
        	field.setCanFreeze(false);
        	field.setCanSort(false);
        	field.setCanSortClientOnly(false);
			field.setWrap(true);
			field.setCanEdit(false);
        }
        onHowMInitHeader();
	}
}
