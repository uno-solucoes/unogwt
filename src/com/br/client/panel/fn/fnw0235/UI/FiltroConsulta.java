package com.br.client.panel.fn.fnw0235.UI;

import java.util.Date;
import java.util.LinkedHashMap;

import com.br.client.configuracao.Configuracao;
import com.br.client.model.cd.entity.eEmpresa;
import com.br.client.model.fn.entity.eCentroCusto;
import com.br.client.model.fn.fnw0235.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.UI.UCFieldCentroCusto;
import com.br.client.panel.business.UI.UCFieldPlanoContas;
import com.br.client.panel.fn.fnw0235.model.OptionView;
import com.howmake.client.form.UI.HowMGWTCheckboxItem;
import com.howmake.client.form.UI.HowMGWTDateItem;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class FiltroConsulta extends VLayout{ 
		
	public static final String SHOW_GROUP_01 = "01";  // Atrasos
	public static final String SHOW_GROUP_02 = "02";  // mes Atual
	public static final String SHOW_GROUP_03 = "03";  // Pagos
	public static final String SHOW_GROUP_04 = "04";  // Previsões

	private LinkedHashMap<String, String> mapCentrosCustos = new LinkedHashMap<String, String>();
	
	private HLayout layoutDetalhaMesRef = new HLayout();
	private HowMGWTDateItem fieldDataInicio 	 = new HowMGWTDateItem("dataInicio" 		, Tradutor.i18n.periodoInicial());
	private HowMGWTDateItem fieldDataFim	   	 = new HowMGWTDateItem("dataFim"    		, Tradutor.i18n.periodoFinal());
	
	private HowMGWTDateItem fieldMesReferencia   	  = new HowMGWTDateItem("mesReferencia"     	 , Tradutor.i18n.mesDataCorte()); // Tradutor.i18n.mesDataCorteInicial()
//	private HowMGWTDateItem fieldMesReferenciaFinal   = new HowMGWTDateItem("mesReferenciaFinal"      , Tradutor.i18n.mesDataCorteFinal());
	
	
	private HowMGWTProperty propertyDetalhaMes   = new HowMGWTProperty("detalhaMes"			, Tradutor.i18n.detalhaMes());

	public HowMGWTProperty getPropertyDetalhaMes() {
		return propertyDetalhaMes;
	}

	private HowMGWTDateItem fieldDetalhaDataInicio 	= new HowMGWTDateItem("dataInicioRef" 	, Tradutor.i18n.inicio());
	private HowMGWTDateItem fieldDetalhaDataFim	   	= new HowMGWTDateItem("dataFimRef"    	, Tradutor.i18n.fim());	
	private UCFieldCentroCusto fieldCentroCusto  	= new UCFieldCentroCusto();
	private UCFieldPlanoContas fieldPlanoContas 	= new UCFieldPlanoContas();
	
	private IButton actionBuscar   			     	= new IButton(Tradutor.i18n.buscar()); 
	private IButton actionImprimir   			 	= new IButton(Tradutor.i18n.formImprimir()); 
	private IButton actionExportarExcel   		 	= new IButton(Tradutor.i18n.formExportarExcel());
	private IButton actionExportarPDF   		 	= new IButton(Tradutor.i18n.formExportarPDF());
	
	private HowMGWTProperty propertyShowResult		= new HowMGWTProperty("showResult", "Listar");
	
	private HowMGWTCheckboxItem fieldGrupo04 		= new HowMGWTCheckboxItem("listaGrupo04", Tradutor.i18n.formListarGrupo04());
	private HowMGWTCheckboxItem fieldListarTransferencias = new HowMGWTCheckboxItem("ListarTransferencias", Tradutor.i18n.formNaoListarTransferencias());
	private HowMGWTCheckboxItem fieldListarReceitas = new HowMGWTCheckboxItem("receitas", Tradutor.i18n.formListarReceitas());
	private HowMGWTCheckboxItem fieldListarDespesas = new HowMGWTCheckboxItem("despesas", Tradutor.i18n.formListarDespesas());	
	
	private HowMGWTProperty propertyEmpresas 		= new HowMGWTProperty("codEmpresa", "Cod Empresa");
	
	private HowMGWTProperty propertyTipoAgrup 		= new HowMGWTProperty("tpAgrupador", "Agrupar");
	
	private HowMGWTProperty propertyCCustoSubstring3= new HowMGWTProperty("ccustoSubstring3", "Agrupar pelos 3 primeiros caracteres?");
	
	public HowMGWTProperty getPropertyEmpresas() {
		return propertyEmpresas;
	}
 
	private HTMLPane paneHelp           	 		= new HTMLPane();

	private boolean showCentroCusto 				= true;
    
	public FiltroConsulta(boolean showCentroCusto){ 
		
		this.showCentroCusto = showCentroCusto;
		
		HLayout mainLayout = new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		
		VLayout filterLayout = new VLayout();
		filterLayout.setWidth(470);
		filterLayout.setHeight100();
		
		this.fieldDataInicio.getField().setUseMask(false);
		this.fieldDataInicio.getField().setUseTextField(false);
		this.fieldDataInicio.getField().setInputFormat("MM/YYYY");		
		
		this.fieldDataFim.getField().setInputFormat(Tradutor.i18n.formInputFormatMesAno());
		// this.fieldMesReferencia.getField().setInputFormat(Tradutor.i18n.formInputFormatMesAno());
		
		
		
		
		fieldDetalhaDataInicio.getField().setInputFormat(Tradutor.i18n.formInputFormatDiaMesAno());
		fieldDetalhaDataFim.getField().setInputFormat(Tradutor.i18n.formInputFormatDiaMesAno());

		propertyShowResult.setBound(100,200);
		propertyShowResult.createHowMFieldSelectItem();
		
		LinkedHashMap<String, String> mapShowResult = new LinkedHashMap<String, String>();
		mapShowResult.put(SHOW_GROUP_01, Tradutor.i18n.formListarGrupo01Atraso());
		// mapShowResult.put(SHOW_GROUP_02, Tradutor.i18n.formListarGrupo02Abrev());
		mapShowResult.put(SHOW_GROUP_03, Tradutor.i18n.formListarGrupo03Abrev());
		mapShowResult.put(SHOW_GROUP_04, Tradutor.i18n.formListarGrupo04Abrev());
		
		propertyShowResult.getHowMFieldSelectItemEditor().getField().setMultiple(true);		
		
		propertyShowResult.getHowMFieldSelectItemEditor().getField().setValueMap(mapShowResult);				
		
		propertyShowResult.setHowmFormValue(
			SHOW_GROUP_01+","+
			// SHOW_GROUP_02+","+
			SHOW_GROUP_03+","+
			SHOW_GROUP_04
		);		
		
		fieldGrupo04.setHowMValue(new Boolean(true));
		fieldListarTransferencias.setHowMValue(new Boolean(true));
		fieldListarReceitas.setHowMValue(new Boolean(true));
		fieldListarDespesas.setHowMValue(new Boolean(true));
		

		fieldListarTransferencias.setHowMValue(new Boolean(true));
		fieldListarReceitas.setHowMValue(new Boolean(true));
		fieldListarDespesas.setHowMValue(new Boolean(true));
	
    	paneHelp.setBorder(Tradutor.i18n.msgBorder());
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setContents(Tradutor.i18n.msgLookupHelp());
		
		HLayout hLayoutDatas = new HLayout();
		hLayoutDatas.setWidth100();
		hLayoutDatas.setHeight("26px");
	
		fieldDataInicio.setWidth("240px");
		fieldDataFim.setWidth("234px");
	
		hLayoutDatas.addMember(fieldDataInicio);
		hLayoutDatas.addMember(fieldDataFim);
				
		hLayoutDatas.addMember(this.fieldCentroCusto.getCreateField());
		
		hLayoutDatas.addMember(this.fieldPlanoContas.getCreateIButton());
		

		
		this.fieldDataInicio.getField().getDaySelector().setVisible(false);
		this.fieldDataInicio.getField().getDaySelector().setWidth(1);
		
		HLayout layoutSpace = new HLayout();
		layoutSpace.setWidth("30px");
		layoutSpace.setHeight("20px");
		hLayoutDatas.addMember(layoutSpace);
		
		filterLayout.addMember(hLayoutDatas);



		
		layoutDetalhaMesRef.setWidth(200);
		layoutDetalhaMesRef.setHeight(22);

		layoutDetalhaMesRef.addMember(fieldDetalhaDataInicio);
		layoutDetalhaMesRef.addMember(fieldDetalhaDataFim);
		
		fieldDetalhaDataInicio.getField().getMonthSelector().setVisible(false);
		fieldDetalhaDataInicio.getField().getYearSelector().setVisible(false);
		fieldDetalhaDataInicio.getField().setShowIcons(false);
		
		fieldDetalhaDataFim.getField().getMonthSelector().setVisible(false);
		fieldDetalhaDataFim.getField().getYearSelector().setVisible(false);
		fieldDetalhaDataFim.getField().setShowIcons(false);

		fieldDetalhaDataInicio.getField().setWidth(30);
		fieldDetalhaDataFim.getField().setWidth(30);
		
		fieldDetalhaDataInicio.getField().getMonthSelector().setWidth(1);
		fieldDetalhaDataInicio.getField().getYearSelector().setWidth(1);
		
		
		fieldDetalhaDataInicio.getField().redraw();
		fieldDetalhaDataFim.getField().redraw();
		
		HLayout layoutMesRef = new HLayout();
		layoutMesRef.setWidth100();
		layoutMesRef.setHeight(22);

		this.fieldMesReferencia.setWidth("230px");	
		this.fieldMesReferencia.getField().setUseMask(true);
		this.fieldMesReferencia.getField().setUseTextField(true);
		this.fieldMesReferencia.getField().setWidth(90);
		layoutMesRef.addMember(this.fieldMesReferencia);

//		this.fieldMesReferenciaFinal.setWidth("230px");
//		this.fieldMesReferenciaFinal.getField().setUseMask(true);
//		this.fieldMesReferenciaFinal.getField().setUseTextField(true);
//		this.fieldMesReferenciaFinal.getField().setWidth(90);
		// layoutMesRef.addMember(this.fieldMesReferenciaFinal);
		
		propertyCCustoSubstring3.setBound(30,190);		
		propertyCCustoSubstring3.createHowMFieldCheckboxItem();
		
		if( showCentroCusto ){
			layoutMesRef.addMember(propertyCCustoSubstring3.getCanvas());
		}

		
		// Remove o dia da data 
		this.fieldDataInicio.getField().getDaySelector().setVisible(false);
		this.fieldDataFim.getField().getDaySelector().setVisible(false);
		// this.fieldMesReferencia.getField().getDaySelector().setVisible(false);
		
		
		this.fieldDataInicio.getField().getDaySelector().setWidth(1);
		this.fieldDataFim.getField().getDaySelector().setWidth(1);
		// this.fieldMesReferencia.getField().getDaySelector().setWidth(1);
		
		propertyDetalhaMes.setBound(20, 80);
		propertyDetalhaMes.createHowMGWTCheckboxItem();
		propertyDetalhaMes.getHowMGWTCheckboxItem().getField().addChangedHandler(new ChangedHandler() {			
			@Override
			public void onChanged(ChangedEvent event) {
				if( HowMGWTUtilities.getBoolean( event.getValue() ) ){
					layoutDetalhaMesRef.setVisible(true);
				}
				else{
					layoutDetalhaMesRef.setVisible(false);
				}
				layoutDetalhaMesRef.redraw();
			}
		});
		
		
		// Comentado a pedido do Marcio em 29/08/2014 - em função da inclusão do campo
		// data de corte final.
		layoutMesRef.addMember(propertyDetalhaMes.getCanvas());
		
		
		layoutMesRef.addMember(layoutDetalhaMesRef);
		layoutDetalhaMesRef.setVisible(false);
		

		filterLayout.addMember(layoutMesRef);


		HLayout hLayoutChecks = new HLayout();
		hLayoutDatas.setWidth100();
		hLayoutDatas.setHeight("26px");		

		fieldListarTransferencias.setWidth("200px");
		
		if( showCentroCusto ){
			hLayoutChecks.addMember(propertyShowResult.getCanvas());  // fieldGrupo04
		}
		else{
			fieldGrupo04.setWidth("100px");
			fieldGrupo04.setHeight("100px");
			hLayoutChecks.addMember(fieldGrupo04);
		}
		hLayoutChecks.addMember(fieldListarTransferencias);
		hLayoutChecks.addMember(fieldListarReceitas);
		hLayoutChecks.addMember(fieldListarDespesas);
		
		// -------------------------------------------------------------------------
		// Carrega as empresas ativas para a lista de empresas,
		// só mostra a lista na tela caso o corpo seja Multi-Empresa 
		// -------------------------------------------------------------------------
		propertyEmpresas.setBound(100, 260);		
		propertyEmpresas.createHowMGWTFormFieldSelectItem();		
		if( "Multi-Empresa".equals(Configuracao.getUnoCorpoGWT() )){
			hLayoutChecks.addMember( propertyEmpresas.getCanvas() );
			propertyEmpresas.getHowMGWTEditorSelectItem().getField().setMultiple(true);
			propertyEmpresas.getHowMGWTEditorSelectItem().getField().setMultipleValueSeparator(",");			
			
		}
		loadEmpresas();
		
		
		propertyTipoAgrup.setBound(70, 100);
		propertyTipoAgrup.createHowMFieldSelectItem();

		//	hLayoutChecks.addMember(propertyTipoAgrup.getCanvas());

		LinkedHashMap<String , String > optionTipoAgrup = new LinkedHashMap<String , String >();
		optionTipoAgrup.put("1", Tradutor.i18n.formMesRef());
		optionTipoAgrup.put("2", "C.Custo");
		
		propertyTipoAgrup.getHowMFieldSelectItemEditor().getField().setValueMap(optionTipoAgrup);
		if( showCentroCusto ){
			propertyTipoAgrup.setHowmFormValue("2");
			onSetCallCentroCusto(true);
		}
		else{
			propertyTipoAgrup.setHowmFormValue("1");
			onSetCallCentroCusto(false);
		}
		propertyTipoAgrup.getHowMFieldSelectItemEditor().getField().addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if( "1".equals( propertyTipoAgrup.getHowmFormValue() ) ){
					onSetCallCentroCusto(false);
				}
				else{
					onSetCallCentroCusto(true);
				}				
			}
		});
		
		filterLayout.addMember(hLayoutChecks);
    	paneHelp.setWidth100();
    	paneHelp.setHeight(40);
    	filterLayout.addMember(paneHelp);
    	
		Date now = new Date();
		Date dataInicio = new Date(now.getYear(), 0, 1);
		Date dataFim 	= new Date(now.getYear(), 11, 31);
		
		this.fieldDataInicio.setHowMValue(dataInicio);
		this.fieldDataFim.setHowMValue(dataFim);
		
		this.fieldMesReferencia.setHowMValue(now);		
//		this.fieldMesReferenciaFinal.setHowMValue(HowMGWTUtilities.getDateLastDay(now));
		
		
		
		this.fieldDetalhaDataInicio.setHowMValue(now);
		this.fieldDetalhaDataFim.setHowMValue(now);
		this.fieldMesReferencia.getField().addChangedHandler(new ChangedHandler() {			
			@Override
			public void onChanged(ChangedEvent event) {
				fieldDetalhaDataInicio.setHowMValue(fieldMesReferencia.getHowMValue());
				fieldDetalhaDataFim.setHowMValue(fieldMesReferencia.getHowMValue());
			}
		});
		
		
		
	
		mainLayout.addMember(filterLayout);

		VLayout layoutButtons = new VLayout();
		layoutButtons.setWidth100();
		layoutButtons.setHeight100();

		actionBuscar.setIcon("actions/search.png");    	
    	actionBuscar.setWidth("120px");
    	actionBuscar.setMargin(2);
    	actionBuscar.setHeight(26);
    	layoutButtons.addMember(actionBuscar);

    	actionExportarExcel.setIcon("report/xls.png");
    	actionExportarExcel.setWidth("120px");    	
    	actionExportarExcel.setMargin(2);
    	actionExportarExcel.setHeight(26);    	
    	layoutButtons.addMember(actionExportarExcel);

    	
    	actionImprimir.setIcon("actions/print.png");
    	actionImprimir.setWidth("120px");    	
    	actionImprimir.setMargin(2);
    	actionImprimir.setHeight(26);    	
    	// layoutButtons.addMember(actionImprimir);
	
    	actionExportarPDF.setIcon("report/pdf.png");
       	actionExportarPDF.setWidth("120px");    	
    	actionExportarPDF.setMargin(2);
    	actionExportarPDF.setHeight(26);    	
    	layoutButtons.addMember(actionExportarPDF);

    	mainLayout.addMember(layoutButtons);
    	this.addMember(mainLayout);
	}
 
	
	public HowMGWTDateItem getFieldDetalhaDataInicio() {
		return fieldDetalhaDataInicio;
	}

	public HowMGWTDateItem getFieldDetalhaDataFim() {
		return fieldDetalhaDataFim;
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
	 * @return the fieldDataInicio
	 */
	public HowMGWTDateItem getFieldDataInicio() {
		return fieldDataInicio;
	}

	/**
	 * @param fieldDataInicio the fieldDataInicio to set
	 */
	public void setFieldDataInicio(HowMGWTDateItem fieldDataInicio) {
		this.fieldDataInicio = fieldDataInicio;
	}

	/**
	 * @return the fieldDataFim
	 */
	public HowMGWTDateItem getFieldDataFim() {
		return fieldDataFim;
	}

	/**
	 * @param fieldDataFim the fieldDataFim to set
	 */
	public void setFieldDataFim(HowMGWTDateItem fieldDataFim) {
		this.fieldDataFim = fieldDataFim;
	}

	/**
	 * @return the fieldMesReferencia
	 */
	public HowMGWTDateItem getFieldMesReferencia() {
		return fieldMesReferencia;
	}

//	/**
//	 * @return the fieldMesReferenciaFinal
//	 */
//	public HowMGWTDateItem getFieldMesReferenciaFinal() {
//		return fieldMesReferenciaFinal;
//	}

	
//	/**
//	 * @return the fieldGrupo04
//	 */
//	public HowMGWTCheckboxItem getFieldGrupo04() {
//		return fieldGrupo04;
//	}
 
	/**
	 * @return the fieldNaoListarTransferencias
	 */
	public HowMGWTCheckboxItem getFieldNaoListarTransferencias() {
		return fieldListarTransferencias;
	}

	/**
	 * @param fieldNaoListarTransferencias the fieldNaoListarTransferencias to set
	 */
	public void setFieldNaoListarTransferencias(
			HowMGWTCheckboxItem fieldNaoListarTransferencias) {
		this.fieldListarTransferencias = fieldNaoListarTransferencias;
	}

	/**
	 * @return the fieldListarReceitas
	 */
	public HowMGWTCheckboxItem getFieldListarReceitas() {
		return fieldListarReceitas;
	}

	/**
	 * @return the fieldListarDespesas
	 */
	public HowMGWTCheckboxItem getFieldListarDespesas() {
		return fieldListarDespesas;
	}

	/**
	 * @return the fieldCentroCusto
	 */
	public UCFieldCentroCusto getFieldCentroCusto() {
		return fieldCentroCusto;
	}

	public UCFieldPlanoContas getFieldPlanoContas(){
		return fieldPlanoContas;
	}
	
	/**
	 * @return the actionImprimir
	 */
	public IButton getActionImprimir() {
		return actionImprimir;
	}

	/**
	 * @return the actionExportarExcel
	 */
	public IButton getActionExportarExcel() {
		return actionExportarExcel;
	}


	/**
	 * Carrega as empresas ativas para a lista de empresas do relatório financeiro.
	 */
	public void loadEmpresas(){

			HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {

				@Override
				public void onResponse(HowMGWTFormBean formBean) {

					if(HowMGWTControl.isRefreshFormShowMessage(formBean, false))
						return;

					FormBean bean = (FormBean)formBean;
					configureEmpresas(bean.getEntityEmpresas());
					
					
					if( bean.getEntityCentrosCustos() != null ){
						
						for( eCentroCusto cc : bean.getEntityCentrosCustos()){
							mapCentrosCustos.put(cc.getCentroCusto(), cc.getDescAbrev());
						}
						
					}
				}
			};

			FormBean formBean = new FormBean();

			if( "Multi-Empresa".equals(Configuracao.getUnoCorpoGWT() )){
				formBean.setCodEmpresa(null);
			}
			else{
				formBean.setCodEmpresa(Configuracao.getCodEmpresa());
			}

			struts.request("fnw0217.do?method=buscaEmpresas", "FNW0217Form", formBean.toSendBody(""));
	}	
	
	public void configureEmpresas(eEmpresa[] empresas){
		if( empresas == null ){
			this.propertyEmpresas.setHowmFormValue(Configuracao.getCodEmpresa());	
			return;
		}
		LinkedHashMap< String , String > mapEmpresas = new LinkedHashMap<String, String>();
		for ( eEmpresa empresa : empresas ){
			mapEmpresas.put(empresa.getCodEmpresa(), empresa.getRazaoSocial());
		}
		this.propertyEmpresas.getHowMGWTEditorSelectItem().getField().setValueMap(mapEmpresas);
		this.propertyEmpresas.setHowmFormValue(Configuracao.getCodEmpresa());
	}
	
	
	public void onSetCallCentroCusto(boolean callExecuteCentroCusto){
		
	}


	public IButton getActionExportarPDF() {
		return actionExportarPDF;
	}


	public HowMGWTProperty getPropertyShowResult() {
		return propertyShowResult;
	}
	
	public OptionView getOptionView(){

		OptionView optionView = new OptionView();
		// Se não for impressão por centro de custo, então utiliza o checkbox como padrão de 
		// seleção das previsões e do resto das opções de visulaização.
		if( ! showCentroCusto ){
			
			optionView.setShowAtrasos(true);
			optionView.setShowMesAtual(false);
			optionView.setShowPagos(true);
			optionView.setShowPrevisoes(HowMGWTUtilities.getBoolean(this.fieldGrupo04.getHowMValue()));

			
			return optionView;
		}
		
		String value = this.getPropertyShowResult().getHowmFormValueToString();
		String[] values = value.split(",");
		for(String option : values ){
			if( SHOW_GROUP_01.equalsIgnoreCase(option)){
				optionView.setShowAtrasos(true);
			}
			if( SHOW_GROUP_02.equalsIgnoreCase(option)){
				optionView.setShowMesAtual(true);
			}
			if( SHOW_GROUP_03.equalsIgnoreCase(option)){
				optionView.setShowPagos(true);
			}
			if( SHOW_GROUP_04.equalsIgnoreCase(option)){
				optionView.setShowPrevisoes(true);
			}
		}
		return optionView;
	}


	public String getDescCentroCusto(String centroCusto){
		
		if( HowMGWTUtilities.getBoolean( propertyCCustoSubstring3.getHowmFormValue() ) ){
			return centroCusto;
		}
		
		if( centroCusto == null ){
			return centroCusto;
		}

		String descCentroCusto = this.mapCentrosCustos.get(centroCusto);

		if( descCentroCusto != null ){
			return descCentroCusto;
		}
		else{
			return centroCusto;
		}
	}


	public HowMGWTProperty getPropertyCCustoSubstring3() {
		return propertyCCustoSubstring3;
	}
	
	
	public boolean isValidPeriodo(){
		if( HowMGWTUtilities.isMaior(HowMGWTUtilities.getDate(fieldDataInicio.getHowMValue()), HowMGWTUtilities.getDate(fieldMesReferencia.getHowMValue()))){
			SC.say("<b>Data Corte </b> deve ser maior ou igual a <b>ao periodo inicial</b> !");
			return  false;
		}

		if( HowMGWTUtilities.isMaior(HowMGWTUtilities.getDate(fieldMesReferencia.getHowMValue()), HowMGWTUtilities.getDate(fieldDataFim.getHowMValue()))){
			SC.say("<b>Data Corte </b> deve ser menor ou igual a <b>ao periodo final</b> !");
			return  false;
		}
				
		return true;
	}
}