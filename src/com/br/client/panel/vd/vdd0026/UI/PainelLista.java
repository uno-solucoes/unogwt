package com.br.client.panel.vd.vdd0026.UI;
 
import com.br.client.model.vd.entity.eItemPedido;
import com.br.client.model.vd.vdw0001.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.UI.HowMGWTTextItem;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PainelLista extends HowMGWTListGrid{
		
		public ListGridField fieldSelect 		= new ListGridField("select", 	       " ", 	   30);
		public ListGridField fieldCodProduto	= new ListGridField("codProduto", 		Tradutor.i18n.formCodProduto(), 	120);
		public ListGridField fieldDescProduto	= new ListGridField("descProduto", 		Tradutor.i18n.formProduto(), 		300);
		public ListGridField fieldQtdEtiquetas	= new ListGridField("qtdEtiquetas", 	Tradutor.i18n.formQtdEtiquetas(),   70 );
		public ListGridField fieldQtdVolumes	= new ListGridField("qtdVolumes", 		Tradutor.i18n.formQtdVolumes(),     70 );
		public ListGridField fieldDataImpressao	= new ListGridField("dataImpressao", 	Tradutor.i18n.formDataImpressao(), 	86 );		   		
		
		public PainelLista(){
			initUI();	
		}
		
		public void initUI(){
			
			this.setWidth100();
			this.setHeight100();
			
			this.setHowMNotifyChangeRecord(true);
			// this.setHowMMEditControl(true);
			this.setDataPageSize(1000);

			this.setHeaderHeight(44);
			
			
			fieldSelect.setType(ListGridFieldType.BOOLEAN);
	 	
			fieldQtdEtiquetas.setCanEdit(true);
			fieldQtdEtiquetas.setWrap(true);
			fieldQtdEtiquetas.setType(ListGridFieldType.INTEGER);
			
			fieldQtdVolumes.setCanEdit(false);
			fieldQtdVolumes.setWrap(true);
			fieldQtdVolumes.setType(ListGridFieldType.INTEGER);

			
			fieldDataImpressao.setCanEdit(false);		
			fieldDataImpressao.setWrap(true);
			
			this.setAlwaysShowEditors(true);  
	        this.setShowRecordComponents(true);
	        this.setShowRecordComponentsByCell(true);  

			this.setFields(
					fieldSelect,
					fieldCodProduto,
					fieldDescProduto,
					fieldQtdEtiquetas,
					fieldQtdVolumes,
					fieldDataImpressao
			);		

			this.setCanResizeFields(true);		
 
			
			// não alterar esta situação para false, pois da problema nesta tela.
			this.setShowAllRecords(true);
			
			onHowMInitEntityControl(); 			

			fieldSelect.setCanEdit(true);
			fieldDescProduto.setCanEdit(false);
			
			this.setEditEvent(ListGridEditEvent.CLICK);
 
		}		
 
		
		
    
 
	 
		
		/**
		 * Grava o registro no servidor.
		 */
		public void onSave(){
			
			this.saveAllEdits();

			ListGridRecord[] records = this.getRecords();
			eItemPedido[] selectItens = new eItemPedido[records.length];

			int i = 0 ;
			for ( ListGridRecord record : records ){
				eItemPedido item = new eItemPedido();
 
				boolean select = new Boolean(record.getAttribute(this.fieldSelect.getName()));

				// configura a ação que deverá ser realizada no servidor.
				if ( select ){
					item.setCodProduto(record.getAttribute(fieldCodProduto.getName()));
					item.setQtdeEtiquetas(""+record.getAttributeAsInt(fieldQtdEtiquetas.getName()));
				}
				else{
					item.setCodProduto(null);
				}			
				selectItens[i] = item;

				i ++ ;
			}
			if ( selectItens.length == 0 ){
				SC.say(Tradutor.i18n.msgNaoHaItemsParaSeremImpressos());
				return;
			}
 			
			HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new FormBean()) {					
				@Override
				public void onResponse(HowMGWTFormBean formBean) {
					FormBean bean = (FormBean)formBean;
					if ( !HowMGWTControl.isRefreshFormShowMessage(bean)){	
						SC.say(Tradutor.i18n.msgImpressaoRealizadaComSucesso());
					}
				}
			};
			
			String param = "";
			String body = "";
			
			JSONArray array = new JSONArray();
			i = 0 ;
			
			for ( eItemPedido cItem :  selectItens){
				JSONObject object = cItem.toJsonObject("");
				 array.set(i, object);
				 i ++ ;
			}
		
			JSONObject objectBean = new JSONObject();
			objectBean.put("itensPedido", array);
			body = "JSONData="+objectBean.toString();
			
			struts.request("vdw0001.do?method=imprimirEtiquetas"+param,  "VDW0001Form", body);						
		}

 

}