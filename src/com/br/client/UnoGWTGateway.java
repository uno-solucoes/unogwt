package com.br.client;

import java.util.ArrayList;
import java.util.TreeMap;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.business.UI.DialogEditorTextArea;
import com.br.client.panel.business.UI.UCFieldListaUF;
import com.br.client.panel.cd.cdd0007.UI.WindowCondicoesPagamentoCliente;
import com.br.client.panel.cd.cdd0008.UI.WindowCondicoesPagamentoTabelaPreco;
import com.br.client.panel.ed.edw0002.UI.WindowMonitorEDIControle;
import com.br.client.panel.ex.exw0031.UI.WindowExtranetGED;
import com.br.client.panel.oc.ocw0001.PainelAddGoogleAgenda;
import com.br.client.panel.oc.ocw0001.UI.GoogleAgendaTaskList;
import com.br.client.panel.registro.UIPartner;
import com.br.client.panel.sg.sgw0102.UI.WindowGED;
import com.br.client.panel.sv.svd0010.UI.WindowVendedorExcecao;
import com.br.client.panel.vd.vdd0026.UI.WindowImprimirEtiquetasPedido;
import com.br.client.panel.vd.vdd0030.UI.WindowPerformanceVenda;
import com.br.client.panel.vd.vdd0031.UI.WindowTransfereVendedor;
import com.br.client.panel.vd.vdd0032.UI.WindowPainelComissaoMargem;
import com.br.client.panel.vd.vdd0033.UI.WindowPainelReimpressaoCertificado;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.UI.HowMGWTFormRichTextEditor;
import com.howmake.client.form.UI.HowMGWTTextItem;
import com.howmake.client.form.UI.HowMGWTUploadDialog;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.client.form.service.HowMGWTExecuteReportExternalWindow;
import com.howmake.shared.HowMGWTEntity;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;

 

@Export
@ExportPackage("uno")
public class UnoGWTGateway implements Exportable{
	public UIPartner workPartner 	= null;
	public UIPartner partner 		= null;
	public UIPartner partnerLookup 	= null;
	 
	private String unoGWTCodEmpresa;
	private String unoGWTCodColaborador;
	private JavaScriptObject unoGWTParentElement;
	private String[][] unoGWTParameters;
	/**
	 * @return the unoGWTCodEmpresa
	 */
	public String getUnoGWTCodEmpresa() {
		return unoGWTCodEmpresa;
	}
	/**
	 * @param unoGWTCodEmpresa the unoGWTCodEmpresa to set
	 */
	public void setUnoGWTCodEmpresa(String unoGWTCodEmpresa) {
		this.unoGWTCodEmpresa = unoGWTCodEmpresa;
	}
	/**
	 * @return the unoGWTCodColaborador
	 */
	public String getUnoGWTCodColaborador() {
		return unoGWTCodColaborador;
	}
	/**
	 * @param unoGWTCodColaborador the unoGWTCodColaborador to set
	 */
	public void setUnoGWTCodColaborador(String unoGWTCodColaborador) {
		this.unoGWTCodColaborador = unoGWTCodColaborador;
	}
	/**
	 * @return the unoGWTParentElement
	 */
	public JavaScriptObject getUnoGWTParentElement() {
		return unoGWTParentElement;
	}
	/**
	 * @param unoGWTParentElement the unoGWTParentElement to set
	 */
	public void setUnoGWTParentElement(JavaScriptObject unoGWTParentElement) {
		this.unoGWTParentElement = unoGWTParentElement;
	}
	/**
	 * @return the unoGWTParameters
	 */
	public String[][] getUnoGWTParameters() {
		return unoGWTParameters;
	}
	/**
	 * @param unoGWTParameters the unoGWTParameters to set
	 */
	public void setUnoGWTParameters(String[][] unoGWTParameters) {
		this.unoGWTParameters = unoGWTParameters;
	}
	

	private JavaScriptObject cParent;
	private String cCodCliente;
	private String cTabPreco;
	private String cIndxItem;
	private String cCampoCodProduto;
	private String cCampoDescricao;
	private String cCampoQtde;
	private String cCampoPrecoVenda;
	private String cTipo;
	private String cMoeda;
	private String cCampoPrecoTotal;
	private com.br.client.panel.vd.vdq0002.UI.PainelGerenciador painel;
	private HowMGWTTextItem fieldCodigoProduto;
	/**
	 * Cria o diálogo para busca de produtos.
	 * @param codPedido
	 * @param codCliente
	 * @param tabelaPreco
	 * @param codProduto
	 */
	public void showUnoGWTVDQ0002(JavaScriptObject parent, String codCliente, String tabPreco, String indxItem, String campoCodProduto, String campoDescricao, String campoQtde, String campoPrecoVenda, String tipo, String moeda){
		this.partner = showUnoGWTVDQ0002Generic(parent, codCliente, tabPreco, indxItem, campoCodProduto, campoDescricao, campoQtde, campoPrecoVenda, null, tipo, moeda, false, partner);
	}
	public void showUnoGWTVDQ0002Lookup(JavaScriptObject parent, String codCliente, String tabPreco, String indxItem, String campoCodProduto, String campoDescricao, String campoQtde, String campoPrecoVenda, String campoPrecoTotal, String tipo, String moeda){
		this.partnerLookup = showUnoGWTVDQ0002Generic(parent, codCliente, tabPreco, indxItem, campoCodProduto, campoDescricao, campoQtde, campoPrecoVenda, campoPrecoTotal,  tipo, moeda, true, partnerLookup );	
	} 
	
	private UIPartner showUnoGWTVDQ0002Generic(JavaScriptObject parent, String codCliente, String tabPreco, String indxItem, String campoCodProduto, String campoDescricao, String campoQtde, String campoPrecoVenda, String campoPrecoTotal ,  String tipo, String moeda, boolean lookup, UIPartner defaultPartner){
		this.cParent = parent;
		this.cCodCliente = codCliente;
		this.cTabPreco = tabPreco;
		this.cIndxItem = indxItem;
		this.cCampoCodProduto = campoCodProduto;
		this.cCampoDescricao  = campoDescricao;
		this.cCampoQtde = campoQtde;
		this.cCampoPrecoVenda = campoPrecoVenda;
		this.cCampoPrecoTotal = campoPrecoTotal;
		this.cMoeda 	= moeda;
		this.cTipo = tipo;
		
		
		this.workPartner = defaultPartner;
		
		if ( workPartner == null || ! (workPartner instanceof com.br.client.panel.vd.vdq0002.UI.PainelGerenciador) ){
			workPartner = new com.br.client.panel.vd.vdq0002.UI.PainelGerenciador(false,true,lookup){				
				@Override
				public void onInitialized() {
					 
					painel = (com.br.client.panel.vd.vdq0002.UI.PainelGerenciador)workPartner;
					painel.setIsModal(true);
					painel.getPainelShoppingProduto().getPainelListaProduto().clearAllRecords();
					painel.configure(cParent , cCodCliente, cTabPreco, cIndxItem ,  cCampoCodProduto,  cCampoDescricao,  cCampoQtde , cCampoPrecoVenda , cCampoPrecoTotal, cTipo, cMoeda);
					painel.show();

					fieldCodigoProduto = painel.getFiltroConsulta().getFieldCodigoProduto();

					String codProduto = Configuracao.getNativeUnoGWTSetValue(cParent, cCampoCodProduto);
					// executa a consulta automaticamente ao abrir se o produto estiver informado.
					if ( ! HowMGWTUtilities.isEmpty( codProduto ) ){
						String filterCodProduto = painel.getFiltroConsulta().getFieldCodigoProduto().getHowMValueAsString();
						if ( ! codProduto.trim().equalsIgnoreCase(filterCodProduto) ){
							painel.getFiltroConsulta().limparFiltros();
							painel.getFiltroConsulta().getFieldCodigoProduto().setHowMValue(codProduto);
							painel.getPainelGerenciadorProduto().setFirstLoad(true);
							painel.getPainelGerenciadorProduto().getToolbarNavegatorListaProdutos().startBuscar();
						}
					}
					else{
						painel.getFiltroConsulta().limparFiltros();
					}
					
					painel.loadSelectItens();

					if( "0002".equals(getCorpo()) ){
						if ( painel.getTabSet() != null ){
							painel.getTabSet().selectTab(0);
						}
						painel.getFiltroConsulta().getPropertyBusca().getHowMGWTEditorFieldText().getField().setShowFocused(true);
						Timer timer = new Timer() {					
							@Override
							public void run() {						 
								painel.focus();
								painel.getFiltroConsulta().getPropertyBusca().getHowMGWTEditorFieldText().getField().focusInItem(); 
								painel.getFiltroConsulta().getPropertyBusca().getHowMGWTEditorFieldText().getField().selectValue();
								painel.getFiltroConsulta().getPropertyBusca().getHowMGWTEditorFieldText().getField().setShowFocused(true);
							}
						};
						timer.schedule(250);						
					}
					else{
						fieldCodigoProduto.getField().setShowFocused(true);
						Timer timer = new Timer() {					
							@Override
							public void run() {						 
								painel.focus();
								fieldCodigoProduto.getField().focusInItem(); 
								fieldCodigoProduto.getField().selectValue();
								fieldCodigoProduto.getField().setShowFocused(true);
							}
						};
						timer.schedule(250);
					}
				}
//				@Override
//				public void onSelectLookupRecord(Record record, String codProduto, String descricao) {
//					
//				}
			};
		}
		else{
			
			((com.br.client.panel.vd.vdq0002.UI.PainelGerenciador)workPartner).onInitialized();
		}
		return workPartner;
	}

	com.br.client.panel.vd.vdq0002.UI.PainelGerenciador painelBuscaProduto = null;
	public void showUnoGWTVDQ0002Busca(){
		if ( painelBuscaProduto == null )
			painelBuscaProduto = new com.br.client.panel.vd.vdq0002.UI.PainelGerenciador(true,true,false,true);
    	((com.smartgwt.client.widgets.Window)painelBuscaProduto).show();
	}
  

	
	
	// ------------------------------------------------------------------------------------
	// 	Implementação interface com Report Server - JasperReport
	// ------------------------------------------------------------------------------------
	private ArrayList<String[]> reportParameters = new ArrayList<String[]>();
	private ArrayList<String[]> parameters = new ArrayList<String[]>();
	private String reportName;
	private String reportModule;
	private String windowWidth;
	private String windowHeight;
	private String strutsAction;
	
	/**
	 * Limpa os parametros do relatório
	 */
	public void createReport(String reportName, String reportModule){
		reportParameters.clear();
		parameters.clear();
		this.reportName 	= reportName;
		this.reportModule 	= reportModule;
		windowWidth			= null;
		windowHeight		= null;
		strutsAction		= null;		
	}
	
	/**
	 * Seta a altura e a largura da janela para apresentação dos dados para o usuório.
	 * @param width Largura da janela.
	 * @param height Altura da janela.
	 */
	public void setSize(String width, String height){
		this.windowWidth 	= width;
		this.windowHeight 	= height;
	}
	
	/**
	 * Adiciona parametros para execução do relatório
	 * @param paramName
	 * @param value
	 * @param type
	 */
	public void addReportParameter(String paramName, String value, String type){
		reportParameters.add(new String[]{paramName, value, type});
	}
	
	
	public void addParameter(String paramName, String value, String type){
		parameters.add(new String[]{paramName, value, type});
	}
	
	/**
	 * @return the strutsAction
	 */
	public String getStrutsAction() {
		return strutsAction;
	}
	/**
	 * @param strutsAction the strutsAction to set
	 */
	public void setStrutsAction(String strutsAction) {
		this.strutsAction = strutsAction;
	}	
 
	/**
	 * Apresenta a OS para impressão
	 * @param codOS
	 * @param codAtendimento
	 */
	public void showReport(){

		HowMGWTExecuteReportExternalWindow report = new HowMGWTExecuteReportExternalWindow() {

			@Override
			protected boolean onHowMExecuteReport(HowMGWTEntity entity) {

				for ( String[] param : reportParameters ){
					String paramName  = param[0];
					String paramValue = param[1];
					if ( "I".equals(param[2]))
						Fabrica.createReportParameter(entity, paramName          	,new Integer(paramValue.trim()));
					else if ( "F".equals(param[2]))
						Fabrica.createReportParameter(entity, paramName          	,new Double(paramValue.trim()));
					else if ( "B".equals(param[2]))
						Fabrica.createReportParameter(entity, paramName          	,new Boolean(paramValue.trim()));
					else if ( "D".equals(param[2]))
						Fabrica.createReportParameter(entity, paramName          	,HowMGWTUtilities.getDate(paramValue.trim()));
					else
						Fabrica.createReportParameter(entity, paramName          	,paramValue.trim());
				}
				
				for ( String[] param : parameters ){
					String paramName  = param[0];
					String paramValue = param[1];
					if ( "I".equals(param[2]))
						Fabrica.createParameter(entity, paramName          	,new Integer(paramValue.trim()));
					else if ( "F".equals(param[2]))
						Fabrica.createParameter(entity, paramName          	,new Double(paramValue.trim()));
					else if ( "B".equals(param[2]))
						Fabrica.createParameter(entity, paramName          	,new Boolean(paramValue.trim()));
					else if ( "D".equals(param[2]))
						Fabrica.createParameter(entity, paramName          	,HowMGWTUtilities.getDate(paramValue.trim()));
					else
						Fabrica.createParameter(entity, paramName          	,paramValue.trim());
				}
				
				Fabrica.createReportParameter(entity, "pCOD_EMPRESA"        ,new Integer(Configuracao.getCodEmpresa()) );

				Fabrica.createParameter(entity, Fabrica.DEFAULT_REPORT_NAME , reportName );
				return true;			
			}
		};
		report.setHeight(windowHeight);
		report.setWidth(windowWidth);
		report.setProgramCode(reportModule);
		report.setStrutsAction(strutsAction);
		report.executeReport();
	}
	
	
	/**
	 * Abre o painel para adicionar tarefas no google agenda.
	 * @param oc
	 */
	public void showAddGoogleAgenda(String tipoAgenda, String labelAgenda, String oc, String descricao, String codResponsavel, String observacao, String onde){
		PainelAddGoogleAgenda painelAddGoogleAgenda = new PainelAddGoogleAgenda(tipoAgenda, labelAgenda, oc, descricao, codResponsavel, observacao,  onde);
		painelAddGoogleAgenda.showAddGoogleAgenda(oc);
	}
	
	
	private GoogleAgendaTaskList googleAgendaTaskList;
	/**
	 * Abre o painel para adicionar tarefas no google agenda.
	 * @param oc
	 */
	public void showGoogleAgendaTaskList(String tipoAgenda, String labelAgenda, String oc){
		if ( googleAgendaTaskList == null ) 
			googleAgendaTaskList = new GoogleAgendaTaskList();
		googleAgendaTaskList.showTaskList(tipoAgenda, labelAgenda, oc);
	}
	
	
	private DialogEditorTextArea editorTextArea;
	
	public void showEditorTextArea(JavaScriptObject object ,  String valor, boolean canEdit){
		if ( editorTextArea == null )
			editorTextArea = new DialogEditorTextArea();
		this.editorTextArea.showEditor(object, valor, canEdit);
	}
	
	WindowVendedorExcecao vendedorExcecao;
	public void showSVD0010(
							JavaScriptObject object,
							String codEmpresa , 
							String tpOwner, 
							String codPlano, 
							String participante, 
							String vendedor, 
							String percComissao,
							String parcelas){
		if ( vendedorExcecao == null ){
			vendedorExcecao = new WindowVendedorExcecao();	
		}
		vendedorExcecao.showEditor(object ,codEmpresa, tpOwner, codPlano, participante, vendedor, percComissao, parcelas);
	}
	
	WindowCondicoesPagamentoCliente condicoesPagamentoCliente;
	public void showCDD0007(
				JavaScriptObject object,
				String codCliente , 
				String nomeCliente ){
		if ( condicoesPagamentoCliente == null ){
			condicoesPagamentoCliente = new WindowCondicoesPagamentoCliente();	
		}
		condicoesPagamentoCliente.showEditor(object ,codCliente, nomeCliente);
	}

	WindowCondicoesPagamentoTabelaPreco condicoesPagamentoTabelaPreco;
	public void showCDD0008(
				JavaScriptObject object,
				String tabelaPreco){
		if ( condicoesPagamentoTabelaPreco == null ){
			condicoesPagamentoTabelaPreco = new WindowCondicoesPagamentoTabelaPreco();	
		}
		condicoesPagamentoTabelaPreco.showEditor(object ,tabelaPreco);
	}	
	
	
	TreeMap<String , UCFieldListaUF> mapUsedFieldListaUF = new TreeMap<String, UCFieldListaUF>();
	public void showUCFieldListaUF(JavaScriptObject hideField, String parentContainer){
		UCFieldListaUF listaUF = mapUsedFieldListaUF.get(parentContainer+"Lista");
		if ( listaUF == null ){			
			listaUF = new UCFieldListaUF();
			mapUsedFieldListaUF.put(parentContainer+"Lista", listaUF);
			listaUF.setParentObject(hideField);
		}		 
		if ( listaUF != null ){
			listaUF.showUFs();
		}
	}

	
	WindowImprimirEtiquetasPedido windowImprimirEtiqutasPedido;
	public void imprimirEtiquetasPedido(JavaScriptObject parent, String codPedido){
		if ( windowImprimirEtiqutasPedido == null){
			windowImprimirEtiqutasPedido = new WindowImprimirEtiquetasPedido();
		}
		windowImprimirEtiqutasPedido.showEditor(parent, codPedido);
	}
	
	HowMGWTUploadDialog uploadDialog;
	public void uploadFiles(JavaScriptObject parent, String subFolders, String labelPrefix, String rootPath, String action, String urlDownload){
		if ( uploadDialog == null ){
			uploadDialog = new HowMGWTUploadDialog();
			uploadDialog.configureUpload();
		}
		uploadDialog.configureUpload(parent, subFolders, labelPrefix, rootPath, action, urlDownload);
	}

	public void uploadFiles(JavaScriptObject parent, String subFolders, String labelPrefix, String rootPath, String action){
		this.uploadFiles(parent, subFolders, labelPrefix, rootPath, action, null);
	}
	
	
	
	WindowPerformanceVenda windowDetalhesPerformanceVendas;
	public void visualizarDetalhesPerformanceVenda(JavaScriptObject parent, String descColaborador, String descFamiliaComercial, String tipoAplicacao){
		if ( windowDetalhesPerformanceVendas == null )
			windowDetalhesPerformanceVendas = new WindowPerformanceVenda();
		
		windowDetalhesPerformanceVendas.show(descColaborador, descFamiliaComercial, tipoAplicacao);
	}

	public void GEDBuscar(){
		WindowGED ged = new WindowGED();
		ged.show();
	}
 
	public void GEDExtranetBuscar(){
		WindowExtranetGED ged = new WindowExtranetGED();
		ged.show();
	}

	WindowTransfereVendedor windowTransfereVendedor;
	public void showWindowTransfereVendedor(JavaScriptObject parentObject, String clientes){
		if ( windowTransfereVendedor == null )
			windowTransfereVendedor = new WindowTransfereVendedor();
		
		windowTransfereVendedor.show(parentObject, clientes);
		
	}
	
	WindowPainelComissaoMargem windowPainelComissaoMargem;
	public void showWindowPainelComissaoMargem(JavaScriptObject parent){
		if ( windowPainelComissaoMargem == null )
			windowPainelComissaoMargem = new WindowPainelComissaoMargem();
		windowPainelComissaoMargem.showPainelComissaoMargem(parent);
	}

	
	WindowMonitorEDIControle windowMonitorEDIControle;
	public void showWindowMonitorEDIControle(String codPedido, String codProduto){
		if ( windowMonitorEDIControle  == null )
			windowMonitorEDIControle = new WindowMonitorEDIControle();
		windowMonitorEDIControle.showMonitor(codPedido, codProduto);
	}
	
	/**
	 * Visualiza o painel para reimpressão dos certificados da nota. 
	 * @param codNotaFiscal
	 */
	WindowPainelReimpressaoCertificado windowPainelReimpressaoCertificado;
	public void showWindowReimprimirCertificado(String codNotaFiscal){
		if ( windowPainelReimpressaoCertificado == null ){
			windowPainelReimpressaoCertificado = new WindowPainelReimpressaoCertificado();
		}
		windowPainelReimpressaoCertificado.show(codNotaFiscal);
	}
	
	private JavaScriptObject parentObject;
	private DivElement divParent;
	private String label; 
	private String fieldName;
	private String width;
	private String height; 
	private HowMGWTFormRichTextEditor richTextEditor;
	
	public void createRichEditor(JavaScriptObject pParentObject, DivElement pDivParent, String pLabel, String pFieldName, String pWidth, String pHeight){

		this.parentObject 	= pParentObject;
		this.divParent		= pDivParent;
		this.label			= pLabel;
		this.fieldName		= pFieldName;
		this.width			= pWidth;
		this.height			= pHeight;

//		 RichTextArea area = new RichTextArea();
//		 area.ensureDebugId("cwRichText-area");
//		 area.setSize("100%", "100%");
//		 area.addStyleName("hasRichTextToolbar");
//		 ;
//		 RootPanel.get(pDivParent).add(area);		
//		 
////		 RichTextToolbar toolbar = new RichTextToolbar(area);
////		    toolbar.ensureDebugId("cwRichText-toolbar");
////		    toolbar.setWidth("100%");
		
		
		
		richTextEditor = new HowMGWTFormRichTextEditor("richEditor", label);
		richTextEditor.setWidth(HowMGWTUtilities.getInteger(width));
		richTextEditor.setHeight(HowMGWTUtilities.getInteger(height));
//		if ( RootPanel.get(pDivParent) != null ){
//			RootPanel.get(pDivParent).add(richTextEditor);
		
		pDivParent.appendChild(richTextEditor.getElement());

 
		//richTextEditor.draw();
			richTextEditor.getFieldHtml().addKeyPressHandler(new KeyPressHandler() {
				@Override
				public void onKeyPress(KeyPressEvent event) {					
					Configuracao.setNativeUnoGWTSetValue(parentObject, fieldName, richTextEditor.getHowMValueAsString());
				}
			});
			richTextEditor.getFieldText().addKeyPressHandler(new KeyPressHandler() {
				@Override
				public void onKeyPress(KeyPressEvent event) {
					Configuracao.setNativeUnoGWTSetValue(parentObject, fieldName, richTextEditor.getHowMValueAsString());					
				}
			});
//		}
//		else{
//			SC.say("não definido divParent : "+pDivParent);
//		}
//			
	}
}