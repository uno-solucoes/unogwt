package com.br.client.panel.sv.svd0010.UI;

import java.util.ArrayList;
import java.util.TreeMap;

import com.br.client.model.sv.entity.ePlanoServicoComissaoExcecao;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;

public class PainelLista extends HowMGWTListGrid{

		private String codEmpresa;
		private String tpOwner;
		private String codPlano;
	
		private boolean changeValues = false;
		public ListGridField fieldParcela 		= new ListGridField("parcela", 	    	Tradutor.i18n.formParcela(), 	   80);
		public ListGridField fieldPercComissao	= new ListGridField("percComissao", 	Tradutor.i18n.formPercComissao(), 100);
		public ListGridField fieldDelete		= new ListGridField("delete", 			" ", 							   100);
		
		public PainelLista(){
			initUI();	
		}
		
		public void initUI(){
			
			this.setWidth100();
			this.setHeight100();
			
			this.setHowMMEditControl(true);
			this.setDataPageSize(1000);

			HowMGWTProperty.configureInputInteger(fieldParcela);
			fieldParcela.setType(ListGridFieldType.INTEGER);
			fieldParcela.setAlign(Alignment.CENTER);

			HowMGWTProperty.configureInputDecimal(fieldPercComissao, "#,##0,0000");
			fieldPercComissao.setType(ListGridFieldType.FLOAT);
			fieldPercComissao.setAlign(Alignment.RIGHT);

			fieldPercComissao.setCellFormatter(new CellFormatter() {				
		            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
		                if(value == null) return null;  
		                NumberFormat nf = NumberFormat.getFormat("#,##0.0000");
		                try {  
		                    return nf.format(((Number) value).doubleValue());  
		                } catch (Exception e) {  
		                    return value.toString();  
		                }  
		            }  
		        });  			
			
			// this.setAlwaysShowEditors(true);  
	        this.setShowRecordComponents(true);
	        this.setShowRecordComponentsByCell(true);  
         
	        
			this.setFields(
					fieldParcela,
					fieldPercComissao,
					fieldDelete
			);		
			
			this.setCanResizeFields(true);		
			this.setHeaderHeight(25);
			// não alterar esta situação para false, pois da problema nesta tela.
			this.setShowAllRecords(true);
			
			onHowMInitEntityControl(); 			

			fieldParcela.setCanEdit(true);
			fieldPercComissao.setCanEdit(true);
			
			this.setEditEvent(ListGridEditEvent.CLICK);
 
		}		
 
		
		
        protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) {  
        	  
            String fieldName = this.getFieldName(colNum);  

            if (fieldName.equals(fieldDelete.getName())) {  
               
            	HLayout recordCanvas = new HLayout(1);  
                recordCanvas.setHeight(22);  
                recordCanvas.setAlign(Alignment.CENTER);

                ImgButton actionDelete = new ImgButton();  
                actionDelete.setShowDown(false);  
                actionDelete.setShowRollOver(false);  
                actionDelete.setLayoutAlign(Alignment.CENTER);  
                actionDelete.setSrc("actions/ico_excluir.gif");  
                actionDelete.setPrompt("Excluir Registro");  
                actionDelete.setHeight(16);  
                actionDelete.setWidth(16);  
                actionDelete.addClickHandler(new ClickHandler() {					
					@Override
					public void onClick(ClickEvent event) {
						 
						SC.confirm( Tradutor.i18n.confirmExcluirRegistro() , new BooleanCallback() {
							
							@Override
							public void execute(Boolean value) {
								onExcluirRegistro(record);
							}
						});
					}
				}); 

                recordCanvas.addMember(actionDelete);  
                return recordCanvas;  
            }
            return super.createRecordComponent(record, colNum);  
        }

		/**
		 * @return the codEmpresa
		 */
		public String getCodEmpresa() {
			return codEmpresa;
		}

		/**
		 * @param codEmpresa the codEmpresa to set
		 */
		public void setCodEmpresa(String codEmpresa) {
			this.codEmpresa = codEmpresa;
		}

		/**
		 * @return the tpOwner
		 */
		public String getTpOwner() {
			return tpOwner;
		}

		/**
		 * @param tpOwner the tpOwner to set
		 */
		public void setTpOwner(String tpOwner) {
			this.tpOwner = tpOwner;
		}

		/**
		 * @return the codPlano
		 */
		public String getCodPlano() {
			return codPlano;
		}

		/**
		 * @param codPlano the codPlano to set
		 */
		public void setCodPlano(String codPlano) {
			this.codPlano = codPlano;
		}

		
        /**
         * Ocorre quando há uma confirmação para excluir o registro selecionado.
         * @param record
         */
		public void onExcluirRegistro(final ListGridRecord record){
			
			if ( this.isRecordModeInsert( record ) ){
				this.removeData(record);
				return;
			}	
			
			HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new com.br.client.model.sv.svd0010.FormBean()) {					
				@Override
				public void onResponse(HowMGWTFormBean formBean) {
					com.br.client.model.sv.svd0010.FormBean bean = (com.br.client.model.sv.svd0010.FormBean)formBean;
					if ( !HowMGWTControl.isRefreshFormShowMessage(bean)){
						PainelLista.this.removeData(record);
					}
				}
			};
			
			String param = "";
			param += "&codEmpresa="+codEmpresa;
			param += "&tpOwner="+tpOwner;
			param += "&codPlano="+codPlano;
			param += "&codParcelaPagto="+record.getAttribute(fieldParcela.getName());
			String body = "";
			struts.request("svd0010.do?method=excluir"+param,  "SVD0010Form", body);			
		}

		
		/**
		 * Grava o registro no servidor.
		 */
		public void onSave(){
			
			this.saveAllEdits();
			
			ListGridRecord[] records = this.getRecords();
			ArrayList<ePlanoServicoComissaoExcecao> excecoes = new ArrayList<ePlanoServicoComissaoExcecao>();
			
			for ( ListGridRecord record : records ){
				if ( this.isRecordModeInsert( record) || this.isRecordModeUpdate(record) ){
					ePlanoServicoComissaoExcecao excecao = new ePlanoServicoComissaoExcecao();
					excecao.setCodEmpresa(codEmpresa);
					excecao.setTpOwner(tpOwner);
					excecao.setCodPlano(codPlano);
					excecao.setCodParcelaPagto(""+record.getAttributeAsInt(this.fieldParcela.getName()));
					excecao.setPercComissao( ""+record.getAttributeAsDouble(fieldPercComissao.getName()));
					excecao.setOperation(this.getRecordMode(record));
					excecoes.add(excecao);
				}
			}
			if ( excecoes.size() == 0 ){
				SC.say(Tradutor.i18n.msgNaoHaItemsParaSeremSalvos());
				return;
			}
 			
			HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new com.br.client.model.sv.svd0010.FormBean()) {					
				@Override
				public void onResponse(HowMGWTFormBean formBean) {
					com.br.client.model.sv.svd0010.FormBean bean = (com.br.client.model.sv.svd0010.FormBean)formBean;
					if ( !HowMGWTControl.isRefreshFormShowMessage(bean)){
						
						// Atualiza os dados do percentual de comissão
						if ( bean.getExcecoes() != null ){
							TreeMap<String, ePlanoServicoComissaoExcecao> map = new TreeMap<String, ePlanoServicoComissaoExcecao>();
							for ( ePlanoServicoComissaoExcecao excecao : bean.getExcecoes() ){
								map.put(excecao.getCodParcelaPagto(), excecao );
							}
							ePlanoServicoComissaoExcecao excecao;
							ListGridRecord[] records = getRecords();
							for ( ListGridRecord record : records ){
								excecao = map.get(record.getAttribute(fieldParcela.getName()));
								if ( excecao != null ){
									record.setAttribute(fieldPercComissao.getName(), HowMGWTUtilities.getDouble(excecao.getPercComissao()) );
									refreshRow(getRecordIndex(record));
								}
								
							}
						}
						howMRestartRecordFlag(HowMGWTListGrid.HOWM_RECORD_QUERY); 
					
					}
				}
			};
			
			String param = "";
			param += "&codEmpresa="+codEmpresa;
			param += "&tpOwner="+tpOwner;
			param += "&codPlano="+codPlano;
			String body = "";
			
			JSONArray array = new JSONArray();
			int i = 0 ;
			
			for ( ePlanoServicoComissaoExcecao cExcecao : excecoes ){					
				JSONObject object = cExcecao.toJsonObject("");
				 array.set(i, object);
				 i ++ ;
			}
			JSONObject objectBean = new JSONObject();
			objectBean.put("excecoes", array);
			body = "JSONData="+objectBean.toString();
			
			struts.request("svd0010.do?method=save"+param,  "SVD0010Form", body);						
		}
}