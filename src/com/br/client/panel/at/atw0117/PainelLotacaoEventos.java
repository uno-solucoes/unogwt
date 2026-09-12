package com.br.client.panel.at.atw0117;

import java.util.ArrayList;

import com.br.client.model.at.entity.eTouchLocalEspaco;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelLotacaoEventos extends HLayout{

	private int widthLotacaoEvento = 0;
	
	private VLayout mainLayout 		= new VLayout();
		
	public PainelLotacaoEventos(){
		
		this.setWidth100();
		this.setHeight100();
		this.addMember(this.mainLayout);
	}
	
	/**
	 * Cria o espaço conforme o tipo de área de lotação informada.
	 * @param touchLocalEspacos
	 * @param tipo
	 */
	public PainelItemEventos createAreaLotacaoEventos(PainelDetalheEspacosLocais painelDetalheEspacosLocais, eTouchLocalEspaco  touchLocalEspaco, int tipo, ArrayList<ActionButtonCalendar> rowHeaderDayOfMonth, int row){
 
		int w = 0;
		
		PainelItemEventos itemEventos = new PainelItemEventos();
		for ( int i = 1; i <= TouchScreenConstantes.DEFAULT_MAX_DAY ; i ++){								
			ActionButtonCalendar actionButtonCalendar = new ActionButtonCalendar(true);
			actionButtonCalendar.setColumn(i-1);
			actionButtonCalendar.setRow(row);
			actionButtonCalendar.createOnClick(painelDetalheEspacosLocais);
			
			actionButtonCalendar.setValues(null);
			itemEventos.addMember(actionButtonCalendar);
			
			w += actionButtonCalendar.getWidth();
			
			rowHeaderDayOfMonth.get(i-1).getItemsCalendar().add(actionButtonCalendar);
		}
		
		mainLayout.addMember(itemEventos);
		
		this.setWidthLotacaoEvento(w);
		
		// Remove da visão o local ou espaço que não deverá ser visivel.
		if( ! (""+tipo).equals(touchLocalEspaco.getCodTipoLocal())){
			itemEventos.setVisible(false);
		}
		return itemEventos;
	}

	/**
	 * @return the widthLotacaoEvento
	 */
	public int getWidthLotacaoEvento() {
		return widthLotacaoEvento;
	}

	/**
	 * @param widthLotacaoEvento the widthLotacaoEvento to set
	 */
	public void setWidthLotacaoEvento(int widthLotacaoEvento) {
		this.widthLotacaoEvento = widthLotacaoEvento;
	}

	
}
