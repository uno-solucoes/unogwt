package com.br.client.panel.cc.ccq0003.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.Services;
import com.br.client.panel.registro.UIPartner;
import com.howmake.client.form.UI.HowMGWTLookupWindow;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
 
public class LookupBuscaFornecedor extends HowMGWTLookupWindow implements UIPartner{
	private boolean fieldLocator = false;
	private HowMProperty pCodFornecedor 	  	= new HowMProperty("codFornecedor", 		"");
	private HowMProperty pNomeFornecedor 	  	= new HowMProperty("nomeFornecedor",	 	"");
	private HowMProperty pAcao 					= new HowMProperty("acao", 					"listar");
 
	
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

	public LookupBuscaFornecedor(){
		super();
	    this.setTitle(this.getHowMGWTPrograma()+"-"+this.getHowMGWTTitle());
		this.setLookupItems(filtroConsulta, resultadoResultado);		
		start();
		
		this.getToolbarNavegator().hideNavegateButton();
	}
	
	public void start(){
		this.setWidth("650px");
		this.setHeight("550px");
		this.filtroConsulta.setHeight("80px");
        this.centerInPage();

        
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put(pCodFornecedor.getName(), 	pCodFornecedor);
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put(pNomeFornecedor.getName(), 	pNomeFornecedor);
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put("acao",						pAcao);
	}
	

	@Override
	protected boolean onHowMPrepareFind(HowMGWTEntity entity){
		this.getToolbarNavegator().setActionClass(Services.acaoCCQ0003);
		pCodFornecedor.setValue(this.filtroConsulta.getFieldCodFornecedor().getField().getValueAsString());
		pNomeFornecedor.setValue(this.filtroConsulta.getFieldNomeFornecedor().getField().getValueAsString());
		
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
		return "CCQ0003";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloSGQ0014();
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