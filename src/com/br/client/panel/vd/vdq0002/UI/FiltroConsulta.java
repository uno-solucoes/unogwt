package com.br.client.panel.vd.vdq0002.UI;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.vd.entity.eModuloVDQ0002;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.howmake.client.form.UI.HowMGWTCheckboxItem;
import com.howmake.client.form.UI.HowMGWTLabel;
import com.howmake.client.form.UI.HowMGWTSelectItem;
import com.howmake.client.form.UI.HowMGWTTextItem;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HOWMGWTDataSourceQuery;
import com.howmake.client.form.model.HowMGWTDataRecord;
import com.howmake.client.form.partner.HowMGWTProperty;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.PickerIcon;
import com.smartgwt.client.widgets.form.fields.events.BlurEvent;
import com.smartgwt.client.widgets.form.fields.events.BlurHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemClickHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyDownEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyDownHandler;
import com.smartgwt.client.widgets.form.fields.events.KeyPressEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyPressHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class FiltroConsulta extends VLayout{ 

	private boolean inFocusProduto;
	private boolean inFocusQuantidade;
	private boolean inFocusPrecoVenda;
	private boolean inProcess = false;
	
	private String novo = "<B>Incluir</B>";
	private String editar = "<font color=red><B>Editar</B></font>";
	
	private HowMGWTDataRecord currentRecord;
	private com.smartgwt.client.widgets.menu.events.ClickHandler clickHandler = new com.smartgwt.client.widgets.menu.events.ClickHandler() {			
			public void onClick(MenuItemClickEvent event) {
				propertyBusca.getHowMGWTEditorFieldText().setHowMValue(event.getItem().getTitle());
				configureFiltro();
				findLocal();
			}
	 }; 
	
	private Menu menuSuggestList;
	
	private PickerIcon actionPrefrencias;
	private IButton actionShopping;
	private FiltroConsultaPreferencias preferencias;
	
	public static final int BUSCA_MULTIPLA_COD_PRODUTO = 0;
	public static final int BUSCA_MULTIPLA_DESC_ABREV  = 1;
	public static final int BUSCA_MULTIPLA 			   = 2;

	private boolean buscaAproximada = true;
	private int buscaMultipla		= BUSCA_MULTIPLA;
	
	private VDD0006PainelGruposProduto painelGruposProduto = new VDD0006PainelGruposProduto();
	
	private PainelGerenciador painelGerenciador;

	private HowMGWTProperty propertyCodigoProduto 		= new HowMGWTProperty("codigoProduto", Tradutor.i18n.formProduto());
	private HowMGWTSelectItem fieldMarca       			= new HowMGWTSelectItem("Marca", Tradutor.i18n.formMarca());
	private HowMGWTSelectItem fieldFamilia     			= new HowMGWTSelectItem("Familia", Tradutor.i18n.formFamilia());
	private HowMGWTCheckboxItem fieldSomenteEst			= new HowMGWTCheckboxItem("somenteEstoque", Tradutor.i18n.formListaSomenteProdutosComEstoque());
	// private HowMGWTProperty propertyAtendimento;
	
	// private HowMGWTProperty propertyBuscaPor;
	private HowMGWTProperty propertyQuantidade;
	private HowMGWTProperty propertyPrecoVenda;
	private HowMGWTProperty propertyBusca 				= new HowMGWTProperty("busca", "");
	
	private HowMGWTLabel label0002;
	
	// ----------------------------------------------------------------------------------

	private HowMGWTTextItem fieldCodigoProdutoFornecedor = new HowMGWTTextItem("codigoProduto", "Cod Produto Fornecedor");
	private IButton selecionarGrupo = new IButton(Tradutor.i18n.formSelecionarGrupoProduto());  

	
	// ----------------------------------------------------------------------------------
	private HowMGWTTextItem fieldDescricaoAbreviada = new HowMGWTTextItem("descricaoAbreviada", Tradutor.i18n.formDescricaoAbreviada());
	private HowMGWTTextItem fieldApelido 			= new HowMGWTTextItem("apelido", "Apelido");
	private HowMGWTTextItem fieldDescricaoTecnica 	= new HowMGWTTextItem("descricaoTecnica", Tradutor.i18n.formDescricaoTecnica());
	
	private String codFonecedor = null;
	
	private HTMLPane tabelaPrecoPedido = new HTMLPane();
	private boolean canEdit = true;
	private boolean menu    = true;
	private String corpo = null;
	
	public FiltroConsulta(String corpo, boolean menu, boolean canEdit, boolean lookup){
		this.corpo   = corpo;
		this.menu    = menu;
		this.canEdit = canEdit;
		
		if ( this.canEdit )
			this.setHeight("116px");
		else
			this.setHeight("136px");
		
		// ----------------------------------------------------------------------------------
		propertyCodigoProduto.createHowMGWTFormFieldTextItem();			

		
		fieldMarca.setWidth("300px");

		fieldFamilia.setWidth("200px");
		fieldSomenteEst.setWidth("200px");		
		
		// ----------------------------------------------------------------------------------
		HLayout outrasInformacoes = new HLayout();
		outrasInformacoes.setWidth100();
		outrasInformacoes.setHeight(26);

		fieldCodigoProdutoFornecedor.setWidth("260px");
  			
		selecionarGrupo.setWidth(190);  
		selecionarGrupo.setShowRollOver(true);  
		selecionarGrupo.setShowDisabled(true);
		selecionarGrupo.setShowDisabledIcon(true);
		selecionarGrupo.setShowDown(true);  
		selecionarGrupo.setIcon("[SKINIMG]/headerIcons/arrow_down_Over.png");  
		
		selecionarGrupo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if ( painelGruposProduto.isVisible() )
					painelGruposProduto.hide();
				else{
					painelGruposProduto.setLeft(selecionarGrupo.getAbsoluteLeft());
					painelGruposProduto.setTop(selecionarGrupo.getAbsoluteTop()+selecionarGrupo.getHeight());
					painelGruposProduto.showGrupoVendas();
				}
			}
		});
		
		
		
    	ToolStrip toolbar = new ToolStrip();
    	toolbar.setWidth100();
    	toolbar.setHeight(26);
 
    	
    	if ( this.canEdit ){
        	tabelaPrecoPedido.setWidth("300px");
	    	tabelaPrecoPedido.setBackgroundColor(Tradutor.i18n.msgColor());
	    	tabelaPrecoPedido.setBorder(Tradutor.i18n.msgBorder());   
	    	tabelaPrecoPedido.setContents("<B>"+Tradutor.i18n.formTabelaPrecoPedido()+"</B>");
		}
    	else
        	tabelaPrecoPedido.setWidth("245px");

    	toolbar.addMember(tabelaPrecoPedido);
    	
        HTMLPane pane = new HTMLPane();
    	pane.setWidth("310px");
    	
    	toolbar.addMember(pane);
    	
    	KeyPressHandler keyPressHandler = new KeyPressHandler() {
			
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if ( event != null && event.getCharacterValue() != null ){
					if ( event.getCharacterValue() == 13 ){
						getPainelGerenciador().getRelacaoGerenciadorProduto().getToolbarNavegatorListaProdutos().startBuscar();
					}
				}
			}
		};
 
		
		fieldApelido.getField().addKeyPressHandler(keyPressHandler);
		fieldCodigoProdutoFornecedor.getField().addKeyPressHandler(keyPressHandler);
		fieldDescricaoAbreviada.getField().addKeyPressHandler(keyPressHandler);
		fieldDescricaoTecnica.getField().addKeyPressHandler(keyPressHandler);

		
		
		//----------------------------------------------------------------------------------------
		// Corpo Morelate.
		// ---------------------------------------------------------------------------------------
		if ( "0002".equals(corpo)){
			HLayout dadosProduto = new HLayout();
			dadosProduto.setWidth100();
			dadosProduto.setHeight(26);

//			propertyAtendimento  = new HowMGWTProperty("atendimento", "Atendimento");
//			propertyAtendimento.setBound(15, 100);
//			propertyAtendimento.createHowMGWTCheckboxItem();
//			propertyAtendimento.getHowMGWTCheckboxItem().addClickHandler(new ClickHandler() {
//				
//				@Override
//				public void onClick(ClickEvent event) {
//					onConfigureAtendimento();
//				}
//			});
			            
			propertyBusca.setBound(100, 130);
			propertyBusca.createHowMGWTFormFieldTextItem();
	    	
			propertyBusca.getHowMGWTEditorFieldText().getField().addChangedHandler(new ChangedHandler() {
				
				@Override
				public void onChanged(ChangedEvent event) {
					if ( ! FiltroConsulta.this.menu ){
						label0002.setContents(novo);
						propertyQuantidade.getHowMGWTEditorFieldText().setHowMValue("");
						propertyPrecoVenda.getHowMGWTEditorFieldText().setHowMValue("");
					}
					inProcess 		  = false;
					inFocusPrecoVenda = false;
					inFocusProduto    = true;
					inFocusQuantidade = false;					
				}
			});
			
			KeyPressHandler keyPressHandlerBusca = new KeyPressHandler() {
				
				@Override
				public void onKeyPress(KeyPressEvent event) {
					if ( event != null && event.getCharacterValue() != null ){
						if ( event.getCharacterValue() == 13 ){
							inProcess = false;
							configureFiltro();
							if( ! findLocal() )
								getPainelGerenciador().getRelacaoGerenciadorProduto().getToolbarNavegatorListaProdutos().startBuscar();
						}
					}
				}
			};			
			propertyBusca.getHowMGWTEditorFieldText().getField().addKeyPressHandler(keyPressHandlerBusca);

			
			dadosProduto.addMember( propertyBusca.getCanvas() );
 
			
			if ( this.menu ){
				
			}
			else{
				propertyQuantidade	= new HowMGWTProperty("quantidade",Tradutor.i18n.formQtde());
				propertyQuantidade.setBound(45, 60);
				propertyQuantidade.createHowMGWTFormFieldTextItem();
				propertyQuantidade.getHowMGWTEditorFieldText().getField().setAlign(Alignment.RIGHT);
				propertyQuantidade.configureInputInteger(propertyQuantidade.getHowMGWTEditorFieldText().getField());
				dadosProduto.addMember(propertyQuantidade.getCanvas());
				
				propertyPrecoVenda  = new HowMGWTProperty("precoVenda", Tradutor.i18n.formPrecoVenda());
				propertyPrecoVenda.setBound(90, 80);
				propertyPrecoVenda.createHowMGWTFormFieldTextItem();
				propertyPrecoVenda.configureInputDecimal(propertyPrecoVenda.getHowMGWTEditorFieldText().getField(),HowMGWTUtilities.getMask(eModuloVDQ0002.PARAM_qtdCasasDecimaisPrecoUnitProduto));
				dadosProduto.addMember(propertyPrecoVenda.getCanvas());

				VLayout vLabel = new VLayout();
				vLabel.setWidth(60);
				vLabel.setOverflow(Overflow.HIDDEN);
				vLabel.setHeight(22);
				vLabel.setAlign(VerticalAlignment.CENTER);
				label0002 = new HowMGWTLabel();
				label0002.setContents(novo);
				label0002.setWidth(60);
				label0002.setHeight(12);
				label0002.setOverflow(Overflow.HIDDEN);
				label0002.setAlign(Alignment.CENTER);
				vLabel.addMember(label0002);
				dadosProduto.addMember(vLabel);
				
				label0002.setVisible(true);
				getPropertyQuantidade().getHowMGWTEditorFieldText().setVisible(true);
				getPropertyPrecoVenda().getHowMGWTEditorFieldText().setVisible(true);	
				
				
				propertyQuantidade.getHowMGWTEditorFieldText().getField().addBlurHandler(new BlurHandler() {					
					@Override
					public void onBlur(BlurEvent event) {
						inFocusPrecoVenda = false;
						inFocusProduto    = false;
						inFocusQuantidade = true;
					}
				});
				
				propertyPrecoVenda.getHowMGWTEditorFieldText().getField().addBlurHandler(new BlurHandler() {					
					@Override
					public void onBlur(BlurEvent event) {
						inFocusPrecoVenda = true;
						inFocusProduto    = false;
						inFocusQuantidade = false;
					}
				});
				
				propertyBusca.getHowMGWTEditorFieldText().getField().addBlurHandler(new BlurHandler() {					
					@Override
					public void onBlur(BlurEvent event) {
						inFocusPrecoVenda = false;
						inFocusProduto    = true;
						inFocusQuantidade = false;
					}
				});
			}			
			
			
			
//			dadosProduto.addMember( propertyAtendimento.getCanvas() );

//			propertyBuscaPor = new HowMGWTProperty("bucarPor", "Busca por");
//			propertyBuscaPor.setBound(80, 150);
//			propertyBuscaPor.createHowMGWTFormFieldSelectItem();
//			dadosProduto.addMember(propertyBuscaPor.getCanvas());
			
			LinkedHashMap<String, String> mapCampos = new LinkedHashMap<String, String>();
			mapCampos.put("cod_produto", "Produto");
			mapCampos.put("cod_Produto_Fornecedor","Cod Produto Fornecedor");
			mapCampos.put("desc_abreviada",Tradutor.i18n.formDescricaoAbreviada());
			mapCampos.put("apedido",Tradutor.i18n.formApelido());
			mapCampos.put("desc_tecnica",Tradutor.i18n.formDescricaoTecnica());
			propertyBusca.getHowMGWTEditorFieldText().getField().setTitle(Tradutor.i18n.formProduto());
			propertyBusca.getHowMGWTEditorFieldText().redraw();
 
			
			actionPrefrencias = new PickerIcon(new PickerIcon.Picker("actions/configure.png"), new FormItemClickHandler(){  
	            public void onFormItemClick(FormItemIconClickEvent event) {  
	            	if ( preferencias == null )
	            		preferencias = new FiltroConsultaPreferencias();
	            	preferencias.showPreferencias(buscaAproximada, buscaMultipla, FiltroConsulta.this);
	            }  
	        });
			actionPrefrencias.setPrompt(Tradutor.i18n.formConfiguracaoPreferenciasDeBusca());
			propertyBusca.getHowMGWTEditorFieldText().getField().setIcons(actionPrefrencias);

			propertyBusca.getHowMGWTEditorFieldText().getField().addKeyDownHandler(new KeyDownHandler() {
				
				@Override
				public void onKeyDown(KeyDownEvent event) {
					if ( event != null && event.getKeyName() != null && event.getKeyName().equals("Arrow_Down")){
						if ( !HowMGWTUtilities.isEmpty(propertyBusca.getHowMGWTEditorFieldText().getHowMValue()) ){
							if ( propertyBusca.getHowMGWTEditorFieldText().getHowMValue().toString().length() >= 2){
								inProcess = false;
								getSuggestList();
							}
						}
					}
				}
			});

			
			dadosProduto.addMember( fieldSomenteEst );
		
			this.addMember(dadosProduto);

//			propertyAtendimento.getHowMGWTCheckboxItem().getField().setValue(Boolean.TRUE);
 
			
			KeyPressHandler keyPressHandlerQtde = new KeyPressHandler() {			
				@Override
				public void onKeyPress(KeyPressEvent event) {
					if ( event.getCharacterValue() == null )
						return;					
					if ( event.getCharacterValue() == 13){ // Enter	
						if ( ! HowMGWTUtilities.isEmpty(propertyBusca.getHowMGWTEditorFieldText().getHowMValue()) ){						
							if( FiltroConsulta.this.menu ){
								
							}
							else{
								double qtde = HowMGWTUtilities.getDouble(propertyQuantidade.getHowMGWTEditorFieldText().getHowMValue());
								if ( qtde > 0 ){

									if ( inProcess ){
										event.cancel();
										return;
									}
									
									inProcess = true;
									HowMGWTWindowWait.showWait();
									getPainelGerenciador().setCallFields(currentRecord, propertyBusca.getHowMGWTEditorFieldText().getHowMValue().toString(), PainelListaProduto.OPCAO_ALTERACAO_QTDE);									
								}
								else{
									SC.say("Quantidade deve ser maior que zero!");
								}
							}
						}
					}
				}
			};
			if ( !menu ){
				propertyQuantidade.getHowMGWTEditorFieldText().getField().addKeyPressHandler(keyPressHandlerQtde);
				KeyPressHandler keyPressHandlerPreco = new KeyPressHandler() {			
					@Override
					public void onKeyPress(KeyPressEvent event) {
						if ( event.getCharacterValue() == null )
							return;					
						if ( event.getCharacterValue() == 13){ // Enter	
							if ( ! HowMGWTUtilities.isEmpty(propertyBusca.getHowMGWTEditorFieldText().getHowMValue()) ){
								double precoUnitario = HowMGWTUtilities.getDouble(propertyPrecoVenda.getHowMGWTEditorFieldText().getHowMValue());
								if ( precoUnitario > 0 ){
									if ( inProcess ){
										event.cancel();
										return;
									}
									
									inProcess = true;

									HowMGWTWindowWait.showWait();
									getPainelGerenciador().setCallFields(currentRecord, propertyBusca.getHowMGWTEditorFieldText().getHowMValue().toString(), PainelListaProduto.OPCAO_ALTERACAO_PRECO);
								}
								else{
									SC.say(Tradutor.i18n.formPrecoVenda()+" deve ser maior que zero!");
								}
							}
						}
					}
				};
				propertyPrecoVenda.getHowMGWTEditorFieldText().getField().addKeyPressHandler(keyPressHandlerPreco);
			}		
		}
		else{
			HLayout dadosProduto = new HLayout();
			dadosProduto.setWidth100();
			dadosProduto.setHeight(26);
			
			propertyCodigoProduto.getHowMGWTEditorFieldText().getField().addKeyPressHandler(keyPressHandler);
			propertyCodigoProduto.getHowMGWTEditorFieldText().setWidth("260px");

			dadosProduto.addMember(propertyCodigoProduto.getCanvas());
			dadosProduto.addMember(fieldMarca);
			dadosProduto.addMember(fieldFamilia);
			if ( this.canEdit )
				dadosProduto.addMember(fieldSomenteEst);

			actionPrefrencias = new PickerIcon(new PickerIcon.Picker("actions/configure.png"), new FormItemClickHandler(){  
	            public void onFormItemClick(FormItemIconClickEvent event) {  
	            	if ( preferencias == null )
	            		preferencias = new FiltroConsultaPreferencias();
	            	preferencias.showPreferencias(buscaAproximada, buscaMultipla, FiltroConsulta.this);
	            }  
	        });
			actionPrefrencias.setPrompt(Tradutor.i18n.formConfiguracaoPreferenciasDeBusca());
			propertyCodigoProduto.getHowMGWTEditorFieldText().getField().setIcons(actionPrefrencias);
				
			this.addMember(dadosProduto);
		}
		outrasInformacoes.addMember(fieldCodigoProdutoFornecedor);		

		HLayout space = new HLayout();
		space.setWidth("60px");
		outrasInformacoes.addMember(space);
		outrasInformacoes.addMember(selecionarGrupo);

		// ----------------------------------------------------------------------------------
		HLayout dadosGeraisProduto = new HLayout();
		dadosGeraisProduto.setWidth100();
		dadosGeraisProduto.setHeight(26);

		fieldDescricaoAbreviada.setWidth("310px");
		fieldDescricaoTecnica.setWidth("260px");
		fieldApelido.setWidth("200px");

		dadosGeraisProduto.addMember(fieldDescricaoAbreviada);
		dadosGeraisProduto.addMember(fieldApelido);
		dadosGeraisProduto.addMember(fieldDescricaoTecnica);

		this.addMember(outrasInformacoes);		
		this.addMember(dadosGeraisProduto);		
	
		if ( ! this.canEdit ){
			fieldSomenteEst.setHowMBound(200, 100);
			this.addMember(fieldSomenteEst);
		}



		
		if ( ! menu && ! lookup ){
		    actionShopping = new IButton(Tradutor.i18n.formCarrinho());
		    actionShopping.setWidth(100);
		    actionShopping.setIcon("actions/shopping.png"); 
		    actionShopping.addClickHandler(new ClickHandler() { 
	            public void onClick(ClickEvent event) {
	            	if( "0002".equals(FiltroConsulta.this.corpo)){
	            		getPainelGerenciador().getTabSet().selectTab(1);
	            	}
	            	else{
	            		painelGerenciador.showPainelShopping();
	            	}
	            }
	        });		
			toolbar.addMember(actionShopping);
		}
			
		IButton actionLimpar   = new IButton("Limpar");
		actionLimpar.setWidth(100);
		actionLimpar.setIcon("actions/clear.png"); 
		actionLimpar.addClickHandler(new ClickHandler() { 
            public void onClick(ClickEvent event) {            
            	limparFiltros();
            	if( "0002".equals(FiltroConsulta.this.corpo))
            		propertyBusca.getHowMGWTEditorFieldText().getField().focusInItem();
            	else
            		propertyCodigoProduto.getHowMGWTEditorFieldText().getField().focusInItem();
            }
        });	

		
		
		
		toolbar.addMember(actionLimpar);
				
		IButton actionBuscar   = new IButton(Tradutor.i18n.buscar());
		actionBuscar.setWidth(100);
		actionBuscar.setIcon("actions/search.png"); 
	    actionBuscar.addClickHandler(new ClickHandler() { 
            public void onClick(ClickEvent event) {            
            	configureFiltro();
            	onExecuteQuery();
            }
        });		
		
		toolbar.addMember(actionBuscar);

    	this.addMember(toolbar);
    
    	// Carrega as listas de dados.
    	
    	HOWMGWTDataSourceQuery.executeQueryPopulate("select cod_marca, desc_abrev from cd_marca order by desc_abrev", this.getFieldMarca().getField(), false);
    	HOWMGWTDataSourceQuery.executeQueryPopulate("select cod_familia_comercial, desc_abrev from cd_familia_comercial order by desc_abrev", this.getFieldFamilia().getField() , false);
	}

	
	/**
	 * Configura o filtro para busca dos dados.
	 */
	public void configureFiltro(){

		if( "0002".equals(this.corpo)){

			this.propertyCodigoProduto.getHowMGWTEditorFieldText().setHowMValue("");
			this.fieldCodigoProdutoFornecedor.setHowMValue("");
			this.fieldDescricaoAbreviada.setHowMValue("");
			this.fieldApelido.setHowMValue("");
			this.fieldDescricaoTecnica.setHowMValue("");

//			if ( "cod_produto".equals( propertyBuscaPor.getHowMGWTEditorSelectItem().getHowMValue() ) )
				this.propertyCodigoProduto.getHowMGWTEditorFieldText().setHowMValue(this.propertyBusca.getHowMGWTEditorFieldText().getHowMValue());
//			else if ( "cod_Produto_Fornecedor".equals( propertyBuscaPor.getHowMGWTEditorSelectItem().getHowMValue() ) )
//				this.fieldCodigoProdutoFornecedor.setHowMValue(this.propertyBusca.getHowMGWTEditorFieldText().getHowMValue());
//			else if ( "desc_abreviada".equals( propertyBuscaPor.getHowMGWTEditorSelectItem().getHowMValue() ) )
//				this.fieldDescricaoAbreviada.setHowMValue(this.propertyBusca.getHowMGWTEditorFieldText().getHowMValue());
//			else if ( "apedido".equals( propertyBuscaPor.getHowMGWTEditorSelectItem().getHowMValue() ) )
//				this.fieldApelido.setHowMValue(this.propertyBusca.getHowMGWTEditorFieldText().getHowMValue());
//			else if ( "desc_tecnica".equals( propertyBuscaPor.getHowMGWTEditorSelectItem().getHowMValue() ) )
//				this.fieldDescricaoTecnica.setHowMValue(this.propertyBusca.getHowMGWTEditorFieldText().getHowMValue());			
		}
	}


	/**
	 * @return the fieldCodigoProduto
	 */
	public HowMGWTTextItem getFieldCodigoProduto() {
		return propertyCodigoProduto.getHowMGWTEditorFieldText();
	}


 



	/**
	 * @return the fieldMarca
	 */
	public HowMGWTSelectItem getFieldMarca() {
		return fieldMarca;
	}



	/**
	 * @param fieldMarca the fieldMarca to set
	 */
	public void setFieldMarca(HowMGWTSelectItem fieldMarca) {
		this.fieldMarca = fieldMarca;
	}



	/**
	 * @return the fieldFamilia
	 */
	public HowMGWTSelectItem getFieldFamilia() {
		return fieldFamilia;
	}



	/**
	 * @param fieldFamilia the fieldFamilia to set
	 */
	public void setFieldFamilia(HowMGWTSelectItem fieldFamilia) {
		this.fieldFamilia = fieldFamilia;
	}



	/**
	 * @return the fieldSomenteEst
	 */
	public HowMGWTCheckboxItem getFieldSomenteEst() {
		return fieldSomenteEst;
	}



	/**
	 * @param fieldSomenteEst the fieldSomenteEst to set
	 */
	public void setFieldSomenteEst(HowMGWTCheckboxItem fieldSomenteEst) {
		this.fieldSomenteEst = fieldSomenteEst;
	}



	/**
	 * @return the fieldCodigoProdutoFornecedor
	 */
	public HowMGWTTextItem getFieldCodigoProdutoFornecedor() {
		return fieldCodigoProdutoFornecedor;
	}



	/**
	 * @param fieldCodigoProdutoFornecedor the fieldCodigoProdutoFornecedor to set
	 */
	public void setFieldCodigoProdutoFornecedor(
			HowMGWTTextItem fieldCodigoProdutoFornecedor) {
		this.fieldCodigoProdutoFornecedor = fieldCodigoProdutoFornecedor;
	}

	/**
	 * @return the fieldDescricaoAbreviada
	 */
	public HowMGWTTextItem getFieldDescricaoAbreviada() {
		return fieldDescricaoAbreviada;
	}



	/**
	 * @param fieldDescricaoAbreviada the fieldDescricaoAbreviada to set
	 */
	public void setFieldDescricaoAbreviada(HowMGWTTextItem fieldDescricaoAbreviada) {
		this.fieldDescricaoAbreviada = fieldDescricaoAbreviada;
	}



	/**
	 * @return the fieldApelido
	 */
	public HowMGWTTextItem getFieldApelido() {
		return fieldApelido;
	}



	/**
	 * @param fieldApelido the fieldApelido to set
	 */
	public void setFieldApelido(HowMGWTTextItem fieldApelido) {
		this.fieldApelido = fieldApelido;
	}



	/**
	 * @return the fieldDescricaoTecnica
	 */
	public HowMGWTTextItem getFieldDescricaoTecnica() {
		return fieldDescricaoTecnica;
	}



	/**
	 * @param fieldDescricaoTecnica the fieldDescricaoTecnica to set
	 */
	public void setFieldDescricaoTecnica(HowMGWTTextItem fieldDescricaoTecnica) {
		this.fieldDescricaoTecnica = fieldDescricaoTecnica;
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
	
	
	public void limparFiltros(){
		
		propertyCodigoProduto.getHowMGWTEditorFieldText().setHowMValue("");
		fieldMarca.setHowMValue("");
		fieldFamilia.setHowMValue("");
		fieldSomenteEst.getField().setValue(false);
		if ( "0002".equals(this.corpo)){
			if ( this.propertyBusca != null && this.propertyBusca.getHowMGWTEditorFieldText() != null ){
				if ( this.menu )
					this.propertyBusca.getHowMGWTEditorFieldText().setHowMValue("");
				else{
					label0002.setContents(novo);
					this.propertyBusca.getHowMGWTEditorFieldText().setHowMValue("");
					this.propertyQuantidade.getHowMGWTEditorFieldText().setHowMValue("");
					this.propertyPrecoVenda.getHowMGWTEditorFieldText().setHowMValue("");
				}
			}
		}		
		// ----------------------------------------------------------------------------------

		fieldCodigoProdutoFornecedor.setHowMValue("");	
		painelGruposProduto.clearSelectGrupos();
		// ----------------------------------------------------------------------------------
		fieldDescricaoAbreviada.setHowMValue("");
		fieldApelido.setHowMValue("");
		fieldDescricaoTecnica.setHowMValue("");
		
		this.painelGruposProduto.clearSelectGrupos();
		
		if ( getPainelGerenciador() != null )
			getPainelGerenciador().clearAllScreen();
		
		if ( label0002 != null )
			label0002.setContents(novo);

	}



	/**
	 * @return the tabelaPrecoPedido
	 */
	public HTMLPane getTabelaPrecoPedido() {
		return tabelaPrecoPedido;
	}



	/**
	 * @param tabelaPrecoPedido the tabelaPrecoPedido to set
	 */
	public void setTabelaPrecoPedido(HTMLPane tabelaPrecoPedido) {
		this.tabelaPrecoPedido = tabelaPrecoPedido;
	}



	/**
	 * @return the painelGruposProduto
	 */
	public VDD0006PainelGruposProduto getPainelGruposProduto() {
		return painelGruposProduto;
	}



	/**
	 * @param painelGruposProduto the painelGruposProduto to set
	 */
	public void setPainelGruposProduto(
			VDD0006PainelGruposProduto painelGruposProduto) {
		this.painelGruposProduto = painelGruposProduto;
	}



	/**
	 * @return the buscaAproximada
	 */
	public boolean isBuscaAproximada() {
		return buscaAproximada;
	}



	/**
	 * @param buscaAproximada the buscaAproximada to set
	 */
	public void setBuscaAproximada(boolean buscaAproximada) {
		this.buscaAproximada = buscaAproximada;
	}



	/**
	 * @return the buscaMultipla
	 */
	public int getBuscaMultipla() {
		return buscaMultipla;
	}



	/**
	 * @param buscaMultipla the buscaMultipla to set
	 */
	public void setBuscaMultipla(int buscaMultipla) {
		this.buscaMultipla = buscaMultipla;
	}



	/**
	 * @return the actionShopping
	 */
	public IButton getActionShopping() {
		return actionShopping;
	}



	/**
	 * @param actionShopping the actionShopping to set
	 */
	public void setActionShopping(IButton actionShopping) {
		this.actionShopping = actionShopping;
	}
	
	public void onExecuteQuery(){
		if ( this.getPainelGerenciador() != null )
			getPainelGerenciador().getRelacaoGerenciadorProduto().getToolbarNavegatorListaProdutos().startBuscar();	
	}



	/**
	 * @return the codFonecedor
	 */
	public String getCodFonecedor() {
		return codFonecedor;
	}



	/**
	 * @param codFonecedor the codFonecedor to set
	 */
	public void setCodFonecedor(String codFonecedor) {
		this.codFonecedor = codFonecedor;
	}


	/**
	 * @return the propertyBusca
	 */
	public HowMGWTProperty getPropertyBusca() {
		return propertyBusca;
	}


	/**
	 * @return the propertyQuantidade
	 */
	public HowMGWTProperty getPropertyQuantidade() {
		return propertyQuantidade;
	}


	/**
	 * @return the propertyPrecoVenda
	 */
	public HowMGWTProperty getPropertyPrecoVenda() {
		return propertyPrecoVenda;
	}



	
	public void onConfigureFirst(PainelListaProduto listaProduto,  HowMGWTDataRecord currentRecord){

		label0002.setContents(novo);

		this.propertyBusca.getHowMGWTEditorFieldText().setHowMValue("");
		this.propertyQuantidade.getHowMGWTEditorFieldText().setHowMValue("");
		this.propertyPrecoVenda.getHowMGWTEditorFieldText().setHowMValue("");
		
		gotoFocus(getPropertyBusca().getHowMGWTEditorFieldText());
	}
		
	public void onConfigure(PainelListaProduto listaProduto,  HowMGWTDataRecord currentRecord){
		
		// getPropertyBuscaPor().getHowMGWTEditorSelectItem().setHowMValue("cod_produto");

		// if( propertyAtendimento.getHowMGWTCheckboxItem().getField().getValueAsBoolean().booleanValue() ){
			if ( !HowMGWTUtilities.isEmpty( getPropertyBusca().getHowMGWTEditorFieldText().getHowMValue() ) ){
				getPropertyBusca().getHowMGWTEditorFieldText().setHowMValue(currentRecord.getAttribute(listaProduto.fieldCodProduto.getName()));
				propertyCodigoProduto.getHowMGWTEditorFieldText().setHowMValue(currentRecord.getAttribute(listaProduto.fieldCodProduto.getName()));

				
				if ( ! menu ){
					if ( ! findShopping()  ){
						double preco = HowMGWTUtilities.getDouble(currentRecord.getAttribute(listaProduto.fieldPrecoVenda.getName()));
						getPropertyQuantidade().getHowMGWTEditorFieldText().setHowMValue("");
						getPropertyPrecoVenda().getHowMGWTEditorFieldText().setHowMValue(""+preco);
					}		
					gotoFocus(getPropertyQuantidade().getHowMGWTEditorFieldText());
				}
				this.currentRecord = currentRecord;
			}
		// }
		// else
		//	currentRecord = null;
	}

//	public void onConfigureAtendimento(){
//
//		if ( propertyAtendimento.getHowMGWTCheckboxItem().getField().getValueAsBoolean().booleanValue() ){
//			label0002.setVisible(true);
//			getPropertyQuantidade().getHowMGWTEditorFieldText().setVisible(true);
//			getPropertyPrecoVenda().getHowMGWTEditorFieldText().setVisible(true);
//			
//			getPropertyQuantidade().getHowMGWTEditorFieldText().redraw();
//			getPropertyPrecoVenda().getHowMGWTEditorFieldText().redraw();
//		}
//		else{
//			label0002.setVisible(false);
//			getPropertyQuantidade().getHowMGWTEditorFieldText().setVisible(false);
//			getPropertyPrecoVenda().getHowMGWTEditorFieldText().setVisible(false);			
//		}
//	}

	/**
	 * Verifica se o produto já está selecionado, se estiver entra no modo de edição do mesmo.
	 * @return
	 */
	public boolean findLocal(){
		
	 	String codProduto;

		ListGridRecord[] records = this.painelGerenciador.getPainelGerenciadorProduto().getListaProduto().getRecords();

		if (HowMGWTUtilities.isEmpty(propertyCodigoProduto.getHowMValue()))
			return false;
		
		for ( ListGridRecord record : records ){
			codProduto = record.getAttribute(this.painelGerenciador.getPainelGerenciadorProduto().getListaProduto().fieldCodProduto.getName());
			if ( codProduto.equalsIgnoreCase(propertyCodigoProduto.getHowMValue().trim()) ){
				this.painelGerenciador.getPainelGerenciadorProduto().getListaProduto().deselectAllRecords();
				this.painelGerenciador.getPainelGerenciadorProduto().getListaProduto().selectRecord(record);
				int row = this.painelGerenciador.getPainelGerenciadorProduto().getListaProduto().getRecordIndex(record);
				this.painelGerenciador.getPainelGerenciadorProduto().getListaProduto().scrollToRow(row);
				onConfigure(this.painelGerenciador.getPainelGerenciadorProduto().getListaProduto(), (HowMGWTDataRecord)record);
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Verifica se o produto já está selecionado, se estiver entra no modo de edição do mesmo.
	 * @return
	 */
	public boolean findShopping(){
		
		if ( this.menu )
			return false;
		
		if ( !"0002".equals(corpo))
			return false;
		
		ListGridRecord[] recordsShopping = this.painelGerenciador.getPainelShoppingProduto().getPainelListaProduto().getRecords();
		String codProduto;

		
		if ( HowMGWTUtilities.isEmpty(propertyBusca.getHowMValue())){
			label0002.setContents(novo);
			return false;
		}
		
		for ( ListGridRecord record : recordsShopping ){
			codProduto = record.getAttribute(this.painelGerenciador.getPainelShoppingProduto().getPainelListaProduto().fieldCodProduto.getName());
			if ( codProduto.equalsIgnoreCase(propertyCodigoProduto.getHowMValue().trim()) ){
				this.painelGerenciador.getPainelShoppingProduto().getPainelListaProduto().deselectAllRecords();
				this.painelGerenciador.getPainelShoppingProduto().getPainelListaProduto().selectRecord(record);
				int row = this.painelGerenciador.getPainelShoppingProduto().getPainelListaProduto().getRecordIndex(record);
				this.painelGerenciador.getPainelShoppingProduto().getPainelListaProduto().scrollToRow(row);
				
				double qtde  = HowMGWTUtilities.getDouble(record.getAttribute(this.painelGerenciador.getPainelShoppingProduto().getPainelListaProduto().fieldQtde.getName()));
				double preco = HowMGWTUtilities.getDouble(record.getAttribute(this.painelGerenciador.getPainelShoppingProduto().getPainelListaProduto().fieldPrecoVenda.getName()));
				
				this.propertyQuantidade.getHowMGWTEditorFieldText().setHowMValue(""+qtde);
				this.propertyPrecoVenda.getHowMGWTEditorFieldText().setHowMValue(""+preco);
				label0002.setContents(editar);
				return true;
			}
		}
	
		label0002.setContents(novo);
		return false;
	}	
	
	/**
	 * Verifica se o produto já está selecionado, se estiver entra no modo de edição do mesmo.
	 * @return
	 */
	public boolean getSuggestList(){

		if ( menuSuggestList != null ){
			menuSuggestList.hide();
			menuSuggestList.clear();
			menuSuggestList.destroy();
			menuSuggestList = null;
		}		
		
		ListGridRecord[] records = this.painelGerenciador.getPainelGerenciadorProduto().getListaProduto().getRecords();

		ArrayList<HowMGWTDataRecord> suggest = new ArrayList<HowMGWTDataRecord>();
		if (HowMGWTUtilities.isEmpty(propertyBusca.getHowMValue()))
			return false;

		String findCodProduto = propertyBusca.getHowMValue();
		String codProduto;
		for ( ListGridRecord record : records ){
			codProduto = record.getAttribute(this.painelGerenciador.getPainelGerenciadorProduto().getListaProduto().fieldCodProduto.getName());
			if ( codProduto.trim().toUpperCase().startsWith(findCodProduto.trim().toUpperCase()) ){
				suggest.add((HowMGWTDataRecord)record);
			}
		}

		if ( suggest.size() > 0 ){
			menuSuggestList = new Menu();
			menuSuggestList.setLeft(this.propertyBusca.getHowMGWTEditorFieldText().getAbsoluteLeft()+110);
			menuSuggestList.setTop(this.propertyBusca.getHowMGWTEditorFieldText().getAbsoluteTop()+this.propertyBusca.getHowMGWTEditorFieldText().getHeight()+2);

			for ( HowMGWTDataRecord record : suggest ){
				codProduto = record.getAttribute(this.painelGerenciador.getPainelGerenciadorProduto().getListaProduto().fieldCodProduto.getName());
				MenuItem item = new MenuItem(codProduto);
				item.addClickHandler(clickHandler);
				menuSuggestList.addItem(item);
			}		
			menuSuggestList.show();
			return true;
		}

		return false;
	}
	
	public void gotoFocus(final HowMGWTTextItem item){
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				item.getField().focusInItem(); 
				item.getField().selectValue();
				item.getField().setShowFocused(true);		
			}
		};
		timer.schedule(100);
	}

	public void onError(ListGridRecord record){
	}
	
	public void onSuccess(ListGridRecord record){

		if ( record == null ){
			this.limparFiltros();
		}else{
			if ( inFocusProduto ){
				propertyQuantidade.getHowMGWTEditorFieldText().getField().setSelectOnFocus(true);
				gotoFocus(propertyQuantidade.getHowMGWTEditorFieldText());
			}
			else if ( inFocusQuantidade ){
				propertyPrecoVenda.getHowMGWTEditorFieldText().getField().setSelectOnFocus(true);
				gotoFocus(propertyPrecoVenda.getHowMGWTEditorFieldText());
			}
			else if ( inFocusPrecoVenda ){
				getPropertyBusca().getHowMGWTEditorFieldText().getField().setSelectOnFocus(true);
				gotoFocus(propertyBusca.getHowMGWTEditorFieldText());
			}
			
		}
		inProcess = false;
	}
}