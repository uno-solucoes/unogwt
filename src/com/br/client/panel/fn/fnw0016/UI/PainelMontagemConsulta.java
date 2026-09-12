package com.br.client.panel.fn.fnw0016.UI;

import java.util.LinkedHashMap;
import java.util.TreeMap;

import com.br.client.model.fn.entity.excel.eHowMCell;
import com.br.client.model.fn.entity.excel.eHowMRow;
import com.br.client.model.fn.entity.excel.eHowMWorksheet;
import com.br.client.model.fn.fnw0016.custom.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTLabel;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.MultipleAppearance;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelMontagemConsulta extends VLayout{

	private PainelResult painelResult;
	private TreeMap<String, HowMGWTProperty> mapFieldsDatas = new TreeMap<String, HowMGWTProperty>();
	private HLayout mainFiltroDatas  = new HLayout();
	private HLayout mainFiltroDatas2 = new HLayout();
	private HLayout mainToolsFiltroDatas = new HLayout();
	private HowMGWTProperty propertyExclusaoContas = new HowMGWTProperty("exclusaoContas", Tradutor.i18n.formExclusoesContas());
	private HowMGWTProperty propertyImpostos	   = new HowMGWTProperty("impostos", "Impostos");
	private HowMGWTProperty propertyTpRegime	   = new HowMGWTProperty("tpRegime", "Considerar despesas por regime");
		
	private ImgButton actionAdicionarComparacao = new ImgButton();
	private ImgButton actionExcluirComparacao = new ImgButton();
	
	public PainelMontagemConsulta(){	
		
		this.addMember(	HowMGWTUtilities.getCanvasHorizontalSeparetor(4, ""));


		mainToolsFiltroDatas.setAutoWidth();
		mainToolsFiltroDatas.setAutoHeight();
		
		VLayout mainAllFiltroDatas = new VLayout();
		mainAllFiltroDatas.setWidth100();
		mainAllFiltroDatas.setAutoHeight();

		mainFiltroDatas.setAutoWidth();
		mainFiltroDatas.setHeight(22);

		mainFiltroDatas2.setAutoWidth();
		mainFiltroDatas2.setHeight(22);
 
		 
		HowMGWTProperty propertyMesBase = createComponenteDate("mesBase", Tradutor.i18n.formMesBase(), false, 105);
		mapFieldsDatas.put("mesBase", propertyMesBase);
		propertyMesBase.setOderList(0);
		mainFiltroDatas.addMember(propertyMesBase.getCanvas());
		
		propertyMesBase.getHowMGWTEditorDateItem().getField().getDaySelector().setVisible(false);
		propertyMesBase.getHowMGWTEditorDateItem().getField().getDaySelector().setWidth(1);


		actionAdicionarComparacao.setSrc("actions/add.png");
		actionAdicionarComparacao.setIconHeight(16);
		actionAdicionarComparacao.setIconWidth(16);
		actionAdicionarComparacao.setPrompt(Tradutor.i18n.formAdicionarMesParaComparacao());
		actionAdicionarComparacao.setWidth(22);
		actionAdicionarComparacao.setHeight(22);
		actionAdicionarComparacao.setShowRollOver(false);  
		actionAdicionarComparacao.setShowDown(false);  	
		actionAdicionarComparacao.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
					HowMGWTProperty propertyMesBase = createComponenteDate("mesComp"+mapFieldsDatas.size(), Tradutor.i18n.formMesCompraracao(), true, 105);
		    		mapFieldsDatas.put("mesComp"+mapFieldsDatas.size(), propertyMesBase);
		    		propertyMesBase.setOderList(mapFieldsDatas.size());
		    		
		    		if ( mapFieldsDatas.size() < 4){
		    			mainFiltroDatas.addMember(propertyMesBase.getCanvas());
		    			mainFiltroDatas2.setVisible(false);
						mainToolsFiltroDatas.setHeight(22);

		    		}
		    		else if ( mapFieldsDatas.size() < 7){
		    			mainFiltroDatas2.addMember(propertyMesBase.getCanvas());
		    			mainFiltroDatas2.setVisible(true);
						mainToolsFiltroDatas.setHeight(50);

		    		}
		    		refreshDatas();
		    		if ( mapFieldsDatas.size() > 1)
		    			actionExcluirComparacao.setVisible(true);
		    		else
		    			actionExcluirComparacao.setVisible(false);
		    		if ( mapFieldsDatas.size() == 6 )
		        		actionAdicionarComparacao.setVisible(false);
		    		
		    		propertyMesBase.getHowMGWTEditorDateItem().getField().getDaySelector().setVisible(false);
		    		propertyMesBase.getHowMGWTEditorDateItem().getField().getDaySelector().setWidth(1);

			}
		});
		
		
		actionExcluirComparacao.setSrc("actions/remove.png");
		actionExcluirComparacao.setIconHeight(16);
		actionExcluirComparacao.setIconWidth(16);
		actionExcluirComparacao.setPrompt(Tradutor.i18n.formAdicionarMesParaComparacao());
		actionExcluirComparacao.setWidth(22);
		actionExcluirComparacao.setHeight(22);
		actionExcluirComparacao.setShowRollOver(false);  
		actionExcluirComparacao.setShowDown(false);  	
		actionExcluirComparacao.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {				
				Object[] keys = mapFieldsDatas.keySet().toArray();
				HowMGWTProperty lastProp = null;
				for ( Object key : keys ){
					lastProp = mapFieldsDatas.get(key);					
				}
				if ( lastProp != null ){					
					if( mapFieldsDatas.size() < 4){
						mainFiltroDatas.removeMember(lastProp.getCanvas());
					}
					else if( mapFieldsDatas.size() < 7 ){
						mainFiltroDatas2.removeMember(lastProp.getCanvas());
						mainFiltroDatas2.setVisible(true);
						mainToolsFiltroDatas.setHeight(50);
					}
					
					mapFieldsDatas.remove(lastProp.getName());
					if( mapFieldsDatas.size() < 4){
						mainFiltroDatas2.setVisible(false);
						mainToolsFiltroDatas.setHeight(22);
					}
					
		    		if ( mapFieldsDatas.size() > 1 )
		    			actionExcluirComparacao.setVisible(true);
		    		else
		    			actionExcluirComparacao.setVisible(false);
					refreshDatas();
				}
				if ( mapFieldsDatas.size() < 6)
					actionAdicionarComparacao.setVisible(true);
			}
		});		
		
		mainAllFiltroDatas.addMember(mainFiltroDatas);
		mainAllFiltroDatas.addMember(mainFiltroDatas2);

		mainFiltroDatas2.setVisible(false);
		
		mainToolsFiltroDatas.addMember(mainAllFiltroDatas);
		
		VLayout vTools = new VLayout();
		vTools.setAlign(VerticalAlignment.BOTTOM);
		vTools.setWidth(60);
		vTools.setHeight100();
		
			HLayout hLayout = new HLayout();
			hLayout.setWidth(60);
			hLayout.setHeight(22);
			
				hLayout.addMember(actionAdicionarComparacao);
				hLayout.addMember(actionExcluirComparacao);
			
		vTools.addMember(hLayout);
		
		mainToolsFiltroDatas.addMember(vTools);
		
		this.addMember(mainToolsFiltroDatas);
		
		actionExcluirComparacao.setVisible(false);

		this.addMember(	HowMGWTUtilities.getCanvasHorizontalSeparetor(4, ""));
		this.addMember(	HowMGWTUtilities.getCanvasHorizontalSeparetor(1, "blue"));

		HLayout vMainOther = new HLayout();
		vMainOther.setWidth100();
		vMainOther.setHeight(100);
		
		VLayout vExclusaoContas = new VLayout();
		vExclusaoContas.setWidth(584);
		vExclusaoContas.setHeight100();

		vExclusaoContas.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(6, ""));
		HowMGWTLabel labelInstrucoes = new HowMGWTLabel(Tradutor.i18n.msgInfExclusaoContas());		
		vExclusaoContas.addMember(HowMGWTUtilities.getCanvasLabelIndicator(22, labelInstrucoes));

		propertyExclusaoContas.setBound(112, 450);
		propertyExclusaoContas.createHowMGWTFormFieldAreaItem();
		vExclusaoContas.addMember(propertyExclusaoContas.getCanvas());

		propertyTpRegime.setBound(118, 180);
		propertyTpRegime.createHowMGWTFormFieldSelectItem();
		
		LinkedHashMap< String , String > mapTipoRegime = new LinkedHashMap<String, String>();
		mapTipoRegime.put("1", Tradutor.i18n.formDtVencimento());
		mapTipoRegime.put("2", Tradutor.i18n.formDtEmissao());
		mapTipoRegime.put("3", Tradutor.i18n.formDtBaixa());
		propertyTpRegime.getHowMGWTEditorSelectItem().getField().setValueMap(mapTipoRegime);
		propertyTpRegime.getHowMGWTEditorSelectItem().getField().setDefaultValues("1");
		
		// propertyImpostos.getHowMGWTEditorSelectItem();
		
		HLayout layoutImpostoTpRegime = new HLayout();
		layoutImpostoTpRegime.setWidth100();
		layoutImpostoTpRegime.setHeight(22);

		layoutImpostoTpRegime.addMember(propertyTpRegime.getCanvas());		

		
		propertyImpostos.setBound(80, 200);
		propertyImpostos.createHowMGWTFormFieldSelectItem();
		propertyImpostos.getHowMGWTEditorSelectItem().getField().setMultiple(true);  
		propertyImpostos.getHowMGWTEditorSelectItem().getField().setMultipleAppearance(MultipleAppearance.PICKLIST);  
		
		layoutImpostoTpRegime.addMember(propertyImpostos.getCanvas());		
		
		
		vExclusaoContas.addMember(layoutImpostoTpRegime);

		
		
		vMainOther.addMember(vExclusaoContas);
				
		vMainOther.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(1, "blue"));
		vMainOther.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(20, ""));

		/**
		 * Barra de ferramentas
		 */
		VLayout tools = new VLayout();
		tools.setWidth100();
		tools.setHeight100();

		tools.addMember( HowMGWTUtilities.getCanvasHorizontalSeparetor(4, ""));
		
		IButton actionBuscar = new IButton(Tradutor.i18n.buscar());
		actionBuscar.setWidth(130);
		actionBuscar.setHeight(24);
		actionBuscar.setIcon("actions/search.png"); 
		actionBuscar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				executarConsulta();
			}
		});
		
		tools.addMember(actionBuscar);
		
		tools.addMember( HowMGWTUtilities.getCanvasHorizontalSeparetor(4, ""));
		 
		IButton actionExportarExcel = new IButton(Tradutor.i18n.formExportarExcel());
		actionExportarExcel.setWidth(130);
		actionExportarExcel.setIcon("report/xls.png"); 
		actionExportarExcel.setHeight(24);
		actionExportarExcel.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				exportarExcel();
			}
		});
		tools.addMember( actionExportarExcel );

		tools.addMember( HowMGWTUtilities.getCanvasHorizontalSeparetor(4, ""));

//		IButton actionImprimir = new IButton(Tradutor.i18n.formImprimir());
//		actionImprimir.setWidth(130);
//		actionImprimir.setIcon("actions/print.png"); 
//		actionImprimir.setHeight(24);
//		actionImprimir.addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				onImprimirConsulta();
//			}
//		});
//		tools.addMember( actionImprimir );
		
		

		vMainOther.addMember(tools);

		
		this.addMember(vMainOther);
		
		preConfiguracao();
		
	}		

	public HowMGWTProperty createComponenteDate(String fieldName, String label, boolean canDelete , int labelWidth){
		HowMGWTProperty propertyMes = new HowMGWTProperty(fieldName, label);

		propertyMes.setBound(labelWidth, 100);
		propertyMes.createHowMGWTFormDateItem();				
		propertyMes.getHowMGWTEditorDateItem().getField().setAttribute("inputFormat", Tradutor.i18n.formInputFormatMesAno());
		propertyMes.getHowMGWTEditorDateItem().getField().addChangedHandler(new ChangedHandler() {			
			@Override
			public void onChanged(ChangedEvent event) {
				refreshDatas();
			}
		});
		return propertyMes;
	}
	
	
	/**
	 * Recupera as configurações iniciais.
	 */
	public void preConfiguracao(){
		HowMGWTWindowWait.showWait();
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {

				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true ) ){
					HowMGWTWindowWait.hideWait();
					return;
				}
				FormBean bean = (FormBean)formBean;
				
				configuracao(bean);
				
				
				HowMGWTWindowWait.hideWait();
			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
 
			}			
		};					 
 
		struts.request("fnw0016.do?method=preConfiguracao",  "FNW0016Form", formBean.getFormPost());						
	}
	

	/**
	 * Executa a consulta no servidor.
	 */
	public void executarConsulta(){
		HowMGWTWindowWait.showWait();
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {

				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true ) ){
					HowMGWTWindowWait.hideWait();
					return;
				}
				FormBean bean = (FormBean)formBean;

				onLoad((eHowMWorksheet)bean.getWorksheet());							 
				HowMGWTWindowWait.hideWait();
			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
 
			}			
		};					 
		
		String[] datas = new String[mapFieldsDatas.size()];
		Object[] keys  = mapFieldsDatas.keySet().toArray();

		HowMGWTProperty prop;
		int i = 0;
		for ( Object key : keys){
			prop = mapFieldsDatas.get(key);
			datas[i++] = HowMGWTUtilities.getFormatDateDB(prop.getHowMGWTEditorDateItem().getField().getValueAsDate());
		}
		String impostos = propertyImpostos.getHowMValue();
		if( HowMGWTUtilities.isEmpty(impostos))
			impostos = "";
		if ( ! impostos.trim().endsWith(",") )
			impostos += ",";
		System.out.println("Impostos "+impostos);
		
		String[] aImpostos = impostos.split(",");
		
		formBean.setExclusoesContas(propertyExclusaoContas.getHowMValue());
		formBean.setImpostos(aImpostos);
		formBean.setDatas(datas);	 
		formBean.setTpRegime(propertyTpRegime.getHowMValue());
		struts.request("fnw0016.do?method=buscar",  "FNW0016Form", formBean.getFormPost());						
	}

	
	/**
	 * Atualiza o layout conforme datas selecionadas.
	 */
	public void refreshDatas(){
		String[] datas = new String[mapFieldsDatas.size()];
		Object[] keys  = mapFieldsDatas.keySet().toArray();

		HowMGWTProperty prop;
		int i = 0;
		for ( Object key : keys){
			prop = mapFieldsDatas.get(key);
			datas[i++] = HowMGWTUtilities.getFormatDateDB(prop.getHowMGWTEditorDateItem().getField().getValueAsDate());
		}
		eHowMWorksheet worksheet = new eHowMWorksheet();
		eHowMRow row = new eHowMRow();
		row.setHeader("true");

		eHowMCell[] cells = new eHowMCell[1+(datas.length*2)];
		cells[0] = new eHowMCell();
		cells[0].setValue(Tradutor.i18n.formDescricao());
		
		i = 1;
		for( int c = 0; c < datas.length; c ++ ){
			
			eHowMCell cell = new eHowMCell();
			int mes = HowMGWTUtilities.getDate(datas[c]).getMonth()+1;
			int ano = HowMGWTUtilities.getDate(datas[c]).getYear()+1900;
			
			cell.setValue(mes+"/"+ano);
			cells[i] = cell;
			i++;
			
			cell = new eHowMCell();
			cell.setValue("%");
			cells[i] = cell;
			i++;
		}
		row.setCells(cells);
		
		worksheet.setRows(new eHowMRow[]{row});		
		
		onLoad(worksheet);
	}
	
	
	public void onLoad(eHowMWorksheet worksheet){}
 

	public void configuracao(FormBean formBean){
 
		propertyImpostos.getHowMGWTEditorSelectItem().getField().setValueMap(FormBean.impostosLucroReal);
		
		if ( "1".equals(formBean.getIndSimplesNacional()) ){
			propertyImpostos.getHowMGWTEditorSelectItem().getField().setDefaultValues(FormBean.impostosSimplesNacional);
			propertyImpostos.getHowMGWTEditorSelectItem().getField().setValueMap(formBean.impostosSimplesNacional);
		}
		else  {
			if ( HowMGWTUtilities.getDouble(formBean.getImpostoLucroPresumido()) > 0  ){
				propertyImpostos.getHowMGWTEditorSelectItem().getField().setDefaultValues(FormBean.impostosLucroPresumido);
				propertyImpostos.getHowMGWTEditorSelectItem().getField().setValueMap(formBean.impostosLucroPresumido);
			}
			else{
				propertyImpostos.getHowMGWTEditorSelectItem().getField().setDefaultValues(FormBean.impostosLucroReal);
				propertyImpostos.getHowMGWTEditorSelectItem().getField().setValueMap(formBean.impostosLucroReal);				
			}
		}
		
		propertyExclusaoContas.getHowMGWTEditorTextAreaItem().setHowMValue(formBean.getExclusoesContas());
	}
	
	
	
	public void exportarExcel(){
		
		if ( this.painelResult == null || this.painelResult.getRecords().length == 0 ){
			SC.say(Tradutor.i18n.msgExecutePrimeiroUmaConsulta());
			return;
		}

		HowMGWTWindowWait.showWait();
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {

				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true ) ){
					HowMGWTWindowWait.hideWait();
					return;
				}
				FormBean bean = (FormBean)formBean;

				HowMGWTUtilities.downloadFile(bean.getPath(), bean.getFileName());
				
				HowMGWTWindowWait.hideWait();
			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
 
			}			
		};					 
 
		struts.request("fnw0016.do?method=exportarExcel",  "FNW0016Form", formBean.getFormPost());	
	}
	
	public void onImprimirConsulta(){}

	/**
	 * @return the painelResult
	 */
	public PainelResult getPainelResult() {
		return painelResult;
	}

	/**
	 * @param painelResult the painelResult to set
	 */
	public void setPainelResult(PainelResult painelResult) {
		this.painelResult = painelResult;
	}
}