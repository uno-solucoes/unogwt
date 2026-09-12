package com.howmake.client.form.UI;

import java.util.ArrayList;
import java.util.TreeMap;

import org.swfupload.client.File;
import org.swfupload.client.SWFUpload;
import org.swfupload.client.UploadBuilder;
import org.swfupload.client.SWFUpload.ButtonAction;
import org.swfupload.client.SWFUpload.ButtonCursor;
import org.swfupload.client.SWFUpload.WindowMode;
import org.swfupload.client.event.FileDialogCompleteHandler;
import org.swfupload.client.event.FileQueuedHandler;
import org.swfupload.client.event.UploadCompleteHandler;
import org.swfupload.client.event.UploadErrorHandler;
import org.swfupload.client.event.UploadProgressHandler;
import org.swfupload.client.event.UploadStartHandler;
import org.swfupload.client.event.UploadSuccessHandler;
import org.swfupload.client.event.UploadCompleteHandler.UploadCompleteEvent;
import org.swfupload.client.event.UploadErrorHandler.UploadErrorEvent;
import org.swfupload.client.event.UploadProgressHandler.UploadProgressEvent;

import com.br.client.configuracao.Configuracao;
import com.br.client.model.sg.entity.eFile;
import com.br.client.model.sg.sgw0033.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFile;
import com.howmake.client.form.model.HowMGWTFolder;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.BackgroundRepeat;
import com.smartgwt.client.types.BkgndRepeat;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.TreeNode;

public class HowMGWTUploadDialogV2 extends HowMGWTUploadDialog{

//	public static final int STORE_TYPE_FILE			= 1;
//	public static final int STORE_TYPE_DIRECTORY	= 2;
//	public static final int STORE_TYPE_LINK			= 3;
//	
//	private boolean closeAfterSendSucess = false;
//	
//	private JavaScriptObject parentObject;
//	private String action;
//	
//	private String urlDownload;
//	private String rootPath;
//	private String fileTypes			= "*.jar;*.zip;*.pdf;*.doc;*.txt;*.xls;*.asf;*.wma;*.wmv;*.avi;*.flv;*.swf;*.mpg;*.mpeg;*.mp4;*.mov;*.m4v;*.aac;*.mp3;*.wav;*.png;*.jpg;*.jpeg;*.gif";
//	private String fileTypesDesciption	= "Todos";
//	
//	private HowMGWTCanvasProgress progress;
//	
//	private HowMGWTUploadToolbarFiles toolbarUploadFiles;
//	private AbsolutePanel painelUploadButton;
//	
//	private HowMGWTUploadSelectFiles panelListFiles   = new HowMGWTUploadSelectFiles(this);
//	private HowMGWTUploadListFolders panelListFolders = new HowMGWTUploadListFolders(this);
//	
//	private ArrayList<File> garbageCollector = new ArrayList<File>();
//	// Arquivos Selecionados
//	private ArrayList<File> files;
//		 
//	private int 	sendingCurrentSendFile 			= -1;			// Indica qual arquivo está sendo enviado no momento
//	private ArrayList<HowMGWTFile> 	sendSelectFiles;				// Lista de arquivos selecionados para transmissão
//	private HowMGWTFile sendingCurrentFile;
//	
//	
//	// 
//	UploadBuilder uploadBuilder = new UploadBuilder();
//
//	// Objeto responsavel pelo upload de arquivos.
//	private SWFUpload uploadManager;
//	// Elemento placeHolder responsavel pela área onde será desenhado o botão para abrir a lista 
//	// de seleção de arquivos.
//	private Element placeHolder;
//	
//	private HowMGWTFolder currentFolder;
//	private ArrayList<ListGridRecord> selectRemoteRecords = new ArrayList<ListGridRecord>();
//	
//	/**
//	 * Construtor padrão.
//	 */
//	public HowMGWTUploadDialogV2(){
//		
//		
//
//		this.setTitle(Tradutor.i18n.formTituloUPLOAD());
//		
//		this.setWidth("650px");
//		this.setHeight("450px");
//		
//		this.setCanDragResize(true);
//
//		
//		VLayout vLayout = new VLayout();
//		vLayout.setWidth100();
//		vLayout.setHeight100();
//
//		HLayout main = new HLayout();
//		main.setWidth100();
//		main.setHeight100();
//		
//		main.addMember(panelListFolders);
//		main.addMember(panelListFiles);
//		
//		
//		vLayout.addMember(main);
//		
//		
//		HTML html = new HTML();
//		
//		toolbarUploadFiles = new HowMGWTUploadToolbarFiles(){
//
//			@Override
//			public void onClose() {
//				HowMGWTUploadDialogV2.this.onClose();
//			}
//
//			@Override
//			public void onSendDelete() {
//				deleteFiles();
//			}
//			
//			@Override
//			public void onSendFiles() {
//				startUpload();
//			}
//			
//		};
//		toolbarUploadFiles.setHeight("30px");
//		toolbarUploadFiles.setWidth100();
//		vLayout.addMember(toolbarUploadFiles);
//		
//		this.addItem(vLayout);
//
//		this.centerInPage();
//
//		this.addCloseClickHandler(new CloseClickHandler(){
//
//			@Override
//			public void onCloseClick(CloseClickEvent event) {
//				onClose();
//			}
//			
//		});
////		this.addCloseClickHandler(new CloseClickHandler() {
////			
////			@Override
////			public void onCloseClick(CloseClientEvent event) {
////				onClose();
////			}
////		});
//		 
//	}
//	
//	
//
//	public void start(){
//		start(ButtonAction.SELECT_FILES);
//	}
//	
//	public void start(ButtonAction buttonAction){
//	       
//	       // Configure which file types may be selected
//
//	       uploadBuilder.preventSWFCaching(true);
//		   uploadBuilder.setFileTypes(fileTypes);
//	       uploadBuilder.setFileTypesDescription(fileTypesDesciption);
//	       uploadBuilder.setUploadURL(Configuracao.getNativeUnoUrlServiceStruts()+"HowMUpload");
//	       
//	       // uploadBuilder.setDebug(true);
//	       // Configure the button to display
//
//	       
//	       // builder.setButtonImageURL("http://127.0.0.1:8080/gwt/images/actions/openFile.png");
//	       
//	       uploadBuilder.setButtonPlaceholderID("swfupload");
//
//	       uploadBuilder.setButtonText("<span class=\"labelSelecionarArquivo\">Selecionar Arquivos</font></span>");
//	       uploadBuilder.setButtonTextStyle(".labelSelecionarArquivo{font-family:Arial,Verdana,sans-serif; font-size:12px;}");
//	       uploadBuilder.setButtonTextLeftPadding(0);
// 	       uploadBuilder.setButtonTextTopPadding(6);
//	       uploadBuilder.setButtonWidth(115);
//	       uploadBuilder.setButtonHeight(20);
//	       uploadBuilder.setButtonCursor(ButtonCursor.HAND);
//	       uploadBuilder.setButtonDisabled(false);
//	       uploadBuilder.setWindowMode(WindowMode.TRANSPARENT);
//	       files = new  ArrayList<File>();
//	       
//	       uploadBuilder.setFileUploadLimit(1000);
//	       
//	       uploadBuilder.setFileQueueLimit(1000);
//	       uploadBuilder.setFileSizeLimit(1024*100);
//	       
//	       
//	       // Use ButtonAction.SELECT_FILE to only allow selection of a single file
//	       uploadBuilder.setButtonAction(buttonAction);
// 
//	       
//	       // The placeholder to be replaced by the swfupload control
//	       // This could also be provided statically by your host HTML page
//	       placeHolder = DOM.createSpan();
//	       placeHolder.setId("swfupload");	       	      
//	       
//	       painelUploadButton = new AbsolutePanel();
//	       painelUploadButton.setWidth("120px");
//	       painelUploadButton.setHeight("26px");
//	      // painelUploadButton.getElement().getStyle().setBackgroundImage("geral/button_model.gif");	       
//	       
//	       Label lbl = new Label();
//	       lbl.setWidth("120px");
//	       lbl.setHeight("26px");	       
//	       painelUploadButton.add(lbl, 12, 0);
//
//	       lbl.getElement().appendChild(placeHolder);
//       
//	       RootPanel.get().add(painelUploadButton);
//
//	       uploadBuilder.setFileDialogCompleteHandler(new FileDialogCompleteHandler() {
//				
//				@Override
//				public void onFileDialogComplete(FileDialogCompleteEvent e) {
//					panelListFolders.addFiles(files);
//					files.clear();
//				}
//	       });
//	       
//	       // Ocorre após a seleção dos arquivos.
//	       uploadBuilder.setFileQueuedHandler(new FileQueuedHandler() {				
//				@Override
//				public void onFileQueued(FileQueuedEvent event) {
//					files.add(event.getFile());
//					garbageCollector.add(event.getFile());
//				}
//	       });	       
//	       
//	       // --------------------------------------------------------------------------
//	       // Receives updates asynchronously to report progress of an upload
//	       // --------------------------------------------------------------------------
//	       uploadBuilder.setUploadProgressHandler( new UploadProgressHandler() {
//			
//				@Override
//				public void onUploadProgress(UploadProgressEvent e) {
//					onSendProgress(e);
//				}
//	       });
//	       
//	       // --------------------------------------------------------------------------
//	       // A file has completed transferring
//	       // --------------------------------------------------------------------------
//	       uploadBuilder.setUploadCompleteHandler(new UploadCompleteHandler() {
//			
//				@Override
//				public void onUploadComplete(UploadCompleteEvent e) {
//					onSendComplete(e);
//				}
//	       });
//
//	       // --------------------------------------------------------------------------
//	       // The server has accepted the upload
//	       // --------------------------------------------------------------------------	       
//	       uploadBuilder.setUploadSuccessHandler( new UploadSuccessHandler() {
//			
//				@Override
//				public void onUploadSuccess(UploadSuccessEvent e) {
//					System.out.println("onUploadSuccess : Upload concluído com sucesso...");
//					
//					if ( closeAfterSendSucess ){
//						onClose();
//						onHowMCloseSelectFile(e.getFile().getName());
//					}
//				}
//	       });
//	       
//	       // --------------------------------------------------------------------------
//	       // An error occurred during the transfer
//	       // --------------------------------------------------------------------------
//	       uploadBuilder.setUploadErrorHandler(new UploadErrorHandler() {			
//				@Override
//				public void onUploadError(UploadErrorEvent e) {
//					onSendError(e);
//				}
//	       });	       
//	       
//	       uploadBuilder.setUploadStartHandler(new UploadStartHandler() {
//			
//				@Override
//				public void onUploadStart(UploadStartEvent e) {
//					
//					String targetPath =  rootPath + sendingCurrentFile.getFolder() ;
//					
//					// Adicona o parametro de nome da pasta 
//					uploadManager.addPostParam("TARGET_PATH" , targetPath );
//					
//				}
//	       });
//
//	       uploadManager = uploadBuilder.build();
//	      
//	       
//	       // Attach any other handlers and custom logic here
//	       // see:
//	       // setDebugHandler
//	       // setDialogStartHandler         - The browse dialog was opened
//	       // setFileDialogCompleteHandler  - The browse dialog was closed
//	       // setFileQueuedHandler          - A file was queued for upload
//	       // setFileQueueErrorHandler      - A requested file could not be queued (max file size, queue limits, etc)
//	       // setUploadStartHandler         - A file has begun uploading
//	      	
//	       Timer timer = new Timer() {
//				@Override
//				public void run() {
//					
//					
//					HLayout layout = new HLayout();
//					layout.setWidth("154px");
//					layout.setHeight("28px");
//					
//					HLayout img = new HLayout();
//					img.setWidth("22x");
//					img.setHeight("22px");
//					img.setBackgroundImage("actions/ico_add_file.png");
//					img.setBackgroundRepeat(BackgroundRepeat.NO_REPEAT);
//					img.setBackgroundPosition("6px 4px");
//					layout.addMember(img);
//					
//					layout.setBackgroundImage("geral/button_model.gif");
//					layout.setBackgroundRepeat(BackgroundRepeat.NO_REPEAT);
//					layout.addMember(painelUploadButton);
//					
//					toolbarUploadFiles.addMember(layout);
//					toolbarUploadFiles.showButtons();
//				}
//	       };
//	      timer.schedule(60);
//	}
//
//
//	
//	/**
//	 * @return the panelListFiles
//	 */
//	public HowMGWTUploadSelectFiles getPanelListFiles() {
//		return panelListFiles;
//	}
//	
//	
//	
//	
//	
//	// ------------------------------------------------------------------------------
//	// Envia os arquivos para o servidor
//	// ------------------------------------------------------------------------------
//	
//	/**
//	 * Inicia o processo de envio.
//	 */
//	public void startUpload(){
//		
//		if ( progress != null ){
//			progress.hide();
//		}
//		progress = null;
//		progress = new HowMGWTCanvasProgress();
//		progress.setWidth("260px");
//		progress.setHeight((progress.getDefaultHeight()+30)+"px");
//		
//		progress.setTitleMessage(Tradutor.i18n.msgOcupadoAguardeOFimDoProcessamento());
//		progress.setTitle(Tradutor.i18n.msgUploadArquivos());
//		progress.setMessage(Tradutor.i18n.msgInicializandoProcessoTransmissaoAquivos());
//	
//		progress.centerInPage();
//		progress.show();		
//		
//		this.sendingCurrentSendFile = 0;
//		this.sendSelectFiles = this.panelListFolders.getTransferFiles();
//		this.nextUpload();
//	}
//
//	/**
//	 * Atualiza o estatus do arquivo que está sendo enviado.
//	 * @param file
//	 * @param status
//	 */
//	public void refreshStatus(HowMGWTFile file , String status){
//
//		// Recupera a pasta onde o arquivo está armazenado
//		HowMGWTFolder folder = this.panelListFolders.getMapFolders().get(file.getFolder());
//		
//		// Verifica se a pasta do arquivo já está selecionada.
//		int indexFolder = this.panelListFolders.getRecordIndex(folder.getTreeNode());
//		if ( this.panelListFolders.getSelectedRecord() != folder.getTreeNode()){
//			if ( this.panelListFolders.getSelectedRecord() != null )
//				this.panelListFolders.deselectRecord(this.panelListFolders.getSelectedRecord());
//			this.panelListFolders.selectRecord(indexFolder);
//		}
//				
//		// Seta o status do registro como enviando
//		file.getRecord().setAttribute(this.panelListFiles.fieldFileStatus.getName(), status );
//		
//		// recupera o indice do registro e atualiza a apresentação na tela.
//		int indexRow = this.panelListFiles.getRecordIndex(file.getRecord());
//		int indexCol = this.panelListFiles.getFieldNum(this.panelListFiles.fieldFileStatus.getName());
//		this.panelListFiles.refreshRecordComponent(indexRow, indexCol);
//
//		
//		//if ( indexRow >= 0 )
//			// this.panelListFiles.refreshRow(indexRow);
//		// Seleciona o registro que está sendo processado.
//		this.panelListFiles.selectRecord(file.getRecord());
//		this.panelListFiles.scrollToRow(indexRow);
//	}
//	
//	
//	public void nextUpload(){
//		try{
//			if( this.sendingCurrentSendFile < this.sendSelectFiles.size() ){
//				
//				// Recupera o objeto do arquivo que será enviado para o servidor
//				HowMGWTFile file = sendSelectFiles.get(sendingCurrentSendFile);
//				
//				this.sendingCurrentFile = file;
//
//	
//				this.refreshStatus(this.sendingCurrentFile, HowMGWTUploadSelectFiles.STATUS_ENVIANDO );
//	
//				// Inicia o processo de upload do arquivo.
//				uploadManager.startUpload(file.getFile().getId());			
//				sendingCurrentSendFile ++;
//			}
//			// Finaliza o upload dos arquivos.
//			else
//				finishLoad();
//		}
//		catch(Throwable err){
//			this.finishLoad();
//			err.printStackTrace();
//			SC.say(err.getMessage());
//		}
//	}
//	
//	public void onSendComplete(UploadCompleteEvent e){
//		this.refreshStatus(this.sendingCurrentFile, HowMGWTUploadSelectFiles.STATUS_OK );
//		nextUpload();
//	}
//	
//	public void onSendProgress(UploadProgressEvent e){
//		double percentSending = ( ( ((double)e.getBytesComplete()) / ((double)e.getBytesTotal()) ) * 100 );
//
//		String percent = NumberFormat.getFormat("####").format(new Double(percentSending))+ " %";
//
//		String deAte = "";
//		
//		if( this.sendingCurrentSendFile != 0 ){
//			deAte = "<br>Arquivos transmitidos : "+this.sendingCurrentSendFile + " de " + this.sendSelectFiles.size() + "<br>";
//		}
//		
//		String msg = 
//			deAte +
//			"Enviando arquivo para pasta : "+ this.sendingCurrentFile.getFolder()+
//			"<br>Arquivo : "+this.sendingCurrentFile.getFile().getName()+  
//			"<br><center> ( <font color=blue><b>"+percent+"</b></blue> ) </center>";
//		
//		progress.setMessage(msg);
//	}
//	
//	public void onSendError(UploadErrorEvent e){
//		nextUpload();
//	}
//	
//	/**
//	 * Finaliza o envio de arquivos para o servidor.
//	 */
//	public void finishLoad(){
//		this.sendingCurrentSendFile = 0;
//		
//		for ( HowMGWTFile file : this.sendSelectFiles){
//			try{
//				this.uploadManager.cancelUpload(file.getFile().getId(), false);
//				System.out.println("File : "+file.getFile().getName()+" Cancleado upload");
//			}
//			catch(Throwable err){
//				System.out.println("Erro cancel upload File : "+file.getFile().getName());
//			}
//		}
//		
//		this.sendSelectFiles.clear();
//		this.sendingCurrentFile = null;
//		if( progress != null ){
//			progress.destroyProgress();
//		}
//		//uploadManager.cancelUpload();
//		progress = null;	
//	}
//	
//
//	/**
//	 * @return the panelListFolders
//	 */
//	public HowMGWTUploadListFolders getPanelListFolders() {
//		return panelListFolders;
//	}		
//	
//	
//	public void configureUpload(){
// 		
//		this.fileTypes 			 = "*.*";
//		this.fileTypesDesciption = "Todos";
//		
//		start();
//	}
//	
//	
//	public void configureUploadSingleFile(){
// 		
//		this.fileTypes 			 = "*.*";
//		this.fileTypesDesciption = "Todos";
//		
//		closeAfterSendSucess = true;
//		start(ButtonAction.SELECT_FILE);
////		this.toolbarUploadFiles.getActionDeleteFiles().setVisible(false);
//	}	
//	
//	public void configureUpload(JavaScriptObject parent, String folders, String prefixo, String rootPath, String action, String urlDownload){
//		this.urlDownload  = urlDownload;
//		this.parentObject = parent;
//		this.action 	  = action;
//		
//		this.rootPath = rootPath;
//
//		this.panelListFiles.setUrlDownload(this.urlDownload);
//		this.panelListFiles.setRootPath(this.rootPath);
//		
//		// Cria a lista de sub pastas para onde poderao ser enviados os arquivos.
//		ArrayList<TreeNode> pathNodes = new ArrayList<TreeNode>();
//		String[] aFolders ;
//		if ( ! HowMGWTUtilities.isEmpty( folders ) ){
//			if ( folders.lastIndexOf(",") < 0 )
//				folders = ",";
//			aFolders = folders.split(",");
//		}
//		else
//			aFolders = new String[]{"temporario"};
//		
//		for ( String folder : aFolders){
//			String[] aFiles = folder.trim().split("/");
//			int i = 0;
//			if ( aFiles.length > 0 ){
//				for ( String file : aFiles ){
//					if ( i == 0 ){
//						i ++;
//						folder = file;
//						continue;
//					}
//				}
//			}
//			HowMGWTUploadListFolders.FolderTreeNode pasta = new HowMGWTUploadListFolders.FolderTreeNode(getPanelListFolders(), folder.trim(), prefixo +" "+ folder.trim());
//			pathNodes.add(pasta);
//		}
//		
//		panelListFolders.showFolders(pathNodes);
//		
//		
//		for ( String folder : aFolders){
//			String[] aFiles = folder.trim().split("/");
//			int i = 0;
//
//			if ( aFiles.length > 0 ){
//				for ( String file : aFiles ){
//					if ( i == 0 ){
//						i ++;
//						folder = file;
//						continue;
//					}
//					
//					if ( file.lastIndexOf(";") > 0 )
//						file += ";";
//
//					String[] fileProp = file.split(";");
//					String fileName = fileProp[0];
//					String type     = fileProp[1];
//					long size	    = HowMGWTUtilities.getLong(fileProp[2]);
//					String status   = fileProp[3];
//					
//					ListGridRecord record = new ListGridRecord();
//
//					if ( HowMGWTUtilities.isEmpty( type )){
//						type = "";
//					}
//					else
//						type = HowMGWTUtilities.replace(type, ".", "").toUpperCase().replace(".", "");
//					
//					long cSize = size/1024;
//					
//					String sSize = "";
//					if ( cSize > 0 ){
//						sSize = cSize+ " KB   ";
//					}
//					else
//						sSize = size + " Bytes";
//
//					record.setAttribute(this.getPanelListFiles().fieldFileName.getName(), fileName);
//					record.setAttribute(this.getPanelListFiles().fieldFileType.getName(), type);
//					record.setAttribute(this.getPanelListFiles().fieldFileSize.getName(), sSize);
//					if ( "W".equalsIgnoreCase(status))
//						record.setAttribute(this.getPanelListFiles().fieldFileStatus.getName(), HowMGWTUploadSelectFiles.STATUS_OK);
//					else
//						record.setAttribute(this.getPanelListFiles().fieldFileStatus.getName(), HowMGWTUploadSelectFiles.STATUS_LEITURA);
//
//					HowMGWTFolder pasta = this.panelListFolders.getMapFolders().get(folder);
//					
//					pasta.getFiles().put(fileName,  record);
//				
//				}
//			}	
//		}
//		this.show();
//	}
//	
//	/**
//	 * @return the toolbarUploadFiles
//	 */
//	public HowMGWTUploadToolbarFiles getToolbarUploadFiles() {
//		return toolbarUploadFiles;
//	}
//	
//	
//	public void onClose(){
//		this.hide();
//		for ( File file : garbageCollector){
//			try{
//				this.uploadManager.cancelUpload(file.getId());
//				// System.out.println("Cancelou Upload arquivo : "+file.getName());
//			}
//			catch(Throwable err){
//				// System.out.println("Erro ao cancelar upload arquivo : "+file.getName());				
//			}
//		}
//		this.garbageCollector.clear();
//		if ( this.parentObject != null )
//			notifyClose(this.parentObject, this.action);
//				
//	}
//	
//	/**
//	 * @return Retorna o endereço absoluto do contexto onde serão executados os serviços de donwload
//	 * GWT.
//	 */
//	public static native void notifyClose(JavaScriptObject parentObject, String action) /*-{
//	   parentObject.onUploadFileClose(action);	 
//	}-*/;
//	
//
//	
// 
////	public void sendFile(File file){
////			
////		
////		FormPanel form = new FormPanel();
////		form.setEncoding(FormPanel.ENCODING_MULTIPART);
////		form.setMethod(FormPanel.METHOD_POST);
////
////		FileUpload upload = new FileUpload();
////		upload.setName("upload");
////
////		form.add(upload);
////		form.setAction("url");
////		form.addSubmitHandler(new FormPanel.SubmitHandler() {
////			
////			@Override
////			public void onSubmit(SubmitEvent event) {
////				// TODO Auto-generated method stub
////				
////			}
////		});
////		form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
////			
////			@Override
////			public void onSubmitComplete(SubmitCompleteEvent event) {
////				// TODO Auto-generated method stub
////				
////			}
////		});
////	}
//
//	
//
//	/**
//	 * Exclui arquivos da lista ou remove o arquivo do servidor, conforme status do registro.
//	 */
//	public void deleteFiles(){
//		SC.confirm(Tradutor.i18n.msgConfirmaExclusaoArquivosSelecionados() ,new BooleanCallback() {			
//			@Override
//			public void execute(Boolean value) {
//				if ( value.booleanValue() )
//					onDeleteFiles();
//			}
//		});
//	}
//	
//	/**
//	 * Exclui os arquivos selecionada, se for arquivo que já está 
//	 */
//	public void onDeleteFiles(){
//		ListGridRecord[] records = this.panelListFiles.getSelectedRecords();	
//
//		// Recupera a pasta selecionada
//	   	ListGridRecord currentNode = this.panelListFolders.getSelectedRecord();
//    	if( currentNode == null )
//    		return;
//
//    	// Recupera o nome da pasta.
//    	String folderName = currentNode.getAttributeAsString("folder");
//
//    	currentFolder = this.panelListFolders.mapFolders.get(folderName);
//    	
//    	ArrayList<eFile> remoteFiles = new ArrayList<eFile>();
//    	ArrayList<ListGridRecord> localFiles = new ArrayList<ListGridRecord>();
//
//    	String pathPasta = this.rootPath + folderName+"/";
//    	String fileName  = "";
//    	String pathFile  = "";
//    	String status    = "";
//    	eFile file;
//		for ( ListGridRecord record : records ){
//			
//			 // recupera o nome do arquivo
//			 fileName = record.getAttributeAsString(this.panelListFiles.fieldFileName.getName());
//			 // Monta o caminho absoluto do arquivo.
//			 pathFile = pathPasta + fileName;
//		
//			 status = record.getAttributeAsString(this.panelListFiles.fieldFileStatus.getName());
//			 if ( 	HowMGWTUploadSelectFiles.STATUS_OK.equalsIgnoreCase(status) ){
//				 file = new eFile();
//				 file.setName(fileName);
//				 file.setPath(pathFile);
//				 file.setStoreType(""+STORE_TYPE_FILE);
//				 remoteFiles.add(file);
//				 selectRemoteRecords.add(record);
//			 }
//			 else if ( HowMGWTUploadSelectFiles.STATUS_ENVIANDO.equalsIgnoreCase(status) 
//				  ||
//				  HowMGWTUploadSelectFiles.STATUS_PENDENTE.equalsIgnoreCase(status) 
//			 ){
//				 localFiles.add(record);
//			 }
//		}
//
//		// Remove os arquivos locais selecionados para deleção.
//		for ( ListGridRecord record : records){
//			// Exclui o arquivo da pasta
//			currentFolder.getFiles().remove(record.getAttributeAsString(panelListFiles.fieldFileName.getName()));
//			// Exclui o arquivo da grid.
//			panelListFiles.removeData(record);
//		}
//
//		// Cria um objeto struts para excluir os arquivos no servidor.
//		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {					
//			@Override
//			public void onResponse(HowMGWTFormBean formBean) {
//				if ( !HowMGWTControl.isRefreshFormShowMessage(formBean)){
//
//					FormBean bean = (FormBean)formBean;
//					TreeMap< String , eFile > mapFiles = new TreeMap<String, eFile>();
//					if ( bean.getFiles() != null ){
//						for ( eFile file : bean.getFiles() )
//							mapFiles.put(file.getName(), file);
//
//						// Remove os arquivos locais selecionados para deleção.
//						for ( ListGridRecord record : selectRemoteRecords ){
//								
//							eFile file = mapFiles.get(panelListFiles.fieldFileName.getName());
//							if ( file != null ){
//								// Verifica se deu erro
//								if ( file.getError() ){
//									// Verifica se há mensagem de erro
//									if ( HowMGWTUtilities.isEmpty(file.getMensagem()) ){
//										// Associar mensagem de erro com o arquivo para visualizar a mensagem 
//										// na tela para o usuório.
//									}
//								}
//								if ( HowMGWTUtilities.getBoolean(file.getDeleted()) ){
//									// Exclui o arquivo da pasta
//									currentFolder.getFiles().remove(record.getAttributeAsString(panelListFiles.fieldFileName.getName()));
//									// Exclui o arquivo da grid.
//									panelListFiles.removeData(record);
//								}
//							}
//						}
//					}
//				}
//			}
//		};
//				
//		String body = "";
//		JSONArray array = new JSONArray();
//		int i = 0 ;
//		
//		for ( eFile entityFile : remoteFiles ){					
//			JSONObject object = entityFile.toJsonObject("");
//			 array.set(i, object);
//			 i ++ ;
//		}
//
//		JSONObject objectBean = new JSONObject();
//		objectBean.put("files", array);
//		body = "JSONData="+objectBean.toString();
//
//		struts.request("sgw0033.do?method=delete",  "SGW0033Form", body);
//	}
//	
//	
//	
//	/**
//	 * Configurar para ser disparado quando for selecionado um arquivo simples.
//	 */
//	public void onHowMCloseSelectFile(String fileName){
//		
//	}
//
//
//
//	/**
//	 * @return the sendingCurrentFile
//	 */
//	public HowMGWTFile getSendingCurrentFile() {
//		return sendingCurrentFile;
//	}
}