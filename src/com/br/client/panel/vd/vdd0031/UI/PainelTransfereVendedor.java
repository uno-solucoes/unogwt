package com.br.client.panel.vd.vdd0031.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.UI.UCFieldLookupBuscaColaborador;
import com.howmake.client.form.UI.HowMGWTLabel;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelTransfereVendedor extends VLayout{

	public UCFieldLookupBuscaColaborador fieldColaborador = new UCFieldLookupBuscaColaborador(){
		public void onHowMGWTSelect(boolean selected){		
			actionAtualizar.setDisabled(!selected);
		}		
	};
	public HowMGWTLabel fieldMessage = new HowMGWTLabel();
	public IButton actionAtualizar = new IButton(Tradutor.i18n.formAtualizar());
	public IButton actionCancelar  = new IButton(Tradutor.i18n.formCancelar());
	
	public PainelTransfereVendedor(){
		
		this.setWidth100();

		HLayout hLayoutMessage = new HLayout();
		hLayoutMessage.setBackgroundColor(Tradutor.i18n.msgColor());
		hLayoutMessage.setWidth100();
		hLayoutMessage.setHeight("40px");
		hLayoutMessage.setAlign(Alignment.CENTER);
		
		fieldMessage.setWidth("210px");
		fieldMessage.setHeight("36px");
		fieldMessage.setOverflow(Overflow.HIDDEN);
		hLayoutMessage.addMember(fieldMessage);
		
		this.addMember(hLayoutMessage);
		
		fieldColaborador.getField().getField().setTitle("Transferir para o Vendedor"); 
		fieldColaborador.setWidth100();
		
		fieldColaborador.getField().setTitleWidth(150);		
		fieldColaborador.getField().setWidth(310);
		
		this.addMember(fieldColaborador);

		HLayout sep = new HLayout();
		sep.setWidth100();
		sep.setHeight(10);
		this.addMember(sep);
		
		HLayout hLayout = new HLayout();
		hLayout.setWidth100();
		hLayout.setHeight("36px");
		hLayout.setAlign(Alignment.CENTER);
		
		actionAtualizar.setDisabled(true);
		actionAtualizar.setWidth("100px");
		actionCancelar.setWidth("100px");

		hLayout.addMember(actionAtualizar);
		hLayout.addMember(actionCancelar);
		
		
		this.addMember(hLayout);
	}
	
}
