package com.br.client.panel.gg.ggw0006.UI;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.howmake.client.form.UI.HowMGWTReportViewer;
import com.howmake.client.form.model.HowMGWTLinkAction;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.shared.HowMGWTEntity;
import com.smartgwt.client.util.SC;

public class PainelGerenciadorRentabilidade extends HowMGWTReportViewer{

	public PainelGerenciadorRentabilidade(){
		super(new FiltroConsulta());
		
		((FiltroConsulta)this.getFilterPanel()).getFieldCodigoPedido().setHowMLinkAction(new HowMGWTLinkAction() {
			
			@Override
			public void onHowMSelectAction() {
				executeReport();
			}
		});
		
		((FiltroConsulta)this.getFilterPanel()).getFieldCodigoPedido().setHowMGWTParentPlugIn(this);
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

		if ( HowMGWTUtilities.isEmpty(filtroConsulta.getFieldCodigoPedido().getField().getField().getValueAsString()) ){
			SC.say("Informe o numero do pedido para consultar a rentabilidade...");
			return false;
		}
		
		Fabrica.createReportParameter(entity, "pCOD_PEDIDO"          ,new Integer(filtroConsulta.getFieldCodigoPedido().getField().getField().getValueAsString()) );
		Fabrica.createReportParameter(entity, "pCOD_EMPRESA"         ,new Integer(Configuracao.getCodEmpresa()) );
		
		Fabrica.createParameter(entity, Fabrica.DEFAULT_REPORT_NAME  , "GGW0006_Rentabilidade1.jrxml" );
		return true;
	}		
	
	

	@Override
	public String getHowMGWTPrograma() {
		return "GGW0006";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloGGW0006();
	}	
}