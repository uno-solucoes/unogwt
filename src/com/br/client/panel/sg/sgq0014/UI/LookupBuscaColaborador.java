package com.br.client.panel.sg.sgq0014.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.Services;
import com.br.client.panel.registro.UIPartner;
import com.howmake.client.form.UI.HowMGWTLookupWindow;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
 
public class LookupBuscaColaborador extends HowMGWTLookupWindow implements UIPartner{
	private boolean fieldLocator = false;
	private HowMProperty pTpColaborador			= new HowMProperty("tpColaborador", 		"");
	private HowMProperty pCodColaborador 	  	= new HowMProperty("codColaboradorLista", 	"");
	private HowMProperty pNomeColaborador 	  	= new HowMProperty("nomeColaborador",	 	"");
	private HowMProperty pSituacao    			= new HowMProperty("situacaoColaborador", 	"");
	private HowMProperty pCnpj		  			= new HowMProperty("CNPJ", 					"");
	private HowMProperty pIdUsuario 			= new HowMProperty("idUsuario",	 			"");
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

	public LookupBuscaColaborador(){
		super();
	    this.setTitle(this.getHowMGWTPrograma()+"-"+this.getHowMGWTTitle());
		this.setLookupItems(filtroConsulta, resultadoResultado);		
		start();
		
		this.getToolbarNavegator().hideNavegateButton();
	}
	
	public void start(){
		this.setWidth("400px");
		this.setHeight("500px");
		this.filtroConsulta.setHeight("160px");
        this.centerInPage();
 	
        this.getToolbarNavegator().getCurrentEntity().getParameters().put(pTpColaborador.getName(),     pTpColaborador);
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put(pCodColaborador.getName(), 	pCodColaborador);
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put(pNomeColaborador.getName(), 	pNomeColaborador);
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put(pCnpj.getName(), 				pCnpj);
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put(pIdUsuario.getName(), 		pIdUsuario);
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put(pSituacao.getName(), 			pSituacao); 
    	this.getToolbarNavegator().getCurrentEntity().getParameters().put("acao",						pAcao);
	}
	

	@Override
	protected boolean onHowMPrepareFind(HowMGWTEntity entity){
		this.getToolbarNavegator().setActionClass(Services.acaoSGQ0014);
		pCodColaborador.setValue(this.filtroConsulta.getFieldCodColaborador().getField().getValueAsString());
		pNomeColaborador.setValue(this.filtroConsulta.getFieldNomeColaborador().getField().getValueAsString());
		pSituacao.setValue(this.filtroConsulta.getFieldSituacao().getValueAsString());
		pCnpj.setValue(this.filtroConsulta.getFieldCNPJ().getField().getValueAsString());
		pIdUsuario.setValue(this.filtroConsulta.getFieldIdUsuario().getField().getValueAsString());
		
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
		return "SGQ0014";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloSGQ0014();
	}

	/**
	 * @return the pTpColaborador
	 */
	public HowMProperty getpTpColaborador() {
		return pTpColaborador;
	}

	/**
	 * @param pTpColaborador the pTpColaborador to set
	 */
	public void setpTpColaborador(HowMProperty pTpColaborador) {
		this.pTpColaborador = pTpColaborador;
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