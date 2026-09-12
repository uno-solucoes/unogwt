package com.br.client.panel.cd.cdq0101.UI;

import java.util.ArrayList;
import java.util.TreeMap;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.Services;
import com.br.client.panel.vd.vdp0001.model.RecordRelacaoVendas;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
 
public class ResultadoConsulta extends HowMGWTListGrid {
 
	private ListGridField fieldCodigo	= new ListGridField("codigo", 		Tradutor.i18n.formCodigoCliente(), 	 80);	
	private ListGridField nomeCliente	= new ListGridField("nomeCliente", 	Tradutor.i18n.formNomeCliente(), 	200);
	private ListGridField cnpj			= new ListGridField("cnpj", 		Tradutor.i18n.formCnpj(), 			110);		
	private ListGridField cidade		= new ListGridField("cidade",		Tradutor.i18n.formCidade(),			180);
	private ListGridField situacao		= new ListGridField("situacao", 	Tradutor.i18n.formSituacao(), 		 80);
	private ListGridField selecionar	= new ListGridField("selecionar", 	Tradutor.i18n.formSelecionar(), 	 70);
 	
	public ResultadoConsulta(){
 
		initUI();
		onHowMInitEntityControl();
	}

	public void initUI(){
		
		this.setDataPageSize(1000);
		this.setShowAllRecords(false);
		this.setFields(
				fieldCodigo,
				nomeCliente,
				cnpj,	
				cidade,
				situacao,
				selecionar				
		);
		
		this.setCanResizeFields(true);   
		this.setHeaderHeight(25);
		// this.setShowAllRecords(true); 

	 
        this.addRecordClickHandler(new RecordClickHandler(){  
            public void onRecordClick(RecordClickEvent event) {  
                Record record = event.getRecord();  
                System.out.println("Selecionou : "+record);
            }  
        });		
		
	}
 
	/**
	 * Permite criar componentes para representar ações dentro da grid.
	 */
	@Override
	protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) {
		String fieldName = this.getFieldName(colNum);
		
		if ( fieldName.equalsIgnoreCase(selecionar.getName())){

			IButton actionSelect = new IButton("");  
			actionSelect.setHeight(18);  
			actionSelect.setWidth(65);                      
			actionSelect.setIcon("actions/ico_editar.gif");  
			actionSelect.addClickHandler(new ClickHandler() {  
	            public void onClick(ClickEvent event) {  
	            	onHowMSelectRecord(record);
	            }  
	        });  
			return actionSelect;  			
		}
		return super.createRecordComponent(record, colNum);
	}
	
	/**
	 * Permite Rendererizar dados da grid.
	 */
    @Override  
    protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {  
//        if ( // Azul
//    		getFieldName(colNum).equals("valorCotacoesEnviadasPorEmailDia") 
//        )   
//        	return "color:blue;";  
        return super.getCellCSSText(record, rowNum, colNum);  
    }

	/**
	 * @return the fieldCodigo
	 */
	public ListGridField getFieldCodigo() {
		return fieldCodigo;
	}

	/**
	 * @param fieldCodigo the fieldCodigo to set
	 */
	public void setFieldCodigo(ListGridField fieldCodigo) {
		this.fieldCodigo = fieldCodigo;
	}

	/**
	 * @return the nomeCliente
	 */
	public ListGridField getNomeCliente() {
		return nomeCliente;
	}

	/**
	 * @param nomeCliente the nomeCliente to set
	 */
	public void setNomeCliente(ListGridField nomeCliente) {
		this.nomeCliente = nomeCliente;
	}  

}
