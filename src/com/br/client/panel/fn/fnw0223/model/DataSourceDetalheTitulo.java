package com.br.client.panel.fn.fnw0223.model;


import java.util.Date;

import com.br.client.configuracao.Configuracao;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.howmake.client.form.model.HowMGWTDataRecord;
import com.howmake.client.form.model.HowMGWTDataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.FieldType;

public class DataSourceDetalheTitulo extends HowMGWTDataSource{

    private DataSourceTextField cod_cliente			= new DataSourceTextField ("cod_cliente", 			Tradutor.i18n.formNomeFavorecido());
    private DataSourceTextField situacao			= new DataSourceTextField ("situacao", 				Tradutor.i18n.formSituacao());
    private DataSourceTextField dt_vencimento		= new DataSourceTextField ("dt_vencimento", 		Tradutor.i18n.formDtVencimento());
    private DataSourceTextField dt_implant			= new DataSourceTextField ("dt_implant", 			Tradutor.i18n.formDtInclusao());
    private DataSourceTextField dt_emissao			= new DataSourceTextField ("dt_emissao", 			Tradutor.i18n.formDtEmissao());
    private DataSourceTextField tp_juros			= new DataSourceTextField ("tp_juros", 				Tradutor.i18n.formTipoJuros());
    private DataSourceTextField vl_total_titulo		= new DataSourceTextField ("vl_total_titulo", 		Tradutor.i18n.formValorTotalTitulo());
    private DataSourceTextField vl_total_baixa		= new DataSourceTextField ("vl_total_baixa", 		Tradutor.i18n.formValorBaixa());
    private DataSourceTextField perc_multa			= new DataSourceTextField ("perc_multa", 			Tradutor.i18n.formPercMulta());
    private DataSourceTextField taxa_boleto			= new DataSourceTextField ("taxa_boleto", 			Tradutor.i18n.formTaxaBoleto());
    private DataSourceTextField perc_pontualidade	= new DataSourceTextField ("perc_pontualidade", 	Tradutor.i18n.formPercPontualidade());
    private DataSourceTextField vl_desconto			= new DataSourceTextField ("vl_desconto", 			Tradutor.i18n.formValorDesconto());
    private DataSourceTextField vl_iss				= new DataSourceTextField ("vl_iss", 				Tradutor.i18n.formIss());
    private DataSourceTextField vl_ir				= new DataSourceTextField ("vl_ir", 				Tradutor.i18n.formIr());
    private DataSourceTextField vl_pis				= new DataSourceTextField ("vl_pis", 				Tradutor.i18n.formPis());
    private DataSourceTextField vl_cofins			= new DataSourceTextField ("vl_cofins", 			Tradutor.i18n.formCofins());
    private DataSourceTextField vl_cs				= new DataSourceTextField ("vl_cs", 				Tradutor.i18n.formCs());
	
    public DataSourceDetalheTitulo(){	
      
		setClientOnly(true);
        
		setFields(
			    cod_cliente,
			    situacao,
			    dt_vencimento,
			    dt_implant,
			    dt_emissao,
			    tp_juros,
			    vl_total_titulo,
			    vl_total_baixa,
			    perc_multa,
			    taxa_boleto,
			    perc_pontualidade,
			    vl_desconto,
			    vl_iss,
			    vl_ir,
			    vl_pis,
			    vl_cofins,
			    vl_cs
        ); 

        this.onHowMInitEntityControl();

	    tp_juros.setType(FieldType.INTEGER);
	    vl_total_titulo.setType(FieldType.FLOAT);
	    vl_total_baixa.setType(FieldType.FLOAT);
	    perc_multa.setType(FieldType.FLOAT);
	    taxa_boleto.setType(FieldType.FLOAT);
	    perc_pontualidade.setType(FieldType.FLOAT);	    
	    vl_desconto.setType(FieldType.FLOAT);
	    vl_iss.setType(FieldType.FLOAT);
	    vl_ir.setType(FieldType.FLOAT);
	    vl_pis.setType(FieldType.FLOAT);
	    vl_cofins.setType(FieldType.FLOAT);
	    vl_cs.setType(FieldType.FLOAT);

	    
	    dt_vencimento.setType(FieldType.DATE);
	    dt_implant.setType(FieldType.DATE);
	    dt_emissao.setType(FieldType.DATE);
	}

	/**
	 * Seta o valor do campo conforme o seu tipo de dado.
	 * @param field
	 * @param record
	 * @param row
	 */
	public void setAttribute(DataSourceTextField field, HowMGWTDataRecord record, String[] row){
		Integer idx = this.getHeaderPositions().get(field.getName());
		if ( idx == null ){
			record.setAttribute(field.getName(), " ");
			return;
		}
		Object value = row[idx.intValue()];
		if( value == null ){
			record.setAttribute(field.getName(), " ");
			return;
		}

		if ( field.getType().equals(FieldType.DATE)){
			try{
				String valor = DateTimeFormat.getFormat("dd/MM/yyyy").format(new Date(new Long(value.toString())));
				if ( dt_vencimento.getName().equals(field.getName()))
					valor = "<html><body><b><Font color=BLUE>"+valor+"</font></b></body></html>";
				
				// Formatar a data.
				record.setAttribute(field.getName(), valor);
			}
			catch(Throwable err){
				record.setAttribute(field.getName(), value.toString() );							
			}
			return;
		}
		else if ( field.getType().equals(FieldType.FLOAT)){
			try{
				String valor = NumberFormat.getFormat("###,###,###,###,###,###,##0.00").format(new Double(value.toString()));
				if ( vl_total_titulo.getName().equals(field.getName()))
					valor = "<html><body><b><Font color=BLUE>"+valor+"</font></b></body></html>";
				if ( vl_total_baixa.getName().equals(field.getName()))
					valor = "<html><body><b><Font color=GREEN>"+valor+"</font></b></body></html>";

				record.setAttribute(field.getName(), valor);			

			}
			catch(Throwable err){
				record.setAttribute(field.getName(), value.toString() );							
			}
			return;
		}
		else{
			record.setAttribute(field.getName(), value.toString() );		
			return;
		}
	}
	
	
	
	public void loadRecord(HowMGWTDataRecord record, String[] row){
		
		this.setAttribute(cod_cliente, record, row);
		this.setAttribute(situacao, record, row);
		this.setAttribute(dt_vencimento, record, row);
		this.setAttribute(dt_implant, record, row);
		this.setAttribute(dt_emissao, record, row);
		this.setAttribute(tp_juros, record, row);
		this.setAttribute(vl_total_titulo, record, row);
		this.setAttribute(vl_total_baixa, record, row);
		this.setAttribute(perc_multa, record, row);
		this.setAttribute(taxa_boleto, record, row);
		this.setAttribute(perc_pontualidade, record, row);
 
		this.setAttribute(vl_desconto, record, row);
		this.setAttribute(vl_iss, record, row);
		this.setAttribute(vl_ir, record, row);
		this.setAttribute(vl_pis, record, row);
		this.setAttribute(vl_cofins, record, row);
		this.setAttribute(vl_cs, record, row);
	}
	
	/**
	 * Retorna o select para recuperar os detalhes do produto no banco de dados.
	 * @param codProduto
	 * @return
	 */
	public String getSQLContasReceber(String codTitulo, String codParcela, String tabela){
		String sql = "";
		
		sql += "select\n";
		if ( "fn_titulo_pagar".equals(tabela) ){
		    sql += "	concat(concat(tipa.cod_fornecedor,'-'),case when razao_social is null or razao_social = '' then nome_fantasia else razao_social end) \n";
		    cod_cliente.setTitle("Fornecedor");		    
		}
		else
		{
			sql += "	 concat(concat(tipa.cod_cliente,'-'),case when cd_cliente.razao_social is null or cd_cliente.razao_social = '' then cd_cliente.nome_cliente else razao_social end)  \n";
		    cod_cliente.setTitle("Cliente");
		}
	    sql += "	,tipa."+situacao.getName()+"\n";
		sql += "	,tipa."+dt_vencimento.getName()+"\n";
		sql += "	,tipa."+dt_implant.getName()+"\n";
		sql += "	,tipa."+dt_emissao.getName()+"\n";
		sql += "	,tipa."+tp_juros.getName()+"\n";
		sql += "	,tipa."+vl_total_titulo.getName()+"\n";
		sql += "	,tipa."+vl_total_baixa.getName()+"\n";
		sql += "	,tipa."+perc_multa.getName()+"\n";
		sql += "	,tipa."+taxa_boleto.getName()+"\n";
		sql += "	,tipa."+perc_pontualidade.getName()+"\n";
 
		sql += "	,tipa."+vl_desconto.getName()+"\n";
		sql += "	,tipa."+vl_iss.getName()+"\n";
		sql += "	,tipa."+vl_ir.getName()+"\n";
		sql += "	,tipa."+vl_pis.getName()+"\n";
		sql += "	,tipa."+vl_cofins.getName()+"\n";
		sql += "	,tipa."+vl_cs.getName()+"\n";
		sql += "from \n";
		sql += "	"+tabela+" as tipa\n";
		if ( "fn_titulo_pagar".equals(tabela) ){
			sql += "	left join cd_fornecedor\n";
			sql += "	on\n";
			sql += "		cd_fornecedor.cod_fornecedor = tipa.cod_fornecedor\n";
		}
		else{
			sql += "	left join cd_cliente\n";
			sql += "	on\n";
			sql += "		cd_cliente.cod_cliente = tipa.cod_cliente\n";			
		}
		sql += "where \n";
		sql += "    tipa.cod_empresa = "+Configuracao.getCodEmpresa();
		sql += "	and ";
		sql += "	tipa.cod_titulo = "+codTitulo+"\n";
		sql += "	and \n";
		sql += "	tipa.cod_parcela = "+codParcela+"\n";
	 
		System.out.println(sql);
		return sql;		
	}

 
}
