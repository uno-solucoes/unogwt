package com.br.client.panel.fn.fnq0013.UI;

import java.util.LinkedHashMap;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.UI.UCFieldCentroCusto;
import com.howmake.client.form.UI.HowMGWTTextItem;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

public class FiltroConsulta  extends VLayout{ 
 
    
    private HowMGWTTextItem fieldCodigoOrcamento 	= new HowMGWTTextItem("codigoOrcamento", Tradutor.i18n.formCodOrcamento() );  
    private HowMGWTTextItem fieldNome   			= new HowMGWTTextItem("nome",   Tradutor.i18n.formNome()   );
    private HowMGWTProperty propertySituacao    	= new HowMGWTProperty("situacao", Tradutor.i18n.formSituacao() );
    
    private UCFieldCentroCusto fieldCentroCusto  = new UCFieldCentroCusto();

    private HTMLPane paneHelp           			= new HTMLPane();

    public FiltroConsulta(){
    	initUI();
    }
    
    public void initUI(){
 
    	paneHelp.setBorder(Tradutor.i18n.msgBorder());
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setContents(Tradutor.i18n.msgLookupHelp());
 
    	fieldCodigoOrcamento.setWidth100();
    	this.addMember(fieldCodigoOrcamento);
    	
    	fieldNome.setWidth100();
    	this.addMember(fieldNome);
    	
    	propertySituacao.setBound(100, 150);
    	propertySituacao.createHowMGWTFormFieldSelectItem();
    	LinkedHashMap<String, String> mapSituacao = new LinkedHashMap<String, String>();
    	mapSituacao.put("", "--");
    	mapSituacao.put("1", Tradutor.i18n.formEmElaboracao());
    	mapSituacao.put("2", Tradutor.i18n.formAprovado());
    	mapSituacao.put("3", Tradutor.i18n.formFinalizado());
    	propertySituacao.getHowMGWTEditorSelectItem().getField().setValueMap(mapSituacao);
    	
    	this.addMember(propertySituacao.getCanvas());
    	
    	fieldCentroCusto.setWidth(300);
    	this.addMember(fieldCentroCusto.getCreateField());
    	
    	paneHelp.setWidth100();
    	this.addMember(paneHelp);
    	
    }

	/**
	 * @return the paneHelp
	 */
	public HTMLPane getPaneHelp() {
		return paneHelp;
	}

	/**
	 * @param paneHelp the paneHelp to set
	 */
	public void setPaneHelp(HTMLPane paneHelp) {
		this.paneHelp = paneHelp;
	}
	
	
	public void clearFilters(){
	    fieldCodigoOrcamento.setHowMValue("");
	    fieldNome.setHowMValue("");
	}

	public HowMGWTTextItem getFieldCodigoOrcamento() {
		return fieldCodigoOrcamento;
	}

	public void setFieldCodigoOrcamento(HowMGWTTextItem fieldCodigoOrcamento) {
		this.fieldCodigoOrcamento = fieldCodigoOrcamento;
	}

	public HowMGWTTextItem getFieldNome() {
		return fieldNome;
	}

	public void setFieldNome(HowMGWTTextItem fieldNome) {
		this.fieldNome = fieldNome;
	}

	public HowMGWTProperty getPropertySituacao() {
		return propertySituacao;
	}

	public void setPropertySituacao(HowMGWTProperty propertySituacao) {
		this.propertySituacao = propertySituacao;
	}

	public UCFieldCentroCusto getFieldCentroCusto() {
		return fieldCentroCusto;
	}

	public void setFieldCentroCusto(UCFieldCentroCusto fieldCentroCusto) {
		this.fieldCentroCusto = fieldCentroCusto;
	}
	
	
}
