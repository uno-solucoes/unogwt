package com.howmake.client.form.partner;


import java.util.Date;
import java.util.TreeMap;

import com.br.client.configuracao.Configuracao;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.howmake.client.form.UI.HowMGWTLabel;
import com.howmake.client.form.UI.HowMGWTWindowDocumentHTML;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.shared.HowMGWTEntity;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


public class HowMGWTUtilities {

	public static final int ACTION_BUTTON_NONE							= 0;
	public static final int ACTION_BUTTON_NEW_ITEM						= 1;
	public static final int ACTION_BUTTON_NEW_SUB_ITEM					= 2;
	
	public static final String PAGE_FIELD_NAME 							= "pageData";
	public static final String PAGE_FIELD_NAME_SUMMARY					= "pageSummary";

    public static final String NAVEGATE_EXECUTE  						= "EXECUTE";
    public static final String NAVEGATE_FIRST 	 						= "FIRST";
    public static final String NAVEGATE_PREVIOUS 						= "PREVIOUS";
    public static final String NAVEGATE_NEXT 	 						= "NEXT";
    public static final String NAVEGATE_LAST 	 						= "LAST";
    public static final String NAVEGATE_NOT_FOUND						= "NOT-FOUND";
	
	public static final int OPERATION_INSERT = 1;
    public static final int OPERATION_UPDATE = 2;
    public static final int OPERATION_DELETE = 3;
    public static final int OPERATION_QUERY  = 4;  
    
	public static String backgroundSeparadora 	= "rgb(30,144,255)";
    
	private static TreeMap<String,String> meses = new TreeMap<String,String>();
		
	public static TreeMap<String,String>  getMeses(){
		if ( meses.size() == 0 ){
			
			meses.put("01", Tradutor.i18n.formJaneiro());
			meses.put("02", Tradutor.i18n.formFevereiro());
			meses.put("03", Tradutor.i18n.formMarco());
			meses.put("04", Tradutor.i18n.formAbril());
			meses.put("05", Tradutor.i18n.formMaio());
			meses.put("06", Tradutor.i18n.formJunho());
			meses.put("07", Tradutor.i18n.formJulho());
			meses.put("08", Tradutor.i18n.formAgosto());
			meses.put("09", Tradutor.i18n.formSetembro());
			meses.put("10", Tradutor.i18n.formOutubro());
			meses.put("11", Tradutor.i18n.formNovembro());
			meses.put("12", Tradutor.i18n.formDezembro());			
		}
		return meses;
	}

	public static String getMesAbrev(String mes){
		return getMeses().get(strZero(getInteger(mes)+1,2));
	}
	
	
	
    public final static String getRPad(String text, String complete, int length) {
        int i = 0;
        // Remove os espaços em branco a esquerda.
        for (; i < text.length(); i++) {
              if (text.charAt(i) == ' ') {
                    continue;
              } else {
                    break;
              }
        }
        // Verifica se a posição do último espaço em branco é menor
        // que o tamanho do texto.
        if (i > 0 && i < text.length()) // Pega somente o texto a partir do último espaço em branco
        // encontrado.
        {
              text = text.substring(i);
        }

        // Verifica se há diferença no tamanho definido pelo usuário e o
        // texto que está sendo analisado.
        int diflen = length - text.length();
        // Se houver diferença completa a diferença com o complete definido
        // pelo usuário para ser preenchido a esquerda.
        if (diflen > 0) {
              String difText = "";
              for (int j = 0; j < diflen; j++) {
                    difText += complete;
              }
              text = difText + text + "  ";
        }
        text = text.substring(0, length);
        return text;
  }

  public final static String getLPad(String text, String complete, int length) {
        int i = text.length() - 1;
        // Remove os espaços em branco a esquerda.
        for (; i >= 0; i--) {
              if (text.charAt(i) == ' ') {
                    continue;
              } else {
                    break;
              }
        }
        // Verifica se a posição do último espaço em branco é menor
        // que o tamanho do texto.
        if (i > 0 && i < text.length()) // Pega somente o texto a partir do último espaço em branco
        // encontrado.
        {
              text = text.substring(0, i + 1);
        }

        // Verifica se há diferença no tamanho definido pelo usuário e o
        // texto que está sendo analisado.
        int diflen = length - text.length();
        // Se houver diferença completa a diferença com o complete definido
        // pelo usuário para ser preenchido a esquerda.
        if (diflen > 0) {
              String difText = "";
              for (int j = 0; j < diflen; j++) {
                    difText += complete;
              }
              text = text + difText + "  ";
        }
        text = text.substring(0, length);
        return text;
  }
  
  

  public final static String getHTMLLPad(String text, String complete, int length) {
      int i = text.length() - 1;
      // Remove os espaços em branco a esquerda.
      for (; i >= 0; i--) {
            if (text.charAt(i) == ' ') {
                  continue;
            } else {
                  break;
            }
      }
      // Verifica se a posição do último espaço em branco é menor
      // que o tamanho do texto.
      if (i > 0 && i < text.length()) // Pega somente o texto a partir do último espaço em branco
      // encontrado.
      {
            text = text.substring(0, i + 1);
      }

      // Verifica se há diferença no tamanho definido pelo usuário e o
      // texto que está sendo analisado.
      int diflen = length - text.length();
      // Se houver diferença completa a diferença com o complete definido
      // pelo usuário para ser preenchido a esquerda.
      if (diflen > 0) {
            String difText = "";
            for (int j = 0; j < diflen; j++) {
                  difText += complete;
            }
            text = text + difText;
      }
      return text;
}  
  
  
	public static  boolean isEmpty(Object valor){
		if ( valor == null || valor.toString().trim().length() == 0 ||  valor.toString().trim().equalsIgnoreCase( "null" )){
			return true;
		}
		else{
			return false;
		}
	}   
	
	
	public static boolean isEquals(Object source, Object target){
		if ( isEmpty(source)  && isEmpty(target) )
			return true;
					
		if ( source != null && source.toString().trim().equals(getString(target)))
			return true;
		
		if ( target != null && target.toString().trim().equals(getString(source)))
			return true;
		
		return false;
	}
	
	public static String getString(Object value){
		if ( isEmpty(value))
			return "";
		else
			return value.toString().trim();
	}	


    /**
     * Retorna um texto tabulado conforme tabulação informada.
     * @param tabs
     * @return
     */
    public static final String getSpaces(int tabs){
  	  String tab = "";
  	  for ( int i = 0 ; i < tabs ; i ++ ){
  		  tab += " ";
  	  }
  	  return tab;
    }	
  
    /**
     * Retorna um texto tabulado conforme tabulação informada.
     * @param tabs
     * @return
     */
    public static final String getTabulation(int tabs){
  	  String tab = "";
  	  for ( int i = 0 ; i < tabs ; i ++ ){
  		  tab += "\t";
  	  }
  	  return tab;
    }
	/**
	 * Substitui um texto por outro dentro de uma cadeia de caracteres.
	 * @param str cadeia original.
	 * @param pattern cadeia a ser substituída.
	 * @param replace cadeia a ser usada na substituição.
	 * @return cadeia de caracteres com <code>str</code>, onde <code>pattern</code> foi
	 * substituído por <code>replace</code>.
	 */
	public static String replace(String str, String pattern, String replace) {
	
	      int s = 0;
	      int e = 0;
	      StringBuffer result = new StringBuffer();
	      if (pattern == null || pattern.equals("")) {
	            return str;
	      }
	
	      while ((e = str.indexOf(pattern, s)) >= 0) {
	            result.append(str.substring(s, e));
	            result.append(replace);
	            s = e + pattern.length();
	      }
	      result.append(str.substring(s));
	      return result.toString();
	}
	
	
	

    /**
     * Transforma um string em um float.
     * @param text string com o valor a ser convertido.
     * @return string convertido para float ou 0 em caso de impossibilidade de conversão.
     */
    public static float getFloat(String text) {
          try {
                Float temp = Float.valueOf(text);
                return temp.floatValue();
          } catch (Exception err) {
                return 0.0F;
          }
    }
    
    public static Double getDoubleToBD(String text){
    	if ( HowMGWTUtilities.isEmpty(text))
    		return 0.0;
    	
    	if ( text.indexOf(",") >=0 )
    		return getDouble( replace(text.trim(), ".",""));
    	else
    		return getDouble( text.trim());
    }

    public static double getDouble(String text) {
    	if ( HowMGWTUtilities.isEmpty(text))
    		return 0.00;
    	
    	try{
		  	if ( text.indexOf(",") >= 0 ){
		  		text = replace(text, ".", "");
		  		text = replace(text, ",", ".");
		  	}
	        
		  	Double temp = Double.valueOf(text);
	        
		  	return temp.doubleValue();
    	}
    	catch(Throwable err){
    		return 0.00;
    	}
    }	

    public static Integer getObjectInteger(String text) {
        try {
              text = text.replace(',', '.');
              Double temp = Double.valueOf(text);
              return temp.intValue();
        } catch (Exception err) {
              return null;
        }
  }	    
    
    public static Double getObjectDouble(String text) {
        try {
              text = text.replace(',', '.');
              Double temp = Double.valueOf(text);
              return temp.doubleValue();
        } catch (Exception err) {
              return null;
        }
  }	    

    /**
     * Retorna um objeto data a partir de uma String com data no formato long
     * @param textLong
     * @return
     */
    public static Date getDateFromLong(Long textLong){
    	if ( isEmpty(textLong))
    		return (Date)null;

    	try{
    		return new Date(new Long(textLong));
    	}
    	catch(Throwable er){
    	}
    	return (Date)null;
    }
    
    
    /**
     * Retorna um objeto data a partir de uma String com data no formato long
     * @param textLong
     * @return
     */
    public static Date getDateFromLong(String textLong){
    	if ( isEmpty(textLong))
    		return (Date)null;

    	try{
    		return new Date(new Long(textLong));
    	}
    	catch(Throwable er){
    	}
    	return (Date)null;
    }

    
    /**
     * Transforma um string em um int.
     * @param text string com o valor a ser convertido.
     * @return string convertido para int ou 0 em caso de impossibilidade de conversão.
     */
    public static double getDouble(Object text) {
          if ( isEmpty( text ))
        	  return 0.0;
           return getDouble(text.toString());
    }  
    
	/**
	 * Transforma um string em um int.
	 * 
	 * @param text
	 *            string com o valor a ser convertido.
	 * @return string convertido para int ou 0 em caso de impossibilidade de
	 *         conversao.
	 */
	public static double getDouble(Object text, boolean checkMoeda) {
		if (isEmpty(text))
			return 0.0;
		try {

			if (text.toString().indexOf(",") >= 0) {
				text = replace(text.toString(), ".", "");
				text = replace(text.toString(), ",", ".");
			}			

			if( checkMoeda ){
				String numbers = "";
				char[] charText = text.toString().toCharArray();
				for( char c : charText ){
					if ( (int)c == 46 )
						numbers += ""+c;
					
					if ( (int)c >= 48 && (int)c <= 57 )
						numbers += ""+c;
				}
				text = numbers;
			}
			
			Double temp = Double.valueOf(text.toString());
			return temp.doubleValue();
		} catch (Throwable err) {
			return 0.0;
		}
	}    
    
    
    /**
     * Transforma um string em um int.
     * @param text string com o valor a ser convertido.
     * @return string convertido para int ou 0 em caso de impossibilidade de conversão.
     */
    public static Integer getIntegerReference(String text) {
        if( isEmpty(text))
        	return (Integer)null;
    	try {
                Double temp = Double.valueOf(text);
                return temp.intValue();
          } catch (Exception err) {
                return (Integer)null;
          }
    }
    /**
     * Transforma um string em um int.
     * @param text string com o valor a ser convertido.
     * @return string convertido para int ou 0 em caso de impossibilidade de conversão.
     */
    public static int getInteger(Object text) {
          if(  isEmpty( text) ){
        	  text = "0";
          }
          text = text.toString().replace(',', '.');
    	  try {
                Double temp = Double.valueOf(text.toString());
                return temp.intValue();
          } catch (Exception err) {
                return 0;
          }
    }

    /**
     * Transforma um string em um Long.
     * @param text string com o valor a ser convertido.
     * @return string convertido para int ou 0 em caso de impossibilidade de conversão.
     */
    public static long getLong(String text) {
          try {
                Double temp = Double.valueOf(text);
                return temp.longValue();
          } catch (Exception err) {
                return 0l;
          }
    }
    
    /**
     * Transforma um string em um int.
     * @param text string com o valor a ser convertido.
     * @return string convertido para int ou 0 em caso de impossibilidade de conversão.
     */
    public static boolean getBoolean(Object value) {
    		if (HowMGWTUtilities.isEmpty(value))
    			return false;
    		
    		String text = value.toString();
    		
    		if ("1".equals(text))
    			return true;
    		else if ("0".equals(text))
    			return false;
    		else if ("S".equals(text))
    			return true;
    		else if ("N".equals(text))
    			return false;
    		else if( "false".equals(text))
    			return false;
    		else if( "true".equals(text))
    			return true;
    		else if( "t".equals(text))
    			return true;

    		try {
    			Boolean temp = Boolean.valueOf(text.toString());
    			return temp.booleanValue();
    		} catch (Exception err) {
    			return false;
    		}

    }    
    
    
	private static final DateTimeFormat formatDate 		= DateTimeFormat.getFormat(Tradutor.i18n.formFormatDate());
	private static final DateTimeFormat formatDateTime 	= DateTimeFormat.getFormat(Tradutor.i18n.formFormatDateTime());
	
    private static final DateTimeFormat formatDateDB    = DateTimeFormat.getFormat("yyyy-MM-dd");    
    private static final DateTimeFormat formatDateTimeDB= DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss");

    private static final DateTimeFormat formatTime		= DateTimeFormat.getFormat("HH:mm");
    
    public static final String strZero(long valor , int nzeros)
    {
        String novoValor = "";
        int    novoLimite=  nzeros-(""+valor).length();

        for ( int i = 1; i <= novoLimite ; i++ )
                novoValor += "0";

        novoValor += valor;

        return novoValor;
    }


    public static final String strZero(int valor , int nzeros)
    {
        return strZero((long)valor,nzeros);
    }

    
	/**
	 * Retorna a data formatada para string
	 * @param date
	 * @return
	 */
    public static final String getFormatDateDBStart(Date date){
    	if ( ! HowMGWTUtilities.isEmpty(date))
    		return formatDateDB.format(date)+" 00:00:00";
    	return "";
    }

	/**
	 * Retorna a data formatada para string
	 * @param date
	 * @return
	 */
    public static final String getFormatDateDBEnd(Date date){
    	if ( ! HowMGWTUtilities.isEmpty(date))
    		return formatDateDB.format(date)+" 23:59:59";
    	return "";
    }
    
	/**
	 * Retorna a data formatada para string
	 * @param date
	 * @return
	 */
    public static final String getFormatDateDB(Date date){
    	if ( ! HowMGWTUtilities.isEmpty(date))
    		return formatDateDB.format(date);
    	return "";
    }
    
	/**
	 * Retorna a data formatada para string
	 * @param date
	 * @return
	 */
    public static final String getFormatTime(Date date){
    	if ( ! HowMGWTUtilities.isEmpty(date))
    		return formatTime.format(date);
    	return "";
    }
    
    
    /**
     * Retorna a data e hora formatada para string.
     * @param date
     * @return
     */
    public static final String getFormatDateTimeDB(Date date){
    	if ( HowMGWTUtilities.isEmpty(date))
    		return "";
    	return formatDateTimeDB.format(date);
    }
    
    
	
	/**
	 * Retorna a data formatada para string
	 * @param date
	 * @return
	 */
    public static final String getFormatDate(Date date){
    	if ( HowMGWTUtilities.isEmpty(date))
    		return "";
    	return formatDate.format(date);
    }
    
    /**
     * Retorna a data e hora formatada para string.
     * @param date
     * @return
     */
    public static final String getFormatDateTime(Date date){
    	if (HowMGWTUtilities.isEmpty(date))
    		return "";
    	
    	return formatDateTime.format(date);
    }
    

    /**
     * Retorna a data Início para execução de relatórios ou consulta entre períodos.
     * @param date Data que será utilizada para conversão.
     * @return
     */
    // @TODO Fazer testes, o ano deve abater -1900
    public static final Date getDateBegin(Date date){
    	if ( date == null )
    		return date;
    	return new Date(date.getYear(),date.getMonth()-1,date.getDate(),0,0,0);
    }
    
    /**
     * Retorna a data final para execução de relatórios ou consulta entre período.
     * @param date Data que será utilizada para conversão.
     * @return
     */
    public static final Date getDateEnd(Date date){
    	if ( date == null )
    		return date;
    	return new Date(date.getYear(), date.getMonth()-1, date.getDate(), 23,59,59);
    }
    
    
    
    /**
     * Retorna um objeto do tipo data a partir do texto setado no campo.
     * @return
     */
    public static final Date getDate(String text) {
          if (HowMGWTUtilities.isEmpty(text) ){
                return (Date) null;
          } 

          String[] parts = text.split(" ");
          if (parts.length == 0 ) {
                parts = text.split( "-" );
                if (parts.length == 0)
                      return (Date) null;
          }
          else if (parts.length == 1 && text.lastIndexOf("-") == 10 ) {
                parts = text.split( "-" );
                if (parts.length == 0)
                      return (Date) null;
          }

          parts[0] = replace(parts[0], "-", "/");
          String[] date = parts[0].split("/");

          if (date.length != 3) {
                return (Date) null;
          }

          int day   = 0;
          int month = 0;
          int year  = 0;

          // Se a primeira data for o ano, então a data está no formato ANSI.
          if ( date[0].length() == 4 ){
	          year  = getInteger(date[0])-1900;
        	  month = getInteger(date[1]);
	          day   = getInteger(date[2]);
          }
          // Formato pt_BR.
          else{
        	  day   = getInteger(date[0]);
	          month = getInteger(date[1]);
	          year  = getInteger(date[2])-1900;

          }
          // Cria a data.
          Date data = null;
          if (parts.length == 1) {
                data = new Date(year, month - 1, day);
          } else {
                String[] time = parts[1].split( ":");
                int hour = 0;
                int minute = 0;
                int secund = 0;
                if (time.length > 0) {
                      hour = getInteger(time[0]);
                }
                if (time.length > 1) {
                      minute = getInteger(time[1]);
                }
                if (time.length > 2) {
                      secund = getInteger(time[2]);
                }

               data = new Date(year, month - 1, day, hour, minute, secund);
          }
         
          return data;
    }
    
    
    /**
     * Analise se houve erro durante o processamento da mesma, 
     * caso tenha ocorrido erro então apresenta o erro para o 
     * usuário.
     * @param entity Entidade que será analisada
     * @return Retorna true se houve erro durante o processamento,
     * caso contrário retorna false.
     */	
	public static boolean isAnalyseEntityIsError(HowMGWTEntity entity){
		if ( entity.getThrowable() != null ){
			String msg = "<html><body><pre>";
			if ( !HowMGWTUtilities.isEmpty(entity.getThrowable().getMenssage()))
				msg += "<b>Mensagem:</b><br><font color=blue>"+entity.getThrowable().getMenssage()+"</font><hr/>";

			if ( !HowMGWTUtilities.isEmpty(entity.getThrowable().getMessage()))
				msg += "<b>Mensagem do Sistema:</b><br><font color=blue>"+entity.getThrowable().getMessage()+"</font><hr/>";

			if ( !HowMGWTUtilities.isEmpty(entity.getThrowable().getCommand()) )
				msg += "<b>Comando SQL:</b><br><font color=blue>"+entity.getThrowable().getCommand()+"</font><hr/>";

			if ( !HowMGWTUtilities.isEmpty(entity.getThrowable().getThrowable()) )
				msg += "<b>Erro:</b><br><font color=red>"+entity.getThrowable().getThrowable()+"</font>";

			if ( !HowMGWTUtilities.isEmpty(entity.getThrowable().getSolution()))
				msg += "<b>Solução:</b><br><font color=green>"+entity.getThrowable().getSolution()+"</font>";

			msg += "</pre></body></html>";
			HowMGWTWindowWait.hideWait();
//			if ( msg.length() <= 500 )
//				SC.say(msg);
//			else
				HowMGWTWindowDocumentHTML.showDocument(msg);
			return true;
		}
		return false;
	}

	public static String getMask(int decimais){

		String mask = "#,##0";	

		String dec = "";
		for ( int i = 0; i < decimais ; i ++ ){
			dec += "0";
		}
		if ( HowMGWTUtilities.isEmpty(dec))
			return mask;
		else
			return mask += "."+dec;
	}	

	public static String getGWTBeanTransfer(String body){
		return "JSONData="+body;
	}
	
	public static HLayout getCanvasVerticalSeparetor(int size, String backgroundColor){
		HLayout sep = new HLayout();
		sep.setWidth(size);
		sep.setHeight100();
		sep.setBackgroundColor(backgroundColor);		
		return sep;
	}

	public static VLayout getCanvasHorizontalSeparetor(int size, String backgroundColor){
		VLayout sep = new VLayout();
		sep.setWidth100();
		sep.setHeight(size);
		sep.setBackgroundColor(backgroundColor);
		return sep;
	}

	
	private static int gapIndicator = 3;
	
	public static VLayout getCanvasIndicator(int width, int height, String backgroundColor, String border ){
		
		int gapMargem 	= gapIndicator ;
		int gap 	 	= gapIndicator * 2;
		
		VLayout mainLayout = new VLayout();
		mainLayout.setWidth(width);
		mainLayout.setHeight(height);
	
		mainLayout.addMember(getCanvasHorizontalSeparetor(gapMargem, ""));
		
		HLayout hLayout = new HLayout();
		hLayout.setWidth100();
		hLayout.setHeight100();
		
		hLayout.addMember(getCanvasVerticalSeparetor(gapMargem, ""));
		
		VLayout sep = new VLayout();
		sep.setWidth(width-gap);
		sep.setHeight(height-gap);
		sep.setBackgroundColor(backgroundColor);
		sep.setBorder(border);
		hLayout.addMember(sep);
		
		mainLayout.addMember(hLayout);
		
		return mainLayout;
	}
	
	public static VLayout getCanvasLabelIndicator(int height, HowMGWTLabel label){

		
		VLayout mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight(height);
		
		mainLayout.addMember(getCanvasHorizontalSeparetor(gapIndicator, ""));
		
		HLayout lblLayout = new HLayout();
		lblLayout.setWidth100();
		lblLayout.setHeight(height-gapIndicator);
		
		label.setWidth100();
		label.setHeight(height-(gapIndicator*2));

		lblLayout.addMember(getCanvasVerticalSeparetor(5, ""));
		lblLayout.addMember(label);
		mainLayout.addMember(lblLayout);
		
		return mainLayout;
	}
	
	public static void downloadFile(String path, String fileName){
		String url = ""; 
    	url += Configuracao.getNativeUnoUrlServiceDonwload();
    	if ( url.endsWith("/"));
    	else
    		url += "/";
    	url += "unogwt/HowMDownload?PATH="+path+"&FILE_NAME="+fileName;
    	Window.open(url, "DONWLOAD", "");
	
	}

	
	private static HowMGWTCalendar calendar;
	public static HowMGWTCalendar getDefaultCalendar(){
		if ( calendar == null )
			calendar = new HowMGWTCalendar();
		return calendar;
	}
	

	
	
	
	/**
	 * Verifica se a data de início é menor ou igual a data fim.
	 * @param dataInicio
	 * @param dataFim
	 * @return
	 */
	public static boolean isMenorOuIgual(Date dataInicio, Date dataFim){

		// Se a data início diferente de null e a data fim for igual a null 
		// então é false, data início é maior que data fim
		if ( ! isEmpty(dataInicio) && isEmpty(dataFim) )
				return false;
		
		// Se a data início é igual a branco e data fim é diferente de null
		// então é true, data início é menor que a data fim
		if ( isEmpty(dataInicio) && ! isEmpty(dataFim) )
				return true;
				
		// Se a data início é igual a data fim então é true
		if( isEquals( dataInicio, dataFim ))
			return true;

		// Se a data início for menor que a data fim então é true;
		if ( dataInicio.before(dataFim))
			return true;
			
		return false;
	}

	
	/**
	 * Verifica se a data de início é maior ou igual a data fim.
	 * @param dataInicio
	 * @param dataFim
	 * @return
	 */
	public static boolean isMaiorOuIgual(Date dataInicio, Date dataFim){

		// Se a data início diferente de null e a data fim for igual a null 
		// então é true, data início é maior que data fim
		if ( ! isEmpty(dataInicio) && isEmpty(dataFim) )
				return true;
		
		// Se a data início é igual a branco e data fim é diferente de null
		// então é false, data início é menor que a data fim
		if ( isEmpty(dataInicio) && ! isEmpty(dataFim) )
				return false;
				
		// Se a data início é igual a data fim então é true
		if( isEquals( dataInicio, dataFim ))
			return true;

		// Se a data início for menor que a data fim então é true;
		if ( dataInicio.after(dataFim))
			return true;
			
		return false;
	}
	
 
	
	
	
	
	
	/**
	 * Verifica se a data de início é menor que a data fim.
	 * @param dataInicio
	 * @param dataFim
	 * @return
	 */
	public static boolean isMenor(Date dataInicio, Date dataFim){

		// Se a data início diferente de null e a data fim for igual a null 
		// então é false, data início é maior que data fim
		if ( ! isEmpty(dataInicio) && isEmpty(dataFim) )
				return false;
		
		// Se a data início é igual a branco e data fim é diferente de null
		// então é true, data início é menor que a data fim
		if ( isEmpty(dataInicio) && ! isEmpty(dataFim) )
				return true;
				
		// Se a data início é igual a data fim então é false
		if( isEquals( dataInicio, dataFim ))
			return false;

		// Se a data início for menor que a data fim então é true;
		if ( dataInicio.before(dataFim))
			return true;
			
		return false;
	}

	

    /**
     * @return String Retorna o tempo decorrido em horas, minutos e segundos .
     */
    public static String getElapsetime(long startTime) {
        long tempoDecorrido = System.currentTimeMillis() - startTime;
        int segundos = (int) ((tempoDecorrido / 1000) % 60);
        int minutos = (int) (((tempoDecorrido / 1000) / 60) % 60);
        int hora = (int) ((((tempoDecorrido / 1000) / 60) / 60) % 60);
        return strZero(hora, 2) + ":"
                + strZero(minutos, 2) + ":"
                + strZero(segundos, 2);
    }

    
    
	
	/**
	 * Verifica se a data de início é maior que a data fim.
	 * @param dataInicio
	 * @param dataFim
	 * @return
	 */
	public static boolean isMaior(Date dataInicio, Date dataFim){

		// Se a data início diferente de null e a data fim for igual a null 
		// então é true, data início é maior que data fim
		if ( ! isEmpty(dataInicio) && isEmpty(dataFim) )
				return true;
		
		// Se a data início é igual a branco e data fim é diferente de null
		// então é false, data início é menor que a data fim
		if ( isEmpty(dataInicio) && ! isEmpty(dataFim) )
				return false;
				
		// Se a data início é igual a data fim então é true
		if( isEquals( dataInicio, dataFim ))
			return false;

		// Se a data início for menor que a data fim então é true;
		if ( dataInicio.after(dataFim))
			return true;
			
		return false;
	}	

	
	public static String getObjectString(Object value) {
		if (isEmpty(value))
			return null;
		else
			return value.toString().trim();
	}

	public static String getFormatTime(int time){
		String sTime = HowMGWTUtilities.strZero(time, 4);
		
		String hora  = sTime.substring(0,2);
		String minuto= sTime.substring(2);
		
		sTime 		 = hora + ":" +minuto+":00";
		
		return sTime;
	}
	
	
    /**
     * Formata um campo cnpj.
     * @param cnpj
     * @return
     */
    public static String formatCNPJ(String cnpj){
    	if( HowMGWTUtilities.isEmpty( cnpj ))
    		return "";
    	
    	cnpj = replace(cnpj, ".", "");
    	cnpj = replace(cnpj, "-", "");
    	cnpj = replace(cnpj, "/", "");
    	cnpj = replace(cnpj, " ", "");

    	if( isEmpty( replace(cnpj, "0", "")))
    		return "";

    	cnpj = strZero(getLong(cnpj), 14);

		cnpj = 	cnpj.substring(0	,2	)	+	"."	+
				cnpj.substring(2	,5	)	+	"."	+
				cnpj.substring(5	,8	)	+	"/"	+
				cnpj.substring(8	,12	)	+	"-"	+
				cnpj.substring(12	,14	);

		return cnpj;
 
    }	
	
    
    /**
     * Retorna a extensão de um determinado arquivo.
     * @param fileName
     * @return
     */
    public static String getExtensaoArquivo(String fileName){
    	if( HowMGWTUtilities.isEmpty(fileName)){
    		return "";
    	}
    	
    	int indexPoint = fileName.lastIndexOf(".");
    	if( indexPoint < 0 ){
    		return "";
    	}
    	
    	String extensao = fileName.substring(indexPoint+1);
    	return extensao;
    }
    
        
    
    
    /**
     * Retorna a diferença em horas/minutos entre duas datas.
     * @param startDate
     * @param finishDate
     * @return
     */
	public static String getDifHoraMinuto(Date startDate, Date finishDate){
			
		if( startDate == null && finishDate == null ){
			return "0000";
		}

		if( finishDate == null ){
			finishDate = startDate;
		}

		// Transforma 1 dias em millesegundos.
		long tempoDia   = 1000 * 60 * 60 * 24;
		
      	// Recupera a diferença entre uma data e outra em milessegundos.
      	long diferenca = startDate.getTime()-finishDate.getTime();
      	// Calcula o número de dias entre duas datas.
      	double dias = (double)diferenca / (double)tempoDia;		
      	      	      	
      	double dif = Math.abs((dias*(double)24)); // Pega a diferença em dias e converte para horas      	      
      	
      	System.out.println("Diferença em dias :"+dif);
      	
      	String difHoraMinuto = ""+dif;
      	String minuto = "";
      	// Incluído este controle, porque na transformação do GWT para javascript
      	// valores inteiros mesmo definidos como double, não retorna fração 0.
      	if( difHoraMinuto.indexOf(".") >= 0 ){
      		minuto = difHoraMinuto.substring(difHoraMinuto.indexOf(".")+1);
      	}
      	else{
      		minuto = "00";
      	}
      	
      	String hora   = "";
      	// Incluído este controle, porque na transformação do GWT para javascript
      	// valores inteiros mesmo definidos como double, não retorna fração 0.      	
      	if( difHoraMinuto.indexOf(".") >= 0 ){
      		hora = difHoraMinuto.substring(0,difHoraMinuto.indexOf("."));
      	}
      	else{
      		hora = difHoraMinuto;
      	}
      		      	
      	minuto		  = ""+Math.round( HowMGWTUtilities.getDouble("0."+minuto) * (double)60 );

      	System.out.println("Minuto : "+minuto);
      	System.out.println("Hora   : "+hora);

		return HowMGWTUtilities.getRPad(hora, "0",  2)+HowMGWTUtilities.strZero(HowMGWTUtilities.getInteger(minuto), 2);		 
	}
	
	
	public static String getValor(Object object){
		if ( object == null )
			return "";
		if ( HowMGWTUtilities.isEmpty(object))
			return "";
		return object.toString();
	}
	
	public static Integer getObjectInteger(Object text) {
		if( HowMGWTUtilities.isEmpty(text))
			return null;
		try {
			text = text.toString().replace(',', '.');
			Double temp = Double.valueOf(text.toString());
			return temp.intValue();
		} catch (Exception err) {
			return null;
		}
	}

	public static Double getObjectDouble(Object text) {
		if( HowMGWTUtilities.isEmpty(text))
			return null;
		try {
			if (text.toString().indexOf(",") >= 0) {
				text = replace(text.toString(), ".", "");
				text = replace(text.toString(), ",", ".");
			}
			Double temp = Double.valueOf(text.toString());
			return temp.doubleValue();
		} catch (Exception err) {
			return null;
		}
	}
	
	
    /**
     * Transforma um string em um boolean.
     *
     * @param text string com o valor a ser convertido.
     * @return string convertido para int ou 0 em caso de impossibilidade de
     * conversão.
     */
    public static String getCBoolean(Object text) {
        if (isEmpty(text)) {
            return "0";
        }

        try {
            if ("SIM".equalsIgnoreCase(text.toString().toUpperCase())) {
                return "1";
            }
            if ("S".equalsIgnoreCase(text.toString().toUpperCase())) {
                return "1";
            }
            if ("TRUE".equalsIgnoreCase(text.toString().toUpperCase())) {
                return "1";
            }
            if ("Y".equalsIgnoreCase(text.toString().toUpperCase())) {
                return "1";
            }
            if ("YES".equalsIgnoreCase(text.toString().toUpperCase())) {
                return "1";
            }
            if ("V".equalsIgnoreCase(text.toString().toUpperCase())) {
                return "1";
            }
            if ("1".equalsIgnoreCase(text.toString().toUpperCase())) {
                return "1";
            }
            if ("VERDADEIRO".equalsIgnoreCase(text.toString().toUpperCase())) {
                return "1";
            } else {
                return "0";
            }
        } catch (Throwable err) {
            return "0";
        }
    }
    
	public static final Date getDate(Object object) {
		
		if (HowMGWTUtilities.isEmpty(object)) 
			return (Date) null;
		
		if ( object instanceof Date )
			return (Date)object;
		
		return getDate(object.toString());
	}
	

	
    /**
     * Retorna a partir de uma data uma nova data com 
     * o último dia do mês.
     * @param data
     * @return
     */
	public static Date getDateLastDay(Date data){
        int dia 		= data.getDate();
        int mes 		= data.getMonth();
        int ano 		= data.getYear();        
        Date newData 	= new Date(ano, mes, 31);
        int newDia  	= newData.getDate();
        int newMes     	= newData.getMonth();
        int newYear 	= newData.getYear();

        if( newMes != mes ){
        	newData = new Date(newYear, newMes, 0);
        }
        else if( newDia == 31 ){
        	newData = new Date(newYear, newMes, newDia);
        }
        
        return newData;
	}
	   
 
}