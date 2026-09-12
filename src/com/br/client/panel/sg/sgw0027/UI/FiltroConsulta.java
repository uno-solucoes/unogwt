package com.br.client.panel.sg.sgw0027.UI;

import com.br.client.model.vd.vdw0035.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.UI.UCFieldLookupBuscaCliente;
import com.howmake.client.HowMProxyServiceAsync;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class FiltroConsulta  extends VLayout{ 

	// private LookupBuscaCliente lookupBuscaCliente = new LookupBuscaCliente();

	private HowMProxyServiceAsync proxy;

	private DateItem  fieldPeriodoInicial = new DateItem("dataInicio", Tradutor.i18n.periodoInicial());
	private DateItem  fieldPeriodoFinal   = new DateItem("dataFim"   , Tradutor.i18n.periodoFinal());
  
    private IButton actionBuscar   			= new IButton(Tradutor.i18n.buscar());  
  

    
    private CheckboxItem fieldNaoEnviados = new CheckboxItem("naoEnviado",Tradutor.i18n.formNaoEnviado());  

    private UCFieldLookupBuscaCliente fieldCodigoCliente = new UCFieldLookupBuscaCliente();  
   
    public FiltroConsulta(){
    	initUI();
    }
    
    public void initUI(){
 
    	actionBuscar.setIcon("actions/search.png");
    	    	
    	fieldPeriodoInicial.setTitle(Tradutor.i18n.periodoInicial());
    	
    	fieldPeriodoFinal.setTitle(Tradutor.i18n.periodoFinal());    	
    	
    	
    	DynamicForm fDataInicial = new DynamicForm();
    	fDataInicial.setWidth("300px");
    	fDataInicial.setItems(fieldPeriodoInicial);
    	
    	DynamicForm fDataFinal = new DynamicForm();
    	fDataFinal.setWidth("300px");
    	fDataFinal.setItems(fieldPeriodoFinal);
    	
    	actionBuscar.setWidth("100px");
    	
    	HLayout layoutDatas = new HLayout();
    	layoutDatas.setWidth100();
    	
    	layoutDatas.addMember(fDataInicial);
    	layoutDatas.addMember(fDataFinal);
    	layoutDatas.addMember(actionBuscar);
    	
 
    	
    	this.addMember(layoutDatas);

    	
    	HLayout layoutSelectCliente = new HLayout();
    	layoutSelectCliente.setWidth100();
    	
    	
//    	PickerIcon buscarCliente = new PickerIcon(PickerIcon.SEARCH, new FormItemClickHandler(){  
//            public void onFormItemClick(FormItemIconClickEvent event) {  
//                // SC.say("Consultar o Cliente");  
//            	
//            	lookupBuscaCliente.show();
//            }  
//        });
    	
    	fieldCodigoCliente.setWidth100();
    	// fieldCodigoCliente.getField().getField().setIcons(buscarCliente);
    	
    	layoutSelectCliente.addMember(fieldCodigoCliente);
       	this.addMember(layoutSelectCliente);


       	HLayout layoutNaoEnviados = new HLayout();
    	layoutNaoEnviados.setWidth100();
    	
    	DynamicForm fNaoEnviados = new DynamicForm();
    	fNaoEnviados.setWidth100();
    	fNaoEnviados.setItems(fieldNaoEnviados);
    	fieldNaoEnviados.setValue(false);
        
    	layoutNaoEnviados.addMember(fNaoEnviados);
    	this.addMember(layoutNaoEnviados);
    	
//    	this.lookupBuscaCliente.addHowMLinkField(
//    			new HowMLinkField(
//    					this.lookupBuscaCliente.getResultadoResultado().getFieldCodigo(), 
//    					this.fieldCodigoCliente.getField()
//    			)
//    	);
//    	
//    	this.lookupBuscaCliente.addHowMLinkField(
//    			new HowMLinkField(
//    					this.lookupBuscaCliente.getResultadoResultado().getNomeCliente(), 
//    					this.fieldCodigoCliente.getMessageLabel()
//    			)
//    	);
    	
    	
    	HTMLPane paneHelp = new HTMLPane();
    	paneHelp.setWidth100();
    	paneHelp.setHeight(30);
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setBorder(Tradutor.i18n.msgBorder());
     	paneHelp.setContents(Tradutor.i18n.msgLookupHelp());    	
    	this.addMember(paneHelp);
    	
 
    }

	/** 
	 * @return the periodoInicial
	 */
	public DateItem getFieldPeriodoInicial() {
		return fieldPeriodoInicial;
	}

	/**
	 * @param periodoInicial the periodoInicial to set
	 */
	public void setFieldPeriodoInicial(DateItem periodoInicial) {
		this.fieldPeriodoInicial = periodoInicial;
	}

	/**
	 * @return the periodoFinal
	 */
	public DateItem getFieldPeriodoFinal() {
		return fieldPeriodoFinal;
	}

	/**
	 * @param periodoFinal the periodoFinal to set
	 */
	public void setFieldPeriodoFinal(DateItem periodoFinal) {
		this.fieldPeriodoFinal = periodoFinal;
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
	

	/**
	 * @return the onNaoEnviados
	 */
	public CheckboxItem getFieldNaoEnviados() {
		return fieldNaoEnviados;
	}

	/**
	 * @param onNaoEnviados the onNaoEnviados to set
	 */
	public void setOnNaoEnviados(CheckboxItem onNaoEnviados) {
		this.fieldNaoEnviados = onNaoEnviados;
	}

	/**
	 * @return the fieldCodigoCliente
	 */
	public UCFieldLookupBuscaCliente getFieldCodigoCliente() {
		return fieldCodigoCliente;
	}

	/**
	 * @param fieldCodigoCliente the fieldCodigoCliente to set
	 */
	public void setFieldCodigoCliente(UCFieldLookupBuscaCliente fieldCodigoCliente) {
		this.fieldCodigoCliente = fieldCodigoCliente;
	} 
	
	
	public void exportarNFSEContador(){

		 HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				FormBean form = (FormBean)formBean;
				
				HowMGWTUtilities.downloadFile(form.getPathName(), form.getFileName());
			
			}
		};
		
		FormBean bean = new FormBean();
		bean.setDtInicio(HowMGWTUtilities.getFormatDateDBStart(fieldPeriodoInicial.getValueAsDate()));
		bean.setDtFim(HowMGWTUtilities.getFormatDateDBStart(fieldPeriodoFinal.getValueAsDate()));
		
		bean.setCodEmpresa( "7" );
		
		struts.request("vdw0035.do?method=findNFSE",  "VDW0035Form", bean.toSendBody("") );

	
	}
	
}
