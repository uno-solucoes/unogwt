package com.br.client.panel.vd.vdq0002.UI;

import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.UI.HowMGWTWindowBase;
import com.howmake.client.form.model.HOWMGWTDataSourceQuery;
import com.howmake.client.form.model.HowMGWTCallImpl;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.shared.HowMGWTEntity;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class VDD0006PainelGruposProduto extends HowMGWTWindowBase{

	private boolean load = true;
	
	TreeGrid treeGridGrupos = new TreeGrid();  
	Tree treeGrupos;
	TreeGridField fieldNome = new TreeGridField("nome");
	
	public VDD0006PainelGruposProduto(){
		
		this.setWidth("480px");
		this.setHeight("300px");
		this.setShowHeader(false);
		
        treeGridGrupos.setWidth100();  
        treeGridGrupos.setHeight100();  
        treeGridGrupos.setShowOpenIcons(false);  
        treeGridGrupos.setShowDropIcons(false);  
        // treeGridGrupos.setAutoFetchData(true);
        treeGridGrupos.setClosedIconSuffix("");  
        treeGridGrupos.setFields(fieldNome);  
        treeGridGrupos.setData(new Tree()); 
        // treeGridGrupos.setShowAllRecords(true);
        treeGridGrupos.setSelectionAppearance(SelectionAppearance.CHECKBOX);  
        treeGridGrupos.setShowSelectedStyle(false);  
        treeGridGrupos.setShowPartialSelection(true);  
        treeGridGrupos.setCascadeSelection(false);
		treeGridGrupos.setShowHeader(false);
		this.setCanDragReposition(false);
             
        addItem(treeGridGrupos);        

        this.setIsModal(true);
		this.setDismissOnOutsideClick(true);
		this.setDismissOnEscape(true);     
		
		this.setDismissOnEscape(true);

	}
 
	/**
	 * Cria uma classe para representação de um nó de grupo
	 */
    public static class GrupoTreeNode extends TreeNode {  
        public GrupoTreeNode( String grupoPai, String grupo, String nome) {  
            setAttribute("grupo", grupo);  
            setAttribute("grupoPai", grupoPai);  
            setAttribute("nome", nome);  
        }
    }

	/**
	 * Apresenta a tela de seleção de grupos de Produtos
	 */
	public void showGrupoVendas(){	
        if ( this.load )
        	this.loadGrupos();
        else
        	this.show();
	}
	
	/**
	 * Carrega os grupos a partir do banco de dados.
	 */
	public void loadGrupos(){
		if ( load ){

			String sql = " ";
			sql += "select ";
			sql += "	cod_grupo_pai, ";
			sql += "	cod_grupo_produto, ";
			sql += "	desc_abrev  ";
			sql += "from ";
			sql += "	cd_grupo_produto ";
		
			HowMGWTCallImpl call = new HowMGWTCallImpl() {
				
				@Override
				public void onSuccess(HowMGWTEntity result) {			
					TreeNode[] nodeGrupos = new TreeNode[result.getData().size()];
					GrupoTreeNode grupo;
					int i = 0 ;
					for ( String[] row : result.getData() ){
						grupo = new GrupoTreeNode(row[0], row[1] , row[2] );
						nodeGrupos[i] = grupo;
						i ++;
					}				       
					treeGrupos = new Tree();
			        treeGrupos.setModelType(TreeModelType.PARENT);  
			        treeGrupos.setIdField("grupo");  
			        treeGrupos.setParentIdField("grupoPai");  
			        treeGrupos.setNameProperty("nome");				
					treeGrupos.setData(nodeGrupos);
 
					treeGridGrupos.setData(treeGrupos);

					treeGridGrupos.getData().openAll();
								        
					load= false;				
					show();
				}
			};
			HOWMGWTDataSourceQuery.executeQuery(sql, call, true);
		}	
	}
	
	/**
	 * @return Retorna os grupos selecionados.
	 */
	public String getSelectGrupos(){
		String grupos = "" ;
		
		ListGridRecord[] listGrids = treeGridGrupos.getSelection();
		String grupo;
		for (ListGridRecord  listGrid : listGrids ){

			grupo = listGrid.getAttribute("grupo");
			
			if ( HowMGWTUtilities.isEmpty(grupos)){
				grupos += grupo;
			}
			else{
				grupos += ","+grupo;
			}
		}
		return grupos;
	}
	
	
	
	/**
	 * Limpa os grupos selecionados.
	 */
	public void clearSelectGrupos(){
		this.treeGridGrupos.deselectAllRecords();
	}
	
	@Override
	public boolean isVisible() {
		if ( this.load ){
			return false;
		}
		return super.isVisible();
	}
 
	@Override
	public void show() {
		super.show();
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				setCanFocus(true);
				treeGridGrupos.setCanFocus(true);
				focus();
			}
		};
		timer.schedule(60);
	}
}