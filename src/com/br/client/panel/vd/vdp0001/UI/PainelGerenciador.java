package com.br.client.panel.vd.vdp0001.UI;
 
import com.br.client.configuracao.UnoRpcRequestBuilder;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.UIPartner;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.howmake.client.HowMProxyServiceAsync;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.BlurEvent;
import com.smartgwt.client.widgets.form.fields.events.BlurHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelGerenciador extends VLayout implements UIPartner{
	 
    // Critório de consulta.
	FiltroConsulta filtroConsulta = new FiltroConsulta();

	// Relação de Vendas
    RelacaoVendas relacaoVendas = new RelacaoVendas();	
	
	public PainelGerenciador(){
		initUI();
		initListners();
	}

	public void start(){
		filtroConsulta.popularGrupos();
	}
	
	public void initUI(){
	    this.setWidth("100%");   
		
        SectionStack sectionStack = new SectionStack();          
        sectionStack.setWidth100();
        sectionStack.setHeight100();
  
        sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);  
        sectionStack.setAnimateSections(false);  
        sectionStack.setOverflow(Overflow.HIDDEN);  	    
	    

	    filtroConsulta.setHeight("60px");
	    filtroConsulta.setShowHover(true);
	    
        SectionStackSection sessionFiltroConsulta = new SectionStackSection();  
        sessionFiltroConsulta.setTitle(Tradutor.i18n.criterioConsulta());  
        sessionFiltroConsulta.setExpanded(true);  
        sessionFiltroConsulta.setItems(filtroConsulta);  	    


        SectionStackSection sessionResultadoConsulta = new SectionStackSection();   
        sessionResultadoConsulta.setExpanded(true); 
        sessionResultadoConsulta.setShowHeader(false);
        sessionResultadoConsulta.setItems(relacaoVendas);  	  
	    
        sectionStack.setSections(sessionFiltroConsulta, sessionResultadoConsulta);
        
	    this.addMember(sectionStack);
	   
	   
	    // Rodape 
	    HLayout resumo = new HLayout(); 
	    resumo.setWidth100();
	    resumo.setHeight("60px");
	    
	    ResumoVendas resumoVendas = new ResumoVendas();
	    resumoVendas.setHeight("120px");      
	    resumo.addMember(resumoVendas);	    
	    
	    SumarioVendas sumario = new SumarioVendas();
	    sumario.setHeight("120px");
	    sumario.setWidth("350px");
	    resumo.addMember(sumario );

	    this.addMember(resumo);
	    
	    relacaoVendas.setSumarioVendas(sumario);
	    relacaoVendas.setResumoVendas(resumoVendas);
	    filtroConsulta.setSumarioVendas(sumario);
	    relacaoVendas.setFiltroConsulta(filtroConsulta);	    
	}
	
	public void initListners(){
		// Inclui um listner para executar a ação buscar.
		this.filtroConsulta.getActionBuscar().addClickHandler(new ClickHandler() { 
            public void onClick(ClickEvent event) {
            	if ( filtroConsulta.getGrupoVendas().getValueAsString() == null || filtroConsulta.getGrupoVendas().getValueAsString().trim().length() == 0 ){
            		SC.say(Tradutor.i18n.msgInformeUmGrupo());
            		return;
            	}
            	relacaoVendas.buscar(false);
            }
        });
		
		this.filtroConsulta.getActionImprimir().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Canvas.showPrintPreview(PainelGerenciador.this); 
			}
		});
		
		
		this.filtroConsulta.getOnMonitor().addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				relacaoVendas.setTimerSecunds(new Integer(filtroConsulta.getSecundsAutoMonitor().getValueAsString()));
				if ( ((Boolean) event.getValue()) )
					relacaoVendas.startScheduler();									
				else
					relacaoVendas.stopScheduler();
			}
		});

		this.filtroConsulta.getSecundsAutoMonitor().addBlurHandler(new BlurHandler() {
			
			@Override
			public void onBlur(BlurEvent event) {
				if ( filtroConsulta.getSecundsAutoMonitor().getValueAsString() == null ){
					SC.say(Tradutor.i18n.erroRefreshAutomaticoMaioIgual30Segundos());
					filtroConsulta.getOnMonitor().setValue(false);
					filtroConsulta.getOnMonitor().setDisabled(true);
					showFocusSecundsAutoMonitor();
					return;
				}
				if ( filtroConsulta.getSecundsAutoMonitor().getValueAsString().trim().length() == 0 ){
					SC.say(Tradutor.i18n.erroRefreshAutomaticoMaioIgual30Segundos());
					filtroConsulta.getOnMonitor().setValue(false);
					filtroConsulta.getOnMonitor().setDisabled(true);
					showFocusSecundsAutoMonitor();
					return;					
				}
				if ( ( new Integer(filtroConsulta.getSecundsAutoMonitor().getValueAsString().trim())).intValue() < 30 ){
					SC.say(Tradutor.i18n.erroRefreshAutomaticoMaioIgual30Segundos());
					filtroConsulta.getOnMonitor().setValue(false);
					filtroConsulta.getOnMonitor().setDisabled(true);
					showFocusSecundsAutoMonitor();
					return;					
				}
				filtroConsulta.getOnMonitor().setDisabled(false);				
				relacaoVendas.setTimerSecunds(new Integer(filtroConsulta.getSecundsAutoMonitor().getValueAsString()));
				relacaoVendas.startScheduler();
			}
		});
	}
	
	public void showFocusSecundsAutoMonitor(){
		Timer timer = new Timer(){
			public void run(){
				filtroConsulta.getSecundsAutoMonitor().focusInItem();
			}
		};
	}
 
}
