package com.howmake.client.form.UI;


import java.util.ArrayList;
import java.util.TreeMap;

import org.moxieapps.gwt.uploader.client.File;
import org.moxieapps.gwt.uploader.client.Uploader;

import com.br.client.model.sg.entity.eFile;
import com.br.client.model.sg.sgw0033.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTML;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFile;
import com.howmake.client.form.model.HowMGWTFolder;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.TreeNode;

public class HowMGWTUploadDialog extends HowMGWTWindowBase{

	public static final int STORE_TYPE_FILE			= 1;
	public static final int STORE_TYPE_DIRECTORY	= 2;
	public static final int STORE_TYPE_LINK			= 3;
	
	private boolean closeAfterSendSucess = false;
	
	private JavaScriptObject parentObject;

	private Uploader.ButtonAction actionButton = Uploader.ButtonAction.SELECT_FILE;
	private String action;
	
	private String urlDownload;
	private String rootPath;
	private String fileTypes			= "*.jar;*.zip;*.pdf;*.doc;*.txt;*.xls;*.asf;*.wma;*.wmv;*.avi;*.flv;*.swf;*.mpg;*.mpeg;*.mp4;*.mov;*.m4v;*.aac;*.mp3;*.wav;*.png;*.jpg;*.jpeg;*.gif";
	private String fileTypesDesciption	= "Todos";
	
	// private HowMGWTCanvasProgress progress;

	private Uploader uploader;
	private HLayout panelButtonUpload = new HLayout(); 
	
	HowMGWTUpload panelUpload = new HowMGWTUpload(){
		@Override
	    public void addButtonUpload(Uploader uploader){
	    	if( HowMGWTUploadDialog.this.uploader != null ){
	    		HowMGWTUploadDialog.this.uploader.removeFromParent();
	    	}
	    	panelButtonUpload.addMember(uploader);    	
	    }
	    
	    @Override
	    public void onFileQueued(File file) {
	    	files.add(file);
	    	garbageCollector.add(file);
	    };
	    
	    @Override
	    public void onFileDialogComplete() {
			panelListFolders.addFiles(files);
			files.clear();
	    };


	    @Override
	    public void onFinish(String fileName) {
	    	HowMGWTUploadDialog.this.onFinish(fileName);
	    }; 

	};
	
	private HowMGWTUploadToolbarFiles toolbarUploadFiles;
	
	private HowMGWTUploadSelectFiles panelListFiles   = new HowMGWTUploadSelectFiles(this);
	private HowMGWTUploadListFolders panelListFolders = new HowMGWTUploadListFolders(this);
	
	private ArrayList<File> garbageCollector = new ArrayList<File>();
	// Arquivos Selecionados
	private ArrayList<File> files;

	private int 	sendingCurrentSendFile 			= -1;			// Indica qual arquivo está sendo enviado no momento
	private ArrayList<HowMGWTFile> 	sendSelectFiles;				// Lista de arquivos selecionados para transmissão
	private HowMGWTFile sendingCurrentFile;
	
	private HowMGWTFolder currentFolder;
	private ArrayList<ListGridRecord> selectRemoteRecords = new ArrayList<ListGridRecord>();
	
	/**
	 * Construtor padrão.
	 */
	public HowMGWTUploadDialog(){
		
		

		this.setTitle(Tradutor.i18n.formTituloUPLOAD());
		
		this.setWidth("650px");
		this.setHeight("450px");
		
		this.setCanDragResize(true);

		
		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();

		HLayout main = new HLayout();
		main.setWidth100();
		main.setHeight100();
		
		main.addMember(panelListFolders);
		main.addMember(panelListFiles);
		
		
		vLayout.addMember(main);
		
		
		vLayout.addMember(panelUpload);
		
		HTML html = new HTML();
		
		toolbarUploadFiles = new HowMGWTUploadToolbarFiles(){

			@Override
			public void onClose() {
				HowMGWTUploadDialog.this.onClose();
			}

			@Override
			public void onSendDelete() {
				deleteFiles();
			}
			
			@Override
			public void onSendFiles() {
				
				String targetPath =  rootPath + panelListFolders.getFolderName()+"/" ;
				panelUpload.setPathRoot(targetPath);
				panelUpload.getUploader().startUpload();
			}
						
			
		};
		toolbarUploadFiles.setHeight("30px");
		toolbarUploadFiles.setWidth100();
		vLayout.addMember(toolbarUploadFiles);
		
		this.addItem(vLayout);

		this.centerInPage();

		this.addCloseClickHandler(new CloseClickHandler(){

			@Override
			public void onCloseClick(CloseClickEvent event) {
				onClose();
			}
			
		});
		this.addCloseClickHandler(new CloseClickHandler() {
			
			@Override
			public void onCloseClick(CloseClickEvent event) {
				onClose();			}
		});		 
	}
	
	

	public void start(){
		start(Uploader.ButtonAction.SELECT_FILE);		
	}
	
	// public void start(ButtonAction buttonAction){
	public void start(Uploader.ButtonAction actionButton){	       
	       files = new  ArrayList<File>();
	       
	       panelUpload.setActionButton(actionButton);	      	
	       Timer timer = new Timer() {
				@Override
				public void run() {
 
					panelUpload.configureUpload();
					
					toolbarUploadFiles.addMember(panelButtonUpload);
					toolbarUploadFiles.showButtons();
				}
	       };
	      timer.schedule(60);
	}


	
	/**
	 * @return the panelListFiles
	 */
	public HowMGWTUploadSelectFiles getPanelListFiles() {
		return panelListFiles;
	}
	
	
	
	
	
	// ------------------------------------------------------------------------------
	// Envia os arquivos para o servidor
	// ------------------------------------------------------------------------------
	
	/**
	 * Atualiza o estatus do arquivo que está sendo enviado.
	 * @param file
	 * @param status
	 */
	public void refreshStatus(HowMGWTFile file , String status){

		// Recupera a pasta onde o arquivo está armazenado
		HowMGWTFolder folder = this.panelListFolders.getMapFolders().get(file.getFolder());
		
		// Verifica se a pasta do arquivo já está selecionada.
		int indexFolder = this.panelListFolders.getRecordIndex(folder.getTreeNode());
		if ( this.panelListFolders.getSelectedRecord() != folder.getTreeNode()){
			if ( this.panelListFolders.getSelectedRecord() != null )
				this.panelListFolders.deselectRecord(this.panelListFolders.getSelectedRecord());
			this.panelListFolders.selectRecord(indexFolder);
		}
				
		// Seta o status do registro como enviando
		file.getRecord().setAttribute(this.panelListFiles.fieldFileStatus.getName(), status );
		
		// recupera o indice do registro e atualiza a apresentação na tela.
		int indexRow = this.panelListFiles.getRecordIndex(file.getRecord());
		int indexCol = this.panelListFiles.getFieldNum(this.panelListFiles.fieldFileStatus.getName());
		this.panelListFiles.refreshRecordComponent(indexRow, indexCol);

 
		// Seleciona o registro que está sendo processado.
		this.panelListFiles.selectRecord(file.getRecord());
		this.panelListFiles.scrollToRow(indexRow);
	}
	

	/**
	 * @return the panelListFolders
	 */
	public HowMGWTUploadListFolders getPanelListFolders() {
		return panelListFolders;
	}		
	
	
	public void configureUpload(){
 		
		this.fileTypes 			 = "*.*";
		this.fileTypesDesciption = "Todos";
		
		start();
	}
	
	
	public void configureUploadSingleFile(){
 		
		this.fileTypes 			 = "*.*";
		this.fileTypesDesciption = "Todos";
		
		closeAfterSendSucess = true;
		start(this.getActionButton());
		
	}	
	
	public void configureUpload(JavaScriptObject parent, String folders, String prefixo, String rootPath, String action, String urlDownload){
		this.urlDownload  = urlDownload;
		this.parentObject = parent;
		this.action 	  = action;
		
		this.rootPath = rootPath;
		this.panelUpload.setPathRoot(rootPath+panelListFolders.getFolderName()+"/");

		this.panelListFiles.setUrlDownload(this.urlDownload);
		this.panelListFiles.setRootPath(this.rootPath);
		
		// Cria a lista de sub pastas para onde poderao ser enviados os arquivos.
		ArrayList<TreeNode> pathNodes = new ArrayList<TreeNode>();
		String[] aFolders ;
		if ( ! HowMGWTUtilities.isEmpty( folders ) ){
			if ( folders.lastIndexOf(",") < 0 )
				folders = ",";
			aFolders = folders.split(",");
		}
		else
			aFolders = new String[]{"temporario"};
		
		for ( String folder : aFolders){
			String[] aFiles = folder.trim().split("/");
			int i = 0;
			if ( aFiles.length > 0 ){
				for ( String file : aFiles ){
					if ( i == 0 ){
						i ++;
						folder = file;
						continue;
					}
				}
			}
			HowMGWTUploadListFolders.FolderTreeNode pasta = new HowMGWTUploadListFolders.FolderTreeNode(getPanelListFolders(), folder.trim(), prefixo +" "+ folder.trim());
			pathNodes.add(pasta);
		}
		
		panelListFolders.showFolders(pathNodes);
		
		
		for ( String folder : aFolders){
			String[] aFiles = folder.trim().split("/");
			int i = 0;

			if ( aFiles.length > 0 ){
				for ( String file : aFiles ){
					if ( i == 0 ){
						i ++;
						folder = file;
						continue;
					}
					
					if ( file.lastIndexOf(";") > 0 )
						file += ";";

					String[] fileProp = file.split(";");
					String fileName = fileProp[0];
					String type     = fileProp[1];
					long size	    = HowMGWTUtilities.getLong(fileProp[2]);
					String status   = fileProp[3];
					
					ListGridRecord record = new ListGridRecord();

					if ( HowMGWTUtilities.isEmpty( type )){
						type = "";
					}
					else
						type = HowMGWTUtilities.replace(type, ".", "").toUpperCase().replace(".", "");
					
					long cSize = size/1024;
					
					String sSize = "";
					if ( cSize > 0 ){
						sSize = cSize+ " KB   ";
					}
					else
						sSize = size + " Bytes";

					record.setAttribute(this.getPanelListFiles().fieldFileName.getName(), fileName);
					record.setAttribute(this.getPanelListFiles().fieldFileType.getName(), type);
					record.setAttribute(this.getPanelListFiles().fieldFileSize.getName(), sSize);
					if ( "W".equalsIgnoreCase(status))
						record.setAttribute(this.getPanelListFiles().fieldFileStatus.getName(), HowMGWTUploadSelectFiles.STATUS_OK);
					else
						record.setAttribute(this.getPanelListFiles().fieldFileStatus.getName(), HowMGWTUploadSelectFiles.STATUS_LEITURA);

					HowMGWTFolder pasta = this.panelListFolders.getMapFolders().get(folder);
					
					pasta.getFiles().put(fileName,  record);
				
				}
			}	
		}
		this.show();
	}
	
	/**
	 * @return the toolbarUploadFiles
	 */
	public HowMGWTUploadToolbarFiles getToolbarUploadFiles() {
		return toolbarUploadFiles;
	}
	
	
	/**
	 * Exclui os arquivos selecionada, se for arquivo que já está 
	 */
	public void onDeleteFiles(){
		ListGridRecord[] records = this.panelListFiles.getSelectedRecords();	

		// Recupera a pasta selecionada
	   	ListGridRecord currentNode = this.panelListFolders.getSelectedRecord();
    	if( currentNode == null )
    		return;

    	// Recupera o nome da pasta.
    	String folderName = currentNode.getAttributeAsString("folder");

    	currentFolder = this.panelListFolders.mapFolders.get(folderName);
    	
    	ArrayList<eFile> remoteFiles = new ArrayList<eFile>();
    	ArrayList<ListGridRecord> localFiles = new ArrayList<ListGridRecord>();

    	String pathPasta = this.rootPath + folderName+"/";
    	String fileName  = "";
    	String pathFile  = "";
    	String status    = "";
    	eFile file;
		for ( ListGridRecord record : records ){
			
			 // recupera o nome do arquivo
			 fileName = record.getAttributeAsString(this.panelListFiles.fieldFileName.getName());
			 // Monta o caminho absoluto do arquivo.
			 pathFile = pathPasta + fileName;
		
			 status = record.getAttributeAsString(this.panelListFiles.fieldFileStatus.getName());
			 if ( 	HowMGWTUploadSelectFiles.STATUS_OK.equalsIgnoreCase(status) ){
				 file = new eFile();
				 file.setName(fileName);
				 file.setPath(pathFile);
				 file.setStoreType(""+STORE_TYPE_FILE);
				 remoteFiles.add(file);
				 selectRemoteRecords.add(record);
			 }
			 else if ( HowMGWTUploadSelectFiles.STATUS_ENVIANDO.equalsIgnoreCase(status) 
				  ||
				  HowMGWTUploadSelectFiles.STATUS_PENDENTE.equalsIgnoreCase(status) 
			 ){
				 localFiles.add(record);
			 }
		}

		// Remove os arquivos locais selecionados para deleção.
		for ( ListGridRecord record : records){
			// Exclui o arquivo da pasta
			currentFolder.getFiles().remove(record.getAttributeAsString(panelListFiles.fieldFileName.getName()));
			// Exclui o arquivo da grid.
			panelListFiles.removeData(record);
			this.panelUpload.cancelFileUpload(panelListFiles.fieldFileName.getName());
		}

		// Cria um objeto struts para excluir os arquivos no servidor.
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {					
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( !HowMGWTControl.isRefreshFormShowMessage(formBean)){

					FormBean bean = (FormBean)formBean;
					TreeMap< String , eFile > mapFiles = new TreeMap<String, eFile>();
					if ( bean.getFiles() != null ){
						for ( eFile file : bean.getFiles() )
							mapFiles.put(file.getName(), file);

						// Remove os arquivos locais selecionados para deleção.
						for ( ListGridRecord record : selectRemoteRecords ){
								
							eFile file = mapFiles.get(panelListFiles.fieldFileName.getName());
							if ( file != null ){
								// Verifica se deu erro
								if ( file.getError() ){
									// Verifica se há mensagem de erro
									if ( HowMGWTUtilities.isEmpty(file.getMensagem()) ){
										// Associar mensagem de erro com o arquivo para visualizar a mensagem 
										// na tela para o usuório.
									}
								}
								if ( HowMGWTUtilities.getBoolean(file.getDeleted()) ){
									// Exclui o arquivo da pasta
									currentFolder.getFiles().remove(record.getAttributeAsString(panelListFiles.fieldFileName.getName()));
									// Exclui o arquivo da grid.
									panelListFiles.removeData(record);
								}
							}
						}
					}
				}
			}
		};
				
		String body = "";
		JSONArray array = new JSONArray();
		int i = 0 ;
		
		for ( eFile entityFile : remoteFiles ){					
			JSONObject object = entityFile.toJsonObject("");
			 array.set(i, object);
			 i ++ ;
		}

		JSONObject objectBean = new JSONObject();
		objectBean.put("files", array);
		body = "JSONData="+objectBean.toString();

		struts.request("sgw0033.do?method=delete",  "SGW0033Form", body);
	}
	
	
	
	/**
	 * Configurar para ser disparado quando for selecionado um arquivo simples.
	 */
	public void onHowMCloseSelectFile(String fileName){
		
	}



	/**
	 * @return the sendingCurrentFile
	 */
	public HowMGWTFile getSendingCurrentFile() {
		return sendingCurrentFile;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void onClose(){
		this.hide();
		for ( File file : garbageCollector){
			try{
				panelUpload.getUploader().cancelUpload();
				// System.out.println("Cancelou Upload arquivo : "+file.getName());
			}
			catch(Throwable err){
				// System.out.println("Erro ao cancelar upload arquivo : "+file.getName());				
			}
		}
		this.garbageCollector.clear();
		if ( this.parentObject != null )
			notifyClose(this.parentObject, this.action);
				
	}
	
	/**
	 * @return Retorna o endereço absoluto do contexto onde serão executados os serviços de donwload
	 * GWT.
	 */
	public static native void notifyClose(JavaScriptObject parentObject, String action) /*-{
	   parentObject.onUploadFileClose(action);	 
	}-*/;
	

	
	/**
	 * Exclui arquivos da lista ou remove o arquivo do servidor, conforme status do registro.
	 */
	public void deleteFiles(){
		SC.confirm(Tradutor.i18n.msgConfirmaExclusaoArquivosSelecionados() ,new BooleanCallback() {			
			@Override
			public void execute(Boolean value) {
				if ( value.booleanValue() )
					onDeleteFiles();
			}
		});
	}



	public Uploader.ButtonAction getActionButton() {
		return actionButton;
	}



	public void setActionButton(Uploader.ButtonAction actionButton) {
		this.actionButton = actionButton;
	}
	
	
	public void onFinish(final String fileName){
		System.out.println("onUploadSuccess : Upload concluído com sucesso...");		
		if ( closeAfterSendSucess ){
			onClose();
			
			
			
			onHowMCloseSelectFile(fileName);
			this.hide();
		}		
	}
}