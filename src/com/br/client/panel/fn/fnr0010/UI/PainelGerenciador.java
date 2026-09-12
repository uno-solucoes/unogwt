package com.br.client.panel.fn.fnr0010.UI;

import com.br.client.configuracao.Fabrica;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.howmake.client.form.UI.HowMGWTReportViewer;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.shared.HowMGWTEntity;

public class PainelGerenciador extends HowMGWTReportViewer{
	
	public PainelGerenciador(){	
		super(new FiltroConsulta());
	}	

	/**
	 * Configura os critórios de consulta para execução do relatório.
	 * @param entity Entidade que será utilizada para configurar os
	 * parametros de critório de consulta.
	 * @return Retornar true se o relatório deverá ser executado.
     * caso contrório mostrar mensagem para o usuório para indicar 
     * o motivo que o relatório não será executado e em seguida 
     * retornar false.
	 */	
	@Override
	protected boolean onHowMExecuteReport(HowMGWTEntity entity) {

		FiltroConsulta filtroConsulta = (FiltroConsulta)getFilterPanel();
		
		DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyy-MM-dd");
		
		DateTimeFormat dateTimeFormatImprimir = DateTimeFormat.getFormat("dd/MM/yyyy");		
		
		String dataImprimeSaldo = ""+dateTimeFormatImprimir.format(filtroConsulta.getFieldDataInicio().getField().getValueAsDate());

		String dataInicio 		= ""+dateTimeFormat.format(filtroConsulta.getFieldDataInicio().getField().getValueAsDate());
		String dataFim    		= ""+dateTimeFormat.format(filtroConsulta.getFieldDataFim().getField().getValueAsDate())+" 23:59:59";
		
		String criterioConsulta = "<html><body>"+Tradutor.i18n.reportPeriodo()+"  "+
								  dateTimeFormatImprimir.format(filtroConsulta.getFieldDataInicio().getField().getValueAsDate())+
								  "  "+Tradutor.i18n.reportAte()+" " + 
								  dateTimeFormatImprimir.format(filtroConsulta.getFieldDataFim().getField().getValueAsDate())
								  +
								  "</body></html>";

		String codFornecedor	= filtroConsulta.getFieldCodigoFornecedor().getField().getField().getValueAsString();
		String sqlCodFornecedor = "";
		if( !HowMGWTUtilities.isEmpty( codFornecedor ) ){
			sqlCodFornecedor = " and tipa.cod_fornecedor = " + codFornecedor;
		}

		
 		Fabrica.createReportParameter(entity, "pDATA_INICIAL_IMPRIMIR", 		dataImprimeSaldo);			
		Fabrica.createReportParameter(entity, "pDATA_INICIAL", 					dataInicio);			
		Fabrica.createReportParameter(entity, "pDATA_FINAL",    				dataFim);
		Fabrica.createReportParameter(entity, "pCOD_FORNECEDOR",    			sqlCodFornecedor);
		
		Fabrica.createReportParameter(entity, "pCRITERIO_CONSULTA", 			criterioConsulta );
		Fabrica.createReportParameter(entity, "pIMPRIMIR_DETALHES",				filtroConsulta.getFieldImprimirDetalhes().getField().getValueAsBoolean());
		
		
		Fabrica.createParameter(entity, Fabrica.DEFAULT_REPORT_NAME 		, "RazaoContasPagar.jrxml" );
		return true;
	}	
	
	@Override
	public String getHowMGWTPrograma() {
		return "FNRW0010";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloFNR0010();
	}	
}