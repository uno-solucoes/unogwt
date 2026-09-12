package com.br.client.panel.fn.fnw0017.model;

import java.util.LinkedHashMap;

import com.br.client.model.fn.entity.eOrcamentoConta;
import com.br.client.panel.fn.fnw0017.UI.PainelResultado;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.widgets.tree.TreeNode;

public class eOrcamentoContaTreeNode extends TreeNode{

	private eOrcamentoConta entityOrcamentoConta;
	private PainelResultado painelResultado;
	
	public eOrcamentoContaTreeNode(eOrcamentoConta orcamentoConta, PainelResultado painelResultado){
		
		this.entityOrcamentoConta 	= orcamentoConta;
		this.painelResultado 		= painelResultado;
		
		this.setAttribute("ContaPai", orcamentoConta.getContaSubContaPai());
		this.setAttribute(painelResultado.contaField.getName(), orcamentoConta.getContaSubConta());
		this.setAttribute(painelResultado.descricaoField.getName(), orcamentoConta.getContaSubConta() + " - " + orcamentoConta.getDescConta());
		this.setAttribute(painelResultado.estimadoField.getName(), orcamentoConta.getVlPrevisao());
		this.setAttribute(painelResultado.aditivosField.getName(), orcamentoConta.getVlAditivos());
		this.setAttribute(painelResultado.orcamentoTotalField.getName(), orcamentoConta.getVlOrcamentoTotal());
		this.setAttribute(painelResultado.faturadoAbertoField.getName(), orcamentoConta.getVlFaturadoEmAberto());
		this.setAttribute(painelResultado.receitasRealizadasField.getName(), orcamentoConta.getVlReceitasRealizadas());
		this.setAttribute(painelResultado.subTotalField.getName(), orcamentoConta.getVlSubTotal());
		this.setAttribute(painelResultado.saldoFaturarField.getName(), orcamentoConta.getVlSaldoFaturar());
		this.setAttribute(painelResultado.totalProjetadoField.getName(), orcamentoConta.getVlTotalProjetado());
	}

	public eOrcamentoConta getEntityOrcamentoConta() {
		return entityOrcamentoConta;
	}

	public void setEntityOrcamentoConta(eOrcamentoConta entityOrcamentoConta) {
		this.entityOrcamentoConta = entityOrcamentoConta;
	}
	
	public void sumarizarContasPai(LinkedHashMap<String, eOrcamentoContaTreeNode> mapContas){
		eOrcamentoContaTreeNode nodeFilho = mapContas.get(this.getEntityOrcamentoConta().getContaSubConta());
		// Encontrou um nó folha, totaliza os nós pai
		if( nodeFilho == null ){
			
			System.out.println("Conta Filha " + this.getEntityOrcamentoConta().getContaSubConta());
			
			onSumarizar(mapContas, this, 0);
		}
	}
	

	/**
	 * Sumariza a conta pai recursivamente ate encontrar o nivel zero..
	 * @param mapContas
	 * @param ocTreeNode
	 */
	public void onSumarizar(LinkedHashMap<String, eOrcamentoContaTreeNode> mapContas, eOrcamentoContaTreeNode ocTreeNode, int nivel){
		eOrcamentoContaTreeNode nodePai = mapContas.get(ocTreeNode.getEntityOrcamentoConta().getContaSubContaPai());
		// Encontrou um nó folha, totaliza os nós pai
		if( nodePai != null ){
			
			

			double totalEstimadoField 			= HowMGWTUtilities.getDouble( nodePai.getAttribute(painelResultado.estimadoField.getName()));
			double totalAtivosField 			= HowMGWTUtilities.getDouble( nodePai.getAttribute(painelResultado.aditivosField.getName()));
			double totalOrcamentoTotalField 	= HowMGWTUtilities.getDouble( nodePai.getAttribute(painelResultado.orcamentoTotalField.getName()));
			double totalFaturadoAbertoField 	= HowMGWTUtilities.getDouble( nodePai.getAttribute(painelResultado.faturadoAbertoField.getName()));
			double totalReceitaRealizadasField 	= HowMGWTUtilities.getDouble( nodePai.getAttribute(painelResultado.receitasRealizadasField.getName()));
			double totalSubTotalField 			= HowMGWTUtilities.getDouble( nodePai.getAttribute(painelResultado.subTotalField.getName()));
			double totalSaldoFaturarField 		= HowMGWTUtilities.getDouble( nodePai.getAttribute(painelResultado.saldoFaturarField.getName()));
			double totalTotalProjetadoField		= HowMGWTUtilities.getDouble( nodePai.getAttribute(painelResultado.totalProjetadoField.getName()));
			
			double estimadoField 				= HowMGWTUtilities.getDouble( this.getAttribute(painelResultado.estimadoField.getName()));
			double ativosField 					= HowMGWTUtilities.getDouble( this.getAttribute(painelResultado.aditivosField.getName()));
			double orcamentoTotalField 			= HowMGWTUtilities.getDouble( this.getAttribute(painelResultado.orcamentoTotalField.getName()));
			double faturadoAbertoField 			= HowMGWTUtilities.getDouble( this.getAttribute(painelResultado.faturadoAbertoField.getName()));
			double receitaRealizadasField 		= HowMGWTUtilities.getDouble( this.getAttribute(painelResultado.receitasRealizadasField.getName()));
			double subTotalField 				= HowMGWTUtilities.getDouble( this.getAttribute(painelResultado.subTotalField.getName()));
			double saldoFaturarField 			= HowMGWTUtilities.getDouble( this.getAttribute(painelResultado.saldoFaturarField.getName()));
			double totalProjetadoField			= HowMGWTUtilities.getDouble( this.getAttribute(painelResultado.totalProjetadoField.getName()));

			
			nodePai.setAttribute(painelResultado.estimadoField.getName()			, totalEstimadoField 			+ estimadoField );
			nodePai.setAttribute(painelResultado.aditivosField.getName()			, totalAtivosField 				+ ativosField );
			nodePai.setAttribute(painelResultado.orcamentoTotalField.getName()		, totalOrcamentoTotalField		+ orcamentoTotalField);
			nodePai.setAttribute(painelResultado.faturadoAbertoField.getName()		, totalFaturadoAbertoField		+ faturadoAbertoField);
			nodePai.setAttribute(painelResultado.receitasRealizadasField.getName()	, totalReceitaRealizadasField 	+ receitaRealizadasField);
			nodePai.setAttribute(painelResultado.subTotalField.getName()			, totalSubTotalField			+ subTotalField);
			nodePai.setAttribute(painelResultado.saldoFaturarField.getName()		, totalSaldoFaturarField		+ saldoFaturarField);
			nodePai.setAttribute(painelResultado.totalProjetadoField.getName()		, totalTotalProjetadoField		+ totalProjetadoField);			
			
			System.out.println( HowMGWTUtilities.getTabulation( nivel ) + "conta-sub = "+nodePai.getEntityOrcamentoConta().getContaSubConta() + " conta-sub pai = "+nodePai.getEntityOrcamentoConta().getContaSubContaPai() );			
			
			nivel ++;
			
			onSumarizar(mapContas, nodePai, nivel);
		}
	}
}