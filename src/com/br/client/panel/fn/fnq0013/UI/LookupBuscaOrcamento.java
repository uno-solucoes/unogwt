package com.br.client.panel.fn.fnq0013.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.Services;
import com.br.client.panel.registro.UIPartner;
import com.howmake.client.form.UI.HowMGWTLookupWindow;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
 
public class LookupBuscaOrcamento extends HowMGWTLookupWindow implements UIPartner{

	private boolean fieldLocator = false;
	
	private HowMProperty pOrcamento	  = new HowMProperty("codOrcamento", "");
	private HowMProperty pNome		  = new HowMProperty("nome", "");
	private HowMProperty pSituacao    = new HowMProperty("situacao", "");
	private HowMProperty pCentroCusto = new HowMProperty("centroCusto", "");
	
	private FiltroConsulta filtroConsulta = new FiltroConsulta();
	private ResultadoConsulta resultadoResultado = new ResultadoConsulta(){
		public void onHowMFinishLoadDatabaseRecord(com.howmake.client.form.model.HowMGWTDataRecord currentRecord, int records){
			if ( fieldLocator ){				
				fieldLocator = false;
				if ( currentRecord != null && records == 1){
					onHowMSelectRecord(currentRecord);
				}	
			}
		}	
	};

	public LookupBuscaOrcamento(){
		super();
		
		this.setBackgroundColor("#FFFFFF");
	    this.setTitle(this.getHowMGWTPrograma()+"-"+this.getHowMGWTTitle());
		this.setLookupItems(filtroConsulta, resultadoResultado);		
		start();	
	}
	
	public void start(){
		this.setWidth("800px");
		this.setHeight("500px");
		this.filtroConsulta.setHeight("160px");
        this.centerInPage();
 	
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put(pOrcamento.getName(), pOrcamento);
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put(pNome.getName(), pNome);
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put(pSituacao.getName(), 	pSituacao);
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put(pCentroCusto.getName(), pCentroCusto);
	}

	@Override
	protected boolean onHowMPrepareFind(HowMGWTEntity entity){
		this.getToolbarNavegator().setActionClass(Services.acaoFNQ0013);
		pOrcamento.setValue(this.filtroConsulta.getFieldCodigoOrcamento().getField().getValueAsString());
		pNome.setValue(this.filtroConsulta.getFieldNome().getField().getValueAsString());
		pSituacao.setValue(this.filtroConsulta.getPropertySituacao().getFormField().getHowMValueAsString());
		pCentroCusto.setValue(this.filtroConsulta.getFieldCentroCusto().getSelectCCusto());
		
		return true;
	}

	/**
	 * @return the filtroConsulta
	 */
	public FiltroConsulta getFiltroConsulta() {
		return filtroConsulta;
	}

	/**
	 * @param filtroConsulta the filtroConsulta to set
	 */
	public void setFiltroConsulta(FiltroConsulta filtroConsulta) {
		this.filtroConsulta = filtroConsulta;
	}

	/**
	 * @return the resultadoResultado
	 */
	public ResultadoConsulta getResultadoResultado() {
		return resultadoResultado;
	}

	/**
	 * @param resultadoResultado the resultadoResultado to set
	 */
	public void setResultadoResultado(ResultadoConsulta resultadoResultado) {
		this.resultadoResultado = resultadoResultado;
	}

	@Override
	public String getHowMGWTPrograma() {
		return "FNQ0013";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloFNQ0013();
	}	

	
	/**
	 * @return the fieldLocator
	 */
	public boolean isFieldLocator() {
		return fieldLocator;
	}

	/**
	 * @param fieldLocator the fieldLocator to set
	 */
	public void setFieldLocator(boolean fieldLocator) {
		this.fieldLocator = fieldLocator;
	}
 
	
	public void clearFilters(){
		filtroConsulta.clearFilters();
	}
}