package com.br.client.panel.ex.exw0031.UI;

import com.br.client.model.sg.entity.eArquivoGED;
import com.br.client.model.ex.exw0031.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.ex.exw0031.UI.DataSourceFiles;
import com.br.client.panel.ex.exw0031.UI.PainelFiltro;
import com.br.client.panel.ex.exw0031.UI.PainelResult;
import com.br.client.panel.ex.exw0031.UI.PainelResultTileGrid;
import com.br.client.panel.ex.exw0031.UI.PanelDetalhesArquivo;
import com.br.client.panel.ex.exw0031.UI.PanelHelp;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.howmake.client.form.UI.HowMGWTWindowBase;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class WindowExtranetGED extends HowMGWTWindowBase {

	private VLayout mainResult = new VLayout();
	private PanelHelp panelHelp = new PanelHelp();
	
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
	
	private DataSourceFiles dataSourceFile 		      = new DataSourceFiles();
	private Label labelArquivosEncontrados 			  = new Label();
	private PainelResult painelResult 				  = new PainelResult();
	private PainelResultTileGrid painelTile 		  = new PainelResultTileGrid();
	private PanelDetalhesArquivo painelDetalheArquivo = new PanelDetalhesArquivo();
	private VLayout editArea 						  = new VLayout();
	
	private JavaScriptObject parentObject;
	
	public Label getLabelArquivosEncontrados() {
		return labelArquivosEncontrados;
	}
	
	/**
	 * Construtor padrão.
	 */
	public WindowExtranetGED(){
		
		editArea.setWidth100();
		editArea.setHeight100();
		
		dataSourceFile.setWindowExtranetGED(this);
		
		mainResult.setWidth100();
		mainResult.setHeight100();
		
		labelArquivosEncontrados.setWrap(false);
		labelArquivosEncontrados.setAlign(Alignment.RIGHT);
		
		this.setFooterControls(labelArquivosEncontrados);
		this.setCanDragReposition(false);
		this.setShowFooter(true);
		this.setTitle(Tradutor.i18n.formTituloGEDBuscaAvancada());
		this.setShowMinimizeButton(false);
		this.setWidth100();
		this.setHeight100();
		this.setCanDragResize(true);

		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.addMember( painelFiltro );

		// Adiciona uma horizonal layout para os resultado da busca.
		HLayout hLayout = new HLayout();
		hLayout.setWidth100();
		hLayout.setHeight100();
		hLayout.addMember(mainResult);
		hLayout.addMember(editArea);
		
		editArea.setVisible(false);
		
		this.painelFiltro.setDataSourceFile(dataSourceFile);
		this.painelResult.setEditArea(editArea);

		vLayout.addMember(hLayout);

		panelHelp.setVisible(false);
		vLayout.addMember(panelHelp);
		
		this.addItem(vLayout);
		this.setShowResizeBar(true);
		this.setShowResizer(true);
		this.setIsModal(true);
		this.centerInPage();
		this.loadConfiguracoes();
		
		this.painelFiltro.getDataSourceFile().onExecuteQuery( "." );
		
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
 		struts.request("exw0031.do?method=loadConfigureGED",  "EXW0031Form", formBean.toSendBody(""));		
	}

	public void showRecords(eArquivoGED arquivoGED){
		mainResult.removeMember(this.painelResult);
		mainResult.addMember(this.painelDetalheArquivo);		
		this.painelDetalheArquivo.showDetalhe(arquivoGED);
	}
	
}
