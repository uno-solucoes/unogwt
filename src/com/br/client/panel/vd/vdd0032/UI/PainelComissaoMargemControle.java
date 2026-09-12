package com.br.client.panel.vd.vdd0032.UI;

import com.br.client.model.vd.entity.eComissaoMargem;
import com.br.client.model.vd.entity.eComissaoMargemFaixa;
import com.br.client.model.vd.vdd0032.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.howmake.client.form.UI.HowMGWTFormToolbarEdit;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.control.HowMGWTControlForm;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelComissaoMargemControle extends VLayout implements HowMGWTControlForm{

	private HowMGWTFormProperties properties = new HowMGWTFormProperties();
	private ListGridRecord currentRecord = null;
	
	private HowMGWTWindow parentWindow;
	
	private boolean changeRecords = false;

	/**
	 * Declara as propriedades de edição do formulório.
	 */
	public HowMGWTProperty propertyCodMargem	= properties.createProperty("codMargem"		, Tradutor.i18n.formReg());
	public HowMGWTProperty propertyDescAbrev	= properties.createProperty("descAbrev"		, Tradutor.i18n.formDescricaoAbreviada());
	public HowMGWTProperty propertyDescricao	= properties.createProperty("descricao"		, Tradutor.i18n.formDescricao());	
	 
	// Cria a instancia da listagem somente após a configuração dos dados 
	// das propriedades
	
	private HowMGWTFormToolbarEdit formToolbarEdit;
	private PainelComissaoMargemFaixaControle painelComissaoMargemFaixaControle = new PainelComissaoMargemFaixaControle();
	
	public PainelComissaoMargemControle(){
		
		this.setWidth100();
		this.setHeight100();
		
		int colW = 120;
		
		propertyCodMargem.setBound(colW, 50);
		propertyDescAbrev.setBound(colW, 200);
		propertyDescricao.setBound(colW, 300);

		propertyCodMargem.setWidthColumn(70);

		propertyCodMargem.createHowMGWTFormFieldTextItem();
		propertyDescAbrev.createHowMGWTFormFieldTextItem();
		propertyDescricao.createHowMGWTFormFieldTextItem();
		
		propertyCodMargem.createHowMGWTListGridField();
		propertyDescAbrev.createHowMGWTListGridField();
		
		propertyDescAbrev.setMandatory(true);
		propertyDescricao.setMandatory(true);
		
		propertyCodMargem.getFormField().setHowMDisable(true);
		
		HLayout mainLayout = new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		
		
		VLayout formLayout = new VLayout();
		formLayout.setWidth100();
		formLayout.setHeight100();

		
		// Criar Toolbar 
		// Cria o objeto de toolbar e adiciona no topo do formulório de controle.
		this.formToolbarEdit = new HowMGWTFormToolbarEdit(this);
		this.formToolbarEdit.getPanelList().setWidth(300);
		this.formToolbarEdit.getPanelList().setHeight100();
				
		formLayout.addMember(formToolbarEdit);
		formLayout.addMember(propertyCodMargem.getCanvas());
		formLayout.addMember(propertyDescAbrev.getCanvas());
		formLayout.addMember(propertyDescricao.getCanvas());

		formLayout.addMember(painelComissaoMargemFaixaControle);		
		
		mainLayout.addMember(formToolbarEdit.getPanelList());
		formToolbarEdit.createActionDelete();
		formToolbarEdit.setWidth100();
		mainLayout.addMember(formLayout);
		this.addMember(mainLayout);

	}

	@Override
	public HowMGWTFormProperties getHowMProperties() {
		return properties;
	}


	@Override
	public void onHowMEditRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHowMLoad(HowMGWTFormBean formBean) {
		FormBean bean = (FormBean)formBean;
		if ( bean.getComissaoMargens() == null )
			return;

		ListGridRecord firstRecord = null;
		RecordList recordList = new RecordList();
		for ( eComissaoMargem margem : bean.getComissaoMargens() ){
			ListGridRecord record = formToolbarEdit.convertFormBeanToRecord(margem);
			recordList.add(record);
			if( firstRecord == null )
				firstRecord = record;
		}
		this.formToolbarEdit.getPanelList().setData(recordList);
		if ( firstRecord != null ){
			this.formToolbarEdit.getPanelList().selectRecord(firstRecord);
			this.onHowMSetValues(firstRecord);	
		}

	}

	@Override
	public void onHowMNewRecord() {
		painelComissaoMargemFaixaControle.onHowMRelation(null);
	}

	@Override
	public void onHowMRelation(ListGridRecord record) {}

	/**
	 * Grava o registro editado no formulório.
	 */
	@Override
	public void onHowMSave() {
 		
		HowMGWTWindowWait.showWait();		
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				HowMGWTWindowWait.hideWait();

				ListGridRecord record;
				FormBean bean = (FormBean)formBean;
				if ( HowMGWTUtilities.isEmpty(propertyCodMargem.getHowMValue()) ){
					propertyCodMargem.getFormField().setHowMValue(bean.getComissaoMargem().getCodMargem());
					record = formToolbarEdit.addRecord();					
				}
				else
					record = formToolbarEdit.refreshRecord();
				
				painelComissaoMargemFaixaControle.onHowMRelation(record);

				SC.say("Registro gravado com sucesso...");
				changeRecords = true;
			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
			}			
		};			
		
		eComissaoMargem comissaoMargem = new eComissaoMargem();
		comissaoMargem.setCodMargem(this.propertyCodMargem.getHowMValue());
		comissaoMargem.setDescAbrev(this.propertyDescAbrev.getHowMValue());
		comissaoMargem.setDescricao(this.propertyDescricao.getHowMValue());

		if ( HowMGWTUtilities.isEmpty(comissaoMargem.getCodMargem()) ) 
			comissaoMargem.setOperacao(HowMGWTUtilities.OPERATION_INSERT );
		else
			comissaoMargem.setOperacao(HowMGWTUtilities.OPERATION_UPDATE );

		eComissaoMargemFaixa[] comissaoMargemFaixas = painelComissaoMargemFaixaControle.getComissaoMargemFaixas();
	
		// Se null então os dados estão inválidos para gravação, aborta 
		// o processo.
		if ( comissaoMargemFaixas == null ){
			HowMGWTWindowWait.hideWait();
			SC.say(Tradutor.i18n.msgDadosInformadosInvalidos());
			return;
		}
				
		JSONArray array = new JSONArray();
		int i = 0 ;
		for ( eComissaoMargemFaixa cItem :  comissaoMargemFaixas ){
			JSONObject object = cItem.toJsonObject("");
			 array.set(i, object);
			 i ++ ;
		}

		JSONObject objectBean = new JSONObject();
		objectBean.put("comissaoMargem",  			comissaoMargem.toJsonObject(""));
		objectBean.put("comissaoMargemFaixas",  	array);
 

		String body = HowMGWTUtilities.getGWTBeanTransfer(objectBean.toString());

		struts.request("vdd0032.do?method=gravar",  "VDD0032Form", body);		
		
	}

	@Override
	public void onHowMSetValues(ListGridRecord record) {
		painelComissaoMargemFaixaControle.onHowMRelation(record);
	}
	
	
	
	/**
	 * Carrega todas as margens de comissão.
	 */
	public void loadAll(){
		HowMGWTWindowWait.showWait();		
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				HowMGWTWindowWait.hideWait();
				onHowMLoad(formBean);
				if ( parentWindow != null )
					parentWindow.show();
			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
			}			
		};			
	
		String body = "";
		struts.setGwtCheckSecurity(true);
		struts.request("vdd0032.do?method=buscar",  "VDD0032Form", body);			
	}
	
	

	@Override
	public void onHowMDeleteRecord() {
		HowMGWTWindowWait.showWait();		
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				HowMGWTWindowWait.hideWait();
				ListGridRecord record = formToolbarEdit.getPanelList().getSelectedRecord();
				if ( record != null ){
					formToolbarEdit.getPanelList().removeData(record);
					formToolbarEdit.onHowMConfigureStatusNewRecord();
				}
				SC.say(Tradutor.i18n.msgRegistroExcluidoComSucesso());

			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
			}			

	    };			
		
		eComissaoMargem comissaoMargem = new eComissaoMargem();
		comissaoMargem.setCodMargem(this.propertyCodMargem.getHowMValue());
		comissaoMargem.setDescAbrev(this.propertyDescAbrev.getHowMValue());
		comissaoMargem.setDescricao(this.propertyDescricao.getHowMValue());

		comissaoMargem.setOperacao(HowMGWTUtilities.OPERATION_DELETE );
		
		JSONObject objectBean = new JSONObject();
		objectBean.put("comissaoMargem",  			comissaoMargem.toJsonObject(""));

		String body = HowMGWTUtilities.getGWTBeanTransfer(objectBean.toString());

		struts.request("vdd0032.do?method=gravar",  "VDD0032Form", body);		
	}

	/**
	 * @return the changeRecords
	 */
	public boolean isChangeRecords() {
		return changeRecords;
	}

	/**
	 * @param changeRecords the changeRecords to set
	 */
	public void setChangeRecords(boolean changeRecords) {
		this.changeRecords = changeRecords;
	}

	/**
	 * @return the parentWindow
	 */
	public HowMGWTWindow getParentWindow() {
		return parentWindow;
	}

	/**
	 * @param parentWindow the parentWindow to set
	 */
	public void setParentWindow(HowMGWTWindow parentWindow) {
		this.parentWindow = parentWindow;
	}

}
