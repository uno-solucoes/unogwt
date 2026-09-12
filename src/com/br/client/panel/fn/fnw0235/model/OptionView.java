package com.br.client.panel.fn.fnw0235.model;

import com.howmake.client.form.partner.HowMGWTUtilities;

public class OptionView {

	private boolean showAtrasos 	= false;
	private boolean showMesAtual 	= false;
	private boolean showPagos	 	= false;
	private boolean showPrevisoes 	= false;
	
	public boolean isShowAtrasos() {
		return showAtrasos;
	}
	public void setShowAtrasos(boolean showAtrasos) {
		this.showAtrasos = showAtrasos;
	}
	public boolean isShowMesAtual() {
		return showMesAtual;
	}
	public void setShowMesAtual(boolean showMesAtual) {
		this.showMesAtual = showMesAtual;
	}
	public boolean isShowPagos() {
		return showPagos;
	}
	public void setShowPagos(boolean showPagos) {
		this.showPagos = showPagos;
	}
	public boolean isShowPrevisoes() {
		return showPrevisoes;
	}
	public void setShowPrevisoes(boolean showPrevisoes) {
		this.showPrevisoes = showPrevisoes;
	}

	public String getSequencias(){
		String sequencias = "";
		if( isShowAtrasos() ){
			sequencias += "1";
		}
		if( this.isShowMesAtual() ){
			if( HowMGWTUtilities.isEmpty(sequencias) ){
				sequencias += "2";
			}
			else{
				sequencias += ", 2";
			}		
		}
		if( this.isShowPagos() ){
			if( HowMGWTUtilities.isEmpty(sequencias) ){
				sequencias += "3";
			}
			else{
				sequencias += ", 3";
			}
		}
		if( this.isShowPrevisoes() ){
			if( HowMGWTUtilities.isEmpty(sequencias) ){
				sequencias += "4";
			}
			else{
				sequencias += ", 4";
			}
		}
		return sequencias;
	}
	
}
