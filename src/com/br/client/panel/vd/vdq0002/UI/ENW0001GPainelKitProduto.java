package com.br.client.panel.vd.vdq0002.UI;

import com.br.client.configuracao.Configuracao;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.model.HOWMGWTDataSourceQuery;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;

public class ENW0001GPainelKitProduto extends HowMGWTWindow{
	
	private Record parentRecord;
	
	private PainelGerenciadorProdutos gerenciadorProdutos;
	private PainelListaProduto parentPanelListProduto;
	
	private PainelListaProduto painelListaProduto;
	
	private String corpo;
	private String moeda = "R$";
	
	public ENW0001GPainelKitProduto(String corpo, boolean canEdit, String moeda){
		this.corpo = corpo;
		this.setMoeda(moeda);
		painelListaProduto = new PainelListaProduto(corpo,true, false, canEdit, false, moeda ){		

			public void onEventSelectFromAction(Record record, String codProduto){

				// Se já estiver atualizado, então retorna sem 
	    		// atualizar.
	        	if( record == gerenciadorProdutos.getCurrentRecord()  )
	        		return;

	        	gerenciadorProdutos.setCurrentRecord(record);			
	    		gerenciadorProdutos.showResumo( record, codProduto );
			}

			@Override
			public void onEventSelectEditRecord(Record record, String codProduto, int opcao){	
				gerenciadorProdutos.getPainelGerenciador().setCallFields(record, codProduto, opcao); 
			}

			public void onEventHowMGWTAfterQuery(final Record record){
				Timer timer = new Timer() {
					@Override
					public void run() {						
						String codProduto = record.getAttribute(getPainelListaProduto().getFieldCodProduto().getName());
			        	gerenciadorProdutos.setCurrentRecord(record);			
			    		gerenciadorProdutos.showResumo( record, codProduto );
					}
				};
				timer.schedule(100*1);
			}
		};		
		
		this.painelListaProduto.setShowKit(false);
		this.setWidth("740px");
		this.setHeight("450px");
		this.setIsModal(true);
		this.centerInPage();
		this.addItem(painelListaProduto);
		
		
		painelListaProduto.addSelectionChangedHandler(new SelectionChangedHandler() {
			@Override
			public void onSelectionChanged(SelectionEvent event) {
				if ( event.getSelectedRecord() != null ){
	        		Record record = event.getSelectedRecord();
	            	
	        		// Se já estiver atualizado, então retorna sem 
	        		// atualizar.
	            	if( record == getGerenciadorProdutos().getCurrentRecord())
	            		return;
	            	
	        		getGerenciadorProdutos().setCurrentRecord(record);
	        		
        			getGerenciadorProdutos().getResumoProduto().getPrecoProduto().clearAllRecords();
        			getGerenciadorProdutos().getResumoProduto().getGruposProduto().clearAllRecords();

        			getGerenciadorProdutos().getResumoProduto().getFieldCodigoProduto().setHowMValue("");
        			getGerenciadorProdutos().getResumoProduto().getDescricaoTecnica().setContents("");
        			if ( record == null )
        				return;
        			
        			String codProduto = record.getAttribute(painelListaProduto.getFieldCodProduto().getName());
			        getGerenciadorProdutos().showResumo(record, codProduto);
	        	}
			}
        });	
		
		
		this.setDismissOnEscape(true);
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				focus();
			}
		};
		timer.schedule(100);
	}

	
	public void showKit(PainelListaProduto parentPanelListProduto , Record record , String codProduto, String descProduto){
		
		this.setLeft(getGerenciadorProdutos().getAbsoluteLeft()-6);
		this.setTop(getGerenciadorProdutos().getAbsoluteTop());
		this.show();
			
		parentRecord = record;
		this.parentPanelListProduto = parentPanelListProduto;
		
		String sql = "";
		
		
		sql = "SELECT   ";
		sql += "    0 as qtde, ";
		sql += "    cd_produto.cod_produto fieldCodProduto,  ";
		sql += "	'' as fieldActionDetalheItem , ";
		sql += "    cd_marca.desc_abrev as fieldMarca, ";
		sql += "    cd_produto.desc_comercial as fieldDescricao , ";  
		sql += "	cd_produto.un as fieldUnidadeMedida, ";

		sql += "   ";

		sql += getCalculoEstoque(Configuracao.getCodEmpresa()) + " as \"fieldEstoqueDisponivel\", \n ";
		
		sql += "	'' as fieldIconeSimEst, ";
		sql += "	'' as fieldIconeEstEmpresa, ";

		sql += "( ";
		sql += "select ";
		sql += "        preco_unit ";
		sql += "from ";
        sql += "     cd_preco_item ";
        sql += "where ";
        sql += "	cod_produto = cd_produto.cod_produto ";
        sql += "    and ";
        sql += "	tb_preco     = '"+this.getPainelListaProduto().getTabPreco()+"' ";
        sql += "	and ";
        sql += "	qtd_min in (  select min(qtd_min) ";      
        sql += "               	  from   cd_preco_item  ";              
        sql += "               	  where  ";
        sql += "                           cod_produto = cd_produto.cod_produto ";
        sql += "                           and ";
        sql += "                           tb_preco     = '"+this.getPainelListaProduto().getTabPreco()+"' ";
        sql += "                ) ";
        sql += " ) as precoVendaConfigurador , \n";
        sql += " 0.0 as precoVendaST , \n";
        sql += "	'' as fieldIconePromocao, \n";
		sql += "	'' as fieldIconePrecoDif, \n";

		sql += "    cd_produto.desc_tecnica , \n"; 
		sql += "    cd_produto.observacao, \n";
		sql += "    '0' as possuiKit, \n";
		sql += " 	0.00 as precoLista,\n";
		sql += " 	0.00 as totalItem, \n";

		sql += getCalculoEstoque(Configuracao.getCodEmpresa()) + " as \"saldoEstoque\" ";

		sql += "FROM  ";
		sql += "    cd_produto_empresa, "; 
		sql += "	en_produto_estrutura, ";
		sql += "    cd_produto  ";
		sql += "    LEFT JOIN cd_marca ON ( cd_marca.cod_marca = cd_produto.cod_marca )   ";
		sql += "    LEFT JOIN cd_fornecedor ON ( cd_fornecedor.cod_fornecedor = cd_produto.cod_fornecedor )   ";
		sql += "WHERE  ";
		sql += "     cd_produto.cod_produto = cd_produto_empresa.cod_produto ";
		sql += "     AND  ";
		sql += "     cd_produto_empresa.cod_empresa = "+Configuracao.getCodEmpresa()+" "; 
		sql += "	 AND ";
		sql += "	 cd_produto.cod_produto = en_produto_estrutura.cod_produto ";
		sql += " 	 AND ";
		sql += "     en_produto_estrutura.cod_produto_pai = '"+codProduto+"'";
		sql += "     AND  ";
		sql += "     cd_produto_empresa.situacao = 1  ";
		sql += "ORDER BY cd_produto.cod_produto "; 
		HOWMGWTDataSourceQuery.executeQueryPopulate(sql, this.painelListaProduto, true, true);

	}
	
	/**
	 * Retorna a forma de calculo do estoque disponivel em forma de SQL;
	 * 
	 * @param situacaoDe
	 * @param situacaoAte
	 * @return
	 */
	public String getCalculoEstoque(String codEmpresa) {
		String situacaoDe = "20";
		String situacaoAte = "69";
		String sql = "";

		sql += " ";
		sql += "ifnull((\n";
		sql += "	(    SELECT \n";
		sql += "                SUM(eq_saldo.saldo_estoque) \n";
		sql += "         FROM \n";
		sql += "              eq_saldo, \n";
		sql += "              eq_deposito \n";
		sql += "         WHERE eq_saldo.cod_produto            = cd_produto_empresa.cod_produto \n";
		sql += "               AND eq_saldo.cod_empresa        = cd_produto_empresa.cod_empresa \n";
		sql += "               AND eq_saldo.cod_deposito       = eq_deposito.cod_deposito  \n";
		sql += "               AND eq_saldo.cod_empresa        = eq_deposito.cod_empresa \n";
		sql += "               AND eq_deposito.consulta_saldo  = 1  \n";
		sql += "     ) \n";
		sql += "        - \n";
		sql += "        ifnull(( \n";
		sql += "             SELECT  \n";
		sql += "                    sum(vd_pedido_item_aberto.qtd) \n";
		sql += "             FROM \n";
		sql += "                  vd_pedido_item_aberto, \n";
		sql += "                  vd_pedido, \n";
		sql += "                  cd_nop, \n";
		sql += "                  sg_colaborador \n";
		sql += "             WHERE \n";
		sql += "                   vd_pedido_item_aberto.cod_produto = cd_produto.cod_produto \n";
		sql += "                   AND \n";
		sql += "                   vd_pedido_item_aberto.cod_empresa = " + codEmpresa + " \n";
		sql += "                   AND \n";
		sql += "                   vd_pedido_item_aberto.cod_empresa = vd_pedido.cod_empresa \n";
		sql += "             	   AND \n";
		sql += "                   vd_pedido_item_aberto.cod_pedido = vd_pedido.cod_pedido \n";
		sql += "             	   AND \n";
		sql += "                   sg_colaborador.cod_colaborador = vd_pedido.cod_colaborador \n";
		sql += "             	   AND \n";
		sql += "                   cd_nop.nop = vd_pedido.nop \n";
		sql += "             	   AND \n";
		sql += "                   cd_nop.tp_nota_fiscal <> 1 \n";
		sql += "             	   AND \n";
		sql += "                   cd_nop.ind_baixa_estoque = 1 \n";
		sql += "                   AND \n";
		sql += "                   vd_pedido.situacao >= " + situacaoDe + " \n";
		sql += "                   AND \n";
		sql += "                   vd_pedido.situacao <= " + situacaoAte + "\n";
		sql += "        ),0)\n";
		sql += " ),0) \n";
		
		return sql;
	}

	/**
	 * @return the gerenciadorProdutos
	 */
	public PainelGerenciadorProdutos getGerenciadorProdutos() {
		return gerenciadorProdutos;
	}

	/**
	 * @param gerenciadorProdutos the gerenciadorProdutos to set
	 */
	public void setGerenciadorProdutos(PainelGerenciadorProdutos gerenciadorProdutos) {
		this.gerenciadorProdutos = gerenciadorProdutos;
	}

	/**
	 * @return the painelListaProduto
	 */
	public PainelListaProduto getPainelListaProduto() {
		return painelListaProduto;
	}

	/**
	 * @param painelListaProduto the painelListaProduto to set
	 */
	public void setPainelListaProduto(PainelListaProduto painelListaProduto) {
		this.painelListaProduto = painelListaProduto;
	}
	
	
	@Override
	public String getHowMGWTPrograma() {
		return "ENW0001G";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloENW0001G();
	}


	/**
	 * @return the moeda
	 */
	public String getMoeda() {
		return moeda;
	}


	/**
	 * @param moeda the moeda to set
	 */
	public void setMoeda(String moeda) {
		this.moeda = moeda;
		if ( this.painelListaProduto != null )
			this.painelListaProduto.setMoeda(moeda);
	}		
}