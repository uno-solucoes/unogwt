package com.br.client.panel.sg.sgw0001.UI;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.partner.HowMGWTConstants;

public class PainelParametros extends HowMGWTWindow{

	private boolean initializer = false;
	private ResultadoConsulta listParametros = new ResultadoConsulta();
	
	public  PainelParametros() {
		this.setShowModalMask(true);
		this.setModalMaskOpacity(HowMGWTConstants.WINDOW_MODAL_MASK_OPACITY);
		
		// TODO Auto-generated constructor stub
		this.addItem(listParametros);
	}
	
	
	@Override
	public String getHowMGWTPrograma() {
		// TODO Auto-generated method stub
		return "SGW0001";
	}

	@Override
	public String getHowMGWTTitle() {
		// TODO Auto-generated method stub
		return Tradutor.i18n.formTituloSGW0001();
	}
	
	public void showNFSeParameters(){

		if ( ! initializer ){
			this.setWidth("600px");
			this.setHeight("200px");			
		}
		super.show();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
		this.listParametros.setChangeValues(false);
	}
	
	/**
	 * @return Retorna true caso tenha sido alterado alguma informação de parametros.
	 */
	public boolean isChangeValue(){
		return this.listParametros.isChangeValues();
	}
}
