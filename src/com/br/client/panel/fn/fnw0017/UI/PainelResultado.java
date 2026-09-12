package com.br.client.panel.fn.fnw0017.UI;

import java.util.LinkedHashMap;

import com.br.client.model.fn.entity.eOrcamentoConta;
import com.br.client.model.fn.fnw0017.FormBean;
import com.br.client.panel.fn.fnw0017.model.eOrcamentoContaTreeNode;
import com.google.gwt.i18n.client.NumberFormat;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.server.HowMUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.GroupStartOpen;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SummaryFunctionType;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class PainelResultado extends VLayout {  
  
	private CellFormatter formatterDoubleTotal= new CellFormatter() {
        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
        	ListGridField field = treeGridTotais.getField(colNum);
        	
        	if( HowMGWTUtilities.isEmpty(value)){
        		return null;
        	}
        	
            if( ListGridFieldType.FLOAT.equals( field.getType() ) ) {
            	return " "+NumberFormat.getFormat("###,###,###,###,###,###,###.00").format(HowMGWTUtilities.getDouble(value));
            }
            else{
            	return " "+value.toString();
            }
        }
	};  	

	private CellFormatter formatterDoubleContas = new CellFormatter() {
        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
        	ListGridField field = treeGridContas.getField(colNum);
        	
        	if( HowMGWTUtilities.isEmpty(value)){
        		return null;
        	}
        	
            if( ListGridFieldType.FLOAT.equals( field.getType() ) ) {
            	return " "+NumberFormat.getFormat("###,###,###,###,###,###,###.00").format(HowMGWTUtilities.getDouble(value));
            }
            else{
            	return " "+value.toString();
            }
        }
	};  	
	
	
	TreeGrid treeGridContas = null;
	TreeGrid treeGridTotais = null;
	eOrcamentoContaTreeNode[] nodesContas = null;
	TreeNode[] nodesTotais = null;
	
	Tree howMTree ;
	
	public TreeGridField contaField 				= new TreeGridField("Conta");
	public TreeGridField contaPaiField 				= new TreeGridField("ContaPai");
	public TreeGridField descricaoField 			= new TreeGridField("Descricao");  
	
	public TreeGridField estimadoField 				= createTreeGridField("Estimado"		, 120, ListGridFieldType.FLOAT, formatterDoubleContas);
	public TreeGridField aditivosField 				= createTreeGridField("Aditivos"		, 120, ListGridFieldType.FLOAT, formatterDoubleContas);
	
	public TreeGridField orcamentoTotalField 		= createTreeGridField("Orcamento Total"	, 120, ListGridFieldType.FLOAT, formatterDoubleContas);  
	public TreeGridField faturadoAbertoField 		= createTreeGridField("Em Aberto"		, 120, ListGridFieldType.FLOAT, formatterDoubleContas);  
	public TreeGridField receitasRealizadasField 	= createTreeGridField("Realizadas"		, 120, ListGridFieldType.FLOAT, formatterDoubleContas);  
	public TreeGridField subTotalField 				= createTreeGridField("SUB TOTAL"		, 120, ListGridFieldType.FLOAT, formatterDoubleContas);  
	public TreeGridField saldoFaturarField 			= createTreeGridField("Saldo"			, 120, ListGridFieldType.FLOAT, formatterDoubleContas);  
	public TreeGridField totalProjetadoField 		= createTreeGridField("Total Projetado"	, 120, ListGridFieldType.FLOAT, formatterDoubleContas);  
    
    TreeGridField contaTotalField 					= new TreeGridField("Conta");
    TreeGridField descricaoTotalField 				= new TreeGridField("Descricao");  
    
    TreeGridField estimadoTotalField 				= createTreeGridField("Estimado"		, 120, ListGridFieldType.FLOAT, formatterDoubleTotal); 
    TreeGridField aditivosTotalField 				= createTreeGridField("Aditivos"		, 120, ListGridFieldType.FLOAT, formatterDoubleTotal);
    
    TreeGridField orcamentoTotalTotalField 			= createTreeGridField("Orcamento Total"	, 120, ListGridFieldType.FLOAT, formatterDoubleTotal);
    TreeGridField faturadoAbertoTotalField 			= createTreeGridField("Em Aberto"		, 120, ListGridFieldType.FLOAT, formatterDoubleTotal);
    TreeGridField receitasRealizadasTotalField 		= createTreeGridField("Realizadas"		, 120, ListGridFieldType.FLOAT, formatterDoubleTotal);
    TreeGridField subTotalTotalField 				= createTreeGridField("SUB TOTAL"		, 120, ListGridFieldType.FLOAT, formatterDoubleTotal);
    TreeGridField saldoFaturarTotalField 			= createTreeGridField("Saldo"			, 120, ListGridFieldType.FLOAT, formatterDoubleTotal);
    TreeGridField totalProjetadoTotalField 			= createTreeGridField("Total Projetado"	, 120, ListGridFieldType.FLOAT, formatterDoubleTotal);
	
    public PainelResultado(){
    	nodesContas = new eOrcamentoContaTreeNode[0];
    	nodesTotais = new TreeNode[0];
    	createTree();
    }
    
    public void createTree() {  
    	    	
    	if( treeGridContas != null ){
    		this.removeMember( treeGridContas );
    	}
    	
    	treeGridContas = new TreeGrid(){
    		@Override
    		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {

    			ListGridField field = this.getField(colNum);
    			if( orcamentoTotalField.getName().equals( field.getName() ) ||
    				subTotalField.getName().equals( field.getName() ) || 
    				totalProjetadoField.getName().equals( field.getName() ) ){
    				return "background-color:yellow; border: 1px solid black;";
    			}
    			
    			return "border: 1px solid black";
    		}
    	};
    	
    	treeGridContas.setBorder("1px solid black");
    	treeGridContas.setLoadDataOnDemand(false);  
    	treeGridContas.setWidth(500);  
    	treeGridContas.setHeight(400);  
    	treeGridContas.setCanEdit(false);  
    	treeGridContas.setCanFreezeFields(false);
                
        treeGridContas.setFields(descricaoField, estimadoField, aditivosField,  
                orcamentoTotalField, faturadoAbertoField, receitasRealizadasField, 
                subTotalField, saldoFaturarField, totalProjetadoField);  
  
        howMTree = new Tree();
        howMTree.setModelType(TreeModelType.PARENT);

        howMTree.setIdField("Conta");
        howMTree.setParentIdField("ContaPai");
        howMTree.setNameProperty("Descricao");
       
        howMTree.setData(nodesContas);
        treeGridContas.setData(howMTree);
        
        treeGridContas.setHeight100();
        treeGridContas.setWidth100();
        
        
        // ------------------------------------------------------------------
        // TOTAIS
        // ------------------------------------------------------------------
        if( treeGridTotais != null ){
    		this.removeMember( treeGridTotais );
    	}
    	
    	treeGridTotais = new TreeGrid(){
    		@Override
    		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {

    			ListGridField field = this.getField(colNum);
    			if( orcamentoTotalField.getName().equals( field.getName() ) ||
    				subTotalField.getName().equals( field.getName() ) || 
    				totalProjetadoField.getName().equals( field.getName() ) ){
    				return "font-family: Arial, Helvetica, sans-serif;font-size: 12px;font-weight: bold;background-color:yellow; border: 1px solid black;";
    			}
    			
    			return "font-family: Arial, Helvetica, sans-serif;font-size: 12px;font-weight: bold; border: 1px solid black";
    		}
    	};
    	
    	treeGridTotais.setBorder("1px solid black");
    	treeGridTotais.setLoadDataOnDemand(false);  
    	treeGridTotais.setHeight(220);  
    	treeGridTotais.setCanEdit(false);  
    	treeGridTotais.setCanFreezeFields(false);
    	
        treeGridTotais.setFields(descricaoTotalField, estimadoTotalField, aditivosTotalField,  
                orcamentoTotalTotalField, faturadoAbertoTotalField, receitasRealizadasTotalField, 
                subTotalTotalField, saldoFaturarTotalField, totalProjetadoTotalField);  
  
        howMTree = new Tree();
        howMTree.setModelType(TreeModelType.PARENT);

        howMTree.setIdField("Conta");
        howMTree.setParentIdField("ContaPai");
        howMTree.setNameProperty("Descricao");
       
        howMTree.setData(nodesTotais);
        treeGridTotais.setData(howMTree);
        
        treeGridTotais.setWidth100();
        
        addMember( treeGridContas );
        addMember( treeGridTotais );
    }  

    public void executeQuery( FormBean bean ) {

    	HowMGWTWindowWait.showWait();
    	HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts( new FormBean() ) {
    		
			@Override
			public void onResponse(HowMGWTFormBean formBean) {

				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true))
					return;

				FormBean bean = (FormBean)formBean;
				eOrcamentoConta[] contas = bean.getContas();
				eOrcamentoContaTreeNode ocTreeNode;
				if( contas != null ){
					
					nodesContas = new eOrcamentoContaTreeNode[contas.length];
					LinkedHashMap<String, eOrcamentoContaTreeNode> mapContas = new LinkedHashMap<String, eOrcamentoContaTreeNode>();
					LinkedHashMap<String, eOrcamentoContaTreeNode> mapContasPais = new LinkedHashMap<String, eOrcamentoContaTreeNode>();
				
					// -------------------------------------------------------------------------
					// Cria o mapa de contas, registra as contas em uma hash para totalização
					// -------------------------------------------------------------------------
					eOrcamentoContaTreeNode orcamentoConta;
					for (int i = 0; i < contas.length; i++) {
						orcamentoConta = new eOrcamentoContaTreeNode(contas[i], PainelResultado.this);
						mapContas.put(orcamentoConta.getEntityOrcamentoConta().getContaSubConta(), orcamentoConta);
						
						nodesContas[i] = orcamentoConta;
						
					}
					
					// -------------------------------------------------------------------------
					// Cria o mapa de contas, registra as contas em uma hash para totalização
					// -------------------------------------------------------------------------
					for (int i = 0; i < contas.length; i++) {
						if( !HowMGWTUtilities.isEmpty( contas[i].getContaSubContaPai() ) ){
							orcamentoConta = mapContas.get( contas[i].getContaSubContaPai() );

							if( orcamentoConta != null ){
								mapContasPais.put(contas[i].getContaSubContaPai(), orcamentoConta);
							}
						}
					}

					// -------------------------------------------------------------------------					
					// Totaliza as contas pai.
					// -------------------------------------------------------------------------
					for (eOrcamentoContaTreeNode treeNode : nodesContas) {
						treeNode.sumarizarContasPai(mapContasPais);
					}

				}
				
				eOrcamentoConta[] totais = bean.getTotais();
				if( totais != null ){
					
					nodesTotais = new TreeNode[totais.length];
					
					for (int i = 0; i < totais.length; i++) {
						
						TreeNode node = new TreeNode();
						node.setAttribute("ContaPai", totais[i].getContaSubContaPai());
						node.setAttribute(contaField.getName(), totais[i].getContaSubConta());
						node.setAttribute(descricaoField.getName(), totais[i].getDescConta());
						node.setAttribute(estimadoField.getName(), totais[i].getVlPrevisao());
						node.setAttribute(aditivosField.getName(), totais[i].getVlAditivos());
						node.setAttribute(orcamentoTotalField.getName(), totais[i].getVlOrcamentoTotal());
						node.setAttribute(faturadoAbertoField.getName(), totais[i].getVlFaturadoEmAberto());
						node.setAttribute(receitasRealizadasField.getName(), totais[i].getVlReceitasRealizadas());
						node.setAttribute(subTotalField.getName(), totais[i].getVlSubTotal());
						node.setAttribute(saldoFaturarField.getName(), totais[i].getVlSaldoFaturar());
						node.setAttribute(totalProjetadoField.getName(), totais[i].getVlTotalProjetado());
						nodesTotais[i] = node;
					}
				}
				
				createTree();
				
				HowMGWTWindowWait.hideWait();
			}
		};
		
		struts.request("fnw0017.do?method=carregarCenario", "FNW0017Form" , bean.toSendBody("") );
    }
    
    
    public TreeGridField createTreeGridField(String name, int size, ListGridFieldType type){
    	return this.createTreeGridField(name, size, type, null);
    }

    
    public TreeGridField createTreeGridField(String name, int size, ListGridFieldType type, CellFormatter formatterDoubleContas){
    	
    	TreeGridField treeGridField = new TreeGridField(name,size);
    	treeGridField.setType(type);
    	if( ListGridFieldType.FLOAT.equals(type) ){
    		treeGridField.setAlign( Alignment.RIGHT );
    	}
    	else{
    		
    	}
    	if( formatterDoubleContas != null ){
            treeGridField.setCellFormatter(formatterDoubleContas);    		
    	}
		treeGridField.setType(type); 
		treeGridField.setCanEdit(false);
		treeGridField.setCanSort(false);
		treeGridField.setCanDragResize(false);
		treeGridField.setCanReorder(false);
		treeGridField.setCanFreeze(false);
		treeGridField.setCanToggle(false);
    	return treeGridField;
    }

 
 
	/**
	 * @return the nodesContas
	 */
	public eOrcamentoContaTreeNode[] getNodesContas() {
		return nodesContas;
	}

	/**
	 * @param nodesContas the nodesContas to set
	 */
	public void setNodesContas(eOrcamentoContaTreeNode[] nodesContas) {
		this.nodesContas = nodesContas;
	}

	/**
	 * @return the nodesTotais
	 */
	public TreeNode[] getNodesTotais() {
		return nodesTotais;
	}

	/**
	 * @param nodesTotais the nodesTotais to set
	 */
	public void setNodesTotais(TreeNode[] nodesTotais) {
		this.nodesTotais = nodesTotais;
	}
}
