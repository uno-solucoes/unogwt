package com.howmake.client.form.model; 

import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.fn.fnw0217.model.EPlanoContas;
import com.br.client.panel.registro.Services;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.server.HowMUtilities;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class HOWMGWTDataSourceQuery {

	public static String LAST_SQL = "";
	
	public static final void executeQuery(String sql, final HowMGWTCall call, boolean showWait) {
		executeQuery(sql, call, null, showWait);
	}
	
	public static final void executeQuery(String sql, final HowMGWTCall call) {
		executeQuery(sql, call, null);
	}
	
	public static final void executeQuery(String sql, final HowMGWTCall call, HowMGWTEntity detailEntity) {
		executeQuery(sql, call, detailEntity, false);
	}
	
	/**
	 * Encaminha a requisição para o servidor para executar a consulta.
	 */
	public static final void executeQuery(String sql, final HowMGWTCall call, HowMGWTEntity detailEntity, final boolean wait) {
        if ( wait ){
        	HowMGWTWindowWait.showWait();
        }
		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
			
				public void onFailure(Throwable caught) {
					if ( call.onFailure(caught) ){
						if ( wait )
							HowMGWTWindowWait.hideWait();
						
						caught.printStackTrace();
						com.google.gwt.user.client.Window.alert(Tradutor.i18n.formEnderecoBase()+GWT.getHostPageBaseURL()+"\n"+caught.getMessage());						
					}
				}

				public void onSuccess(HowMGWTEntity result) {					
					call.onSuccess(result);
					if ( wait ){
						Timer timer = new Timer() {
							
							@Override
							public void run() {
								if ( wait )
									HowMGWTWindowWait.hideWait();
							}
						};
						timer.schedule(10);
					}
				}
		};

		HowMGWTEntity entity = Fabrica.createEntity();
		entity.setAction(Services.acaoSelectInEmpresa);
		
		LAST_SQL = sql;
		
		HowMProperty pSelect = new HowMProperty(Fabrica.DEFAULT_SELECT, sql );
		entity.getParameters().put(pSelect.getName(), pSelect);
		
		if ( detailEntity != null )
			entity.getDetailEntities().add(detailEntity);
		
		Configuracao.getProxyStruts().executeQuery(entity, callback);
	}

	/**
	 * Encaminha a requisição para o servidor para executar a consulta.
	 */
	public static final void executeQueryPopulate(String sql, final SelectItem selectItem , boolean mandatory) {
		executeQueryPopulate(sql,null, selectItem, mandatory);
	}
	
	
	/**
	 * Encaminha a requisição para o servidor para executar a consulta.
	 */
	public static final void executeQueryPopulate(String sql, final HowMGWTCall call , final SelectItem selectItem , final boolean mandatory) {
        
		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
			
				public void onFailure(Throwable caught) {
					if ( call == null ){
						caught.printStackTrace();
						com.google.gwt.user.client.Window.alert(Tradutor.i18n.formEnderecoBase()+GWT.getHostPageBaseURL()+"\n"+caught.getMessage());						
					}
					else if ( call.onFailure(caught) ){
						caught.printStackTrace();
						com.google.gwt.user.client.Window.alert(Tradutor.i18n.formEnderecoBase()+GWT.getHostPageBaseURL()+"\n"+caught.getMessage());						
					}
				}

				public void onSuccess(HowMGWTEntity result) {					
			        LinkedHashMap<String, String> valueItem = new LinkedHashMap<String, String>();
			        
			        int id = 1;
			        if ( ! mandatory )
			        	valueItem.put("", " ");
					for ( String[] row : result.getData() ){

						if ( row.length == 2 )
							valueItem.put(row[0], row[1]);
						else{
							valueItem.put(""+(id++), row[0]);
						}
					}
			        selectItem.setValueMap(valueItem);
			        if ( call != null )
			        	call.onSuccess(result);
				}
		};

		HowMGWTEntity entity = Fabrica.createEntity();
		entity.setAction(Services.acaoSelectInEmpresa);

		HowMProperty pSelect = new HowMProperty(Fabrica.DEFAULT_SELECT, sql );
		entity.getParameters().put(pSelect.getName(), pSelect);

		Configuracao.getProxyStruts().executeQuery(entity, callback );
	}

	/**
	 * Executa a consulta no servidor e popula a grid.
	 * @param sql
	 * @param listGrid
	 */
	public static final void executeQueryPopulate(String sql, final HowMGWTListGrid listGrid){
		executeQueryPopulate(sql, listGrid, false);
	}

	/**
	 * Executa a consulta no servidor e popula a grid.
	 * @param sql
	 * @param listGrid
	 */
	public static final void executeQueryPopulate(String sql, HowMGWTListGrid listGrid, boolean wait){
		executeQueryPopulate(sql, listGrid, wait, false);
	}	
	
	/**
	 * Executa a consulta no servidor e popula a grid.
	 * @param sql
	 * @param listGrid
	 */
	public static final void executeQueryPopulate(final String sql, final HowMGWTListGrid listGrid, final boolean wait, final boolean selectRowAfterQuery){

		if ( wait )
			HowMGWTWindowWait.showWait();
		// System.out.println("Iniciando execucao da consulta...");
		HowMGWTCallImpl call = new HowMGWTCallImpl() {
			@Override
			public boolean onFailure(Throwable caught) {
				if ( wait ){
					HowMGWTWindowWait.hideWait();
					
				}
				return super.onFailure(caught);
				
			}
			
			@Override
			public void onSuccess(HowMGWTEntity result) {
				//System.out.println("Carregando dados....");				
				showResult(listGrid,result, selectRowAfterQuery, sql);
				//System.out.println("Dados carregados com sucesso...");
				if ( wait ){
					Timer timer = new Timer() {						
						@Override
						public void run() {
							HowMGWTWindowWait.hideWait();	
						}
					};
					timer.schedule(60*1);
				}
			}
		};

		executeQuery(sql, call);
	}

	
	/**
	 * Configura o resultado recuperado do servidor e popula a grid.
	 * @param listGrid
	 * @param result
	 */
	public static final void showResult(HowMGWTListGrid listGrid, HowMGWTEntity result,String sql){
		showResult( listGrid,  result, false, sql);
	}
	
	/**
	 * Configura o resultado recuperado do servidor e popula a grid.
	 * @param listGrid
	 * @param result
	 */
	public static final void showResult(HowMGWTListGrid listGrid, HowMGWTEntity result,  boolean selectRowAfterQuery, String sql){

		// Verifica se houve algum erro durante o processamento.
		if ( HowMGWTUtilities.isAnalyseEntityIsError(result))
			return;
		try{
			listGrid.setShowRecordComponents(true);          
			listGrid.setShowRecordComponentsByCell(true);  
			ListGridRecord[] records = new ListGridRecord[result.getData().size()];		 
			HowMGWTDataRecord record;
			Record firstRecord = null;
			int i = 0;
			// Avisa que a carga comecou.
			listGrid.onHowMStartLoadDatabaseRecord();
			for ( String[] row : result.getData()){
				// Notifica os registros sendo carregados.
				record = new HowMGWTDataRecord(listGrid, listGrid.getHeaderPositions(), row);
	
				records[i] = record;
				if ( i == 0 )
					firstRecord = record;
	
				i ++;
				listGrid.onHowMLoadDatabaseRecord(record);
			}
			// Verifica se a carga ter
			if ( listGrid.onHowMCustomFinishLoader(records))
				return;
			
			// Avisa que a carga terminou.
			listGrid.onHowMFinishLoadDatabaseRecord();
			listGrid.setData(records);
			if ( selectRowAfterQuery && firstRecord != null )
				listGrid.onEventHowMGWTAfterQuery(firstRecord);
		}
		catch (Throwable e) {
			e.printStackTrace();
			Logger logger = Logger.getLogger("");
			logger.log(Level.ALL, "Ex caught!", e);
			
			String st = "";
			if ( e.getStackTrace() != null ){
				
				st ="<hr>"+e.getClass().getName() + ": " + e.getMessage()+"<hr>";
				for (StackTraceElement ste : e.getStackTrace())
					st += "<br>" + ste.toString();				
			}	
			SC.say("Erro: " +e.getMessage()+"<hr>Causa:<br/>"+st);
		}
	}
	
	
//	
//	/**
//	 * Executa a consulta no servidor e popula a grid.
//	 * @param sql
//	 * @param listGrid
//	 */
//	public static final void executeQueryPopulate(String sql, final HowMGWTCallImpl call ,final DetailViewer detailViewer, final HowMGWTDataSource dataSource){
//		executeQuery(sql, call);
//	}	
	
	/**
	 * Executa a consulta no servidor e popula a grid.
	 * @param sql
	 * @param listGrid
	 */
	public static final void executeQueryPopulate(String sql,final DetailViewer detailViewer, final HowMGWTDataSource dataSource){

		HowMGWTCallImpl call = new HowMGWTCallImpl() {
			
			@Override
			public void onSuccess(HowMGWTEntity result) {
				showResult(detailViewer, dataSource, result);
			}
		};
		executeQuery(sql, call);
	}
	
	/**
	 * Configura o resultado recuperado do servidor e popula a grid.
	 * @param listGrid
	 * @param result
	 */
	public static final ListGridRecord[] showResult(DetailViewer detailViewer, HowMGWTDataSource dataSource, HowMGWTEntity result){
				
		ListGridRecord[] records = new ListGridRecord[result.getData().size()];		 
		HowMGWTDataRecord record;
		int i = 0;
		for ( String[] row : result.getData()){
			record = new HowMGWTDataRecord(dataSource, dataSource.getHeaderPositions(), row);
			records[i] = record;
			i ++;
		}
		detailViewer.setData(records);
		return records;
	}
		
	
}
