package com.br.client.panel.at.atw0117;

import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelOpcoes extends VLayout{
	
	private int w = TouchScreenConstantes.DEFAULT_WIDTH_OPTIONS;
	private double pa= TouchScreenConstantes.DEFAULT_PERCENT_AMPLIADO;
 
	ActionButton actionEspacos;
	ActionButton actionLocais;
//	ActionButton actionMeses;
//	ActionButton actionAnos;

	ActionButton currentAction;

	public PainelOpcoes(){

		this.setWidth((int)(w*pa)+30);
		this.setMargin(10);

		actionEspacos 	= new ActionButton("agenda/buttonEspaco.png"){
			@Override
			public void onConfigure(ActionButton action) {
				PainelOpcoes.this.onConfigure(action);
			}
		};

		actionLocais 	= new ActionButton("agenda/buttonLocal.png"){
			@Override
			public void onConfigure(ActionButton action) {
				PainelOpcoes.this.onConfigure(action);
			}
		};
//
//		actionMeses 	= new ActionButton("agenda/buttonMesAno.png"){
//			@Override
//			public void onConfigure(ActionButton action) {				
//				onShowPainelMeses();
//			}			
//		};

//		actionAnos 	= new ActionButton("agenda/buttonAno.png"){
//			@Override
//			public void onConfigure(ActionButton action) {
//				// PainelOpcoes.this.onConfigure(action);			
//			}			
//		};

        this.addMember(actionEspacos);
        this.addMember(actionLocais);
        
        
        this.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(100, ""));
        
//        this.addMember(actionMeses);
//        this.addMember(actionAnos);

        this.onConfigure(actionEspacos);
	}
	
	/**
	 * Configura a aparencia dos botões conforme os mesmos forem selecionados.
	 * @param action
	 */
	public void onConfigure(final ActionButton action){
		if ( currentAction == action )
			return;
		
		if ( currentAction != action)
			action.selectButton();
		
		if ( currentAction != null )
			currentAction.deselectButton();
		
		currentAction = action;
		
		if ( action == actionEspacos ){
			onActionEspacos();
		}
		else if ( action == actionLocais ){
			onActionLocais();
		}
//		else if ( action == actionMeses ){
//			onActionMeses();
//		}
		else if ( action == action ){
			onActionAno();
		}
	}

	protected void onActionEspacos(){}
	protected void onActionLocais(){}
	protected void onActionMeses(){}
	protected void onActionAno(){}
	
	protected void onShowPainelMeses(){}

//	/**
//	 * @return the actionMeses
//	 */
//	public ActionButton getActionMeses() {
//		return actionMeses;
//	}
}