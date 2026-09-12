package com.howmake.client.form.model;

import com.google.gwt.user.client.Window;
import com.howmake.client.form.UI.HowMGWTWindowDocument;
import com.howmake.client.form.UI.HowMGWTWindowDocumentHTML;
import com.howmake.client.form.UI.HowMGWTWindowDocumentHTMLError;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.util.SC;

public class HowMGWTControl {
	
	public static final String FORM_TAREFA_POPULA 			= "50";
	public static final String FORM_TAREFA_MSG_HTML 		= "51";
	public static final String FORM_TAREFA_MSG_ALERT 		= "52";
	public static final String FORM_TAREFA_ERROS_HTML 		= "53";
	public static final String FORM_TAREFA_ERROS_ALERT 		= "54";
	public static final String FORM_TAREFA_ALERT_POPULA 	= "55";
	public static final String FORM_TAREFA_MSG_POPULA 		= "56";
	public static final String FORM_TAREFA_POS_POPULA 		= "59";

	public static boolean isRefreshFormShowMessage(HowMGWTFormBean bean){
		HowMGWTWindowWait.hideWait();
		if ( !HowMGWTUtilities.isEmpty(bean.getErro()) )
			Window.alert(bean.getErro());
			// SC.say(bean.getErro());
		
		else if ( !HowMGWTUtilities.isEmpty(bean.getMensagem()))
			Window.alert(bean.getMensagem());
			//SC.say(bean.getMensagem());
		
		return FORM_TAREFA_ERROS_ALERT.equals(bean.getTarefa()) || FORM_TAREFA_ERROS_HTML.equals(bean.getTarefa());
	}

	public static boolean isRefreshFormShowMessage(HowMGWTFormBean bean, boolean ajax){
		HowMGWTWindowWait.hideWait();

		if( "HowMERROR".equals( bean.getBarraControladora() )){
			HowMGWTWindowDocumentHTMLError.showDocument("<html><body><pre>"+bean.getErro()+"</pre></body></html>", bean.getErroDetail());	
			return true; 
		}

		if ( bean == null ){
			Window.alert("Retornou bean null, verifique junto ao administrador...");
		}
		if ( !HowMGWTUtilities.isEmpty(bean.getErro()) ){
			if ( ajax )
				SC.say(bean.getErro());
			else
				Window.alert(bean.getErro());
		}
		
		else if ( !HowMGWTUtilities.isEmpty(bean.getMensagem()))
			if ( ajax )
				SC.say(bean.getMensagem());
			else
				Window.alert(bean.getMensagem());
		
		return FORM_TAREFA_ERROS_ALERT.equals(bean.getTarefa()) || FORM_TAREFA_ERROS_HTML.equals(bean.getTarefa());
	}


}
