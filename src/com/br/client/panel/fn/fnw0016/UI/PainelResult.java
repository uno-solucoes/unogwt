package com.br.client.panel.fn.fnw0016.UI;

import java.util.ArrayList;
import java.util.Date;

import com.br.client.model.fn.entity.excel.eHowMCell;
import com.br.client.model.fn.entity.excel.eHowMRow;
import com.br.client.model.fn.entity.excel.eHowMWorksheet;
import com.br.client.model.fn.fnw0016.custom.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.NumberFormat;
import com.howmake.client.form.UI.HowMGWTFormToolbarEdit;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PainelResult extends ListGrid{

	HowMGWTFormToolbarEdit tool;
	private static String cellType = "cellType";

	ArrayList<HowMGWTProperty> fields = new ArrayList<HowMGWTProperty>();
	
	public PainelResult(eHowMWorksheet worksheet){
		
		this.setShowAllRecords(true);
		this.setShowAllColumns(true);
		
		
		this.setHeaderHeight(40);
		
		HowMGWTProperty prop;
		if ( worksheet.getRows() != null && worksheet.getRows().length >= 1){
			eHowMRow headerRow = worksheet.getRows()[0];
			int c = 0;
			
			for ( eHowMCell cell : headerRow.getCells()){

				prop = new HowMGWTProperty("_cell_"+c, cell.getValue());

				boolean value = false;
				
				if ( c > 0 ){
					prop.setWidthColumn(100);
					if ( c == 1 ){
						
						Date data = HowMGWTUtilities.getDate("01/"+prop.getTitle());
						String mesAno = HowMGWTUtilities.getMesAbrev(""+data.getMonth())+"/"+(data.getYear()+1900);
						
						prop.setTitle("<center><b>"+Tradutor.i18n.formMesBase()+"</b><br>"+mesAno+"</center>");
						prop.setType(ListGridFieldType.FLOAT);
						prop.getExternalProperties().put(cellType, "MesBase");
						prop.createHowMGWTListGridField();
						prop.createFormatDouble("R$ ###,###,###,###,###,###,##0.00");
						prop.getListField().setWrap(true);
					}
					else if ( cell.getValue().trim().equals("%") ){
						prop.setWidthColumn(50);
						prop.setType(ListGridFieldType.FLOAT);
						prop.getExternalProperties().put(cellType, "%");
						prop.createHowMGWTListGridField();
						// prop.createFormatDouble("###,##0.00"," %");
						
						CellFormatter formatter = new CellFormatter() {
					        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
					        	if ( ! HowMGWTUtilities.isEmpty( record.getAttribute("BLANK_ROW") ) )
					        			return "";
					        	if( HowMGWTUtilities.getDouble( value ) == 0.00 )
					        		return "";
					        	
					        	return NumberFormat.getFormat("###,##0.00").format(HowMGWTUtilities.getDouble(value))+" %";
					        }
						};	
						
						prop.getListField().setType(ListGridFieldType.FLOAT);
						prop.getListField().setCellFormatter(formatter);
						
					}
					else{
						Date data = HowMGWTUtilities.getDate("01/"+prop.getTitle());
						String mesAno = HowMGWTUtilities.getMesAbrev(""+data.getMonth())+"/"+(data.getYear()+1900);

						prop.setTitle( mesAno );
						prop.setType(ListGridFieldType.FLOAT);
						prop.getExternalProperties().put(cellType, "Compara");	
						prop.createHowMGWTListGridField();
						prop.createFormatDouble("R$ ###,###,###,###,###,###,##0.00");
					}
				}
				else{
					prop.setWidthColumn(260);
					prop.createHowMGWTListGridField();
					if ( c == 0 )
						prop.getListField().setFrozen(true);
				}
				
				prop.getListField().setCanHide(false);
				prop.getListField().setCanReorder(false);
				prop.getListField().setCanSort(false);
				prop.getListField().setCanGroupBy(false);
				prop.getListField().setCanSortClientOnly(false);
				prop.getListField().setCanToggle(false);
				
				fields.add(prop);
				c ++;
			}
			
			ListGridField[] fs = new ListGridField[fields.size()];
			int i = 0;
			for ( HowMGWTProperty p : fields){
				fs[i++] = p.getListField();
			}
			
			this.setFields(fs);

			/**
			 * Carrega os dados da grid.
			 */
			int r = 0;
			RecordList recordList = new RecordList();
			ListGridRecord record;
			for ( eHowMRow row : worksheet.getRows()){
				// Pula a linha de cabeçalho.
				if ( r == 0 ){
					r ++;
					continue;
				}

				record = new ListGridRecord();
				String css;
				record.setAttribute("_cssTotal", row.getTotal());

				c = 0;
				for ( HowMGWTProperty p : fields){
					if ( c < row.getCells().length ){
						p.setHowMValue(record, row.getCells()[c].getValue());
					}
					c ++;
				}
				recordList.add(record);
				if ( FormBean.SISTEMA_RESULTADO_OPERACIONAL_TOTAL_VENDAS.equals(row.getTotal()) ){
					record = new ListGridRecord();
					record.setAttribute("BLANK_ROW","1");			
					recordList.add(record);
				}
				else if ( FormBean.SISTEMA_RESULTADO_OPERACIONAL_TOTAL_VENDAS_MENOS_IMPOSTOS.equals(row.getTotal()) ){
					record = new ListGridRecord();
					record.setAttribute("BLANK_ROW","1");			
					recordList.add(record);
				}
				else if ( FormBean.SISTEMA_RESULTADO_OPERACIONAL_TOTAL_VENDAS_MENOS_IMPOSTOS_MENOS_CMV.equals(row.getTotal()) ){
					record = new ListGridRecord();
					record.setAttribute("BLANK_ROW","1");			
					recordList.add(record);
				}
				else if ( FormBean.SISTEMA_RESULTADO_OPERACIONAL_TOTAL_DESPESAS.equals(row.getTotal()) ){
					record = new ListGridRecord();
					record.setAttribute("BLANK_ROW","1");			
					recordList.add(record);
				}
				
				r ++;
			}
			this.setData(recordList);
		}				
	}
	
	
	
	/**
	 * Intercepta a renderização dos registros para aplicar o css de acordo com 
	 * a configuração do registro.
	 */
	@Override
	protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
		
		HowMGWTProperty prop = fields.get(colNum);
		
		final String colorTotalVendas 	 = ""; // "color: rgb(0,130,0);";
		final String colorTotalVendasNeg = "color: rgb(0,130,0);";
		final String colorDespesas 		 = "color: rgb(255,0,0);";
		final String colorDespesasNeg 	 = "color: rgb(255,0,0);";
		
		final String bgVendas			 = ""; //  "background-color:rgb(202,225,255);";
		
		String cssTotal = record.getAttribute("_cssTotal");
		String css;
		if ( 
				HowMGWTUtilities.isEquals(cssTotal, FormBean.SISTEMA_RESULTADO_OPERACIONAL_TOTAL_VENDAS ) 
				|| 
				HowMGWTUtilities.isEquals(cssTotal, FormBean.SISTEMA_RESULTADO_OPERACIONAL_TOTAL_VENDAS_MENOS_IMPOSTOS ) 
				|| 
				HowMGWTUtilities.isEquals(cssTotal, FormBean.SISTEMA_RESULTADO_OPERACIONAL_TOTAL_VENDAS_MENOS_IMPOSTOS_MENOS_CMV ) 
		){
			css  = "";
		    css += colorTotalVendas;
		    css += "font-weight: bold;";
		    css += bgVendas;
			
			return css;
		}
		else if ( 
				HowMGWTUtilities.isEquals(cssTotal, FormBean.SISTEMA_RESULTADO_OPERACIONAL_VENDAS_MERCADORIAS) 
				|| 
				HowMGWTUtilities.isEquals(cssTotal, FormBean.SISTEMA_RESULTADO_OPERACIONAL_OUTRAS_VENDAS) 
		){
			css  = "";
		    css += colorTotalVendas;
		    css += bgVendas;
			return css;
		}

		else if (  HowMGWTUtilities.isEquals(cssTotal, FormBean.SISTEMA_RESULTADO_OPERACIONAL_RESULTADO ) ){
			css  = "";
		    css += "font-weight: bold;";
		   
		    if ( colNum > 0 ){
			    if ( HowMGWTUtilities.getDouble( prop.getHowMValue(record) ) > 0 )
				    css += colorTotalVendas;
			    else
				    css += colorDespesasNeg;	
		    }
		    else
			    css += colorTotalVendas;			

		    css += bgVendas;
		    
		    return css;
		}
		
		
		
		
		else if ( 
				HowMGWTUtilities.isEquals(cssTotal, FormBean.SISTEMA_RESULTADO_OPERACIONAL_TOTAL_IMPOSTOS) 
				||
				HowMGWTUtilities.isEquals(cssTotal, FormBean.SISTEMA_RESULTADO_OPERACIONAL_DESPESAS) 				
		){
			css  = "";
		    css += colorDespesas;
			return css;
		}

		else if (  HowMGWTUtilities.isEquals(cssTotal, FormBean.SISTEMA_RESULTADO_OPERACIONAL_TOTAL_DESPESAS ) ){
			css  = "";
		    css += colorDespesas;
		    css += "font-weight: bold;";					
			return css;
		}
		
		
		return super.getCellCSSText(record, rowNum, colNum);
	}
}