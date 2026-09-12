package com.br.client.panel.at.atw0117;

import java.util.Date;
import java.util.LinkedHashMap;

import com.br.client.model.at.entity.eTouchAgenda;
import com.br.client.model.at.entity.eTouchLocalEspaco;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.types.BackgroundRepeat;
import com.smartgwt.client.types.BkgndRepeat;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.MouseOutEvent;
import com.smartgwt.client.widgets.events.MouseOutHandler;
import com.smartgwt.client.widgets.events.MouseOverEvent;
import com.smartgwt.client.widgets.events.MouseOverHandler;
 

public class ActionButtonEspacoLocal  extends Canvas{
	
	LinkedHashMap< String , Totalizador> mapTotalizadores = new LinkedHashMap<String, Totalizador>();

	
	private String overColor		= "agenda/actionDescricaoOver.png";
	private String normalColor		= "agenda/actionDescricaoNormal.png";
	
	private boolean selected;
	
	
//	private Img img;
	// private Img imgText;
	
	private Label labelText;
	// private Label rightLabelText;
	
	private eTouchLocalEspaco touchLocalEspaco;
	private PainelItemEventos itemEvento;
	
	public ActionButtonEspacoLocal(boolean space, eTouchLocalEspaco touchLocalEspaco ){

		this.setBackgroundRepeat(BackgroundRepeat.NO_REPEAT);
		this.touchLocalEspaco = touchLocalEspaco;

		this.setCursor(Cursor.HAND);
		
		int wWidth = TouchScreenConstantes.DEFAULT_WIDTH_ACTION_BUTTON_ESPACO_LOCAL;
		
		this.setWidth(wWidth);
		this.setHeight(TouchScreenConstantes.DEFAULT_HEIGHT_ACTION_BUTTON_ESPACO_LOCAL);

		if ( ! space ){ 

//			img 			= new Img("agenda/actionDescricao.png");
			// imgText 		= new Img("agenda/actionDescricaoText.png");

			labelText 		= new Label();
	//		rightLabelText 	= new Label();

			labelText.setAlign(Alignment.CENTER);

//			img.setParentElement(this);
//			img.setWidth(wWidth);
//			img.setHeight(TouchScreenConstantes.DEFAULT_HEIGHT_ACTION_BUTTON_ESPACO_LOCAL);

//
//			imgText.setParentElement(this);
//			imgText.setLeft(2);
//			imgText.setTop(2);
setBackgroundImage(normalColor);
//			imgText.setWidth(wWidth-6);
//			imgText.setHeight(TouchScreenConstantes.DEFAULT_HEIGHT_ACTION_BUTTON_ESPACO_LOCAL-10);
//			
			
//			
//			img.animateShow(AnimationEffect.SLIDE);
			
			labelText.setAlign(Alignment.CENTER);
			
			labelText.setParentElement(this);
			labelText.setWidth(wWidth);
	
			labelText.setHeight(TouchScreenConstantes.DEFAULT_HEIGHT_ACTION_BUTTON_ESPACO_LOCAL);
			labelText.setContents("");
			
//			
//			imgText.show();
			labelText.show();
//			rightLabelText.show();

			this.addMouseOverHandler(new MouseOverHandler() {
				
				@Override
				public void onMouseOver(MouseOverEvent event) {
					
					if ( ActionButtonEspacoLocal.this.getTouchLocalEspaco() != null ){
						if ( ! selected )
							setBackgroundImage(overColor);
						else
							setBackgroundImage(TouchScreenConstantes.getImageTipoArea(HowMGWTUtilities.getInteger(ActionButtonEspacoLocal.this.getTouchLocalEspaco().getCodTipoLocal())));
					}
					
				}
			});
			
			this.addMouseOutHandler(new MouseOutHandler() {
				
				@Override
				public void onMouseOut(MouseOutEvent event) {
					if ( ActionButtonEspacoLocal.this.getTouchLocalEspaco() != null ){
						if( ! selected )
							setBackgroundImage(normalColor);					
						else
							setBackgroundImage(TouchScreenConstantes.getImageTipoArea(HowMGWTUtilities.getInteger(ActionButtonEspacoLocal.this.getTouchLocalEspaco().getCodTipoLocal())));
					}
				}
			});
		}
	}
	
	public void setLabel(String label){
		labelText.setContents(label);
	}

	/**
	 * @return the itemEvento
	 */
	public PainelItemEventos getItemEvento() {
		return itemEvento;
	}

	/**
	 * @param itemEvento the itemEvento to set
	 */
	public void setItemEvento(PainelItemEventos itemEvento) {
		this.itemEvento = itemEvento;
	}

//	/**
//	 * @return the imgText
//	 */
//	public Img getImgText() {
//		return imgText;
//	}
//
//	/**
//	 * @param imgText the imgText to set
//	 */
//	public void setImgText(Img imgText) {
//		this.imgText = imgText;
//	}

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

//	/**
//	 * @return the rightLabelText
//	 */
//	public Label getRightLabelText() {
//		return rightLabelText;
//	}
//
//	/**
//	 * @param rightLabelText the rightLabelText to set
//	 */
//	public void setRightLabelText(Label rightLabelText) {
//		this.rightLabelText = rightLabelText;
//	}

	/**
	 * @return the touchLocalEspaco
	 */
	public eTouchLocalEspaco getTouchLocalEspaco() {
		return touchLocalEspaco;
	}

	/**
	 * @param touchLocalEspaco the touchLocalEspaco to set
	 */
	public void setTouchLocalEspaco(eTouchLocalEspaco touchLocalEspaco) {
		this.touchLocalEspaco = touchLocalEspaco;
	}
	
	/**
	 * Lotar locais espaços a partir dos dados da agenda.
	 * @param touchLocalEspaco
	 */
	public void showLotacaoLocaisEspacos(eTouchLocalEspaco touchLocalEspaco){
		
		// Limpa o mapa de totalizadores.
		mapTotalizadores.clear();
		
		Date dataEventoInicio;
		String sDataEventoInicio;
		
		String key;

		Date dataEventoFim;
		String sDataEventoFim;
		
		if( touchLocalEspaco.getEntityTouchAgendas() != null ){
			for ( eTouchAgenda  agenda : touchLocalEspaco.getEntityTouchAgendas() ){

				dataEventoInicio 	= HowMGWTUtilities.getDate(agenda.getDtAgendaIni());
				sDataEventoInicio 	= HowMGWTUtilities.getFormatDateDB(dataEventoInicio);
				// -------------------------------------------------------------------
				// Verifica se a data inicio do evento já foi contabilizado.
				// -------------------------------------------------------------------
				analisarTotalizador(mapTotalizadores,agenda, sDataEventoInicio);

				dataEventoFim    	= HowMGWTUtilities.getDate(agenda.getDtAgendaFim());
				sDataEventoFim		= HowMGWTUtilities.getFormatDateDB(dataEventoFim);

// Esta restrição inclui um registro caso o evento comece em um dia e termine no outro
// dia.
//					
//				// Verifica se a data fim do eento é diferente da data de inicio,
//				// se for, verifica se a data já foi contabilizada e contabiliza 
//				// conforme a situação da mesma. 
//				if ( ! HowMGWTUtilities.isEquals(sDataEventoInicio, sDataEventoFim))
//					analisarTotalizador(mapTotalizadores,agenda, sDataEventoFim);
			}
		}
		Canvas[] canvas = this.itemEvento.getChildren();
		ActionButtonCalendar actionButtonCalendar;
		// -------------------------------------------------------------
		// Percorre os itens do calendário e configura os totalizadores
		// -------------------------------------------------------------
		for ( Canvas canva : canvas ){
			 actionButtonCalendar = (ActionButtonCalendar)canva;

			sDataEventoInicio = HowMGWTUtilities.getFormatDateDB(actionButtonCalendar.getDateCalendar());
	
			key = touchLocalEspaco.getCodLocal()+"-"+sDataEventoInicio;
			
			Totalizador totalizador = mapTotalizadores.get(key);
			// Seta o totalizador do item do calendário.
			actionButtonCalendar.setValues(totalizador);
		}
	
	}
	
	/**
	 *  Analisa o totalizador para as datas de inicio e fim do evento.
	 * @param mapTotalizadores
	 * @param agenda
	 * @param dataEvento
	 * @return
	 */
	public Totalizador analisarTotalizador(LinkedHashMap<String, Totalizador> mapTotalizadores, eTouchAgenda agenda, String dataEvento){
		String key = agenda.getCodLocal()+"-"+dataEvento;

		Totalizador totalizador = mapTotalizadores.get(key);
		if ( totalizador == null ){
			totalizador = new Totalizador();
			mapTotalizadores.put(key, totalizador);
		}				
		if ( "1".equals( agenda.getSituacao() ) )
			totalizador.setConfirmado(totalizador.getConfirmado()+1);
		else if ( "2".equals( agenda.getSituacao() ) )
			totalizador.setReserva(totalizador.getReserva()+1);
		else 
			totalizador.setSemSituacao( totalizador.getSemSituacao());					

		// Adiciona a agenda que participou do totalizador.
		totalizador.getAgendas().add(agenda); 
		return totalizador;
		
	}

	public void setSelected(boolean selected){
		this.selected = selected;
		
		if( selected ){
			setBackgroundImage(TouchScreenConstantes.getImageTipoArea(HowMGWTUtilities.getInteger(ActionButtonEspacoLocal.this.getTouchLocalEspaco().getCodTipoLocal())));
			this.labelText.setStyleName("calendarVillaBisuttiSelect");
		}
		else{
			setBackgroundImage(this.normalColor);
			this.labelText.setStyleName("calendarVillaBisuttiNormal");
		}
	}

	/**
	 * @return the mapTotalizadores
	 */
	public LinkedHashMap<String, Totalizador> getMapTotalizadores() {
		return mapTotalizadores;
	}
	
	public Totalizador getTotalizador(Date date){
		String key = touchLocalEspaco.getCodLocal()+"-"+HowMGWTUtilities.getFormatDateDB(date);
		Totalizador totalizador = mapTotalizadores.get(key);
		return totalizador;
	}	
}