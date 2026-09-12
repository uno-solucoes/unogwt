package com.howmake.client.form.UI;


import java.util.ArrayList;
import java.util.TreeMap;

import org.moxieapps.gwt.uploader.client.File;

import com.google.gwt.user.client.Timer;
import com.howmake.client.form.model.HowMGWTFile;
import com.howmake.client.form.model.HowMGWTFolder;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class HowMGWTUploadListFolders extends TreeGrid{
 
	private static final String FILE_OBJECT = "fileObject";
	
	HowMGWTUploadDialog panelUploadDialog;
		
    TreeMap< String , HowMGWTFolder> mapFolders = new TreeMap<String,HowMGWTFolder>();
	
	Tree tree;
	TreeGridField fieldNome = new TreeGridField("Desc", "Pastas");
	
	public HowMGWTUploadListFolders(HowMGWTUploadDialog panelUploadDialog){

		this.panelUploadDialog = panelUploadDialog;
		
		this.setShowHeader(true);
		this.setTitle("Pastas");		
        this.setWidth("170px");  
        this.setHeight100();  
        this.setShowOpenIcons(false);  
        this.setShowDropIcons(false);  
        this.setClosedIconSuffix("");  
        this.setFields(fieldNome);  
        this.setData(new Tree()); 

        this.setShowAllRecords(true);
        

        this.setSelectionType(SelectionStyle.SINGLE);
        
        this.setShowHeader(true);
		
		this.setCanDragReposition(false);
		
		this.addSelectionChangedHandler(new SelectionChangedHandler() {
			
			@Override
			public void onSelectionChanged(SelectionEvent event) {

				addFiles(new ArrayList<File>());
				// HowMGWTUploadListFolders.this.panelUploadDialog.getToolbarUploadFiles().getActionDeleteFiles().setDisabled(true);
			}
		});
	}

	
	/**
	 * Cria uma classe para representação de um nó de grupo
	 */
    public static class FolderTreeNode extends TreeNode {  
        public FolderTreeNode( HowMGWTUploadListFolders panelListFolder, String folder, String desc) { 
            this.setAttribute("folder", folder);
            this.setAttribute("folderPai", "");  
            this.setAttribute(panelListFolder.fieldNome.getName(), desc);
        }
    	public FolderTreeNode( HowMGWTUploadListFolders panelListFolder, String folder) { 
    		this.setAttribute("folder", folder);
    		this.setAttribute("folderPai", "");  
    		this.setAttribute(panelListFolder.fieldNome.getName(), folder);  
        }
    }


    /**
     * Apresenta as pastas e arquivos no diálogo 
     * @param folders
     */
    public void showFolders(ArrayList<TreeNode> folders){
  
    	Object[] keyFolders = this.mapFolders.keySet().toArray();
    	// Limpa as caches em uso.
    	HowMGWTFolder folder;
    	for( Object keyFolder : keyFolders ){
    		folder = this.mapFolders.get(keyFolder);
    		folder.getFiles().clear();
    	}
    	this.panelUploadDialog.getPanelListFiles().clearAllRecords();

    	
    	TreeNode[] nodeFolders = new TreeNode[folders.size()];
		int i = 0;
		for ( TreeNode node : folders){
			nodeFolders[i] = node;
			folder = new HowMGWTFolder();
			folder.setFolderName(node.getAttributeAsString("folder"));
			folder.setFiles(new TreeMap<String, ListGridRecord>());
			folder.setTreeNode(node);
			this.mapFolders.put(folder.getFolderName(), folder);
			i++;
		}
		
		tree = new Tree();
		tree.setModelType(TreeModelType.PARENT);

		tree.setRootValue("");  
		tree.setIdField("folder");
		tree.setParentIdField("folderPai");
		tree.setNameProperty(fieldNome.getName());
		tree.setData(nodeFolders);
 		
		this.setData(tree);

		this.getData().openAll(); 		

    
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				if ( getRecords().length > 0)
					selectRecord(0);
			}
		};
		timer.schedule(30);
    }
    
    public String getFolderName(){
    	if( this.getSelectedRecord() != null ){
	    	ListGridRecord currentNode = this.getSelectedRecord();     	
	    	String folderName = currentNode.getAttributeAsString("folder");
			HowMGWTFolder folder = this.mapFolders.get(folderName);	
			return folder.getFolderName();
    	}
    	return "";
    }
    
    
    public void addFiles(ArrayList<File> files){
    	ListGridRecord currentNode = this.getSelectedRecord();
    	if( currentNode == null )
    		return;

    	String folderName = currentNode.getAttributeAsString("folder");
		if ( folderName == null )
			return;
		
		HowMGWTFolder folder = this.mapFolders.get(folderName);

		for ( File file : files ){ 
			ListGridRecord record = new ListGridRecord();
 	
			String type = file.getType();
			if ( HowMGWTUtilities.isEmpty( type )){
				type = "";
			}
			else
				type = HowMGWTUtilities.replace(type, ".", "").toUpperCase();
			
			long size = file.getSize();
			
			long cSize = size/1024;
			
			String sSize = "";
			if ( cSize > 0 ){
				sSize = cSize+ " KB   ";
			}
			else
				sSize = size + " Bytes";
			
			record.setAttribute(this.panelUploadDialog.getPanelListFiles().fieldFileName.getName(), file.getName());
			record.setAttribute(this.panelUploadDialog.getPanelListFiles().fieldFileType.getName(), type);
			record.setAttribute(this.panelUploadDialog.getPanelListFiles().fieldFileSize.getName(), sSize);
			record.setAttribute(this.panelUploadDialog.getPanelListFiles().fieldFileStatus.getName(), HowMGWTUploadSelectFiles.STATUS_PENDENTE);
			
			record.setAttribute(FILE_OBJECT, file);
			folder.getFiles().put(file.getName(),  record);
		}
		this.panelUploadDialog.getPanelListFiles().showFiles(folder.getFiles());
    }
    
	
    /**
     * @return Retorna uma lista de arquivos que serão transmitidos para o servidor.
     */
	public ArrayList<HowMGWTFile> getTransferFiles(){
		
		ArrayList<HowMGWTFile> files = new ArrayList<HowMGWTFile>();
		
		// Recupera as chaves das estruturas de pastas.
		Object[] keys = this.mapFolders.keySet().toArray();
		
		for ( Object key : keys){
			// Recupera o nó da pasta
			TreeMap<String,ListGridRecord> nodes = ((HowMGWTFolder)this.mapFolders.get(key)).getFiles();
			
			// Recupera as chaves dos nós dos arquivos.
			Object[] nodeKeys = nodes.keySet().toArray();
			for ( Object nodeKey : nodeKeys ){
				// Recupera o registro do arquivo
				ListGridRecord recordFile = nodes.get(nodeKey);
				// Verifica se o arquivo está pendente para envio.
				if( recordFile.getAttributeAsString(panelUploadDialog.getPanelListFiles().fieldFileStatus.getName()).equalsIgnoreCase(HowMGWTUploadSelectFiles.STATUS_PENDENTE)){
					
					// Cria um objeto com o nome da pasta para onde será enviado o objeto do arquivo.
					HowMGWTFile file = new HowMGWTFile(key.toString(), (File)recordFile.getAttributeAsObject(FILE_OBJECT));
					file.setRecord(recordFile);
					files.add(file);
				}
			}
		}
		
		return files;
	}



	/**
	 * @return the mapFolders
	 */
	public TreeMap<String, HowMGWTFolder> getMapFolders() {
		return mapFolders;
	}



	/**
	 * @param mapFolders the mapFolders to set
	 */
	public void setMapFolders(TreeMap<String, HowMGWTFolder> mapFolders) {
		this.mapFolders = mapFolders;
	}

    
}