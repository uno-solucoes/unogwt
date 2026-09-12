package com.br.client.panel.at.atw0117a;

import java.util.LinkedHashMap;

import com.br.client.model.at.entity.eTouchLocalEspaco;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ImageStyle;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelLocais extends VLayout{
	
	private ClickHandler clickHandler = new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			parentPainelCalendarioAno.showLocal(((ActionLocalButton)event.getSource()).getLocalEspaco());			
		}
	};
	
	private VLayout adjustLayout = new VLayout();
	private VLayout monitorLayout = new VLayout();
	private PainelCalendarioAno parentPainelCalendarioAno;

	private HowMGWTProperty propertyMonitorar = new HowMGWTProperty("monitorar", "Monitorar");
	private HowMGWTProperty propertyTempo = new HowMGWTProperty("tempo", "Tempo");
	
	public PainelLocais(PainelCalendarioAno painelCalendarioAno){

		this.parentPainelCalendarioAno = painelCalendarioAno;
		
		this.setWidth(126);
		this.setHeight100();

		int wLabel = 40;
		
		propertyMonitorar.setBound(wLabel, 60);
		propertyMonitorar.createHowMGWTCheckboxItem();
		monitorLayout.addMember(propertyMonitorar.getCanvas());
		propertyMonitorar.getHowMGWTCheckboxItem().getField().addChangedHandler(new ChangedHandler() {			
			@Override
			public void onChanged(ChangedEvent event) {
				onChangeMonitor();
			}
		});
		
		
		propertyTempo.setBound(wLabel, 70);
		propertyTempo.createHowMGWTFormFieldSelectItem();
		monitorLayout.addMember(propertyTempo.getCanvas());
		LinkedHashMap<String, String> mapTempo = new LinkedHashMap<String, String>();
		mapTempo.put("1", "1 minuto");
		mapTempo.put("2", "2 minutos");
		mapTempo.put("3", "3 minutos");
		mapTempo.put("4", "4 minutos");
		mapTempo.put("5", "5 minutos");
		mapTempo.put("6", "6 minutos");
		mapTempo.put("7", "7 minutos");
		mapTempo.put("8", "8 minutos");
		mapTempo.put("9", "9 minutos");
		mapTempo.put("10", "10 minutos");
		propertyTempo.getHowMGWTEditorSelectItem().getField().setValueMap(mapTempo);
		propertyTempo.setHowmFormValue("1");

		propertyTempo.getHowMGWTEditorSelectItem().getField().addChangedHandler(new ChangedHandler() {			
			@Override
			public void onChanged(ChangedEvent event) {
				
			}
		});
		
		
		
		monitorLayout.setWidth100();
		monitorLayout.setAutoHeight();
		monitorLayout.setBackgroundColor("#ffeeaa");
		this.addMember(monitorLayout);
		
		
		
		
		
		adjustLayout.setWidth100();
		adjustLayout.setHeight100();
		adjustLayout.setBackgroundColor("#FFFFFF");
		
		// adjustLayout.setShowShadow(true);
		
		this.setMargin(6);
		this.setStyleName("DirectSaleShadow");	
		
		
		adjustLayout.setAlign(VerticalAlignment.CENTER);
		
		this.addMember(this.adjustLayout);
		
		

		
	}
	
    private ActionLocalButton getIconButton(eTouchLocalEspaco localEspaco, String iconName) {
    	
    	ActionLocalButton button = new ActionLocalButton(localEspaco);
        
        button.setWrap(true);
        button.setIconWidth(32);
        button.setIconHeight(32);
        button.setWidth100();
        button.setHeight(36);
        button.setImageType(ImageStyle.NORMAL);
        button.setTitle(localEspaco.getDescAbrevLocal());
                
        button.setIcon("agenda/"+iconName);  
        button.setAlign(Alignment.LEFT);
        
        return button;  
        
    }


    public void showLocais(eTouchLocalEspaco[] locaisEspacos){

    	if( locaisEspacos == null ){
    		return;
    	}

    	eTouchLocalEspaco currentLocalEspaco = null;
    	for( eTouchLocalEspaco le : locaisEspacos){
    		ActionLocalButton button = getIconButton(le, "local_evento.png" );
    		this.adjustLayout.addMember(button);
    		this.adjustLayout.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(5, ""));

    		if( currentLocalEspaco == null )
    			currentLocalEspaco = le;

    		button.addClickHandler(clickHandler);
    	}

    	this.parentPainelCalendarioAno.showLocal(currentLocalEspaco); 
    }
    

    public void onChangeMonitor(){
    	if( "true".equalsIgnoreCase(this.propertyMonitorar.getHowmFormValueToString() ) ){
    		this.propertyTempo.getCanvas().setDisabled(true);
    		Scheduler.get().scheduleFixedPeriod(new Scheduler.RepeatingCommand() {
				
				@Override
				public boolean execute() {
					if( "true".equals( propertyMonitorar.getHowmFormValueToString() ) ){
						
						System.out.println("Executando tarefa : "+System.currentTimeMillis());
						parentPainelCalendarioAno.refreshAno();	
						return true;
					}
					else{
						return false;
					}
				}
			}, HowMGWTUtilities.getInteger( this.propertyTempo.getHowmFormValueToString() ) * 1000 * 60 ) ;
    	}
    	else{
    		this.propertyTempo.getCanvas().setDisabled(false);
    	}
    }
    
}