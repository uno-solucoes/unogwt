package com.br.client.panel.vd.vdp0001.UI;

 
import java.util.ArrayList;
import java.util.TreeMap;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.Services;
import com.br.client.panel.vd.vdp0001.model.RecordRelacaoVendas;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.GroupStartOpen;
import com.smartgwt.client.types.RecordSummaryFunctionType;
import com.smartgwt.client.types.SummaryFunctionType;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
 
public class RelacaoVendas extends ListGrid {
	
    private com.smartgwt.client.widgets.Window winModal = new com.smartgwt.client.widgets.Window();  
	
	private boolean executeTimer = false;
	
	private TreeMap<String, Integer> headerPositions = new TreeMap<String,Integer>();
	private ArrayList<ListGridField> headerFields = new ArrayList<ListGridField>();
	
	private int timerSecunds = 30;
	private Timer timer;
	private FiltroConsulta filtroConsulta;
	private SumarioVendas sumarioVendas;
	private ResumoVendas resumoVendas;
	
	private ListGridField grupo									= new ListGridField("Grupo", Tradutor.i18n.grupo(), 130);	
	private ListGridField vendedor								= new ListGridField("Vendedor", Tradutor.i18n.vendedor(), 160);
	private ListGridField valorOportunidade						= new ListGridField("valorOportunidade", Tradutor.i18n.valorOportunidade(), 100);		
	private ListGridField valorCotacoesEnviadasPorEmailDia		= new ListGridField("valorCotacoesEnviadasPorEmailDia",Tradutor.i18n.valorCotacoesEnviadasPorEmailDia(),100);
	private ListGridField qtdeCotacoesEnviadasPorEmMailDia		= new ListGridField("qtdeCotacoesEnviadasPorEmMailDia",  Tradutor.i18n.qtdeCotacoesEnviadasPorEmMailDia(), 80);
	private ListGridField qtdeCotacoesEnviadasPorEMailPeriodo	= new ListGridField("qtdeCotacoesEnviadasPorEMailPeriodo", Tradutor.i18n.qtdeCotacoesEnviadasPorEMailPeriodo(),100);
	private ListGridField valorCotacoesEnviadasPorEmailPeriodo	= new ListGridField("valorCotacoesEnviadasPorEmailPeriodo", Tradutor.i18n.valorCotacoesEnviadasPorEmailPeriodo(), 100);
	private ListGridField qtdeLigacoesDia						= new ListGridField("qtdeLigacoesDia", Tradutor.i18n.qtdeLigacoesDia(), 80);
	private ListGridField qtdeLigacoesPeriodo					= new ListGridField("qtdeLigacoesPeriodo", Tradutor.i18n.qtdeLigacoesPeriodo(), 80);
	private ListGridField qtdePedidosDia						= new ListGridField("qtdePedidosDia", Tradutor.i18n.qtdePedidosDia(), 80);
	private ListGridField qtdePedidosPeriodo					= new ListGridField("qtdePedidosPeriodo", Tradutor.i18n.qtdePedidosPeriodo(), 80);
	private ListGridField valorPedidoDia						= new ListGridField("valorPedidoDia", Tradutor.i18n.valorPedidoDia(), 100);
	private ListGridField valorPedidoPeriodo					= new ListGridField("valorPedidoPeriodo", Tradutor.i18n.valorPedidoPeriodo(), 100);
	private ListGridField mediaPedidos							= new ListGridField("mediaPedidos", Tradutor.i18n.mediaPedidos(), 100);
	private ListGridField ValorFaturadoDia						= new ListGridField("ValorFaturadoDia", Tradutor.i18n.valorFaturadoDia(), 100);
	
	private ListGridField mediaFaturadoDia						= new ListGridField("mediaFaturadoDia", Tradutor.i18n.mediaFaturadoDia(), 100);
	private ListGridField mediaFaturadoMes						= new ListGridField("mediaFaturadoMes", Tradutor.i18n.mediaFaturadoMes(), 100);
	private ListGridField percentualMes							= new ListGridField("percentualMes", Tradutor.i18n.percentualMes()+"&nbsp;&nbsp;&nbsp;&nbsp;", 100);
	
	public RelacaoVendas(){
		initConfigureWindowWait();
		initUI();
		initEntityControl();
	}

	public void initEntityControl(){

		grupo.setCanReorder(false);
		vendedor.setCanReorder(false);

		grupo.setFrozen(true);
		vendedor.setFrozen(true);
		
		for( int i = 0 ; i < this.getFields().length ; i ++){
			this.headerPositions.put(this.getFields()[i].getName(), new Integer(i));
			this.headerFields.add(this.getFields()[i]);
		};

	}
	
	public void initConfigureWindowWait(){
		winModal.setWidth(300);  
        winModal.setHeight(60);  

        winModal.setTitle(Tradutor.i18n.formEmProcessamento());
        winModal.setShowTitle(true);
        winModal.setShowHeader(true);
        winModal.setShowCloseButton(false);
        winModal.setShowMinimizeButton(false);  
        winModal.setIsModal(true);  
        // winModal.setShowModalMask(true);

        HTMLPanel htmlPanel = new HTMLPanel("<center><font>"+Tradutor.i18n.formAguardeProcessandoConsulta()+"</font></center>");
 
        winModal.addItem(htmlPanel);
	}
	
	public void initUI(){
		
		this.setDataPageSize(1000);
		grupo.setWrap(true);
		vendedor.setWrap(true);
		valorOportunidade.setWrap(true);
		valorCotacoesEnviadasPorEmailDia.setWrap(true);
		qtdeCotacoesEnviadasPorEmMailDia.setWrap(true);
		valorCotacoesEnviadasPorEmailPeriodo.setWrap(true);
		qtdeCotacoesEnviadasPorEMailPeriodo.setWrap(true);
		qtdeLigacoesDia.setWrap(true);
		qtdeLigacoesPeriodo.setWrap(true);
		qtdePedidosDia.setWrap(true);
		qtdePedidosPeriodo.setWrap(true);
		valorPedidoDia.setWrap(true);
		valorPedidoPeriodo.setWrap(true);
		mediaPedidos.setWrap(true);
		ValorFaturadoDia.setWrap(true);			
		mediaFaturadoDia.setWrap(true);
		mediaFaturadoMes.setWrap(true);
		percentualMes.setWrap(true);		
		
		valorOportunidade.setAlign(Alignment.RIGHT);
		valorCotacoesEnviadasPorEmailDia.setAlign(Alignment.RIGHT);
		qtdeCotacoesEnviadasPorEmMailDia.setAlign(Alignment.RIGHT);
		valorCotacoesEnviadasPorEmailPeriodo.setAlign(Alignment.RIGHT);
		qtdeCotacoesEnviadasPorEMailPeriodo.setAlign(Alignment.RIGHT);
		qtdeLigacoesDia.setAlign(Alignment.RIGHT);
		qtdeLigacoesPeriodo.setAlign(Alignment.RIGHT);
		qtdePedidosDia.setAlign(Alignment.RIGHT);
		qtdePedidosPeriodo.setAlign(Alignment.RIGHT);
		valorPedidoDia.setAlign(Alignment.RIGHT);
		valorPedidoPeriodo.setAlign(Alignment.RIGHT);
		mediaPedidos.setAlign(Alignment.RIGHT);
		ValorFaturadoDia.setAlign(Alignment.RIGHT);			
		mediaFaturadoDia.setAlign(Alignment.RIGHT);
		mediaFaturadoMes.setAlign(Alignment.RIGHT);
		percentualMes.setAlign(Alignment.RIGHT);
		
 
	 
		
		

		CellFormatter formatterDouble = new CellFormatter() {
	        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
	            if(value == null) return null;
	            try{
	            	return "R$ "+NumberFormat.getFormat("###,###,###,###,###,###,###.00").format(new Double(value.toString()));
	            }
	            catch(Throwable er){
	            	return "R$ "+value.toString();
	            }
	        }
		};
 
		valorPedidoPeriodo.setCellFormatter(formatterDouble);
		valorOportunidade.setCellFormatter(formatterDouble);
		valorCotacoesEnviadasPorEmailDia.setCellFormatter(formatterDouble);
		valorCotacoesEnviadasPorEmailPeriodo.setCellFormatter(formatterDouble);
		valorPedidoDia.setCellFormatter(formatterDouble);
		valorPedidoPeriodo.setCellFormatter(formatterDouble);		
		ValorFaturadoDia.setCellFormatter(formatterDouble);
		mediaFaturadoMes.setCellFormatter(formatterDouble);
		
		mediaPedidos.setCellFormatter(formatterDouble);
		mediaFaturadoDia.setCellFormatter(formatterDouble);
		
		CellFormatter formatterInteger = new CellFormatter() {
	        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
	            if(value == null) return null;
	            try{
	            	return NumberFormat.getFormat("###,###,###,###,###,###,##0").format(new Double(value.toString()));
	            }
	            catch(Throwable er){
	            	return value.toString();
	            }
	        }
		};		
		
		qtdeCotacoesEnviadasPorEmMailDia.setCellFormatter(formatterInteger);
		qtdeCotacoesEnviadasPorEMailPeriodo.setCellFormatter(formatterInteger);
		qtdeLigacoesDia.setCellFormatter(formatterInteger);
		qtdeLigacoesPeriodo.setCellFormatter(formatterInteger);
		qtdePedidosDia.setCellFormatter(formatterInteger);
		qtdePedidosPeriodo.setCellFormatter(formatterInteger);

		
		CellFormatter formatterPercentual = new CellFormatter() {
	        public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
	            if(value == null) return null;
	            try{
	            	return NumberFormat.getFormat("###,##0.00").format(new Double(value.toString())) + " %";
	            }
	            catch(Throwable er){
	            	return value.toString()+" %";
	            }
	        }
		};

		percentualMes.setCellFormatter(formatterPercentual);
		
		valorPedidoPeriodo.setAttribute("DataType", "ND");
		valorOportunidade.setAttribute("DataType", "ND");
		valorCotacoesEnviadasPorEmailDia.setAttribute("DataType", "ND");
		valorCotacoesEnviadasPorEmailPeriodo.setAttribute("DataType", "ND");
		valorPedidoDia.setAttribute("DataType", "ND");
		valorPedidoPeriodo.setAttribute("DataType", "ND");
		mediaPedidos.setAttribute("DataType", "ND");
		ValorFaturadoDia.setAttribute("DataType", "ND");
		mediaFaturadoDia.setAttribute("DataType", "ND");
		mediaFaturadoMes.setAttribute("DataType", "ND");
		percentualMes.setAttribute("DataType", "ND");	
	
		qtdeCotacoesEnviadasPorEmMailDia.setAttribute("DataType", "NI");
		qtdeCotacoesEnviadasPorEMailPeriodo.setAttribute("DataType", "NI");
		qtdeLigacoesDia.setAttribute("DataType", "NI");
		qtdeLigacoesPeriodo.setAttribute("DataType", "NI");
		qtdePedidosDia.setAttribute("DataType", "NI");
		qtdePedidosPeriodo.setAttribute("DataType", "NI");

		
		
		
		valorPedidoPeriodo.setSummaryFunction(SummaryFunctionType.SUM);
		valorOportunidade.setSummaryFunction(SummaryFunctionType.SUM);
		valorCotacoesEnviadasPorEmailDia.setSummaryFunction(SummaryFunctionType.SUM);
		valorCotacoesEnviadasPorEmailPeriodo.setSummaryFunction(SummaryFunctionType.SUM);
		valorPedidoDia.setSummaryFunction(SummaryFunctionType.SUM);
		valorPedidoPeriodo.setSummaryFunction(SummaryFunctionType.SUM);
		mediaPedidos.setSummaryFunction(SummaryFunctionType.SUM);
		ValorFaturadoDia.setSummaryFunction(SummaryFunctionType.SUM);
		mediaFaturadoDia.setSummaryFunction(SummaryFunctionType.SUM);
		mediaFaturadoMes.setSummaryFunction(SummaryFunctionType.SUM);
		percentualMes.setSummaryFunction(SummaryFunctionType.SUM);
	
		qtdeCotacoesEnviadasPorEmMailDia.setSummaryFunction(SummaryFunctionType.SUM);
		qtdeCotacoesEnviadasPorEMailPeriodo.setSummaryFunction(SummaryFunctionType.SUM);
		qtdeLigacoesDia.setSummaryFunction(SummaryFunctionType.SUM);
		qtdeLigacoesPeriodo.setSummaryFunction(SummaryFunctionType.SUM);
		qtdePedidosDia.setSummaryFunction(SummaryFunctionType.SUM);
		qtdePedidosPeriodo.setSummaryFunction(SummaryFunctionType.SUM);
		
		
		
		
		valorPedidoPeriodo.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
		valorOportunidade.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
		valorCotacoesEnviadasPorEmailDia.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
		valorCotacoesEnviadasPorEmailPeriodo.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
		valorPedidoDia.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
		valorPedidoPeriodo.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
		mediaPedidos.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
		ValorFaturadoDia.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
		mediaFaturadoDia.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
		mediaFaturadoMes.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
		percentualMes.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
	
		qtdeCotacoesEnviadasPorEmMailDia.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
		qtdeCotacoesEnviadasPorEMailPeriodo.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
		qtdeLigacoesDia.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
		qtdeLigacoesPeriodo.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
		qtdePedidosDia.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
		qtdePedidosPeriodo.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
 
 
		
		valorPedidoPeriodo.setShowGridSummary(true);  
		valorOportunidade.setShowGridSummary(true);  
		valorCotacoesEnviadasPorEmailDia.setShowGridSummary(true);  
		valorCotacoesEnviadasPorEmailPeriodo.setShowGridSummary(true);  
		valorPedidoDia.setShowGridSummary(true);  
		valorPedidoPeriodo.setShowGridSummary(true);  
		mediaPedidos.setShowGridSummary(true);  
		ValorFaturadoDia.setShowGridSummary(true);  
		mediaFaturadoDia.setShowGridSummary(true);  
		mediaFaturadoMes.setShowGridSummary(true);  
		percentualMes.setShowGridSummary(true);  
	
		qtdeCotacoesEnviadasPorEmMailDia.setShowGridSummary(true);  
		qtdeCotacoesEnviadasPorEMailPeriodo.setShowGridSummary(true);  
		qtdeLigacoesDia.setShowGridSummary(true);  
		qtdeLigacoesPeriodo.setShowGridSummary(true);  
		qtdePedidosDia.setShowGridSummary(true);  
		qtdePedidosPeriodo.setShowGridSummary(true);  
	 
		
		
		
		valorPedidoPeriodo.setShowGroupSummary(true); 	
		valorOportunidade.setShowGroupSummary(true); 	
		valorCotacoesEnviadasPorEmailDia.setShowGroupSummary(true); 	 
		valorCotacoesEnviadasPorEmailPeriodo.setShowGroupSummary(true); 	
		valorPedidoDia.setShowGroupSummary(true); 	
		valorPedidoPeriodo.setShowGroupSummary(true); 	
		mediaPedidos.setShowGroupSummary(true); 	
		ValorFaturadoDia.setShowGroupSummary(true); 	
		mediaFaturadoDia.setShowGroupSummary(true); 	
		mediaFaturadoMes.setShowGroupSummary(true); 	
		percentualMes.setShowGroupSummary(true); 	
	
		qtdeCotacoesEnviadasPorEmMailDia.setShowGridSummary(true);  
		qtdeCotacoesEnviadasPorEMailPeriodo.setShowGridSummary(true);  
		qtdeLigacoesDia.setShowGridSummary(true);  
		qtdeLigacoesPeriodo.setShowGridSummary(true);  
		qtdePedidosDia.setShowGridSummary(true);  
		qtdePedidosPeriodo.setShowGridSummary(true);  		
	  
		this.setFields(
				grupo,
				vendedor,
				valorOportunidade,	
				valorCotacoesEnviadasPorEmailDia,
				qtdeCotacoesEnviadasPorEmMailDia,
				qtdeCotacoesEnviadasPorEMailPeriodo,
				valorCotacoesEnviadasPorEmailPeriodo,
				qtdeLigacoesDia,
				qtdeLigacoesPeriodo,
				qtdePedidosDia,
				qtdePedidosPeriodo,
				valorPedidoDia,
				valorPedidoPeriodo,
				mediaPedidos,
				ValorFaturadoDia,				
				mediaFaturadoDia,
				mediaFaturadoMes,
				percentualMes
		);
		
		this.setCanResizeFields(true);   
		
		this.setHeaderHeight(50);
		this.setShowAllRecords(true); 

		this.setGroupByField("Grupo");  
        this.setGroupStartOpen(GroupStartOpen.ALL);   
        this.setShowGridSummary(true);  
        this.setShowGroupSummary(true);  		
	}
 
    @Override  
    protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {  
        if ( // Azul
    		getFieldName(colNum).equals("valorCotacoesEnviadasPorEmailDia") 
    		||
    		getFieldName(colNum).equals("qtdeCotacoesEnviadasPorEmMailDia") 
    		||
    		getFieldName(colNum).equals("valorCotacoesEnviadasPorEmailPeriodo") 
    		||
    		getFieldName(colNum).equals("qtdeCotacoesEnviadasPorEMailPeriodo") 
        )   
        	return "color:blue;";  
        else if ( // Verde
    		getFieldName(colNum).equals("qtdeLigacoesDia") 
    		||
    		getFieldName(colNum).equals("qtdeLigacoesPeriodo")
        )   
        	return "color:green;";  
        else if ( // vermelho
        		getFieldName(colNum).equals("qtdePedidosDia") 
        		||
        		getFieldName(colNum).equals("qtdePedidosPeriodo")
        		||
        		getFieldName(colNum).equals("valorPedidoDia")
        		||
        		getFieldName(colNum).equals("valorPedidoPeriodo")
        		||
        		getFieldName(colNum).equals("mediaPedidos")
        		||
        		getFieldName(colNum).equals("qtdePedidosPeriodo")
        		||
        		getFieldName(colNum).equals("qtdePedidosPeriodo")        		
        )   
            	return "color:red;"; 
    	
        else 
            return super.getCellCSSText(record, rowNum, colNum);  
    }  
    
   
	
	public void showResult(HowMGWTEntity result ){
		
		ListGridRecord[] records = new ListGridRecord[result.getData().size()];
		 
		RecordRelacaoVendas record;
		int i = 0;
		for ( String[] row : result.getData()){
			record = new RecordRelacaoVendas(headerFields, row);
			records[i] = record;
			i ++;
		}
		this.setData(records);
		
		this.getSumarioVendas().showResult(result);
		this.getResumoVendas().showResult(result);
		
		this.show();
		


		// Se a execução da consulta foi disparada pelo timer, então não mostra 
		//o alerta ao usuório.
		if( ! executeTimer ){
			if ( result.getData().size() == 0){
				winModal.hide();
				Window.alert(Tradutor.i18n.alertNaoEncontrouRegistros());
			}
			else{
				hideWindowWait();
			}
		}
		else{
			hideWindowWait();
		}
	}

	
	public void hideWindowWait(){
		Timer timer = new Timer(){
			public void run() 
			{
				winModal.hide();
			};
		};
		timer.schedule(1000*1);
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
	
	public void startScheduler(){
		if ( timer != null ){
			timer.cancel();
			timer = null;
		}
		timer = new Timer() {
			
			@Override
			public void run() {
				executeTimer = true;
				buscar(true);
			}
		};
		timer.scheduleRepeating(1000*timerSecunds);
	}

	public void stopScheduler(){
		if ( timer != null ){
			try{
				this.timer.cancel();
			}
			catch(Throwable e){
				Window.alert("Erro ao cancelar timer : "+e);
			}
		}
		this.timer = null;
	}


	/**
	 * @return the filtroConsulta
	 */
	public FiltroConsulta getFiltroConsulta() {
		return filtroConsulta;
	}


	/**
	 * @param filtroConsulta the filtroConsulta to set
	 */
	public void setFiltroConsulta(FiltroConsulta filtroConsulta) {
		this.filtroConsulta = filtroConsulta;
	}
	

	/**
	 * @return the resumoVendas
	 */
	public ResumoVendas getResumoVendas() {
		return resumoVendas;
	}


	/**
	 * @param resumoVendas the resumoVendas to set
	 */
	public void setResumoVendas(ResumoVendas resumoVendas) {
		this.resumoVendas = resumoVendas;
	}		
	
	
	/**
	 * Encaminha a requisição para o servidor para executar a consulta.
	 */
	public void buscar(boolean executeTimer) {

		winModal.centerInPage();
        winModal.show();
		
		this.executeTimer = executeTimer;
		// this.setData(new ListGridRecord[0]);

		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>(){
			
				public void onFailure(Throwable caught) {
					winModal.hide();
					caught.printStackTrace();
					com.google.gwt.user.client.Window.alert(caught.getMessage());
				}

				public void onSuccess(HowMGWTEntity result) {
					if ( result.getThrowable() != null ){
						winModal.hide();
						com.google.gwt.user.client.Window.alert(result.getThrowable().toString());
					}
					else
						showResult(result);
				}
		};

		HowMGWTEntity entity = Fabrica.createEntity();
		
		HowMProperty pDataInicio 	= new HowMProperty("dataInicio", this.filtroConsulta.getPeriodoInicial().getValueAsDate());
		entity.getParameters().put(pDataInicio.getName(), pDataInicio);
		
		HowMProperty pDataFim 		= new HowMProperty("dataFim", this.filtroConsulta.getPeriodoFinal().getValueAsDate());
		entity.getParameters().put(pDataFim.getName(), pDataFim);
	
		
		String[] grupos = new String[0];
		if ( this.filtroConsulta.getGrupoVendas().getValueAsString() != null )
			grupos = this.filtroConsulta.getGrupoVendas().getValueAsString().split(",");
		
		String sGrupos = "";
		for ( String grupo : grupos){
			
			String[] code = grupo.split("-");
			if ( sGrupos.trim().length() == 0 ){
				if ( "---".equals(grupo.trim()) )
					sGrupos += "---";
				else
					sGrupos += code[0];
			}
			else{
				if ( "---".equals(grupo.trim()) )
					sGrupos += ",---";
				else
					sGrupos += ","+code[0];				
			}
		}
		
		String[] vendedores = new String[0];
		if ( this.filtroConsulta.getVendedores().getValueAsString() != null )
			vendedores = this.filtroConsulta.getVendedores().getValueAsString().split(",");
		
		String sVendedores = "";
		for ( String vendedor : vendedores){
			
			String[] code = vendedor.split("-");
			if ( sVendedores.trim().length() == 0 ){
				if ( "---".equals(vendedor.trim()) )
					sVendedores += "---";
				else
					sVendedores += code[0];
			}
			else{
				if ( "---".equals(vendedor.trim()) )
					sVendedores += ",---";
				else
					sVendedores += ","+code[0];				
			}
		}		
		
		HowMProperty pGrupo 		= new HowMProperty("grupo", sGrupos );
		entity.getParameters().put(pGrupo.getName(), pGrupo);
 
		HowMProperty pVendedores 	= new HowMProperty("vendedores", sVendedores);
		entity.getParameters().put(pVendedores.getName(), pVendedores);
		
		HowMProperty pAcao      	= new HowMProperty("acao", "consulta");
		
		entity.setAction(Services.acaoVDP0001);
		
		Configuracao.getProxyStruts().executeQuery(entity, callback);
	}

	/**
	 * @return the timerSecunds
	 */
	public int getTimerSecunds() {
		return timerSecunds;
	}

	/**
	 * @param timerSecunds the timerSecunds to set
	 */
	public void setTimerSecunds(int timerSecunds) {
		this.timerSecunds = timerSecunds;
	}
}
