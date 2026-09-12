package com.howmake.client.form.model;

import java.util.TreeMap;

import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.tree.TreeNode;

public class HowMGWTFolder {
	private String folderName;
	private TreeNode treeNode;
    private TreeMap<String,ListGridRecord> files = new TreeMap<String,ListGridRecord>();
	/**
	 * @return the folderName
	 */
	public String getFolderName() {
		return folderName;
	}
	/**
	 * @param folderName the folderName to set
	 */
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	/**
	 * @return the treeNode
	 */
	public TreeNode getTreeNode() {
		return treeNode;
	}
	/**
	 * @param treeNode the treeNode to set
	 */
	public void setTreeNode(TreeNode treeNode) {
		this.treeNode = treeNode;
	}
	/**
	 * @return the files
	 */
	public TreeMap<String, ListGridRecord> getFiles() {
		return files;
	}
	/**
	 * @param files the files to set
	 */
	public void setFiles(TreeMap<String, ListGridRecord> files) {
		this.files = files;
	}

}
