package com.br.client.panel.cd.cdd0007.UI;

import com.br.client.model.cd.cdd0007.FormBean;
import com.br.client.model.cd.entity.eClienteCondicaoPagamento;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.cd.cdd0007.model.DataSourcePainelDados;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.UI.HowMGWTCheckboxItem;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.model.HowMGWTDataRecord;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTConstants;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;

 

public class WindowCondicoesPagamentoCliente extends HowMGWTWindow{

	private JavaScriptObject parentJavaScriptObject;
	
	private PainelDados painelDados = new PainelDados();
	private PainelLista painelLista = new PainelLista();
	
	private HowMGWTCheckboxItem selecionarTodos = new HowMGWTCheckboxItem("selecionarTodos", Tradutor.i18n.formSelecionarTodos());
	
	private VLayout mainLayout = new VLayout();
	
	private PainelToolbar toolbar = new PainelToolbar() {
		
		protected void onSave() {
			painelLista.onSave();
		};
	};
	
	public  WindowCondicoesPagamentoCliente() {
		this.setShowModalMask(true);
		this.setModalMaskOpacity(HowMGWTConstants.WINDOW_MODAL_MASK_OPACITY);
			
		this.setWidth("400px");
		this.setHeight("550px");
		this.setIsModal(true);
		
		HTMLPane paneHelp = new HTMLPane();
		paneHelp.setWidth100();	
    	paneHelp.setBorder(Tradutor.i18n.msgBorder());
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setContents(Tradutor.i18n.formSelecioneAsCondicoesPagtoCliente());		
 
    	paneHelp.setHeight("22px");
		
		mainLayout.setWidth100();
		mainLayout.setHeight100();
				
		selecionarTodos.setWidth100();
		
		mainLayout.addMember(painelDados);
		mainLayout.addMember(paneHelp);
		mainLayout.addMember(selecionarTodos);
		mainLayout.addMember(painelLista);
		mainLayout.addMember(toolbar);

		this.centerInPage();

		this.addItem(this.mainLayout);
		
		selecionarTodos.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Timer timer = new Timer() {
					
					@Override
					public void run() {
						selectRecords();
					}
				};
				timer.schedule(40);
			}
		});
		
        this.setDismissOnEscape(true);
	}
	
	@Override
	public String getHowMGWTPrograma() {		
		return "CDD0007";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloCDD0007();
	}
	
	public void showEditor(	
							JavaScriptObject object,
							String codCliente, 
							String nomeCliente
						){

		
		selecionarTodos.getField().setValue(false);
		
		parentJavaScriptObject = object;

		this.painelLista.setCodCliente(codCliente);
		
		this.painelDados.setDados(new DataSourcePainelDados(), codCliente, nomeCliente);
		
		this.centerInPage();
		
		this.show();
		
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				setCanFocus(true);
				focus();
				painelDados.setCanFocus(true);
				painelDados.focus();
			}
		};
		timer.schedule(60);
		
		
		
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new  FormBean()) {	
			
			@Override
			public void onNoAccess(){
				WindowCondicoesPagamentoCliente.this.hide();
			}
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
								
				FormBean bean = (FormBean)formBean;
				if ( bean.getCondicoesPagamento() != null ){
					RecordList records = new RecordList();
					HowMGWTDataRecord record;
					for ( eClienteCondicaoPagamento condicao : bean.getCondicoesPagamento() ){
						 record = new HowMGWTDataRecord();
						 
						 record.setAttribute(painelLista.fieldCodCliente.getName(), HowMGWTUtilities.getInteger(condicao.getCodCliente() ));						 

						 if ( HowMGWTUtilities.isEmpty(condicao.getCodCliente()))
							 record.setAttribute(painelLista.fieldSelect.getName(), false);						 
						 else
							 record.setAttribute(painelLista.fieldSelect.getName(), true);						 

						 record.setAttribute(painelLista.fieldCodCondPagto.getName(), condicao.getCodCondPagto());
						 record.setAttribute(painelLista.fieldDescCondPagto.getName(), condicao.getDescCondicaoPagamento());

						 if ( HowMGWTUtilities.isEmpty(condicao.getCodCliente() ) ){
							 record.setAttribute(painelLista.fieldVlMinimoVenda.getName(), (String)null  );
						 }
						 else{
							 record.setAttribute(painelLista.fieldVlMinimoVenda.getName(), HowMGWTUtilities.getDouble(condicao.getVlMinimoVenda()) );							 
						 }
							 
						 records.add(record);

					}
					painelLista.setData(records);
					Timer timer = new Timer() {
						
						@Override
						public void run() {
							setCanFocus(true);
							focus();
							painelDados.setCanFocus(true);
							painelDados.focus();
						}
					};
					timer.schedule(60);					
				}
			}
		};
		struts.setGwtCheckSecurity(true);
		String param = "";
		param += "&codCliente="+codCliente; 
		
		struts.request("cdd0007.do?method=buscar"+param,  "CDD0007Form", "");		
	}
	
	public void selectRecords(){
		boolean select = selecionarTodos.getField().getValueAsBoolean().booleanValue();
		ListGridRecord[] records = this.painelLista.getRecords();
		for ( ListGridRecord record : records ){
			record.setAttribute(this.painelLista.fieldSelect.getName(), select);

			int colNum = this.painelLista.getFieldNum(this.painelLista.fieldSelect.getName());
			int rowNum = this.painelLista.getRecordIndex(record);
			
			this.painelLista.refreshCell(rowNum, colNum);
		}
	}
	
	@Override
	protected void onHowMGWTClose() {		
		// this.setNativeUnoGWTClose(parentJavaScriptObject, ""+this.painelLista.getRecords().length);
	}
	

	/**
	 * @return Retorna o endereço absoluto do contexto onde serão executados os serviços de donwload
	 * GWT.
	 */
	public static native void setNativeUnoGWTClose( JavaScriptObject object) /*-{
	   object.closeCDD0007();	 
	}-*/;	
}
