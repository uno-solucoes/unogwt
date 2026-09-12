package com.br.client.panel.vd.vdq0002.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.vd.entity.eModuloVDQ0002;
import com.google.gwt.i18n.client.NumberFormat;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTDataRecord;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyPressEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyPressHandler;
import com.smartgwt.client.widgets.grid.CellEditValueParser;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.HoverCustomizer;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;

public class PainelListaProduto extends HowMGWTListGrid{

	private String moeda						= "R$";
	private KeyPressHandler keyPressHandler;
	private boolean changedQtde     			= false;
	private boolean changedPrecoVenda 			= false;
	private boolean keyPressedEnterQtde 		= false;
	private boolean keyPressedEnterPrecoVenda 	= false;
	
	private ListGridRecord lastSelectRecord     = null;
	private String lastValueChanged 			= null;
	
	public static final int OPCAO_ALTERACAO_QTDE  = 1;
	public static final int OPCAO_ALTERACAO_PRECO = 2;
	public static final int OPCAO_ACAO            = 3;
	public static final int OPCAO_ACAO_LOOKUP 	  = 4;
	
	private PainelGerenciadorProdutos painelGerenciadorProduto;
	private String tabPreco;
	private VDD0011PainelDetalheItem painelDetalheItem = new VDD0011PainelDetalheItem();
	private ENW0001GPainelKitProduto painelKitProduto;
	private VDD0004PainelSimulacaoEstoque painelSimulacaoEstoque;
	private VDD0005PainelEstoquePorEmpresa painelEstoqueEmpresa;
	
	public ListGridField fieldQtde 			 	 = new ListGridField("Qtde", 				Tradutor.i18n.formQtde()				,  35);
	public ListGridField fieldCodProduto 		 = new ListGridField("codProduto", 			Tradutor.i18n.formCodProduto()			,  90);
	public ListGridField fieldActionDetalheItem  = new ListGridField("ActionDetalheItem", 	" "							  			,  56);
	public ListGridField fieldMarca 			 = new ListGridField("Marca", 				Tradutor.i18n.formMarca()				,  70);
	public ListGridField fieldDescricaoComercial = new ListGridField("Descricao", 			Tradutor.i18n.formDescricaoAbreviada()	, 195);
	public ListGridField fieldUnidadeMedida	 	 = new ListGridField("UnidadeMedida", 		Tradutor.i18n.formUnidadeMedida()		,  50);
	public ListGridField fieldEstoqueDisponivel  = new ListGridField("EstDisponivel",		Tradutor.i18n.formEstoqueDisponivel()	,  60);
	public ListGridField fieldIconeSimEst 		 = new ListGridField("IconeSimEst",			Tradutor.i18n.formIconeSimEst()			,  60);
	public ListGridField fieldIconeEstEmpresa	 = new ListGridField("IconeEstEmpr",		" "									    ,  36);
	public ListGridField fieldPrecoVenda		 = new ListGridField("PrecoVenda",			Tradutor.i18n.formPrecoVenda()			,  80);
	public ListGridField fieldPrecoVendaST		 = new ListGridField("PrecoVendaST",		Tradutor.i18n.formPrecoVendaST()	    ,  70);
	public ListGridField fieldIconePromocao	 	 = new ListGridField("IconePrecoVenda",		Tradutor.i18n.formIconePromocao()		,  10);
	public ListGridField fieldIconePrecoDif	 	 = new ListGridField("IconePrecoDif",		" "										,  20);
	public ListGridField fieldDescricaoTecnica	 = new ListGridField("descricaoTecnica",	"Descricao Tecnica" 					,  10);
	public ListGridField fieldObservacoes		 = new ListGridField("observacoes",			"Observacao" 						    ,  10);
	public ListGridField fieldPossuiKit		 	 = new ListGridField("Possui Kit",			"Possui Kit" 						    ,  50);

	public ListGridField fieldPrecoLista		 = new ListGridField("precoLinha",			Tradutor.i18n.formPrecoLista()  		,  90);
	public ListGridField fieldTotalItem		 	 = new ListGridField("totalItem",			Tradutor.i18n.formprecoTotal() 			, 100);

	/*
	 * Corpo Cybershop
	 * OC: 76596
	 */
//	public ListGridField fieldEstoqueSP          = new ListGridField("saldoEstoqueSP",          "Estoque SP"                            ,  80);
//	public ListGridField fieldEstoqueES          = new ListGridField("saldoEstoqueES",          "Estoque ES"                            ,  80);
	
    private TextItem editorFieldQtde 		 = new TextItem(fieldQtde.getName());
    private TextItem editorFieldPrecoVenda = new TextItem(fieldPrecoVenda.getName());

    private boolean canEdit				= true;
    private boolean lookup 				= false;

	private boolean shopping			= false;
	private boolean showKit 			= true;
	private boolean detailListaProduto 	= false;
	private String corpo;

	public PainelListaProduto(String corpo, boolean detail, boolean shopping, boolean canEdit, boolean lookup, String moeda){
       		
		this.setMoeda(moeda);
		this.canEdit = canEdit;
		this.lookup  = lookup;

		this.setWrapCells(true);  
        this.setFixedRecordHeights(false);
		
		this.corpo 				= corpo;
        this.detailListaProduto = detail;		        

        if( !"Cybershop".equalsIgnoreCase( corpo ) ) {
//        	fieldEstoqueES.setHidden( true );
//        	fieldEstoqueSP.setHidden( true );
        } else {
        	fieldUnidadeMedida.setHidden( true );
        	fieldPrecoLista.setHidden( true );
        	fieldEstoqueDisponivel.setHidden( true );
        }
        
        	this.setFields(
        			fieldQtde,
        			fieldCodProduto,
        			fieldActionDetalheItem,
        			fieldMarca,
        			fieldDescricaoComercial,
        			fieldUnidadeMedida,
        			fieldEstoqueDisponivel,
        			fieldIconeSimEst,
        			fieldIconeEstEmpresa,
        			fieldPrecoVenda,
        			fieldPrecoVendaST,
        			fieldIconePromocao,
        			fieldIconePrecoDif,
        			fieldDescricaoTecnica,
        			fieldObservacoes,
        			fieldPossuiKit,
        			fieldPrecoLista,
        			fieldTotalItem
        			);

		this.shopping = shopping;

 
		
		CellFormatter formatterQtde = new CellFormatter() {
	        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
	            if(value == null) return null; 
	            try{
	            	return NumberFormat.getFormat(HowMGWTUtilities.getMask(eModuloVDQ0002.PARAM_qtdCasasDecimaisQtdProduto)).format(new Double(value.toString()));
	            }
	            catch(Throwable er){
	            	return value.toString();
	            }
	        }
		};
		
		
		CellFormatter formatterValor = new CellFormatter() {
	        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
	            if(value == null) return null;
	            try{
	            	return PainelListaProduto.this.getMoeda()+" "+NumberFormat.getFormat(HowMGWTUtilities.getMask(eModuloVDQ0002.PARAM_qtdCasasDecimaisPrecoUnitProduto)).format(new Double(value.toString()));
	            }
	            catch(Throwable er){
	            	return value.toString();
	            }
	        }
		};
		
//		if( "Cybershop".equalsIgnoreCase( corpo ) ) {
//        	fieldEstoqueSP.setType( ListGridFieldType.FLOAT );
//        	fieldEstoqueSP.setCellFormatter( formatterQtde );
//        	fieldEstoqueES.setType( ListGridFieldType.FLOAT );
//        	fieldEstoqueES.setCellFormatter( formatterQtde );
//		}
		
		fieldQtde.setType(ListGridFieldType.FLOAT);
		fieldEstoqueDisponivel.setType(ListGridFieldType.FLOAT);
		fieldPrecoVendaST.setType(ListGridFieldType.FLOAT);
		fieldPrecoVenda.setType(ListGridFieldType.FLOAT);
		
		fieldPrecoLista.setType(ListGridFieldType.FLOAT);
		fieldTotalItem.setType(ListGridFieldType.FLOAT);
		
		fieldQtde.setCellFormatter(formatterQtde);
		fieldEstoqueDisponivel.setCellFormatter(formatterQtde);
		fieldPrecoVendaST.setCellFormatter(formatterValor);
		fieldPrecoVenda.setCellFormatter(formatterValor);

		fieldPrecoLista.setCellFormatter(formatterValor);
		fieldTotalItem.setCellFormatter(formatterValor);
		
		this.setHeaderHeight(36);
	
        this.onHowMInitEntityControl();      	
		
        // this.fieldQtde.setHidden(true);        
        this.fieldObservacoes.setHidden(true);
        this.fieldDescricaoTecnica.setHidden(true);

        
        
        // 14/12/2011 - incluído recurso para desabilitar a edição.
        if ( ! this.canEdit ){
        	this.fieldQtde.setHidden(true);
        	this.fieldUnidadeMedida.setHidden(true);
        	this.fieldMarca.setHidden(true);
        	
        	if ( this.lookup ){
        		fieldDescricaoComercial.setWidth(500);
        		this.fieldIconePrecoDif.setWidth(30);
        	}
        	else
        		this.fieldIconePrecoDif.setHidden(true);
        	
        	this.fieldIconePromocao.setHidden(true);
        	this.fieldIconeEstEmpresa.setHidden(true);
        	this.fieldIconeSimEst.setHidden(true);
        }        
        
        this.fieldObservacoes.setCanHide(false);
        this.fieldDescricaoTecnica.setCanHide(false);        
        this.fieldQtde.setCanHide(false);

        if ( ! shopping )
        	fieldPrecoVendaST.setHidden(true);
  
        
        this.fieldPrecoVendaST.setCanHide(false);
        
        this.fieldPossuiKit.setHidden(true);
        this.fieldPossuiKit.setCanHide(false);
    	this.fieldIconeSimEst.setHidden(true);
    	// this.fieldIconeEstEmpresa.setHidden(true);
    	this.fieldIconePromocao.setHidden(true);
    	// this.fieldIconePrecoDif.setHidden(true);
    	
    	this.fieldIconeSimEst.setCanHide(false);
    	this.fieldIconeEstEmpresa.setCanHide(false);

    	this.fieldIconePromocao.setCanHide(false);
    	this.fieldIconePrecoDif.setCanHide(false);
    	
        this.setCanAutoFitFields(false);        
        
        for ( ListGridField field :  this.getFields()){
        	field.setCanHide(false);
        	field.setCanReorder(false);
        	field.setCanGroupBy(false);
        	field.setCanFreeze(false);
        	field.setCanSort(false);
        	field.setCanSortClientOnly(false);
			field.setWrap(true);
			field.setCanEdit(false);
        }
        this.setEditEvent(ListGridEditEvent.CLICK);
        
		// Evento para detectar a alteração de dados no campo.
		com.smartgwt.client.widgets.form.fields.events.ChangeHandler changeHandler = new com.smartgwt.client.widgets.form.fields.events.ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if ( event.getItem() != null ){
					if ( event.getValue() == null )
						lastValueChanged = "0";
					else 
						lastValueChanged = event.getValue().toString();

					//Indica se a alteração é de quantidade.
					changedQtde 	  = event.getItem().getName().equals(editorFieldQtde.getName());
					changedPrecoVenda = event.getItem().getName().equals(editorFieldPrecoVenda.getName());					
				}
			}
		};
		
		if ( ! isShopping() ){
	        keyPressHandler = new KeyPressHandler() {			
				@Override
				public void onKeyPress(KeyPressEvent event) {
					if ( event.getCharacterValue() == null )
						return;
					lastSelectRecord = getSelectedRecord();
					
					if ( event.getCharacterValue() == 13){ // Enter	
						if ( event.getItem().getName().equals(editorFieldQtde.getName()) )
							keyPressedEnterQtde = true;
						if ( event.getItem().getName().equals(editorFieldPrecoVenda.getName()) )
							keyPressedEnterPrecoVenda = true;
						
						if ( !HowMGWTUtilities.isEmpty(lastValueChanged) ){
							if ( changedQtde )
								lastSelectRecord.setAttribute(fieldQtde.getName(), HowMGWTUtilities.getDoubleToBD(lastValueChanged));
							if ( changedPrecoVenda )
								lastSelectRecord.setAttribute(fieldPrecoVenda.getName(), HowMGWTUtilities.getDouble(lastValueChanged));
						}
						event.cancel();
						changeField();
					}					
					else { 
						System.out.println("ASC KeyPress : "+event.getCharacterValue());
					}
					
				}
			};
		}

		this.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				// Window.alert("Fim da edição col:"+event.getColNum()+":row:"+event.getRowNum()+"-NEW VALUE : "+event.getNewValues()+"- OLD VALUE : "+event.getOldRecord());
				if ( keyPressedEnterQtde || keyPressedEnterPrecoVenda )
					return;
				lastSelectRecord = getRecord(event.getRowNum());
				changeField();
			}
		});
		
        editorFieldQtde.addChangeHandler(changeHandler);
        if ( !isShopping() )
        	editorFieldQtde.addKeyPressHandler(keyPressHandler);

        editorFieldPrecoVenda.addChangeHandler(changeHandler);
        if ( !isShopping() )
        	editorFieldPrecoVenda.addKeyPressHandler(keyPressHandler);
        
        
//        editorFieldQtde.setInputTransformer(HowMGWTProperty.getInputDoubleTransformer());
//        fieldQtde.setEditValueParser(new CellEditValueParser() {			
//			@Override
//			public Object parse(Object value, ListGridRecord record, int rowNum,int colNum) {			
//				return ""+HowMGWTUtilities.getDouble(value);
//			}
//		});
        
        fieldQtde.setEditorType(editorFieldQtde);
        fieldQtde.setCanEdit(true);
        
        if( shopping ){
        	
        	editorFieldPrecoVenda.setInputTransformer(HowMGWTProperty.getInputDoubleTransformer());
        	fieldPrecoVenda.setEditValueParser(new CellEditValueParser() {			
    			@Override
    			public Object parse(Object value, ListGridRecord record, int rowNum,int colNum) {			
    				return ""+HowMGWTUtilities.getDouble(value);
    			}
    		});        	
        	fieldPrecoVenda.setEditorType(editorFieldPrecoVenda);
        	fieldPrecoVenda.setCanEdit(true);
        }    
  
        fieldDescricaoComercial.setShowHover(true);
        fieldDescricaoComercial.setHoverCustomizer(new HoverCustomizer() {  
            public String hoverHTML(Object value, ListGridRecord record, int rowNum, int colNum) {                  
                return record.getAttribute(fieldDescricaoComercial.getName());  
            }  
        });

        if ( ! shopping ){

        	if ( "0002".equals(corpo))
        		this.fieldPrecoVenda.setHidden(true);

        	this.fieldTotalItem.setHidden(true);

        	if( "0002".equals(corpo)){
	        	this.fieldQtde.setCanEdit(false);
	        	this.fieldQtde.setHidden(true);
	        	this.fieldIconePrecoDif.setHidden(true);
        	}
 
        }
        else{
        	if ( "0002".equals(corpo)){
        		// Se for o corpo 002 e for a tela do carrinho, reorganiza os campos.
        		int idxQtde = this.getFieldNum(fieldQtde.getName());
        		int idxPv   = this.getFieldNum(fieldIconeEstEmpresa.getName());
        		this.reorderField(idxQtde, idxPv);

        		idxQtde = this.getFieldNum(fieldPrecoLista.getName());
        		idxPv   = this.getFieldNum(fieldPrecoVenda.getName());
        		this.reorderField(idxQtde, idxPv);
        		
        		idxQtde = this.getFieldNum(fieldTotalItem.getName());
        		idxPv   = this.getFieldNum(fieldIconePrecoDif.getName());
        		this.reorderField(idxQtde, idxPv);
        		
        	}
        	else{
            	this.fieldPrecoLista.setHidden(true);
            	this.fieldTotalItem.setHidden(true);    		
        	}
        }
        
	}
	
	/**
	 * Submete o valor alterado no campo.
	 */
	public void changeField(){
		if ( lastSelectRecord == null ){
			return ;
		}
//		Timer timer = new Timer() {
//			
//			@Override
//			public void run() {
				if ( changedQtde || keyPressedEnterQtde){
					String qtde = lastSelectRecord.getAttribute(fieldQtde.getName());
					if ( ! HowMGWTUtilities.isEmpty(qtde)){
						HowMGWTWindowWait.showWait();
						if( PainelListaProduto.this.lookup ){
							HowMGWTWindowWait.hideWait();
							selectRecordAndClose(lastSelectRecord, OPCAO_ACAO_LOOKUP);
						}
						else
							selectRecordAndClose(lastSelectRecord, OPCAO_ALTERACAO_QTDE);
						changedQtde = false;
					}
					else{
						lastSelectRecord.setAttribute(fieldQtde.getName(), 0.0);
						int index = getRecordIndex(lastSelectRecord);
						if ( index >=0 )
							refreshRow(index);
					}
				}
				else if ( changedPrecoVenda || keyPressedEnterPrecoVenda){
					String precoVenda = lastSelectRecord.getAttribute(fieldPrecoVenda.getName());
					if ( ! HowMGWTUtilities.isEmpty(precoVenda) ){
						HowMGWTWindowWait.showWait();
						selectRecordAndClose(lastSelectRecord, OPCAO_ALTERACAO_PRECO);
						changedPrecoVenda = false;
						System.out.println("Preco Venda : "+precoVenda);
					}
					else{
						lastSelectRecord.setAttribute(fieldPrecoVenda.getName(), 0.0);
						int index = getRecordIndex(lastSelectRecord);
						if ( index >=0 )
							refreshRow(index);
					}
				}
				keyPressedEnterQtde 		= false;
				keyPressedEnterPrecoVenda 	= false;
//			}
//		};
//		timer.schedule(5);
	}

	/**
	 * @return the fieldCodProduto
	 */
	public ListGridField getFieldCodProduto() {
		return fieldCodProduto;
	}

	/**
	 * @param fieldCodProduto the fieldCodProduto to set
	 */
	public void setFieldCodProduto(ListGridField fieldCodProduto) {
		this.fieldCodProduto = fieldCodProduto;
	}

	/**
	 * @return the fieldDescricaoTecnica
	 */
	public ListGridField getFieldDescricaoTecnica() {
		return fieldDescricaoTecnica;
	}

	/**
	 * @param fieldDescricaoTecnica the fieldDescricaoTecnica to set
	 */
	public void setFieldDescricaoTecnica(ListGridField fieldDescricaoTecnica) {
		this.fieldDescricaoTecnica = fieldDescricaoTecnica;
	}

	/**
	 * @return the fieldDescricaoComercial
	 */
	public ListGridField getFieldDescricaoComercial() {
		return fieldDescricaoComercial;
	}

	/**
	 * @param fieldDescricaoComercial the fieldDescricaoComercial to set
	 */
	public void setFieldDescricaoComercial(ListGridField fieldDescricaoComercial) {
		this.fieldDescricaoComercial = fieldDescricaoComercial;
	}

	/**
	 * @return the fieldObservacoes
	 */
	public ListGridField getFieldObservacoes() {
		return fieldObservacoes;
	}

	/**
	 * @param fieldObservacoes the fieldObservacoes to set
	 */
	public void setFieldObservacoes(ListGridField fieldObservacoes) {
		this.fieldObservacoes = fieldObservacoes;
	}
	
	
   @Override
    protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) { 

	    if( getField(colNum).getName().equals(fieldEstoqueDisponivel.getName()) ){
		    
	    	Double qtd = (Double)record.getAttributeAsDouble(fieldEstoqueDisponivel.getName());
	        if ( qtd.doubleValue() <= 0 )
	        	return "background-color:red; color:#ffffff;";	    	
	    }
	    return "";
   }
	
   private ListGridRecord rollOverRecord;
   private HLayout rollOverCanvas;
   
 
	
	/**
	 * Permite criar componentes para representar ações dentro da grid.
	 */
	@Override
	protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) {
		String fieldName = this.getFieldName(colNum);

		// Cria o botao para mostrar os detalhes do item.
		if ( fieldName.equalsIgnoreCase(fieldActionDetalheItem.getName())){		
			HLayout layout = new HLayout();
			layout.setWidth100();
			layout.setHeight100();
			
			ImgButton actionDetalhe = new ImgButton();
			actionDetalhe.setShowDown(false);  
			actionDetalhe.setShowRollOver(false);  
			actionDetalhe.setLayoutAlign(Alignment.CENTER);  
			actionDetalhe.setSrc("actions/ico_mais.gif");  
			actionDetalhe.setPrompt(Tradutor.i18n.formDetalheItem());  
			actionDetalhe.setHeight(16);  
			actionDetalhe.setWidth(16);
			actionDetalhe.addClickHandler(new ClickHandler() {					
				@Override
				public void onClick(ClickEvent event) {
					Record selectRecord = getSelectedRecord();
					if ( selectRecord != null )
						selectRecord(selectRecord, false);
					
					selectRecord(record);
					String codProduto = record.getAttribute(fieldCodProduto.getName());
					painelDetalheItem.showDetalhes(codProduto);
					// onEventSelectFromAction(record, codProduto);
				}
			});
			layout.addMember(actionDetalhe);
			
			if ( isShowKit() ){
				if ( HowMGWTUtilities.isEmpty( record.getAttribute(fieldPossuiKit.getName())) || "0".equals(record.getAttribute(fieldPossuiKit.getName()) )){
					;
				}
				else{
					if ( painelKitProduto == null ){
						painelKitProduto = new ENW0001GPainelKitProduto(corpo, this.canEdit, this.getMoeda());
						painelKitProduto.getPainelListaProduto().setTabPreco(getTabPreco());
						painelKitProduto.setGerenciadorProdutos(getPainelGerenciadorProduto());
					}
					
					ImgButton actionShowKit = new ImgButton();
					actionShowKit.setShowDown(false);  
					actionShowKit.setShowRollOver(false);  
					actionShowKit.setLayoutAlign(Alignment.CENTER);  
					actionShowKit.setSrc("actions/ico_kit.png");  
					actionShowKit.setPrompt(Tradutor.i18n.formPromptVisualizarKit());  
					actionShowKit.setHeight(16);  
					actionShowKit.setWidth(16);
					actionShowKit.addClickHandler(new ClickHandler() {					
						@Override
						public void onClick(ClickEvent event) {
							Record selectRecord = getSelectedRecord();
							
							if ( painelDetalheItem.isVisible() ){
								painelDetalheItem.hide();
							}
							
							String codProduto  = record.getAttribute(fieldCodProduto.getName());
							String descProduto = record.getAttribute(fieldDescricaoComercial.getName()) + 
							"["+record.getAttribute(fieldUnidadeMedida.getName())+"]";
	
							// onEventSelectFromAction(record, codProduto);
							
							painelKitProduto.showKit(PainelListaProduto.this, record, codProduto , descProduto );
						}
					});
					layout.addMember(actionShowKit);			

				}			
			}
			if ( ! HowMGWTUtilities.isEmpty(record.getAttribute(fieldObservacoes.getName()))){
					
				Img actionObservacao = new Img();
				actionObservacao.setShowDown(false);  
				actionObservacao.setShowRollOver(false);  
				actionObservacao.setLayoutAlign(Alignment.CENTER);  
				actionObservacao.setSrc("actions/ico_obs.gif");  
				actionObservacao.setPrompt(record.getAttribute(fieldObservacoes.getName()));  
				actionObservacao.setHeight(16);  
				actionObservacao.setWidth(16);
				layout.addMember(actionObservacao);
			}
			
			return layout;
		}
		else if ( fieldName.equalsIgnoreCase(fieldIconeEstEmpresa.getName())){		
			HLayout layout = new HLayout();
			layout.setWidth100();
			layout.setHeight100();
			ImgButton actionSimulacaoEstoque = new ImgButton();
			actionSimulacaoEstoque.setShowDown(false);  
			actionSimulacaoEstoque.setShowRollOver(false);  
			actionSimulacaoEstoque.setLayoutAlign(Alignment.CENTER);  
			actionSimulacaoEstoque.setSrc("actions/ico_simulacao.gif");  
			actionSimulacaoEstoque.setPrompt(Tradutor.i18n.formPromptSimulacaoEstoque());  
			actionSimulacaoEstoque.setHeight(16);  
			actionSimulacaoEstoque.setWidth(16);
			actionSimulacaoEstoque.addClickHandler(new ClickHandler() {					
				@Override
				public void onClick(ClickEvent event) {
					Record selectRecord = getSelectedRecord();
					if( selectRecord != null )
						selectRecord(selectRecord, false);
					selectRecord(record);
					String codProduto = record.getAttribute(fieldCodProduto.getName());
					// onEventSelectFromAction(record, codProduto);
					
					if ( painelSimulacaoEstoque == null ){
						painelSimulacaoEstoque = new VDD0004PainelSimulacaoEstoque();						
					}
					painelSimulacaoEstoque.showSimulacao(codProduto);
				}
			});
			layout.addMember(actionSimulacaoEstoque);

			ImgButton actionEstoqueEmpresa = new ImgButton();
			actionEstoqueEmpresa.setShowDown(false);  
			actionEstoqueEmpresa.setShowRollOver(false);  
			actionEstoqueEmpresa.setLayoutAlign(Alignment.CENTER);  
			actionEstoqueEmpresa.setSrc("actions/ico_estoque.gif");  
			actionEstoqueEmpresa.setPrompt(Tradutor.i18n.formPromptEstoqueEmpresa());  
			actionEstoqueEmpresa.setHeight(16);  
			actionEstoqueEmpresa.setWidth(16);
			actionEstoqueEmpresa.addClickHandler(new ClickHandler() {					
				@Override
				public void onClick(ClickEvent event) {
					Record selectRecord = getSelectedRecord();
					if ( selectRecord != null )
						selectRecord(selectRecord, false);
					selectRecord(record);
					String codProduto = record.getAttribute(fieldCodProduto.getName());
					// onEventSelectFromAction(record, codProduto);
					
					if ( painelEstoqueEmpresa == null )
						painelEstoqueEmpresa = new VDD0005PainelEstoquePorEmpresa();
					painelEstoqueEmpresa.showEstoque(codProduto);
				}
			});
			layout.addMember(actionEstoqueEmpresa);		
			
			return layout;
		}		

		
		else if ( fieldName.equalsIgnoreCase(fieldIconePrecoDif.getName())){		
			if( this.isShopping() ){
				if ( record.getAttribute("revoke") != null && record.getAttributeAsBoolean("revoke") )
					return super.createRecordComponent(record, colNum);
			}
			
			HLayout layout = new HLayout();
			layout.setWidth100();
			layout.setHeight100();

			ImgButton actionSelecionar = new ImgButton();
			actionSelecionar.setShowDown(false);  
			actionSelecionar.setShowRollOver(false);  
			actionSelecionar.setLayoutAlign(Alignment.CENTER);  
			if( this.isShopping() ){
				actionSelecionar.setSrc("actions/remove.png");  
				actionSelecionar.setPrompt(Tradutor.i18n.formPromptRemoverItem());
			}
			else{
				actionSelecionar.setSrc("actions/ico_editar.gif");  
				actionSelecionar.setPrompt(Tradutor.i18n.formPromptSelecionarItem());
			}
			actionSelecionar.setHeight(16);  
			actionSelecionar.setWidth(16);
			actionSelecionar.addClickHandler(new ClickHandler() {					
				@Override
				public void onClick(ClickEvent event) {
					lastSelectRecord = getSelectedRecord();
					if ( lookup ){
						selectRecordAndClose(record, OPCAO_ACAO_LOOKUP);
					}
					else if( isShopping() )
						onDeleteRecord(record);
					else
						selectRecordAndClose(record, OPCAO_ACAO);
				}
			});
			layout.addMember(actionSelecionar);			
						
			return layout;
		}

		else
			return super.createRecordComponent(record, colNum);
	}
	
//	/**
//	 * Evento para interceptar a seleção do registro a partir de uma ação causada por botão.
//	 * @param Record
//	 * @param codProduto
//	 */
//	public void onEventSelectFromAction(Record Record, String codProduto){		
//	}
	
	public void onEventSelectEditRecord(Record record, String codProduto, int opcao){	
	}

	/**
	 * @return the tabPreco
	 */
	public String getTabPreco() {
		return tabPreco;
	}

	/**
	 * @param tabPreco the tabPreco to set
	 */
	public void setTabPreco(String tabPreco) {
		this.tabPreco = tabPreco;
	}

	/**
	 * @return the showKit
	 */
	public boolean isShowKit() {
		return showKit;
	}

	/**
	 * @param showKit the showKit to set
	 */
	public void setShowKit(boolean showKit) {
		this.showKit = showKit;
	}

	/**
	 * @return the painelGerenciadorProduto
	 */
	public PainelGerenciadorProdutos getPainelGerenciadorProduto() {
		return painelGerenciadorProduto;
	}

	/**
	 * @param painelGerenciadorProduto the painelGerenciadorProduto to set
	 */
	public void setPainelGerenciadorProduto(
			PainelGerenciadorProdutos painelGerenciadorProduto) {
		this.painelGerenciadorProduto = painelGerenciadorProduto;
	}

	/**
	 * @return the painelDetalheItem
	 */
	public VDD0011PainelDetalheItem getPainelDetalheItem() {
		return painelDetalheItem;
	}

	/**
	 * @param painelDetalheItem the painelDetalheItem to set
	 */
	public void setPainelDetalheItem(VDD0011PainelDetalheItem painelDetalheItem) {
		this.painelDetalheItem = painelDetalheItem;
	}

	/**
	 * @return the painelKitProduto
	 */
	public ENW0001GPainelKitProduto getPainelKitProduto() {
		return painelKitProduto;
	}

	/**
	 * @param painelKitProduto the painelKitProduto to set
	 */
	public void setPainelKitProduto(ENW0001GPainelKitProduto painelKitProduto) {
		this.painelKitProduto = painelKitProduto;
	}	
	
	/**
	 * Seleciona o registro atual, seta os dados no pedido e fecha a tela de 
	 * busca.
	 * @param record
	 */
	public void selectRecordAndClose(Record record, int opcao){		
//		// ------------------------------------------------------------------------------------
//		// Permitir selecionar o registro sem fechar a janela.
//		// Analisar forma de fazer isto.
//		// Confirma registro na tela de pedido e pula para o próximo registro o focu.
//		// ------------------------------------------------------------------------------------		
//		if ( painelDetalheItem.isVisible() ){
//			painelDetalheItem.hide();
//		}
//		
//		if ( painelKitProduto != null && painelKitProduto.isVisible() ){
//			painelKitProduto.hide();
//		}
//				
		selectRecord(record);
		String codProduto  = record.getAttribute(fieldCodProduto.getName());
		onEventSelectEditRecord(record, codProduto, opcao);
	}

	/**
	 * @return the detailListaProduto
	 */
	public boolean isDetailListaProduto() {
		return detailListaProduto;
	}

	/**
	 * @param detailListaProduto the detailListaProduto to set
	 */
	public void setDetailListaProduto(boolean detailListaProduto) {
		this.detailListaProduto = detailListaProduto;
	}
	
	public ListGridRecord copy(ListGridRecord record){
		HowMGWTDataRecord copyRecord = new HowMGWTDataRecord();
		
		for ( ListGridField field : this.getHeaderFields() ){
			
			ListGridFieldType fieldType = field.getType();
			
	 		if ( fieldType != null ){
	 			
				if ( ListGridFieldType.FLOAT.equals( fieldType ) ){
					copyRecord.setAttribute(field.getName(), record.getAttributeAsDouble(field.getName()));					
				}
				else if ( ListGridFieldType.INTEGER.equals( fieldType ) ){
					copyRecord.setAttribute(field.getName(), record.getAttributeAsInt(field.getName()));					
				}
				else if ( ListGridFieldType.DATE.equals(fieldType)){
					copyRecord.setAttribute(field.getName(), record.getAttributeAsDate(field.getName()));
				}
				else if ( ListGridFieldType.BOOLEAN.equals( fieldType ) ){
					copyRecord.setAttribute(field.getName(), record.getAttributeAsBoolean(field.getName()));
				}
				else{
					copyRecord.setAttribute(field.getName(), record.getAttributeAsString(field.getName()));
				}
			}
	       	else{
				copyRecord.setAttribute(field.getName(), record.getAttributeAsString(field.getName()));
	       	} 		
			
		}
		return copyRecord;
	}

	/**
	 * @return the shopping
	 */
	public boolean isShopping() {
		return shopping;
	}

	/**
	 * @param shopping the shopping to set
	 */
	public void setShopping(boolean shopping) {
		this.shopping = shopping;
	}
	
	public void onDeleteRecord(ListGridRecord record){}

	/**
	 * @return the moeda
	 */
	public String getMoeda() {
		return moeda;
	}

	/**
	 * @param moeda the moeda to sethttp
	 */
	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}


	/**
	 * Converte o preco de lista para a moeda definida no pedido ou 
	 * na consulta.
	 */
	@Override
	public void onHowMLoadDatabaseRecord(Record record) {
		converteMoeda(record, this.fieldPrecoLista, this.moeda);
	}
	
	
	public static void converteMoeda(Record record, ListGridField field, String moeda){

		if ( HowMGWTUtilities.isEmpty( moeda) ){
			moeda = "R$";
		}
		
		Double precoLista = record.getAttributeAsDouble(field.getName());
		Double cotacao    = eModuloVDQ0002.getMAPCotacoes().get(moeda);
					
		if ( cotacao != null && precoLista != null ){
			Double precoMoeda = precoLista.doubleValue() / cotacao.doubleValue();

        	String sPrecoMoeda = NumberFormat.getFormat(HowMGWTUtilities.getMask(eModuloVDQ0002.PARAM_qtdCasasDecimaisPrecoUnitProduto)).format(precoMoeda);
	
			record.setAttribute(field.getName(),HowMGWTUtilities.getDouble(sPrecoMoeda));
		}	
	}
}