package com.howmake.client.form.UI;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class HowMGWTPanelDocumentBar extends HLayout{

	private Img img = new Img();
	private HowMGWTFormLabel help = new HowMGWTFormLabel("");
	private HowMGWTFormLabel titulo = new HowMGWTFormLabel();

	private ImgButton imgRefresh;
	private Img imgWait;
	private ImgButton imgBack;

	private String moduleName = "";
	
	public HowMGWTPanelDocumentBar(String icon, String title, String help){

		this.img.setSrc("atalhos/"+icon);
		
		this.titulo.setContents("<font size=5>"+title+"</font>");
		this.help.setContents(help);
		
		this.setWidth100();
		this.setHeight(60);
				
		VLayout vLayout = new VLayout();
		vLayout.setAlign(Alignment.CENTER);
		vLayout.setHeight100();
		vLayout.setWidth100();
		
		img.setHeight(48);
		img.setWidth(48);
		img.setAlign(Alignment.CENTER);
		this.addMember(img);
		
		this.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(10, ""));
		
		titulo.setStyleName("formTitleOptional");
		titulo.setOverflow(Overflow.HIDDEN);
		titulo.setHeight(25);
		titulo.setWidth100();
		vLayout.addMember(titulo);
		
		vLayout.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(1,HowMGWTUtilities.backgroundSeparadora));
		
		this.help.setStyleName("formTitleOptional");
		this.help.setHeight(30);
		this.help.setWidth100();
		vLayout.addMember(this.help);

		
		this.addMember(vLayout);
		
	}
	
	
	public ImgButton createHowMActionRefresh(){

		if( imgRefresh == null ){
			imgRefresh = new ImgButton();		
			imgRefresh.setWidth(48);
			imgRefresh.setHeight(48);
			imgRefresh.setPrompt("Clique aqui <br>para executar <br>a consulta.");
			imgRefresh.setAlign(Alignment.CENTER);
			this.imgRefresh.setSrc("atalhos/ico_refresh_big.png");
	
			this.addMember(imgRefresh);
			
			imgWait = new Img();		
			imgWait.setWidth(48);
			imgWait.setHeight(48);
			imgWait.setAlign(Alignment.CENTER);
			this.imgWait.setSrc("window/progress/ajax-loader.gif");
			
			imgBack = new ImgButton();		
			imgBack.setWidth(48);
			imgBack.setHeight(48);
			imgBack.setAlign(Alignment.CENTER);
			imgBack.setPrompt("Clique aqui <br>para voltar <br>para a consulta.");
			this.imgBack.setSrc("atalhos/ico_back_big.png");			
			
			
		}
		
		return imgRefresh;		
	}


	/**
	 * @return the imgRefresh
	 */
	public ImgButton getImgRefresh() {
		return imgRefresh;
	}


	/**
	 * @param imgRefresh the imgRefresh to set
	 */
	public void setImgRefresh(ImgButton imgRefresh) {
		this.imgRefresh = imgRefresh;
	}


	public void howMShowProgress(){
		this.removeMember(imgRefresh);
		this.addMember(imgWait);
		this.redraw();
	}

	public void howMHideProgress(){
		this.removeMember(imgWait);
		this.addMember(imgRefresh);
		this.redraw();
	}
	
	public void howMShowBack(){
		this.removeMember(imgRefresh);
		this.addMember(imgBack);
		this.redraw();
	}
	
	public void howMHideBack(){
		this.removeMember(imgBack);
		this.addMember(imgRefresh);
		this.redraw();
	}


	/**
	 * @return the imgBack
	 */
	public ImgButton getImgBack() {
		return imgBack;
	}


	/**
	 * @param imgBack the imgBack to set
	 */
	public void setImgBack(ImgButton imgBack) {
		this.imgBack = imgBack;
	}	
	

	
	public void setHowMGWTIconHeader(String icon){
		this.img.setSrc("atalhos/"+icon);		
	}
	
	public void setHowMGWTTitleHeader(String title){
		this.titulo.setContents("<font size=5>"+title+"</font>");		
	}
	
	public void setHowMGWTHelpHeader(String help){
		this.help.setContents(help);		
	}
}
