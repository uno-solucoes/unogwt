package com.br.client.panel.vd.vdw0035.UI;

import com.br.client.UnoGWTGateway;
import com.br.client.configuracao.Configuracao;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.UIPartner;
import com.smartgwt.client.widgets.layout.VLayout;

public class ManagerNFSE  extends VLayout implements UIPartner{

	private FiltroConsulta filtroConsulta = new FiltroConsulta(){
		@Override
		public void onBuscar(String codEmpresa, String dtInicio, String dtFim){			
			painelResultado.load(Configuracao.getCodEmpresa(),  dtInicio, dtFim);
		}
		
		@Override
		public void onExportarNFSEContador(String codEmpresa, String dtInicio, String dtFim) {
			painelResultado.onExportarNFSEContador(Configuracao.getCodEmpresa(),  dtInicio, dtFim);
		};
	};
	private PanelResultadoConsulta painelResultado = new PanelResultadoConsulta();
	
	@Override
	public void start() {
		 
		this.addMember(filtroConsulta);
		this.addMember(painelResultado);
		
	}

	
	
	public String getHowMGWTTitle(){
		return Tradutor.i18n.formTituloVDW0035();
	}

	public String getHowMGWTPrograma(){
		return "VDW0035";
	}	
	
	
}
