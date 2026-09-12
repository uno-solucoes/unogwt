package com.br.client.panel.business.UI;

import java.util.TreeMap;

import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.UI.HowMGWTTextItem;
import com.howmake.client.form.UI.HowMGWTWindowBase;
import com.howmake.client.form.model.HOWMGWTDataSourceQuery;
import com.howmake.client.form.model.HowMGWTCallImpl;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.shared.HowMGWTEntity;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
 
import com.smartgwt.client.widgets.form.fields.PickerIcon;
import com.smartgwt.client.widgets.form.fields.events.FormItemClickHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class UCFieldCentroCusto extends HowMGWTWindowBase{

	private boolean inputField = false;
	
	private HowMGWTTextItem textItem;
	
	private boolean load = true;
	
	TreeGrid treeGridCCusto = new TreeGrid();  
	Tree treeCCusto;
	TreeGridField fieldNome = new TreeGridField("desc_abrev");
	
	public UCFieldCentroCusto(){
		
		this.setWidth("300px");
		this.setHeight("250px");
		this.setShowHeader(false);
		
        treeGridCCusto.setWidth100();  
        treeGridCCusto.setHeight100();  
        treeGridCCusto.setShowOpenIcons(false);  
        treeGridCCusto.setShowDropIcons(false);  
        // treeGridGrupos.setAutoFetchData(true);
        treeGridCCusto.setClosedIconSuffix("");  
        treeGridCCusto.setFields(fieldNome);  
        treeGridCCusto.setData(new Tree()); 
        // treeGridGrupos.setShowAllRecords(true);
        treeGridCCusto.setSelectionAppearance(SelectionAppearance.CHECKBOX);  
        treeGridCCusto.setShowSelectedStyle(false);  
        treeGridCCusto.setShowPartialSelection(true);  
        treeGridCCusto.setCascadeSelection(false);
		treeGridCCusto.setShowHeader(false);
		this.setCanDragReposition(false);
             
        addItem(treeGridCCusto);        

        this.setIsModal(true);
		this.setDismissOnOutsideClick(true);
		this.setDismissOnEscape(true);     
		
		this.setDismissOnEscape(true);

	
		
		this.addCloseClickHandler(new CloseClickHandler() {
			
			@Override
			public void onCloseClick(CloseClickEvent event) {
				onChangeSelectCCusto();				
			}
		}); 
		
				
		
	}
 
	/**
	 * Cria uma classe para representação de um no de grupo
	 */
    public static class CCustoTreeNode extends TreeNode {  
        public CCustoTreeNode( String ccustoPai, String ccusto, String nome) {  
            setAttribute("ccusto", ccusto);  
            setAttribute("ccustoPai", ccustoPai);  
            setAttribute("desc_abrev", nome);  
        }
    }

	/**
	 * Apresenta a tela de seleção de grupos de Produtos
	 */
	public void showGrupoVendas(){	
        if ( this.load ){
        	this.loadGrupos();
        }
        else{
        	this.show();
        	loadSelect();
        }
	}
	
	/**
	 * Carrega os grupos a partir do banco de dados.
	 */
	public void loadGrupos(){
		if ( load ){

			String sql = " ";
			
			sql += "select  \n";
			sql += "	'ROOT' as ccustoPai, \n";
			sql += "	ccusto, \n";
			sql += "	desc_abrev \n";
			sql += "from fn_centro_custo\n";
		
			HowMGWTCallImpl call = new HowMGWTCallImpl() {
				
				@Override
				public void onSuccess(HowMGWTEntity result) {			
					TreeNode[] nodeGrupos = new TreeNode[result.getData().size()];
					CCustoTreeNode grupo;
					int i = 0 ;
					for ( String[] row : result.getData() ){
						grupo = new CCustoTreeNode(row[0], row[1] , row[1]+"-"+row[2] );
						nodeGrupos[i] = grupo;
						i ++;
					}				       
					treeCCusto = new Tree();
			        treeCCusto.setModelType(TreeModelType.PARENT);  
			        treeCCusto.setIdField("ccusto");  
			        treeCCusto.setParentIdField("ccustoPai");  
			        treeCCusto.setNameProperty("desc_abrev");				
					treeCCusto.setData(nodeGrupos);
 
					treeGridCCusto.setData(treeCCusto);

					treeGridCCusto.getData().openAll();
								        
					load= false;				
					show();
		        	loadSelect();
				}
			};
			HOWMGWTDataSourceQuery.executeQuery(sql, call, true);
		}	
	}
	
	/**
	 * Intercepta as alterações na lista de seleção e seta os itens selecionados no input.
	 */ 
	public void onChangeSelectCCusto(){		
		ListGridRecord[] listGrids = treeGridCCusto.getSelectedRecords();
		String grupo;
		String ccustos = "";
		// Recupera todos os itens selecionados.
		for (ListGridRecord  listGrid : listGrids ){
			grupo = listGrid.getAttribute("ccusto");			
			if ( ! HowMGWTUtilities.isEmpty(grupo) ){
				// Verifica se a relação de centro de custos já possui elementos,
				// se não possui inclui o elemento, se possuir inclui uma virgula 
				// para separar os demais elementos.
				if ( HowMGWTUtilities.isEmpty(ccustos))
					ccustos += ""+grupo+"";
				else
					ccustos += ","+grupo+"";
			}
		}
		String likes = "";
		String values = this.textItem.getHowMValueAsString();
		if ( values != null ){
			if ( ! values.endsWith(","))
				values += ",";
			
			String[] aValues = values.split(",");
			// recupera todos os valores inputados
			for ( String val : aValues ){
				if ( val.indexOf("%") >= 0 ){
					if ( ! HowMGWTUtilities.isEmpty( likes ) )
						likes += ",";
					likes += val;
				}
			}
		}

		if ( !HowMGWTUtilities.isEmpty( ccustos ) )
			ccustos += "," + likes;
		else
			ccustos += likes;
		
		this.getTextItem().setHowMValue(ccustos);
		this.hide();
	}


	/**
	 * @return Retorna os grupos selecionados.
	 */
	public String getSelectCCusto(){
		
		loadSelect();

		String ccustos = "" ;
		
		TreeMap<String, String> mapCC = new TreeMap<String, String>();
		TreeMap<String, String> mapLike = new TreeMap<String, String>();
		
		ListGridRecord[] listGrids = treeGridCCusto.getSelectedRecords();
		String grupo;
		for (ListGridRecord  listGrid : listGrids ){
			grupo = listGrid.getAttribute("ccusto");	
			if ( HowMGWTUtilities.isEmpty( mapCC.get(grupo) ) )
				mapCC.put(grupo.trim(), grupo.trim());
		}
		String values = this.textItem.getHowMValueAsString();
		if ( ! HowMGWTUtilities.isEmpty(values) ){
			if ( !values.trim().endsWith(","))
				values += ",";
			
			String[] aValues = values.split(",");
			
			for ( String val : aValues ){
				if ( val.indexOf("%") >= 0  )
					mapLike.put(val,val);
				else{
					if ( HowMGWTUtilities.isEmpty(mapCC.get(val)) ){
						mapCC.put(val, val);
					}
				}
			}
		}
		
		Object[] keys = mapCC.keySet().toArray();
		
		for ( Object key : keys ){
			key = key.toString().trim();
			if ( HowMGWTUtilities.isEmpty(ccustos))
				ccustos += "'"+key+"'";
			else
				ccustos += ",'"+key+"'";					
		}

		if ( !HowMGWTUtilities.isEmpty( ccustos )){
			if ( ccustos.indexOf(",") > 0 )
				ccustos = " ${FIELD} in ( "+ccustos+")";
			else
				ccustos = " ${FIELD} = "+ccustos+" ";
		}
		
		keys = mapLike.keySet().toArray();
		
		String likes = "";
		for ( Object key : keys ){
			key = key.toString().trim();
			if ( ! HowMGWTUtilities.isEmpty(likes))
				likes += " OR \n";
			
			likes += " ${FIELD} like '"+key+"'\n";
		}

		String where = ccustos;

		if ( ! HowMGWTUtilities.isEmpty(likes) ){
			if ( !HowMGWTUtilities.isEmpty( ccustos ) )
				where += " OR \n";
			where += "(\n";
			where += likes += ")\n";
		}
		if ( ! HowMGWTUtilities.isEmpty(where))
			where = " ( "+ where + " )";
		return where;
	}
	
	
	
	/**
	 * Limpa os grupos selecionados.
	 */
	public void clearSelectGrupos(){
		this.treeGridCCusto.deselectAllRecords();
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
				treeGridCCusto.setCanFocus(true);
				focus();
			}
		};
		timer.schedule(60);
	}
 
	
	/**
	 * Cria o componente de imput para edição dos dados diretamente via teclado
	 * @return
	 */
	public HowMGWTTextItem getCreateField(){
		final HowMGWTTextItem selecionarCCusto = new HowMGWTTextItem("CCusto", Tradutor.i18n.formCCusto());  
		this.setInputField(true);
		this.setTextItem(selecionarCCusto);
		selecionarCCusto.setWidth(60); 			
		
		PickerIcon button 		 = this.getCreateButton();
		
		selecionarCCusto.getField().setIcons(button);		
		
		return selecionarCCusto;
	}	
	
	/**
	 * Cria um componente tipo botão para realizar a abertura da lista de seleção.
	 * @return
	 */
	public PickerIcon getCreateButton(){
		final PickerIcon selecionarCCusto = new PickerIcon(PickerIcon.SEARCH, new FormItemClickHandler(){  
            public void onFormItemClick(FormItemIconClickEvent event) {  
                // SC.say("Consultar o Cliente");  
            	
				if ( UCFieldCentroCusto.this.isVisible() )
					UCFieldCentroCusto.this.hide();
				else{
					UCFieldCentroCusto.this.setLeft(getTextItem().getAbsoluteLeft());
					UCFieldCentroCusto.this.setTop(getTextItem().getAbsoluteTop()+getTextItem().getHeight());
					UCFieldCentroCusto.this.showGrupoVendas();
				}
            }  
        });
 
		return selecionarCCusto;
	}

	/**
	 * @return the inputField
	 */
	public boolean isInputField() {
		return inputField;
	}

	/**
	 * @param inputField the inputField to set
	 */
	public void setInputField(boolean inputField) {
		this.inputField = inputField;
	}

	/**
	 * @return the textItem
	 */
	public HowMGWTTextItem getTextItem() {
		return textItem;
	}

	/**
	 * @param textItem the textItem to set
	 */
	public void setTextItem(HowMGWTTextItem textItem) {
		this.textItem = textItem;
	}	


	
	
	/**
	 * Verifica os itens informados no campo de input e seleciona os códigos
	 * equivalentes na lista de seleção.
	 */
	public void loadSelect(){
 
		this.clearSelectGrupos();

		if( HowMGWTUtilities.isEmpty( this.getTextItem().getHowMValueAsString()))
			return ;
		
		String values = this.getTextItem().getHowMValueAsString();		

		if ( ! values.endsWith(",") )
			values += ",";

		TreeMap<String, String> mapSelect = new TreeMap<String, String>();
 		String[] aValues = values.split(",");
		for ( String value : aValues ){
			if ( !HowMGWTUtilities.isEmpty(value) ){
				mapSelect.put(value.trim().toUpperCase(), value.trim());
			}
		}
		
		ListGridRecord[] records = this.treeGridCCusto.getRecords();
		for ( ListGridRecord record : records){
			String key = record.getAttribute("ccusto");
			if ( !HowMGWTUtilities.isEmpty( key )){
				if ( mapSelect.get(key.trim().toUpperCase() ) != null ){ 	
						this.treeGridCCusto.selectRecord(record);
				}
			}
		}
	}
}