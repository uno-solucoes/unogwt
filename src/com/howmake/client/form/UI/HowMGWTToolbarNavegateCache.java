package com.howmake.client.form.UI;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.howmake.client.form.model.HowMGWTDataRecord;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public abstract class HowMGWTToolbarNavegateCache extends ToolStrip{
	
	private boolean showNavigate 	= true;
	
	private IButton actionFirst   	= new IButton("");
	private IButton actionPreview  	= new IButton("");
	private IButton actionNext   	= new IButton("");
	private IButton actionLast   	= new IButton("");
	
	private HowMGWTLabel message	= new HowMGWTLabel();
	
	private IButton actionBuscar;

	private boolean createActionBuscar = true;
	
	private HowMProperty method = new HowMProperty(Fabrica.DEFAULT_ACAO, Fabrica.NAVEGATE_ACTION_BUSCAR);

	private Timer timer;

	private String actionClass;

	private HowMGWTListGrid resultGrid;

	private HowMGWTEntity currentEntity = Fabrica.createEntity();

	public HowMGWTToolbarNavegateCache(HowMGWTListGrid resultGrid, boolean createActionBuscar){		
		this.setWidth100();
		this.setHeight100();
		
		currentEntity.getParameters().put(method.getName(), method);
		this.setCreateActionBuscar(createActionBuscar);
		this.resultGrid = resultGrid;
		this.initUI();
		
        resultGrid.setCurrentEntity(this.getCurrentEntity());        
    	this.resultGrid.onHowMInitHeader();
	}

	protected void initUI(){
		   
		   // Verfiica se deverá ser criado o botão buscar na barra de ferramentas.
		   if ( createActionBuscar ){

			   actionBuscar = new IButton(Tradutor.i18n.buscar());
			   actionBuscar.setWidth(70);
			   actionBuscar.setIcon("actions/search.png"); 
			   actionBuscar.addClickHandler(new ClickHandler() { 
		            public void onClick(ClickEvent event) {
		            	executeQuery();
		            }
		        });
		   }		
		
		   actionFirst.addClickHandler(new ClickHandler() { 
	           public void onClick(ClickEvent event) {
	           	onHowMFirst();
	           }
	       });
		   
		   actionPreview.addClickHandler(new ClickHandler() { 
	           public void onClick(ClickEvent event) {
	           	onHowMPreview();
	           }
	       });

		   actionNext.addClickHandler(new ClickHandler() { 
	           public void onClick(ClickEvent event) {
	           	onHowMNext();
	           }
	       });
		   
		   actionLast.addClickHandler(new ClickHandler() { 
	           public void onClick(ClickEvent event) {
	           	onHowMLast();
	           }
	       });
		
		   
	 	   actionFirst.setWidth(30);
		   actionFirst.setIcon("actions/first.png");
		   
		   actionPreview.setWidth(30);
		   actionPreview.setIcon("actions/prev.png");
		   
		   actionNext.setWidth(30);
		   actionNext.setIcon("actions/next.png");
		   
		   actionLast.setWidth(30);
		   actionLast.setIcon("actions/last.png");

		   
	    	this.setHeight(26);
	
	    	// Verficia se deve ser criado a ação buscar.
	    	if ( this.createActionBuscar ){
		    	this.addMember(actionBuscar);
		    	this.addSeparator();    	
	    	}
	    	
	    	this.addMember(actionFirst);
	    	this.addMember(actionPreview);
	    	this.addMember(actionNext);
	    	this.addMember(actionLast);
	    	
	    	message.setWidth100();
	    	this.addMember(message);
	    	
	    	this.actionFirst.setDisabled(true);
	    	this.actionPreview.setDisabled(true);
	    	this.actionNext.setDisabled(true);
	    	this.actionLast.setDisabled(true);
 
	}
	
 
	
	private void onHowMFirst(){	
		this.getMethod().setValue( Fabrica.NAVEGATE_ACTION_FIRST );
		onHowMBuscar(false);
	}
	
	private void onHowMPreview(){
		this.getMethod().setValue( Fabrica.NAVEGATE_ACTION_PREVIEW );
		
		onHowMBuscar(false);
	}
	
	private void onHowMNext(){
		this.getMethod().setValue( Fabrica.NAVEGATE_ACTION_NEXT );
		onHowMBuscar(false);
	}
	
	private void onHowMLast(){
		this.getMethod().setValue( Fabrica.NAVEGATE_ACTION_LAST );
		onHowMBuscar(false);
	}
	
	protected HowMGWTDataRecord onLoadData(HowMGWTEntity result, ListGridRecord[] records){
		 
		HowMGWTDataRecord firstRecord = null;
		HowMGWTDataRecord record;
		int i = 0;
		for ( String[] row : result.getData()){
			record = new HowMGWTDataRecord(this.getResultGrid(), this.getResultGrid().getHeaderPositions(), row);
			if ( firstRecord == null )
				firstRecord = record;

			records[i] = record;
			onHowMLoadRecord(record);
			i ++;
		}
		return firstRecord;
	}
	
	protected void onHowMLoadRecord(HowMGWTDataRecord record){		
	}
	
	protected void onShowResult(HowMGWTEntity result ){
 
		this.getResultGrid().setShowRecordComponents(true);          
		this.getResultGrid().setShowRecordComponentsByCell(true);  
		
		ListGridRecord[] records = new ListGridRecord[result.getData().size()];
		HowMGWTDataRecord firstRecord =  onLoadData(result, records);
		
		this.getResultGrid().setData(records);
		
		HowMProperty pMessage   = result.getParameters().get(Fabrica.NAVEGATE_FLAG_MESSAGE);
		
		// Se a execução da consulta foi disparada pelo timer, então não mostra 
		//o alerta ao usuório.
		if ( result.getData().size() == 0){
			HowMGWTWindowWait.hideWait();
			// winModal.hide();
			if ( showNavigate ){
		    	this.actionFirst.setDisabled(true);
		    	this.actionPreview.setDisabled(true);
		    	this.actionNext.setDisabled(true);
		    	this.actionLast.setDisabled(true);		
			}
		    SC.say(Tradutor.i18n.alertNaoEncontrouRegistros());
		}
		else{
			if( showNavigate ){
				HowMProperty pFirstPage = result.getParameters().get(Fabrica.NAVEGATE_FLAG_FIST_PAGE);
				HowMProperty pPrevPage  = result.getParameters().get(Fabrica.NAVEGATE_FLAG_PREVIEW_PAGE);
				HowMProperty pNextPage  = result.getParameters().get(Fabrica.NAVEGATE_FLAG_NEXT_PAGE);
				HowMProperty pLastPage  = result.getParameters().get(Fabrica.NAVEGATE_FLAG_LAST_PAGE);

				this.actionFirst.setDisabled(!pFirstPage.getValueBoolean().booleanValue());
		    	this.actionPreview.setDisabled(!pPrevPage.getValueBoolean().booleanValue());
		    	this.actionNext.setDisabled(!pNextPage.getValueBoolean().booleanValue());
		    	this.actionLast.setDisabled(!pLastPage.getValueBoolean().booleanValue());

			}			
			hideWindowWait();
	    	
		}
		if ( showNavigate ){
			message.setMargin(4);
			message.setHowMValue(pMessage.getValue());
		}		
		if( firstRecord != null ){
			this.getResultGrid().selectRecord(0);
			onEventHowMGWTSelectFirstRecord(firstRecord);	
		}
		this.resultGrid.onHowMFinishLoadDatabaseRecord(firstRecord, result.getData().size() );
		
	}

	protected void hideWindowWait(){
		Timer timer = new Timer(){
			public void run() 
			{
				HowMGWTWindowWait.hideWait();
			};
		};
		timer.schedule(50*1);
	}
 
	protected abstract boolean onHowMPrepareFind(HowMGWTEntity entity);
	
	
	/**
	 * Inicializa a busca dos dados no servidor.
	 */
	public void startBuscar(){
    	getMethod().setValue(Fabrica.NAVEGATE_ACTION_BUSCAR);
		this.onHowMBuscar(true);
	}
	
	
	/**
	 * Encaminha a requisição para o servidor para executar a consulta.
	 */
	private boolean onHowMBuscar(boolean check) {
		
		
		if ( check ){
			if ( ! onHowMPrepareFind(this.currentEntity) )
				return false;
		}
		
		HowMGWTWindowWait.showWait();
 
//		Timer executeTimer = new Timer() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//			}
//		};

		
		this.currentEntity.getData().clear();		
		
		this.resultGrid.setData(new ListGridRecord[0]);

		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
			
				public void onFailure(Throwable caught) {
					HowMGWTWindowWait.hideWait();
					caught.printStackTrace();
					com.google.gwt.user.client.Window.alert(caught.getMessage());
				}

				public void onSuccess(HowMGWTEntity result) {
					if ( result.getThrowable() != null ){
						result.getThrowable().printStackTrace();
						com.google.gwt.user.client.Window.alert(result.getThrowable().toString());
						HowMGWTWindowWait.hideWait();
					}
					else
						onShowResult(result);
				}
		};
		currentEntity.setAction(this.getActionClass());
		Configuracao.getProxyStruts().executeQuery(this.currentEntity, callback);
		return true;
	}
	
	/**
	 * @return the actionClass
	 */
	public String getActionClass() {
		return actionClass;
	}	
	
	/**
	 * @return the method
	 */
	public HowMProperty getMethod() {
		return method;
	}

	/**
	 * @return the resultGrid
	 */
	public HowMGWTListGrid getResultGrid() {
		return resultGrid;
	}

	/**
	 * @param resultGrid the resultGrid to set
	 */
	public void setResultGrid(HowMGWTListGrid resultGrid) {
		this.resultGrid = resultGrid;
	}

	/**
	 * @return the createActionBuscar
	 */
	public boolean isCreateActionBuscar() {
		return createActionBuscar;
	}

	/**
	 * @param createActionBuscar the createActionBuscar to set
	 */
	public void setCreateActionBuscar(boolean createActionBuscar) {
		this.createActionBuscar = createActionBuscar;
	}

	/**
	 * @return the currentEntity
	 */
	public HowMGWTEntity getCurrentEntity() {
		return currentEntity;
	}

	/**
	 * @param currentEntity the currentEntity to set
	 */
	public void setCurrentEntity(HowMGWTEntity currentEntity) {
		this.currentEntity = currentEntity;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(HowMProperty method) {
		this.method = method;
	}

	/**
	 * @param actionClass the actionClass to set
	 */
	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}	

	/**
	 * Evento disparado no termino da consulta 
	 * @param record
	 */
	public void onEventHowMGWTSelectFirstRecord(Record record){}
		
	
	/**
	 * Remove os botões de navegação, normalmente utilizado quando 
	 * utilizado em conjunto com cache.
	 */
	public void hideNavegateButton(){
    	this.removeMember(actionFirst);
    	this.removeMember(actionPreview);
    	this.removeMember(actionNext);
    	this.removeMember(actionLast);
    	this.showNavigate = false;
	}
	
	public void executeQuery(){
    	getMethod().setValue(Fabrica.NAVEGATE_ACTION_BUSCAR);
    	onHowMBuscar(true);
	}
}