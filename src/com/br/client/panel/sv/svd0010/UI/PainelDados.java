package com.br.client.panel.sv.svd0010.UI;


import com.br.client.panel.sv.svd0010.model.DataSourcePainelDados;
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
	public void setDados(DataSourcePainelDados dsPainelDados, String participante, String vendedor, String percComissao){
		DetailViewerRecord record = new DetailViewerRecord();

		record.setAttribute(dsPainelDados.fieldParticipante.getName(), 	participante);
		record.setAttribute(dsPainelDados.fieldVendedor.getName(), 		vendedor);
		record.setAttribute(dsPainelDados.fieldPercComissao.getName(), 	percComissao);	

		DetailViewerRecord[] records = new DetailViewerRecord[]{record};
		
		this.setDataSource(dsPainelDados);
		
		this.setData(records);
	}
}