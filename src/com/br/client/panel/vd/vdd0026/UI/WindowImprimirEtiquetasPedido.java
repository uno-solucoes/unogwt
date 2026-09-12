package com.br.client.panel.vd.vdd0026.UI;
 
import com.br.client.model.vd.entity.eItemPedido;
import com.br.client.model.vd.vdw0001.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.vd.vdd0026.model.DataSourcePainelDados;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.UI.HowMGWTCheckboxItem;
import com.howmake.client.form.UI.HowMGWTTextItem;
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
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;

 

public class WindowImprimirEtiquetasPedido extends HowMGWTWindow{

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
	
	public  WindowImprimirEtiquetasPedido() {
		this.setShowModalMask(true);
		this.setModalMaskOpacity(HowMGWTConstants.WINDOW_MODAL_MASK_OPACITY);
			
		this.setWidth("700px");
		this.setHeight("600px");
		this.setIsModal(true);
		
		HTMLPane paneHelp = new HTMLPane();
		paneHelp.setWidth100();	
    	paneHelp.setBorder(Tradutor.i18n.msgBorder());
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setContents(Tradutor.i18n.formSelecioneOsItensParaImpressao());		
 
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
		return "VDD0028";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloVDD0026();
	}
	
	public void showEditor(	
							JavaScriptObject object,
							String pedido
						){

		
		selecionarTodos.getField().setValue(false);
		
		parentJavaScriptObject = object;
 		
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
				WindowImprimirEtiquetasPedido.this.hide();
			}
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
 
				FormBean bean = (FormBean)formBean;
				if ( bean.getItensPedido() != null ){
					painelDados.setDados(new DataSourcePainelDados(), bean.getCodPedido()+"-["+bean.getCodCliente()+"]-"+bean.getRazaoSocial());

					RecordList records = new RecordList();
					HowMGWTDataRecord record;
					for ( eItemPedido item : bean.getItensPedido() ){
						
						if ( ! HowMGWTUtilities.isEmpty(item.getCodProduto()) ){
							 record = new HowMGWTDataRecord();

							 record.setAttribute(painelLista.fieldSelect.getName(), false);
							 record.setAttribute(painelLista.fieldCodProduto.getName(), item.getCodProduto());
							 record.setAttribute(painelLista.fieldDescProduto.getName(), item.getDescComercial());
							 record.setAttribute(painelLista.fieldQtdEtiquetas.getName() , HowMGWTUtilities.getInteger(item.getQtdVolumes()));
							 record.setAttribute(painelLista.fieldQtdVolumes.getName(), HowMGWTUtilities.getInteger(item.getQtdVolumes()));
							 if( HowMGWTUtilities.isEmpty(item.getDtImpressaoEtiqueta()) || item.getDtImpressaoEtiqueta().trim().length() < 10)
								 record.setAttribute(painelLista.fieldDataImpressao.getName(), "");
							 else{
								 String data[] = item.getDtImpressaoEtiqueta().split("-");
								 String year = data[0];
								 String mes  = data[1];
								 String dia  = data[2];
								 String newDate = dia + "/" + mes + "/" + year;
								 record.setAttribute(painelLista.fieldDataImpressao.getName(),newDate);
							 }
							 records.add(record);
						}
					}
					painelLista.setData(records);
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
		struts.setGwtCheckSecurity(true);
		struts.requestFormBean("vdw0001",  "VDW0001Form");
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
	   object.closeCDD0008();	 
	}-*/;	
}
