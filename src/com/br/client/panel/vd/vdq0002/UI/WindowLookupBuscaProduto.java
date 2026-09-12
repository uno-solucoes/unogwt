package com.br.client.panel.vd.vdq0002.UI;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTLookupWindow;
import com.howmake.shared.HowMGWTEntity;

public class WindowLookupBuscaProduto extends HowMGWTLookupWindow{

	PainelGerenciador painelBuscaProduto = new PainelGerenciador(true,false, true){
		@Override
		public void onInitialized() {
			
			super.onInitialized();

			// Remove o painel de resumo do produto.
			getRelacaoGerenciadorProduto().getPainelGerenciador().getPainelGerenciadorProduto().getResumoProduto().setVisible(false);

//// 			getRelacaoGerenciadorProduto().getPainelGerenciador().getPainelGerenciadorProduto().getMainLayout().setWidth(510);
			getRelacaoGerenciadorProduto().getPainelGerenciador().getPainelGerenciadorProduto().getEstruturaLayoutProduto().setVisible(false);			 
		}
		
		@Override
		public void onSelectLookup(String codProduto, String descricao){
			WindowLookupBuscaProduto.this.hide();
			WindowLookupBuscaProduto.this.onSelectLookup(codProduto, descricao);
		}
		
		
		public void onShowLookup(){
			WindowLookupBuscaProduto.this.show();
		};
	};
	
	public WindowLookupBuscaProduto(){

		this.setWidth("820");
		this.setHeight("700");
		this.centerInPage();
 		this.setIsModal(true);
 	
		painelBuscaProduto.setWidth100();
		painelBuscaProduto.setHeight100();
		
		this.addItem(this.painelBuscaProduto);
	}

	

	public String getHowMGWTTitle(){
    	return  Tradutor.i18n.formTituloVDQ0002();
	}

	public String getHowMGWTPrograma(){
		return "VDQ0002";
	}
	
	public void onSelectLookup(String codProduto, String descricao){}



	@Override
	protected boolean onHowMPrepareFind(HowMGWTEntity entity) {
		 
		return false;
	}



	/**
	 * @return the painelBuscaProduto
	 */
	public PainelGerenciador getPainelBuscaProduto() {
		return painelBuscaProduto;
	};



}