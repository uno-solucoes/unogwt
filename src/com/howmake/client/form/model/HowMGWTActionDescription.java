package com.howmake.client.form.model;
 
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.widgets.tree.TreeNode;


/**
 * Classe utilizada para troca de dados entre a toolbar e o formulório 
 * @author HCINF
 */
public class HowMGWTActionDescription {
	 
	private String howMAction 		= "";
	private String howMPropertyName = "";

	private HowMGWTFormBean howMFormBean;

	private String howMFinishActionMessage;
	private String howMMessageError;
	private boolean howMError;

	private TreeNode howMParentTreeNode;
	
	private int howMOperacao  		= HowMGWTUtilities.OPERATION_QUERY;
	private int howMActionButton	= HowMGWTUtilities.ACTION_BUTTON_NONE;
	
	private boolean howMSaveInServer= false;
	
	private boolean howMFinishShowMessage = true;
	
 	/**
	 * @return the setHowMFormBean
	 */
	public HowMGWTFormBean getHowMFormBean() {
		return howMFormBean;
	}

	/**
	 * @param setHowMFormBean the setHowMFormBean to set
	 */
	public void setHowMFormBean(HowMGWTFormBean setHowMFormBean) {
		this.howMFormBean = setHowMFormBean;
	}

	/**
	 * @return the howmMessageError
	 */
	public String getHowMMessageError() {
		return howMMessageError;
	}

	/**
	 * @param howmMessageError the howmMessageError to set
	 */
	public void setHowMMessageError(String howmMessageError) {
		this.howMMessageError = howmMessageError;
	}

	/**
	 * @return the howmError
	 */
	public boolean isHowMError() {
		return howMError;
	}

	/**
	 * @param howmError the howmError to set
	 */
	public void setHowMError(boolean howMError) {
		this.howMError = howMError;
	}

	
	/**
	 * Reinicializa os flags.
	 */
	private void restartFlags(){
		
		this.howMError 			= false;
		this.howMMessageError 	= "";
		this.howMFormBean		= null;	

	}
	
	

	public void setHowMInsertMode(){
		this.howMOperacao = HowMGWTUtilities.OPERATION_INSERT;
		restartFlags();
	}
	
	public void setHowMUpdateMode(){
		this.howMOperacao = HowMGWTUtilities.OPERATION_UPDATE;
		restartFlags();
	}

	public void setHowMDeleteMode(){
		this.howMOperacao = HowMGWTUtilities.OPERATION_DELETE;
		restartFlags();
	}

	public void setHowMQueryMode(){
		this.howMOperacao = HowMGWTUtilities.OPERATION_QUERY;
		restartFlags();
	}


	public boolean isHowMInsertMode(){
		return this.howMOperacao == HowMGWTUtilities.OPERATION_INSERT;
	}
	
	public boolean isHowMUpdateMode(){
		return this.howMOperacao == HowMGWTUtilities.OPERATION_UPDATE;
	}

	public boolean isHowMDeleteMode(){
		return this.howMOperacao == HowMGWTUtilities.OPERATION_DELETE;
	}

	public boolean isHowMQueryMode(){
		return this.howMOperacao == HowMGWTUtilities.OPERATION_QUERY;
	}

	
	
	
	
	public void setActionButtonNode(){
		this.howMActionButton = HowMGWTUtilities.ACTION_BUTTON_NONE;
	}
	
	public void setActionButtonNewItem(){
		this.howMActionButton = HowMGWTUtilities.ACTION_BUTTON_NEW_ITEM;
	}

	public void setActionButtonNewSubItem(){
		this.howMActionButton = HowMGWTUtilities.ACTION_BUTTON_NEW_SUB_ITEM;
	}
	
	
	public boolean isActionButtonNode(){
		return this.howMActionButton == HowMGWTUtilities.ACTION_BUTTON_NONE;
	}
	
	public boolean isActionButtonNewItem(){
		return this.howMActionButton == HowMGWTUtilities.ACTION_BUTTON_NEW_ITEM;
	}

	public boolean isActionButtonNewSubItem(){
		return this.howMActionButton == HowMGWTUtilities.ACTION_BUTTON_NEW_SUB_ITEM;
	}

	
	
	
	
	
	
	/**
	 * @return the howMAction
	 */
	public String getHowMAction() {
		return howMAction;
	}

	/**
	 * @param howMAction the howMAction to set
	 */
	public void setHowMAction(String howMAction) {
		this.howMAction = howMAction;
	}

	/**
	 * @return the howMPropertyName
	 */
	public String getHowMPropertyName() {
		return howMPropertyName;
	}

	/**
	 * @param howMPropertyName the howMPropertyName to set
	 */
	public void setHowMPropertyName(String howMPropertyName) {
		this.howMPropertyName = howMPropertyName;
	}

	/**
	 * @return the howMFinishActionMessage
	 */
	public String getHowMFinishActionMessage() {
		return howMFinishActionMessage;
	}

	/**
	 * @param howMFinishActionMessage the howMFinishActionMessage to set
	 */
	public void setHowMFinishActionMessage(String howMFinishActionMessage) {
		this.howMFinishActionMessage = howMFinishActionMessage;
	}

	/**
	 * @return the howMParentTreeNode
	 */
	public TreeNode getHowMParentTreeNode() {
		return howMParentTreeNode;
	}

	/**
	 * @param howMParentTreeNode the howMParentTreeNode to set
	 */
	public void setHowMParentTreeNode(TreeNode howMParentTreeNode) {
		this.howMParentTreeNode = howMParentTreeNode;
	}

	/**
	 * @return the howMOperacao
	 */
	public int getHowMOperacao() {
		return howMOperacao;
	}

	/**
	 * @return the howMSaveInServer
	 */
	public boolean isHowMSaveInServer() {
		return howMSaveInServer;
	}

	/**
	 * @param howMSaveInServer the howMSaveInServer to set
	 */
	public void setHowMSaveInServer(boolean howMSaveInServer) {
		this.howMSaveInServer = howMSaveInServer;
	}

	/**
	 * @return the howMFinishShowMessage
	 */
	public boolean isHowMFinishShowMessage() {
		return howMFinishShowMessage;
	}

	/**
	 * @param howMFinishShowMessage the howMFinishShowMessage to set
	 */
	public void setHowMFinishShowMessage(boolean howMFinishShowMessage) {
		this.howMFinishShowMessage = howMFinishShowMessage;
	}
}
