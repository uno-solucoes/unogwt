package com.br.client.panel.cd.cdq0101.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.Services;
import com.br.client.panel.registro.UIPartner;
import com.howmake.client.form.UI.HowMGWTLookupWindow;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
 
public class LookupBuscaCliente extends HowMGWTLookupWindow implements UIPartner{

	private boolean fieldLocator = false;
	
	private HowMProperty pCliente 	  = new HowMProperty("codCliente", 		"");
	private HowMProperty pNomeCliente = new HowMProperty("nomeCliente",	 	"");
	private HowMProperty pSituacao    = new HowMProperty("situacaoCliente", "");
	private HowMProperty pCnpj		  = new HowMProperty("CNPJ", 			"");
	private HowMProperty pRazaoSocial = new HowMProperty("razaoSocial",	 	"");
	private HowMProperty pObsContato  = new HowMProperty("obsContato", 		"");		
	
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

	public LookupBuscaCliente(){
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
 	
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put(pCliente.getName(), 	pCliente);
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put(pNomeCliente.getName(), pNomeCliente);
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put(pSituacao.getName(), 	pSituacao);
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put(pCnpj.getName(), 		pCnpj);
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put(pRazaoSocial.getName(), pRazaoSocial);
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put(pObsContato.getName(), 	pObsContato);
	}

	@Override
	protected boolean onHowMPrepareFind(HowMGWTEntity entity){
		this.getToolbarNavegator().setActionClass(Services.acaoCDQ0101);
		pCliente.setValue(this.filtroConsulta.getFieldCodigoCliente().getField().getValueAsString());
		pNomeCliente.setValue(this.filtroConsulta.getFieldNomeCliente().getField().getValueAsString());
		pSituacao.setValue(this.filtroConsulta.getFieldSituacao().getValueAsString());
		pCnpj.setValue(this.filtroConsulta.getFieldCNPJ().getField().getValueAsString());
		pRazaoSocial.setValue(this.filtroConsulta.getFieldRazaoSocial().getField().getValueAsString());
		pObsContato.setValue(this.filtroConsulta.getFieldObsContato().getField().getValueAsString());
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
		return "CDQ0101";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloCDQ0101();
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