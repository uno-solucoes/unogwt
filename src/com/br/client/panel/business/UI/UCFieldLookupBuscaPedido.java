package com.br.client.panel.business.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.cd.cdq0101.UI.LookupBuscaCliente;
import com.br.client.panel.vd.vdq0001.UI.LookupBuscarPedido;
import com.howmake.client.form.UI.HowMGWTCodeDescriptor;
import com.howmake.client.form.model.HowMGWTLinkAction;
import com.howmake.client.form.model.HowMGWTLinkField;
import com.howmake.client.form.model.HowMGWTLinkInterface;
import com.howmake.client.form.model.HowMGWTPlugInInterface;
import com.smartgwt.client.widgets.form.fields.PickerIcon;
import com.smartgwt.client.widgets.form.fields.events.FormItemClickHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent;

public class UCFieldLookupBuscaPedido extends HowMGWTCodeDescriptor implements HowMGWTLinkInterface{

	private LookupBuscarPedido lookupBuscaPedido = new LookupBuscarPedido();

	public UCFieldLookupBuscaPedido(){
    	
		super( "codigoCliente", Tradutor.i18n.formCodigoPedido() );
		
		PickerIcon buscarPedido = new PickerIcon(PickerIcon.SEARCH, new FormItemClickHandler(){  
            public void onFormItemClick(FormItemIconClickEvent event) { 
                // SC.say("Consultar o Cliente");  
            	
            	lookupBuscaPedido.show();
            }  
        });
		
    	this.getField().getField().setIcons(buscarPedido);
	
    	this.lookupBuscaPedido.addHowMLinkField(
    			new HowMGWTLinkField(
    					this.lookupBuscaPedido.getResultadoResultado().getFieldCodPedido(), 
    					UCFieldLookupBuscaPedido.this.getField()
    			)
    	);
 
    	
	}
	
	@Override
	public void setHowMLinkAction(HowMGWTLinkAction linkAction) {
		this.lookupBuscaPedido.setHowMGWTLinkdAction( linkAction );
	}
	
	@Override
	public void setHowMGWTParentPlugIn( HowMGWTPlugInInterface parentHowMGWTPlugIn) {
		this.lookupBuscaPedido.setParentHowMGWTPlugIn(parentHowMGWTPlugIn);
		
	}

	@Override
	public void onHowMGWTSelect(boolean selected) {
		// TODO Auto-generated method stub
		
	}	
 

}