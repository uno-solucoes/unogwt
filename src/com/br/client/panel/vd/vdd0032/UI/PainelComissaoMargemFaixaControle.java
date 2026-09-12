package com.br.client.panel.vd.vdd0032.UI;

import java.util.ArrayList;
import java.util.TreeMap;

import com.br.client.model.vd.entity.eComissaoMargem;
import com.br.client.model.vd.entity.eComissaoMargemFaixa;
import com.br.client.model.vd.vdd0032.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.json.client.JSONObject;
import com.howmake.client.form.UI.HowMGWTFormToolbarEdit;
import com.howmake.client.form.UI.HowMGWTLabel;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.control.HowMGWTControlForm;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.FormItemValueFormatter;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.BlurEvent;
import com.smartgwt.client.widgets.form.fields.events.BlurHandler;
import com.smartgwt.client.widgets.form.validator.CustomValidator;
import com.smartgwt.client.widgets.form.validator.IntegerRangeValidator;
import com.smartgwt.client.widgets.form.validator.Validator;
import com.smartgwt.client.widgets.grid.CellEditValueFormatter;
import com.smartgwt.client.widgets.grid.CellEditValueParser;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellSavedEvent;
import com.smartgwt.client.widgets.grid.events.CellSavedHandler;
import com.smartgwt.client.widgets.grid.events.DataArrivedEvent;
import com.smartgwt.client.widgets.grid.events.DataArrivedHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.EditorEnterEvent;
import com.smartgwt.client.widgets.grid.events.EditorEnterHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelComissaoMargemFaixaControle extends VLayout implements HowMGWTControlForm{

	private HowMGWTFormProperties properties = new HowMGWTFormProperties();
	private ListGridRecord currentRecord = null;

	/**
	 * Declara as propriedades de edição do formulório.
	 */
	public HowMGWTProperty propertyCodMargem				= properties.createProperty("codMargem"					, Tradutor.i18n.formReg());
	public HowMGWTProperty propertySeqComissaoMargemFaixa	= properties.createProperty("seqComissaoMargemFaixa"	, Tradutor.i18n.formSeq());
	
	public HowMGWTProperty propertyPercMargemIni			= properties.createProperty("percMargemIni"				, Tradutor.i18n.formPercMargemIni());
	public HowMGWTProperty propertyPercMargemFim			= properties.createProperty("percMargemFim"				, Tradutor.i18n.formPercMagemFim());
	public HowMGWTProperty propertyPercComissaoVendedor		= properties.createProperty("percComissaoVendedor"		, Tradutor.i18n.formPercComissaoVendedor());
 	 
	private eComissaoMargemFaixa validateMargemFaixa = new eComissaoMargemFaixa();

	private boolean existErrors = false;
	
	// Cria a instancia da listagem somente após a configuração dos dados 
	// das propriedades
	
	private HowMGWTFormToolbarEdit formToolbarEdit;

	/**
	 * Construtor.
	 */
	public PainelComissaoMargemFaixaControle(){

		this.setWidth100();
		this.setHeight100();
		
		propertySeqComissaoMargemFaixa.setWidthColumn(60);

		propertySeqComissaoMargemFaixa.createHowMGWTListGridField();

		propertyPercMargemIni.createHowMGWTListGridField();
		propertyPercMargemFim.createHowMGWTListGridField();
		propertyPercComissaoVendedor.createHowMGWTListGridField();


		// -------------------------------------------------------------------
		// Validador de range 
		// -------------------------------------------------------------------
		CustomValidator validatorRange = new CustomValidator(){
			
			@Override
			protected boolean condition(Object value) {
			
				formToolbarEdit.convertRecordToFormBean( (ListGridRecord)getRecord() , validateMargemFaixa );
				
				double percMargemIni 		= HowMGWTUtilities.getDouble(validateMargemFaixa.getPercMargemIni());
				double percMargemFim        = HowMGWTUtilities.getDouble(validateMargemFaixa.getPercMargemFim());
								
				return ( percMargemIni <= percMargemFim );
			}
		};
		validatorRange.setErrorMessage(Tradutor.i18n.msgRangePercentualInvalido());
		
		// -------------------------------------------------------------------
		// Validador de range 
		// -------------------------------------------------------------------
		CustomValidator validatorRangeFinal = new CustomValidator(){
			
			@Override
			protected boolean condition(Object value) {	
				formToolbarEdit.convertRecordToFormBean( (ListGridRecord)getRecord() , validateMargemFaixa );				
				double percMargemFim    = HowMGWTUtilities.getDouble(validateMargemFaixa.getPercMargemFim());								
				return ( percMargemFim > 0.0 );
			}
		};
		validatorRangeFinal.setErrorMessage(Tradutor.i18n.msgRangeFinalDeveSerMaiorQueZero());
		
		// -------------------------------------------------------------------
		// Validador intersecao
		// -------------------------------------------------------------------		
		CustomValidator validatorIntersecao = new CustomValidator(){

			@Override
			protected boolean condition(Object value) {
			
				formToolbarEdit.convertRecordToFormBean( (ListGridRecord)getRecord() , validateMargemFaixa );
				
				double percMargemIni 		= HowMGWTUtilities.getDouble(validateMargemFaixa.getPercMargemIni());
				double percMargemFim        = HowMGWTUtilities.getDouble(validateMargemFaixa.getPercMargemFim());
 								
				return validateRecord((ListGridRecord)getRecord(), percMargemIni, percMargemFim);
			}
		};	
		validatorIntersecao.setErrorMessage(Tradutor.i18n.msgIntersecaoNaoPermitida());
		
		
		propertyPercMargemIni.getListField().setValidators(validatorRange, validatorIntersecao);
		propertyPercMargemFim.getListField().setValidators(validatorRangeFinal, validatorRange, validatorIntersecao);
		
		
		

		propertyPercMargemIni.getListField().setAlign(Alignment.RIGHT);
		propertyPercMargemFim.getListField().setAlign(Alignment.RIGHT);
		propertyPercComissaoVendedor.getListField().setAlign(Alignment.RIGHT);

		propertyPercMargemIni.createFormatDouble( "###,##0.00", " %" );
		propertyPercMargemFim.createFormatDouble( "###,##0.00", " %" );
		propertyPercComissaoVendedor.createFormatDouble( "###,##0.00" , " %" );
		
		propertyPercMargemIni.getListField().setCanEdit(true);
		propertyPercMargemIni.configureInputDecimal();
		propertyPercMargemFim.getListField().setCanEdit(true);
		propertyPercMargemFim.configureInputDecimal();
		propertyPercComissaoVendedor.getListField().setCanEdit(true);
		propertyPercComissaoVendedor.configureInputDecimal();		

		// propertyPercComissaoVendedor.getListField().get
		// commisionField.setKeyPressFilter("[0-9.]"
		// setUseMask usado quando 'edata
		// setMask 
		//  
		formToolbarEdit = new HowMGWTFormToolbarEdit(this){
			@Override
			public void onHowMCreatePanelList() {
				this.getPanelList().setCanRemoveRecords(true);
				this.getPanelList().setAnimateRemoveRecord(false);
			}
		};

		
		formToolbarEdit.getActionGravar().setVisible(false);
		this.addMember(formToolbarEdit);
		this.addMember(formToolbarEdit.getPanelList());
		// formToolbarEdit.createActionDelete();
		
		VLayout ajuda = new VLayout();
		ajuda.setWidth100();
		ajuda.setHeight(24);
		ajuda.setBackgroundColor(Tradutor.i18n.msgColor());
		
		ajuda.setAlign(VerticalAlignment.CENTER);
		
		HLayout cAjuda = new HLayout();
		cAjuda.setWidth100();
		cAjuda.setHeight(14);
		cAjuda.setAlign(Alignment.CENTER);
		
		HowMGWTLabel lblAjuda 	= new HowMGWTLabel(Tradutor.i18n.ajudaListGrid());
		lblAjuda.setHeight(14);
		lblAjuda.setWidth(390);
		
		cAjuda.addMember(lblAjuda);
		ajuda.addMember(cAjuda);
		
		this.addMember(ajuda);
	}
	
	@Override
	public HowMGWTFormProperties getHowMProperties() {		
		return properties;
	}

	@Override
	public void onHowMDeleteRecord() {}

	@Override
	public void onHowMEditRecord() {}

	@Override
	public void onHowMLoad(HowMGWTFormBean formBean) {
		FormBean bean = (FormBean)formBean;
		if ( bean.getComissaoMargemFaixas() == null )
			return;

		RecordList recordList = new RecordList();

		ListGridRecord currentRecord = null;
		
		for ( eComissaoMargemFaixa margemFaixa : bean.getComissaoMargemFaixas() ){
			ListGridRecord record = formToolbarEdit.convertFormBeanToRecord(margemFaixa);
			if ( currentRecord == null)
				currentRecord = record;
			mapLoadRecords.put(margemFaixa.getSeqComissaoMargemFaixa(), margemFaixa);
			recordList.add(record);
		}

		this.formToolbarEdit.getPanelList().setData(recordList);
		if ( currentRecord != null )
			formToolbarEdit.onHowMConfigureStatus(currentRecord);
		else
			formToolbarEdit.onHowMConfigureStatusNewRecord();
	}

	@Override
	public void onHowMNewRecord() {
		if ( formToolbarEdit != null ){
			if ( formToolbarEdit.isActionKeyPressed() ){
				
				ListGridRecord record = formToolbarEdit.addRecord();
				record.setAttribute(propertyPercMargemIni.getName(), 0.0);
				record.setAttribute(propertyPercMargemFim.getName(), 0.0);
				record.setAttribute(propertyPercComissaoVendedor.getName(), 0.0);
				
				int row = formToolbarEdit.getPanelList().getRecordIndex(record);
				int col = formToolbarEdit.getPanelList().getFieldNum(propertyPercMargemIni.getListField().getName());
				formToolbarEdit.getPanelList().startEditing(row, col, false);

				formToolbarEdit.getPanelList().setFieldError(row, propertyPercMargemFim.getName(), Tradutor.i18n.msgRangeFinalDeveSerMaiorQueZero());
			}
		}
	}

	@Override
	public void onHowMRelation(ListGridRecord record) {
		
		mapLoadRecords.clear();
		
		if ( record == null ){
			if ( this.formToolbarEdit != null )
				this.formToolbarEdit.getPanelList().clearAllRecords();
			this.formToolbarEdit.onHowMConfigureStatusNewRecord();
			return;
		}
		
		HowMGWTWindowWait.showWait();		
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				HowMGWTWindowWait.hideWait();
				onHowMLoad(formBean);
			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
			}			
		};			
	
		eComissaoMargem margem = new eComissaoMargem();
		margem.setCodMargem(record.getAttributeAsString(propertyCodMargem.getName()));
		
		JSONObject objectBean = new JSONObject();
		objectBean.put("comissaoMargem",  			margem.toJsonObject(""));

		String body = HowMGWTUtilities.getGWTBeanTransfer(objectBean.toString());
		struts.request("vdd0032.do?method=buscarMargemFaixas",  "VDD0032Form", body);			
		
	}

	@Override
	public void onHowMSave() {}

	@Override
	public void onHowMSetValues(ListGridRecord record) {}

	
	private TreeMap<String, eComissaoMargemFaixa> mapLoadRecords = new TreeMap<String, eComissaoMargemFaixa>();
	
	/**
	 * Retorna os registros de comissão margem faixa alterados
	 * @return
	 */
	public eComissaoMargemFaixa[] getComissaoMargemFaixas(){

		
		this.formToolbarEdit.getPanelList().saveAllEdits();
		
		existErrors = false;
		
		ListGridRecord[] records = formToolbarEdit.getPanelList().getRecords();
	
		eComissaoMargemFaixa margemFaixa;
		eComissaoMargemFaixa oldMargemFaixa;
		
		TreeMap<String , eComissaoMargemFaixa> mapCurrentRecords = new TreeMap<String, eComissaoMargemFaixa>();
		ArrayList<eComissaoMargemFaixa> margensFaixa = new ArrayList<eComissaoMargemFaixa>();
		 
		int row = 0;
		for ( ListGridRecord record : records){
			
			row = this.formToolbarEdit.getPanelList().getRecordIndex(record);
			// Verifica se há erros nas celulas dos registro.
			for ( HowMGWTProperty prop : this.properties.getProperties()){
				
				String erros[] = this.formToolbarEdit.getPanelList().getCellErrors( row, prop.getName() );
				if ( erros != null  && erros.length > 0 ){
					existErrors = true;
					break;
				}
			}
			
			
			margemFaixa = new eComissaoMargemFaixa();
			formToolbarEdit.convertRecordToFormBean( record, margemFaixa );	
			
			if ( HowMGWTUtilities.getDouble(margemFaixa.getPercMargemFim()) <= 0 ){
				existErrors = true;
				formToolbarEdit.getPanelList().setFieldError(row, propertyPercMargemFim.getName(), Tradutor.i18n.msgRangeFinalDeveSerMaiorQueZero());
			}
			
			oldMargemFaixa = mapLoadRecords.get( margemFaixa.getSeqComissaoMargemFaixa() );
			
			if ( HowMGWTUtilities.isEmpty( margemFaixa.getSeqComissaoMargemFaixa() ) ){
				margemFaixa.setOperacao(HowMGWTUtilities.OPERATION_INSERT);
			}
			else{
				// Se for igual a null, o registro foi excluído, marca o registro como excluído.
				if ( mapLoadRecords.get(margemFaixa.getSeqComissaoMargemFaixa()) == null ) 
					margemFaixa.setOperacao(HowMGWTUtilities.OPERATION_DELETE);
				mapCurrentRecords.put(margemFaixa.getSeqComissaoMargemFaixa(), margemFaixa);
			}
			
			// Se form diferente de deleção, então verifica se os dados informados 
			// são válidos.
			if ( margemFaixa.getOperacao() != HowMGWTUtilities.OPERATION_DELETE ){
	
				if ( oldMargemFaixa != null ){
					if (
						!HowMGWTUtilities.isEquals( margemFaixa.getPercComissaoVendedor(), oldMargemFaixa.getPercComissaoVendedor())
						||
						!HowMGWTUtilities.isEquals( margemFaixa.getPercMargemIni(), oldMargemFaixa.getPercMargemIni())
						||
						!HowMGWTUtilities.isEquals( margemFaixa.getPercMargemFim(), oldMargemFaixa.getPercMargemFim())
					)
						margemFaixa.setOperacao(HowMGWTUtilities.OPERATION_UPDATE);
										
				}
			}

			// Verifica se houve alteração nos dados.
			if ( margemFaixa.getOperacao() == HowMGWTUtilities.OPERATION_INSERT 
				|| 
				margemFaixa.getOperacao() == HowMGWTUtilities.OPERATION_UPDATE 
				||
				margemFaixa.getOperacao() == HowMGWTUtilities.OPERATION_DELETE
			)
				margensFaixa.add(margemFaixa);
		}
		
		// Se há erros na digitação do usuório retorna null, indicando 
		// que os dados não serão gravados.
		if ( isExistErrors() )
			return null;
		
		// --------------------------------------------------------------------------
		// Verifica se foi excluído algum registro.
		// --------------------------------------------------------------------------
		Object keys[] = mapLoadRecords.keySet().toArray();
		eComissaoMargemFaixa auxFaixa;
		for ( Object key : keys){
			auxFaixa = mapLoadRecords.get(key);
			// Se não encontrar o registro nos registros correntes, então o registro
			// foi excluído, neste caso marca o registro como excluído.
			if ( mapCurrentRecords.get(key) == null ){
				eComissaoMargemFaixa faixa = new eComissaoMargemFaixa();
				faixa.setOperacao( HowMGWTUtilities.OPERATION_DELETE );
				faixa.setCodMargem(auxFaixa.getCodMargem());
				faixa.setSeqComissaoMargemFaixa(auxFaixa.getSeqComissaoMargemFaixa());
				margensFaixa.add(faixa);
			}
		}

		
		
		eComissaoMargemFaixa[] margensFaixas = new eComissaoMargemFaixa[margensFaixa.size()];
		int i = 0 ;
		for ( eComissaoMargemFaixa faixa : margensFaixa){
			margensFaixas[i] = faixa;
			i++;
		}
		return margensFaixas;
	}
	 
	
	
	public boolean validateRecord(ListGridRecord recordExclude, double percMargemIniExclude, double percMargemFimExclude){

		ListGridRecord[] records = formToolbarEdit.getPanelList().getRecords();

		eComissaoMargemFaixa margemFaixa;
		eComissaoMargemFaixa oldMargemFaixa;

		boolean error = false;
		for ( ListGridRecord record : records){
			if ( recordExclude == record )
				continue;
			
			margemFaixa = new eComissaoMargemFaixa();
			formToolbarEdit.convertRecordToFormBean( record, margemFaixa );	

			oldMargemFaixa = mapLoadRecords.get( margemFaixa.getSeqComissaoMargemFaixa() );
			
			if ( HowMGWTUtilities.isEmpty( oldMargemFaixa ) ){
				margemFaixa.setOperacao(HowMGWTUtilities.OPERATION_INSERT);
			}
			else{
				// Se for igual a null, o registro foi excluído, marca o registro como excluído.
				if ( mapLoadRecords.get(margemFaixa.getSeqComissaoMargemFaixa()) == null ) 
					margemFaixa.setOperacao(HowMGWTUtilities.OPERATION_DELETE);
			}
			
			if ( margemFaixa.getOperacao() == HowMGWTUtilities.OPERATION_DELETE )
				;
			// Verifica se os dados informados são válidos.
			else{
	
				if ( oldMargemFaixa != null ){
					if (
						!HowMGWTUtilities.isEquals( margemFaixa.getPercComissaoVendedor(), oldMargemFaixa.getPercComissaoVendedor())
						||
						!HowMGWTUtilities.isEquals( margemFaixa.getPercMargemIni(), oldMargemFaixa.getPercMargemIni())
						||
						!HowMGWTUtilities.isEquals( margemFaixa.getPercMargemFim(), oldMargemFaixa.getPercMargemFim())
					){
						margemFaixa.setOperacao(HowMGWTUtilities.OPERATION_UPDATE);
					}
				}

				// Verifica se houve alteração nos dados.
				if ( margemFaixa.getOperacao() == HowMGWTUtilities.OPERATION_INSERT || margemFaixa.getOperacao() == HowMGWTUtilities.OPERATION_UPDATE ){
									 
					double percMargemIni 		= HowMGWTUtilities.getDouble(margemFaixa.getPercMargemIni());
					double percMargemFim        = HowMGWTUtilities.getDouble(margemFaixa.getPercMargemFim());
					
					if ( percMargemIniExclude >= percMargemIni && percMargemIniExclude <= percMargemFim)
						return false;

					if ( percMargemFimExclude >= percMargemIni && percMargemFimExclude <= percMargemFim)
						return false;

					if ( percMargemIni >= percMargemIniExclude &&  percMargemIni <= percMargemFimExclude)
						return false;

					if ( percMargemFim >= percMargemIniExclude && percMargemFim <= percMargemFimExclude )
						return false;
				}
			}
		}
		return true;
	}

	/**
	 * @return the formToolbarEdit
	 */
	public HowMGWTFormToolbarEdit getFormToolbarEdit() {
		return formToolbarEdit;
	}

	/**
	 * @return the existErrors
	 */
	public boolean isExistErrors() {
		return existErrors;
	}

	/**
	 * @param existErrors the existErrors to set
	 */
	public void setExistErrors(boolean existErrors) {
		this.existErrors = existErrors;
	}
}