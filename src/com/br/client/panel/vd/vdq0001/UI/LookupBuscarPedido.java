package com.br.client.panel.vd.vdq0001.UI;

 
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.vd.vdq0001.UI.FiltroConsulta;
import com.br.client.panel.vd.vdq0001.UI.ResultadoConsulta;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.Services;
import com.br.client.panel.registro.UIPartner;
import com.howmake.client.form.UI.HowMGWTLookupWindow;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;

public class LookupBuscarPedido extends HowMGWTLookupWindow implements UIPartner{

	private HowMProperty pCodigoCliente;
	private HowMProperty pSituacao;
	private HowMProperty pRazaoSocial;		
	private HowMProperty pCodVendedor;
	private HowMProperty pPedidoVenda;
	private HowMProperty pPedidoVendedor;
	private HowMProperty pPedidoComprador;	

	private FiltroConsulta filtroConsulta = new FiltroConsulta();
	private ResultadoConsulta resultadoResultado = new ResultadoConsulta();

	public LookupBuscarPedido(){
		super();
	    this.setTitle(this.getHowMGWTPrograma()+"-"+this.getHowMGWTTitle());    
		this.setLookupItems(filtroConsulta, resultadoResultado);
		
		start();
	}

	public void start(){
		this.setWidth("900px");
		this.setHeight("600px");
		
		this.centerInPage();

	}


	@Override
	protected boolean onHowMPrepareFind(HowMGWTEntity entity){
		this.getToolbarNavegator().setActionClass(Services.acaoVDQ0001);

		if ( this.pCodigoCliente == null ){		
			pCodigoCliente = Fabrica.createParameter(entity, "codigoCliente", "");
			entity.getParameters().put(pCodigoCliente.getName()		,pCodigoCliente);
		}

		if ( this.pSituacao == null ){
			pSituacao = Fabrica.createParameter(entity, "situacao", "");
			entity.getParameters().put(pSituacao.getName()			,pSituacao);
		}

		if ( this.pRazaoSocial == null ){
			pRazaoSocial = Fabrica.createParameter(entity, "razaoSocial", "");
			entity.getParameters().put(pRazaoSocial.getName()		,pRazaoSocial);			
		}
		
		if ( this.pCodVendedor == null ){
			pCodVendedor =  Fabrica.createParameter(entity, "codVendedor", "");
			entity.getParameters().put(pCodVendedor.getName()		,pCodVendedor);
		}

		if ( this.pPedidoVenda == null ){
			pPedidoVenda = Fabrica.createParameter(entity, "pedidoVenda", "");
			entity.getParameters().put(pPedidoVenda.getName()		,pPedidoVenda);
		}
		
		if ( this.pPedidoVendedor == null ){
			pPedidoVendedor =  Fabrica.createParameter(entity, "PedidoVendedor", "");
			entity.getParameters().put(pPedidoVendedor.getName()	,pPedidoVendedor);
		}
		
		if ( pPedidoComprador == null ){
			pPedidoComprador = Fabrica.createParameter(entity, "PedidoComprador", "");
			entity.getParameters().put(pPedidoComprador.getName()	,pPedidoComprador);
		}
 			
		pPedidoVenda.setValue(this.filtroConsulta.getFieldPedidoVenda().getField().getValueAsString());
		pCodigoCliente.setValue(this.filtroConsulta.getFieldCodigoCliente().getField().getField().getValueAsString());
		pSituacao.setValue(this.filtroConsulta.getFieldSituacao().getValueAsString());
		pRazaoSocial.setValue(this.filtroConsulta.getFieldRazaoSocial().getField().getValueAsString());

		pCodVendedor.setValue(this.filtroConsulta.getFieldCodVendedor().getField().getValueAsString());
		
		pPedidoVendedor.setValue(this.filtroConsulta.getFieldPedidoVendedor().getField().getValueAsString());
		pPedidoComprador.setValue(this.filtroConsulta.getFieldPedidoComprador().getField().getValueAsString());

		return true;
	}	

	@Override
	public String getHowMGWTPrograma() {
		return "VDQ0001";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloVDQ0001();
	}

	/**
	 * @return the resultadoResultado
	 */
	public ResultadoConsulta getResultadoResultado() {
		return resultadoResultado;
	}	

}