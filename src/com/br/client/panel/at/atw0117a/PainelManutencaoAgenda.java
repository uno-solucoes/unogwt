package com.br.client.panel.at.atw0117a;

import java.util.Date;
import java.util.LinkedHashMap;

import com.br.client.configuracao.Configuracao;
import com.br.client.model.at.entity.eTouchAgenda;
import com.br.client.model.at.entity.eTouchLocalEspaco;
import com.br.client.model.cd.entity.eFeriado;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.UI.UCFieldLookupBuscaCliente;
import com.br.client.panel.business.UI.UCFieldLookupBuscaColaborador;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelManutencaoAgenda extends VLayout{ 

	private DateTimeFormat formatDateTimeDB= DateTimeFormat.getFormat("EEEE");
	
	private VLayout mainLayout = new VLayout();

	private HowMGWTFormProperties properties = new HowMGWTFormProperties();
	
	private HowMGWTProperty propertyCodAgendamento 	= properties.createProperty("codAgendamento", 	"Cod Agendamento");
	private HowMGWTProperty propertyTipoLocal 		= properties.createProperty("tipoLocal", 		"Tipo Local");
	private HowMGWTProperty propertyLocal 			= properties.createProperty("local", 			"local");
	private HowMGWTProperty propertyDtInicio 		= properties.createProperty("dtInicio", 		Tradutor.i18n.formDataInicio());
	private HowMGWTProperty propertyDtFim 			= properties.createProperty("dtFim", 			Tradutor.i18n.formDataFim());
	private HowMGWTProperty propertyHoraInicio 		= properties.createProperty("horaInicio", 		Tradutor.i18n.formHoraInicio());
	private HowMGWTProperty propertyHoraFim 		= properties.createProperty("horaFim", 			Tradutor.i18n.formHoraFim());
	private HowMGWTProperty propertyTempoTotal 		= properties.createProperty("tempoTotal", 		"Tempo Total");
	private HowMGWTProperty propertySituacao 		= properties.createProperty("situacao", 		Tradutor.i18n.formSituacao());
	private HowMGWTProperty propertyAssunto 		= properties.createProperty("assunto", 			"Assunto");
	private HowMGWTProperty propertyObservacao 		= properties.createProperty("Observacao", 		Tradutor.i18n.formObservacao());
 
	private Label lblFeriadoInicio 					= new Label(); 
	private Label lblFeriadoFim 					= new Label();
	
	private UCFieldLookupBuscaColaborador fieldLookupBuscaColaborador = new UCFieldLookupBuscaColaborador(){
		public void onHowMGWTSelect(boolean selected) {			
			onChangeValueEditor();
		};
	};
	private UCFieldLookupBuscaCliente     fieldLookupBuscaCliente     = new UCFieldLookupBuscaCliente(){
		public void onHowMGWTSelect(boolean selected) {
			onChangeValueEditor();
		};		
	};
	
	
	private PainelCalendarioMensal parentPainelCalendarioMensal;
	
	public PainelManutencaoAgenda(PainelCalendarioMensal painelCalendarioMensal){

		this.parentPainelCalendarioMensal = painelCalendarioMensal;

		int wLabel = 100;

		// this.setBorder("1px solid #EEEEEE");
		this.mainLayout.setPadding(20);
		
		propertyCodAgendamento.setBound(wLabel, 100);
		propertyCodAgendamento.createHowMGWTFormFieldTextItem();
		propertyCodAgendamento.getCanvas().setDisabled(true);		
		this.mainLayout.addMember(propertyCodAgendamento.getCanvas());
		
		
			
		fieldLookupBuscaColaborador.setWidth100();
		fieldLookupBuscaCliente.setWidth100();

		fieldLookupBuscaColaborador.setHowMBound(wLabel+200, 100);
		fieldLookupBuscaCliente.setHowMBound(wLabel, 100);
			
		
		this.mainLayout.addMember(fieldLookupBuscaColaborador);
		this.mainLayout.addMember(fieldLookupBuscaCliente);
		
		propertyTipoLocal.setBound(wLabel, 200);
		propertyTipoLocal.createHowMGWTFormFieldTextItem();		
		this.mainLayout.addMember(propertyTipoLocal.getCanvas());
		propertyTipoLocal.getCanvas().setDisabled(true);
		
		propertyLocal.setBound(wLabel, 200);
		propertyLocal.createHowMGWTFormFieldTextItem();	
		this.mainLayout.addMember(propertyLocal.getCanvas());
		propertyLocal.getCanvas().setDisabled(true);


		HLayout layoutHoraInicio = new HLayout();
		layoutHoraInicio.setWidth100();
		layoutHoraInicio.setHeight(22);

		propertyDtInicio.setBound(wLabel, 90);
		propertyDtInicio.setMandatory(true);
		propertyDtInicio.createHowMGWTFormDateItemInput();	
		layoutHoraInicio.addMember(propertyDtInicio.getCanvas());

		propertyHoraInicio.setBound(50, 60);
		propertyHoraInicio.setMandatory(true);
		propertyHoraInicio.createHowMGWTFormFieldTextItem();
		propertyHoraInicio.getHowMGWTEditorFieldText().getField().setMask("##:##");
		layoutHoraInicio.addMember(propertyHoraInicio.getCanvas());
		
		


		lblFeriadoInicio.setWidth100();
		lblFeriadoInicio.setHeight100();
		lblFeriadoInicio.setContents("");

		layoutHoraInicio.addMember(lblFeriadoInicio);


		this.mainLayout.addMember(layoutHoraInicio);

		HLayout layoutHoraFim = new HLayout();
		layoutHoraFim.setWidth100();
		layoutHoraFim.setHeight(22);
		
		propertyDtFim.setBound(wLabel, 90);
		propertyDtFim.setMandatory(true);
		propertyDtFim.createHowMGWTFormDateItemInput();	
		layoutHoraFim.addMember(propertyDtFim.getCanvas());
		
		propertyHoraFim.setBound(50, 60);
		propertyHoraFim.setMandatory(true);
		propertyHoraFim.createHowMGWTFormFieldTextItem();	
		propertyHoraFim.getHowMGWTEditorFieldText().getField().setMask("##:##");
		layoutHoraFim.addMember(propertyHoraFim.getCanvas());
		
		lblFeriadoFim.setWidth100();
		lblFeriadoFim.setHeight100();
		lblFeriadoFim.setContents("");
		
		layoutHoraFim.addMember(lblFeriadoFim);

		this.mainLayout.addMember(layoutHoraFim);

		HLayout layoutTempo = new HLayout();
		layoutTempo.setWidth100();
		layoutTempo.setHeight(22);
		
		propertyTempoTotal.setBound(wLabel, 70);
		propertyTempoTotal.createHowMGWTFormFieldTextItem();
		propertyTempoTotal.getHowMGWTEditorFieldText().getField().setMask("##:##");
		propertyTempoTotal.getCanvas().setDisabled(true);
		layoutTempo.addMember(propertyTempoTotal.getCanvas());
		
		propertySituacao.setBound(100, 180);
		propertySituacao.setMandatory(true);
		propertySituacao.createHowMGWTFormFieldSelectItem();	
		layoutTempo.addMember(propertySituacao.getCanvas());
		
		LinkedHashMap< String , String > mapSituacao = new LinkedHashMap();
 
		mapSituacao.put("1", Tradutor.i18n.formReservaConfirmada());
		mapSituacao.put("2", Tradutor.i18n.formReservaDeInteresse());
		mapSituacao.put("3", Tradutor.i18n.formReservaPreContrato());
		mapSituacao.put("4", Tradutor.i18n.formReservaContratoAssinado());
		
		propertySituacao.getHowMGWTEditorSelectItem().getField().setValueMap(mapSituacao);		
		propertySituacao.getHowMGWTEditorSelectItem().setHowMValue("2");		
		
		
		this.mainLayout.addMember( layoutTempo );

		
		propertyAssunto.setBound(wLabel, 200);
		propertyAssunto.setMandatory(true);
		propertyAssunto.createHowMGWTFormFieldTextItem();	
		this.mainLayout.addMember(propertyAssunto.getCanvas());
		

		propertyObservacao.setBound(wLabel,300);
		propertyObservacao.createHowMGWTFormFieldAreaItem();	
		propertyObservacao.getCanvas().setHeight100();		
		this.mainLayout.addMember(propertyObservacao.getCanvas());

		mainLayout.setWidth100();
		mainLayout.setHeight100();
						
		
		mainLayout.setMargin(6);
		mainLayout.setStyleName("DirectSaleShadow");	
		
		// mainLayout.setShowShadow(true);
		mainLayout.setBackgroundColor("#FFFFFF");

		
		this.setWidth100();
		this.setHeight(360);
		
		
		this.addMember(this.mainLayout);

		

		/**
		 * Adiciona o Listner para detectar alteração de dados.
		 */
		ChangedHandler changeHandler = new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				refreshTempoTotal();
				onChangeValueEditor();
				if( event.getSource() == propertyDtFim.getHowMGWTEditorDateItem().getField() ){
					refreshDataFeriado(propertyDtFim, lblFeriadoFim);
				}
				else if( event.getSource() == propertyDtInicio.getHowMGWTEditorDateItem().getField() ){
					refreshDataFeriado(propertyDtInicio, lblFeriadoInicio);
				}
			}
		};

		propertyDtInicio.getHowMGWTEditorDateItem().getField().addChangedHandler(changeHandler);		
		propertyDtFim.getHowMGWTEditorDateItem().getField().addChangedHandler(changeHandler);
		propertyHoraInicio.getHowMGWTEditorFieldText().getField().addChangedHandler(changeHandler);
		propertyHoraFim.getHowMGWTEditorFieldText().getField().addChangedHandler(changeHandler);
		propertySituacao.getHowMGWTEditorSelectItem().getField().addChangedHandler(changeHandler);
		propertyAssunto.getHowMGWTEditorFieldText().getField().addChangedHandler(changeHandler);
		propertyObservacao.getHowMGWTEditorTextAreaItem().getField().addChangedHandler(changeHandler);

	}
	
	

	public void onFecharEditor(){
		this.animateHide(AnimationEffect.FADE);
	}

	
	/**
	 * Habilita ou desabilita a edição dos campos conforme a operação do usuório na agenda.
	 * @param edited
	 */
	public void setEditedFields(boolean edited){

		propertyDtInicio.getCanvas().setDisabled( ! edited );
		propertyDtFim.getCanvas().setDisabled( ! edited );
		propertyHoraInicio.getCanvas().setDisabled( ! edited );
		propertyHoraFim.getCanvas().setDisabled( ! edited );
		propertySituacao.getCanvas().setDisabled( ! edited );
		propertyAssunto.getCanvas().setDisabled( ! edited );
		propertyObservacao.getCanvas().setDisabled( ! edited );
		fieldLookupBuscaColaborador.setDisabled( ! edited );
		fieldLookupBuscaCliente.setDisabled( ! edited );

	}
		

	/**
	 * Atualiza o tempo total da locação do espaço.
	 */
	
	public void refreshTempoTotal(){
		
		// Padroniza a hora para "0000" quatro casas  
		String hsInicio = HowMGWTUtilities.getLPad(HowMGWTUtilities.replace(HowMGWTUtilities.getString( this.propertyHoraInicio.getHowMGWTEditorFieldText().getHowMValue() ),":",""),"0",4);
		String hsFim    = HowMGWTUtilities.getLPad(HowMGWTUtilities.replace(HowMGWTUtilities.getString( this.propertyHoraFim.getHowMGWTEditorFieldText().getHowMValue() ),":",""),"0",4); 

		hsInicio 		= hsInicio.substring(0,2)+":"+hsInicio.substring(2)+":00";
		hsFim 			= hsFim.substring(0,2)+":"+hsFim.substring(2)+":00";

 		String startDate  = HowMGWTUtilities.getString( this.propertyDtInicio.getHowMGWTEditorDateItem().getHowMValue() )+" "+hsInicio;
		String finishDate = HowMGWTUtilities.getString( this.propertyDtFim.getHowMGWTEditorDateItem().getHowMValue() )+" "+hsFim;

		Date dataInicio = HowMGWTUtilities.getDate(startDate);
		Date dataFim    = HowMGWTUtilities.getDate(finishDate);

		String difHorasMinutos = HowMGWTUtilities.getDifHoraMinuto(dataInicio, dataFim);
		

		
		// this.propertyObservacao.setHowmFormValue("Diferenca horas minutos : "+difHorasMinutos);
		
		this.propertyTempoTotal.getHowMGWTEditorFieldText().setHowMValue(difHorasMinutos);
	}
	
	
	
	/**
	 * Atualiza os dados da agenda no formulório para permitir a edição dos dados.
	 * @param touchAgenda
	 * @param localEspaco
	 */
	public void onAtualizaFormulario(eTouchAgenda touchAgenda, eTouchLocalEspaco localEspaco){

		if( HowMGWTUtilities.isEmpty( touchAgenda.getCodAgenda() ) ){
			this.setEditedFields(true);
			touchAgenda.setColaborador("");
			touchAgenda.setNomeCliente("");
		}
		else{
			this.setEditedFields(false);
		}

		this.propertyCodAgendamento.getHowMGWTEditorFieldText().setHowMValue(touchAgenda.getCodAgenda());
		this.propertyTipoLocal.getHowMGWTEditorFieldText().setHowMValue(localEspaco.getDescaAbrevTipoLocal());
		this.propertyLocal.getHowMGWTEditorFieldText().setHowMValue(localEspaco.getDescAbrevLocal());
		this.propertyDtInicio.getHowMGWTEditorDateItem().setHowMValue(HowMGWTUtilities.getDate(touchAgenda.getDtAgendaIni()));
		this.propertyDtFim.getHowMGWTEditorDateItem().setHowMValue(HowMGWTUtilities.getDate(touchAgenda.getDtAgendaFim()));

		this.propertyHoraInicio.getHowMGWTEditorFieldText().setHowMValue(HowMGWTUtilities.getFormatTime( HowMGWTUtilities.getDate( touchAgenda.getDtAgendaIni() )));
		this.propertyHoraFim.getHowMGWTEditorFieldText().setHowMValue(HowMGWTUtilities.getFormatTime( HowMGWTUtilities.getDate( touchAgenda.getDtAgendaFim() )));

		this.propertySituacao.getHowMGWTEditorSelectItem().setHowMValue(touchAgenda.getSituacao());
		this.propertyAssunto.getHowMGWTEditorFieldText().setHowMValue(touchAgenda.getAssunto());
		this.propertyObservacao.getHowMGWTEditorTextAreaItem().setHowMValue(touchAgenda.getDescricao());
		
		this.fieldLookupBuscaColaborador.getField().setHowMValue(touchAgenda.getCodOrganizador());
		
 
		this.fieldLookupBuscaColaborador.getMessageLabel().setHowMValue(touchAgenda.getColaborador());		
		
		this.fieldLookupBuscaCliente.getField().setHowMValue(touchAgenda.getCodCliente());
		this.fieldLookupBuscaCliente.getMessageLabel().setHowMValue(touchAgenda.getNomeCliente());

		this.refreshTempoTotal();

		refreshDataFeriado(propertyDtInicio, lblFeriadoInicio);
		refreshDataFeriado(propertyDtFim, lblFeriadoFim);

	}
	
	public void onChangeValueEditor(){}
	
	
	
	
	
	/**
	 * Atualiza o objeto touchAgenda para gravação dos dados no banco.
	 * @param currentTouchAgenda
	 * @param touchAgenda
	 */
	public void refreshTouchAgenda(eTouchAgenda currentTouchAgenda, eTouchAgenda touchAgenda, eTouchLocalEspaco touchLocalEspaco){


		Date dataInicio 	= HowMGWTUtilities.getDate( HowMGWTUtilities.getString( this.getPropertyDtInicio().getHowMGWTEditorDateItem().getHowMValue() ) );
		Date dataFim 		= HowMGWTUtilities.getDate( HowMGWTUtilities.getString( this.getPropertyDtFim().getHowMGWTEditorDateItem().getHowMValue() ) );

		String horaInicio	= HowMGWTUtilities.getString( this.getPropertyHoraInicio().getHowMGWTEditorFieldText().getHowMValue() );
		String horaFim		= HowMGWTUtilities.getString( this.getPropertyHoraFim().getHowMGWTEditorFieldText().getHowMValue() );

		
		String sDatatInicio = HowMGWTUtilities.getFormatDate(dataInicio) +" "+HowMGWTUtilities.getFormatTime( HowMGWTUtilities.getInteger( HowMGWTUtilities.replace( horaInicio , ":" , "" ) ) );
		String sDataFim		= HowMGWTUtilities.getFormatDate(dataFim)    +" "+HowMGWTUtilities.getFormatTime( HowMGWTUtilities.getInteger( HowMGWTUtilities.replace( horaFim    , ":" , "" ) ) );

		touchAgenda.setCodAgenda(this.propertyCodAgendamento.getHowmFormValueToString());
		touchAgenda.setCodLocal(touchLocalEspaco.getCodLocal());
		touchAgenda.setCodEmpresa(Configuracao.getCodEmpresa());

		touchAgenda.setDtAgendaIni(sDatatInicio);
		touchAgenda.setDtAgendaFim(sDataFim);

		touchAgenda.setSituacao(HowMGWTUtilities.getString( this.propertySituacao.getHowMGWTEditorSelectItem().getHowMValue() ));

		touchAgenda.setAssunto( HowMGWTUtilities.getString( this.propertyAssunto.getHowMGWTEditorFieldText().getHowMValue() ) );		
		touchAgenda.setDescricao( HowMGWTUtilities.getString( this.propertyObservacao.getHowMGWTEditorTextAreaItem().getHowMValue() ) );

		touchAgenda.setCodOrganizador( HowMGWTUtilities.getString( this.fieldLookupBuscaColaborador.getField().getHowMValue() ) ); 
		touchAgenda.setCodCliente( HowMGWTUtilities.getString( this.fieldLookupBuscaCliente.getField().getHowMValue() ) );

		if( HowMGWTUtilities.isEmpty( currentTouchAgenda.getDtImplant() ) ){
			touchAgenda.setDtImplant(HowMGWTUtilities.getFormatDateTime(new Date()));
		}
		else{
			touchAgenda.setDtImplant( currentTouchAgenda.getDtImplant() );
		}
		
	}




	public HowMGWTFormProperties getProperties() {
		return properties;
	}




	public void setProperties(HowMGWTFormProperties properties) {
		this.properties = properties;
	}




	public HowMGWTProperty getPropertyCodAgendamento() {
		return propertyCodAgendamento;
	}




	public void setPropertyCodAgendamento(HowMGWTProperty propertyCodAgendamento) {
		this.propertyCodAgendamento = propertyCodAgendamento;
	}




	public HowMGWTProperty getPropertyDtInicio() {
		return propertyDtInicio;
	}




	public HowMGWTProperty getPropertyDtFim() {
		return propertyDtFim;
	}




	public HowMGWTProperty getPropertyHoraInicio() {
		return propertyHoraInicio;
	}




	public HowMGWTProperty getPropertyHoraFim() {
		return propertyHoraFim;
	}




	public HowMGWTProperty getPropertySituacao() {
		return propertySituacao;
	}




	public HowMGWTProperty getPropertyAssunto() {
		return propertyAssunto;
	}




	public UCFieldLookupBuscaColaborador getFieldLookupBuscaColaborador() {
		return fieldLookupBuscaColaborador;
	}




	public UCFieldLookupBuscaCliente getFieldLookupBuscaCliente() {
		return fieldLookupBuscaCliente;
	}
	
	
	public void refreshDataFeriado(HowMGWTProperty property, Label label){
		String data  	= property.getHowmFormValueToString();

		label.setContents("");

		if( ! HowMGWTUtilities.isEmpty( data ) ){
			eFeriado feriado = parentPainelCalendarioMensal.getParentPainelCalendarioAno().getParentPainelTop().getMapFeriados().get(HowMGWTUtilities.getFormatDateDB(HowMGWTUtilities.getDate(data)));
			if( feriado != null ){
				String dia = "";
					
				dia = formatDateTimeDB.format(HowMGWTUtilities.getDate(feriado.getDtFeriado()));
				label.setContents("<font color=red>"+dia+", - Feriado <strong>"+feriado.getNomeFeriado()+"</strong></font>");
			}
		}
	}
}