package com.howmake.client.form.UI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.br.client.configuracao.Fabrica;
import com.howmake.client.form.model.HowMGWTDataRecord;
import com.howmake.client.form.partner.HowMGWTSelectPartner;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellSavedEvent;
import com.smartgwt.client.widgets.grid.events.CellSavedHandler;
import com.smartgwt.client.widgets.layout.HLayout;



public class HowMGWTListGrid extends ListGrid{
 
	private Record lastAddRecord;
	
	private ListGridField fieldFlagMode;

	private HowMGWTSelectPartner selectPartner;
	private boolean HowMMEditControl= false;
	private boolean HowMNotifyChangeRecord=false;
	
	private HowMGWTEntity currentEntity;
	
	private Map<String, Integer> headerPositions = new HashMap<String,Integer>();
	private ArrayList<ListGridField> headerFields = new ArrayList<ListGridField>();
	private Map<String , ListGridField> howMGWTFields = new HashMap<String, ListGridField>();
	
	public HowMGWTListGrid(){
		// this.setShowAllRecords(true);
	     this.setShowAllColumns(true);

	}
 
	
	/**
	 * @return the headerPositions
	 */
	public Map<String, Integer> getHeaderPositions() {
		return headerPositions;
	}
	/**
	 * @param headerPositions the headerPositions to set
	 */
	public void setHeaderPositions(TreeMap<String, Integer> headerPositions) {
		this.headerPositions = headerPositions;
	}
	/**
	 * @return the headerFields
	 */
	public ArrayList<ListGridField> getHeaderFields() {
		return headerFields;
	}
	/**
	 * @param headerFields the headerFields to set
	 */
	public void setHeaderFields(ArrayList<ListGridField> headerFields) {
		this.headerFields = headerFields;
	}
	
	public void onHowMInitEntityControl(){
		for( int i = 0 ; i < this.getFields().length ; i ++){
			this.headerPositions.put(this.getFields()[i].getName(), new Integer(i));
			this.headerFields.add(this.getFields()[i]);
		};
	}
	
	public void onHowMInitHeader(){
		
		for( int i = 0 ; i < this.getFields().length ; i ++){
			HowMProperty header = new HowMProperty();
			header.setTitle(this.getFields()[i].getName());
			this.getCurrentEntity().getHeaders().add(header);
		};		
	}
	
    
	
    public void onHowMSelectRecord(Record record){
    	if ( this.getSelectPartner() != null )
    		this.getSelectPartner().onHowMSelectRecord(record);
    }	
	
	/**
	 * @return the currentEntity
	 */
	public HowMGWTEntity getCurrentEntity() {
		if ( this.currentEntity == null )
			this.currentEntity = Fabrica.createEntity();
		return currentEntity;
	}
	/**
	 * @param currentEntity the currentEntity to set
	 */
	public void setCurrentEntity(HowMGWTEntity currentEntity) {
		this.currentEntity = currentEntity;
	}
	/**
	 * @return the selectPartner
	 */
	public HowMGWTSelectPartner getSelectPartner() {
		return selectPartner;
	}
	/**
	 * @param selectPartner the selectPartner to set
	 */
	public void setSelectPartner(HowMGWTSelectPartner selectPartner) {
		this.selectPartner = selectPartner;
	}
	
	/**
	 * Retorna o valor do registro a partir de um array de colunas.
	 * @param row
	 * @param fieldName
	 * @return
	 */
	public String getFieldValue(String[] row, String fieldName){
		return row[this.getHeaderPositions().get(fieldName).intValue()];
	}
	
	public String getFieldValue(ListGridRecord record, String fieldName){
		return record.getAttribute(fieldName);
	}
	
	
	public void clearAllRecords(){		
		this.setRecords(new ListGridRecord[0]);
	}
	
	
	@Override
	public void setFields(ListGridField... fields) {
		
		// Se controle de edição habilitado, inclui flag de controle de edição.
		if ( this.isHowMMEditControl() ){
			
			this.fieldFlagMode = new ListGridField("HowMFieldMode", " ", 20);
			ArrayList<ListGridField> aFields = new ArrayList<ListGridField>();
			aFields.add(this.fieldFlagMode);
			
			for ( ListGridField oField : fields){
				aFields.add(oField);
			}

			fields = new ListGridField[aFields.size()];

			// Adiciona um listener para detectar quando 
			// um dado em uma determinada celula é alterada
			this.addCellSavedHandler(new CellSavedHandler() {
				
				@Override
				public void onCellSaved(CellSavedEvent event) {
					if( event.getRecord() != null ){
						Record record = HowMGWTListGrid.this.getRecord(event.getRowNum());
						if( record != null && isRecordModeQuery( record )){
							setRecordModeUpdate( record );
							
							ImgButton button = (ImgButton)record.getAttributeAsObject("HowMFlagIcon");
							if ( button != null ){
								button.setSrc("actions/ico_edited.gif");
							}
						}						
					}	 
				}
			});
				
			int i = 0 ;
			for ( ListGridField oField : aFields){
				fields[i] = oField;
				i ++;
			}
		}
		else if ( HowMNotifyChangeRecord ){
			this.addCellSavedHandler(new CellSavedHandler() {
				
				@Override
				public void onCellSaved(CellSavedEvent event) {
					if( event.getRecord() != null ){
						Record record = HowMGWTListGrid.this.getRecord(event.getRowNum());
						if( record != null )
							onHowMNotifyChanged(event, record);
					}	 
				}
			});			
		}
		
		for ( ListGridField field : fields){
			howMGWTFields.put(field.getName(), field);
		}
		super.setFields(fields);
	}
	
	public void onEventHowMGWTAfterQuery(Record record){}

	/**
	 * @return the howMGWTFields
	 */
	public Map<String, ListGridField> getHowMGWTFields() {
		return howMGWTFields;
	}

	/**
	 * @param howMGWTFields the howMGWTFields to set
	 */
	public void setHowMGWTFields(Map<String, ListGridField> howMGWTFields) {
		this.howMGWTFields = howMGWTFields;
	}
	
	/**
	 * Método de conveniencia para detectar a leitura dos dados do banco de dados.
	 * @param record
	 */
	public void onHowMLoadDatabaseRecord(Record record){}
	public void onHowMStartLoadDatabaseRecord(){}	
	public void onHowMFinishLoadDatabaseRecord(){}
	public void onHowMFinishLoadDatabaseRecord(HowMGWTDataRecord currentRecord, int records){}
	public boolean onHowMCustomFinishLoader(ListGridRecord[] records){
		return false;
	}
	

	
	
	
	
	
	
	
	// ----------------------------------------------------------------------------------
	// Controle de edição da grid
	// ----------------------------------------------------------------------------------	
	private static String HOWM_RECORD_MODE 			= "HowMMode";
	private static String HOWM_INSERT_MODE_CAN_EDIT = "HowMIMCanEdit";
	private static String HOWM_UPDATE_MODE_CAN_EDIT = "HowMUMEdit";
	
	public static int HOWM_RECORD_INSERT   		= 1;
	public static int HOWM_RECORD_UPDATE   		= 2;
	public static int HOWM_RECORD_DELETE   		= 3;
	public static int HOWM_RECORD_QUERY    		= 4;
	

	public void setRecordMode(Record record, int mode){
		record.setAttribute(HOWM_RECORD_MODE ,  mode );
	}
	
	public int getRecordMode(Record record){
		if ( record.getAttribute(HOWM_RECORD_MODE) == null )
			return -1;
		return record.getAttributeAsInt(HOWM_RECORD_MODE);
	}

	
	public void setRecordModeInsert(Record record){
		this.setRecordMode(record, HOWM_RECORD_INSERT);
	}

	public void setRecordModeUpdate(Record record){
		this.setRecordMode(record, HOWM_RECORD_UPDATE);
	}

	public void setRecordModeDelete(Record record){
		this.setRecordMode(record, HOWM_RECORD_DELETE);
	}

	public void setRecordModeQuery(Record record){
		this.setRecordMode(record, HOWM_RECORD_QUERY);
	}
	

	public boolean isRecordModeInsert(Record record){
		return this.getRecordMode(record) == HOWM_RECORD_INSERT;
	}

	public boolean isRecordModeUpdate(Record record){
		return this.getRecordMode(record) == HOWM_RECORD_UPDATE;
	}

	public boolean isRecordModeDelete(Record record){
		return this.getRecordMode(record) == HOWM_RECORD_DELETE;
	}

	public boolean isRecordModeQuery(Record record){
		return this.getRecordMode(record) == HOWM_RECORD_QUERY;
	}
	
	
	
	
	/**
	 * Permite indicar que uma determinada celula em um determinado registro podera ou não ser editado.
	 * @param record
	 * @param fieldName
	 * @param canEdited
	 */
	public void setCellCanEditInsertMode(Record record, String fieldName, boolean canEdited){
		record.setAttribute(fieldName+HOWM_INSERT_MODE_CAN_EDIT, canEdited);
	}
	
	
	/**
	 * Retorna true caso a celula podera ser editada.
	 * @param record
	 * @param fieldName
	 * @return
	 */
	public boolean isCellCanEditInsertMode(Record record, String fieldName){
		if ( record.getAttribute(fieldName+HOWM_INSERT_MODE_CAN_EDIT) == null)  
			return false;
		return this.isRecordModeInsert(record) && record.getAttributeAsBoolean(fieldName+HOWM_INSERT_MODE_CAN_EDIT).booleanValue();
	}

	
	/**
	 * Permite indicar que uma determinada celula em um determinado registro podera ou não ser editado.
	 * @param record
	 * @param fieldName
	 * @param canEdited
	 */
	public void setCellCanEditUpdateMode(Record record, String fieldName, boolean canEdited){
		record.setAttribute(fieldName+HOWM_UPDATE_MODE_CAN_EDIT, canEdited);
	}
	
	
	/**
	 * Retorna true caso a celula podera ser editada.
	 * @param record
	 * @param fieldName
	 * @return
	 */
	public boolean isCellCanEditUpdateMode(Record record, String fieldName){
		if ( record.getAttribute(fieldName+HOWM_UPDATE_MODE_CAN_EDIT) == null)  
			return false;
		return this.isRecordModeQuery(record)  && record.getAttributeAsBoolean(fieldName+HOWM_UPDATE_MODE_CAN_EDIT).booleanValue()
			   || 
			   this.isRecordModeUpdate(record) && record.getAttributeAsBoolean(fieldName+HOWM_UPDATE_MODE_CAN_EDIT).booleanValue();
	}
 	
	/**
	 * Verifica se deverá ser controlado a edição das celulas dos registros da grid.
	 */
	@Override
	public boolean canEditCell(int rowNum, int colNum) {
		
		if ( ! this.getField(colNum).getCanEdit() )
			return false;
		
		// Se modo controle desligado retorna status da  super classe.
		if ( ! this.isHowMMEditControl() )
			return super.canEditCell(rowNum, colNum );
		
		// Se celula sem privilegio para edição retorna false.
		if ( !super.canEditCell(rowNum, colNum ) )
			return false;
			
		// Avalia a configuração do modo controle para edição.
		String fieldName = this.getFieldName(colNum);
		Record record 	 = this.getRecord(rowNum);
		// Ocorre quando é utilizado o modo startEditInsert da grid.
		if ( record == null )
			record = lastAddRecord;
			
		if ( this.isCellCanEditInsertMode(record, fieldName))
			return true;
		
		if ( this.isCellCanEditUpdateMode(record,fieldName))
			return true;
		
		return false;
	}

	/**
	 * @return the howMMEditControl
	 */
	public boolean isHowMMEditControl() {
		return HowMMEditControl;
	}

	/**
	 * @param howMMEditControl the howMMEditControl to set
	 */
	public void setHowMMEditControl(boolean howMMEditControl) {
		HowMMEditControl = howMMEditControl;
	}

	/**
	 * @return the fieldFlagMode
	 */
	public ListGridField getFieldFlagMode() {
		return fieldFlagMode;
	}

	/**
	 * @param fieldFlagMode the fieldFlagMode to set
	 */
	public void setFieldFlagMode(ListGridField fieldFlagMode) {
		this.fieldFlagMode = fieldFlagMode;
	}
	
	
	
	
    protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) {  

        String fieldName = this.getFieldName(colNum);

        if (  this.fieldFlagMode != null && fieldName.equalsIgnoreCase(this.fieldFlagMode.getName())) {  
        	String flagName = "";
        	if ( this.isRecordModeInsert(record))
        		flagName = "actions/editedNew.gif";
        	else if ( this.isRecordModeUpdate( record) )
        		flagName = "actions/ico_edited.gif";
        	else if ( this.isRecordModeDelete( record ))
        		flagName = "actions/og_delete.gif";
        	else if ( this.isRecordModeQuery( record ))
        		flagName = "actions/transparence.png";

           	HLayout recordCanvas = new HLayout(1); 
           	recordCanvas.setWidth100();
            recordCanvas.setHeight(22);  
            recordCanvas.setAlign(Alignment.CENTER);

            ImgButton actionFlag = new ImgButton();  
            actionFlag.setShowDown(false);  
            actionFlag.setShowRollOver(false);  
            actionFlag.setLayoutAlign(Alignment.CENTER);  
            actionFlag.setSrc(flagName);  
            actionFlag.setPrompt("");  
            actionFlag.setHeight(16);  
            actionFlag.setWidth(16);  
            recordCanvas.addMember(actionFlag);
            record.setAttribute("HowMFlagIcon", actionFlag);
            return recordCanvas;
        }

        return null;
    }
    
    public Record addNewRecord(	Record record ){
		this.setRecordModeInsert(record);
		this.lastAddRecord = record;
		this.selectRecord(record);
		this.startEditingNew(record);
		return record;
    }
    
    public void howMRestartRecordFlag(int mode){
    	ListGridRecord []records = this.getRecords();
    	for ( ListGridRecord record : records ){
    		
    		this.setRecordMode(record, mode );
    		
    		ImgButton button = (ImgButton)record.getAttributeAsObject("HowMFlagIcon");
			if ( button != null ){

				if ( this.isRecordModeInsert(record))
	        		button.setSrc("actions/editedNew.gif");
	        	else if ( this.isRecordModeUpdate( record) )
	        		button.setSrc("actions/ico_edited.gif");
	        	else if ( this.isRecordModeDelete( record ))
	        		button.setSrc("actions/og_delete.gif");
	        	else if ( this.isRecordModeQuery( record ))
	        		button.setSrc("actions/transparence.png");
			}
    	}
    }

	/**
	 * @return the howMNotifyChangeRecord
	 */
	public boolean isHowMNotifyChangeRecord() {
		return HowMNotifyChangeRecord;
	}

	/**
	 * @param howMNotifyChangeRecord the howMNotifyChangeRecord to set
	 */
	public void setHowMNotifyChangeRecord(boolean howMNotifyChangeRecord) {
		HowMNotifyChangeRecord = howMNotifyChangeRecord;
	}
	
	public void onHowMNotifyChanged(CellSavedEvent event , Record record){
		
	}
}