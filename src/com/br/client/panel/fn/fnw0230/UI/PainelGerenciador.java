package com.br.client.panel.fn.fnw0230.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.UIPartner;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * Balancete 
 * @author JPLEISER
 */
public class PainelGerenciador extends VLayout implements UIPartner{
		
	private ResultadoConsulta resultadoConsulta;

	private FiltroConsulta filtroConsulta;
	
	private boolean showCentroCusto;
	
	public PainelGerenciador(boolean showCentroCusto){	
		this.setWidth100();
		this.setHeight100();
		
		resultadoConsulta = new ResultadoConsulta(showCentroCusto);
		
		filtroConsulta = new FiltroConsulta(showCentroCusto){

			public void onSetCallCentroCusto(boolean callExecuteCentroCusto) {
				resultadoConsulta.setCallCentroCusto(callExecuteCentroCusto);			
			};		
			
		};

	}

	public void start(){
	        SectionStack sectionStack = new SectionStack();          
	        sectionStack.setWidth100();
	        sectionStack.setHeight100();
	  
	        sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);  
	        sectionStack.setAnimateSections(false);  
	        sectionStack.setOverflow(Overflow.HIDDEN);  	    
		    
		    filtroConsulta.setHeight("60px");
		    filtroConsulta.setShowHover(true);
		    
		    resultadoConsulta.setFiltroConsulta(filtroConsulta);
		    
	        SectionStackSection sessionFiltroConsulta = new SectionStackSection();  
	        sessionFiltroConsulta.setTitle(Tradutor.i18n.criterioConsulta());  
	        sessionFiltroConsulta.setExpanded(true);  
	        sessionFiltroConsulta.setItems(filtroConsulta);  	    


	        SectionStackSection sessionResultadoConsulta = new SectionStackSection();   
	        sessionResultadoConsulta.setExpanded(true); 
	        sessionResultadoConsulta.setShowHeader(false);
	        sessionResultadoConsulta.setItems(resultadoConsulta);  	  
		    
	        sectionStack.setSections(sessionFiltroConsulta, sessionResultadoConsulta);
	        	        
		    this.addMember(sectionStack);
		    
			this.filtroConsulta.getActionBuscar().addClickHandler(new ClickHandler() { 
		            public void onClick(ClickEvent event) {
		            	if( ! filtroConsulta.isValidPeriodo()){
		            		return;
		            	}
		            	resultadoConsulta.buscarMovimentacao();
		            }
		    });	
	}
	
	
	public void configure(){
		
	}
}