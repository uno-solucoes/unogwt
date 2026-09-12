package com.howmake.client.form.model;

import org.moxieapps.gwt.uploader.client.File;

import com.smartgwt.client.widgets.grid.ListGridRecord;

public class HowMGWTFile {
	private String folder;
	private File file;
	private ListGridRecord record;
 

	public HowMGWTFile(String folder, File file){
		this.folder = folder;
		this.file   = file;
	}

	/**
	 * @return the folder
	 */
	public String getFolder() {
		return folder;
	}

	/**
	 * @param folder the folder to set
	 */
	public void setFolder(String folder) {
		this.folder = folder;
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * @return the record
	 */
	public ListGridRecord getRecord() {
		return record;
	}

	/**
	 * @param record the record to set
	 */
	public void setRecord(ListGridRecord record) {
		this.record = record;
	}
 
}
