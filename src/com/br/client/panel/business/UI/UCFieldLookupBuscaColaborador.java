package com.br.client.panel.business.UI;

import com.br.client.panel.I18N.Tradutor;
 
import com.br.client.panel.sg.sgq0014.UI.LookupBuscaColaborador;
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
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.FocusEvent;
import com.smartgwt.client.widgets.form.fields.events.FocusHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemClickHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyUpEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyUpHandler;

public class UCFieldLookupBuscaColaborador extends HowMGWTCodeDescriptor implements HowMGWTLinkInterface{

	private boolean changedData = false;	
	
	private LookupBuscaColaborador lookupBuscaColaborador = new LookupBuscaColaborador();

	public UCFieldLookupBuscaColaborador(){
    	
		super( "codigoColaborador", Tradutor.i18n.formCodigoColaborador() );
		
		PickerIcon buscarCliente = new PickerIcon(PickerIcon.SEARCH, new FormItemClickHandler(){  
            public void onFormItemClick(FormItemIconClickEvent event) {  
               
            	lookupBuscaColaborador.setFieldLocator(false);
            	lookupBuscaColaborador.show();
            }  
        });
		
    	this.getField().getField().setIcons(buscarCliente);
	
    	this.lookupBuscaColaborador.addHowMLinkField(
    			new HowMGWTLinkField(
    					this.lookupBuscaColaborador.getResultadoResultado().getFieldCodigo(), 
    					UCFieldLookupBuscaColaborador.this.getField()
    			)
    	);
    	
    	this.lookupBuscaColaborador.addHowMLinkField(
    			new HowMGWTLinkField(
    					this.lookupBuscaColaborador.getResultadoResultado().getFieldNomeColaborador(), 
    					UCFieldLookupBuscaColaborador.this.getMessageLabel()
    			)
    	);

    	
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
					
					lookupBuscaColaborador.clearFilters();
					lookupBuscaColaborador.setFieldLocator(true);
					lookupBuscaColaborador.getFiltroConsulta().getFieldCodColaborador().setHowMValue(getField().getHowMValueAsString());
					// Limpa os dados do campo para selecionar pela lookup de busca dos colaboradores.
					getField().setHowMValue("");
					onHowMGWTSelect(false);

					UCFieldLookupBuscaColaborador.this.getMessageLabel().setHowMValue("");
					if ( ! HowMGWTUtilities.isEmpty(lookupBuscaColaborador.getFiltroConsulta().getFieldCodColaborador().getHowMValue()) )
							lookupBuscaColaborador.getToolbarNavegator().executeQuery();
				}
			}
		});
    	
    	
    	this.getField().getField().addKeyUpHandler(new KeyUpHandler() {
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				if ( !HowMGWTUtilities.isEmpty(event.getKeyName()) ){
					if ( "Enter".equals(event.getKeyName())){						
						lookupBuscaColaborador.clearFilters();
						lookupBuscaColaborador.setFieldLocator(true);
						lookupBuscaColaborador.getFiltroConsulta().getFieldCodColaborador().setHowMValue(getField().getHowMValueAsString());
						// Limpa os dados do campo para selecionar pela lookup de busca dos colaboradores.
						getField().setHowMValue("");
						onHowMGWTSelect(false);

						UCFieldLookupBuscaColaborador.this.getMessageLabel().setHowMValue("");
						if ( ! HowMGWTUtilities.isEmpty(lookupBuscaColaborador.getFiltroConsulta().getFieldCodColaborador().getHowMValue()) )
								lookupBuscaColaborador.getToolbarNavegator().executeQuery();						
					}
				}
			}
		});
    	
    	this.lookupBuscaColaborador.setHowMGWTLinkdAction(new HowMGWTLinkAction() {
			
			@Override
			public void onHowMSelectAction() {
				 onHowMGWTSelect(true);
			}
		});
	}

	@Override
	public void setHowMLinkAction(HowMGWTLinkAction linkAction) {
		this.lookupBuscaColaborador.setHowMGWTLinkdAction( linkAction );
	}

	@Override
	public void setHowMGWTParentPlugIn( HowMGWTPlugInInterface parentHowMGWTPlugIn) {
		this.lookupBuscaColaborador.setParentHowMGWTPlugIn(parentHowMGWTPlugIn);
		
	}

	/**
	 * @return the lookupBuscaColaborador
	 */
	public LookupBuscaColaborador getLookupBuscaColaborador() {
		return lookupBuscaColaborador;
	}

	/**
	 * @param lookupBuscaColaborador the lookupBuscaColaborador to set
	 */
	public void setLookupBuscaColaborador(
			LookupBuscaColaborador lookupBuscaColaborador) {
		this.lookupBuscaColaborador = lookupBuscaColaborador;
	}
 
	public void onHowMGWTSelect(boolean selected){		
	}
}
