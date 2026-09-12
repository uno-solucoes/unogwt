package com.howmake.client.form.UI;

import java.util.ArrayList;

import com.br.client.configuracao.Configuracao;
import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.model.HowMGWTLinkAction;
import com.howmake.client.form.model.HowMGWTLinkField;
import com.howmake.client.form.model.HowMGWTPlugInInterface;
import com.howmake.client.form.partner.HowMGWTConstants;
import com.howmake.client.form.partner.HowMGWTSelectPartner;
import com.howmake.shared.HowMGWTEntity;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.HeaderControls;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HeaderControl;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;

public abstract class HowMGWTLookupWindow extends HowMGWTWindowBase implements HowMGWTSelectPartner{

	public HowMGWTPlugInInterface parentHowMGWTPlugIn;
	public HowMGWTLinkAction linkdAction;
	public ArrayList<HowMGWTLinkField> linkFields = new ArrayList<HowMGWTLinkField>();
	
	HowMGWTToolbarNavegateCache toolbarNavegator;
	
	private SectionStack sectionStack = new SectionStack();     

	private SectionStackSection sessionFilter = new SectionStackSection();
    private SectionStackSection sessionResult = new SectionStackSection();   

	private Canvas filter;
	private HowMGWTListGrid result;
	
	public HowMGWTLookupWindow(){ 
			this.setShowModalMask(true);
			this.setModalMaskOpacity(HowMGWTConstants.WINDOW_MODAL_MASK_OPACITY);
			
	}
	
	public void setLookupItems(Canvas filter, HowMGWTListGrid result ){
		
	   result.setSelectPartner(this);
		

 
		ClickHandler clickHandler = new ClickHandler() {  
            public void onClick(ClickEvent event) {  
//                String src = ((HeaderControl) event.getSource()).getSrc();  
//                SC.say("Control " + src + " clicked ");  
            	HowMGWTWindowHelp.showHelp(getHowMGWTPrograma());
            }  
        };
        
       ClickHandler closeHandler = new ClickHandler() {  
            public void onClick(ClickEvent event) {  
            	HowMGWTLookupWindow.this.hide();
            }  
        };

        HeaderControl help = new HeaderControl(HeaderControl.HELP, clickHandler); 

        HeaderControl close = new HeaderControl(HeaderControl.CLOSE, closeHandler);  
        
        this.setHeaderControls(HeaderControls.HEADER_LABEL, new Label(Configuracao.getNativeUnoCorpoGWT()) ,help,close);
        this.setIsModal(true);

	        
		this.filter 	= filter;
	    this.filter.setShowHover(true);
        this.result 	= result;

        sectionStack.setWidth100();
        sectionStack.setHeight100();
  
        sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);  
        sectionStack.setAnimateSections(false);  
        sectionStack.setOverflow(Overflow.HIDDEN);  	    
	            
        sessionFilter.setTitle(Tradutor.i18n.criterioConsulta());  
        sessionFilter.setExpanded(true);  
        sessionFilter.setItems(this.filter);
        
        sessionResult.setExpanded(true); 
        sessionResult.setShowHeader(false);
        sessionResult.setItems(this.result);
        
        sectionStack.setSections(sessionFilter, sessionResult);
        
        this.addItem(sectionStack);
 
    	toolbarNavegator = new HowMGWTToolbarNavegateCache(result, true){
    			protected boolean onHowMPrepareFind(HowMGWTEntity entity){
    				return HowMGWTLookupWindow.this.onHowMPrepareFind(entity);
    			}
    	};
       	this.getResult().setCurrentEntity(this.toolbarNavegator.getCurrentEntity());
    	this.getResult().onHowMInitHeader();

    	this.addItem(toolbarNavegator);
    	
	}
 
	/**
	 * @return the sessionFilter
	 */
	public SectionStackSection getSessionFilter() {
		return sessionFilter;
	}

	/**
	 * @param sessionFilter the sessionFilter to set
	 */
	public void setSessionFilter(SectionStackSection sessionFilter) {
		this.sessionFilter = sessionFilter;
	}

	/**
	 * @return the sessionResult
	 */
	public SectionStackSection getSessionResult() {
		return sessionResult;
	}

	/**
	 * @param sessionResult the sessionResult to set
	 */
	public void setSessionResult(SectionStackSection sessionResult) {
		this.sessionResult = sessionResult;
	}

	/**
	 * @return the filter
	 */
	public Canvas getFilter() {
		return filter;
	}

	/**
	 * @param filter the filter to set
	 */
	public void setFilter(Canvas filter) {
		this.filter = filter;
	}

	/**
	 * @return the result
	 */
	public HowMGWTListGrid getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(HowMGWTListGrid result) {
		this.result = result;
	}
 	
	protected abstract boolean onHowMPrepareFind(HowMGWTEntity entity);

	
	/**
	 * Adiciona um Link para relacionar a grid com o campo que solicitou a lista.
	 * @param linkField
	 */
	public void addHowMLinkField( HowMGWTLinkField linkField){
		this.linkFields.add(linkField);
		
	}
	
	public void onHowMSelectRecord(Record record){
		
		for ( HowMGWTLinkField linkField : linkFields ){
			linkField.setTargetValue(record);
		}
				
		this.hide();
		if ( this.getHowMGWTLinkdAction() != null )
				this.getHowMGWTLinkdAction().onHowMSelectAction();
	}

	/**
	 * @return the toolbarNavegator
	 */
	public HowMGWTToolbarNavegateCache getToolbarNavegator() {
		return toolbarNavegator;
	}

	/**
	 * @param toolbarNavegator the toolbarNavegator to set
	 */
	public void setToolbarNavegator(HowMGWTToolbarNavegateCache toolbarNavegator) {
		this.toolbarNavegator = toolbarNavegator;
	}
 
	
	
	public abstract String getHowMGWTTitle();
	public abstract String getHowMGWTPrograma();


	/**
	 * @return the linkdAction
	 */
	public HowMGWTLinkAction getHowMGWTLinkdAction() {
		return linkdAction;
	}

	/**
	 * @param linkdAction the linkdAction to set
	 */
	public void setHowMGWTLinkdAction(HowMGWTLinkAction linkdAction) {
		this.linkdAction = linkdAction;
	}

	/**
	 * @return the parentHowMGWTPlugIn
	 */
	public HowMGWTPlugInInterface getParentHowMGWTPlugIn() {
		return parentHowMGWTPlugIn;
	}

	/**
	 * @param parentHowMGWTPlugIn the parentHowMGWTPlugIn to set
	 */
	public void setParentHowMGWTPlugIn(HowMGWTPlugInInterface parentHowMGWTPlugIn) {
		this.parentHowMGWTPlugIn = parentHowMGWTPlugIn;
	}
 
	
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		super.hide();
		if ( this.getParentHowMGWTPlugIn() != null )
			this.getParentHowMGWTPlugIn().retoreHowMGWTPlugIns();
	}
	
	@Override
	public void show() {
		if ( this.getParentHowMGWTPlugIn() != null )
			this.getParentHowMGWTPlugIn().hideHowMGWTPlugIns();
		// TODO Auto-generated method stub
		super.show();
	}
}