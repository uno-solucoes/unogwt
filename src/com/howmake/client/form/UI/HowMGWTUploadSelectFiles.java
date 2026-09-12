package com.howmake.client.form.UI;

import java.util.TreeMap;

import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.layout.HLayout;
 
public class HowMGWTUploadSelectFiles extends HowMGWTListGrid{
	
	public static final String STATUS_OK 	   = "L/E";
	public static final String STATUS_LEITURA  = "L";
	public static final String STATUS_PENDENTE = "Pendente";
	public static final String STATUS_ENVIANDO = "Enviando";
	
	private String urlDownload;;
	private String rootPath;
	
	public ListGridField fieldFileName   = new ListGridField("FileName",  "Nome Arquivo",  230);
	public ListGridField fieldFileType   = new ListGridField("FileType",  "Tipo", 			40);
	public ListGridField fieldFileSize   = new ListGridField("FileSize",  "Tamanho", 		70);
	public ListGridField fieldFileStatus = new ListGridField("FileStatus","Status", 		80);
	
	private HowMGWTUploadDialog panelUploadDialog;
	
	public HowMGWTUploadSelectFiles(HowMGWTUploadDialog panelUploadDialog){

		this.panelUploadDialog = panelUploadDialog;
		
		this.setDataPageSize(1000);
		this.setShowAllRecords(false);
		this.setFields(
				fieldFileName,
				fieldFileType,
				fieldFileSize,
				fieldFileStatus
		);

		this.setCanResizeFields(true);   
		this.setHeaderHeight(25);		
		
		this.setShowRecordComponents(true);
		this.setShowRecordComponentsByCell(true);  	
		this.setShowAllRecords(true);  
	
		fieldFileStatus.setAlign(Alignment.CENTER);
		fieldFileType.setAlign(Alignment.CENTER);
		fieldFileSize.setAlign(Alignment.RIGHT); 
		
		
		CellFormatter formatter = new CellFormatter() {
	        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
	        	return "";
	        }
		};
		fieldFileStatus.setCellFormatter(formatter);		
		
		onHowMInitEntityControl(); 
		
		this.addSelectionChangedHandler(new SelectionChangedHandler() {
			
			@Override
			public void onSelectionChanged(SelectionEvent event) {
				// HowMGWTUploadSelectFiles.this.panelUploadDialog.getToolbarUploadFiles().getActionDeleteFiles().setDisabled(false);
			}
		});
	}
	
 
	public void showFiles(TreeMap<String, ListGridRecord> folder){
		this.clearAllRecords();
		if ( folder != null ){
			Object[] keys = folder.keySet().toArray();
			ListGridRecord record;
			ListGridRecord[] records = new ListGridRecord[keys.length];
			int i = 0 ;
			for ( Object key : keys ){
				record = folder.get(key);
				records[i++] = record; 
			}
			this.setData(records);
			 
		}
	}

	@Override
	protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {

		if ( this.fieldFileStatus.getName().equalsIgnoreCase(this.getField(colNum).getName())){
			if ( record.getAttributeAsString(this.fieldFileStatus.getName()).equals(STATUS_PENDENTE)){
				return "color:red;";
			}
			else if ( record.getAttributeAsString(this.fieldFileStatus.getName()).equals(STATUS_ENVIANDO )){
				return "color:red";
			}
			else if ( record.getAttributeAsString(this.fieldFileStatus.getName()).equals(STATUS_OK)){
				return "color:green";
			}
		}
		return super.getCellStyle(record, rowNum, colNum);
	}
	
	
    protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) {  
    	  
        String fieldName = this.getFieldName(colNum);  

        if (fieldName.equals(fieldFileStatus.getName())) {
        	
        	String status = record.getAttribute(fieldFileStatus.getName());
        	HLayout recordCanvas = new HLayout(6);  

        	if ( 
            		HowMGWTUtilities.isEquals(status, STATUS_PENDENTE )
            ){
                    recordCanvas.setHeight(22);  
                    recordCanvas.setAlign(Alignment.CENTER);  
                    ImgButton actionPendente = new ImgButton();  
                    actionPendente.setShowDown(false);  
                    actionPendente.setShowRollOver(false);  
                    actionPendente.setCursor(Cursor.DEFAULT);
                    actionPendente.setLayoutAlign(Alignment.CENTER);  
                    actionPendente.setSrc("actions/ico_upload.png");  
                    actionPendente.setPrompt("Pendente para Envio");  
                    actionPendente.setHeight(16);  
                    actionPendente.setWidth(16);  
                    recordCanvas.addMember(actionPendente);  
            }
        	if ( 
        		HowMGWTUtilities.isEquals(status, STATUS_PENDENTE )
        		||
        		HowMGWTUtilities.isEquals(status, STATUS_OK )
        		||
        		HowMGWTUtilities.isEquals(status, STATUS_ENVIANDO )
        	){
                recordCanvas.setHeight(22);  
                recordCanvas.setAlign(Alignment.CENTER);  
                ImgButton actionExcluir = new ImgButton();  
                actionExcluir.setShowDown(false);  
                actionExcluir.setShowRollOver(false);  
                actionExcluir.setLayoutAlign(Alignment.CENTER);  
                actionExcluir.setSrc("actions/remove.png");  
                actionExcluir.setPrompt("Excluir Arquivo");  
                actionExcluir.setHeight(16);  
                actionExcluir.setWidth(16);  
                actionExcluir.addClickHandler(new ClickHandler() {  
                    public void onClick(ClickEvent event) {  
                    	deselectAllRecords();
                    	selectRecord(record);
                    	panelUploadDialog.deleteFiles();
                    }  
                });
                recordCanvas.addMember(actionExcluir);  
        	}
        	// Se não tiver url para donwload, não libera a 
        	// ação para abrir o arquivo utilizando o processo de
        	// download.
//         	if ( ! HowMGWTUtilities.isEmpty( urlDownload ) ){
	        	if ( 
	            		HowMGWTUtilities.isEquals(status, STATUS_LEITURA )
	            		||
	            		HowMGWTUtilities.isEquals(status, STATUS_OK )
	            		||
	            		HowMGWTUtilities.isEquals(status, STATUS_ENVIANDO )
	            ){
	                recordCanvas.setHeight(22);  
	                recordCanvas.setAlign(Alignment.CENTER);  
	                ImgButton actionOpen = new ImgButton();  
	                actionOpen.setShowDown(false);  
	                actionOpen.setShowRollOver(false);  
	                actionOpen.setLayoutAlign(Alignment.CENTER);  
	                actionOpen.setSrc("actions/btn_open_file.png");  
	                actionOpen.setPrompt("Abrir Arquivo");  
	                actionOpen.setHeight(16);  
	                actionOpen.setWidth(16);  
	                actionOpen.addClickHandler(new ClickHandler() {  
	                    public void onClick(ClickEvent event) {
	                    	selectRecord(record);
	                    	HowMGWTUtilities.downloadFile(rootPath+"/"+panelUploadDialog.getPanelListFolders().getFolderName()+"/", record.getAttributeAsString(fieldFileName.getName()));
	                    }  
	                });
	                recordCanvas.addMember(actionOpen);  
	            }
//         	}
            return recordCanvas;  
        } else {  
            return null;  
        }  

    }


	/**
	 * @return the urlDownload
	 */
	public String getUrlDownload() {
		return urlDownload;
	}


	/**
	 * @param urlDownload the urlDownload to set
	 */
	public void setUrlDownload(String urlDownload) {
		this.urlDownload = urlDownload;
	}


	/**
	 * @return the rootPath
	 */
	public String getRootPath() {
		return rootPath;
	}


	/**
	 * @param rootPath the rootPath to set
	 */
	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}  
	
}