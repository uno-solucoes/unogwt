package com.br.client.panel.ed.edw0003.UI;

import java.util.LinkedHashMap;
import java.util.TreeMap;

import com.br.client.configuracao.Configuracao;
import com.br.client.model.ed.edw0003.FormBean;
import com.br.client.model.ed.entity.eEDILayout;
import com.br.client.model.ed.entity.eEDILayoutField;
import com.br.client.model.ed.entity.eEDIPageCode;
import com.br.client.model.ed.entity.eEDIRecord;
import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTFormToolbarEdit;
import com.howmake.client.form.UI.HowMGWTUploadDialog;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.control.HowMGWTControlForm;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

public class PainelLayoutControle extends VLayout implements HowMGWTControlForm{
	
	private eEDILayout currentLayout;
	
	private String defaultPathTemp;
	
	private IButton actionUploadFile = new IButton("Selecionar Arquivo ");	
	private IButton actionGravar 	 = new IButton(Tradutor.i18n.formGravar());	
	
	private HowMGWTUploadDialog windowUploadDialog;
	
	private HowMGWTFormProperties propertiesLayout = new HowMGWTFormProperties();
	
	private TreeMap<String, eEDILayout> mapLayouts = new TreeMap<String, eEDILayout>();
	private LinkedHashMap<String, String> mapPages = new LinkedHashMap<String, String>();


	private HowMGWTProperty propertyFileName 					= propertiesLayout.createProperty("fileName", 					"Arquivo Selecionado" );
	
	private HowMGWTProperty propertyLayouts 					= propertiesLayout.createProperty("layoutName", 				Tradutor.i18n.formLayout());
	private HowMGWTProperty propertyDelimitador 				= propertiesLayout.createProperty("delimitador", 				Tradutor.i18n.formDelimitador());
	private HowMGWTProperty propertyLinhaInicio					= propertiesLayout.createProperty("linhaInicio", 				Tradutor.i18n.formLinhaInicio());
	
	private HowMGWTProperty propertyPageCode 					= propertiesLayout.createProperty("pageCode", 					Tradutor.i18n.formPaginaCodigo());
	
	private HowMGWTProperty propertyFormato						= propertiesLayout.createProperty("formatoArquivo", 			Tradutor.i18n.formFormatoArquivo());
	private HowMGWTProperty propertyAcao						= propertiesLayout.createProperty("acao", 						Tradutor.i18n.formAcao());

	private HowMGWTProperty propertyColumnPrimaryKey			= propertiesLayout.createProperty("primaryKey", "Chave");
	private HowMGWTProperty propertyColumnName					= propertiesLayout.createProperty("name", 		"Nome Campo");
	private HowMGWTProperty propertyColumnLabel					= propertiesLayout.createProperty("label", 		"Campo");
	private HowMGWTProperty propertyColumnType					= propertiesLayout.createProperty("type", 		"Tipo Dado");
	private HowMGWTProperty propertyColumnLength				= propertiesLayout.createProperty("length", 	"Tamanho");
	private HowMGWTProperty propertyColumnDecimal				= propertiesLayout.createProperty("decimals", 	"Decimais");
	private HowMGWTProperty propertyColumnMandatory				= propertiesLayout.createProperty("mandatory", 	"Obrigatorio");
	private HowMGWTProperty propertyColumnMask					= propertiesLayout.createProperty("mask", 		"Mascara");	
	
	private PanelLayoutLoader panelLayoutLoader;
	
    private TabSet tabSet = new TabSet();  
	
	HowMGWTFormToolbarEdit formToolbarEdit;
	
	public PainelLayoutControle(){
	
		this.setWidth100();
		// this.setHeight(100);
		this.setHeight100();
		
		int widthLabel = 120;
				
		actionUploadFile.setIcon("actions/ico_add_file.png");
		actionUploadFile.setHeight(22);
		actionUploadFile.setWidth(140);
		actionUploadFile.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				uploadFile();
			}
		});
		
		actionGravar.setIcon("actions/save.png");
		actionGravar.setHeight(22);
		actionGravar.setWidth(140);
		actionGravar.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				gravarDados();
			}
		});
		
		propertyLayouts.setMandatory(true);
		propertyDelimitador.setMandatory(true);
		propertyLinhaInicio.setMandatory(true);
		propertyPageCode.setMandatory(false);
		propertyFormato.setMandatory(true);
		propertyAcao.setMandatory(true);
		
		propertyLinhaInicio.setType(ListGridFieldType.INTEGER);
		
		propertyLayouts.setBound(widthLabel, 200);
		propertyPageCode.setBound(widthLabel, 200);
		propertyDelimitador.setBound(widthLabel, 30);
		propertyLinhaInicio.setBound(widthLabel, 30);
	
		propertyFormato.setBound(widthLabel, 240);
		propertyAcao.setBound(widthLabel, 150);

		propertyLayouts.createHowMGWTFormFieldSelectItem();
		propertyPageCode.createHowMGWTFormFieldSelectItem();
		
		propertyDelimitador.createHowMGWTFormFieldTextItem();
		propertyLinhaInicio.createHowMGWTFormFieldTextItem();
		propertyFormato.createHowMGWTFormFieldSelectItem();
		
		propertyDelimitador.getHowMGWTEditorFieldText().setDisabled(true);
		propertyLinhaInicio.getHowMGWTEditorFieldText().setDisabled(true);

		propertyAcao.createHowMGWTFormFieldSelectItem();	

		LinkedHashMap formatos = new LinkedHashMap<String, String>();
		formatos.put("", "");
		formatos.put("csv"	,  "Arquivo CSV");		

		LinkedHashMap acao 	   = new LinkedHashMap<String, String>();
		acao.put("", "");
		acao.put("I"	,  Tradutor.i18n.formImportacao());

		this.propertyFormato.getHowMGWTEditorSelectItem().getField().setDefaultValue("");
		this.propertyFormato.getHowMGWTEditorSelectItem().getField().setValueMap(formatos);
		
		this.propertyAcao.getHowMGWTEditorSelectItem().getField().setDefaultValue("");
		this.propertyAcao.getHowMGWTEditorSelectItem().getField().setValueMap(acao);
		
		
		HLayout mainLayoutForm = new HLayout();
		mainLayoutForm.setWidth100();
		mainLayoutForm.setHeight(140);
		
		VLayout configuraLayout = new VLayout();
		configuraLayout.setHeight100();
		configuraLayout.setWidth(300);		
		
		configuraLayout.addMember(propertyLayouts.getCanvas());
		
		
		HLayout hlayout = new HLayout();
		hlayout.setWidth100();
		hlayout.setHeight(24);
		
		hlayout.addMember(propertyDelimitador.getCanvas());
		hlayout.addMember(propertyLinhaInicio.getCanvas());
		
		configuraLayout.addMember(hlayout);
				
		configuraLayout.addMember(propertyPageCode.getCanvas());			
		configuraLayout.addMember(propertyFormato.getCanvas());
		configuraLayout.addMember(propertyAcao.getCanvas());

		propertyLayouts.getHowMGWTEditorSelectItem().getField().addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				String tableName = propertyLayouts.getHowMValue();
				selectTable(tableName);
			}
		});

		propertyAcao.getHowMGWTEditorSelectItem().getField().addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				selectAcao(propertyAcao.getHowMValue());
			}
		});
		
		
		mainLayoutForm.addMember(configuraLayout);
		
		VLayout sep = new VLayout();
		sep.setWidth(1);
		sep.setHeight100();
		sep.setBackgroundColor(Tradutor.i18n.sepColor());
		mainLayoutForm.addMember(sep);

		VLayout sep1 = new VLayout();
		sep1.setWidth(5);
		sep1.setHeight100();
		mainLayoutForm.addMember(sep1);
		
		VLayout vLayoutUpload = new VLayout();
		vLayoutUpload.setWidth(300);
		vLayoutUpload.setHeight100();

		vLayoutUpload.addMember(actionUploadFile);
		vLayoutUpload.addMember(actionGravar);
		
		actionUploadFile.setVisible(false);
		actionGravar.setVisible(false);
		
		mainLayoutForm.addMember(vLayoutUpload);
		
		
		VLayout sepTop = new VLayout();
		sepTop.setHeight(5);
		sepTop.setWidth100();
		this.addMember(sepTop);
		this.addMember(mainLayoutForm);


		createGrid();
		
		this.loadLayouts();
	
	}
	
	public void createGrid(){
		propertyColumnPrimaryKey.setWidthColumn(40);
		propertyColumnName.setWidthColumn(140);
		propertyColumnLabel.setWidthColumn(240);
		propertyColumnType.setWidthColumn(80);
		propertyColumnLength.setWidthColumn(60);
		propertyColumnDecimal.setWidthColumn(60);
		propertyColumnMandatory.setWidthColumn(60);
		propertyColumnMask.setWidthColumn(140);
		
		propertyColumnPrimaryKey.setType(ListGridFieldType.BOOLEAN);
		// record.setAttribute(propertyColumnName.getName(), field.getName());
		// record.setAttribute(propertyColumnLabel.getName(), field.getLabel());
		// record.setAttribute(propertyColumnType.getName(), field.getType());
		propertyColumnLength.setType(ListGridFieldType.INTEGER);
		propertyColumnDecimal.setType(ListGridFieldType.INTEGER);
		propertyColumnMandatory.setType(ListGridFieldType.BOOLEAN);
		// record.setAttribute(propertyColumnMask.getName(), field.getMask());		
		
		propertyColumnPrimaryKey.createHowMGWTListGridField();
		propertyColumnName.createHowMGWTListGridField();
		propertyColumnLabel.createHowMGWTListGridField();
		propertyColumnType.createHowMGWTListGridField();
		propertyColumnLength.createHowMGWTListGridField();
		propertyColumnDecimal.createHowMGWTListGridField();
		propertyColumnMandatory.createHowMGWTListGridField();
		propertyColumnMask.createHowMGWTListGridField();


		/** 
		 * Desliga os recursos de organização do layout para 
		 * evitar problemas na carga.
		 */
		for (HowMGWTProperty prop : propertiesLayout.getProperties()){
			if ( prop.getListField() != null ){
				prop.getListField().setCanDragResize(false);
				prop.getListField().setCanFreeze(false);
				prop.getListField().setCanGroupBy(false);
				prop.getListField().setCanHide(false);
				prop.getListField().setCanReorder(false);
				prop.getListField().setCanSort(false);
			}
		}
		
		
		formToolbarEdit = new HowMGWTFormToolbarEdit(this);
		
		formToolbarEdit.getPanelList().setCanAutoFitFields(false);
		
		this.formToolbarEdit.getPanelList().setWidth100();
		this.formToolbarEdit.getPanelList().setHeight100();
		
	    tabSet.setTabBarPosition(Side.TOP);  
	    tabSet.setTabBarThickness(32);
	    tabSet.setWidth100();  
	    tabSet.setHeight100();  	
	    
        Tab tabLayout = new Tab("Layout", "tools/bot_table.png");
        tabLayout.setPane(this.formToolbarEdit.getPanelList());
	    
        tabSet.addTab(tabLayout);
		
		this.addMember(tabSet);
		
//		formToolbarEdit.getPanelList().setEditorCustomizer(new ListGridEditorCustomizer() {  
//            public FormItem getEditor(ListGridEditorContext context) {  
//                ListGridField field = context.getEditField();  
//                if (field.getName().equals("value")) {  
//                    NameValueRecord record = (NameValueRecord) context.getEditedRecord();  
//                    int id = record.getID();  
//                    switch (id) {  
//                        case 1:  
//                            TextItem textItem = new TextItem();  
//                            textItem.setShowHint(true);  
//                            textItem.setShowHintInField(true);  
//                            textItem.setHint("Some Hint");  
//                            return textItem;  
//                        case 2:  
//                            return new PasswordItem();  
//                        case 3:  
//                            return new DateItem();  
//                        case 4:  
//                            CheckboxItem cbi = new CheckboxItem();  
//                            cbi.setShowLabel(false);  
//                            return cbi;  
//                        case 5:  
//                            IntegerItem integerItem = new IntegerItem();  
//                            integerItem.setMask("###");  
//                            return integerItem;  
//                        case 6:  
//                            SelectItem selectItemMultipleGrid = new SelectItem();  
//                            selectItemMultipleGrid.setShowTitle(false);  
//                            selectItemMultipleGrid.setMultiple(true);  
//                            selectItemMultipleGrid.setMultipleAppearance(MultipleAppearance.PICKLIST);  
//                            selectItemMultipleGrid.setValueMap("Cat", "Dog", "Giraffe", "Goat", "Marmoset", "Mouse");  
//                            return selectItemMultipleGrid;  
//                        case 7:  
//                            SliderItem sliderItem = new SliderItem();  
//                            sliderItem.setMaxValue(10);  
//                            sliderItem.setWidth(160);  
//                            return sliderItem;  
//                        default:  
//                            return context.getDefaultProperties();  
//                    }  
//                }  
//                return context.getDefaultProperties();  
//            }  
//        });  
  	
	}
	
	
	
	@Override
	public HowMGWTFormProperties getHowMProperties() {
		return propertiesLayout;
	}

	@Override
	public void onHowMDeleteRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHowMEditRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHowMNewRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHowMRelation(ListGridRecord record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHowMSave() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHowMSetValues(ListGridRecord record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHowMLoad(HowMGWTFormBean formBean) {
		mapLayouts.clear();
		LinkedHashMap<String, String> layouts = new LinkedHashMap<String, String>();

		FormBean bean = (FormBean)formBean;

		this.defaultPathTemp = bean.getPathTemp();
		
		layouts.put("", "");
		
		if ( bean.getLayouts() != null ){
			for ( eEDILayout layout : bean.getLayouts()){
				mapLayouts.put(layout.getTableName(), layout);
				layouts.put(layout.getTableName(), layout.getTableTitle());
			}
		}
		this.propertyLayouts.getHowMGWTEditorSelectItem().getField().setValueMap(layouts);

		mapPages.clear();
		if ( bean.getEntityPages() != null ){
			for ( eEDIPageCode page : bean.getEntityPages()){
				mapPages.put(HowMGWTUtilities.getString(page.getPageCode()), page.getPageTitle());				
			}
		}
		this.propertyPageCode.getHowMGWTEditorSelectItem().getField().setValueMap(mapPages);
		
	}	
	
	public void loadLayouts(){
		HowMGWTWindowWait.showWait();
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {

				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true ) ){
					HowMGWTWindowWait.hideWait();
					return;
				}
				
				
				onHowMLoad(formBean);
				HowMGWTWindowWait.hideWait();
			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
 
			}			
		};					 
		String body =  "";
		
		struts.request("edw0003.do?method=loadLayouts",  "EDW0003Form", body);						
	}
	
	
	public void selectTable(String tableName){

		this.formToolbarEdit.getPanelList().clearAllRecords();
		Tab tableRemove = panelLayoutLoader;
		panelLayoutLoader = null;
		if ( tableRemove != null ){
			this.tabSet.removeTab(tableRemove);
		}			
		
		if ( HowMGWTUtilities.isEmpty(tableName)){
			propertyAcao.getFormField().setHowMValue("");
			propertyDelimitador.getFormField().setHowMValue("");
			propertyFormato.getFormField().setHowMValue("");
			propertyLinhaInicio.getFormField().setHowMValue("");
			propertyAcao.getFormField().setHowMValue("");
			propertyAcao.getFormField().setHowMValue("");
			this.actionGravar.setVisible(false);
			this.actionUploadFile.setVisible(false);

			return;
		}
		
		eEDILayout layout = this.mapLayouts.get(tableName);
		this.currentLayout = layout;
		propertyDelimitador.getFormField().setHowMValue(layout.getDelimiter());
		propertyLinhaInicio.getFormField().setHowMValue(""+layout.getRowStartRead());
		
		panelLayoutLoader = new PanelLayoutLoader(layout);
		this.tabSet.addTab(panelLayoutLoader);
		
		tabSet.setSelectedTab(0);

		eEDILayoutField[] fields = layout.getFields();
		if ( fields == null ){
			return;
		}
		RecordList recordList = new RecordList();
		ListGridRecord record;
		for ( eEDILayoutField field : fields){
			record = new ListGridRecord();
			record.setAttribute(propertyColumnPrimaryKey.getName(), HowMGWTUtilities.getBoolean(field.getPrimaryKey()));
			record.setAttribute(propertyColumnName.getName(), field.getName());
			record.setAttribute(propertyColumnLabel.getName(), field.getLabel());
			record.setAttribute(propertyColumnType.getName(), field.getType());
			record.setAttribute(propertyColumnLength.getName(), HowMGWTUtilities.getInteger(field.getLength()));
			record.setAttribute(propertyColumnDecimal.getName(), HowMGWTUtilities.getInteger(field.getDecimals()));
			record.setAttribute(propertyColumnMandatory.getName(), HowMGWTUtilities.getBoolean(field.getMandatory()));
			record.setAttribute(propertyColumnMask.getName(), field.getMask());
			
			
			recordList.add(record);
		}
		this.formToolbarEdit.getPanelList().setData(recordList);
		
	}
	
	public void selectAcao(String acao){
		if ( HowMGWTUtilities.isEmpty(acao))
			this.actionUploadFile.setVisible(false);
		else{
			if ( "I".equals(acao.trim()))
				this.actionUploadFile.setVisible(true);				
		}
	}

	
	public void uploadFile(){
		 if ( ! formToolbarEdit.preFormValidate() )
			 return;
		 
		 if ( windowUploadDialog == null ){
			 windowUploadDialog = new HowMGWTUploadDialog(){
					/**
					 * Configurar para ser disparado quando for selecionado um arquivo simples.
					 */
					public void onHowMCloseSelectFile(String fileName){
						if(fileName.endsWith(HowMGWTUtilities.getString( propertyFormato.getHowmFormValue()))){
							validateFile(fileName);
						}
						else{
							SC.say("Formato do arquivo inválido...<hr>O formato correto para importação deste layout, deverá ser : <storng>"+propertyFormato.getHowmFormValue()+"</strong>");
						}
					} 
			 };
			 windowUploadDialog.configureUploadSingleFile();
		 }
		 
		 String subFolders 	= "EDI_"+Configuracao.getCodColaborador()+",";
		 String labelPrefix = "";
		 String rootPath    = defaultPathTemp;
		 String action		= "edi";
		 
		 System.out.println("defaultPathTemp : "+defaultPathTemp);
 	 
		 
		 windowUploadDialog.configureUpload(null, subFolders, labelPrefix, rootPath, action,null);
	}
	
	
	public void validateFile(final String fileName){
	 
		HowMGWTWindowWait.showWait();
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true ) ){					 
					return;
				}
				
				HowMGWTWindowWait.hideWait();
				if ( panelLayoutLoader.loadDataLayout(currentLayout, (FormBean)formBean) ){
					tabSet.selectTab(1);
					actionGravar.setVisible(true);
				}
				else{
					actionGravar.setVisible(false);					
				}
			}

			@Override
			public void onError(Throwable err) {
				super.onError(err);
 
			}
		};
		
		propertiesLayout.loadFormValues(formBean);
		formBean.setFileName(fileName);
		formBean.setCodePage(this.propertyPageCode.getHowmFormValueToString());
		String body =  HowMGWTUtilities.getGWTBeanTransfer(formBean.toJsonObject("").toString());
		
		struts.request("edw0003.do?method=parserFile",  "EDW0003Form", body);						
	}
	
	
	
	
	
	public void gravarDados(){
		if ( this.panelLayoutLoader.isErroPendente() ){
			SC.say(Tradutor.i18n.msgArquivoPossuiErros());
			return;
		}
		
		if ( this.panelLayoutLoader.getValidRecords().size() == 0 ){
			SC.say(Tradutor.i18n.msgNaoHaRegistrosValidosParaImportacao());	
			return;
		}
		
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ){
					return;
				}
				else{
					actionGravar.setVisible(false);

					FormBean bean = (FormBean)formBean;
					if ( bean.getDataRecords() != null ){	
						int i = 0;

						
						for ( eEDIRecord record : bean.getDataRecords() ){
							ListGridRecord recordGrid = (ListGridRecord)panelLayoutLoader.getValidRecords().get(i).getObject("RECORD");
							if ( recordGrid != null ){
								panelLayoutLoader.propertyFieldLog.setHowMValue(recordGrid, "<font color=blue><b>"+record.getMsg()+"</b></font>");
								panelLayoutLoader.getPanelList().refreshRow(panelLayoutLoader.getPanelList().getRecordIndex(recordGrid));
							}
							i ++;
						}
					}
					HowMGWTWindowWait.hideWait();
					SC.say(Tradutor.i18n.msgRegistrosAtualizadosComSucesso());
				}
			}

			@Override
			public void onError(Throwable err) {
				super.onError(err);
 
			}
		};	
		
		HowMGWTWindowWait.showWait();
		
		eEDIRecord[] records = new eEDIRecord[panelLayoutLoader.getValidRecords().size()];
		int i = 0;
		for ( eEDIRecord record : panelLayoutLoader.getValidRecords()){
			records[i++] = record;
		}
		
		propertiesLayout.loadFormValues(formBean);
		formBean.setDataRecords(records);
		String body =  HowMGWTUtilities.getGWTBeanTransfer(formBean.toJsonObject("").toString());
		
		struts.request("edw0003.do?method=gravarDados",  "EDW0003Form", body);

	}
}