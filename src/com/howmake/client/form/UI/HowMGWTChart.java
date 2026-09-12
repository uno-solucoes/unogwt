package com.howmake.client.form.UI;

import java.util.ArrayList;

import com.br.client.configuracao.Configuracao;
import com.google.gwt.http.client.URL;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.ContentsType;
import com.smartgwt.client.widgets.HTMLPane;

public class HowMGWTChart extends HTMLPane{

	public static final String CHART_PACKAGE_PIE 			= "google.load('visualization', '1.0', {'packages':['corechart']});";
	public static final String CHART_PACKAGE_BAR 			= "google.load('visualization', '1.0', {'packages':['corechart']});";
	public static final String CHART_PACKAGE_BARCOLUMN_BAR 	= "google.load('visualization', '1.0', {'packages':['corechart']});";
	
	public static final String CHART_TYPE_PIE 				= "\n\tvar chart = new google.visualization.PieChart(document.getElementById('chart_div'));\n";
	public static final String CHART_TYPE_BAR 				= "\n\tvar chart = new google.visualization.BarChart(document.getElementById('chart_div'));\n";
	public static final String CHART_TYPE_COLUMN_BAR 		= "\n\tvar chart = new google.visualization.ColumnChart(document.getElementById('chart_div'))\n"; 
	
	private String chartPackage = CHART_PACKAGE_PIE;
	private String chartType	= CHART_TYPE_PIE;	
	
	private String requestZoom;
	private String url = "";
 
	private String title        = "";
	private Legend legend;
	private ChartArea chartArea; 
	private Axis vAxis;
	private Axis hAxis;
	
	private Boolean is3D = null;
	
	private ArrayList<Column> columns = new ArrayList<Column>();
	private ArrayList<String[]> dados = new ArrayList<String[]>();
	
	public HowMGWTChart(){
		this.setWidth100();
		this.setHeight100();
        this.setContentsType(ContentsType.PAGE);
	}
	
	public  void drawChart(){

		String url = "";

       	url += Configuracao.getNativeUnoUrlServiceDonwload();
    	if ( url.endsWith("/"));
    	else
    		url += "/";
    	
		String param = "?CHART_HEIGHT=98%&CHART_WIDTH=98%"+"&CHART_TITLE="+this.getTitle()+"&CHART_DATA=";
		String data = "";
		if( this.getDados() != null ){
			for ( String[] e : this.getDados() ){
				String line = "";
				for ( int i = 0 ; i < e.length ; i++ ){
					if ( i == 0 )
						line = "'"+e[i]+"'";
					else
						line += ","+e[i];
				}
				if ( !HowMGWTUtilities.isEmpty(data))
					data += ",\n";
				data += "["+line+"]";
			}
		}
		data += "\n";
		param += data;
		
		String options = "";
		if ( is3D != null )
			options += "'is3D':"+this.isIs3D();

		if (this.getLegend() != null ){
			if (  !HowMGWTUtilities.isEmpty(options) )
				options += ",";
			options += this.getLegend().toOptions();
		}
		if ( this.getChartArea() != null ){
			if (  !HowMGWTUtilities.isEmpty(options) )
				options += ",";	
			options += this.getChartArea().toOptions();
		}
		if ( this.getvAxis() != null ){
			if (  !HowMGWTUtilities.isEmpty(options) )
				options += ",";
			options += this.getvAxis().toAxis();
		}
		if ( this.gethAxis() != null ){
			if (  !HowMGWTUtilities.isEmpty(options) )
				options += ",";			
			options += this.gethAxis().toAxis();
		}
     	
		param += "&CHART_OPTIONS="+options;
		
		String sColumn = "";
		for( Column column : this.columns){
			sColumn += column.toColumn();
		}
		param += "&CHART_COLUMNS="+sColumn;

		param += "&CHART_PAKAGE="+chartPackage;
		param += "&CHART_TYPE="+chartType;
		
		String request = url+"/UnoGWTChart.jsp"+param;
    	
    	this.requestZoom = request;

    	this.setContentsURL(URL.encode(request));
	}

	public void addColumnString( String name){
		Column column = new Column(Column.TYPE_STRING, name);
		this.columns.add(column);
	}

	public void addColumnNumber(String name){
		Column column = new Column(Column.TYPE_NUMBER, name);
		this.columns.add(column);
	}

	
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the is3D
	 */
	public Boolean isIs3D() {
		return is3D;
	}

	/**
	 * @param is3d the is3D to set
	 */
	public void setIs3D(Boolean is3d) {
		is3D = is3d;
	}

	/**
	 * @return the dados
	 */
	public ArrayList<String[]> getDados() {
		return dados;
	}

	/**
	 * @param dados the dados to set
	 */
	public void setDados(ArrayList<String[]> dados) {
		this.dados = dados;
	}

	/**
	 * @return the legend
	 */
	public Legend getLegend() {
		return legend;
	}

	/**
	 * @return the chartArea
	 */
	public ChartArea getChartArea() {
		return chartArea;
	}

	public void createChartArea(){
		this.chartArea = new ChartArea();
	}
	
	public void createLegend(){
		this.legend = new Legend();
	}

	public void createVAxis(){
		Axis axis = new Axis();
		axis.setVertical(true);
		this.vAxis = axis;
	}

	public void createHAxis(){
		Axis axis = new Axis();
		axis.setVertical(false);
		this.hAxis = axis;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public void setTypePIE(){
		chartPackage = CHART_PACKAGE_PIE;
		chartType	= CHART_TYPE_PIE;	
	}
	
	public void setTypeBAR(){
		chartPackage = CHART_PACKAGE_BAR;
		chartType	= CHART_TYPE_BAR;
	}
	
	public void setTypeColumnBAR(){
		chartPackage = CHART_PACKAGE_BARCOLUMN_BAR;
		chartType	 = CHART_TYPE_COLUMN_BAR;
	}

	/**
	 * @return the request
	 */
	public String getRequestZoom() {
		return requestZoom;
	}
 
	
	
	
	
	// -------------------------------------------------------------------------------
	
	
	public class Legend{
		private String position = "none";
		private TextStyle textStyle = new TextStyle();
		public Legend(){
			
		}
		/**
		 * @return the position
		 */
		public String getPosition() {
			return position;
		}
		/**
		 * @param position the position to set
		 */
		public void setPosition(String position) {
			this.position = position;
		}
		/**
		 * @return the textStyle
		 */
		public TextStyle getTextStyle() {
			return textStyle;
		}
		/**
		 * @param textStyle the textStyle to set
		 */
		public void setTextStyle(TextStyle textStyle) {
			this.textStyle = textStyle;
		}
		
		public String toOptions(){
			String options = "";
			options += "'legend':{position: '"+this.getPosition()+"', "+getTextStyle().toOptions()+"}";		
			return options;
		}
	}

	public class TextStyle{
		private String color = "blue";
		private int fontSize = 12;

		public TextStyle(){
			
		}

		/**
		 * @return the color
		 */
		public String getColor() {
			return color;
		}

		/**
		 * @param color the color to set
		 */
		public void setColor(String color) {
			this.color = color;
		}

		/**
		 * @return the fontSize
		 */
		public int getFontSize() {
			return fontSize;
		}

		/**
		 * @param fontSize the fontSize to set
		 */
		public void setFontSize(int fontSize) {
			this.fontSize = fontSize;
		}
		
		public String toOptions(){
			String options = "";
			options += "textStyle: {color: '"+this.getColor()+"', fontSize: "+this.getFontSize()+"}";
			return options;
		}
		
	}

	public class ChartArea{
		private int left = 0;
		private int top  = 0;
		private String width  = "99%";
		private String height = "99%";
		/**
		 * @return the left
		 */
		public int getLeft() {
			return left;
		}
		/**
		 * @param left the left to set
		 */
		public void setLeft(int left) {
			this.left = left;
		}
		/**
		 * @return the top
		 */
		public int getTop() {
			return top;
		}
		/**
		 * @param top the top to set
		 */
		public void setTop(int top) {
			this.top = top;
		}
		/**
		 * @return the width
		 */
		public String getWidth() {
			return width;
		}
		/**
		 * @param width the width to set
		 */
		public void setWidth(String width) {
			this.width = width;
		}
		/**
		 * @return the height
		 */
		public String getHeight() {
			return height;
		}
		/**
		 * @param height the height to set
		 */
		public void setHeight(String height) {
			this.height = height;
		}
		
		public String toOptions(){
			String options = "";
			options += "'chartArea':{left:"+this.getLeft()+",top:"+this.getTop()+",width:'"+this.getWidth()+"',height:'"+this.getHeight()+"'}";
			return options;
		}
	}

	public class  Axis{
		
		private boolean vertical = true;
		private String title = "";
		private String color = "red";

		public Axis(){
		}
		
		public String toAxis(){
			if ( vertical )
				return "vAxis: {title: '"+title+"',  titleTextStyle: {color: '"+color+"'}}\n";
			else
				return "hAxis: {title: '"+title+"',  titleTextStyle: {color: '"+color+"'}}\n";
		}

		/**
		 * @return the vertical
		 */
		public boolean isVertical() {
			return vertical;
		}

		/**
		 * @param vertical the vertical to set
		 */
		public void setVertical(boolean vertical) {
			this.vertical = vertical;
		}

		/**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * @param title the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}

		/**
		 * @return the color
		 */
		public String getColor() {
			return color;
		}

		/**
		 * @param color the color to set
		 */
		public void setColor(String color) {
			this.color = color;
		}
	}

	public class Column{
		
		public static final String TYPE_STRING = "string";
		public static final String TYPE_NUMBER = "number";
		
		String type = TYPE_STRING;
		String name = "";
		public Column(String type, String name){
			this.type = type;
			this.name = name;
		}
		
		public String toColumn(){		      
			return "\tdata.addColumn('"+type+"', '"+this.name+"');\n";
		}
	}


	/**
	 * @return the columns
	 */
	public ArrayList<Column> getColumns() {
		return columns;
	}

	/**
	 * @param columns the columns to set
	 */
	public void setColumns(ArrayList<Column> columns) {
		this.columns = columns;
	}


	/**
	 * @return the vAxis
	 */
	public Axis getvAxis() {
		return vAxis;
	}


	/**
	 * @return the hAxis
	 */
	public Axis gethAxis() {
		return hAxis;
	}


}


