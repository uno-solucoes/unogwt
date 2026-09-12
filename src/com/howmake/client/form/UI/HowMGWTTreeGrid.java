package com.howmake.client.form.UI;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.model.HowMGWTTreeNode;
import com.howmake.client.form.model.entity.HowMGWTPageCache;
 
import com.howmake.client.form.partner.HowMGWTFormField;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTListField;
import com.howmake.client.form.partner.HowMGWTParameter;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ExpansionMode;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;

public class HowMGWTTreeGrid extends VLayout {
	
	private ArrayList<HowMGWTParameter> howMParametros = new ArrayList<HowMGWTParameter>();

	private HowMGWTListField	listField;
	private HowMGWTFormField	formField;
	
	private String howMAction;
	private String howMBeanName;
	private HowMGWTFormBean howMFormBean;

	protected ToolStrip howMNavegateToolsDatabase;
		
	private boolean howMCustomIcon					= false;

	private boolean howMModeLookup					= false;
	
	private boolean howmShowConnectors				= true;
	private boolean howMShowHeader					= false;
	
	private String howMCustomContext; 				

	private boolean howMCanSelectCells				= false;
	
    private boolean howMShowPartialSelection		= false;  
    private boolean howMCascadeSelection	    	= false;  		
    private boolean howMAlwaysShowEditors			= false;

    private boolean howMSelectRecordFinishLoad		= true;
    
    private boolean howMWrapCells					= false;

    
    private String howMplaceHolder;
    
	private Boolean howMCanReorderRecords;  	
	private Boolean howMCanAcceptDroppedRecords;  

    
    private Boolean howMShowRecordComponents		= null;          
    private Boolean howMShowRecordComponentsByCell	= null;
    private Boolean howMCanExpandRecords			= null;
    
    private ExpansionMode howMExpansionMode			= null;  
	private String howMDetailField					= null; 
    
    private Boolean howMShowAllColumns;
    private Boolean howMShowAllRecords;

    private ListGridEditEvent howMEditEvent;    
	
	private String howmIconName						= "icon";
	
	private int    howMIconSize						= 16;

	private Integer howMCellHeight;
	private Integer howMHeaderHeight;
	
    private String howMKeyName 						= "howMKey";
    private String howMParentKeyName 				= "howMParentID";
    private String howmFieldName 					= "howMDescricao";

    private String howMArrayObjectName  			= "howMArrayObjectName";
    
	private String howMAppImgDir 					= "actions/";

	private String howMFolderIcon 					= "transparence.png";
	private String howMNodeIcon 					= "transparence.png";

	private String howMModuleName					= "";
	
	private String howMFormBeanName     			= "howMFormBean";
	
	private HowMGWTFormToolbarEditTree parentHowMFormToolbarEditTree;
	
	private SelectionAppearance howMSelectionAppearance = SelectionAppearance.CHECKBOX;

	private boolean howMCanEdit						= false;
		
	
	private boolean howMClientMode					= false;
	
	HowMGWTProperty howMPropertyFieldOperation ;

	HowMGWTProperty howMPropertyFieldName 			= new HowMGWTProperty("", "");
	
	private Boolean HowMFixedRecordHeights			= null;
 
	public Boolean getHowMFixedRecordHeights() {
		return HowMFixedRecordHeights;
	}


	public void setHowMFixedRecordHeights(Boolean howMFixedRecordHeights) {
		HowMFixedRecordHeights = howMFixedRecordHeights;
	}


	private LinkedHashMap<String, HowMGWTProperty>  mapHowMFields = new LinkedHashMap<String, HowMGWTProperty>();
	private ArrayList<HowMGWTProperty> howMFields 	= new ArrayList<HowMGWTProperty>();
	
	private boolean found 							= false;	
	
	private TreeGrid howMTreeGrid;
	private Tree howMTree;
	
	private HowMGWTFormBean howMCurrentFormBean;
	private HowMGWTFormBean howMLastFormBeanQuery;

	public HowMGWTTreeGrid(){
		this.setWidth(260);
		this.setHeight100();		
				
		howMPropertyFieldName.setName(getHowmFieldName());
		howMPropertyFieldName.createHowMGWTListGridField();
		howMPropertyFieldName.getListField().setWrap(true);
	}
	
	
	public void createHomMNavegateToolsDatabase(){
		this.howMNavegateToolsDatabase = new HowMGWTNavegateToolsDatabase(this);

		this.addMember(this.howMNavegateToolsDatabase);

		((HowMGWTNavegateToolsDatabase)this.howMNavegateToolsDatabase).start();
	}
	
	public void onHowMInitialize(){
		loadTree(new HowMGWTFormBean[]{});
	}
	
	

	/**
	 * @return the howMParametros
	 */
	public ArrayList<HowMGWTParameter> getHowMParametros() {
		return howMParametros;
	}

	/**
	 * @param howMParametros the howMParametros to set
	 */
	public void setHowMParametros(ArrayList<HowMGWTParameter> howMParametros) {
		this.howMParametros = howMParametros;
	}
		
	
	/**
	 * Carrega os dados da árvore.
	 * @param action ação que será executada no servidor 
	 * @param beanName Nome do bean que será acessado no servidor.
	 * @param formBean Objeto formbean que será passado como parâmetro para o servidor.
	 */
	public void executeHowMAction(HowMGWTFormBean formBean){

		this.howMFormBean 	= formBean;
		setHowMLastFormBeanQuery(formBean);

		setHowMCurrentFormBean(formBean);
		
		this.setFound(false);

		if ( this.howMTreeGrid == null )
			loadTree(new HowMGWTFormBean[]{});
		
		// carrega a árvore de objetos.
		loadTree((HowMGWTFormBean[])formBean.getObject(getHowMArrayObjectName()));
		
	}
	
	
	/**
	 * Carrega os dados da árvore.
	 * @param action ação que será executada no servidor 
	 * @param beanName Nome do bean que será acessado no servidor.
	 * @param formBean Objeto formbean que será passado como parâmetro para o servidor.
	 */
	public void executeHowMAction(String action, String beanName , HowMGWTFormBean formBean){

		this.howMAction 	= action;
		this.howMBeanName 	= beanName;
		this.howMFormBean 	= formBean;
		
		this.setFound(false);

		if ( this.howMTreeGrid == null )
			loadTree(new HowMGWTFormBean[]{});
		
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean){
			@Override
			public void onResponse(HowMGWTFormBean formBean) {

				setHowMLastFormBeanQuery(formBean);

				setHowMCurrentFormBean(formBean);

				if( formBean.isError(true) ){
					return;
				}

				onHowMBeforeLoader(formBean);
				
				if ( formBean.getObject("howMPageData") != null ){
					HowMGWTFormBean formBeanPageData = (HowMGWTFormBean)formBean.getObject("howMPageData");
					Object pageBean = formBeanPageData.getObject(HowMGWTUtilities.PAGE_FIELD_NAME);
					if ( pageBean != null ){
						HowMGWTPageCache pageCache = new HowMGWTPageCache();
						pageCache.convertToThisBean(formBeanPageData);
						if ( howMNavegateToolsDatabase != null && howMNavegateToolsDatabase instanceof HowMGWTNavegateToolsDatabase ){
							((HowMGWTNavegateToolsDatabase)howMNavegateToolsDatabase).setHowMPageCache(pageCache);
						}
						loadTree((HowMGWTFormBean[])pageBean);
					}
					else{
						if( howMNavegateToolsDatabase instanceof HowMGWTNavegateToolsDatabase  ){
							((HowMGWTNavegateToolsDatabase)howMNavegateToolsDatabase).setHowMPageCache(null);
						}
						loadTree(null);
					}	
				}
				else{
					// carrega a árvore de objetos.
					loadTree((HowMGWTFormBean[])formBean.getObject(getHowMArrayObjectName()));
				}
				HowMGWTWindowWait.hideWait();
			}
		};
		// Executa a carga de dados no servidor.
		struts.request(action, beanName, formBean.toSendBody(""));		
	}

	/**
	 * Carrega os dados da árvore.
	 * @param action ação que será executada no servidor 
	 * @param beanName Nome do bean que será acessado no servidor.
	 * @param formBean Objeto formbean que será passado como parâmetro para o servidor.
	 */
	public void executeHowMAction(String action, String beanName , HowMGWTFormBean formBean, HowMGWTFormBean pageEntity){

		this.setFound(false);

		if ( this.howMTreeGrid == null )
			loadTree(new HowMGWTFormBean[]{});
		
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(pageEntity){
			@Override
			public void onResponse(HowMGWTFormBean formBean) {

				setHowMLastFormBeanQuery(formBean);
				
				
				if( formBean.isError(true) ){
					return;
				}
			
				onHowMBeforeLoader(formBean);				
				
				setHowMCurrentFormBean(formBean);
				// carrega a árvore de objetos.
				loadTree((HowMGWTFormBean[])formBean.getObject(getHowMArrayObjectName()));
				HowMGWTWindowWait.hideWait();
			}
		};
		// Executa a carga de dados no servidor.
		struts.request(action, beanName, formBean.toSendBody(""));		
	}
	
	public void howMLoadTree(HowMGWTFormBean[] formBeans){
		loadTree(formBeans);
	}	
	
	private void loadTree(HowMGWTFormBean[] formBeans){

 		boolean create = false;
		
		if ( howMTreeGrid != null ){
			create = true;
//			this.removeMember(this.howMTreeGrid);
//			howMTreeGrid.destroy();
//			howMTreeGrid = null;
			
//			this.howMTree.destroy();
//			this.howMTree = null;
			
		}
		// Se não estiver criado a grid então cria.
		else{
			
			this.howMPropertyFieldName.setName(this.getHowmFieldName());

			onHowMBeforeTreeGrid();

			if( this.getHowMCanExpandRecords() != null && this.getHowMCanExpandRecords().booleanValue() ){
			
				howMTreeGrid = new TreeGrid(){	
					@Override  
		            protected Canvas getExpansionComponent(final ListGridRecord record) {
						Canvas canvas = getHowMExpansionComponent(record);
						if( canvas != null )
							return canvas;
						else
							return super.getExpansionComponent(record);
					}
				};
				howMTreeGrid.setCanExpandRecords(getHowMCanExpandRecords().booleanValue());
				if( ! HowMGWTUtilities.isEmpty( this.howMplaceHolder ) ){
					howMTreeGrid.setEmptyMessage(this.getHowMplaceHolder());
				}
			}
			else if( this.getHowMShowRecordComponents() != null && this.getHowMShowRecordComponents().booleanValue() ){
				howMTreeGrid = new TreeGrid(){	
		            @Override
		            protected Canvas createRecordComponent(ListGridRecord record, Integer colNum) {
		            	Canvas canvas = howMCreateRecordComponent(record, colNum);
		            	if( canvas != null )
		            		return canvas;
		            	else
		            		return super.createRecordComponent(record, colNum);
		            }

				};
				
			    howMTreeGrid.setShowRecordComponents(HowMGWTUtilities.getBoolean(this.getHowMShowRecordComponents()));          
			    howMTreeGrid.setShowRecordComponentsByCell(HowMGWTUtilities.getBoolean(this.getHowMShowRecordComponentsByCell()));
			    
				if( ! HowMGWTUtilities.isEmpty( this.howMplaceHolder ) ){
					howMTreeGrid.setEmptyMessage(this.getHowMplaceHolder());
				}

			}
			else{
				if ( this.isHowMModeLookup() ){
					howMTreeGrid = new TreeGrid(){					
			            @Override  
			            protected com.smartgwt.client.widgets.Canvas getRollOverCanvas(Integer rowNum, Integer colNum) {  	  
			            	return onHowMGetRollOverCanvas(this,rowNum, colNum);
			            }
						@Override
						protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {							
							String css = getHowMCellCSSText(record, rowNum, colNum);
							if( HowMGWTUtilities.isEmpty(css)){
								return super.getCellCSSText(record, rowNum, colNum);
							}
							return css;
						}
						@Override
						protected String getBaseStyle(ListGridRecord record, int rowNum, int colNum) {
							String style = getHowMBaseStyle(record, rowNum, colNum);
							if( HowMGWTUtilities.isEmpty(style)){
								return super.getBaseStyle(record, rowNum, colNum);
							}
							return style;							
						}						
			        };
					if( ! HowMGWTUtilities.isEmpty( this.howMplaceHolder ) ){
						howMTreeGrid.setEmptyMessage(this.getHowMplaceHolder());
					}

				}
				else{
					howMTreeGrid = new TreeGrid(){
						@Override
						protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
							
							String css = getHowMCellCSSText(record, rowNum, colNum);
							if( HowMGWTUtilities.isEmpty(css)){
								return super.getCellCSSText(record, rowNum, colNum);
							}
							return css;
						}
						
						@Override
						protected String getBaseStyle(ListGridRecord record, int rowNum, int colNum) {
							String style = getHowMBaseStyle(record, rowNum, colNum);
							if( HowMGWTUtilities.isEmpty(style)){
								return super.getBaseStyle(record, rowNum, colNum);
							}
							return style;							
						}
						@Override
						protected Canvas getCellHoverComponent(Record record, Integer rowNum, Integer colNum) {
							Canvas canvas = null;
							if( ( canvas = getHowMCellHoverComponent(record, rowNum, colNum) ) != null) {
								
							}
							if( canvas == null ){
								canvas = super.getCellHoverComponent(record, rowNum, colNum);
							}
							return canvas;
						}
					};  				
					if( ! HowMGWTUtilities.isEmpty( this.howMplaceHolder ) ){
						howMTreeGrid.setEmptyMessage(this.getHowMplaceHolder());
					}
				}				
			}
			
			if( this.getHowMFixedRecordHeights() != null ){
				howMTreeGrid.setFixedRecordHeights(this.getHowMFixedRecordHeights());
			}

			howMTreeGrid.setCanSelectCells(this.isHowMCanSelectCells());
			
			onHowMAfterTreeGrid();

			if( this.getHowMCellHeight() != null )
				howMTreeGrid.setCellHeight(this.getHowMCellHeight().intValue());
			
			
			this.howMTreeGrid.setWrapCells(this.howMWrapCells);
			
			if( this.getHowMHeaderHeight() != null )
				this.howMTreeGrid.setHeaderHeight(this.getHowMHeaderHeight());
				
	        howMTreeGrid.setShowRollOverCanvas(true); 	
			
	        howMTreeGrid.setWidth100();  
	        howMTreeGrid.setHeight100();  


			if( this.getHowMCanExpandRecords() != null && this.getHowMCanExpandRecords() ){
				this.howMTreeGrid.setCanExpandRecords(true);
				if( this.getHowMExpansionMode() != null  ){
					this.howMTreeGrid.setExpansionMode(this.getHowMExpansionMode());
				}
				if( ! HowMGWTUtilities.isEmpty( this.getHowMDetailField() ) ){
					this.howMTreeGrid.setDetailField(this.getHowMDetailField());
				}
			}	  	        
	        
	        howMTreeGrid.setAlwaysShowEditors(this.isHowMAlwaysShowEditors());
	        
	        howMTreeGrid.setCanEdit(this.isHowMCanEdit());
	        
	        if ( this.isHowMCanEdit() ){
	        	howMTreeGrid.setSelectOnEdit(true);
	        	howMTreeGrid.setEditEvent(ListGridEditEvent.CLICK);  
	        }
	        
	        
	        if( this.getHowMCanReorderRecords() != null ){
	        	howMTreeGrid.setCanReorderRecords(this.getHowMCanReorderRecords());
	    	}


	    	if( getHowMCanAcceptDroppedRecords() != null ){
	    		howMTreeGrid.setCanAcceptDroppedRecords(getHowMCanAcceptDroppedRecords());
	    	}

	        
	        
	        howMTreeGrid.setClosedIconSuffix("");  
	        howMTreeGrid.setOpenIconSuffix("");
	        
	        if( this.isHowMClientMode() && howMFields.size() == 0 ){
	        	howMPropertyFieldOperation= new HowMGWTProperty("howMGWTOperation", " "); 
	        	howMPropertyFieldOperation.setWidthColumn(60);
	        	howMPropertyFieldOperation.setType(ListGridFieldType.IMAGE);
	        	howMPropertyFieldOperation.createHowMGWTListGridField();
	        	howMPropertyFieldOperation.getListField().setImageURLPrefix("actions/");
	        	howMPropertyFieldOperation.getListField().setImageURLSuffix(".png");
	        	howMPropertyFieldOperation.getListField().setCanEdit(false);
	        	// actions/og_delete.gif
	        	// actions/og_novo.gif
	        	// actions/ico_edited.gif
	        	howMPropertyFieldOperation.getListField().setDefaultValue("icon_operation_result");
	        	howMFields.add(howMPropertyFieldOperation);
	        	
	        	
	        	howMFields.add(howMPropertyFieldName);
	        }
	        else if( this.isHowMClientMode() && howMFields.size() > 0 ){
	        	howMPropertyFieldOperation= new HowMGWTProperty("howMGWTOperation", " "); 
	        	howMPropertyFieldOperation.setWidthColumn(60);
	        	howMPropertyFieldOperation.setType(ListGridFieldType.IMAGE);
	        	howMPropertyFieldOperation.createHowMGWTListGridField();
	        	howMPropertyFieldOperation.getListField().setImageURLPrefix("actions/");
	        	howMPropertyFieldOperation.getListField().setImageURLSuffix(".png");
	        	howMPropertyFieldOperation.getListField().setCanEdit(false);
	        	// actions/og_delete.gif
	        	// actions/og_novo.gif
	        	// actions/ico_edited.gif
	        	howMPropertyFieldOperation.getListField().setDefaultValue("icon_operation_result");
	        	howMFields.add(0,howMPropertyFieldOperation);
	        	
	        	
	        }
	        
	        if ( howMFields.size() == 0  )
	        	howMFields.add(howMPropertyFieldName);
	        
	        ListGridField[] fields = new ListGridField[this.howMFields.size()];
	        int i = 0;
	        this.mapHowMFields.clear();
	        for ( HowMGWTProperty field : this.howMFields){
	        	fields[i++] = field.getListField();
	        	mapHowMFields.put(field.getName(), field);
	        }
	         
	        howMTreeGrid.setFields(fields);  
	        
	        // treeGridGrupos.setShowAllRecords(true);
	        howMTreeGrid.setSelectionAppearance(getSelectionAppearance()); 
	        
	        // Modo SELECT-ROW
	        if ( getSelectionAppearance() == SelectionAppearance.ROW_STYLE ){
	        	howMTreeGrid.setSelectionType(SelectionStyle.SINGLE);
	        }
	        // Modo CHECK-BOX
	        else{
	        	howMTreeGrid.setSelectionType(SelectionStyle.MULTIPLE);
	        
	        	howMTreeGrid.setShowPartialSelection(this.isHowMShowPartialSelection());  
	        	howMTreeGrid.setCascadeSelection(this.isHowMCascadeSelection());  		

	        }
			howMTreeGrid.setShowHeader(this.isHowMShowHeader());
			
			if ( this.isHowMCustomIcon() ){
				howMTreeGrid.setAppImgDir(null);
				howMTreeGrid.setFolderIcon(null);  
		        howMTreeGrid.setNodeIcon(null); 
			}
			else{
				howMTreeGrid.setAppImgDir(getHowMAppImgDir());
				howMTreeGrid.setFolderIcon(getHowMFolderIcon());  
		        howMTreeGrid.setNodeIcon(getHowMNodeIcon());
		     
			}			

			howMTreeGrid.setIconSize(this.getHowMIconSize());
			System.out.println("CellHeight : "+howMTreeGrid.getCellHeight());
			// howMTreeGrid.setCellHeight(this.getHowMIconSize());
			
			howMTreeGrid.setShowConnectors(this.isHowmShowConnectors());
	        
			if ( getHowMEditEvent() != null )
	        	howMTreeGrid.setEditEvent(this.getHowMEditEvent() );  

		
	        if( this.howMShowAllColumns != null )
	        	howMTreeGrid.setShowAllColumns(this.howMShowAllColumns.booleanValue());
	        
	        if ( this.howMShowAllRecords != null )
	        	howMTreeGrid.setShowAllRecords(this.getHowMShowAllRecords());
		}
		
		howMTree = new Tree();
		howMTree.setModelType(TreeModelType.PARENT);

		onHowAfterCreateTree();
		
		howMTree.setIdField(getHowMKeyName());
		howMTree.setParentIdField(getHowMParentKeyName());
		howMTree.setNameProperty(getHowmFieldName());
	
		
		this.setFound(false);
		
		HowMGWTTreeNode[] nodes = null;
		if ( formBeans != null ){
			nodes = new HowMGWTTreeNode[formBeans.length];
			
			int i = 0;			
			for ( HowMGWTFormBean node : formBeans){
				nodes[i] = addHowMNode(node);
				
				if( this.isHowMClientMode()  ){
					if ( HowMGWTUtilities.isEmpty(nodes[i].getHowMOperation()) )
						nodes[i].setAttribute(howMPropertyFieldOperation.getName(), "icon_operation_result");
					else
						nodes[i].setAttribute(howMPropertyFieldOperation.getName(), nodes[i].getHowMOperation() );				
				}
				onHowMLoadNode(HowMGWTTreeGrid.this , node,nodes[i]);
				i++;
			}
			if ( i > 0 )
				this.setFound(true);
		}		

		howMTree.setData(nodes);
		howMTreeGrid.setData(howMTree);

		if ( !create ){			
	        addMember(howMTreeGrid); 
		}
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
			
			@Override
			public void execute() {
				if ( getParentHowMFormToolbarEditTree() != null ){
					getParentHowMFormToolbarEditTree().onHowMAfterLoad(found);
				}
				else if( found && isHowMSelectRecordFinishLoad() ){					
					 getHowMTreeGrid().selectRecord(0);
				}
		        onHowMFinishLoadTreeGrid();
			}
		});
		
	}	
	
	public HowMGWTTreeNode onHowMCreateTreeNode(HowMGWTFormBean formBean){
		return this.addHowMNode(formBean);
	}

	
    public HowMGWTFormBean getNodeFormBean(ListGridRecord node){
    	return (HowMGWTFormBean)node.getAttributeAsObject(howMFormBeanName);
    	 
    }
 
 
	/**
	 * @return the selectionAppearance
	 */
	public SelectionAppearance getSelectionAppearance() {
		return howMSelectionAppearance;
	}


	/**
	 * @param selectionAppearance the selectionAppearance to set
	 */
	public void setSelectionAppearance(SelectionAppearance selectionAppearance) {
		this.howMSelectionAppearance = selectionAppearance;
	}	



	/**
	 * @return the howMKeyName
	 */
	public String getHowMKeyName() {
		return howMKeyName;
	}


	/**
	 * @param howMKeyName the howMKeyName to set
	 */
	public void setHowMKeyName(String howMKeyName) {
		this.howMKeyName = howMKeyName;
	}


	/**
	 * @return the howMParentKeyName
	 */
	public String getHowMParentKeyName() {
		return howMParentKeyName;
	}


	/**
	 * @param howMParentKeyName the howMParentKeyName to set
	 */
	public void setHowMParentKeyName(String howMParentKeyName) {
		this.howMParentKeyName = howMParentKeyName;
	}


	/**
	 * @return the howmFieldName
	 */
	public String getHowmFieldName() {
		return howmFieldName;
	}


	/**
	 * @param howmFieldName the howmFieldName to set
	 */
	public void setHowmFieldName(String howmFieldName) {
		this.howmFieldName = howmFieldName;
	}


	/**
	 * @return the howMAppImgDir
	 */
	public String getHowMAppImgDir() {
		return howMAppImgDir;
	}


	/**
	 * @param howMAppImgDir the howMAppImgDir to set
	 */
	public void setHowMAppImgDir(String howMAppImgDir) {
		this.howMAppImgDir = howMAppImgDir;
	}


	/**
	 * @return the howMFolderIcon
	 */
	public String getHowMFolderIcon() {
		return howMFolderIcon;
	}


	/**
	 * @param howMFolderIcon the howMFolderIcon to set
	 */
	public void setHowMFolderIcon(String howMFolderIcon) {
		this.howMFolderIcon = howMFolderIcon;
	}


	/**
	 * @return the howMNodeIcon
	 */
	public String getHowMNodeIcon() {
		return howMNodeIcon;
	}


	/**
	 * @param howMNodeIcon the howMNodeIcon to set
	 */
	public void setHowMNodeIcon(String howMNodeIcon) {
		this.howMNodeIcon = howMNodeIcon;
	}


	/**
	 * @return the howMSelectionAppearance
	 */
	public SelectionAppearance getHowMSelectionAppearance() {
		return howMSelectionAppearance;
	}


	/**
	 * @param howMSelectionAppearance the howMSelectionAppearance to set
	 */
	public void setHowMSelectionAppearance(SelectionAppearance howMSelectionAppearance) {
		this.howMSelectionAppearance = howMSelectionAppearance;
	}


	/**
	 * @return the howMTreeGrid
	 */
	public TreeGrid getHowMTreeGrid() {
		return howMTreeGrid;
	}


	/**
	 * @return the howMArrayObjectName
	 */
	public String getHowMArrayObjectName() {
		return howMArrayObjectName;
	}


	/**
	 * @param howMArrayObjectName the howMArrayObjectName to set
	 */
	public void setHowMArrayObjectName(String howMArrayObjectName) {
		this.howMArrayObjectName = howMArrayObjectName;
	}
	
    public Boolean getHowMCanReorderRecords() {
		return howMCanReorderRecords;
	}


	public void setHowMCanReorderRecords(Boolean howMCanReorderRecords) {
		this.howMCanReorderRecords = howMCanReorderRecords;
	}


	public Boolean getHowMCanAcceptDroppedRecords() {
		return howMCanAcceptDroppedRecords;
	}


	public void setHowMCanAcceptDroppedRecords(Boolean howMCanAcceptDroppedRecords) {
		this.howMCanAcceptDroppedRecords = howMCanAcceptDroppedRecords;
	}

	
	// -----------------------------------------------------------------------------------------
	//                                       E V E N T O S 
	// -----------------------------------------------------------------------------------------
	
	
	/**
	 * Evento disparado quando a carga é completada.
	 */
	public void onHowMFinishLoadTreeGrid(){}

	/**
	 * Evento dispardo quando o nó é carregado do banco de dados.
	 * @param formBean
	 * @param node
	 */
	public void onHowMLoadNode(HowMGWTTreeGrid treeGrid, HowMGWTFormBean formBean, HowMGWTTreeNode node){};
	
//	/**
//	 * Evento disparado quando é selecionado um nó. 
//	 * @param event
//	 * @return
//	 */
//	public boolean onHowMSelectChanged(SelectionEvent event){	
//		return true;
//	}



	public HowMGWTTreeNode addHowMNode(HowMGWTFormBean nodeForm){
    
		HowMGWTTreeNode node = new HowMGWTTreeNode(this, nodeForm);		
        return node;
	}
 
	
	/**
	 * @return the found
	 */
	public boolean isFound() {
		return found;
	}

	/**
	 * @param found the found to set
	 */
	public void setFound(boolean found) {
		this.found = found;
	}

	/**
	 * @return the parentHowMFormToolbarEditTree
	 */
	public HowMGWTFormToolbarEditTree getParentHowMFormToolbarEditTree() {
		return parentHowMFormToolbarEditTree;
	}

	/**
	 * @param parentHowMFormToolbarEditTree the parentHowMFormToolbarEditTree to set
	 */
	public void setParentHowMFormToolbarEditTree(HowMGWTFormToolbarEditTree parentHowMFormToolbarEditTree) {
		this.parentHowMFormToolbarEditTree = parentHowMFormToolbarEditTree;
	}
	
	
	public HowMGWTTreeNode getHowMCurrentTreeNode(){
		if( this.getHowMTreeGrid().getSelectedRecord() != null )
			return (HowMGWTTreeNode)this.getHowMTreeGrid().getSelectedRecord();
		else{
			RecordList recordList = this.getHowMTreeGrid().getRecordList();
			if ( recordList.getLength() > 0 ){
				this.getHowMTreeGrid().selectRecord(0);
				return (HowMGWTTreeNode)this.getHowMTreeGrid().getSelectedRecord();
			}			
		}	
		return null;
	}

	public HowMGWTFormBean getHowMCurrentFormBean(){
		HowMGWTTreeNode node = getHowMCurrentTreeNode();
		if ( node != null )
			return node.getHowMFormBean();
		
		return null;
	}

	/**
	 * @return the howmIconName
	 */
	public String getHowmIconName() {
		return howmIconName;
	}

	/**
	 * @param howmIconName the howmIconName to set
	 */
	public void setHowmIconName(String howmIconName) {
		this.howmIconName = howmIconName;
	}

	/**
	 * @return the howMCustomIcon
	 */
	public boolean isHowMCustomIcon() {
		return howMCustomIcon;
	}

	/**
	 * @param howMCustomIcon the howMCustomIcon to set
	 */
	public void setHowMCustomIcon(boolean howMCustomIcon) {
		this.howMCustomIcon = howMCustomIcon;
	}

	/**
	 * @return the howmShowConnectors
	 */
	public boolean isHowmShowConnectors() {
		return howmShowConnectors;
	}

	/**
	 * @param howmShowConnectors the howmShowConnectors to set
	 */
	public void setHowmShowConnectors(boolean howmShowConnectors) {
		this.howmShowConnectors = howmShowConnectors;
	}

	/**
	 * @return the howMIconSize
	 */
	public int getHowMIconSize() {
		return howMIconSize;
	}

	/**
	 * @param howMIconSize the howMIconSize to set
	 */
	public void setHowMIconSize(int howMIconSize) {
		this.howMIconSize = howMIconSize;
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
	 * @return the howMBeanName
	 */
	public String getHowMBeanName() {
		return howMBeanName;
	}


	/**
	 * @param howMBeanName the howMBeanName to set
	 */
	public void setHowMBeanName(String howMBeanName) {
		this.howMBeanName = howMBeanName;
	}


	/**
	 * @return the howMFormBean
	 */
	public HowMGWTFormBean getHowMFormBean() {
		return howMFormBean;
	}


	/**
	 * @return the howMFieldGridName
	 */
	public ListGridField getHowMFieldGridName() {
		return howMPropertyFieldName.getListField();
	}


	/**
	 * @return the howMShowHeader
	 */
	public boolean isHowMShowHeader() {
		return howMShowHeader;
	}


	/**
	 * @param howMShowHeader the howMShowHeader to set
	 */
	public void setHowMShowHeader(boolean howMShowHeader) {
		this.howMShowHeader = howMShowHeader;
	}


	/**
	 * @return the howMPropertyFieldName
	 */
	public HowMGWTProperty getHowMPropertyFieldName() {
		return howMPropertyFieldName;
	}


	/**
	 * @param howMPropertyFieldName the howMPropertyFieldName to set
	 */
	public void setHowMPropertyFieldName(HowMGWTProperty howMPropertyFieldName) {
		this.howMPropertyFieldName = howMPropertyFieldName;
	}


	/**
	 * @return the howMFields
	 */
	public ArrayList<HowMGWTProperty> getHowMFields() {
		return howMFields;
	}


	/**
	 * @param howMFields the howMFields to set
	 */
	public void setHowMFields(ArrayList<HowMGWTProperty> howMFields) {
		this.howMFields = howMFields;
	}


	/**
	 * @return the howMCanEdit
	 */
	public boolean isHowMCanEdit() {
		return howMCanEdit;
	}


	/**
	 * @param howMCanEdit the howMCanEdit to set
	 */
	public void setHowMCanEdit(boolean howMCanEdit) {
		this.howMCanEdit = howMCanEdit;
	}


	/**
	 * @param howMFormBean the howMFormBean to set
	 */
	public void setHowMFormBean(HowMGWTFormBean howMFormBean) {
		this.howMFormBean = howMFormBean;
	}


	/**
	 * @return the howMModuleName
	 */
	public String getHowMModuleName() {
		return howMModuleName;
	}


	/**
	 * @param howMModuleName the howMModuleName to set
	 */
	public void setHowMModuleName(String howMModuleName) {
		this.howMModuleName = howMModuleName;
	}

	/**
	 * @return the howMModeLookup
	 */
	public boolean isHowMModeLookup() {
		return howMModeLookup;
	}


	/**
	 * @param howMModeLookup the howMModeLookup to set
	 */
	public void setHowMModeLookup(boolean howMModeLookup) {
		this.howMModeLookup = howMModeLookup;
	}	
	
	
    private HLayout rollOverCanvas;
    private ListGridRecord rollOverRecord;  
	
	protected com.smartgwt.client.widgets.Canvas onHowMGetRollOverCanvas(TreeGrid grid, Integer rowNum, Integer colNum) {  	  
 

            rollOverRecord = grid.getRecord(rowNum);  

            if(rollOverCanvas == null) {  
                rollOverCanvas = new HLayout();  
                rollOverCanvas.setSnapTo("TR");                
                rollOverCanvas.setWidth(16);  
                rollOverCanvas.setHeight(16);                  
                rollOverCanvas.setOverflow(Overflow.HIDDEN);
                
               // grid.setCellHeight(16);

                ImgButton editImg = new ImgButton();  
                
                editImg.setShowDown(false);  
                editImg.setShowRollOver(false);  
                editImg.setLayoutAlign(Alignment.CENTER);  
                editImg.setSrc("actions/ok.png");  
                editImg.setPrompt("Selecionar Registro");  
                editImg.setHeight(16);  
                editImg.setWidth(16);  
                editImg.addClickHandler(new ClickHandler()  {  
                    public void onClick(ClickEvent event) {  
                    	onHowMSelectRecord(rollOverRecord);
                    }  
                });   
                rollOverCanvas.addMember(editImg);  
            }  
            return rollOverCanvas;  
	}

	/**
	 * Retorna o parent node do nó.
	 * @param treeNode
	 * @return
	 */
	public TreeNode getHowMParentTreeNode(HowMGWTTreeNode treeNode){
		return this.howMTree.getParent(treeNode);
	}
	
	
	public void onHowMSelectRecord(ListGridRecord rollOverRecord){}
	public void onHowMBeforeTreeGrid(){};
	public void onHowMAfterTreeGrid(){}


	/**
	 * @return the howMShowPartialSelection
	 */
	public boolean isHowMShowPartialSelection() {
		return howMShowPartialSelection;
	}


	/**
	 * @param howMShowPartialSelection the howMShowPartialSelection to set
	 */
	public void setHowMShowPartialSelection(boolean howMShowPartialSelection) {
		this.howMShowPartialSelection = howMShowPartialSelection;
	}


	/**
	 * @return the howMCascadeSelection
	 */
	public boolean isHowMCascadeSelection() {
		return howMCascadeSelection;
	}


	/**
	 * @param howMCascadeSelection the howMCascadeSelection to set
	 */
	public void setHowMCascadeSelection(boolean howMCascadeSelection) {
		this.howMCascadeSelection = howMCascadeSelection;
	}


	/**
	 * @return the howMAlwaysShowEditors
	 */
	public boolean isHowMAlwaysShowEditors() {
		return howMAlwaysShowEditors;
	}


	/**
	 * @param howMAlwaysShowEditors the howMAlwaysShowEditors to set
	 */
	public void setHowMAlwaysShowEditors(boolean howMAlwaysShowEditors) {
		this.howMAlwaysShowEditors = howMAlwaysShowEditors;
	}


	/**
	 * @return the howMEditEvent
	 */
	public ListGridEditEvent getHowMEditEvent() {
		return howMEditEvent;
	}


	/**
	 * @param howMEditEvent the howMEditEvent to set
	 */
	public void setHowMEditEvent(ListGridEditEvent howMEditEvent) {
		this.howMEditEvent = howMEditEvent;
	}


	/**
	 * @return the howMShowAllColumns
	 */
	public Boolean getHowMShowAllColumns() {
		return howMShowAllColumns;
	}


	/**
	 * @param howMShowAllColumns the howMShowAllColumns to set
	 */
	public void setHowMShowAllColumns(Boolean howMShowAllColumns) {
		this.howMShowAllColumns = howMShowAllColumns;
	}


	/**
	 * @return the howMShowAllRecords
	 */
	public Boolean getHowMShowAllRecords() {
		return howMShowAllRecords;
	}


	/**
	 * @param howMShowAllRecords the howMShowAllRecords to set
	 */
	public void setHowMShowAllRecords(Boolean howMShowAllRecords) {
		this.howMShowAllRecords = howMShowAllRecords;
	}


	/**
	 * @param howMCurrentFormBean the howMCurrentFormBean to set
	 */
	public void setHowMCurrentFormBean(HowMGWTFormBean howMCurrentFormBean) {
		this.howMCurrentFormBean = howMCurrentFormBean;
	}


	/**
	 * @return the howMCellHeight
	 */
	public Integer getHowMCellHeight() {
		return howMCellHeight;
	}


	/**
	 * @param howMCellHeight the howMCellHeight to set
	 */
	public void setHowMCellHeight(Integer howMCellHeight) {
		this.howMCellHeight = howMCellHeight;
	}


	/**
	 * @return the howMHeaderHeight
	 */
	public Integer getHowMHeaderHeight() {
		return howMHeaderHeight;
	}


	/**
	 * @param howMHeaderHeight the howMHeaderHeight to set
	 */
	public void setHowMHeaderHeight(Integer howMHeaderHeight) {
		this.howMHeaderHeight = howMHeaderHeight;
	}


	/**
	 * @return the howMClientMode
	 */
	public boolean isHowMClientMode() {
		return howMClientMode;
	}


	/**
	 * @param howMClientMode the howMClientMode to set
	 */
	public void setHowMClientMode(boolean howMClientMode) {
		this.howMClientMode = howMClientMode;
	}


	/**
	 * @return the howMPropertyFieldOperation
	 */
	public HowMGWTProperty getHowMPropertyFieldOperation() {
		return howMPropertyFieldOperation;
	}


	/**
	 * @param howMPropertyFieldOperation the howMPropertyFieldOperation to set
	 */
	public void setHowMPropertyFieldOperation(HowMGWTProperty howMPropertyFieldOperation) {
		this.howMPropertyFieldOperation = howMPropertyFieldOperation;
	}


	/**
	 * @return the howMLastFormBeanQuery
	 */
	public HowMGWTFormBean getHowMLastFormBeanQuery() {
		return howMLastFormBeanQuery;
	}


	/**
	 * @param howMLastFormBeanQuery the howMLastFormBeanQuery to set
	 */
	public void setHowMLastFormBeanQuery(HowMGWTFormBean howMLastFormBeanQuery) {
		this.howMLastFormBeanQuery = howMLastFormBeanQuery;
	}


	/**
	 * @return the howMWrapCells
	 */
	public boolean isHowMWrapCells() {
		return howMWrapCells;
	}


	/**
	 * @param howMWrapCells the howMWrapCells to set
	 */
	public void setHowMWrapCells(boolean howMWrapCells) {
		this.howMWrapCells = howMWrapCells;
	}


	/**
	 * @return the howMCustomContext
	 */
	public String getHowMCustomContext() {
		return howMCustomContext;
	}


	/**
	 * @param howMCustomContext the howMCustomContext to set
	 */
	public void setHowMCustomContext(String howMCustomContext) {
		this.howMCustomContext = howMCustomContext;
	}


	/**
	 * @return the howMSelectRecordFinishLoad
	 */
	public boolean isHowMSelectRecordFinishLoad() {
		return howMSelectRecordFinishLoad;
	}


	/**
	 * @param howMSelectRecordFinishLoad the howMSelectRecordFinishLoad to set
	 */
	public void setHowMSelectRecordFinishLoad(boolean howMSelectRecordFinishLoad) {
		this.howMSelectRecordFinishLoad = howMSelectRecordFinishLoad;
	}


	/**
	 * @return the mapHowMFields
	 */
	public LinkedHashMap<String, HowMGWTProperty> getMapHowMFields() {
		return mapHowMFields;
	}


	/**
	 * @param mapHowMFields the mapHowMFields to set
	 */
	public void setMapHowMFields(LinkedHashMap<String, HowMGWTProperty> mapHowMFields) {
		this.mapHowMFields = mapHowMFields;
	}
	
	public void onHowAfterCreateTree(){}


	/**
	 * @return the howMTree
	 */
	public Tree getHowMTree() {
		return howMTree;
	}


	/**
	 * @return the howMNavegateToolsDatabase
	 */
	public ToolStrip getHowMNavegateToolsDatabase() {
		return howMNavegateToolsDatabase;
	};
	
	
	protected void onHowMBeforeLoader(HowMGWTFormBean formBean){}
	
	
	protected Canvas howMCreateRecordComponent(final ListGridRecord record, Integer colNum){		
		return null;
	}


	/**
	 * @return the howMShowRecordComponents
	 */
	public Boolean getHowMShowRecordComponents() {
		return howMShowRecordComponents;
	}


	/**
	 * @param howMShowRecordComponents the howMShowRecordComponents to set
	 */
	public void setHowMShowRecordComponents(Boolean howMShowRecordComponents) {
		this.howMShowRecordComponents = howMShowRecordComponents;
	}


	/**
	 * @return the howMShowRecordComponentsByCell
	 */
	public Boolean getHowMShowRecordComponentsByCell() {
		return howMShowRecordComponentsByCell;
	}


	/**
	 * @param howMShowRecordComponentsByCell the howMShowRecordComponentsByCell to set
	 */
	public void setHowMShowRecordComponentsByCell(Boolean howMShowRecordComponentsByCell) {
		this.howMShowRecordComponentsByCell = howMShowRecordComponentsByCell;
	}


	/**
	 * @return the howMCanExpandRecords
	 */
	public Boolean getHowMCanExpandRecords() {
		return howMCanExpandRecords;
	}


	/**
	 * @param howMCanExpandRecords the howMCanExpandRecords to set
	 */
	public void setHowMCanExpandRecords(Boolean howMCanExpandRecords) {
		this.howMCanExpandRecords = howMCanExpandRecords;
	}
	
	
	
	
	
	
	
	protected Canvas getHowMExpansionComponent(final ListGridRecord record) {
		return null;
	}
	
	public void addHowMProperty(HowMGWTProperty property) {
		
		if (property.getListField() == null) {
			property.createHowMGWTListGridField();
			property.getListField().setHidden(true);
		}
		
		this.getHowMFields().add(property);
		
	}
	
	public void addHowMProperty(HowMGWTProperty property, Integer wLabel, HowMGWTFormField formField ) {

		property.setBound(wLabel);
		addHowMProperty(property);
		
	}

	public void addHowMProperty(HowMGWTProperty property, Integer wLabel, Integer valueBound ) {

		property.setWidthColumn(valueBound);
		property.setBound(wLabel, valueBound);
		addHowMProperty(property);
		property.getListField().setWidth(valueBound);

	}
	
	public void addHowMProperty(HowMGWTProperty property, Integer wLabel, Integer valueBound, HowMGWTFormField formField ) {

		addHowMProperty(property, wLabel, valueBound);
	}

	public void addHowMProperty(HowMGWTProperty property, Integer wLabel, Integer valueBound, HowMGWTFormField formField, LinkedHashMap<String, String> mapValues ) {

		addHowMProperty(property, wLabel, valueBound, formField);
		
		if (property.getHowMFieldSelectItemEditor() != null) {
			property.getHowMFieldSelectItemEditor().getField().setValueMap(mapValues);
		} else if (property.getHowMFieldComboBoxEditor() != null) {
			property.getHowMFieldComboBoxEditor().getField().setValueMap(mapValues);
		}
		
	}

	
	protected String getHowMCellCSSText(ListGridRecord record, int rowNum, int colNum) {
		return null;
	}
	
	/**
	 * @return the howMCanSelectCells
	 */
	public boolean isHowMCanSelectCells() {
		return howMCanSelectCells;
	}


	/**
	 * @param howMCanSelectCells the howMCanSelectCells to set
	 */
	public void setHowMCanSelectCells(boolean howMCanSelectCells) {
		this.howMCanSelectCells = howMCanSelectCells;
	}
	
	protected String getHowMBaseStyle(ListGridRecord record, int rowNum, int colNum) {
		return null;
	}
	
	
    public ExpansionMode getHowMExpansionMode() {
		return howMExpansionMode;
	}


	public void setHowMExpansionMode(ExpansionMode howMExpansionMode) {
		this.howMExpansionMode = howMExpansionMode;
	}


	public String getHowMDetailField() {
		return howMDetailField;
	}


	public void setHowMDetailField(String howMDetailField) {
		this.howMDetailField = howMDetailField;
	}


	
	public Canvas getHowMCellHoverComponent(Record record, Integer rowNum, Integer colNum) {
		return null;
	}
	

	/**
	 * Retorna os dados da grid no formato de bean.
	 * @return
	 */
	public HowMGWTFormBean[] getHowMData(){

		HowMGWTFormBean[] howMData = null;

		RecordList recordList = this.getHowMTreeGrid().getRecordList();
		howMData = new HowMGWTFormBean[recordList.getLength()];

		int i = 0;
		for ( HowMGWTFormBean form : howMData ){
			HowMGWTTreeNode node = (HowMGWTTreeNode)recordList.get(i);
			HowMGWTFormBean formTreeNode = node.getHowMFormBean();
			howMData[i] = formTreeNode;
			i ++;
		}

		return howMData;
	}
	
	public HowMGWTFormSelectItem getHowMFieldSelectItemEditor() {
		if (this.formField instanceof HowMGWTFormSelectItem)
			return (HowMGWTFormSelectItem) this.formField;
		return null;
	}


	public String getHowMplaceHolder() {
		return howMplaceHolder;
	}


	public void setHowMplaceHolder(String howMplaceHolder) {
		this.howMplaceHolder = howMplaceHolder;
	}	
}