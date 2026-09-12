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
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
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

public class UCFieldPlanoContas extends HowMGWTWindowBase{

	private boolean inputField = false;
	
	private HowMGWTTextItem textItem;
	
	private boolean load = true;
	
	TreeGrid treeGridPlanoContas = new TreeGrid();  
	Tree treePlanoContas;
	TreeGridField fieldNome = new TreeGridField("desc_abrev");
	
	private IButton actionButton = null; 
	
	public UCFieldPlanoContas(){
		
		this.setWidth("450px");
		this.setHeight("500px");
		this.setShowHeader(true);
		
        treeGridPlanoContas.setWidth100();  
        treeGridPlanoContas.setHeight100();  
        treeGridPlanoContas.setShowOpenIcons(true);  
        treeGridPlanoContas.setShowDropIcons(true);
        
        treeGridPlanoContas.setFields(fieldNome);  
        treeGridPlanoContas.setData(new Tree()); 
        treeGridPlanoContas.setShowAllRecords(false);
        treeGridPlanoContas.setSelectionAppearance(SelectionAppearance.CHECKBOX);  
        treeGridPlanoContas.setShowSelectedStyle(false);  
        treeGridPlanoContas.setShowPartialSelection(true);  
        treeGridPlanoContas.setCascadeSelection(true);
		treeGridPlanoContas.setShowHeader(false);
		this.setCanDragReposition(false);
             
        addItem(treeGridPlanoContas);        

        this.setIsModal(true);
		this.setDismissOnOutsideClick(true);
		this.setDismissOnEscape(true);     
		
		this.setDismissOnEscape(true);

		this.addCloseClickHandler(new CloseClickHandler() {
			
			@Override
			public void onCloseClick(CloseClickEvent event) {
				onChangeSelectPlanoContas();				
			}
		}); 
		
			
		this.setTitle("Plano de Contas");
		
	}
 
	/**
	 * Cria uma classe para representação de um no de grupo
	 */
    public static class NodePlanoContas extends TreeNode {  
        public NodePlanoContas( String planoContasPai, String planoContas, String nome) {  
            setAttribute("conta", planoContas);  
            setAttribute("contaPai", planoContasPai);  
            setAttribute("desc_abrev", nome);  
        }
    }

	/**
	 * Apresenta a tela de seleção de grupos de Produtos
	 */
	public void showGrupoVendas(){	
        if ( this.load ){
        	this.loadPlanoContas();
        }
        else{
        	this.show();
        	// loadSelect();
        }
	}
	
	/**
	 * Carrega os grupos a partir do banco de dados.
	 */
	public void loadPlanoContas(){
		if ( load ){

			String sql = " ";

			sql += "select \n";
			sql += "	concat(conta_totalizadora,'-',sub_conta_totalizadora) as contaPai, \n"; 
			sql += "	concat(conta,'-',sub_conta) as conta,  \n";
			sql += "	desc_abrev  \n";
			sql += "from  \n";
			sql += "	fn_plano_conta \n"; 
			sql += "order by  \n";
			sql += "	concat(conta,'-',sub_conta) \n"; // Solicitado pelo marcio em 07/09/2015

			HowMGWTCallImpl call = new HowMGWTCallImpl() {
				
				@Override
				public void onSuccess(HowMGWTEntity result) {			
					TreeNode[] nodeGrupos = new TreeNode[result.getData().size()];
					NodePlanoContas grupo;
					int i = 0 ;
					for ( String[] row : result.getData() ){
						grupo = new NodePlanoContas(row[0], row[1] , row[1]+"-"+row[2] );
						nodeGrupos[i] = grupo;
						i ++;
					}				       
					treePlanoContas = new Tree();
			        treePlanoContas.setModelType(TreeModelType.PARENT);  
			        treePlanoContas.setIdField("conta");  
			        treePlanoContas.setParentIdField("contaPai");  
			        treePlanoContas.setNameProperty("desc_abrev");				
					treePlanoContas.setData(nodeGrupos);
 
					treeGridPlanoContas.setData(treePlanoContas);

					treeGridPlanoContas.getData().openAll();
								        
					load= false;				
					show();
		        	// loadSelect();
				}
			};
			HOWMGWTDataSourceQuery.executeQuery(sql, call, true);
		}	
	}
	
	/**
	 * Intercepta as alterações na lista de seleção e seta os itens selecionados no input.
	 */ 
	public void onChangeSelectPlanoContas(){		
		ListGridRecord[] listGrids = treeGridPlanoContas.getSelectedRecords();
		String grupo;
		String planoContas = "";
		// Recupera todos os itens selecionados.
		for (ListGridRecord  listGrid : listGrids ){
			grupo = listGrid.getAttribute("conta");			
			if ( ! HowMGWTUtilities.isEmpty(grupo) ){
				// Verifica se a relação conta / conta pai já possui elementos,
				// se não possui inclui o elemento, se possuir inclui uma virgula 
				// para separar os demais elementos.
				if ( HowMGWTUtilities.isEmpty(planoContas))
					planoContas += ""+grupo+"";
				else
					planoContas += ","+grupo+"";
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

		if ( !HowMGWTUtilities.isEmpty( planoContas ) )
			planoContas += "," + likes;
		else
			planoContas += likes;
		
		this.getTextItem().setHowMValue(planoContas);
		this.hide();
	}


	/**
	 * @return Retorna os grupos selecionados.
	 */
	public String getSelectPlanoContas(){
		
		// loadSelect();

		String planoContas = "" ;
		
		TreeMap<String, String> mapCC = new TreeMap<String, String>();
		TreeMap<String, String> mapLike = new TreeMap<String, String>();
		
		ListGridRecord[] listGrids = treeGridPlanoContas.getSelectedRecords();
		String grupo;
		for (ListGridRecord  listGrid : listGrids ){
			grupo = listGrid.getAttribute("conta");	
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
			if ( HowMGWTUtilities.isEmpty(planoContas))
				planoContas += "'"+key+"'";
			else
				planoContas += ",'"+key+"'";					
		}

		if ( !HowMGWTUtilities.isEmpty( planoContas )){
			if ( planoContas.indexOf(",") > 0 )
				planoContas = " ${FIELD} in ( "+planoContas+")";
			else
				planoContas = " ${FIELD} = "+planoContas+" ";
		}
		
		keys = mapLike.keySet().toArray();
		
		String likes = "";
		for ( Object key : keys ){
			key = key.toString().trim();
			if ( ! HowMGWTUtilities.isEmpty(likes))
				likes += " OR \n";
			
			likes += " ${FIELD} like '"+key+"'\n";
		}

		String where = planoContas;

		if ( ! HowMGWTUtilities.isEmpty(likes) ){
			if ( !HowMGWTUtilities.isEmpty( planoContas ) )
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
		this.treeGridPlanoContas.deselectAllRecords();
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
				treeGridPlanoContas.setCanFocus(true);
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
		final HowMGWTTextItem selecionarPlanoContas = new HowMGWTTextItem("conta", Tradutor.i18n.formPlanoContas());  
		this.setInputField(true);
		this.setTextItem(selecionarPlanoContas);
		selecionarPlanoContas.setWidth(60);
		
		
		PickerIcon button 		 = this.getCreateButton();
		
		selecionarPlanoContas.getField().setIcons(button);		
		
		return selecionarPlanoContas;
	}	
	
	public IButton getCreateIButton(){
		final HowMGWTTextItem selecionarPlanoContas = new HowMGWTTextItem("conta", Tradutor.i18n.formPlanoContas());  
		this.setInputField(true);
		this.setTextItem(selecionarPlanoContas);
		selecionarPlanoContas.setWidth(60);				
		actionButton 		 = new IButton(Tradutor.i18n.formPlanoContas());
		actionButton.setIcon("actions/find_explorer_account.png");
		actionButton.setWidth(80);
		actionButton.setMargin(2);
		actionButton.setHeight(26);
		actionButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {

				if ( UCFieldPlanoContas.this.isVisible() )
					UCFieldPlanoContas.this.hide();
				else{
					UCFieldPlanoContas.this.setLeft(actionButton.getAbsoluteLeft());
					UCFieldPlanoContas.this.setTop(actionButton.getAbsoluteTop()+actionButton.getHeight());
					UCFieldPlanoContas.this.showGrupoVendas();
				}
				
			}
		});
		
		return actionButton;
	}	
	
	
	/**
	 * Cria um componente tipo botão para realizar a abertura da lista de seleção.
	 * @return
	 */
	public PickerIcon getCreateButton(){
		final PickerIcon selecionarPlanoContas = new PickerIcon(PickerIcon.SEARCH, new FormItemClickHandler(){  
            public void onFormItemClick(FormItemIconClickEvent event) {  
                // SC.say("Consultar o Cliente");  
            	
				if ( UCFieldPlanoContas.this.isVisible() )
					UCFieldPlanoContas.this.hide();
				else{
					UCFieldPlanoContas.this.setLeft(getTextItem().getAbsoluteLeft());
					UCFieldPlanoContas.this.setTop(getTextItem().getAbsoluteTop()+getTextItem().getHeight());
					UCFieldPlanoContas.this.showGrupoVendas();
				}
            }  
        });
 
		return selecionarPlanoContas;
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


	
	
//	/**
//	 * Verifica os itens informados no campo de input e seleciona os códigos
//	 * equivalentes na lista de seleção.
//	 */
//	public void loadSelect(){
// 
//		this.clearSelectGrupos();
//
//		if( HowMGWTUtilities.isEmpty( this.getTextItem().getHowMValueAsString()))
//			return ;
//		
//		String values = this.getTextItem().getHowMValueAsString();		
//
//		if ( ! values.endsWith(",") )
//			values += ",";
//
//		TreeMap<String, String> mapSelect = new TreeMap<String, String>();
// 		String[] aValues = values.split(",");
//		for ( String value : aValues ){
//			if ( !HowMGWTUtilities.isEmpty(value) ){
//				mapSelect.put(value.trim().toUpperCase(), value.trim());
//			}
//		}
//		
//		ListGridRecord[] records = this.treeGridPlanoContas.getRecords();
//		for ( ListGridRecord record : records){
//			String key = record.getAttribute("conta");
//			if ( !HowMGWTUtilities.isEmpty( key )){
//				if ( mapSelect.get(key.trim().toUpperCase() ) != null ){ 	
//						this.treeGridPlanoContas.selectRecord(record);
//				}
//			}
//		}
//	}
}