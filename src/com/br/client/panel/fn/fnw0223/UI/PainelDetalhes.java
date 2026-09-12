package com.br.client.panel.fn.fnw0223.UI;



import java.util.TreeMap;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.fn.fnw0223.model.EPlanoContas;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.model.HOWMGWTDataSourceQuery;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelDetalhes extends HowMGWTWindow{

	public static final int OPTION_CONTA_MES = 1;
	
	private PanelDetalhesResult detalhesResult;
	private PainelDetalhesTitulo detalhesTitulo = new PainelDetalhesTitulo();
	private PainelDetalhesTituloBaixas detalhesTituloBaixas = new PainelDetalhesTituloBaixas();
	private VLayout lDetalhesTitulo = new VLayout();
	
	private HLayout layout = new HLayout();
	
	public PainelDetalhes(){		

		this.setWidth("700px");
		this.setHeight("96%");
		this.centerInPage();
		this.setCanDragResize(true); 
	
		lDetalhesTitulo.setWidth100();
		lDetalhesTitulo.setHeight100();
		
		
		layout.setWidth100();
		layout.setHeight100();
		
		lDetalhesTitulo.addMember(detalhesTitulo);
		lDetalhesTitulo.addMember(detalhesTituloBaixas);
		detalhesTitulo.setDetalhesTituloBaixas(detalhesTituloBaixas);
		lDetalhesTitulo.setOverflow(Overflow.AUTO);
		this.addItem(layout);
		
	}
	
	
	@Override
	public String getHowMGWTPrograma() {		
		return "FNW0223D";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloFNW0223D();
	}
	
	public void showDetalhes(int option , EPlanoContas plano, int column, int row, ResultadoConsulta resultadoConsulta, TreeMap<String, EPlanoContas> planoContas, boolean callCentroCusto){
				                   
		if ( this.detalhesResult != null ){
			this.detalhesResult.clearAllRecords();
			this.layout.removeMember(this.detalhesResult);
			this.layout.removeMember(this.lDetalhesTitulo);
			this.detalhesResult.setDetalhesTitulo(null);
			this.detalhesResult = null;
		
			detalhesTitulo.setData(new ListGridRecord[0]);
			detalhesTituloBaixas.setRecords(new ListGridRecord[0]);
			
		}
		this.detalhesResult = null;
		detalhesResult = new PanelDetalhesResult();
		layout.addMember(this.detalhesResult);
		this.detalhesResult.setWidth("350px");
		this.detalhesResult.setHeight100();
		layout.addMember(this.lDetalhesTitulo);
		this.detalhesTitulo.setWidth100();

		this.detalhesResult.setDetalhesTitulo(this.detalhesTitulo);
		
		this.detalhesResult.setPlanoContas(planoContas);
		this.show();
		
		ListGridField field = resultadoConsulta.getTreeGrid().getField(column);
		String sqlAux = "";
		if ( option == OPTION_CONTA_MES ){
			sqlAux = "select * from (\n";
			sqlAux += resultadoConsulta.getSelect(true,field.getAttribute("mesRef"), plano.getKey(),null, callCentroCusto);
			sqlAux += ") as resultQuery\n";
			int sequencia = HowMGWTUtilities.getInteger(field.getAttribute("grupo"));
			if (sequencia > 0 ){
				sqlAux += "where\n";
				sqlAux += "	sequencia = "+sequencia+"\n";
			}
		}
		
		final String sql = sqlAux;
		Timer timer = new Timer() {
		
			@Override
			public void run() {
				HOWMGWTDataSourceQuery.executeQueryPopulate(sql , detalhesResult, true);				
			}
		};
		timer.schedule(100);

	}

	/**
	 * @return the detalhesResult
	 */
	public PanelDetalhesResult getDetalhesResult() {
		return detalhesResult;
	}

	/**
	 * @param detalhesResult the detalhesResult to set
	 */
	public void setDetalhesResult(PanelDetalhesResult detalhesResult) {
		this.detalhesResult = detalhesResult;
	}	
}