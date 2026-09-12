package com.br.client.configuracao;
 
import java.util.Date;

import com.br.client.configuracao.entity.eModulo;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.core.client.GWT;
import com.howmake.client.form.model.HOWMGWTDataSourceQuery;
import com.howmake.client.form.model.HowMGWTCall;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.util.SC;
 
public class Fabrica {

	public static final String DEFAULT_SELECT 				= "SELECT";
	public static final String NAVEGATE_ACTION_BUSCAR 		= "buscar";
	public static final String NAVEGATE_ACTION_CLOSE  		= "close";
	public static final String NAVEGATE_ACTION_FIRST 		= "first";
	public static final String NAVEGATE_ACTION_PREVIEW 		= "preview";
	public static final String NAVEGATE_ACTION_NEXT 		= "next";
	public static final String NAVEGATE_ACTION_LAST     	= "last";

	public static final String NAVEGATE_FLAG_MESSAGE    	= "flagMessage";
	public static final String NAVEGATE_FLAG_FIST_PAGE  	= "flagFirstPage";
	public static final String NAVEGATE_FLAG_PREVIEW_PAGE 	= "flagPreviewPage";
	public static final String NAVEGATE_FLAG_NEXT_PAGE		= "flagNextPage";
	public static final String NAVEGATE_FLAG_LAST_PAGE		= "flagLastPage";

	public static final String NAVEGATE_CACHE_ID 			= "cacheID";
	
	public static final String DEFAULT_EMPRESA				= "empresa";
	public static final String DEFAULT_COLABORADOR 			= "colaborador";
	public static final String DEFAULT_ACAO					= "acao";
	
	public static final String DEFAULT_REPORT_NAME			= "ReportName";	
	public static final String DEFAULT_REPORT_VISUALIZER	= "ReportVisualizer";		
	
	public static final String REPORT_EXPORT_PDF 	= "pdf";
	public static final String REPORT_EXPORT_HTML 	= "htm";
	public static final String REPORT_EXPORT_XHTML	= "html";
	public static final String REPORT_EXPORT_XLS  	= "xls";
	public static final String REPORT_EXPORT_PPT 	= "ppt";
	public static final String REPORT_EXPORT_DOC 	= "doc";
	public static final String REPORT_EXPORT_CSV 	= "csv";
	public static final String REPORT_EXPORT_XML	= "xml";
	
	
	
	/**
	 * @return Fabrica uma entidade e configura a empresa e o colaborador locado.
	 */
	public static HowMGWTEntity createEntity(){
		HowMGWTEntity entity = new HowMGWTEntity();
		
		entity.setUrl(Configuracao.getBaseUrlServices());
		
		HowMProperty colaborador = new HowMProperty(DEFAULT_COLABORADOR,Configuracao.getCodColaborador());
		entity.getParameters().put(colaborador.getName(), colaborador);
		
		HowMProperty empresa = new HowMProperty(DEFAULT_EMPRESA,Configuracao.getCodEmpresa());
		entity.getParameters().put(empresa.getName(), empresa);
		
		Date now = new Date();
		HowMProperty pCacheID       = new HowMProperty(NAVEGATE_CACHE_ID,GWT.getUniqueThreadId()+"_"+now.getTime());
		entity.getParameters().put(pCacheID.getName(), pCacheID);
		
		
		entity.setTimeout( 1000 * 160 );
 
		return entity;
	}

	public static HowMProperty createParameter(HowMGWTEntity entity, String name, Object value){
		HowMProperty parameter = null;
		
		if ( value == null )
			parameter = new HowMProperty(name, (Double)value);
			
		else if ( value instanceof Double )
			parameter = new HowMProperty(name, (Double)value);

		else if ( value instanceof Integer )
			parameter = new HowMProperty(name, (Integer)value);

		else if ( value instanceof Date )
			parameter = new HowMProperty(name, (Date)value);
		
		else if ( value instanceof String )
			parameter = new HowMProperty(name, (String)value);

		else if ( value instanceof Boolean )
			parameter = new HowMProperty(name, (Boolean)value);
		
		else 
			parameter = new HowMProperty(name, value.toString());		
	
		entity.getParameters().remove(name);
		entity.getParameters().put(name, parameter);
		return parameter;
	}
	
	/**
	 * Cria um objeto de parametro para emissão de relatórios.
	 * @param name Nome da Variável
	 * @param value Valor da Variável.
	 * @return retorna um objeto de parametro para execução de relatório.
	 */
	public static HowMProperty createReportParameter(HowMGWTEntity entity, String name , Object value){
		HowMProperty reportParameter = createParameter(entity, name, value);
		reportParameter.setType("REPORT");		
		return reportParameter;
	}
}