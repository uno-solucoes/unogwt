package com.br.client.panel.at.atw0117a;

import java.util.Date;
import java.util.LinkedHashMap;

import com.br.client.model.at.entity.eTouchLocalEspaco;
import com.br.client.model.cd.entity.eFeriado;
import com.google.gwt.core.client.Scheduler;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ImageStyle;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelTop extends HLayout{

	private LinkedHashMap< String , eFeriado > mapFeriados = new LinkedHashMap<String, eFeriado>();
	
	private eTouchLocalEspaco entityLocalEspaco;
	
	public eTouchLocalEspaco getEntityLocalEspaco() {
		if( entityLocalEspaco == null ){
			entityLocalEspaco = new eTouchLocalEspaco();
			entityLocalEspaco.setCodLocal("-1");
			entityLocalEspaco.setDescAbrevLocal("");
		}
		return entityLocalEspaco;
	}


	public void setEntityLocalEspaco(eTouchLocalEspaco entityLocalEspaco) {
		this.entityLocalEspaco = entityLocalEspaco;
	}

	private Img imgLogo 	= new Img("agenda/logo-villa-bisutti_new.png");
	
	
	private VLayout tituloLayout = new VLayout();
	private Label titulo 		 = new Label();
	private Label local 		 = new Label();
	
	private PainelFeriados painelFeriado = new PainelFeriados();
	
	public PainelFeriados getPainelFeriado() {
		return painelFeriado;
	}


	public PainelTop(){
		
		this.imgLogo.setWidth(260);
		this.imgLogo.setHeight100();
		this.imgLogo.setImageType(ImageStyle.CENTER);

		this.addMember(imgLogo);			

		
		
		
		tituloLayout.setWidth100();
		tituloLayout.setHeight100();


		
		
		HLayout nav = new HLayout();
		nav.setWidth100();
		nav.setHeight100();
		
		
		ImgButton actionAnterior = new ImgButton();
		actionAnterior.setSrc("agenda/ico_anterior.png");
		actionAnterior.setWidth(32);
		actionAnterior.setImageHeight(32);
		actionAnterior.setImageWidth(32);
		actionAnterior.setHeight100();
		actionAnterior.setImageType(ImageStyle.CENTER);
		nav.addMember(actionAnterior);
		actionAnterior.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {				
				Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {					
					@Override
					public void execute() {
						anoAnterior();
					}
				});				

			}
		});
		
		
		this.titulo.setWidth100();
		this.titulo.setHeight100();
		this.titulo.setPadding(2);
		this.titulo.setAlign(Alignment.CENTER);
		
		
		nav.addMember(this.titulo);
		
		ImgButton actionProximo = new ImgButton();
		actionProximo.setSrc("agenda/ico_proximo.png");
		actionProximo.setWidth(32);
		actionProximo.setImageHeight(32);
		actionProximo.setImageWidth(32);
		actionProximo.setHeight100();
		actionProximo.setImageType(ImageStyle.CENTER);
		nav.addMember(actionProximo);
		actionProximo.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {					
					@Override
					public void execute() {
						proximoAno();
					}
				});				
			}
		});
		
		
		
		
		
		tituloLayout.addMember( nav );

		this.local.setWidth100();
		this.local.setHeight100();
		this.local.setPadding(2);
		this.local.setAlign(Alignment.CENTER);
		tituloLayout.addMember( this.local );
		
		
		
		
		this.addMember(tituloLayout);
		
 
		
		
		HLayout feriadoLayout = new HLayout();
		feriadoLayout.setHeight100();
		feriadoLayout.setWidth(300);
		feriadoLayout.setPadding(5);
 	
		painelFeriado.setWidth100();
		painelFeriado.setHeight100();
			
		feriadoLayout.addMember(painelFeriado);
		
		this.addMember(feriadoLayout);
	}

	
	public void refreshTitle(Date date){
		titulo.setContents("<Font size=+3><i>Calend&aacute;rio de Planejamento <Strong>"+(1900+date.getYear())+"</Strong></i></Font>");
	}
	
	public void showFeriados(eFeriado[] feriados){
		this.painelFeriado.showFeriados(feriados);
		if( feriados != null ){
			getMapFeriados().clear();
			for ( eFeriado feriado : feriados){
				getMapFeriados().put(feriado.getDtFeriado(), feriado);
			}
		}
	}
	
	public void refreshLocal(eTouchLocalEspaco entityLocalEspaco){
		this.entityLocalEspaco = entityLocalEspaco;

		if( entityLocalEspaco == null )
			this.local.setContents("<Font size=+2><i></Strong></i></Font>");
		else{
			// String img = imgHTML("agenda/ico_agenda_local.png", 32, 32, "image", "style=''", null);
			
			this.local.setContents("<Font size=+2 color=#00008B ><i><Strong>"+entityLocalEspaco.getDescAbrevLocal().toUpperCase()+"</Strong></i></Font>");
		}

	}
	
	public void anoAnterior(){}
	
	public void proximoAno(){}


	public LinkedHashMap<String, eFeriado> getMapFeriados() {
		return mapFeriados;
	}


	public void setMapFeriados(LinkedHashMap<String, eFeriado> mapFeriados) {
		this.mapFeriados = mapFeriados;
	}
}
