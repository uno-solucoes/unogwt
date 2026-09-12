package com.howmake.client.form.UI;


import java.util.ArrayList;

import org.moxieapps.gwt.uploader.client.File;
import org.moxieapps.gwt.uploader.client.Uploader;
import org.moxieapps.gwt.uploader.client.Uploader.Cursor;
import org.moxieapps.gwt.uploader.client.events.FileDialogCompleteEvent;
import org.moxieapps.gwt.uploader.client.events.FileDialogCompleteHandler;
import org.moxieapps.gwt.uploader.client.events.FileDialogStartEvent;
import org.moxieapps.gwt.uploader.client.events.FileDialogStartHandler;
import org.moxieapps.gwt.uploader.client.events.FileQueueErrorEvent;
import org.moxieapps.gwt.uploader.client.events.FileQueueErrorHandler;
import org.moxieapps.gwt.uploader.client.events.FileQueuedEvent;
import org.moxieapps.gwt.uploader.client.events.FileQueuedHandler;
import org.moxieapps.gwt.uploader.client.events.UploadCompleteEvent;
import org.moxieapps.gwt.uploader.client.events.UploadCompleteHandler;
import org.moxieapps.gwt.uploader.client.events.UploadErrorEvent;
import org.moxieapps.gwt.uploader.client.events.UploadErrorHandler;
import org.moxieapps.gwt.uploader.client.events.UploadProgressEvent;
import org.moxieapps.gwt.uploader.client.events.UploadProgressHandler;

import com.br.client.configuracao.Configuracao;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.DragLeaveEvent;
import com.google.gwt.event.dom.client.DragLeaveHandler;
import com.google.gwt.event.dom.client.DragOverEvent;
import com.google.gwt.event.dom.client.DragOverHandler;
import com.google.gwt.event.dom.client.DropEvent;
import com.google.gwt.event.dom.client.DropHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FocusPanel;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.events.ResizedEvent;
import com.smartgwt.client.widgets.events.ResizedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * Uploader, inclui um Botão com a seleção de múltiplos arquivos, suporte para arrastar e soltar e Barra de Progresso GWT.
 */
public class HowMGWTUpload extends VLayout {

	
	private String pathRoot = "c:\\temp\\upload\\"; 
	private Uploader.ButtonAction actionButton = Uploader.ButtonAction.SELECT_FILE; 
	
	private HowMGWTCanvasProgress progress;
	
	private HLayout mainLayout = new HLayout();
	private final Uploader uploader = new Uploader();

	private int buttonWidth	= 270;	

	private int dragHeight  = 120;

	private HLayout layoutDragAndDrop = new HLayout();
    private com.smartgwt.client.widgets.Label labelDragAndDrop = new com.smartgwt.client.widgets.Label(
    		  "<font color='#9C9C9C'; size=+2>Arraste arquivos para cá</font><br>"
    		+ "<font color='#9C9C9C'; size=2>Ou, se preferir ...</font><br>"
    );    
    

    private ArrayList<File> files = new ArrayList<File>(); 
    
    public HowMGWTUpload() {    	

    	this.mainLayout.setWidth100();
    	this.mainLayout.setHeight(dragHeight);
    	this.mainLayout.setBorder("2px dashed #8B8682");

    	this.setWidth100();
    	this.setAutoHeight();
    	this.setBackgroundColor("#ffffff");    	
    	
    	this.addResizedHandler(new ResizedHandler() {

			@Override
			public void onResized(ResizedEvent event) {

				mainLayout.setWidth(HowMGWTUpload.this.getWidth()-10);								
				layoutDragAndDrop.setWidth(mainLayout.getWidth()-30);
			}
		});    	

    	
    }

    /**
     * Retorna a cor do botão
     * @return
     */
    public String getBackgroundButton(){
    	if( Uploader.isAjaxUploadWithProgressEventsSupported()  ){
    		return " color:#ffffff; background:rgb(30,144,255) ";
    	}
    	else{
    		return "";
    	}
    }


    public void configureUpload(){

    	files.clear();
    	
        JSONObject params = new JSONObject();
        params.put("TARGET_PATH", new JSONString(pathRoot));
                
        uploader.setUploadURL(Configuracao.getNativeUnoUrlServiceStruts()+"HowMUpload")
                .setButtonText("<button type=\"submit\" style=\"width:"+(this.getButtonWidth()-5)+"px; heigth:24px; cursor:pointer;cursor:hand; font-size:12px; "+getBackgroundButton()+";\">Selecione arquivos do computador</button>")
                .setButtonWidth(this.getButtonWidth())
                .setButtonHeight(28)
                .setButtonCursor(Cursor.HAND)
                .setPostParams(params)
                .setFileSizeLimit("50 MB")
                .setButtonCursor(Uploader.Cursor.HAND)
                .setButtonAction(actionButton)
                
                // -------------------------------------------------------------
                // intercepta a entrada do arquivo na fila de upload.
                // -------------------------------------------------------------
                .setFileQueuedHandler(new FileQueuedHandler() {
                    public boolean onFileQueued(final FileQueuedEvent fileQueuedEvent) {                    	
                    	HowMGWTUpload.this.onFileQueued(fileQueuedEvent.getFile());            
                    	files.add(fileQueuedEvent.getFile());
                        return true;
                    }
                })

                // -------------------------------------------------------------
                // intercepta o andamento do upload
                // -------------------------------------------------------------                
                .setUploadProgressHandler(new UploadProgressHandler() {
                    public boolean onUploadProgress(UploadProgressEvent onUploadProgress) {

                    	if( progress == null ){
                    		createProgress();
                    	}
                    	
                		double percentSending = ( ( ((double)onUploadProgress.getBytesComplete()) / ((double)onUploadProgress.getBytesTotal()) ) * 100 );
                    	
                		String percent = NumberFormat.getFormat("####").format(new Double(percentSending))+ " %";
                    	                    			
                    	String msg = 
                    				"Enviando arquivo  : "+ onUploadProgress.getFile().getName()+  
                    				"<br><center> ( <font color=blue><b>"+percent+"</b></blue> ) </center>";
                    			
                    			progress.setMessage(msg);
                    
                        return true;
                    }
                })
                
                // -------------------------------------------------------------
                // intercepta quando é concluida a carga do arquivo.
                // -------------------------------------------------------------                                
                .setUploadCompleteHandler(new UploadCompleteHandler() {
                    public boolean onUploadComplete(UploadCompleteEvent uploadCompleteEvent) {
                		
                		if( progress != null ){
                			progress.destroyProgress();
                		}
                		progress = null;	

                		System.out.println("onUploadComplete - Arquivos enviados com sucesso...");
                		                		
                		onStartUpload(uploadCompleteEvent);
                		
                		
                		if( files.size() == 0 ){
                			
                		}
                		else{
	                		File lastFile = files.get(files.size()-1);	                		
	                		if( uploadCompleteEvent.getFile().equals(lastFile)){

	                			if( progress != null ){
	                				progress.hide();
	                				progress = null;
	                			}
	                			onFinish(lastFile.getName());
	                			return false;
	                		}
                		}
                        return true;
                    }
                })
                
                // -------------------------------------------------------------
                // limpa os arquivos que foram concluídos os uploads, este evento 
                // só ocorre se todos os processo foram finalizados.
                // -------------------------------------------------------------                
                .setFileDialogStartHandler(new FileDialogStartHandler() {
                    public boolean onFileDialogStartEvent(FileDialogStartEvent fileDialogStartEvent) {
                        if (uploader.getStats().getUploadsInProgress() <= 0) {
                        	System.out.println("onFileDialogStartEvent  ");
                         }
                        else{
                        	System.out.println("FileDialogStartEvent Upload in Progress : "+uploader.getStats().getUploadsInProgress());
                        }
                        return true;
                    }
                })
               
                
                // -------------------------------------------------------------
                // Avisa a interface que os arquivos estão disponiveis para 
                // serem enviados para o servidor.
                // -------------------------------------------------------------
                .setFileDialogCompleteHandler(new FileDialogCompleteHandler() {
                    public boolean onFileDialogComplete(FileDialogCompleteEvent fileDialogCompleteEvent) {
                    	HowMGWTUpload.this.onFileDialogComplete();                    	
                        return true;
                    }
                })
                
                
                
                
                
                
                
                
                
                // --------------------------------------------------------------------------------
                // Controle de erros.
                // --------------------------------------------------------------------------------
                
                // Intercepta erros na fila.
                .setFileQueueErrorHandler(new FileQueueErrorHandler() {
                    public boolean onFileQueueError(FileQueueErrorEvent fileQueueErrorEvent) {
                        Window.alert("Upload do arquivo " + fileQueueErrorEvent.getFile().getName() + " falhou devido a [" +
                                fileQueueErrorEvent.getErrorCode().toString() + "]: " + fileQueueErrorEvent.getMessage()
                        );
                        return true;
                    }
                })
                
                // Intercepta erros durante o upload
                .setUploadErrorHandler(new UploadErrorHandler() {
                    public boolean onUploadError(UploadErrorEvent uploadErrorEvent) {
                    	// itens.get(uploadErrorEvent.getFile().getId()).removeFromParent();
                        Window.alert("Upload do arquivo " + uploadErrorEvent.getFile().getName() + " falhou devido a  [" +
                                uploadErrorEvent.getErrorCode().toString() + "]: " + uploadErrorEvent.getMessage()
                        );
                        return true;
                    }
                });
                    
		        // --------------------------------------------------------------------------------
		        // Fim Controle de erros.
		        // --------------------------------------------------------------------------------
        

        
        
        
        
        
        
        
        /**
         * Se tiver suporte a AjaxUpload com e ProgressEvents, então inclui uma área 
         * para o usuário arrastar o arquivo para upload integrado com o sistema operacional.
         */
        if ( Uploader.isAjaxUploadWithProgressEventsSupported() ) {
            final FocusPanel dropFilesLabel = new FocusPanel();                                    
            dropFilesLabel.getElement().getStyle().setWidth(100, Unit.PCT);
            dropFilesLabel.getElement().getStyle().setHeight(100, Unit.PCT);
            dropFilesLabel.getElement().getStyle().setMargin(5, Unit.PX);
            
            
            // labelDragAndDrop.setHeight100();
            // labelDragAndDrop.setValign(VerticalAlignment.CENTER);
            labelDragAndDrop.setAutoHeight();
            labelDragAndDrop.setAlign(Alignment.CENTER);
            // labelDragAndDrop.setHeight(dragHeight-2);
            labelDragAndDrop.setWrap(false);
            
            
            layoutDragAndDrop.setAlign(Alignment.CENTER);
            // layoutDragAndDrop.addMember(uploader);
            layoutDragAndDrop.setHeight(dragHeight-2);

            // .-------------------------------------------------
            // |layoutDragAndDrop  .---------------------
            // |                   | vLayout
            // |                   |  addMember(labelDragAndDrop)
            // |                   |  addMember(uploader)
            // |                   |
            // |    			   `---------------------
            // `-------------------------------------------------            
            
            VLayout vLayout = new VLayout();
            vLayout.setAutoWidth();
            vLayout.setHeight100();
            vLayout.setAlign(Alignment.CENTER);
            
            vLayout.addMember(labelDragAndDrop);
            vLayout.addMember(uploader);
                        
            layoutDragAndDrop.addMember(vLayout);

            
            dropFilesLabel.add(layoutDragAndDrop);
            
            
            
            
            dropFilesLabel.setStyleName("dropFilesLabel");
            dropFilesLabel.addDragOverHandler(new DragOverHandler() {
                public void onDragOver(DragOverEvent event) {
                    if (!uploader.getButtonDisabled()) {
                        dropFilesLabel.addStyleName("dropFilesLabelHover");
                    }
                }
            });
            dropFilesLabel.addDragLeaveHandler(new DragLeaveHandler() {
                public void onDragLeave(DragLeaveEvent event) {
                    dropFilesLabel.removeStyleName("dropFilesLabelHover");
                }
            });
            dropFilesLabel.addDropHandler(new DropHandler() {
                public void onDrop(DropEvent event) {
                    dropFilesLabel.removeStyleName("dropFilesLabelHover");

                    if (uploader.getStats().getUploadsInProgress() <= 0) {
                    }

                    uploader.addFilesToQueue(Uploader.getDroppedFiles(event.getNativeEvent()));
                    event.preventDefault();
                }
            });
            
            mainLayout.setMargin(10);
            mainLayout.addMember(dropFilesLabel);
            
            addMember(mainLayout);
        }
        else{
        	 addButtonUpload(uploader);
        }
    	
    }
    
            
    public void addButtonUpload(Uploader uploader){
    	this.addMember(uploader);    	
    }

    public void onFileQueued(File file){}
    

	public int getButtonWidth() {
		return buttonWidth;
	}


	public void onFileDialogComplete(){}
	
	public void setButtonWidth(int buttonWidth) {
		this.buttonWidth = buttonWidth;
	}
	
		

	/**
	 * Disparado pelo dialogo de seleção de arquivos.
	 */
	public void onStartUpload(UploadCompleteEvent uploadCompleteEvent){
		
        if (uploader.getStats().getUploadsInProgress() <= 0) {
        	        	
    		createProgress();
    		
        	uploader.startUpload();
        	
        }
        else{
        	System.out.println("FileDialogCompleteEvent Upload in Progress : "+uploader.getStats().getUploadsInProgress());
        }
	}

	public void createProgress(){

		if ( progress != null ){
			progress.hide();
		}		    		

		progress = null;
		progress = new HowMGWTCanvasProgress();
		progress.setWidth("260px");
		progress.setHeight((progress.getDefaultHeight()+30)+"px");
		
		progress.setTitleMessage(Tradutor.i18n.msgOcupadoAguardeOFimDoProcessamento());
		progress.setTitle(Tradutor.i18n.msgUploadArquivos());
		progress.setMessage(Tradutor.i18n.msgInicializandoProcessoTransmissaoAquivos());
	
		progress.centerInPage();
		progress.show();		

	}
	
	public Uploader.ButtonAction getActionButton() {
		return actionButton;
	}

	public void setActionButton(Uploader.ButtonAction actionButton) {
		this.actionButton = actionButton;
	}

	public Uploader getUploader() {
		return uploader;
	}
	
	
	public void onFinish(String fileName){
		
	}

	public String getPathRoot() {
		return pathRoot;
	}

	public void setPathRoot(String pathRoot) {
		this.pathRoot = pathRoot;
		
        JSONObject params = new JSONObject();
        params.put("TARGET_PATH", new JSONString(pathRoot));
        uploader.setPostParams(params);
	}
	
	
	public void cancelFileUpload(String fileName){
		for( File file : files ){
			if( file.getName().equalsIgnoreCase(fileName)){
				this.uploader.cancelUpload(file.getId());
			}
		}
	}
}
