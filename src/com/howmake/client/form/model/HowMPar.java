package com.howmake.client.form.model;

import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class HowMPar {
	
	private ListGridRecord listGridRecord;
	private HowMGWTFormBean formBean;
	private int index;

	private ListGrid parentListGrid;
	
	/**
	 * @return the formBean
	 */
	public HowMGWTFormBean getFormBean() {
		return formBean;
	}
	/**
	 * @param formBean the formBean to set
	 */
	public void setFormBean(HowMGWTFormBean formBean) {
		this.formBean = formBean;
	}
	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}
	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	/**
	 * @return the listGridRecord
	 */
	public ListGridRecord getListGridRecord() {
		return listGridRecord;
	}
	/**
	 * @param listGridRecord the listGridRecord to set
	 */
	public void setListGridRecord(ListGridRecord listGridRecord) {
		this.listGridRecord = listGridRecord;
	}
	/**
	 * @return the parentListGrid
	 */
	public ListGrid getParentListGrid() {
		return parentListGrid;
	}
	/**
	 * @param parentListGrid the parentListGrid to set
	 */
	public void setParentListGrid(ListGrid parentListGrid) {
		this.parentListGrid = parentListGrid;
	}

	public boolean addMessageError(HowMGWTProperty property, String message){
		this.getParentListGrid().setFieldError(this.getIndex(), property.getName(), message);
		return false;
	}

	
	/**
	 * Libera o recurso alocado
	 */
	public void clear(){		
		setIndex(-1);
		setFormBean(null);
		setListGridRecord(null);
		setParentListGrid(null);
	}
}