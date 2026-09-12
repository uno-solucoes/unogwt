package com.br.client.configuracao.entity;

public class eModulo {
	private String corpo;
	private String codLayout;
	private String nomeLayout;	
	
	private String tpFuncao;
	private String comando;
	private String nomeProgramaEnEN;
	private String nomeProgramaPtBR;	
	
	public eModulo(){
		
	}

	/**
	 * @return the corpo
	 */
	public String getCorpo() {
		return corpo;
	}

	/**
	 * @param corpo the corpo to set
	 */
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	/**
	 * @return the codLayout
	 */
	public String getCodLayout() {
		return codLayout;
	}

	/**
	 * @param codLayout the codLayout to set
	 */
	public void setCodLayout(String codLayout) {
		this.codLayout = codLayout;
	}

	/**
	 * @return the nomeLayout
	 */
	public String getNomeLayout() {
		return nomeLayout;
	}

	/**
	 * @param nomeLayout the nomeLayout to set
	 */
	public void setNomeLayout(String nomeLayout) {
		this.nomeLayout = nomeLayout;
	}

	/**
	 * @return the tpFuncao
	 */
	public String getTpFuncao() {
		return tpFuncao;
	}

	/**
	 * @param tpFuncao the tpFuncao to set
	 */
	public void setTpFuncao(String tpFuncao) {
		this.tpFuncao = tpFuncao;
	}

	/**
	 * @return the comando
	 */
	public String getComando() {
		return comando;
	}

	/**
	 * @param comando the comando to set
	 */
	public void setComando(String comando) {
		this.comando = comando;
	}

	/**
	 * @return the nomeProgramaEnEN
	 */
	public String getNomeProgramaEnEN() {
		return nomeProgramaEnEN;
	}

	/**
	 * @param nomeProgramaEnEN the nomeProgramaEnEN to set
	 */
	public void setNomeProgramaEnEN(String nomeProgramaEnEN) {
		this.nomeProgramaEnEN = nomeProgramaEnEN;
	}

	/**
	 * @return the nomeProgramaPtBR
	 */
	public String getNomeProgramaPtBR() {
		return nomeProgramaPtBR;
	}

	/**
	 * @param nomeProgramaPtBR the nomeProgramaPtBR to set
	 */
	public void setNomeProgramaPtBR(String nomeProgramaPtBR) {
		this.nomeProgramaPtBR = nomeProgramaPtBR;
	}
}
