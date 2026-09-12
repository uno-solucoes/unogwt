package com.br.client.panel.sg.sgw0102.UI;

import com.br.client.model.sg.entity.eArquivoGED;
import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTLabel;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ImageStyle;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

public class PanelDetalhesArquivo extends VLayout{

	VLayout mainImage = new VLayout();
	
	Img image = new Img();
	
	DetailViewer detailViewer = new DetailViewer();
	
	DetailViewerField nomeArquivo 	= new DetailViewerField("fileName", "Nome do Arquivo");
	DetailViewerField resumoArquivo = new DetailViewerField("resumoArquivo", "Resumo");
	DetailViewerField responsavel 	= new DetailViewerField("responsavel", Tradutor.i18n.formResponsavel());
	DetailViewerField dataRef	 	= new DetailViewerField("dataRef", Tradutor.i18n.formDataReferencia());
	DetailViewerField tipoArquivo 	= new DetailViewerField("tipoArquivo", "Tipo Arquivo");
	DetailViewerField downLoadFile 	= new DetailViewerField("downLoadFile", "Abrir Arquivo");
	

	public PanelDetalhesArquivo(){
		detailViewer.setEmptyMessage("não existe arquivo selecionado para mostrar...");
		
		detailViewer.setCanSelectText(true);
		
		downLoadFile.setType("link");		
		
		detailViewer.setFields(nomeArquivo, resumoArquivo, responsavel, dataRef, tipoArquivo, downLoadFile);
		
		this.addMember(detailViewer);

		
		ToolStrip bar = new ToolStrip();
		bar.setAlign(Alignment.CENTER);
		bar.setWidth100();

		HowMGWTLabel label = new HowMGWTLabel("<Strong>Representação Gráfica do Arquivo</Strong>");
		label.setHeight100();
		label.setMargin(7);
		label.setAlign(Alignment.CENTER);
		bar.addMember(label);

				
		
		this.addMember(bar);
		
		
		this.mainImage.addMember(image);
		this.image.setWidth100();
		this.image.setImageType(ImageStyle.NORMAL);
		
		this.mainImage.setWidth100();
		this.mainImage.setHeight100();		
		this.mainImage.setOverflow(Overflow.AUTO);
		this.addMember(this.mainImage);
		
		
		
	}
	
	public void showDetalhe(eArquivoGED arquivo){

		ListGridRecord record = new ListGridRecord();

		record.setAttribute(nomeArquivo.getName(), arquivo.getNomeArquivo());

		if ( ! HowMGWTUtilities.isEmpty(arquivo.getDescricao()) ){
			String text = "";
			text += "<table border=0 style=\"width:100%; \">";
			text += "<tr><td width=\"20px\"></td><td style=\"background-color:rgb(255,250,205); border-top:1px solid #6495ED; border-left:1px solid #6495ED; border-right:1px solid #6495ED; border-bottom:1px solid #6495ED;\">";
			text += "<font color=\"#1C86EE\"> <u><b>"+Tradutor.i18n.formResumo()+"</b></u><br>"+HowMGWTUtilities.replace(arquivo.getDescricao(),"\n","<br>")+"</font>";
			text += "</td><td width=\"60px\"></td></tr>";
			text += "</table>";
			record.setAttribute(resumoArquivo.getName(), text);
		}

		record.setAttribute(responsavel.getName(), arquivo.getIdUsuario());
		record.setAttribute(dataRef.getName(), arquivo.getData());
		record.setAttribute(downLoadFile.getName(), arquivo.getArquivo());				

		ListGridRecord[] records = new ListGridRecord[1];
		records[0] = record;

		record.setAttribute(tipoArquivo.getName(),HowMGWTUtilities.getExtensaoArquivo(arquivo.getNomeArquivo()));
		
		detailViewer.setData(records);
	
		image.setSrc(DataSourceFiles.configureFileName(arquivo.getArquivo()));
		mainImage.redraw();
		
	}
	
}
