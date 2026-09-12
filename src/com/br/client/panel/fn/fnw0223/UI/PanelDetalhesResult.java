package com.br.client.panel.fn.fnw0223.UI;



import java.util.Date;
import java.util.TreeMap;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.fn.fnw0223.model.EPlanoContas;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.UI.HowMGWTWindowDocument;
import com.howmake.client.form.model.HOWMGWTDataSourceQuery;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.GroupStartOpen;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SummaryFunctionType;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.tree.TreeGridField;

public class PanelDetalhesResult extends HowMGWTListGrid{

	
	private PainelDetalhesTitulo detalhesTitulo;	
	
	TreeMap<String, EPlanoContas> planoContas;

	private TreeGridField fieldSequencia 				= new TreeGridField( "Sequencia" 			, Tradutor.i18n.formSequencia() 			,  70);
	private TreeGridField fieldMesRef    				= new TreeGridField( "MesRef" 				, Tradutor.i18n.formMesRef()     			,  60);
	private TreeGridField fieldTipoConta 				= new TreeGridField( "TipoConta" 			, Tradutor.i18n.formTipoConta() 			,  60);
	private TreeGridField fieldConta 					= new TreeGridField( "Conta" 				, Tradutor.i18n.formConta() 				,  200);
	private TreeGridField fieldData 					= new TreeGridField( "Data" 				, "Data" 									,  70);
	private TreeGridField fieldParcela   				= new TreeGridField( "Parcela" 				, Tradutor.i18n.formParcela() 				,  70);
	private TreeGridField fieldCodTitulo 				= new TreeGridField( "CodTitulo"	 		, Tradutor.i18n.formCodTitulo() 			,  70);
	private TreeGridField fieldValor 					= new TreeGridField( "Valor" 				, Tradutor.i18n.formValor() 				, 100);
 	

	private TreeGridField fieldPessoa 					= new TreeGridField( "Pessoa" 				, " " 			, 100);
	private TreeGridField fieldChave 					= new TreeGridField( "Chave" 				, " " 			, 100);

	
	public PanelDetalhesResult(){
		initUI();
		onHowMInitEntityControl();
	}

	public void initUI(){
		
		// this.setDataPageSize(60);
		this.setShowAllRecords(false);

		CellFormatter formatterDouble = new CellFormatter() {
	        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
	            if(value == null) return null;
	            try{
	            	return " "+NumberFormat.getFormat("###,###,###,###,###,###,###.00").format(new Double(value.toString()));
	            }
	            catch(Throwable er){
	            	return " "+value.toString();
	            }
	        }
		};  
	
		
		formatterDouble = new CellFormatter() {
	        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
	            if(value == null) return null;
	            try{
	            	return NumberFormat.getFormat("###,###,###,###,###,###,##0.00").format(new Double(value.toString()));
	            }
	            catch(Throwable er){
	            	return NumberFormat.getFormat("###,###,###,###,###,###,##0.00").format(0.0);
	            }
	        }
		};		
		fieldValor.setType(ListGridFieldType.FLOAT);
		fieldValor.setAlign(Alignment.RIGHT);
		fieldValor.setCellFormatter(formatterDouble);
		
		fieldData.setType(ListGridFieldType.DATE);
		formatterDouble = new CellFormatter() {
	        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
	            if(value == null) return null;
	            try{
	            	return DateTimeFormat.getFormat("dd/MM/yyyy").format((Date)value);
	            }
	            catch(Throwable er){
	            	return "Erro data";
	            }
	        }
		};
		fieldData.setCellFormatter(formatterDouble);
		
		 fieldValor.setSummaryFunction(SummaryFunctionType.SUM);
 	
		 fieldValor.setShowGridSummary(true); 
		 fieldValor.setShowGroupSummary(false);
		
		 fieldConta.setShowGroupSummary(false);


		this.setGroupStartOpen(GroupStartOpen.ALL);   
        this.setShowGridSummary(true);  
        this.setShowGroupSummary(true);  		
 
        
        this.setGroupByField(fieldConta.getName(),fieldTipoConta.getName(),fieldSequencia.getName(), fieldMesRef.getName());  

		this.setFields(
				fieldSequencia,
				fieldMesRef,
				fieldTipoConta,
				fieldConta,
				fieldData,
				fieldCodTitulo,
				fieldParcela,
				fieldPessoa ,
				fieldChave ,				
				fieldValor 
		);	
        
		onHowMInitHeader();
		onHowMInitEntityControl();
		
		for( int i = 0 ; i < this.getFields().length ; i ++){
			this.getFields()[i].setWrap(true);
		}
 	
		this.setCanResizeFields(true);   
		this.setHeaderHeight(40); 
 
	 
		fieldSequencia.setHidden(true);
		fieldMesRef.setHidden(true);
		fieldTipoConta.setHidden(true);
		fieldConta.setHidden(true);
		fieldPessoa.setHidden(true);
		fieldChave.setHidden(true);
		
		this.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {				 
				if ( event.getKeyName() != null ){
					if ( event.isCtrlKeyDown() && "J".equals(event.getKeyName())){
						HowMGWTWindowDocument.showDocument(HOWMGWTDataSourceQuery.LAST_SQL);
						event.cancel();
					}
				}
			}
		});
		
		this.addRecordClickHandler(new RecordClickHandler() {
			
			@Override
			public void onRecordClick(RecordClickEvent event) {
				detalhesTitulo.showDetalhes(
					event.getRecord().getAttribute(fieldCodTitulo.getName()),
					event.getRecord().getAttribute(fieldParcela.getName()),
					event.getRecord().getAttribute(fieldTipoConta.getName()),
					event.getRecord().getAttribute(fieldPessoa.getName()),
					event.getRecord().getAttribute(fieldChave.getName())
				);
			}
		});		
	}
	
	@Override
	public void onHowMLoadDatabaseRecord(Record record) {
		super.onHowMLoadDatabaseRecord(record);

		String key = record.getAttribute(fieldConta.getName());
        EPlanoContas conta = getPlanoContas().get(key);
        if ( conta != null )
        	record.setAttribute(fieldConta.getName(), conta.getAttribute("DescricaoConta"));
        
        if ( "1".equals(record.getAttribute(fieldSequencia.getName())))
        	record.setAttribute(fieldSequencia.getName(), Tradutor.i18n.formGrupo01());
        if ( "2".equals(record.getAttribute(fieldSequencia.getName())))
        	record.setAttribute(fieldSequencia.getName(), Tradutor.i18n.formGrupo02());
        if ( "3".equals(record.getAttribute(fieldSequencia.getName())))
        	record.setAttribute(fieldSequencia.getName(), Tradutor.i18n.formGrupo03());
        if ( "4".equals(record.getAttribute(fieldSequencia.getName())))
        	record.setAttribute(fieldSequencia.getName(), Tradutor.i18n.formGrupo04());

        String mes = HowMGWTUtilities.getRPad(record.getAttribute(fieldMesRef.getName()),"0",2);
        record.setAttribute(fieldMesRef.getName(), HowMGWTUtilities.getMeses().get(mes));

        String tipoConta = HowMGWTUtilities.getRPad(record.getAttribute(fieldTipoConta.getName()),"0",2);
        if ( "10".equals(tipoConta))
        	record.setAttribute(fieldTipoConta.getName(),"Despesa");
        else
        	record.setAttribute(fieldTipoConta.getName(),"Receita");

	}
	
	
	/**
	 * @return the planoContas
	 */
	public TreeMap<String, EPlanoContas> getPlanoContas() {
		return planoContas;
	}

	/**
	 * @param planoContas the planoContas to set
	 */
	public void setPlanoContas(TreeMap<String, EPlanoContas> planoContas) {
		this.planoContas = planoContas;
	}	


	/**
	 * @return the detalhesTitulo
	 */
	public PainelDetalhesTitulo getDetalhesTitulo() {
		return detalhesTitulo;
	}

	/**
	 * @param detalhesTitulo the detalhesTitulo to set
	 */
	public void setDetalhesTitulo(PainelDetalhesTitulo detalhesTitulo) {
		this.detalhesTitulo = detalhesTitulo;
	}	
 
}