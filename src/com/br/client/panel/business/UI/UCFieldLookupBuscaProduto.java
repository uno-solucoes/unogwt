package com.br.client.panel.business.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.vd.vdq0002.UI.WindowLookupBuscaProduto;
import com.howmake.client.form.UI.HowMGWTCodeDescriptor;
import com.howmake.client.form.model.HowMGWTLinkAction;
import com.howmake.client.form.model.HowMGWTLinkField;
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

public class UCFieldLookupBuscaProduto extends HowMGWTCodeDescriptor { // implements HowMGWTLinkInterface{

	private WindowLookupBuscaProduto lookupBuscaProduto = new WindowLookupBuscaProduto(){
		@Override
		public void onSelectLookup(String codProduto, String descricao){
			getField().setHowMValue(codProduto);
			getMessageLabel().setHowMValue(descricao);
			
		}		
	};

	private boolean changedData = false;	
	
	
	public UCFieldLookupBuscaProduto(){
    	
		super( "codigoCliente", Tradutor.i18n.formCodProduto() );
		
		PickerIcon buscarCliente = new PickerIcon(PickerIcon.SEARCH, new FormItemClickHandler(){  
            public void onFormItemClick(FormItemIconClickEvent event) {  

            	lookupBuscaProduto.show();
            }  
        });
		
    	this.getField().getField().setIcons(buscarCliente);
    
    	
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

    	this.getField().getField().addBlurHandler(new BlurHandler(){
			
			@Override
			public void onBlur(BlurEvent event) {
				if ( changedData ){
					
					lookupBuscaProduto.getPainelBuscaProduto().getFiltroConsulta().limparFiltros();
					lookupBuscaProduto.getPainelBuscaProduto().getRelacaoGerenciadorProduto().setFieldLocator(true);
					lookupBuscaProduto.getPainelBuscaProduto().getFiltroConsulta().getFieldCodigoProduto().setHowMValue(getField().getHowMValue());
					// Limpa os dados do campo para selecionar pela lookup de busca dos colaboradores.
					getField().setHowMValue("");
					UCFieldLookupBuscaProduto.this.getMessageLabel().setHowMValue("");

					onHowMGWTSelect(false);
					
					if ( ! HowMGWTUtilities.isEmpty(lookupBuscaProduto.getPainelBuscaProduto().getFiltroConsulta().getFieldCodigoProduto().getHowMValue()) )
						lookupBuscaProduto.getPainelBuscaProduto().getRelacaoGerenciadorProduto().getToolbarNavegatorListaProdutos().startBuscar();

				}
			}
		});

    	this.getField().getField().addKeyUpHandler(new KeyUpHandler(){
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				if ( !HowMGWTUtilities.isEmpty(event.getKeyName()) ){
					if ( "Enter".equals(event.getKeyName())){						

						lookupBuscaProduto.getPainelBuscaProduto().getFiltroConsulta().limparFiltros();
						lookupBuscaProduto.getPainelBuscaProduto().getRelacaoGerenciadorProduto().setFieldLocator(true);
						lookupBuscaProduto.getPainelBuscaProduto().getFiltroConsulta().getFieldCodigoProduto().setHowMValue(getField().getHowMValue());
						// Limpa os dados do campo para selecionar pela lookup de busca dos colaboradores.
						getField().setHowMValue("");
						UCFieldLookupBuscaProduto.this.getMessageLabel().setHowMValue("");

						onHowMGWTSelect(false);
						
						if ( ! HowMGWTUtilities.isEmpty(lookupBuscaProduto.getPainelBuscaProduto().getFiltroConsulta().getFieldCodigoProduto().getHowMValue()) )
							lookupBuscaProduto.getPainelBuscaProduto().getRelacaoGerenciadorProduto().getToolbarNavegatorListaProdutos().startBuscar();

					}
				}
			}
		});    	
    	
    	
    	
    	
    	
    	
    	
    	
	}

//	@Override
//	public void setHowMLinkAction(HowMGWTLinkAction linkAction) {
//		this.lookupBuscaProduto.setHowMGWTLinkdAction( linkAction );
//	}
//
//	@Override
//	public void setHowMGWTParentPlugIn( HowMGWTPlugInInterface parentHowMGWTPlugIn) {
//		this.lookupBuscaProduto.setParentHowMGWTPlugIn(parentHowMGWTPlugIn);
//		
//	}
	
	public void onHowMGWTSelect(boolean selected){
		
	}
	
	@Override
	public void setDisabled(boolean disabled) {
		this.getField().setHowMValue(disabled);		
	}
}
