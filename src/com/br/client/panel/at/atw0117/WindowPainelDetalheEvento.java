package com.br.client.panel.at.atw0117;

import com.br.client.model.at.entity.eTouchAgenda;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.StyleInjector;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.partner.HowMGWTConstants;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

public class WindowPainelDetalheEvento extends Window{

	private DetailViewer detailViewer;
	private DetailViewer detailAssunto;
	
	private DetailViewerField fieldColaborador	= new DetailViewerField("fieldColaborador"	, "Colaborador");  
	private DetailViewerField fieldCliente 		= new DetailViewerField("fieldCliente"		, "Cliente");  
	private DetailViewerField fieldTipoLocal	= new DetailViewerField("fieldTipoLocal"	, "Tipo de Local");  
	private DetailViewerField fieldEspaco 		= new DetailViewerField("fieldEspaco"		, "Espaco");  
	private DetailViewerField fieldDtInicio 	= new DetailViewerField("fieldDtInicio"		, "Data Inicio");  
	private DetailViewerField fieldDtFim 		= new DetailViewerField("fieldDtFim"		, "Data Fim");  
	private DetailViewerField fieldAssunto 		= new DetailViewerField("fieldAssunto"		, "Assunto");
	private DetailViewerField fieldObservacao	= new DetailViewerField("fieldObservacao"	, "Observacao");	

	private Label header = new Label();

    private VLayout mainLayout = new VLayout();

	private ImgButton actionBack = new ImgButton();
    
	public WindowPainelDetalheEvento(){
		
		
		
		

				
		
	
		detailViewer = new DetailViewer();
		detailViewer.setID(SC.generateID());
		detailViewer.setCellStyle("detailAgenda");
		detailViewer.setLabelStyle("detailAgendaLabel");
		
		detailAssunto = new DetailViewer();
		detailAssunto.setID(SC.generateID());
		detailAssunto.setCellStyle("detailAgenda");
		detailAssunto.setLabelStyle("detailAgendaLabel");

		this.setCanDragReposition(false);
        this.setCanDrag(false);

        this.setBackgroundColor("#FFFFFF");
        
        this.setModalMaskOpacity(70);
        this.setShowModalMask(true);
       
		this.setWidth(900);
		this.setHeight(400);
		
		this.setShowHeader(false);
		this.setShowShadow(true);
		this.setShowEdges(false);
		
 
		VLayout headerLayout = new VLayout();
		headerLayout.setWidth100();
		headerLayout.setHeight(48);
		headerLayout.setAlign(Alignment.CENTER);
		headerLayout.setStyleName("agendaVillaTitle");

		header.setWidth100();
		header.setAlign(Alignment.CENTER);
		header.setStyleName("agendaVillaFontTitle");
		header.setHeight(24);
		headerLayout.addMember(header);
		
		mainLayout.addMember(headerLayout);
		
		
		
		
		mainLayout.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(1,  HowMGWTUtilities.backgroundSeparadora));

		
		HLayout dataLayout = new HLayout();
		dataLayout.setWidth100();
		dataLayout.setHeight100();
		
		dataLayout.setMargin(10);

		
		detailViewer.setWidth(400);
		detailViewer.setHeight100();
		detailViewer.setFields(
	    		fieldColaborador,
	    		fieldCliente,
	    		fieldTipoLocal,
	    		fieldEspaco,
	    		fieldDtInicio,
	    		fieldDtFim);			
		
		detailViewer.setData(new ListGridRecord[0]);
			
		
		dataLayout.addMember(detailViewer);
	
		
		dataLayout.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(5, "" ));
		
		
		detailAssunto.setFields(
	    		fieldAssunto,
	    		fieldObservacao);			
		detailAssunto.setWidth100();
		detailAssunto.setHeight100();
		detailAssunto.setData(new ListGridRecord[0]);
		dataLayout.addMember(detailAssunto);
		
		mainLayout.addMember(dataLayout);
		
		mainLayout.setWidth100();
		mainLayout.setHeight100();
 
		
		
		
		
		
		actionBack.setSrc("agenda/action_voltar_loop.png");
		actionBack.setWidth(48);
		actionBack.setHeight(48);
		this.actionBack.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				animateHide(AnimationEffect.FADE);
			}
		});
		
  
		this.mainLayout.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(1,  HowMGWTUtilities.backgroundSeparadora));
		
		HLayout tools = new HLayout();
		tools.setWidth100();
		tools.setHeight(48);
		tools.setAlign(Alignment.RIGHT);
		
		tools.setStyleName("agendaVillaTitle");
		
		tools.addMember(actionBack);
		tools.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(10,""));
		
		mainLayout.addMember(tools);
		
        this.addItem(mainLayout); 
	
        this.setIsModal(true);
        this.centerInPage();
        
        
        
        
        
	}
	
	
	public void showTouchAgenda(eTouchAgenda touchAgenda){
		
		ListGridRecord record = new ListGridRecord();
		record.setAttribute(fieldColaborador.getName()	, touchAgenda.getColaborador());
		record.setAttribute(fieldCliente.getName()		, "<strong>"+touchAgenda.getNomeCliente()+"</strong>");
		record.setAttribute(fieldTipoLocal.getName()	, touchAgenda.getTipoLocal());
		record.setAttribute(fieldEspaco.getName()		, touchAgenda.getLocal());
		record.setAttribute(fieldDtInicio.getName()		, HowMGWTUtilities.getFormatDateTime(HowMGWTUtilities.getDate(touchAgenda.getDtAgendaIni())));
		record.setAttribute(fieldDtFim.getName()		, HowMGWTUtilities.getFormatDateTime(HowMGWTUtilities.getDate(touchAgenda.getDtAgendaFim())));
		
		record.setAttribute(fieldAssunto.getName()		, "<strong>"+touchAgenda.getAssunto()+"</strong>");
		record.setAttribute(fieldObservacao.getName()	, touchAgenda.getDescricao());
		
		ListGridRecord[] records = new ListGridRecord[]{
			record
		};
		
		this.detailViewer.setData(records);
		this.detailAssunto.setData(records);
		
		header.setContents("<font size=5>DETALHE DO AGENDAMENTO : "+touchAgenda.getCodAgenda()+"</font>");
		
		this.animateShow(AnimationEffect.FADE);
		
	}
}