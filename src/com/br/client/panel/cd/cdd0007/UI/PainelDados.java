package com.br.client.panel.cd.cdd0007.UI;

import com.br.client.panel.cd.cdd0007.model.DataSourcePainelDados;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerRecord;

public class PainelDados extends DetailViewer{
	 
	
	public PainelDados(){
		
        this.setWidth100();
        this.setHeight("100px");
        this.setMargin(2); 
        this.setAutoHeight();            
        this.setEmptyMessage("Nenhum item encontrado...");  		
	}
	
	
	/**
	 * Seta os dados do participante 
	 * @param participante
	 * @param vendedor
	 * @param percComissao
	 */
	public void setDados(DataSourcePainelDados dsPainelDados, String codCliente, String nomeCliente){
		DetailViewerRecord record = new DetailViewerRecord();

		record.setAttribute(dsPainelDados.fieldCodCliente.getName(), 	codCliente);
		record.setAttribute(dsPainelDados.fieldNomeCliente.getName(),   nomeCliente);

		DetailViewerRecord[] records = new DetailViewerRecord[]{record};
		
		this.setDataSource(dsPainelDados);
		
		this.setData(records);
	}
}