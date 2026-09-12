package com.br.client.panel.cd.cdd0007.UI;

import com.br.client.model.cd.cdd0007.FormBean;
import com.br.client.model.cd.entity.eClienteCondicaoPagamento;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellSavedEvent;

public class PainelLista extends HowMGWTListGrid{

		private String codCliente;
		
		public ListGridField fieldCodCliente    = new ListGridField("codCondPagto",			" ",       80);
		public ListGridField fieldCodCondPagto  = new ListGridField("codCondPagto",			" ",       80);

		public ListGridField fieldSelect 		= new ListGridField("select", 	    		" ", 	   30);
		public ListGridField fieldDescCondPagto	= new ListGridField("descCondPagto", 		Tradutor.i18n.formCondPagto(), 		240);
		public ListGridField fieldVlMinimoVenda = new ListGridField("vlMinimoVenda", 		Tradutor.i18n.formVlMinimoVenda(), 	100);

		public PainelLista(){
			initUI();	
		}
		
		public void initUI(){
			
			this.setWidth100();
			this.setHeight100();
			
			this.setHowMNotifyChangeRecord(true);
			// this.setHowMMEditControl(true);
			this.setDataPageSize(1000);

			fieldSelect.setType(ListGridFieldType.BOOLEAN);
	 
			fieldCodCliente.setType(ListGridFieldType.INTEGER);
			fieldCodCliente.setHidden(true);
			fieldCodCliente.setCanHide(false);
 
			fieldCodCondPagto.setHidden(true);
			fieldCodCondPagto.setCanHide(false);
			
			
			fieldVlMinimoVenda.setType(ListGridFieldType.FLOAT);
			fieldVlMinimoVenda.setAlign(Alignment.RIGHT);

			fieldVlMinimoVenda.setCellFormatter(new CellFormatter() {				
		            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
		                if(value == null) return null;  
		                NumberFormat nf = NumberFormat.getFormat("###,###,###,###,###,###,##0.00");
		                try {  
		                    return nf.format(((Number) value).doubleValue());  
		                } catch (Exception e) {  
		                    return value.toString();  
		                }  
		            }  
		        });  			
			
			this.setAlwaysShowEditors(true);  
	        this.setShowRecordComponents(true);
	        this.setShowRecordComponentsByCell(true);  
         
	        
			this.setFields(
					fieldCodCliente,
					fieldCodCondPagto,
					fieldSelect,
					fieldDescCondPagto,
					fieldVlMinimoVenda
			);		
			
			this.setCanResizeFields(true);		
			this.setHeaderHeight(25);
			
			// não alterar esta situação para false, pois da problema nesta tela.
			this.setShowAllRecords(true);
			
			onHowMInitEntityControl(); 			

			fieldSelect.setCanEdit(true);
			fieldDescCondPagto.setCanEdit(false);
			fieldVlMinimoVenda.setCanEdit(true);
			
			this.setEditEvent(ListGridEditEvent.CLICK);
 
		}		
 
		
		
    
 
	 
		
		/**
		 * Grava o registro no servidor.
		 */
		public void onSave(){
			this.saveAllEdits();
			
			ListGridRecord[] records = this.getRecords();
			eClienteCondicaoPagamento[] condicoes = new eClienteCondicaoPagamento[records.length];

			int i = 0 ;
			for ( ListGridRecord record : records ){
				eClienteCondicaoPagamento condicao = new eClienteCondicaoPagamento();

				// Verfica se não campos informados com erros.
				int row = this.getRecordIndex(record);
				String erros[] = this.getCellErrors( row, this.fieldVlMinimoVenda.getName() );
				if ( erros != null  && erros.length > 0 ){

					String msg = "" ;
					for ( String erro : erros )
						msg += "<li>"+Tradutor.i18n.formCampo()+" "+this.fieldVlMinimoVenda.getTitle()+" : "+erro;

					SC.say(Tradutor.i18n.msgVerifiqueValorInformado()+msg);
					return;
				}

				boolean select = new Boolean(record.getAttribute(this.fieldSelect.getName()));

				Double valorMinimo = record.getAttributeAsDouble(fieldVlMinimoVenda.getName());

				// configura a ação que deverá ser realizada no servidor.
				if ( select ){
					condicao.setCodCliente(this.getCodCliente());
					if ( valorMinimo == null ){
						condicao.setVlMinimoVenda("0.0000");
						record.setAttribute(fieldVlMinimoVenda.getName(), new Double(0.0) );				
					}
				}
				else{
					condicao.setCodCliente(null);
					condicao.setVlMinimoVenda(null);
					record.setAttribute(fieldVlMinimoVenda.getName(), (String)null );
				}
				condicao.setCodCondPagto(record.getAttribute(fieldCodCondPagto.getName()));
				condicao.setVlMinimoVenda(""+valorMinimo);

				refreshRow(row);

				condicoes[i] = condicao;

				i ++ ;
			}
			if ( condicoes.length == 0 ){
				SC.say(Tradutor.i18n.msgNaoHaItemsParaSeremSalvos());
				return;
			}
 			
			HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {					
				@Override
				public void onResponse(HowMGWTFormBean formBean) {
					FormBean bean = (FormBean)formBean;
					if ( !HowMGWTControl.isRefreshFormShowMessage(bean)){	
						SC.say(Tradutor.i18n.msgAlteracaoRealizadaComSucesso());
 
					}
				}
			};
			
			String param = "";
			param += "&codCliente="+this.getCodCliente();
			String body = "";
			
			JSONArray array = new JSONArray();
			i = 0 ;
			
			for ( eClienteCondicaoPagamento cCond :  condicoes){
				JSONObject object = cCond.toJsonObject("");
				 array.set(i, object);
				 i ++ ;
			}
			JSONObject objectBean = new JSONObject();
			objectBean.put("condicoesPagamento", array);
			body = "JSONData="+objectBean.toString();
			System.out.println("JSON: \n"+array.toString());
			struts.setGwtCheckSecurity(true);

			struts.request("cdd0007.do?method=save"+param,  "CDD0007Form", body);						
		}

		/**
		 * @return the codCliente
		 */
		public String getCodCliente() {
			return codCliente;
		}

		/**
		 * @param codCliente the codCliente to set
		 */
		public void setCodCliente(String codCliente) {
			this.codCliente = codCliente;
		}
 
 
 		@Override
 		public void onHowMNotifyChanged(CellSavedEvent event, Record record) {
			if ( event.getColNum() == this.getFieldNum(fieldVlMinimoVenda.getName())){				
				if ( ! HowMGWTUtilities.isEquals(event.getOldValue() , event.getNewValue()) ){
					if ( ! HowMGWTUtilities.isEmpty(event.getNewValue()) ){
						if ( HowMGWTUtilities.getDouble(event.getNewValue()) > 0 ){
							record.setAttribute(fieldSelect.getName(), true );
						}
						else {
							record.setAttribute(fieldSelect.getName(), false );						
						}
					}
				}
			}			
 		}
}