package com.br.client.panel.oc.ocw0001.UI;

import java.util.Date;

import com.br.client.configuracao.Configuracao;
import com.br.client.configuracao.Fabrica;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.Services;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.howmake.client.form.UI.HowMGWTWindowWait;
import com.howmake.client.form.model.HowMGWTDataRecord;
import com.howmake.client.form.model.HowMGWTTask;
import com.howmake.client.form.partner.HowMGWTConstants;
import com.howmake.client.form.partner.HowMGWTUtilities;
import com.howmake.shared.HowMGWTEntity;

public class GoogleAgendaTaskList extends HowMGWTWindow{

	private GoogleAgendaTaskListGrid grid = new GoogleAgendaTaskListGrid();
	
	public GoogleAgendaTaskList(){		
		this.setModalMaskOpacity(HowMGWTConstants.WINDOW_MODAL_MASK_OPACITY);		  
		this.setShowModalMask(true);		

		this.setWidth(600+"px");
		this.setHeight(250+"px");
		this.setCanDragResize(true);

		
		this.centerInPage();
		this.setDismissOnEscape(true);		
		this.setIsModal(true);	
		
		this.addItem(grid);				
	}
	
	public String getHowMGWTTitle(){
		return Tradutor.i18n.formTituloOCW0001GATL() ;
	}
	public String getHowMGWTPrograma(){
		return "OCW0001GATL";
	}	
	
	/**
	 * Apresenta a lista de eventos agendados para o serviço em questão.
	 * @param tipoAgenda
	 * @param labelAgenda
	 * @param codOC
	 */
	public void showTaskList(String tipoAgenda, String labelAgenda, String codOC){
		
		
		HowMGWTWindowWait.showWait(Tradutor.i18n.formGoogleAguardeConectandoGoogleAgenda());
		grid.clearAllRecords();

		HowMGWTEntity entity = Fabrica.createEntity();
		entity.setAction(Services.acaoOCW0001); 
		Fabrica.createParameter(entity, "acao", "buscarAgendaByPK");
		Fabrica.createParameter(entity, "AGENDA_Type",tipoAgenda);
		Fabrica.createParameter(entity, "AGENDA_KEY" , codOC );
		
		AsyncCallback callback = new AsyncCallback<HowMGWTEntity>() {

			public void onFailure(Throwable caught) {
				HowMGWTWindowWait.hideWait();
				caught.printStackTrace();
				com.google.gwt.user.client.Window.alert(Tradutor.i18n.formEnderecoBase()+ GWT.getHostPageBaseURL() + "\n" + caught.getMessage());
			}

			public void onSuccess(HowMGWTEntity result) {
				if( HowMGWTUtilities.isAnalyseEntityIsError(result))
					return;
				
				int i = 0;	
				HowMGWTTask task;
				HowMGWTDataRecord[] records = new HowMGWTDataRecord[result.getData().size()];
				for (String[] row : result.getData()) {
					task = new HowMGWTTask(row);
					
					records[i] = new HowMGWTDataRecord();
					records[i].setAttribute(grid.fieldData.getName()		, DateTimeFormat.getFormat("dd/MM/yyyy").format(task.getStartDate()));
					records[i].setAttribute(grid.fieldHoraInicio.getName()	, DateTimeFormat.getFormat("HH:mi").format(task.getStartDate()));
					records[i].setAttribute(grid.fieldHoraFim.getName()		, DateTimeFormat.getFormat("HH:mi").format(task.getEndDate()));

					records[i].setAttribute(grid.fieldNome.getName()		, task.getName());
					
					records[i].setAttribute(grid.fieldObservacao.getName()	, task.getDescription());
				 
					i++;
				}
				grid.setRecords(records);
				 

				HowMGWTWindowWait.hideWait();
				
				GoogleAgendaTaskList.this.show();
			}
		};
		Configuracao.getProxyStruts().executeQuery(entity, callback);		
		

	}
}