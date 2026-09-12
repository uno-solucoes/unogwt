package com.br.client.panel.at.atw0117;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.br.client.model.at.entity.eTouchLocalEspaco;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelDetalheEspacosLocais extends HLayout{

	
	private boolean showDetalheDia = false;
	
	private eTouchLocalEspaco[] touchLocalEspacos;
	
	private PainelEspacosLocais parentPainelEspacosLocais;
	
	private ArrayList<ActionButtonCalendar> rowHeaderDayOfMonth;

	private Canvas currentPanel;

	private ActionButtonCalendar currentActionButtonCalendar;
	private ActionButtonEspacoLocal currentActionButtonEspacoLocal;

	private int tipoArea = TouchScreenConstantes.TIPO_ESPACO;
	private LinkedHashMap<String, ActionButtonEspacoLocal> actionsButtonEspacoLocal = new LinkedHashMap<String, ActionButtonEspacoLocal>();

	private PainelDetalheAgenda  painelDetalheAgenda = new PainelDetalheAgenda(){
		protected void onVoltarAgenda() {
			showAgenda();
		};
	};

	private PainelLotacaoEventos lotacaoEventos = new PainelLotacaoEventos();
	private VLayout mainAreas = new VLayout();
	
	private boolean selected;
	
	public PainelDetalheEspacosLocais(){
 
		this.mainAreas.setWidth(TouchScreenConstantes.DEFAULT_WIDTH_ACTION_BUTTON_ESPACO_LOCAL);
		this.mainAreas.setHeight100();

		this.currentPanel = this.lotacaoEventos;
		
		this.addMember(this.mainAreas);		
		this.addMember(this.lotacaoEventos);
		this.addMember(this.painelDetalheAgenda);
	}	


	

	/**
	 * @return the currentActionButtonCalendar
	 */
	public ActionButtonCalendar getCurrentActionButtonCalendar() {
		return currentActionButtonCalendar;
	}

	/**
	 * @return the currentActionButtonEspacoLocal
	 */
	public ActionButtonEspacoLocal getCurrentActionButtonEspacoLocal() {
		return currentActionButtonEspacoLocal;
	}

	/**
	 * @return the tipoArea
	 */
	public int getTipoArea() {
		return tipoArea;
	}

 

	/**
	 * @param currentActionButtonCalendar the currentActionButtonCalendar to set
	 */
	public void setCurrentActionButtonCalendar(
			ActionButtonCalendar currentActionButtonCalendar) {
		this.currentActionButtonCalendar = currentActionButtonCalendar;
	}
	

	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @param selected the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * @return the actionsButtonEspacoLocal
	 */
	public LinkedHashMap<String, ActionButtonEspacoLocal> getActionsButtonEspacoLocal() {
		return actionsButtonEspacoLocal;
	}

	/**
	 * @param actionsButtonEspacoLocal the actionsButtonEspacoLocal to set
	 */
	public void setActionsButtonEspacoLocal(
			LinkedHashMap<String, ActionButtonEspacoLocal> actionsButtonEspacoLocal) {
		this.actionsButtonEspacoLocal = actionsButtonEspacoLocal;
	}
		
	public void createDetalheEspacoLocais(PainelEspacosLocais painelEspacosLocais, eTouchLocalEspaco[] touchLocalEspacos, ArrayList<ActionButtonCalendar> rowHeaderDayOfMonth){

		this.touchLocalEspacos = touchLocalEspacos;
		
		this.parentPainelEspacosLocais = painelEspacosLocais;
		this.rowHeaderDayOfMonth = rowHeaderDayOfMonth;
		
		this.actionsButtonEspacoLocal.clear();
		
		tipoArea = TouchScreenConstantes.TIPO_ESPACO;
		
		ActionButtonEspacoLocal actionButtonEspacoLocal;
		
		int row = 0;
 		// Monta a quantidade de eventos no calendário por dia local.
		for( eTouchLocalEspaco touchLocalEspaco : touchLocalEspacos ){
					
			actionButtonEspacoLocal = new ActionButtonEspacoLocal(false, touchLocalEspaco);
			actionButtonEspacoLocal.setLabel(touchLocalEspaco.getDescAbrevLocal());
			actionButtonEspacoLocal.setCursor(Cursor.HAND);
			this.mainAreas.addMember(actionButtonEspacoLocal);

			this.setCursor(Cursor.HAND);

			actionButtonEspacoLocal.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {					

					currentActionButtonEspacoLocal =(ActionButtonEspacoLocal)event.getSource();

					Object[] keys = PainelDetalheEspacosLocais.this.actionsButtonEspacoLocal.keySet().toArray();
					for ( Object key : keys )
						PainelDetalheEspacosLocais.this.actionsButtonEspacoLocal.get(key).setSelected(false);

					currentActionButtonEspacoLocal.setSelected(true);
					showAgendaDia(false);
				}
			});			

			PainelItemEventos itemEvento = lotacaoEventos.createAreaLotacaoEventos(this,touchLocalEspaco, tipoArea, rowHeaderDayOfMonth, row );
			actionButtonEspacoLocal.setItemEvento(itemEvento);
			// Adiciona os espaços locais em uma lista.
			actionsButtonEspacoLocal.put(touchLocalEspaco.getCodLocal(),actionButtonEspacoLocal);
			
			// Remove da visão o local ou espaço que não deverá ser visivel.
			if( ! (""+tipoArea).equals(touchLocalEspaco.getCodTipoLocal())){
				actionButtonEspacoLocal.setVisible(false);
			}
			row ++;
			
		}
	}

	public void showTipoArea(int tipoArea){		
		this.tipoArea = tipoArea;
		
		showAgenda();		
		
		Object[]  actions = actionsButtonEspacoLocal.keySet().toArray();
		for( Object action : actions){

			ActionButtonEspacoLocal actionButtonEspacoLocal = (ActionButtonEspacoLocal)actionsButtonEspacoLocal.get(action);

			if( (""+tipoArea).equals(actionButtonEspacoLocal.getTouchLocalEspaco().getCodTipoLocal() )){
				actionButtonEspacoLocal.setVisible(true);
				actionButtonEspacoLocal.getItemEvento().setVisible(true);
			}
			else{
				actionButtonEspacoLocal.setVisible(false);
				actionButtonEspacoLocal.getItemEvento().setVisible(false);				
			}
		}
	}	
	
	/**
	 * Atualiza os dados de detalhe da agenda conforme navegação do calendário.
	 */
	public void refreshAgendaDia(){
		if ( ! this.isShowDetalheDia() )
			return;
		
		Totalizador totalizador = this.currentActionButtonEspacoLocal.getTotalizador(this.currentActionButtonCalendar.getDateCalendar());

		this.painelDetalheAgenda.showAgendaDia(totalizador);

		this.painelDetalheAgenda.showAgendaDia(totalizador);
	}

	/**
	 * Apresenta a agenda do dia para a data selecionada e o espaço ou local selecionado..
	 */
	public void showAgendaDia(boolean actionCalendar ){

		if ( this.currentPanel == this.lotacaoEventos ){

			if( actionCalendar ){
				if ( this.getCurrentActionButtonEspacoLocal() == null ){
					Object[] keys = this.actionsButtonEspacoLocal.keySet().toArray();
					if ( keys != null && keys.length > 0 ){
						this.currentActionButtonEspacoLocal = this.actionsButtonEspacoLocal.get(keys[0]);
						this.currentActionButtonEspacoLocal.setSelected(true);
					}
					else
						return;
				}
			}
			else if( this.getCurrentActionButtonCalendar() == null ){
				for( ActionButtonCalendar calendar : this.rowHeaderDayOfMonth)
					calendar.setTipoArea(HowMGWTUtilities.getInteger(this.currentActionButtonEspacoLocal.getTouchLocalEspaco().getCodTipoLocal()));
   
				this.currentActionButtonCalendar = this.rowHeaderDayOfMonth.get(0);
				this.currentActionButtonCalendar.setSelected(true);
			}
			this.painelDetalheAgenda.setWidth(this.lotacaoEventos.getWidthLotacaoEvento());
			this.lotacaoEventos.hide();
			painelDetalheAgenda.animateShow(AnimationEffect.FADE);

			Totalizador totalizador = this.currentActionButtonEspacoLocal.getTotalizador(this.currentActionButtonCalendar.getDateCalendar());
			
			this.painelDetalheAgenda.showAgendaDia(totalizador);
			
			this.setShowDetalheDia(true);
		}		
	}

	public void showAgenda(){
		
		if ( this.currentActionButtonEspacoLocal == null )
			return;
		
		currentActionButtonCalendar.setTipoArea(this.getTipoArea());
		currentActionButtonEspacoLocal.setSelected(false);
		currentActionButtonCalendar.setSelected(false);
		
		currentActionButtonEspacoLocal 	= null;
		currentActionButtonCalendar		= null;

		this.painelDetalheAgenda.hide();
		lotacaoEventos.animateShow(AnimationEffect.FADE);
	}




	/**
	 * @return the parentPainelEspacosLocais
	 */
	public PainelEspacosLocais getParentPainelEspacosLocais() {
		return parentPainelEspacosLocais;
	}
 
	/**
	 * @param parentPainelEspacosLocais the parentPainelEspacosLocais to set
	 */
	public void setParentPainelEspacosLocais(
			PainelEspacosLocais parentPainelEspacosLocais) {
		this.parentPainelEspacosLocais = parentPainelEspacosLocais;
	}
 
	/**
	 * @return the touchLocalEspacos
	 */
	public eTouchLocalEspaco[] getTouchLocalEspacos() {
		return touchLocalEspacos;
	}
 
	/**
	 * @param touchLocalEspacos the touchLocalEspacos to set
	 */
	public void setTouchLocalEspacos(eTouchLocalEspaco[] touchLocalEspacos) {
		this.touchLocalEspacos = touchLocalEspacos;
	}

	
	public void setForceSelectEspacoLocal(ActionButtonEspacoLocal actionEspacoLocal){
		currentActionButtonEspacoLocal =actionEspacoLocal;

		Object[] keys = PainelDetalheEspacosLocais.this.actionsButtonEspacoLocal.keySet().toArray();
		for ( Object key : keys )
			PainelDetalheEspacosLocais.this.actionsButtonEspacoLocal.get(key).setSelected(false);

		currentActionButtonEspacoLocal.setSelected(true);		
	}
 

	/**
	 * @param currentActionButtonEspacoLocal the currentActionButtonEspacoLocal to set
	 */
	public void setCurrentActionButtonEspacoLocal(
			ActionButtonEspacoLocal currentActionButtonEspacoLocal) {
		this.currentActionButtonEspacoLocal = currentActionButtonEspacoLocal;
		

		Object[] keys = PainelDetalheEspacosLocais.this.actionsButtonEspacoLocal.keySet().toArray();
		for ( Object key : keys )
			PainelDetalheEspacosLocais.this.actionsButtonEspacoLocal.get(key).setSelected(false);

		currentActionButtonEspacoLocal.setSelected(true);		
	}
 
	/**
	 * @return the showDetalheDia
	 */
	public boolean isShowDetalheDia() {
		return showDetalheDia;
	}
 
	/**
	 * @param showDetalheDia the showDetalheDia to set
	 */
	public void setShowDetalheDia(boolean showDetalheDia) {
		this.showDetalheDia = showDetalheDia;
	}
}