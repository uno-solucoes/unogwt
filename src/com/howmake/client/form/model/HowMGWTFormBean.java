package com.howmake.client.form.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.howmake.client.form.partner.HowMGWTUtilities;
 

public class HowMGWTFormBean {

    protected TreeMap _self = new TreeMap();    
       
	public String getErro(){
	 	return toString("erro");
	}

	public void setErro(String value){
	 	setString("erro",value);
	}


	public String getTarefa(){
		return toString("tarefa");
	}

	public void setTarefa(String value){
		setString("tarefa", value);
	}


	public String getMensagem(){
		return toString("mensagem");
	}

	public void setMensagem(String value){
		setString("mensagem", value);
	}


	public String getBarraControladora(){
	 	return toString("barraControladora");
	}

	public void setBarraControladora(String value){
		setString("barraControladora", value );
	}
 
	
	
	/**
	 * @param propertyMame
	 * @return Retorna o valor armazenado no formato String
	 */
	public String toString(String propertyMame){
		Object obj = _self.get(propertyMame);
		if ( obj == null )
			return null;
		else
			return obj.toString();	
	}
	/**
	 * Seta um valor no formato String na cache para a propriedade em questão.
	 * @param propertyMame
	 * @param value
	 */
	public void setString(String propertyMame, String value){
		_self.remove(propertyMame);
		if ( value != null );
			_self.put(propertyMame, value);
	}

	
	
		
	
	
	
	/**
	 * @param propertyMame
	 * @return Retorna o valor armazenado no formato Boolean
	 */
	public boolean toBoolean(String propertyMame){
		Object obj = _self.get(propertyMame);
		if ( obj == null )
			return false;
		else
			return ((Boolean)obj).booleanValue();	
	}
	
	/**
	 * Seta um valor no formato Boolean na cache para a propriedade em questão.
	 * @param propertyMame
	 * @param value
	 */
	public void setBoolean(String propertyMame, Boolean value){
		_self.remove(propertyMame);
		if ( value != null );
			_self.put(propertyMame, value);
	}

	
	
	
	
	
	
	
	/**
	 * @param propertyMame
	 * @return Retorna o valor armazenado no formato Boolean
	 */
	public int toInteger(String propertyMame){
		Object obj = _self.get(propertyMame);
		if ( obj == null )
			return 0;
		else{
			if ( obj instanceof Double)
				return ((Double)obj).intValue();

			return ((Integer)obj).intValue();
		}
	}
	
	/**
	 * Seta um valor no formato Boolean na cache para a propriedade em questão.
	 * @param propertyMame
	 * @param value
	 */
	public void setInteger(String propertyMame, Integer value){
		_self.remove(propertyMame);
		if ( value != null );
			_self.put(propertyMame, value);
	}
	
	
	
	
	
	
	
	
	

	/**
	 * @param propertyMame
	 * @return Retorna o valor armazenado no formato double
	 */
	public double toDouble(String propertyMame){
		Object obj = _self.get(propertyMame);
		if ( obj == null )
			return 0.0;
		else{
			if ( obj instanceof Double)
				return ((Double)obj).doubleValue();

			return HowMGWTUtilities.getDouble(obj);
		}
	}
	
	/**
	 * Seta um valor no formato Double na cache para a propriedade em questão.
	 * @param propertyMame
	 * @param value
	 */
	public void setDouble(String propertyMame, Double value){
		_self.remove(propertyMame);
		if ( value != null );
			_self.put(propertyMame, value);
	}	

	
	
	
	
	
	
	/**
	 * @param propertyMame
	 * @return Retorna o valor armazenado no formato double
	 */
	public long toLong(String propertyMame){
		Object obj = _self.get(propertyMame);
		if ( obj == null )
			return 0l;
		else{
			if ( obj instanceof Double)
				return ((Double)obj).longValue();
			
			return ((Long)obj).longValue();	
		}
	}
	
	/**
	 * Seta um valor no formato Double na cache para a propriedade em questão.
	 * @param propertyMame
	 * @param value
	 */
	public void setLong(String propertyMame, Long value){
		_self.remove(propertyMame);
		if ( value != null );
			_self.put(propertyMame, value);
	}	
	
	
	
	
	
	
	
	
	
	/**
	 * @param propertyMame
	 * @return Retorna o valor armazenado no formato double
	 */
	public float toFloat(String propertyMame){
		Object obj = _self.get(propertyMame);
		if ( obj == null )
			return 0.0f;
		else
			if ( obj instanceof Double)
				return ((Double)obj).floatValue();
			return ((Float)obj).floatValue();	
	}
	
	/**
	 * Seta um valor no formato Double na cache para a propriedade em questão.
	 * @param propertyMame
	 * @param value
	 */
	public void setFloat(String propertyMame, Long value){
		_self.remove(propertyMame);
		if ( value != null );
			_self.put(propertyMame, value);
	}






























	/**
	 * @param propertyMame
	 * @return Retorna o valor armazenado no formato String
	 */
	protected String[] toStringArray(String propertyMame){
		Object obj = _self.get(propertyMame);
		if ( obj == null )
			return null;
		else
			return (String[])obj;	
	}
	/**
	 * Seta um valor no formato String na cache para a propriedade em questão.
	 * @param propertyMame
	 * @param value
	 */
	protected void setStringArray(String propertyMame, String[] value){
		_self.remove(propertyMame);
		if ( value != null );
			_self.put(propertyMame, value);
	}

	
	
	
	
	
	
	
	
	
	/**
	 * @param propertyMame
	 * @return Retorna o valor armazenado no formato Boolean
	 */
	protected boolean[] toBooleanArray(String propertyMame){
		Object obj = _self.get(propertyMame);
		if ( obj == null )
			return null;
		else
			return (boolean[])obj;	
	}
	
	/**
	 * Seta um valor no formato Boolean na cache para a propriedade em questão.
	 * @param propertyMame
	 * @param value
	 */
	protected void setBooleanArray(String propertyMame, boolean[] value){
		_self.remove(propertyMame);
		if ( value != null );
			_self.put(propertyMame, value);
	}

	
	
 
	
	
	
	
	/**
	 * @param propertyMame
	 * @return Retorna o valor armazenado no formato Boolean
	 */
	protected int[] toIntegerArray(String propertyMame){
		Object obj = _self.get(propertyMame);
		if ( obj == null )
			return null;
		else
			return (int[])obj;	
	}
	
	/**
	 * Seta um valor no formato Boolean na cache para a propriedade em questão.
	 * @param propertyMame
	 * @param value
	 */
	protected void setIntegerArray(String propertyMame, int[] value){
		_self.remove(propertyMame);
		if ( value != null );
			_self.put(propertyMame, value);
	}
	
	
	
	
	
	
	
	
	

	/**
	 * @param propertyMame
	 * @return Retorna o valor armazenado no formato double
	 */
	protected double[] toDoubleArray(String propertyMame){
		Object obj = _self.get(propertyMame);
		if ( obj == null )
			return null;
		else
			return (double[])obj;	
	}
	
	/**
	 * Seta um valor no formato Double na cache para a propriedade em questão.
	 * @param propertyMame
	 * @param value
	 */
	protected void setDoubleArray(String propertyMame, double[] value){
		_self.remove(propertyMame);
		if ( value != null );
			_self.put(propertyMame, value);
	}	

	
	
	
	
	
	
	/**
	 * @param propertyMame
	 * @return Retorna o valor armazenado no formato double
	 */
	protected long[] toLongArray(String propertyMame){
		Object obj = _self.get(propertyMame);
		if ( obj == null )
			return null;
		else
			return (long[])obj;	
	}
	
	/**
	 * Seta um valor no formato Double na cache para a propriedade em questão.
	 * @param propertyMame
	 * @param value
	 */
	protected void setLongArray(String propertyMame, long[] value){
		_self.remove(propertyMame);
		if ( value != null );
			_self.put(propertyMame, value);
	}	
	
	
	
	
	
	
	
	
	
	/**
	 * @param propertyMame
	 * @return Retorna o valor armazenado no formato double
	 */
	protected float[] toFloatArray(String propertyMame){
		Object obj = _self.get(propertyMame);
		if ( obj == null )
			return null;
		else
			return ((float[])obj);	
	}
	
	/**
	 * Seta um valor no formato Double na cache para a propriedade em questão.
	 * @param propertyMame
	 * @param value
	 */
	protected void setFloatArray(String propertyMame, long[] value){
		_self.remove(propertyMame);
		if ( value != null );
			_self.put(propertyMame, value);
	}
	
	
	/**
	 * Carrega os Objetos JSON de forma automatica
	 * @param value
	 */
	public Object load(String name ,JSONValue value){
		if( value == null ){
			return null;
		}
		else if ( value.isNull() != null  ){
			return null;
		}
		else if ( value.isArray() != null )
			loadCustomArray(name, value.isArray());
		// Carrega os Objetos
		else if ( value.isObject() != null ){
			JSONObject object = value.isObject();
			Set set = object.keySet();
			Object[] objects = set.toArray();
			String key;
			JSONValue valueLoad;
			for ( Object obj : objects ){
				key 	  	= obj.toString();
				valueLoad 	= object.get(key);
				if ( valueLoad != null ){
					if( valueLoad.isObject() != null ){
						Object customObj = loadCustom(key, valueLoad.isObject());	
						if ( customObj != null ){
							_self.put(key, customObj);
						}
					}
					else
						load(key, valueLoad);
				}
			}
		}
		// Carrega os numericos
		else if ( value.isNumber() != null ){
			if ( ! HowMGWTUtilities.isEmpty(name) )
				_self.put(name, value.isNumber().doubleValue());
		}
		// Carrea os booleanos
		else if ( value.isBoolean() != null ){
			if ( ! HowMGWTUtilities.isEmpty(name) )
				_self.put(name, value.isBoolean().booleanValue());
		}
		else if ( value.isString() != null ){
			if ( ! HowMGWTUtilities.isEmpty(name) )
				_self.put(name, value.isString().stringValue() );
		}
		return this;
	}
	
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){		
	}
	
	/**
	 * Carrega um Objeto JSON de forma automatica
	 * @param value
	 */
	public Object loadCustom(String name, JSONObject value){		
		return null;
	}
	
	public String toPrint(){
		String text = "";
		Set set = _self.keySet();
		Object[] keys = set.toArray();
		for (Object key : keys){
			text += key + " : "+_self.get(key)+"\n";
		}
		return text;
	}
	

	public String toEncodeFields(){
		return toEncodeFields(null);
	}

	/**
	 * @return codifica os campos do objeto para transmissão para o servidor.
	 */
	public String toEncodeFields(String exceptionTags){
		String encode = "";
		Set set = _self.keySet();
		Object[] keys = set.toArray();
		Object value;
		
		TreeMap<String, String> mapExceptionTags = new TreeMap<String,String>();
		if ( HowMGWTUtilities.isEmpty(exceptionTags) )
			exceptionTags = "";
		
		String[] tags = exceptionTags.split(";");
		for ( String tag : tags)
			mapExceptionTags.put(tag, "");
		
		
		for ( Object key : keys){
			value = _self.get(key);
			if ( value == null )
				continue;
			
			// Ingnora caso encontre a tag na lista de exceções.
			if( mapExceptionTags.get(key.toString())!= null )
				continue;
			
			// Codifica somente os tipos descritos abaixo.
			if ( value instanceof String 
				 ||
				 value instanceof Double 
				 ||
				 value instanceof Integer
				 || 
				 value instanceof Float 
				 || 
				 value instanceof Long
				 || 
				 value instanceof Boolean
				 ||
				 value instanceof Date
			)
				encode += "&"+key+"="+URL.encode(value.toString());		
		}
		return encode;
	}
	
	
	
	/**
	 * @return codifica os campos do objeto para transmissão para o servidor.
	 */
	public JSONObject toJsonObject(String exceptionTags){
		String encode = "";
		Set set = _self.keySet();
		Object[] keys = set.toArray();
		Object value;
		
		JSONObject object = new JSONObject();
		
		TreeMap<String, String> mapExceptionTags = new TreeMap<String,String>();
		if ( HowMGWTUtilities.isEmpty(exceptionTags) )
			exceptionTags = "";
		
		String[] tags = exceptionTags.split(";");
		for ( String tag : tags)
			mapExceptionTags.put(tag, "");
		
		
		for ( Object key : keys){
			value = _self.get(key);
			if ( value == null )
				continue;
			
			// Ingnora caso encontre a tag na lista de exceções.
			if( mapExceptionTags.get(key.toString())!= null )
				continue;
			
			// Codifica somente os tipos descritos abaixo.
			if ( value instanceof String 
				 || 
				 value instanceof Boolean
			){
				if ( !HowMGWTUtilities.isEmpty( value ) )
					object.put(key.toString(), new JSONString( value.toString() ));
			}
			// Codifica somente os tipos descritos abaixo.
			else if (  
				 value instanceof Double 
				 ||
				 value instanceof Integer
				 || 
				 value instanceof Float 
				 || 
				 value instanceof Long
			){
				if ( !HowMGWTUtilities.isEmpty( value ) )
					object.put(key.toString(), new JSONString( value.toString() ));
			}
			else if (value instanceof Date ){

				if ( ! HowMGWTUtilities.isEmpty( value ) ){
					Date date = (Date)value;
					String data = "";
					data += HowMGWTUtilities.getLPad(""+(date.getYear()+1900), "0",4);
					data += "-";
					data += HowMGWTUtilities.getLPad(""+(date.getMonth()+1), "0", 2);
					data += "-";
					data += HowMGWTUtilities.getLPad(""+date.getDate(), "0", 2);
					data += " ";
					data += HowMGWTUtilities.getLPad(""+date.getHours(), "0", 2);
					data += ":";
					data += HowMGWTUtilities.getLPad(""+date.getMinutes(), "0", 2);
					data += ":";
					data += HowMGWTUtilities.getLPad(""+date.getSeconds(), "0", 2);
	
					object.put(key.toString(), new JSONString( data ));
				}
			}
			else if ( value instanceof String[] ){

				String[] sValue = (String[])value;

				JSONArray valueLoad = new JSONArray();
				int i = 0;
				for ( String obj : sValue )
					valueLoad.set(i++, new JSONString(obj));
				object.put(key.toString(), valueLoad );				
			}			
			else if ( value instanceof HowMGWTFormBean[] ){

				HowMGWTFormBean[] sValue = (HowMGWTFormBean[])value;

				JSONArray valueLoad = new JSONArray();
				int i = 0;
				for ( HowMGWTFormBean obj : sValue ){
					JSONObject object1 = obj.toJsonObject("");
					valueLoad.set(i, object1);
					i ++ ;
				}
				object.put(key.toString(), valueLoad );				
			}
			else if ( value instanceof HowMGWTFormBean ){

				HowMGWTFormBean sValue = (HowMGWTFormBean)value;
				JSONObject valueLoad = sValue.toJsonObject("");
				object.put(key.toString(), valueLoad );				
			}						
		}
		return object;
	}
	
	public String toSendBody(String exceptionTags){
		return "JSONData="+this.toJsonObject(exceptionTags).toString();
	}
	
	public void setObject(String name, Object value){
		_self.put(name, value);
	}
	
	public Object getObject(String name){
		return _self.get(name);
	}


	public String getFormPost(){
		return HowMGWTUtilities.getGWTBeanTransfer(this.toJsonObject("").toString());
	}
	
	// Converte um objeto formBeam para outro objeto formBean de tipos diferentes.
	public void convertToThisBean(HowMGWTFormBean formBeam){
		this._self = formBeam._self;
	}
	
	
	public String getHowMGridRow(){
		return toString("howMGridRow");
	}

	public void setHowMGridRow(String value){
		setString("howMGridRow",value);
	}
		
	public void setHowMMethodValue(String value){}
	public String getHowMMethodValue(){return null;}

	
	public boolean isError(){
		return isError(true);
	}
	
	public boolean isError(boolean showError){
		return isFormShowMessage(this, showError);
	}

	
	
	
	private boolean isFormShowMessage(HowMGWTFormBean bean, boolean ajax){
		
//		HowMGWTWindowWait.hideWait();	
//		
//		if ( bean == null )
//			Window.alert("Retornou bean null, verifique junto ao administrador...");
//		
//		HowMGWTFormBean throwable = (HowMGWTFormBean)bean.getServerThrowable();
//		if(  throwable == null ){
//			return false;
//		}
//
//		String erro = "";
//		erro += HowMGWTUtilities.getValor(throwable.toString("erro"));
//		erro += HowMGWTUtilities.getValor(throwable.toString("mensagem"));
//		erro += HowMGWTUtilities.getValor(throwable.toString("causa"));
//		erro += HowMGWTUtilities.getValor(throwable.toString("solucao"));
//		erro += HowMGWTUtilities.getValor(throwable.toString("nota"));
//		erro += HowMGWTUtilities.getValor(throwable.toString("throwable"));
//		if( !HowMGWTUtilities.isEmpty(throwable.getDatabaseCommand())){
//			erro += "<hr>";
//			erro += HowMGWTUtilities.getValor(throwable.getDatabaseCommand());
//		}
//		
//		if ( ! HowMGWTUtilities.isEmpty(erro)){
//			HowMGWTWindowManagerError.showError(erro);
//		}
//		return 	HowMGWTControl.FORM_TAREFA_ERROS_ALERT.equals(throwable.toString("tipoErro")) 
//				|| 
//				HowMGWTControl.FORM_TAREFA_ERROS_HTML.equals(throwable.toString("tipoErro"))
//				|| 
//				HowMGWTControl.FORM_TAREFA_NOT_FOUND.equals(throwable.toString("tipoErro"))
//				;
		return false;
	}
	
	
	
	
	   /**
     * @return the sqlOperacao
     */
    public String getSqlOperacao() {
        return toString("sqlOperacao");
    }

    /**
     * @param sqlOperacao the sqlOperacao to set
     */
    public void setSqlOperacao(String sqlOperacao) {
        setString("sqlOperacao", sqlOperacao);
    }
    
    public boolean isSQLOperacaoInsert(){
        return (""+HowMGWTUtilities.OPERATION_INSERT).equals(getSqlOperacao());
    }

    public boolean isSQLOperacaoUpdate(){
        return (""+HowMGWTUtilities.OPERATION_UPDATE).equals(getSqlOperacao());
    }

    public boolean isSQLOperacaoDelete(){
        return (""+HowMGWTUtilities.OPERATION_DELETE).equals(getSqlOperacao());
    }

    public boolean isSQLOperacaoQuery(){
        return (""+HowMGWTUtilities.OPERATION_QUERY).equals(getSqlOperacao());
    }

    public void setSQLOperacaoInsert(){
        this.setSqlOperacao(""+HowMGWTUtilities.OPERATION_INSERT);
    }

    public void setSQLOperacaoUpdate(){
    	this.setSqlOperacao(""+HowMGWTUtilities.OPERATION_UPDATE);
    }

    public void setSQLOperacaoDelete(){
        this.setSqlOperacao(""+HowMGWTUtilities.OPERATION_DELETE);
    }
    
    public void setSQLOperacaoQuery(){
        this.setSqlOperacao(""+HowMGWTUtilities.OPERATION_QUERY);
    }
    
    
	public TreeMap getObjectShelf(){
		return this._self;
	}

	
	public String getErroDetail(){		
		return toString("erroDetail");
	}
	
}