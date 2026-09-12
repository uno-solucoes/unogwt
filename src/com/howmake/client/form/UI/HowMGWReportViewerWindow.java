package com.howmake.client.form.UI;

import java.util.Collection;

import com.br.client.configuracao.Configuracao;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.howmake.client.form.partner.HowMGWTConstants;
import com.howmake.client.form.partner.HowMGWTNavigator;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DragRepositionMoveEvent;
import com.smartgwt.client.widgets.events.DragRepositionMoveHandler;
import com.smartgwt.client.widgets.events.ResizedEvent;
import com.smartgwt.client.widgets.events.ResizedHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class HowMGWReportViewerWindow extends HowMGWTWindow {

	private HowMGWTEntity currentEntity;
	
	private ToolStrip toolbar = new ToolStrip();
	private IButton actionSendMail;
	
	private Timer timer;
	private VLayout layout = new VLayout();
	
	HowMGWTIFrame iframe = new HowMGWTIFrame();
	
	public HowMGWReportViewerWindow(){		

		this.setShowModalMask(true);
		this.setModalMaskOpacity(HowMGWTConstants.WINDOW_MODAL_MASK_OPACITY);
		this.setIsModal(true);
		
		
		this.layout.setWidth100();
		this.layout.setHeight100();
		this.layout.setOverflow(Overflow.HIDDEN);

		this.addItem(layout);
		
		this.toolbar.setWidth100();
		this.toolbar.setHeight("24px");
		
		this.layout.addMember(toolbar);
		this.layout.addMember(iframe);
		this.setCanDragReposition(true);
		this.setCanDragResize(true);
		this.setShowFooter(true);
			
		this.addDragRepositionMoveHandler(new DragRepositionMoveHandler() {
			@Override
			public void onDragRepositionMove(DragRepositionMoveEvent event) {
				Timer timer = new Timer() {
					
					@Override
					public void run() {
						repaint();
					}
				};
				timer.schedule(200);
			}
		});
		
		this.addResizedHandler(new ResizedHandler() {			
			@Override
			public void onResized(ResizedEvent event) {
				if ( timer != null ){
					timer.cancel();
					timer = null;
				}
				timer = new Timer() {
					@Override
					public void run() {
						repaint();
					}
				};
				timer.schedule(100);
			}
		});
		
		this.repaint();
	}
	
	/**
	 * Corrige problema de repaint do Smart-GWT quando utiliza iFrame em Window.
	 */
	public void repaint(){
		iframe.setWidth((layout.getInnerContentWidth())+"px");
		iframe.setHeight((layout.getInnerContentHeight()-24)+"px");
	}
	
	
	/**
	 * Apresenta o relatório pdf na tela.
	 * @param url
	 * @param module
	 * @param title
	 * @param result
	 */
	public void showReport(String url, String module, String title,HowMGWTEntity result){

		this.currentEntity = result;
		
		this.setModuleName(module);
		this.setModuleTitle(title);
		
		this.setTitle(this.getHowMGWTPrograma()+" - " + this.getHowMGWTTitle());
		
		this.iframe.setUrl(url);
		this.centerInPage();
		this.setTitle(module+"-"+title);

		if ( result != null ){
			HowMProperty emailSMTP = result.getParameters().get("emailSMTP");
			if ( emailSMTP != null ){
				this.actionSendMail = new IButton("Enviar Email");
				this.actionSendMail.setIcon("actions/send_email.png");
				this.toolbar.addChild(this.actionSendMail);

				this.actionSendMail.addClickHandler(new ClickHandler() {					
					@Override
					public void onClick(ClickEvent event) {
						iframe.setVisible(false);
						sendMail();
					}
				});
			}
		}

		this.show();
		repaint();

		if ( result != null ){
			Collection<HowMProperty> objs = result.getParameters().values();
			
			for ( HowMProperty p : objs){
				System.out.println("Param : "+p.getName()+"="+p.getValue());
			}
		}
	}
	
	@Override
	public String getHowMGWTPrograma() {		
		if ( HowMGWTUtilities.isEmpty(this.getModuleName())) 
			return "";
		else
			return this.getModuleName();
	}

	@Override
	public String getHowMGWTTitle() {
		if ( HowMGWTUtilities.isEmpty(this.getModuleTitle())) 
			return "";
		else
			return this.getModuleTitle();
	}
	
	
	protected void onHowMGWTClose(){
		// Safari não remove o iframe quando fecha a janela.
		if ( HowMGWTNavigator.isSafari() ){
			iframe.removeFromParent();
			iframe.setVisible(false);
			iframe.getElement().setInnerHTML("<htmL><body></body></html>");
		
			iframe.setWidth("0px");
			iframe.setHeight("0px");
			
			iframe.getElement().getStyle().setLeft(-10, Unit.PX);
			iframe.getElement().getStyle().setTop(-10, Unit.PX);
		}
	}
	
	/**
	 * Envia e-mail com o documento em anexo para os destinatórios configurados para 
	 * recebimento do documento na chamada do visualizador de relatórios.
	 */
	protected void sendMail(){
		HowMGWTWindowWait.showWait();
		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
				public void onFailure(Throwable caught) {
					HowMGWTWindowWait.hideWait();		
					caught.printStackTrace();
					com.google.gwt.user.client.Window.alert(Tradutor.i18n.formEnderecoBase()+GWT.getHostPageBaseURL()+"\n"+caught.getMessage());
				}
				public void onSuccess(HowMGWTEntity result) {					
				
					HowMGWTWindowWait.hideWait();
		
					HowMProperty returnOK    = result.getParameters().get("ReturnOK");
					HowMProperty returnERROR = result.getParameters().get("ReturnERROR");
					
					String msg = "";
					if ( returnOK != null )
						msg = returnOK.getValue();
					
					if ( returnERROR != null )
						msg = returnERROR.getValue();
					
					SC.say(msg,new BooleanCallback() {	
						@Override
						public void execute(Boolean value) {
							// TODO Auto-generated method stub							
							iframe.setVisible(true);
							repaint();
						}
					});		
				}
		};
		Configuracao.getProxyStruts().executeQuery(currentEntity, callback);						
	}
}