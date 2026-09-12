package com.br.client.panel.vd.vdq0002.UI;

import java.util.TreeMap;

import com.br.client.model.vd.entity.eItemPedido;
import com.br.client.model.vd.vdw0001.FormBean;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.howmake.client.form.UI.HowMGWTLabel;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ENW0002GPainelShoppingProduto extends HowMGWTWindow{

	
	private String moeda = "R$";
 
	private HowMGWTLabel labelTotalLista;
	private HowMGWTLabel labelTotalPedido;
	
	private boolean inProcess = false;
	
	private HLayout mainLayout = new HLayout();

	private eItemPedido[] itensPedido;
	private TreeMap<String,eItemPedido> itensPedidoCarregados = new TreeMap<String, eItemPedido>();
	
	private Record parentRecord;
	
	private PainelGerenciadorProdutos gerenciadorProdutos;
	
	private PainelListaProduto painelListaProduto;
	
	private String corpo;
	
	private String tipoBusca;
	
	public ENW0002GPainelShoppingProduto(String corpo, boolean canEdit, String moeda){
		this.corpo = corpo;
	
		this.setMoeda( moeda );
		painelListaProduto = new PainelListaProduto(corpo,true, true, canEdit, false, moeda ){

 
			@Override
			public void onEventSelectEditRecord(Record record, String codProduto, int opcao){
				// currentOption = opcao;
				verificaPrecoUnitario((ListGridRecord)record, codProduto);
			}		
 
			
			@Override
			public void onEventHowMGWTAfterQuery(final Record record){

			}
			
			@Override
			public boolean onHowMCustomFinishLoader(ListGridRecord[] records){
				customFinishLoader(records);
				gerenciadorProdutos.getFiltroConsulta().findShopping();
				return true;
			}
			
			@Override
			public void onDeleteRecord(ListGridRecord record){
				deleteRecord(record);
			}

		};		
		
		this.painelListaProduto.setShowKit(false);
		this.painelListaProduto.setShopping(true);
		this.setWidth("980px");
		this.setHeight("450px");
		this.setIsModal(true);
		this.centerInPage();
		
		
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		
		VLayout toolbar = new VLayout();
		toolbar.setHeight100();
		toolbar.setWidth("48px");
		toolbar.setAlign(VerticalAlignment.CENTER);
		
		if ( ! "0002".equals(corpo)){
	        ImgButton pane = new ImgButton();
	        pane.setSrc("geral/selectShopping.png");
			pane.setShowDown(false);  
			pane.setShowRollOver(false);  
			pane.setLayoutAlign(Alignment.CENTER);
	        pane.setHeight(48);
	        pane.setWidth100();		
	        toolbar.addMember(pane);
	        
	        mainLayout.addMember(toolbar);
			mainLayout.addMember(painelListaProduto);
		}
		if ( "0002".equals(corpo) ){

			VLayout vLayout = new VLayout();
			vLayout.setHeight100();
			vLayout.setWidth100();
			
			HLayout hTotais = new HLayout();
			hTotais.setWidth100();
			hTotais.setHeight(22);
			hTotais.setAlign(Alignment.RIGHT);
			
			labelTotalLista		= new HowMGWTLabel("<B>Valor Lista :  0,00</b>");
			labelTotalPedido	= new HowMGWTLabel("<B>Total Pedido:  0,00</b>");
			labelTotalLista.setWidth(130);
			labelTotalPedido.setWidth(130);
			hTotais.addMember(labelTotalLista);
			hTotais.addMember(HowMGWTUtilities.getCanvasVerticalSeparetor(12, ""));
			hTotais.addMember(labelTotalPedido);

			vLayout.addMember(painelListaProduto);
			vLayout.addMember(hTotais);
			mainLayout.addMember(vLayout);
		}

		
//		if ( "0002".equals( corpo ))
//			;
//		else
		
		System.out.println("Teste de Versão");

		this.addItem(mainLayout);
		
		
			
		getPainelListaProduto().setShowRecordComponents(true);          
		getPainelListaProduto().setShowRecordComponentsByCell(true);
		
		this.setDismissOnEscape(true);

	}


	/**
	 * @return the tipoBusca
	 */
	public String getTipoBusca() {
		return tipoBusca;
	}

	/**
	 * @param tipoBusca the tipoBusca to set
	 */
	public void setTipoBusca(String tipoBusca) {
		this.tipoBusca = tipoBusca;
	}
	
	/**
	 * @return the itensPedido
	 */
	public eItemPedido[] getItensPedido() {
		return itensPedido;
	}

	/**
	 * @param itensPedido the itensPedido to set
	 */
	public void setItensPedido(eItemPedido[] itensPedido) {
		this.itensPedido = itensPedido;
	}
	
	/**
	 * @return the item
	 */
	public TreeMap<String, eItemPedido> getItem() {
		return itensPedidoCarregados;
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
	public void hide() {
		
		super.hide();
	}
	
	
	@Override
	public String getHowMGWTPrograma() {
		return "ENW0002G";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloENW0002G();
	}	
	
	/**
	 * @param codProduto código do produto que será localizado
	 * @return Retorna o indice para o produto selecionado.
	 */
	public String getIndexItem(String codProduto){
		ListGridRecord[] records = this.getPainelListaProduto().getRecords();
		int index = 0;
		for ( ListGridRecord record : records){
			// Se encontrou o produto então retorna o indice
			if ( codProduto.equalsIgnoreCase(record.getAttribute("codProduto")))
				break;
			index ++;
		}
		return ""+index;
	}
	
	
	
	private FormBean currentBean;
	private eItemPedido currentItemPedido;
	private String currentCodProduto;
	private ListGridRecord currentRecord;
	private boolean addRecord = false;
	// private int currentOption = -1;
	/**
	 * Adiciona o item no carrinho de compras.
	 * @param bean
	 * @param itens
	 */
	private ListGridRecord addItemCarrinho(com.br.client.model.vd.vdw0001.FormBean bean, eItemPedido item){
		Record[] records = getPainelListaProduto().getRecords();
		int j = 0;
		RecordList recordList = new RecordList();

		ListGridRecord newRecord;
		for (  ; j < records.length ; j ++ ){
			newRecord = getPainelListaProduto().copy((ListGridRecord)records[j]);
			// copia a flag de revoke para a cópia.
			if ( records[j].getAttribute("revoke") != null)
				newRecord.setAttribute("revoke", records[j].getAttributeAsBoolean("revoke"));
			
			if ( records[j].getAttribute("objectItemPedido") != null )
				newRecord.setAttribute("objectItemPedido", records[j].getAttributeAsObject("objectItemPedido") );
			
			recordList.add(newRecord);
		}
		ListGridRecord record = getPainelListaProduto().copy((ListGridRecord)currentRecord);
		record.setAttribute("objectItemPedido" , currentItemPedido );
		
		refreshQtdePreco(record, item, bean, false);
		
		recordList.add(record);
		getPainelListaProduto().setData(recordList);			
		this.getGerenciadorProdutos().getFiltroConsulta().getActionShopping().setTitle(Tradutor.i18n.formCarrinho()+"("+this.getPainelListaProduto().getRecords().length+")");
		HowMGWTWindowWait.hideWait();
		return record;

	}
	
	/**
	 * Atualiza os dados no registro da grid.
	 * @param record
	 * @param item
	 * @param refreshRecordInGrid
	 */
	public void refreshQtdePreco(ListGridRecord record, eItemPedido item, FormBean bean, boolean refreshRecordInGrid){

		record.setAttribute(getPainelListaProduto().fieldQtde.getName(), 		HowMGWTUtilities.getDoubleToBD(item.getQtd()));
		record.setAttribute(getPainelListaProduto().fieldPrecoVenda.getName(),  HowMGWTUtilities.getDoubleToBD(item.getPrecoVenda()));
		record.setAttribute(getPainelListaProduto().fieldPrecoVendaST.getName(),HowMGWTUtilities.getDoubleToBD(item.getPrecoVendaST()));
		record.setAttribute(getPainelListaProduto().fieldTotalItem.getName(), 	HowMGWTUtilities.getDouble(item.getPrecoTotal()));
		
		if ( refreshRecordInGrid ){
			int index = this.getPainelListaProduto().getRecordIndex(record);
			if ( index >= 0 )
				this.getPainelListaProduto().refreshRow(index);
		} 
		if ( bean != null ){
			if ( "P".equalsIgnoreCase(tipoBusca) ){
				if ( bean.getItensPedido() != null ){
					TreeMap<String,eItemPedido> map = new TreeMap<String, eItemPedido>();
					for ( eItemPedido itemPedido : bean.getItensPedido() ){
						if( !HowMGWTUtilities.isEmpty(itemPedido.getCodProduto()) )
							map.put(itemPedido.getCodProduto(), itemPedido);
					}
					ListGridRecord[] records = this.getPainelListaProduto().getRecords();
					if ( records != null ){
						for( ListGridRecord rec : records){
							eItemPedido itemPedido = map.get(rec.getAttribute(getPainelListaProduto().fieldCodProduto.getName()));
							if ( itemPedido != null ){
								rec.setAttribute(getPainelListaProduto().fieldPrecoVendaST.getName(),HowMGWTUtilities.getDoubleToBD(itemPedido.getPrecoVendaST()));
								int row = getPainelListaProduto().getRecordIndex(rec);
								int col = getPainelListaProduto().getFieldNum(getPainelListaProduto().fieldPrecoVendaST.getName());
								getPainelListaProduto().refreshCell(row, col);
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * Adiciona um item de produto.
	 * @param record
	 * @param codProduto
	 * @param qtde
	 */
	public void buscarProduto(ListGridRecord record, String codProduto, int opcao){
		currentCodProduto = codProduto;
		currentRecord  = record;
		addRecord         = false;
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new com.br.client.model.vd.vdw0001.FormBean()) {					
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				com.br.client.model.vd.vdw0001.FormBean bean = (com.br.client.model.vd.vdw0001.FormBean)formBean;				 
				ListGridRecord returnRecord = chekAddItem(currentRecord, currentCodProduto, bean);
				recalcula(null);
				if ( returnRecord != null )
					getGerenciadorProdutos().getFiltroConsulta().onSuccess(returnRecord);
			}
		};
		String qtde 		= record.getAttribute(getPainelListaProduto().fieldQtde.getName());
		struts.request("vdw0001.do?method=buscarProduto&tpBuscaPedido=codProduto&qtde="+qtde+"&qtd="+qtde+"&indexItem="+getIndexItem(codProduto)+"&codProduto="+codProduto, "VDW0001Form" , "" );
	}

	/**
	 * Adiciona um item de Serviço
	 * @param record
	 * @param codProduto
	 * @param qtde
	 */
	public void buscarServico(ListGridRecord record, String codProduto, int opcao){
		currentCodProduto = codProduto;
		currentRecord  = record;
		addRecord         = false;
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new com.br.client.model.vd.vdw0001.FormBean()) {					
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				com.br.client.model.vd.vdw0001.FormBean bean = (com.br.client.model.vd.vdw0001.FormBean)formBean;
				chekAddItem(currentRecord, currentCodProduto, bean);
				recalcula(null);
			}
		};
		String qtde 		= record.getAttribute(getPainelListaProduto().fieldQtde.getName());
 
		struts.request("vdw0001.do?method=buscarServico&qtde="+qtde+"&qtd="+qtde+"&indexServico="+getIndexItem(codProduto)+"&codProduto="+codProduto, "VDW0001Form" , "" );
	}	
 

	/**
	 * Altera um item de produto.
	 * @param record
	 * @param codProduto
	 * @param qtde
	 */
	public void verificaPrecoUnitario(ListGridRecord record, String codProduto){
		currentCodProduto = codProduto;
		currentRecord  	  = record;
		addRecord         = false;
		HowMGWTWindowWait.showWait();
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new com.br.client.model.vd.vdw0001.FormBean()) {					
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				com.br.client.model.vd.vdw0001.FormBean bean = (com.br.client.model.vd.vdw0001.FormBean)formBean;				
				checkEditItem(currentRecord, currentCodProduto ,bean);
			}
		};
		eItemPedido item = (eItemPedido)record.getAttributeAsObject("objectItemPedido");
		// Atualiza os valores que serão alterados no servidor.
		item.setQtd(""+record.getAttributeAsDouble(getPainelListaProduto().fieldQtde.getName()));
		item.setPrecoVenda(""+record.getAttributeAsDouble(getPainelListaProduto().fieldPrecoVenda.getName()));
		// Codifica para envio para o servidor.		
		String encode = item.toEncodeFields("qtd;indexItem;tipoItem;codProduto;situacao;codColaborador;moeda");
		if ( "S".equalsIgnoreCase(tipoBusca))
			struts.request(
					"vdw0001.do?method=verificaPrecoUnitario&qtd="+item.getQtd()+
					"&tipoItem=servico&indexItem="+getIndexItem(codProduto)+
					"&codProduto="+codProduto+
					"&atualizarTbPreco=true"+encode, 
					"VDW0001Form" , 
					"" 
			);
		else 
			struts.request(
					"vdw0001.do?method=verificaPrecoUnitario&qtd="+item.getQtd()+
					"&tipoItem=item&indexItem="+getIndexItem(codProduto)+
					"&codProduto="+codProduto+
					"&atualizarTbPreco=true"+encode, 
					"VDW0001Form" , 
					"" 
			);
	}	

	
	/**
	 * Verifica o registro deverá ficar habilitado para edição.
	 * @param record
	 */
	public void isRecordEnable(ListGridRecord record){
		eItemPedido item = this.itensPedidoCarregados.get(record.getAttribute("codProduto"));
		if ( item == null )
			return;
		
		
		if (! HowMGWTUtilities.isEmpty(item.getNrSequencia()) )
			record.setAttribute("revoke", new Boolean(true));

		refreshQtdePreco(record, item,null, false);

		boolean atendido = false;
		double qtdAtendida = HowMGWTUtilities.isEmpty(item.getQtdAtendida()) ? 0.0 : HowMGWTUtilities.getDoubleToBD(item.getQtdAtendida());
		// System.out.println("Quantidade Atendida "+item.getQtdAtendida()) ;
		boolean hasEtq = false;
		String observacaoKit = "";
		
		if( ! HowMGWTUtilities.isEmpty(item.getEtqs())){
			hasEtq = true;
			observacaoKit += " - Item com separação. Alteração não permitida.";
		}
		if( item.getIndFantasma() != null && item.getIndFantasma().trim().equalsIgnoreCase("1") && 
		    item.getCodPedido() != null && item.getCodPedido().trim().length() > 0 ){
			observacaoKit += " - Item Fantasma. A quantidade não pode ser alterada.";
		}
		if( qtdAtendida > 0d ){
			atendido = true;
		}
		if ( !atendido && !hasEtq  )
			((ListGridRecord)record).setEnabled(true);
		else
			((ListGridRecord)record).setEnabled(false);			
	}


	/**
	 * Carrega os itens do pedido no carrinho de compra na ordem em que 
	 * foram carregados no pedido.
	 * @param records
	 */
	public void customFinishLoader(ListGridRecord[] records){
		TreeMap<String , ListGridRecord> mapRecords = new TreeMap<String, ListGridRecord>();
		for ( ListGridRecord record : records)
			mapRecords.put(record.getAttribute("codProduto"), record);			
		
		RecordList recordList = new RecordList();
		ListGridRecord record;

		
		for ( eItemPedido item : getItensPedido()){
			if ( !HowMGWTUtilities.isEmpty(item.getCodProduto())){
				record = mapRecords.get(item.getCodProduto());
				if ( record != null ){
					record.setAttribute("objectItemPedido" , item );
					this.isRecordEnable(record);
					record.setAttribute(getPainelListaProduto().fieldTotalItem.getName(), HowMGWTUtilities.getDouble(item.getPrecoTotal()));
					recordList.add(record);
				}
				else{
					System.out.println("Produto : "+item.getCodProduto());
				}
			}
		}
		this.getPainelListaProduto().setData(recordList);
		if( this.getGerenciadorProdutos().getFiltroConsulta().getActionShopping() != null )
			this.getGerenciadorProdutos().getFiltroConsulta().getActionShopping().setTitle(Tradutor.i18n.formCarrinho()+"("+this.getPainelListaProduto().getRecords().length+")");
		recalcula(records);
	}
	
	
	public void recalcula(ListGridRecord[] records){
		
		if( "0002".equals(corpo)){
			
			double valorLista  = 0.00;
			double totalPedido = 0.00;

			double qtde    = 0.00;
			double vlLista = 0.00;
			double vlTotal = 0.00;
		
			if ( records == null )
				records = this.getPainelListaProduto().getRecords();
			
			for ( ListGridRecord record : records ){			
				qtde    = HowMGWTUtilities.getDouble(record.getAttribute(getPainelListaProduto().fieldQtde.getName()));
				vlLista = HowMGWTUtilities.getDouble(record.getAttribute(getPainelListaProduto().fieldPrecoLista.getName()));
				vlTotal = HowMGWTUtilities.getDouble(record.getAttribute(getPainelListaProduto().fieldTotalItem.getName()));
			
				valorLista  += qtde * vlLista;
				totalPedido += vlTotal;
			}

			String sValorLista  = NumberFormat.getFormat("#,##0.00").format(valorLista);
			String sTotalPedido = NumberFormat.getFormat("#,##0.00").format(totalPedido);
			labelTotalLista.setContents("<B>Valor Lista :  "+sValorLista+"</b>");
			labelTotalPedido.setContents("<B>Total Pedido:  "+sTotalPedido+"</b>");
		
		}		
	}
	
	
	int index = -1;
	/**
	 * Remove o registro do carrinhoi de compras.
	 * @param record Registro que será removido.
	 */
	public void deleteRecord(final ListGridRecord record){
	   	
		index = getPainelListaProduto().getRecordIndex(record);
		
		HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new com.br.client.model.vd.vdw0001.FormBean()) {					
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				com.br.client.model.vd.vdw0001.FormBean bean = (com.br.client.model.vd.vdw0001.FormBean)formBean;
				if ( index >= 0){
					getPainelListaProduto().removeData(record);
					getPainelListaProduto().refreshRow(index);
					getGerenciadorProdutos().getFiltroConsulta().getActionShopping().setTitle(Tradutor.i18n.formCarrinho()+"("+getPainelListaProduto().getRecords().length+")");
					recalcula(null);
					getGerenciadorProdutos().getFiltroConsulta().onSuccess(null);
				}
			}
		};
		if ( index >= 0 ){
			eItemPedido item = (eItemPedido)record.getAttributeAsObject("objectItemPedido");
			String encode = item.toEncodeFields("gwtIndex;tipoBusca;codProduto;situacao;codColaborador;moeda");
			String acao = "";
			String indices = "";			
			ListGridRecord records[] = this.getPainelListaProduto().getRecords();
			if ( records != null ){
				int i = 0;
				for ( ListGridRecord rec : records){
					if ( index == i)
						indices += "true,";
					else
						indices += "false,";
					i ++;
				}
				
				if ( "S".equalsIgnoreCase(tipoBusca))
					acao = "vdw0001.do?method=excluirServicos&indicesItens=" + indices;
				else  
					acao = "vdw0001.do?method=excluirProdutos&indicesItens=" + indices;
				struts.request(acao+encode, "VDW0001Form", "");
			}
		}
	}
	
	
	/**
	 * Procura pelo item na lista de itens de produtos ou serviço
	 * @param codProduto
	 * @param bean
	 * @return
	 */
	public eItemPedido getItem(String codProduto, FormBean bean){
		if ( "P".equalsIgnoreCase(this.tipoBusca)){
			for ( eItemPedido item : bean.getItensPedido() ){
				if ( codProduto.equalsIgnoreCase(item.getCodProduto() )){
					this.currentItemPedido = item;
					return item;
				}
			}
		}
		else if ( "S".equalsIgnoreCase(this.tipoBusca)){
			for ( eItemPedido item : bean.getServicosPedido() ){
				if ( codProduto.equalsIgnoreCase(item.getCodProduto() )){
					this.currentItemPedido = item;
					return item;
				}
			}			
		}		
		return null;
	}
	
	
	/**
	 * Checa se o item podera ser incluído no carrinho de compra.
	 * @param record
	 * @param codProduto
	 * @param bean
	 */
	public ListGridRecord chekAddItem(ListGridRecord record, String codProduto, FormBean bean){
		currentBean = bean;
		this.currentItemPedido = this.getItem(codProduto, bean);
		HowMGWTControl.isRefreshFormShowMessage(bean);
		// Se o item foi adicionado no servidor então adiciona no carrinho.
		if ( currentItemPedido != null)
			return addItemCarrinho(currentBean, this.currentItemPedido);
		return null;
	}
	
	
	
	/**
	 * Verifica se o registro foi alterado e se há alguma tarefa a ser executada
	 * @param record
	 * @param codCliente
	 * @param bean
	 */
	private void checkEditItem(ListGridRecord record, String codProduto, FormBean bean){
		this.currentBean = bean;
		this.currentItemPedido = this.getItem(codProduto, bean);

		for ( eItemPedido item : bean.getItensPedido() ){
			if ( codProduto.equalsIgnoreCase(item.getCodProduto() )){
				this.currentItemPedido = item;
				break;
			}
		}			
		// Assinatura eletronica, solicita o motivo da alteração e se o usuório possui 
		// assinatura eletronica para permitir a alteração.
		if( "450".equalsIgnoreCase(bean.getTarefa())){ // Solicita Assinatura digital.
 
				String value = Window.prompt(bean.getMensagem(), "");
				if ( value != null ){
					String actionStruts = "";
					int index = getPainelListaProduto().getRecordIndex(currentRecord);
					// executa a atualização do preco conforme o tipo de busca realizado.
					if ( "S".equalsIgnoreCase(tipoBusca)){
						actionStruts = "vdw0001.do?method=gravarAssinaturaPrecoVendaServico&motivoAssinatura"+index+"="+value+"&tipoItem=servico&indexItem="+index;
					}
					else if ( "P".equalsIgnoreCase(tipoBusca)){
						actionStruts = "vdw0001.do?method=gravarAssinaturaPrecoVendaProduto&motivoAssinatura"+index+"="+value+"&tipoItem=item&indexItem="+index;
					}
				    gravarAssinaturaPrecoVenda(actionStruts, currentBean, currentItemPedido, currentRecord);
				}
				else{
					recalcula(null);
					getGerenciadorProdutos().getFiltroConsulta().onSuccess(record);
					HowMGWTWindowWait.hideWait();
				}
		}
		else if ( "160".equalsIgnoreCase(bean.getTarefa())){
			boolean value = Window.confirm(bean.getMensagem());
			if ( value ){
 
					String actionStruts = "";
					int index = getPainelListaProduto().getRecordIndex(currentRecord);
					if ( "S".equalsIgnoreCase(tipoBusca)){
						actionStruts = "vdw0001.do?method=gravarServico&tipoItem=servico&indexItem="+getIndexItem(codProduto);
					}
					else if ( "P".equalsIgnoreCase(tipoBusca)){
						actionStruts = "vdw0001.do?method=gravarProduto&tipoItem=item&indexItem="+getIndexItem(codProduto);
					}

					currentBean.setAtualizaPrecoUnitario(value);
					actionStruts += "&atualizaPrecoUnitario="+value;
				    gravarAssinaturaPrecoVenda(actionStruts, currentBean, currentItemPedido, currentRecord);
 
			}
			else{
				recalcula(null);
				getGerenciadorProdutos().getFiltroConsulta().onSuccess(record);
				HowMGWTWindowWait.hideWait();
			}   
		}else{
			HowMGWTControl.isRefreshFormShowMessage(bean);
			refreshQtdePreco(currentRecord, currentItemPedido, bean, true);
			recalcula(null);
			getGerenciadorProdutos().getFiltroConsulta().onSuccess(record);		
		}
		
		System.out.println("bean.getTarefa() : "+bean.getTarefa());
	}
	
	
	/**
	 * Grava a assinatura e atualiza o item.
	 * @param actionStruts
	 * @param currentBean
	 * @param currentItemPedido
	 * @param currentRecord
	 */
    public void gravarAssinaturaPrecoVenda(String actionStruts, FormBean bean, final eItemPedido item, final ListGridRecord record){
		int index = getPainelListaProduto().getRecordIndex(record);
    	HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(new com.br.client.model.vd.vdw0001.FormBean()) {					
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				FormBean bean = (FormBean)formBean;
				eItemPedido  item = getItem(record.getAttribute(getPainelListaProduto().fieldCodProduto.getName()),bean);
				boolean ret = HowMGWTControl.isRefreshFormShowMessage(bean);
				refreshQtdePreco(record, item, bean, true);
				recalcula(null);
				getGerenciadorProdutos().getFiltroConsulta().onSuccess(record);
				HowMGWTWindowWait.hideWait();
			}
		};
		double qtde 	  = record.getAttributeAsDouble(getPainelListaProduto().fieldQtde.getName());
		double precoVenda = record.getAttributeAsDouble(getPainelListaProduto().fieldPrecoVenda.getName());
		
		item.setPrecoVenda(""+precoVenda);
		item.setQtd(""+qtde);
		item.setQtdUnitaria(""+qtde);
		String encode = item.toEncodeFields("situacao;codColaborador;moeda");
		struts.request(actionStruts+encode, "VDW0001Form", "");
    }
    
	public void showShopping(){
		this.show();
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				focus();
				painelListaProduto.focus();
			}
		};
		timer.schedule(100);		
	}


	/**
	 * @return the mainLayout
	 */
	public HLayout getMainLayout() {
		return mainLayout;
	}


	/**
	 * @param mainLayout the mainLayout to set
	 */
	public void setMainLayout(HLayout mainLayout) {
		this.mainLayout = mainLayout;
	}


	/**
	 * @return the currentRecord
	 */
	public ListGridRecord getCurrentRecord() {
		return currentRecord;
	}


	/**
	 * @param currentRecord the currentRecord to set
	 */
	public void setCurrentRecord(ListGridRecord currentRecord) {
		this.currentRecord = currentRecord;
	}


	/**
	 * @return the labelTotalLista
	 */
	public HowMGWTLabel getLabelTotalLista() {
		return labelTotalLista;
	}


	/**
	 * @return the labelTotalPedido
	 */
	public HowMGWTLabel getLabelTotalPedido() {
		return labelTotalPedido;
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