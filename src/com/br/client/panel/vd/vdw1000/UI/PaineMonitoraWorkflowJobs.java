package com.br.client.panel.vd.vdw1000.UI;

import com.br.client.configuracao.Configuracao;
 
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.smartgwt.client.widgets.layout.VLayout;

public class PaineMonitoraWorkflowJobs extends VLayout{

	boolean repeatMonitor = true;
		
 
	
	public PaineMonitoraWorkflowJobs(){
		
		this.setWidth100();
		this.setHeight100();

//		Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
//			
//			@Override
//			public boolean execute() {
//				onRefreshMonitor();
//				return repeatMonitor;
//			}
//		}
//		, 10000);

 
	
	}	

	private int m = 0; 
	/**
	 * Atualiza o monitoramento do sistema a cada 10s
	 */
	public void onRefreshMonitor(){

		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new com.br.client.model.vd.vdw1001.FormBean()) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				com.br.client.model.vd.vdw1001.FormBean form = (com.br.client.model.vd.vdw1001.FormBean)formBean;
				// showHistorico(form.getEntityLoteWS());
				System.out.println("Monitoramento executado ("+m+")");
			}
		};

		com.br.client.model.vd.vdw1001.FormBean bean = new com.br.client.model.vd.vdw1001.FormBean();
		bean.setCodEmpresa(Configuracao.getCodEmpresa());

		struts.request("vdw1001.do?method=buscarMonitoramento",  "VDW1001Form", bean.toSendBody("") );
	}	
	
}