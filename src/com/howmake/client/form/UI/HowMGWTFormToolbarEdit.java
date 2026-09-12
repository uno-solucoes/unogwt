package com.howmake.client.form.UI;

import java.util.Date;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.control.HowMGWTControlForm;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class HowMGWTFormToolbarEdit extends ToolStrip{

	private boolean initialize   = false;
	
	private IButton actionNovo 	 = new IButton(Tradutor.i18n.formNovo());
	private IButton actionEditar;
	private IButton actionGravar = new IButton(Tradutor.i18n.formGravar());
	private IButton actionDelete;
	private IButton actionBuscar;
	
	private HowMGWTLabel fieldStatus = new HowMGWTLabel();
	
	private HowMGWTControlForm formControl;
	private HowMGWTListGrid panelList;

	private boolean actionKeyPressed = false;
	
	public HowMGWTFormToolbarEdit(HowMGWTControlForm formControl){
		this(formControl, new HowMGWTListGrid(), true);
	}

	public HowMGWTFormToolbarEdit(HowMGWTControlForm formControl, HowMGWTListGrid panelList){
		this(formControl,panelList, true);
	}
	
	public HowMGWTFormToolbarEdit(HowMGWTControlForm formControl, HowMGWTListGrid panelList, boolean configureListGrid){
		this.formControl = formControl;		
		this.panelList   = panelList;
		// Verifica se a grid deverá ser configurada.
		if ( configureListGrid  )
			this.onHowMCreatePanelList();
		
		this.setWidth100();
		this.setHeight(30);
		this.setVertical(false);
		
 
		actionNovo.setWidth(66);
		actionNovo.setIcon("actions/add.png"); 
	
		actionGravar.setWidth(66);
		actionGravar.setIcon("actions/save.png"); 
		
		
		this.addSeparator();
		
		this.addMember(actionNovo);
		
		this.addSeparator();
		
		int widthStatus = 150;
		VLayout vLayout = new VLayout();
		vLayout.setHeight(30);
		vLayout.setWidth(widthStatus);
		vLayout.setOverflow(Overflow.HIDDEN);
		
		HLayout hLayout = new HLayout();
		hLayout.setAutoWidth();
		hLayout.setHeight(8);
		hLayout.setOverflow(Overflow.HIDDEN);
		vLayout.addMember(hLayout);
			
		fieldStatus.setOverflow(Overflow.HIDDEN);
		fieldStatus.setWidth(widthStatus);
		fieldStatus.setAlign(Alignment.CENTER);
		vLayout.addMember(fieldStatus);
		this.addMember(vLayout);
		
		
		
		this.addSeparator();
		this.addMember(actionGravar);
				
		this.actionNovo.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				actionKeyPressed = true;
				onHowMConfigureStatusNewRecord();
				actionKeyPressed = false;
			}
		});

		// Verifica se a grid deverá ser configurada.
		if ( configureListGrid ){
			this.getPanelList().addKeyPressHandler(new KeyPressHandler() {
				
				@Override
				public void onKeyPress(KeyPressEvent event) {
					if ( event != null ){
						System.out.println("Key : "+event.getKeyName());					
						if ( event.getKeyName() != null && event.getKeyName().equals("Delete")){
							if ( actionDelete != null && ! actionDelete.isDisabled() && actionDelete.isVisible() ){
								if ( HowMGWTFormToolbarEdit.this.getPanelList().getSelectedRecord() != null ){
									HowMGWTFormToolbarEdit.this.formControl.onHowMDeleteRecord();
								}
							}
						}
						if ( event.getKeyName() != null && event.getKeyName().equals("Insert")){
							if ( actionNovo != null && ! actionNovo.isDisabled() && actionNovo.isVisible() ){
								actionKeyPressed = true;
								onHowMConfigureStatusNewRecord();
								actionKeyPressed = false;
							}
						}
					}
				}
			});
		}
		
		
		this.actionGravar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if ( preFormValidate() )
					HowMGWTFormToolbarEdit.this.formControl.onHowMSave();
			}
		});
		
				
		// Verifica se a grid deverá ser configurada
		if ( configureListGrid  ){
			this.panelList.setFields(formControl.getHowMProperties().getListFields());
			onHowMConfigureStatusNewRecord();
		
			// Intercepta a navegação do registro.
	        this.panelList.addRecordClickHandler(new RecordClickHandler(){              
	        	public void onRecordClick(RecordClickEvent event) {  
	                ListGridRecord record = (ListGridRecord)event.getRecord(); 
	                onHowMConfigureStatus(record);
	           		
	        	}
	        });
		}
		else 
			onHowMConfigureStatusNewRecord();
	}

	/**
	 * @return the actionNovo
	 */
	public IButton getActionNovo() {
		return actionNovo;
	}

	/**
	 * @return the actionGravar
	 */
	public IButton getActionGravar() {
		return actionGravar;
	}

	/**
	 * @param fieldStatus the fieldStatus to set
	 */
	public void setFieldStatus(HowMGWTLabel fieldStatus) {
		this.fieldStatus = fieldStatus;
	}
	
	public void setStatus(String status){
		this.fieldStatus.setHowMValue("<center>"+status+"</center>");
	}
	
	
	/**
	 * Configura o status do registro na barra de ferramentas.
	 * @param panelList
	 * @param record
	 */
	public void onHowMConfigureStatus(ListGridRecord record){
 
        getActionGravar().setDisabled(false);
        
        String value = "";
        value = Tradutor.i18n.formNavegacao();
		if ( record == null )
			value = HowMGWTUtilities.replace(value, "#RegIni", ""+(panelList.getRecords().length));
		else
	        value = HowMGWTUtilities.replace(value, "#RegIni", ""+(panelList.getRecordIndex(record)+1));
			
		value = HowMGWTUtilities.replace(value, "#RegFim", ""+(panelList.getRecords().length));

        setStatus(value);
        convertRecordToForm(record);
        if ( record != null ){
	        if ( actionDelete != null ) 
	        	actionDelete.setDisabled(false);
	        if ( actionEditar != null )
	        	actionEditar.setDisabled(false);
        }
        else{
	        if ( actionDelete != null ) 
	        	actionDelete.setDisabled(true);
	        if ( actionEditar != null )
	        	actionEditar.setDisabled(true);        	
        }
        HowMGWTFormToolbarEdit.this.formControl.onHowMSetValues(record);
	}
	
	/**
	 * Prepara o formulório para um novo registro
	 */
	public void onHowMConfigureStatusNewRecord(){
		  if ( initialize )
			  this.panelList.deselectAllRecords();
		  else
			  initialize = true;
		  
		  setStatus(Tradutor.i18n.formNovoRegistro());
	      
		  getActionGravar().setDisabled(false);
	      newRecord();

	      if ( actionDelete != null ) 
	    	  actionDelete.setDisabled(true);
	      
	      if ( actionEditar != null )
	    	  actionEditar.setDisabled(true);
	      
	      HowMGWTFormToolbarEdit.this.formControl.onHowMNewRecord();
	}
 
	
	public void onHowMConfigureStatusEditRecord(){	    
		getActionGravar().setDisabled(false);		

	    String value = "";
        value = Tradutor.i18n.formEditandoRegistro();
        value = HowMGWTUtilities.replace(value, "#RegIni", ""+(panelList.getRecordIndex(panelList.getSelectedRecord())+1));
        value = HowMGWTUtilities.replace(value, "#RegFim", ""+(panelList.getRecords().length));
        setStatus(value);
 	    HowMGWTFormToolbarEdit.this.formControl.onHowMEditRecord();		
	}

	/**
	 * @return the panelList
	 */
	public HowMGWTListGrid getPanelList() {
		return panelList;
	}
	
	/**
	 * Realiza umaprévalidação no formulório para verificar se todas as informações forma informadas.
	 * @return
	 */
	public boolean preFormValidate(){
		String errors = "";
		String msg;
		for ( HowMGWTProperty prop : formControl.getHowMProperties().getProperties() ){
			msg = prop.getMessageMandatory();
			if ( ! HowMGWTUtilities.isEmpty( msg ) ){
				if ( ! HowMGWTUtilities.isEmpty( errors ))
					errors += "<br>";
				
				errors += msg ;
			}
		}
		if ( !HowMGWTUtilities.isEmpty( errors ) ){
			errors += "<hr>";
			errors += "<font color=red>Corrija o problema e tente novamente...</b>";
			SC.warn(errors);
			return false;
		}
		return true;
	}
	
	/**
	 * Limpa os dados da tela e prepara a tela para um novo registro.
	 */
	public void newRecord(){
		for ( HowMGWTProperty prop : formControl.getHowMProperties().getProperties() ){
			if ( prop.getFormField() != null )
				prop.getFormField().setHowMValue(null);
		}
	}
	
	/**
	 * Adiciona um novo registro a partir dos campos de edição.
	 */
	public ListGridRecord addRecord(){
		ListGridRecord record = new ListGridRecord();
		for ( HowMGWTProperty prop : formControl.getHowMProperties().getProperties() )
			record.setAttribute(prop.getName(), prop.getHowMValue() );
		this.getPanelList().getRecordList().add(record);
		this.getPanelList().selectRecord(record);		
		onHowMConfigureStatus(record);
		
		return record;
	}
	
	/**
	 * Adiciona um novo registro a partir dos campos de edição.
	 */
	public ListGridRecord addRecord(HowMGWTFormBean bean){
		ListGridRecord record = new ListGridRecord();
		convertFormBeanToRecord(record,bean);		
		this.getPanelList().getRecordList().add(record);
		this.getPanelList().selectRecord(record);		
		onHowMConfigureStatus(record);
		return record;
	}
	

	public void removeRecord(ListGridRecord record){
		this.getPanelList().removeData(record);
	}
	
	/**
	 * Adiciona um novo registro a partir dos campos de edição.
	 */
	public ListGridRecord convertFormBeanToRecord(HowMGWTFormBean bean){
		ListGridRecord record = new ListGridRecord();
		return convertFormBeanToRecord(record, bean);
	}

	/**
	 * Seta os valores de um record para um FormBean
	 */
	public ListGridRecord convertRecordToFormBean(HowMGWTFormBean bean){
		ListGridRecord record = new ListGridRecord();
		return convertRecordToFormBean(record, bean);
	}

	/**
	 * Adiciona um novo registro a partir dos campos de edição.
	 */
	public ListGridRecord convertFormBeanToRecord(ListGridRecord record, HowMGWTFormBean bean){

		for ( HowMGWTProperty prop : formControl.getHowMProperties().getProperties() )
			if ( prop.getType().equals(ListGridFieldType.TEXT )){
				record.setAttribute(prop.getName(), bean.toString(prop.getName()) );				
			}
			else if ( prop.getType().equals(ListGridFieldType.FLOAT)){
				record.setAttribute(prop.getName(), bean.toDouble(prop.getName()) );								
			}
			else if ( prop.getType().equals(ListGridFieldType.INTEGER)){
				record.setAttribute(prop.getName(), bean.toDouble(prop.getName()) );	
			}
			else if ( prop.getType().equals(ListGridFieldType.BOOLEAN)){
				record.setAttribute(prop.getName(), bean.toBoolean(prop.getName()) );	
			}
			else if ( prop.getType().equals(ListGridFieldType.DATE)){
				record.setAttribute(prop.getName(), HowMGWTUtilities.getDate(bean.toString(prop.getName())));
			}

		return record;
	}

	/**
	 * Seta os valores de um record para um FormBean
	 */
	public ListGridRecord convertRecordToFormBean(ListGridRecord record , HowMGWTFormBean bean){
		for ( HowMGWTProperty prop : formControl.getHowMProperties().getProperties() ){
			if ( prop.getType().equals(ListGridFieldType.TEXT )){
				bean.setString(prop.getName(), record.getAttributeAsString(prop.getName()));
			}
			else if ( prop.getType().equals(ListGridFieldType.FLOAT)){
				bean.setDouble(prop.getName(), record.getAttributeAsDouble(prop.getName()));
			}
			else if ( prop.getType().equals(ListGridFieldType.INTEGER)){
				bean.setInteger(prop.getName(), record.getAttributeAsInt(prop.getName()));
			}
			else if ( prop.getType().equals(ListGridFieldType.DATE)){
				Date date = record.getAttributeAsDate(prop.getName());
				bean.setString(prop.getName(), HowMGWTUtilities.getFormatDateTimeDB(date));
			}
		}
		return record;
	}

	
	public void convertFormBeanToForm(HowMGWTFormBean formBean){
		for ( HowMGWTProperty prop : formControl.getHowMProperties().getProperties() ){
			if ( prop.getFormField() != null ){
			
				if ( prop.getType().equals(ListGridFieldType.TEXT )){
					prop.getFormField().setHowMValue(formBean.toString(prop.getName()));
				}
				else if ( prop.getType().equals(ListGridFieldType.FLOAT)){
					prop.getFormField().setHowMValue(formBean.toString(prop.getName()));
				}
				else if ( prop.getType().equals(ListGridFieldType.INTEGER)){
					prop.getFormField().setHowMValue(formBean.toString(prop.getName()));
				}
				else if ( prop.getType().equals(ListGridFieldType.DATE)){
					Date date = HowMGWTUtilities.getDate(formBean.toString(prop.getName()));
					
					if ( prop.getHowMGWTEditorDateItem() != null )
						prop.getFormField().setHowMValue(date);
					else
						prop.getFormField().setHowMValue(HowMGWTUtilities.getFormatDateTime(date));
				}
				
			}
		}		
	}	
	
	public void convertFormToFormBean(HowMGWTFormBean formBean){
		for ( HowMGWTProperty prop : formControl.getHowMProperties().getProperties() ){

			if ( prop.getFormField() != null ){

				if ( prop.getType().equals(ListGridFieldType.TEXT )){
					formBean.setObject(prop.getName(), prop.getFormField().getHowMValue() );
				}
				else if ( prop.getType().equals(ListGridFieldType.FLOAT)){
					formBean.setObject( prop.getName(), ""+HowMGWTUtilities.getDouble(prop.getFormField().getHowMValue()) );
				}
				else if ( prop.getType().equals(ListGridFieldType.INTEGER)){
					formBean.setObject( prop.getName(), ""+HowMGWTUtilities.getInteger(""+prop.getFormField().getHowMValue()) );				
				}
				else if ( prop.getType().equals(ListGridFieldType.DATE)){	
					Date date = HowMGWTUtilities.getDate(""+prop.getFormField().getHowMValue());
					if ( HowMGWTUtilities.isEmpty( date ) )
						formBean.setObject( prop.getName(), "" );
					else
						formBean.setObject( prop.getName(), HowMGWTUtilities.getFormatDateTimeDB(date));						
				}

			}
		}		
	}		
	
	
	public void convertRecordToForm(ListGridRecord record){
		if ( record == null )
			return;
		
		for ( HowMGWTProperty prop : formControl.getHowMProperties().getProperties() ){
			if ( prop.getFormField() != null ){
			
				if ( prop.getType().equals(ListGridFieldType.TEXT )){
					prop.getFormField().setHowMValue(record.getAttributeAsString(prop.getName()));
				}
				else if ( prop.getType().equals(ListGridFieldType.FLOAT)){
					prop.getFormField().setHowMValue(record.getAttributeAsDouble(prop.getName()));
				}
				else if ( prop.getType().equals(ListGridFieldType.INTEGER)){
					prop.getFormField().setHowMValue(record.getAttributeAsInt(prop.getName()));
				}
				else if ( prop.getType().equals(ListGridFieldType.DATE)){
					try{
						Date date = record.getAttributeAsDate(prop.getName());						
						if ( prop.getHowMGWTEditorDateItem() != null )
							prop.getFormField().setHowMValue(date);
						else
							prop.getFormField().setHowMValue(HowMGWTUtilities.getFormatDateTime(date));
					}
					catch(Throwable er){
						Date date = HowMGWTUtilities.getDate(record.getAttribute(prop.getName()));
						if ( date != null )
							if ( prop.getHowMGWTEditorFieldText() != null )
								prop.getFormField().setHowMValue(HowMGWTUtilities.getFormatDateTime(date));
							else
								prop.getFormField().setHowMValue("");
					}
				}
				
			}
		}		
	}	
	
	/**
	 * Atualiza os dados do registro a partir dos campos de edição
	 */
	public ListGridRecord refreshRecord(){
		ListGridRecord record = this.getPanelList().getSelectedRecord();
		for ( HowMGWTProperty prop : formControl.getHowMProperties().getProperties() )
			record.setAttribute(prop.getName(), prop.getHowMValue() );
		this.getPanelList().refreshRow(this.getPanelList().getRecordIndex(record));
		return record;
	}

	
	/**
	 * Atualiza os dados do registro a partir dos campos de edição
	 */
	public ListGridRecord refreshRecord(HowMGWTFormBean bean){
		ListGridRecord record = this.getPanelList().getSelectedRecord();
		convertFormBeanToRecord(record, bean);
		this.getPanelList().refreshRow(this.getPanelList().getRecordIndex(record));
		return record;
	}

	
	public void createActionDelete(){
		this.actionDelete = 	new IButton(Tradutor.i18n.formDelete());
		this.actionDelete.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {			
				formControl.onHowMDeleteRecord();
			}
		});
		
		this.actionDelete.setIcon("actions/ico_excluir.gif");
		this.actionDelete.setDisabled(true);
		HLayout sep = new HLayout();
		sep.setWidth(5);
		this.addMember(sep);
		this.addMember(this.actionDelete);
	}


	public void createActionBuscar(){
		this.actionBuscar = 	new IButton(Tradutor.i18n.buscar());

		this.actionBuscar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {

				if ( actionDelete != null )
		        	actionDelete.setDisabled(true);
		        
				if ( actionEditar != null )
		        	actionEditar.setDisabled(true);


				formControl.onHowMLoad(null);
			}
		});
		
		this.actionBuscar.setIcon("actions/search.png");
		HLayout sep = new HLayout();
		sep.setWidth(5);
		this.addMember(sep);
		this.addMember(this.actionBuscar);
	}

	
	/***
	 * Cria o botão para edição de dados.
	 */
	public void createActionEditar(){
		this.actionEditar = new IButton(Tradutor.i18n.formEditar());
		this.actionEditar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				formControl.onHowMEditRecord();
			}
		});
		
		this.actionEditar.setIcon("actions/ico_edited.gif");
		this.actionEditar.setDisabled(true);
		HLayout sep = new HLayout();
		sep.setWidth(5);
		this.addMember(sep);
		this.addMember(this.actionEditar);
	}
	
	public void onHowMCreatePanelList(){}

	/**
	 * @return the actionKeyPressed
	 */
	public boolean isActionKeyPressed() {
		return actionKeyPressed;
	}

	/**
	 * @param actionKeyPressed the actionKeyPressed to set
	 */
	public void setActionKeyPressed(boolean actionKeyPressed) {
		this.actionKeyPressed = actionKeyPressed;
	}

	/**
	 * @return the actionEditar
	 */
	public IButton getActionEditar() {
		return actionEditar;
	}

	/**
	 * @return the actionDelete
	 */
	public IButton getActionDelete() {
		return actionDelete;
	};
	
	
}
