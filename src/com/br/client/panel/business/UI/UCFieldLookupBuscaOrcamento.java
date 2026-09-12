package com.br.client.panel.business.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.fn.fnq0013.UI.LookupBuscaOrcamento;
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

public class UCFieldLookupBuscaOrcamento extends HowMGWTCodeDescriptor implements HowMGWTLinkInterface{

	private LookupBuscaOrcamento lookupBuscaOrcamento = new LookupBuscaOrcamento();

	private boolean changedData = false;	
	
	
	public UCFieldLookupBuscaOrcamento(){
    	
		super( "codOrcamento", Tradutor.i18n.formCodOrcamento() );
		
		PickerIcon buscarOrcamento = new PickerIcon(PickerIcon.SEARCH, new FormItemClickHandler(){  
            public void onFormItemClick(FormItemIconClickEvent event) {  
                // SC.say("Consultar o Orcamento");  
            	
            	lookupBuscaOrcamento.show();
            }  
        });
		
    	this.getField().getField().setIcons(buscarOrcamento);
	
    	this.lookupBuscaOrcamento.addHowMLinkField(
    			new HowMGWTLinkField(
    					this.lookupBuscaOrcamento.getResultadoResultado().getFieldCodigo(), 
    					UCFieldLookupBuscaOrcamento.this.getField()
    			)
    	);
    	
    	this.lookupBuscaOrcamento.addHowMLinkField(
    			new HowMGWTLinkField(
    					this.lookupBuscaOrcamento.getResultadoResultado().getNome(), 
    					UCFieldLookupBuscaOrcamento.this.getMessageLabel()
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
					
					lookupBuscaOrcamento.clearFilters();
					lookupBuscaOrcamento.setFieldLocator(true);
					lookupBuscaOrcamento.getFiltroConsulta().getFieldCodigoOrcamento().setHowMValue(getField().getHowMValueAsString());
					// Limpa os dados do campo para selecionar pela lookup de busca dos colaboradores.
					getField().setHowMValue("");
					onHowMGWTSelect(false);

					UCFieldLookupBuscaOrcamento.this.getMessageLabel().setHowMValue("");
					if ( ! HowMGWTUtilities.isEmpty(lookupBuscaOrcamento.getFiltroConsulta().getFieldCodigoOrcamento().getHowMValue()) )
						lookupBuscaOrcamento.getToolbarNavegator().executeQuery();
				}
			}
		});

    	this.getField().getField().addKeyUpHandler(new KeyUpHandler() {
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				if ( !HowMGWTUtilities.isEmpty(event.getKeyName()) ){
					if ( "Enter".equals(event.getKeyName())){						
						lookupBuscaOrcamento.clearFilters();
						lookupBuscaOrcamento.setFieldLocator(true);
						lookupBuscaOrcamento.getFiltroConsulta().getFieldCodigoOrcamento().setHowMValue(getField().getHowMValueAsString());
						// Limpa os dados do campo para selecionar pela lookup de busca dos colaboradores.
						getField().setHowMValue("");
						onHowMGWTSelect(false);

						UCFieldLookupBuscaOrcamento.this.getMessageLabel().setHowMValue("");
						if ( ! HowMGWTUtilities.isEmpty(lookupBuscaOrcamento.getFiltroConsulta().getFieldCodigoOrcamento().getHowMValue()) )
							lookupBuscaOrcamento.getToolbarNavegator().executeQuery();						
					}
				}
			}
		});    	
    	
    	
    	this.lookupBuscaOrcamento.setHowMGWTLinkdAction(new HowMGWTLinkAction() {
			
			@Override
			public void onHowMSelectAction() {
				 onHowMGWTSelect(true);
			}
		});
	}
	
	

	@Override
	public void setHowMLinkAction(HowMGWTLinkAction linkAction) {
		this.lookupBuscaOrcamento.setHowMGWTLinkdAction( linkAction );
	}

	@Override
	public void setHowMGWTParentPlugIn( HowMGWTPlugInInterface parentHowMGWTPlugIn) {
		this.lookupBuscaOrcamento.setParentHowMGWTPlugIn(parentHowMGWTPlugIn);
		
	}
	
	public void onHowMGWTSelect(boolean selected){
		
	}

}
