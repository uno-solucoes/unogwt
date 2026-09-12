package com.br.client.panel.sg.sgw0027.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.sg.sgw0001.UI.PainelParametros;
import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

public class ToolbarVertical extends ToolStrip {

	private PainelParametros painelParametros;
	
	private ResultadoConsulta resultadoConsulta;
	private VLayout toolbarCheckList;
	private ToolStripButton actionParameters = new ToolStripButton();
	
	public ToolbarVertical(){
		this.setVertical(true);  
		this.setWidth(32); 
		this.setHeight100();
		this.setBackgroundColor("rgb(133,169,182)");
		
        final ToolStripButton boldButton = new ToolStripButton();  
        boldButton.setIcon("geral/btnFechar.png");  
        boldButton.setActionType(SelectionType.CHECKBOX);  
        this.addButton(boldButton);  
        
        boldButton.setShowRollOver(false);  
        // boldButton.setActionType(SelectionType.CHECKBOX);  
        
        boldButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if ( toolbarCheckList.isVisible() ){
					boldButton.setIcon("geral/btnChecklist.png");  
					toolbarCheckList.setVisible(false);
	 
				}
				else{
		 
					boldButton.setIcon("geral/btnFechar.png");
					toolbarCheckList.setVisible(true);
				}
			}
		});	

        this.addSeparator();
		actionParameters.setIcon("geral/tools/btnParameters.png");
		actionParameters.setTooltip(Tradutor.i18n.formTituloSGW0001());
		actionParameters.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if ( painelParametros == null ) 
					painelParametros = new PainelParametros(){
						@Override
						public void hide() {
							super.hide();
							//if ( painelParametros.isChangeValue() )
								getResultadoConsulta().loadParameters();
						}
					};
				
				painelParametros.centerInPage();
				painelParametros.showNFSeParameters();
			}
		});
        this.addButton(this.actionParameters);
	
	}

	/**
	 * @return the toolbarCheckList
	 */
	public VLayout getToolbarCheckList() {
		return toolbarCheckList;
	}

	/**
	 * @param toolbarCheckList the toolbarCheckList to set
	 */
	public void setToolbarCheckList(VLayout toolbarCheckList) {
		this.toolbarCheckList = toolbarCheckList;
	}

	/**
	 * @return the resultadoConsulta
	 */
	public ResultadoConsulta getResultadoConsulta() {
		return resultadoConsulta;
	}

	/**
	 * @param resultadoConsulta the resultadoConsulta to set
	 */
	public void setResultadoConsulta(ResultadoConsulta resultadoConsulta) {
		this.resultadoConsulta = resultadoConsulta;
	}
	
}
