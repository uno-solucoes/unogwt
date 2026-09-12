package com.br.client.panel.sg.sgw0102.UI;

import java.util.TreeMap;

import com.br.client.model.sg.entity.eArquivoGED;
import com.br.client.model.sg.entity.eDiretorioGED;
import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.Record;
 
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.tile.events.RecordClickEvent;
import com.smartgwt.client.widgets.tile.events.RecordClickHandler;
import com.smartgwt.client.widgets.viewer.DetailFormatter;
import com.smartgwt.client.widgets.viewer.DetailViewerField;


public class PainelResultTileGrid extends VLayout{

	
	TreeMap<String, eDiretorioGED> mapDiretorios = new TreeMap<String, eDiretorioGED>();

    DetailViewerField image = new DetailViewerField("fieldPubs");  
	DetailViewerField fieldData = new DetailViewerField("fieldData");    
    DetailViewerField fieldArquivo = new DetailViewerField("fieldArquivo");  

    private Label labelDetalhes = new Label();
    
    private TileGrid tileGrid = new TileGrid(); 
    
	public PainelResultTileGrid(){
		
		this.setWidth100();
		this.setHeight100();
		
		tileGrid.setTileWidth(220);  
		tileGrid.setTileHeight(170);  
		tileGrid.setHeight100();  
		tileGrid.setWidth100();  
		tileGrid.setCanReorderTiles(true);  
		tileGrid.setShowAllRecords(false);  
  
        image.setType("image");  
        image.setImageWidth(186);  
        image.setImageHeight(140);  
  
        fieldArquivo.setDetailFormatter(new DetailFormatter() {
			
			@Override
			public String format(Object value, Record record, DetailViewerField field) {
				eArquivoGED   arquivo   = (eArquivoGED)record.getAttributeAsObject("ARQUIVO");
				String text = "";
 
				text += "<font size=><a href=\""+arquivo.getArquivo()+"\" target=\"_blank\">"+arquivo.getNomeArquivo()+"</a></font>";				
				record.setAttribute(fieldArquivo.getName(), text);
				return text;
			}
		});
        
        tileGrid.addRecordClickHandler(new RecordClickHandler() {			
			@Override
			public void onRecordClick(RecordClickEvent event) {
				showDetalhes(event.getRecord());
			}
		});
        
        tileGrid.setFields(image, fieldArquivo, fieldData);
        this.addMember(tileGrid);
        
        this.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(1, HowMGWTUtilities.backgroundSeparadora));
        VLayout detalhes = new VLayout();
        detalhes.setWidth100();
        detalhes.setHeight(30);
        
        labelDetalhes.setWrap(false);
        labelDetalhes.setWidth100();
        labelDetalhes.setHeight100();
        detalhes.addMember(labelDetalhes);
        
        this.addMember(detalhes);
	}
	

    public void setData(Record[] data) {
    	this.tileGrid.setData(data);
    	this.labelDetalhes.setContents("");
    }


    public void setData(RecordList data) {
        this.tileGrid.setData(data);
        this.labelDetalhes.setContents("");
    }
    
    
    public void showDetalhes(Record record){
    
		eDiretorioGED diretorio = (eDiretorioGED)record.getAttributeAsObject("DIRETORIO");
		eArquivoGED   arquivo   = (eArquivoGED)record.getAttributeAsObject("ARQUIVO");

	    String html = "";
		html += "<html>\n";
		html += "<body>\n";
		html += "<table style=\"width:100%; font-family: Arial, Verdana, sans-serif; font-size: 11px; \"><tr>";
		  
		html += "<td><b>DETALHES:</b></td>";
		html += "<td>"+Tradutor.i18n.formResponsavel()+" : <b>"+arquivo.getIdUsuario()+"</b></td>";
		html += "<td>"+Tradutor.i18n.formDataReferencia() + " : <b>"+arquivo.getData()+"</b></td>";
		html += "<td>"+Tradutor.i18n.formPasta()+" : <b>"+record.getAttribute("absolutePath")+"</b></td>";
		//	// diretorio.getNomeDiretorio()

		
    	if ( ! HowMGWTUtilities.isEmpty(arquivo.getDescricao()) ){
    		html += "<table border=0 style=\"width:100%; font-family: Arial, Verdana, sans-serif; font-size: 11px; \">";
    		html += "<tr><td width=\"20px\"></td><td style=\"background-color:rgb(255,250,205); border-top:1px solid #6495ED; border-left:1px solid #6495ED; border-right:1px solid #6495ED; border-bottom:1px solid #6495ED;\">";
    		html += "<font color=\"#1C86EE\"> <u><b>"+Tradutor.i18n.formResumo()+"</b></u><br>"+HowMGWTUtilities.replace(arquivo.getDescricao(),"\n","<br>")+"</font>";
    		html += "</td><td width=\"60px\"></td></tr>";
    		html += "</table>";
	}
		html += "</tr></table>";

		html += "</body>\n";
		html += "</html>\n";

		this.labelDetalhes.setContents(html);
    }


}
