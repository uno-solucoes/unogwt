package com.br.client.panel.at.atw0117;

import java.util.Date;

import com.br.client.model.at.entity.eTouchAgenda;
import com.br.client.panel.registro.UIPartner;
import com.google.gwt.dom.client.StyleInjector;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelAgendaTouchScreen extends HowMGWTWindow implements UIPartner{
	
	private static WindowPainelDetalheEvento painelDetalheEvento = new WindowPainelDetalheEvento();
	private static WindowPainelEditaEvento painelEditaEvento;
	
	private HLayout mainHorizontalLayout = new HLayout();
	private VLayout mainVerticalLayout = new VLayout();

	private VLayout mainLayout = new VLayout();

	private PainelOpcoes painelOpcoes 	= new PainelOpcoes(){
		
		protected void onActionEspacos(){
			if( painelEspacos != null )
				painelEspacos.showTipoArea(TouchScreenConstantes.TIPO_ESPACO);
		}

		protected void onActionLocais(){
			if( painelEspacos != null )
				painelEspacos.showTipoArea(TouchScreenConstantes.TIPO_LOCAL);			
		}

		protected void onActionAno() {			
			if( painelEspacos != null )
				painelEspacos.configureData(new Date());
		};

		protected void onActionMeses() {
 
			if( painelEspacos != null )
				painelEspacos.configureData(new Date());
		};

	};
	private PainelEspacosLocais painelEspacos = new PainelEspacosLocais(this){
		protected void onRefreshTopDate(Date navegateDate) {
			painelTop.onRefreshTopDate(navegateDate);
		};
	};
	private PainelTop painelTop 		= new PainelTop(){
		{
			painelEspacos.setPainelTop(this);
		}
		@Override
		public void onCalendarSelectDate(Date currentDate) {
 
			painelEspacos.setCurrentDateNavegate(currentDate);
			painelEspacos.setFirstCurrentDate(null);
			painelEspacos.configureData(currentDate);
		}	
	};

	public PainelAgendaTouchScreen(){
	
		configureCSS();
		
		this.setCanDragReposition(false);
		this.setCanDragResize(false);
		this.setOverflow(Overflow.HIDDEN);
		this.setShowHeader(false);
		this.setShowEdges(false);
		
		start();
	}

	@Override
	public String getHowMGWTPrograma() {		
		return "ATW00117";
	}

	@Override
	public String getHowMGWTTitle() {
		return "Agenda";
	}

	@Override
	public void start() {

		this.setWidth100();
		this.setHeight100();

		mainLayout = new VLayout();
		
		mainLayout.setWidth100();
		mainLayout.setHeight100();

		mainLayout.setOverflow(Overflow.HIDDEN);
		
		mainLayout.addMember(painelTop);

		
		
		mainVerticalLayout.setWidth100();
		mainVerticalLayout.setHeight100();
		mainVerticalLayout.setAlign(Alignment.CENTER);
		// @TODO Incluir recurso para apresentar uma imagem definida pelo cliente.
		mainVerticalLayout.setStyleName("agendaVillaMain");

		mainHorizontalLayout.setWidth100();
		mainHorizontalLayout.setAutoHeight();
		mainHorizontalLayout.setAlign(Alignment.CENTER);
		
		HLayout painelOpcoesBody = new HLayout();						
		painelOpcoesBody.setAutoWidth();
		painelOpcoesBody.setAutoHeight();

		painelOpcoesBody.setShowShadow(true);
		painelOpcoesBody.setEdgeOpacity(1);
		
		painelOpcoesBody.addMember(painelOpcoes);

		painelEspacos.setWidth100();
		painelEspacos.setHeight100();

		painelOpcoesBody.addMember(painelEspacos);

		mainHorizontalLayout.addMember(painelOpcoesBody);
		mainVerticalLayout.addMember(mainHorizontalLayout);

		mainLayout.addMember( mainVerticalLayout );
		this.addItem(mainLayout);
		
		painelEspacos.setPainelTop(this.painelTop);
 
		painelEspacos.load();	
 
		
	}
	
//	
//	/**
//	 * Apresenta dos meses do ano.
//	 */
//	public void showPainelMeses(){
//		if ( this.painelMeses == null ){
//			this.painelMeses = new PainelMeses(){
//				@Override
//				public void onCalendarSelectDate(Date currentDate) {
//					painelEspacos.setCurrentDateNavegate(currentDate);
//					painelEspacos.setFirstCurrentDate(null);
//					painelEspacos.configureData(currentDate);
//				}
//			};
//			this.painelMeses.centerInPage();
// 		}
//
//		this.painelMeses.animateShow(AnimationEffect.FLY);
//
//		Timer timer = new Timer() {
//			
//			@Override
//			public void run() {
//				painelMeses.setCurrentDate(painelEspacos.getFirstCurrentDate());
//			}	
//		};
//		timer.schedule(500);
//	}	
	
	public static void showDetalhesEvento(eTouchAgenda touchAgenda){
		if ( painelDetalheEvento == null ){
			painelDetalheEvento = new WindowPainelDetalheEvento();
		}
		painelDetalheEvento.showTouchAgenda(touchAgenda);
	}
	
	
	public static void showEditaEvento(eTouchAgenda touchAgenda){
		if ( painelEditaEvento == null ){
			painelEditaEvento = new WindowPainelEditaEvento();	
		}
		painelEditaEvento.showTouchAgenda(touchAgenda);
	}	
	
	
	public void configureCSS(){
		
		String css = "";
		css+= ".detailAgendaBlock {\n";
		css+= "    border-left:1px solid #A7ABB4;\n";
		css+= "    border-top:1px solid #A7ABB4;\n";
		css+= "}\n";

		css+= ".detailAgenda,\n";
		css+= ".detailAgendaLabel{\n";
		css+= "    font-family:Arial,Verdana,sans-serif; font-size:16px;  font-weight:normal \n";
		// css+= "	   background-image:url("+PainelAgendaTouchScreen.BACKGROUND_IMAGE+");\n";
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

		String startColor = "#CC0000";
		String endColor   = "#8B0000";
		
		css+= ".agendaVillaTitle { \n";
		css+= "		display:block; \n";
		css+= "		filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='"+startColor+"', endColorstr='"+endColor+"');  \n";
	  	css+= "		background: -webkit-gradient(linear, left top, left bottom, from("+startColor+"), to("+endColor+"));  \n";
	  	css+= "		background: -moz-linear-gradient(top,  "+startColor+",  "+endColor+"); \n";  
	  	css+= "} \n";

		css+= ".agendaVillaMain { \n";
		css+= "		display:block; \n";
		
		css+= "		background: rgb(132,0,0); /* Old browsers */\n";
		css+= "		background: -moz-linear-gradient(top, rgba(132,0,0,1) 0%, rgba(89,0,0,1) 11%, rgba(155,2,0,1) 35%, rgba(150,0,0,1) 93%, rgba(122,0,0,1) 100%, rgba(204,0,0,1) 100%); /* FF3.6+ */\n";
		css+= "		background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(132,0,0,1)), color-stop(11%,rgba(89,0,0,1)), color-stop(35%,rgba(155,2,0,1)), color-stop(93%,rgba(150,0,0,1)), color-stop(100%,rgba(122,0,0,1)), color-stop(100%,rgba(204,0,0,1))); /* Chrome,Safari4+ */\n";
		css+= "		background: -webkit-linear-gradient(top, rgba(132,0,0,1) 0%,rgba(89,0,0,1) 11%,rgba(155,2,0,1) 35%,rgba(150,0,0,1) 93%,rgba(122,0,0,1) 100%,rgba(204,0,0,1) 100%); /* Chrome10+,Safari5.1+ */\n";
		css+= "		background: -o-linear-gradient(top, rgba(132,0,0,1) 0%,rgba(89,0,0,1) 11%,rgba(155,2,0,1) 35%,rgba(150,0,0,1) 93%,rgba(122,0,0,1) 100%,rgba(204,0,0,1) 100%); /* Opera 11.10+ */\n";
		css+= "		background: -ms-linear-gradient(top, rgba(132,0,0,1) 0%,rgba(89,0,0,1) 11%,rgba(155,2,0,1) 35%,rgba(150,0,0,1) 93%,rgba(122,0,0,1) 100%,rgba(204,0,0,1) 100%); /* IE10+ */\n";
		css+= "		background: linear-gradient(to bottom, rgba(132,0,0,1) 0%,rgba(89,0,0,1) 11%,rgba(155,2,0,1) 35%,rgba(150,0,0,1) 93%,rgba(122,0,0,1) 100%,rgba(204,0,0,1) 100%); /* W3C */\n";
		css+= "		filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#840000', endColorstr='#cc0000',GradientType=0 ); /* IE6-9 */\n";
		css+= "} \n";
 
		css+= ".agendaVillaButtonOver { \n";
		css+= "		display:block; \n";	
		css+= "		background: rgb(254,252,234); /* Old browsers */\n";
		css+= "		background: -moz-linear-gradient(top,  rgba(254,252,234,1) 0%, rgba(241,218,54,1) 100%); /* FF3.6+ */\n";
		css+= "		background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(254,252,234,1)), color-stop(100%,rgba(241,218,54,1))); /* Chrome,Safari4+ */\n";
		css+= "		background: -webkit-linear-gradient(top,  rgba(254,252,234,1) 0%,rgba(241,218,54,1) 100%); /* Chrome10+,Safari5.1+ */\n";
		css+= "		background: -o-linear-gradient(top,  rgba(254,252,234,1) 0%,rgba(241,218,54,1) 100%); /* Opera 11.10+ */\n";
		css+= "		background: -ms-linear-gradient(top,  rgba(254,252,234,1) 0%,rgba(241,218,54,1) 100%); /* IE10+ */\n";
		css+= "		background: linear-gradient(to bottom,  rgba(254,252,234,1) 0%,rgba(241,218,54,1) 100%); /* W3C */\n";
		css+= "		filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#fefcea', endColorstr='#f1da36',GradientType=0 ); /* IE6-9 */\n";
		css+= "} \n";	
		
		css+= ".agendaVillaButtonRed { \n";
		css+= "		display:block; \n";
		css+= "		background: rgb(204,0,0); /* Old browsers */\n";
		css+= "		background: -moz-linear-gradient(top,  rgba(204,0,0,1) 0%, rgba(237,2,2,1) 35%, rgba(242,2,2,1) 63%, rgba(204,0,0,1) 100%); /* FF3.6+ */\n";
		css+= "		background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(204,0,0,1)), color-stop(35%,rgba(237,2,2,1)), color-stop(63%,rgba(242,2,2,1)), color-stop(100%,rgba(204,0,0,1))); /* Chrome,Safari4+ */\n";
		css+= "		background: -webkit-linear-gradient(top,  rgba(204,0,0,1) 0%,rgba(237,2,2,1) 35%,rgba(242,2,2,1) 63%,rgba(204,0,0,1) 100%); /* Chrome10+,Safari5.1+ */\n";
		css+= "		background: -o-linear-gradient(top,  rgba(204,0,0,1) 0%,rgba(237,2,2,1) 35%,rgba(242,2,2,1) 63%,rgba(204,0,0,1) 100%); /* Opera 11.10+ */\n";
		css+= "		background: -ms-linear-gradient(top,  rgba(204,0,0,1) 0%,rgba(237,2,2,1) 35%,rgba(242,2,2,1) 63%,rgba(204,0,0,1) 100%); /* IE10+ */\n";
		css+= "		background: linear-gradient(to bottom,  rgba(204,0,0,1) 0%,rgba(237,2,2,1) 35%,rgba(242,2,2,1) 63%,rgba(204,0,0,1) 100%); /* W3C */\n";
		css+= "		filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#cc0000', endColorstr='#cc0000',GradientType=0 ); /* IE6-9 */\n";
		css+= "} \n";
		
		css+= ".agendaVillaButtonNormal { \n";
		css+= "		display:block; \n";
		
		css+= "		background: rgb(242,245,246); /* Old browsers */\n";
		css+= "		background: -moz-linear-gradient(top, rgba(242,245,246,1) 0%, rgba(227,234,237,1) 37%, rgba(200,215,220,1) 100%); /* FF3.6+ */\n";
		css+= "		background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(242,245,246,1)), color-stop(37%,rgba(227,234,237,1)), color-stop(100%,rgba(200,215,220,1))); /* Chrome,Safari4+ */\n";
		css+= "		background: -webkit-linear-gradient(top, rgba(242,245,246,1) 0%,rgba(227,234,237,1) 37%,rgba(200,215,220,1) 100%); /* Chrome10+,Safari5.1+ */\n";
		css+= "		background: -o-linear-gradient(top, rgba(242,245,246,1) 0%,rgba(227,234,237,1) 37%,rgba(200,215,220,1) 100%); /* Opera 11.10+ */\n";
		css+= "		background: -ms-linear-gradient(top, rgba(242,245,246,1) 0%,rgba(227,234,237,1) 37%,rgba(200,215,220,1) 100%); /* IE10+ */\n";
		css+= "		background: linear-gradient(to bottom, rgba(242,245,246,1) 0%,rgba(227,234,237,1) 37%,rgba(200,215,220,1) 100%); /* W3C */\n";
		css+= "		filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f2f5f6', endColorstr='#c8d7dc',GradientType=0 ); /* IE6-9 */ \n";
		css+= "} \n";
		
		css+= ".agendaVillaButtonYellow { \n";
		css+= "		background: rgb(254,191,1); /* Old browsers */\n";
		css+= "		background: -moz-linear-gradient(top,  rgba(254,191,1,1) 0%, rgba(234,152,0,1) 60%, rgba(249,191,29,1) 100%); /* FF3.6+ */\n";
		css+= "		background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(254,191,1,1)), color-stop(60%,rgba(234,152,0,1)), color-stop(100%,rgba(249,191,29,1))); /* Chrome,Safari4+ */\n";
		css+= "		background: -webkit-linear-gradient(top,  rgba(254,191,1,1) 0%,rgba(234,152,0,1) 60%,rgba(249,191,29,1) 100%); /* Chrome10+,Safari5.1+ */\n";
		css+= "		background: -o-linear-gradient(top,  rgba(254,191,1,1) 0%,rgba(234,152,0,1) 60%,rgba(249,191,29,1) 100%); /* Opera 11.10+ */\n";
		css+= "		background: -ms-linear-gradient(top,  rgba(254,191,1,1) 0%,rgba(234,152,0,1) 60%,rgba(249,191,29,1) 100%); /* IE10+ */\n";
		css+= "		background: linear-gradient(to bottom,  rgba(254,191,1,1) 0%,rgba(234,152,0,1) 60%,rgba(249,191,29,1) 100%); /* W3C */\n";
		css+= "		filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#febf01', endColorstr='#f9bf1d',GradientType=0 ); /* IE6-9 */\n";
		css+= "} \n";		
		

		
		
	  	css+= ".agendaVillaFontTitle { \n";
	  	css+= "     font-family:Arial,Verdana,sans-serif; font-size:11px; font-weight:normal;";
	  	css+= " 	color:#FFFFFF;";
	  	css+= "} \n";		
		

	  	
	  	
		StyleInjector.inject( css , true);		
	}

	/**
	 * @return the painelTop
	 */
	public PainelTop getPainelTop() {
		return painelTop;
	}

	/**
	 * @param painelTop the painelTop to set
	 */
	public void setPainelTop(PainelTop painelTop) {
		this.painelTop = painelTop;
	}
}