package com.br.client.panel.sv.svd0010.UI;

import com.br.client.model.sv.entity.ePlanoServicoComissaoExcecao;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.sv.svd0010.model.DataSourcePainelDados;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.model.HowMGWTDataRecord;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTConstants;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

public class WindowVendedorExcecao  extends HowMGWTWindow{

	private JavaScriptObject parentJavaScriptObject;
	
	private PainelDados painelDados = new PainelDados();
	private PainelLista painelLista = new PainelLista();
	
	private VLayout mainLayout = new VLayout();
	
	private PainelToolbar toolbar = new PainelToolbar() {
		
		@Override
		protected void onNewRecord() {
			HowMGWTDataRecord record = new HowMGWTDataRecord();

			painelLista.setCellCanEditInsertMode(record, painelLista.fieldParcela.getName(), 		true);
			painelLista.setCellCanEditInsertMode(record, painelLista.fieldPercComissao.getName(), 	true);

			painelLista.setCellCanEditUpdateMode(record, painelLista.fieldPercComissao.getName(), 	true);

			painelLista.addNewRecord(record);
		}
		protected void onSave() {
			painelLista.onSave();
		};
	};
	
	public  WindowVendedorExcecao() {
		this.setShowModalMask(true);
		this.setModalMaskOpacity(HowMGWTConstants.WINDOW_MODAL_MASK_OPACITY);
			
		this.setWidth("400px");
		this.setHeight("450px");
		this.setIsModal(true);
		
		HTMLPane paneHelp = new HTMLPane();
		paneHelp.setWidth100();	
    	paneHelp.setBorder(Tradutor.i18n.msgBorder());
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setContents(Tradutor.i18n.formListaExcecoesComissao());		
    	paneHelp.setHeight("22px");
		
		mainLayout.setWidth100();
		mainLayout.setHeight100();
				
		mainLayout.addMember(painelDados);
		mainLayout.addMember(paneHelp);
		mainLayout.addMember(painelLista);
		mainLayout.addMember(toolbar);

		this.centerInPage();

        this.setDismissOnEscape(true);

		this.addItem(this.mainLayout);
	}
	
	@Override
	public String getHowMGWTPrograma() {		
		return "SVD0010";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloSVD0010();
	}
	
	public void showEditor(	
							JavaScriptObject object,
							String codEmpresa , 
							String tpOwner, 
							String codPlano, 
							String participante, 
							String vendedor, 
							String percComissao, 
							String parcelas){

		parentJavaScriptObject = object;

		this.painelLista.setCodEmpresa(codEmpresa);
		this.painelLista.setTpOwner(tpOwner);
		this.painelLista.setCodPlano(codPlano);
		
		this.painelDados.setDados(new DataSourcePainelDados(), participante, vendedor, percComissao);
		
		this.centerInPage();
		
		this.show();
		
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				setCanFocus(true);
				focus();
			}
		};
		timer.schedule(60);

		
		HowMGWTPlugInStruts SVD0007 = new HowMGWTPlugInStruts(new com.br.client.model.sv.svd0010.FormBean()) {					
			@Override
			public void onResponse(HowMGWTFormBean formBean) { 
			}
		};		
		SVD0007.request("svd0007.do?method=gravarComissoes",  "SVD0007Form", "");		
		
		
		
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new com.br.client.model.sv.svd0010.FormBean()) {					
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				com.br.client.model.sv.svd0010.FormBean bean = (com.br.client.model.sv.svd0010.FormBean)formBean;
				if ( bean.getExcecoes() != null ){
					RecordList records = new RecordList();
					HowMGWTDataRecord record;
					for ( ePlanoServicoComissaoExcecao excecao : bean.getExcecoes() ){
						 record = new HowMGWTDataRecord();
						 record.setAttribute(painelLista.fieldParcela.getName(), HowMGWTUtilities.getInteger(excecao.getCodParcelaPagto() ));
						 record.setAttribute(painelLista.fieldPercComissao.getName(), HowMGWTUtilities.getDouble(excecao.getPercComissao() ));
						 record.setAttribute(painelLista.fieldDelete.getName(), " " );
						 
						 painelLista.setRecordModeQuery(record);
						 painelLista.setCellCanEditUpdateMode(record, painelLista.fieldPercComissao.getName(), true);
						 
						 records.add(record);
					}
					painelLista.setData(records);
				}
			}
		};
		String param = "";
		param += "&codEmpresa="+codEmpresa;
		param += "&tpOwner="+tpOwner;
		param += "&codPlano="+codPlano;
		
		struts.request("svd0010.do?method=buscar"+param,  "SVD0010Form", "");		
	}
	
	@Override
	protected void onHowMGWTClose() {		
		this.setNativeUnoGWTClose(parentJavaScriptObject, ""+this.painelLista.getRecords().length);
	}
	

	/**
	 * @return Retorna o endereço absoluto do contexto onde serão executados os serviços de donwload
	 * GWT.
	 */
	public static native void setNativeUnoGWTClose( JavaScriptObject object, String excecoes) /*-{
	   object.closeSVD0010(excecoes);	 
	}-*/;	
}
