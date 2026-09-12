package com.howmake.client.form.control;

import com.howmake.client.form.model.HowMGWTActionDescription;

/**
 * Interface utilizada para realizar operações de gravação de dados no servidor.
 * @author HCINF
 *
 */
public interface HowMGWTControlFormSave {

	public boolean onHowMFormBeforeSave(HowMGWTActionDescription actionDescription);
	public void onHowMFormAfterSave(HowMGWTActionDescription actionDescription);
	public boolean onHowMFormSave(HowMGWTActionDescription actionDescription);	
	
}
