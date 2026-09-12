package com.br.client.panel.sg.sgw0027.UI;

 
import com.br.client.configuracao.Configuracao;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.I18N.TradutorI18N;
import com.br.client.panel.sg.sgw0027.model.eConstants;
import com.br.client.panel.sg.sgw0027.model.eNFSEProtocolo;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.howmake.client.form.UI.HowMGWTImgButtonDonwload;
import com.howmake.client.form.model.HOWMGWTDataSourceQuery;
import com.howmake.client.form.model.HowMGWTCall;
import com.howmake.client.form.model.HowMGWTCallImpl;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.client.form.service.HowMGWTExecuteReportExternalWindow;
import com.howmake.shared.HowMGWTEntity;
import com.ibm.icu.text.DateFormat;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;

public class ToolbarRecord extends HLayout{
    
	private WindowConfirmar windowConfirmar;
	private ListGridRecord record;
	private ImgButton actionStatus 		= new ImgButton();  
	private ImgButton actionDelete 		= new ImgButton();  
	private ImgButton actionConsulta 	= new ImgButton();
	private ImgButton actionSelect   	= new ImgButton();
	private ImgButton actionViewNF		= new ImgButton();
	private HLayout layoutActionSelect  = new HLayout();

	
	private ResultadoConsulta resultadoConsulta;
	
	private HowMGWTImgButtonDonwload actionDonwload = new HowMGWTImgButtonDonwload();
	
	public ToolbarRecord(ListGridRecord lRecord , ResultadoConsulta parentResultadoConsulta){
		super(3); 

		this.resultadoConsulta = parentResultadoConsulta;
		
		this.setWidth100();
		
		this.record = lRecord;
		this.setHeight(22);  
		this.setAlign(Alignment.CENTER);
		
		this.layoutActionSelect.setWidth100();
		this.layoutActionSelect.setHeight(22);
		this.layoutActionSelect.setAlign(Alignment.CENTER);
		this.layoutActionSelect.setBackgroundColor("#FFFFFF");
		
		actionSelect.setShowDown(false);  
		actionSelect.setShowRollOver(false);  
		actionSelect.setLayoutAlign(Alignment.CENTER);   
		actionSelect.setSrc(this.getFlagSelect());  
		actionSelect.setPrompt(	Tradutor.i18n.promptSelecionado() );  
		actionSelect.setHeight(16);  
		actionSelect.setWidth(16);  
		
		actionSelect.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {
            	if ( isRPSEnviada() ){
            		record.setAttribute(getSelect(),"false");
            		return;
            	}

            	if ("true".equalsIgnoreCase(record.getAttribute(getSelect()))){
            		actionSelect.setPrompt(	Tradutor.i18n.promptNaoSelecionado());
            		record.setAttribute(getSelect(),"false");
            	}
            	else{
            		record.setAttribute(getSelect(),"true");
            		actionSelect.setPrompt(	Tradutor.i18n.promptSelecionado());
            	}
            	actionSelect.setSrc( getFlagSelect() );
            }  
        });
		record.setAttribute(getFieldSelectNameComponent(), this);
		
		actionStatus.setShowDown(false);  
		actionStatus.setShowRollOver(false);  
		actionStatus.setLayoutAlign(Alignment.CENTER);  
		actionStatus.setSrc(this.getFlagRPSEnviada());  
		actionStatus.setPrompt("");  
		actionStatus.setHeight(16);  
		actionStatus.setWidth(16);
		if ( resultadoConsulta.isWebService() || resultadoConsulta.isG2ka() ){
			actionStatus.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					if ( isRPSEnviada() ){
						resultadoConsulta.consultarWebService(record);
					}
				}
			});
		}
	
		
		actionDelete.setShowDown(false);  
		actionDelete.setShowRollOver(false);  
		actionDelete.setLayoutAlign(Alignment.CENTER);  
		actionDelete.setSrc(this.getFlagDelete());  
		actionDelete.setPrompt("");  
		actionDelete.setHeight(16);  
		actionDelete.setWidth(16);  
		actionDelete.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				if ( isRPSEnviada() ){
					// Se tiver nestas situações não permite excluir.
					if ( getFlagDelete().equalsIgnoreCase(getFlagTransparence())){
						;
					}
					else
						verificaCancelamento();
				}
			}
		});		

		actionConsulta.setShowDown(false);  
		actionConsulta.setShowRollOver(false);  
		actionConsulta.setLayoutAlign(Alignment.CENTER);  
		actionConsulta.setSrc(this.getFlagConsulta());  
		actionConsulta.setPrompt("");  
		actionConsulta.setHeight(16);  
		actionConsulta.setWidth(16);  
		actionConsulta.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				 
				if ( isRPSEnviada() && isValidFile() )
					resultadoConsulta.showXML(record);
			}
		});

		
		actionViewNF.setShowDown(false);  
		actionViewNF.setShowRollOver(false);  
		actionViewNF.setLayoutAlign(Alignment.CENTER);  
		actionViewNF.setSrc(this.getFlagViewNF());  
		actionViewNF.setPrompt("");  
		actionViewNF.setHeight(16);  
		actionViewNF.setWidth(16);  
		actionViewNF.setPrompt(Tradutor.i18n.formPromptVisualizarNotaFiscalServicoUCommerce());
		actionViewNF.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String codNotaFiscal = record.getAttribute(getCodNumeroNF());
				resultadoConsulta.showNotaFiscalServicoUCommerce(codNotaFiscal);
			}
		});
		
		
		this.addMember(actionStatus);
		this.addMember(actionDelete);
		this.addMember(actionConsulta);

		
		
		this.addMember(actionDonwload);
		this.addMember(actionViewNF);
		
		this.layoutActionSelect.addMember(actionSelect);
		
		refreshPrompts();
	}

	public static String getFieldSelectNameComponent(){
		return "fieldSelectComp"; 
	}
	
	public static String getNrRPS(){
		return "arqRps";
	}
	
	
	public static String getSelect(){
		return "fieldSelect";
	}
	
	public static String getControl(){
		return "flagControl";
	}

	public static String getCodNumeroNF(){
		return "codNumeroNF";
	}
	
	private String getFlagControl(){
		return this.record.getAttribute(getControl());
	}
	
	public boolean isOS(){
		if ( getNomeArquivoNF() != null && getNomeArquivoNF().startsWith("OS:") )
			return true;
		return false;
	}

	private String getIconAtividade()
	{
		return this.record.getAttribute("IconAtividade");		
	}
	
	public void setIconAtividade(String icon)
	{
		this.record.setAttribute("IconAtividade",icon);
	}	
	
	public void setIdAtividade(int idAtividade){
		this.record.setAttribute("IdAtividade", ""+idAtividade);
	}	
	
	private String getIdAtividade(){
		return this.record.getAttribute("IdAtividade");
	}
	
	private String getArquivoNF(){
		return "nomeArqNF";
	}

	private String getRealNomeArquivoNF(){
		String fileName = getNomeArquivoNF();
		fileName = fileName.replaceAll("OS:", "");
		fileName = fileName.replaceAll("WS:", "");
		return fileName;
	}	
	
	private String getNomeArquivoNF(){
		return this.record.getAttribute(getArquivoNF());
	}	
	
	public boolean isEnvioRPSPendente(){
		return "P".equalsIgnoreCase(this.getFlagControl());
	}
	
	public boolean isRPSEnviada(){
		return "E".equalsIgnoreCase(this.getFlagControl());
	}
	
	private String getFlagRPSEnviada(){
		if ( this.isRPSEnviada() )
			if ( this.isOS() )
				return "nfe/nfe_xml.png";
			else if ( this.resultadoConsulta.isArquivoRemessa() )
				return "nfe/nfe_text.png";
			else{
				if( isPrefeituraOK() || isPrefeituraError() )
					return this.getIconAtividade();
				else if ( isAguardandoCancelamentoNFSEPrefeitura() )
					return this.getIconAtividade();
				else if ( isNFSECanceladaPrefeitura() )
					return this.getIconAtividade();
				else if ( isErroAoCancelarNFSEPrefeitura() )
					return this.getIconAtividade();
				return "nfe/nfe_share.png";
			}
		else
			return "nfe/nfe_send.png";
	}
		
	private String getFlagSelect(){
		if ( this.isRPSEnviada() )				
			return "actions/transparence.png";
		else{
           	if ("true".equalsIgnoreCase(record.getAttribute(getSelect())))
           		return "actions/accept.png";
        	else
        		return "actions/exclamation.png";
		}
	}

	private String getFlagDelete(){
		
		if ( this.isAguardandoCancelamentoNFSEPrefeitura() )
			return this.getFlagTransparence();
		else if ( this.isErroAoCancelarNFSEPrefeitura() )
			return this.getFlagTransparence();
		else if ( this.isNFSECanceladaPrefeitura() )
			return this.getFlagTransparence();
		else if ( this.isRPSEnviada() )
			return "actions/remove.png";
		else
			return this.getFlagTransparence();
	}
	
	private String getFlagViewNF(){
		return "actions/nf.png";
	}

	private String getFlagConsulta(){
		if ( this.isRPSEnviada() && isValidFile() )
			return "actions/view.png";
		else
			return this.getFlagTransparence();
	}
	
	public String getFlagTransparence(){
		return "actions/transparence.png";
	}


	/**
	 * @return the actionSelect
	 */
	public ImgButton getActionSelect() {
		return actionSelect;
	}


	/**
	 * @param actionSelect the actionSelect to set
	 */
	public void setActionSelect(ImgButton actionSelect) {
		this.actionSelect = actionSelect;
	}
	
	/**
	 * Retorna um objeto de toobar.
	 */
	public static ToolbarRecord getCreateOrObject(ListGridRecord record, ResultadoConsulta resultadoConsulta){
		ToolbarRecord comp = (ToolbarRecord)record.getAttributeAsObject(getFieldSelectNameComponent());
		if ( comp == null ) 
			comp = new ToolbarRecord(record, resultadoConsulta);

		return comp;
	}

	/**
	 * @return the layoutActionSelect
	 */
	public HLayout getLayoutActionSelect() {
		return layoutActionSelect;
	}

	/**
	 * @param layoutActionSelect the layoutActionSelect to set
	 */
	public void setLayoutActionSelect(HLayout layoutActionSelect) {
		this.layoutActionSelect = layoutActionSelect;
	}
	
	public void refreshToolsCancel(){
		record.setAttribute(getSelect(),"false");

		// Nestas situações mantem os dados da rps.
		if ( this.isAguardandoCancelamentoNFSEPrefeitura() || this.isErroAoCancelarNFSEPrefeitura() || this.isNFSECanceladaPrefeitura() ){			
		}
		else{
			record.setAttribute(getNrRPS(), "");
			record.setAttribute(getControl()  , "P" );
			record.setAttribute(getArquivoNF(), ""  );
			record.setAttribute("NrNfse", "");
		}		
		actionSelect.setSrc(this.getFlagSelect());  
		
		actionStatus.setSrc(this.getFlagRPSEnviada());  
		actionDelete.setSrc(this.getFlagDelete());  
		actionConsulta.setSrc(this.getFlagConsulta());  
	
		refreshPrompts();		
	}
	
	public void refreshTools(String[] row, ResultadoConsulta resultadoConsulta){
		record.setAttribute(getSelect(),"false");
		record.setAttribute(getControl(), resultadoConsulta.getFieldValue(row, this.getControl() ));
		record.setAttribute(getArquivoNF(),resultadoConsulta.getFieldValue(row, this.getArquivoNF() ));
		
		record.setAttribute("idNfse", resultadoConsulta.getFieldValue(row, "idNfse" ));
		record.setAttribute("IdAtividade", resultadoConsulta.getFieldValue(row, "IdAtividade" ));
		record.setAttribute("IconAtividade", resultadoConsulta.getFieldValue(row, "IconAtividade" ));
		record.setAttribute("NrNfse"  , resultadoConsulta.getFieldValue(row, "NrNfse" ));
		record.setAttribute(getNrRPS(), resultadoConsulta.getFieldValue(row, getNrRPS()));
		
		actionSelect.setSrc(this.getFlagSelect());  
		
		actionStatus.setSrc(this.getFlagRPSEnviada());  
		actionDelete.setSrc(this.getFlagDelete());  
		actionConsulta.setSrc(this.getFlagConsulta());  
	
		refreshPrompts();
	}
	
	public void refreshTools(ListGridRecord record, ResultadoConsulta resultadoConsulta){
		actionSelect.setSrc(this.getFlagSelect());  
		actionStatus.setSrc(this.getFlagRPSEnviada());  
			
		actionDelete.setSrc(this.getFlagDelete());
		actionConsulta.setSrc(this.getFlagConsulta()); 
		refreshPrompts();
	}	
	
	public void refreshPrompts(){

		if ( isRPSEnviada() ){
			if(  isOS() )
				actionStatus.setPrompt(Tradutor.i18n.promptStatusEnvioOS());
			else if ( this.resultadoConsulta.isWebService() ){
				if ( isPrefeituraOK() )
					actionStatus.setPrompt(Tradutor.i18n.promptStatusEnvioWSOK());
				else if ( isPrefeituraError() )
					actionStatus.setPrompt(Tradutor.i18n.promptStatusEnvioWSErro());					
				else
					actionStatus.setPrompt(Tradutor.i18n.promptStatusEnvioWS());
			}
			else if ( this.resultadoConsulta.isArquivoRemessa() )
				actionStatus.setPrompt(Tradutor.i18n.promptStatusEnvioRemessa());
		}
		else{
			if ( this.resultadoConsulta.isArquivoRemessa() )
				actionStatus.setPrompt(Tradutor.i18n.promptStatusEnvioPendenteArqRemessa());			
			else
				actionStatus.setPrompt(Tradutor.i18n.promptStatusEnvioPendente());			
		}

		if ( isNFSECanceladaPrefeitura() || isErroAoCancelarNFSEPrefeitura() || isAguardandoCancelamentoNFSEPrefeitura() ){
			actionDelete.setPrompt("");			
			actionDelete.setCursor(Cursor.POINTER);
		}
		else if ( isRPSEnviada() ){
			if ( this.resultadoConsulta.isArquivoRemessa() )
				actionDelete.setPrompt(Tradutor.i18n.promptExcluirItemRemessa());
			else
				actionDelete.setPrompt(Tradutor.i18n.promptExcluirEnvio());
			actionDelete.setCursor(Cursor.HAND);
		}
		else{
			actionDelete.setPrompt("");
			actionDelete.setCursor(Cursor.POINTER);
		}
			
		if ( isRPSEnviada() )
			this.actionSelect.setPrompt("");
		else{
			if( "true".equalsIgnoreCase(record.getAttribute(getSelect())) )
					this.actionSelect.setPrompt(Tradutor.i18n.promptSelecionado());
			else
				this.actionSelect.setPrompt(Tradutor.i18n.promptNaoSelecionado());					
		}
		
		if ( isRPSEnviada() && isValidFile() ){
			if ( this.isOS() )
				actionConsulta.setPrompt(Tradutor.i18n.promptVisualizarAruivoXML());
			else if ( this.resultadoConsulta.isArquivoRemessa() )			
				actionConsulta.setPrompt(Tradutor.i18n.promptVisualizarArquivoRemessa());
			else if ( this.resultadoConsulta.isG2ka() )
				actionConsulta.setPrompt(Tradutor.i18n.promptVisualizarArquivoRemessa());
			else
				actionConsulta.setPrompt(Tradutor.i18n.promptConsultarStatusRPS());
		}
		else
			actionConsulta.setPrompt("");
		
		if ( getResultadoConsulta().isG2ka() ){
			actionStatus.setPrompt("Consultar Status");
		}
		
		refreshDownload();
	}
	
	public void refreshDownload(){
		if ( 	
				isRPSEnviada() 
				&& 
				isValidFile()

		){
			this.actionDonwload.setFileName(getRealNomeArquivoNF());
			this.actionDonwload.showDownload();
			this.actionDonwload.getActionDownload().setPrompt(Tradutor.i18n.downloadArquivo());
		}
		else{
			this.actionDonwload.setFileName("");
			this.actionDonwload.hiddenDownload();			
			this.actionDonwload.getActionDownload().setPrompt("");
		}
	}

	/**
	 * @return retorna true o arquivo na nota é válido.
	 */
	public boolean isValidFile(){
		return  getNomeArquivoNF() != null 
				&& 
				getNomeArquivoNF().trim().length() > 0 
				&& 
				(
						getNomeArquivoNF().indexOf(".xml") > 0
						|| 
						getNomeArquivoNF().indexOf(".txt") > 0 
				);		
	}
	
	/**
	 * @return the actionDonwload
	 */
	public HowMGWTImgButtonDonwload getActionDonwload() {
		return actionDonwload;
	}

	/**
	 * @param actionDonwload the actionDonwload to set
	 */
	public void setActionDonwload(HowMGWTImgButtonDonwload actionDonwload) {
		this.actionDonwload = actionDonwload;
	}

 
 

	/**
	 * @return the resultadoConsulta
	 */
	public ResultadoConsulta getResultadoConsulta() {
		return resultadoConsulta;
	}
 
	/**
	 * @param resultadoConsulta the resultadoConsulta to set
	 */
	public void setResultadoConsulta(ResultadoConsulta resultadoConsulta) {
		this.resultadoConsulta = resultadoConsulta;
	}

	public boolean isErroAoCancelarNFSEPrefeitura(){
		return getIdAtividade() != null && (new Integer(getIdAtividade())).intValue() == eConstants.ATIVIDADE_ERRO_AO_CANCELAR_NFSE_NA_PREFEITURA;
	}
	
	public boolean isNFSECanceladaPrefeitura(){
		return getIdAtividade() != null && (new Integer(getIdAtividade())).intValue() == eConstants.ATIVIDADE_NFSE_CANCELADA_NA_PREFEITURA;
	}
	
	public boolean isAguardandoCancelamentoNFSEPrefeitura(){
		return getIdAtividade() != null && (new Integer(getIdAtividade())).intValue() == eConstants.ATIVIDADE_AGUARDANDO_CANCELAMENTO_NFSE_NA_PREFEITURA;
	}
	
	public boolean isPrefeituraOK(){
		return getIdAtividade() != null && (new Integer(getIdAtividade())).intValue() == eConstants.ATIVIDADE_NOTA_FISCAL_ELETRONICA_GERADA_NA_PREFEITURA;
	}

	public boolean isPrefeituraError(){
		return getIdAtividade() != null && (new Integer(getIdAtividade())).intValue() == eConstants.ATIVIDADE_ERRO_AO_PROCESSAR_RPS_NA_PREFEITURA;
	}	
	
	
	/**
	 * Verfica se o usuório pode realizar o cancelamento do lote de RPS.
	 * @param record
	 */
	public void verificaCancelamento(){
		String sql = "";
		sql += "SELECT ";
		sql += "      vd_nfse_nota_fiscal.id_protocolo ";
		sql += "FROM ";
		sql += "     vd_nfse_nota_fiscal ";
		sql += "     left outer join vd_nfse_atividade ";
		sql += "          on ";
		sql += "          vd_nfse_atividade.id_atividade = vd_nfse_nota_fiscal.id_atividade ";
		sql += "WHERE ";
		sql += "    vd_nfse_nota_fiscal.cod_empresa 	= "+Configuracao.getCodEmpresa()+" ";
		sql += "    and ";
		sql += "    vd_nfse_nota_fiscal.cod_nota_fiscal = "+record.getAttribute(getCodNumeroNF());
		sql += "";
		
		HOWMGWTDataSourceQuery.executeQuery(sql, new HowMGWTCallImpl() {
			
			@Override
			public void onSuccess(HowMGWTEntity result) {
				if ( result.getData() != null && result.getData().size() > 0 ){
					verificaCancelamentoProtocolo(record,result.getData().get(0)[0]);					
				}
				else
					verificaCancelamentoProtocolo(record,null);					
			}
		});
	}

	/**
	 * Verfica se o usuório pode realizar o cancelamento do lote de RPS.
	 * @param record
	 */
	public void verificaCancelamentoProtocolo(final ListGridRecord record , String nrProtocolo){
		// Se tiver protocolo informado, verifica o protocolo utilizado para o envio.
		if ( nrProtocolo != null ){
			HOWMGWTDataSourceQuery.executeQuery(eNFSEProtocolo.getSqlSelect(nrProtocolo), new HowMGWTCallImpl() {				
				@Override
				public void onSuccess(HowMGWTEntity result) {				
					if ( result.getData().size() > 0 ){
						eNFSEProtocolo protocolo = protocolo = eNFSEProtocolo.parser(result.getData().get(0));
						confirmaCancelamento(record, protocolo);
					}
					else
						confirmaCancelamento(record, null);
				}
			});
		}
		else
			confirmaCancelamento(record, null);
	}
	
	
	/**
	 * Solicita a confirmação do cancelamento do lote da RPS enviada para a prefeitura.
	 * @param recordGrid
	 * @param resultProtocolo
	 */
	public void confirmaCancelamento(ListGridRecord  recordGrid , eNFSEProtocolo protocolo){

		String msg = "";
		Integer idProtocolo = null;
		
		if ( protocolo != null && protocolo.getQtdeNFs() > 0 ){
			
			idProtocolo = protocolo.getIdProtocolo();
			
			msg += "<pre>";
			if ( protocolo.getQtdeNFs() > 1 ){
				msg += Tradutor.i18n.msgExcluiLoteEnvio();
				msg += "<hr>";
			}
			
			msg += Tradutor.i18n.formProtocoloUCommerce()+" : <b>"+protocolo.getIdProtocolo()+"</b><br>";
			msg += Tradutor.i18n.formColaboradorEnvio()+"   : <b>"+protocolo.getNomeColaborador()+"</b><br>";

			DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("dd/MM/yyyy HH:mi:ss");
			
			msg += Tradutor.i18n.formDataHoraEnvio()+"     : <b>"+dateTimeFormat.format(protocolo.getDataInclusao()) +"</b><br>";
			if ( ! HowMGWTUtilities.isEmpty(protocolo.getCodProtocoloPrefeitura()))
				msg += Tradutor.i18n.formProtocoloPrefeitura()+": <b>"+protocolo.getCodProtocoloPrefeitura()+"</b><br>";

			msg += Tradutor.i18n.formPadrao()+"              : <b>"+protocolo.getNomeModeloIntegracao()+"</b><br>" ;

			msg += Tradutor.i18n.formQtdeNotaLote()+": <b><font color=red>"+protocolo.getQtdeNFs()+"</font></b>";
			
			//                                [Padrão              : ]
			//                                [Qtde de Nota no Lote: ]

			msg += "<hr>";
		}

		final eNFSEProtocolo eProtocolo = protocolo;
		
		if ( resultadoConsulta.isArquivoRemessa() ){
			if ( protocolo != null && protocolo.getQtdeNFs() > 0 )			
				msg += Tradutor.i18n.confirmExcluirLoteRemessa();
			
			else
				msg += Tradutor.i18n.confirmExcluirItemRemessa();
		}
		else{
			if ( protocolo != null && protocolo.getQtdeNFs() > 0 ){
				if ( this.getResultadoConsulta().isG2ka() && ! HowMGWTUtilities.isEmpty(recordGrid.getAttribute(getResultadoConsulta().fieldNrNfse.getName())))
					msg += HowMGWTUtilities.replace(Tradutor.i18n.confirmCancelamentoNFSePrefeitura(),"#NFSE","<B>"+recordGrid.getAttribute(getResultadoConsulta().fieldNrNfse.getName())+"</B>");
				
				else				
					msg += Tradutor.i18n.confirmExcluirLoteEnvio();
			}
			else
				msg += Tradutor.i18n.confirmExcluirEnvio();
		}
		msg += "</pre>";
		if ( this.getResultadoConsulta().isG2ka() && ! HowMGWTUtilities.isEmpty(recordGrid.getAttribute(getResultadoConsulta().fieldNrNfse.getName()))){
			if ( windowConfirmar == null ){
				this.windowConfirmar = new WindowConfirmar(Tradutor.i18n.formInformeMotivoCancelamento());
				this.windowConfirmar.getActionConfirmar().addClickHandler(new ClickHandler() {			
					public void onClick(ClickEvent event) {
						deleteRecord(eProtocolo);
					}
				});
								
			}
			this.windowConfirmar.confirme(490, 250, msg);
		}
		else{		
			SC.confirm(msg, new BooleanCallback() {
				@Override
				public void execute(Boolean value) {
					if ( value.booleanValue() )
						resultadoConsulta.excluir(record, eProtocolo);
				}
			});
		}
	}	
	
	
	public void deleteRecord(eNFSEProtocolo eProtocolo){
		if ( HowMGWTUtilities.isEmpty( windowConfirmar.getMotivo()) ){
			SC.say(Tradutor.i18n.msgObrigatorioInformarMotivoCancelamento());
			return;
		}
		else if ( windowConfirmar.getMotivo().length() < 15 ){
			SC.say(Tradutor.i18n.msgInformeMotivoCancelamentoMais15Caracters());
			return;
		}
		else{
			eProtocolo.setMotivoCancelamento(windowConfirmar.getMotivo());
			resultadoConsulta.excluir(record, eProtocolo);
			windowConfirmar.hide();							
		}		
	}
}