package com.br.client.panel.vd.vdw0800.UI;

import com.br.client.model.vd.entity.eNFSEEstatisticas;
import com.br.client.model.vd.vdw0800.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTChart;
import com.howmake.client.form.UI.HowMGWTChartPane;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelChartParticipacaoPadroes extends VLayout{
	
	private HowMGWTChartPane chartParticiapacaoVariacaoPadrao = new HowMGWTChartPane();
	private HowMGWTChartPane chartParticiapacaoPadrao 		  = new HowMGWTChartPane();
	private HowMGWTChartPane chartParticiapacaoEstado 		  = new HowMGWTChartPane();
	private HowMGWTChartPane chartParticiapacaoGeral 		  = new HowMGWTChartPane();
	
	public PainelChartParticipacaoPadroes(){
	
		this.setWidth100();
		this.setHeight100();

		this.setOverflow(Overflow.AUTO);
		
		HLayout par1 = new HLayout();
		par1.setWidth100();
		par1.setHeight(300);
		
		chartParticiapacaoVariacaoPadrao.setTitle(Tradutor.i18n.formParticipacaoVariacaoPadrao());
		chartParticiapacaoVariacaoPadrao.setWidth("400px");
		chartParticiapacaoVariacaoPadrao.setHeight("300px");
		chartParticiapacaoVariacaoPadrao.getChart().addColumnString("Padrao");
		chartParticiapacaoVariacaoPadrao.getChart().addColumnNumber("Participacao");
		chartParticiapacaoVariacaoPadrao.getChart().setTypePIE();
		chartParticiapacaoVariacaoPadrao.getChart().setIs3D(true);
		chartParticiapacaoVariacaoPadrao.getChart().createChartArea();
		
		chartParticiapacaoVariacaoPadrao.getChart().createLegend();
		chartParticiapacaoVariacaoPadrao.getChart().getLegend().setPosition("left");
		chartParticiapacaoVariacaoPadrao.getChart().getLegend().getTextStyle().setFontSize(8);
		
		par1.addMember(chartParticiapacaoVariacaoPadrao);

		HLayout sepGraficosPar1 = new HLayout();
		sepGraficosPar1.setWidth(1);
		sepGraficosPar1.setHeight100();
		sepGraficosPar1.setBackgroundColor("red");
		par1.addMember(sepGraficosPar1);
		
		chartParticiapacaoPadrao.setTitle(Tradutor.i18n.formParticipacaoPadrao());
		chartParticiapacaoPadrao.setWidth("400px");
		chartParticiapacaoPadrao.setHeight("300px");
		chartParticiapacaoPadrao.getChart().addColumnString("Padrao"); 
		chartParticiapacaoPadrao.getChart().addColumnNumber("Participacao"); 
		chartParticiapacaoPadrao.getChart().setTypePIE();
		chartParticiapacaoPadrao.getChart().setIs3D(true);
		chartParticiapacaoPadrao.getChart().createChartArea();

		chartParticiapacaoPadrao.getChart().createLegend();
		chartParticiapacaoPadrao.getChart().getLegend().setPosition("left");
		chartParticiapacaoPadrao.getChart().getLegend().getTextStyle().setFontSize(8);		

		par1.addMember(chartParticiapacaoPadrao);
	
		this.addMember(par1);

		chartParticiapacaoEstado.setTitle(Tradutor.i18n.formParticipacaoEstado());
		chartParticiapacaoEstado.setWidth("800px");
		chartParticiapacaoEstado.setHeight("300px");
		chartParticiapacaoEstado.getChart().addColumnString("Estado"); 
		chartParticiapacaoEstado.getChart().addColumnNumber("Municipios sem NFSE"); 
		chartParticiapacaoEstado.getChart().addColumnNumber("Municipios com NFSE"); 
		chartParticiapacaoEstado.getChart().setTypeColumnBAR();
		
		chartParticiapacaoEstado.getChart().createVAxis();
		chartParticiapacaoEstado.getChart().getvAxis().setTitle("Quantidade Municipios");

		chartParticiapacaoEstado.getChart().createLegend();
		chartParticiapacaoEstado.getChart().createHAxis();
		chartParticiapacaoEstado.getChart().gethAxis().setTitle("Estados");
		
		this.addMember(chartParticiapacaoEstado);
		

		chartParticiapacaoGeral.setTitle(Tradutor.i18n.formParticipacaoGeral());
		chartParticiapacaoGeral.setWidth("600px");
		chartParticiapacaoGeral.setHeight("500px");
		chartParticiapacaoGeral.getChart().addColumnString("Padrao"); 
		chartParticiapacaoGeral.getChart().addColumnNumber("Participacao"); 
		chartParticiapacaoGeral.getChart().setTypePIE();
		chartParticiapacaoGeral.getChart().setIs3D(true);
		chartParticiapacaoGeral.getChart().createChartArea();

		chartParticiapacaoGeral.getChart().createLegend();
		chartParticiapacaoGeral.getChart().getLegend().setPosition("left");
		chartParticiapacaoGeral.getChart().getLegend().getTextStyle().setFontSize(8);		

		this.addMember(chartParticiapacaoGeral);

	
		
	}

	
	public void drawChart(){
		
		HowMGWTWindowWait.showWait();

		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				load(( FormBean)formBean);				
				HowMGWTWindowWait.hideWait();
			}
		};					 
		String body = "";
		struts.request("vdw0800.do?method=gerarEstatisticas",  "VDW0800Form", "");			
	
	}

	
	private void load(FormBean bean){

		HowMGWTChart chart = null;
		
		chart = chartParticiapacaoVariacaoPadrao.getChart();
		// Gráfico Variação entre Padrões
		chart.setUrl("/UnoGWTChart.jsp");
		chart.getDados().clear();
		if ( bean.getParticipacaoPadroesVariacoes() != null ){
			for ( eNFSEEstatisticas e : bean.getParticipacaoPadroesVariacoes() )
				chart.getDados().add(new String[]{e.getLabel(),e.getValue()});
		}
		chart.drawChart();		


		chart = chartParticiapacaoPadrao.getChart();
 	
		chart.setUrl("/UnoGWTChart.jsp");
		chart.getDados().clear();
		if ( bean.getParticipacaoPadroes() != null ){
			for ( eNFSEEstatisticas e : bean.getParticipacaoPadroes() )
				chart.getDados().add(new String[]{e.getLabel(),e.getValue()});
		}

		chart.drawChart();		


		chart = chartParticiapacaoEstado.getChart();
		chart.getDados().clear();	 	
		chart.setUrl("/UnoGWTChart.jsp");
		if ( bean.getParticipacaoEstados() != null ){
			for ( eNFSEEstatisticas e : bean.getParticipacaoEstados() )
				chart.getDados().add(new String[]{e.getLabel(),e.getValue(), e.getValue1() });
		}

		chart.drawChart();		
    	// System.out.println("Request:\n"+chartParticiapacaoEstado.getChart().getRequestZoom());


		chart = chartParticiapacaoGeral.getChart();
		chart.getDados().clear();	 	
		chart.setUrl("/UnoGWTChart.jsp");
		if ( bean.getParticipacaoEstados() != null ){
			for ( eNFSEEstatisticas e : bean.getParticipacaoGeral() )
				chart.getDados().add(new String[]{e.getLabel(),e.getValue()});
		}

		chart.drawChart();		
	}
}
