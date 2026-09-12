package com.howmake.client.form.UI;

 
import com.br.client.panel.I18N.Tradutor;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.toolbar.ToolStrip;


public abstract class HowMGWTUploadToolbarFiles extends ToolStrip{
 
	private IButton actionSendFiles  	= new IButton("");
	// private IButton actionDeleteFiles  	= new IButton("");
	private IButton actionClose   		= new IButton("");
	
//	private FileItem fileItem 			= new FileItem();
//	private DynamicForm form 		    = new DynamicForm();
	public HowMGWTUploadToolbarFiles(){
 
//		form.setFields(fileItem);
//		final DynamicForm uploadForm = new DynamicForm();       
//		
		
		actionSendFiles = new IButton(Tradutor.i18n.formEnviarArquivos());
		actionSendFiles.setWidth(130);
		actionSendFiles.setHeight("24px");
		actionSendFiles.setIcon("actions/ico_upload.png"); 

		actionSendFiles.addClickHandler(new ClickHandler() { 
			public void onClick(ClickEvent event) {
				onSendFiles();
	        }
		});	
	

//		actionDeleteFiles = new IButton(Tradutor.i18n.formExcluirArquivos());
//		actionDeleteFiles.setWidth(130);
//		actionDeleteFiles.setHeight("24px");
//		actionDeleteFiles.setIcon("actions/ico_excluir.gif"); 
//
//		actionDeleteFiles.setDisabled(true);
//		actionDeleteFiles.addClickHandler(new ClickHandler() { 
//			public void onClick(ClickEvent event) {
//				onSendDelete();
//	        }
//		});	

		
		actionClose = new IButton(Tradutor.i18n.formFechar());
		actionClose.setWidth(80);
		actionClose.setHeight("24px");
		actionClose.setIcon("actions/ico_close.png"); 
		actionClose.addClickHandler(new ClickHandler() { 
			public void onClick(ClickEvent event) {
				onClose();
	        }
		});

	}
 
 
	public abstract void onSendFiles();
	public abstract void onSendDelete();
	public abstract void onClose();

	public void showButtons(){

		// this.addMember(this.form);

		this.addMember(this.actionSendFiles);
//		this.addMember(this.actionDeleteFiles);
		this.addMember(this.actionClose);
	
	}


	/**
	 * @return the actionSendFiles
	 */
	public IButton getActionSendFiles() {
		return actionSendFiles;
	}

//
//	/**
//	 * @return the actionDeleteFiles
//	 */
//	public IButton getActionDeleteFiles() {
//		return actionDeleteFiles;
//	}


	/**
	 * @return the actionClose
	 */
	public IButton getActionClose() {
		return actionClose;
	}
	
	
}
