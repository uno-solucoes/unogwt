package com.br.client.panel.vd.vdq0002.UI;

import com.br.client.configuracao.Configuracao;
import com.br.client.model.vd.entity.eItemPedido;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.UIPartner;
import com.br.client.panel.vd.entity.eModuloVDQ0002;
import com.br.client.panel.vd.mdao.MDAOSecurityVDQ0002;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.i18n.client.NumberFormat;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HOWMGWTDataSourceQuery;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;

public class PainelGerenciador extends HowMGWTWindow implements UIPartner {
	private Tab tabListaPreco;
	private TabSet tabSet;
	private ENW0002GPainelShoppingProduto painelShoppingProduto;

	private VLayout mainLayout = new VLayout();

	private eModuloVDQ0002 currentModulo;
	private String corpo = "0001";

	private JavaScriptObject inParent;
	private String inIndxItem;
	private String inCampoCodProduto;
	private String inCampoDescricao;
	private String inCampoQtde;
	private String inCodCliente;
	private String inTabPreco;
	private String inCampoPrecoVenda;
	private String inCampoPrecoTotal;
	private String moeda = "R$";

	private boolean menu;
	private boolean canEdit = true;
	private boolean lookup = false;

	private String tipoBusca = "S";
	private boolean initialized = false;

	private boolean buscaProdutoDesktop = false;

	// Critório de consulta.
	FiltroConsulta filtroConsulta;

	// Relação de Vendas
	PainelGerenciadorProdutos painelGerenciadorProduto;

	public PainelGerenciador(boolean menu) {
		this(menu, true, false);
	}

	public PainelGerenciador(boolean menu, boolean canEdit, boolean lookup) {
		this(menu, canEdit, lookup, false);
	}

	public PainelGerenciador(boolean menu, boolean canEdit, boolean lookup, boolean buscaProdutoDesktop) {
		super(!menu);

		if (buscaProdutoDesktop)
			super.setCanClose(buscaProdutoDesktop);

		this.menu = menu;
		this.canEdit = canEdit;
		this.lookup = lookup;

		this.mainLayout.setWidth100();
		this.mainLayout.setHeight100();

		// Utilizado para consultar produtos em EDI
		if (!this.canEdit) {
			this.setShowEdges(false);
			this.setShowHeader(false);
		}

		if (menu) {
			this.setWidth100();
			this.setHeight100();
		} else {
			canEdit = true;
			this.setShowModalMask(true);
			this.setModalMaskOpacity(5);

			this.setWidth("1020px");
			this.setHeight("620px");
			this.centerInPage();
		}

		MDAOSecurityVDQ0002 security = new MDAOSecurityVDQ0002(this.getHowMGWTPrograma()) {
			@Override

			protected void onFound(eModuloVDQ0002 modulo) {
				
				if ( PainelGerenciador.this.lookup )
					modulo.setCorpo("0001");
				
				setCorpo(modulo.getCorpo());
				getLabelCorpo().setContents(modulo.getCorpo() + " (01.01)");
				currentModulo = modulo;
				initUI();
				initListners();
				onInitialized();
			}

			@Override
			protected void onError() {
				SC.say("n�o encontrou o m�dulo : " + getHowMGWTPrograma() + "-"
						+ getHowMGWTTitle());
			}

		};

		if (!this.menu)
			this.setDismissOnEscape(true);

	}

	public void start() {

	}

	/**
	 * Monta a interface gráfica da tela de busca de produtos.
	 */
	public void initUI() {

		filtroConsulta = new FiltroConsulta(this.getCorpo(), this.menu,
				this.canEdit, this.lookup);
		filtroConsulta.setBuscaAproximada(this.currentModulo
				.isIndBuscaAproximadaProduto());
		if (this.currentModulo.isIndBuscaMultiplaProduto())
			filtroConsulta.setBuscaMultipla(FiltroConsulta.BUSCA_MULTIPLA);
		else
			filtroConsulta
					.setBuscaMultipla(FiltroConsulta.BUSCA_MULTIPLA_COD_PRODUTO);

		painelGerenciadorProduto = new PainelGerenciadorProdutos(this
				.getCorpo(), this.canEdit, this.lookup, this.getMoeda());
		painelGerenciadorProduto.setMenu(this.menu);

		VLayout mainInternalLayout = new VLayout();
		mainInternalLayout.setWidth100();
		mainInternalLayout.setHeight100();

		SectionStack sectionStack = new SectionStack();
		sectionStack.setWidth100();
		sectionStack.setHeight100();

		sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);
		sectionStack.setAnimateSections(false);
		sectionStack.setOverflow(Overflow.HIDDEN);

		filtroConsulta.setShowHover(true);
		filtroConsulta.setPainelGerenciador(this);

		SectionStackSection sessionFiltroConsulta = new SectionStackSection();

		if (this.canEdit)
			if ("0002".equals(this.corpo))
				if (this.menu)
					sessionFiltroConsulta.setTitle(Tradutor.i18n
							.formConsultaPrecos());
				else
					sessionFiltroConsulta.setTitle(Tradutor.i18n
							.formBuscaItens());
			else
				sessionFiltroConsulta
						.setTitle(Tradutor.i18n.criterioConsulta());
		else
			sessionFiltroConsulta.setTitle(Tradutor.i18n.criterioConsulta()
					+ " [" + Tradutor.i18n.formCliqueAquiParaGanharEspaco()
					+ "]");

		sessionFiltroConsulta.setExpanded(true);
		sessionFiltroConsulta.setItems(filtroConsulta);

		SectionStackSection sessionResultadoConsulta = new SectionStackSection();
		sessionResultadoConsulta.setExpanded(true);
		sessionResultadoConsulta.setShowHeader(false);

		if (!menu) {
			painelShoppingProduto = new ENW0002GPainelShoppingProduto(corpo,this.canEdit, moeda);
			painelShoppingProduto.setGerenciadorProdutos(this.getPainelGerenciadorProduto());
		}
		sessionResultadoConsulta.setItems(painelGerenciadorProduto);

		sectionStack.setSections(sessionFiltroConsulta,sessionResultadoConsulta);

		mainInternalLayout.addMember(sectionStack);

		painelGerenciadorProduto.setFiltroConsulta(filtroConsulta);
		painelGerenciadorProduto.setPainelGerenciador(this);

		if ("0002".equals(corpo) && !menu) {

			TabSet tabSetManager = new TabSet();
			tabSetManager.setWidth100();
			tabSetManager.setHeight100();
			tabSetManager.setTabBarPosition(Side.LEFT);

			tabSetManager.setTabBarThickness(32);

			tabSet = new TabSet();
			tabListaPreco = new Tab(Tradutor.i18n.formListaPrecos());
			Tab tabDadosAtendimento = null;
			if (canEdit)
				tabDadosAtendimento = new Tab(Tradutor.i18n.formDadosAtendimento());

			tabListaPreco.setPane(mainInternalLayout);
			if (tabDadosAtendimento != null)
				tabDadosAtendimento.setPane(this.painelShoppingProduto.getMainLayout());

			sessionFiltroConsulta.setExpanded(false);
			sessionFiltroConsulta.setCanCollapse(false);

			// tabSet.setTabs(tabListaPreco); // ,tabDadosAtendimento
			tabSet.setTabs(tabListaPreco, tabDadosAtendimento);

			// sessionResultadoConsulta.setItems(tabSet);

			Tab tabManager = new Tab("Pedido Venda", "tools/bot_pedido_venda.png");
			tabManager.setPane(tabSet);

			Tab tabConsultaPrecos = new Tab(Tradutor.i18n.formConsultaPrecos(), "tools/bot_pequisa_preco.png");
			PainelGerenciador painelConsultaPrecos = new PainelGerenciador(true);
			tabConsultaPrecos.setPane(painelConsultaPrecos.getMainLayout());

			tabSetManager.setTabs(tabManager, tabConsultaPrecos);

			this.mainLayout.addMember(tabSetManager);

			tabSet.addTabSelectedHandler(new TabSelectedHandler() {
				@Override
				public void onTabSelected(TabSelectedEvent event) {
					if (event.getTab() == tabListaPreco) {
						getFiltroConsulta().gotoFocus(getFiltroConsulta().getPropertyBusca().getHowMGWTEditorFieldText());
					}
				}
			});

			this.setHeight("640px");
		} else {
			this.mainLayout.addMember(mainInternalLayout);
		}

		inTabPreco = eModuloVDQ0002.PARAM_TabelaPrecoPadrao;
		this.painelGerenciadorProduto.setInTabPreco(inTabPreco);
		this.painelGerenciadorProduto.setInCodCliente(this.inCodCliente);
		this.addItem(this.mainLayout);
	}

	public void initListners() {
	}

	/**
	 * @return the relacaoGerenciadorProduto
	 */
	public PainelGerenciadorProdutos getRelacaoGerenciadorProduto() {
		return painelGerenciadorProduto;
	}

	/**
	 * @param relacaoGerenciadorProduto
	 *            the relacaoGerenciadorProduto to set
	 */
	public void setRelacaoGerenciadorProduto(
			PainelGerenciadorProdutos relacaoGerenciadorProduto) {
		this.painelGerenciadorProduto = relacaoGerenciadorProduto;
	}

	/**
	 * @return the painelShoppingProduto
	 */
	public ENW0002GPainelShoppingProduto getPainelShoppingProduto() {
		return painelShoppingProduto;
	}

	/**
	 * @param painelShoppingProduto
	 *            the painelShoppingProduto to set
	 */
	public void setPainelShoppingProduto(
			ENW0002GPainelShoppingProduto painelShoppingProduto) {
		this.painelShoppingProduto = painelShoppingProduto;
	}

	/**
	 * Configura os parametros para execução da busca de produtos.
	 * 
	 * @param codPedido
	 * @param codCliente
	 * @param tabelaPreco
	 */
	public void configure(JavaScriptObject parent, String codCliente,
			String tabPreco, String indxItem, String campoCodProduto,
			String campoDescricao, String campoQtde, String campoPrecoVenda, String campoPrecoTotal,
			String tipo, String moeda) {
		this.inParent 			= parent;
		this.inIndxItem 		= indxItem;
		this.inCampoCodProduto 	= campoCodProduto;
		this.inCampoDescricao 	= campoDescricao;
		this.inCampoQtde 		= campoQtde;
		this.inCodCliente 		= codCliente;
		this.inCampoPrecoTotal 	= campoPrecoTotal;
		this.setMoeda(moeda);

		if (HowMGWTUtilities.isEmpty(tabPreco)) {
			tabPreco = eModuloVDQ0002.PARAM_TabelaPrecoPadrao;
			inTabPreco = eModuloVDQ0002.PARAM_TabelaPrecoPadrao;
		}
		this.inTabPreco = tabPreco;
		this.inCampoPrecoVenda = campoPrecoVenda;
		this.filtroConsulta.getTabelaPrecoPedido().setContents(tabPreco);
		this.painelGerenciadorProduto.setInTabPreco(tabPreco);
		this.painelGerenciadorProduto.setInCodCliente(this.inCodCliente);
		// Se o tipo de busca modou, limpra os dados dos filtros e resultados de
		// consulta/

		// Se inicializado, verifica se há necessidade de limpeza dos filtros e
		// resultado.
		if (initialized) {
			if (!tipo.equalsIgnoreCase(this.tipoBusca))
				filtroConsulta.limparFiltros();
		}

		this.tipoBusca = tipo;
		if ( lookup ){
			this.getPainelGerenciadorProduto().setIndServico("");			
		}
		else{
			if ("S".equalsIgnoreCase(tipoBusca)) {
				this.getPainelGerenciadorProduto().setIndServico("1");
				this.getPainelShoppingProduto().setTipoBusca("S");
			} else {
				this.getPainelGerenciadorProduto().setIndServico("0");
				this.getPainelShoppingProduto().setTipoBusca("P");
			}
		}
		initialized = true;
	}

	/**
	 * @return Retorna o endereço absoluto do contexto onde serão executados os
	 *         serviços de donwload GWT.
	 */
	public static native void setNativeUnoGWTSetValue(JavaScriptObject object,
			String codProduto, String qtde) /*-{
		object.popularProdutoGWT(codProduto, qtde);
	}-*/;

	/**
	 * Limpa todos os dados da tela.
	 */
	public void clearAllScreen() {
		this.painelGerenciadorProduto.clearAllScreen();
	}

	/**
	 * @return the filtroConsulta
	 */
	public FiltroConsulta getFiltroConsulta() {
		return filtroConsulta;
	}

	/**
	 * @param filtroConsulta
	 *            the filtroConsulta to set
	 */
	public void setFiltroConsulta(FiltroConsulta filtroConsulta) {
		this.filtroConsulta = filtroConsulta;
	}

	/**
	 * @return the painelGerenciadorProduto
	 */
	public PainelGerenciadorProdutos getPainelGerenciadorProduto() {
		return painelGerenciadorProduto;
	}

	/**
	 * @param painelGerenciadorProduto
	 *            the painelGerenciadorProduto to set
	 */
	public void setPainelGerenciadorProduto(
			PainelGerenciadorProdutos painelGerenciadorProduto) {
		this.painelGerenciadorProduto = painelGerenciadorProduto;
	}

	@Override
	public String getHowMGWTPrograma() {
		return "VDQ0002";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloVDQ0002();
	}

	/**
	 * @return the corpo
	 */
	public String getCorpo() {
		return corpo;
	}

	/**
	 * @param corpo
	 *            the corpo to set
	 */
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public void onInitialized() {
	};

	public void showPainelShopping() {
		filtroConsulta.getActionShopping().setTitle(
				Tradutor.i18n.formCarrinho()
						+ "("
						+ painelShoppingProduto.getPainelListaProduto()
								.getRecords().length + ")");
		painelShoppingProduto.showShopping();
	}

	private Record currentEditRecord;
	private String currentEditCodProduto;
	private String currentEditDescricao;
	private String currentEditCampoValor;
	private int currentEditOption;

	/**
	 * Set Adiciona o item no carrinho, altera valor ou quantidade dependendo da
	 * opção passada.
	 * 
	 * @param record
	 * @param codProduto
	 * @param descricao
	 * @param campoValor
	 * @param opcao
	 */
	public void setCallFields(Record record, String codProduto, int opcao) {

		if (opcao == PainelListaProduto.OPCAO_ACAO_LOOKUP) {
			String descricao = record.getAttribute("Descricao");
			onSelectLookup(codProduto, descricao);
			onSelectLookupRecord(record, codProduto, descricao);
			return;
		}

		if (this.isMenu())
			return;

		this.currentEditRecord = record;
		this.currentEditCodProduto = codProduto;
		this.currentEditOption = opcao;
		ListGridRecord[] records = this.getPainelShoppingProduto()
				.getPainelListaProduto().getRecords();
		for (ListGridRecord cRecord : records) {
			// Verifica se o produto já foi incluído no carrinho de compra.
			if (codProduto.equalsIgnoreCase(cRecord.getAttribute("codProduto"))) {
				if ("0002".equals(corpo)) {
					double qtde = HowMGWTUtilities
							.getDouble(this.filtroConsulta
									.getPropertyQuantidade()
									.getHowMGWTEditorFieldText().getHowMValue());
					double preco = HowMGWTUtilities
							.getDouble(this.filtroConsulta
									.getPropertyPrecoVenda()
									.getHowMGWTEditorFieldText().getHowMValue());

					cRecord.setAttribute(this.getPainelShoppingProduto()
							.getPainelListaProduto().fieldQtde.getName(), qtde);
					cRecord.setAttribute(this.getPainelShoppingProduto()
							.getPainelListaProduto().fieldPrecoVenda.getName(),
							preco);

					int idx = this.getPainelShoppingProduto()
							.getPainelListaProduto().getRecordIndex(cRecord);
					this.getPainelShoppingProduto().getPainelListaProduto()
							.selectRecord(cRecord);
					this.getPainelShoppingProduto().getPainelListaProduto()
							.scrollToRow(idx);
					this.getPainelShoppingProduto().verificaPrecoUnitario(
							(ListGridRecord) cRecord, codProduto);
				} else {
					String msg = Tradutor.i18n.msgProdutoJaSelecionado();
					// if ( opcao == PainelListaProduto.OPCAO_ACAO ){
					HowMGWTWindowWait.hideWait();
					SC.say(msg);
				}
				return;
				// }
				// else if ( opcao == PainelListaProduto.OPCAO_ALTERACAO_PRECO )
				// msg = Tradutor.i18n.msgProdutoJaSelecionadoPreco();
				// else if ( opcao == PainelListaProduto.OPCAO_ALTERACAO_QTDE )
				// msg = Tradutor.i18n.msgProdutoJaSelecionadoQtde();
				//					
				// SC.confirm(msg, new BooleanCallback() {
				//					
				// @Override
				// public void execute(Boolean value) {
				// if ( value.booleanValue() )
				// SC.say("Alterar produto ou servico aqui...");
				// else
				// SC.say("valor do campo não foi alterado");
				// }
				// });
				// return;
			}
		}
		if ("0002".equals(corpo)) {
			double qtde = HowMGWTUtilities.getDouble(this.filtroConsulta
					.getPropertyQuantidade().getHowMGWTEditorFieldText()
					.getHowMValue());
			double preco = HowMGWTUtilities.getDouble(this.filtroConsulta
					.getPropertyPrecoVenda().getHowMGWTEditorFieldText()
					.getHowMValue());

			record.setAttribute(this.getPainelShoppingProduto()
					.getPainelListaProduto().fieldQtde.getName(), qtde);
			record.setAttribute(this.getPainelShoppingProduto()
					.getPainelListaProduto().fieldPrecoVenda.getName(), preco);
		}
		if ( this.lookup ){
			
		}
		else{
			if ("S".equalsIgnoreCase(tipoBusca))
				this.getPainelShoppingProduto().buscarServico(
						(ListGridRecord) record, codProduto, opcao);
			if ("P".equalsIgnoreCase(tipoBusca))
				this.getPainelShoppingProduto().buscarProduto(
						(ListGridRecord) record, codProduto, opcao);
		}
	}

	/**
	 * Carrega os dados do FormBean do módulo requisitado do servidor
	 */
	public void loadSelectItens() {
		if (getFiltroConsulta().getActionShopping() != null) {
			getFiltroConsulta().getActionShopping().setTitle(
					Tradutor.i18n.formCarrinho());
		}
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(
				new com.br.client.model.vd.vdw0001.FormBean()) {
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				com.br.client.model.vd.vdw0001.FormBean bean = (com.br.client.model.vd.vdw0001.FormBean) formBean;
				if ("S".equalsIgnoreCase(tipoBusca))
					loadSelectItens(bean.getServicosPedido(), bean.getCodPedido());
				if ("P".equalsIgnoreCase(tipoBusca))
					loadSelectItens(bean.getItensPedido(), bean.getCodPedido());
			}
		};
		struts.requestFormBean("vdw0001", "VDW0001Form");
	}

	/**
	 * Carrega a lista de Itens para o carrinho de compra
	 * 
	 * @param itens
	 */
	public void loadSelectItens(eItemPedido[] itens, String codPedido) {
		this.getPainelShoppingProduto().getItem().clear();
		if (itens != null) {
			this.getPainelShoppingProduto().setItensPedido(itens);
			String inProdutos = "";
			for (eItemPedido item : itens) {
				if (!HowMGWTUtilities.isEmpty(item.getCodProduto())) {
					// System.out.println("----------------------------------------------------");
					// System.out.println("Codigo Produto : "+item.getCodProduto());
					// System.out.println("Descricao Comercial : "+item.getDescComercial());
					// System.out.println("Qtde : "+item.getQtd());
					// System.out.println("Valor Venda : "+item.getPrecoVenda());

					if (HowMGWTUtilities.isEmpty(inProdutos))
						inProdutos += "'" + item.getCodProduto() + "'";
					else
						inProdutos += ", '" + item.getCodProduto() + "'";

					this.getPainelShoppingProduto().getItem().put(
							item.getCodProduto(), item);
				}
			}
			if (!HowMGWTUtilities.isEmpty(inProdutos)) {
				String sql = "";
				sql += "SELECT DISTINCT      \n";
				sql += "   0 as qtde,\n";
				sql += "   cd_produto.cod_produto fieldCodProduto,\n";
				sql += "   '' as fieldActionDetalheItem ,\n";
				sql += "   cd_marca.desc_abrev as fieldMarca,\n";
				sql += "   cd_produto.desc_comercial as fieldDescricao ,\n";
				sql += "   cd_produto.un as fieldUnidadeMedida, \n";
				
				sql += getCalculoEstoque(Configuracao.getCodEmpresa()) + " as \"fieldEstoqueDisponivel\", \n ";
				
				sql += "	 0.00 as valorVendaST,\n";
				sql += "     '' as fieldIconeSimEst,\n";
				sql += "     '' as fieldIconeEstEmpresa,\n";
				sql += "     0.00 as precoVendaConfigurador,\n";
				sql += "     '' as fieldIconePromocao,\n";
				sql += "     '' as fieldIconePrecoDif,\n";
				sql += "     cd_produto.desc_tecnica ,\n";
				sql += "     cd_produto.observacao,\n";
				sql += "     (\n";
				sql += "          select count(1)\n";
				sql += "          from en_produto_estrutura\n";
				sql += "          where\n";
				sql += "                en_produto_estrutura.cod_produto_pai = cd_produto.cod_produto   ) as possuiKit,\n";

				sql += "( ";
				sql += "select ";
				sql += "        preco_unit ";
				sql += "from ";
				sql += "     cd_preco_item ";
				sql += "where ";
				sql += "	cod_produto = cd_produto.cod_produto ";
				sql += "    and ";
				sql += "	tb_preco     = '" + inTabPreco + "' ";
				sql += "	and ";
				sql += "	qtd_min in (  select min(qtd_min) ";
				sql += "               	  from   cd_preco_item  ";
				sql += "               	  where  ";
				sql += "                           cod_produto = cd_produto.cod_produto ";
				sql += "                           and ";
				sql += "                           tb_preco     = '"
						+ inTabPreco + "' ";
				sql += "                ) ";
				sql += " ) as precoLista,  ";
				sql += " 	0.00 as totalItem, \n";
				
				sql += getCalculoEstoque(Configuracao.getCodEmpresa()) + " as \"saldoEstoque\" ";
				
				sql += "FROM\n";
				sql += "      cd_produto_empresa\n";
				sql += "      INNER JOIN cd_produto\n";
				sql += "            ON\n";
				sql += "               cd_produto.cod_produto = cd_produto_empresa.cod_produto\n";
				sql += "      LEFT JOIN cd_marca\n";
				sql += "            ON\n";
				sql += "               cd_marca.cod_marca = cd_produto.cod_marca\n";
				sql += "      LEFT JOIN cd_fornecedor\n";
				sql += "            ON\n";
				sql += "               cd_fornecedor.cod_fornecedor = cd_produto.cod_fornecedor\n";
				sql += "WHERE\n";
				sql += "        cd_produto_empresa.cod_empresa = "
						+ Configuracao.getCodEmpresa() + " ";
				sql += "        AND\n";
				sql += "        cd_produto.cod_produto in (" + inProdutos + ")";
				// sql += "        AND\n";
				// sql += "        cd_produto.situacao = 1\n"; // 1 - Produtos
				// ativos.
				sql += "ORDER BY cd_produto.cod_produto\n";

				// System.out.println(sql);
				HOWMGWTDataSourceQuery.executeQueryPopulate(sql,
						painelShoppingProduto.getPainelListaProduto());
			} else
				System.out
						.println(">>>>>>>>>>>> não há itens no pedido para serem carregados...");
		}
	}

	@Override
	protected void onHowMGWTClose() {
		if( lookup ){
			
		}
		else if (!menu && this.inParent != null){
			setNativeUnoGWTSetValue(this.inParent, "refresh", "0");
		}
	}

	/**
	 * @return the menu
	 */
	public boolean isMenu() {
		return menu;
	}

	/**
	 * @param menu
	 *            the menu to set
	 */
	public void setMenu(boolean menu) {
		this.menu = menu;
	}

	public void onSelectLookup(String codProduto, String descricao) {
	};

	public void onSelectLookupRecord(Record record, String codProduto, String descricao) {
		if (this.lookup) {
			this.setNativeValues(this.inParent, record, codProduto, descricao);
		}
	}

	public void onShowLookup() {
	}

	/**
	 * @return the tabSet
	 */
	public TabSet getTabSet() {
		return tabSet;
	}

	/**
	 * @return the mainLayout
	 */
	public VLayout getMainLayout() {
		return mainLayout;
	}

	/**
	 * @return the moeda
	 */
	public String getMoeda() {
		return moeda;
	}

	/**
	 * @param moeda
	 *            the moeda to set
	 */
	public void setMoeda(String moeda) {
		this.moeda = moeda;
		if (this.painelGerenciadorProduto != null)
			this.painelGerenciadorProduto.setMoeda(moeda);
		if (this.painelShoppingProduto != null)
			this.painelShoppingProduto.setMoeda(moeda);
	};
	
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

	public void setNativeValues(JavaScriptObject parent, Record record,  String cdProduto, String DescrProduto) {

		if( ! HowMGWTUtilities.isEmpty( this.inCampoCodProduto ))
			Configuracao.setNativeUnoGWTSetValue(parent, this.inCampoCodProduto,cdProduto);

		if( ! HowMGWTUtilities.isEmpty( this.inCampoDescricao ))
			Configuracao.setNativeUnoGWTSetInnerHTML(parent, this.inCampoDescricao ,DescrProduto);

		if( ! HowMGWTUtilities.isEmpty( this.inCampoQtde )){
		
			double qtde = HowMGWTUtilities.getDouble(record.getAttribute("Qtde"));
			if( qtde <=0 )
				qtde = 1;
			
			String sQtde = NumberFormat.getFormat(HowMGWTUtilities.getMask(eModuloVDQ0002.PARAM_qtdCasasDecimaisQtdProduto)).format(qtde);
			Configuracao.setNativeUnoGWTSetValue(parent, this.inCampoQtde, ""+qtde);

		}
		if( ! HowMGWTUtilities.isEmpty( this.inCampoPrecoVenda )){

			double precoVenda 	= HowMGWTUtilities.getDouble(record.getAttribute("PrecoVenda"));
			String sPrecoVenda 	= NumberFormat.getFormat(HowMGWTUtilities.getMask(eModuloVDQ0002.PARAM_qtdCasasDecimaisPrecoUnitProduto)).format(precoVenda);
			Configuracao.setNativeUnoGWTSetValue(parent, this.inCampoPrecoVenda, ""+sPrecoVenda);

		}

		if( ! HowMGWTUtilities.isEmpty( this.inCampoPrecoTotal )){

			double qtde = HowMGWTUtilities.getDouble(record.getAttribute("Qtde"));
			double precoVenda 	= HowMGWTUtilities.getDouble(record.getAttribute("PrecoVenda"));
			if ( qtde <= 0 )
				qtde = 1;
			
			double precoTotal   = qtde * precoVenda;
			
			String sPrecoTotal 	= NumberFormat.getFormat(HowMGWTUtilities.getMask(eModuloVDQ0002.PARAM_qtdCasasDecimaisPrecoUnitProduto)).format(precoTotal);
			Configuracao.setNativeUnoGWTSetInnerHTML(parent, this.inCampoPrecoTotal, ""+sPrecoTotal);

		}
		
		hide();
	}
}