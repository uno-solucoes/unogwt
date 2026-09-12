package com.howmake.client.form.model;

import com.br.client.configuracao.Configuracao;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.util.SC;

/** 
 * @author Julio P. Leiser
 * Data : 10/09/2011 - 14:00
 * Classe responsavel por estabelecer um meio de comunicação entre GWT e Struts,
 * torna transparente o envio e a recepção de dados entre a camada de 
 * visualização(Browser) de dados e a camada servidora(Struts)
 */
public abstract class HowMGWTPlugInStruts {

	HowMGWTFormBean currentFormBean;
	private String currentFormBeanName;
	private boolean gwtCheckSecurity;
 
	
	public HowMGWTPlugInStruts(HowMGWTFormBean formBean){
		this.currentFormBean = formBean;
	}
	
	public void requestFormBean(String action, String formBeanName){
		this.request(action+".do?method=gwtTransport", formBeanName , "");
	}

	long startTimeExecute;

	static int execute = 0;
	
	public void request(String action, String formBeanName , String body){
		currentFormBeanName = formBeanName;
		
		startTimeExecute = System.currentTimeMillis();

		System.out.println("Executando "+formBeanName + " - " + (++execute));
		
		try{   
			
			String security = "";
			if ( this.isGwtCheckSecurity() ){
				security = "&GWT_CHECK_SECURITY="+this.isGwtCheckSecurity();
			}
			
			RequestBuilder request = new RequestBuilder(RequestBuilder.POST, Configuracao.getNativeUnoUrlServiceStruts()+action+"&GWTJSON=true"+security+"&GWTFORM="+currentFormBeanName);
    		RequestCallback callback = new RequestCallback() {
    			// ---------------------------------------------------------------------------
    			// Detecta os dados processados no servidor.
    			// ---------------------------------------------------------------------------
    			@Override
				public void onResponseReceived(Request request, Response response) {
    				String json = response.getText();
    				
    				System.out.println( "JSON: " + json );
			
					Long finishTimeExecute = System.currentTimeMillis() - startTimeExecute;
					
					System.out.println("Tempo execu��o busca dados do servidor : "+finishTimeExecute);
					
					if ( json != null ){

						// Verifica se processou JSON ou se houve algum problema no processamento no 
						// servidor.
						if ( json.toUpperCase().startsWith("<HTML") 
							 || 
							 ( json.toUpperCase().indexOf("<HTML") >= 0 && json.toUpperCase().indexOf("</HTML>") >= 0 )
						){
							HowMGWTWindowWait.hideWait();


							if ( json.indexOf("Acesso Negado ao programa") >=0)
								onNoAccess();
							
							SC.say(json);
							return;
						}
						System.out.println("Passo 2");

						// Verifica se retornou Conteudo Application/JSON.
						int idx = json.indexOf("{");
						int lidx= json.lastIndexOf("}");
						if ( idx >= 0 ){											
							// Faz o parser do conteudo retornado no servidor.
							JSONValue value = JSONParser.parseStrict(json.substring(idx,lidx+1));
							// Converte o conteudo JSON(JavaScript) para objeto Java GWT.
							long startTime = System.currentTimeMillis();
							currentFormBean.load(null, value);
							
							long dif = System.currentTimeMillis() - startTime;
							System.out.println("Tempo processamento : "+dif);
						
							// Devolve o formulório recuperado do servidor para o objeto chamador.
							onResponse(currentFormBean);						
						}
						// Emite uma mensagem para o usuório caso nenhuma das alternativas acima 
						// tenha sido detectada.
						else{
							HowMGWTWindowWait.hideWait();
							if ( HowMGWTUtilities.isEmpty( json ) ){
								System.out.println("Passo 7:\n"+json);
								Window.alert("Web Services retornou JSON null, verifique Framework Howmake Server... Entre em contato com o arquiteto do software.");
							}
							if ( json.indexOf("Acesso Negado ao programa") >=0)
								onNoAccess();
							
							SC.say(json);
							return;							
						}
					}
					// Se cair nesta situação, erro não detectado durante o processo de desenvolvimento.
					// em teoria não deveria ocorrer está situação, caso ocorra, é porque não está sendo
					// utilizado corretamte este plug-in.
					else{
						System.out.println("Erro ao executar a requisição no servidor.");
						onResponse(json);
					}
				}
				@Override
				public void onError(Request request, Throwable exception) {
					HowMGWTWindowWait.hideWait();
					HowMGWTPlugInStruts.this.onError(exception);
				}
			};
			// ---------------------------------------------------------------------------
			// Configura o Header para comunicação com o servidor.
			// ---------------------------------------------------------------------------
			if ( body.length() > 0 ){
				// request.setHeader("Content-type", "multipart/form-data");
				// application/json-rpc
				request.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");		
				
				body = HowMGWTUtilities.replace( body ,"&" , "#{38}");
				body = HowMGWTUtilities.replace( body ,"%" , "#{37}");
				body = HowMGWTUtilities.replace( body ,"+" , "#{43}");
				body = HowMGWTUtilities.replace( body ,"�" , "-");

				body = URL.encode(body);
			}
    		request.setHeader("Content-Length", ""+body.length());
    		request.setHeader("Expires", "-1");
    		request.setHeader("Cache-Control", "no-cache");
    		request.setHeader("Pragma", "no-cache");            	
 
    		request.sendRequest(body, callback);
    	}
    	catch(Throwable e){
    		HowMGWTWindowWait.hideWait();
    		e.printStackTrace();
    		onError(e);
    	}
	}
	
	public void onNoAccess(){}

	public abstract void onResponse(HowMGWTFormBean formBean);
	public void onResponse(String page){}
	
	public void onError(Throwable err){
		err.printStackTrace();
		Window.alert("Erro :"+err.getMessage());
	}

	/**
	 * @return the gwtCheckSecurity
	 */
	public boolean isGwtCheckSecurity() {
		return gwtCheckSecurity;
	}

	/**
	 * @param gwtCheckSecurity the gwtCheckSecurity to set
	 */
	public void setGwtCheckSecurity(boolean gwtCheckSecurity) {
		this.gwtCheckSecurity = gwtCheckSecurity;
	}
 
	
// Exemplo original da ideia.	
//	try{
//	
//	RequestBuilder request = new RequestBuilder(RequestBuilder.POST,"/Desenv/vdw0001.do?method=verificarBeneficiario&GWTJSON=true");
//	RequestCallback callback = new RequestCallback() {
//		@Override
//		public void onResponseReceived(Request request, Response response) {
//			String json = response.getText();
//			if ( json != null ){
//
//				int idx = json.indexOf("{");
//				int lidx= json.lastIndexOf("}");
//				if ( idx >= 0 ){
//					System.out.println("---------------------------------------------------------------------------------------------");
//					System.out.println("JSON:\n"+json.substring(idx,lidx+1));
//					System.out.println("---------------------------------------------------------------------------------------------");							
//
//					JSONValue value = JSONParser.parseStrict(json.substring(idx,lidx+1));
//					com.br.client.model.vd.vdw0001.FormBean formBean = new com.br.client.model.vd.vdw0001.FormBean();
//					formBean.load(null, value);
//					
//					if ( formBean.getItensPedido() != null ){
//						System.out.println("Itens : "+formBean.getItensPedido().length);
//					}	
//					if ( formBean.getServicosPedido() != null ){
//						System.out.println("Servicos : "+formBean.getServicosPedido().length);										
//						for (  eItemPedido servico : formBean.getServicosPedido()){
//							System.out.println("--------------------------------------------------------------------------");
//							System.out.println("["+servico.getCodProduto()+"]");
//							System.out.println( servico.toPrint() );
//						}
//
//					}
//					
//					System.out.println("Codigo Pedido     : "+formBean.getCodPedido());
//					System.out.println("Nome do Cliente   : "+formBean.getNomeCliente());
//					System.out.println("Codigo Cliente    : "+formBean.getCodCliente());
//					System.out.println("Corpo             : "+formBean.getCorpo());
//					System.out.println("Tarefa            : "+formBean.getTarefa());
//					System.out.println("Barra Controladora: "+formBean.getBarraControladora());
//					System.out.println("Erro              : "+formBean.getErro());
//					System.out.println("Mensagem          : "+formBean.getMensagem());
//					System.out.println("Endereco          : "+formBean.getEndereco());
//				}
//			}
//			System.out.println("Header : "+response.getHeadersAsString());
//		}
//		
//		@Override
//		public void onError(Request request, Throwable exception) {
//			exception.printStackTrace();
//		}
//	};
//	// -----------------------------------------------------
//	// Configura o Header a requisição
//	// -----------------------------------------------------
//	String body = "";
//	// http-equiv="content-type" content="text/html; charset=iso-8859-1"
////	request.setHeader("Content-Type", "application/json; charset=utf-8");
////	request.setHeader("Content-Type", "application/json; charset=iso-8859-1"); //"text/javascript");
////	request.setHeader("Accept",       "application/json; charset=iso-8859-1");
//	request.setHeader("Content-Length", ""+body.length());
//	request.setHeader("Expires", "-1");
//	request.setHeader("Cache-Control", "no-cache");
//	request.setHeader("Pragma", "no-cache");            	
//
//	request.sendRequest(body, callback);
//}
//catch(Throwable e){
//	e.printStackTrace();
//}
	
}
