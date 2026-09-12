package com.howmake.client.form.control;

import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public interface HowMGWTControlForm {
 
	/**
	 * Passo 1 - Retorna as propriedades de edição.
	 * @return
	 */
	public HowMGWTFormProperties getHowMProperties();
	
 
	// Carrega os dados.
	public void onHowMLoad(HowMGWTFormBean formBean);

	public void onHowMSetValues(ListGridRecord record);
	
	public void onHowMRelation(ListGridRecord record);

	/**
	 * Define as operações permitidas no formulório.
	 */
	public void onHowMNewRecord();
	public void onHowMEditRecord();
	public void onHowMDeleteRecord();

	/**
	 * Grava as operações permitidas no servidor.
	 */
	public void onHowMSave();	
}
