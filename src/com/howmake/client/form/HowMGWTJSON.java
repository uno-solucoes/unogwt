package com.howmake.client.form;

import java.util.TreeMap;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public class HowMGWTJSON {

	  private void addChildren(TreeMap<String, Object> treeItem, JSONValue jsonValue) {
		    JSONArray jsonArray;
		    JSONObject jsonObject;
		    JSONString jsonString;

//		    if ((jsonArray = jsonValue.isArray()) != null) {
//		    	ArrayList itens = new ArrayList();
//		    	
//		    	for (int i = 0; i < jsonArray.size(); ++i) {
//		        TreeMap<String,Object> child = new TreeMap<String,Object>();
//		        
//		        addChildren(child, jsonArray.get(i));
//		      }
//		    } else if ((jsonObject = jsonValue.isObject()) != null) {
//		      Set<E> keys = jsonObject.keySet();
//		      for (Iterator<E> iter = keys.iterator(); iter.hasNext();) {
//		        String key = (String) iter.next();
//		        TreeItem child = treeItem.addItem(key);
//		        addChildren(child, jsonObject.get(key));
//		      }
//		    } else if ((jsonString = jsonValue.isString()) != null) {
//		      // Use stringValue instead of toString() because we don't want escaping
//		      treeItem.addItem(jsonString.stringValue());
//		    } else {
//		      // JSONBoolean, JSONNumber, and JSONNull work well with toString().
//		      treeItem.addItem(getChildText(jsonValue.toString()));
//		    }
	  }
	
}
