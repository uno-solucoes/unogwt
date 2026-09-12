package com.howmake.client.form.UI;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.control.HowMGWTControlFormDragSelect;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class HowMGWTFormToolbarDragSelect extends ToolStrip{

	private IButton actionSelectLeft 		= new IButton("");
	private IButton actionSelectRight 		= new IButton("");
	private IButton actionSelectAllLeft 	= new IButton("");
	private IButton actionSelectAllRight 	= new IButton("");
	
	public HowMGWTFormToolbarDragSelect(final HowMGWTControlFormDragSelect controlFormDragSelect){
		
		this.setWidth(30);
		this.setHeight100();
		this.setVertical(true);
	
		this.setAlign(VerticalAlignment.CENTER);
	
	
		actionSelectLeft.setWidth(22);
		actionSelectLeft.setIcon("actions/prev.png"); 
	
		actionSelectRight.setWidth(22);
		actionSelectRight.setIcon("actions/next.png"); 

		actionSelectAllLeft.setWidth(22);
		actionSelectAllLeft.setIcon("actions/btn_left_all.png");
		
		actionSelectAllRight.setWidth(22);
		actionSelectAllRight.setIcon("actions/btn_right_all.png");
	
		this.addMember(this.actionSelectLeft);
		this.addMember(this.actionSelectRight);
		
		this.addSeparator();
		this.addMember(this.actionSelectAllLeft);
		this.addMember(this.actionSelectAllRight);
		
		controlFormDragSelect.onHowMInit(this);	
		
		ClickHandler actions = new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if ( event.getSource() == actionSelectLeft  ){
					if ( ! controlFormDragSelect.onHowMSendLeft() )
						SC.say(Tradutor.i18n.formSelecionePrimeiroRegistroNaListaDaDireita());
				}
				else if ( event.getSource() == actionSelectRight ){
					if ( ! controlFormDragSelect.onHowMSendRight() )
						SC.say(Tradutor.i18n.formSelecionePrimeiroRegistroNaListaDaEsquerda());
				}
				else if ( event.getSource() == actionSelectAllLeft ){
					if( ! controlFormDragSelect.onHowMSendAllLeft()){
						SC.say(Tradutor.i18n.formNaoHaRegistrosNaListaDaDireita());						
					}
				}
				else if ( event.getSource() == actionSelectAllRight ){
					if ( ! controlFormDragSelect.onHowMSendAllRight() )
						SC.say(Tradutor.i18n.formNaoHaRegistrosNaListaDaEsquerda());												
				}
			}
		};
		
		
		actionSelectAllLeft.addClickHandler(actions);
		actionSelectAllRight.addClickHandler(actions);
		actionSelectLeft.addClickHandler(actions);
		actionSelectRight.addClickHandler(actions);
	}

	/**
	 * @return the actionSelectLeft
	 */
	public IButton getActionSelectLeft() {
		return actionSelectLeft;
	}

	/**
	 * @return the actionSelectRight
	 */
	public IButton getActionSelectRight() {
		return actionSelectRight;
	}

	/**
	 * @return the actionSelectAllLeft
	 */
	public IButton getActionSelectAllLeft() {
		return actionSelectAllLeft;
	}

	/**
	 * @return the actionSelectAllRight
	 */
	public IButton getActionSelectAllRight() {
		return actionSelectAllRight;
	}
	

	
	
}
