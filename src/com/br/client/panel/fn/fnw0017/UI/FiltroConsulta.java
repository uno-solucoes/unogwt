package com.br.client.panel.fn.fnw0017.UI;

import java.util.LinkedHashMap;

import com.br.client.model.fn.entity.eCenario;
import com.br.client.model.fn.fnw0017.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.UI.UCFieldLookupBuscaOrcamento;
import com.google.gwt.core.client.Scheduler;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class FiltroConsulta extends VLayout{ 

	FormBean bean ;
	
	private UCFieldLookupBuscaOrcamento fieldCodOrcamento = new UCFieldLookupBuscaOrcamento(){
		public void onHowMGWTSelect(boolean selected) {
			if( selected ){
				loadCenarios(this.getField().getHowMValueAsString());
			}
		};
	};
	
	private HowMGWTProperty propertyCenario = new HowMGWTProperty("cenario", Tradutor.i18n.formCenario());

	private IButton actionBuscar = new IButton(Tradutor.i18n.buscar()); 
	private HTMLPane paneHelp = new HTMLPane();
	
	public FiltroConsulta(){ 
		
		paneHelp.setBorder(Tradutor.i18n.msgBorder());
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setContents(Tradutor.i18n.msgLookupHelpEbitida());
		
		HLayout mainLayout = new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		VLayout filterLayout = new VLayout();
		filterLayout.setWidth(500);
		filterLayout.setHeight100();
		
		fieldCodOrcamento.getField().setHowMBound(100, 300);
		filterLayout.addMember(fieldCodOrcamento);

		propertyCenario.setBound(100, 300);
		propertyCenario.createHowMGWTFormFieldSelectItem();
		filterLayout.setWidth100();
		filterLayout.addMember( propertyCenario.getCanvas() );
		
		propertyCenario.getCanvas().setVisible( false );
		
		propertyCenario.getHowMGWTEditorSelectItem().getField().addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
					
					@Override
					public void execute() {
						onChangedCenario();						
					}
				});
			}
		});
		
		filterLayout.addMember( paneHelp );
	
		mainLayout.addMember( filterLayout );
		
		actionBuscar.setIcon("actions/search.png");    	
    	actionBuscar.setWidth("100px");
    	mainLayout.addMember(actionBuscar);

    	this.setHeight(90);
    	this.addMember(mainLayout);
	}
 
	/**
	 * @return the actionBuscar
	 */
	public IButton getActionBuscar() {
		return actionBuscar;
	}

	/**
	 * @param actionBuscar the actionBuscar to set
	 */
	public void setActionBuscar(IButton actionBuscar) {
		this.actionBuscar = actionBuscar;
	}
	
	public void loadCenarios( String codOrcamento ) {
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts( new FormBean() ) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {

				propertyCenario.getCanvas().setVisible( false );
				
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true))
					return;
				
				bean = (FormBean)formBean;
				
				LinkedHashMap<String, String> mapCenarios = new LinkedHashMap<String, String>();
				
				mapCenarios.put("0", "Selecione um cenario. ");
				
				eCenario[] cenarios = bean.getCenarios();
				if( cenarios != null ){
					
					for (eCenario cenario : cenarios) {
						mapCenarios.put(cenario.getCenario(), cenario.getNome());
					}
				}
				
				propertyCenario.getHowMGWTEditorSelectItem().getField().setValueMap(mapCenarios);
				propertyCenario.setHowmFormValue("0");
				propertyCenario.getCanvas().setVisible( true );
				
				Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
					
					@Override
					public void execute() {
						onChangedOrcamento();
					}
				});				
				
			}
		};
		
		FormBean bean = new FormBean();
		bean.setCodOrcamento(codOrcamento);
		
		struts.request("fnw0017.do?method=buscarOrcamento", "FNW0017Form" , bean.toSendBody("") );
	}

	/**
	 * @return the bean
	 */
	public FormBean getBean() {
		return bean;
	}

	/**
	 * @param bean the bean to set
	 */
	public void setBean(FormBean bean) {
		this.bean = bean;
	}

	/**
	 * @return the propertyCenario
	 */
	public HowMGWTProperty getPropertyCenario() {
		return propertyCenario;
	}
	
	
	protected void onChangedOrcamento(){}
	protected void onChangedCenario(){}

}