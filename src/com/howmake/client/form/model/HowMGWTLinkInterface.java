package com.howmake.client.form.model;

/**
 * @author JPLEISER
 */
public interface HowMGWTLinkInterface {
	public void setHowMLinkAction(HowMGWTLinkAction linkAction);
	public void setHowMGWTParentPlugIn(HowMGWTPlugInInterface parentHowMGWTPlugIn);
	public void onHowMGWTSelect(boolean selected);
}