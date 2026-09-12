package com.br.client.panel.cd.cdd0008.UI;
 
import java.util.LinkedHashMap;

import com.br.client.model.cd.cdd0008.FormBean;
import com.br.client.model.cd.entity.eTabelaPrecoCondicaoPagamento;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.cd.cdd0008.model.DataSourcePainelDados;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.UI.HowMGWTCheckboxItem;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.model.HowMGWTDataRecord;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTConstants;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;

 

public class WindowCondicoesPagamentoTabelaPreco extends HowMGWTWindow{

	private JavaScriptObject parentJavaScriptObject;
	
	private PainelDados painelDados = new PainelDados();
	private PainelLista painelLista = new PainelLista();
	
	private HowMGWTCheckboxItem selecionarTodos = new HowMGWTCheckboxItem("selecionarTodos", Tradutor.i18n.formSelecionarTodos());
	
//	private HowMGWTProperty property = new HowMGWTProperty("tabPreco", "Tab Preco");
	private VLayout mainLayout = new VLayout();
	
	private PainelToolbar toolbar = new PainelToolbar() {
		
		protected void onSave() {
			painelLista.onSave();
		};
	};
	
	public  WindowCondicoesPagamentoTabelaPreco() {
		this.setShowModalMask(true);
		this.setModalMaskOpacity(HowMGWTConstants.WINDOW_MODAL_MASK_OPACITY);
			
		this.setWidth("440px");
		this.setHeight("550px");
		this.setIsModal(true);
		
		HTMLPane paneHelp = new HTMLPane();
		paneHelp.setWidth100();	
    	paneHelp.setBorder(Tradutor.i18n.msgBorder());
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setContents(Tradutor.i18n.formSelecioneAsCondicoesPagtoTabelaPreco());		
 
    	
//    	property.setBound(100, 160);
//    	property.createHowMGWTFormFieldSelectItem();
//    	
//    	LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
//    	map.put("FatDistr", "FatDistr");
//    	map.put("TabPadrao", "TabPadrao");
//    	map.put("A", "A");
//    	property.getHowMGWTEditorSelectItem().getField().setValueMap(map);
//    	property.getHowMGWTEditorSelectItem().getField().addChangedHandler(new ChangedHandler() {
//			
//			@Override
//			public void onChanged(ChangedEvent event) {
//				showEditor(null, property.getHowMValue());
//			}
//		});
//    	toolbar.addMember(property.getCanvas());
    	
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
		return "CDD0008";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloCDD0008();
	}
	
	public void showEditor(	
							JavaScriptObject object,
							String tabelaPreco
						){
 
		this.painelLista.deselectAllRecords();
		this.painelLista.clearAllRecords();
		

		selecionarTodos.getField().setValue(false);
		
		parentJavaScriptObject = object;

		this.painelLista.setTabelaPreco(tabelaPreco);
		
		this.painelDados.setDados(new DataSourcePainelDados(), tabelaPreco);
		
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
				WindowCondicoesPagamentoTabelaPreco.this.hide();
			}
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
 
				FormBean bean = (FormBean)formBean;
				if ( bean.getCondicoesPagamento() != null ){
					HowMGWTDataRecord[] records = new HowMGWTDataRecord[bean.getCondicoesPagamento().length];
 
					HowMGWTDataRecord record;
					int i = 0;
					for ( eTabelaPrecoCondicaoPagamento condicao : bean.getCondicoesPagamento() ){
						 record = new HowMGWTDataRecord();
						 
						 record.setAttribute(painelLista.fieldCodTabelaPreco.getName(), condicao.getTabelaPreco() );
						 record.setAttribute(painelLista.fieldCodCondPagto.getName(), condicao.getCodCondPagto());
						 record.setAttribute(painelLista.fieldDescCondPagto.getName(), condicao.getDescCondicaoPagamento());
 
						 records[i] = record;
						 i ++;
					}
					painelLista.setData(records);

					for ( HowMGWTDataRecord rec : records){
						 if ( HowMGWTUtilities.isEmpty(rec.getAttribute(painelLista.fieldCodTabelaPreco.getName())))
							 ;
						 else
							  painelLista.selectRecord(rec);		 
					}
					painelLista.saveAllEdits();
					
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
		String param = "";
		param += "&tabelaPreco="+tabelaPreco; 
		struts.setGwtCheckSecurity(true);
		struts.request("cdd0008.do?method=buscar"+param,  "CDD0008Form", "");		
	}
	
	public void selectRecords(){
		boolean select = selecionarTodos.getField().getValueAsBoolean().booleanValue();
		if ( select )
			this.painelLista.selectAllRecords();
		else
			this.painelLista.deselectAllRecords();
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
	   object.closeCDD0008();	 
	}-*/;	
}
