package com.br.client.panel.vd.vdw1000.UI.servicos;

import com.br.client.model.vd.entity.eNFSEEmitenteWS;
import com.howmake.client.form.UI.HowMGWTPanelDocumentBar;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.widgets.layout.VLayout;

public class WindowConfiguracaoServicos extends HowMGWTWindow{

	private VLayout mainLayout = new VLayout();
	private HowMGWTPanelDocumentBar panelDocumentBar = new HowMGWTPanelDocumentBar("ico_servico_monitoramento.png", getHowMGWTTitle(), "Aqui você pode configurar o serviço de monitoramento de RPS...");
	private PanelServicos panelServicos = new PanelServicos();
	
	public WindowConfiguracaoServicos(){
	
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		this.setWidth(600);
		this.setHeight(280);
		
		this.setIsModal(true);
		
		mainLayout.addMember(panelDocumentBar);
		mainLayout.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(1,HowMGWTUtilities.backgroundSeparadora));
		mainLayout.addMember(panelServicos);
		
		this.addItem(mainLayout);
	}
	
	
	public void showConfiguracoes(eNFSEEmitenteWS currentEntityEmitente){
		this.centerInPage();
		this.show();
		
		panelServicos.showServicos(currentEntityEmitente);
	}
	
	@Override
	public String getHowMGWTTitle() {
		return "Configuração do serviços de Monitoramento";
	}

	@Override
	public String getHowMGWTPrograma() {
		return "VDW1000S";
	}

}
