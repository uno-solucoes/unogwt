package com.br.client.panel.vd.vdq0002.model;

import java.util.Date;

import com.br.client.configuracao.Configuracao;
import com.br.client.panel.I18N.Tradutor;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.howmake.client.form.model.HowMGWTDataRecord;
import com.howmake.client.form.model.HowMGWTDataSource;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.FieldType;

public class DataSourceDetalheItem extends HowMGWTDataSource{

	DataSourceTextField  fieldCodProduto 		= new DataSourceTextField ("CodProduto", 			Tradutor.i18n.formItem());  	
	DataSourceTextField  fieldDescTecnica 		= new DataSourceTextField ("DescTecnica", 			Tradutor.i18n.formDescricaoTecnica());
	DataSourceTextField  fieldDataAlteracao		= new DataSourceTextField ("dataAlteracao",			Tradutor.i18n.formDataAlteracao());
	DataSourceTextField  fieldLeadTime			= new DataSourceTextField ("leadTime",				Tradutor.i18n.formLeadTime());
	DataSourceTextField  fieldQtdeMultipla		= new DataSourceTextField ("qtdeMultipla",			Tradutor.i18n.formQtdeMultipla());
	DataSourceTextField  fieldOrigem			= new DataSourceTextField ("origem",				Tradutor.i18n.formOrigem());
	DataSourceTextField  fieldClassFiscal		= new DataSourceTextField ("ClassFiscal",			Tradutor.i18n.formClassFiscal());
	DataSourceTextField  fieldLargura			= new DataSourceTextField ("Largura",				Tradutor.i18n.formLargura());
	DataSourceTextField  fieldAltura			= new DataSourceTextField ("Altura",				Tradutor.i18n.formAltura());
	DataSourceTextField  fieldComprimento		= new DataSourceTextField ("Comprimento",			Tradutor.i18n.formComprimento());
	DataSourceTextField  fieldPesoLiquido		= new DataSourceTextField ("PesoLiquido",			Tradutor.i18n.formPesoLiquido());
	DataSourceTextField  fieldPesoBruto			= new DataSourceTextField ("PesoBruto",				Tradutor.i18n.formPesoBruto());
	public DataSourceTextField  fieldValorCusto	= new DataSourceTextField ("ValorCusto",			Tradutor.i18n.formCustoProduto());
	public DataSourceTextField  fieldDataCusto	= new DataSourceTextField ("DataCusto",				Tradutor.i18n.formDataCusto());
	
	DataSourceTextField  fieldEstoqueDisponivel = new DataSourceTextField ("EstoqueDisponivel",		Tradutor.i18n.formEstoqueDisponivel());
	DataSourceTextField  fieldEstoqueAtual 		= new DataSourceTextField ("EstoqueAtual",			Tradutor.i18n.formEstoqueAtual());
		
	public DataSourceDetalheItem(boolean allPrivilegies){	
        setClientOnly(true);
        
        if ( allPrivilegies ){
			setFields(
	        		fieldCodProduto,
	        		fieldDescTecnica,
	        		fieldDataAlteracao,
	        		fieldLeadTime,
	        		fieldQtdeMultipla,
	        		fieldOrigem,
	        		fieldClassFiscal,
	        		fieldLargura,
	        		fieldAltura,
	        		fieldComprimento,
	        		fieldPesoLiquido,
	        		fieldPesoBruto,
	        		fieldValorCusto,
	        		fieldDataCusto,
	        		fieldEstoqueDisponivel,
	        		fieldEstoqueAtual
	        ); 
        }
        else{
			setFields(
	        		fieldCodProduto,
	        		fieldDescTecnica,
	        		fieldDataAlteracao,
	        		fieldLeadTime,
	        		fieldQtdeMultipla,
	        		fieldOrigem,
	        		fieldClassFiscal,
	        		fieldLargura,
	        		fieldAltura,
	        		fieldComprimento,
	        		fieldPesoLiquido,
	        		fieldPesoBruto,
	        		fieldEstoqueDisponivel,
	        		fieldEstoqueAtual
	        ); 
        	
        }
        this.onHowMInitEntityControl();

        fieldQtdeMultipla.setType(FieldType.FLOAT);
		fieldLargura.setType(FieldType.FLOAT);
		fieldAltura.setType(FieldType.FLOAT);
		fieldComprimento.setType(FieldType.FLOAT);
		fieldPesoLiquido.setType(FieldType.FLOAT);

		fieldPesoBruto.setType(FieldType.FLOAT);
		fieldValorCusto.setType(FieldType.FLOAT);
		
		fieldDataAlteracao.setType(FieldType.DATE);
		fieldDataCusto.setType(FieldType.DATE);
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
				// Formatar a data.
				record.setAttribute(field.getName(), DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss").format(new Date(new Long(value.toString()))));
			}
			catch(Throwable err){
				record.setAttribute(field.getName(), value.toString() );							
			}
			return;
		}
		else if ( field.getType().equals(FieldType.FLOAT)){
			try{
				if ( fieldValorCusto.getName().equalsIgnoreCase(field.getName()) )
					// Formatar a Valor Double.
					record.setAttribute(field.getName(), NumberFormat.getFormat("###,###,###,###,###,###,##0.0000").format(new Double(value.toString())));
				else
					// Formatar a Valor Double.
					record.setAttribute(field.getName(), NumberFormat.getFormat("###,###,###,###,###,###,##0.00").format(new Double(value.toString())));
			}
			catch(Throwable err){
				record.setAttribute(field.getName(), value.toString() );							
			}
			return;
		}
		else{
			if ( field.getName().equals(fieldLeadTime.getName()))
				record.setAttribute(field.getName(), value.toString() + " " + Tradutor.i18n.formDias() );
			else
				record.setAttribute(field.getName(), value.toString() );		
			return;
		}
	}
	
	
	
	public void loadRecord(HowMGWTDataRecord record, String[] row){
		
		this.setAttribute(fieldCodProduto		, record, row);
		this.setAttribute(fieldCodProduto		, record, row);
		this.setAttribute(fieldDescTecnica		, record, row);
		this.setAttribute(fieldDataAlteracao	, record, row);
		this.setAttribute(fieldLeadTime			, record, row);
		this.setAttribute(fieldQtdeMultipla		, record, row);
		this.setAttribute(fieldOrigem			, record, row);
		this.setAttribute(fieldClassFiscal		, record, row);
		this.setAttribute(fieldLargura			, record, row);
		this.setAttribute(fieldAltura			, record, row);
		this.setAttribute(fieldComprimento		, record, row);
		this.setAttribute(fieldPesoLiquido		, record, row);
		this.setAttribute(fieldPesoBruto		, record, row);
		this.setAttribute(fieldValorCusto		, record, row);
		this.setAttribute(fieldDataCusto		, record, row);
		this.setAttribute(fieldEstoqueDisponivel, record, row);
		this.setAttribute(fieldEstoqueAtual		, record, row);
	}
	
	/**
	 * Retorna o select para recuperar os detalhes do produto no banco de dados.
	 * @param codProduto
	 * @return
	 */
	public final static String getSQL(String codProduto){
		String sql = "";
		 
		sql += "select  ";
		sql += "   concat(concat(cd_produto.cod_produto,' - '), cd_produto.desc_comercial ) ,  ";
		sql += "   cd_produto.desc_tecnica ,  ";
		sql += "   cd_produto.dt_alteracao,  ";
		sql += "   cd_produto_empresa.lead_time, ";
		sql += "   cd_produto.qtd_multipla,  ";
		sql += "   if (  cd_produto_empresa.origem = 1  OR cd_produto_empresa.origem = 0 , "; 
		sql += "      'Comprado',  ";
		sql += "      if ( cd_produto_empresa.origem = 2 , ";          
		sql += "         'Fabricado' ,  ";
		sql += "         if ( cd_produto_empresa.origem = 3 , ";
		sql += "            'Beneficiado' , ";                
		sql += "            ' ' ";
		sql += "         ) ";             
		sql += "      ) ";
		sql += "   ) as origem, ";
		sql += "   if(cd_produto.class_fiscal is not null ,  concat(concat(cd_produto.class_fiscal , ' - ' ),cd_classificacao_fiscal.desc_abrev) , '  ' ) , ";
		sql += "   cd_produto.largura,  ";
		sql += "   cd_produto.altura, ";
		sql += "   cd_produto.comprimento, ";
		sql += "   cd_produto.peso_liquido,  ";
		sql += "   cd_produto.peso_bruto, ";
		
		sql += "   cd_produto_empresa.vl_custo_total as custoProduto, ";
		sql += "   cd_produto_empresa.dt_vl_custo_total,  ";

		sql += "   0 as estoqueDisponivel, ";
		sql += " ifnull( ( \n";				
		sql += "	SELECT  \n";
		sql += "	         SUM( eq_saldo.saldo_estoque ) as saldo  \n";
		sql += "	FROM  \n";
		sql += "	       eq_saldo,  \n";
		sql += "	       eq_deposito \n";
		sql += "	WHERE \n";
		sql += "	       eq_saldo.cod_empresa = cd_produto_empresa.cod_empresa\n";   
		sql += "	       AND \n";
		sql += "	       eq_saldo.cod_produto = cd_produto_empresa.cod_produto   \n"; //HBO8811
		sql += "	       AND \n";
		sql += "	       eq_deposito.cod_empresa = eq_saldo.cod_empresa  \n";
		sql += "	       AND \n";
		sql += "	       eq_deposito.cod_deposito = eq_saldo.cod_deposito \n";
		sql += "	       AND\n";
		sql += "	       eq_deposito.consulta_saldo = '1'\n";
		sql += "	GROUP BY eq_saldo.cod_produto \n";
		sql += "), 0.0000) as estoqueAtual ";
		
		sql += "from  ";
		sql += "   cd_produto ";
		sql += "   inner join cd_produto_empresa   ";
		sql += "        on ";
		sql += "        cd_produto_empresa.cod_produto = cd_produto.cod_produto  ";     
		sql += "   left outer join cd_classificacao_fiscal ";
		sql += "        on ";
		sql += "        cd_classificacao_fiscal.class_fiscal = cd_produto.class_fiscal ";
		sql += "where ";
		sql += "   cd_produto_empresa.cod_empresa = "+Configuracao.getCodEmpresa()+" ";
		sql += "   and ";
		sql += "   cd_produto_empresa.cod_produto = '"+codProduto+"' ";
		// System.out.println(sql);
		return sql;		
	}


	/**
	 * @return the fieldEstoqueDisponivel
	 */
	public DataSourceTextField getFieldEstoqueDisponivel() {
		return fieldEstoqueDisponivel;
	}


	/**
	 * @param fieldEstoqueDisponivel the fieldEstoqueDisponivel to set
	 */
	public void setFieldEstoqueDisponivel(DataSourceTextField fieldEstoqueDisponivel) {
		this.fieldEstoqueDisponivel = fieldEstoqueDisponivel;
	}


	/**
	 * @return the fieldEstoqueAtual
	 */
	public DataSourceTextField getFieldEstoqueAtual() {
		return fieldEstoqueAtual;
	}


	/**
	 * @param fieldEstoqueAtual the fieldEstoqueAtual to set
	 */
	public void setFieldEstoqueAtual(DataSourceTextField fieldEstoqueAtual) {
		this.fieldEstoqueAtual = fieldEstoqueAtual;
	}
}
