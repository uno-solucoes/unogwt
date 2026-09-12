package com.br.client.panel.fn.fnw0235.UI;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.fn.fnw0217.model.DataSourceDetalheTitulo;
import com.howmake.client.form.model.HOWMGWTDataSourceQuery;
import com.howmake.client.form.model.HowMGWTCallImpl;
import com.howmake.client.form.model.HowMGWTDataRecord;
import com.howmake.shared.HowMGWTEntity;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class PainelDetalhesTitulo extends DetailViewer{ 
	
    private HowMGWTEntity detailEntity = Fabrica.createEntity();
	private DataSourceDetalheTitulo dsDetalheItem = new DataSourceDetalheTitulo();
	private String currentCodTituloParcela;
	PainelDetalhesTituloBaixas detalhesTituloBaixas;
	
	public PainelDetalhesTitulo(){
		this.setWidth100();
		this.setMargin(2); 
		this.setAutoHeight();
		this.setDataSource(dsDetalheItem);
		this.setEmptyMessage("Nenhum item encontrado...");  	
	}

	
	public void showDetalhes(final String codTitulo, final String codParcela, final String TipoConta, final String pessoa, final String chave){
		
		if ( ! (codTitulo+"-"+codParcela+"-"+TipoConta).equals(currentCodTituloParcela) ){

			HowMGWTCallImpl call = new HowMGWTCallImpl() {
				
				@Override
				public void onSuccess(HowMGWTEntity result) {
					if ( result.getThrowable() != null ){
						result.getThrowable().printStackTrace();
						return;
					}
						
					ListGridRecord[] records = new ListGridRecord[result.getData().size()];		 
					HowMGWTDataRecord record;
					int i = 0;
					for ( String[] row : result.getData()){
						record = new HowMGWTDataRecord();						
						dsDetalheItem.loadRecord(record, row);
						records[i] = record;
						i ++;
					}
					setData(records);
					
					String sql = "";
					if( "Despesa".equals(TipoConta))
						sql = "select hist.dt_conciliacao, hist.vl_baixa from fn_titulo_pagar_hist as hist where hist.cod_empresa = "+ Configuracao.getCodEmpresa() +" and hist.cod_titulo = "+codTitulo+" and hist.cod_parcela = "+codParcela+" and hist.cod_fornecedor = " +pessoa+ " and hist.cod_especie = '"+chave+ "' and tp_hist = 30 order by  hist.dt_conciliacao desc";
					else
						sql = "select hist.dt_conciliacao, hist.vl_baixa from fn_titulo_receber_hist as hist where hist.cod_empresa = "+ Configuracao.getCodEmpresa() +" and hist.cod_titulo = "+codTitulo+" and hist.cod_parcela = "+codParcela+" and  hist.serie = '" +chave+ "' and tp_hist = 30 order by  hist.dt_conciliacao desc";
					HOWMGWTDataSourceQuery.executeQueryPopulate(sql, detalhesTituloBaixas);
				}
			};
			String sql = "";
			if( "Despesa".equals(TipoConta))
				sql = dsDetalheItem.getSQLContasReceber(codTitulo, codParcela, "fn_titulo_pagar");
			else
				sql = dsDetalheItem.getSQLContasReceber(codTitulo, codParcela, "fn_titulo_receber");
			
			HOWMGWTDataSourceQuery.executeQuery(sql, call, detailEntity);
			
		}
	}


	/**
	 * @return the detalhesTituloBaixas
	 */
	public PainelDetalhesTituloBaixas getDetalhesTituloBaixas() {
		return detalhesTituloBaixas;
	}


	/**
	 * @param detalhesTituloBaixas the detalhesTituloBaixas to set
	 */
	public void setDetalhesTituloBaixas(
			PainelDetalhesTituloBaixas detalhesTituloBaixas) {
		this.detalhesTituloBaixas = detalhesTituloBaixas;
	}
 
}