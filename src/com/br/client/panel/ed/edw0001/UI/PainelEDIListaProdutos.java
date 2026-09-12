package com.br.client.panel.ed.edw0001.UI;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import com.br.client.configuracao.Configuracao;
import com.br.client.model.ed.edw0001.FormBean;
import com.br.client.model.ed.entity.eEDI;
import com.br.client.model.ed.entity.eEDIProduto;
import com.br.client.model.sg.entity.eDiretorioGED;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.vd.vdq0002.UI.PainelGerenciador;
import com.howmake.client.form.UI.HowMGWTFormToolbarDragSelect;
import com.howmake.client.form.UI.HowMGWTFormToolbarEdit;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.control.HowMGWTControlForm;
import com.howmake.client.form.control.HowMGWTControlFormDragSelect;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTFormProperties;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.EventHandler;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DropEvent;
import com.smartgwt.client.widgets.events.DropHandler;
import com.smartgwt.client.widgets.events.DropMoveEvent;
import com.smartgwt.client.widgets.events.DropMoveHandler;
import com.smartgwt.client.widgets.events.DropOverEvent;
import com.smartgwt.client.widgets.events.DropOverHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PainelEDIListaProdutos implements HowMGWTControlForm, HowMGWTControlFormDragSelect{
	private HowMGWTFormProperties properties = new HowMGWTFormProperties();
 
	private String codEDI;
	
	private ArrayList<ListGridRecord> deleteLocalRecords; 
	private TreeMap<String, ListGridRecord> selectRecords = new TreeMap<String, ListGridRecord>();
	private TreeMap<String, ListGridRecord> selectDeleteRecords = new TreeMap<String, ListGridRecord>();
	
	private Img actionLixeira;
	private Img actionVoltarLixeira;
	
	private String ID_EDIListaProdutos = "EDI_LISTA_PRODUTOS";
	
	private PainelGerenciador painelGerenciador;
	
	/**
	 * Declara as propriedades de edição do formulório.
	 */
	public HowMGWTProperty propertyCodEDI					 	= properties.createProperty("codEdi"			, Tradutor.i18n.formReg());
	public HowMGWTProperty propertyIndAtivo 					= properties.createProperty("indAtivo"			, Tradutor.i18n.formAtivo());
	public HowMGWTProperty propertyCodProduto			 	 	= properties.createProperty("codProduto"		, Tradutor.i18n.formCodProduto());	
	public HowMGWTProperty propertyDescComercial 			    = properties.createProperty("descComercial"		, Tradutor.i18n.formDescricaoProduto());
	public HowMGWTProperty propertyPrioridade  					= properties.createProperty("prioridadeReserva"	, Tradutor.i18n.formPrioridade());
 
	public HowMGWTProperty propertyFlagNovo	 			    	= properties.createProperty("flagControleNovo","Flag Novo Registro");

	public HowMGWTProperty propertyDtInicioVigencia  			= properties.createProperty("dtVigenciaInicio"	, Tradutor.i18n.formInicioVigencia());
	public HowMGWTProperty propertyDtFimVigencia  				= properties.createProperty("dtVigenciaFinal"	, Tradutor.i18n.formFimVigencia());
	
	
	private HowMGWTProperty propertyEDISaldoEstoque				= properties.createProperty("ediSaldo"			, Tradutor.i18n.formSaldoEstoqueEDI());
	private HowMGWTProperty propertyEDIPrecoVenda				= properties.createProperty("ediPrecoVenda"		, Tradutor.i18n.formPrecoVendaEDI());
	
			
	private HowMGWTListGrid panelList = new HowMGWTListGrid(){
		
	};
 
	
	// Cria a instancia da listagem somente após a configuração dos dados 
	// das propriedades
	
	private HowMGWTFormToolbarEdit formToolbarEdit;

	/*
	 * Construtor padrão
	 */
	public PainelEDIListaProdutos(){
 

		propertyCodEDI.setWidthColumn(40);

		propertyIndAtivo.setWidthColumn(40);
		propertyIndAtivo.setType(ListGridFieldType.BOOLEAN);
		propertyIndAtivo.createHowMGWTListGridField();
	
		propertyIndAtivo.getListField().setCanEdit(true);

		
		propertyCodProduto.setWidthColumn(110);
		propertyCodProduto.createHowMGWTListGridField();
		
		propertyDescComercial.createHowMGWTListGridField();
		
		propertyEDISaldoEstoque.setWidthColumn(100);
		propertyEDIPrecoVenda.setWidthColumn(100); 

		propertyEDIPrecoVenda.setType(ListGridFieldType.FLOAT);
		propertyEDISaldoEstoque.setType(ListGridFieldType.FLOAT);
		
		propertyEDISaldoEstoque.createHowMGWTListGridField();
		propertyEDIPrecoVenda.createHowMGWTListGridField();
		
		propertyEDISaldoEstoque.getListField().setAlign(Alignment.RIGHT);
		propertyEDIPrecoVenda.getListField().setAlign(Alignment.RIGHT);
		
		propertyEDISaldoEstoque.createFormatDouble( "###,###,###,##0", "");
		propertyEDIPrecoVenda.createFormatDouble( "###,###,###,##0.00" , "" );		

 
		
		
		// Criar Toolbar 
		// Cria o objeto de toolbar e adiciona no topo do formulório de controle.
		this.formToolbarEdit = new HowMGWTFormToolbarEdit(this, panelList);
		
		this.formToolbarEdit.getPanelList().addDropHandler(new DropHandler() {

			@Override
			public void onDrop(DropEvent event) {
				ListGridRecord[]  records = ((HowMGWTListGrid)EventHandler.getDragTarget()).getSelectedRecords();
				onDropVerify(records);
				event.cancel();
			}
		});


		this.formToolbarEdit.getPanelList().setCanAcceptDrop(true);
		this.formToolbarEdit.getPanelList().setCanDragRecordsOut(true);
		this.formToolbarEdit.getPanelList().setCanAcceptDroppedRecords(true);

		this.formToolbarEdit.getPanelList().setID("ID_EDIListaProdutos");

	}
  
	/**
	 * @return the formToolbarEdit
	 */
	public HowMGWTFormToolbarEdit getFormToolbarEdit() {
		return formToolbarEdit;
	}	
	
	

	/**
	 * @return the painelBuscaProduto
	 */
	public PainelGerenciador getPainelGerenciador() {
		return painelGerenciador;
	}

	/**
	 * @param painelBuscaProduto the painelBuscaProduto to set
	 */
	public void setPainelGerenciador(PainelGerenciador painelGerenciador) {
		this.painelGerenciador = painelGerenciador;
	}
	
	
	
	
	
	// ------------------------------------------------------------------------
	// Implementação da interface de controle do formulório.
	// ------------------------------------------------------------------------
	 
	
	/**
	 * Retorna as propriedades do formulório.
	 */
	public HowMGWTFormProperties getHowMProperties(){
		return properties;
	}
	
	/**
	 * Carrega os dados para a cache prepara os dados para visualização do usuório.
	 */
	@Override
	public void onHowMLoad(HowMGWTFormBean formBean) {
		RecordList records = new RecordList();
		FormBean bean = (FormBean)formBean;		  

		// -------------------------------------------------------------------
		// Carrega os dados dos produtos EDIs.
		// -------------------------------------------------------------------		
		if( bean.getEdiProdutos() != null ){
			// Carrega os dados de EDI e prepara a visualização para o 
			// usuório.
			for ( eEDIProduto ediProduto : bean.getEdiProdutos() ){
				ListGridRecord record = formToolbarEdit.convertFormBeanToRecord(ediProduto);
				record.setAttribute(propertyFlagNovo.getName(), false );
				
//				ListGridRecord record = new ListGridRecord();
//				for ( HowMGWTProperty prop : this.getHowMProperties().getProperties() ){
//					if ( prop.getName().equalsIgnoreCase(propertyIndAtivo.getName()))
//						record.setAttribute(prop.getName(), ediProduto.toBoolean(prop.getName()));
//					else if ( prop.getName().equals(propertyFlagNovo.getName()))
//						record.setAttribute(prop.getName(), false );					
//					else
//						record.setAttribute(prop.getName(), ediProduto.toString(prop.getName()));
//				}
				
				if ( selectRecords.get(ediProduto.getCodProduto()) == null )
					selectRecords.put(ediProduto.getCodProduto().toUpperCase(), record);
				
				records.add(record);
			}
		}
		// Aciona o controlador para carregar os dados
		this.formToolbarEdit.getPanelList().setData(records);
	}


	/**
	 * Seta os valores selecionados no resultado e apresenta no painel.
	 */
	public void onHowMSetValues(ListGridRecord record){}
 
	/**
	 * Evento disparado quando o botão da barra de ferramentas é pressionado.
	 */
	@Override
	public void onHowMDeleteRecord() {}
 
	/**
	 * Coloca a tela em modo edição
	 */
	@Override
	public void onHowMEditRecord() {}
 
	/**
	 * Prepara a tela para um novo registro.
	 */
	@Override
	public void onHowMNewRecord() {}
 
	/**
	 * Evento disparado quando o botão gravar da barra de ferramentas é pressionado.
	 */
	@Override
	public void onHowMSave() {}
	
	@Override
	public void onHowMRelation(ListGridRecord record) {

		this.codEDI = null;
		
		this.selectRecords.clear();
		this.selectDeleteRecords.clear();

		if ( this.selectDeleteRecords.size() > 0 ){
			if ( actionLixeira != null ){
				actionLixeira.setSrc("tools/bot_lixeira_cheia.png");
				actionVoltarLixeira.setVisible(true);
			}
		}
		else{
			if ( actionLixeira != null ){
				actionLixeira.setSrc("tools/bot_lixeira_vazia.png");
				actionVoltarLixeira.setVisible(false);
			}
		}		
		
		if ( record == null ){
			// Limpa os registros em cache.
			this.formToolbarEdit.getPanelList().clearAllRecords();
			return;
		}
		
		HowMGWTWindowWait.showWait();		
		FormBean formBean = new FormBean();
	    HowMGWTPlugInStruts struts = new HowMGWTPlugInStruts(formBean) {
			
			@Override
			public void onResponse(HowMGWTFormBean formBean) {
				if ( HowMGWTControl.isRefreshFormShowMessage(formBean, true ) ){
					HowMGWTWindowWait.hideWait();
					return;
				}

				onHowMLoad(formBean);
				HowMGWTWindowWait.hideWait();
			}
			
			@Override
			public void onError(Throwable err) {
				super.onError(err);
				formToolbarEdit.onHowMConfigureStatusNewRecord();
			}			
		};
				
		this.codEDI = record.getAttribute(propertyCodEDI.getName());
		String body = "";
		// body += "&"+propertyCodEDI.getName()+"="+this.codEDI;

		FormBean bean = new FormBean();
		eEDI edi = new eEDI();
		edi.setCodEdi(this.codEDI);
		edi.setCodEmpresa(Configuracao.getCodEmpresa());
		bean.setEdi(edi);
		
		struts.request("edw0001.do?method=buscarProdutosEDI",  "EDW0001Form", bean.toSendBody(""));					
	}


	
	
	
	
	

	
	// ------------------------------------------------------------------------
	// Controla drag and drop de registros via barra de ferramenta drag select.
	// ------------------------------------------------------------------------

	@Override
	public void onHowMInit(HowMGWTFormToolbarDragSelect formDragSelect) {
		formDragSelect.getActionSelectAllLeft().setVisible(false);
		formDragSelect.getActionSelectLeft().setVisible(false);
	}

	@Override
	public boolean onHowMSendAllLeft() 	{ return false; }
	@Override
	public boolean onHowMSendLeft() 	{ return false; }


	
	
	@Override
	public boolean onHowMSendAllRight() {
		ListGridRecord[] records = getPainelGerenciador().getPainelGerenciadorProduto().getListaProduto().getRecords();
		if ( records.length == 0 )
			return false;
		
		this.onDropVerify(records);
		return true;
	}

	@Override
	public boolean onHowMSendRight() { 
		ListGridRecord[] records = getPainelGerenciador().getPainelGerenciadorProduto().getListaProduto().getSelectedRecords();
		if (  records.length == 0 )
			return false;

		this.onDropVerify(records);
		return true;
	}

	
	
	

	
	
	
	public void onDropVerify(ListGridRecord[] records){
		if ( records != null ){
			int inserts  = 0;
			int descarts = 0;
			int restore  = 0;
			RecordList recordList = this.getFormToolbarEdit().getPanelList().getRecordList();
			
			for ( ListGridRecord record : records ){
				
				String codProduto = record.getAttribute(this.propertyCodProduto.getName()).toUpperCase();
				String descProduto = record.getAttribute("Descricao");
				
				if ( this.selectRecords.get(codProduto) == null ){
					ListGridRecord deleteRecord = this.selectDeleteRecords.get(codProduto) ;
					if ( deleteRecord != null ){
						recordList.add(deleteRecord);
						this.selectRecords.put(codProduto, deleteRecord);						
						this.selectDeleteRecords.remove(codProduto);
						restore ++ ;
					}
					else{
						ListGridRecord newRecord = new ListGridRecord();
						newRecord.setAttribute(this.propertyIndAtivo.getName(), true);
						newRecord.setAttribute(this.propertyCodProduto.getName(), codProduto);
						newRecord.setAttribute(this.propertyDescComercial.getName(), descProduto );
						newRecord.setAttribute(this.propertyFlagNovo.getName(), true);
						recordList.add(newRecord);
						this.selectRecords.put(codProduto, newRecord);						
						inserts ++ ;
					}
				}
				else{
					descarts ++ ;
				}
			}
			String msg = "";
			if ( inserts > 0 ){
				if ( inserts == 1)
					msg += "Inserido "+inserts+" registro com sucesso.<br>";
				else
					msg += "Inserido "+inserts+" registros com sucesso.<br>";
			
			}
			if ( descarts > 0 ){
				if ( descarts == 1)
					msg += "Descatado "+descarts+" registro por já existir na lista da direita.<br>";				
				else
					msg += "Descatados "+descarts+" registros por já existirem na lista da direita.<br>";
			}
			
			if ( restore > 0 ){
				if ( restore == 1)
					msg += "Restaurado "+restore+" registro que estava marcado para exclusão.<br>";				
				else
					msg += "Restaurados "+restore+" registros que estavam marcados para exclusão.<br>";
				
				if ( this.selectDeleteRecords.size() > 0 ){
					actionLixeira.setSrc("tools/bot_lixeira_cheia.png");
					actionVoltarLixeira.setVisible(true);
				}
				else{
					actionLixeira.setSrc("tools/bot_lixeira_vazia.png");
					actionVoltarLixeira.setVisible(false);
				}				
			}
			if ( HowMGWTUtilities.isEmpty(msg))
				msg += "Nehum registro inserido ";
			
			SC.say(msg);
		}
	}

	/**
	 * @return the actionLixeira
	 */
	public Img getActionLixeira() {
		return actionLixeira;
	}

	/**
	 * @param actionLixeira the actionLixeira to set
	 */
	public void setActionLixeira(Img actionLixeira) {
		this.actionLixeira = actionLixeira;
		this.actionLixeira.setCanAcceptDrop(true);
		this.actionLixeira.addDropHandler(new DropHandler() {
			
			@Override
			public void onDrop(DropEvent event) {
				ListGridRecord[]  records = ((HowMGWTListGrid)EventHandler.getDragTarget()).getSelectedRecords();
				onDropVerifyActionExcluir(records);
				event.cancel();				
			}
		});
		
		this.actionLixeira.addDropOverHandler(new DropOverHandler() {
			
			@Override
			public void onDropOver(DropOverEvent event) {
				event.cancel();
			}
		});

		this.actionLixeira.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[]  records = getFormToolbarEdit().getPanelList().getSelectedRecords();
				onDropVerifyActionExcluir(records);		
			}
		});
	}
	
	public void onDropVerifyActionExcluir(ListGridRecord[] records){
		int inserts  = 0;
		int descarts = 0;
		int inativos = 0;

		if ( records != null ){
			for ( ListGridRecord record : records ){
				
				String codProduto = record.getAttribute(this.propertyCodProduto.getName()).toUpperCase();
				String descProduto = record.getAttribute("Descricao");
				
				ListGridRecord deleteRecord = this.selectDeleteRecords.get(codProduto);
				if (  deleteRecord == null ){
					deleteRecord = this.selectRecords.get(codProduto);
					if ( deleteRecord != null ) {
						if ( propertyFlagNovo.getHowMValueBoolean(record) ){						
							this.selectDeleteRecords.put(codProduto, deleteRecord);
							inserts ++ ;
							this.getFormToolbarEdit().getPanelList().removeData(deleteRecord);
							this.selectRecords.remove(codProduto);
						}
						else{
							deleteRecord.setAttribute(this.propertyIndAtivo.getName(), false);
							inativos ++ ;
						}
					}
					else
						descarts ++ ;
				}
				else
					descarts ++ ;
			}
			
			if ( this.selectDeleteRecords.size() > 0 ){
				actionLixeira.setSrc("tools/bot_lixeira_cheia.png");
				actionVoltarLixeira.setVisible(true);
			}
			else{
				actionLixeira.setSrc("tools/bot_lixeira_vazia.png");
				actionVoltarLixeira.setVisible(false);
			}
			String msg = "";
			if ( inserts > 0 ){
				if ( inserts == 1)
					msg += "<li>Marcado para exclusão "+inserts+" registro com sucesso.<br>";
				else
					msg += "<li>Marcados para exclusão "+inserts+" registros com sucesso.<br>";
			
			}
			if ( descarts > 0 ){
				if ( descarts == 1)
					msg += "<li>Descatado "+descarts+" registro por já estar marcado como excluído.<br>";				
				else
					msg += "<li>Descatados "+descarts+" registros por já estarem marcados como excluído.<br>";
			}
			if ( inativos > 0 ){
				if ( inativos == 1)
					msg += "<li><font color=red>Marcado "+inativos+" registro como inativo em função de que o mesmo já encontra-se associado ao EDI.</font><br>";				
				else
					msg += "<li><font color=red>Marcados "+inativos+" registros como inativos em função de que os mesmos já encontra-se associados ao EDI.</font><br>";				
			}
			
			if ( HowMGWTUtilities.isEmpty(msg))
				msg += "Selecione primeiro os registros para marcar como como excluído ";
			
			SC.say(msg);			
		}
	}

	/**
	 * @return the actionVoltarLixeira
	 */
	public Img getActionVoltarLixeira() {
		return actionVoltarLixeira;
	}

	/**
	 * @param actionVoltarLixeira the actionVoltarLixeira to set
	 */
	public void setActionVoltarLixeira(Img actionVoltarLixeira) {
		this.actionVoltarLixeira = actionVoltarLixeira;
		
		this.actionVoltarLixeira.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				restoreRecords();
			}
		});
	}
	
	public void restoreRecords(){
		ListGridRecord[] records = new ListGridRecord[this.selectDeleteRecords.size()];
		Set<String> keys = this.selectDeleteRecords.keySet();
		int i = 0 ;
		for (String key : keys ){	
			records[i] = this.selectDeleteRecords.get(key);
			i ++ ;
		}
		onDropVerify( records );		
	}

	/**
	 * @return the selectRecords
	 */
	public TreeMap<String, ListGridRecord> getSelectRecords() {
		return selectRecords;
	}

	/**
	 * @return the selectDeleteRecords
	 */
	public TreeMap<String, ListGridRecord> getSelectDeleteRecords() {
		return selectDeleteRecords;
	}
	
	
	/**
	 * @return Seleciona os registros alterados para envio para o servidor.
	 */
	public eEDIProduto[] getItens(){
		deleteLocalRecords = new ArrayList<ListGridRecord>();
		
		// Confirma todas as alterações do usuório 
		this.getFormToolbarEdit().getPanelList().saveAllEdits();
		
		boolean indAtivo;
		String codProduto;
		boolean flagNovo;
		String dtInicioVigencia;
		String dtFimVigencia;
		
		ArrayList<eEDIProduto> itens = new ArrayList<eEDIProduto>();
		
		Object[] keys = this.getSelectDeleteRecords().keySet().toArray();
		ListGridRecord record;
		eEDIProduto ediProduto;
		for ( Object key : keys){
			record = this.getSelectDeleteRecords().get(key);			
			indAtivo			= propertyIndAtivo.getHowMValueBoolean(record);
			codProduto			= propertyCodProduto.getHowMValue(record);
			flagNovo			= propertyFlagNovo.getHowMValueBoolean(record);		

			dtInicioVigencia 	= propertyDtInicioVigencia.getHowMValue(record);
			dtFimVigencia 		= propertyDtFimVigencia.getHowMValue(record);		
			
			// Adiciona os registros incluídos e depois delatados para serem tratados localmente.
			if(  flagNovo )
				deleteLocalRecords.add(record);
			// Inclui o registro para ser excluído na transação.
			else{
				ediProduto		= new eEDIProduto();
				ediProduto.setCodProduto(codProduto);
				ediProduto.setCodEDI(this.codEDI);
				ediProduto.setIndAtivo(false);
				ediProduto.setOperacao(HowMGWTUtilities.OPERATION_DELETE);

				ediProduto.setDtVigenciaInicio(dtInicioVigencia);
				ediProduto.setDtVigenciaFinal(dtFimVigencia);

				itens.add(ediProduto);
			}
		}

		keys = this.getSelectRecords().keySet().toArray();

		for ( Object key : keys){
			record = this.getSelectRecords().get(key);			
			indAtivo			= propertyIndAtivo.getHowMValueBoolean(record);
			codProduto			= propertyCodProduto.getHowMValue(record);
			flagNovo			= propertyFlagNovo.getHowMValueBoolean(record);		

			dtInicioVigencia 	= propertyDtInicioVigencia.getHowMValue(record);
			dtFimVigencia 		= propertyDtFimVigencia.getHowMValue(record);		
			

			// Adiciona os registros incluídos e depois deletados para serem tratados localmente.
			ediProduto		= new eEDIProduto();
			ediProduto.setCodProduto(codProduto);
			ediProduto.setCodEDI(this.codEDI);
			ediProduto.setIndAtivo(indAtivo);

			if(  flagNovo )
				ediProduto.setOperacao(HowMGWTUtilities.OPERATION_INSERT);

			// Inclui o registro para ser excluído na transação.
			else
				ediProduto.setOperacao(HowMGWTUtilities.OPERATION_UPDATE);

			ediProduto.setDtVigenciaInicio(dtInicioVigencia);
			ediProduto.setDtVigenciaFinal(dtFimVigencia);

			itens.add(ediProduto);
		}
		
		eEDIProduto[] produtos = new eEDIProduto[itens.size()];
		for( int i = 0 ; i < produtos.length ; i ++ )
			produtos[i] = itens.get(i);
		
		return produtos;
	}
}