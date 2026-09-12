package com.br.client.panel.cd.cdd0008.UI;
 
import com.br.client.model.cd.cdd0008.FormBean;
import com.br.client.model.cd.entity.eTabelaPrecoCondicaoPagamento;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PainelLista extends HowMGWTListGrid{

		private String tabelaPreco;
		
		public ListGridField fieldCodTabelaPreco    = new ListGridField("tabelaPreco",		" ",       80);
		public ListGridField fieldCodCondPagto  = new ListGridField("codCondPagto",			" ",       80);
 		public ListGridField fieldDescCondPagto	= new ListGridField("descCondPagto", 		Tradutor.i18n.formCondPagto(), 		240);

		public PainelLista(){
			initUI();	
		}
		
		public void initUI(){
			
			this.setWidth100();
			this.setHeight100();
			
 
			this.setDataPageSize(1000);
 
			this.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		
			fieldCodTabelaPreco.setHidden(true);
			fieldCodTabelaPreco.setCanHide(false);
 
			fieldCodCondPagto.setHidden(true);
			fieldCodCondPagto.setCanHide(false);
 
	        
			this.setFields(
					fieldCodTabelaPreco,
					fieldCodCondPagto,
					fieldDescCondPagto 
			);		
			
			this.setCanResizeFields(true);		
			this.setHeaderHeight(25);
			
			// não alterar esta situação para false, pois da problema nesta tela.
			this.setShowAllRecords(true);
			
			onHowMInitEntityControl(); 			
 
			fieldDescCondPagto.setCanEdit(false);
 
		}		
 
		
		
    
 
	 
		
		/**
		 * Grava o registro no servidor.
		 */
		public void onSave(){
 			
			ListGridRecord[] records = this.getRecords();
			eTabelaPrecoCondicaoPagamento[] condicoes = new eTabelaPrecoCondicaoPagamento[records.length];

			int i = 0 ;
			for ( ListGridRecord record : records ){
				eTabelaPrecoCondicaoPagamento condicao = new eTabelaPrecoCondicaoPagamento();
 
				condicao.setCodCondPagto(record.getAttribute(fieldCodCondPagto.getName()));

				boolean select = this.isSelected(record);

				// configura a ação que deverá ser realizada no servidor.
				if ( select ){
					condicao.setTabelaPreco(this.getTabelaPreco());
				}
				else{
					condicao.setTabelaPreco(null);
				}			
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
			struts.setGwtCheckSecurity(true);
			
			String param = "";
			param += "&tabelaPreco="+this.getTabelaPreco();
			String body = "";
			
			JSONArray array = new JSONArray();
			i = 0 ;
			
			for ( eTabelaPrecoCondicaoPagamento cCond :  condicoes){
				JSONObject object = cCond.toJsonObject("");
				 array.set(i, object);
				 i ++ ;
			}
			JSONObject objectBean = new JSONObject();
			objectBean.put("condicoesPagamento", array);
			body = "JSONData="+objectBean.toString();
			System.out.println("JSON: \n"+array.toString());
			
			struts.request("cdd0008.do?method=save"+param,  "CDD0008Form", body);						
		}

		/**
		 * @return the tabelaPreco
		 */
		public String getTabelaPreco() {
			return tabelaPreco;
		}

		/**
		 * @param tabelaPreco the tabelaPreco to set
		 */
		public void setTabelaPreco(String tabelaPreco) {
			this.tabelaPreco = tabelaPreco;
		}
 
}