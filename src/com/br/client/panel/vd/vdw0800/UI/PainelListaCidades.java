package com.br.client.panel.vd.vdw0800.UI;

import com.br.client.model.vd.entity.eNFSECidade;
import com.br.client.model.vd.vdw0800.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;

public class PainelListaCidades extends HowMGWTListGrid{
	
	private ListGridField fieldCodEstado	= new ListGridField("fieldCodEstado", 	"UF.", 	                40);	// 0
	private ListGridField fieldSiglaEstado	= new ListGridField("fieldSiglaEstado", "Sigla UF", 	        60);	// 0
	private ListGridField fieldCodigoIBGE 	= new ListGridField("fieldCodigoIBGE", 	"IBGE", 	            70);	// 1
	private ListGridField fieldNomeCidade	= new ListGridField("fieldNomeCidade", 	"Municipio", 		    200);	// 2

	
	private ListGridField fieldCodPadrao	= new ListGridField("fieldCodPadrao", 	"Cd Padrao", 			90);  	// 3
	private ListGridField fieldSchemaXSD	= new ListGridField("fieldSchemaXSD", 	"Schema XSD", 			90);	// 4
	private ListGridField fieldNomePadrao	= new ListGridField("fieldNomePadrao",	"Nome Padrao"			,90);	// 5
	private ListGridField fieldVariacao		= new ListGridField("fieldVariacao", 	"Variacao", 			90); 	// 6
	private ListGridField fieldDescricao	= new ListGridField("fieldDescricao", 	Tradutor.i18n.formDescricao(), 	140);	// 7

	
	public PainelListaCidades(){
	 
		this.setFields(
				fieldCodEstado,
				fieldSiglaEstado,
				fieldCodigoIBGE,
				fieldNomeCidade,
				fieldCodPadrao,
				fieldSchemaXSD,
				fieldNomePadrao,
				fieldVariacao,
				fieldDescricao
		);		
	}
	
	public void load(FormBean bean){
		this.clearAllRecords();
		
		if ( bean.getCidades() == null )
			return;
		
		RecordList records = new RecordList();
		ListGridRecord record;
		for ( eNFSECidade cidade : bean.getCidades() ){
			record = new ListGridRecord();
			record.setAttribute(fieldCodEstado.getName(),   cidade.getUf());
			record.setAttribute(fieldSiglaEstado.getName(), cidade.getSiglaUF());
			record.setAttribute(fieldCodigoIBGE.getName(),  cidade.getCodMunicipio());
			record.setAttribute(fieldNomeCidade.getName(),  cidade.getNome());

			record.setAttribute(fieldCodPadrao.getName(),   cidade.getEntityPadrao().getCdPadrao());
			record.setAttribute(fieldSchemaXSD.getName(),   cidade.getEntityPadrao().getSchemaXSD());
			record.setAttribute(fieldNomePadrao.getName(),  cidade.getEntityPadrao().getNomePadrao());
			record.setAttribute(fieldDescricao.getName(),   cidade.getEntityPadrao().getDescricao());
			
			record.setAttribute("LINKS", cidade.getUrls());

			records.add(record);
			
			
		}
		this.setData(records);
		onHowMFinishLoadDatabaseRecord();
	}
 
}
