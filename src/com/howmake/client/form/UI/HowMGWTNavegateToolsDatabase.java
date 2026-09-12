package com.howmake.client.form.UI;

import com.howmake.client.form.model.entity.HowMGWTPageCache;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class HowMGWTNavegateToolsDatabase extends ToolStrip{

	private HowMGWTTreeGrid parentHowMTreeGrid;
	
	private HowMGWTPageCache howMPageCache;
	
	private IButton actionPrevious 	= new IButton();
	private IButton actionFirst 	= new IButton();
	
	private Label   recordNavegate  = new Label();
	
	private IButton actionNext  	= new IButton();
	private IButton actionLast		= new IButton();
	
	public HowMGWTNavegateToolsDatabase(HowMGWTTreeGrid parentHowMTreeGrid){
		
		this.parentHowMTreeGrid = parentHowMTreeGrid;
		
		actionFirst.setIcon("actions/first.png");
		actionFirst.setWidth(24);
		actionFirst.setHeight(22);
		actionFirst.addClickHandler(new ClickHandler() {			
			public void onClick(ClickEvent event) {
				onFirst();
			}
		});
		
		
		
		actionPrevious.setIcon("actions/btn_left_all.png");		
		actionPrevious.setWidth(24);
		actionPrevious.setHeight(22);
		actionPrevious.addClickHandler(new ClickHandler() {			
			public void onClick(ClickEvent event) {
				onPrevious();
			}
		});
		
		
		recordNavegate.setAlign(Alignment.CENTER);

		actionNext.setIcon("actions/btn_right_all.png");
		actionNext.setWidth(24);
		actionNext.setHeight(22);
		actionNext.addClickHandler(new ClickHandler() {			
			public void onClick(ClickEvent event) {
				onNext();
			}
		});
		
		actionLast.setIcon("actions/last.png");
		actionLast.setWidth(24);
		actionLast.setHeight(22);
		actionLast.addClickHandler(new ClickHandler() {			
			public void onClick(ClickEvent event) {
				onLast();
			}
		});
		
		this.addMember(actionFirst);
		this.addMember(actionPrevious);
		
		recordNavegate.setWidth(160);
		recordNavegate.setHeight(20);
		recordNavegate.setBackgroundColor("ffffff");
		
		this.addSeparator();
		this.addMember(recordNavegate);
		this.addSeparator();
		
		this.addMember(actionNext);
		this.addMember(actionLast);
	
		this.setAlign(Alignment.CENTER);
		
		
		// this.setHeight(24);
		this.setWidth100();

	}

	public void start(){
		this.actionFirst.setDisabled(true);
		this.actionPrevious.setDisabled(true);
		this.actionNext.setDisabled(true);
		this.actionLast.setDisabled(true);
		this.recordNavegate.setContents("não existe Itens...");
	}

	/**
	 * @return the howMPageCache
	 */
	public HowMGWTPageCache getHowMPageCache() {
		return howMPageCache;
	}

	
	
	
	/**
	 * Configura a barra de ferramentas usando os dados de navegação da cache atual.
	 * @param howMPageCache the howMPageCache to set
	 */
	public void setHowMPageCache(HowMGWTPageCache howMPageCache) {

		this.howMPageCache = howMPageCache;
		
		if( howMPageCache == null ){
			recordNavegate.setContents("não existe Itens...");
			this.actionNext.setDisabled(true);
			this.actionLast.setDisabled(true);
			this.actionPrevious.setDisabled(true);
			this.actionLast.setDisabled(true);
			return;
		}
		
		double maxRecord 		= HowMGWTUtilities.getInteger( howMPageCache.getMaxRecords() );
		double pageSize  		= HowMGWTUtilities.getInteger( howMPageCache.getPageSize() );
		double currentRecord 	= HowMGWTUtilities.getInteger( howMPageCache.getFirstRecord());

		double pages 		= 0.0;
		if ( maxRecord % pageSize == 0 )
			pages = maxRecord/pageSize;
		else
			pages = ((int)(maxRecord/pageSize)+1.0);
		
		double page = currentRecord / pageSize;
			page += 1;
		
		if ( pages <= 0 )
			recordNavegate.setContents("não existe Itens...");
		else{
			recordNavegate.setContents("Página "+HowMGWTUtilities.getObjectInteger(""+page)+"/"+HowMGWTUtilities.getObjectInteger(""+pages));			
		}

		pages = HowMGWTUtilities.getInteger(""+pages);
		
		if ( pages <= 1.0 ){
			this.actionNext.setDisabled(true);
			this.actionLast.setDisabled(true);
			this.actionPrevious.setDisabled(true);
			this.actionLast.setDisabled(true);
		}
		else{
			
			page = HowMGWTUtilities.getInteger(""+page);
			
			if( page >= pages ){
				this.actionNext.setDisabled(true);
				this.actionLast.setDisabled(true);
			}
			else{
				this.actionNext.setDisabled(false);
				this.actionLast.setDisabled(false);			
			}
	
			
			
			if( page <= 1 ){
				this.actionPrevious.setDisabled(true);
				this.actionFirst.setDisabled(true);
			}
			else{
				this.actionPrevious.setDisabled(false);
				this.actionFirst.setDisabled(false);
			}
		}
		
	}

	public void onPrevious(){	
		double pageSize  		= HowMGWTUtilities.getInteger( howMPageCache.getPageSize() );
		double currentRecord 	= HowMGWTUtilities.getInteger( howMPageCache.getFirstRecord());

		double page = currentRecord / pageSize;

		double goRecord = ((page*pageSize))-pageSize;
		if ( goRecord < 0 )
			goRecord = 0;
		this.howMPageCache.setCurrentRecord(""+HowMGWTUtilities.getObjectInteger(""+goRecord));
		

		howMPageCache.setObject(HowMGWTUtilities.PAGE_FIELD_NAME,(Object)null);
		
		this.parentHowMTreeGrid.getHowMFormBean().setObject("howMPageData", this.howMPageCache);
		
		parentHowMTreeGrid.executeHowMAction(this.parentHowMTreeGrid.getHowMAction(), this.parentHowMTreeGrid.getHowMBeanName(), this.parentHowMTreeGrid.getHowMFormBean());
	}
	
	public void onNext(){	
		double maxRecord 		= HowMGWTUtilities.getInteger( howMPageCache.getMaxRecords() );
		double pageSize  		= HowMGWTUtilities.getInteger( howMPageCache.getPageSize() );
		double currentRecord 	= HowMGWTUtilities.getInteger( howMPageCache.getFirstRecord());

		double page = currentRecord / pageSize;
		page += 2;

		double goRecord = ((page*pageSize))-(pageSize);
		this.howMPageCache.setCurrentRecord(""+HowMGWTUtilities.getObjectInteger(""+goRecord));
		

		howMPageCache.setObject(HowMGWTUtilities.PAGE_FIELD_NAME,(Object)null);
		
		this.parentHowMTreeGrid.getHowMFormBean().setObject("howMPageData", this.howMPageCache);
		
		parentHowMTreeGrid.executeHowMAction(this.parentHowMTreeGrid.getHowMAction(), this.parentHowMTreeGrid.getHowMBeanName(), this.parentHowMTreeGrid.getHowMFormBean());
	}
	
	public void onLast(){
		double maxRecord 		= HowMGWTUtilities.getInteger( howMPageCache.getMaxRecords() );
		double pageSize  		= HowMGWTUtilities.getInteger( howMPageCache.getPageSize() );
		double currentRecord 	= HowMGWTUtilities.getInteger( howMPageCache.getFirstRecord());

		Double pages 		= 0.0;
		if ( maxRecord % pageSize == 0 )
			pages = maxRecord/pageSize;
		else
			pages = ((int)(maxRecord/pageSize)+1.0);

		double goRecord = ((pages*pageSize))-pageSize;
		this.howMPageCache.setCurrentRecord(""+HowMGWTUtilities.getObjectInteger(""+goRecord));
		

		howMPageCache.setObject(HowMGWTUtilities.PAGE_FIELD_NAME,(Object)null);
		
		this.parentHowMTreeGrid.getHowMFormBean().setObject("howMPageData", this.howMPageCache);
		
		parentHowMTreeGrid.executeHowMAction(this.parentHowMTreeGrid.getHowMAction(), this.parentHowMTreeGrid.getHowMBeanName(), this.parentHowMTreeGrid.getHowMFormBean());
	}
	
	
	public void onFirst(){

		double goRecord = 1;
		this.howMPageCache.setCurrentRecord(""+HowMGWTUtilities.getObjectInteger(""+goRecord));

		howMPageCache.setObject(HowMGWTUtilities.PAGE_FIELD_NAME,(Object)null);
		
		this.parentHowMTreeGrid.getHowMFormBean().setObject("howMPageData", this.howMPageCache);
		
		parentHowMTreeGrid.executeHowMAction(this.parentHowMTreeGrid.getHowMAction(), this.parentHowMTreeGrid.getHowMBeanName(), this.parentHowMTreeGrid.getHowMFormBean());
	}	
}