package com.br.client.model.fn.fnw0016.custom;
 
public class FormBean extends com.br.client.model.fn.fnw0016.FormBean{

	// Registros importantes
	public static final String SISTEMA_RESULTADO_OPERACIONAL_VENDAS_MERCADORIAS 					= "1";
	public static final String SISTEMA_RESULTADO_OPERACIONAL_OUTRAS_VENDAS 							= "2";
	public static final String SISTEMA_RESULTADO_OPERACIONAL_TOTAL_VENDAS 							= "3";
	public static final String SISTEMA_RESULTADO_OPERACIONAL_TOTAL_IMPOSTOS_CREDITO 				= "4";
	public static final String SISTEMA_RESULTADO_OPERACIONAL_TOTAL_IMPOSTOS_DEBITO 					= "5";	
	public static final String SISTEMA_RESULTADO_OPERACIONAL_TOTAL_IMPOSTOS 						= "6";
	public static final String SISTEMA_RESULTADO_OPERACIONAL_TOTAL_VENDAS_MENOS_IMPOSTOS 			= "7";
	public static final String SISTEMA_RESULTADO_OPERACIONAL_CUSTO_CMV								= "8";
	public static final String SISTEMA_RESULTADO_OPERACIONAL_TOTAL_VENDAS_MENOS_IMPOSTOS_MENOS_CMV	= "9";
	public static final String SISTEMA_RESULTADO_OPERACIONAL_DESPESAS 								= "10";
	public static final String SISTEMA_RESULTADO_OPERACIONAL_TOTAL_DESPESAS 						= "11";
	public static final String SISTEMA_RESULTADO_OPERACIONAL_RESULTADO 								= "12";
	
	// Relação de impostos calculados pelo sistema.
	public static final String SISTEMA_IMPOSTO_ICMS 												= "ICMS";
	public static final String SISTEMA_IMPOSTO_IPI 													= "IPI";
	public static final String SISTEMA_IMPOSTO_IR 													= "IR";
	public static final String SISTEMA_IMPOSTO_PIS 													= "PIS";
	public static final String SISTEMA_IMPOSTO_COFINS 												= "COFINS";
	public static final String SISTEMA_IMPOSTO_CSLL 												= "CSLL";
	public static final String SISTEMA_IMPOSTO_ICMSST 												= "ICMS ST";
	public static final String SISTEMA_IMPOSTO_ISS 													= "ISS";
	public static final String SISTEMA_IMPOSTO_ICMS_SUBSTITUICAO									= "ICMS Substituicao";
	public static final String SISTEMA_IMPOSTO_SIMPLES_NACIONAL										= "Simples Nacional";
	
	
	public String[] todosImpostos = new String[]{
			SISTEMA_IMPOSTO_ICMS,
			SISTEMA_IMPOSTO_IPI,
			SISTEMA_IMPOSTO_IR,
			SISTEMA_IMPOSTO_PIS,
			SISTEMA_IMPOSTO_COFINS,
			SISTEMA_IMPOSTO_CSLL,
			SISTEMA_IMPOSTO_ICMSST,
			SISTEMA_IMPOSTO_ISS,
			SISTEMA_IMPOSTO_ICMS_SUBSTITUICAO,
			SISTEMA_IMPOSTO_SIMPLES_NACIONAL
	};
	
	public static String[] impostosLucroReal 		= new String[]{
			SISTEMA_IMPOSTO_ICMS,
			SISTEMA_IMPOSTO_IPI,
			SISTEMA_IMPOSTO_IR,
			SISTEMA_IMPOSTO_PIS,
			SISTEMA_IMPOSTO_COFINS,
			SISTEMA_IMPOSTO_CSLL
	};

	public static String[] impostosLucroPresumido 	= new String[]{
			SISTEMA_IMPOSTO_ICMS,
			SISTEMA_IMPOSTO_IPI,
			SISTEMA_IMPOSTO_IR,
			SISTEMA_IMPOSTO_PIS,
			SISTEMA_IMPOSTO_COFINS,
			SISTEMA_IMPOSTO_CSLL
	};

	public static String[] impostosSimplesNacional	= new String[]{
		SISTEMA_IMPOSTO_SIMPLES_NACIONAL
	};

	/**
	 * @return the todosImpostos
	 */
	public String[] getTodosImpostos() {
		return todosImpostos;
	}

	/**
	 * @param todosImpostos the todosImpostos to set
	 */
	public void setTodosImpostos(String[] todosImpostos) {
		this.todosImpostos = todosImpostos;
	}

	/**
	 * @return the impostosLucroReal
	 */
	public String[] getImpostosLucroReal() {
		return impostosLucroReal;
	}

	/**
	 * @param impostosLucroReal the impostosLucroReal to set
	 */
	public void setImpostosLucroReal(String[] impostosLucroReal) {
		this.impostosLucroReal = impostosLucroReal;
	}

	/**
	 * @return the impostosLucroPresumido
	 */
	public String[] getImpostosLucroPresumido() {
		return impostosLucroPresumido;
	}

	/**
	 * @param impostosLucroPresumido the impostosLucroPresumido to set
	 */
	public void setImpostosLucroPresumido(String[] impostosLucroPresumido) {
		this.impostosLucroPresumido = impostosLucroPresumido;
	}

	/**
	 * @return the impostosSimplesNacional
	 */
	public String[] getImpostosSimplesNacional() {
		return impostosSimplesNacional;
	}

	/**
	 * @param impostosSimplesNacional the impostosSimplesNacional to set
	 */
	public void setImpostosSimplesNacional(String[] impostosSimplesNacional) {
		this.impostosSimplesNacional = impostosSimplesNacional;
	}

}