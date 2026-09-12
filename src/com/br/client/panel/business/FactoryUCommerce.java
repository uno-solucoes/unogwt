package com.br.client.panel.business;

import com.br.client.panel.business.UI.UCFieldLookupBuscaCliente;
import com.br.client.panel.business.UI.UCFieldLookupBuscaColaborador;
import com.br.client.panel.business.UI.UCFieldLookupBuscaFornecedor;
import com.br.client.panel.business.UI.UCFieldLookupBuscaPedido;
import com.br.client.panel.business.UI.UCFieldLookupBuscaProduto;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.smartgwt.client.widgets.Canvas;

public class FactoryUCommerce {

	private static int defaultHeight = 22;
	
	
	
	/**
	 * Cria componente de negocio Lookup Busca Cliente.
	 * @param property
	 * @return
	 */
	public static final Canvas createLookupBuscaProduto(HowMGWTProperty property){
		UCFieldLookupBuscaProduto lookupBuscaProduto = new UCFieldLookupBuscaProduto();
		
		property.setCanvas(lookupBuscaProduto);
		property.setFormField(lookupBuscaProduto.getField());		
		property.getCanvas().setHeight(defaultHeight);
		return lookupBuscaProduto;
	}
	
	/**
	 * Cria componente de negocio Lookup Busca Cliente.
	 * @param property
	 * @return
	 */
	public static final Canvas createLookupBuscaCliente(HowMGWTProperty property){
		UCFieldLookupBuscaCliente lookupBuscaCliente = new UCFieldLookupBuscaCliente();
		
		property.setCanvas(lookupBuscaCliente);
		property.setFormField(lookupBuscaCliente.getField());		
		property.getCanvas().setHeight(defaultHeight);
		return lookupBuscaCliente;
	}

	/**
	 * Cria componente de negocio Lookup Busca Vendedor.
	 * @param property
	 * @return
	 */
	public static final Canvas createLookupBuscaVendedor(HowMGWTProperty property){
		UCFieldLookupBuscaColaborador lookupBuscaColaborador = new UCFieldLookupBuscaColaborador();
		lookupBuscaColaborador.getField().getField().setTitle(property.getTitle());
		
		property.setCanvas(lookupBuscaColaborador);
		property.setFormField(lookupBuscaColaborador.getField());		
		property.getCanvas().setHeight(defaultHeight);
		return lookupBuscaColaborador;
	}
	
	/**
	 * Cria componente de negocio Lookup Busca Pedido Venda.
	 * @param property
	 * @return
	 */
	public static final Canvas createLookupBuscaPedido(HowMGWTProperty property){
		UCFieldLookupBuscaPedido lookupBuscaPedido = new UCFieldLookupBuscaPedido();
		
		property.setCanvas(lookupBuscaPedido);
		property.setFormField(lookupBuscaPedido.getField());
		property.getCanvas().setHeight(defaultHeight);
		return lookupBuscaPedido;
	}	
	
	public static final Canvas createLookupBuscaFornecedor(HowMGWTProperty property){

		UCFieldLookupBuscaFornecedor lookupBuscaFornecedor = new UCFieldLookupBuscaFornecedor();
		
		lookupBuscaFornecedor.setParentProperty(property);
		
		property.setCanvas(lookupBuscaFornecedor);
		property.setFormField(lookupBuscaFornecedor.getField());
		property.getCanvas().setHeight(defaultHeight);
		return lookupBuscaFornecedor;

		
	}
}
