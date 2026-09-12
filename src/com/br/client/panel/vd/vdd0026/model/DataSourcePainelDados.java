package com.br.client.panel.vd.vdd0026.model;

import com.br.client.panel.I18N.Tradutor;
import com.howmake.client.form.model.HowMGWTDataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DataSourcePainelDados extends HowMGWTDataSource{

	public DataSourceTextField  fieldPedido 	= new DataSourceTextField ("Pedido", 			   Tradutor.i18n.formPedido()); 
		
	public DataSourcePainelDados(){	
        setClientOnly(true);
        
        setFields( fieldPedido); 

        this.onHowMInitEntityControl();
	}
}