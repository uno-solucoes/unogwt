package com.br.client.panel.business.UI;

import com.br.client.panel.I18N.Tradutor;
 
import com.br.client.panel.cc.ccq0003.UI.LookupBuscaFornecedor;
import com.br.client.panel.sg.sgq0014.UI.LookupBuscaColaborador;
import com.howmake.client.form.UI.HowMGWTCodeDescriptor;
import com.howmake.client.form.model.HowMGWTLinkAction;
import com.howmake.client.form.model.HowMGWTLinkField;
import com.howmake.client.form.model.HowMGWTLinkInterface;
import com.howmake.client.form.model.HowMGWTPlugInInterface;
import com.howmake.client.form.partner.HowMGWTProperty;
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

public class UCFieldLookupBuscaFornecedor extends HowMGWTCodeDescriptor implements HowMGWTLinkInterface{

	private HowMGWTProperty parentProperty;
	
	private boolean changedData = false;	
	
	private LookupBuscaFornecedor lookupBuscaFornecedor = new LookupBuscaFornecedor();

	public UCFieldLookupBuscaFornecedor(){
    	
		super( "codigoFornecedor", Tradutor.i18n.formCodFornecedor() );
		
		PickerIcon buscarCliente = new PickerIcon(PickerIcon.SEARCH, new FormItemClickHandler(){  
            public void onFormItemClick(FormItemIconClickEvent event) {  
               
            	lookupBuscaFornecedor.setFieldLocator(false);
            	lookupBuscaFornecedor.show();
            }  
        });
		
    	this.getField().getField().setIcons(buscarCliente);
	
    	this.lookupBuscaFornecedor.addHowMLinkField(
    			new HowMGWTLinkField(
    					this.lookupBuscaFornecedor.getResultadoResultado().getFieldCodigo(), 
    					UCFieldLookupBuscaFornecedor.this.getField()
    			)
    	);
    	
    	this.lookupBuscaFornecedor.addHowMLinkField(
    			new HowMGWTLinkField(
    					this.lookupBuscaFornecedor.getResultadoResultado().getFieldNomeFornecedor(), 
    					UCFieldLookupBuscaFornecedor.this.getMessageLabel()
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
					
					lookupBuscaFornecedor.clearFilters();
					lookupBuscaFornecedor.setFieldLocator(true);
					lookupBuscaFornecedor.getFiltroConsulta().getFieldCodFornecedor().setHowMValue(getField().getHowMValueAsString());
					// Limpa os dados do campo para selecionar pela lookup de busca dos colaboradores.
					getField().setHowMValue("");
					onHowMGWTSelect(false);

					UCFieldLookupBuscaFornecedor.this.getMessageLabel().setHowMValue("");
					if ( ! HowMGWTUtilities.isEmpty(lookupBuscaFornecedor.getFiltroConsulta().getFieldCodFornecedor().getHowMValue()) )
							lookupBuscaFornecedor.getToolbarNavegator().executeQuery();
				}
			}
		});
    	
    	
    	this.getField().getField().addKeyUpHandler(new KeyUpHandler() {
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				if ( !HowMGWTUtilities.isEmpty(event.getKeyName()) ){
					if ( "Enter".equals(event.getKeyName())){						
						lookupBuscaFornecedor.clearFilters();
						lookupBuscaFornecedor.setFieldLocator(true);
						lookupBuscaFornecedor.getFiltroConsulta().getFieldCodFornecedor().setHowMValue(getField().getHowMValueAsString());
						// Limpa os dados do campo para selecionar pela lookup de busca dos colaboradores.
						getField().setHowMValue("");
						onHowMGWTSelect(false);

						UCFieldLookupBuscaFornecedor.this.getMessageLabel().setHowMValue("");
						if ( ! HowMGWTUtilities.isEmpty(lookupBuscaFornecedor.getFiltroConsulta().getFieldCodFornecedor().getHowMValue()) )
								lookupBuscaFornecedor.getToolbarNavegator().executeQuery();						
					}
				}
			}
		});
    	
    	this.lookupBuscaFornecedor.setHowMGWTLinkdAction(new HowMGWTLinkAction() {
			
			@Override
			public void onHowMSelectAction() {
				 if ( getParentProperty() != null ){
					 getParentProperty().onHowMGWTSelect(true);
				 }
				 onHowMGWTSelect(true);
			}
		});
	}

	@Override
	public void setHowMLinkAction(HowMGWTLinkAction linkAction) {
		this.lookupBuscaFornecedor.setHowMGWTLinkdAction( linkAction );
	}

	@Override
	public void setHowMGWTParentPlugIn( HowMGWTPlugInInterface parentHowMGWTPlugIn) {
		this.lookupBuscaFornecedor.setParentHowMGWTPlugIn(parentHowMGWTPlugIn);
		
	}

	/**
	 * @return the lookupBuscaFornecedor
	 */
	public LookupBuscaFornecedor getLookupBuscaFornecedor() {
		return lookupBuscaFornecedor;
	}

	/**
	 * @param lookupBuscaColaborador the lookupBuscaColaborador to set
	 */
	public void setLookupBuscaColaborador(
			LookupBuscaFornecedor lookupBuscaFornecedor) {
		this.lookupBuscaFornecedor = lookupBuscaFornecedor;
	}
 
	public void onHowMGWTSelect(boolean selected){
		 
	}

	/**
	 * @return the parentProperty
	 */
	public HowMGWTProperty getParentProperty() {
		return parentProperty;
	}

	/**
	 * @param parentProperty the parentProperty to set
	 */
	public void setParentProperty(HowMGWTProperty parentProperty) {
		this.parentProperty = parentProperty;
	}
}
