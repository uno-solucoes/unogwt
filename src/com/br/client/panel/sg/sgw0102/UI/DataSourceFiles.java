package com.br.client.panel.sg.sgw0102.UI;

import com.br.client.model.sg.entity.eArquivoGED;
import com.br.client.model.sg.sgw0102.FormBean;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class DataSourceFiles {

	PainelResult painelResultGridList;
	PainelResultTileGrid painelResultTileGrid;
	WindowGED windowGED;
	
	private eArquivoGED[] listaArquivos ;
	
	public void onExecuteQuery(String text){

		
		if( HowMGWTUtilities.isEmpty( text )){
			SC.say("Informe no m&iacute;nimo um crit&eacute;rio para executar a consulta ...");
			return;
		}
		
		HowMGWTWindowWait.showWait("Aguarde, localizando arquivos...");
		if( painelResultGridList != null ){
			painelResultGridList.mapDiretorios.clear();
			painelResultGridList.setData(new RecordList());
		}
		else if( painelResultTileGrid != null ){
			painelResultTileGrid.mapDiretorios.clear();
			painelResultTileGrid.setData(new RecordList());			
		}
		// Cria um objeto struts para excluir os arquivos no servidor.
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {					
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				FormBean bean = (FormBean)formBean;
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean)){
					return;
				}
				// getPanelFileNavegator().showDirectory(bean);
				
				if( bean.getArquivoGEDs()!= null ){
					if( bean.getArquivoGEDs().length == 0 ){
						getWindowGED().getLabelArquivosEncontrados().setContents("Nenhum arquivo encontrado...");
					}
					if( bean.getArquivoGEDs().length == 1 ){
						getWindowGED().getLabelArquivosEncontrados().setContents(""+bean.getArquivoGEDs().length+" arquivo encontrado...");
					}
					else{
						getWindowGED().getLabelArquivosEncontrados().setContents(""+bean.getArquivoGEDs().length+" arquivos encontrados...");
					}				
				}
				else{
					getWindowGED().getLabelArquivosEncontrados().setContents("Nenhum arquivo encontrado...");
				}
				showRecords(bean.getArquivoGEDs());				
				
			}
		};						
		FormBean formBean = new FormBean();
		formBean.setFindFilter(text);
 		struts.request("sgw0102.do?method=buscaAvancada",  "SGW0102Form", formBean.toSendBody(""));		
	}

	
	public void showRecordsTransicao(eArquivoGED[] arquivos){
		if( listaArquivos == null ){
			RecordList records = new RecordList();
			if( painelResultGridList != null ){
				painelResultGridList.setData(records);
			}
			else if( painelResultTileGrid != null ){
				painelResultTileGrid.setData(records);			
			}				
			return;
		}
		showRecords(arquivos);
	}
	
	
	public void showRecords(eArquivoGED[] arquivos){

		this.listaArquivos = arquivos;
		
		RecordList records = new RecordList();
		if ( arquivos != null ){
			for ( eArquivoGED arquivo : arquivos){
				ListGridRecord record = new ListGridRecord();
	
				record.setAttribute("DIRETORIO", arquivo.getEntityDiretorioGED());
				
				record.setAttribute("ARQUIVO", arquivo);
				record.setAttribute("absolutePath", arquivo.getAbsolutePath());

				if( painelResultGridList != null ){
					record.setAttribute(painelResultGridList.fieldArquivo.getName(), arquivo.getNomeArquivo());
				}
				else if( painelResultTileGrid != null ){
					record.setAttribute("fieldArquivo", arquivo.getNomeArquivo());
				}				

				
				record.setAttribute("fieldPubs",configureFileName(arquivo.getArquivo()));
				records.add(record);
			}
		}		
		if( painelResultGridList != null ){
			painelResultGridList.setData(records);
		}
		else if( painelResultTileGrid != null ){			
			painelResultTileGrid.setData(records);			
		}				
	}
	

	/**
	 * Configura o nome do arquivo a partir da extensão.
	 * @param record
	 * @param fileName
	 */
	public static final String configureFileName(String fileName){
		String extensao = HowMGWTUtilities.getExtensaoArquivo(fileName);
		if( "PNG".equalsIgnoreCase(extensao)	// Imagem PNG ( Portable Network Graphics)
			 ||
			"JPG".equalsIgnoreCase(extensao)	// Imagem no formato JPEG
			||
			"JPEG".equalsIgnoreCase(extensao)	// Imagem no formato JPEG
			||
			"GIF".equalsIgnoreCase(extensao)	// Imagem no formato Graphic Interchange Formato							
			||
			"TIF".equalsIgnoreCase(extensao)	// Imagem							
			||
			"TIFF".equalsIgnoreCase(extensao)	// Imagem							
			||
			"BMP".equalsIgnoreCase(extensao)	// Imagem no formato Bitmap. Elas podem ser lidas por qualquer programa gráfico.	
			||
			"ICO".equalsIgnoreCase(extensao)	// ICONE
			||
			"PIC".equalsIgnoreCase(extensao)	// Imagem Macintosh PICT						
			||
			"DWG".equalsIgnoreCase(extensao)	// Arquivo Autodesk AutoCAD			
			||
			"DWR".equalsIgnoreCase(extensao)	// Dessin Micrografx Draw ou Designer							
			||
			"EPS".equalsIgnoreCase(extensao)	// Imagem PostScript (Encapsulated PostScript)						
			||
			"DXF".equalsIgnoreCase(extensao)	// Arquivo Autodesk AutoCAD no formato "Autodesk Drawing Interchange"
			||
			"ILBM".equalsIgnoreCase(extensao)	// Imagem							
			||
			"LBM".equalsIgnoreCase(extensao)	// Imagem Deluxe Paint			
			||
			"PCX".equalsIgnoreCase(extensao)	// Imagem Bitmap							
			||
			"PCT".equalsIgnoreCase(extensao)	// Imagem Macintosh PICT		
			||
			"PSP".equalsIgnoreCase(extensao)	// Imagem Paint Shop Pro
			||
			"PCD".equalsIgnoreCase(extensao)	// Imagem Kodak PhotoCD	
			||
			"PSD".equalsIgnoreCase(extensao)	// Imagem Adobe Photoshop							
		){
			return fileName;
		}
		else if( "XLS".equalsIgnoreCase(extensao) ){
			return "ged/types/"+extensao.toLowerCase()+".png" ;
		}
		else if( "DOC".equalsIgnoreCase(extensao) ){
			return"ged/types/"+ extensao.toLowerCase()+".png" ;								
		}
		else if( "PPT".equalsIgnoreCase(extensao) ){
			return "ged/types/"+extensao.toLowerCase()+".png";								
		}
		else if( "PPS".equalsIgnoreCase(extensao) ){
			return "ged/types/"+extensao.toLowerCase()+".png" ;								
		}
		else if( "PDF".equalsIgnoreCase(extensao) ){
			return "ged/types/"+extensao.toLowerCase()+".png";								
		}
		else if( "XLSX".equalsIgnoreCase(extensao) ){
			return "ged/types/"+extensao.toLowerCase()+".png";								
		}
		else if( "DOCX".equalsIgnoreCase(extensao) ){
			return "ged/types/"+extensao.toLowerCase()+".png";								
		}
		else if( "RAR".equalsIgnoreCase(extensao) ){
			return "ged/types/"+extensao.toLowerCase()+".png";								
		}
		else if( "ZIP".equalsIgnoreCase(extensao) ){
			return "ged/types/"+extensao.toLowerCase()+".png";								
		}							
		else{
			return "ged/types/file.png";								
		}									
	}



	public PainelResult getPainelResultGridList() {
		return painelResultGridList;
	}



	public void setPainelResultGridList(PainelResult painelResultGridList) {
		this.painelResultGridList = painelResultGridList;
	}



	public PainelResultTileGrid getPainelResultTileGrid() {
		return painelResultTileGrid;
	}



	public void setPainelResultTileGrid(PainelResultTileGrid painelResultTileGrid) {
		this.painelResultTileGrid = painelResultTileGrid;
	}



	public eArquivoGED[] getListaArquivos() {
		return listaArquivos;
	}



	public void setListaArquivos(eArquivoGED[] listaArquivos) {
		this.listaArquivos = listaArquivos;
	}


	public WindowGED getWindowGED() {
		return windowGED;
	}


	public void setWindowGED(WindowGED windowGED) {
		this.windowGED = windowGED;
	}	


}
