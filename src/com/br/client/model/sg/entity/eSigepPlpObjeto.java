package com.br.client.model.sg.entity;

public class eSigepPlpObjeto extends com.howmake.client.form.model.HowMGWTFormBean{
	public eSigepPlpObjeto(){
	}


	public String getSeqPlpObjeto(){
		return toString("seqPlpObjeto");
	}

	public void setSeqPlpObjeto(String value){
		setString("seqPlpObjeto",value);
	}


	public String getCodListaPostagem(){
		return toString("codListaPostagem");
	}

	public void setCodListaPostagem(String value){
		setString("codListaPostagem",value);
	}


	public String getCodEmpresa(){
		return toString("codEmpresa");
	}

	public void setCodEmpresa(String value){
		setString("codEmpresa",value);
	}


	public String getCodNotaFiscal(){
		return toString("codNotaFiscal");
	}

	public void setCodNotaFiscal(String value){
		setString("codNotaFiscal",value);
	}


	public String getNrNotaFiscal(){
		return toString("nrNotaFiscal");
	}

	public void setNrNotaFiscal(String value){
		setString("nrNotaFiscal",value);
	}


	public String getNomeCliente(){
		return toString("nomeCliente");
	}

	public void setNomeCliente(String value){
		setString("nomeCliente",value);
	}


	public String getCodPedido(){
		return toString("codPedido");
	}

	public void setCodPedido(String value){
		setString("codPedido",value);
	}


	public String getCodPedidoPDA(){
		return toString("codPedidoPDA");
	}

	public void setCodPedidoPDA(String value){
		setString("codPedidoPDA",value);
	}


	public String getNrEtiqueta(){
		return toString("nrEtiqueta");
	}

	public void setNrEtiqueta(String value){
		setString("nrEtiqueta",value);
	}


	public String getCodServicoPostagem(){
		return toString("codServicoPostagem");
	}

	public void setCodServicoPostagem(String value){
		setString("codServicoPostagem",value);
	}


	public String getCodTipoObjeto(){
		return toString("codTipoObjeto");
	}

	public void setCodTipoObjeto(String value){
		setString("codTipoObjeto",value);
	}


	public String getPeso(){
		return toString("peso");
	}

	public void setPeso(String value){
		setString("peso",value);
	}


	public String getEmailDestinatario(){
		return toString("emailDestinatario");
	}

	public void setEmailDestinatario(String value){
		setString("emailDestinatario",value);
	}


	public String getEmailEnvio(){
		return toString("emailEnvio");
	}

	public void setEmailEnvio(String value){
		setString("emailEnvio",value);
	}


	public String getIndAvisoRecebimento(){
		return toString("indAvisoRecebimento");
	}

	public void setIndAvisoRecebimento(String value){
		setString("indAvisoRecebimento",value);
	}


	public String getIndARDigital(){
		return toString("indARDigital");
	}

	public void setIndARDigital(String value){
		setString("indARDigital",value);
	}


	public String getDescServico(){
		return toString("descServico");
	}

	public void setDescServico(String value){
		setString("descServico",value);
	}


	public String getDescStatus(){
		return toString("descStatus");
	}

	public void setDescStatus(String value){
		setString("descStatus",value);
	}


	public String getVolume(){
		return toString("volume");
	}

	public void setVolume(String value){
		setString("volume",value);
	}


	@Override
	public void loadCustomArray(String name, com.google.gwt.json.client.JSONArray array){
	}

	@Override
	public Object loadCustom(String name, com.google.gwt.json.client.JSONObject value){
		return null;
	}


	public static final com.br.client.model.sg.entity.eSigepPlpObjeto newInstance(){
		return new com.br.client.model.sg.entity.eSigepPlpObjeto();
	}
}