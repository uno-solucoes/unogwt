package com.br.client.panel.vd.vdq0001.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.UI.UCFieldLookupBuscaCliente;
import com.br.client.panel.business.UI.UCFieldSituacaoCliente;
import com.br.client.panel.business.UI.UCFieldSituacaoPedido;
import com.howmake.client.form.UI.HowMGWTTextItem;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.layout.VLayout;

public class FiltroConsulta  extends VLayout{ 
 
	private HowMGWTTextItem fieldPedidoVenda   					= new HowMGWTTextItem("pedidoVenda",   Tradutor.i18n.formPedido() );
	   
	   
    private UCFieldLookupBuscaCliente fieldCodigoCliente 		= new UCFieldLookupBuscaCliente();  
    private UCFieldSituacaoPedido fieldSituacao    				= new UCFieldSituacaoPedido();
    private HowMGWTTextItem fieldRazaoSocial   					= new HowMGWTTextItem("razaoSocial",   Tradutor.i18n.formRazaoSocial() );
    
    private HowMGWTTextItem fieldCodVendedor   					= new HowMGWTTextItem("codVendedor",   	Tradutor.i18n.formCodVendedor() );
    private HowMGWTTextItem fieldPedidoVendedor   				= new HowMGWTTextItem("PedidoVendedor", Tradutor.i18n.formPedidoVendedor() );
    private HowMGWTTextItem fieldPedidoComprador  				= new HowMGWTTextItem("PedidoComprador",Tradutor.i18n.formPedidoComprador() );

 
    private HTMLPane paneHelp           						= new HTMLPane();
    
    public FiltroConsulta(){
    	initUI();
    }
    
    public void initUI(){
 
    	this.setHeight("220px");
    	
    	paneHelp.setBorder(Tradutor.i18n.msgBorder());
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setContents(Tradutor.i18n.msgLookupHelp());
 
    	
    	fieldPedidoVenda.setWidth100();
    	this.addMember(fieldPedidoVenda);
    	
    	fieldCodigoCliente.setWidth100();
    	this.addMember(fieldCodigoCliente);
    
    	fieldSituacao.setWidth100();
    	this.addMember(fieldSituacao);
    	
    	fieldRazaoSocial.setWidth100();

    	this.addMember(fieldRazaoSocial);
 
 
    	fieldCodVendedor.setWidth100();
    	this.addMember(fieldCodVendedor);
    	
    	fieldPedidoVendedor.setWidth100();
    	this.addMember(fieldPedidoVendedor);
    	
    	fieldPedidoComprador.setWidth100();
    	this.addMember(fieldPedidoComprador);    	
    	
    	paneHelp.setWidth100();
    	this.addMember(paneHelp);

    	
    	// Carrega os dados da lista.
    	fieldSituacao.start();
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
	 * @return the fieldSituacao
	 */
	public UCFieldSituacaoPedido getFieldSituacao() {
		return fieldSituacao;
	}

	/**
	 * @param fieldSituacao the fieldSituacao to set
	 */
	public void setFieldSituacao(UCFieldSituacaoPedido fieldSituacao) {
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
	 * @return the fieldCodVendedor
	 */
	public HowMGWTTextItem getFieldCodVendedor() {
		return fieldCodVendedor;
	}

	/**
	 * @param fieldCodVendedor the fieldCodVendedor to set
	 */
	public void setFieldCodVendedor(HowMGWTTextItem fieldCodVendedor) {
		this.fieldCodVendedor = fieldCodVendedor;
	}

	/**
	 * @return the fieldPedidoVendedor
	 */
	public HowMGWTTextItem getFieldPedidoVendedor() {
		return fieldPedidoVendedor;
	}

	/**
	 * @param fieldPedidoVendedor the fieldPedidoVendedor to set
	 */
	public void setFieldPedidoVendedor(HowMGWTTextItem fieldPedidoVendedor) {
		this.fieldPedidoVendedor = fieldPedidoVendedor;
	}

	/**
	 * @return the fieldPedidoComprador
	 */
	public HowMGWTTextItem getFieldPedidoComprador() {
		return fieldPedidoComprador;
	}

	/**
	 * @param fieldPedidoComprador the fieldPedidoComprador to set
	 */
	public void setFieldPedidoComprador(HowMGWTTextItem fieldPedidoComprador) {
		this.fieldPedidoComprador = fieldPedidoComprador;
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

	/**
	 * @return the fieldPedidoVenda
	 */
	public HowMGWTTextItem getFieldPedidoVenda() {
		return fieldPedidoVenda;
	}
 
}
