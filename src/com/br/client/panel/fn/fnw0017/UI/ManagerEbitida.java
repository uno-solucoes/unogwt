package com.br.client.panel.fn.fnw0017.UI;

import com.br.client.panel.fn.fnw0017.model.eOrcamentoContaTreeNode;
import com.br.client.panel.registro.UIPartner;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.TreeNode;

public class ManagerEbitida extends VLayout implements UIPartner{

	private FiltroConsulta filtroConsulta = new FiltroConsulta(){
		protected void onChangedOrcamento(){
			painelResultado.setNodesTotais(new TreeNode[0]);
			painelResultado.setNodesContas(new eOrcamentoContaTreeNode[0]);
			painelResultado.createTree();
		}
		protected void onChangedCenario(){
        	filtroConsulta.getBean().setCenario( filtroConsulta.getPropertyCenario().getHowMValue() );
        	painelResultado.executeQuery( filtroConsulta.getBean() );
		}
	};
	private PainelResultado painelResultado = new PainelResultado();
	
	public ManagerEbitida(){
		this.setWidth100();
		this.setHeight100();
	}
	
	@Override
	public void start() {
		
		this.addMember(filtroConsulta); 
		this.addMember(painelResultado);
	    
		this.filtroConsulta.getActionBuscar().addClickHandler(new ClickHandler() { 
	            public void onClick(ClickEvent event) {
	            	filtroConsulta.getBean().setCenario( filtroConsulta.getPropertyCenario().getHowMValue() );
	            	painelResultado.executeQuery( filtroConsulta.getBean() );
	            }
	        });	
	}
}
