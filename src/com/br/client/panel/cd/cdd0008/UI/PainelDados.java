package com.br.client.panel.cd.cdd0008.UI;

import com.br.client.panel.cd.cdd0008.model.DataSourcePainelDados;
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
	public void setDados(DataSourcePainelDados dsPainelDados, String codTabelaPreco ){
		DetailViewerRecord record = new DetailViewerRecord();

		record.setAttribute(dsPainelDados.fieldCodTabelaPreco.getName(), 	codTabelaPreco);

		DetailViewerRecord[] records = new DetailViewerRecord[]{record};
		
		this.setDataSource(dsPainelDados);
		
		this.setData(records);
	}
}