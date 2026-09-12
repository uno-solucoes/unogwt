package com.howmake.client.form.UI;
 
 
import com.howmake.client.form.partner.HowMGWTFormField;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.widgets.RichTextEditor;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

public class HowMGWTFormRichTextEditor extends VLayout  implements HowMGWTFormField{

	private ToolStrip tools = new ToolStrip();
    private ToolStripButton actionTranslate = new ToolStripButton();  

	private String name;
	private String title;
	private HowMGWTLabel labelValue = new HowMGWTLabel();
	private VLayout layoutLabelValue;
	
	private boolean selectButton = true;
	
	private RichTextEditor fieldHtml = new RichTextEditor();
	private HowMGWTTextAreaItem fieldText = new HowMGWTTextAreaItem();
	
	public HowMGWTFormRichTextEditor(String name, String title){

		this.name = name;
		this.title= title;
		
		this.setWidth100();
		this.setHeight100();
		
		this.labelValue.setWidth100();
		this.labelValue.setHeight(22);
		this.labelValue.setContents(title);
		
		tools.setWidth100();
		
		layoutLabelValue = HowMGWTUtilities.getCanvasLabelIndicator(22, labelValue);
		layoutLabelValue.setWidth100();
		
		tools.addMember(layoutLabelValue);

		
        actionTranslate.setIcon("actions/btn_cod_html.png");  
        actionTranslate.setActionType(SelectionType.RADIO);  
        actionTranslate.setRadioGroup("textAlign");  
        actionTranslate.setSelected(true);
        actionTranslate.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				if ( selectButton ){
					 actionTranslate.setIcon("actions/btn_html.png");  
					 selectButton = false;
					 fieldText.setHowMValue(fieldHtml.getValue());
					 removeMember(fieldHtml);
					 addMember(fieldText);
					 fieldText.redraw();
				}
				else{
					 actionTranslate.setIcon("actions/btn_cod_html.png");  
					 selectButton = true;
					 fieldHtml.setValue(fieldText.getHowMValueAsString());
					 fieldHtml.setContents(fieldText.getHowMValueAsString());
					 removeMember(fieldText);
					 addMember(fieldHtml);
					 fieldHtml.redraw();
				}
				// actionTranslate.setSelected(selectButton);
			}
		});
        tools.addButton(actionTranslate);  

        
		this.addMember(tools);
		
		this.fieldText.setWidth100();
		this.fieldText.setHeight100();
		this.fieldText.getField().setShowTitle(false);
		
		this.fieldHtml.setWidth100();
		this.fieldHtml.setHeight100();
		
		this.addMember(fieldHtml);		
	}

	public void setHowMValue(Object value) {
		if ( HowMGWTUtilities.isEmpty(value) ){
			fieldHtml.setValue("");
			fieldHtml.redraw();
		}
		else{
			fieldHtml.setValue(value.toString());
			fieldHtml.redraw();
		}
	}

	public Object getHowMValue() {
		return getHowMValueAsString();
	}	

	public String getHowMValueAsString() {
		String value = fieldHtml.getValue();
		if ( fieldHtml.getValue() != null ){
			value = HowMGWTUtilities.replace(value,"\"","'");
		}			
		return value;
	}

	public void setHowMBound(int widthLabel, int widthField) {
		this.setWidth100();
		this.setHeight100();
	}

	public void setHowMBound(int widthLabel) {
		this.setWidth100();
		this.setHeight100();
	}

	public void setHowMDisable(Boolean disabled) {
		fieldHtml.setDisabled(disabled);
	}

	public void setHowMFocusInItem() {
		fieldHtml.focus();
	}

	public void setHowMLabelTitle(String label) {
		this.labelValue.setContents(label);
		
	}

	public String getHowMLabelTitle() {
		return labelValue.getContents();
	}

	
	public void setLabelStyleName(String styleName){
		this.labelValue.setStyleName(styleName);
	}
	
	
	public void setHowMPlusHeight(int height){
		this.fieldHtml.setHeight(height);
		this.fieldText.setHeight(height);
		this.setHeight(height);
	}

	/**
	 * @return the fieldHtml
	 */
	public RichTextEditor getFieldHtml() {
		return fieldHtml;
	}

	/**
	 * @param fieldHtml the fieldHtml to set
	 */
	public void setFieldHtml(RichTextEditor fieldHtml) {
		this.fieldHtml = fieldHtml;
	}

	/**
	 * @return the fieldText
	 */
	public HowMGWTTextAreaItem getFieldText() {
		return fieldText;
	}

	/**
	 * @param fieldText the fieldText to set
	 */
	public void setFieldText(HowMGWTTextAreaItem fieldText) {
		this.fieldText = fieldText;
	}

	@Override
	public void setWidth(int width) {
		super.setWidth(width);
//		this.labelValue.setHeight(width);
		tools.setWidth(width);
//		layoutLabelValue.setWidth(width);
// 		this.fieldText.setWidth(width);		
		this.fieldHtml.setWidth(width);
	}

	@Override
	public void setHeight(int height) {
		super.setHeight(height);
//		this.fieldText.setWidth(height-24);		
		this.fieldHtml.setHeight(height-24);
	}
}
