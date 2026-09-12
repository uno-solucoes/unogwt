package com.br.client.panel.business.UI;

import java.util.ArrayList;
import java.util.TreeMap;

import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.UI.HowMGWTTextItem;
import com.howmake.client.form.UI.HowMGWTWindowBase;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class UCFieldListaUF extends HowMGWTWindowBase{

	private JavaScriptObject parentObject;
	private String hideField;
	
	private boolean inputField = false;
	
	private HowMGWTTextItem textItem;
	
	private boolean load = true;
	
	TreeGrid treeGridUF = new TreeGrid();  
	Tree treeUF;
	TreeGridField fieldNome = new TreeGridField("ufDesc");
	
	public UCFieldListaUF(){
		
		this.setWidth("160px");
		this.setHeight("500px");
		this.setShowHeader(true);
		this.setTitle("Lista de UFs");
		
        treeGridUF.setWidth100();  
        treeGridUF.setHeight100();  
        treeGridUF.setShowOpenIcons(false);  
        treeGridUF.setShowDropIcons(false);  
        // treeGridGrupos.setAutoFetchData(true);
        treeGridUF.setClosedIconSuffix("");  
        treeGridUF.setFields(fieldNome);  
        treeGridUF.setData(new Tree()); 
        // treeGridGrupos.setShowAllRecords(true);
        treeGridUF.setSelectionAppearance(SelectionAppearance.CHECKBOX);  
        treeGridUF.setShowSelectedStyle(false);  
        treeGridUF.setShowPartialSelection(true);  
        treeGridUF.setCascadeSelection(false);
		treeGridUF.setShowHeader(false);
		this.setCanDragReposition(false);
             
        addItem(treeGridUF); 

        
        
        this.setIsModal(true);
		this.setDismissOnOutsideClick(true);
		this.setDismissOnEscape(true);     
		
		this.setDismissOnEscape(true);
		
		this.addCloseClickHandler(new CloseClickHandler() {
			
			@Override
			public void onCloseClick(CloseClickEvent event) {
				onChange();
			}
		});
	}
 
	/**
	 * Cria uma classe para representação de um no de grupo
	 */
    class UFTreeNode extends TreeNode {  
        public UFTreeNode( String uf, String desc) { 
            setAttribute("uf", uf);
            setAttribute("ufPai", "");  
            setAttribute(fieldNome.getName(), desc);  
        }
    	public UFTreeNode( String uf) { 
            setAttribute("uf", uf);
            setAttribute("ufPai", "");  
            setAttribute(fieldNome.getName(), uf);  
        }
    }

	/**
	 * Apresenta a tela de seleção de grupos de Produtos
	 */
	public void showUFs(){
		this.centerInPage();
        if ( this.load )
        	this.loadUFs();
        else
        	this.show();
        this.loadSelect();
	}
	
	/**
	 * Carrega os grupos a partir do banco de dados.
	 */
	public void loadUFs(){

		ArrayList<UFTreeNode> ufs = new ArrayList<UFTreeNode>();
		
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFExterior()));
	
		ufs.add(new UFTreeNode("EX",Tradutor.i18n.formUFAc()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFAl()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFAp()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFAm()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFBa()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFCe()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFDf()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFEs()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFGo()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFMa()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFMt()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFMs()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFMg()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFPa()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFPb()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFPr()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFPe()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFPi()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFRj()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFRn()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFRs()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFRo()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFRr()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFSc()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFSp()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFSe()));
		ufs.add(new UFTreeNode(Tradutor.i18n.formUFTo()));
	
		UFTreeNode[] nodeUfs = new UFTreeNode[ufs.size()];
		int i = 0;
		for ( UFTreeNode node : ufs){
			nodeUfs[i] = node;
			i++;
		}
		
		treeUF = new Tree();
		treeUF.setModelType(TreeModelType.PARENT);

		treeUF.setRootValue("");  
		treeUF.setIdField("uf");
		treeUF.setParentIdField("ufPai");
		treeUF.setNameProperty(fieldNome.getName());
		treeUF.setData(nodeUfs);
 
		
		treeGridUF.setData(treeUF);

		treeGridUF.getData().openAll();
 
		this.load = false;
		
		this.show();
	}
	
	
	
	/**
	 * Limpa os grupos selecionados.
	 */
	public void clearSelectGrupos(){
		this.treeGridUF.deselectAllRecords();
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
				treeGridUF.setCanFocus(true);
				focus();
			}
		};
		timer.schedule(60);
	}
	
	
	
 
	
	public IButton getCreateButton(){
		final IButton selecionarCCusto = new IButton(Tradutor.i18n.formCCusto());  
		this.setInputField(false);
		this.setTextItem(null);
		selecionarCCusto.setWidth(80);  
		selecionarCCusto.setShowRollOver(true);  
		selecionarCCusto.setShowDisabled(true);
		selecionarCCusto.setShowDisabledIcon(true);
		selecionarCCusto.setShowDown(true);  
		selecionarCCusto.setIcon("[SKINIMG]/headerIcons/arrow_down_Over.png");  
		
		selecionarCCusto.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if ( UCFieldListaUF.this.isVisible() )
					UCFieldListaUF.this.hide();
				else{
					UCFieldListaUF.this.setLeft(selecionarCCusto.getAbsoluteLeft());
					UCFieldListaUF.this.setTop(selecionarCCusto.getAbsoluteTop()+selecionarCCusto.getHeight());
					UCFieldListaUF.this.showUFs();
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
	

	public void onChange() {
		if ( this.parentObject != null ){

			this.treeGridUF.saveAllEdits();

			ListGridRecord[] records = this.treeGridUF.getSelectedRecords();
			String values = "";
			for ( ListGridRecord record : records){
				if( HowMGWTUtilities.isEmpty(values))
					values += ""+record.getAttribute("uf")+"";
				else
					values += ","+record.getAttribute("uf")+"";
			}
			setNativeSetValue(this.getParentObject(), values);
		}
		super.hide();
	}

	/**
	 * @return Retorna o endereço absoluto do contexto onde serão executados os serviços de donwload
	 * GWT.
	 */
	public native void setNativeSetValue( JavaScriptObject hideField , String values) /*-{
	   hideField.value = values;	 
	}-*/;

	/**
	 * @return Retorna o endereço absoluto do contexto onde serão executados os serviços de donwload
	 * GWT.
	 */
	public native String getNativeSetValue( JavaScriptObject hideField , String values) /*-{
	   return hideField.value;	 
	}-*/;	
	
	/**
	 * @return the parentObject
	 */
	public JavaScriptObject getParentObject() {
		return parentObject;
	}

	/**
	 * @param parentObject the parentObject to set
	 */
	public void setParentObject(JavaScriptObject parentObject) {
		this.parentObject = parentObject;
	}

	/**
	 * @return the hideField
	 */
	public String getHideField() {
		return hideField;
	}

	/**
	 * @param hideField the hideField to set
	 */
	public void setHideField(String hideField) {
		this.hideField = hideField;
	}
	
	public void loadSelect(){
		if ( this.getParentObject() == null )
			return;
		String values = (getNativeSetValue(this.getParentObject(), this.getHideField())+",").toUpperCase();
		
		this.clearSelectGrupos();
		
		TreeMap<String, String> mapSelect = new TreeMap<String, String>();
 		String[] aValues = values.split(",");
		for ( String value : aValues ){
			mapSelect.put(value.trim(), value.trim());
		}
		
		ListGridRecord[] records = this.treeGridUF.getRecords();
		for ( ListGridRecord record : records){
			if ( mapSelect.get(record.getAttribute("uf").trim().toUpperCase() ) != null ) 	
					this.treeGridUF.selectRecord(record);
		}
	}
}