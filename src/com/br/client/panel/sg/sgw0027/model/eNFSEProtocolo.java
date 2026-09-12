package com.br.client.panel.sg.sgw0027.model;

 
import java.util.Date;


import com.howmake.client.form.partner.HowMGWTUtilities;
 

public class eNFSEProtocolo {


	
	/**
	 * Retorna o SQL para recuperação do protocolo e quantidade de notas fiscais 
	 * enviadas pelo mesmo, por WebServices ou por remessa de arquivo.
	 * @param idProtocolo Protocolo de envio gerado pelo sistema de UCommerce. 
	 * @return Retorna o SQL para recuperação do protocolo de envio.
	 */
	public static final String getSqlSelect(String idProtocolo){
	   return  "select \n"+
			   "	vd_nfse_protocolo.id_protocolo,\n"+
			   "	vd_nfse_protocolo.dsc_observacao,\n"+
			   "	vd_nfse_protocolo.tp_envio,\n"+
			   "	vd_nfse_protocolo.cod_protocolo_prefeitura,\n"+
			   "	vd_nfse_protocolo.nm_modelo,\n"+
			   "	vd_nfse_protocolo.nm_versao,\n"+
			   "	vd_nfse_protocolo.cod_colaborador_inclusao,\n"+
			   "	colaboradorInclusao.id_usuario,\n"+
			   "	colaboradorInclusao.nome_colaborador,\n"+  
			   "	vd_nfse_protocolo.dt_inclusao, \n"+
			   "	vd_nfse_protocolo.dt_cancelamento,\n"+
			   "	vd_nfse_protocolo.cod_colaborador_cancelamento,\n"+
			   "	count(vd_nfse_nota_fiscal.cod_nota_fiscal) as qtdeNFs\n"+
			   "from \n"+
			   "	vd_nfse_protocolo\n"+
			   "	left outer join vd_nfse_nota_fiscal\n"+
			   "		on\n"+
			   "			vd_nfse_nota_fiscal.id_protocolo = vd_nfse_protocolo.id_protocolo\n"+
			   "	inner join sg_colaborador colaboradorInclusao \n"+
			   "		on\n"+
			   "			colaboradorInclusao.cod_colaborador = vd_nfse_protocolo.cod_colaborador_inclusao\n"+
			   "where\n"+
			   "	vd_nfse_protocolo.id_protocolo = "+idProtocolo+"\n"+
			   "group by\n"+
			   "	vd_nfse_nota_fiscal.id_protocolo \n";
	}
	
	private Integer idProtocolo;	 
	private String dscObservacao;
	private String tpEnvio = "WS";
	private String codProtocoloPrefeitura;
	private String nomeModeloIntegracao;
	private String nomeVersaoIntegracao;
	private Integer codColaboradorInclusao;
	private Date dataInclusao;
	private Integer codColaboradorCancelamento;
	private Date dataCancelamento;	
	private Integer qtdeNFs;

	private String motivoCancelamento;
	
	
	private String idUsuario;
	private String nomeColaborador;
	
	
	/**
	 * @return the idProtocolo
	 */
	public Integer getIdProtocolo() {
		return idProtocolo;
	}

	/**
	 * @param idProtocolo the idProtocolo to set
	 */
	public void setIdProtocolo(Integer idProtocolo) {
		this.idProtocolo = idProtocolo;
	}

	/**
	 * @return the dscObservacao
	 */
	public String getDscObservacao() {
		return dscObservacao;
	}

	/**
	 * @param dscObservacao the dscObservacao to set
	 */
	public void setDscObservacao(String dscObservacao) {
		this.dscObservacao = dscObservacao;
	}

	/**
	 * @return the tpEnvio
	 */
	public String getTpEnvio() {
		return tpEnvio;
	}

	/**
	 * @param tpEnvio the tpEnvio to set
	 */
	public void setTpEnvio(String tpEnvio) {
		this.tpEnvio = tpEnvio;
	}

	/**
	 * @return the codProtocoloPrefeitura
	 */
	public String getCodProtocoloPrefeitura() {
		return codProtocoloPrefeitura;
	}

	/**
	 * @param codProtocoloPrefeitura the codProtocoloPrefeitura to set
	 */
	public void setCodProtocoloPrefeitura(String codProtocoloPrefeitura) {
		this.codProtocoloPrefeitura = codProtocoloPrefeitura;
	}

	/**
	 * @return the nomeModeloIntegracao
	 */
	public String getNomeModeloIntegracao() {
		return nomeModeloIntegracao;
	}

	/**
	 * @param nomeModeloIntegracao the nomeModeloIntegracao to set
	 */
	public void setNomeModeloIntegracao(String nomeModeloIntegracao) {
		this.nomeModeloIntegracao = nomeModeloIntegracao;
	}

	/**
	 * @return the nomeVersaoIntegracao
	 */
	public String getNomeVersaoIntegracao() {
		return nomeVersaoIntegracao;
	}

	/**
	 * @param nomeVersaoIntegracao the nomeVersaoIntegracao to set
	 */
	public void setNomeVersaoIntegracao(String nomeVersaoIntegracao) {
		this.nomeVersaoIntegracao = nomeVersaoIntegracao;
	}

	/**
	 * @return the codColaboradorInclusao
	 */
	public Integer getCodColaboradorInclusao() {
		return codColaboradorInclusao;
	}

	/**
	 * @param codColaboradorInclusao the codColaboradorInclusao to set
	 */
	public void setCodColaboradorInclusao(Integer codColaboradorInclusao) {
		this.codColaboradorInclusao = codColaboradorInclusao;
	}

	/**
	 * @return the dataInclusao
	 */
	public Date getDataInclusao() {
		return dataInclusao;
	}

	/**
	 * @param dataInclusao the dataInclusao to set
	 */
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	/**
	 * @return the codColaboradorCancelamento
	 */
	public Integer getCodColaboradorCancelamento() {
		return codColaboradorCancelamento;
	}

	/**
	 * @param codColaboradorCancelamento the codColaboradorCancelamento to set
	 */
	public void setCodColaboradorCancelamento(Integer codColaboradorCancelamento) {
		this.codColaboradorCancelamento = codColaboradorCancelamento;
	}

	/**
	 * @return the dataCancelamento
	 */
	public Date getDataCancelamento() {
		return dataCancelamento;
	}

	/**
	 * @param dataCancelamento the dataCancelamento to set
	 */
	public void setDataCancelamento(Date dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

	/**
	 * @return the qtdeNFs
	 */
	public Integer getQtdeNFs() {
		return qtdeNFs;
	}

	/**
	 * @param qtdeNFs the qtdeNFs to set
	 */
	public void setQtdeNFs(Integer qtdeNFs) {
		this.qtdeNFs = qtdeNFs;
	}
	

	/**
	 * @return the idUsuario
	 */
	public String getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the nomeColaborador
	 */
	public String getNomeColaborador() {
		return nomeColaborador;
	}

	/**
	 * @param nomeColaborador the nomeColaborador to set
	 */
	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}	
	
	/**
	 * Retorna um objeto de protocolo a partir de um parser da linha de dados.
	 * @param row Linha de dados que será realizado o parser.
	 * @return
	 */
	public static final eNFSEProtocolo parser(String[] row){
		eNFSEProtocolo protocolo = new eNFSEProtocolo();
		int i = 0;
		protocolo.setIdProtocolo(HowMGWTUtilities.getInteger(row[i++]));
		protocolo.setDscObservacao(row[i++]);
		protocolo.setTpEnvio(row[i++]);
		protocolo.setCodProtocoloPrefeitura(row[i++]);
		protocolo.setNomeModeloIntegracao(row[i++]);
		protocolo.setNomeVersaoIntegracao(row[i++]);
		protocolo.setCodColaboradorInclusao(HowMGWTUtilities.getIntegerReference(row[i++]));
		protocolo.setIdUsuario(row[i++]);
		protocolo.setNomeColaborador(row[i++]);
		protocolo.setDataInclusao(HowMGWTUtilities.getDateFromLong(row[i++]));
		protocolo.setDataCancelamento(HowMGWTUtilities.getDateFromLong(row[i++]));
		protocolo.setCodColaboradorCancelamento(HowMGWTUtilities.getIntegerReference(row[i++]));
		protocolo.setQtdeNFs(HowMGWTUtilities.getInteger(row[i++]));		
		return protocolo;
	}

	/**
	 * @return the motivoCancelamento
	 */
	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}

	/**
	 * @param motivoCancelamento the motivoCancelamento to set
	 */
	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

}