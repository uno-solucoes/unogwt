package com.br.client.panel.business.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.cd.cdq0101.UI.LookupBuscaCliente;
import com.howmake.client.form.UI.HowMGWTCodeDescriptor;
import com.howmake.client.form.model.HowMGWTLinkAction;
import com.howmake.client.form.model.HowMGWTLinkField;
import com.howmake.client.form.model.HowMGWTLinkInterface;
import com.howmake.client.form.model.HowMGWTPlugInInterface;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.widgets.form.fields.PickerIcon;
import com.smartgwt.client.widgets.form.fields.events.BlurEvent;
import com.smartgwt.client.widgets.form.fields.events.BlurHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.FocusEvent;
import com.smartgwt.client.widgets.form.fields.events.FocusHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemClickHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyUpEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyUpHandler;

public class UCFieldLookupBuscaCliente extends HowMGWTCodeDescriptor implements HowMGWTLinkInterface{

	private LookupBuscaCliente lookupBuscaCliente = new LookupBuscaCliente();

	private boolean changedData = false;	
	
	
	public UCFieldLookupBuscaCliente(){
    	
		super( "codigoCliente", Tradutor.i18n.formCodigoCliente() );
		
		PickerIcon buscarCliente = new PickerIcon(PickerIcon.SEARCH, new FormItemClickHandler(){  
            public void onFormItemClick(FormItemIconClickEvent event) {  
                // SC.say("Consultar o Cliente");  
            	
            	lookupBuscaCliente.show();
            }  
        });
		
    	this.getField().getField().setIcons(buscarCliente);
	
    	this.lookupBuscaCliente.addHowMLinkField(
    			new HowMGWTLinkField(
    					this.lookupBuscaCliente.getResultadoResultado().getFieldCodigo(), 
    					UCFieldLookupBuscaCliente.this.getField()
    			)
    	);
    	
    	this.lookupBuscaCliente.addHowMLinkField(
    			new HowMGWTLinkField(
    					this.lookupBuscaCliente.getResultadoResultado().getNomeCliente(), 
    					UCFieldLookupBuscaCliente.this.getMessageLabel()
    			)
    	);
    
    	
    	
    	/**
    	 * -----------------------------------------------------------------------
    	 * Implementa a busca ao sair do foco ou alterar o dados do campo chave da
    	 * lookup.
    	 * -----------------------------------------------------------------------
    	 */
    	
    	
    	this.getField().getField().addFocusHandler(new FocusHandler() {
			
			@Override
			public void onFocus(FocusEvent event) {
				changedData = false;
			}
		});
    	
    	this.getField().getField().addChangedHandler(new ChangedHandler() {			
			@Override
			public void onChanged(ChangedEvent event) {
				changedData = true;
				onHowMGWTSelect(false);
			}
		});

    	this.getField().getField().addBlurHandler(new BlurHandler() {
			
			@Override
			public void onBlur(BlurEvent event) {
				if ( changedData ){					
					
					lookupBuscaCliente.clearFilters();
					lookupBuscaCliente.setFieldLocator(true);
					lookupBuscaCliente.getFiltroConsulta().getFieldCodigoCliente().setHowMValue(getField().getHowMValueAsString());
					// Limpa os dados do campo para selecionar pela lookup de busca dos colaboradores.
					getField().setHowMValue("");
					onHowMGWTSelect(false);

					UCFieldLookupBuscaCliente.this.getMessageLabel().setHowMValue("");
					if ( ! HowMGWTUtilities.isEmpty(lookupBuscaCliente.getFiltroConsulta().getFieldCodigoCliente().getHowMValue()) )
						lookupBuscaCliente.getToolbarNavegator().executeQuery();
				}
			}
		});

    	this.getField().getField().addKeyUpHandler(new KeyUpHandler() {
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				if ( !HowMGWTUtilities.isEmpty(event.getKeyName()) ){
					if ( "Enter".equals(event.getKeyName())){						
						lookupBuscaCliente.clearFilters();
						lookupBuscaCliente.setFieldLocator(true);
						lookupBuscaCliente.getFiltroConsulta().getFieldCodigoCliente().setHowMValue(getField().getHowMValueAsString());
						// Limpa os dados do campo para selecionar pela lookup de busca dos colaboradores.
						getField().setHowMValue("");
						onHowMGWTSelect(false);

						UCFieldLookupBuscaCliente.this.getMessageLabel().setHowMValue("");
						if ( ! HowMGWTUtilities.isEmpty(lookupBuscaCliente.getFiltroConsulta().getFieldCodigoCliente().getHowMValue()) )
							lookupBuscaCliente.getToolbarNavegator().executeQuery();						
					}
				}
			}
		});    	
    	
    	
    	
    	
    	
    	
    	
    	
	}

	@Override
	public void setHowMLinkAction(HowMGWTLinkAction linkAction) {
		this.lookupBuscaCliente.setHowMGWTLinkdAction( linkAction );
	}

	@Override
	public void setHowMGWTParentPlugIn( HowMGWTPlugInInterface parentHowMGWTPlugIn) {
		this.lookupBuscaCliente.setParentHowMGWTPlugIn(parentHowMGWTPlugIn);
		
	}
	
	public void onHowMGWTSelect(boolean selected){
		
	}
	
}
