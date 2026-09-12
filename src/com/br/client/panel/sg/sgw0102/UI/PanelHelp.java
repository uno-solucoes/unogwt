package com.br.client.panel.sg.sgw0102.UI;

import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VLayout;

public class PanelHelp extends VLayout{

	public PanelHelp(){
		
		this.setWidth100();
		this.setHeight(110);
		
		this.setBackgroundColor("#FFFACD");
		
		this.setOverflow(Overflow.HIDDEN);

		Label label = new Label();

		String html = "";

		this.addMember(HowMGWTUtilities.getCanvasHorizontalSeparetor(1, HowMGWTUtilities.backgroundSeparadora));

		html += "<html>\n";
		html += "<head>\n";
		html += "	<title>Editor HTML Online</title>\n";
		html += "</head>\n";
		html += "<body>\n";
		html += "	<li>Dois <strong><u>e</u></strong> comerciais&nbsp;<strong><span style=\"color: rgb(0, 0, 255);\">&amp;&amp;</span></strong>&nbsp;- Pesquisa com E &nbsp;</li>\n";
		html += "	<li>Dois <strong><u>pipes</u></strong><strong>&nbsp;<span style=\"color: rgb(0, 0, 255);\">||</span>&nbsp;</strong>- Pesquisa com OU</li>\n";
		html += "	<hr>\n";
		html += "	<strong>Exemplo 1:&nbsp;</strong>Para localizar um arquivo ou diret&oacute;rio que possua a palavra <span style=\"color: rgb(0, 0, 255);\"><strong>&quot;teste&quot;</strong></span> <strong>e</strong> a palavra <span style=\"color: rgb(0, 0, 255);\"><strong>&quot;.pdf&quot;</strong></span>, neste caso voc&ecirc; dever&aacute; utilizar o seguinte crit&eacute;rio de pesquisa: <span style=\"color: rgb(0, 0, 255);\"><strong>teste &amp;&amp; .pdf .</strong></span>\n";
		html += "	<BR>\n";
		html += "	<strong>Exemplo 2:&nbsp;</strong>Para localizar um arquivo ou diret&oacute;rio que possua a palavra<strong><span style=\"color:#0000ff;\"> &quot;teste&quot; </span>ou</strong> a palavra <span style=\"color:#0000ff;\"><strong>&quot;Servi&ccedil;os&quot;</strong></span>, neste caso voc&ecirc; dever&aacute; utiliar o seguinte crit&eacute;rio de pesquisa : <span style=\"color:#0000ff;\"><strong style=\"color: rgb(0, 0, 255);\">teste || Servi&ccedil;os&nbsp;</strong></span><strong style=\"color: rgb(0, 0, 255);\">.</strong>\n";
		html += "	<BR>\n";
		html += "	<strong>Exemplo 2: </strong>Voc&ecirc; pode combinar a pesquisa utilizando E ou OU, por exemplo:&nbsp;<span style=\"color: rgb(0, 0, 255);\"><strong>teste &amp;&amp; .pdf ||&nbsp;</strong></span><strong style=\"color: rgb(0, 0, 255);\">teste || Servi&ccedil;os</strong>\n";
		html += "</body>\n";
		html += "</html>\n";

		label.setContents(html);

		this.addMember(label);
	}	
}
