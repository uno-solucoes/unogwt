package com.br.client.panel.vd.vdq0002.UI;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.UI.HowMGWTCheckboxItem;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.partner.HowMGWTConstants;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class FiltroConsultaPreferencias extends HowMGWTWindow{
	
	private FiltroConsulta filtroConsulta;
	
	private VLayout layout = new VLayout();
	private HowMGWTCheckboxItem fieldBuscaAproximada 	= new HowMGWTCheckboxItem("buscaProdutoAproximada", Tradutor.i18n.formBuscaProdutoAproximada());

	private HowMGWTCheckboxItem fieldBuscaProdutoPorCodigo 	= new HowMGWTCheckboxItem("formBuscaProdutoPorCodigo"	, Tradutor.i18n.formBuscaProdutoPorCodigo());
	private HowMGWTCheckboxItem fieldBuscaProdutoPorApelido = new HowMGWTCheckboxItem("formBuscaProdutoPorApelido"	, Tradutor.i18n.formBuscaProdutoPorApelido());

	
	private IButton actionConfirme = new IButton("Aplicar");
	
	public FiltroConsultaPreferencias(){
		this.setShowModalMask(true);
		this.setModalMaskOpacity(HowMGWTConstants.WINDOW_MODAL_MASK_OPACITY);
		this.setIsModal(true);
		
		this.setWidth("390px");
		this.setHeight("150px");
		
		layout.setWidth100();
		layout.setHeight100();
		
		fieldBuscaAproximada.getField().setValue(true);
		fieldBuscaAproximada.setHeight("20px");
		HLayout hbaLayout = new HLayout();
		hbaLayout.setWidth100();
		hbaLayout.setAlign(Alignment.LEFT);
		hbaLayout.addMember(fieldBuscaAproximada);
		hbaLayout.setHeight("20px");
		layout.addMember(hbaLayout);
		
		
		Label labelSelecao = new Label(Tradutor.i18n.formSelecioneAsOpcoesDeBusca());
		labelSelecao.setHeight("20px");
		labelSelecao.setWidth100();
		layout.addMember(labelSelecao);
		
		fieldBuscaProdutoPorApelido.setHeight("20px");
		fieldBuscaProdutoPorCodigo.setHeight("20px");

		HLayout hbppCodigoLayout = new HLayout();
		hbppCodigoLayout.setWidth100();
		hbppCodigoLayout.setAlign(Alignment.LEFT);
		hbppCodigoLayout.setHeight("20px");
		hbppCodigoLayout.addMember(fieldBuscaProdutoPorCodigo);
		layout.addMember(hbppCodigoLayout);
		
		
		HLayout hbppApelidoLayout = new HLayout();
		hbppApelidoLayout.setWidth100();
		hbppApelidoLayout.setAlign(Alignment.LEFT);
		hbppApelidoLayout.setHeight("20px");
		hbppApelidoLayout.addMember(fieldBuscaProdutoPorApelido);
		layout.addMember(hbppApelidoLayout);
		
		
		HLayout hLayout = new HLayout();
		hLayout.setHeight("26px");
		hLayout.setWidth100();
		hLayout.setAlign(Alignment.CENTER);
		hLayout.addMember(actionConfirme);
		actionConfirme.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				salvaPreferencias();
			}
		});
		
		
		layout.addMember(hLayout);
		
		this.addItem(layout);
		this.centerInPage();
	}

	@Override
	public String getHowMGWTPrograma() {
		return "VDQ0002p";
	}

	@Override
	public String getHowMGWTTitle() {
		// TODO Auto-generated method stub
		return Tradutor.i18n.formTituloVDQ0002p();
	}
	
	public void showPreferencias(boolean buscaAproximada, int buscaMultipla, FiltroConsulta filtroConsulta){
		this.filtroConsulta = filtroConsulta;
		this.fieldBuscaAproximada.getField().setValue(buscaAproximada);
		if ( buscaMultipla == FiltroConsulta.BUSCA_MULTIPLA){
			this.fieldBuscaProdutoPorApelido.getField().setValue(true);
			this.fieldBuscaProdutoPorCodigo.getField().setValue(true);
		}
		else if ( buscaMultipla == FiltroConsulta.BUSCA_MULTIPLA_COD_PRODUTO){
			this.fieldBuscaProdutoPorApelido.getField().setValue(false);
			this.fieldBuscaProdutoPorCodigo.getField().setValue(true);
		}
		else if ( buscaMultipla == FiltroConsulta.BUSCA_MULTIPLA_DESC_ABREV){
			this.fieldBuscaProdutoPorApelido.getField().setValue(true);
			this.fieldBuscaProdutoPorCodigo.getField().setValue(false);
		}
		this.show();
	}
	
	public void salvaPreferencias(){
		filtroConsulta.setBuscaAproximada(this.fieldBuscaAproximada.getField().getValueAsBoolean());
		if ( 
				this.fieldBuscaProdutoPorApelido.getField().getValueAsBoolean()
				&& 
				this.fieldBuscaProdutoPorCodigo.getField().getValueAsBoolean()
		)
			filtroConsulta.setBuscaMultipla(FiltroConsulta.BUSCA_MULTIPLA);
		else if ( this.fieldBuscaProdutoPorApelido.getField().getValueAsBoolean() )
			filtroConsulta.setBuscaMultipla(FiltroConsulta.BUSCA_MULTIPLA_DESC_ABREV);
		else if ( this.fieldBuscaProdutoPorCodigo.getField().getValueAsBoolean() )
			filtroConsulta.setBuscaMultipla(FiltroConsulta.BUSCA_MULTIPLA_COD_PRODUTO);
		else			
			filtroConsulta.setBuscaMultipla(FiltroConsulta.BUSCA_MULTIPLA_COD_PRODUTO);
		this.hide();
	}
}
