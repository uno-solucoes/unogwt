package com.howmake.client.form.partner;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

import com.howmake.client.form.model.HowMGWTFormBean;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGridField;

public class HowMGWTFormProperties {
	ArrayList<HowMGWTProperty> properties = new ArrayList<HowMGWTProperty>();
	
	private LinkedHashMap<String, HowMGWTProperty> mapProperties;

	
	public void addProperty(HowMGWTProperty property){
		this.properties.add(property);
	}
	
	public void removeProperty(HowMGWTProperty property){
		this.properties.remove(property);
	}

	public void clear(){
		this.properties.clear();
	}
	
	public List<HowMGWTProperty> getProperties(){
		return properties;
	}
	
	public HowMGWTProperty createProperty(String name, String title){
		HowMGWTProperty property = new HowMGWTProperty(name, title); 
//		{
//			@Override
//			public void onHowMGWTSelect(boolean selected) {
//				onHowMChangeLookup(this);
//			}
//		};
		this.properties.add(property);
		property.setOderList(this.properties.size());
		property.setIndex(this.properties.size());
		return property;
	}
	
	public ListGridField[] getListFields(){
		ListGridField[] fields;
		
		ArrayList<HowMGWTProperty> properties = sortListToGrid();
		ArrayList<ListGridField> lFields = new ArrayList<ListGridField>();
		
		for ( HowMGWTProperty prop : properties ){
			if ( prop.getListField() != null )
				lFields.add(prop.getListField());
		}
		fields = new ListGridField[lFields.size()];
		for ( int i = 0 ; i < fields.length; i ++ ){
			fields[i] = lFields.get(i);
		}
		return fields;
	}
	
	/**
	 * @return Retorna uma lista ordenada para apresentação na grid.
	 */
	private ArrayList<HowMGWTProperty> sortListToGrid(){

		ArrayList<HowMGWTProperty> newList = new ArrayList<HowMGWTProperty>();
		
		for ( HowMGWTProperty prop : this.properties)
			newList.add(prop);
		
		Collections.sort(newList, new Comparator<HowMGWTProperty>() {
	        @Override
	        public int compare(HowMGWTProperty o1, HowMGWTProperty o2) {
	        	return o1.getOderList() - o2.getOderList();
	        }
		});
		
		return newList;
	}
	
	
	/**
	 * @return Avalia e retorna o script para submeter ao servidor.
	 */
	public String getFormSendFilter(HowMGWTFormBean formBean){
		if ( this.properties == null || this.properties.size() == 0 )
			return "";

		String script = "";
		String value  = "";

		for( HowMGWTProperty prop : this.properties ){
			
			if ( prop.getHowMGWTEditorDateItem() != null ){
				if ( ! HowMGWTUtilities.isEmpty( prop.getHowMValue() ) )
					value = HowMGWTUtilities.getFormatDateDB(prop.getHowMValueAsDate());
			}
			else
				value = prop.getHowMValue();

			formBean.setString(prop.getName(), value);
		}
		
		return formBean.toJsonObject("").toString();
	}
	
	/**
	 * @return Avalia e retorna o script para submeter ao servidor.
	 */
	public void loadFormValues(HowMGWTFormBean formBean){
		if ( this.properties == null || this.properties.size() == 0 )
			return ;
 
		String value  = "";

		for( HowMGWTProperty prop : this.properties ){
			
			if ( prop.getHowMGWTEditorDateItem() != null ){
				if ( ! HowMGWTUtilities.isEmpty( prop.getHowMValue() ) )
					value = HowMGWTUtilities.getFormatDateDB(prop.getHowMValueAsDate());
			}
			else
				value = prop.getHowMValue();

			formBean.setString(prop.getName(), value);
		}
	}

	/**
	 * @param property
	 */
	public void onHowMChangeLookup(HowMGWTProperty property){
	}
	
	
	/**
	 * Retorna um mapa indexado com as propriedades de interfaces configuradas
	 * @return
	 */
	public LinkedHashMap<String, HowMGWTProperty> getMapProperties(){
		if( this.mapProperties == null || this.mapProperties.size() != this.getProperties().size() ){
			if( this.mapProperties != null && this.mapProperties.size() != this.getProperties().size() ){
				this.mapProperties.clear();
				this.mapProperties = null;
			}
			this.mapProperties = new LinkedHashMap<String, HowMGWTProperty>();
			for( HowMGWTProperty property : this.getProperties()){
				mapProperties.put(property.getName(), property);
			}
		}
		return this.mapProperties;
	}	
}