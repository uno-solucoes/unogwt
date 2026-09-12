package com.br.client.panel.ed.edw0002.UI;

import java.util.LinkedHashMap;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.UIPartner;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelMonitorEDI extends VLayout implements UIPartner{

	private PainelMonitorEDIControle monitorEdiControle = new PainelMonitorEDIControle();
	
	@Override
	public void start() {
		this.addMember(this.monitorEdiControle);
	}
	
	public String getHowMGWTTitle(){
		return Tradutor.i18n.formTituloEDW0002();
	}

	public String getHowMGWTPrograma(){
		return "EDW0002";
	}
	
	
	
	private static LinkedHashMap< String, String > situacoes;

	public static final String SITUACAO_TODOS 				= "";
	public static final String SITUACAO_AGUARDANDO_RESERVA 	= "1";
	public static final String SITUACAO_RESERVADO 			= "2";
	public static final String SITUACAO_RESERVA_EFETIVADA	= "3";
	public static final String SITUACAO_RESERVA_CANCELADA	= "4";
	public static final String SITUACAO_VENDA_CANCELADA 	= "5";

	public static final LinkedHashMap< String, String > getEDISituacoes(){
		if ( situacoes == null ){
			situacoes = new LinkedHashMap<String, String>();

			situacoes.put(SITUACAO_TODOS				,  "Todos");
			situacoes.put(SITUACAO_AGUARDANDO_RESERVA	,  "Aguardando reserva");
			situacoes.put(SITUACAO_RESERVADO			,  "Reservado");
			situacoes.put(SITUACAO_RESERVA_EFETIVADA	,  "Reserva Efetivada");
			situacoes.put(SITUACAO_RESERVA_CANCELADA	,  "Reserva Cancelada");
			situacoes.put(SITUACAO_VENDA_CANCELADA		,  "Venda Cancelada");
		
		}
		return situacoes;
	}
}