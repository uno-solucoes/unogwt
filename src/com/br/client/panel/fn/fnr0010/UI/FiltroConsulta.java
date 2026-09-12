package com.br.client.panel.fn.fnr0010.UI;

import java.util.Date;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.UI.UCFieldLookupBuscaCliente;
import com.br.client.panel.business.UI.UCFieldLookupBuscaFornecedor;
import com.howmake.client.form.UI.HowMGWTCheckboxItem;
import com.howmake.client.form.UI.HowMGWTDateItem;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class FiltroConsulta extends VLayout{ 

	private HowMGWTDateItem fieldDataInicio 	 = new HowMGWTDateItem("dataInicio" 		, Tradutor.i18n.periodoInicial());
	private HowMGWTDateItem fieldDataFim	   	 = new HowMGWTDateItem("dataFim"    		, Tradutor.i18n.periodoFinal());
	private UCFieldLookupBuscaFornecedor fieldCodigoFornecedor = new UCFieldLookupBuscaFornecedor();  
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
		
		this.addMember( fieldCodigoFornecedor );
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
	 * @return the fieldCodigoFornecedor
	 */
	public UCFieldLookupBuscaFornecedor getFieldCodigoFornecedor() {
		return fieldCodigoFornecedor;
	}


	/**
	 * @param fieldCodigoFornecedor the fieldCodigoFornecedor to set
	 */
	public void setFieldCodigoFornecedor(
			UCFieldLookupBuscaFornecedor fieldCodigoFornecedor) {
		this.fieldCodigoFornecedor = fieldCodigoFornecedor;
	}
}