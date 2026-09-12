package com.howmake.client.form.UI;
 
import com.smartgwt.client.widgets.Window;

public class HowMGWTWindowBase extends Window{

	private String moduleName;
	private String moduleTitle;
	
	public HowMGWTWindowBase(){
		this.setEdgeImage("window/howmake/window.png");
		this.setShadowOffset(10);
	}

	/**
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * @param moduleName the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/**
	 * @return the moduleTitle
	 */
	public String getModuleTitle() {
		return moduleTitle;
	}

	/**
	 * @param moduleTitle the moduleTitle to set
	 */
	public void setModuleTitle(String moduleTitle) {
		this.moduleTitle = moduleTitle;
	}
}
