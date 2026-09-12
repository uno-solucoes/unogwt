package com.br.client.panel.sv.svd0010.model;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.model.HowMGWTDataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DataSourcePainelDados extends HowMGWTDataSource{

	public DataSourceTextField  fieldParticipante 	= new DataSourceTextField ("fieldParticipante", 		Tradutor.i18n.formParticipante());  	
	public DataSourceTextField  fieldVendedor 		= new DataSourceTextField ("fieldVendedor", 			Tradutor.i18n.formVendedor());
	public DataSourceTextField  fieldPercComissao	= new DataSourceTextField ("fieldPercComissao",			Tradutor.i18n.formPercComissao());
		
	public DataSourcePainelDados(){	
        setClientOnly(true);
        
        setFields( fieldParticipante, fieldVendedor, fieldPercComissao); 

        this.onHowMInitEntityControl();
	}
}
