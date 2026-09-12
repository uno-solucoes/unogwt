//package com.howmake.client.form.partner;
//
//import java.util.Date;
//import java.util.TreeMap;
//
//import com.br.client.panel.I18N.Tradutor;
//import com.google.gwt.i18n.client.DateTimeFormat;
//import com.google.gwt.i18n.client.NumberFormat;
//import com.howmake.client.form.UI.HowMGWTCheckboxItem;
//import com.howmake.client.form.UI.HowMGWTCodeDescriptor;
//import com.howmake.client.form.UI.HowMGWTDateItem;
//import com.howmake.client.form.UI.HowMGWTFormDateItem;
//import com.howmake.client.form.UI.HowMGWTFormRichTextEditor;
//import com.howmake.client.form.UI.HowMGWTLabel;
//import com.howmake.client.form.UI.HowMGWTPasswordItem;
//import com.howmake.client.form.UI.HowMGWTSelectItem;
//import com.howmake.client.form.UI.HowMGWTTextAreaItem;
//import com.howmake.client.form.UI.HowMGWTTextItem;
//import com.smartgwt.client.data.Record;
//import com.smartgwt.client.types.Alignment;
//import com.smartgwt.client.types.ListGridFieldType;
//import com.smartgwt.client.widgets.Canvas;
//import com.smartgwt.client.widgets.form.DynamicForm;
//import com.smartgwt.client.widgets.form.FormItemInputTransformer;
//import com.smartgwt.client.widgets.form.fields.FormItem;
//import com.smartgwt.client.widgets.form.fields.TextItem;
//import com.smartgwt.client.widgets.grid.CellEditValueFormatter;
//import com.smartgwt.client.widgets.grid.CellEditValueParser;
//import com.smartgwt.client.widgets.grid.CellFormatter;
//import com.smartgwt.client.widgets.grid.ListGridField;
//import com.smartgwt.client.widgets.grid.ListGridRecord;
//
//
//public class HowMGWTProperty{
//	
//	private Object howmFormValue;
//	private String name;
//	private String title;
//	
//	private Integer    widthColumn;
//	
//	private Integer   widthLabel;
//	private Integer   widthField;
//	
//	private HowMGWTListField listField;
//	private HowMGWTFormField formField;
//	private Canvas canvas;
//	
//	private ListGridFieldType type = ListGridFieldType.TEXT;
//	
//	private TreeMap externalProperties = null;
//	
//	private int oderList;
//	private int index;
//
//	private boolean mandatory;
//
//	/**
//	 * Constroi uma property com o nome e o título.
//	 * @param name
//	 * @param title
//	 */
//	public HowMGWTProperty(String name, String title){	
//		this.name 	= name;
//		this.title 	= title;
//	}
//	
//	/**
//	 * @return the name
//	 */
//	public String getName() {
//		return name;
//	}
//	/**
//	 * @param name the name to set
//	 */
//	public void setName(String name) {
//		this.name = name;
//	}
//	/**
//	 * @return the title
//	 */
//	public String getTitle() {
//		return title;
//	}
//	/**
//	 * @param title the title to set
//	 */
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	/**
//	 * @return the widthColumn
//	 */
//	public Integer getWidthColumn() {
//		return widthColumn;
//	}
//	/**
//	 * @param widthColumn the widthColumn to set
//	 */
//	public void setWidthColumn(Integer widthColumn) {
//		this.widthColumn = widthColumn;
//	}
//	/**
//	 * @return the widthLabel
//	 */
//	public Integer getWidthLabel() {
//		return widthLabel;
//	}
//	/**
//	 * @param widthLabel the widthLabel to set
//	 */
//	public void setWidthLabel(Integer widthLabel) {
//		this.widthLabel = widthLabel;
//	}
//	/**
//	 * @return the widthField
//	 */
//	public Integer getWidthField() {
//		return widthField;
//	}
//	/**
//	 * @param widthField the widthField to set
//	 */
//	public void setWidthField(Integer widthField) {
//		this.widthField = widthField;
//	}
//	/**
//	 * @return the listField
//	 */
//	public HowMGWTListField getListField() {
//		return listField;
//	}
//	/**
//	 * @param listField the listField to set
//	 */
//	public void setListField(HowMGWTListField listField) {
//		this.listField = listField;
//	}
//	/**
//	 * @return the formField
//	 */
//	public HowMGWTFormField getFormField() {
//		return formField;
//	}
//	/**
//	 * @param formField the formField to set
//	 */
//	public void setFormField(HowMGWTFormField formField) {
//		this.formField = formField;
//	
//		configureLabelClass();
//		configureWidths();		
//	} 
//
//	/**
//	 * Seta o tamanho do label e do campo para o formulário associado.
//	 * @param widthLabel
//	 * @param widthField
//	 */
//	public void setBound(Integer widthLabel, Integer widthField){
//		this.widthLabel = widthLabel;
//		this.widthField = widthField;
//	}
//	
//	
//	
//
//	/**
//	 * Cria uma coluna do tipo grid.
//	 */
//	public void createHowMGWTListGridField(){
//		
//		if ( this.getWidthColumn() != null )
//			this.listField = new HowMGWTListField(this.name, this.title , this.widthColumn.intValue() );
//		else 
//			this.listField = new HowMGWTListField(this.name, this.title);
//		
//		this.listField.setType(this.getType());
//	
//	}
//	
// 	
//	
//	
//	private void configureWidths(){
//		if ( this.widthField != null && this.widthLabel != null )
//			this.formField.setHowMBound(widthLabel.intValue(), widthField.intValue());		
//	}
//	
//	
//	public Canvas getCanvas(){
//		if ( this.canvas != null )
//			return canvas;
//		Canvas canvas = (Canvas)this.formField;
//		if ( canvas == null )
//			return new HowMGWTLabel("Propriedade : <b>"+this.getName()+"</b> nao foi criada para ser utilizado");
//		return canvas;
//	}
//
//	public Date getHowMValueAsDate() {
//		return HowMGWTUtilities.getDate(this.getHowMValue());
//	}
//
//	public double getHowMValueAsDouble() {
//		return HowMGWTUtilities.getDouble(this.getHowMValue());
//	}
//
//	public String getHowMValue() {
//		String returnValue = "";
//		if (this.formField != null) {
//
//			if (this.getHowMGWTEditorDateItem() != null) {
//				try {
//					Date date = this.getHowMGWTEditorDateItem().getField().getValueAsDate();
//					if (date != null)
//						return HowMGWTUtilities.getFormatDate(date);
//					return "";
//				} catch (Throwable err) {
//					if (HowMGWTUtilities.isEmpty(this.getHowMGWTEditorDateItem().getField().getValue()))
//						return "";
//					else
//						return this.getHowMGWTEditorDateItem().getField().getValue().toString();
//				}
//			}
//
//			returnValue = this.formField.getHowMValueAsString();
//		}
//		return returnValue;
//	}
//
//	public String getHowMValue(ListGridRecord record) {
//		if (record == null)
//			return "";
//
//		if (HowMGWTUtilities.isEmpty(this.getName()))
//			return "";
//
//		Object valor = record.getAttribute(this.getName());
//
//		if (HowMGWTUtilities.isEmpty(valor))
//			return "";
//
//		if( ListGridFieldType.FLOAT.equals(this.getType()) )
//			valor = ""+HowMGWTUtilities.getDouble(valor,true);
//		
//		
//		if (this.getType().equals(ListGridFieldType.DATE)) {
//			try{
//				return HowMGWTUtilities.getFormatDateTime(record.getAttributeAsDate(this.getName()));
//			}
//			catch(Throwable ex){
//				return HowMGWTUtilities.getFormatDateTime(HowMGWTUtilities.getDate(record.getAttribute(this.getName())));
//			}
//		}
//		
//		if (valor instanceof String)
//			return valor.toString();
//		
//		return valor.toString();
//	}
//
//	public boolean getHowMValueBoolean(ListGridRecord record){
//		String valor = getHowMValue(record);
//		if ( HowMGWTUtilities.isEmpty(valor))
//			return false;
//		return HowMGWTUtilities.getBoolean(valor.toString());
//	}
//
//	/**
//	 * @return the mandatory
//	 */
//	public boolean isMandatory() {
//		return mandatory;
//	}
//
//	/**
//	 * @param mandatory the mandatory to set
//	 */
//	public void setMandatory(boolean mandatory) {
//		this.mandatory = mandatory;
//		configureLabelClass();
//	}
//	
//
//	
//	/**
//	 * @return Retorna uma mensagem de erro caso o campo seja obrigatíro e 
//	 * estiver em branco.
//	 */
//	public String getMessageMandatory(){
//		if ( this.isMandatory() ){
//			if ( HowMGWTUtilities.isEmpty(this.getHowMValue())){
//				String msg = Tradutor.i18n.formCampoObrigatorio();
//				return HowMGWTUtilities.replace(msg, "#campo", this.getTitle());
//			}
//		}
//		return "";
//	}
//
//	/**
//	 * @param canvas the canvas to set
//	 */
//	public void setCanvas(Canvas canvas) {
//		this.canvas = canvas;
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	// --------------------------------------------------------------------------------
//	// FABRICA PARA PRODUÇÃO DE CAMPOS DE EDIÇÃO
//	// --------------------------------------------------------------------------------
//	public void createHowMFormRichTextEditor() {
//		this.formField = new HowMGWTFormRichTextEditor(this.name, this.title);
//		this.canvas = (HowMGWTFormRichTextEditor) this.formField;
//		configureLabelClass();
//		configureWidths();
//	}
//
//
//	public void createHowMGWTCheckboxItem(){
//		this.formField = new HowMGWTCheckboxItem(this.name, this.title);
//		configureLabelClass();
//		configureWidths();
//	}
//
//
//	public void createHowMGWTFormCodeDescriptor(){
//		HowMGWTCodeDescriptor codDesc = new HowMGWTCodeDescriptor(this.name, this.title);
//		this.canvas = codDesc;
//		this.canvas.setHeight(22);
//	
//		this.formField = codDesc.getField();
//		configureLabelClass();
//		configureWidths();		
//	}
//	
//	
//	public void createHowMGWTFormFieldPasswordItem(){
//		this.formField = new HowMGWTPasswordItem(this.name, this.title);		
//		configureLabelClass();
//		configureWidths();
//
//	}
//
//	
//	public void createHowMGWTFormFieldAreaItem(){
//		this.formField = new HowMGWTTextAreaItem(this.name, this.title);		
//		configureLabelClass();
//		if ( this.widthField != null && this.widthLabel != null )
//			this.formField.setHowMBound(widthLabel.intValue()-6, widthField.intValue());		
//		this.getHowMGWTEditorTextAreaItem().setHeight(44);
//	}
//
//	
//	public void createHowMGWTFormFieldTextItem(){
//		this.formField = new HowMGWTTextItem(this.name, this.title);		
//		configureLabelClass();
//		configureWidths();
//	}
//	
//	public void createHowMGWTFormFieldSelectItem(){
//
//		this.formField = 	new HowMGWTSelectItem(this.name, this.title);	
//		configureLabelClass();
//		configureWidths();
//	}
//	
//		
//	public void createHowMGWTFormDateItem(){
//		this.formField = new HowMGWTDateItem(this.name, this.title);		
//		configureLabelClass();
//		if ( this.widthField != null && this.widthLabel != null )
//			this.formField.setHowMBound(widthLabel.intValue()-2, widthField.intValue());		
//	}
//
//	
//	public void createHowMGWTFormDateItemInput(){
//		this.formField = new HowMGWTDateItem(this.name, this.title);	
//		((HowMGWTDateItem)this.formField).setHowMUseMask(true);
//		configureLabelClass();
//		if ( this.widthField != null && this.widthLabel != null )
//			this.formField.setHowMBound(widthLabel.intValue()-2, widthField.intValue());		
//	}	
//	
//	public HowMGWTPasswordItem getHowMGWTEditorPasswordItem(){
//		if ( this.formField instanceof HowMGWTPasswordItem )
//			return (HowMGWTPasswordItem)this.canvas;
//		return null;		
//	}
//
//	public HowMGWTFormRichTextEditor getHowMGWTFormRichTextEditor() {
//		if (this.formField instanceof HowMGWTFormRichTextEditor)
//			return (HowMGWTFormRichTextEditor) this.canvas;
//		return null;
//	}
//
//
//	
//	public HowMGWTCodeDescriptor getHowMGWTEditorCodeDescriptor(){
//		if ( this.formField instanceof HowMGWTTextItem )
//			return (HowMGWTCodeDescriptor)this.canvas;
//		return null;
//	}	
//
//	public HowMGWTCheckboxItem getHowMGWTCheckboxItem(){
//		if ( this.formField instanceof HowMGWTCheckboxItem )
//			return (HowMGWTCheckboxItem)this.formField;
//		return null;
//	}	
//	
//	
//	public HowMGWTTextItem getHowMGWTEditorFieldText(){
//		if ( this.formField instanceof HowMGWTTextItem )
//			return (HowMGWTTextItem)this.formField;
//		return null;
//	}	
//	
//	public HowMGWTSelectItem getHowMGWTEditorSelectItem(){
//		if ( this.formField instanceof HowMGWTSelectItem )
//			return (HowMGWTSelectItem)this.formField;
//		return null;
//	}
//	
//	public HowMGWTTextAreaItem getHowMGWTEditorTextAreaItem(){
//		if ( this.formField instanceof HowMGWTTextAreaItem )
//			return (HowMGWTTextAreaItem)this.formField;
//		return null;	
//	}
//	
//	public HowMGWTDateItem getHowMGWTEditorDateItem(){
//		if ( this.formField instanceof HowMGWTDateItem)
//			return (HowMGWTDateItem)this.formField;
//		return null;
//	}
//	
//	
//	protected void configureLabelClass(){
//		String classStyle = "formTitleOptional";
//
//		if ( this.isMandatory() ){
//			classStyle = "formTitleMandatory";
//		}
//			
//		if ( formField != null ){
//			if ( this.getHowMGWTEditorFieldText() != null ){
//				this.getHowMGWTEditorFieldText().getField().setTitleStyle(classStyle);
//			}
//			if ( this.getHowMGWTCheckboxItem() != null ){
//				this.getHowMGWTCheckboxItem().getField().setTitleStyle(classStyle);
//			}
//			else if ( this.getHowMGWTEditorSelectItem() != null ){
//				this.getHowMGWTEditorSelectItem().getField().setTitleStyle(classStyle);
//			}
//			else if ( this.getHowMGWTEditorDateItem() != null ){
//				this.getHowMGWTEditorDateItem().getField().setTitleStyle(classStyle);
//			}
//			else if ( this.getHowMGWTEditorCodeDescriptor() != null ){
//				this.getHowMGWTEditorCodeDescriptor().getField().getField().setTitleStyle(classStyle);
//			}
//			else if ( this.getHowMGWTEditorPasswordItem() != null ){
//				this.getHowMGWTEditorPasswordItem().getField().setTitleStyle(classStyle);
//			}	
//			else if ( this.getHowMGWTEditorTextAreaItem() != null ){
//				this.getHowMGWTEditorTextAreaItem().getField().setTitleStyle(classStyle);
//			}
//			else if (this.getHowMGWTFormRichTextEditor() != null) {
//				this.getHowMGWTFormRichTextEditor().setLabelStyleName(classStyle);
//			}			
//		}
//	}
//
//	/**
//	 * @return the oderList
//	 */
//	public int getOderList() {
//		return oderList;
//	}
//
//	/**
//	 * @param oderList the oderList to set
//	 */
//	public void setOderList(int oderList) {
//		this.oderList = oderList;
//	}
//
//	/**
//	 * @return the type
//	 */
//	public ListGridFieldType getType() {
//		return type;
//	}
//
//	/**
//	 * @param type the type to set
//	 */
//	public void setType(ListGridFieldType type) {
//		this.type = type;
//		if ( this.listField != null )
//			this.listField.setType(this.getType());
//	}
//
//
//	// ------------------------------------------------------------------------------
//	// Fábrica de formatos
//	// ------------------------------------------------------------------------------
//	private static final TreeMap<String , CellFormatter> formats = new TreeMap<String , CellFormatter>();
//
//	
//	public void createFormatDouble(String mask){
//		if( this.listField != null )
//			createFormatDouble(this.listField, mask, "");
//	}
//
//	public void createFormatDouble(String mask, String textFix){
//		if( this.listField != null )
//			createFormatDouble(this.listField, mask, textFix);
//	}
//	
//	public static final void createFormatDouble(ListGridField field , final String mask, final String textFix){
//		CellFormatter formatter = formats.get("double_"+mask);
//		if ( formatter == null ){
//			formatter = new CellFormatter() {
//		        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
//		        	if ( ! HowMGWTUtilities.isEmpty( record.getAttribute("BLANK_ROW") ) )
//		        			return "";
//		        	
//		        	return NumberFormat.getFormat(mask).format(HowMGWTUtilities.getDouble(value))+textFix;
//		        }
//			};
//			formats.put("double_"+mask, formatter);
//		}
//		field.setType(ListGridFieldType.FLOAT);
//		field.setCellFormatter(formatter);
//	}
//	
//
//	
//	public void createFormatDate( String mask ){
//		createFormatDate(this.getListField(), mask);
//	}
//	
//	public static final void createFormatDate(ListGridField field , final String mask){
//		CellFormatter formatter = formats.get(mask);
//		if ( formatter == null ){
//			formatter = new CellFormatter() {
//		        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
//		        	if ( HowMGWTUtilities.isEmpty(value))
//		        		return "";
//		        	if ( value instanceof String ){
//		        		Date date = HowMGWTUtilities.getDate(value.toString());
//		        		if ( HowMGWTUtilities.isEmpty(date) )
//		        			return "";
//			            return DateTimeFormat.getFormat(mask).format(date);
//		        	}
//		            return DateTimeFormat.getFormat(mask).format((Date)value);
//		        }
//			};
//			formats.put(mask, formatter);
//		}
//		field.setType(ListGridFieldType.FLOAT);
//		field.setCellFormatter(formatter);
//	}	
//	
//	
//
//	/**
//	 * Seta um valor no campo do registro em questão
//	 * @param record
//	 * @param value
//	 */
//	public void setHowMValue(ListGridRecord record, String value){
//		if ( this.getType().equals(ListGridFieldType.TEXT )){
//			record.setAttribute(this.getName(), value);				
//		}
//		else if ( this.getType().equals(ListGridFieldType.FLOAT)){
//			record.setAttribute(this.getName(),HowMGWTUtilities.getDouble(value) );								
//		}
//		else if ( this.getType().equals(ListGridFieldType.INTEGER)){
//			record.setAttribute(this.getName(), HowMGWTUtilities.getInteger(value) );	
//		}
//		else if ( this.getType().equals(ListGridFieldType.BOOLEAN)){
//			record.setAttribute(this.getName(), HowMGWTUtilities.getBoolean(value) );	
//		}
//		else if ( this.getType().equals(ListGridFieldType.DATE)){
//			record.setAttribute(this.getName(), HowMGWTUtilities.getDate(value));
//		}		
//	}
//
//	/**
//	 * @return the index
//	 */
//	public int getIndex() {
//		return index;
//	}
//
//	/**
//	 * @param index the index to set
//	 */
//	public void setIndex(int index) {
//		this.index = index;
//	}
//
//	/**
//	 * @return the externalProperties
//	 */
//	public TreeMap getExternalProperties() {
//		if ( externalProperties == null )
//			externalProperties = new TreeMap();
//		return externalProperties;
//	}
//
//	
//	
//	private static FormItemInputTransformer INPUT_TRANSFORMER_DOUBLE = new FormItemInputTransformer() {			
//		public Object transformInput(DynamicForm form, FormItem item, Object value, Object oldValue) {
//
//			if( value != null ){					
//				String filterValue = "";
//				int sep = 0;
//				char[] chars = value.toString().toCharArray();
//				if( chars != null ){
//					int i = 0;
//					for ( char c : chars){
//						if ( (int)c == 46 )
//							c = ',';
//						if ( ( ((int)c) >= 48 && ((int)c) <=57) || ((int)c) == 44 ){
//							if ( ((int)c) == 44 ){
//								sep ++;
//								// Não deixa repetir o separador decimal.
//								if ( sep > 1)
//									continue;
//								if( i == 0 ){
//									filterValue += "0";
//								}
//							}
//							filterValue += ""+c;
//							i ++;
//						}
//					}					
//					value = filterValue;
//				}
//			}
//			return value;
//		}			
//	};		
//	
//	private static FormItemInputTransformer INPUT_TRANSFORMER_INTEGER = new FormItemInputTransformer() {			
//		public Object transformInput(DynamicForm form, FormItem item, Object value, Object oldValue) {
//
//			if( value != null ){					
//				String filterValue = "";
//				int sep = 0;
//				char[] chars = value.toString().toCharArray();
//				if( chars != null ){
//					int i = 0;
//					for ( char c : chars){
//						if ( ( ((int)c) >= 48 && ((int)c) <=57) ){
//							filterValue += ""+c;
//							i ++;
//						}
//					}					
//					value = filterValue;
//				}
//			}
//			return value;
//		}			
//	};			
//
//	public static FormItemInputTransformer getInputIntegerTransformer(){
//		return INPUT_TRANSFORMER_INTEGER;
//	}
//	
//	
//	public void configureInputInteger(){
//		configureInputInteger(this.getListField());
//	}	
//	
//	
//	public static FormItemInputTransformer getInputDoubleTransformer(){
//		return INPUT_TRANSFORMER_DOUBLE;
//	}
//	
//	
//	public void configureInputDecimal(){
//		configureInputDecimal(this.getListField(),"##0.00");
//	}
//	
//	public void configureInputDecimal(String mask){
//		configureInputDecimal(this.getListField(), mask);
//	}
//
//	
//	/**
//	 * Configura o campo da grid para digitação somente de números com 
//	 * separador decimal.
//	 */
//	public static TextItem configureInputInteger(ListGridField field){
//        final TextItem inputField = new TextItem();
//		inputField.setInputTransformer(HowMGWTProperty.getInputDoubleTransformer());	
//		field.setEditorType(inputField); 
//		return inputField;
//	}
//
//	public static void configureInputInteger(TextItem item){
//		item.setInputTransformer(HowMGWTProperty.getInputIntegerTransformer());	
//	}
//	
//	public static void configureInputDecimal(TextItem item, final String mask){
//		item.setInputTransformer(HowMGWTProperty.getInputDoubleTransformer());	
//	}
//	
//	/**
//	 * Configura o campo da grid para digitação somente de números com 
//	 * separador decimal.
//	 */
//	public static TextItem configureInputDecimal(ListGridField field, final String mask){
//        final TextItem inputField = new TextItem();
//		inputField.setInputTransformer(HowMGWTProperty.getInputDoubleTransformer());	
//		field.setEditValueFormatter(new CellEditValueFormatter() {
//			@Override
//			public Object format(Object value, ListGridRecord record, int rowNum, int colNum) {				
//				if ( value != null ){
//					System.out.println("Valor de entrada : "+value);
//					return NumberFormat.getFormat(mask).format(HowMGWTUtilities.getDouble(value));
//				}
//				return value ;
//			}
//		});
//		field.setEditValueParser(new CellEditValueParser() {			
//			@Override
//			public Object parse(Object value, ListGridRecord record, int rowNum,int colNum) {			
//				System.out.println("Parser : "+value+" convertido : "+HowMGWTUtilities.getDouble(value));
//
//				return HowMGWTUtilities.getDouble(value);
//			}
//		});
//		field.setEditorType(inputField); 
//		return inputField;
//	}
//	
// 
//	
//	public void onHowMGWTSelect(boolean selected){
//	}
//
//
//
//	/**
//	 * @return the howmFormValue
//	 */
//	public Object getHowmFormValue() {
//		if ( this.formField != null )
//			return this.formField.getHowMValue();
//		
//		return howmFormValue;
//	}
//
//	public String getHowmFormValueToString(){
//		return 	HowMGWTUtilities.getObjectString(this.getHowmFormValue());
//	}
//
//	/**
//	 * @param howmFormValue the howmFormValue to set
//	 */
//	public void setHowmFormValue(Object howmFormValue) {
//		if ( this.formField != null )
//			this.formField.setHowMValue(howmFormValue);
//
//		this.howmFormValue = howmFormValue;
//	}
//	
//	public HowMGWTFormDateItem getHowMFieldDateItemEditor() {
//		if (this.formField instanceof HowMGWTFormDateItem)
//			return (HowMGWTFormDateItem) this.formField;
//		return null;
//	}	
//}


package com.howmake.client.form.partner;

import java.util.Date;
import java.util.TreeMap;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.howmake.client.I18N.HowMTradutor;
import com.howmake.client.form.UI.HowMGWTCheckboxItem;
import com.howmake.client.form.UI.HowMGWTCodeDescriptor;
import com.howmake.client.form.UI.HowMGWTDateItem;
import com.howmake.client.form.UI.HowMGWTFormCheckboxItem;
import com.howmake.client.form.UI.HowMGWTFormCodeDescriptor;
import com.howmake.client.form.UI.HowMGWTFormColorPickerItem;
import com.howmake.client.form.UI.HowMGWTFormComboBox;
import com.howmake.client.form.UI.HowMGWTFormDateItem;
import com.howmake.client.form.UI.HowMGWTFormDateItemRange;
import com.howmake.client.form.UI.HowMGWTFormLabel;
import com.howmake.client.form.UI.HowMGWTFormLabelValue;
import com.howmake.client.form.UI.HowMGWTFormLookup;
import com.howmake.client.form.UI.HowMGWTFormPasswordItem;
import com.howmake.client.form.UI.HowMGWTFormRichTextEditor;
import com.howmake.client.form.UI.HowMGWTFormSampleLabel;
import com.howmake.client.form.UI.HowMGWTFormSelectItem;
import com.howmake.client.form.UI.HowMGWTFormTextAreaItem;
import com.howmake.client.form.UI.HowMGWTFormTextItem;
import com.howmake.client.form.UI.HowMGWTFormTextItemInteger;
import com.howmake.client.form.UI.HowMGWTFormTextItemMoney;
import com.howmake.client.form.UI.HowMGWTGridCheckboxItem;
import com.howmake.client.form.UI.HowMGWTGridComboBoxItem;
import com.howmake.client.form.UI.HowMGWTGridDateItem;
import com.howmake.client.form.UI.HowMGWTGridSelectItem;
import com.howmake.client.form.UI.HowMGWTGridTextItem;
import com.howmake.client.form.UI.HowMGWTGridTextItemInteger;
import com.howmake.client.form.UI.HowMGWTGridTextItemMoney;
import com.howmake.client.form.UI.HowMGWTPasswordItem;
import com.howmake.client.form.UI.HowMGWTSelectItem;
import com.howmake.client.form.UI.HowMGWTTextAreaItem;
import com.howmake.client.form.UI.HowMGWTTextItem;
import com.howmake.client.form.partner.listener.HowMGWTPropertyListener;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.FormItemInputTransformer;
import com.smartgwt.client.widgets.form.FormItemValueFormatter;
import com.smartgwt.client.widgets.form.FormItemValueParser;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class HowMGWTProperty {
	
	private HowMGWTPropertyListener howMPropertyListener;
	
	private boolean grantVisible 	= true;	
	
	private boolean gridEditorON 	= false;
	
	private boolean showTitle 		= true;

	private String fullName			= null;
	
	public boolean isShowTitle() {
		return showTitle;
	}

	public void setVisibleTitle(boolean showTitle) {
		this.showTitle = showTitle;
		
		if( this.formField != null ){
			// this.formField.setVisibleTitle(this.showTitle);
		}
	}

	private int howMModeOperation   = HowMGWTUtilities.OPERATION_INSERT;
	
	private boolean howMCanEditMode = false;
	private boolean howMCanNewMode  = false;
	
	private int howMLength			= -1;
	
	private String convertMask;

	private String howMPlaceholder;	

	// private boolean shortDate = true;
	
	private String fieldID = SC.generateID(this.getClass().getName());
	
	/**
	 * true  - Permite edição nos dados do campo quando o modo for edição ou navegação.
	 * false - Não permite alteração nos dados quando o modo for edição ou navegação.1
	 */
	private boolean grantEdit = true;

	/**
	 * true  - Permite edição nos dados do campo quando o modo for novo registro.
	 * false - Não permite alteração nos dados quando o modo for novo registro.
	 */
	private boolean grantNew  = true;

	/**
	 * Nome do atributo, utilizado para setar os dados no registro de navegação e campo de edição.
	 */
	private String				name;
	/**
	 * Título que o atributo terá a direita ou conforme alinhamento do formulário definido.
	 */
	private String				title;

	/**
	 * Largura da coluna quando for tipo grid.
	 */
	private Integer				widthColumn;

	/**
	 * Largura do label do campo quando for modo formulário.
	 */
	private Integer				widthLabel;
	/**
	 * Largura do campo quando for modo formulário.
	 */
	private Integer				widthField;

	private HowMGWTDataSource	dataSourceField;
	
	private HowMGWTListField	listField;
	private HowMGWTFormField	formField;
	
	private String 				databaseExpression;
	private String 				databaseType;	
	
	/**
	 * Contém a área gráfica em que a propriedade está sendo visualizada, caso 
	 * o valor seja null, então a propriedade não está sendo apresentada para o 
	 * usuário.
	 */
	private Canvas				canvas;

	private ListGridFieldType	type				= ListGridFieldType.TEXT;

	/**
	 * Mapa de propriedades vinculadas a propriedade em questão, normalmente 
	 * utilizada em lookups.
	 */
	private TreeMap				externalProperties	= null;

	private int					oderList;
	private int					index;

	private boolean				clearValue			= true;

	private boolean 			primaryKey			= false;
	private boolean				mandatory			= false;
	private boolean 			visible				= true;
	
	private Object				workObject;
	private String				workVariavel;
	
	private Object				howmFormValue;
	private Object				howmFormValueDescription;

	private String 				howMSelectValue;
	private String 				howMUnselectValue;
	
	private String				HowMMask;
	private String 				HowMValid;
	
	/**
	 * Constroi uma property com o nome e o titulo.
	 * 
	 * @param name
	 * @param title
	 */
	public HowMGWTProperty(String name, String title) {
		this.name = name;
		this.title = title;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
		if ( this.listField != null )
			this.listField.setName(this.name);
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
		if ( this.listField != null )
			this.listField.setTitle(this.title);
	}

	/**
	 * @return the widthColumn
	 */
	public Integer getWidthColumn() {
		return widthColumn;
	}

	/**
	 * @param widthColumn
	 *            the widthColumn to set
	 */
	public void setWidthColumn(Integer widthColumn) {
		this.widthColumn = widthColumn;
	}

	/**
	 * @return the widthLabel
	 */
	public Integer getWidthLabel() {
		return widthLabel;
	}

	/**
	 * @param widthLabel
	 *            the widthLabel to set
	 */
	public void setWidthLabel(Integer widthLabel) {
		this.widthLabel = widthLabel;
	}

	/**
	 * @return the widthField
	 */
	public Integer getWidthField() {
		return widthField;
	}

	/**
	 * @param widthField
	 *            the widthField to set
	 */
	public void setWidthField(Integer widthField) {
		this.widthField = widthField;
	}

	/**
	 * @return the listField
	 */
	public HowMGWTListField getListField() {
		return listField;
	}

	/**
	 * @param listField
	 *            the listField to set
	 */
	public void setListField(HowMGWTListField listField) {
		this.listField = listField;
	}

	/**
	 * @return the formField
	 */
	public HowMGWTFormField getFormField() {
		return formField;
	}

	/**
	 * Retorna true se a propriedade estiver com o editor em focus.
	 * @return
	 */
	public boolean howMHasFocus(){
		if( this.getFormField() != null ){
//			DynamicForm form = this.getFormField().getHowMForm();
//			if( form != null ){
//				if( form.getFocusItem() != null ) {
//					return true;
//				}
//			}
		}
		return false;
	}
	

	/**
	 * @param formField
	 *            the formField to set
	 */
	public void setFormField(HowMGWTFormField formField) {
		this.formField = formField;

		configureLabelClass();
		configureWidths();
	}

	/**
	 * Seta o tamanho do label e do campo para o formulário associado.
	 * 
	 * @param widthLabel
	 * @param widthField
	 */
	public void setBound(Integer widthLabel, Integer widthField) {
		this.widthLabel = widthLabel;
		this.widthField = widthField;
		configureWidths();
	}

	/**
	 * Seta o tamanho do label e do campo para o formulário associado.
	 * 
	 * @param widthLabel
	 * @param widthField
	 */
	public void setBound(Integer widthLabel) {
		this.widthLabel = widthLabel;
		this.widthField = -1;
		configureWidths();
	}

	public void createHowMGWTDataSourceField() {
		createHowMGWTDataSourceField(true);
	}	
	/**
	 * Cria uma coluna do tipo grid.
	 */
	public void createHowMGWTDataSourceField(boolean controleListGridField) {

		this.dataSourceField = new HowMGWTDataSource();
		this.dataSourceField.setName(this.name);
		this.dataSourceField.setTitle(this.title);
		if (this.getWidthColumn() != null){
			this.dataSourceField.setLength(this.getWidthColumn());			
		}

		if( controleListGridField ){
			if ( this.listField == null ){
				this.dataSourceField.setHidden(true);
			}
		}		
		if ( this.isPrimaryKey() )
			this.dataSourceField.setPrimaryKey(true);
	
		if ( getType() == null )
			this.dataSourceField.setType(FieldType.TEXT);
		else if ( getType().equals(ListGridFieldType.TEXT))
			this.dataSourceField.setType(FieldType.TEXT);
		else if ( getType().equals(ListGridFieldType.FLOAT))
			this.dataSourceField.setType(FieldType.FLOAT);
		else if ( getType().equals(ListGridFieldType.INTEGER))
			this.dataSourceField.setType(FieldType.INTEGER);
		else if ( getType().equals(ListGridFieldType.IMAGE))
			this.dataSourceField.setType(FieldType.IMAGE);
		else if ( getType().equals(ListGridFieldType.DATE)) 
			this.dataSourceField.setType(FieldType.DATE); 
		else if ( getType().equals(ListGridFieldType.BOOLEAN))
			this.dataSourceField.setType(FieldType.BOOLEAN);
	}

	/**
	 * Cria uma coluna do tipo grid.
	 */
	public ListGridField createHowMGWTListGridField() {

		if (this.getWidthColumn() != null)
			this.listField = new HowMGWTListField(this.name, this.title, this.widthColumn.intValue());
		else
			this.listField = new HowMGWTListField(this.name, this.title);

		this.listField.setType(this.getType());

		return this.listField;

	}

	private void configureField(){
		if ( this.formField != null ){
			if ( this.getHowMFieldTextEditor() != null ){
				Object value = this.getHowmFormValue();
				this.getHowMFieldTextEditor().getField().setMask(this.getHowMMask());
				this.setHowmFormValue(value);
				if( this.howMLength > 0 ){
					this.getHowMFieldTextEditor().getField().setLength(this.howMLength);
				}
				
				// Seta uma dica para quando o campo não tiver valor
				if( ! HowMGWTUtilities.isEmpty( this.getHowMPlaceholder() )){
					// this.getHowMFieldTextEditor().getField().setEmptyDisplayValue(this.getHowMPlaceholder());
					this.getHowMFieldTextEditor().getField().setAttribute("placeholder", this.getHowMPlaceholder());
				}
			}
			if( this.getHowMFieldTextAreaItemEditor() != null ){
				if( this.howMLength > 0 ){
					this.getHowMFieldTextAreaItemEditor().getField().setLength(this.howMLength);
				}				
			}
		}
		configureLabelClass();
		configureWidths();		
	}

	private void configureWidths() {
		if (this.widthField != null && this.widthLabel != null && this.formField != null) {
			
			if ( getHowMFieldCheckboxItemEditor() != null)
				this.formField.setHowMBound(widthLabel.intValue() - 3, widthField.intValue());
			else {
				if (this.widthField.intValue() == -1){
					// this.formField.setHowMBound(widthLabel.intValue());
				}
				else
					this.formField.setHowMBound(widthLabel.intValue(), widthField.intValue());
			}
		}
	}

	public Canvas getCanvas() {
		if (this.canvas != null)
			return canvas;
 
		if( ! ( this.formField instanceof Canvas ) )
			return null;
			
		Canvas canvas = (Canvas) this.formField;
		if (canvas == null)
			return new HowMGWTFormLabel("Propriedade : <b>" + this.getName() + "</b> nao foi criada para ser utilizado");

		return canvas;
	}

	public Canvas getInternalCanvas() {
		if (this.canvas != null)
			return canvas;
 
		if( ! ( this.formField instanceof Canvas ) )
			return null;
			
		Canvas canvas = (Canvas) this.formField;
		
		return canvas;
	}
	
	
	public Date getHowMValueAsDate() {
		return HowMGWTUtilities.getDate(this.getHowMValue());
	}

	public double getHowMValueAsDouble() {
		return HowMGWTUtilities.getDouble(this.getHowMValue());
	}

	public String getHowMValue() {
		String returnValue = "";
		if (this.formField != null) {

			if (this.getHowMFieldDateItemEditor() != null) {
				try {
					Date date = this.getHowMFieldDateItemEditor().getField().getValueAsDate();
					if (date != null)
						return HowMGWTUtilities.getFormatDate(date);
					return "";
				} catch (Throwable err) {
					if (HowMGWTUtilities.isEmpty(this.getHowMFieldDateItemEditor().getField().getValue()))
						return "";
					else
						return this.getHowMFieldDateItemEditor().getField().getValue().toString();
				}
			}

			returnValue = this.formField.getHowMValueAsString();
		}
		return returnValue;
	}

	public String getHowMValue(ListGridRecord record) {
		if (record == null)
			return "";

		if (HowMGWTUtilities.isEmpty(this.getName()))
			return "";

		Object valor = record.getAttribute(this.getName());

		if (HowMGWTUtilities.isEmpty(valor))
			return "";

		if( ListGridFieldType.FLOAT.equals(this.getType()) )
			valor = ""+HowMGWTUtilities.getDouble(valor,true);
		
		
		if (this.getType().equals(ListGridFieldType.DATE)) {
			try{
				return HowMGWTUtilities.getFormatDateTime(record.getAttributeAsDate(this.getName()));
			}
			catch(Throwable ex){
				return HowMGWTUtilities.getFormatDateTime(HowMGWTUtilities.getDate(record.getAttribute(this.getName())));
			}
		}
		
		if (valor instanceof String)
			return valor.toString();
		
		return valor.toString();
	}

	public boolean getHowMValueBoolean(ListGridRecord record) {
		String valor = getHowMValue(record);
		if (HowMGWTUtilities.isEmpty(valor))
			return false;
		return HowMGWTUtilities.getBoolean(valor.toString());
	}

	/**
	 * @return the mandatory
	 */
	public boolean isMandatory() {
		return mandatory;
	}

	/**
	 * @param mandatory
	 *            the mandatory to set
	 */
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
		configureLabelClass();
	}

	/**
	 * @return Retorna uma mensagem de erro caso o campo seja obrigatóro e
	 *         estiver em branco.
	 */
	public String getMessageMandatory() {
		if (this.isMandatory()) {
			if ( HowMGWTUtilities.isEmpty(this.getHowMValue())) {
				String msg = HowMTradutor.i18n.formCampoObrigatorio();
				return HowMGWTUtilities.replace(msg, "#campo", this.getTitle());
			}
		}
		return "";
	}


	/**
	 * @return Retorna uma mensagem de erro caso o campo seja obrigatóro e
	 *         estiver em branco.
	 */
	public String getMessageMandatory(ListGridRecord record) {
		if (this.isMandatory()) {
			if ( HowMGWTUtilities.isEmpty(this.getHowMValue(record))) {
				String msg = HowMTradutor.i18n.formCampoObrigatorio();
				return HowMGWTUtilities.replace(msg, "#campo", this.getTitle());
			}
		}
		return "";
	}
	
	
	/**
	 * @param canvas
	 *            the canvas to set
	 */
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	// --------------------------------------------------------------------------------
	// FABRICA PARA PRODUCÇAO DE CAMPOS DE EDIção
	// --------------------------------------------------------------------------------

	
	public void createHowMFieldRichTextEditor() {
		this.formField = new HowMGWTFormRichTextEditor(this.fieldID, this.title);
		this.canvas = (HowMGWTFormRichTextEditor) this.formField;
		configureField();
	}

	public HowMGWTFormField createHowMFieldCheckboxItem() {
		this.formField = new HowMGWTFormCheckboxItem(this.fieldID, this.title);
		configureField();
		configureCheckboxValues();
		
		return this.formField;
	}

	
	public void createHowMGridFieldCheckboxItem() {
		this.formField = new HowMGWTGridCheckboxItem(this.fieldID, this.title);
		this.setHowMSelectValue("1");
		this.setHowMUnselectValue("0");
		this.setType(ListGridFieldType.BOOLEAN);
		this.createHowMGWTListGridField();	
		this.getListField().setEditorType(this.getHowMGridFieldCheckboxItemEditor().getField());
		configureField();
		configureCheckboxValues();
	}

 
	
	public void createHowMFieldLookup() {
		this.formField = new HowMGWTFormLookup(this.fieldID, this.title);
		this.canvas = (HowMGWTFormLookup) this.formField;
		configureField();
	}
	
	public HowMGWTFormField createHowMFieldLabelValue() {
		this.formField = new HowMGWTFormLabelValue(this.fieldID, this.title);
		this.canvas = (HowMGWTFormLabelValue) this.formField;
		configureField();
		
		return this.formField;
	}

	public void createHowMFieldLabelTopValue() {
		this.formField = new HowMGWTFormLabelValue(this.fieldID, this.title, VerticalAlignment.TOP);
		this.canvas = (HowMGWTFormLabelValue) this.formField;
		configureField();
	}


	public void createHowMFieldSampleLabel() {
		this.formField = new HowMGWTFormSampleLabel();
		this.canvas = (HowMGWTFormSampleLabel) this.formField;
		configureField();
	}
	
	

	public void createHowMFieldCodeDescriptor() {
		HowMGWTFormCodeDescriptor codDesc = new HowMGWTFormCodeDescriptor(this.fieldID, this.title);
		this.canvas = codDesc;
		this.canvas.setHeight(22);

		this.formField = codDesc.getField();
		configureField();
	}

	public void createHowMFieldPasswordItem() {
		this.formField = new HowMGWTFormPasswordItem(this.fieldID, this.title);
		this.canvas = (HowMGWTFormPasswordItem) this.formField;
		configureField();
	}

	public HowMGWTFormField createHowMFieldAreaItem() {
		this.formField = new HowMGWTFormTextAreaItem(this.fieldID, this.title);
		configureLabelClass();
		if (this.widthField != null && this.widthLabel != null)
			this.formField.setHowMBound(widthLabel.intValue() - 6, widthField.intValue());

		this.getHowMFieldTextAreaItemEditor().setHeight(44);
		
		return this.formField;
	}

	
	
	public void createHowMFieldColorPickerItem() {
		this.formField = new HowMGWTFormColorPickerItem(this.fieldID, this.title);
		configureField();
	}

	public HowMGWTFormField createHowMFieldTextItem() {
		this.formField = new HowMGWTFormTextItem(this.fieldID, this.title);
	
		configureField();
		
		return this.formField;
	}

	public void createHowMFieldTelefone(){
		this.createHowMFieldTextItem();
		this.getHowMFieldTextEditor().getField().setMask("(##) #####-####");
		this.getHowMFieldTextEditor().getField().setMaskSaveLiterals(true);
	}
	
//
//	public void createHowmFieldCPF(){
//		this.createHowMFieldTextItem();
//		configureCPF();
//	}
//	
//	public void createHowmFieldCNPJ(){
//		this.createHowMFieldTextItem();
//		configureCNPJ();
//	}

//	public void configureCPF(){
//		this.getHowMFieldTextEditor().getField().setMask(Tradutor.i18n.formMaskCPF());
//		this.getHowMFieldTextEditor().getField().setMaskSaveLiterals(true);			
//		System.out.println("Configura CPF...");
//	}
//	
//	public void configureCNPJ(){
//		this.getHowMFieldTextEditor().getField().setMask(Tradutor.i18n.formMaskCNPJ());
//		this.getHowMFieldTextEditor().getField().setMaskSaveLiterals(true);
//		System.out.println("Configura CNPJ...");
//	}
	
	
	public HowMGWTFormField createHowMFieldCurrencyItem() {
		this.createHowMFieldTextItem();
		this.setHowmFormValue("0.00");
		this.configureInputDecimal(this.getHowMFieldTextEditor().getField(), "#,##0.00");
		this.getHowMFieldTextEditor().getField().setTextAlign(Alignment.RIGHT);
		configureField();
		return this.formField;
	}

	public HowMGWTFormField createHowMFieldCurrencyItem(String mask) {
		this.createHowMFieldTextItem();
		this.setHowmFormValue("0.00");
		this.configureInputDecimal(this.getHowMFieldTextEditor().getField(), mask);
		this.getHowMFieldTextEditor().getField().setTextAlign(Alignment.RIGHT);
		configureField();
		return this.formField;
	}

	
	
	public void createHowMFieldIntegerItem() {
		this.createHowMFieldTextItem();
		this.setHowmFormValue("0");
		this.configureInputInteger(this.getHowMFieldTextEditor().getField());
	
		configureField();
	}
	

	public HowMGWTGridTextItem getHowMGridFieldTextItem(){
		return (HowMGWTGridTextItem)this.formField;
	}
	
	public void createHowMGridFieldTextItem() {
		this.gridEditorON = true;

		this.formField = new HowMGWTGridTextItem(this.fieldID, this.title);
		this.createHowMGWTListGridField();
		this.getListField().setEditorProperties(this.getHowMGridFieldTextEditor().getField());
		configureField();
	}

	
	public void createHowMGridFieldTextItem(String mask, boolean  preservMask) {
		this.gridEditorON = true;

		this.formField = new HowMGWTGridTextItem(this.fieldID, this.title);
		((HowMGWTGridTextItem)this.formField).getField().setMask(mask);
		((HowMGWTGridTextItem)this.formField).getField().setMaskSaveLiterals(preservMask);
		System.out.println("Configura CNPJ Grid...");
		this.createHowMGWTListGridField();
		this.getListField().setEditorProperties(this.getHowMGridFieldTextEditor().getField());
		configureField();
	}
	
	public void createHowMGridFieldSelectItem() {
		this.gridEditorON = true;
		
		this.formField = new HowMGWTGridSelectItem(this.fieldID, this.title);
		this.createHowMGWTListGridField();
		this.getListField().setEditorProperties(this.getHowMGridSelectItem().getField());
		configureField();
	}
	

	public void createHowMGridFieldComboBoxItem() {
		this.gridEditorON = true;
		
		this.formField = new HowMGWTGridComboBoxItem(this.fieldID, this.title);
		this.createHowMGWTListGridField();
		this.getListField().setEditorProperties(this.getHowMGridComboBoxItem().getField());
		configureField();
	}
	
	
	public void createHowMGridFieldTextItemMoney() {
		this.gridEditorON = true;

		this.formField = new HowMGWTGridTextItemMoney(this.fieldID, this.title, this);
		this.setType(ListGridFieldType.FLOAT);
		this.createHowMGWTListGridField();
		this.getListField().setEditorProperties(this.getHowMGridFieldTextEditor().getField());
		this.createFormatDouble("#,##0.00");
		configureField();
	}

	public void createHowMGridFieldTextItemMoney(String mask) {
		this.gridEditorON = true;

		this.formField = new HowMGWTGridTextItemMoney(this.fieldID, this.title, this, mask);
		this.setType(ListGridFieldType.FLOAT);
		this.createHowMGWTListGridField();
		this.getListField().setEditorProperties(this.getHowMGridFieldTextEditor().getField());
		this.createFormatDouble(mask);
		this.setHowMMask(mask);
		// configureField();
	}
	
	
	public void createHowMGridFieldTextItemInteger() {
		this.gridEditorON = true;
		this.formField = new HowMGWTGridTextItemInteger(this.fieldID, this.title, this);
		this.setType(ListGridFieldType.INTEGER);
		this.createHowMGWTListGridField();
		this.getListField().setEditorProperties(this.getHowMGridFieldTextEditor().getField());
		this.createFormatDouble("##0");
		configureField();
	}
	
	
	
	public void createHowMFieldTextItemMoney() {
		this.formField = new HowMGWTFormTextItemMoney(this.fieldID, this.title, this);
		configureField();
	}
	
	public void createHowMFieldTextItemInteger() {
		this.formField = new HowMGWTFormTextItemInteger(this.fieldID, this.title, this);
		configureField();
	}

	
	public void createHowMFieldComboBox() {

		this.formField = new HowMGWTFormComboBox(this.fieldID, this.title);
		this.canvas = (HowMGWTFormComboBox)this.formField;
		HowMGWTFormComboBox comboBox = (HowMGWTFormComboBox) this.formField;
		comboBox.setValidateOnChange(true);

		configureField();
	}

	public HowMGWTFormField createHowMFieldSelectItem() {

		this.formField = new HowMGWTFormSelectItem(this.fieldID, this.title);
		configureField();
		
		return this.formField;
	}

	public void createHowMGridFieldDateItem() {
		this.gridEditorON = true;
		this.formField = new HowMGWTGridDateItem(this.fieldID, this.title);
		this.setType(ListGridFieldType.DATE);
		this.createHowMGWTListGridField();
		this.getListField().setEditorProperties(this.getHowMGridFieldDateItemEditor().getField());
		configureLabelClass();
		 
	}	
	
	public void createHowMFieldDateItem() {
		this.formField = new HowMGWTFormDateItem(this.fieldID, this.title);
		configureLabelClass();
		if (this.widthField != null && this.widthLabel != null)
			this.formField.setHowMBound(widthLabel.intValue() - 7, widthField.intValue());
	}

	public void createHowMFieldDateItemRange() {
		this.formField = new HowMGWTFormDateItemRange(this.fieldID, this.title);
		configureLabelClass();
		if (this.widthField != null && this.widthLabel != null)
			this.formField.setHowMBound(widthLabel.intValue() - 7, widthField.intValue());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public HowMGWTFormRichTextEditor getHowMFieldRichTextEditor() {
		if (this.formField instanceof HowMGWTFormRichTextEditor)
			return (HowMGWTFormRichTextEditor) this.canvas;
		return null;
	}

	public HowMGWTFormPasswordItem getHowMFieldPasswordItemEditor() {
		if (this.formField instanceof HowMGWTFormPasswordItem)
			return (HowMGWTFormPasswordItem) this.canvas;
		return null;
	}

	
	public HowMGWTFormColorPickerItem getHowMFieldColorPickerItem() {
		if (this.formField instanceof HowMGWTFormColorPickerItem)
			return (HowMGWTFormColorPickerItem) this.formField;
		return null;
	}

	
	public HowMGWTFormCodeDescriptor getHowMFieldCodeDescriptorEditor() {
		if (this.formField instanceof HowMGWTFormTextItem)
			// TODO VERIFICAR AQUI
			return (HowMGWTFormCodeDescriptor) this.canvas;
		return null;
	}

	public HowMGWTFormCheckboxItem getHowMFieldCheckboxItemEditor() {
		if (this.formField instanceof HowMGWTFormCheckboxItem)
			return (HowMGWTFormCheckboxItem) this.formField;
		return null;
	}

	public HowMGWTGridCheckboxItem getHowMGridFieldCheckboxItemEditor() {
		if (this.formField instanceof HowMGWTGridCheckboxItem)
			return (HowMGWTGridCheckboxItem) this.formField;
		return null;
	}

		
	public HowMGWTFormLookup getHowMFieldLookup() {
		if (this.formField instanceof HowMGWTFormLookup)
			return (HowMGWTFormLookup) this.formField;
		return null;
	}
	
	public HowMGWTFormLabelValue getHowMFieldLabelValue() {
		if (this.formField instanceof HowMGWTFormLabelValue)
			return (HowMGWTFormLabelValue) this.formField;
		return null;
	}

	public HowMGWTFormTextItem getHowMFieldTextEditor() {
		if (this.formField instanceof HowMGWTFormTextItem)
			return (HowMGWTFormTextItem) this.formField;
		return null;
	}
	
	
	public HowMGWTGridSelectItem getHowMGridSelectItem() {
		if (this.formField instanceof HowMGWTGridSelectItem)
			return (HowMGWTGridSelectItem) this.formField;
		return null;
	}	

	public HowMGWTGridComboBoxItem getHowMGridComboBoxItem() {
		if (this.formField instanceof HowMGWTGridComboBoxItem)
			return (HowMGWTGridComboBoxItem) this.formField;
		return null;
	}	
	
	
	public HowMGWTGridTextItem getHowMGridFieldTextEditor() {
		if (this.formField instanceof HowMGWTGridTextItem)
			return (HowMGWTGridTextItem) this.formField;
		return null;
	}	
	
	public HowMGWTFormComboBox getHowMFieldComboBoxEditor() {
		if (this.formField instanceof HowMGWTFormComboBox)
			return (HowMGWTFormComboBox) this.formField;
		return null;
	}

	public HowMGWTFormSelectItem getHowMFieldSelectItemEditor() {
		if (this.formField instanceof HowMGWTFormSelectItem)
			return (HowMGWTFormSelectItem) this.formField;
		return null;
	}

	public HowMGWTFormTextAreaItem getHowMFieldTextAreaItemEditor() {
		if (this.formField instanceof HowMGWTFormTextAreaItem)
			return (HowMGWTFormTextAreaItem) this.formField;
		return null;
	}

	public HowMGWTFormDateItem getHowMFieldDateItemEditor() {
		if (this.formField instanceof HowMGWTFormDateItem)
			return (HowMGWTFormDateItem) this.formField;
		return null;
	}

	public HowMGWTGridDateItem getHowMGridFieldDateItemEditor() {
		if (this.formField instanceof HowMGWTGridDateItem)
			return (HowMGWTGridDateItem) this.formField;
		return null;
	}
	
	
	public HowMGWTFormDateItemRange getHowMGWTFieldDateItemRange() {
		if (this.formField instanceof HowMGWTFormDateItemRange)
			return (HowMGWTFormDateItemRange) this.formField;
		return null;
	}
	
	
	protected void configureLabelClass() {

//		String classStyle = CssConstantes.STYLE_FORM_TITLE_OPTIONAL;
//
//		if (this.isMandatory()) {
//			classStyle = CssConstantes.STYLE_FORM_TITLE_MANDATORY; // "formTitleMandatory";
//		}
 
		if (formField != null) {
			
//			if (this.getHowMFieldTextEditor() != null) {
//				this.getHowMFieldTextEditor().getField().setTitleStyle(classStyle);			
//			} 
//			else if (this.getHowMFieldCheckboxItemEditor() != null) {
//				this.getHowMFieldCheckboxItemEditor().setTitleStyle(classStyle);
//			}
//
//			if ( getHowMFieldLookup() != null ){
//				this.getHowMFieldLookup().setStyleName(classStyle);				
//			}
//			else if (this.getHowMFieldLabelValue() != null) {
//				this.getHowMFieldLabelValue().setStyleName(classStyle);
//			} 
//			else if (this.getHowMFieldComboBoxEditor() != null) {
//				this.getHowMFieldComboBoxEditor().getField().setTitleStyle(classStyle);
//			} 
//			else if (this.getHowMFieldSelectItemEditor() != null) {
//				this.getHowMFieldSelectItemEditor().getField().setTitleStyle(classStyle);
//			} 
//			else if (this.getHowMFieldDateItemEditor() != null) {
//				this.getHowMFieldDateItemEditor().getField().setTitleStyle(classStyle);					
//			} 
//			else if (this.getHowMGWTFieldDateItemRange() != null) {
//				this.getHowMGWTFieldDateItemRange().setTitleStyle(classStyle);					
//			} 			
//			else if (this.getHowMFieldCodeDescriptorEditor() != null) {
//				this.getHowMFieldCodeDescriptorEditor().getField().getField().setTitleStyle(classStyle);
//			} 
//			else if (this.getHowMFieldPasswordItemEditor() != null) {
//				this.getHowMFieldPasswordItemEditor().getField().setTitleStyle(classStyle);
//			} 
//			else if (this.getHowMFieldTextAreaItemEditor() != null) {
//				this.getHowMFieldTextAreaItemEditor().getField().setTitleStyle(classStyle);
//			} 
//			else if (this.getHowMFieldRichTextEditor() != null) {
//				this.getHowMFieldRichTextEditor().setLabelStyleName(classStyle);
//			}
////			else if ( this.getHowMFormColorPickerItem() != null ){
////				this.getHowMFormColorPickerItem().getField().setLabelStyleName(classStyle);				
////			}
			
			
			if( this.getInternalCanvas() != null ){
				if( this.grantVisible ){
					this.getInternalCanvas().setVisible(this.visible);
					if( this.howMPropertyListener != null ){
						this.howMPropertyListener.onHowMSetVisible(visible);
					}
				}
				else{
					this.getInternalCanvas().setVisible(false);
					if( this.howMPropertyListener != null ){
						this.howMPropertyListener.onHowMSetVisible(false);
					}
				}
			}

		}

	}

	/**
	 * @return the oderList
	 */
	public int getOderList() {
		return oderList;
	}

	/**
	 * @param oderList
	 *            the oderList to set
	 */
	public void setOderList(int oderList) {
		this.oderList = oderList;
	}

	/**
	 * @return the type
	 */
	public ListGridFieldType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(ListGridFieldType type) {
		this.type = type;
		if (this.listField != null)
			this.listField.setType(this.getType());
	}

	// ------------------------------------------------------------------------------
	// Fábrica de formatos
	// ------------------------------------------------------------------------------
	private static final TreeMap<String, CellFormatter>	formats	= new TreeMap<String, CellFormatter>();

	public void createFormatDouble(String mask) {
		if (this.listField != null)
			createFormatDouble(this.listField, mask, "");
	}

	public void createFormatDouble(String mask, String textFix) {
		if (this.listField != null)
			createFormatDouble(this.listField, mask, textFix);
	}

	public static final void createFormatDouble(ListGridField field, final String mask, final String textFix) {
		CellFormatter formatter = formats.get("double_" + mask);
		if (formatter == null) {
			formatter = new CellFormatter() {
				public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
					if (!HowMGWTUtilities.isEmpty(record.getAttribute("BLANK_ROW")))
						return "";

					return NumberFormat.getFormat(mask).format(HowMGWTUtilities.getDouble(value)) + textFix;
				}
			};
			formats.put("double_" + mask, formatter);
		}
		field.setType(ListGridFieldType.FLOAT);
		field.setCellFormatter(formatter);
	}

	public void createFormatDate(String mask) {
		createFormatDate(this.getListField(), mask);
	}

	public static final void createFormatDate(ListGridField field, final String mask) {
		CellFormatter formatter = formats.get(mask);
		if (formatter == null) {
			formatter = new CellFormatter() {
				public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
					if (HowMGWTUtilities.isEmpty(value))
						return "";
					if (value instanceof String) {
						Date date = HowMGWTUtilities.getDate(value.toString());
						if (HowMGWTUtilities.isEmpty(date))
							return "";
						return DateTimeFormat.getFormat(mask).format(date);
					}
					return DateTimeFormat.getFormat(mask).format((Date) value);
				}
			};
			formats.put(mask, formatter);
		}
		field.setType(ListGridFieldType.DATE);
		field.setCellFormatter(formatter);

	}

	public void setHowMValue(ListGridRecord record, Object value) {
		if (value == null)
			setHowMValue(record, null);
		else
			setHowMValue(record, value.toString());
	}

	/**
	 * Seta um valor no campo do registro em questão
	 * 
	 * @param record
	 * @param value
	 */
	public void setHowMValue(ListGridRecord record, String value) {
		if (this.getType().equals(ListGridFieldType.TEXT)) {
			record.setAttribute(this.getName(), value);
		} else if (this.getType().equals(ListGridFieldType.FLOAT)) {
			record.setAttribute(this.getName(), HowMGWTUtilities.getDouble(value));
		} else if (this.getType().equals(ListGridFieldType.INTEGER)) {
			record.setAttribute(this.getName(), HowMGWTUtilities.getInteger(value));
		} else if (this.getType().equals(ListGridFieldType.BOOLEAN)) {
			record.setAttribute(this.getName(), HowMGWTUtilities.getBoolean(value));
		} else if (this.getType().equals(ListGridFieldType.DATE)) {
			record.setAttribute(this.getName(), HowMGWTUtilities.getDate(value));
		}
		else if (this.getType().equals(ListGridFieldType.IMAGE)) {
			record.setAttribute(this.getName(), HowMGWTUtilities.getString(value));
		}
		
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the externalProperties
	 */
	public TreeMap getExternalProperties() {
		if (externalProperties == null)
			externalProperties = new TreeMap();
		return externalProperties;
	}
 

	public void configureInputInteger() {
		configureInputInteger(this.getListField());
	}
 
	public void configureInputDecimal() {
		configureInputDecimal(this.getListField(), "##0.00");
	}

	public void configureInputDecimal(String mask) {
		configureInputDecimal(this.getListField(), mask);
	}
 
	
	/**
	 * Configura o campo da grid para digitação somente de números com separador
	 * decimal.
	 */
	public static TextItem configureInputInteger(ListGridField field) {
		final TextItem inputField = new TextItem();

		inputField.setEditorValueFormatter(new FormItemValueFormatter() {			
			public String formatValue(Object value, Record record, DynamicForm form, FormItem item) {
				return NumberFormat.getFormat("###").format(HowMGWTUtilities.getDouble(value, true ));
			}
		});
		inputField.setEditorValueParser(new FormItemValueParser() {
			public Object parseValue(String value, DynamicForm form, FormItem item) {
				return HowMGWTUtilities.getDouble(value, true );
			}
		});
		inputField.setKeyPressFilter("^\\d*[0-9](\\d*[0-9 ])?$");
 
		field.setEditorType(inputField);
		return inputField;
	}	
	
	/**
	 * Configura a formatação para digitação de valores decimais 
	 * @param item
	 * @param mask
	 */
	public static void configureInputInteger(TextItem item) {
		item.setEditorValueFormatter(new FormItemValueFormatter() {			
			public String formatValue(Object value, Record record, DynamicForm form, FormItem item) {
				return NumberFormat.getFormat("###").format(HowMGWTUtilities.getDouble(value, true));
			}
		});
		item.setEditorValueParser(new FormItemValueParser() {
			public Object parseValue(String value, DynamicForm form, FormItem item) {
				return HowMGWTUtilities.getDouble(value, true);
			}
		});
		item.setKeyPressFilter("^\\d*[0-9](\\d*[0-9 ])?$");
	}	

 
	
	
	
	/**
	 * Configura a formatação para digitação de valores decimais 
	 * @param item
	 * @param mask
	 */
	public static void configureInputDecimal(TextItem item, final String mask) {
		item.setEditorValueFormatter(new FormItemValueFormatter() {			
			public String formatValue(Object value, Record record, DynamicForm form, FormItem item) {
				return NumberFormat.getFormat(mask).format(HowMGWTUtilities.getDouble(value,true));
			}
		});
		item.setEditorValueParser(new FormItemValueParser() {
			public Object parseValue(String value, DynamicForm form, FormItem item) {
				return HowMGWTUtilities.getDouble(value,true);
			}
		});
		item.setKeyPressFilter("^\\d*[0-9,.](\\d*[0-9 ])?$");
	}

	/**
	 * Configura o campo da grid para digitação somente de números com separador
	 * decimal.
	 */
	public static TextItem configureInputDecimal(ListGridField field, final String mask) {
		final TextItem inputField = new TextItem();

		inputField.setEditorValueFormatter(new FormItemValueFormatter() {			
			public String formatValue(Object value, Record record, DynamicForm form, FormItem item) {
 			return NumberFormat.getFormat(mask).format(HowMGWTUtilities.getDouble(value, true));
			}
		});
		inputField.setEditorValueParser(new FormItemValueParser() {
			public Object parseValue(String value, DynamicForm form, FormItem item) {
 				return HowMGWTUtilities.getDouble(value, true );
			}
		});
		inputField.setKeyPressFilter("^\\d*[0-9,.](\\d*[0-9 ])?$");
	 
		field.setEditorType(inputField);
		return inputField;
	}

	/**
	 * @return the clearValue
	 */
	public boolean isClearValue() {
		return clearValue;
	}

	/**
	 * @param clearValue
	 *            the clearValue to set
	 */
	public void setClearValue(boolean clearValue) {
		this.clearValue = clearValue;
	}

	public void showTitleMandatory() {

	}

	public void showTitleOptional() {

	}

	/**
	 * @return the workObject
	 */
	public Object getWorkObject() {
		return workObject;
	}

	/**
	 * @param workObject
	 *            the workObject to set
	 */
	public void setWorkObject(Object workObject) {
		this.workObject = workObject;
	}

	/**
	 * @return the workVariavel
	 */
	public String getWorkVariavel() {
		return workVariavel;
	}

	/**
	 * @param workVariavel
	 *            the workVariavel to set
	 */
	public void setWorkVariavel(String workVariavel) {
		this.workVariavel = workVariavel;
	}

	public void setFocus(){
		showFocus();
	}
	
	public void requestFocus(){
		showFocus();
	}
	
	/**
	 * Vai para o foco do campo.
	 */
	public void showFocus() {
		if (getFormField() == null)
			return;

		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {							
			public void execute() {							
				// if (getFormField() != null)
					// getFormField().setHowMFocusInItem();				
			}
		});		
	}

	public void setLabel(String label) {
		if (this.getFormField() != null) {
			this.title = label;
			// this.getFormField().setHowMLabelTitle(label);
		}
	}

 

	/**
	 * @return Retorna true se o campo estiver com as informações ok, caso
	 *         contrário retorna false;
	 */
	public boolean isValidate() {
 
		return this.isValidate(null, this.getHowmFormValue());
	}

	public boolean isValidate(String complemento) {		 
		return this.isValidate(" "+complemento, this.getHowmFormValue());
	}

	
	/**
	 * @return Retorna true se o campo estiver com as informações ok, caso
	 *         contrário retorna false;
	 */
	public boolean isValidate(String complemento, Object object) {
		
		if( HowMGWTUtilities.isEmpty(complemento))
			complemento = "";
			
		if ( this.isMandatory() && this.isVisible() ) {
			if (HowMGWTUtilities.isEmpty(object) || "<br>".equals(object)) {
				SC.say("Campo <strong><font color=red>" + this.getLabel() + "</font>" + complemento + "</strong> é obrigatório ! <br>Informe um valor para o campo e tente novamente...",
						new BooleanCallback() {
							public void execute(Boolean value) {
								showFocus();
							}
						});
				return false;
			}
		}
		if ( getHowMFieldDateItemEditor() != null  ){
			if ( ! HowMGWTUtilities.isEmpty(object)) {
				Date data = HowMGWTUtilities.getDate(object);
				if ( data == null ){
					SC.say("Campo <strong><font color=red>" + this.getLabel() + "</font> Data informada não é valida ...", new BooleanCallback() {
						public void execute(Boolean value) {
							showFocus();
						}
					});					
				}
			}
		}
//		if( HowMGWTConstants.MASK_CPF.equals(getHowMMask()) ){
//			if ( ! HowMGWTUtilities.isEmpty( object ) ){
//				boolean valid = HowMGWTUtilities.verifyCPF(object.toString());
//				if( ! valid ){
//					SC.say("<strong><font color=red>" + this.getLabel() + "</font> não é válido...", new BooleanCallback() {
//						public void execute(Boolean value) {
//							showFocus();
//						}
//					});					
//					return false;
//				}
//			}
//		}
//
//		if ( this.isVisible() ) {
//			if( HowMGWTConstants.VALID_EMAIL.equalsIgnoreCase(this.getHowMValid())){
//				if ( ! HowMGWTUtilities.isEmpty( object ) ){
//					boolean valid = HowMGWTUtilities.validaEmail(object.toString());
//					if( ! valid ){
//						SC.say("<strong><font color=red>" + this.getLabel() + "</font> não é válido...", new BooleanCallback() {
//							public void execute(Boolean value) {
//								showFocus();
//							}
//						});
//						return false;
//					}
//				}
//			}
//		}
		return true;
	}

	/**
	 * @return the primaryKey
	 */
	public boolean isPrimaryKey() {
		return primaryKey;
	}

	/**
	 * @param primaryKey the primaryKey to set
	 */
	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}

	/**
	 * @return the howmFormValue
	 */
	public Object getHowmFormValue() {
		if ( this.formField != null )
			return this.formField.getHowMValue();
		
		return howmFormValue;
	}
	
	public String getHowmFormValueToString(){
		return 	HowMGWTUtilities.getObjectString(this.getHowmFormValue());
	}
	
	/**
	 * @param howmFormValue the howmFormValue to set
	 */
	public void setHowmFormValue(Object howmFormValue) {
		if ( this.formField != null )
			this.formField.setHowMValue(howmFormValue);
		
		this.howmFormValue = howmFormValue;
	}

	/**
	 * @return the howMSelectValue
	 */
	public String getHowMSelectValue() {
		return howMSelectValue;
	}

	/**
	 * @param howMSelectValue the howMSelectValue to set
	 */
	public void setHowMSelectValue(String howMSelectValue) {
		this.howMSelectValue = howMSelectValue;
		configureCheckboxValues();
	}

	/**
	 * @return the howMUnselectValue
	 */
	public String getHowMUnselectValue() {
		return howMUnselectValue;
	}

	/**
	 * @param howMUnselectValue the howMUnselectValue to set
	 */
	public void setHowMUnselectValue(String howMUnselectValue) {
		this.howMUnselectValue = howMUnselectValue;
		configureCheckboxValues();
	}

	public void configureCheckboxValues(){
		if ( this.getHowMGridFieldCheckboxItemEditor() != null ){

			this.getHowMGridFieldCheckboxItemEditor().setHowMSelectValue(this.getHowMSelectValue());
			this.getHowMGridFieldCheckboxItemEditor().setHowMUnselectValue(this.getHowMUnselectValue());

		}
		if ( this.getHowMFieldCheckboxItemEditor() != null ){

			this.getHowMFieldCheckboxItemEditor().setHowMSelectValue(this.getHowMSelectValue());
			this.getHowMFieldCheckboxItemEditor().setHowMUnselectValue(this.getHowMUnselectValue());

		}
	}

	/**
	 * @return the dataSourceField
	 */
	public HowMGWTDataSource getDataSourceField() {
		return dataSourceField;
	}

	/**
	 * @param dataSourceField the dataSourceField to set
	 */
	public void setDataSourceField(HowMGWTDataSource dataSourceField) {
		this.dataSourceField = dataSourceField;
	}
 
	public double getHowMDouble(){
		return HowMGWTUtilities.getDouble(this.getHowmFormValue());
	}

	
	public int getHowMInteger(){
		return HowMGWTUtilities.getInteger(this.getHowmFormValue());
	}

	public Date getHowMDate(){
		return HowMGWTUtilities.getDate(this.getHowmFormValue());
	}

	/**
	 * @return the grantEdit
	 */
	public boolean isGrantEdit() {
		return grantEdit;
	}

	/**
	 * @param grantEdit the grantEdit to set
	 */
	public void setGrantEdit(boolean grantEdit) {
		this.grantEdit = grantEdit;
	}

	/**
	 * @return the grantNew
	 */
	public boolean isGrantNew() {
		return grantNew;
	}

	/**
	 * @param grantNew the grantNew to set
	 */
	public void setGrantNew(boolean grantNew) {
		this.grantNew = grantNew;
	}

	/**
	 * Eventos disparados para indicar mudança de estado de navegação
	 */
	public void onHowMNavegateImpl(){
	}
	
	public void onHowMEditImpl(){		
	}
	
	public void onHowMNewRecordImpl(){
	}
	
	public void howMUseMask(boolean useMask){
		if( this.getHowMFieldDateItemEditor() != null ){
			this.getHowMFieldDateItemEditor().setHowMUseMask(useMask);
		}
		if( this.getHowMGWTFieldDateItemRange() != null ){
			this.getHowMGWTFieldDateItemRange().setHowMUseMask(useMask);
		}
		
	}

	/**
	 * @return the howMMask
	 */
	public String getHowMMask() {
		return HowMMask;
	}

	/**
	 * @param howMMask the howMMask to set
	 */
	public void setHowMMask(String howMMask) {
		HowMMask = howMMask;
		this.configureField();
	}
	
	
	public void setHowMValueToRecord(ListGridRecord record, Object value){
		if ( this.getType().equals(ListGridFieldType.TEXT )){
			record.setAttribute(this.getName(), value );				
		}
		else if ( this.getType().equals(ListGridFieldType.FLOAT)){
			record.setAttribute(this.getName(), HowMGWTUtilities.getObjectDouble(value));								
		}
		else if ( this.getType().equals(ListGridFieldType.INTEGER)){
			record.setAttribute(this.getName(), HowMGWTUtilities.getObjectInteger(value));	
		}
		else if ( this.getType().equals(ListGridFieldType.BOOLEAN)){
			record.setAttribute(this.getName(), HowMGWTUtilities.getBoolean(value));	
		}
		else if ( this.getType().equals(ListGridFieldType.DATE)){
			record.setAttribute(this.getName(), HowMGWTUtilities.getDate(value));
		}
		else{
			record.setAttribute(this.getName(), value);								
		}		
	}

	/**
	 * @return the databaseExpression
	 */
	public String getDatabaseExpression() {
		return databaseExpression;
	}

	/**
	 * @param databaseExpression the databaseExpression to set
	 */
	public void setDatabaseExpression(String databaseExpression) {
		this.databaseExpression = databaseExpression;
	}

	/**
	 * @return the databaseType
	 */
	public String getDatabaseType() {
		return databaseType;
	}

	/**
	 * @param databaseType the databaseType to set
	 */
	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}
 
	/**
	 * @return the convertMask
	 */
	public String getConvertMask() {
		return convertMask;
	}

	/**
	 * @param convertMask the convertMask to set
	 */
	public void setConvertMask(String convertMask) {
		this.convertMask = convertMask;
	}

	/**
	 * @return the howMModeOperation
	 */
	public int getHowMModeOperation() {
		return howMModeOperation;
	}



	/**
	 * @return the howMCanEditMode
	 */
	public boolean isHowMCanEditMode() {
		return howMCanEditMode;
	}

	/**
	 * @param howMCanEditMode the howMCanEditMode to set
	 */
	public void setHowMCanEditMode(boolean howMCanEditMode) {
		this.howMCanEditMode = howMCanEditMode;
	}

	/**
	 * @return the howMCanNewMode
	 */
	public boolean isHowMCanNewMode() {
		return howMCanNewMode;
	}

	/**
	 * @param howMCanNewMode the howMCanNewMode to set
	 */
	public void setHowMCanNewMode(boolean howMCanNewMode) {
		this.howMCanNewMode = howMCanNewMode;
	}
	
	/**
	 * @param howMModeOperation the howMModeOperation to set
	 */
	public void setHowMModeOperation(int howMModeOperation) {
		this.howMModeOperation = howMModeOperation;
		
		if( this.getCanvas() != null && this.getHowMFieldLabelValue() == null ){		
			if( this.howMModeOperation == HowMGWTUtilities.OPERATION_INSERT ){
				if( this.howMCanNewMode )
					this.getCanvas().setDisabled(false);
				else
					this.getCanvas().setDisabled(true);
			}
			else if( this.howMModeOperation == HowMGWTUtilities.OPERATION_QUERY 
					 || 
					 this.howMModeOperation == HowMGWTUtilities.OPERATION_UPDATE ){
				if( this.howMCanEditMode )
					this.getCanvas().setDisabled(false);
				else
					this.getCanvas().setDisabled(true);
			}
			else{
				this.getCanvas().setDisabled(true);				
			}
		}
		
		if( this.getListField() != null ){		
			if( this.howMModeOperation == HowMGWTUtilities.OPERATION_INSERT ){
				if( this.howMCanNewMode )
					this.getListField().setCanEdit(true);
				else
					this.getListField().setCanEdit(false);
			}
			else if( this.howMModeOperation == HowMGWTUtilities.OPERATION_QUERY 
					 || 
					 this.howMModeOperation == HowMGWTUtilities.OPERATION_UPDATE ){
				if( this.howMCanEditMode )
					this.getListField().setCanEdit(true);
				else
					this.getListField().setCanEdit(false);
			}
			else{
				this.getListField().setCanEdit(false);
			}
		}

	}

	/**
	 * @return the howMMaxLength
	 */
	public int getHowMLength() {
		return howMLength;
	}

	/**
	 * @param howMLength the howMMaxLength to set
	 */
	public void setHowMLength(int howMLength) {
		this.howMLength = howMLength;
		configureField();
	}	
	
	
	public void onHowMFinishUpload(String fileName) {}	

	
	
	/**
	 * Se o formField for diferente de null
	 * posiciona o focus no campo.
	 */
	public void howMFocusInItem(){
		// if( getFormField() != null)
			// this.getFormField().howMFocusInItem();		
	}


	public void setVisible(boolean visible){
		this.visible = visible;
		this.configureLabelClass();
	}	
	
	public boolean isVisible(){
		return this.visible;
	}

	/**
	 * @return the grantVisible
	 */
	public boolean isGrantVisible() {
		return grantVisible;
	}

	/**
	 * @param grantVisible the grantVisible to set
	 */
	public void setGrantVisible(boolean grantVisible) {
		this.grantVisible = grantVisible;
	}

	/**
	 * @return the howMPropertyListener
	 */
	public HowMGWTPropertyListener getHowMPropertyListener() {
		return howMPropertyListener;
	}

	/**
	 * @param howMPropertyListener the howMPropertyListener to set
	 */
	public void setHowMPropertyListener(HowMGWTPropertyListener howMPropertyListener) {
		this.howMPropertyListener = howMPropertyListener;
	}

	/**
	 * @return the howMValid
	 */
	public String getHowMValid() {
		return HowMValid;
	}

	/**
	 * @param howMValid the howMValid to set
	 */
	public void setHowMValid(String howMValid) {
		this.HowMValid = howMValid;
	}

	/**
	 * @return the howMPlaceholder
	 */
	public String getHowMPlaceholder() {
		return howMPlaceholder;
	}

	/**
	 * @param howMPlaceholder the howMPlaceholder to set
	 */
	public void setHowMPlaceholder(String howMPlaceholder) {
		this.howMPlaceholder = howMPlaceholder;
		configureField();
	}

	/**
	 * @param howmFormValueDescription the howmFormValueDescription to set
	 */
	public void setHowmFormValueDescription(Object howmFormValueDescription) {
		this.howmFormValueDescription = howmFormValueDescription;
	}

	/**
	 * @return the howmFormValue
	 */
	public Object getHowmFormValueDescription() {
		if ( this.getHowMFieldSelectItemEditor() != null ){
			return this.getHowMFieldSelectItemEditor().getField().getDisplayValue();
		}
		else if ( this.getHowMFieldComboBoxEditor() != null ){
			return this.getHowMFieldComboBoxEditor().getField().getDisplayValue();
		}
		return howmFormValueDescription;
	}
		
	/**
	 * @return the howmFormValue
	 */
	public String getHowmFormValueDescriptionToString() {
		return HowMGWTUtilities.getString(getHowmFormValueDescription());
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
 
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// --------------------------------------------------------------------------------
	// FABRICA PARA PRODUÇÃO DE CAMPOS DE EDIÇÃO
	// --------------------------------------------------------------------------------
	public void createHowMFormRichTextEditor() {
		this.formField = new HowMGWTFormRichTextEditor(this.name, this.title);
		this.canvas = (HowMGWTFormRichTextEditor) this.formField;
		configureLabelClass();
		configureWidths();
	}


	public void createHowMGWTCheckboxItem(){
		this.formField = new HowMGWTCheckboxItem(this.name, this.title);
		configureLabelClass();
		configureWidths();
	}


	public void createHowMGWTFormCodeDescriptor(){
		HowMGWTCodeDescriptor codDesc = new HowMGWTCodeDescriptor(this.name, this.title);
		this.canvas = codDesc;
		this.canvas.setHeight(22);
	
		this.formField = codDesc.getField();
		configureLabelClass();
		configureWidths();		
	}
	
	
	public void createHowMGWTFormFieldPasswordItem(){
		this.formField = new HowMGWTPasswordItem(this.name, this.title);		
		configureLabelClass();
		configureWidths();

	}

	
	public void createHowMGWTFormFieldAreaItem(){
		this.formField = new HowMGWTTextAreaItem(this.name, this.title);		
		configureLabelClass();
		if ( this.widthField != null && this.widthLabel != null )
			this.formField.setHowMBound(widthLabel.intValue()-6, widthField.intValue());		
		this.getHowMGWTEditorTextAreaItem().setHeight(44);
	}

	
	public void createHowMGWTFormFieldTextItem(){
		this.formField = new HowMGWTTextItem(this.name, this.title);		
		configureLabelClass();
		configureWidths();
	}
	
	public void createHowMGWTFormFieldSelectItem(){

		this.formField = 	new HowMGWTSelectItem(this.name, this.title);	
		configureLabelClass();
		configureWidths();
	}
	
		
	public void createHowMGWTFormDateItem(){
		this.formField = new HowMGWTDateItem(this.name, this.title);		
		configureLabelClass();
		if ( this.widthField != null && this.widthLabel != null )
			this.formField.setHowMBound(widthLabel.intValue()-2, widthField.intValue());		
	}

	
	public void createHowMGWTFormDateItemInput(){
		this.formField = new HowMGWTDateItem(this.name, this.title);	
		((HowMGWTDateItem)this.formField).setHowMUseMask(true);
		configureLabelClass();
		if ( this.widthField != null && this.widthLabel != null )
			this.formField.setHowMBound(widthLabel.intValue()-2, widthField.intValue());		
	}	
	
	public HowMGWTPasswordItem getHowMGWTEditorPasswordItem(){
		if ( this.formField instanceof HowMGWTPasswordItem )
			return (HowMGWTPasswordItem)this.canvas;
		return null;		
	}

	public HowMGWTFormRichTextEditor getHowMGWTFormRichTextEditor() {
		if (this.formField instanceof HowMGWTFormRichTextEditor)
			return (HowMGWTFormRichTextEditor) this.canvas;
		return null;
	}


	
	public HowMGWTCodeDescriptor getHowMGWTEditorCodeDescriptor(){
		if ( this.formField instanceof HowMGWTTextItem )
			return (HowMGWTCodeDescriptor)this.canvas;
		return null;
	}	

	public HowMGWTCheckboxItem getHowMGWTCheckboxItem(){
		if ( this.formField instanceof HowMGWTCheckboxItem )
			return (HowMGWTCheckboxItem)this.formField;
		return null;
	}	
	
	
	public HowMGWTTextItem getHowMGWTEditorFieldText(){
		if ( this.formField instanceof HowMGWTTextItem )
			return (HowMGWTTextItem)this.formField;
		return null;
	}	
	
	public HowMGWTSelectItem getHowMGWTEditorSelectItem(){
		if ( this.formField instanceof HowMGWTSelectItem )
			return (HowMGWTSelectItem)this.formField;
		return null;
	}
	
	public HowMGWTTextAreaItem getHowMGWTEditorTextAreaItem(){
		if ( this.formField instanceof HowMGWTTextAreaItem )
			return (HowMGWTTextAreaItem)this.formField;
		return null;	
	}
	
	public HowMGWTDateItem getHowMGWTEditorDateItem(){
		if ( this.formField instanceof HowMGWTDateItem)
			return (HowMGWTDateItem)this.formField;
		return null;
	}	
	

	
	public String getLabel() {
		if (this.getFormField() != null)
			return this.getFormField().getHowMLabelTitle();//
		else
			return "";
	}

	
	public void onHowMGWTSelect(boolean selected){
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static FormItemInputTransformer INPUT_TRANSFORMER_DOUBLE = new FormItemInputTransformer() {			
	public Object transformInput(DynamicForm form, FormItem item, Object value, Object oldValue) {

			if( value != null ){					
				String filterValue = "";
				int sep = 0;
				char[] chars = value.toString().toCharArray();
				if( chars != null ){
					int i = 0;
					for ( char c : chars){
						if ( (int)c == 46 )
							c = ',';
						if ( ( ((int)c) >= 48 && ((int)c) <=57) || ((int)c) == 44 ){
							if ( ((int)c) == 44 ){
								sep ++;
								// Não deixa repetir o separador decimal.
								if ( sep > 1)
									continue;
								if( i == 0 ){
									filterValue += "0";
								}
							}
							filterValue += ""+c;
							i ++;
						}
					}					
					value = filterValue;
				}
			}
			return value;
		}			
	};		

	private static FormItemInputTransformer INPUT_TRANSFORMER_INTEGER = new FormItemInputTransformer() {			
		public Object transformInput(DynamicForm form, FormItem item, Object value, Object oldValue) {
	
			if( value != null ){					
				String filterValue = "";
				int sep = 0;
				char[] chars = value.toString().toCharArray();
				if( chars != null ){
					int i = 0;
					for ( char c : chars){
						if ( ( ((int)c) >= 48 && ((int)c) <=57) ){
							filterValue += ""+c;
							i ++;
						}
					}					
					value = filterValue;
				}
			}
			return value;
		}			
	};			
	
	public static FormItemInputTransformer getInputIntegerTransformer(){
		return INPUT_TRANSFORMER_INTEGER;
	}
	
	
	
	public static FormItemInputTransformer getInputDoubleTransformer(){
		return INPUT_TRANSFORMER_DOUBLE;
	}

}