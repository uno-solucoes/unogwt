package com.br.client.panel.vd.vdp0001.UI;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.Services;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.howmake.client.HowMProxyServiceAsync;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.types.MultipleAppearance;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


public class FiltroConsulta extends VLayout{ 
 
	private LinkedHashMap<String, String[]> mapGrupos;
	
	private SumarioVendas sumarioVendas;
	
	private DateItem  periodoInicial = new DateItem();
	private DateItem  periodoFinal   = new DateItem();
    private SelectItem grupoVendas   = new SelectItem();
    private SelectItem vendedores    = new SelectItem();
    
    private IButton actionImprimir = new IButton(Tradutor.i18n.formImprimir());
    
    private IButton actionBuscar   = new IButton(Tradutor.i18n.buscar());  
    
    private CheckboxItem onMonitor = new CheckboxItem();  
    private TextItem secundsAutoMonitor = new TextItem("secunds",Tradutor.i18n.formEmSegundos());
    
    public FiltroConsulta(){
    	initUI();
    }
    
    public void initUI(){
 
    	secundsAutoMonitor.setValue("30");
    	secundsAutoMonitor.setLength(3);
    	secundsAutoMonitor.setInputFormat("##0");
    	secundsAutoMonitor.setMask("##0");
    	secundsAutoMonitor.setWidth("30px");
    	secundsAutoMonitor.setCellStyle("width:30px");
    	secundsAutoMonitor.setShowTitle(false);


    	actionBuscar.setIcon("actions/search.png");
    	actionImprimir.setIcon("actions/print.png");
    	

    	onMonitor.setName("onMonitor");  
        onMonitor.setTitle(Tradutor.i18n.formAutoAtualizar());  
        onMonitor.setRedrawOnChange(true);  
        onMonitor.setWidth(50);
        onMonitor.setTitleVAlign(VerticalAlignment.CENTER);
        onMonitor.setValue(false);
        
    	periodoInicial.setTitle(Tradutor.i18n.periodoInicial());
    	periodoInicial.setEndDate( HowMGWTUtilities.getDate( "2099-12-31" ) );
    	
    	periodoFinal.setTitle(Tradutor.i18n.periodoFinal());
    	periodoFinal.setEndDate( HowMGWTUtilities.getDate( "2099-12-31" ) );
    	
    	grupoVendas.setTitle(Tradutor.i18n.grupoVendas());
    	grupoVendas.setMultiple(true);
    	grupoVendas.setMultipleAppearance(MultipleAppearance.PICKLIST);
    	grupoVendas.setWidth("100%");
    	grupoVendas.setValueMap();
    	
    	vendedores.setTitle(Tradutor.i18n.vendedores());
    	vendedores.setMultiple(true);
    	vendedores.setMultipleAppearance(MultipleAppearance.PICKLIST);
    	vendedores.setWidth("100%");
    	vendedores.setValueMap();
    	
    	DynamicForm fDataInicial = new DynamicForm();
    	fDataInicial.setWidth("300px");
    	fDataInicial.setItems(periodoInicial);
    	
    	DynamicForm fDataFinal = new DynamicForm();
    	fDataFinal.setWidth("300px");
    	fDataFinal.setItems(periodoFinal);
    	
    	HLayout layoutGrupoVendedores = new HLayout();
    	layoutGrupoVendedores.setWidth100();
    	
    	DynamicForm fGrupos = new DynamicForm();
    	fGrupos.setItems(grupoVendas);
    	fGrupos.setWidth("300px");
    	layoutGrupoVendedores.addMember(fGrupos);
    	
    	DynamicForm fVendedores = new DynamicForm();
    	fVendedores.setItems(vendedores);
    	fVendedores.setWidth("400px");
    	layoutGrupoVendedores.addMember(fVendedores);

    	DynamicForm fOnMonitor = new DynamicForm();
    	fOnMonitor.setItems(onMonitor);

    	DynamicForm fSecundsAutoMonitor = new DynamicForm();
    	fSecundsAutoMonitor.setWidth("30px");
    	fSecundsAutoMonitor.setItems(secundsAutoMonitor);

    	actionBuscar.setWidth("100px");

    	HTMLPane labelSecunds = new HTMLPane();
    	labelSecunds.setContents(Tradutor.i18n.formEmSegundos());
    	labelSecunds.setHeight("24px");
    	labelSecunds.setMargin(4);
    	
    	HLayout layoutDatas = new HLayout();
    	layoutDatas.setWidth100();
    	
    	layoutDatas.addMember(fDataInicial);
    	layoutDatas.addMember(fDataFinal);
    	layoutDatas.addMember(actionBuscar);
    	layoutDatas.addMember(actionImprimir);
    	layoutDatas.addMember(fOnMonitor);
    	layoutDatas.addMember(fSecundsAutoMonitor);
    	layoutDatas.addMember(labelSecunds);
    	
    	
    	this.addMember(layoutDatas);
    	this.addMember(layoutGrupoVendedores);
    	
    	
        grupoVendas.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {

				Timer timer = new Timer() {
					
					@Override
					public void run() {
						refreshVendedores();
					}
				};
				timer.schedule(50);
			}
		});  
    
        
        
        this.vendedores.setShowAllOptions(true);
        
    }

	/**
	 * @return the periodoInicial
	 */
	public DateItem getPeriodoInicial() {
		return periodoInicial;
	}

	/**
	 * @param periodoInicial the periodoInicial to set
	 */
	public void setPeriodoInicial(DateItem periodoInicial) {
		this.periodoInicial = periodoInicial;
	}

	/**
	 * @return the periodoFinal
	 */
	public DateItem getPeriodoFinal() {
		return periodoFinal;
	}

	/**
	 * @param periodoFinal the periodoFinal to set
	 */
	public void setPeriodoFinal(DateItem periodoFinal) {
		this.periodoFinal = periodoFinal;
	}

	/**
	 * @return the grupoVendas
	 */
	public SelectItem getGrupoVendas() {
		return grupoVendas;
	}

	/**
	 * @param grupoVendas the grupoVendas to set
	 */
	public void setGrupoVendas(SelectItem grupoVendas) {
		this.grupoVendas = grupoVendas;
	}

	/**
	 * @return the vendedores
	 */
	public SelectItem getVendedores() {
		return vendedores;
	}

	/**
	 * @param vendedores the vendedores to set
	 */
	public void setVendedores(SelectItem vendedores) {
		this.vendedores = vendedores;
	}

	/**
	 * @return the actionBuscar
	 */
	public IButton getActionBuscar() {
		return actionBuscar;
	}

	/**
	 * @param actionBuscar the actionBuscar to set
	 */
	public void setActionBuscar(IButton actionBuscar) {
		this.actionBuscar = actionBuscar;
	}	
	
	public void popularGrupos(){
	 
			AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
				public void onFailure(Throwable caught) {
					caught.printStackTrace();
					com.google.gwt.user.client.Window.alert(caught.getMessage());
					com.google.gwt.user.client.Window.alert(caught.getMessage());
				}

				public void onSuccess(HowMGWTEntity result) {
					if ( result.getThrowable() != null ){
						com.google.gwt.user.client.Window.alert(result.getThrowable().toString());
					}
					else
					  showResultGrupos(result);
				}
			};

			HowMGWTEntity entity = Fabrica.createEntity();
			
			HowMProperty pAcao = new HowMProperty("acao","buscaGrupo");
			entity.getParameters().put(pAcao.getName(), pAcao);
 
			
			entity.setAction(Services.acaoVDP0001);
			Configuracao.getProxyStruts().executeQuery(entity, callback);	
	}
	
	public void refreshVendedores(){
		String grupo = this.grupoVendas.getValueAsString();
		if ( grupo == null || grupo.trim().length() == 0 ){
			vendedores.setValueMap();
			return;
		}
		
		// Recupera os grupos selecionados
		String[] grupos = grupo.split(",");
		
		// Percorre a lista de grupos selecionados.
		ArrayList<String> vendedores = new ArrayList<String>();
		for ( String g : grupos ){
			// procura pelo grupo no mapa
			Object oVendedores = this.mapGrupos.get(g);
			// verifica se encontrou a lista de vendedores do grupo.
			if ( oVendedores != null ){
				String[] sVendedores = (String[])oVendedores;
				// carrega os vendedores para a lista.
				for ( String enumVendedores : sVendedores){
					vendedores.add(enumVendedores);
				}
			}
		}
		// Converte a lista para um array de strings
		String[] sVendedores = new String[vendedores.size()];
		for ( int i = 0 ; i < vendedores.size() ; i++  )
			sVendedores[i] = vendedores.get(i);

		this.vendedores.setValueMap(sVendedores);
	}
	
	public void showResultGrupos(HowMGWTEntity entity){
		  
		mapGrupos = new LinkedHashMap<String, String[]>();
		
		String[] grupos = new String[entity.getData().size()];
		
		String grupo;
		int countGrupos = 0;
		for ( String row[] : entity.getData() ){;
			if ( row.length > 0 ){
				grupo = row[0];
				
				String[] vendedores = new String[row.length-1];
				for ( int j = 1 ; j < row.length ; j ++){
					vendedores[j-1] = row[j];	
				}
				mapGrupos.put(grupo, vendedores);
				grupos[countGrupos] = grupo;
				countGrupos ++;
			}
		}
		
		HowMProperty pDataInicio = entity.getParameters().get("dataInicio");
		HowMProperty pDataFim = entity.getParameters().get("dataFim");
		
		if ( pDataInicio != null )
			this.periodoInicial.setValue(pDataInicio.getValueDate());
		
		if ( pDataFim != null )
			this.periodoFinal.setValue(pDataFim.getValueDate());
		
		sumarioVendas.showResult(entity);
		this.grupoVendas.setValueMap(grupos);
	}
	
	
	
	public void popularVendedores(){
		
	}

	/**
	 * @return the actionImprimir
	 */
	public IButton getActionImprimir() {
		return actionImprimir;
	}

	/**
	 * @param actionImprimir the actionImprimir to set
	 */
	public void setActionImprimir(IButton actionImprimir) {
		this.actionImprimir = actionImprimir;
	}

	/**
	 * @return the onMonitor
	 */
	public CheckboxItem getOnMonitor() {
		return onMonitor;
	}

	/**
	 * @param onMonitor the onMonitor to set
	 */
	public void setOnMonitor(CheckboxItem onMonitor) {
		this.onMonitor = onMonitor;
	}

	/**
	 * @return the secundsAutoMonitor
	 */
	public TextItem getSecundsAutoMonitor() {
		return secundsAutoMonitor;
	}

	/**
	 * @param secundsAutoMonitor the secundsAutoMonitor to set
	 */
	public void setSecundsAutoMonitor(TextItem secundsAutoMonitor) {
		this.secundsAutoMonitor = secundsAutoMonitor;
	}

	/**
	 * @return the sumarioVendas
	 */
	public SumarioVendas getSumarioVendas() {
		return sumarioVendas;
	}

	/**
	 * @param sumarioVendas the sumarioVendas to set
	 */
	public void setSumarioVendas(SumarioVendas sumarioVendas) {
		this.sumarioVendas = sumarioVendas;
	}

 
	
}
