package com.br.client.panel.vd.vdp0001.UI;

import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.NumberFormat;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

public class SumarioVendas extends VLayout{
	String fontBegin = "<Font size='+1'>";
	String fontEnd   = "</Font>";

	HTMLPane mediaDiaVendas    = new HTMLPane();
	HTMLPane diasUteisPassados = new HTMLPane();
	HTMLPane diasUteisNoPeriodo= new HTMLPane();
	
	public SumarioVendas(){
		initUI();
	}
	
	public void initUI(){
		this.setWidth100();
		this.setHeight("60px");
		 
		String lblDiasUteisNoPeriodo = Tradutor.i18n.diasUteisNoPeriodo();
		lblDiasUteisNoPeriodo = lblDiasUteisNoPeriodo.replaceAll("_dias_", "<b>0</b>");

		mediaDiaVendas.setContents(fontBegin+Tradutor.i18n.mediaDiaVendas() + " : <b>R$ 0.00 </b>"+fontEnd);
		diasUteisPassados.setContents(fontBegin+Tradutor.i18n.diasUteisPassados()+" : <b>0</b>"+fontEnd);
		diasUteisNoPeriodo.setContents(fontBegin+lblDiasUteisNoPeriodo+fontEnd);
		
 
		this.mediaDiaVendas.setWidth("300px");
		this.addMember(mediaDiaVendas);
		 
		this.diasUteisPassados.setWidth("350px");
		this.addMember(diasUteisPassados);

		this.diasUteisNoPeriodo.setWidth("350px");
		this.addMember(diasUteisNoPeriodo);
	}
	
	public void showResult(HowMGWTEntity entity){
		
		HowMProperty pMediaDiasVenda = entity.getParameters().get("mediaDiasVendas");
		HowMProperty pDiasUteisMes   = entity.getParameters().get("diasUteisMes");
		HowMProperty pDiasUteis      = entity.getParameters().get("diasUteis");

		double mediaDiasVendas = 0.00;
		
		if ( pMediaDiasVenda != null )
			mediaDiasVendas = pMediaDiasVenda.getValueDouble().doubleValue();
		
		int diasUteisMes = 0;
		int diasUteis    = 0;
		
		if ( pDiasUteis != null && pDiasUteis.getValueInteger() != null )
			diasUteis = pDiasUteis.getValueInteger().intValue();
		
		if ( pDiasUteisMes != null && pDiasUteisMes.getValueInteger() != null )
			diasUteisMes = pDiasUteisMes.getValueInteger().intValue(); 
		
		mediaDiaVendas.setContents(fontBegin+Tradutor.i18n.mediaDiaVendas()+" : <b>R$ "+ NumberFormat.getFormat("###,###,###,###,###,##0.00").format(mediaDiasVendas) + "</b>" + fontEnd);
		diasUteisPassados.setContents(fontBegin+Tradutor.i18n.diasUteisPassados()+" : <b>"+diasUteis+"</b>" + fontEnd);
		diasUteisNoPeriodo.setContents(fontBegin+Tradutor.i18n.diasUteisNoPeriodo().replaceAll( "_dias_" , "<b>"+diasUteisMes+"</b>") + fontEnd);
	}
}
