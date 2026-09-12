package com.br.client.panel.vd.vdq0002.UI;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.Services;
import com.google.gwt.user.client.Window;
import com.howmake.client.form.UI.HowMGWTPanelSectionStack;
import com.howmake.client.form.UI.HowMGWTToolbarNavegateCache;
import com.howmake.client.form.model.HOWMGWTDataSourceQuery;
import com.howmake.client.form.model.HowMGWTDataRecord;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelGerenciadorProdutos extends HLayout {

	private boolean firstLoad = false;
	private boolean fieldLocator = false;
	
	private String corpo;
	
	private Record currentRecord;
	
	private String inCodCliente;
	private String inTabPreco;
	private String indServico = "0";

	private PainelGerenciador painelGerenciador;
	private FiltroConsulta filtroConsulta;
	private PainelResumoProduto resumoProduto;
	private PainelListaProduto listaProduto;
	private PainelListaProduto listaSimilares;
	private PainelListApelidosProduto listApelidosProduto;
	
	// private PainelListaProduto listaKits 		= new PainelListaProduto();
	private HowMGWTToolbarNavegateCache toolbarNavegatorListaProdutos;
	
    private VLayout estruturaLayoutProduto;
    VLayout mainLayout = new VLayout();
    
    private HowMGWTPanelSectionStack sessionListaProduto;
	
	private boolean canEdit = true;
	private boolean lookup  = false;
	private boolean menu    = false;
	
	private String moeda 	= "R$";
	
	public PainelGerenciadorProdutos(String corpo, boolean canEdit, boolean lookup, String moeda){		
		
		this.canEdit = canEdit;
		this.lookup  = lookup;
		this.setMoeda(moeda);
		
		this.corpo = corpo;

		resumoProduto 	= new PainelResumoProduto(this.corpo);

		listaProduto 	= new PainelListaProduto(corpo, false,false, canEdit, lookup, moeda){	 
			@Override
			public void onEventSelectEditRecord(Record record, String codProduto,int opcao){	
				painelGerenciador.setCallFields(record, codProduto, opcao);
			}
 
			public void onHowMFinishLoadDatabaseRecord(com.howmake.client.form.model.HowMGWTDataRecord currentRecord, int records){
				if ( fieldLocator ){				
					fieldLocator = false;
					if ( currentRecord != null && records == 1){
						selectRecordAndClose(PainelGerenciadorProdutos.this.currentRecord, OPCAO_ACAO_LOOKUP);
					}	
					else if ( currentRecord == null || records == 0){
						SC.say(Tradutor.i18n.msgRegistroNaoEncontrado());
					}
					else{
						getPainelGerenciador().onShowLookup();
					}
				}
				else{
					
					if ( "0002".equals(PainelGerenciadorProdutos.this.corpo)){
						if ( records == 0 ){
													}
						else{
							if ( menu ){
								filtroConsulta.getFieldCodigoProduto().setHowMValue("");
								filtroConsulta.getPropertyBusca().getHowMGWTEditorFieldText().setHowMValue("");
							}
							else{
//								if ( firstLoad ){
//									filtroConsulta.getFieldCodigoProduto().setHowMValue("");
//									filtroConsulta.getPropertyBusca().getHowMGWTEditorFieldText().setHowMValue("");
//									filtroConsulta.onConfigureFirst(this, currentRecord);
//									
//								}
//								else
									filtroConsulta.onConfigure(this, currentRecord);
								firstLoad = false;
							}
						}
					}
					else if ( "0003".equals(PainelGerenciadorProdutos.this.corpo)){
						if ( records == 0 ){
							
						}
						else{
							filtroConsulta.getFieldCodigoProduto().setHowMValue("");
						}
					}

				}
			}	
			
		};

		if ( "0002".equals(corpo)){
			listApelidosProduto = new PainelListApelidosProduto();
		}
		else if ( "0003".equals(corpo)){
			listApelidosProduto = new PainelListApelidosProduto();
		}
		else{
			listaSimilares 	= new PainelListaProduto(corpo, true,false, this.canEdit, this.lookup, moeda){
 
				@Override
				public void onEventSelectEditRecord(Record record, String codProduto,  int opcao){	
					painelGerenciador.setCallFields(record, codProduto, opcao);
				}	
				
			};		
		}
		
		toolbarNavegatorListaProdutos = new HowMGWTToolbarNavegateCache(listaProduto, false ){
				protected boolean onHowMPrepareFind(HowMGWTEntity entity){
					
			  		HowMProperty pCodigoProduto 	  		= new HowMProperty("codigoProduto", filtroConsulta.getFieldCodigoProduto().getField().getValueAsString());			// ok
			  		entity.getParameters().put(pCodigoProduto.getName(), pCodigoProduto);
			  		
					HowMProperty pMarca 	  		  		= new HowMProperty("marca", filtroConsulta.getFieldMarca().getField().getValueAsString());					// ok
			  		entity.getParameters().put(pMarca.getName(), pMarca);
					
					HowMProperty pFamilia		 	  		= new HowMProperty("familia", filtroConsulta.getFieldFamilia().getField().getValueAsString());					// ok
			  		entity.getParameters().put(pFamilia.getName(), pFamilia);

					HowMProperty pSomenteEst 	  			= new HowMProperty("SomenteEst", filtroConsulta.getFieldSomenteEst().getField().getValueAsBoolean());				
			  		entity.getParameters().put(pSomenteEst.getName(), pSomenteEst);

					HowMProperty pCodigoProdutoFornecedor 	= new HowMProperty("CodigoProdutoFornecedor", filtroConsulta.getFieldCodigoProdutoFornecedor().getField().getValueAsString());	// ok
			  		entity.getParameters().put(pCodigoProdutoFornecedor.getName(), pCodigoProdutoFornecedor);

					HowMProperty pDescricaoAbreviada 	  	= new HowMProperty("DescricaoAbreviada", filtroConsulta.getFieldDescricaoAbreviada().getField().getValueAsString());		
			  		entity.getParameters().put(pDescricaoAbreviada.getName(), pDescricaoAbreviada);

					HowMProperty pApelido 	  				= new HowMProperty("Apelido", filtroConsulta.getFieldApelido().getField().getValueAsString());					// ok
			  		entity.getParameters().put(pApelido.getName(), pApelido);

					HowMProperty pDescricaoTecnica 	  		= new HowMProperty("descricaoTecnica", filtroConsulta.getFieldDescricaoTecnica().getField().getValueAsString());			// ok
			  		entity.getParameters().put(pDescricaoTecnica.getName(), pDescricaoTecnica);
					
					HowMProperty pTabelaPreco 	  			= new HowMProperty("TabelaPreco", getInTabPreco());															 	// ok
			  		entity.getParameters().put(pTabelaPreco.getName(), pTabelaPreco );

			  		HowMProperty pCorpoPrograma 			= new HowMProperty("corpoPrograma", PainelGerenciadorProdutos.this.corpo );
			  		entity.getParameters().put(pCorpoPrograma.getName(), pCorpoPrograma);
			  		
			  		
			  		if ( ! HowMGWTUtilities.isEmpty( filtroConsulta.getCodFonecedor() ) ){
						HowMProperty pCodFornecedor 	  		= new HowMProperty("codFornecedor", filtroConsulta.getCodFonecedor());															 	// ok
				  		entity.getParameters().put(pCodFornecedor.getName(), pCodFornecedor );
				  		
						HowMProperty pProdutoInformadoFornecedor= new HowMProperty("produtoInformadoFornecedor", true );															 	// ok
				  		entity.getParameters().put(pProdutoInformadoFornecedor.getName(), pProdutoInformadoFornecedor );
				  		
				  		
			  		}
				  		
			  		if ( fieldLocator ){
				  		Fabrica.createParameter(entity, "buscaMultipla"  , filtroConsulta.BUSCA_MULTIPLA_COD_PRODUTO );	  					  			
				  		Fabrica.createParameter(entity, "buscaAproximada", false );
			  		}
			  		else{
				  		Fabrica.createParameter(entity, "buscaMultipla"  , filtroConsulta.getBuscaMultipla() );	  		
				  		Fabrica.createParameter(entity, "buscaAproximada", filtroConsulta.isBuscaAproximada());
					}
				
			  		// Pega os grupos de produtos selecionados para consulta, se não houver
			  		// grupos selecionados recupera todos os grupos.
			  		String grupoProdutos = "";
			  		if ( filtroConsulta.getPainelGruposProduto() != null )
			  			grupoProdutos = filtroConsulta.getPainelGruposProduto().getSelectGrupos();

			  		HowMProperty pGrupoProdutos 	  			= new HowMProperty("grupoProduto", grupoProdutos);															 	// ok
			  		entity.getParameters().put(pGrupoProdutos.getName(), pGrupoProdutos );
			  		
			  		Fabrica.createParameter(entity, "buscaServico", getIndServico());
			  		
			  		currentRecord = null;
			  		clearAllData();
					
					return true;
				}
				
				public void onEventHowMGWTSelectFirstRecord(Record record){	
					showAllDetail(record);
				}
				
				
				protected void onHowMLoadRecord(HowMGWTDataRecord record){		
					record.setAttribute(getListaProduto().fieldPrecoLista.getName(), HowMGWTUtilities.getDouble(record.getAttribute(getListaProduto().fieldPrecoVenda.getName())));
					
					listaProduto.converteMoeda(record, getListaProduto().fieldPrecoLista, getMoeda());
					listaProduto.converteMoeda(record, getListaProduto().fieldPrecoVenda, getMoeda());
				
				}

			};		
		
		
		
		
		this.setWidth100();  
        this.setHeight100();	
        
        this.listaProduto.setPainelGerenciadorProduto(this);

        if ( this.listaSimilares != null )
        	this.listaSimilares.setPainelGerenciadorProduto(this);

        toolbarNavegatorListaProdutos.setActionClass(Services.acaoVDQ0002);

        mainLayout.setWidth100();        

        // ----------------------------------------------------------------
        VLayout lListaProduto = new VLayout();
        lListaProduto.setWidth100();
        lListaProduto.setHeight100();      

        listaProduto.setWidth100();
        listaProduto.setHeight100();
        
        if ( listaSimilares != null ){
	        listaSimilares.addSelectionChangedHandler(new SelectionChangedHandler() {
				@Override
				public void onSelectionChanged(SelectionEvent event) {
					if ( event.getSelectedRecord() != null ){						 
						showListaSimilaresDetalhes(event.getSelectedRecord());
					}
				}
			});	        
        }
        
        listaProduto.addSelectionChangedHandler(new SelectionChangedHandler() {
			@Override
			public void onSelectionChanged(SelectionEvent event) {
				if ( event.getSelectedRecord() != null ){					 
					showListaProdutoDetalhes(event.getSelectedRecord());
				}
			}
		});

        
        
        
    	lListaProduto.addMember(listaProduto);
    	lListaProduto.addMember(toolbarNavegatorListaProdutos);
        
	    // ---------------------------------------------------------------------    	

    	
    	
        sessionListaProduto = new HowMGWTPanelSectionStack(Tradutor.i18n.formListaProdutos(), lListaProduto);
        sessionListaProduto.setWidth100();
        // Se não for modo de edição inclui icone inforativa para lista de seleção.
        if ( ! this.canEdit ){
        	sessionListaProduto.setHeaderHeight(40);

        	Img imgSend = new Img("tools/bot_list_send.png");
	        imgSend.setHeight(32);
	        imgSend.setWidth(32);
	        sessionListaProduto.getSession().setControls(imgSend);
	        sessionListaProduto.setHeight100();
		}
        else
            sessionListaProduto.setHeight("60%");        

        mainLayout.addMember(sessionListaProduto);     
        
        // -----------------------------------------------------------------
        
        
        estruturaLayoutProduto = new VLayout();
        estruturaLayoutProduto.setWidth100();
        estruturaLayoutProduto.setHeight("40%");

        if ( listaSimilares != null ){
	        // ----------------------------------------------------------------- 
	        listaSimilares.setWidth100();

	        HowMGWTPanelSectionStack sessionListaSimilares = new HowMGWTPanelSectionStack(Tradutor.i18n.formListProdutosSimilares(), listaSimilares);
	        sessionListaSimilares.setWidth100();
	        if ( canEdit ){
	        	sessionListaSimilares.setHeight("50%");        
	        	sessionListaProduto.setShowResizeBar(true);
	        }
	        estruturaLayoutProduto.addMember(sessionListaSimilares);
	        // -----------------------------------------------------------------
        }
        else{
        	listApelidosProduto.setWidth100();
	        HowMGWTPanelSectionStack sessionListaSimilares = new HowMGWTPanelSectionStack(Tradutor.i18n.formConversaoApelido(), listApelidosProduto);
	        sessionListaSimilares.setWidth100();
	        if ( canEdit ){
		        sessionListaSimilares.setHeight("50%");        
		        sessionListaProduto.setShowResizeBar(true);
	        }
	        estruturaLayoutProduto.addMember(sessionListaSimilares);
        }
        

 
        mainLayout.addMember(estruturaLayoutProduto);
        
        

        resumoProduto.setWidth("270px");
        
        this.addMember(mainLayout);
        this.addMember(resumoProduto);
        
         
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
	 * @return the listaProduto
	 */
	public PainelListaProduto getListaProduto() {
		return listaProduto;
	}


	/**
	 * @param listaProduto the listaProduto to set
	 */
	public void setListaProduto(PainelListaProduto listaProduto) {
		this.listaProduto = listaProduto;
	}


	/**
	 * @return the toolbarNavegatorListaProdutos
	 */
	public HowMGWTToolbarNavegateCache getToolbarNavegatorListaProdutos() {
		return toolbarNavegatorListaProdutos;
	}


	/**
	 * @param toolbarNavegatorListaProdutos the toolbarNavegatorListaProdutos to set
	 */
	public void setToolbarNavegatorListaProdutos(
			HowMGWTToolbarNavegateCache toolbarNavegatorListaProdutos) {
		this.toolbarNavegatorListaProdutos = toolbarNavegatorListaProdutos;
	}
	
	public void clearAllData(){


		resumoProduto.getPrecoProduto().clearAllRecords();
		resumoProduto.getGruposProduto().clearAllRecords();
		
		resumoProduto.getFieldCodigoProduto().setHowMValue("");
		resumoProduto.getDescricaoTecnica().setContents("");
		
	}
	
	
	/**
	 * Mostra todos os detalhes do produto.
	 * @param record
	 */
	public void showAllDetail(Record record){
		
		// Se já estiver atualizado o registro em questão
		// retorna e não executa nenhuma ação.
		if ( record == currentRecord)
			return;
		
		currentRecord = record;
		
   		if ( record == null ){
			resumoProduto.getPrecoProduto().clearAllRecords();
			resumoProduto.getGruposProduto().clearAllRecords();
			if ( listaSimilares != null )
				listaSimilares.clearAllRecords();

			resumoProduto.getFieldCodigoProduto().setHowMValue("");
			resumoProduto.getDescricaoTecnica().setContents("");
			return;
		}
		String codProduto = record.getAttribute(listaProduto.getFieldCodProduto().getName());
		showResumo(record, codProduto);
		
		String sql = "";
		if (listaSimilares != null ){
			sql = "";
			sql += "SELECT DISTINCT  ";
			sql += "    0 as qtde, ";	
			sql += "    cd_produto.cod_produto fieldCodProduto,  ";
			sql += "	'' as fieldActionDetalheItem , ";
			sql += "    cd_marca.desc_abrev as fieldMarca, ";
			sql += "    cd_produto.desc_comercial as fieldDescricao , ";
			
			sql += "	cd_produto.un as fieldUnidadeMedida, ";
			
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
	        sql += "	tb_preco     = '"+this.getInTabPreco()+"' ";
	        sql += "	and ";
	        sql += "	qtd_min in (  select min(qtd_min) ";      
	        sql += "               	  from   cd_preco_item  ";              
	        sql += "               	  where  ";
	        sql += "                           cod_produto = cd_produto.cod_produto ";
	        sql += "                           and ";
	        sql += "                           tb_preco     = '"+this.getInTabPreco()+"' ";
	        sql += "                ) ";
	        sql += " ) as precoVendaConfigurador,  ";		
	        sql += " 0.0 as precoVendaST , \n";			
			
			sql += "	'' as fieldIconePromocao, ";
			sql += "	'' as fieldIconePrecoDif, ";
	
			sql += "    cd_produto.desc_tecnica , "; 
			sql += "    cd_produto.observacao,   ";
			
			sql += "    ( "+
			 " 		select count(1) " +
			 " 		from en_produto_estrutura \n"+
			 " 		where en_produto_estrutura.cod_produto_pai = cd_produto.cod_produto " +
			 "  ) as possuiKit, ";
			sql += " 0.00 precoLista,\n";
			sql += " 0.00 totalItem \n";
			sql += "FROM  ";
			sql += "    cd_produto_empresa, "; 
			sql += "	cd_produto_similar, "; 
			sql += "    cd_produto  ";
			sql += "    LEFT JOIN cd_marca ON ( cd_marca.cod_marca = cd_produto.cod_marca )   ";
			sql += "    LEFT JOIN cd_fornecedor ON ( cd_fornecedor.cod_fornecedor = cd_produto.cod_fornecedor )   ";
			sql += "WHERE  ";
			sql += "     cd_produto.cod_produto = cd_produto_empresa.cod_produto ";
			sql += "     AND  ";
			sql += "     cd_produto_empresa.cod_empresa = "+Configuracao.getCodEmpresa()+" "; 
			sql += "	 AND ";
			sql += "	 cod_produto_similar = cd_produto.cod_produto ";
			sql += " 	 AND ";
			sql += "     cd_produto_similar.cod_produto = '"+codProduto+"'";
			sql += "     AND  ";
			sql += "     cd_produto_empresa.situacao = 1  ";
			sql += "ORDER BY cd_produto.cod_produto "; 
			// System.out.println(sql);
			HOWMGWTDataSourceQuery.executeQueryPopulate(sql, listaSimilares );		
		}
		else{
			sql = "";
			sql += "select\n";
			sql += "    apelido,\n";
			sql += "	descricao\n";
			sql += "from \n";
			sql += "	cd_produto_apelido\n";
			sql += "where \n";
			sql += "	cod_produto = '"+codProduto+"'\n";
			HOWMGWTDataSourceQuery.executeQueryPopulate(sql , listApelidosProduto);
		}
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
	 * Le os dados de resumo.
	 * @param record
	 * @param codProduto
	 */
	public void showResumo(Record record, String codProduto){
		String sql = "";


		
		String descricaoComercial = record.getAttribute(listaProduto.getFieldDescricaoComercial().getName());
		resumoProduto.getFieldCodigoProduto().setHowMValue("<font color='blue'><b>"+codProduto+"</b><br>"+descricaoComercial+"</font>");
		
		String descricaoTecnica   = record.getAttribute(listaProduto.getFieldDescricaoTecnica().getName());
		resumoProduto.getDescricaoTecnica().setHowMValue(descricaoTecnica);
		
		// System.out.println("descricao tecnica : "+descricaoTecnica);
		
		sql  = "select ";
		sql += "	tb_preco, ";
		sql += "	qtd_min, ";
		sql += "	preco_unit ";
		sql += "from ";
		sql += "	cd_preco_item ";
		sql += "where ";
		sql += "	cod_produto = '"+codProduto+"'";
		if ( ! HowMGWTUtilities.isEmpty(this.getInTabPreco()) ){
			sql += "	and ";
			sql += "	tb_preco = '"+this.getInTabPreco().trim()+"' ";
		}
		sql += "order by tb_preco desc ";
		HOWMGWTDataSourceQuery.executeQueryPopulate(sql, resumoProduto.getPrecoProduto());	
		
		// Somente busca os grupos de produtos se for corpo 0001.
		if ( "0001".equals(corpo) ){
			sql  = "";
			sql += "select ";
			sql += "	cd_grupo_produto.desc_abrev ";
			sql += "from cd_grupo_item ";
			sql += "     inner join cd_grupo_produto ";
			sql += "           on cd_grupo_produto.cod_grupo_produto = cd_grupo_item.cod_grupo_produto ";
			sql += "where ";
			sql += "      cd_grupo_item.cod_produto = '"+codProduto+"'";
			HOWMGWTDataSourceQuery.executeQueryPopulate(sql, resumoProduto.getGruposProduto() );				
		}		
		
		/** 
		 * Busca as ultimas vendas do cliente 
		 */
		sql  = " ";

		sql += "SELECT \n";
		sql += "	vd_nota_fiscal.nome_cliente,\n";
		// sql += "	vd_nota_fiscal.cod_nota_fiscal ,\n";
		sql += "	concat(concat(vd_nota_fiscal.nr_nota_fiscal,'-'),vd_nota_fiscal.serie), \n";
		sql += "	vd_nota_fiscal.dt_emissao, \n";
		sql += "	sum(vd_nota_fiscal_item.qtd), \n";
		sql += "	sum(vd_nota_fiscal_item.preco_venda) \n";
		sql += "FROM \n";
		sql += "	vd_nota_fiscal \n";
		sql += "	INNER JOIN vd_nota_fiscal_item \n";
		sql += "	ON \n";
		sql += "		vd_nota_fiscal_item.cod_empresa      = vd_nota_fiscal.cod_empresa \n";
		sql += "		AND \n";
		sql += "		vd_nota_fiscal_item.cod_nota_fiscal  = vd_nota_fiscal.cod_nota_fiscal \n";
		// Se corpo 0002, inclui o cliente na busca para restringir por grupo de cliente.
		if ( "0002".equals(corpo) ){
		     sql += "	INNER JOIN cd_cliente \n";
		     sql += "	on\n";
		     sql += "		cd_cliente.cod_cliente = vd_nota_fiscal.cod_cliente\n";			
		}
		else if ( "0003".equals(corpo) ){
		     sql += "	INNER JOIN cd_cliente \n";
		     sql += "	on\n";
		     sql += "		cd_cliente.cod_cliente = vd_nota_fiscal.cod_cliente\n";			
		}
		sql += "WHERE \n";
		sql += "	vd_nota_fiscal.cod_empresa = "+Configuracao.getCodEmpresa()+"\n";
		sql += "	AND \n";
		sql += "	vd_nota_fiscal_item.cod_produto = '"+codProduto+"' \n";
    	sql += "	AND \n";
    	// Se corpo 0002, inclui o critório por cod_cliente ou cod_grupo_cliente caso o grupo 
    	// esteja preenchido..
    	if ( "0002".equals(corpo)){
    	      sql += "CASE 	WHEN  cd_cliente.cod_grupo_cliente is null\n"; 
    	      sql += "		THEN  vd_nota_fiscal.cod_cliente   = "+getInCodCliente()+"\n";         
    	      sql += "		ELSE  \n"; // cd_cliente.cod_grupo_cliente = "+getInCodCliente()+"\n";
    	      sql += "			cd_cliente.cod_grupo_cliente in ";
    	      sql += "			(Select \n";
    	      sql += "			        cd_grupo_cliente.cod_grupo_cliente \n";
    	      sql += "			 from \n";
    	      sql += "			      cd_grupo_cliente \n";
    	      sql += "			            inner join cd_cliente as clie\n"; 
    	      sql += "			            on \n";
    	      sql += "			               clie.cod_grupo_cliente =  cd_grupo_cliente.cod_grupo_cliente \n";
    	      sql += "			 where \n";
    	      sql += "			 	clie.cod_cliente = "+getInCodCliente()+" ) \n";   	      
    	      sql += "END\n";
    	}
    	else if ( "0003".equals(corpo)){
	  	      sql += "CASE 	WHEN  cd_cliente.cod_grupo_cliente is null\n"; 
		      sql += "		THEN  vd_nota_fiscal.cod_cliente   = "+getInCodCliente()+"\n";         
		      sql += "		ELSE  \n"; // cd_cliente.cod_grupo_cliente = "+getInCodCliente()+"\n";
		      sql += "			cd_cliente.cod_grupo_cliente in ";
		      sql += "			(Select \n";
		      sql += "			        cd_grupo_cliente.cod_grupo_cliente \n";
		      sql += "			 from \n";
		      sql += "			      cd_grupo_cliente \n";
		      sql += "			            inner join cd_cliente as clie\n"; 
		      sql += "			            on \n";
		      sql += "			               clie.cod_grupo_cliente =  cd_grupo_cliente.cod_grupo_cliente \n";
		      sql += "			 where \n";
		      sql += "			 	clie.cod_cliente = "+getInCodCliente()+" ) \n";   	      
		      sql += "END\n";
    	}

    	else{
    		if( HowMGWTUtilities.isEmpty(getInCodCliente()) || "undefined ".equals(getInCodCliente()) ){
    			System.out.println("n�o foi passado o cliente como parametro.");
    			sql += "	vd_nota_fiscal.cod_cliente = -1 \n";
    		}
    		else{
    			sql += "	vd_nota_fiscal.cod_cliente = "+getInCodCliente()+" \n";
    		}
    	}
    	sql += "GROUP BY \n";
    	sql += "	vd_nota_fiscal.dt_emissao, \n";
    	sql += "	vd_nota_fiscal.nome_cliente, \n";
    	sql += "	vd_nota_fiscal.cod_nota_fiscal \n";
    	sql += "ORDER BY vd_nota_fiscal.dt_emissao DESC \n";
    	sql += "LIMIT 0 ,6 \n";

 
		HOWMGWTDataSourceQuery.executeQueryPopulate(sql, resumoProduto.getUltimasVendasCliente() );				
	}


	/**
	 * @return the inCodCliente
	 */
	public String getInCodCliente() {
		return inCodCliente;
	}


	/**
	 * @param inCodCliente the inCodCliente to set
	 */
	public void setInCodCliente(String inCodCliente) {
		this.inCodCliente = inCodCliente;
	}

 
	/**
	 * @return the painelGerenciador
	 */
	public PainelGerenciador getPainelGerenciador() {
		return painelGerenciador;
	}


	/**
	 * @param painelGerenciador the painelGerenciador to set
	 */
	public void setPainelGerenciador(PainelGerenciador painelGerenciador) {
		this.painelGerenciador = painelGerenciador;
	}


	/**
	 * @return the inTabPreco
	 */
	public String getInTabPreco() {
		return inTabPreco;
	}


	/**
	 * @param inTabPreco the inTabPreco to set
	 */
	public void setInTabPreco(String inTabPreco) {
		this.inTabPreco = inTabPreco;
		
		this.listaProduto.setTabPreco(inTabPreco);
		if ( this.listaSimilares != null ){
			this.listaSimilares.setTabPreco(inTabPreco);
		}
	}


	/**
	 * @return the currentRecord
	 */
	public Record getCurrentRecord() {
		return currentRecord;
	}


	/**
	 * @param currentRecord the currentRecord to set
	 */
	public void setCurrentRecord(Record currentRecord) {
		this.currentRecord = currentRecord;
	}


	/**
	 * @return the resumoProduto
	 */
	public PainelResumoProduto getResumoProduto() {
		return resumoProduto;
	}


	/**
	 * @param resumoProduto the resumoProduto to set
	 */
	public void setResumoProduto(PainelResumoProduto resumoProduto) {
		this.resumoProduto = resumoProduto;
	}
	
	public void clearAllScreen(){
		this.listaProduto.clearAllRecords();
		if ( this.listaSimilares != null ) 
			this.listaSimilares.clearAllRecords();		
		else
			this.listApelidosProduto.clearAllRecords();
		
		this.resumoProduto.getFieldCodigoProduto().setContents("");
		this.resumoProduto.getPrecoProduto().clearAllRecords();
		this.resumoProduto.getUltimasVendasCliente().clearAllRecords();
		this.resumoProduto.getDescricaoTecnica().setContents("");
		this.resumoProduto.getGruposProduto().clearAllRecords();
	}


	/**
	 * @return the indServico
	 */
	public String getIndServico() {
		return indServico;
	}


	/**
	 * @param indServico the indServico to set
	 */
	public void setIndServico(String indServico) {
		this.indServico = indServico;
	}









	
	
	/**
	 * Atualiza os detalhes da lista de produtos.
	 */
	public void showListaProdutoDetalhes(Record record){		
		showAllDetail(record);		
		if ( "0002".equals(corpo) && !menu){
			getFiltroConsulta().getPropertyBusca().getHowMGWTEditorFieldText().setHowMValue(record.getAttribute(getListaProduto().fieldCodProduto.getName()));
			getFiltroConsulta().onConfigure(this.getListaProduto(), (HowMGWTDataRecord)record);
		}
	}


	/**
	 * Atualiza os detalhes da lista de Similares.
	 */
	public void showListaSimilaresDetalhes(final Record record){    	
		// Se já estiver atualizado, então retorna sem 
		// atualizar.
    	if( record == currentRecord  )
    		return;

		currentRecord = record;
		if ( record == null )
			return;
		
		resumoProduto.getPrecoProduto().clearAllRecords();
		resumoProduto.getGruposProduto().clearAllRecords();
		resumoProduto.getFieldCodigoProduto().setHowMValue("");
		resumoProduto.getDescricaoTecnica().setContents("");
		String codProduto = record.getAttribute(listaSimilares.getFieldCodProduto().getName());
		showResumo(record, codProduto);
	}


	/**
	 * @return the estruturaLayoutProduto
	 */
	public VLayout getEstruturaLayoutProduto() {
		return estruturaLayoutProduto;
	}


	/**
	 * @return the mainLayout
	 */
	public VLayout getMainLayout() {
		return mainLayout;
	}


	/**
	 * @return the sessionListaProduto
	 */
	public HowMGWTPanelSectionStack getSessionListaProduto() {
		return sessionListaProduto;
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
	
	public void onShowLookup(){
		this.show();
	}


	/**
	 * @return the firstLoad
	 */
	public boolean isFirstLoad() {
		return firstLoad;
	}


	/**
	 * @param firstLoad the firstLoad to set
	 */
	public void setFirstLoad(boolean firstLoad) {
		this.firstLoad = firstLoad;
	}


	/**
	 * @return the menu
	 */
	public boolean isMenu() {
		return menu;
	}


	/**
	 * @param menu the menu to set
	 */
	public void setMenu(boolean menu) {
		this.menu = menu;
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
		if ( listaProduto != null )
			this.listaProduto.setMoeda(moeda);
		
		if ( listaSimilares != null )
			this.listaSimilares.setMoeda(moeda);
	};

}