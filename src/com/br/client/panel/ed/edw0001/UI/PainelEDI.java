package com.br.client.panel.ed.edw0001.UI;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.UIPartner;
import com.br.client.panel.vd.vdq0002.UI.PainelGerenciador;
import com.howmake.client.form.UI.HowMGWTFormToolbarDragSelect;
import com.howmake.client.form.UI.HowMGWTListGrid;
import com.howmake.client.form.UI.HowMGWTPanelSectionStack;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelEDI extends VLayout implements UIPartner{

	
	
	private PainelEDIControle 	painelEDIControle 				= new PainelEDIControle();
	private HowMGWTListGrid 	painelListaEDI 					= painelEDIControle.getFormToolbarEdit().getPanelList();
	private HowMGWTListGrid 	painelListaProdutosSelecionados = painelEDIControle.getPainelEDIListaProdutos().getFormToolbarEdit().getPanelList();
 
	private HowMGWTFormToolbarDragSelect painelToolbarDragSelect = new HowMGWTFormToolbarDragSelect(painelEDIControle.getPainelEDIListaProdutos());
	
	PainelGerenciador painelBuscaProduto = new PainelGerenciador(true, false, false){
		@Override
		public void onInitialized() {
			
			super.onInitialized();
			getRelacaoGerenciadorProduto().getListaProduto().setCanAcceptDrop(true);
			getRelacaoGerenciadorProduto().getListaProduto().setCanDragRecordsOut(true);

			// Remove o painel de resumo do produto.
			getRelacaoGerenciadorProduto().getPainelGerenciador().getPainelGerenciadorProduto().getResumoProduto().setVisible(false);

			painelListaProdutosSelecionados.setWidth100();
 			getRelacaoGerenciadorProduto().getPainelGerenciador().getPainelGerenciadorProduto().getMainLayout().setWidth(510);
			getRelacaoGerenciadorProduto().getPainelGerenciador().getPainelGerenciadorProduto().getEstruturaLayoutProduto().setVisible(false);			 
		

	        HowMGWTPanelSectionStack sessionListaSimilares = new HowMGWTPanelSectionStack( "<font color=red><b>"+Tradutor.i18n.formListProdutosProgramadosEDI()+"", painelListaProdutosSelecionados);
	        sessionListaSimilares.setHeaderHeight(40);	        

	        Img actionVoltarLixeira = new Img("tools/bot_lixeira_voltar.png");
	        actionVoltarLixeira.setHeight(32);
	        actionVoltarLixeira.setWidth(32);
	        actionVoltarLixeira.setCursor(Cursor.POINTER);
	        actionVoltarLixeira.setPrompt(Tradutor.i18n.formVoltarExcluir());
	        painelEDIControle.setActionVoltarLixeira(actionVoltarLixeira);
	        painelEDIControle.getPainelEDIListaProdutos().setActionVoltarLixeira(actionVoltarLixeira);
	        
	        
	        Img actionLixeira = new Img("tools/bot_lixeira_vazia.png");
	        actionLixeira.setHeight(32);
	        actionLixeira.setWidth(32);
	        actionLixeira.setCursor(Cursor.POINTER);
	        actionLixeira.setPrompt(Tradutor.i18n.formExcluir());
	        painelEDIControle.setActionLixeira(actionLixeira);
	        painelEDIControle.getPainelEDIListaProdutos().setActionLixeira(actionLixeira);
	        
	        
	        
	        
	        
	        Img imgSinc = new Img("tools/bot_cfg.png");	  
	        imgSinc.setHeight(32);
	        imgSinc.setWidth(32);
	        sessionListaSimilares.getSession().setControls(actionLixeira,actionVoltarLixeira, imgSinc);
	        
	        actionVoltarLixeira.setVisible(false);
	        
	        sessionListaSimilares.setWidth100();
	        sessionListaSimilares.setHeight100();        
	        // estruturaLayoutProduto.addMember(sessionListaSimilares);
			
	        
			getRelacaoGerenciadorProduto().getPainelGerenciador().getPainelGerenciadorProduto().addMember(painelToolbarDragSelect);
			getRelacaoGerenciadorProduto().getPainelGerenciador().getPainelGerenciadorProduto().addMember(sessionListaSimilares);
			
			painelEDIControle.setPainelBuscaProduto(this);
			painelEDIControle.getPainelEDIListaProdutos().setPainelGerenciador(this);
			
		}
	};
	 
	public PainelEDI(){
	} 

	@Override
	public void start() {
		
		painelBuscaProduto.start();

 
		painelListaEDI.setWidth(250);
		
		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();		
		vLayout.addMember(painelEDIControle);

		
		
		painelListaProdutosSelecionados.setWidth(350);

		

		HLayout hLayout = new HLayout();
		hLayout.setWidth100();
		hLayout.setHeight(240);
		
		hLayout.addMember(painelListaEDI);
		hLayout.addMember(vLayout);
		
		this.addMember(hLayout);
		

		VLayout vConsultaProdutos = new VLayout();
		vConsultaProdutos.setWidth100();
		vConsultaProdutos.setHeight100();

		vConsultaProdutos.addMember(painelBuscaProduto);
		this.addMember(vConsultaProdutos);
		
		
		this.painelEDIControle.executeQuery();

	}
	
	

	public String getHowMGWTTitle(){
		return Tradutor.i18n.formTituloEDW0001();
	}

	public String getHowMGWTPrograma(){
		return "EDW0001";
	}
 }
