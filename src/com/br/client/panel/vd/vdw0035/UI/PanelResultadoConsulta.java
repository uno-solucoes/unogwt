package com.br.client.panel.vd.vdw0035.UI;
 
import com.br.client.model.vd.entity.eNFSE;
import com.br.client.model.vd.vdw0035.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTFormToolbarEdit;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.control.HowMGWTControlForm;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;

public class PanelResultadoConsulta extends VLayout implements HowMGWTControlForm {
 
  	private HowMGWTFormToolbarEdit formToolbarEdit;

	private HowMGWTFormProperties properties = new HowMGWTFormProperties();

	private HowMGWTProperty propertyIdNfse					= properties.createProperty("idNfse"					,	Tradutor.i18n.formID());

	private HowMGWTProperty propertynrRps					= properties.createProperty("nrRps"						,	Tradutor.i18n.formNrRps());
	private HowMGWTProperty propertyNrNfseWs				= properties.createProperty("nrNfseWs"					,	Tradutor.i18n.formNrNfseWs());
	private HowMGWTProperty propertySerie					= properties.createProperty("serie"						,	Tradutor.i18n.formSerie());

	private HowMGWTProperty propertyCnpjPrestador			= properties.createProperty("cnpjPrestador"				,	Tradutor.i18n.formCnpjPrestador());
	private HowMGWTProperty propertyCodNotaFiscal			= properties.createProperty("codNotaFiscal"				,	Tradutor.i18n.formCodNotaFiscalERP());

	private HowMGWTProperty propertyDtInclusao				= properties.createProperty("dtInclusao"				,	Tradutor.i18n.formDtInclusao());
	private HowMGWTProperty propertyDtCancelamento			= properties.createProperty("dtCancelamento"			,	Tradutor.i18n.formDtCancelamento());

	private HowMGWTProperty propertyNomeCliente				= properties.createProperty("nomeCliente"				,	Tradutor.i18n.formNomeCliente());
	private HowMGWTProperty propertyNmAtividade				= properties.createProperty("nmAtividade"				,	Tradutor.i18n.formSituacao());

	private HowMGWTProperty propertyIdProtocolo				= properties.createProperty("idProtocolo"				,	Tradutor.i18n.formNrProtocoloRecebimentoWs()); 
	private HowMGWTProperty propertyCodEmpresa				= properties.createProperty("codEmpresa"				,	Tradutor.i18n.formCodEmpresa());
	private HowMGWTProperty propertyNrProtocoloRecebimentoWs= properties.createProperty("nrProtocoloRecebimentoWss"	,	Tradutor.i18n.formNrProtocoloRecebimentoWs());
	private HowMGWTProperty propertyChave					= properties.createProperty("chave"						,	Tradutor.i18n.formChave());
	private HowMGWTProperty propertyIdAtividade				= properties.createProperty("idAtividade"				,	Tradutor.i18n.formIdAtividade());

 	private HowMGWTListGrid panelGrid = new HowMGWTListGrid();
 
	public PanelResultadoConsulta(){
		
		panelGrid.setWrapCells(true);  
		panelGrid.setFixedRecordHeights(false); 
	   
		/**
		 * ----------------------------------------------------------------------
		 * Cria a grid para listagem das solicitações de devolução
		 * ----------------------------------------------------------------------
		 */
		propertyIdProtocolo.setType(ListGridFieldType.INTEGER);		
		propertyIdProtocolo.setWidthColumn(50);		 
		propertyIdProtocolo.createHowMGWTListGridField();
		propertyIdProtocolo.getListField().setWrap(true);
		propertyIdProtocolo.getListField().setHidden(true);


		propertyDtInclusao.setType(ListGridFieldType.TEXT);		
		propertyDtInclusao.setWidthColumn(115);		 
		propertyDtInclusao.createHowMGWTListGridField();
		propertyDtInclusao.getListField().setWrap(true);
		
		propertyDtCancelamento.setType(ListGridFieldType.TEXT);
		propertyDtCancelamento.setWidthColumn(115);
		propertyDtCancelamento.createHowMGWTListGridField();
		propertyDtCancelamento.getListField().setWrap(true);
		
		propertyIdNfse.setType(ListGridFieldType.TEXT);		
		propertyIdNfse.setWidthColumn(50);		 
		propertyIdNfse.createHowMGWTListGridField();
		propertyIdNfse.getListField().setWrap(true);

		propertyCodEmpresa.setType(ListGridFieldType.TEXT);		
		propertyCodEmpresa.setWidthColumn(90);		 
		propertyCodEmpresa.createHowMGWTListGridField();
		propertyCodEmpresa.getListField().setWrap(true);
		propertyCodEmpresa.getListField().setHidden(true);
		
		propertyCodNotaFiscal.setType(ListGridFieldType.TEXT);		
		propertyCodNotaFiscal.setWidthColumn(70);		 
		propertyCodNotaFiscal.createHowMGWTListGridField();
		propertyCodNotaFiscal.getListField().setWrap(true);


		propertyCnpjPrestador.setType(ListGridFieldType.TEXT);		
		propertyCnpjPrestador.setWidthColumn(120);		 
		propertyCnpjPrestador.createHowMGWTListGridField();
		propertyCnpjPrestador.getListField().setWrap(true);
		// propertyCnpjPrestador.getListField().setHidden(true);

		
		propertynrRps.setType(ListGridFieldType.TEXT);		
		propertynrRps.setWidthColumn(50);		 
		propertynrRps.createHowMGWTListGridField();
		propertynrRps.getListField().setWrap(true);
		// propertynrRps.getListField().setHidden(true);
		
		propertyNrProtocoloRecebimentoWs.setType(ListGridFieldType.TEXT);		
		propertyNrProtocoloRecebimentoWs.setWidthColumn(110);		 
		propertyNrProtocoloRecebimentoWs.createHowMGWTListGridField();
		propertyNrProtocoloRecebimentoWs.getListField().setWrap(true);
		propertyNrProtocoloRecebimentoWs.getListField().setHidden(true);

		propertyChave.setType(ListGridFieldType.TEXT);		
		propertyChave.setWidthColumn(200);		 
		propertyChave.createHowMGWTListGridField();
		propertyChave.getListField().setWrap(true);
		propertyChave.getListField().setHidden(true);
		
		
		propertyIdAtividade.setType(ListGridFieldType.TEXT);		
		propertyIdAtividade.setWidthColumn(90);		 
		propertyIdAtividade.createHowMGWTListGridField();
		propertyIdAtividade.getListField().setWrap(true);
		propertyIdAtividade.getListField().setHidden(true);

		propertyNrNfseWs.setType(ListGridFieldType.TEXT);		
		propertyNrNfseWs.setWidthColumn(50);		 
		propertyNrNfseWs.createHowMGWTListGridField();
		propertyNrNfseWs.getListField().setWrap(true);
		// propertyNrNfseWs.getListField().setHidden(true);
		

		propertySerie.setType(ListGridFieldType.TEXT);		
		propertySerie.setWidthColumn(40);		 
		propertySerie.createHowMGWTListGridField();
		propertySerie.getListField().setWrap(true);
		// propertySerie.getListField().setHidden(true);

		propertyNomeCliente.setType(ListGridFieldType.TEXT);		
		propertyNomeCliente.setWidthColumn(250);		 
		propertyNomeCliente.createHowMGWTListGridField();
		propertyNomeCliente.getListField().setWrap(true);
		// propertyNomeCliente.getListField().setHidden(true);
		
		propertyNmAtividade.setType(ListGridFieldType.TEXT);		
		propertyNmAtividade.setWidthColumn(250);		 
		propertyNmAtividade.createHowMGWTListGridField();
		propertyNmAtividade.getListField().setWrap(true);

		
		panelGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		

		formToolbarEdit = new HowMGWTFormToolbarEdit(this, panelGrid);
		formToolbarEdit.getPanelList().setHeaderHeight(48);


		this.addMember(formToolbarEdit.getPanelList());		
		formToolbarEdit.getActionGravar().setVisible(false); 		
	}
 
	
	public String getHowMGWTTitle(){
		return Tradutor.i18n.formTituloVDW0035();
	}

	public String getHowMGWTPrograma(){
		return "VDW0035";
	}

	
	/**
	 * --------------------------------------------------------------------
	 * Implementa a interface de manuteção dos dados do formulório.
	 * --------------------------------------------------------------------
	 */
	@Override
	public HowMGWTFormProperties getHowMProperties() {
		return properties;
	}

	@Override
	public void onHowMDeleteRecord() {}

	@Override
	public void onHowMEditRecord() {
 
	}

	
	/**
	 * Carrega os dados do banco de dados.
	 */
	@Override
	public void onHowMLoad(HowMGWTFormBean pFormBean) 
	{
	}

	@Override
	public void onHowMNewRecord() {}

	@Override
	public void onHowMRelation(ListGridRecord record) {}

	@Override
	public void onHowMSave() {}

	@Override
	public void onHowMSetValues(ListGridRecord record) {}
	
	

	
	/**
	 * @return the properties
	 */
	public HowMGWTFormProperties getProperties() {
		return properties;
	}

	
	
	
	public void load(String codEmpresa, String dtInicio, String dtFim){
		
		formToolbarEdit.getPanelList().clearAllRecords();
		
		// -------------------------------------------------------------------------------
		// Grava os dados no servidor.
		// -------------------------------------------------------------------------------
		HowMGWTWindowWait.showWait();		
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true))
					return;
				
				FormBean bean = (FormBean)formBean;
	
				
				if( bean.getEntityNFSEs() == null ){
					SC.say("não encontrou registros para o critório de consulta utilizado...");
					return;
				}

				ListGridRecord[] records = new ListGridRecord[bean.getEntityNFSEs().length];
				ListGridRecord record;
				int i = 0;
				for ( eNFSE nfse : bean.getEntityNFSEs() ){
				
					record = new ListGridRecord();
				
					propertyIdProtocolo.setHowMValue(record, nfse.getIdProtocolo()); 
					
					
					if( HowMGWTUtilities.isEmpty( nfse.getDtInclusao() )){
						propertyDtInclusao.setHowMValue(record, "" );						
					}
					else{
						propertyDtInclusao.setHowMValue(record, HowMGWTUtilities.getFormatDateTime( HowMGWTUtilities.getDate( nfse.getDtInclusao() ) ) );
					}
					
					if( HowMGWTUtilities.isEmpty( nfse.getDtCancelamento() )){
						propertyDtCancelamento.setHowMValue(record, "" );						
					}
					else{
						propertyDtCancelamento.setHowMValue(record, HowMGWTUtilities.getFormatDateTime( HowMGWTUtilities.getDate( nfse.getDtCancelamento() ) ) );
					}

					
					propertyIdNfse.setHowMValue(record, nfse.getIdNfse());
					propertyCodEmpresa.setHowMValue(record, nfse.getCodEmpresa());
					propertyCodNotaFiscal.setHowMValue(record, nfse.getCodNotaFiscal());
					
					propertyCnpjPrestador.setHowMValue(record, HowMGWTUtilities.formatCNPJ( nfse.getCnpjPrestador() ));
					
					propertynrRps.setHowMValue(record, nfse.getNrRps());
					propertyNrProtocoloRecebimentoWs.setHowMValue(record, nfse.getNrProtocoloRecebimentoWs());
					propertyChave.setHowMValue(record, nfse.getChave());
					propertyIdAtividade.setHowMValue(record, nfse.getIdAtividade());
					propertyNrNfseWs.setHowMValue(record, nfse.getNrNfseWs());
					propertySerie.setHowMValue(record, nfse.getSerie());
					propertyNomeCliente.setHowMValue(record, nfse.getNomeCliente());
					propertyNmAtividade.setHowMValue(record, nfse.getNmAtividade());		
					
					records[i++] = record;
					
				}
				
				panelGrid.setData(records);
				
				HowMGWTWindowWait.hideWait();
			}

			@Override
			public void onError(Throwable err) {
				super.onError(err);
			}			
		};
	
		// Configura os filtros da consulta.
		
		FormBean formBean = new FormBean();
		formBean.setCodEmpresa(codEmpresa);
		formBean.setDtFim(dtFim);
		formBean.setDtInicio(dtInicio);
	 	
		struts.request("vdw0035.do?method=buscar",  "VDW0035Form", formBean.toSendBody("") );				
	}
	
	
		
	public void onExportarNFSEContador(String codEmpresa, String dtInicio, String dtFim){
		
		ListGridRecord[] records = panelGrid.getSelectedRecords();

		if( records.length == 0 ){
			SC.say(Tradutor.i18n.msgSelecioneNotasFiscaisServico());
			return;
		}

		HowMGWTWindowWait.showWait("Aguarde exportando arquivos XML NFS-e...");
		
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				FormBean form = (FormBean)formBean;

				HowMGWTWindowWait.hideWait();

				HowMGWTUtilities.downloadFile(form.getPathName(), form.getFileName());

			}
		};

		FormBean bean = new FormBean();
		bean.setCodEmpresa(codEmpresa);
		bean.setDtInicio(dtInicio);
		bean.setDtFim(dtFim);

		// Passa as nfse-s selecionadas pelo usuório.
		eNFSE[] NFSEs = new eNFSE[records.length];
		eNFSE nfse;
		int i = 0;
		for( ListGridRecord record : records ){
			nfse = new eNFSE();
			nfse.setIdNfse(propertyIdNfse.getHowMValue(record));
			nfse.setChave(propertyChave.getHowMValue(record));
			nfse.setNomeCliente(propertyNomeCliente.getHowMValue(record));
			nfse.setCodNotaFiscal(propertyCodNotaFiscal.getHowMValue(record));
			nfse.setCnpjPrestador(propertyCnpjPrestador.getHowMValue(record));
			NFSEs[i++] = nfse;
		}
		bean.setEntityNFSEs(NFSEs);
		
		bean.setCodEmpresa( codEmpresa );
		
		struts.request("vdw0035.do?method=exportarNFSEContador",  "VDW0035Form", bean.toSendBody("") );		
	}
	
}