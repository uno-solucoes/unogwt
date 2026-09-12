package com.br.client.panel.vd.vdw1000.util;

import com.br.client.model.vd.entity.eNFSEStatusWS;

public class NFSEUtilities {
 	
	
	public static final String OPERACAO_NOTAS_FISCAIS_PENDENTES_PARA_ENVIO 				= "1"; 
	public static final String OPERACAO_ENVIAR_RPS_PARA_PROCESSAMENTO_DESC 			= "Notas fiscais pendentes para envio";
	
	public static final String OPERACAO_AGUARDANDO_PROCESSAMENTO_NA_PREFEITURA			= "2";
	public static final String OPERACAO_CANCELAR_ENVIO_RPS_NAO_PROCESSADAS_DESC		= "RPS's aguardando processamento na prefeitura";
	
//	public static final String OPERACAO_SINCRONIZAR_ERP_X_SERVIDOR_RPS				= "3";
//	public static final String OPERACAO_SINCRONIZAR_ERP_X_SERVIDOR_RPS_DESC			= "RPS's com processamento pendente no Servidor de Integração";

	
	
//	public static final String OPERACAO_CANCELAR_NFSE_NA_PREFEITURA					= "4";
//	public static final String OPERACAO_CANCELAR_NFSE_NA_PREFEITURA_DESC			= "NFS-e para cancelamento na Prefeitura";


	public static final String OPERACAO_EMITIDAS_NA_PREFEITURA						= "4";
	public static final String OPERACAO_CARREGAR_NFSE_EMITIDAS_DESC					= "NFS-e emitidas na Prefeitura";
	
	
	
	
	

	
	
	
	public static final String OPERACAO_EXPORTAR_ARQUIVO_XML_NFSE_PARA_CONTADOR		= "6";
	public static final String OPERACAO_EXPORTAR_ARQUIVO_XML_NFSE_PARA_CONTADOR_DESC= "Exportar XML-NFS-e<br> para Contador";
	
	public static final String OPERACAO_EXPORTAR_ARQUIVOS_PDF_DANFES				= "7";
	public static final String OPERACAO_EXPORTAR_ARQUIVOS_PDF_DANFES_DESC			= "Visualizar<br>NFS-e";
	
	public static final String OPERACAO_EXPORTAR_ARQUIVO_PDF_NFSE					= "8";
	public static final String OPERACAO_EXPORTAR_ARQUIVO_PDF_NFSE_DESC				= "Visualizar<br>NFS-e";

	public static final String OPERACAO_ENVIAR_EMAIL_CONTRIBUINTE					= "9";
	public static final String OPERACAO_ENVIAR_EMAIL_CONTRIBUINTE_DESC 				= "Enviar e-mail<br>contribuinte...";
	
	
	public static final String OPERACAO_ENVIAR_RPS_PREFEITURA 						= "10"; 
	public static final String OPERACAO_ENVIAR_RPS_PREFEITURA_DESC 					= "Enviar";

	public static final String OPERACAO_REENVIAR_RPS_PREFEITURA 					= "23"; 
	public static final String OPERACAO_REENVIAR_RPS_PREFEITURA_DESC 				= "Voltar<br>Fase 1";

	public static final String OPERACAO_OPERACAO_SUPORTE_INTELIGENTE 				= "24"; 
	public static final String OPERACAO_SUPORTE_INTELIGENTE_DESC 					= "Ajude-me";
	
	public static final String OPERACAO_CANCELAR_ENVIO_RPS							= "11";
	public static final String OPERACAO_CANCELAR_ENVIO_RPS__DESC					= "Cancelar<br>NFS-e";
	
	public static final String OPERACAO_CANCELAR_NFSE								= "12";
	public static final String OPERACAO_CANCELAR_NFSE_DESC							= "Cancelar NFS-e<br>na Prefeitura";

	public static final String OPERACAO_SINCRONIZR_RPS_PENDENTES					= "13";
	public static final String OPERACAO_SINCRONIZR_RPS_PENDENTES_DESC				= "Sincronizar RPS's<br>Pendentes";
	
	public static final String OPERACAO_MONITOR_INTEGRACAO							= "14";
	public static final String OPERACAO_MONITOR_INTEGRACAO_DESC						= "Monitor de<br>Integração";

	public static final String OPERACAO_CONFIGURAR_SERVICO							= "15";
	public static final String OPERACAO_CONFIGURAR_SERVICO_DESC						= "Configurar <br>Monitoramento";

	public static final String OPERACAO_ACESSAR_SITE_PREFEITURA						= "16";
	public static final String OPERACAO_ACESSAR_SITE_PREFEITURA_DESC				= "Acessar Portal<br>NFS-e Prefeitura";

	public static final String OPERACAO_VISUALIZAR_HISTORICO						= "17";
	public static final String OPERACAO_VISUALIZAR_HISTORICO_DESC 					= "Visualizar<br>Histórico...";	

	public static final String OPERACAO_ACESSAR_ADMINISTRADOR						= "18";
	public static final String OPERACAO_ACESSAR_ADMINISTRADOR_DESC					= "Suporte";
	
	public static final String OPERACAO_ACESSAR_ADMIN_REGERAR_RPS_REENVIAR			= "19";
	public static final String OPERACAO_ACESSAR_ADMIN_REGERAR_RPS_REENVIAR_DESC		= "Recriar / <br>Reenviar RPS";

	public static final String OPERACAO_ACESSAR_ADMIN_ANALISAR_RPS					= "20";
	public static final String OPERACAO_ACESSAR_ADMIN_ANALISAR_RPS_DESC				= "Analisar<br>RPS";

	public static final String OPERACAO_ACESSAR_ADMIN_BACK							= "21";
	public static final String OPERACAO_ACESSAR_ADMIN_BACK_DESC						= "Voltar";

	public static final String OPERACAO_ACESSAR_ADMIN_DOWNLOAD_AI_RPS				= "22";
	public static final String OPERACAO_ACESSAR_ADMIN_DOWNLOAD_AI_DESC				= "Download";

	
	public static boolean isNFSEGeradaNaPrefeitura(eNFSEStatusWS nfse){
        if( nfse.getChaveNFSE() == null || nfse.getChaveNFSE().length() == 0 ){
            return false;
        }
        return true;
    }
    
    public static String getNFSESituacaoPrefeitura(eNFSEStatusWS nfse){
        if( isNFSEGeradaNaPrefeitura(nfse)){
            return "NFS-e Gerada";
        }
        else{
            if( nfse.getCmsgSefaz() == null || nfse.getCmsgSefaz().trim().length() == 0) {
                return "Pendente";
            }
            return "Erro : "+nfse.getCmsgSefaz();
        }
            
    }	
	
	public final static String getEntityEmitenteView(eNFSEStatusWS statusWS){
		String html = "";

//		html += statusWS.getChaveNFSE();
//		html += statusWS.getCmsgSefaz();
//		html += statusWS.getCodStat();
//		html += statusWS.getCStat();
//		html += statusWS.getDataEmissao();
//		html += statusWS.getDestinatario();
//		html += statusWS.getDataHoraRecebimento();
//		html += statusWS.getDataAlteracao();
//		html += statusWS.getEMails();
//		html += statusWS.getEMailsSucesso();
//		html += statusWS.getMunicipio();
//		html += statusWS.getMunicipioPrestacao();
//		html += statusWS.getNNf();
//		html += statusWS.getNProtocoloCancelamento();
//		html += statusWS.getNProtocoloEnvio();
//		html += statusWS.getNProtocoloRecebimento();
//		html += statusWS.getNumeroNFSE();
//		html += statusWS.getQtdEmissao();
//		html += statusWS.getQtdEnvioEmail();
//		html += statusWS.getQtdRetornada();
//		html += statusWS.getSerie();
//		html += statusWS.getTipoIntegracao();
//		html += statusWS.getTipoAmbiente();
//		html += statusWS.getTipoEnvio();
//		html += statusWS.getTipoImpressao();
//		html += statusWS.getMotivo();
//		html += statusWS.getMsgSefaz();		

		html += "Data Emissão : " + statusWS.getDataEmissao();
		html += "<br>";
		html += "Data Recebimento : " + statusWS.getDataHoraRecebimento();
		html += "<br>";
		html += "Mensagem : " + statusWS.getMotivo();
		html += "<br>";
		html += "código SEFAZ : " + statusWS.getCmsgSefaz();
		html += "<br>";
		html += "Chave NFS-e : "+ statusWS.getChaveNFSE();
		html += "<br>";
		html += "Situação Prefeitura : "+NFSEUtilities.getNFSESituacaoPrefeitura(statusWS);
		html += "<br>";
		html += "NFS-e Gerada : "+statusWS.getNumeroNFSE();
		html += "<br>";
		html += "Número Protocolo Envio : "+statusWS.getNProtocoloEnvio();
		html += "<br>";
		html += "Número Protocolo Retorno : "+statusWS.getNProtocoloRecebimento();
		html += "<br>";
		html += "Número Protocolo Cancelamento : "+statusWS.getNProtocoloCancelamento();
		html += "<br>";
		html += "E-Mail Responsável : "+statusWS.getEMails();		

		return html;
	}
}