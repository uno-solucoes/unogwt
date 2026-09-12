package com.br.client.panel.cd.cdd0008.model;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.model.HowMGWTDataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DataSourcePainelDados extends HowMGWTDataSource{

	public DataSourceTextField  fieldCodTabelaPreco 	= new DataSourceTextField ("fieldCodPreco", 			   Tradutor.i18n.formTabelaPreco()); 
		
	public DataSourcePainelDados(){	
        setClientOnly(true);
        
        setFields( fieldCodTabelaPreco); 

        this.onHowMInitEntityControl();
	}
}