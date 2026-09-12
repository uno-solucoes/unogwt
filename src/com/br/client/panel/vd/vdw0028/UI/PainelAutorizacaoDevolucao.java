package com.br.client.panel.vd.vdw0028.UI;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTReportViewer;
import com.howmake.shared.HowMGWTEntity;

// Novo Relatório VDW00XX -Motivos de Devolução

// FILTROS
// 1. Filtros por data inicial e final
// 2. Filtro por vendedor
// 3. Filtro por motivo
// 4. Filtro por cliente
//
// LISTA
// 1. código Motivo
// 2. Descrição abreviada do motivo
// 3. Quantidade devoluções
// 4. % quantidade
// 5. Valor devolvido
// 6. % valor

public class PainelAutorizacaoDevolucao extends HowMGWTReportViewer{

	public PainelAutorizacaoDevolucao(){
		super(new FiltroConsulta());
		
//		((FiltroConsulta)this.getFilterPanel()).getFieldCodigoPedido().setHowMLinkAction(new HowMGWTLinkAction() {
//			
//			@Override
//			public void onHowMSelectAction() {
//				executeReport();
//			}
//		});
//		
//		((FiltroConsulta)this.getFilterPanel()).getFieldCodigoPedido().setHowMGWTParentPlugIn(this);
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

//		if ( HowMGWTUtilities.isEmpty(filtroConsulta.getFieldCodigoPedido().getField().getField().getValueAsString()) ){
//			SC.say("Informe o numero do pedido para consultar a rentabilidade...");
//			return false;
//		}
//		
 		Fabrica.createReportParameter(entity, "pCOD_EMPRESA"         ,new Integer(Configuracao.getCodEmpresa()) );
		
		Fabrica.createParameter(entity, Fabrica.DEFAULT_REPORT_NAME  , "VDW0028_AutorizacaoDevolucao.jrxml" );
		return true;
	}		
	
	

	@Override
	public String getHowMGWTPrograma() {
		return "VDW0028";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloVDW0028();
	}	
}