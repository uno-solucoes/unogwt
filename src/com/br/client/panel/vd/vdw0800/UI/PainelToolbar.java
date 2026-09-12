package com.br.client.panel.vd.vdw0800.UI;

import com.br.client.panel.I18N.Tradutor;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

public class PainelToolbar extends ToolStrip{

	private PainelNFSE parentNFSE;
	public ToolStripButton actionLinks = new ToolStripButton(); 
	
	public PainelToolbar(){

		this.setVertical(true);  
		this.setWidth(32); 
		this.setHeight100();
		
		this.setHeight100();
		this.setWidth("40px");
		
		
		this.addMember(getSeparator(10));
		
		ToolStripButton actionListaCidades = new ToolStripButton(); 
		actionListaCidades.setIcon("tools/bot_list.png");   
		actionListaCidades.setHeight(34);
		actionListaCidades.setIconSize(32);
		actionListaCidades.setPrompt(Tradutor.i18n.formListaCidades());
        this.addButton(actionListaCidades);  
        actionListaCidades.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				parentNFSE.showPanel(PainelNFSE.OPTION_LIST_CIDADES);
			}
		});		

		this.addMember(getSeparator(5));        
        
		actionLinks.setIcon("tools/bot_link.png");   
		actionLinks.setHeight(34);
		actionLinks.setIconSize(32);
		actionLinks.setPrompt(Tradutor.i18n.formLinksCidades());
        this.addButton(actionLinks);  
        actionLinks.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				parentNFSE.showPanel(PainelNFSE.OPTION_PAINEL_LINKS);
			}
		});	        

		this.addMember(getSeparator(5));        
        
		ToolStripButton actionChartPizza = new ToolStripButton(); 
        actionChartPizza.setIcon("tools/bot_chart_pizza.png");   
        actionChartPizza.setHeight(34);
        actionChartPizza.setIconSize(32);
        actionChartPizza.setPrompt(Tradutor.i18n.formEstatisticas());
        this.addButton(actionChartPizza);  
        actionChartPizza.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				parentNFSE.showPanel(PainelNFSE.OPTION_CHART_ESTATISTICAS);				
			}
		});	
        
        
        this.actionLinks.setDisabled(true);
	}

	/**
	 * @return the parentNFSE
	 */
	public PainelNFSE getParentNFSE() {
		return parentNFSE;
	}

	/**
	 * @param parentNFSE the parentNFSE to set
	 */
	public void setParentNFSE(PainelNFSE parentNFSE) {
		this.parentNFSE = parentNFSE;
	}
	
	private HLayout getSeparator(int size){
		HLayout sep = new HLayout();
		sep.setHeight(size);
		sep.setWidth(10);
		return sep;
	}
}
