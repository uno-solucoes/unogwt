package com.br.client.configuracao;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.howmake.client.HowMProxyService;
import com.howmake.client.HowMProxyServiceAsync;
import com.howmake.client.form.partner.HowMGWTUtilities;

public class Configuracao {
		
	private static String baseUrlServices;
	private static String codEmpresa;
	private static String tpPlanoConta;
	private static String codColaborador;
	private static HowMProxyServiceAsync proxyStruts; 

	
	/**
	 * @return Retorna o endereço absoluto do contexto onde serão executados os serviços de donwload
	 * GWT.
	 */
	public static native String getNativeUnoGWTSetValue(JavaScriptObject object, String fieldName) /*-{
	   var elementChange = object.document.getElementById(fieldName);
	   if ( elementChange != undefined ){
	   		return elementChange.value;
	   }
	   else{
	   	alert('Nao encontrou objeto : ' + fieldName );
	   }
	   return "";
	}-*/;	

	/**
	 * @return Retorna o endereço absoluto do contexto onde serão executados os serviços de donwload
	 * GWT.
	 */
	public static native void setNativeUnoGWTSetValue(JavaScriptObject object, String fieldName, String value) /*-{
	   var elementChange = object.document.getElementById(fieldName);
	   if ( elementChange != undefined ){
	   		elementChange.value = value;
	   }
	   else{
	   	alert('Nao encontrou objeto : ' + fieldName );
	   }
	}-*/;	

	/**
	 * @return Retorna o endereço absoluto do contexto onde serão executados os serviços de donwload
	 * GWT.
	 */
	public static native void setNativeUnoGWTSetInnerHTML(JavaScriptObject object, String fieldName, String value) /*-{
	   var elementChange = object.document.getElementById(fieldName);
	   if ( elementChange != undefined ){
	   		elementChange.innerHTML = value;
	   }
	   else{
	   	alert('Nao encontrou objeto' );
	   }
	}-*/;
	
	/**
	 * @return Retorna o endereço absoluto do contexto onde serão executados os serviços de donwload
	 * GWT.
	 */
	public static native void nativeUnoGWTInitializeGateway() /*-{
	   $wnd.unoGWTInitializeGateway(); // $wnd é um sinônimo para JSNI da 'window'
	  
	}-*/;	

	/**
	 * @return Retorna a URL de forma correta.
	 */
	public static String getNativeUnoUrlServiceStruts(){
		
		String url = Configuracao.getInternalNativeUnoUrlServiceStruts();

		if ( url.endsWith("//") )
			url = url.substring(0,url.length()-2);
		
		if ( url.endsWith("/") )
			url = url.substring(0,url.length()-1);
		
		
		return url+"/";
	}

	
	/**
	 * @return Retorna a URL de forma correta.
	 */
	public static String getNativeUnoUrlServiceDonwload(){
		String url = Configuracao.getInternalNativeUnoUrlServiceDonwload();

		if ( url.endsWith("//") )
			url = url.substring(0,url.length()-2);
		
		if ( url.endsWith("/") )
			url = url.substring(0,url.length()-1);


		return url;
	}
	
	/**
	 * @return Retorna o endereço absoluto do contexto onde serão executados os serviços de donwload
	 * GWT.
	 */
	private static native String getInternalNativeUnoUrlServiceStruts() /*-{
	  return $wnd.getUnoUrlServiceStruts(); // $wnd é um sinônimo para JSNI da 'window'
	  
	}-*/;	
	
	
	/**
	 * @return Retorna o endereço absoluto do contexto onde serão executados os serviços de donwload
	 * GWT.
	 */
	public static native String getInternalNativeUnoUrlServiceDonwload() /*-{
	  return $wnd.getUnoUrlServiceDonwload(); // $wnd é um sinônimo para JSNI da 'window'
	  
	}-*/;	
	
	
	/**
	 * @return Retorna o endereço absoluto do contexto onde serão executados os serviços 
	 * GWT.
	 */
	public static native String getNativeUnoUrlService() /*-{
	  return $wnd.getUnoUrlService(); // $wnd é um sinônimo para JSNI da 'window'
	  
	}-*/;	

	/**
	 * @return Retorna o código da empresa utilizada na sessão.
	 */
	private static native String getNativeUnoEmpresa() /*-{
	  return $wnd.getUnoEmpresa(); // $wnd é um sinônimo para JSNI da 'window'
	  
	}-*/;	
	
	/**
	 * @return Retorna o código do colaborador conectado.
	 */
	private static native String getNativeUnoColaborador() /*-{
	  return $wnd.getUnoColaborador(); // $wnd é um sinônimo para JSNI da 'window'
	  
	}-*/;	
	
	/**
	 * @return Retorna o código do colaborador conectado.
	 */
	private static native String getNativeUnoTpPlanoConta() /*-{
	  return $wnd.getUnoTpPlanoConta(); // $wnd é um sinônimo para JSNI da 'window'
	  
	}-*/;	
		
	public static native String getNativeUnoHelpGWT() /*-{
	  return $wnd.getUnoHelpGWT(); // $wnd é um sinônimo para JSNI da 'window'
	}-*/;
	
	public static native String getNativeUnoTituloGWT() /*-{
	  return $wnd.getUnoTituloGWT(); // $wnd é um sinônimo para JSNI da 'window'
	}-*/;
	
	public static native String getNativeUnoCorpoGWT() /*-{
	  return $wnd.getUnoCorpoGWT(); // $wnd é um sinônimo para JSNI da 'window'
	}-*/;
	
	public static native String getNativeUnoProgramaGWT() /*-{
	  return $wnd.getUnoProgramaGWT(); // $wnd é um sinônimo para JSNI da 'window'
	}-*/;

	
	public static native String getNativeUnoAcaoGWT() /*-{
	  return $wnd.getUnoAcaoGWT(); // $wnd é um sinônimo para JSNI da 'window'
	}-*/;


	public static String getUnoCorpoGWT(){
		if( ! HowMGWTUtilities.isEmpty( getNativeUnoCorpoGWT() ) ){
			String[] parts = getNativeUnoCorpoGWT().split(" ");
			return parts[0];
		}
		else{
			return "0001";
		}
	}
	
	
	public static String getUnoVersionGWT(){
		return getNativeUnoCorpoGWT().substring(getUnoCorpoGWT().length());
	}
	
	
	
	/**
	 * @return the baseUrlServices
	 */
	public static String getBaseUrlServices() {
		if ( baseUrlServices == null )
			baseUrlServices = GWT.getHostPageBaseURL()+".."+getInternalNativeUnoUrlServiceStruts();
		
		return baseUrlServices;

	}

	/**
	 * @param baseUrlServices the baseUrlServices to set
	 */
	public static void setBaseUrlServices(String baseUrlServices) {
		Configuracao.baseUrlServices = baseUrlServices;
	}

	/**
	 * @return the codEmpresa
	 */
	public static String getCodEmpresa() {
		if ( HowMGWTUtilities.isEmpty(codEmpresa))
			codEmpresa = getNativeUnoEmpresa();
		return codEmpresa;
	}

	/**
	 * @param codEmpresa the codEmpresa to set
	 */
	public static void setCodEmpresa(String codEmpresa) {
		Configuracao.codEmpresa = codEmpresa;
	}
	
	/**
	 * @return the tpPlanoConta
	 */
	public static String getTpPlanoConta() {
		if ( HowMGWTUtilities.isEmpty(tpPlanoConta))
			tpPlanoConta = getNativeUnoEmpresa();
		return tpPlanoConta;
	}

	/**
	 * @param tpPlanoConta the tpPlanoConta to set
	 */
	public static void setTpPlanoConta(String tpPlanoConta) {
		Configuracao.tpPlanoConta = tpPlanoConta;
	}

	/**
	 * @return the codColaborador
	 */
	public static String getCodColaborador() {
		if ( HowMGWTUtilities.isEmpty(codColaborador) )
			codColaborador = getNativeUnoColaborador();
		return codColaborador;
	}

	/**
	 * @param codColaborador the codColaborador to set
	 */
	public static void setCodColaborador(String codColaborador) {
		Configuracao.codColaborador = codColaborador;
	}
	
	public static final HowMProxyServiceAsync getProxyStruts(){
		if ( proxyStruts == null ){
			proxyStruts = GWT.create(HowMProxyService.class);	
			UnoRpcRequestBuilder rpcRequestBuider = new UnoRpcRequestBuilder();
			((ServiceDefTarget)proxyStruts).setRpcRequestBuilder(rpcRequestBuider);
		}
		return proxyStruts;
	}
}
