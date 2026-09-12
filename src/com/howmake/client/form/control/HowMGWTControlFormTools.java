package com.howmake.client.form.control;

import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public interface HowMGWTControlFormTools {

	/**
	 * Passo 1 - Retorna as propriedades de edição.
	 * @return
	 */
	public HowMGWTFormProperties getHowMProperties();	
 
	public void onHowMSetValues(ListGridRecord record);
	
	/**
	 * Define as operações permitidas no formulório.
	 */
	public void onHowMNewRecord();
	public void onHowMEditRecord();
	
}
