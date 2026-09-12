package com.br.client.panel.vd.vdd0026.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.vd.vdd0026.model.DataSourcePainelDados;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerRecord;
 
public class PainelDados extends DetailViewer{
	 
	
	public PainelDados(){
		
        this.setWidth100();
        this.setHeight("100px");
        this.setMargin(2); 
        this.setAutoHeight();            
        this.setEmptyMessage(Tradutor.i18n.formNehumItemEncontrado());  		
	}
	
	
	/**
	 * Seta os dados do participante 
	 * @param participante
	 * @param vendedor
	 * @param percComissao
	 */
	public void setDados(DataSourcePainelDados dsPainelDados, String pedido ){
		DetailViewerRecord record = new DetailViewerRecord();

		record.setAttribute(dsPainelDados.fieldPedido.getName(), pedido);

		DetailViewerRecord[] records = new DetailViewerRecord[]{record};
		
		this.setDataSource(dsPainelDados);
		
		this.setData(records);
	}
}