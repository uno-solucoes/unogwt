package com.br.client.panel.sg.sgq0014.UI;

import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.business.UI.UCFieldSituacaoColaborador;
import com.howmake.client.form.UI.HowMGWTTextItem;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

public class FiltroConsulta  extends VLayout{ 
 
    
    private HowMGWTTextItem fieldCodColaborador 	= new HowMGWTTextItem("codigoCliente", 	Tradutor.i18n.formCodigo()    );  
    private HowMGWTTextItem fieldNomeColaborador   	= new HowMGWTTextItem("nomeColaborador",Tradutor.i18n.formNome()   	  ); 
    private HowMGWTTextItem fieldCNPJ				= new HowMGWTTextItem("cnpj",          	Tradutor.i18n.formCnpj()      );
    private HowMGWTTextItem fieldIdUsuario   		= new HowMGWTTextItem("idUsuario",   	Tradutor.i18n.formIdUsuario() );
    
    private UCFieldSituacaoColaborador fieldSituacao= new UCFieldSituacaoColaborador();
    
    private HTMLPane paneHelp           			= new HTMLPane();
 
    
    
    public FiltroConsulta(){
    	initUI();
    }
    
    public void initUI(){
 
    	paneHelp.setBorder(Tradutor.i18n.msgBorder());
    	paneHelp.setBackgroundColor(Tradutor.i18n.msgColor());
    	paneHelp.setContents(Tradutor.i18n.msgLookupHelp());
 
    	fieldCodColaborador.setWidth100();
    	this.addMember(fieldCodColaborador);
    	
    	fieldNomeColaborador.setWidth100();
    	this.addMember(fieldNomeColaborador);
 
    	fieldIdUsuario.setWidth100();
    	this.addMember(fieldIdUsuario);
    	
    	fieldSituacao.setWidth100();
    	this.addMember(fieldSituacao);
    	
    	paneHelp.setWidth100();
    	this.addMember(paneHelp);

    	
    	// Carrega os dados da lista.
    	fieldSituacao.start();
    }

 
	/**
	 * @return the fieldCNPJ
	 */
	public HowMGWTTextItem getFieldCNPJ() {
		return fieldCNPJ;
	}

	/**
	 * @param fieldCNPJ the fieldCNPJ to set
	 */
	public void setFieldCNPJ(HowMGWTTextItem fieldCNPJ) {
		this.fieldCNPJ = fieldCNPJ;
	}

	/**
	 * @return the paneHelp
	 */
	public HTMLPane getPaneHelp() {
		return paneHelp;
	}

	/**
	 * @param paneHelp the paneHelp to set
	 */
	public void setPaneHelp(HTMLPane paneHelp) {
		this.paneHelp = paneHelp;
	}

	/**
	 * @return the fieldCodColaborador
	 */
	public HowMGWTTextItem getFieldCodColaborador() {
		return fieldCodColaborador;
	}

	/**
	 * @param fieldCodColaborador the fieldCodColaborador to set
	 */
	public void setFieldCodColaborador(HowMGWTTextItem fieldCodColaborador) {
		this.fieldCodColaborador = fieldCodColaborador;
	}

	/**
	 * @return the fieldNomeColaborador
	 */
	public HowMGWTTextItem getFieldNomeColaborador() {
		return fieldNomeColaborador;
	}

	/**
	 * @param fieldNomeColaborador the fieldNomeColaborador to set
	 */
	public void setFieldNomeColaborador(HowMGWTTextItem fieldNomeColaborador) {
		this.fieldNomeColaborador = fieldNomeColaborador;
	}

	/**
	 * @return the fieldIdUsuario
	 */
	public HowMGWTTextItem getFieldIdUsuario() {
		return fieldIdUsuario;
	}

	/**
	 * @param fieldIdUsuario the fieldIdUsuario to set
	 */
	public void setFieldIdUsuario(HowMGWTTextItem fieldIdUsuario) {
		this.fieldIdUsuario = fieldIdUsuario;
	}

	/**
	 * @return the fieldSituacao
	 */
	public UCFieldSituacaoColaborador getFieldSituacao() {
		return fieldSituacao;
	}

	/**
	 * @param fieldSituacao the fieldSituacao to set
	 */
	public void setFieldSituacao(UCFieldSituacaoColaborador fieldSituacao) {
		this.fieldSituacao = fieldSituacao;
	}
	
	
	public void clearFilters(){
	    fieldCodColaborador.setHowMValue("");  
	    fieldNomeColaborador.setHowMValue(""); 
	    fieldCNPJ.setHowMValue("");
	    fieldIdUsuario.setHowMValue("");
	    fieldSituacao.setHowMValue("");
	}
}
