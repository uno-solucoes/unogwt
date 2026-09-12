package com.br.client.panel.vd.vdw0800.UI;

import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelLinksCidade extends VLayout{

	HTMLPane panel = new HTMLPane();
	
	public PainelLinksCidade() {
		
		this.setWidth100();
		this.setHeight100();

		HLayout top = new HLayout();
		top.setWidth100();
		top.setHeight(20);
		this.addMember(top);
		
		HLayout mainLayout = new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
	
		HLayout left = new HLayout();
		left.setWidth(20);
		left.setHeight100();
		mainLayout.addMember(left);
		
		this.panel.setWidth100();
		this.panel.setHeight100();
		
		mainLayout.addMember(panel);

		HLayout right = new HLayout();
		right.setWidth(20);
		left.setHeight100();
		mainLayout.addMember(right);

		
		this.addMember(mainLayout);
	
	}
	
	public void drawLinks(ListGridRecord record){
		if ( record != null ){
			if ( !HowMGWTUtilities.isEmpty(record.getAttribute("LINKS")) ){
				String html = "";
//				html += "<table style=\"width:100%; height:100%\" >";
//				html += "	<tr>";
//				html += "		<td style=\"width:400px; height:100%\">";
				html += record.getAttribute("LINKS");
//				html += "		<td>";
//				html += "		<td style=\"width:100%;>";
//				html += "			<iframe id=\"NEW\" name=\"NEW\" width=\"100%\" height=\"100%\" src=\"\" frameborder=\"0\" allowfullscreen></iframe>";
//				html += "		<td>";				
//				html += "	<tr>";
//				html += "</div>";
				this.panel.setContents(html);
			}
			else
				this.panel.setContents("");
		}
	}
}
