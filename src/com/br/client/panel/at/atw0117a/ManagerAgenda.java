package com.br.client.panel.at.atw0117a;

import java.util.Date;

import com.br.client.panel.registro.UIPartner;
import com.google.gwt.dom.client.StyleInjector;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.partner.HowMGWTNavigator;
import com.howmake.server.HowMUtilities;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ManagerAgenda extends HowMGWTWindow implements UIPartner{

	private PainelTop painelTop  = new PainelTop(){
		public void anoAnterior(){
			painelCalendarioAno.anoAnterior();
		}
		
		public void proximoAno(){
			painelCalendarioAno.proximoAno();
		}

	};
	private VLayout mainLayout 	 = new VLayout();
	private PainelCalendarioAno painelCalendarioAno = new PainelCalendarioAno(painelTop);	
	
	private VLayout centerLayout = new VLayout();
	
	public ManagerAgenda(){

		this.setCanDragReposition(false);
		this.setCanDragResize(false);
		this.setOverflow(Overflow.HIDDEN);
		this.setShowHeader(false);
		this.setShowEdges(false);

		this.mainLayout.setOverflow(Overflow.HIDDEN);
		this.mainLayout.setWidth100();
		this.mainLayout.setHeight100();
		this.mainLayout.setBackgroundColor("#E0EDE5");

		this.painelTop.setWidth100();
		this.painelTop.setHeight(116);				
		this.painelTop.refreshTitle(new Date());

		this.mainLayout.addMember(this.painelTop);

		this.centerLayout.addMember(painelCalendarioAno);
	
		this.mainLayout.addMember(this.centerLayout);

		int wWindow = 1020;
		int hWindow =  650;
		
		if ( ! HowMGWTNavigator.isIE() && ( HowMGWTNavigator.isMobile() || HowMGWTNavigator.isTabbletApple() || HowMGWTNavigator.isTabbletGalaxy() ) ){
			if( HowMGWTNavigator.isMobile() ){
				
				this.setWidth(wWindow);
				this.setHeight(hWindow);
			}
			if( HowMGWTNavigator.isTabbletApple() || HowMGWTNavigator.isTabbletGalaxy() ){
				
				this.setWidth(wWindow);
				this.setHeight(hWindow);
				
			}
		}
		else{
			this.centerLayout.setWidth100();
			this.centerLayout.setHeight100();

			this.setMinWidth(wWindow);
			this.setMinHeight(hWindow);

			this.setWidth100();
			this.setHeight100();
			
		}		
		this.addItem(this.mainLayout);				
		
		configureCSS();

	}
	
	

	@Override
	public void start() {
	}

	@Override
	public String getHowMGWTPrograma() {		
		return "ATW00117";
	}

	@Override
	public String getHowMGWTTitle() {
		return "Agenda";
	}

	
	
	

	
	
	
	
	public void configureCSS(){
		
		String css = "";
 
		css+= ".detailAgenda,\n";
		css+= ".detailAgendaLabel{\n";
		css+= "    font-family:Arial,Verdana,sans-serif; font-size:11px;  font-weight:normal \n";
		css+= "    color:#003168;\n";
 
		css+= "    border-right:1px solid #A7ABB4;\n";
		css+= "    border-bottom:1px solid #A7ABB4;\n";
		css+= "}\n";

		css+= ".detailAgendaLabel {\n";
		css+= "    font-weight:bold;\n";
		css+= "	   color:#4C4C4C;\n";
		css+= "	   background-color:#F6F7F9;\n";
		css+= "    text-align:right;\n";
		css+= "}\n";
		
		StyleInjector.inject( css , true);		
	}
}
