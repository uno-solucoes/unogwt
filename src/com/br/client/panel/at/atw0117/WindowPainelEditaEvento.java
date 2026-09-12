package com.br.client.panel.at.atw0117;

import com.br.client.model.at.entity.eTouchAgenda;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.partner.HowMGWTConstants;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class WindowPainelEditaEvento extends Window{

	private DetailViewer detailViewer;
	
    DataSourceTextField itemNameField = new DataSourceTextField("itemName", "Item", 128, true);  
    
    private VLayout mainLayout = new VLayout();
    

	private ImgButton actionBack = new ImgButton();
    
	public WindowPainelEditaEvento(){

        this.setCanDrag(false);

        this.setBackgroundColor("#FFFAFA");
        
        this.setModalMaskOpacity(30);
        this.setShowModalMask(true);
       
		this.setWidth(600);
		this.setHeight(400);
		
		this.setShowHeader(false);
		this.setShowShadow(true);
		this.setShowEdges(false);
		
		mainLayout.setWidth100();
		mainLayout.setHeight100();
 
		VLayout formLayout = new VLayout();
		formLayout.setWidth100();
		formLayout.setHeight100();
		
		actionBack.setSrc("agenda/action_voltar_loop.png");
		actionBack.setWidth(48);
		actionBack.setHeight(48);
		this.actionBack.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				animateHide(AnimationEffect.FADE);
			}
		});
		
		this.mainLayout.addMember(formLayout);
	
		HLayout tools = new HLayout();
		tools.setWidth100();
		tools.setHeight(48);
		tools.setAlign(Alignment.RIGHT);
 
		tools.addMember(actionBack);
		tools.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(10, ""));
		
		mainLayout.addMember(tools);
		
        this.addItem(mainLayout); 
	
        this.setIsModal(true);
        this.centerInPage();
        
	}
	
	
	public void showTouchAgenda(eTouchAgenda touchAgenda){
		
		this.animateShow(AnimationEffect.FADE);
		
	}
}