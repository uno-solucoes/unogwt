package com.br.client.panel.sg.sgw0027.UI;

import java.util.TreeMap;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.Services;
import com.br.client.panel.sg.sgw0027.model.ENFSE;
import com.br.client.panel.sg.sgw0027.model.eConstants;
import com.br.client.panel.sg.sgw0027.model.eNFSEProtocolo;
import com.br.client.panel.vd.vdw0004.NotasFiscais;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.rebind.FieldReference;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.UI.HowMGWTWindowDocumentHTML;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTDataRecord;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ContentsType;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.TextAreaWrap;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.KeyDownEvent;
import com.smartgwt.client.widgets.events.KeyDownHandler;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
 
public class ResultadoConsulta extends HowMGWTListGrid {
	
	private NotasFiscais notaFiscais;
	
	private boolean issIntel 	= false;
	private boolean ginfes		= false;
	private boolean g2ka		= false;
	private boolean vinhedo		= false;
	private boolean issDigital	= false;
	private String padrao 		= "UNO";
	
    private PainelNFSE painelNFSE;
    private VLayout paneHelp;

    private Window windowShowXML 		= new Window();
    private TextAreaItem messageShowXML = new TextAreaItem();  
    
    private Window windowShowHTML       = new Window();
    private HTMLPane messageShowHTML 	= new HTMLPane();
    
    private HTMLPane messageShowNFSE    = new HTMLPane();  

    private String pathNFSE 			= "";
    
    private String nomeModelo			= "";
    
	private int timerSecunds = 30;
	private Timer timer;
	private FiltroConsulta filtroConsulta;
	
	private boolean arquivoRemessa 		= false;
	private boolean webService			= false;

	private ListGridField fieldSelect 		= new ListGridField("fieldSelect", 	"Sel.", 	                    28);	// 0
	private ListGridField fieldFlag 		= new ListGridField("flagControl", 	"", 	                        20);	// 1
	private ListGridField fieldArqRPS		= new ListGridField("arqRps", 		Tradutor.i18n.formArqRps(), 	56);	// 2
	private ListGridField fieldCodPedido	= new ListGridField("codPedido", 	Tradutor.i18n.formCodPedido(), 	66);  	// 3
	private ListGridField fieldDataEmissao	= new ListGridField("dataEmissao", 	Tradutor.i18n.formDtEmissao(), 	66);	// 4
	private ListGridField fieldSituacao		= new ListGridField("situacao",		Tradutor.i18n.formSituacao(),	80);	// 5
	private ListGridField fieldCliente		= new ListGridField("cliente", 	 	Tradutor.i18n.formNomeCliente(), 	180); 	// 6
	private ListGridField fieldValor		= new ListGridField("valor", 		Tradutor.i18n.formValor(), 		80);	// 7
	private ListGridField fieldToolbar      = new ListGridField("toolbar",      " ",						    100);	// 8
	private ListGridField fieldCodNumeroNF	= new ListGridField("codNumeroNF",  "Numero NF",					75);	// 9
	private ListGridField fieldNomeArqNF    = new ListGridField("nomeArqNF",	"Arq NF",						75);	// 10
	private ListGridField fieldRegistro     = new ListGridField("registro",		"registro",						75);	// 11
	private ListGridField fieldIdNfse       = new ListGridField("idNfse",		"ID NFS-e",						65);	// 12
	private ListGridField fieldIdAtividade  = new ListGridField("IdAtividade",	"Atividade",					75);	// 13
	private ListGridField fieldIconAtividade= new ListGridField("IconAtividade","IconAtividade",				75);	// 14
	public ListGridField fieldNrNfse		= new ListGridField("NrNfse",		"NFS-e",						65);	// 15

	private ListGridField fieldRegistroUI	= new ListGridField("RegistroUI",		"#Reg.",						50);	// 16
	
	public ResultadoConsulta(){
	 
		initUI();
		
		windowShowXML.setWidth(600);
		windowShowXML.setHeight(600);
		windowShowXML.setTitle(Tradutor.i18n.visualizarArquivo());
		windowShowXML.setShowMinimizeButton(false);
		windowShowXML.setCanDragResize(true);
		windowShowXML.setCanDragReposition(true);
			
		messageShowXML.setShowTitle(false);  
		messageShowXML.setLength(10000);  
		messageShowXML.setWidth("*");  
		messageShowXML.setHeight("*");
		messageShowXML.setWrap(TextAreaWrap.OFF);
		
		windowShowHTML.setWidth(1000);
		windowShowHTML.setHeight(640);
		windowShowHTML.setTitle(Tradutor.i18n.visualizarArquivo());
		windowShowHTML.setShowMinimizeButton(false);
		windowShowHTML.setCanDragResize(true);
		windowShowHTML.setCanDragReposition(true);
		
		VLayout vMessageHTML = new VLayout();
		vMessageHTML.setWidth100();
		vMessageHTML.setHeight100();		

		messageShowHTML.setShowEdges(true);  
		messageShowHTML.setContentsType(ContentsType.PAGE);
		vMessageHTML.addMember(messageShowHTML);
		
		windowShowHTML.addItem(vMessageHTML);
		
		
		messageShowNFSE.setWidth100();
		messageShowNFSE.setHeight100();

        DynamicForm form = new DynamicForm();
        form.setNumCols(1);
        form.setWidth100();
        form.setHeight100();
        form.setItems(messageShowXML);
        form.setColWidths("*");
        windowShowXML.addItem(form);
        
        setShowRecordComponents(true);          
        setShowRecordComponentsByCell(true);
        
        setEditEvent(ListGridEditEvent.CLICK);

        fieldFlag.setHidden(true);
        fieldCodNumeroNF.setHidden(true);
        fieldNomeArqNF.setHidden(true);
        fieldRegistro.setHidden(true);
        fieldIdNfse.setHidden(true);
        fieldIdAtividade.setHidden(true);
        fieldIconAtividade.setHidden(true);
        
        
        
        fieldValor.setAlign(Alignment.RIGHT);
        fieldRegistroUI.setAlign(Alignment.CENTER);
        
        fieldSelect.setCanDragResize(false);
        fieldToolbar.setCanDragResize(false);
        
        fieldNrNfse.setAlign(Alignment.CENTER);
        
        this.setCanAutoFitFields(false);
        
        for ( ListGridField field :  this.getFields()){
        	field.setCanHide(false);
        	field.setCanReorder(false);
        	field.setCanGroupBy(false);
        	field.setCanFreeze(false);
        	field.setCanSort(false);
        	field.setCanSortClientOnly(false);
       
        }
	}

	public void initUI(){
		
		this.setDataPageSize(1000);

		CellFormatter formatterDouble = new CellFormatter() {
	        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
	            if(value == null) return null;
	            try{
	            	return "R$ "+NumberFormat.getFormat("###,###,###,###,###,###,###.00").format(new Double(value.toString()));
	            }
	            catch(Throwable er){
	            	return "R$ "+value.toString();
	            }
	        }
		};
		fieldValor.setCellFormatter(formatterDouble);
 
		this.setFields(
				fieldSelect,
				fieldFlag,
				fieldArqRPS,
				fieldCodPedido,
				fieldDataEmissao,	
				fieldSituacao,
				fieldCliente,
				fieldValor,
				fieldToolbar,
				fieldCodNumeroNF,
				fieldNomeArqNF,
				fieldRegistro,
				fieldIdNfse,
				fieldIdAtividade,
				fieldIconAtividade,
				fieldNrNfse,
				fieldRegistroUI
		);

		this.addKeyPressHandler(new KeyPressHandler() {
			
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if ( "F6".equalsIgnoreCase(event.getKeyName()))
					setModeAdmin(true);
				else if ( "F7".equalsIgnoreCase(event.getKeyName()))
					setModeAdmin(false);
			}
		});
		
		this.setCanResizeFields(true);		
		this.setHeaderHeight(25);
		// não alterar esta situação para false, pois da problema nesta tela.
		this.setShowAllRecords(true);
		
		onHowMInitEntityControl(); 
	}
 
    @Override  
    protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {  

    	if ( getFieldName(colNum).equals("idNfse") ){
    		return "color:blue; font-weight:bold;";
    	}
    	if ( getFieldName(colNum).equals("RegistroUI")){
    		String css = "";
    		css += "font-wight:bold; color:#104E8B; background-color: rgb(225,225,225);";
    		return css;
    	}
        return super.getCellCSSText(record, rowNum, colNum);  
    }  
    
    @Override
    protected String getCellStyle(ListGridRecord record, int rowNum, int colNum) {
    	// TODO Auto-generated method stub
    	return super.getCellStyle(record, rowNum, colNum);
    }
    
    @Override
    protected String getBaseStyle(ListGridRecord record, int rowNum, int colNum) {
    	// TODO Auto-generated method stub
    	return super.getBaseStyle(record, rowNum, colNum);
    }
    

	/**
	 * @return the filtroConsulta
	 */
	public FiltroConsulta getFiltroConsulta() {
		return filtroConsulta;
	}


	/**
	 * @param filtroConsulta the filtroConsulta to set
	 */
	public void setFiltroConsulta(FiltroConsulta filtroConsulta) {
		this.filtroConsulta = filtroConsulta;
	}
	
	


	/**
	 * @return the timerSecunds
	 */
	public int getTimerSecunds() {
		return timerSecunds;
	}

	/**
	 * @param timerSecunds the timerSecunds to set
	 */
	public void setTimerSecunds(int timerSecunds) {
		this.timerSecunds = timerSecunds;
	}
	
	 
	/**
	 * Permite criar componentes para representar ações dentro da grid.
	 */
	@Override
	protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) {
		String fieldName = this.getFieldName(colNum);

		if ( fieldName.equalsIgnoreCase(fieldSelect.getName())){
			ToolbarRecord toolbar = ToolbarRecord.getCreateOrObject(record, this);
			toolbar.getActionDonwload().setPath(pathNFSE);
			return toolbar.getLayoutActionSelect();
		}
		else if ( fieldName.equalsIgnoreCase(fieldToolbar.getName())){
			ToolbarRecord toolbar = ToolbarRecord.getCreateOrObject(record, this);
			toolbar.getActionDonwload().setPath(pathNFSE);
			return toolbar;
		}
		else
			return super.createRecordComponent(record, colNum);
	}	
	
	
	
	
	
	
	// --------------------------------------------------------------------------------------
	// Comunicação com o servidor de aplicação.
	// --------------------------------------------------------------------------------------
	
	/**
	 * Encaminha a requisição para o servidor para executar a consulta.
	 */
	public void buscar() {

		this.getPainelNFSE().getTabSetManager().selectTab(0); 
		
		HowMGWTWindowWait.showWait();
 
		this.setData(new ListGridRecord[0]);

		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
			
				public void onFailure(Throwable caught) {
					caught.printStackTrace();
					com.google.gwt.user.client.Window.alert(Tradutor.i18n.msgEnderecoBase()+GWT.getHostPageBaseURL()+"\n"+caught.getMessage());
				}

				public void onSuccess(HowMGWTEntity result) {
					if ( HowMGWTUtilities.isAnalyseEntityIsError(result) ){
						return;
					}else
						showResult(result);
				}
		};

		HowMGWTEntity entity = Fabrica.createEntity();
		
		HowMProperty pDataInicio 	= new HowMProperty("periodoInicial", this.filtroConsulta.getFieldPeriodoInicial().getValueAsDate());
		entity.getParameters().put(pDataInicio.getName(), pDataInicio);
		
		HowMProperty pDataFim 		= new HowMProperty("periodoFinal", this.filtroConsulta.getFieldPeriodoFinal().getValueAsDate());
		entity.getParameters().put(pDataFim.getName(), pDataFim);
			
		HowMProperty pCodCliente 		= new HowMProperty("codigoCliente", this.filtroConsulta.getFieldCodigoCliente().getField().getHowMValueAsString() );
		entity.getParameters().put(pCodCliente.getName(), pCodCliente);

		Boolean naoEnviados = this.filtroConsulta.getFieldNaoEnviados().getValueAsBoolean();
		if ( naoEnviados == null )
			naoEnviados = new Boolean(false);
		HowMProperty pNaoEnviados 		= new HowMProperty("naoEnviados", naoEnviados );

		entity.getParameters().put(pNaoEnviados.getName(), pNaoEnviados);
	
		HowMProperty pAcao      	= new HowMProperty("acao", "buscaNotas");
		entity.getParameters().put(pAcao.getName(), pAcao);
		entity.setAction(Services.acaoVDW0027);
		
		Configuracao.getProxyStruts().executeQuery(entity, callback);
	}    
	
	/**
	 * Apresenta o resultado da consulta 
	 * @param result
	 */	
	public void showResult(HowMGWTEntity result ){
		
		ListGridRecord[] records = new ListGridRecord[result.getData().size()];
		 
		HowMGWTDataRecord record;
		int i = 0;
		for ( String[] row : result.getData()){
			record = new HowMGWTDataRecord(this, this.getHeaderPositions(),row);
			records[i] = record;
			i ++;
		}
		this.setData(records);		
		this.show();
		
		if ( result.getData().size() == 0){
			HowMGWTWindowWait.hideWait();
			SC.say(Tradutor.i18n.alertNaoEncontrouRegistros());
		}
		else{
			HowMGWTWindowWait.hideWait();
		}
	}	
	
	
	String modeAdmin = "0";
	public String getModeAdmin(){
		return modeAdmin;
	}
	
	public void setModeAdmin(boolean modeAdmin){
		if ( modeAdmin )
			this.modeAdmin = "1";
		else
			this.modeAdmin = "0";
	}
	

	/**
	 * Encaminha a requisição para o servidor para executar a consulta.
	 */
	public void enviar() {

		HowMGWTEntity entity = Fabrica.createEntity();
		int limit = this.getTotalRows();
		
		ListGridRecord record;
		
		// recupera os registros selecionados para enviar as notas para a prefeitura.
		for ( int i = 0; i < limit ; i++ ){
			record = this.getRecord(i);
			if ( new Boolean(record.getAttribute(this.fieldSelect.getName() ) ).booleanValue() ){
				String[] row = ENFSE.convertRecordToRow(record, this);
				row[this.getHeaderPositions().get("registro").intValue()] = ""+i;
				entity.getData().add(row);
				;
			}
		}
		if ( entity.getData().size() == 0  ){
			SC.say(Tradutor.i18n.msgNaoHaItemSelecionadosParaEnvio());
			return;
		}

		HowMGWTWindowWait.showWait();
 
		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
			public void onFailure(Throwable caught) {
				HowMGWTWindowWait.hideWait();
				caught.printStackTrace();
				com.google.gwt.user.client.Window.alert(Tradutor.i18n.msgEnderecoBase()+GWT.getHostPageBaseURL()+"\n"+caught.getMessage());
			}

			public void onSuccess(HowMGWTEntity result) {
				if ( HowMGWTUtilities.isAnalyseEntityIsError(result) ){
					;
				}
				else{
					HowMGWTWindowWait.hideWait();
					
					HowMProperty pErro = result.getParameters().get("erro");
					// Ocorreu erro durante o processamento.
					if ( pErro != null ){
						HowMGWTWindowDocumentHTML.showDocument("<pre>"+pErro.getValue()+"</pre>");
						Scheduler.get().scheduleDeferred( new Scheduler.ScheduledCommand(){
							
							@Override
							public void execute() {
								buscar();
							}
						});

						return;
					}
					HowMProperty pLog = result.getParameters().get("log");
					// não validou nota fiscal 
					if ( pLog != null ){
						HowMProperty pRegistro = result.getParameters().get("registro");
						int registro = new Integer(pRegistro.getValue()).intValue();
						
						System.out.println("pLog : "+pLog.getValue());
						// String row[] = result.getData().get(registro);
						
						messageShowHTML.setContents("<html><body>"+pLog.getValue()+"</body></html>");
						
						windowShowHTML.centerInPage();
						windowShowHTML.show();
						
						
						return;
					}

					
					for ( String[] row : result.getData() ){
						int idRow = new Integer(row[getHeaderPositions().get(fieldRegistro.getName())]).intValue();
						if ( idRow >= 0 ){
							ListGridRecord record = getRecord(idRow);
							ToolbarRecord.getCreateOrObject(record, ResultadoConsulta.this).refreshTools(row, ResultadoConsulta.this);
							refreshRow(idRow);
						}
					}
					HowMProperty pPath = result.getParameters().get("PATH");
					if ( pPath != null  ){
	
						HowMProperty pFileName = result.getParameters().get("FILE_NAME");
							
		            	String url = "";
		            	url += Configuracao.getNativeUnoUrlServiceDonwload();
		            	if ( url.endsWith("/"));
		            	else
		            		url += "/";
		            	url += "unogwt/HowMDownload?PATH="+pPath.getValue()+"&FILE_NAME="+pFileName.getValue();

		            	final String urlOpen = url;
		            	Timer timer = new Timer() {
							
							@Override
							public void run() {
								// System.out.println("URL: "+urlOpen);
				            	com.google.gwt.user.client.Window.open(urlOpen, "DONWLOAD1", "");						
							}
						};	
						timer.schedule(60);
					}
				}
			}
		};

		HowMProperty pAcao      	= new HowMProperty("acao", "enviarNFSE");
		
		entity.getParameters().put(pAcao.getName(), pAcao);
	
		HowMProperty pDataInicio = new HowMProperty("dataInicial", this.getFiltroConsulta().getFieldPeriodoInicial().getValueAsDate());
		entity.getParameters().put(pDataInicio.getName(), pDataInicio);
		
		HowMProperty pDataFinal = new HowMProperty("dataFinal", this.getFiltroConsulta().getFieldPeriodoFinal().getValueAsDate());
		entity.getParameters().put(pDataFinal.getName(), pDataFinal);
		
		entity.setAction(Services.acaoVDW0027);

		Configuracao.getProxyStruts().executeQuery(entity, callback);
	}
		
	
	
	
	
	/**
	 * Encaminha a requisição para o servidor para executar a consulta.
	 */
	public void excluir(ListGridRecord currentRecord, final eNFSEProtocolo protocolo) {
 
		HowMGWTWindowWait.showWait();
 
		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
			
				public void onFailure(Throwable caught) {
					HowMGWTWindowWait.hideWait();
					caught.printStackTrace();
					com.google.gwt.user.client.Window.alert(Tradutor.i18n.msgEnderecoBase()+GWT.getHostPageBaseURL()+"\n"+caught.getMessage());
				}

				public void onSuccess(HowMGWTEntity result) {
					
					if ( HowMGWTUtilities.isAnalyseEntityIsError(result)){
						return;
					}else{
						HowMGWTWindowWait.hideWait();
						// Verifica se o cancelamento foi em lote.
						if ( result.getDetailEntities().size() > 0 ){

							ListGridRecord[] records = getRecords();
						
							TreeMap<String, ListGridRecord> map = new TreeMap<String, ListGridRecord>();
							for ( ListGridRecord record : records){
								map.put(record.getAttribute(fieldCodNumeroNF.getName()), record);
							}

							String codNotaFiscal;
							ListGridRecord record;
							for( String[] row : result.getDetailEntities().get(0).getData() ){
								codNotaFiscal = row[0];
								record = map.get(codNotaFiscal);
								int idRow = getRecordIndex(record);
								if( record != null ){
									
									if ( HowMGWTUtilities.isEmpty( result.getParameters().get("pendenteParaEnvio"))){
										ToolbarRecord.getCreateOrObject(record, ResultadoConsulta.this).setIdAtividade(eConstants.ATIVIDADE_PENDENTE_PARA_ENVIO);
										ToolbarRecord.getCreateOrObject(record, ResultadoConsulta.this).setIconAtividade("nfe/nfe_send.png" );										
									}
									// Se tiver motivo, é G2kA e é cancelamento de NFS-e na prefeitura.
									else if ( HowMGWTUtilities.isEmpty( result.getParameters().get("atividadeCancelamento") ) ){
										ToolbarRecord.getCreateOrObject(record, ResultadoConsulta.this).setIdAtividade(eConstants.ATIVIDADE_AGUARDANDO_CANCELAMENTO_NFSE_NA_PREFEITURA);
										ToolbarRecord.getCreateOrObject(record, ResultadoConsulta.this).setIconAtividade("nfe/nfe_wait_delete.png" );
									}
									ToolbarRecord.getCreateOrObject(record, ResultadoConsulta.this).refreshToolsCancel();
									refreshRow(idRow);
								}
							}
						}
						else{
							for ( String[] row : result.getData() ){
								int idRow = new Integer(row[getHeaderPositions().get(fieldRegistro.getName())]).intValue();
								if ( idRow >= 0 ){
									ListGridRecord record = getRecord(idRow);
									ToolbarRecord.getCreateOrObject(record, ResultadoConsulta.this).refreshTools(row, ResultadoConsulta.this);
									refreshRow(idRow);
								}
							}
						}
					}
				}
		};

		HowMGWTEntity entity = Fabrica.createEntity();
		
		int limit = this.getTotalRows();
		
		String codNrNumeroNota = currentRecord.getAttribute("codNumeroNF");		

		String[] row = ENFSE.convertRecordToRow(currentRecord, this);
		row[this.getHeaderPositions().get("registro").intValue()] = ""+this.getRecordIndex(currentRecord);
		entity.getData().add(row);	 
		
		HowMProperty pCodNumeroNota 	= new HowMProperty("codNrNumeroNota", codNrNumeroNota );
		entity.getParameters().put(pCodNumeroNota.getName(), pCodNumeroNota);
	
		HowMProperty pAcao      	= new HowMProperty("acao", "excluirEnvio");
		entity.getParameters().put(pAcao.getName(),pAcao);
		
		if( protocolo != null ){
			Fabrica.createParameter(entity, "idProtocolo", 		protocolo.getIdProtocolo() );
			Fabrica.createParameter(entity, "padrao",     		protocolo.getNomeModeloIntegracao());
			Fabrica.createParameter(entity, "versao",      		protocolo.getNomeVersaoIntegracao());
			Fabrica.createParameter(entity, "tipoEnvio",   		protocolo.getTpEnvio());

			
			HowMProperty pModoAdministrador = new HowMProperty("cancelarNrNFSeAdmin", getModeAdmin());
			entity.getParameters().put(pModoAdministrador.getName(), pModoAdministrador);			

			if ( ! HowMGWTUtilities.isEmpty( protocolo.getMotivoCancelamento())){
				Fabrica.createParameter(entity, "cancelarNrNFSe", 	currentRecord.getAttribute(fieldNrNfse.getName())  );
				Fabrica.createParameter(entity, "motivoCancelamento" , protocolo.getMotivoCancelamento() );
			}
		}
		else
			Fabrica.createParameter(entity, "padrao",      getNomeModelo() );

		entity.setAction(Services.acaoVDW0027);
		
		Configuracao.getProxyStruts().executeQuery(entity, callback);
	}
	
	
	/**
	 * Encaminha a requisição para o servidor para executar a consulta.
	 */
	public void showXML(ListGridRecord currentRecord) {
 
		HowMGWTWindowWait.showWait();

		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
			
				public void onFailure(Throwable caught) {
					HowMGWTWindowWait.hideWait();
					caught.printStackTrace();
					com.google.gwt.user.client.Window.alert(Tradutor.i18n.msgEnderecoBase()+GWT.getHostPageBaseURL()+"\n"+caught.getMessage());
				}

				public void onSuccess(HowMGWTEntity result) {
					if ( HowMGWTUtilities.isAnalyseEntityIsError(result)){
						return;
					}else{
						HowMGWTWindowWait.hideWait();
						
						HowMProperty pXML = result.getParameters().get("xml");
						messageShowXML.setValue(pXML.getValue());
						
				        windowShowXML.centerInPage();
				        windowShowXML.show();
				        
					}
				}
		};
		HowMGWTEntity entity = Fabrica.createEntity();	
		
		String codNrNumeroNota = currentRecord.getAttribute("codNumeroNF");		
		HowMProperty pCodNumeroNota 	= new HowMProperty("codNrNumeroNota", codNrNumeroNota );
		entity.getParameters().put(pCodNumeroNota.getName(), pCodNumeroNota);
		
		String fileName        = currentRecord.getAttribute(fieldNomeArqNF.getName());
		if ( fileName != null ){
			fileName = fileName.replaceAll("OS:", "");
			fileName = fileName.replaceAll("WS:", "");			
		}
		HowMProperty pFileName 	= new HowMProperty("fileName", fileName );
		entity.getParameters().put(pFileName.getName(), pFileName);
		
	
		HowMProperty pAcao      	= new HowMProperty("acao", "visualizarXML");
		entity.getParameters().put(pAcao.getName(),pAcao);
		
		entity.setAction(Services.acaoVDW0027);

		Configuracao.getProxyStruts().executeQuery(entity, callback);
	}

	
	public void setSelectRecords(boolean select){
		int limit = this.getTotalRows();
		ListGridRecord record;
		ToolbarRecord toolbar;
		// recupera os registros selecionados para enviar as notas para a prefeitura.
		for ( int i = 0; i < limit ; i++ ){
			record = this.getRecord(i);
			toolbar = ToolbarRecord.getCreateOrObject(record, this);
			if ( toolbar.isRPSEnviada() )
				continue;
			else{
				record.setAttribute(ToolbarRecord.getSelect(),""+select);
				toolbar.refreshTools(record, this);
			}
		}
	}
	
	
	public void loadParameters(){
		
		Canvas[] itens = paneHelp.getChildren();
		for ( Canvas item : itens ){
			paneHelp.removeChild(item);
		}
		
		HowMGWTWindowWait.showWait();


		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
			
				public void onFailure(Throwable caught) {
					HowMGWTWindowWait.hideWait();
					caught.printStackTrace();
					com.google.gwt.user.client.Window.alert(Tradutor.i18n.msgEnderecoBase()+GWT.getHostPageBaseURL()+"\n"+caught.getMessage());
				}

				public void onSuccess(HowMGWTEntity result) {
					if ( HowMGWTUtilities.isAnalyseEntityIsError(result)){
						return;
					}else{
						HowMGWTWindowWait.hideWait();
						configureParametes(result);
					}
				}
		};
		HowMGWTEntity entity = Fabrica.createEntity();	

		HowMProperty pAcao      	= new HowMProperty("acao", "loadParameters");
		entity.getParameters().put(pAcao.getName(),pAcao);
		
		entity.setAction(Services.acaoVDW0027);

		Configuracao.getProxyStruts().executeQuery(entity, callback);
	}
	
	/**
	 * Tratamento Configuração tipo padrão utilizado para emissão da NFS-e.
	 * @param indWebService Indicador se é arquivo ou web services
	 * @param url Url onde está configurado o padrão de integração NFS-e.
	 * @return Retorna 0 para arquivo e 1 para web services.
	 */
	public void configureFlags(String url){

		this.setIssIntel(false);
		this.setGinfes(false);
		this.setG2ka(false);
		this.setVinhedo(false);
		this.setIssDigital(false);

		if ( url.startsWith(eConstants.SISTEMA_ISSINTEL    )){
			this.setIssIntel(true);
			padrao = eConstants.SISTEMA_ISSINTEL;
		}
		else if ( url.startsWith(eConstants.SISTEMA_GINFES  	)){
			this.setGinfes(true);
			padrao = eConstants.SISTEMA_GINFES;
		}
		else if ( url.startsWith(eConstants.SISTEMA_G2KA    	)){
			this.setG2ka(true);
			padrao = eConstants.SISTEMA_G2KA;
		}
		else if ( url.startsWith(eConstants.SISTEMA_VINHEDO 	)){
			this.setVinhedo(true);
			padrao 			= eConstants.SISTEMA_VINHEDO;
		}
		else if ( url.startsWith(eConstants.SISTEMA_ISSDIGITAL 	)){
			this.setIssDigital(true);
			padrao = eConstants.SISTEMA_ISSDIGITAL;
		}
	}	
	
	
	/**
	 * Analisa os parametros e gera um check-list com indicadores se está tudo ok para emissão 
	 * da RPS ou se falta alguma informação.
	 * @param entity
	 */
	public void configureParametes(HowMGWTEntity entity){
		
		String padrao 	= null;
		String url 		= null;
		
		HowMProperty pUrlWebServices 		= entity.getParameters().get( "urlWebServiceRPS"	);
    	HowMProperty pUrlCertificadoRPS 	= entity.getParameters().get( "urlCertificadoRPS"	);
    	HowMProperty pSenhaCertificadoRPS 	= entity.getParameters().get( "senhaCertificadoRPS"	);
    	HowMProperty pCodAtividadeRPS 		= entity.getParameters().get( "codAtividadeRPS"		);
    	HowMProperty pInscricaoMunicipal 	= entity.getParameters().get( "inscricaoMunicipal"	);
    	HowMProperty pCodMunicipio 			= entity.getParameters().get( "codMunicipio"		);
    	HowMProperty pNomeMunicipio 		= entity.getParameters().get( "nomeMunicipio"		);
    	HowMProperty pEmpresaCNPJ			= entity.getParameters().get( "empresaCNPJ"			);
 
    	HowMProperty pPathNFSE		 		= entity.getParameters().get( "pathNFSE"			);
    	if ( pPathNFSE != null && pPathNFSE.getValue() != null && pPathNFSE.getValue().trim().length() > 0 )
    		pathNFSE = pPathNFSE.getValue();
    	else 
    		pathNFSE = "";
    	
    	// Analisa e seta as flags para indicar qual o padrão e o tipo de serviço que será 
    	// tratado pela interface do usuório.
    	configureFlags(pUrlWebServices.getValue());
    	
    	// System.out.println("Path : "+pathNFSE);

    	String negative = "negativo.png";
    	String positive = "positivo.png";
    	int heightDefault = 22;
    	
    	boolean utilizaCertificado = false;
    	
    	HowMProperty pPadraoPrefeitura = entity.getParameters().get("padraoPrefeitura");
    	HowMProperty pSitePrefeitura = entity.getParameters().get("sitePrefeitura");		

    	if ( pUrlWebServices != null && pUrlWebServices.getValue() != null){
    		if ( pUrlWebServices.getValue() != null ){
    			int idx = pUrlWebServices.getValue().indexOf(":");
    			if ( idx < 0 ){
    				this.addTask(negative, "Serviço não informado", heightDefault );
    				this.addTask(negative, "Padrão não definido" , heightDefault);
    			}
    			else{
    				if ( pUrlWebServices.getValue().toUpperCase().startsWith("HTTP")){
           				this.addTask(positive, "Web Services" , heightDefault );
        				this.addTask(negative, "Padrão não definido" , heightDefault );     					
    				}
    				else{
    					url 	= pUrlWebServices.getValue().substring(idx+1);
    					padrao 	= pUrlWebServices.getValue().substring(0,idx);
    					
    					// System.out.println("Padrao : "+padrao);
    					if ( "ARQUIVO".equals(padrao) ){
    						this.addTask(positive, "Comunicacao Manual - <b>Arquivo remessa</b>" ,heightDefault);
	        				this.addTask(positive, "Padrão : <b>"+padrao+"</b>", heightDefault);
	        				
	        				this.getPainelNFSE().getActionEnviar().setTitle(Tradutor.i18n.formGerarArquivoRemessa());

	        				this.arquivoRemessa = true;
	        				if ( pPadraoPrefeitura != null && pSitePrefeitura != null  ){
	        					if ( eConstants.SISTEMA_GINFES.equals(pPadraoPrefeitura.getValue())){
	        						utilizaCertificado = true;
	        					}	        					
	        				}
    					}
    					else if ( "VINHEDO".equals(padrao) ){
	           				this.addTask(positive, "Comunicacao Manual - <b>Envio de Arquivo</b>" ,heightDefault);
	        				this.addTask(positive, "Padrão : <b>"+padrao+"</b>", heightDefault);
	        				this.arquivoRemessa = false;
    					}
    					else{ 
    						utilizaCertificado  = true;
    						this.arquivoRemessa = false;
    						if ( this.isG2ka() )
    							this.addTask(positive, "Comunicacao Digital Integrada" ,heightDefault);
    						else
    							this.addTask(positive, "Comunicacao Web Services" ,heightDefault);
	           				if ( "ISSINTEL".equals(padrao) || "ISSDIGITAL".equals(padrao) || "GINFES".equals(padrao)  ){
	           					this.addTask(positive, "Padrão : <b>"+padrao+"</b>" , heightDefault );
	    						this.setWebService(true);
	           				}
	           				// Padrão integração G2KA - Cod nome ISSUNO
	           				else if ( this.isG2ka() )
	           					this.addTask(positive, "Padrão : <b>ISSUNO</b>" , heightDefault );
	           				else{
	           					this.addTask(positive, "<font color=red>Padrão <B>"+padrao+"</B> não suportado</color>" , heightDefault);
	    						this.setWebService(false);
	           				}
	           				// Se Padrão G2KA não mostra o serviço.
	           				if ( this.isG2ka() )
	           					;
	           				else
	           					this.addTask(positive, "Serviço : <font color=blue><u>"+url+"</u></font>", 32);
    					}
    				}
    			}
    		}
    	}    
    	if ( utilizaCertificado  ){
    		if ( pUrlCertificadoRPS == null || pUrlCertificadoRPS.getValue() == null || pUrlCertificadoRPS.getValue().trim().length() == 0   )
    			this.addTask(negative, "Certificado não informado", heightDefault );
    		else {
    			this.addTask(positive, "Certificado : <b>"+pUrlCertificadoRPS.getValue() + "</b>" , 30 );
    			if ( pSenhaCertificadoRPS == null || pSenhaCertificadoRPS.getValue() == null || pSenhaCertificadoRPS.getValue().trim().length() == 0 )
        			this.addTask(negative, "Senha do Certificado não informado", heightDefault );
    			else 
        			this.addTask(positive, "Senha do Certificado", heightDefault );    				
    		}
    	}
    	else 
			this.addTask(positive, "Certificado não utilizado" , heightDefault);
    	
    	if( pCodAtividadeRPS == null || pCodAtividadeRPS.getValue() == null || pCodAtividadeRPS.getValue().trim().length() == 0 ) 
    		this.addTask(negative, "Código da Atividade não informado", heightDefault );
    	else
    		this.addTask(positive, "Código da Atividade : <b>"+pCodAtividadeRPS.getValue()+"</b>", heightDefault );
    	
    	if ( pInscricaoMunicipal == null || pInscricaoMunicipal.getValue() == null || pInscricaoMunicipal.getValue().trim().length() == 00)
    		this.addTask(negative, "Inscrição Municipal não informado", heightDefault );
    	else
    		this.addTask(positive, "Inscrição Municipal : <b>"+pInscricaoMunicipal.getValue()+"</b>", heightDefault );
	
    	if ( pCodMunicipio == null || pCodMunicipio.getValue() == null || pCodMunicipio.getValue().trim().length() == 0 ) 
    		this.addTask(negative, "Código Município IBGE não encontrado.", heightDefault );
    	else
    		this.addTask(positive, "Código Município IBGE : <b>"+pCodMunicipio.getValue()+"</b>", heightDefault );
    	
    	if ( pNomeMunicipio == null || pNomeMunicipio.getValue() == null || pNomeMunicipio.getValue().trim().length() == 0 ) 
    		this.addTask(negative, "Prefeitura Municipal não informado.", heightDefault );
    	else
    		this.addTask(positive, "Prefeitura Municipal : <b>"+pNomeMunicipio.getValue()+"</b>", 30 );    	

    	if ( pPadraoPrefeitura != null && pSitePrefeitura != null )
    		this.getPainelNFSE().showSitePrefeitura(pPadraoPrefeitura.getValue(), pSitePrefeitura.getValue());
    	
    	HowMProperty ultimaRPS = entity.getParameters().get("UltimaRPS");
    	if ( ultimaRPS != null && ! isG2ka()){
    		this.getPainelNFSE().getUltimaRPS().setContents("Ultima RPS Gerada na Prefeitura : <B>"+ultimaRPS.getValue()+"</b>");    	
    	}
    	else
    		this.getPainelNFSE().getUltimaRPS().setContents("");
    	
    	if ( pEmpresaCNPJ != null )
    		this.addTask(positive, "CNPJ da Empresa : <b>"+pEmpresaCNPJ.getValue()+"</b>", 20);
	}

	
	private int row = 0;
	public void addTask(String icon, String msg , int height ){
		HLayout hLayout = new HLayout();
		hLayout.setWidth100();
		hLayout.setAutoHeight();
		if( row % 2 == 0 ){
			hLayout.setBackgroundColor(Tradutor.i18n.msgColor());
			hLayout.setBorder(Tradutor.i18n.msgBorder());
		}
		ImgButton imageButton = new ImgButton();
		imageButton.setSrc("check/"+icon);
		imageButton.setShowDown(false);  
		imageButton.setShowRollOver(false);  
		imageButton.setWidth(22);
		imageButton.setHeight(22);
		imageButton.setLayoutAlign(Alignment.CENTER);  		
		hLayout.addMember(imageButton);
		
		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setAlign(VerticalAlignment.CENTER);
		vLayout.setHeight(height);
		
		HTMLPane text = new HTMLPane();
		text.setWidth100();
		text.setContents("<div style='display:table-cell; vertical-align:middle;' >"+msg+"</div>");
		
		vLayout.addMember(text);
		hLayout.addMember(vLayout);
		
		
		this.paneHelp.addMember(hLayout);
		row ++;
	}

	/**
	 * @return the paneHelp
	 */
	public VLayout getPaneHelp() {
		return paneHelp;
	}

	/**
	 * @param paneHelp the paneHelp to set
	 */
	public void setPaneHelp(VLayout paneHelp) {
		this.paneHelp = paneHelp;
	}

	/**
	 * @return the painelNFSE
	 */
	public PainelNFSE getPainelNFSE() {
		return painelNFSE;
	}

	/**
	 * @param painelNFSE the painelNFSE to set
	 */
	public void setPainelNFSE(PainelNFSE painelNFSE) {
		this.painelNFSE = painelNFSE;
	}

	/**
	 * @return the arquivoRemessa
	 */
	public boolean isArquivoRemessa() {
		return arquivoRemessa;
	}

	/**
	 * @param arquivoRemessa the arquivoRemessa to set
	 */
	public void setArquivoRemessa(boolean arquivoRemessa) {
		this.arquivoRemessa = arquivoRemessa;
	}

	/**
	 * @return the webService
	 */
	public boolean isWebService() {
		return webService;
	}

	/**
	 * @param webService the webService to set
	 */
	public void setWebService(boolean webService) {
		this.webService = webService;
	}


	/**
	 * Executa consulta no webServices da prefeitura.
	 * @param currentRecord
	 */
	public void consultarWebService(ListGridRecord currentRecord){

		HowMGWTWindowWait.showWait();

		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
			
				public void onFailure(Throwable caught) {
					HowMGWTWindowWait.hideWait();
					caught.printStackTrace();
					com.google.gwt.user.client.Window.alert(Tradutor.i18n.msgEnderecoBase()+GWT.getHostPageBaseURL()+"\n"+caught.getMessage());
				}

				public void onSuccess(HowMGWTEntity result) {
					if ( HowMGWTUtilities.isAnalyseEntityIsError( result) ){
						return;
					}else{				
						showConsultaWebService(result);
					}
				}
		};

		HowMGWTEntity entity = Fabrica.createEntity();
		
		int limit = this.getTotalRows();
		
		String codNotaFiscal 	= currentRecord.getAttribute("codNumeroNF");
		String idNfse 			= currentRecord.getAttribute("idNfse");		
		// String nrRPS  		= currentRecord.getAttribute("nrRPS");
		String nomeArquivo  	= currentRecord.getAttribute("nomeArqNF");

		String[] row = ENFSE.convertRecordToRow(currentRecord, this);
		row[this.getHeaderPositions().get("registro").intValue()] = ""+this.getRecordIndex(currentRecord);
		entity.getData().add(row);
		
		HowMProperty pCodNumeroNota 	= new HowMProperty("codNumeroNF", codNotaFiscal );
		entity.getParameters().put(pCodNumeroNota.getName(), pCodNumeroNota);

		HowMProperty pIdNfse 	= new HowMProperty("idNfse", idNfse );
		entity.getParameters().put(pIdNfse.getName(), pIdNfse);
		
//		HowMProperty pNrRPS 	= new HowMProperty("idNfse", nrRPS );
//		entity.getParameters().put(pNrRPS.getName(), pNrRPS);
		
		HowMProperty pNomeArquivo 	= new HowMProperty("nomeArqNF", nomeArquivo );
		entity.getParameters().put(pNomeArquivo.getName(), pNomeArquivo);
		
		HowMProperty pAcao      	= new HowMProperty("acao", "consultarWebService" );
		entity.getParameters().put(pAcao.getName(),pAcao);
		
		entity.setAction(Services.acaoVDW0027);
		
		Configuracao.getProxyStruts().executeQuery(entity, callback);
	}

	/**
	 * Apresenta o resultado da consulta para o usuório.
	 * @param result
	 */
	public void showConsultaWebService(HowMGWTEntity result){
		try{
			for ( String[] row : result.getData() ){
				int idRow = new Integer(row[getHeaderPositions().get(fieldRegistro.getName())]).intValue();
				if ( idRow >= 0 ){
					ListGridRecord record = getRecord(idRow);
					ToolbarRecord.getCreateOrObject(record, ResultadoConsulta.this).refreshTools(row, ResultadoConsulta.this);			
					this.refreshRow(idRow);
				}
			}	
			HowMProperty pMessage = result.getParameters().get("Message");
			if( pMessage != null && pMessage.getValue() != null && pMessage.getValue().trim().length() > 0 ){
				if( this.isG2ka() ){
					SC.say("<pre>"+pMessage.getValue()+"</pre>");
				}
				else{
					messageShowXML.setValue(pMessage.getValue());
					windowShowXML.centerInPage();
			        windowShowXML.show();
				}
			}
			
	    	HowMProperty ultimaRPS = result.getParameters().get("UltimaRPS");
	    	if ( ultimaRPS != null && ! isG2ka() ){
	    		this.getPainelNFSE().getUltimaRPS().setContents("Ultima RPS Gerada na Prefeitura : <B>"+ultimaRPS.getValue()+"</b>");    	
	    	}
	    	else
	    		this.getPainelNFSE().getUltimaRPS().setContents("");

		}
		catch(Throwable e){}
		HowMGWTWindowWait.hideWait();
	}

	/**
	 * @return the nomeModelo
	 */
	public String getNomeModelo() {
		return nomeModelo;
	}

	/**
	 * @param nomeModelo the nomeModelo to set
	 */
	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}

	/**
	 * @return the issIntel
	 */
	public boolean isIssIntel() {
		return issIntel;
	}

	/**
	 * @param issIntel the issIntel to set
	 */
	public void setIssIntel(boolean issIntel) {
		this.issIntel = issIntel;
	}

	/**
	 * @return the ginfes
	 */
	public boolean isGinfes() {
		return ginfes;
	}

	/**
	 * @param ginfes the ginfes to set
	 */
	public void setGinfes(boolean ginfes) {
		this.ginfes = ginfes;
	}

	/**
	 * @return the g2ka
	 */
	public boolean isG2ka() {
		return g2ka;
	}

	/**
	 * @param g2ka the g2ka to set
	 */
	public void setG2ka(boolean g2ka) {
		this.g2ka = g2ka;
	}

	/**
	 * @return the vinhedo
	 */
	public boolean isVinhedo() {
		return vinhedo;
	}

	/**
	 * @param vinhedo the vinhedo to set
	 */
	public void setVinhedo(boolean vinhedo) {
		this.vinhedo = vinhedo;
	}

	/**
	 * @return the issDigital
	 */
	public boolean isIssDigital() {
		return issDigital;
	}

	/**
	 * @param issDigital the issDigital to set
	 */
	public void setIssDigital(boolean issDigital) {
		this.issDigital = issDigital;
	}

	/**
	 * @return the padrao
	 */
	public String getPadrao() {
		return padrao;
	}

	/**
	 * @param padrao the padrao to set
	 */
	public void setPadrao(String padrao) {
		this.padrao = padrao;
	}	
	
	public void showNotaFiscalServicoUCommerce(String codNotaFiscal){
		if ( notaFiscais == null ) 
			notaFiscais = new NotasFiscais();
		this.notaFiscais.showConsulta(codNotaFiscal);
	}
	
}