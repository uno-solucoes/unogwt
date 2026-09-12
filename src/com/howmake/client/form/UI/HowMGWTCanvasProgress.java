package com.howmake.client.form.UI;

 
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.BackgroundRepeat;
import com.smartgwt.client.types.BkgndRepeat;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class HowMGWTCanvasProgress extends HowMGWTWindowBase{

	private VLayout manager    = new VLayout();
	private VLayout mainLayout = new VLayout();
	
	private VLayout vAlingTitle = new VLayout();
	
	
	private VLayout vAlignTitleMessage = new VLayout();
	private HLayout	hTitleMessage  = new HLayout();
	private HTMLPane titleMessage  = new HTMLPane();
	
	private HTMLPane windowTitle   = new HTMLPane();
	
	
	private VLayout   mainBodyMessage = new VLayout();
	
	private Img imageInformation = new Img("window/messages/info.png",48,48);
	private Img imageWait = new Img("window/progress/wait.gif");
	
	private HTMLPane bodyMessage   = new HTMLPane();

	private HLayout  mainBorders   = new HLayout();
	
	private HLayout  leftBorder    = new HLayout();
	private HLayout  rightBorder   = new HLayout();
	private HLayout  topBorder     = new HLayout();
	
	
	private HLayout  bottonBorder  = new HLayout();
	private HLayout  bottonBorderLeft = new HLayout();
	private HLayout  bottonBorderCenter = new HLayout();
	private HLayout  bottonBorderRigth  = new HLayout();
	
	public HowMGWTCanvasProgress(boolean createBody){
		
		if ( createBody )
			this.createBody();
	}
	public HowMGWTCanvasProgress(){
		this(true);
	}

	public void createBody(){

		this.setShowHeader(false);
		this.setShowEdges(false);
				
		this.setEdgeOpacity(50);
		
		
		this.setHeight(this.getDefaultHeight()+"px");		
		
		this.mainBorders.setWidth100();
		this.mainBorders.setHeight100();

		leftBorder.setWidth("1px");
		leftBorder.setHeight100();
		leftBorder.setBackgroundImage("window/progress/all_border.gif");
		mainBorders.addMember(leftBorder);		
		
		topBorder.setWidth100();
		topBorder.setHeight("1px");
		topBorder.setBackgroundImage("window/progress/all_border.gif");
		topBorder.setBackgroundRepeat(BackgroundRepeat.REPEAT_X);
		mainLayout.addMember(topBorder);
		
		
		vAlignTitleMessage.setWidth100();
		vAlignTitleMessage.setAlign(VerticalAlignment.CENTER);
		vAlignTitleMessage.setHeight("45px");
	 
		imageInformation.setWidth("48px");
		imageInformation.setHeight("48px");
		
		titleMessage.setHeight("30px");
		titleMessage.setWidth100();
		titleMessage.setAlign(Alignment.LEFT);
		
		hTitleMessage.addMember(imageInformation);
		vAlignTitleMessage.addMember(titleMessage);
		
		hTitleMessage.setBackgroundImage("window/progress/bgr_message_title.gif");
		hTitleMessage.addMember(vAlignTitleMessage);
		
		mainLayout.addMember(hTitleMessage);

		windowTitle.setHeight("18px");
		windowTitle.setWidth100();
		windowTitle.setAlign(Alignment.LEFT);

		vAlingTitle.setAlign(VerticalAlignment.CENTER);
		vAlingTitle.setHeight("30px");
		vAlingTitle.setWidth100();
		vAlingTitle.setBackgroundColor("#FFFFFF");
		vAlingTitle.addMember(windowTitle);
		
		mainLayout.addMember(vAlingTitle);
	
		
		mainBodyMessage.setWidth100();
		mainBodyMessage.setHeight100();
		mainBodyMessage.setBackgroundColor("#FFFFFF");
 
		
		bodyMessage.setHeight100();
		bodyMessage.setWidth100();
		bodyMessage.setOverflow(Overflow.HIDDEN);

		imageWait.setWidth100();
		imageWait.setHeight("5px");
		mainBodyMessage.addMember(imageWait);
		
		bodyMessage.setMargin(6);
		mainBodyMessage.addMember(bodyMessage);
		
		mainLayout.addMember(mainBodyMessage);		
		
		
		mainLayout.setHeight100();
		mainLayout.setWidth100();
		mainBorders.addMember(mainLayout);

		rightBorder.setWidth("1px");
		rightBorder.setHeight100();
		rightBorder.setBackgroundImage("window/progress/all_border.gif");
		mainBorders.addMember(rightBorder);
		

		
		manager.addMember(mainBorders);
		
		
		
		
		
		
		bottonBorder.setWidth100();
	    bottonBorder.setHeight("8px");
	    
	    bottonBorderLeft.setWidth("100%");
	    bottonBorderLeft.setHeight("8px");
	    bottonBorderLeft.setBackgroundImage("window/progress/all_border.gif");
	    bottonBorderLeft.setBackgroundRepeat(BackgroundRepeat.REPEAT_X);
	    bottonBorder.addMember(bottonBorderLeft);	   
	    
	    bottonBorderCenter.setWidth("28px");
	    bottonBorderCenter.setHeight("8px");
	    bottonBorderCenter.setBackgroundImage("window/progress/botton_center.gif");
	    bottonBorderCenter.setBackgroundRepeat(BackgroundRepeat.NO_REPEAT);
	    bottonBorder.addMember(bottonBorderCenter);
	    
	    bottonBorderRigth.setWidth100();
	    bottonBorderRigth.setHeight("8px");
	    bottonBorderRigth.setBackgroundImage("window/progress/all_border.gif");
	    bottonBorderRigth.setBackgroundRepeat(BackgroundRepeat.REPEAT_X);
	    bottonBorder.addMember(bottonBorderRigth);
	    
	    manager.addMember(bottonBorder);
	    
	    
		//this.setIsModal(true);

		this.addItem(manager);
		
		

	}
	
	public void setTitleMessage(String text){
		this.titleMessage.setContents("<font style=\"margin: 6px;\">"+text+"</font>");
		System.out.println("Altura da janela de Texto : "+this.titleMessage.getHeight());
	}
	
	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		super.setTitle(title);
	
		this.windowTitle.setContents("<font style=\"margin: 10px; font-weight: bold; font-size=16;color:#BB5517;\">"+title+"</font>");
	}
	
	public void setMessage(String text){
		this.bodyMessage.setContents("<font style=\"margin: 6px;\">"+text+"</font>");
	}
	
	public void destroyProgress(){
		try{
			manager    = null;
			mainLayout = null;
			vAlingTitle = null;
			vAlignTitleMessage = null;
			hTitleMessage   = null;
			titleMessage   = null;
			windowTitle  = null;
			mainBodyMessage = null;
			imageInformation = null;
			imageWait = null;
			bodyMessage = null;
			mainBorders = null;
			leftBorder = null;
			rightBorder = null;
			topBorder = null;
			bottonBorder = null;
			bottonBorderLeft = null;
			bottonBorderCenter = null;
			bottonBorderRigth = null;
			this.hide();
			this.destroy();
		}
		catch(Throwable err){
			err.printStackTrace();
		}
	}
	
	public int getDefaultHeight(){
		return 150;
	}
}