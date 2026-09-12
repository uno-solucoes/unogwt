package com.br.client.panel.vd.vdd0030.UI;

import com.br.client.model.vd.entity.ePerformanceVendasDetalhes;
import com.br.client.model.vd.vdw0025.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.NumberFormat;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PainelResultado  extends HowMGWTListGrid{

	private boolean init = false;
	
	private int maskQtde = 2;
	
	public ListGridField fieldCodPedido			= new ListGridField("codPedido", 	    Tradutor.i18n.formPedido(), 	      60);
	public ListGridField fieldCodProduto		= new ListGridField("codProduto", 	    Tradutor.i18n.formCodProduto(),      110);
	public ListGridField fieldDescComercial		= new ListGridField("descComercial", 	Tradutor.i18n.formDescComercial(),   210);
	public ListGridField fieldVendedor		    = new ListGridField("nomeVendedor", 	Tradutor.i18n.formVendedor(),            150);
	public ListGridField fieldFamiliaComercial	= new ListGridField("familiaComercial", Tradutor.i18n.formFimiliaComercial(),110);
	public ListGridField fieldTipoAplicacao		= new ListGridField("tipoAplicacao", 	Tradutor.i18n.formTipoAplicacao(), 	  90);
	public ListGridField fieldQtde				= new ListGridField("qtde", 	    	Tradutor.i18n.formQtde(), 	      	  70);
	public ListGridField fieldPrecoVenda		= new ListGridField("fieldPrecoVenda", 	Tradutor.i18n.formPrecoVenda(), 	  80);
	public ListGridField fieldValorVendido		= new ListGridField("precoTotal", 	    Tradutor.i18n.formValorVendido(), 	 100);
	
	public PainelResultado(){
		 
	}
	
	public void initUI(){
		
		if ( init )
			return;
		
		init = true;
		
		this.setWidth100();
		this.setHeight100();
		
		this.setWrapCells(true);
		this.setFixedRecordHeights(false);
		

		CellFormatter formatQtde = new CellFormatter() {				
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if(value == null) return null;  
                NumberFormat nf = NumberFormat.getFormat(HowMGWTUtilities.getMask(maskQtde));
                try {  
                    return nf.format(((Number) value).doubleValue());  
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        };

		CellFormatter formatValorUnitario = new CellFormatter() {				
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if(value == null) return null;  
                NumberFormat nf = NumberFormat.getFormat("###,###,###,###,###,###,##0.0000");
                try {  
                    return nf.format(((Number) value).doubleValue());  
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        };

		CellFormatter formatValor = new CellFormatter() {				
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if(value == null) return null;  
                NumberFormat nf = NumberFormat.getFormat("###,###,###,###,###,###,##0.00");
                try {  
                    return nf.format(((Number) value).doubleValue());  
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        };
        
		fieldQtde.setCellFormatter(formatQtde);
		fieldPrecoVenda.setCellFormatter(formatValorUnitario);
		fieldValorVendido.setCellFormatter(formatValor);

		fieldQtde.setType(ListGridFieldType.FLOAT);
		fieldPrecoVenda.setType(ListGridFieldType.FLOAT);
		fieldValorVendido.setType(ListGridFieldType.FLOAT);		
		
		fieldTipoAplicacao.setWrap(true);
		
		this.setFields(
				fieldCodPedido,
				fieldCodProduto,
				fieldDescComercial,
				fieldVendedor,				
				fieldFamiliaComercial,
				fieldTipoAplicacao,
				fieldQtde,
				fieldPrecoVenda,
				fieldValorVendido		
		);		
		
		this.setCanResizeFields(true);
		this.setHeaderHeight(44);
		this.setShowAllRecords(false);
		
		onHowMInitEntityControl();
	}
	
	
	/**
	 * Carrega os dados para a listagem.
	 * @param form
	 */
	public void loadResult(FormBean form){

		this.clearAllRecords();
		if ( form.getListaDetalhePerformanceVendas() == null ){
			return;
		}
		RecordList records = new RecordList();
		ListGridRecord record;
		for ( ePerformanceVendasDetalhes detalhe : form.getListaDetalhePerformanceVendas() ){
			record = new ListGridRecord();

			double qtde				= HowMGWTUtilities.getDouble(detalhe.getQtde());
			double precoVenda		= HowMGWTUtilities.getDouble(detalhe.getPrecoVenda());
			double valorVendido		= HowMGWTUtilities.getDouble(detalhe.getPrecoTotal());
			
			record.setAttribute(fieldCodPedido.getName()		, detalhe.getCodPedido());
			record.setAttribute(fieldCodProduto.getName()		, detalhe.getCodProduto());
			record.setAttribute(fieldDescComercial.getName()	, detalhe.getDescComercial());
			record.setAttribute(fieldVendedor.getName() 		, detalhe.getNomeColaborador());
			record.setAttribute(fieldFamiliaComercial.getName()	, detalhe.getFamiliaComercial());
			record.setAttribute(fieldTipoAplicacao.getName()	, detalhe.getTipoAplicacao());
			record.setAttribute(fieldQtde.getName()				, qtde);
			record.setAttribute(fieldPrecoVenda.getName()		, precoVenda);
			record.setAttribute(fieldValorVendido.getName()		, valorVendido);
			records.add(record);
		}
		this.setData(records);
	}
}