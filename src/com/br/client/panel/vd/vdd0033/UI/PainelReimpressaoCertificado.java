package com.br.client.panel.vd.vdd0033.UI;

import java.util.ArrayList;

import com.br.client.model.sg.entity.eFile;
import com.br.client.model.vd.entity.eImprimeCertificado;
import com.br.client.model.vd.vdd0033.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.UI.HowMGWTCheckboxItem;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class PainelReimpressaoCertificado extends VLayout{

	
	private static final String fieldLaderObject = "loadOBJECT";
	
	private FormBean lastFormBean;
	
	private TreeGrid treeGrid;
	private WindowPainelReimpressaoCertificado windowPainelReimpressaoCertificado;
	private String codNotaFiscal;

	
	private VLayout mainLayout = new VLayout();
	
	private  ToolStrip toolbar = new  ToolStrip();
	
	private IButton actionImprimir = new IButton(Tradutor.i18n.formImprimir());
	private HowMGWTProperty propertySelecionarTodos = new HowMGWTProperty("selecionarTodos", Tradutor.i18n.formSelecionarTodos());
	

	
	public PainelReimpressaoCertificado(){

		mainLayout.setWidth100();
		mainLayout.setHeight100();

		
		propertySelecionarTodos.setBound(15, 300);
		propertySelecionarTodos.createHowMGWTCheckboxItem();
		this.addMember(propertySelecionarTodos.getCanvas());
		
		propertySelecionarTodos.getHowMGWTCheckboxItem().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Timer timer = new Timer() {
					
					@Override
					public void run() {
						selectRecords();
					}
				};
				timer.schedule(40);
			}
		});		
		
		
		this.addMember(mainLayout);

		
		actionImprimir.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				imprimirCertificados();
			}
		});
		
		toolbar.setWidth100();
		toolbar.setHeight(30);

		this.toolbar.setAlign(Alignment.RIGHT);

		actionImprimir.setWidth(100);
		actionImprimir.setHeight(22);
		actionImprimir.setIcon("actions/save.png");
		this.toolbar.addMember(actionImprimir);

		this.addMember(toolbar);
	}

	private void loadCertificadosLote(){
		HowMGWTWindowWait.showWait();		
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ) {
					return;
				}
				showCertificados((FormBean)formBean);
			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
			}			
		};			
	
		String body = "";
		formBean.setCodNotaFiscal(this.getCodNotaFiscal());
		body = HowMGWTUtilities.getGWTBeanTransfer(formBean.toJsonObject("").toString());
		
		struts.setGwtCheckSecurity(true);
		struts.request("vdd0033.do?method=buscar",  "VDD0033Form", body);					
	}

	/**
	 * @return the codNotaFiscal
	 */
	public String getCodNotaFiscal() {
		return codNotaFiscal;
	}

	/**
	 * @param codNotaFiscal the codNotaFiscal to set
	 */
	public void setCodNotaFiscal(String codNotaFiscal) {
		this.codNotaFiscal = codNotaFiscal;
		this.loadCertificadosLote();
	}

	/**
	 * @return the windowPainelReimpressaoCertificado
	 */
	public WindowPainelReimpressaoCertificado getWindowPainelReimpressaoCertificado() {
		return windowPainelReimpressaoCertificado;
	}

	/**
	 * @param windowPainelReimpressaoCertificado the windowPainelReimpressaoCertificado to set
	 */
	public void setWindowPainelReimpressaoCertificado(
			WindowPainelReimpressaoCertificado windowPainelReimpressaoCertificado) {
		this.windowPainelReimpressaoCertificado = windowPainelReimpressaoCertificado;
	}
	
	
	/**
	 * Apresenta os certificados associados a nota fiscal de entrada
	 * encontrados a partir do lote embarcado pela nota fiscal de saida.
	 * @param formBean
	 */
	public void showCertificados(FormBean formBean){

		lastFormBean = null;		
		lastFormBean = formBean;
		if ( treeGrid != null )
			mainLayout.removeMember(treeGrid);
		
		treeGrid = new TreeGrid();  
        treeGrid.setLoadDataOnDemand(false);  
        treeGrid.setWidth100();  
        treeGrid.setHeight100();           
        treeGrid.setCanEdit(true);  
        treeGrid.setNodeIcon("icons/16/person.png");  
        treeGrid.setFolderIcon("icons/16/person.png");  
        treeGrid.setAutoFetchData(true);  
        treeGrid.setCanFreezeFields(true);  
        treeGrid.setCanReparentNodes(true);
        treeGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);   
        
        TreeGridField fieldChave	 		= new TreeGridField("key", 				Tradutor.i18n.formCodProduto(), 160);
        TreeGridField fieldChavePai  		= new TreeGridField("parentKey", 		"ChavePai", 100);
        
        fieldChavePai.setHidden(true);
        
        TreeGridField fieldDescricao 		= new TreeGridField("descricao", 		Tradutor.i18n.formDescricao(), 200);
        TreeGridField fieldLote 			= new TreeGridField("lote", 			Tradutor.i18n.formlote(), 100);
        TreeGridField fieldNrCertificado 	= new TreeGridField("nrCertificado", 	Tradutor.i18n.formNrCertificado(), 100);
        
        treeGrid.setFields(fieldChave, fieldChavePai, fieldDescricao, fieldLote, fieldNrCertificado);  
        treeGrid.setCanAutoFitFields(false);
 
        ListGridField[] fields = treeGrid.getFields();
        for ( ListGridField field : fields ){ 
        	field.setCanDragResize(false);
        	field.setCanGroupBy(false);
        	field.setCanHide(false);
        	field.setCanReorder(false);
        	field.setCanSort(false);
        	field.setCanSortClientOnly(false);
        	field.setCanSort(false);
        	field.setCanFreeze(false);
        	
        }

        Tree tree = new Tree();

        tree.setIdField("key");  					// Define o campo chave para montagem da árvore. Imprimir o código do Produto
	    tree.setParentIdField("parentKey");  		// Define o campo pai para formação da hierarquia da árvore.
	    tree.setNameProperty("descricao");			// Define o campo que será apresetnado como texto do campo da árvore

	    tree.setModelType(TreeModelType.PARENT);  	// Define a forma que os dados serão apresentados.

	    tree.setShowRoot(false);  					// não apresenta o nó principal ou o primeiro nó da árvore.

	    ArrayList<TreeNode> nodes = new ArrayList<TreeNode>(); 

	    TreeNode[] records = null;

	    TreeNode record = null;
//	    record.setAttribute(fieldChave.getName(), "A0428");
//	    record.setAttribute(fieldChavePai.getName(), "");
//	    record.setAttribute(fieldDescricao.getName(), "TV LCD 32` FULL HD 3D 800 MKZ");
//	    record.setAttribute("icon", "actions/ico_certificado.gif");
//	    
//	    records[0] = record;
//
//	    record = new TreeNode();
//	    record.setAttribute(fieldChave.getName(), "1");
//	    record.setAttribute(fieldChavePai.getName(), "A0428");
//	    record.setAttribute(fieldDescricao.getName(), "Certificado de Qulidade.pdf");
//	    record.setAttribute("icon", "report/ppt.png");
//	    records[1] = record;
//
//	    record = new TreeNode();
//	    record.setAttribute(fieldChave.getName(), "2");
//	    record.setAttribute(fieldChavePai.getName(), "A0428");
//	    record.setAttribute(fieldDescricao.getName(), "Garantia extendida.pdf");
//	    records[2] = record;

	    // Carrega os dados dos certificados recuperados no servidor para
	    // a árvore de seleção para impressão.
	    if ( formBean.getImprimeCertificados() != null ){
	    	for ( eImprimeCertificado certificado : formBean.getImprimeCertificados() ){
	    	    record = new TreeNode();
	    	    record.setAttribute(fieldChave.getName(), certificado.getCodProduto()+"-"+certificado.getCodLote());
	    	    record.setAttribute(fieldChavePai.getName(), "");
	    	    record.setAttribute(fieldDescricao.getName(), certificado.getDescComercial());
	    	    record.setAttribute(fieldLote.getName(), certificado.getCodLote());
	    	    record.setAttribute(fieldNrCertificado.getName(), certificado.getNrCertificado());
	    	    record.setAttribute("icon", "actions/ico_certificado.gif");
	    	    record.setAttribute(fieldLaderObject, certificado);
	    	    nodes.add(record);

	    	    if( certificado.getAnexos() != null ){
	    	    	int i = 0;
	    	    	for ( eFile file : certificado.getAnexos() ){
	    	    	    record = new TreeNode();
	    	    		record.setAttribute(fieldChave.getName(), ""+(++i));
	    	    	    record.setAttribute(fieldChavePai.getName(), certificado.getCodProduto()+"-"+certificado.getCodLote());
	    	    	    record.setAttribute(fieldDescricao.getName(), file.getName());
	    	    	    record.setAttribute("icon", "actions/ico_attachment.gif");
	    	    	    record.setAttribute(fieldLaderObject, file );
	    	    	    nodes.add(record);
	    	    	}
	    	    }
	    	}
	    	records = new TreeNode[nodes.size()];

	    	int i = 0 ; 
	    	for ( TreeNode node : nodes){
	    		records[i++] = node;
	    	}
	    }
	    else{
	    	records = new TreeNode[0];
	    }

		tree.setData(records);
		treeGrid.setData(tree);
		treeGrid.getData().openAll();

		Timer timer = new Timer() {
			@Override
			public void run() {
				HowMGWTWindowWait.hideWait();
			}
		};
		timer.schedule(60);	    
		
		mainLayout.addMember(treeGrid);
	}
	
	
	
	

	/**
	 * Submete os registros para impressão.
	 */
	private void imprimirCertificados(){
	
		HowMGWTWindowWait.showWait();
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true) ) {
					return;
				}
				System.out.println("Impressao ok");
				SC.say(Tradutor.i18n.msgImpressaoFinalizadaComSucesso());
			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
			}			
		};			
	
		ListGridRecord[] records = this.treeGrid.getRecords();
		Object object;
		boolean select = false;
		String selected;
		for ( ListGridRecord record : records ){
			object = record.getAttributeAsObject(fieldLaderObject);

			selected = ""+treeGrid.isSelected(record);
 
			if ( object instanceof eImprimeCertificado )
				((eImprimeCertificado)object).setSelected(selected);

			else if ( object instanceof eFile )
				((eFile)object).setSelected(selected);

			if ( treeGrid.isSelected(record))
				select = true;
		}
		if ( ! select ){
			HowMGWTWindowWait.hideWait();
			SC.say(Tradutor.i18n.msgSelecionePrimeiroOsItensASeremImpresssos());
			return;
		}

		formBean.setImprimeCertificados(lastFormBean.getImprimeCertificados());

		String body = "";
		body = HowMGWTUtilities.getGWTBeanTransfer(formBean.toJsonObject("").toString());

		struts.setGwtCheckSecurity(true);
		struts.request("vdd0033.do?method=reimprimirCertificado",  "VDD0033Form", body);					
	}	


	/**
	 * Seleciona e deseleciona os registros da listagem. 
	 */
	public void selectRecords(){
		
		ListGridRecord[] records = this.treeGrid.getRecords();

		for ( ListGridRecord record : records ){

			if ( propertySelecionarTodos.getHowMGWTCheckboxItem().getField().getValueAsBoolean().booleanValue() )
				treeGrid.selectRecord(record);
			else
				treeGrid.deselectRecord(record);			
		}
		
	}
	
}