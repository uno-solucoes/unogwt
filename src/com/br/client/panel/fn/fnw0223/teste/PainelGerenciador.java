package com.br.client.panel.fn.fnw0223.teste;


import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.fn.fnw0223.model.EPlanoContas;
import com.br.client.panel.registro.Services;
import com.br.client.panel.registro.UIPartner;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTControl;
import com.howmake.client.form.model.HowMGWTFormBean;
import com.howmake.client.form.model.HowMGWTPlugInStruts;
import com.howmake.client.form.partner.HowMGWTPDF;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;
import com.br.client.model.fn.fnw0217.teste.EntityPlanoContas;
import com.br.client.model.fn.fnw0217.teste.FormBean;

/**
 * Balancete 
 * @author JPLEISER
 */
public class PainelGerenciador extends VLayout implements UIPartner{
		
	PanelPlanoContas panelPlanoContas = new PanelPlanoContas();
	public PainelGerenciador() {
		
		panelPlanoContas.setWidth100();
		panelPlanoContas.setHeight100();
		
		this.addMember(panelPlanoContas);
	}
	
	public void start(){
		
		onBuscaPlanoContas();
		
	}
	
	
	public void configure(){
		
	}
 
	/**
	7	 * Encaminha a requisição para o servidor para executar a consulta.
	 */
	private boolean onBuscaPlanoContas() {
		
		HowMGWTWindowWait.showWait();
        
		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
			
				public void onFailure(Throwable caught) {
					HowMGWTWindowWait.hideWait();
					caught.printStackTrace();
					com.google.gwt.user.client.Window.alert(Tradutor.i18n.formEnderecoBase()+GWT.getHostPageBaseURL()+"\n"+caught.getMessage());
				}

				public void onSuccess(HowMGWTEntity result) {
					HowMGWTWindowWait.hideWait();
					HowMGWTWindowWait.hideWait();
					
					if ( result.getData().size() == 0){
						HowMGWTWindowWait.hideWait();
						Window.alert(Tradutor.i18n.alertNaoEncontrouRegistros());
						return;
					}					
					showResult(result);
					SC.say("Fim do processamento");
				}
		};
		HowMGWTEntity entity = Fabrica.createEntity();
		entity.setAction(Services.acaoSelectInEmpresa);
		
		HowMProperty pSelect = new HowMProperty(Fabrica.DEFAULT_SELECT, EPlanoContas.getSelectPlanoContas());
		entity.getParameters().put(pSelect.getName(), pSelect);
		
		Configuracao.getProxyStruts().executeQuery(entity, callback);
		return true;
	}

		
	/**
	 * Marca a conta root pra Receita ou Despesa conforme o nó filho
	 * @param conta pai variável
	 */
	public void markContaNivelZero(EPlanoContas contaFolha ,EPlanoContas contaPaiVariavel ){	
		if ( contaPaiVariavel != null ){
						
			if ( contaPaiVariavel.isAgrupadorPrincipal() )
				return;
			
			if( contaPaiVariavel.isVisited() )
				return;
			
 
			contaPaiVariavel.setVisited(true);
			EPlanoContas contaPai = planoContas.get(contaPaiVariavel.getParent());
			if ( contaPai  != null ){
					markContaNivelZero(contaFolha, contaPai);
			}
			else{ // Encontrou a conta principal, marca como root.
				if ( !contaPaiVariavel.isRootNode() ){
					System.out.println("Conta Pai parent: "+contaPaiVariavel.getParent()+"-"+"Conta Pai Key: "+contaPaiVariavel.getKey()+"-"+contaPaiVariavel.getTipoConta()+ " conta folha receita : "+contaFolha.isReceita());
					contaPaiVariavel.setRootNode(true);
					contaPaiVariavel.setReceita(contaFolha.isReceita());
				}
			}
		}
	}		
	
	
	private LinkedHashMap<String, EPlanoContas> planoContasPai = new LinkedHashMap<String, EPlanoContas>();
	private LinkedHashMap<String, EPlanoContas> planoContas = new LinkedHashMap<String, EPlanoContas>();
	private EPlanoContas contaReceitas 		= EPlanoContas.createContaReceita();
	private EPlanoContas contaDespesas 		= EPlanoContas.createContaDespesas();	
	private EPlanoContas contaResultado 	= EPlanoContas.createContaResultado();
	private EPlanoContas contaNullReceita 	= EPlanoContas.createNullContaReceita();
	private EPlanoContas contaNullDespesa 	= EPlanoContas.createNullContaDespesa();

	
	/**
	 * Carrega o Plano de Contas.
	 * @param result
	 */
	public void showResult(HowMGWTEntity result){
				
		// Inclui contas adicionais para totalização de para 
		// agrupamento de receitas e despesas sem conta associada.
		planoContas.put(contaReceitas.getKey(), contaReceitas);
		planoContas.put(contaDespesas.getKey(), contaDespesas);
		planoContas.put(contaNullDespesa.getKey(), contaNullDespesa);
		planoContas.put(contaNullReceita.getKey(), contaNullReceita);
		
		for ( String[] row : result.getData() ){
			EPlanoContas conta = new EPlanoContas(row);
			planoContas.put(conta.getKey(), conta);			
			planoContasPai.put( conta.getParent(), conta);
		}

		Object[] entry = planoContas.keySet().toArray();

		EntityPlanoContas[] bean		   = new EntityPlanoContas[entry.length];
		EPlanoContas[] oCurrentPlanoContas = new EPlanoContas[entry.length];
		ArrayList<EPlanoContas> oContasPai = new ArrayList<EPlanoContas>();
		int i = 0;
		// Percorre o plano de contas e corrige os niveis de aninhamento do plano.
		for ( Object obj : entry){
			EPlanoContas conta = planoContas.get(obj.toString());
			oCurrentPlanoContas[i] = conta;
			// Verifica se a conta é folha.
			conta.setFolha(false);
			// Se encontrar encontrar a conta nas contas pai,
			// significa que é uma conta filha.
			EPlanoContas contaPai = this.planoContasPai.get(obj.toString());
			if (  contaPai == null ){
				conta.setFolha(true);
				markContaNivelZero(conta,this.planoContasPai.get(conta.getParent()));
			}
			else{
				oContasPai.add(conta);
			}
			EntityPlanoContas cc = new EntityPlanoContas();
			cc.setConta(conta.getKey());
			cc.setContaPai(conta.getParent());
			cc.setDescricao(conta.getAttribute("DescricaoConta"));
			bean[i] = cc;
			i ++;			
		}
		FormBean b = new FormBean();
		b.setEntityPlanoContas(bean);
		panelPlanoContas.executeHowMAction(b);
	}
	
}