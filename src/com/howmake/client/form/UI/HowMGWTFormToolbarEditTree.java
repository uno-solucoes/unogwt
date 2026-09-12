package com.howmake.client.form.UI;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.Timer;
import com.howmake.client.I18N.HowMTradutor;
import com.howmake.client.form.control.HowMGWTControlFormLoad;
import com.howmake.client.form.control.HowMGWTControlFormSave;
import com.howmake.client.form.control.HowMGWTControlFormTools;
import com.howmake.client.form.model.HowMGWTActionDescription;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.model.HowMGWTTreeNode;
import com.howmake.client.form.model.HowMPar;

import com.howmake.client.form.partner.HowMGWTConstants;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.tree.TreeNode;

public class HowMGWTFormToolbarEditTree extends ToolStrip{

	ArrayList<HowMPar> entitySaveParEntities;
	
	boolean insertModeTempWork = false;
	
	
    private boolean howMCanEdit					= true;
    private boolean howMCanNew					= true;
    private boolean howMCanDelete				= true;	
	
	private int rowNumGerador = 100000;
	
	private HowMGWTActionDescription lastActionDescription;
	private HowMGWTActionDescription actionDescription = new HowMGWTActionDescription();

	private HowMGWTControlFormSave parentHowMControlFormSave;
	private HowMGWTControlFormLoad parentHowMControlFormLoad;

	private boolean actionInsertSubItem = false;

	private int operacaoRegistro;
	
	private boolean initialize   = false;
	
	private IButton actionNovoNo 	= new IButton(HowMTradutor.i18n.formNovoItem()){
		@Override
		public void setDisabled(boolean disabled) {
			if( ! isHowMCanNew() )
				super.setDisabled(true);
			else
				super.setDisabled(disabled);
		};
	};
	
	private IButton actionNovoSubNo = new IButton(HowMTradutor.i18n.formNovoSubItem()){
		@Override
		public void setDisabled(boolean disabled) {
			if( ! isHowMCanNew() )
				super.setDisabled(true);
			else
				super.setDisabled(disabled);
		};
	};

	
	private IButton actionEditar;
	private IButton actionGravar = new IButton(HowMTradutor.i18n.formGravar()){
		public void setDisabled(boolean disabled) {
			if (! isHowMCanSave() ) 
				super.setDisabled(true);				
		 
			else 
				super.setDisabled(disabled);
		};
	};
	
	
	private IButton actionGravarGrid;
	
	private IButton actionDelete;
	private IButton actionBuscar;
	
	private HowMGWTFormLabel fieldStatus = new HowMGWTFormLabel();
	private HowMGWTFormLabel fieldStatusSecurity ;
	
	private HowMGWTControlFormTools formControl;
	private HowMGWTTreeGrid treeGrid ;

	private boolean actionKeyPressed = false;

	public HowMGWTFormToolbarEditTree(){
	}
	
	public HowMGWTFormToolbarEditTree(HowMGWTControlFormTools formControl, HowMGWTTreeGrid panelList){
		this(formControl,panelList, true);
	}

	
	public HowMGWTFormToolbarEditTree(HowMGWTControlFormTools formControl, HowMGWTTreeGrid treeGrid, boolean configureListGrid){
		this.HowMInitialize(formControl, treeGrid, configureListGrid);
	}

	/**
	 * Inicializa a barra de controle dos dados para trabalho 
	 * @param formControl
	 * @param treeGrid
	 * @param configureListGrid
	 */
	public void HowMInitialize(HowMGWTControlFormTools formControl, HowMGWTTreeGrid treeGrid, boolean configureListGrid){
		
//		HowMGWTPrograma programa = null;
//		if( ! HowMGWTUtilities.isEmpty( formControl.getHowMProperties().getHowMModule() )){
//		
//			String module = formControl.getHowMProperties().getHowMModule();
//
//			programa = HowMGWTConstants.GLOBAL_WORKSPACE.getHowMAcessoProgramas().get(module);
//			// Workspace.getDefault().getGlobalSystem().getAcessosProgramas()	
//			if ( programa != null ){
//				
//				if( "1".equals(programa.getIndInsert() ) )
//					this.setHowMCanNew(true);
//				else
//					this.setHowMCanNew(false);
//				
//				if( "1".equals(programa.getIndUpdate() ) )
//					this.setHowMCanEdit(true);
//				else
//					this.setHowMCanEdit(false);
//				
//				if( "1".equals(programa.getIndDelete() ) )
//					this.setHowMCanDelete(true);
//				else
//					this.setHowMCanDelete(false);			
//			}
//		}
		
		this.formControl = formControl;		
		this.treeGrid   = treeGrid;

		this.treeGrid.setParentHowMFormToolbarEditTree(this);
		
		// Verifica se a grid deverá ser configurada.
		if ( configureListGrid  )
			this.onHowMCreatePanelList();
		
		this.setWidth100();
		this.setHeight(30);
		this.setVertical(false);
		
 
		actionNovoNo.setWidth(100);
		actionNovoNo.setIcon("actions/icon_novo_item.png"); 
		actionNovoNo.setPrompt("Novo Item");
		
		actionNovoSubNo.setWidth(110);
		actionNovoSubNo.setIcon("actions/icon_novo_sub_item.png"); 
		actionNovoSubNo.setPrompt("Novo Sub-Item");

		actionGravar.setWidth(66);
		changeSaveIcon("save.png",HowMTradutor.i18n.formGravar());

		if ( onIsCreateActionNovoNo() ){
			this.addSeparator();
			this.addMember(actionNovoNo);
			this.addSeparator();			

			this.actionNovoNo.addClickHandler(new ClickHandler() {

				public void onClick(ClickEvent event) {
					onHowMClickNewActionNovoNo();
				}
			});

		}
		
		
		if ( onIsCreateActionNovoSubNo() ){
			this.addSeparator();
			this.addMember(actionNovoSubNo);
			this.addSeparator();			

			this.actionNovoSubNo.addClickHandler(new ClickHandler() {
				 
				public void onClick(ClickEvent event) {
					onClickActionNovoSubNo();
				}
			});
			actionNovoSubNo.setDisabled(true);
		}



//		// Alerta de seguranca
//		if ( programa != null ){		
//			if(  "0".equals(programa.getIndInsert() ) && "0".equals(programa.getIndUpdate() ) && "0".equals(programa.getIndDelete() ) ){
//				fieldStatusSecurity = new HowMGWTFormLabel(); 
//				fieldStatusSecurity.setOverflow(Overflow.HIDDEN);
//				fieldStatusSecurity.setWidth(60);
//				fieldStatusSecurity.setHeight(30);							
//				fieldStatusSecurity.setHowMValue("<STRONG><FONT color=red>Somente<br>Consulta</FONT></STRONG>");
//				this.addMember(fieldStatusSecurity);
//				this.addSeparator();
//			}
//		}
//		
		
		
		
		int widthStatus = 160;
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
		

 		if ( onIsCreateActionSave() && ! this.treeGrid.isHowMCanEdit() ){
			this.addSeparator();
			actionGravar.setWidth(100);
			this.addMember(actionGravar);

			this.actionGravar.addClickHandler(new ClickHandler() {
				 
				public void onClick(ClickEvent event) {
					onClickSave();
				}
			});
			

		}

		// Verifica se a grid deverá ser configurada.
		if ( configureListGrid ){
			this.getTreeGrid().addKeyPressHandler(new KeyPressHandler() {
			 
				public void onKeyPress(KeyPressEvent event) {
					if ( event != null ){
						if ( event.getKeyName() != null && event.getKeyName().equals("Delete")){
							if ( actionDelete != null && ! actionDelete.isDisabled() && actionDelete.isVisible() ){
								if ( HowMGWTFormToolbarEditTree.this.treeGrid.getHowMTreeGrid().getSelectedRecord() != null ){									
									delete();
								}
							}
						}
						if ( event.getKeyName() != null && event.getKeyName().equals("Insert")){
							if ( actionNovoNo != null && ! actionNovoNo.isDisabled() && actionNovoNo.isVisible() ){
								actionKeyPressed = true;
								onHowMConfigureStatusNewRecord();
								actionKeyPressed = false;
							}
						}
					}
				}
			});
		}
		
		if( this.getTreeGrid().isHowMCanEdit() ){
			// Avalia se algum campo foi alterado.
			this.getTreeGrid().getHowMTreeGrid().addEditCompleteHandler(new EditCompleteHandler() {
				public void onEditComplete(EditCompleteEvent event) {
					LinkedHashMap mapNewValues = (LinkedHashMap)event.getNewValues();
					ListGridRecord record = getTreeGrid().getHowMTreeGrid().getRecord(event.getRowNum());
					if ( record == null )
						return;
					
					String columnName = getTreeGrid().getHowMTreeGrid().getFieldName(event.getColNum());
					event.getOldValues().getAttribute(columnName);
	
					
					HowMGWTTreeNode node = (HowMGWTTreeNode)record;
					if( "icon_operation_insert".equalsIgnoreCase(node.getHowMOperation() ) )
						;
					else if( "icon_operation_deleted".equalsIgnoreCase(node.getHowMOperation()))
						;
					else if( "icon_operation_edited".equalsIgnoreCase(node.getHowMOperation()))
						;
					else{
						getTreeGrid().getHowMPropertyFieldOperation().setHowMValue(node, "icon_operation_edited");
						node.getHowMFormBean().setSQLOperacaoUpdate();
						
					}
				}
			});			
		}		
				
		// Verifica se a grid deverá ser configurada
		if ( configureListGrid  ){

			onHowMConfigureStatusNewRecord();

	        if( ! treeGrid.getHowMTreeGrid().getCanEdit() ){				
				// Intercepta a navegação do registro.
		        this.treeGrid.getHowMTreeGrid().addRecordClickHandler(new RecordClickHandler(){              
		        	public void onRecordClick(RecordClickEvent event){
						HowMGWTTreeNode record = (HowMGWTTreeNode)event.getRecord(); 
		                onHowMConfigureStatus(record);
		        	}
		        });
	        }
	        if( treeGrid.getHowMTreeGrid().getCanEdit() ){
		        this.treeGrid.getHowMTreeGrid().addSelectionChangedHandler(new SelectionChangedHandler() {
					
					public void onSelectionChanged(SelectionEvent event) {
						if( event.getSelectedRecord() != null ){
							String operation = getTreeGrid().getHowMPropertyFieldOperation().getHowMValue(event.getSelectedRecord());
			                onHowMConfigureStatus((HowMGWTTreeNode)event.getSelectedRecord());
						}
					}
				});
	        }
		}
		else {
			onHowMConfigureStatusNewRecord();
		}
		
	}

	/**
	 * @return the actionNovo
	 */
	public IButton getActionNovo() {
		return actionNovoNo;
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
	public void setFieldStatus(HowMGWTFormLabel fieldStatus) {
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
	public void onHowMConfigureStatus(HowMGWTTreeNode record){
 
 
		getActionGravar().setDisabled(false);
        
        String value = "";
        value = HowMTradutor.i18n.formNavegacao();
        
        /**
         * Ocorre null quando o componente é finalizado.
         * neste caso retorna e não faz nada.
         */                
		if( this.treeGrid.getHowMTreeGrid().getRecordList() == null ){
			return;
		}

		if ( record == null ){
						value = HowMGWTUtilities.replace(value, "#RegIni", ""+(this.treeGrid.getHowMTreeGrid().getRecordList().getLength()));
	 	    this.operacaoRegistro = HowMGWTUtilities.OPERATION_INSERT;
			if( getTreeGrid().isHowMClientMode() ){
				changeSaveIcon("add.png","Incluir");
			}	 	    
	 	    actionDescription.setHowMInsertMode();
		}
		else{
	        value = HowMGWTUtilities.replace(value, "#RegIni", ""+(this.treeGrid.getHowMTreeGrid().getRecordIndex(record)+1));
	 	    this.operacaoRegistro = HowMGWTUtilities.OPERATION_UPDATE;
			if( getTreeGrid().isHowMClientMode() ){
				changeSaveIcon("accept.png", "Atualizar");
			}
	 	    actionDescription.setHowMUpdateMode();
		}
		
		value = HowMGWTUtilities.replace(value, "#RegFim", ""+(this.treeGrid.getHowMTreeGrid().getRecordList().getLength()));

        setStatus(value);
        convertRecordToForm(record);
        if ( record != null ){
	        if ( actionDelete != null ){ 
	        	if( this.getTreeGrid().isHowMCanEdit() ){
	        		if(  record.getHowMFormBean().isSQLOperacaoDelete())
	        			actionDelete.setTitle("Desfazer");
	        		else
	        			actionDelete.setTitle(HowMTradutor.i18n.formDelete());	        			
	        	}
	        	actionDelete.setDisabled(false);
	        }
	        if ( actionEditar != null )
	        	actionEditar.setDisabled(false);
	        
			if ( onIsCreateActionNovoSubNo() )
				this.actionNovoSubNo.setDisabled(false);			

        }
        else{
	        if ( actionDelete != null ){
	        	actionDelete.setTitle(HowMTradutor.i18n.formDelete());	        			
	        	actionDelete.setDisabled(true);
	        }
	        if ( actionEditar != null )
	        	actionEditar.setDisabled(true);        	

			if ( onIsCreateActionNovoSubNo() )
				this.actionNovoSubNo.setDisabled(true);			

        }
        onHowMSetValuesImpl(record);
	}
	
	/**
	 * Prepara o formulório para um novo registro
	 */
	public void onHowMConfigureStatusNewRecord(){
 
		if( this.treeGrid.isHowMCanEdit() &&  ( !this.initialize || !actionKeyPressed )){
			setStatus("Nenhum registro encontrado");
			initialize = true;
			return;
		}
		
		actionDescription.setHowMInsertMode();

		if ( onIsCreateActionNovoNo() || onIsCreateActionNovoSubNo() ){
			if ( initialize ){
				if( isActionInsertSubItem() )
					;
				else{
					this.treeGrid.getHowMTreeGrid().deselectAllRecords();
					if ( isActionInsertSubItem() ){
						this.actionNovoNo.setDisabled(true);
					}
				}
			}
		    else
				  initialize = true;
			  
			  setStatus(HowMTradutor.i18n.formNovoRegistro());
		      
			  getActionGravar().setDisabled(false);
		      newRecord();
	
		      if ( actionDelete != null ){
		    	  actionDelete.setDisabled(true);
		    	  actionDelete.setTitle(HowMTradutor.i18n.formDelete());	        			
		      }
		      
		      if ( actionEditar != null )
		    	  actionEditar.setDisabled(true);
		      
		      if ( onIsCreateActionNovoSubNo() && ! isActionInsertSubItem()  )
				this.actionNovoSubNo.setDisabled(true);			
		      
		      
		      this.setOperacaoRegistro(HowMGWTUtilities.OPERATION_INSERT);
		      onHowMNewRecordImpl();
		      
		      if( this.getTreeGrid().isHowMCanEdit()){
		    	  this.onClickSave();
		    	  
		    	  // ---------------------------------------------------------------------------------
		    	  // Move o cursor até a última linha e inicializa a edição dos dados na grid.
		    	  // ---------------------------------------------------------------------------------		    	  
		    	  Timer timer = new Timer() {					
						@Override
						public void run() {
							int lastRow = getTreeGrid().getHowMTreeGrid().getRecordList().getLength()-1;
					    	getTreeGrid().getHowMTreeGrid().scrollToRow(lastRow);
					    	
					    	
					    	int col = 0;
					    	ListGridField[] fields = getTreeGrid().getHowMTreeGrid().getFields();
					    	for( int i = 0 ; i < fields.length ; i ++ ){
					    		if( fields[i].getCanEdit() ){
					    			col = i;
					    			break;
					    		}
					    	}
					    	getTreeGrid().getHowMTreeGrid().startEditing(lastRow,col,false);
						}
		    	  };
		    	  timer.schedule(100);
		      }
		}
		else{
			setStatus("Nenhum registro encontrado");			
		}
	}
 
	
	
	public void onHowMConfigureStatusEditRecord(){	    
		getActionGravar().setDisabled(false);

	    String value = "";
        value = HowMTradutor.i18n.formEditandoRegistro();
        value = HowMGWTUtilities.replace(value, "#RegIni", ""+(this.treeGrid.getHowMTreeGrid().getRecordIndex(this.treeGrid.getHowMTreeGrid().getSelectedRecord())+1));
        value = HowMGWTUtilities.replace(value, "#RegFim", ""+(this.treeGrid.getHowMTreeGrid().getRecordList().getLength()));
        setStatus(value);
        HowMGWTFormToolbarEditTree.this.formControl.onHowMEditRecord();
 	    this.operacaoRegistro = HowMGWTUtilities.OPERATION_UPDATE;
	}

	/**
	 * @return the panelList
	 */
	public HowMGWTTreeGrid getTreeGrid() {
		return treeGrid;
	}
	
	
	private HowMGWTProperty currentProperty = null;
	
	
	
	/**
	 * Realiza umaprévalidação no formulório para verificar se todas as informações forma informadas.
	 * @return
	 */
	public boolean preFormValidate(){
//		String errors = "";
//		String msg;
//		for ( HowMGWTProperty prop : formControl.getHowMProperties().getProperties() ){
//			currentProperty = prop;
//			msg = prop.getMessageMandatory();
//			if ( ! HowMGWTUtilities.isEmpty( msg ) ){
//				if ( ! HowMGWTUtilities.isEmpty( errors ))
//					errors += "<br>";
//				
//				errors += msg ;
//			}
//			
//			if ( prop.getHowMFieldDateItemEditor() != null  ){
//				if ( ! HowMGWTUtilities.isEmpty(prop.getHowMValue())) {
//					Date data = HowMGWTUtilities.getDate(prop.getHowMValue());
//					if ( data == null ){
//						if ( ! HowMGWTUtilities.isEmpty( errors ))
//							errors += "<br>";
//						
//						errors += "Campo <strong><font color=red>" + prop.getLabel() + "</font></strong>, data informada não é valida ..." ;
//
//					}
//				}			
//			}
//
//			if( HowMGWTConstants.MASK_CNPJ.equals(prop.getHowMMask()) ){
//				if ( ! HowMGWTUtilities.isEmpty( prop.getHowMValue() ) ){
//					boolean valid = HowMGWTUtilities.verifyCNPJ(prop.getHowMValue());
//					if( ! valid ){
//						errors += "Valor informado para o Campo <strong><font color=red>" + prop.getLabel() + "</font> não é válido...";
//					}
//				}
//			}
//			
//			if( HowMGWTConstants.MASK_CPF.equals(prop.getHowMMask()) ){
//				if ( ! HowMGWTUtilities.isEmpty( prop.getHowMValue() ) ){
//					boolean valid = HowMGWTUtilities.verifyCPF(prop.getHowMValue());
//					if( ! valid ){
//						errors += "Valor informado para o Campo <strong><font color=red>" + prop.getLabel() + "</font> não é válido...";
//					}
//				}
//			}
//		}
//		if ( !HowMGWTUtilities.isEmpty( errors ) ){
//			errors += "<hr>";
//			errors += "<font color=red>Corrija o problema e tente novamente...</font></b>";
//			SC.warn(errors);
//			return false;
//		}
		return true;
	}
	
	
	
	
	
	
	
	
	/**
	 * Limpa os dados da tela e prepara a tela para um novo registro.
	 */
	public void newRecord(){

		actionDescription.setHowMInsertMode();

		for ( HowMGWTProperty prop : formControl.getHowMProperties().getProperties() ){
			prop.setHowmFormValue(null);
		}
	}
	
	public void removeRecord(){
		this.treeGrid.getHowMTreeGrid().removeData(this.treeGrid.getHowMTreeGrid().getSelectedRecord());
		RecordList records = this.treeGrid.getHowMTreeGrid().getRecordList();
		
		if ( this.treeGrid.getHowMTreeGrid().getRecordList().getLength() > 0 ){
			this.treeGrid.getHowMTreeGrid().selectRecord(this.treeGrid.getHowMTreeGrid().getRecordList().get(0));
			onHowMConfigureStatus((HowMGWTTreeNode)this.treeGrid.getHowMTreeGrid().getRecordList().get(0));
		}
	}

	
	public void removeRecord(HowMGWTTreeNode record){
		this.treeGrid.getHowMTreeGrid().removeData(record);
	}


	/**
	 * Adiciona um novo registro a partir dos campos de edição.
	 */
	public HowMGWTTreeNode convertFormBeanToRecord(HowMGWTTreeNode record, HowMGWTFormBean bean){

		for ( HowMGWTProperty prop : formControl.getHowMProperties().getProperties() ){
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
				record.setAttribute(prop.getName(), HowMGWTUtilities.getBoolean(bean.toString(prop.getName())) );	
			}
			else if ( prop.getType().equals(ListGridFieldType.DATE)){
				record.setAttribute(prop.getName(), HowMGWTUtilities.getDate(bean.toString(prop.getName())));
			}
			else{
				record.setAttribute(prop.getName(), bean.toString(prop.getName()) );								
			}
		}

		return record;
	}

	/**
	 * Seta os valores de um record para um FormBean
	 */
	public HowMGWTTreeNode convertRecordToFormBean(HowMGWTTreeNode record , HowMGWTFormBean bean){
		
		for ( HowMGWTProperty prop : formControl.getHowMProperties().getProperties() ){
			if ( prop.getType().equals(ListGridFieldType.TEXT )){
				bean.setString(prop.getName(), record.getAttributeAsString(prop.getName()));
			}
			if ( prop.getType().equals(ListGridFieldType.BOOLEAN )){
				if( HowMGWTUtilities.getBoolean(record.getAttribute(prop.getName())) )
					bean.setString(prop.getName(), prop.getHowMSelectValue());
				else
					bean.setString(prop.getName(), prop.getHowMUnselectValue());
			}
			else if ( prop.getType().equals(ListGridFieldType.FLOAT)){
				bean.setDouble(prop.getName(), HowMGWTUtilities.getDouble(record.getAttribute(prop.getName())));
			}
			else if ( prop.getType().equals(ListGridFieldType.INTEGER)){
				bean.setInteger(prop.getName(), HowMGWTUtilities.getInteger(record.getAttribute(prop.getName())));
			}
			else if ( prop.getType().equals(ListGridFieldType.DATE)){
				try{
					Date date = record.getAttributeAsDate(prop.getName());
					bean.setString(prop.getName(),HowMGWTUtilities.getFormatDateTime(date));
				}
				catch(Throwable er){
					Date date = HowMGWTUtilities.getDate(record.getAttribute(prop.getName()));
					bean.setString(prop.getName(),HowMGWTUtilities.getFormatDateTime(date));
				}
			}
		}
		return record;
	}

	
	public void convertFormBeanToForm(HowMGWTFormBean formBean){
		
		for ( HowMGWTProperty prop : formControl.getHowMProperties().getProperties() ){
						
			if ( prop.getType().equals(ListGridFieldType.TEXT )){
				prop.setHowmFormValue(formBean.toString(prop.getName()));
			}
			if ( prop.getType().equals(ListGridFieldType.IMAGE )){
				prop.setHowmFormValue(formBean.toString(prop.getName()));
			}
			else if ( prop.getType().equals(ListGridFieldType.FLOAT)){
				prop.setHowmFormValue(formBean.toString(prop.getName()));
			}
			else if ( prop.getType().equals(ListGridFieldType.INTEGER)){
				prop.setHowmFormValue(formBean.toString(prop.getName()));
			}
			else if ( prop.getType().equals(ListGridFieldType.DATE)){
				Date date = HowMGWTUtilities.getDate(formBean.toString(prop.getName()));
				
				if ( prop.getHowMFieldDateItemEditor() != null )
					prop.setHowmFormValue(date);
				else
					prop.setHowmFormValue(HowMGWTUtilities.getFormatDateTime(date));
			}
		}		
	}	
	
	
	/**
	 * Seta os dados de um formBean para os campos do formulório.
	 * @param formBean
	 */
	public void convertFormToFormBean(HowMGWTFormBean formBean){
		
		System.out.println("---------------------------------------------------------");
		
		for ( HowMGWTProperty prop : formControl.getHowMProperties().getProperties() ){
			
			System.out.println("Campo : "+prop.getTitle());

			if ( prop.getType().equals(ListGridFieldType.TEXT )){
				formBean.setObject(prop.getName(), prop.getHowmFormValue() );
			}
			else if ( prop.getType().equals(ListGridFieldType.FLOAT)){
				formBean.setObject( prop.getName(), ""+HowMGWTUtilities.getDouble(prop.getHowmFormValue()) );
			}
			else if ( prop.getType().equals(ListGridFieldType.INTEGER)){
				formBean.setObject( prop.getName(), ""+HowMGWTUtilities.getInteger(""+prop.getHowmFormValue()) );				
			}
			else if ( prop.getType().equals(ListGridFieldType.DATE)){	
				Date date = HowMGWTUtilities.getDate(""+prop.getHowmFormValue());
				if ( HowMGWTUtilities.isEmpty( date ) )
					formBean.setObject( prop.getName(), "" );
				else
					formBean.setObject( prop.getName(), HowMGWTUtilities.getFormatDateTimeDB(date));						
			}
			
			System.out.println("Campo : "+prop.getTitle()+" : "+prop.getHowmFormValue());
			
		}		
	}		
	
	
	
	
	
	
	public void convertRecordToForm(HowMGWTTreeNode record){
		if ( record == null )
			return;
		
		for ( HowMGWTProperty prop : formControl.getHowMProperties().getProperties() ){

				if ( prop.getType().equals(ListGridFieldType.TEXT )){
					prop.setHowmFormValue(record.getAttribute(prop.getName()));
				}
				else if ( prop.getType().equals(ListGridFieldType.FLOAT)){
					prop.setHowmFormValue(HowMGWTUtilities.getDouble(record.getAttribute(prop.getName())));
				}
				else if ( prop.getType().equals(ListGridFieldType.INTEGER)){
					prop.setHowmFormValue(HowMGWTUtilities.getDouble(record.getAttribute(prop.getName())));
				}
				else if ( prop.getType().equals(ListGridFieldType.DATE)){
					try{
						Date date = record.getAttributeAsDate(prop.getName());
						if ( prop.getHowMFieldDateItemEditor() != null )
							prop.setHowmFormValue(date);
						else
							prop.setHowmFormValue(HowMGWTUtilities.getFormatDateTime(date));
					}
					catch(Throwable er){
						Date date = HowMGWTUtilities.getDate(record.getAttribute(prop.getName()));
						if ( date != null )
							if ( prop.getHowMFieldDateItemEditor() != null )
								prop.setHowmFormValue(HowMGWTUtilities.getFormatDateTime(date));
							else if ( prop.getHowMFieldDateItemEditor() != null )
								prop.setHowmFormValue(date);
						else
							prop.setHowmFormValue("");
					}
				}
			}
	}	
	
	/**
	 * Atualiza os dados do registro a partir dos campos de edição
	 */
	public HowMGWTTreeNode refreshRecord(){
		HowMGWTTreeNode record = (HowMGWTTreeNode)this.treeGrid.getHowMTreeGrid().getSelectedRecord();
		for ( HowMGWTProperty prop : formControl.getHowMProperties().getProperties() )
			record.setAttribute(prop.getName(), prop.getHowMValue() );
		this.treeGrid.getHowMTreeGrid().refreshRow(this.treeGrid.getHowMTreeGrid().getRecordIndex(record));
		return record;
	}
	
	/**
	 * Atualiza os dados do registro a partir dos campos de edição
	 */
	public HowMGWTTreeNode refreshRecord(HowMGWTFormBean bean){
		HowMGWTTreeNode record = (HowMGWTTreeNode)this.treeGrid.getHowMTreeGrid().getSelectedRecord();
		convertFormBeanToRecord(record, bean);
		this.treeGrid.getHowMTreeGrid().refreshRow(this.treeGrid.getHowMTreeGrid().getRecordIndex(record));
		return record;
	}

	
	
	
	public void createActionSaveGrid(){
		 this.actionGravarGrid = new IButton(HowMTradutor.i18n.formGravar()){
			public void setDisabled(boolean disabled) {
				if (! isHowMCanSave() ) 
					super.setDisabled(true);				
			 
				else 
					super.setDisabled(disabled);
			};
		};	

		actionGravarGrid.setWidth(66);
		actionGravarGrid.setTitle(HowMTradutor.i18n.formGravar());
		actionGravarGrid.setIcon("actions/save.png");		
		this.addSeparator();
		actionGravarGrid.setWidth(100);

		this.actionGravarGrid.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				saveServerGrid();
			}
		});
		
		// this.actionGravarGrid.setDisabled(true);
		HLayout sep = new HLayout();
		sep.setWidth(5);
		this.addMember(sep);
		this.addMember(this.actionGravarGrid);
	}
	


		
	
		
		
		
		
	public void createActionDelete(){
		this.actionDelete = 	new IButton(HowMTradutor.i18n.formDelete()){
			@Override
			public void setDisabled(boolean disabled) {

				if ( ! isHowMCanDelete() ){
					if( treeGrid != null && treeGrid.getHowMTreeGrid() != null && getTreeGrid().getHowMPropertyFieldOperation() != null ){
						HowMGWTTreeNode node = (HowMGWTTreeNode)treeGrid.getHowMTreeGrid().getSelectedRecord();
						if( node != null ){
							String operation = getTreeGrid().getHowMPropertyFieldOperation().getHowMValue(node);
							if( "icon_operation_insert".equalsIgnoreCase(operation)){
								super.setDisabled(false);
							}	
							else{
								super.setDisabled(true);
							}
						}
						else
							super.setDisabled(true);
					}
					else
						super.setDisabled(true);
				}
				else
					super.setDisabled(disabled);
			}
		};
		this.actionDelete.addClickHandler(new ClickHandler() {
 
			public void onClick(ClickEvent event) {			
				delete();
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
		this.actionBuscar = 	new IButton(HowMTradutor.i18n.formBuscar());
		
		this.actionBuscar.addClickHandler(new ClickHandler() {
 
			public void onClick(ClickEvent event) {

				if ( actionDelete != null ){
		        	actionDelete.setDisabled(true);
		        	actionDelete.setTitle(HowMTradutor.i18n.formDelete());	        			
				}
		        
				if ( actionEditar != null )
		        	actionEditar.setDisabled(true);

				if ( onIsCreateActionNovoSubNo() )
					actionNovoSubNo.setDisabled(true);

				if( getParentHowMControlFormLoad() != null )
					getParentHowMControlFormLoad().onHowMLoad(null);
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
		this.actionEditar = new IButton(HowMTradutor.i18n.formEditar());
		this.actionEditar.addClickHandler(new ClickHandler() {
			
 
			public void onClick(ClickEvent event) {
				actionDescription.setHowMUpdateMode();
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
	

	
	private void delete(){
 
		if( "Desfazer".equals( this.actionDelete.getTitle() )){
			HowMGWTTreeNode node = (HowMGWTTreeNode)this.getTreeGrid().getHowMTreeGrid().getSelectedRecord();
			if( node != null ){			
				getTreeGrid().getHowMPropertyFieldOperation().setHowMValue(node, "icon_operation_result");
				node.getHowMFormBean().setSQLOperacaoDelete();
				getTreeGrid().getHowMTreeGrid().redraw();
				this.actionDelete.setTitle(HowMTradutor.i18n.formDelete());
				return;
			} 
		}
		else{
			SC.ask("Confirma a exclusão do registro ?", new BooleanCallback(){
				public void execute(Boolean value) {
					if ( value.booleanValue() ){
						actionDescription.setHowMDeleteMode();
						onClickSave();
	 				}
				}
			});
		}		
	}

	/**
	 * @return the operacaoRegistro
	 */
	public int isOperacaoRegistro() {
		return operacaoRegistro;
	}

	/**
	 * @param operacaoRegistro the operacaoRegistro to set
	 */
	public void setOperacaoRegistro(int operacaoRegistro) {
		this.operacaoRegistro = operacaoRegistro;
	}


	public boolean isInsert(){
		return this.operacaoRegistro == HowMGWTUtilities.OPERATION_INSERT;
	}
	
	public boolean isEdited(){
		return this.operacaoRegistro == HowMGWTUtilities.OPERATION_UPDATE;
	}
	
	public boolean onIsCreateActionNovoNo(){
		return true;
	}
	
	public boolean onIsCreateActionNovoSubNo(){
		return true;
	}

	public boolean onIsCreateActionSave(){
		return true;
	}

	/**
	 * @return the actionInsertSubItem
	 */
	public boolean isActionInsertSubItem() {
		return actionInsertSubItem;
	}

	/**
	 * @param actionInsertSubItem the actionInsertSubItem to set
	 */
	public void setActionInsertSubItem(boolean actionInsertSubItem) {
		this.actionInsertSubItem = actionInsertSubItem;
	}

	/**
	 * @return the parentHowMControlFormSave
	 */
	public HowMGWTControlFormSave getParentHowMControlFormSave() {
		return parentHowMControlFormSave;
	}

	/**
	 * @param parentHowMControlFormSave the parentHowMControlFormSave to set
	 */
	public void setParentHowMControlFormSave(HowMGWTControlFormSave parentHowMControlFormSave) {
		this.parentHowMControlFormSave = parentHowMControlFormSave;
	}

	public void onClickSave(){
		if ( getParentHowMControlFormSave() != null ){
			
			if ( getParentHowMControlFormSave().onHowMFormBeforeSave(actionDescription) ){
				if( actionDescription.isHowMError() && HowMGWTUtilities.isEmpty( actionDescription.getHowMMessageError() ) ){
					SC.say(actionDescription.getHowMMessageError());
					return;
				}
				
				if ( ! getTreeGrid().isHowMClientMode() ){
					if( HowMGWTUtilities.isEmpty( actionDescription.getHowMAction() ) ){
						SC.say("Informe o nome do módulo que será executado no servidor...");
						return;								
					}							
				}
				if( HowMGWTUtilities.isEmpty( actionDescription.getHowMPropertyName() ) ){
					SC.say("Informe o nome da propriedade que será atribuido os dados do formulório ...");
					return;								
				}							
				
				if( actionDescription.getHowMFormBean() == null  ){
					SC.say("Informe o objeto formBean que será submetido para o servidor  ...");
					return;								
				}
				
				if( actionDescription.isHowMDeleteMode() ){
					HowMGWTTreeNode node = getTreeGrid().getHowMCurrentTreeNode();
					TreeNode[] nodes = getTreeGrid().getHowMTreeGrid().getTree().getChildren(node);
					if( nodes != null && nodes.length > 0 ){
						SC.say("Registro possui dependêntes, não pode ser excluído.");
						return;														
					}
				}
				
			}
			
			HowMGWTFormBean formBean = (HowMGWTFormBean)actionDescription.getHowMFormBean().getObject(actionDescription.getHowMPropertyName());
			convertFormToFormBean(formBean);
		}

		if ( actionDescription.isHowMDeleteMode() )
			onInternalSave();			
		else{
//			// Se a grid estiver em modo de edição 
//			// não executa a pre validação.
//			if( formControl.getHowMProperties().isHowMManagerModeOperation() ){
//				onInternalSave();
//			}
//			else{
//				if ( preFormValidate() ){
//					onInternalSave();			
//				}
//			}
		}
	}
	
	
	/**
	 * Popula os dados do bean a partir do conteúdo do formulório de edição.
	 * @param returnBeanData
	 * @return
	 */
	public void populeHowMFormBeanFromForm(HowMGWTFormBean pupuleBeanData){
		convertFormToFormBean(pupuleBeanData);
	}
	
	
	/**
	 * Grava os dados do formulório no servidor.
	 */
	public void onInternalSave(){
		if ( getParentHowMControlFormSave() != null ){
	
			// --------------------------------------------------------------------------------
			// Executa a ação localmente.
			// --------------------------------------------------------------------------------
			if( this.treeGrid.isHowMClientMode() )
				saveClient();
			// --------------------------------------------------------------------------------
			else
				saveServer();
		}
	}

	/**
	 * Grava localmente os dados na grid associada ao gerenciador de manutenção.
	 */
	public void saveClient(){
		this.getActionGravar().setDisabled(true);
		
		if( ! getParentHowMControlFormSave().onHowMFormSave(actionDescription) ){
			this.getActionGravar().setDisabled(false);
			return;
		}
		
		
		boolean actionDelete = actionDescription.isHowMDeleteMode();
		
		HowMGWTFormBean bean = (HowMGWTFormBean)actionDescription.getHowMFormBean().getObject(actionDescription.getHowMPropertyName());
		convertFormBeanToForm(bean);

		// Atualiza a árvore com o registro recém inserido.
		if ( actionDescription.isHowMInsertMode() ){

			if ( "rowNum".equalsIgnoreCase(getTreeGrid().getHowMKeyName()) ) {
				bean.setString("rowNum", ""+rowNumGerador );
				rowNumGerador ++;
			}

			HowMGWTTreeNode node = new HowMGWTTreeNode(getTreeGrid(), bean);
			bean.setSQLOperacaoInsert();
			node.setHowMOperation("icon_operation_insert");

			getTreeGrid().getHowMPropertyFieldOperation().setHowMValue(node, "icon_operation_insert");
			
			node.getHowMFormBean().setSQLOperacaoInsert();
			if ( isActionInsertSubItem() ){

				if ( actionDescription.getHowMParentTreeNode() != null ){
					getTreeGrid().getHowMTreeGrid().getTree().add(node, actionDescription.getHowMParentTreeNode());
					getTreeGrid().getHowMTreeGrid().getTree().openFolder(actionDescription.getHowMParentTreeNode());
					getTreeGrid().getHowMTreeGrid().selectRecord(node);
				}
				else{
					getTreeGrid().getHowMTreeGrid().getTree().add(node, getTreeGrid().getHowMCurrentTreeNode());
					getTreeGrid().getHowMTreeGrid().getTree().openFolder(getTreeGrid().getHowMCurrentTreeNode());
					getTreeGrid().getHowMTreeGrid().selectRecord(node);
				}

			}
			else{
				getTreeGrid().getHowMTreeGrid().getTree().add(node, getTreeGrid().getHowMTreeGrid().getTree().getRoot());
				getTreeGrid().getHowMTreeGrid().getTree().openFolder(getTreeGrid().getHowMTreeGrid().getTree().getRoot());
				getTreeGrid().getHowMTreeGrid().selectRecord(node);
			}
			getTreeGrid().getHowMTreeGrid().redraw();
			
			getParentHowMControlFormSave().onHowMFormAfterSave(actionDescription);
			actionDescription.setHowMQueryMode();
			
		}
		// Atualiza a árvore com o registro recém excluído.
		else if ( actionDescription.isHowMDeleteMode() ){		
			
			HowMGWTTreeNode node = getTreeGrid().getHowMCurrentTreeNode();				

			if( getTreeGrid().isHowMCanEdit() && node.getHowMFormBean().isSQLOperacaoInsert() ){
				removeRecord(node);
				if( getTreeGrid().getHowMTreeGrid().getRecordList().getLength() == 0)
					HowMGWTFormToolbarEditTree.this.actionDelete.setDisabled(true);
				else{
					
				}
			}
			else{
				getTreeGrid().getHowMPropertyFieldOperation().setHowMValue(node, "icon_operation_deleted");
				node.getHowMFormBean().setSQLOperacaoDelete();
				getTreeGrid().getHowMTreeGrid().redraw();
				getParentHowMControlFormSave().onHowMFormAfterSave(actionDescription);
				actionDescription.setHowMQueryMode();
				
				if( getTreeGrid().isHowMCanEdit() ){
					HowMGWTFormToolbarEditTree.this.actionDelete.setTitle("Desfazer");
				}
			}
		}
		// Atualiza a árvore com o registro recém alterado.
		else{
			
			HowMGWTTreeNode node = getTreeGrid().getHowMCurrentTreeNode();
			node.getHowMFormBean().setSQLOperacaoUpdate();
			if( node == null ){
				if ( getTreeGrid().getHowMTreeGrid().getRecordList().getLength() > 0 ){
					this.getTreeGrid().getHowMTreeGrid().selectRecord(0);
					node = getTreeGrid().getHowMCurrentTreeNode();
				}
			}
			node.refreshHowMGWTTreeNode(formControl.getHowMProperties(), bean);

			if( ! HowMGWTUtilities.isEquals("icon_operation_insert",node.getHowMOperation() ) ){
				getTreeGrid().getHowMPropertyFieldOperation().setHowMValue(node, "icon_operation_edited");
				node.getHowMFormBean().setSQLOperacaoUpdate();
			}
			else{
				getTreeGrid().getHowMPropertyFieldOperation().setHowMValue(node, "icon_operation_insert");
				node.getHowMFormBean().setSQLOperacaoInsert();
				actionNovoNo.setIcon("actions/accept.png");
			}
			getTreeGrid().getHowMTreeGrid().redraw();

			getParentHowMControlFormSave().onHowMFormAfterSave(actionDescription);
			actionDescription.setHowMQueryMode();						
		}
	
		actionDescription.setHowMParentTreeNode(null);

		getActionGravar().setDisabled(false);
	}
	
	/**
	 * Envia os dados para o servidor e grava no banco de dados.
	 */
	public void saveServer(){
		
		this.getActionGravar().setDisabled(true);
		
		if( ! getParentHowMControlFormSave().onHowMFormSave(actionDescription) ){
			this.getActionGravar().setDisabled(false);
			return;
		}

		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(actionDescription.getHowMFormBean()){
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( formBean.isError(true) ){
					actionDescription.setHowMParentTreeNode(null);
					getActionGravar().setDisabled(false);
					return;
				}
				
				
				// Seta o formBean atualizado de volta para o actionDescription.
				actionDescription.setHowMFormBean(formBean);

				boolean actionDelete = actionDescription.isHowMDeleteMode();
				
				HowMGWTFormBean bean = (HowMGWTFormBean)formBean.getObject(actionDescription.getHowMPropertyName());
				convertFormBeanToForm(bean);

				insertModeTempWork = false;

				lastActionDescription = new HowMGWTActionDescription();
				lastActionDescription.setHowMFormBean(actionDescription.getHowMFormBean());				
				
				// Atualiza a árvore com o registro recém inserido.
				if ( actionDescription.isHowMInsertMode() ){
					insertModeTempWork = true;
					HowMGWTTreeNode node = new HowMGWTTreeNode(getTreeGrid(), bean);
					if ( isActionInsertSubItem() ){
						if ( actionDescription.getHowMParentTreeNode() != null ){
							
							getTreeGrid().getHowMTreeGrid().getTree().add(node, actionDescription.getHowMParentTreeNode());
							getTreeGrid().getHowMTreeGrid().getTree().openFolder(actionDescription.getHowMParentTreeNode());									
							
							getTreeGrid().getHowMTreeGrid().deselectAllRecords();
							getTreeGrid().getHowMTreeGrid().selectRecord(node);
						}
						else{
							getTreeGrid().getHowMTreeGrid().getTree().add(node, getTreeGrid().getHowMCurrentTreeNode());
							getTreeGrid().getHowMTreeGrid().getTree().openFolder(getTreeGrid().getHowMCurrentTreeNode());
							getTreeGrid().getHowMTreeGrid().deselectAllRecords();
							getTreeGrid().getHowMTreeGrid().selectRecord(node);
						}
					}
					else{
						getTreeGrid().getHowMTreeGrid().getTree().add(node, getTreeGrid().getHowMTreeGrid().getTree().getRoot());
						getTreeGrid().getHowMTreeGrid().getTree().openFolder(getTreeGrid().getHowMTreeGrid().getTree().getRoot());
						getTreeGrid().getHowMTreeGrid().selectRecord(node);
					}
					node.refreshHowMGWTTreeNode(formControl.getHowMProperties(), bean);

					getTreeGrid().getHowMTreeGrid().redraw();
					getParentHowMControlFormSave().onHowMFormAfterSave(actionDescription);
					actionDescription.setHowMQueryMode();						
				}
				// Atualiza a árvore com o registro recém excluído.
				else if ( actionDescription.isHowMDeleteMode() ){							
					HowMGWTTreeNode node = getTreeGrid().getHowMCurrentTreeNode();
					TreeNode parentNode = (TreeNode)getTreeGrid().getHowMTreeGrid().getTree().getParent(node);
					
					getTreeGrid().getHowMTreeGrid().getTree().remove(node);
					getTreeGrid().getHowMTreeGrid().redraw();

					if ( parentNode instanceof HowMGWTTreeNode ){
						getTreeGrid().getHowMTreeGrid().selectRecord(parentNode);
						onHowMConfigureStatus((HowMGWTTreeNode)parentNode);

						getParentHowMControlFormSave().onHowMFormAfterSave(actionDescription);
						actionDescription.setHowMQueryMode();
					}
					else{
						if ( getTreeGrid().getHowMTreeGrid().getRecordList().getLength() > 0 ){
							getTreeGrid().getHowMTreeGrid().selectRecord(0);
							onHowMConfigureStatus((HowMGWTTreeNode)getTreeGrid().getHowMTreeGrid().getSelectedRecord());
						}
						else{
							setActionInsertSubItem(false);
							actionDescription.setHowMInsertMode();
							onHowMConfigureStatusNewRecord();
						}
						getParentHowMControlFormSave().onHowMFormAfterSave(actionDescription);

						actionDescription.setHowMQueryMode();
						HowMGWTWindowWait.hideWait();								
					}
				}
				// Atualiza a árvore com o registro recém alterado.
				else{
					HowMGWTTreeNode node = getTreeGrid().getHowMCurrentTreeNode();
					node.refreshHowMGWTTreeNode(formControl.getHowMProperties(), bean);
					getTreeGrid().getHowMTreeGrid().redraw();

					getParentHowMControlFormSave().onHowMFormAfterSave(actionDescription);
					actionDescription.setHowMQueryMode();						
				}

				HowMGWTWindowWait.hideWait();

				actionDescription.setHowMParentTreeNode(null);

				getActionGravar().setDisabled(false);

				if (actionDescription.isHowMFinishShowMessage()) {
					if( actionDelete ){
						SC.say("Registro excluído com sucesso...");
						onHowMFinishSave();
					}
					else {
						
						if( onHowMFinishSaveMessage() ){
							SC.say("Registro gravado com sucesso...",new BooleanCallback() {
								
								public void execute(Boolean value) {
									if( insertModeTempWork ){
										Timer timer = new Timer() {
											
											@Override
											public void run() {
												onHowMSaveInsertRecord(lastActionDescription);											
												onHowMFinishSave();
											}
										};
										timer.schedule(50);
									}
								}
							});
						}
					}
				}
				
				actionDescription.setActionButtonNode();
			}
		};
		
		String method = "";
		if ( this.actionDescription.isHowMInsertMode() )
			method = "insert";
		else if ( this.actionDescription.isHowMDeleteMode() )
			method = "delete";
		else
			method = "update";
				
		// Executa a carga de dados no servidor.
 		struts.request(
				this.actionDescription.getHowMAction().toLowerCase()+".do?method="+method, 
				this.actionDescription.getHowMAction().toUpperCase()+"Form", 
				this.actionDescription.getHowMFormBean().toSendBody("")
		);				
		
	}

	
	
	/**
	 * Envia os dados da grid para o servidor e grava no banco de dados.
	 * Realiza gravação em lote
	 */
	public void saveServerGrid(){
		
		this.getActionGravar().setDisabled(true);
		
		if( ! getParentHowMControlFormSave().onHowMFormSave(actionDescription) ){
			this.getActionGravar().setDisabled(false);
			return;
		}

		// Recupera o form bean do painel
		getParentHowMControlFormSave().onHowMFormBeforeSave(this.actionDescription);
		// this.actionDescription.setHowMFormBean();

		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(actionDescription.getHowMFormBean()){
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( formBean.isError(true) ){
					actionDescription.setHowMParentTreeNode(null);
					getActionGravar().setDisabled(false);
					return;
				}

				HowMGWTFormBean[] registros = (HowMGWTFormBean[]) formBean.getObject(getTreeGrid().getHowMArrayObjectName());
				if( registros != null ){					
					int rowGrid;
					RecordList recordList = getTreeGrid().getHowMTreeGrid().getRecordList();
					ArrayList<HowMGWTTreeNode> deleteRecords = new ArrayList<HowMGWTTreeNode>();
					for ( HowMGWTFormBean bean : registros){
						rowGrid = HowMGWTUtilities.getInteger(bean.getHowMGridRow());
						HowMGWTTreeNode node = (HowMGWTTreeNode)recordList.get(rowGrid);
						node.refreshHowMGWTTreeNode(formControl.getHowMProperties(), bean);
						if( "3".equalsIgnoreCase(bean.getSqlOperacao() )) 
							deleteRecords.add(node);
						else{
							bean.setSQLOperacaoQuery();
							node.setHowMOperation("icon_operation_result");
							getTreeGrid().getHowMPropertyFieldOperation().setHowMValue(node, "icon_operation_result");
						}
					}
					for( int i = deleteRecords.size()-1 ; i >= 0; i -- ){
						removeRecord(deleteRecords.get(i));
					}
					getTreeGrid().getHowMTreeGrid().redraw();
				}
				actionDescription.setHowMQueryMode();						
				HowMGWTWindowWait.hideWait();
				SC.say("Registros gravado com sucesso...");
				actionDescription.setActionButtonNode();
				
				onHowMFinishSave();
			}
		};
		
		HowMGWTFormBean[] registros =  getHowMDataSave();
		if( registros == null || registros.length == 0 ){
			SC.say("não há registros para serem salvos...");
			
			// Desaloca os recursos alocados pelos registros 
			// selecionados para a gravação.
			this.clearEntitySaveParEntities();			
			return;
		}

		if( ! onHowMCheckMandatory( this.entitySaveParEntities ) ){

			// Desaloca os recursos alocados pelos registros 
			// selecionados para a gravação.
			this.clearEntitySaveParEntities();
			
			SC.say("Erro durante a validação dos dados!<hr>Corrija os erros em destaque e tente novamente...");
			
			return;			
		}
		
		// Verifica os registros estão validos para gravação.
		if( ! onHowMValidateSave(this.entitySaveParEntities) ){
			
			// Desaloca os recursos alocados pelos registros 
			// selecionados para a gravação.
			this.clearEntitySaveParEntities();
			
			SC.say("Erro durante a validação dos dados!<hr>Corrija os erros em destaque e tente novamente...");
			
			return;
		}

		// Desaloca os recursos alocados pelos registros 
		// selecionados para a gravação.		
		this.clearEntitySaveParEntities();
		
		String method = "save";

		this.actionDescription.getHowMFormBean().setObject(getTreeGrid().getHowMArrayObjectName(),registros);

		// Executa a carga de dados no servidor.
//		struts.request(
//				formControl.getHowMProperties().getHowMModule().toLowerCase()+".do?method="+method, 
//				this.actionDescription.getHowMAction().toUpperCase()+"Form", 
//				this.actionDescription.getHowMFormBean().toSendBody("")
//		);				
	}
	


	/**
	 * Dispara os eventos para verificação se os registros da grid estão aptos a 
	 * serem gravados no servidor.
	 */
	public boolean isSaveServerGrid(){
			
		if( ! getParentHowMControlFormSave().onHowMFormSave(actionDescription) ){
			return false;		
		}

		// Recupera o form bean do painel
		getParentHowMControlFormSave().onHowMFormBeforeSave(this.actionDescription);
	
		HowMGWTFormBean[] registros =  getHowMDataSave();
		if( registros == null || registros.length == 0 ){
			// Desaloca os recursos alocados pelos registros 
			// selecionados para a gravação.
			this.clearEntitySaveParEntities();			
			return true;
		}

		if( ! onHowMCheckMandatory( this.entitySaveParEntities ) ){

			// Desaloca os recursos alocados pelos registros 
			// selecionados para a gravação.
			this.clearEntitySaveParEntities();
			
			SC.say("Erro durante a validação dos dados!<hr>Corrija os erros em destaque e tente novamente...");
			
			return false;			
		}
		
		// Verifica os registros estão validos para gravação.
		if( ! onHowMValidateSave(this.entitySaveParEntities) ){
			
			// Desaloca os recursos alocados pelos registros 
			// selecionados para a gravação.
			this.clearEntitySaveParEntities();
			
			SC.say("Erro durante a validação dos dados!<hr>Corrija os erros em destaque e tente novamente...");
			
			return false;
		}

		// Desaloca os recursos alocados pelos registros 
		// selecionados para a gravação.		
		this.clearEntitySaveParEntities();		

		this.actionDescription.getHowMFormBean().setObject(getTreeGrid().getHowMArrayObjectName(),registros);
		return true;
	}
	
	
	/**
	 * @return the parentHowMControlFormLoad
	 */
	public HowMGWTControlFormLoad getParentHowMControlFormLoad() {
		return parentHowMControlFormLoad;
	}

	/**
	 * @param parentHowMControlFormLoad the parentHowMControlFormLoad to set
	 */
	public void setParentHowMControlFormLoad(HowMGWTControlFormLoad parentHowMControlFormLoad) {
		this.parentHowMControlFormLoad = parentHowMControlFormLoad;
	}	
	
	public void onClickActionNovoSubNo(){
		actionDescription.setHowMInsertMode();
		actionDescription.setActionButtonNewSubItem();
		actionInsertSubItem = true;
		actionKeyPressed = true;
		onHowMConfigureStatusNewRecord();
		actionKeyPressed = false;
	}

	public void onHowMAfterLoad(boolean found){

		if ( found ){
			if( this.treeGrid.getHowMTreeGrid().getRecordList().getLength() > 0 ){
				this.treeGrid.getHowMTreeGrid().selectRecord(0);			
				onHowMConfigureStatus((HowMGWTTreeNode)this.treeGrid.getHowMTreeGrid().getRecord(0));
			}
			else{
				onHowMConfigureStatus(null);					
				onHowMConfigureStatusNewRecord();				
			}
		}
		else{
			onHowMConfigureStatus(null);					
			onHowMConfigureStatusNewRecord();
		}
		if( this.treeGrid.isHowMClientMode() ){
			changeSaveIcon("accept.png","Atualizar");
		}
	}
	
	/**
	 * @return Retorna os dados da grid no formato para gravação dos dados.
	 */
	private HowMGWTFormBean[] getHowMDataSave(){

		entitySaveParEntities 				= new ArrayList<HowMPar>();
		ArrayList<HowMGWTFormBean> howMData = new ArrayList<HowMGWTFormBean>();

		RecordList recordList = this.getTreeGrid().getHowMTreeGrid().getRecordList();

		HowMPar par;
		
		for ( int i = 0; i < recordList.getLength() ; i++ ){
			HowMGWTTreeNode node = (HowMGWTTreeNode)recordList.get(i);
			HowMGWTFormBean formTreeNode = node.getHowMFormBean();
			if( formTreeNode.getSqlOperacao() ==  null || "4".equalsIgnoreCase(formTreeNode.getSqlOperacao() )) 
					continue;

			formTreeNode.setHowMGridRow(""+i);
			convertRecordToFormBean(node, node.getHowMFormBean());
			howMData.add(formTreeNode);
			
			
			par = new HowMPar();
			par.setIndex(i);
			par.setFormBean(formTreeNode);
			par.setListGridRecord(node);
			par.setParentListGrid(this.getTreeGrid().getHowMTreeGrid());
			entitySaveParEntities.add(par);
			
		}

		HowMGWTFormBean[] retData = new HowMGWTFormBean[howMData.size()];
		for ( int i = 0; i < retData.length ; i ++ )
			retData[i] = howMData.get(i);

		return retData;
	}	
	
	/**
	 * @return Retorna os dados da lista no formato para gravação dos dados.
	 */
	public HowMGWTFormBean[] getHowMData(){

		HowMGWTFormBean[] howMData = null;

		RecordList recordList = this.getTreeGrid().getHowMTreeGrid().getRecordList();
		howMData = new HowMGWTFormBean[recordList.getLength()];

		int i = 0;
		for ( HowMGWTFormBean form : howMData ){
			HowMGWTTreeNode node = (HowMGWTTreeNode)recordList.get(i);
			HowMGWTFormBean formTreeNode = node.getHowMFormBean();
			if( this.getTreeGrid().isHowMCanEdit() )
				convertRecordToFormBean(node, node.getHowMFormBean());

			howMData[i] = formTreeNode;
			i ++;
		}

		return howMData;
	}

	
	
	/**
	 * @return Retorna os dados da lista no formato para gravação dos dados.
	 */
	public void refreshHowMData(HowMGWTFormBean[] formBeans){

//		HowMGWTFormBean[] howMData = null;
//
//		RecordList recordList = this.getTreeGrid().getHowMTreeGrid().getRecordList();
//		howMData = new HowMGWTFormBean[recordList.getLength()];
//
//		int i = 0;
//		for ( HowMGWTFormBean form : howMData ){
//			HowMGWTTreeNode node = (HowMGWTTreeNode)recordList.get(i);
//			HowMGWTFormBean formTreeNode = node.getHowMFormBean();
//			System.out.println("formTreeNode : "+formTreeNode.getClass().getName());
//			howMData[i] = formTreeNode;
//			i ++;
//		}

	}


	public void changeSaveIcon(String icon, String title){
		try{
			actionGravar.setIcon("actions/"+icon);
			actionGravar.setTitle(title);
		}
		catch(Throwable err){}
	}

	/**
	 * @return the howMCanEdit
	 */
	public boolean isHowMCanEdit() {
		return howMCanEdit;
	}

	/**
	 * @param howMCanEdit the howMCanEdit to set
	 */
	public void setHowMCanEdit(boolean howMCanEdit) {
		this.howMCanEdit = howMCanEdit;
		if( ! this.howMCanEdit && this.actionEditar != null ){
			this.actionEditar.setDisabled(true);
		}
	}

	/**
	 * @return the howMCanNew
	 */
	public boolean isHowMCanNew() {
		return howMCanNew;
	}

	/**
	 * @param howMCanNew the howMCanNew to set
	 */
	public void setHowMCanNew(boolean howMCanNew) {
		this.howMCanNew = howMCanNew;
		if( ! this.howMCanNew ){
			this.actionNovoNo.setDisabled(true);
			this.actionNovoSubNo.setDisabled(true);			
		}
	}

	/**
	 * @return the howMCanDelete
	 */
	public boolean isHowMCanDelete() {
		return howMCanDelete;
	}

	/**
	 * @param howMCanDelete the howMCanDelete to set
	 */
	public void setHowMCanDelete(boolean howMCanDelete) {
		this.howMCanDelete = howMCanDelete;
		if( ! this.howMCanDelete && this.actionDelete != null )
			this.actionDelete.setDisabled(true);
	}
	
	public boolean isHowMCanSave(){
		return this.isHowMCanNew() || this.isHowMCanEdit() ; 
	}
	
	
	public void onHowMSetValuesImpl(ListGridRecord record){

		if( this.getTreeGrid().getHowMPropertyFieldOperation() != null ){
			String operation = this.getTreeGrid().getHowMPropertyFieldOperation().getHowMValue(record);
		
//			if( "icon_operation_insert".equalsIgnoreCase(operation)){
//				if( ! this.isHowMCanNew() )
//					this.formControl.getHowMProperties().setHowMModeOperation(HowMGWTUtilities.OPERATION_NO_ACCESS);
//				else
//					this.formControl.getHowMProperties().setHowMModeOperation(HowMGWTUtilities.OPERATION_INSERT);					
//			}
//			else if( "icon_operation_result".equalsIgnoreCase(operation)){
//				if( ! this.isHowMCanEdit() )
//					this.formControl.getHowMProperties().setHowMModeOperation(HowMGWTUtilities.OPERATION_NO_ACCESS);
//				else
//					this.formControl.getHowMProperties().setHowMModeOperation(HowMGWTUtilities.OPERATION_UPDATE);				
//			}
//			else if( "icon_operation_edited".equalsIgnoreCase(operation)){ 
//				if( ! this.isHowMCanEdit() )
//					this.formControl.getHowMProperties().setHowMModeOperation(HowMGWTUtilities.OPERATION_NO_ACCESS);
//				else
//					this.formControl.getHowMProperties().setHowMModeOperation(HowMGWTUtilities.OPERATION_UPDATE);				
//			}
//			else
//				this.formControl.getHowMProperties().setHowMModeOperation(HowMGWTUtilities.OPERATION_NO_ACCESS);
		}	    
		HowMGWTFormToolbarEditTree.this.formControl.onHowMSetValues(record);
	}
	
    public void onHowMNewRecordImpl(){
//		if( this.getTreeGrid().getHowMPropertyFieldOperation() != null ){
//			this.formControl.getHowMProperties().setHowMModeOperation(this.actionDescription.getHowMOperacao());    	
//		}
		HowMGWTFormToolbarEditTree.this.formControl.onHowMNewRecord();
    }

	/**
	 * @return the actionNovoSubNo
	 */
	public IButton getActionNovoSubNo() {
		return actionNovoSubNo;
	}

	/**
	 * @return the actionNovoNo
	 */
	public IButton getActionNovoNo() {
		return actionNovoNo;
	}

	/**
	 * Evento disparado quando um novo registro é incluído no banco de dados.
	 */
	public void onHowMSaveInsertRecord(HowMGWTActionDescription actionDescription){		
	}

	public boolean onHowMValidateSave(ArrayList<HowMPar> entitySaveParEntities){
		return true;
	}	
	
	
	/**
	 * ----------------------------------------------------------------------------------------
	 * Valida os dados que serão atualizados no servidor.
	 * @param entities
	 * @return
	 * ----------------------------------------------------------------------------------------
	 */
	public boolean onHowMCheckMandatory(ArrayList<HowMPar> entitySaveParEntities){

		ListGridRecord record;

		boolean validate = true;
		
		for( HowMPar par : entitySaveParEntities){

			// Se registro estiver marcado como deletado, então não valida.
			if( par.getFormBean().isSQLOperacaoDelete() )
				continue;

			record 		= par.getListGridRecord();

			String msg = "";
			for ( HowMGWTProperty prop : formControl.getHowMProperties().getProperties() ){
				

				if ( prop.isMandatory() && HowMGWTUtilities.isEmpty(prop.getHowMValue(record))) {
					msg = "#campo é um campo obrigatório !";
					msg = HowMGWTUtilities.replace(msg, "#campo", prop.getTitle());
					validate = par.addMessageError(prop, msg);
				}
				else if ( prop.getHowMGridFieldDateItemEditor() != null && ! HowMGWTUtilities.isEmpty(prop.getHowMValue(par.getListGridRecord()))) {
					Date data = HowMGWTUtilities.getDate(prop.getHowMValue(par.getListGridRecord()));
					if ( data == null ){
						validate = par.addMessageError(prop, "Data informada não é valida...");
					}
				}			
			}				
		}
	
//
//				if( HowMGWTConstants.MASK_CNPJ.equals(prop.getHowMMask()) ){
//					if ( ! HowMGWTUtilities.isEmpty( prop.getHowMValue() ) ){
//						boolean valid = HowMGWTUtilities.verifyCNPJ(prop.getHowMValue());
//						if( ! valid ){
//							errors += "Valor informado para o Campo <strong><font color=red>" + prop.getLabel() + "</font> não é válido...";
//						}
//					}
//				}
//				
//				if( HowMGWTConstants.MASK_CPF.equals(prop.getHowMMask()) ){
//					if ( ! HowMGWTUtilities.isEmpty( prop.getHowMValue() ) ){
//						boolean valid = HowMGWTUtilities.verifyCPF(prop.getHowMValue());
//						if( ! valid ){
//							errors += "Valor informado para o Campo <strong><font color=red>" + prop.getLabel() + "</font> não é válido...";
//						}
//					}
//				}
		return validate;
	}
	
	
	private void clearEntitySaveParEntities(){
		if( this.entitySaveParEntities == null )
			return;
		
		for( HowMPar par : this.entitySaveParEntities )
			par.clear();
		
		this.entitySaveParEntities.clear();
		this.entitySaveParEntities = null;

	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Dispara uma inclusão de um novo nó dentro de uma grid de edição 
	 */
	public void onHowMClickNewActionNovoNo(){
		actionDescription.setHowMInsertMode();
		if( getTreeGrid().isHowMClientMode() ){
			changeSaveIcon("add.png", "Incluir");
		}
		actionDescription.setActionButtonNewItem();
		actionInsertSubItem = false;
		actionKeyPressed = true;
		onHowMConfigureStatusNewRecord();
		actionKeyPressed = false;
	}
	
	
	protected void onHowMFinishSave(){}
	
	
	
	public boolean onHowMFinishSaveMessage(){
		return true;
	}
}