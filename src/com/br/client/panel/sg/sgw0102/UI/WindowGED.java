package com.br.client.panel.sg.sgw0102.UI;

import com.br.client.model.sg.entity.eArquivoGED;
import com.br.client.model.sg.sgw0102.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.howmake.client.form.UI.HowMGWTWindowBase;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tile.TileGrid;

public class WindowGED  extends HowMGWTWindowBase{

	private VLayout mainResult = new VLayout();
	private PanelHelp panelHelp = new PanelHelp();
	
// 	private PanelFileNavegator panelFileNavegator = new PanelFileNavegator();
	
	private PainelFiltro painelFiltro = new PainelFiltro(){
		public void onShowHelp(boolean showHelp){
			if( showHelp ){
				panelHelp.animateShow(AnimationEffect.WIPE);
			}
			else{
				panelHelp.animateHide(AnimationEffect.WIPE);
			}
		}
		
		public void onShowList(){
			mainResult.removeMember(painelTile);
			this.redraw();
			Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {				
				@Override
				public void execute() {
					dataSourceFile.setPainelResultGridList(painelResult);
					dataSourceFile.setPainelResultTileGrid(null);
					mainResult.addMember(painelResult);
					dataSourceFile.showRecordsTransicao(dataSourceFile.getListaArquivos());					
				}
			});
		}
		public void onShowIconesGrandes(){			
			mainResult.removeMember(painelResult);
			this.redraw();
			Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {				
				@Override
				public void execute() {
					dataSourceFile.setPainelResultGridList(null);
					dataSourceFile.setPainelResultTileGrid(painelTile);
					mainResult.addMember(painelTile);
					dataSourceFile.showRecordsTransicao(dataSourceFile.getListaArquivos());
				}
			});					
		}
	};
	private PainelResult painelResult 		= new PainelResult();
	private PainelResultTileGrid painelTile = new PainelResultTileGrid();
	private PanelDetalhesArquivo painelDetalheArquivo = new PanelDetalhesArquivo();
	private VLayout editArea = new VLayout();

	private JavaScriptObject parentObject;
 
	private DataSourceFiles dataSourceFile = new DataSourceFiles();
	
	private Label labelArquivosEncontrados = new Label();
	

	public Label getLabelArquivosEncontrados() {
		return labelArquivosEncontrados;
	}

	
	/**
	 * Construtor padrão.
	 */
	public WindowGED(){

		this.setCanDragReposition(false);
		this.setShowFooter(true);		
		labelArquivosEncontrados.setWrap(false);
		labelArquivosEncontrados.setAlign(Alignment.RIGHT);
		this.setFooterControls(labelArquivosEncontrados);
		
		dataSourceFile.setWindowGED(this);
		
		mainResult.setWidth100();
		mainResult.setHeight100();		

//		painelResult.setPanelFileNavegator(this.panelFileNavegator);

		this.setTitle(Tradutor.i18n.formTituloGEDBuscaAvancada());

		this.setShowMinimizeButton(false);

		this.setWidth100();
		this.setHeight100();
		
		
		this.setCanDragResize(true);

		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		// Adiciona o painel do filtro no top.
		vLayout.addMember( painelFiltro );

		// Adiciona uma horizonal layout para os resultado da busca.
		HLayout hLayout = new HLayout();
		hLayout.setWidth100();
		hLayout.setHeight100();

//		hLayout.addMember(panelFileNavegator);

		// mainResult.addMember(painelResult);
		
		hLayout.addMember(mainResult);

		editArea.setWidth100();
		editArea.setHeight100();
		hLayout.addMember(editArea);
		editArea.setVisible(false);
		
		this.painelFiltro.setDataSourceFile(dataSourceFile);
		this.painelResult.setEditArea(editArea);

		vLayout.addMember(hLayout);

//		panelFileNavegator.getHowMTreeGrid().addRecordClickHandler(new RecordClickHandler() {
//
//			@Override
//			public void onRecordClick(RecordClickEvent event) {
//				HowMGWTTreeNode node = (HowMGWTTreeNode)event.getRecord();
//				if( node.getAttributeAsObject("entityPasta") != null ){
//
//					mainResult.removeMember(painelDetalheArquivo);
//					mainResult.addMember(painelResult);
//
//					eDiretorioGED diretorio = (eDiretorioGED)node.getAttributeAsObject("entityPasta");
//					FormBean bean = new FormBean();
//					bean.setArquivoGEDs(diretorio.getEntityArquivos());					
//					painelResult.showRecords(bean,diretorio);
//				}
//				else if( node.getAttributeAsObject("entityArquivo") != null ){
//					eArquivoGED arquivoGED = (eArquivoGED)node.getAttributeAsObject("entityArquivo");
//					
//					showRecords(arquivoGED);					
//				}
//				System.out.println("Nó : "+node.getAttribute("descricao"));
//			}
//		});		

		panelHelp.setVisible(false);
		
		vLayout.addMember(panelHelp);
		
		this.addItem(vLayout);
		
		this.setShowResizeBar(true);
		this.setShowResizer(true);
		
		this.setIsModal(true);
		this.centerInPage();
		
		this.loadConfiguracoes();
	}
	
	
	public void loadConfiguracoes(){
		HowMGWTWindowWait.showWait("Aguarde, configurando GED...");

		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {					
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				FormBean bean = (FormBean)formBean;
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean)){
					return;
				}				
				if( "2".equals(bean.getFindFilter())){
					dataSourceFile.setPainelResultTileGrid(painelTile);
					mainResult.addMember(painelTile);
					painelFiltro.getActionShowIconesGrandes().setSelected(true);
					painelFiltro.getActionShowLista().setSelected(false);
				}
				else{
					mainResult.addMember(painelResult);
					dataSourceFile.setPainelResultGridList(painelResult);
					painelFiltro.getActionShowIconesGrandes().setSelected(false);
					painelFiltro.getActionShowLista().setSelected(true);
				}				
			}
		};						
		FormBean formBean = new FormBean();		
 		struts.request("sgw0102.do?method=loadConfigureGED",  "SGW0102Form", formBean.toSendBody(""));		
	}

	public void showRecords(eArquivoGED arquivoGED){
		mainResult.removeMember(this.painelResult);
		mainResult.addMember(this.painelDetalheArquivo);		
		this.painelDetalheArquivo.showDetalhe(arquivoGED);
	}
}