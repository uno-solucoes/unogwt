package com.br.client.panel.fn.fnw0015.UI;

import com.howmake.client.form.UI.HowMGWTLabel;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelTitle extends VLayout{
	
	public PainelTitle(String backgroundColor, String title ){
		this(backgroundColor, title, 130, 22);
	}
	
	public PainelTitle(String backgroundColor, String title , int width, int height){
		
		HLayout margemLayoutTitleTitulos = new HLayout();
		margemLayoutTitleTitulos.setWidth100();
		margemLayoutTitleTitulos.setHeight("6px");
		margemLayoutTitleTitulos.setBackgroundColor(backgroundColor);
		// margemLayoutTitleTitulos.setOverflow(Overflow.HIDDEN);

		this.addMember(margemLayoutTitleTitulos);
		
		HLayout layoutTitleTitulos = new HLayout();
		layoutTitleTitulos.setWidth100();
		layoutTitleTitulos.setHeight(height+"px");
		layoutTitleTitulos.setBackgroundColor(backgroundColor);
		layoutTitleTitulos.setAlign(Alignment.CENTER);
		// layoutTitleTitulos.setOverflow(Overflow.HIDDEN);
	
		HowMGWTLabel label = new HowMGWTLabel();
		label.setAutoWidth();
		label.setWidth(width+"px");
		label.setAlign(Alignment.CENTER);
		label.setHowMValue(title);
		label.setOverflow(Overflow.HIDDEN);
		
		layoutTitleTitulos.addMember(label);
		this.addMember(layoutTitleTitulos);
	}
}
