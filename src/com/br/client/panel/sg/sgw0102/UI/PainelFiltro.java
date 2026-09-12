package com.br.client.panel.sg.sgw0102.UI;



import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.ui.TextBox;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelFiltro extends VLayout{

	private DataSourceFiles dataSourceFile;
	
	private PainelResult painelResult;
	private Img imgGed = new Img("ged/ged.png");

	public TextBox fieldBuscarArquivo = new TextBox();
	
	ImgButton buscarHelp = new ImgButton();
	
	ImgButton actionShowLista  			= new ImgButton();
	ImgButton actionShowIconesGrandes  	= new ImgButton(); 
	
	public PainelFiltro(){

		this.setAlign(VerticalAlignment.CENTER);
		
		this.setWidth100();
		this.setHeight("32");

				
		fieldBuscarArquivo.addKeyUpHandler(new com.google.gwt.event.dom.client.KeyUpHandler() {
			
			@Override
			public void onKeyUp(com.google.gwt.event.dom.client.KeyUpEvent event) {
				if ( KeyCodes.KEY_ENTER == event.getNativeKeyCode()){
					dataSourceFile.onExecuteQuery(fieldBuscarArquivo.getText());
				}				
			}
		});
		
		fieldBuscarArquivo.setWidth("500px");

		
		IButton buscarArquivo = new IButton("Localizar");
		buscarArquivo.setWidth(80);
		buscarArquivo.setHeight(30);
		buscarArquivo.setIcon("actions/view.png");
		buscarArquivo.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
            	dataSourceFile.onExecuteQuery(fieldBuscarArquivo.getText());			}
		});
		;
		
		buscarHelp.setWidth(30);
		buscarHelp.setHeight(30);		
		buscarHelp.setSrc("actions/icon_ajuda.png");
		buscarHelp.setActionType(SelectionType.CHECKBOX);
		buscarHelp.setShowRollOver(false);  
		buscarHelp.setSelected(false);
		
		
		buscarHelp.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
            	onShowHelp(buscarHelp.getSelected());
            }
		});
		;
		
		
		fieldBuscarArquivo.getElement().setAttribute("placeholder", "Informe um critério de consulta ...");
		
		
		
		
		
		actionShowLista.setWidth(30);
		actionShowLista.setHeight(30);		
		actionShowLista.setSrc("ged/list_detalhes.png");
		actionShowLista.setActionType(SelectionType.CHECKBOX);
		actionShowLista.setShowRollOver(false);  
		actionShowLista.setSelected(false);
		actionShowLista.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				actionShowIconesGrandes.setSelected(false);
				onShowList();
			}
		});
		
		
		actionShowIconesGrandes.setWidth(30);
		actionShowIconesGrandes.setHeight(30);		
		actionShowIconesGrandes.setSrc("ged/list_icones_grandes.png");
		actionShowIconesGrandes.setActionType(SelectionType.CHECKBOX);
		actionShowIconesGrandes.setShowRollOver(false);  
		actionShowIconesGrandes.setSelected(false);
		actionShowIconesGrandes.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				actionShowLista.setSelected(false);
				onShowIconesGrandes();
			}
		});
		
		
		
		
		HLayout lineTop = new HLayout();
		lineTop.setWidth100();
		lineTop.setHeight("6px");
		this.addMember(lineTop);
		
		
		
		
		HLayout hLayoutField = new HLayout();
		hLayoutField.setHeight100();
		
		hLayoutField.setAlign(Alignment.CENTER);

		hLayoutField.addMember(imgGed);

		hLayoutField.addMember(fieldBuscarArquivo);
		hLayoutField.addMember(buscarArquivo);
		hLayoutField.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(4, ""));
		hLayoutField.addMember(buscarHelp);
		
		hLayoutField.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(10,""));
		hLayoutField.addMember(actionShowLista);
		hLayoutField.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(2,""));
		hLayoutField.addMember(actionShowIconesGrandes);
		
		
		HLayout findLayout = new HLayout();
		
		findLayout.setHeight(32);
		
				
		imgGed.setHeight(30);
		imgGed.setAlign(Alignment.RIGHT);
		
		findLayout.addMember(hLayoutField);
		
		this.addMember(findLayout);
		
		HLayout lineButton = new HLayout();
		lineButton.setWidth100();
		lineButton.setHeight("2px");
		this.addMember(lineButton);

		HLayout lineRed = new HLayout();
		lineRed.setWidth100();
		lineRed.setHeight("1px");
		lineRed.setBackgroundColor(HowMGWTUtilities.backgroundSeparadora);
		this.addMember(lineRed);

		HLayout lineButton2 = new HLayout();
		lineButton2.setWidth100();
		lineButton2.setHeight("2px");
		this.addMember(lineButton2);

		
		this.setBackgroundColor("#f5f5f5");
		
						
	}

	
	public void onShowHelp(boolean showHelp){}


	public DataSourceFiles getDataSourceFile() {
		return dataSourceFile;
	}


	public void setDataSourceFile(DataSourceFiles dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}


	public ImgButton getActionShowLista() {
		return actionShowLista;
	}


	public ImgButton getActionShowIconesGrandes() {
		return actionShowIconesGrandes;
	}
	
	
	public void onShowList(){}
	public void onShowIconesGrandes(){}


}