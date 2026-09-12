package com.br.client.panel.cd.cdd0007.model;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.model.HowMGWTDataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DataSourcePainelDados extends HowMGWTDataSource{

	public DataSourceTextField  fieldCodCliente 	= new DataSourceTextField ("fieldCodCliente", 			Tradutor.i18n.formCodigoCliente());  	
	public DataSourceTextField  fieldNomeCliente 	= new DataSourceTextField ("fieldNomeCliente", 			Tradutor.i18n.formNomeCliente());
		
	public DataSourcePainelDados(){	
        setClientOnly(true);
        
        setFields( fieldCodCliente, fieldNomeCliente); 

        this.onHowMInitEntityControl();
	}
}