package com.howmake.client.form.model;

import java.util.LinkedHashMap;

import com.howmake.client.form.UI.HowMGWTTreeGrid;
import com.howmake.client.form.partner.HowMGWTConstants;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.tree.TreeNode;

public class HowMGWTTreeNode extends TreeNode{
	
	private HowMGWTTreeGrid treeGrid;
	
	private HowMGWTFormBean bean;
	
	private String howMOperation;
	
	public HowMGWTTreeNode(HowMGWTTreeGrid treeGrid, HowMGWTFormBean bean){

		this.treeGrid 	= treeGrid;
		this.bean 		= bean;
	

		Object[] keys = bean.getObjectShelf().keySet().toArray();
		HowMGWTProperty prop;
		for ( Object key : keys ){
			prop = treeGrid.getMapHowMFields().get(key.toString());
			if ( prop != null && ListGridFieldType.BOOLEAN.equals(prop.getType())){
				this.setAttribute(prop.getName(), HowMGWTUtilities.getBoolean(bean._self.get(key)));
			}
			else{
				this.setAttribute(key.toString(), bean._self.get(key));
			}
		}

		
//		if( this.bean.isSQLOperacaoInsert() )
//			this.setHowMOperation("icon_operation_insert");
//
//		else if ( this.bean.isSQLOperacaoUpdate() )
//			this.setHowMOperation("icon_operation_edited");
//
//		else if ( this.bean.isSQLOperacaoDelete() )
//			this.setHowMOperation("icon_operation_deleted");
//		
		
		this.setAttribute(treeGrid.getHowMParentKeyName(), bean.toString(treeGrid.getHowMParentKeyName()));
		this.setAttribute(treeGrid.getHowMKeyName(), bean.toString(treeGrid.getHowMKeyName()));
		this.setAttribute(treeGrid.getHowmFieldName(), bean.toString(treeGrid.getHowmFieldName()));

		if ( treeGrid.isHowMCustomIcon() ){
			
			if( HowMGWTUtilities.isEmpty(treeGrid.getHowMCustomContext()))
				this.setIcon(HowMGWTConstants.getContextImageMenu("")+bean.toString(treeGrid.getHowmIconName()));
			else
				this.setIcon(treeGrid.getHowMCustomContext()+bean.toString(treeGrid.getHowmIconName()));							

			if( HowMGWTUtilities.isEmpty(bean.toString(treeGrid.getHowmIconName())))
				this.setIcon(HowMGWTConstants.getContextImageMenu("")+"transparence.png");							
		}		
	}

	public void refreshHowMGWTTreeNode(HowMGWTFormProperties properties , HowMGWTFormBean bean){
		
		// Limpa os valores dos campos do formulório.
		for ( HowMGWTProperty prop : properties.getProperties() ){

			if ( prop.getName().toString().trim().equals(treeGrid.getHowMParentKeyName()))
				continue;

			if ( prop.getName().toString().trim().equals(treeGrid.getHowMKeyName()))
				continue;
		
			this.setAttribute(prop.getName() , (String)null);
		}

		refreshHowMGWTTreeNode(bean, properties.getMapProperties());
	}	
	
	private void refreshHowMGWTTreeNode(HowMGWTFormBean bean){
		refreshHowMGWTTreeNode(bean, null);
	}
	
	private void refreshHowMGWTTreeNode(HowMGWTFormBean bean, LinkedHashMap<String, HowMGWTProperty> mapProperties){

		this.bean 		= bean;
		
		Object[] keys = bean.getObjectShelf().keySet().toArray();
		for ( Object key : keys ){

			if ( key.toString().trim().equals(treeGrid.getHowMParentKeyName()))
				continue;

			if ( key.toString().trim().equals(treeGrid.getHowMKeyName()))
				continue;


			// Se tiver mapa de propriedade, respeita as configurações do mapa.
			if( mapProperties != null ){
				HowMGWTProperty prop = mapProperties.get(key);
				if( prop != null ){
					prop.setHowMValue(this, bean._self.get(key));
				}
				else
					this.setAttribute(key.toString(), bean._self.get(key));
			}
			else
				this.setAttribute(key.toString(), bean._self.get(key));

		}

		this.setAttribute(treeGrid.getHowmFieldName(), bean.toString(treeGrid.getHowmFieldName()));
		 
		if ( treeGrid.isHowMCustomIcon() ){
			
			if( HowMGWTUtilities.isEmpty(treeGrid.getHowMCustomContext()))
				this.setIcon(HowMGWTConstants.getContextImageMenu("")+bean.toString(treeGrid.getHowmIconName()));
			else
				this.setIcon(treeGrid.getHowMCustomContext()+bean.toString(treeGrid.getHowmIconName()));
			
			if( HowMGWTUtilities.isEmpty(bean.toString(treeGrid.getHowmIconName())))
				this.setIcon(HowMGWTConstants.getContextImageMenu("")+"transparence.png");				
		}				
	}

	
	public HowMGWTFormBean getHowMFormBean(){
		return this.bean;
	}


	public void setHowMIdParentKey(Object value){
		this.setAttribute(treeGrid.getHowMParentKeyName(), value);
	}

	public void setHowMKey(Object value){
		this.setAttribute(treeGrid.getHowMKeyName(), value);
	}	
	
	public String getHowMIdParentKey(){
		return 	this.getAttribute(treeGrid.getHowMParentKeyName());
	}

	public String getHowMKey(){
		return 	this.getAttribute(treeGrid.getHowMKeyName());
	}

	public String getHowMName(){
		return 	this.getAttribute(treeGrid.getHowmFieldName());
	}

	

	public String getHowMIcon(){
		return 	this.getAttribute( "icon" );
	}
	
	public void onHowMGWTClear(){
		
		this.treeGrid = null;
		this.bean     = null;
	}

	/**
	 * @return the howMOperation
	 */
	public String getHowMOperation() {
		return howMOperation;
	}

	/**
	 * @param howMOperation the howMOperation to set
	 */
	public void setHowMOperation(String howMOperation) {
		this.howMOperation = howMOperation;
	}
	
	
	
}
