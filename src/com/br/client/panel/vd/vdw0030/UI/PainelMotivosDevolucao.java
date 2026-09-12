package com.br.client.panel.vd.vdw0030.UI;

import java.util.TreeMap;

import com.br.client.configuracao.Configuracao;
import com.br.client.model.vd.entity.eMotivoDevolucao;
import com.br.client.model.vd.vdw0030.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.UIPartner;
import com.howmake.client.form.UI.HowMGWTFormToolbarEdit;
import com.howmake.client.form.UI.HowMGWTLabel;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.control.HowMGWTControlForm;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelMotivosDevolucao extends VLayout implements HowMGWTControlForm , UIPartner{
	
	private HowMGWTFormProperties properties = new HowMGWTFormProperties();
	private HowMGWTFormToolbarEdit formToolbarEdit;
	
	private HowMGWTProperty propertyCodMotivoDevolucao 	= properties.createProperty("codMotivoDevolucao", 	Tradutor.i18n.formCodMotivoDevolucao());
	private HowMGWTProperty propertyDescAbrev 			= properties.createProperty("descAbrev", 			Tradutor.i18n.formDescricaoAbreviada());
	private HowMGWTProperty propertyDescricao 			= properties.createProperty("descricao", 			Tradutor.i18n.formDescricao());
	
	public PainelMotivosDevolucao(){
		
		this.setWidth100();
		this.setHeight100();		
	}
	
	@Override
	public void start() {
	
		int widthLabel = 120;

		propertyCodMotivoDevolucao.setBound(widthLabel, 60);
		propertyDescAbrev.setBound(widthLabel, 300);
		propertyDescricao.setBound(widthLabel, 400);
		
		propertyCodMotivoDevolucao.setWidthColumn(widthLabel);
		propertyDescAbrev.setWidthColumn(300);
		
		propertyCodMotivoDevolucao.createHowMGWTFormFieldTextItem();
		propertyDescAbrev.createHowMGWTFormFieldTextItem();
		propertyDescricao.createHowMGWTFormFieldAreaItem();
		
		propertyCodMotivoDevolucao.createHowMGWTListGridField();
		propertyDescAbrev.createHowMGWTListGridField();
		propertyDescricao.createHowMGWTListGridField();
		
		propertyDescAbrev.getListField().setCanEdit(true);
		propertyDescAbrev.getListField().setRequired(true);

		propertyDescricao.getListField().setCanEdit(true);

		formToolbarEdit = new HowMGWTFormToolbarEdit(this);

		
		formToolbarEdit.getPanelList().setCanEdit(true);  
		formToolbarEdit.getPanelList().setModalEditing(true);  
		// formToolbarEdit.getPanelList().setEditEvent(ListGridEditEvent.CLICK);  
		// formToolbarEdit.getPanelList().setListEndEditAction(RowEndEditAction.NEXT);  
		formToolbarEdit.getPanelList().setAutoSaveEdits(false);  
	        
		
		formToolbarEdit.getPanelList().setCanEdit(true);
		formToolbarEdit.createActionDelete();
		
		this.addMember(formToolbarEdit);
		this.addMember(formToolbarEdit.getPanelList());
		this.addMember(HowMGWTUtilities.getCanvasLabelIndicator(26, new HowMGWTLabel(Tradutor.i18n.ajudaListGrid()) ));
		
		executeQuery();
	}
	
	public String getHowMGWTTitle(){
		return Tradutor.i18n.formTituloVDW0030();
	}

	public String getHowMGWTPrograma(){
		return "VDW0030";
	}
	

	@Override
	public void onHowMDeleteRecord() {
		SC.confirm(Tradutor.i18n.confirmExcluirRegistro(), new BooleanCallback() {
			
			@Override
			public void execute(Boolean value) {
				if ( value.booleanValue() )
					excluirRegistro();
			}
		});
	}

	@Override
	public void onHowMEditRecord() {}

	@Override
	public void onHowMLoad(HowMGWTFormBean formBean) {}


	@Override
	public void onHowMRelation(ListGridRecord record) {}

	@Override
	public void onHowMSetValues(ListGridRecord record) {}

	@Override
	public HowMGWTFormProperties getHowMProperties() {
		return properties;
	}
	
	@Override
	public void onHowMNewRecord() {
		if ( formToolbarEdit != null && formToolbarEdit.isActionKeyPressed() ){
			ListGridRecord record = formToolbarEdit.addRecord();		
		}
	}

	
	/**
	 * Valida e Grava os dados no servidor.
	 */
	@Override
	public void onHowMSave() {
		
		TreeMap<String,Record> mapEditRows = new TreeMap<String, Record>();
		int[] editRows = this.formToolbarEdit.getPanelList().getAllEditRows();

		Record editRecord;
		if ( editRows != null && editRows.length > 0 ){
			for ( int edit : editRows ){
				editRecord = this.formToolbarEdit.getPanelList().getEditedRecord(edit);
				if ( editRecord != null ){
					mapEditRows.put(""+edit, editRecord);
				}
			}
		}
 
		ListGridRecord[] records = this.formToolbarEdit.getPanelList().getRecords();
		boolean existErrors = false;
		for ( ListGridRecord record : records ){
			if ( HowMGWTUtilities.isEmpty(propertyDescAbrev.getHowMValue(record)) ){
				existErrors = true;
				int row = this.formToolbarEdit.getPanelList().getRecordIndex(record);
				formToolbarEdit.getPanelList().setFieldError(row, propertyDescAbrev.getName(), Tradutor.i18n.msgCampoEObrigatorio());
			}			
		}
		if( existErrors ){
			SC.say(Tradutor.i18n.msgNaoEPossivelGravarDadosCorrijaOsDados());
			return;
		}

		if ( editRows == null && editRows.length == 0 ){
			SC.say(Tradutor.i18n.msgNaoHaItemsParaSeremSalvos());
			return;
		}		
		
		FormBean formBean = new FormBean();
		eMotivoDevolucao[] motivosDevolucao = new eMotivoDevolucao[records.length];
		eMotivoDevolucao motivoDevolucao;
		int i = 0;
				
		
		for ( ListGridRecord record : records ){
		 
			motivoDevolucao = new eMotivoDevolucao();
			motivoDevolucao.setCodColaborador(Configuracao.getCodColaborador());
			motivoDevolucao.setDescAbrev(propertyDescAbrev.getHowMValue(record));
			motivoDevolucao.setDescricao(propertyDescricao.getHowMValue(record));
			motivoDevolucao.setCodMotivoDevolucao(propertyCodMotivoDevolucao.getHowMValue(record));

			editRecord = mapEditRows.get(""+i);
			if ( editRecord != null ){

				if ( HowMGWTUtilities.isEmpty( motivoDevolucao.getCodMotivoDevolucao() ))
					motivoDevolucao.setOperacao(""+HowMGWTUtilities.OPERATION_INSERT);
				
				// Verificar se foi alterado alguma informação, antes de marcar como 
				// alterado.
				else{					
						motivoDevolucao.setOperacao(""+HowMGWTUtilities.OPERATION_UPDATE);
				}
			}						
			motivosDevolucao[i++] = motivoDevolucao;
		}
		formBean.setMotivosDevolucao(motivosDevolucao);
		
		
		// -------------------------------------------------------------------------------
		// Grava os dados no servidor.
		// -------------------------------------------------------------------------------
		HowMGWTWindowWait.showWait();		
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true))
					return;

				final FormBean bean = (FormBean)formBean;
				
				formToolbarEdit.getPanelList().saveAllEdits();
				// Recupera os registros da lista.
				ListGridRecord[] records =formToolbarEdit.getPanelList().getRecords();
				
				// Limpa a lista para fazer a recarga dos dados atualizados.
				formToolbarEdit.getPanelList().clearAllRecords();
				int i = 0;
				for ( eMotivoDevolucao motivoDevolucao : bean.getMotivosDevolucao()){
					if ( HowMGWTUtilities.isEmpty( propertyCodMotivoDevolucao.getHowMValue(records[i]) ) ){
						records[i].setAttribute(propertyCodMotivoDevolucao.getName(), motivoDevolucao.getCodMotivoDevolucao());
					}
					i++;
				}
				formToolbarEdit.getPanelList().setData(records);
				HowMGWTWindowWait.hideWait();				
				SC.say("Registro gravado com sucesso...");
			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
			}			
		};					
		
		String body = HowMGWTUtilities.getGWTBeanTransfer(  formBean.toJsonObject("").toString() );
		struts.request("vdw0030.do?method=save",  "VDW0030Form", body);		
	}
	
	/**
	 * Executa a consulta no servidor e carrega todos os motivos de devolução para
	 * a tela de manutenção dos dados.
	 */
	public void executeQuery(){		
		// -------------------------------------------------------------------------------
		// Grava os dados no servidor.
		// -------------------------------------------------------------------------------
		this.formToolbarEdit.getPanelList().clearAllRecords();
		
		HowMGWTWindowWait.showWait();
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true))
					return;

				FormBean bean = (FormBean)formBean;
				if ( bean.getMotivosDevolucao() != null ){
					RecordList recordList = new RecordList();
					ListGridRecord record;
					for ( eMotivoDevolucao motivoDevolucao : bean.getMotivosDevolucao()){
						record = new ListGridRecord();
						formToolbarEdit.convertFormBeanToRecord(record, motivoDevolucao );
						recordList.add(record);
					}
					formToolbarEdit.getPanelList().setData(recordList);
				}
				
				HowMGWTWindowWait.hideWait();				
			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
			}			
		};					
	
		
		String body = "";
		struts.request("vdw0030.do?method=buscar",  "VDW0030Form", body);		
	}


	/**
	 * Exclui o registro no servidor.
	 */
	public void excluirRegistro(){
		FormBean formBean = new FormBean();

		final ListGridRecord deleteRecord = formToolbarEdit.getPanelList().getSelectedRecord();
		if ( HowMGWTUtilities.isEmpty( propertyCodMotivoDevolucao.getHowMValue(deleteRecord))){
			formToolbarEdit.getPanelList().removeData(deleteRecord);			
			SC.say("Registro excluido com sucesso...");
			return;
		}
		// -------------------------------------------------------------------------------
		// Grava os dados no servidor.
		// -------------------------------------------------------------------------------
		HowMGWTWindowWait.showWait();		
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true))
					return;

				final FormBean bean = (FormBean)formBean;
				
				formToolbarEdit.getPanelList().removeData(deleteRecord);
				
				HowMGWTWindowWait.hideWait();				
				SC.say("Registro excluido com sucesso...");
			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
			}			
		};
		
		eMotivoDevolucao motivoDevolucao = new eMotivoDevolucao();
		motivoDevolucao.setCodColaborador(Configuracao.getCodColaborador());
		motivoDevolucao.setDescAbrev(propertyDescAbrev.getHowMValue(deleteRecord));
		motivoDevolucao.setDescricao(propertyDescricao.getHowMValue(deleteRecord));
		motivoDevolucao.setCodMotivoDevolucao(propertyCodMotivoDevolucao.getHowMValue(deleteRecord));
		motivoDevolucao.setOperacao(""+HowMGWTUtilities.OPERATION_DELETE);
		
		formBean.setMotivosDevolucao(new eMotivoDevolucao[]{motivoDevolucao});
		String body = HowMGWTUtilities.getGWTBeanTransfer(  formBean.toJsonObject("").toString() );
		struts.request("vdw0030.do?method=save",  "VDW0030Form", body);				
	}

}
