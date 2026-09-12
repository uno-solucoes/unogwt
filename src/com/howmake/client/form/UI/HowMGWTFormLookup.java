package com.howmake.client.form.UI;

import com.howmake.client.form.partner.HowMGWTFormField;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class HowMGWTFormLookup extends VLayout implements HowMGWTFormField {

	private IButton actionLocalizar = new IButton();
	private IButton actionLimpar    = new IButton();
	private Label	label			= new Label();
	private Label	labelSeparator	= new Label(":");
	private Label	labelText		= new Label();
	private Label   labelDescription= new Label();
	
	private String  nameDescription;

	private String	name;

	Label labelIfen = new Label("-");
	
	HLayout			formLayout		= new HLayout();

	private String borderLookup = "1px solid #dbdfe5";
	
	public HowMGWTFormLookup() {

		this.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(2,""));
		
		this.setAlign(Alignment.CENTER);

		labelDescription.setWidth100();
		
		label.setHeight100();
		label.setAlign(Alignment.RIGHT);
		labelSeparator.setWidth(12);
		labelSeparator.setHeight100();
		labelSeparator.setAlign(Alignment.CENTER);

		labelText.setHeight100();
		labelText.setWidth(80);
		labelDescription.setWidth100();

		formLayout.setWidth100();
		
		formLayout.addMember(label);
		formLayout.addMember(labelSeparator);
		
		HLayout layoutDescription = new HLayout();
		layoutDescription.setWidth100();
		layoutDescription.setHeight(22);
		
		layoutDescription.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(2, ""));
		layoutDescription.addMember(labelText);

	
		labelIfen.setAlign(Alignment.CENTER);
		labelIfen.setWidth(5);
		labelIfen.setHeight(18);
		layoutDescription.addMember(labelIfen);
		
		layoutDescription.setBorder(borderLookup);
 

//		border-top:1px solid #abadb3;
//	    border-left:1px solid #dbdfe5;
//	    border-right:1px solid #dbdfe5;
//	    border-bottom:1px solid #dbdfe5;		
		
		layoutDescription.addMember(labelDescription);
		formLayout.addMember(layoutDescription);
		
		actionLocalizar.setIcon("actions/view.png");
		actionLocalizar.setWidth(22);
		actionLocalizar.setHeight(22);
		actionLocalizar.setPrompt("Localizar");		
		formLayout.addMember(actionLocalizar);
		
		
		actionLimpar.setIcon("[SKIN]/pickers/clear_picker.png");
		actionLimpar.setWidth(22);
		actionLimpar.setHeight(22);
		actionLimpar.setPrompt("Limpar Campo");
		formLayout.addMember(actionLimpar);
		
		actionLimpar.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				setHowMValue("");
				labelDescription.setContents("");
			}
		});
		
		this.addMember(formLayout);
		this.setHeight(22);
	}

	public HowMGWTFormLookup(String name, String title) {
		this();
		this.name = name;
		this.label.setContents(title);
	}

	public void setHowMValue(Object value) {
		if (!HowMGWTUtilities.isEmpty(value))
			this.labelText.setContents(value.toString());
		else
			this.labelText.setContents("");
	}

	public Object getHowMValue() {
		return labelText.getContents();
	}

	public String getHowMValueAsString() {
		return labelText.getContents();
	}

	public void setHowMBound(int widthLabel, int widthField) {
		this.label.setWidth(widthLabel - 10);
		this.labelText.setAutoWidth();
//		this.labelDescription.setWidth(widthField-10);
		this.setWidth(widthLabel + widthField + 12);		
		this.redraw();
	}

	public void setHowMBound(int widthLabel) {
		this.label.setWidth(widthLabel - 10);
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
		this.label.setStyleName("lookup"+styleName);
		this.labelSeparator.setStyleName(styleName);
		this.labelText.setStyleName("lookup"+styleName);
		this.labelDescription.setStyleName("lookup"+styleName);
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

		this.setWidth(width + label.getWidth() + labelDescription.getWidth()+ labelSeparator.getWidth());
	}

	/**
	 * @return the nameDescription
	 */
	public String getNameDescription() {
		return nameDescription;
	}

	/**
	 * @param nameDescription the nameDescription to set
	 */
	public void setNameDescription(String nameDescription) {
		this.nameDescription = nameDescription;
	}

	/**
	 * @return the actionLocalizar
	 */
	public IButton getActionLocalizar() {
		return actionLocalizar;
	}

	/**
	 * @return the labelDescription
	 */
	public Label getLabelDescription() {
		return labelDescription;
	}

	public void hideDescriptor(){
		labelIfen.setVisible(false);
		labelDescription.setVisible(false);		
	}

	
	public void removeActionLimpar(){
		formLayout.removeMember(this.actionLimpar);
	}


	public DynamicForm getHowMForm(){
		return null;
	}

	public void howMFocusInItem() {
		// TODO Auto-generated method stub
		
	}

	public void hideCode(){
		labelIfen.setVisible(false);
		labelText.setVisible(false);
	}
 
}