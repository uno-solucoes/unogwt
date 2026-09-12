package com.br.client.panel.at.atw0117;

import java.util.ArrayList;

import com.br.client.model.at.entity.eTouchAgenda;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelDetalheAgenda extends VLayout{

	public VLayout mainLayout = new VLayout();
	public HLayout toolbar    = new HLayout();

	private ArrayList<PainelDetalheAgendaHora> agendaHoras = new ArrayList<PainelDetalheAgendaHora>();
	public PainelDetalheAgenda(){

		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		this.setVisible(false);
		
		this.setWidth100();
		
		// this.setShowShadow(true);	
		this.setHeight(250);

		PainelDetalheAgendaHora agendaHora;
		for( int i = 0 ; i < 8 ; i++ ){
			agendaHora = new PainelDetalheAgendaHora();
			mainLayout.addMember(agendaHora);
			mainLayout.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(5, ""));
			agendaHoras.add(agendaHora);
		}
		
		this.addMember(mainLayout);		
		
		toolbar.setWidth100();
		toolbar.setHeight(32);
		toolbar.setAlign(Alignment.RIGHT);
		
//		ImgButton actionNew  = new ImgButton();
//
//		actionNew.setSrc("agenda/action_new.png");
//		actionNew.setWidth(48);
//		actionNew.setHeight(48);
//		actionNew.addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				PainelAgendaTouchScreen.showEditaEvento(null);
//			}
//		});
//		toolbar.addMember(actionNew);
		
		ImgButton actionVoltar = new ImgButton();
		actionVoltar.setWidth(48);
		actionVoltar.setHeight(48);			
		actionVoltar.setSrc("agenda/action_voltar_loop.png");
		toolbar.addMember(actionVoltar);
		
		actionVoltar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {				
				onVoltarAgenda();
			}
		});
		
		this.addMember(toolbar);
	}
	
	@Override
	public void setWidth(int width) {
		super.setWidth(width);
		mainLayout.setWidth(width);
		toolbar.setWidth(width);
	}
	
	protected void onVoltarAgenda(){}
	
	
	public void showAgendaDia(Totalizador totalizador){

		PainelDetalheAgendaHora agendaHora;
		for( int i = 0 ; i < agendaHoras.size() ; i ++ ){
			agendaHora = agendaHoras.get(i);
			agendaHora.setWidth(this.getWidth());
			if( totalizador != null && totalizador.getAgendas() != null ){
				if( i < totalizador.getAgendas().size() ){
					agendaHora.setAgenda(totalizador.getAgendas().get(i));
				}
				else
					agendaHora.setAgenda(null);
			}
			else
				agendaHora.setAgenda(null);
		}
	}
}