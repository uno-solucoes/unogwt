package com.br.client.panel.ex.exw0031.UI;

import java.util.TreeMap;

import com.br.client.model.sg.entity.eArquivoGED;
import com.br.client.model.sg.entity.eDiretorioGED;
import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelResult extends HowMGWTListGrid {

PanelFileNavegator panelFileNavegator;
	
	TreeMap<String, eDiretorioGED> mapDiretorios = new TreeMap<String, eDiretorioGED>();
	
	VLayout editArea;

	ListGridField fieldPasta    = new ListGridField("fieldPasta","Pasta",200);	
	ListGridField fieldArquivo  = new ListGridField("fieldArquivo","Arquivo");
	ListGridField fieldData     = new ListGridField("fieldData", "Data Ref.",100);
	ListGridField fieldPubs		= new ListGridField("fieldPubs"," ",110);
	
	
	public PainelResult(){
		this.setWidth100();
		this.setHeight100();		        
		
		
		this.setWrapCells(true);
		this.setFixedRecordHeights(false);
		
		this.setShowHeader(false);
		this.setBorder("0px none #ffffff");
		
		
		
		
		
		fieldArquivo.setCellFormatter(new CellFormatter() {
			
			@Override
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
				
				eDiretorioGED diretorio = (eDiretorioGED)record.getAttributeAsObject("DIRETORIO");
				eArquivoGED   arquivo   = (eArquivoGED)record.getAttributeAsObject("ARQUIVO");
				String text = "";
 
				text += "<font size=+1><a href=\""+arquivo.getArquivo()+"\" target=\"_blank\">"+arquivo.getNomeArquivo()+"</a></font>";
				
				if ( ! HowMGWTUtilities.isEmpty(arquivo.getDescricao()) ){
					text += "<table border=0 style=\"width:100%; \">";
					text += "<tr><td width=\"20px\"></td><td style=\"background-color:rgb(255,250,205); border-top:1px solid #6495ED; border-left:1px solid #6495ED; border-right:1px solid #6495ED; border-bottom:1px solid #6495ED;\">";
					text += "<font color=\"#1C86EE\"> <u><b>"+Tradutor.i18n.formResumo()+"</b></u><br>"+HowMGWTUtilities.replace(arquivo.getDescricao(),"\n","<br>")+"</font>";
					text += "</td><td width=\"60px\"></td></tr>";
					text += "</table>";
				}

				text += "<table border=0>";
				text += "<tr><td>";
				text += Tradutor.i18n.formResponsavel()+" : </td><td><b><font color=\"red\">"+arquivo.getIdUsuario()+"</font></b>";
				text += "</td></tr>";
				text += "<tr><td>";
				text += Tradutor.i18n.formDataReferencia() + " : </td><td><b><font color=\"red\">"+arquivo.getData()+"</font></b>";
				text += "</td></tr>";
				text += "<tr><td>";
				text += Tradutor.i18n.formPasta()+" : </td><td><b><font color=\"red\">"+record.getAttribute("absolutePath")+"</font></b>";
				// diretorio.getNomeDiretorio()
				text += "</td></td>";
				text += "</table>";
				record.setAttribute(fieldArquivo.getName(), text);
				
				record.setAttribute(fieldData.getName(), arquivo.getData());

				return text;
			}
		});
	
		this.setDataPageSize(1000);
		this.setShowAllRecords(true);
	
		fieldPubs.setType(ListGridFieldType.IMAGE);
		fieldPubs.setImageHeight(100);
		fieldPubs.setImageWidth(100);
		
		this.setFields(
				// fieldPasta,
				fieldArquivo,
				fieldPubs
				// fieldData
		);

		this.setCanResizeFields(true);   
		this.setHeaderHeight(25);		

		
		this.setEmptyMessage("Não existem arquivos para mostrar...");
		
		onHowMInitEntityControl(); 
		
		
	}

	/**
	 * @param editArea the editArea to set
	 */
	public void setEditArea(VLayout editArea) {
		this.editArea = editArea;
	}
	

	public PanelFileNavegator getPanelFileNavegator() {
		return panelFileNavegator;
	}

	public void setPanelFileNavegator(PanelFileNavegator panelFileNavegator) {
		this.panelFileNavegator = panelFileNavegator;
	}
	
}
