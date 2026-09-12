package com.br.client.panel.vd.vdp0001.UI;

 
import java.util.TreeMap;

import com.br.client.panel.vd.vdp0001.model.RecordRelacaoVendas;
import com.google.gwt.i18n.client.NumberFormat;
import com.howmake.shared.HowMGWTEntity;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
 
public class ResumoVendas extends ListGrid {
 	
	private TreeMap<String, Integer> headerPositions = new TreeMap<String,Integer>();
	
	public ResumoVendas(){
		initUI();
	}
	
	public void initUI(){
				
		this.setFields();
		
		this.setCanResizeFields(true);   
        // this.setData(CountryData.getRecords()); 
		
		this.setHeaderHeight(50);		
	}
	
	public void showResult(HowMGWTEntity entity){
		
		this.headerPositions.clear();
		for ( HowMGWTEntity detailEntity : entity.getDetailEntities() ){
			ListGridField[] fields = new ListGridField[detailEntity.getHeaders().size()];
			
			for ( int i = 0 ; i < detailEntity.getHeaders().size(); i ++  ){
				fields[i] = new ListGridField(detailEntity.getHeaders().get(i).getTitle(), detailEntity.getHeaders().get(i).getTitle(), 100);
				fields[i].setWrap(true);
				fields[i].setCanHide(false);
				fields[i].setCanHide(false);				
				if ( i > 1 ){
					fields[i].setAlign(Alignment.RIGHT);
				}
				this.headerPositions.put(fields[i].getName(), new Integer(i) );
			}
			
			ListGridRecord[] records = new ListGridRecord[detailEntity.getData().size()];
			for ( int i = 0 ; i < detailEntity.getData().size(); i ++ ){
				// Formata os valores 
				for ( int j = 2 ; j < detailEntity.getData().get(i).length ; j ++ ){
					if ( i == 0 ){
						int value = new Integer(detailEntity.getData().get(i)[j]);
						detailEntity.getData().get(i)[j] = ""+NumberFormat.getFormat("###,###,###,###,###,###,##0").format(value);
					}
					else{
						double value = new Double(detailEntity.getData().get(i)[j]);
						detailEntity.getData().get(i)[j] = "R$ "+NumberFormat.getFormat("###,###,###,###,###,###,###.00").format(value);
					}
				}
				records[i] = new RecordRelacaoVendas(fields, headerPositions ,detailEntity.getData().get(i));
			}
			this.setFields(fields);
			this.setData(records);
		}
	}	
}
