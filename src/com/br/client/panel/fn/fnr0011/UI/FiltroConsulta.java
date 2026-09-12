package com.br.client.panel.fn.fnr0011.UI;

import java.util.Date;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.UI.UCFieldCentroCusto;
import com.br.client.panel.business.UI.UCFieldLookupBuscaCliente;
import com.howmake.client.form.UI.HowMGWTCheckboxItem;
import com.howmake.client.form.UI.HowMGWTDateItem;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class FiltroConsulta extends VLayout{

	private HowMGWTDateItem fieldDataInicio 	 = new HowMGWTDateItem("dataInicio" 		, Tradutor.i18n.periodoInicial());
	private UCFieldLookupBuscaCliente fieldCodigoCliente = new UCFieldLookupBuscaCliente();  
	private UCFieldCentroCusto fieldCentroCusto  = new UCFieldCentroCusto();
	private HowMGWTDateItem fieldDataFim	   	 = new HowMGWTDateItem("dataFim"    		, Tradutor.i18n.periodoFinal());
 	private HowMGWTCheckboxItem fieldImprimirDetalhes = new HowMGWTCheckboxItem("imprimirDetalhes" , Tradutor.i18n.formImprimirDetalhes() );
    
	public FiltroConsulta(){ 

		HLayout hLayoutDatas = new HLayout();
		hLayoutDatas.setWidth100();
		hLayoutDatas.setHeight("26px");
	
		fieldDataInicio.setWidth("280px");
		fieldDataFim.setWidth("280px");
		fieldImprimirDetalhes.setWidth("120px");
	
		hLayoutDatas.addMember(fieldDataInicio);
		hLayoutDatas.addMember(fieldDataFim);
		hLayoutDatas.addMember(fieldImprimirDetalhes);
 
		this.addMember(hLayoutDatas);
 
		HLayout hLayoutChecks = new HLayout();
		hLayoutDatas.setWidth100();
		hLayoutDatas.setHeight("26px");

		this.addMember(hLayoutChecks);

		// ---------------------------------------------------------------------------

		Date now = new Date();
		Date dataInicio = new Date(now.getYear(), now.getMonth(), 1);
		Date dataFim 	= now;

		this.fieldDataInicio.setHowMValue(dataInicio);
		this.fieldDataFim.setHowMValue(dataFim);
		this.fieldImprimirDetalhes.setHowMValue(new Boolean(true));
		HLayout filtrosAdicionais = new HLayout();
		
		filtrosAdicionais.setWidth100();
		filtrosAdicionais.setHeight(22);
		
		HowMGWTProperty property = new HowMGWTProperty("", "");
 
		fieldCodigoCliente.getField().setTitleWidth(100);
		fieldCodigoCliente.getField().getField().setWidth(60);
		fieldCodigoCliente.getMessageLabel().setWidth(140);
		fieldCodigoCliente.setWidth(300);
		
		filtrosAdicionais.addMember( fieldCodigoCliente );
		filtrosAdicionais.addMember( fieldCentroCusto.getCreateField() );
		
		this.addMember(filtrosAdicionais);
	}


	/**
	 * @return the fieldDataInicio
	 */
	public HowMGWTDateItem getFieldDataInicio() {
		return fieldDataInicio;
	}


	/**
	 * @param fieldDataInicio the fieldDataInicio to set
	 */
	public void setFieldDataInicio(HowMGWTDateItem fieldDataInicio) {
		this.fieldDataInicio = fieldDataInicio;
	}


	/**
	 * @return the fieldDataFim
	 */
	public HowMGWTDateItem getFieldDataFim() {
		return fieldDataFim;
	}


	/**
	 * @param fieldDataFim the fieldDataFim to set
	 */
	public void setFieldDataFim(HowMGWTDateItem fieldDataFim) {
		this.fieldDataFim = fieldDataFim;
	}


	/**
	 * @return the fieldImprimirDetalhes
	 */
	public HowMGWTCheckboxItem getFieldImprimirDetalhes() {
		return fieldImprimirDetalhes;
	}


	/**
	 * @param fieldImprimirDetalhes the fieldImprimirDetalhes to set
	 */
	public void setFieldImprimirDetalhes(HowMGWTCheckboxItem fieldImprimirDetalhes) {
		this.fieldImprimirDetalhes = fieldImprimirDetalhes;
	}


	/**
	 * @return the fieldCodigoCliente
	 */
	public UCFieldLookupBuscaCliente getFieldCodigoCliente() {
		return fieldCodigoCliente;
	}


	/**
	 * @param fieldCodigoCliente the fieldCodigoCliente to set
	 */
	public void setFieldCodigoCliente(UCFieldLookupBuscaCliente fieldCodigoCliente) {
		this.fieldCodigoCliente = fieldCodigoCliente;
	}


	/**
	 * @return the fieldCentroCusto
	 */
	public UCFieldCentroCusto getFieldCentroCusto() {
		return fieldCentroCusto;
	}


	/**
	 * @param fieldCentroCusto the fieldCentroCusto to set
	 */
	public void setFieldCentroCusto(UCFieldCentroCusto fieldCentroCusto) {
		this.fieldCentroCusto = fieldCentroCusto;
	}
}