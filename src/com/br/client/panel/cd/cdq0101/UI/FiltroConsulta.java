package com.br.client.panel.cd.cdq0101.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.UI.UCFieldSituacaoCliente;
import com.howmake.client.form.UI.HowMGWTTextItem;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

public class FiltroConsulta  extends VLayout{ 
 
    
    private HowMGWTTextItem fieldCodigoCliente 		= new HowMGWTTextItem("codigoCliente", Tradutor.i18n.formCodigoCliente() );  
    private HowMGWTTextItem fieldNomeCliente   		= new HowMGWTTextItem("nomeCliente",   Tradutor.i18n.formNomeCliente()   );
    private UCFieldSituacaoCliente fieldSituacao    = new UCFieldSituacaoCliente();
    private HowMGWTTextItem fieldRazaoSocial   		= new HowMGWTTextItem("razaoSocial",   Tradutor.i18n.formRazaoSocial()   );
    private HowMGWTTextItem fieldObsContato    		= new HowMGWTTextItem("obsContato",    Tradutor.i18n.formObsContato()    );
    private HowMGWTTextItem fieldCNPJ				= new HowMGWTTextItem("cnpj",          Tradutor.i18n.formCnpj()          );
    private HTMLPane paneHelp           			= new HTMLPane();

    public FiltroConsulta(){
    	initUI();
    }
    
    public void initUI(){
 
    	paneHelp.setBorder(Tradutor.i18n.msgBorder());
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setContents(Tradutor.i18n.msgLookupHelp());
 
    	fieldCodigoCliente.setWidth100();
    	this.addMember(fieldCodigoCliente);
    	
    	fieldNomeCliente.setWidth100();
    	this.addMember(fieldNomeCliente);
    	
    	fieldSituacao.setWidth100();
    	this.addMember(fieldSituacao);
    	
    	fieldRazaoSocial.setWidth100();
    	this.addMember(fieldRazaoSocial);
    	
    	fieldObsContato.setWidth100();
    	this.addMember(fieldObsContato);
    	
    	paneHelp.setWidth100();
    	this.addMember(paneHelp);

    	
    	// Carrega os dados da lista.
    	fieldSituacao.start();
    }

	/**
	 * @return the fieldCodigoCliente
	 */
	public HowMGWTTextItem getFieldCodigoCliente() {
		return fieldCodigoCliente;
	}

	/**
	 * @param fieldCodigoCliente the fieldCodigoCliente to set
	 */
	public void setFieldCodigoCliente(HowMGWTTextItem fieldCodigoCliente) {
		this.fieldCodigoCliente = fieldCodigoCliente;
	}

	/**
	 * @return the fieldNomeCliente
	 */
	public HowMGWTTextItem getFieldNomeCliente() {
		return fieldNomeCliente;
	}

	/**
	 * @param fieldNomeCliente the fieldNomeCliente to set
	 */
	public void setFieldNomeCliente(HowMGWTTextItem fieldNomeCliente) {
		this.fieldNomeCliente = fieldNomeCliente;
	}

	/**
	 * @return the fieldSituacao
	 */
	public UCFieldSituacaoCliente getFieldSituacao() {
		return fieldSituacao;
	}

	/**
	 * @param fieldSituacao the fieldSituacao to set
	 */
	public void setFieldSituacao(UCFieldSituacaoCliente fieldSituacao) {
		this.fieldSituacao = fieldSituacao;
	}

	/**
	 * @return the fieldRazaoSocial
	 */
	public HowMGWTTextItem getFieldRazaoSocial() {
		return fieldRazaoSocial;
	}

	/**
	 * @param fieldRazaoSocial the fieldRazaoSocial to set
	 */
	public void setFieldRazaoSocial(HowMGWTTextItem fieldRazaoSocial) {
		this.fieldRazaoSocial = fieldRazaoSocial;
	}

	/**
	 * @return the fieldObsContato
	 */
	public HowMGWTTextItem getFieldObsContato() {
		return fieldObsContato;
	}

	/**
	 * @param fieldObsContato the fieldObsContato to set
	 */
	public void setFieldObsContato(HowMGWTTextItem fieldObsContato) {
		this.fieldObsContato = fieldObsContato;
	}

	/**
	 * @return the fieldCNPJ
	 */
	public HowMGWTTextItem getFieldCNPJ() {
		return fieldCNPJ;
	}

	/**
	 * @param fieldCNPJ the fieldCNPJ to set
	 */
	public void setFieldCNPJ(HowMGWTTextItem fieldCNPJ) {
		this.fieldCNPJ = fieldCNPJ;
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
	    
	    fieldCodigoCliente.setHowMValue("");
	    fieldNomeCliente.setHowMValue("");
	    fieldSituacao.setHowMValue("");
	    fieldRazaoSocial.setHowMValue("");
	    fieldObsContato.setHowMValue("");
	    fieldCNPJ.setHowMValue("");

	}
}
