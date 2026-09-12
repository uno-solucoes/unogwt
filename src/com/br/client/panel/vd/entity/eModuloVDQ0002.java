package com.br.client.panel.vd.entity;

import java.util.TreeMap;

import com.br.client.configuracao.entity.eModulo;
import com.howmake.client.form.partner.HowMGWTUtilities;

public class eModuloVDQ0002 extends eModulo{
	
	private String 			tipo;
	private boolean 		indBuscaAproximadaProduto;
	private boolean 		indBuscaMultiplaProduto;
	public static int     	PARAM_qtdCasasDecimaisQtdProduto	 		= 2;
	public static int 		PARAM_qtdCasasDecimaisPrecoUnitProduto		= 4;
	public static String    PARAM_TabelaPrecoPadrao						= "";

	private static TreeMap<String , Double> MAP_cotacoes					= new TreeMap<String, Double>();
	
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the indBuscaAproximadaProduto
	 */
	public boolean isIndBuscaAproximadaProduto() {
		return indBuscaAproximadaProduto;
	}
	/**
	 * @param indBuscaAproximadaProduto the indBuscaAproximadaProduto to set
	 */
	public void setIndBuscaAproximadaProduto(boolean indBuscaAproximadaProduto) {
		this.indBuscaAproximadaProduto = indBuscaAproximadaProduto;
	}
	/**
	 * @return the indBuscaMultiplaProduto
	 */
	public boolean isIndBuscaMultiplaProduto() {
		return indBuscaMultiplaProduto;
	}
	/**
	 * @param indBuscaMultiplaProduto the indBuscaMultiplaProduto to set
	 */
	public void setIndBuscaMultiplaProduto(boolean indBuscaMultiplaProduto) {
		this.indBuscaMultiplaProduto = indBuscaMultiplaProduto;
	}
 
	
	public static final TreeMap<String, Double> getMAPCotacoes(){
		if ( MAP_cotacoes.get("R$") == null )

			MAP_cotacoes.put("R$", new Double(1));
		
		return MAP_cotacoes;
	}
}
