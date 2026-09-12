package com.br.client.panel.at.atw0117a;

import java.util.Date;

import com.br.client.configuracao.Configuracao;
import com.br.client.model.at.atw0117.FormBean;
import com.br.client.model.at.entity.eTouchAgenda;
import com.br.client.model.at.entity.eTouchLocalEspaco;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.at.atw0117a.calendar.HowMGWTCalendar;
import com.br.client.panel.at.atw0117a.calendar.HowMGWTCalendarioMesDetalhado;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.model.HowMGWTTask;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelCalendarioMensal extends VLayout{

	private boolean permiteAlterarCalendario	= false;
	private boolean permiteAprovarCalendario	= false;
	private boolean permiteExcluirCalendario	= false;;
	private boolean permiteIncluirCalendario	= false;
	
	
	private eTouchAgenda currentTouchAgenda;
	
	private DateTimeFormat formatDateTimeDB= DateTimeFormat.getFormat("EEEE, dd ");
	
	private Date currentSelectData;
	
	private boolean changeEvent = false;
	
	private PainelCalendarioAno parentPainelCalendarioAno;
	private PainelManutencaoAgenda painelManutencaoAgenda = new PainelManutencaoAgenda(this){
		public void onChangeValueEditor(){
			actionGravarEvento.setVisible(true);
			actionVoltarAlteracao.setVisible(true);
		}
	};
	
	
	public PainelCalendarioAno getParentPainelCalendarioAno() {
		return parentPainelCalendarioAno;
	}

	public void setParentPainelCalendarioAno(PainelCalendarioAno parentPainelCalendarioAno) {this.parentPainelCalendarioAno = parentPainelCalendarioAno;
		calendarioMensalDetalhado.setParentPainelTop(this.parentPainelCalendarioAno.getParentPainelTop());		
	}

	private HowMGWTCalendar calendario;
	private HowMGWTCalendarioMesDetalhado calendarioMensalDetalhado = new HowMGWTCalendarioMesDetalhado(){
		public void onChangeData(Date data){
			onShowChangeData(data);
		}		
	};	

	public HowMGWTCalendarioMesDetalhado getCalendarioMensalDetalhado() {
		return calendarioMensalDetalhado;
	}

	private VLayout formLayout = new VLayout();
	
	private HLayout headerLabel 		  = new HLayout();
	private Label labelMes				  = new Label();
	private ImgButton actionShowMes		  = new ImgButton();

	private HLayout headerLabelAgendamento= new HLayout();
	private Label labelMesAgendamento	  = new Label("<Font size=+2><Strong>AGENDAMENTOS</strong></Font>");
	
	
	private PainelCalendarioAgendaDia painelCalendarioDetalheDia = new PainelCalendarioAgendaDia(){
		@Override
		public void onSelectRecord(eTouchAgenda touchAgenda){
			if( touchAgenda == null ){
				touchAgenda = createTouchAgenda();
			}			
			onAtualizaFormulario(touchAgenda, parentPainelCalendarioAno.getParentPainelTop().getEntityLocalEspaco() );			
		}		
	};
	
	private HLayout mainLayout = new HLayout();
	
	
	private IButton actionNovoEvento 		= new IButton("novo<br>Evento"){
		public void setVisible(boolean visible) {
			if( ! isPermiteIncluirCalendario() )
				super.setVisible(false);
			else
				super.setVisible(visible);
		};
	};
	private IButton actionAlterarEvento 	= new IButton("Alterar<br>Evento"){
		public void setVisible(boolean visible) {
			if( ! isPermiteAlterarCalendario() )
				super.setVisible(false);
			else
				super.setVisible(visible);
		};		
	};
	private IButton actionDeletarEvento 	= new IButton("Excluir<br>Evento"){
		public void setVisible(boolean visible) {
			if( ! isPermiteExcluirCalendario() )
				super.setVisible(false);
			else
				super.setVisible(visible);
		};				
	};
	private IButton actionGravarEvento  	= new IButton("Gravar<br>Evento");
	private IButton actionVoltarAlteracao	= new IButton("Voltar<br>Alteracao");
	
	public PainelCalendarioMensal(){

		this.setPadding(2);
		this.setBackgroundColor("#FFFFFF");
		
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		VLayout formCalendarioMes = new VLayout();
		formCalendarioMes.setWidth100();
		formCalendarioMes.setHeight100();
		formCalendarioMes.setBackgroundColor("#FFFFFF");
		
		formCalendarioMes.setMargin(6);
		formCalendarioMes.setStyleName("DirectSaleShadow");	

		// this.actionShowMes.setImageType(ImageStyle.CENTER);
		this.actionShowMes.setImageWidth(32);
		this.actionShowMes.setImageHeight(32);
		this.actionShowMes.setWidth(36);
		this.actionShowMes.setHeight100();
		this.actionShowMes.setSrc("agenda/ico_voltar_agenda.png");
		
		headerLabel.addMember(this.actionShowMes);
		
		
		labelMes.setWidth100();
		labelMes.setHeight(36);
		labelMes.setAlign(Alignment.CENTER);
		
		
		headerLabel.setWidth100();
		headerLabel.setHeight(32);
		headerLabel.setBackgroundColor("#E0EEEE");

		headerLabel.addMember(labelMes);		
		
		formCalendarioMes.addMember(headerLabel);		
		
		
		calendarioMensalDetalhado.setMargin(6);
		calendarioMensalDetalhado.setStyleName("DirectSaleShadow");	

		
		formCalendarioMes.addMember(calendarioMensalDetalhado);
		mainLayout.addMember(formCalendarioMes);
		
		
		
		mainLayout.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(10, ""));
		
		formLayout.setWidth100();
		formLayout.setHeight100();
		formLayout.setBackgroundColor("#FFFFFF");
		
		formLayout.setMargin(6);
		formLayout.setStyleName("DirectSaleShadow");	

		
		painelCalendarioDetalheDia.setWidth100();
		painelCalendarioDetalheDia.setHeight100();
		
		headerLabelAgendamento.setWidth100();
		headerLabelAgendamento.setHeight(36);
		headerLabelAgendamento.setBackgroundColor("#E0EEEE");

		labelMesAgendamento.setWidth100();
		labelMesAgendamento.setHeight100();
		labelMesAgendamento.setAlign(Alignment.CENTER);
		
		headerLabelAgendamento.addMember(labelMesAgendamento);

		
		formLayout.addMember(headerLabelAgendamento);

		
		formLayout.addMember(painelCalendarioDetalheDia);
		formLayout.addMember(painelManutencaoAgenda);
		
		
		
		HLayout tools = new HLayout();
		tools.setWidth100();
		tools.setHeight(44);
		tools.setAlign(Alignment.CENTER);
		
		actionNovoEvento.setWidth(110);
		actionNovoEvento.setHeight(36);
		actionNovoEvento.setIconSize(32);
		actionNovoEvento.setIcon("agenda/ico_insert_agenda.png");
				
		actionNovoEvento.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onNovoEvento();				
			}
		});
		
		actionAlterarEvento.setWidth(110);
		actionAlterarEvento.setHeight(36);
		actionAlterarEvento.setIconSize(32);
		actionAlterarEvento.setIcon("agenda/ico_edit_agenda.png");
		
		actionAlterarEvento.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onAlterarEvento();
			}
		});
	
		actionVoltarAlteracao.setWidth(110);
		actionVoltarAlteracao.setHeight(36);
		actionVoltarAlteracao.setIconSize(32);
		actionVoltarAlteracao.setIcon("agenda/ico_voltar_agenda.png");


		
		actionVoltarAlteracao.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onVoltarAlteracao();
			}
		});		
		
		actionDeletarEvento.setWidth(110);
		actionDeletarEvento.setHeight(36);
		actionDeletarEvento.setIconSize(32);
		actionDeletarEvento.setIcon("agenda/ico_delete_agenda.png");
		actionDeletarEvento.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				SC.confirm(Tradutor.i18n.msgConfirmaExclusaoEventoSelecionado(), new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if( value ){
							onExcluirEvento();
						}
					}
				});
			}
		});
		
		
		actionGravarEvento.setWidth(110);
		actionGravarEvento.setHeight(36);
		actionGravarEvento.setIconSize(32);
		actionGravarEvento.setIcon("agenda/ico_gravar_agenda.png");
		actionGravarEvento.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onGravarEvento();
			}
		});
		
		
		tools.addMember(actionNovoEvento);
		tools.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(10, ""));
		tools.addMember(actionAlterarEvento);
		tools.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(10, ""));		
		tools.addMember(actionVoltarAlteracao);
		tools.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(10, ""));		
		tools.addMember(actionDeletarEvento);		
		tools.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(10, ""));
		tools.addMember(actionGravarEvento);
		
		
		formLayout.addMember(tools);
		
		mainLayout.addMember(formLayout);
		
		this.setWidth100();
		this.setHeight100();

		this.addMember(this.mainLayout);
		
		this.actionShowMes.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				getParentPainelCalendarioAno().onShowCalendar(changeEvent);
			}
		});
		
		
		painelCalendarioDetalheDia.addRecordClickHandler(new RecordClickHandler() {
			
			@Override
			public void onRecordClick(RecordClickEvent event) {
				eTouchAgenda agenda 	= painelCalendarioDetalheDia.getTouchAgenda(event.getRecord());
				eTouchLocalEspaco local = parentPainelCalendarioAno.getParentPainelTop().getEntityLocalEspaco();
				onAtualizaFormulario(agenda, local);
			}
		});
		
	}
	
	public void showMes( HowMGWTCalendar calendar ){
		
		if( this.calendario != null )
			this.calendario.setCalendarioMensal(null);
				
		this.calendario = calendar;
		
		this.calendario.setCalendarioMensal(this);		
		String dia = "";
		if( currentSelectData != null ){
			
			dia = formatDateTimeDB.format(currentSelectData)+ "de ";
			   
		}
		String mes = HowMGWTUtilities.getMesAbrev(""+(calendar.getCurrentDate().getMonth()));
		this.labelMes.setContents("<Font size=+2><Strong>"+dia+mes+"</Strong></Font>");		
		this.calendarioMensalDetalhado.setData(calendar.getCalendar().getData());
	}

	public void showTasks( HowMGWTTask[] tasks){
		this.calendarioMensalDetalhado.showTasks(tasks);
	}	

	// ------------------------------------------------------------------------	

	public void onRefreshChangeLocal(){
		System.out.println("Alterado Local : "+HowMGWTUtilities.getFormatDate(this.currentSelectData));
		onShowChangeData(this.currentSelectData);
	}

	public void onShowChangeData(Date data){

		currentSelectData = data;
		
		// Se igual a null, foi selecionado pela lupa. 
		if ( data == null ){
			return;
		}		

		System.out.println("Data selecionada : "+HowMGWTUtilities.getFormatDate(data));
		
		this.painelCalendarioDetalheDia.load(data, this.parentPainelCalendarioAno.getParentPainelTop().getEntityLocalEspaco().getCodLocal());
	}

	// ------------------------------------------------------------------------	

	
	
	public eTouchAgenda createTouchAgenda(){
		eTouchAgenda touchAgenda = new eTouchAgenda();
		
		touchAgenda.setSituacao("2");
		if( this.currentSelectData != null ){

			touchAgenda.setDtAgendaIni(HowMGWTUtilities.getFormatDate(this.currentSelectData));
			touchAgenda.setDtAgendaFim(HowMGWTUtilities.getFormatDate(this.currentSelectData));

		}
		return touchAgenda;
	}

	/**
	 * Atualiza o formulório com o dados da agenda navegada.
	 * @param touchAgenda
	 * @param touchLocalEspaco
	 */
	public void onAtualizaFormulario( eTouchAgenda touchAgenda, eTouchLocalEspaco touchLocalEspaco){

		currentTouchAgenda = touchAgenda;

		painelManutencaoAgenda.onAtualizaFormulario(touchAgenda, touchLocalEspaco);		

		if( HowMGWTUtilities.isEmpty( touchAgenda.getCodAgenda() ) ){
			this.actionDeletarEvento.setVisible(false);
			this.actionAlterarEvento.setVisible(false);
			this.actionGravarEvento.setVisible(false);
			this.actionVoltarAlteracao.setVisible(false);
			
			if( ! isPermiteIncluirCalendario() ){
				painelManutencaoAgenda.setEditedFields(false);
			}
			
			if( ! isPermiteAprovarCalendario() ){
				this.painelManutencaoAgenda.getPropertySituacao().getCanvas().setDisabled(true);
			}
		}
		else{
			this.actionDeletarEvento.setVisible(true);
			this.actionAlterarEvento.setVisible(true);
			this.actionGravarEvento.setVisible(false);
			this.actionVoltarAlteracao.setVisible(false);
			if( ! isPermiteAprovarCalendario() ){
				this.painelManutencaoAgenda.getPropertySituacao().getCanvas().setDisabled(true);
			}			
		}
	}

	public void onNovoEvento(){		
		onAtualizaFormulario(this.createTouchAgenda(), this.getParentPainelCalendarioAno().getParentPainelTop().getEntityLocalEspaco() );
	}

	public void onAlterarEvento(){

		this.actionDeletarEvento.setVisible(false);
		this.actionAlterarEvento.setVisible(false);
		this.actionGravarEvento.setVisible(false);
		this.actionVoltarAlteracao.setVisible(true);
		
		painelManutencaoAgenda.setEditedFields(true);
		if( ! isPermiteAprovarCalendario() ){
			this.painelManutencaoAgenda.getPropertySituacao().getCanvas().setDisabled(true);
		}			
	}

	public void onExcluirEvento(){

		FormBean formBean = new FormBean();
		HowMGWTPlugInStruts strusts = new HowMGWTPlugInStruts(formBean) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, false)){ 
					return;
				}
				
				getParentPainelCalendarioAno().refreshAno();
			}
		};
		
		eTouchLocalEspaco touchLocalEspaco = this.getParentPainelCalendarioAno().getParentPainelTop().getEntityLocalEspaco();
		
		formBean.setEntityTouchAgenda(this.currentTouchAgenda);

		this.currentTouchAgenda.setCodLocal(touchLocalEspaco.getCodLocal());
		this.currentTouchAgenda.setCodEmpresa(Configuracao.getCodEmpresa());
		
		strusts.request("atw0117.do?method=excluir", "ATW0117Form", formBean.toSendBody(""));		

	}

	public boolean isValidProperty(HowMGWTProperty property){
		if( ! HowMGWTUtilities.isEmpty( property.getMessageMandatory() ) ){
			SC.say( property.getMessageMandatory() );
			return false;
		}
		return true;
	}
	
	public void onGravarEvento(){

		if( HowMGWTUtilities.isEmpty( this.painelManutencaoAgenda.getFieldLookupBuscaColaborador().getHowMValue() ) ){			
			SC.say(HowMGWTUtilities.replace( Tradutor.i18n.msgCampoEObrigatorioParam() , "$[campo]" , "<strong>Codigo Colaborador</strong>"));			
			return;		
		}
		
		if( HowMGWTUtilities.isEmpty( this.painelManutencaoAgenda.getFieldLookupBuscaCliente().getHowMValue() ) ){
			SC.say(HowMGWTUtilities.replace( Tradutor.i18n.msgCampoEObrigatorioParam() , "$[campo]" , "<strong>Codigo Cliente</strong>"));
			return;
		}
		
		if( ! isValidProperty(this.painelManutencaoAgenda.getPropertyDtInicio()))
			return ;

		if( ! isValidProperty(this.painelManutencaoAgenda.getPropertyDtFim()))
			return ;
		
		if( ! isValidProperty(this.painelManutencaoAgenda.getPropertyHoraInicio()))
			return ;

		if( ! isValidProperty(this.painelManutencaoAgenda.getPropertyHoraFim()))
			return ;

		if( ! isValidProperty(this.painelManutencaoAgenda.getPropertyAssunto()))
			return ;
		
		if( ! isValidProperty(this.painelManutencaoAgenda.getPropertySituacao()))
			return ;

		
		Date dataInicio 	= HowMGWTUtilities.getDate( HowMGWTUtilities.getString( this.painelManutencaoAgenda.getPropertyDtInicio().getHowMGWTEditorDateItem().getHowMValue() ) );
		Date dataFim 		= HowMGWTUtilities.getDate( HowMGWTUtilities.getString( this.painelManutencaoAgenda.getPropertyDtFim().getHowMGWTEditorDateItem().getHowMValue() ) );

		String horaInicio	= HowMGWTUtilities.getString( this.painelManutencaoAgenda.getPropertyHoraInicio().getHowMGWTEditorFieldText().getHowMValue() );
		String horaFim		= HowMGWTUtilities.getString( this.painelManutencaoAgenda.getPropertyHoraFim().getHowMGWTEditorFieldText().getHowMValue() );

		
		String sDatatInicio = HowMGWTUtilities.getFormatDate(dataInicio) +" "+HowMGWTUtilities.getFormatTime( HowMGWTUtilities.getInteger( HowMGWTUtilities.replace( horaInicio , ":" , "" ) ) );
		String sDataFim		= HowMGWTUtilities.getFormatDate(dataFim)    +" "+HowMGWTUtilities.getFormatTime( HowMGWTUtilities.getInteger( HowMGWTUtilities.replace( horaFim    , ":" , "" ) ) );
		
		
		Date dtInicio 	= HowMGWTUtilities.getDate( sDatatInicio );
		Date dtFim 		= HowMGWTUtilities.getDate( sDataFim );

		if( HowMGWTUtilities.isMaior(dtInicio, dtFim)){
			SC.say(Tradutor.i18n.formDataInicio()+" <Strong>"+sDatatInicio+"</strong> deve ser menor ou <br>igual a "+Tradutor.i18n.formDataFim()+" <strong>"+sDataFim+"</strong>!!!");
			return ;
		}		

		FormBean formBean = new FormBean();
		HowMGWTPlugInStruts strusts = new HowMGWTPlugInStruts(formBean) {

			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true)){ 
					return;
				}

				FormBean bean = (FormBean)formBean;

				getParentPainelCalendarioAno().refreshAno();
			}
		};

		eTouchLocalEspaco touchLocalEspaco = this.getParentPainelCalendarioAno().getParentPainelTop().getEntityLocalEspaco();
		
		eTouchAgenda touchAgenda = new eTouchAgenda();
		painelManutencaoAgenda.refreshTouchAgenda(this.currentTouchAgenda, touchAgenda , touchLocalEspaco);

		formBean.setEntityTouchAgenda(touchAgenda);
		
		strusts.request("atw0117.do?method=salvar", "ATW0117Form", formBean.toSendBody(""));		

	}
	
	public void onVoltarAlteracao(){
		onAtualizaFormulario(this.currentTouchAgenda, this.getParentPainelCalendarioAno().getParentPainelTop().getEntityLocalEspaco() );
	}

	public boolean isPermiteAlterarCalendario() {
		return permiteAlterarCalendario;
	}

	public void setPermiteAlterarCalendario(boolean permiteAlterarCalendario) {
		this.permiteAlterarCalendario = permiteAlterarCalendario;
	}

	public boolean isPermiteAprovarCalendario() {
		return permiteAprovarCalendario;
	}

	public void setPermiteAprovarCalendario(boolean permiteAprovarCalendario) {
		this.permiteAprovarCalendario = permiteAprovarCalendario;
	}

	public boolean isPermiteExcluirCalendario() {
		return permiteExcluirCalendario;
	}

	public void setPermiteExcluirCalendario(boolean permiteExcluirCalendario) {
		this.permiteExcluirCalendario = permiteExcluirCalendario;		
	}

	public boolean isPermiteIncluirCalendario() {
		return permiteIncluirCalendario;		
	}

	public void setPermiteIncluirCalendario(boolean permiteIncluirCalendario) {

		this.permiteIncluirCalendario = permiteIncluirCalendario;
		actionNovoEvento.setVisible(this.permiteIncluirCalendario);

	}

}