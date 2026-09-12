package com.br.client.panel.at.atw0117;

import java.util.ArrayList;
import java.util.Date;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.MouseOutEvent;
import com.smartgwt.client.widgets.events.MouseOutHandler;
import com.smartgwt.client.widgets.events.MouseOverEvent;
import com.smartgwt.client.widgets.events.MouseOverHandler;
 

public class ActionButtonCalendar  extends Canvas{
	
	private PainelDetalheEspacosLocais parentPainelDetalheEspacosLocais;
	
	private int tipoArea			= 1;

	private int column				= 0;
	private int row					= 0;
	
	private String overColor		= "agendaVillaButtonOver";
	private String normalColor		= "agendaVillaButtonNormal";
	
	private boolean selected;	
	
	private Date dateCalendar;
	
	private ActionButtonCalendar weekAction ;
	private ArrayList<ActionButtonCalendar> itemsCalendar = new ArrayList<ActionButtonCalendar>();
	
	private Img img 					= new Img("agenda/actionContador.png");
	private Img imgText					= new Img("agenda/actionContadorText.png");
	private Img imgTextRigth			= new Img("agenda/actionContadorTextRigth.png");
	
	private Label labelText 			= new Label();
	private Label rightLabelTextTop 	= new Label();
	private Label rightLabelTextButton	= new Label();

	
	private int wWidth = TouchScreenConstantes.DEFAULT_WIDTH_ACTION_BUTTON_CALENDAR;
		
	public ActionButtonCalendar(boolean showRigthPanel){
		
		this.setWidth(wWidth);
		this.setHeight(TouchScreenConstantes.DEFAULT_HEIGHT_ACTION_BUTTON_ESPACO_LOCAL);
		
		labelText.setAlign(Alignment.CENTER);
		
		img.setParentElement(this);
		img.setWidth(wWidth);
		img.setHeight(TouchScreenConstantes.DEFAULT_HEIGHT_ACTION_BUTTON_ESPACO_LOCAL);
	
		img.animateShow(AnimationEffect.SLIDE);
	
		imgText.setParentElement(this);
		imgText.setLeft(2);
		imgText.setTop(5);
		imgText.setBackgroundColor("#ffffff");
		imgText.setWidth(wWidth-8);
		imgText.setHeight(TouchScreenConstantes.DEFAULT_HEIGHT_ACTION_BUTTON_ESPACO_LOCAL-16);
		
			
		
		labelText.setAlign(Alignment.CENTER);
		
		labelText.setParentElement(this);
		if ( showRigthPanel )
			labelText.setWidth(wWidth-27);
		else
			labelText.setWidth(wWidth);

		labelText.setHeight(54);
		labelText.setContents("");
		
		
		imgText.show();		
		labelText.show();
		
		if ( showRigthPanel ){
			
			imgTextRigth.setParentElement(this);
			imgTextRigth.setLeft(wWidth-27);
			imgTextRigth.setTop(5);
			imgTextRigth.setWidth(21);
			imgTextRigth.setHeight(TouchScreenConstantes.DEFAULT_HEIGHT_ACTION_BUTTON_ESPACO_LOCAL-16);
			imgTextRigth.setBackgroundColor("ffffff");
			imgTextRigth.show();
			
			rightLabelTextTop.setParentElement(imgTextRigth);
			rightLabelTextTop.setAlign(Alignment.CENTER);
			rightLabelTextTop.setLeft(3);
			rightLabelTextTop.setTop(2);
			rightLabelTextTop.setWidth(10);
			rightLabelTextTop.setHeight(10);
			rightLabelTextTop.setBackgroundColor("#CCCCCC");
			rightLabelTextTop.setContents("<STRONG></STRONG>");
			rightLabelTextTop.setShowShadow(true);
			//rightLabelTextTop.setShadowOffset(2);
			rightLabelTextTop.setShadowSoftness(3);
			rightLabelTextTop.show();

			rightLabelTextButton.setParentElement(imgTextRigth);
			rightLabelTextButton.setAlign(Alignment.CENTER);
			rightLabelTextButton.setLeft(3);
			rightLabelTextButton.setTop(19);
			rightLabelTextButton.setWidth(10);
			rightLabelTextButton.setHeight(10);
			rightLabelTextButton.setBackgroundColor("#CCCCCC");
			rightLabelTextButton.setContents("<STRONG></STRONG>");
			rightLabelTextButton.setShowShadow(true);
			//rightLabelTextButton.setShadowOffset(2);
			rightLabelTextButton.setShadowSoftness(3);
			rightLabelTextButton.show();

		
		}
	}

	public void setLabel(String label){
		if( labelText != null )
			labelText.setContents(label);
	}

	/**
	 * @return the dateCalendar
	 */
	public Date getDateCalendar() {
		return dateCalendar;
	}


	/**
	 * @return the weekAction
	 */
	public ActionButtonCalendar getWeekAction() {
		return weekAction;
	}

	/**
	 * @param weekAction the weekAction to set
	 */
	public void setWeekAction(ActionButtonCalendar weekAction) {
		this.weekAction = weekAction;
	}
	
	/**
	 * @param dateCalendar the dateCalendar to set
	 */
	public void setDateCalendar(Date dateCalendar) {
		this.dateCalendar = dateCalendar;
		if( dateCalendar.getDay() == 0 || dateCalendar.getDay() == 6){
			img.setSrc("agenda/actionContadorOrange.png");
			imgText.setSrc("agenda/actionContadorTextOrange.png");
			imgTextRigth.setSrc("agenda/actionContadorTextRigthOrange.png");
		}
		else{
			img.setSrc("agenda/actionContador.png");
			imgText.setSrc("agenda/actionContadorText.png");
			imgTextRigth.setSrc("agenda/actionContadorTextRigth.png");
		}
		if ( weekAction != null )
			weekAction.setDateCalendar(dateCalendar);

		for ( ActionButtonCalendar actionButtonCalendar : itemsCalendar ){
			actionButtonCalendar.setDateCalendar(dateCalendar);
		}
	}

	
	public void setValues(Totalizador totalizador){
	
		int confirmado = 0;
		int reservado  = 0;
		
		if( totalizador != null ){
			confirmado = totalizador.getConfirmado();
			reservado  = totalizador.getReserva();			
		}
 
		
		if ( confirmado > 0 || reservado > 0 ){
			labelText.setWidth(wWidth-27);
			
			imgTextRigth.setVisible(true);
			
			this.setLabel(""+(confirmado + reservado));

			if( confirmado > 0 )
				imgText.setBackgroundColor("red");
			else if ( reservado > 0 )
				imgText.setBackgroundColor("yellow");
			
			if( confirmado > 0 ){
				rightLabelTextTop.setVisible(true);
				rightLabelTextTop.setContents("C");
			}
			else{
				rightLabelTextTop.setVisible(false);
				rightLabelTextTop.setContents("");				
			}
			
			if ( reservado > 0 ){
				rightLabelTextButton.setVisible(true);
				rightLabelTextButton.setContents("R");
			}
			else{
				rightLabelTextButton.setVisible(false);
				rightLabelTextButton.setContents("");				
			}			
		}
		else{
			imgTextRigth.setVisible(false);
			rightLabelTextTop.setVisible(false);
			rightLabelTextButton.setVisible(false);
			labelText.setWidth(wWidth);
			this.setLabel("");			
			imgText.setBackgroundColor("#33FF33");			
		}

	}

	/**
	 * @return the itemsCalendar
	 */
	public ArrayList<ActionButtonCalendar> getItemsCalendar() {
		return itemsCalendar;
	}
 
	
	public void setSelected(boolean selected){
		this.selected = selected;
		
		if( selected ){
			
			this.imgText.setStyleName(TouchScreenConstantes.getColorTipoArea(this.getTipoArea()));
			this.getWeekAction().getImgText().setStyleName(TouchScreenConstantes.getColorTipoArea(this.getTipoArea()));
			this.labelText.setStyleName("calendarVillaBisuttiSelect");
			this.getWeekAction().getLabelText().setStyleName("calendarVillaBisuttiSelect");
		}
		else{
			this.imgText.setStyleName(this.normalColor);
			this.getWeekAction().getImgText().setStyleName(this.normalColor);
			this.labelText.setStyleName("calendarVillaBisuttiNormal");	
			this.getWeekAction().getLabelText().setStyleName("calendarVillaBisuttiNormal");
		}
		this.imgText.redraw();
		this.labelText.redraw();
	}


	/**
	 * Configura a navegação do mouse sobre o botão.
	 */
	public void configureMouseOverOut(){
		this.setCursor(Cursor.HAND);
		this.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				
				if ( ! selected )
					imgText.setStyleName(overColor);
				else
					imgText.setStyleName(TouchScreenConstantes.getColorTipoArea(getTipoArea()));

			}
		});
		
		this.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				if( ! selected )
					imgText.setStyleName(normalColor);					
				else
					imgText.setStyleName(TouchScreenConstantes.getColorTipoArea(getTipoArea()));
			}
		});		
	}

	/**
	 * @return the labelText
	 */
	public Label getLabelText() {
		return labelText;
	}

	/**
	 * @param labelText the labelText to set
	 */
	public void setLabelText(Label labelText) {
		this.labelText = labelText;
	}

	/**
	 * @return the imgText
	 */
	public Img getImgText() {
		return imgText;
	}

	/**
	 * @return the tipoArea
	 */
	public int getTipoArea() {
		return tipoArea;
	}

	/**
	 * @param tipoArea the tipoArea to set
	 */
	public void setTipoArea(int tipoArea) {
		this.tipoArea = tipoArea;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}
	
	public void createOnClick(PainelDetalheEspacosLocais painelDetalheEspacosLocais){
		
		parentPainelDetalheEspacosLocais = painelDetalheEspacosLocais;
			
		this.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				parentPainelDetalheEspacosLocais.getParentPainelEspacosLocais().onShowDetail(ActionButtonCalendar.this);
			}
		});
	}

	/**
	 * @return the parentPainelDetalheEspacosLocais
	 */
	public PainelDetalheEspacosLocais getParentPainelDetalheEspacosLocais() {
		return parentPainelDetalheEspacosLocais;
	}

	/**
	 * @param parentPainelDetalheEspacosLocais the parentPainelDetalheEspacosLocais to set
	 */
	public void setParentPainelDetalheEspacosLocais(
			PainelDetalheEspacosLocais parentPainelDetalheEspacosLocais) {
		this.parentPainelDetalheEspacosLocais = parentPainelDetalheEspacosLocais;
	}

}