package com.br.client.panel.sg.sgw0001.UI;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.Services;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.model.HOWMGWTDataSourceQuery;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.events.BlurEvent;
import com.smartgwt.client.widgets.form.fields.events.BlurHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellSavedEvent;
import com.smartgwt.client.widgets.grid.events.CellSavedHandler;

public class ResultadoConsulta extends HowMGWTListGrid{

	private boolean changeValues = false;
	private ListGridField fieldCodEmpresa 	= new ListGridField("CodEmpresa", 	    "", 	                        28);	// 0
	private ListGridField fieldSistema 		= new ListGridField("flagSistema", 	    "", 	                        20);	// 1
	private ListGridField fieldNomeParam	= new ListGridField("nomeParam", 		"", 						    56);	// 2
	private ListGridField fieldDescricao	= new ListGridField("codDescricao", 	Tradutor.i18n.formDescricao(), 	300);  	// 3
	private ListGridField fieldValor		= new ListGridField("dataValor", 		Tradutor.i18n.formValor(), 		250);	// 4
 
	public ResultadoConsulta(){
		initUI();	
	}
	
	public void initUI(){
		
		this.setDataPageSize(1000);

		this.setFields(
				fieldCodEmpresa,
				fieldSistema,
				fieldNomeParam,
				fieldDescricao,
				fieldValor
		);		
		
		this.setCanResizeFields(true);		
		this.setHeaderHeight(25);
		// não alterar esta situação para false, pois da problema nesta tela.
		this.setShowAllRecords(true);
		
		onHowMInitEntityControl(); 
		

		fieldCodEmpresa.setHidden(true);
		fieldSistema.setHidden(true);
		fieldNomeParam.setHidden(true);

		fieldCodEmpresa.setCanHide(false);
		fieldSistema.setCanHide(false);
		fieldNomeParam.setCanHide(false);
		
		fieldDescricao.setCanEdit(false);
		fieldValor.setCanEdit(true);
		
		this.setEditEvent(ListGridEditEvent.CLICK);

		fieldValor.addCellSavedHandler(new CellSavedHandler() {

			@Override
			public void onCellSaved(final CellSavedEvent event) {
				Record record = getSelectedRecord();
				saveParameter(event.getOldValue(), event.getNewValue(), record);
		
			}
		});	
		
		String sql = "";
		sql += "select \n";
		sql += "        cd_param_empresa.cod_empresa\n";
		sql += "       ,cd_parametro.sistema\n";
		sql += "       ,cd_param_empresa.nome_param\n";
		sql += "       ,cd_parametro.label\n";
		sql += "       ,cd_param_empresa.valor\n";
		sql += "from \n";
		sql += "       cd_param_empresa \n";
		sql += "       INNER JOIN cd_parametro\n";        
		sql += "       ON\n";
		sql += "         cd_param_empresa.nome_param = cd_parametro.nome_param\n";
		sql += "where \n";
		sql += "      sistema = 'NF'\n"; 
		sql += "      and\n";
		sql += "      cd_param_empresa.nome_param like '%RPS'\n";
		sql += "	  and\n";
		sql += "      cd_param_empresa.cod_empresa = "+Configuracao.getCodEmpresa();
		sql += "	  and\n";
		sql += "	  cd_param_empresa.nome_param != 'senhaCertificadoRPS' \n";
		HOWMGWTDataSourceQuery.executeQueryPopulate(sql, this);
	}

	public void saveParameter(Object oldValue, Object newValue, Record record){
		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
			
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				com.google.gwt.user.client.Window.alert(Tradutor.i18n.msgEnderecoBase()+GWT.getHostPageBaseURL()+"\n"+caught.getMessage());
			}

			public void onSuccess(HowMGWTEntity result) {
				if ( result.getThrowable() != null ){					 
					com.google.gwt.user.client.Window.alert(Tradutor.i18n.msgEnderecoBase()+GWT.getHostPageBaseURL()+"\n"+result.getThrowable());
				}else{
					SC.say(Tradutor.i18n.msgAlteracaoRealizadaComSucesso());
					changeValues = true;
				}
			}
		};
		if (HowMGWTUtilities.isEmpty(oldValue))
			oldValue = "";
		if (HowMGWTUtilities.isEmpty(newValue))
			newValue = "";
		
		HowMGWTEntity entity = Fabrica.createEntity();
		Fabrica.createParameter(entity, "acao",				"gravarParametroEmpresa");
		Fabrica.createParameter(entity, "sistema", 			"NF" );
		Fabrica.createParameter(entity, "nomeParametro",	record.getAttribute(fieldNomeParam.getName()));
		Fabrica.createParameter(entity, "valorParametro", 	newValue.toString());
		Fabrica.createParameter(entity, "valorParametroOld",oldValue.toString());
		entity.setAction(Services.acaoVDW0027);
		
		Configuracao.getProxyStruts().executeQuery(entity, callback);
	}

	/**
	 * @return the changeValues
	 */
	public boolean isChangeValues() {
		return changeValues;
	}

	/**
	 * @param changeValues the changeValues to set
	 */
	public void setChangeValues(boolean changeValues) {
		this.changeValues = changeValues;
	}
}