package com.br.client.panel.at.atw0117;

import com.br.client.model.at.entity.eTouchAgenda;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;

public class PainelDetalheAgendaHora extends HLayout{

	private eTouchAgenda agenda;

	private String selectedColor	= "agendaVillaButtonRed";
	private String overColor		= "agendaVillaButtonOver";
	private String normalColor		= "agendaVillaButtonNormal";

	private boolean selected;	

	private Label horaInicio = new Label();
	private Label horaFim    = new Label();
	private Label descricao  = new Label();
	private Label cliente    = new Label();

	public PainelDetalheAgendaHora(){
	
		this.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PainelAgendaTouchScreen.showDetalhesEvento(agenda);
			}
		});
		
		this.setHeight(24);
		this.setWidth100();
 
		this.setCursor(Cursor.HAND);
		
		horaInicio.setWidth(60);
		horaFim.setWidth(60);

		descricao.setWidth(140);
		descricao.setOverflow(Overflow.HIDDEN);	
		
		cliente.setWidth100();
		cliente.setOverflow(Overflow.HIDDEN);	

		horaInicio.setHeight100();
		
		horaFim.setHeight100();
		
		descricao.setHeight100();
		
		cliente.setHeight100();

		horaInicio.setAlign(Alignment.CENTER);
		horaFim.setAlign(Alignment.CENTER);
		descricao.setAlign(Alignment.CENTER);
		cliente.setAlign(Alignment.CENTER);

		this.addMember(horaInicio);
		this.addMember(horaFim);
		this.addMember(descricao);
		this.addMember(cliente);

		horaInicio.setCursor(Cursor.HAND);
		horaFim.setCursor(Cursor.HAND);
		descricao.setCursor(Cursor.HAND);
		cliente.setCursor(Cursor.HAND);
		
		horaInicio.setStyleName("calendarVillaBisuttiSelect");
		horaFim.setStyleName("calendarVillaBisuttiSelect");
		descricao.setStyleName("calendarVillaBisuttiSelect");
		cliente.setStyleName("calendarVillaBisuttiSelect");
	}	

	public void setSelected(boolean selected){
		this.selected = selected;
		
		if( selected ){
			this.setStyleName(this.selectedColor);
		}
		else{
			this.setStyleName(this.normalColor);
		}
	}

	/**
	 * @return the selectedColor
	 */
	public String getSelectedColor() {
		return selectedColor;		
	}

	/**
	 * @param selectedColor the selectedColor to set
	 */
	public void setSelectedColor(String selectedColor) {
		this.selectedColor = selectedColor;
	}
	
	
	public void setAgenda(eTouchAgenda agenda){
 
		if( agenda == null ){
			this.horaInicio.setContents("");
			this.horaFim.setContents("");
			this.descricao.setContents("");
			this.cliente.setContents("");
			this.agenda = null;
			this.setStyleName("");
			this.hide();
			return;
		}	
		
		this.setStyleName(TouchScreenConstantes.getColorTipoArea(HowMGWTUtilities.getInteger(agenda.getSituacao())));
		
		this.agenda = agenda;
		this.horaInicio.setContents(HowMGWTUtilities.getFormatTime(HowMGWTUtilities.getDate(agenda.getDtAgendaIni())));
		this.horaFim.setContents(HowMGWTUtilities.getFormatTime(HowMGWTUtilities.getDate(agenda.getDtAgendaFim())));
		this.descricao.setContents(agenda.getAssunto());
		this.cliente.setContents(agenda.getNomeCliente());
		this.setVisible(true);
		
	}
}