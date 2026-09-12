package com.br.client.panel.at.atw0117a;

import com.br.client.model.at.entity.eTouchLocalEspaco;
import com.smartgwt.client.widgets.IButton;

public class ActionLocalButton extends IButton{

	private eTouchLocalEspaco localEspaco;
	
	public eTouchLocalEspaco getLocalEspaco() {
		return localEspaco;
	}

	public void setLocalEspaco(eTouchLocalEspaco localEspaco) {
		this.localEspaco = localEspaco;
	}

	public ActionLocalButton(eTouchLocalEspaco localEspaco) {
		super(localEspaco.getDescAbrevLocal());		
		this.setLocalEspaco(localEspaco);
	}
}
