package com.br.client.panel.ed.edw0003.UI;

import java.util.ArrayList;
import java.util.TreeMap;

import org.apache.james.mime4j.field.FieldName;

import com.br.client.model.ed.edw0003.FormBean;
import com.br.client.model.ed.entity.eEDILayout;
import com.br.client.model.ed.entity.eEDILayoutField;
import com.br.client.model.ed.entity.eEDIRecord;
import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTFormToolbarEdit;
import com.howmake.client.form.UI.HowMGWTLabel;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.control.HowMGWTControlForm;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;

public class PanelLayoutLoader  extends Tab implements HowMGWTControlForm{

	public static final String SUCCESS		      = "-1";
	public static final String ERRO_TYPE_EXCLUDE  = "1";
	public static final String ERRO_TYPE_CRITICAL = "2";
	
	public HowMGWTProperty propertyFieldLog;
	
	private HLayout lErroCampoNaoEncontrado;
	private HLayout lErroDeslocamento;
	private HLayout lErroNumeroCampoNaoBateLayout;
	private HLayout lErroCampoObrigatorio;
	

	private HowMGWTFormProperties propertiesLayout;;
	private HowMGWTFormToolbarEdit formToolbarEdi;
	
	private VLayout mainLayout = new VLayout();

	private ArrayList<eEDIRecord> validRecords = new ArrayList<eEDIRecord>();
	
	private boolean erroPendente = false;
 
	// Customização da lista.
	private HowMGWTListGrid panelList = new HowMGWTListGrid(){
		
		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
			
			HowMGWTProperty prop = propertiesLayout.getProperties().get(colNum);
			
			if ( prop != null ){
				// Campo deslocado
				Object value = record.getAttribute("ECD_"+prop.getName().toUpperCase());
				if ( value != null ){
					// panelList.setFieldError(rowNum, prop.getName(), value.toString());				
					return "background-color:"+Tradutor.i18n.colorLayoutErroDeslocamento();
				}
				// Campo não encontrado
				value = record.getAttribute("ECN_"+prop.getName().toUpperCase());
				if ( value != null ){
					// panelList.setFieldError(rowNum, prop.getName(), value.toString());				
					return "background-color:"+Tradutor.i18n.colorLayoutErroCampoNaoEncontrado();
				}
				// Campo obrigatório
				value = record.getAttribute("COB_"+prop.getName().toUpperCase());
				if ( value != null ){
					// panelList.setFieldError(rowNum, prop.getName(), value.toString());				
					return "background-color:"+Tradutor.i18n.colorObrigatorio();
				}
				
			}
			return "";
		};
		
	};
	
	public PanelLayoutLoader(eEDILayout layout){
		super("Dados", "tools/bot_data_add.png");
		
		
		panelList.setWrapCells(true);  
		panelList.setFixedRecordHeights(false); 
				
		if ( propertiesLayout != null )
			propertiesLayout = null;
		
		propertiesLayout = new HowMGWTFormProperties();
	 
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		configureLayoutErrors();
		
		if ( layout != null ){
			
			if ( layout.getFields() != null ){
				propertyFieldLog	= propertiesLayout.createProperty("LAYOUT_ANALISE", "<font color=red><b>"+Tradutor.i18n.formLog()+"</b><font>");
				propertyFieldLog.setWidthColumn(120);
				propertyFieldLog.createHowMGWTListGridField();

				
				for ( eEDILayoutField field : layout.getFields() ){
					HowMGWTProperty propertyField	= propertiesLayout.createProperty(field.getName(), field.getLabel());

					int wLabel = field.getLabel().length();
					int wField = HowMGWTUtilities.getInteger(field.getLength());
					
					if ( wField < wLabel )
						wField = wLabel;					
					wField *= 8;
					
					if ( wField > 250 )
						wField = 250;
					
					propertyField.setWidthColumn(wField);
					propertyField.createHowMGWTListGridField();
			
					if ( HowMGWTUtilities.getBoolean(field.getMandatory()) ){
						propertyField.getListField().setCanHide(false);
					}
				}
				
			}
			formToolbarEdi  = new HowMGWTFormToolbarEdit(this, panelList);
			formToolbarEdi.getPanelList().setWidth100();
			formToolbarEdi.getPanelList().setHeight100();
		    mainLayout.addMember(formToolbarEdi.getPanelList());

		    this.setPane(mainLayout);
		}
	}

	@Override
	public HowMGWTFormProperties getHowMProperties() {
		return propertiesLayout;
	}

	@Override
	public void onHowMDeleteRecord() {}

	@Override
	public void onHowMEditRecord() {}

	@Override
	public void onHowMLoad(HowMGWTFormBean formBean) {}

	@Override
	public void onHowMNewRecord() {}

	@Override
	public void onHowMRelation(ListGridRecord record) {}

	@Override
	public void onHowMSave() {}

	@Override
	public void onHowMSetValues(ListGridRecord record) {
	}

	public boolean loadDataLayout(eEDILayout layout, FormBean formBean){
		
		this.validRecords.clear();
		
		erroPendente = false;
		
		this.mainLayout.removeMember(lErroCampoNaoEncontrado);
		this.mainLayout.removeMember(lErroDeslocamento);
		this.mainLayout.removeMember(lErroNumeroCampoNaoBateLayout);
					
		
		this.formToolbarEdi.getPanelList().clearAllRecords();
		if ( formBean.getDataRecords() == null ){
			SC.say("Nao foi possivel recuperar registros do arquivo informado ...");
			return false;
		}
		if ( HowMGWTUtilities.getInteger(layout.getRowStartRead()) > formBean.getDataRecords().length  ) {
			SC.say("Arquivo nao possui registros para serem lidos ...");			
			return false;
		}
		
		boolean erroDeslocamento 				= false;
		boolean erroCampoNaoEncontrado 			= false;
		boolean erroNumeroCampoNaoBateLayout 	= false;
		boolean erroCampoObrigatorio			= false;
		
		HowMGWTWindowWait.showWait();
		eEDILayoutField field;
		ListGridRecord recordList;
		RecordList records = new RecordList();
		int r = 1;

		// cria um mapa para armazenar o header caso tenha header informado no arquivo.
		TreeMap<String, Integer> headerFile = new TreeMap<String, Integer>();
		for ( eEDIRecord record  : formBean.getDataRecords()){

			boolean rowValid = true;
			
			String[] values = record.getRowData();
			int i = 0;
			if ( r < HowMGWTUtilities.getInteger(layout.getRowStartRead()) ){				
				// Carrega os labels de cabeçalho do arquivo
				for ( String value : values){
					if ( headerFile.get(value.trim().toUpperCase()) == null )
						headerFile.put(value.trim().toUpperCase(), new Integer(i++));
				}
				r++;
				continue;
			}
			i = 0;
			
			recordList = new ListGridRecord();
			if ( ERRO_TYPE_EXCLUDE.equals(record.getTipoErro()) ){
				propertyFieldLog.setHowMValue(recordList, "<font color=green>"+record.getMsg()+"<font>");
				rowValid		= false;
			}
			if ( ERRO_TYPE_CRITICAL.equals(record.getTipoErro()) ){
				propertyFieldLog.setHowMValue(recordList, "<font color=red>"+record.getMsg()+"</font>");	
				erroPendente 	= true;
				rowValid     	= false;
			}
			
			for ( String value: values){
				if ( values.length != layout.getFields().length )
					erroNumeroCampoNaoBateLayout = true;
				
				if ( i < layout.getFields().length ){

					field = layout.getFields()[i];

					// Verifica se tem cabeçalho no arquivo e recupera o indice do campo no cabeçalho.
					if ( headerFile.size() > 0){
						
						Integer index = headerFile.get(field.getName().trim().toUpperCase());
						if ( index == null )
							index = headerFile.get(field.getLabel().trim().toUpperCase());
						
						if ( index == null )
							index = -1; 
						
						if ( HowMGWTUtilities.getBoolean( field.getMandatory() ) ){
							if ( HowMGWTUtilities.isEmpty( value )){
								recordList.setAttribute("COB_"+field.getName().toUpperCase(), value);
								erroCampoObrigatorio	= true;
								erroPendente 		 	= true;
								rowValid     		 	= false;
							}
						}
						if ( index.intValue() != i){
							// Campo não encontrado
							if ( index.intValue() == -1 ){
								recordList.setAttribute("ECN_"+field.getName().toUpperCase(), value);
								erroCampoNaoEncontrado 	= true;
								erroPendente 			= true;
								rowValid     			= false;
							}
							// Erro de deslocamento.
							else{
								recordList.setAttribute("ECD_"+field.getName().toUpperCase(), value);
								erroDeslocamento 		= true;
								erroPendente 			= true;
								rowValid				= false;
							}
						}
						
					}

					recordList.setAttribute(field.getName(), value);
					i++;

				}
				else
					break;
			}
			records.add(recordList);
			// Inclui o registro na lista de registros válidos.
			if ( rowValid ){
				this.validRecords.add(record);
				record.setObject("RECORD", recordList);
			}
			
			HowMGWTWindowWait.hideWait();
			
		}
		this.formToolbarEdi.getPanelList().setData(records);
		
		if ( erroCampoNaoEncontrado  )
			this.mainLayout.addMember(lErroCampoNaoEncontrado);

		if ( erroDeslocamento )
			this.mainLayout.addMember(lErroDeslocamento);

		if ( erroNumeroCampoNaoBateLayout )
			this.mainLayout.addMember(lErroNumeroCampoNaoBateLayout);
			
		if ( erroCampoObrigatorio )
			this.mainLayout.addMember(lErroCampoObrigatorio);
		
		HowMGWTWindowWait.hideWait();
		return true;
	}
	
	
	
	
	
	
	
	public void configureLayoutErrors(){
		if ( lErroCampoNaoEncontrado == null ){
			lErroCampoNaoEncontrado 		= new HLayout();
			lErroCampoNaoEncontrado.setWidth100();
			lErroCampoNaoEncontrado.setHeight(22);
			
			lErroDeslocamento				= new HLayout();
			lErroDeslocamento.setWidth100();
			lErroDeslocamento.setHeight(22);
			
			lErroNumeroCampoNaoBateLayout	= new HLayout();
			lErroNumeroCampoNaoBateLayout.setWidth100();
			lErroNumeroCampoNaoBateLayout.setHeight(22);
				
			lErroCampoObrigatorio	= new HLayout();
			lErroCampoObrigatorio.setWidth100();
			lErroCampoObrigatorio.setHeight(22);			
			
			lErroCampoNaoEncontrado.addMember(HowMGWTUtilities.getCanvasIndicator(18, 22, Tradutor.i18n.colorLayoutErroCampoNaoEncontrado(), Tradutor.i18n.colorLayoutErroCampoNaoEncontrado()));
			lErroCampoNaoEncontrado.addMember(HowMGWTUtilities.getCanvasLabelIndicator(22, new HowMGWTLabel("<B>"+Tradutor.i18n.msgLayoutErroCampoNaoEncontrado()+"</B>")));

			lErroDeslocamento.addMember(HowMGWTUtilities.getCanvasIndicator(18, 22, Tradutor.i18n.colorLayoutErroDeslocamento(), Tradutor.i18n.colorLayoutErroDeslocamento()));
			lErroDeslocamento.addMember(HowMGWTUtilities.getCanvasLabelIndicator(22,new HowMGWTLabel("<B>"+Tradutor.i18n.msgLayoutErroDeslocamento()+"</B>")));
 
			lErroNumeroCampoNaoBateLayout.addMember(HowMGWTUtilities.getCanvasIndicator(18, 22, Tradutor.i18n.colorLayoutErroCampoDiferenteLayout(), Tradutor.i18n.colorLayoutErroCampoDiferenteLayout()));
			lErroNumeroCampoNaoBateLayout.addMember(HowMGWTUtilities.getCanvasLabelIndicator(22,new HowMGWTLabel("<B>"+Tradutor.i18n.msgLayoutErroCamposDifentesLayout()+"</B>")));
		
			lErroCampoObrigatorio.addMember(HowMGWTUtilities.getCanvasIndicator(18, 22, Tradutor.i18n.colorObrigatorio(), Tradutor.i18n.colorObrigatorio()));
			lErroCampoObrigatorio.addMember(HowMGWTUtilities.getCanvasLabelIndicator(22,new HowMGWTLabel("<B>"+Tradutor.i18n.msgCampoObrigatorioNaoInformado()+"</B>")));
			
		}
	}

	private HLayout getSep(){
		HLayout sep = new HLayout();
		sep.setWidth(6);
		sep.setHeight100();
		return sep;
	}

	/**
	 * @return the erroPendente
	 */
	public boolean isErroPendente() {
		return erroPendente;
	}

	/**
	 * @param erroPendente the erroPendente to set
	 */
	public void setErroPendente(boolean erroPendente) {
		this.erroPendente = erroPendente;
	}

	/**
	 * @return the validRecords
	 */
	public ArrayList<eEDIRecord> getValidRecords() {
		return validRecords;
	}

	/**
	 * @param validRecords the validRecords to set
	 */
	public void setValidRecords(ArrayList<eEDIRecord> validRecords) {
		this.validRecords = validRecords;
	}

	/**
	 * @return the panelList
	 */
	public HowMGWTListGrid getPanelList() {
		return panelList;
	}

}