package com.br.client.panel.vd.vdq0002.UI;
 
 

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.Services;
import com.br.client.panel.vd.vdq0002.model.DataSourceDetalheItem;
import com.google.gwt.user.client.Timer;
import com.howmake.client.form.UI.HowMGWTPanelSectionStack;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.model.HOWMGWTDataSourceQuery;
import com.howmake.client.form.model.HowMGWTCallImpl;
import com.howmake.client.form.model.HowMGWTDataRecord;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.shared.HowMGWTEntity;
import com.howmake.shared.HowMProperty;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.tile.TileRecord;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

public class VDD0011PainelDetalheItem extends HowMGWTWindow{

	public String currentCodProduto;
	
	public final static int SISTEMA_PRODUTO_TP_AQUISICAO_COMPRADO	= 1;
	public final static int SISTEMA_PRODUTO_TP_AQUISICAO_FABRICADO	= 2;
	public final static int SISTEMA_PRODUTO_TP_AQUISICAO_BENEFICIADO = 3;

	private DataSourceDetalheItem dsDetalheItem = new DataSourceDetalheItem(false);
    private DetailViewer dvDetalheItem = new DetailViewer();  
	private TileGrid tileGrid = new TileGrid();  
    private DetailViewerField pictureField = new DetailViewerField("picture");    
    private HowMGWTEntity detailEntity = Fabrica.createEntity();
    private HowMProperty pCodProduto   = new HowMProperty("codProduto","");
   
	public VDD0011PainelDetalheItem(){

		pCodProduto = Fabrica.createParameter(detailEntity, pCodProduto.getName(), pCodProduto		  );
		Fabrica.createParameter(detailEntity, "acao", 				 "buscaEstoqueProduto");
		
		this.setWidth("500px");
		this.setHeight("600px");
		this.centerInPage();
		
		this.setIsModal(true);
		
		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setOverflow(Overflow.AUTO);
		
        dvDetalheItem.setWidth100();
        dvDetalheItem.setMargin(2); 
        dvDetalheItem.setAutoHeight();
        dvDetalheItem.setDataSource(dsDetalheItem);
        dvDetalheItem.setEmptyMessage("Nenhum item encontrado...");  

        vLayout.addMember(dvDetalheItem);
        
        HowMGWTPanelSectionStack sessionDetalheItem = new HowMGWTPanelSectionStack("Detalhes do Produto", vLayout);
        sessionDetalheItem.setHeight("400px");
        
        tileGrid.setWidth100();   
        tileGrid.setHeight100();
        tileGrid.setTileWidth(120);  
        tileGrid.setTileHeight(90);  
        tileGrid.setCanAcceptDrop(true);  
        tileGrid.setCanDrag(true);
        tileGrid.setData(new TileRecord[]{});          
        
        pictureField.setType("image");  
        pictureField.setImageURLPrefix("");
		pictureField.setImageHeight(100);
		pictureField.setImageWidth(100);

        tileGrid.setFields(pictureField);  

        HowMGWTPanelSectionStack sessionImagensItem = new HowMGWTPanelSectionStack("Imagens do Produto", tileGrid);
 
        
        this.addItem(sessionDetalheItem);
        this.addItem(sessionImagensItem);
        
        this.setDismissOnEscape(true);
 	}
	
	public void showDetalhes(String codProduto){
		this.show();
		
		
		pCodProduto.setValue(codProduto);
		detailEntity.setAction(Services.acaoVDD0011);
		
		if ( ! codProduto.equals(currentCodProduto) ){

			HowMGWTCallImpl call = new HowMGWTCallImpl() {
				
				@Override
				public void onSuccess(HowMGWTEntity result) {

					if ( result.getDetailEntities().size() > 0 ){
						HowMGWTEntity entity = result.getDetailEntities().get(0);
						HowMProperty permiteVisualizarCusto = entity.getParameters().get("PermiteVisualizarCusto" );
						if ( permiteVisualizarCusto.getValueBoolean() )
							dsDetalheItem = new DataSourceDetalheItem(true);
						
						else
							dsDetalheItem = new DataSourceDetalheItem(false);
						
						dvDetalheItem.setDataSource(dsDetalheItem);
					}					
					
					ListGridRecord[] records = new ListGridRecord[result.getData().size()];		 
					HowMGWTDataRecord record;
					int i = 0;
					for ( String[] row : result.getData()){
						record = new HowMGWTDataRecord();						
						dsDetalheItem.loadRecord(record, row);
						records[i] = record;
						i ++;
					}
					dvDetalheItem.setData(records);					
										
					ListGridRecord currentRecord = null;
					if ( records.length > 0 )
						currentRecord = records[0];
					
					if ( result.getDetailEntities().size() > 0 ){
						HowMGWTEntity entity = result.getDetailEntities().get(0);
						HowMProperty saldoEstoque 	= entity.getParameters().get("saldoDisponivel" );
						HowMProperty saldoDisponivel = entity.getParameters().get("saldoEstoque" );
						
						if ( currentRecord != null ){
							String valor = "0.0";
							if ( saldoDisponivel!= null ) 
								valor = saldoDisponivel.getValue();
							valor = HowMGWTUtilities.replace(valor, ".", "");
							valor = HowMGWTUtilities.replace(valor, ",", ".");
							
							if ( new Double(valor ) <= 0.0 )
								currentRecord.setAttribute(dsDetalheItem.getFieldEstoqueDisponivel().getName(), "<font color=\"#FF0033\">"+saldoDisponivel.getValue()+"</font>");
							else
								currentRecord.setAttribute(dsDetalheItem.getFieldEstoqueDisponivel().getName(), "<font color=\"	#0000CD\">"+saldoDisponivel.getValue()+"</font>");

							currentRecord.setAttribute(dsDetalheItem.getFieldEstoqueAtual().getName(), saldoEstoque.getValue());						
						}
					}
				}
			};
			HOWMGWTDataSourceQuery.executeQuery(DataSourceDetalheItem.getSQL(codProduto), call, detailEntity);
					
			
			
			
			// ------------------------------------------------------------------------
			// Carrega as imagens do produto
			// ------------------------------------------------------------------------
			String sql = "";
			sql += "SELECT ";
			sql += " imagem ";
			sql += "FROM ";
			sql += "	cd_imagem_produto ";
			sql += "WHERE ";
			sql += "	cod_produto = '"+codProduto+"' ";
			HowMGWTCallImpl callImages = new HowMGWTCallImpl() {
				
				@Override
				public void onSuccess(HowMGWTEntity result) {
					TileRecord[] records = new TileRecord[result.getData().size()];
					int i = 0;
					
			        String context = "";
					
					for ( String[]  row : result.getData() ){

						if ( context.trim().length() == 0 ){
							context = row[0].substring(0,row[0].lastIndexOf("/"))+"/";		
							pictureField.setImageURLPrefix(Configuracao.getNativeUnoUrlServiceDonwload()+"/.."+context); 
						}
						row[0] = HowMGWTUtilities.replace(row[0], context, "");
						TileRecord record = new TileRecord();
						record.setAttribute("picture", row[0]);
						records[i] = record;
						i ++;
					}
					tileGrid.setData(records);
				}
			};				
			HOWMGWTDataSourceQuery.executeQuery(sql, callImages);

			
			this.currentCodProduto = codProduto;
			Timer timer = new Timer() {
				
				@Override
				public void run() {
					setCanFocus(true);
					focus();
				}
			};
			timer.schedule(60);			
		}
	}
	
	@Override
	public String getHowMGWTPrograma() {
		return "VDD011";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloVDD0011();
	}	
}
