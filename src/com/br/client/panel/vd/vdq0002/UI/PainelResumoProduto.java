package com.br.client.panel.vd.vdq0002.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.I18N.TradutorI18N;
import com.howmake.client.form.UI.HowMGWTLabel;
import com.howmake.client.form.UI.HowMGWTPanelSectionStack;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelResumoProduto extends VLayout{
	private HowMGWTLabel fieldCodigoProduto = new HowMGWTLabel();
	private PainelPrecoProduto precoProduto = new PainelPrecoProduto();
	private PainelUtimasVendasCliente ultimasVendasCliente = new PainelUtimasVendasCliente();
	private PainelGruposProduto gruposProduto = new PainelGruposProduto();
	private HowMGWTLabel descricaoTecnica = new HowMGWTLabel();
	
	private HowMGWTPanelSectionStack sessionVendasCliente;
	
	private String corpo;
	
	public PainelResumoProduto(String corpo){
		this.corpo = corpo;
		
		VLayout lCodigoProduto = new VLayout();
		lCodigoProduto.setWidth100();
		lCodigoProduto.setHeight(100);
		
		fieldCodigoProduto.setBackgroundColor(Tradutor.i18n.msgColor());
		
		fieldCodigoProduto.setContents(Tradutor.i18n.formCodProduto());
		lCodigoProduto.addMember(fieldCodigoProduto);
		this.addMember(lCodigoProduto);
		
		
		// -------------------------------------------------------------------
		precoProduto.setWidth100();
		final IButton actionPrecoProduto = new IButton(Tradutor.i18n.formPrecoProduto());
		actionPrecoProduto.setIcon("actions/opener_opened.png");
		actionPrecoProduto.setAlign(Alignment.LEFT);
					
		actionPrecoProduto.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				if( precoProduto.isVisible() ){
					precoProduto.setVisible(false);
					actionPrecoProduto.setIcon("actions/opener_opened.png");
			        if ( "0001".equals(PainelResumoProduto.this.corpo))
			        	sessionVendasCliente.setHeight("198");
			        else 
			        	sessionVendasCliente.setHeight("288");					
				}
				else{
					precoProduto.setVisible(true);
					actionPrecoProduto.setIcon("actions/opener_closed.png");
			        if ( "0001".equals(PainelResumoProduto.this.corpo))
			        	sessionVendasCliente.setHeight("110");
			        else 
			        	sessionVendasCliente.setHeight("200");					
				}
			}
		});
		actionPrecoProduto.setWidth100();
		actionPrecoProduto.setHeight("22px");
		precoProduto.setHeight("88px");
		// HowMGWTPanelSectionStack sessionPrecoProduto = new HowMGWTPanelSectionStack(Tradutor.i18n.formPrecoProduto(), precoProduto,true,false);
        // sessionPrecoProduto.setWidth100();
        // sessionPrecoProduto.setHeight("110");
   
		this.addMember(actionPrecoProduto);
		this.addMember(precoProduto);
		precoProduto.setVisible(false);
		
		// -------------------------------------------------------------------
		
		
		// -------------------------------------------------------------------
		ultimasVendasCliente.setWidth100();
        sessionVendasCliente = new HowMGWTPanelSectionStack(Tradutor.i18n.formUltimasVendasCliente(), ultimasVendasCliente);
        sessionVendasCliente.setWidth100();
        if ( "0001".equals(corpo))
          	sessionVendasCliente.setHeight("198");
        else 
        	sessionVendasCliente.setHeight("200");

        ultimasVendasCliente.setParentSession(sessionVendasCliente);
		this.addMember(sessionVendasCliente);
		// -------------------------------------------------------------------
		
        HowMGWTPanelSectionStack sessionDescricaoTecnica = new HowMGWTPanelSectionStack(Tradutor.i18n.formDescricaoTecnica(), descricaoTecnica);
        sessionDescricaoTecnica.setWidth100();
        sessionDescricaoTecnica.setHeight("90");   
        this.addMember(sessionDescricaoTecnica);
        
        if ( "0001".equals(corpo)){
	        gruposProduto.setWidth100();
	        gruposProduto.setHeight("90px");

	        this.addMember(gruposProduto);
        }     
        
	}

	/**
	 * @return the fieldCodigoProduto
	 */
	public HowMGWTLabel getFieldCodigoProduto() {
		return fieldCodigoProduto;
	}

	/**
	 * @param fieldCodigoProduto the fieldCodigoProduto to set
	 */
	public void setFieldCodigoProduto(HowMGWTLabel fieldCodigoProduto) {
		this.fieldCodigoProduto = fieldCodigoProduto;
	}

	/**
	 * @return the precoProduto
	 */
	public PainelPrecoProduto getPrecoProduto() {
		return precoProduto;
	}

	/**
	 * @param precoProduto the precoProduto to set
	 */
	public void setPrecoProduto(PainelPrecoProduto precoProduto) {
		this.precoProduto = precoProduto;
	}

	/**
	 * @return the ultimasVendasCliente
	 */
	public PainelUtimasVendasCliente getUltimasVendasCliente() {
		return ultimasVendasCliente;
	}

	/**
	 * @param ultimasVendasCliente the ultimasVendasCliente to set
	 */
	public void setUltimasVendasCliente(
			PainelUtimasVendasCliente ultimasVendasCliente) {
		this.ultimasVendasCliente = ultimasVendasCliente;
	}

	/**
	 * @return the gruposProduto
	 */
	public PainelGruposProduto getGruposProduto() {
		return gruposProduto;
	}

	/**
	 * @param gruposProduto the gruposProduto to set
	 */
	public void setGruposProduto(PainelGruposProduto gruposProduto) {
		this.gruposProduto = gruposProduto;
	}

	/**
	 * @return the descricaoTecnica
	 */
	public HowMGWTLabel getDescricaoTecnica() {
		return descricaoTecnica;
	}

	/**
	 * @param descricaoTecnica the descricaoTecnica to set
	 */
	public void setDescricaoTecnica(HowMGWTLabel descricaoTecnica) {
		this.descricaoTecnica = descricaoTecnica;
	}
}
