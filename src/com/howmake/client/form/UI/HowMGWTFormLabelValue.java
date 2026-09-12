package com.howmake.client.form.UI;

import com.howmake.client.form.partner.HowMGWTFormField;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class HowMGWTFormLabelValue extends VLayout implements HowMGWTFormField {

	private Label	label			= new Label();
	private Label	labelSeparator	= new Label(":");
	private Label	labelText		= new Label();

	private String	name;

	HLayout			formLayout		= new HLayout();

	private boolean top 			= false; 
	
	public HowMGWTFormLabelValue() {
		this(Alignment.LEFT);
	}

	public HowMGWTFormLabelValue(VerticalAlignment verticalAlign) {

		this.top = true;
		this.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(3,""));	

		this.setAlign(Alignment.CENTER);

		label.setHeight(16);
		label.setAlign(Alignment.LEFT);
		
		this.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(3,""));
		
		labelText.setHeight100();
		labelText.setWidth100();
		// labelText.setBackgroundColor("#ffffff");

		this.addMember(label);
		this.addMember(labelText);
		labelText.setBorder("1px solid #dbdfe5");

		this.setHeight(22);
	}

	public HowMGWTFormLabelValue(Alignment horizontalAlignment){
		this.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(2,""));	

		this.setAlign(Alignment.CENTER);

		label.setHeight100();
		label.setAlign(Alignment.RIGHT);
		labelSeparator.setWidth(12);
		labelSeparator.setHeight100();
		labelSeparator.setAlign(Alignment.CENTER);

		labelText.setHeight100();
		labelText.setWidth100();
		// labelText.setBackgroundColor("#ffffff");

		formLayout.setWidth100();
		formLayout.addMember(label);
		formLayout.addMember(labelSeparator);
		formLayout.addMember(labelText);
		labelText.setBorder("1px solid #dbdfe5");

		this.addMember(formLayout);
		this.setHeight(22);			
		
	}

	public HowMGWTFormLabelValue(String name, String title) {
		this(name, title, Alignment.LEFT);
	}

	public HowMGWTFormLabelValue(String name, String title, VerticalAlignment verticalAlignment) {
		this(verticalAlignment.TOP);
		this.name = name;
		this.label.setContents(title);
	}
	public HowMGWTFormLabelValue(String name, String title, Alignment horizontalAlignment) {
		this();
		this.name = name;
		this.label.setContents(title);
	}

	public void setHowMValue(Object value) {
		if (!HowMGWTUtilities.isEmpty(value))
			this.labelText.setContents(value.toString());
		else
			this.labelText.setContents("&nbsp;");
	}

	public Object getHowMValue() {
		if( "&nbsp;".equalsIgnoreCase(labelText.getContents()))
			return "";
		return labelText.getContents();
	}

	public String getHowMValueAsString() {
		return labelText.getContents();
	}

	public void setHowMBound(int widthLabel, int widthField) {
		if( this.top ){
			label.setWidth100();
			this.setWidth(widthLabel + widthField + 8);
		}
		else{
			this.label.setWidth(widthLabel - 10);
			this.labelText.setWidth(widthField);
			this.setWidth(widthLabel + widthField + 8);
		}
		this.redraw();
	}

	public void setHowMBound(int widthLabel) {
		if( this.top ){
			this.label.setWidth100();
		}
		else{	
			this.label.setWidth(widthLabel - 10);		
		}
		this.setWidth100();
	}

	public void setHowMDisable(Boolean disabled) {
	}

	public Label getField() {
		return this.labelText;
	}

	public Label getDisplayLabel() {
		return this.label;
	}

	@Override
	public void setStyleName(String styleName) {
		// super.setStyleName(styleName);
		// this.label.setStyleName(styleName);
		this.labelSeparator.setStyleName(styleName);
		// this.labelText.setStyleName(styleName);
	}

	/**
	 * @return the labelText
	 */
	public Label getLabelText() {
		return labelText;
	}

	public void setHowMFocusInItem() {
	}

	public void setHowMLabelTitle(String label) {
		this.label.setContents(label);
	}

	public String getHowMLabelTitle() {
		return this.label.getContents();
	}

	public void setHowMWidthField(int width) {
		
		this.labelText.setWidth(width);

		this.setWidth(width + label.getWidth() + labelSeparator.getWidth());
	}

	public DynamicForm getHowMForm(){
		return null;
	}

	public void howMFocusInItem() {
		// TODO Auto-generated method stub
		
	}

	
	public void hideTitle(){
		label.hide();
		labelSeparator.hide();		
	}

	/**
	 * @return the formLayout
	 */
	public HLayout getFormLayout() {
		return formLayout;
	}
	
 
}