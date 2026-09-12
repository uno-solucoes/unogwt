package com.howmake.client.form.model;

import java.util.Map;
import java.util.TreeMap;

import com.smartgwt.client.data.DataSource;

public class HowMGWTDataSource extends DataSource{
	
	private Map<String, Integer> headerPositions = new TreeMap<String,Integer>();

	public HowMGWTDataSource(){
		
	}

	public void onHowMInitEntityControl(){
		for( int i = 0 ; i < this.getFields().length ; i ++){
			this.headerPositions.put(this.getFields()[i].getName(), new Integer(i));
		};
	}

	/**
	 * @return the headerPositions
	 */
	public Map<String, Integer> getHeaderPositions() {
		return headerPositions;
	}

	/**
	 * @param headerPositions the headerPositions to set
	 */
	public void setHeaderPositions(TreeMap<String, Integer> headerPositions) {
		this.headerPositions = headerPositions;
	}	
}