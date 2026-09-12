package com.br.client.panel.vd.vdw1000.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.at.atw0117.ActionButton;
import com.howmake.client.form.UI.HowMGWTActionOK;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


public class PanelLoginSuporte extends HLayout{

	private String suporteUsuario;
	private String suporteSenha;
	
	private HowMGWTProperty propertyUsuario = new HowMGWTProperty("usuario", Tradutor.i18n.formUsuario());
	private HowMGWTProperty propertySenha   = new HowMGWTProperty("senha",   Tradutor.i18n.formSenha());
	
	
	public PanelLoginSuporte(){
		
		VLayout formLayout = new VLayout(); 
		formLayout.setWidth100();
		formLayout.setHeight100();
		
		this.setHeight100();
		this.setWidth(260);
		
		propertyUsuario.setBound(100, 150);
		propertyUsuario.createHowMFieldTextItem();
		formLayout.addMember(propertyUsuario.getCanvas());
		
		
		propertySenha.setBound(100,150);
		propertySenha.createHowMFieldPasswordItem();
		formLayout.addMember(propertySenha.getCanvas());

		this.addMember(formLayout);
		
		
		HowMGWTActionOK actionButton = new HowMGWTActionOK();
		actionButton.setWidth(80);
		actionButton.setHeight(46);
		actionButton.setTitle("Conectar");
		this.addMember(actionButton);
		
		actionButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				if( ! HowMGWTUtilities.isEquals( propertyUsuario.getHowMValue() , suporteUsuario ) ){
					SC.say("Usuario nao tem acesso ao suporte Eletronico...");
				}

				if( !HowMGWTUtilities.isEquals( propertySenha.getHowmFormValue(), suporteSenha ) ){
					SC.say("Usuario nao tem acesso ao suporte Eletronico...");
				}
				
				if(isConnect() ){				
					onConnect();
				}

			}
			
		});
		
	}
	
	public void configure(String suporteUsuario, String suporteSenha ){
		this.suporteUsuario = suporteUsuario;
		this.suporteSenha   = suporteSenha;
	}
	
	private boolean isConnect(){
		if( !HowMGWTUtilities.isEquals( this.suporteUsuario , this.propertyUsuario.getHowmFormValue() )){
			SC.say("Usuario nao tem acesso ao suporte");
			return false;
		}
		if( !HowMGWTUtilities.isEquals( this.suporteSenha , this.propertySenha.getHowmFormValue() )){
			SC.say("Usuario nao tem acesso ao suporte");
			return false;
		}
		return true;
	}
	
	protected void onConnect(){}
	
}