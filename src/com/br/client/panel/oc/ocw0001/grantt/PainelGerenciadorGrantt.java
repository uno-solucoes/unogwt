package com.br.client.panel.oc.ocw0001.grantt; 

 
import java.util.Date;

import com.arcetis.gwt.jsgantt.client.Format;
import com.arcetis.gwt.jsgantt.client.GanttChart;
import com.arcetis.gwt.jsgantt.client.GanttChartListener;
import com.arcetis.gwt.jsgantt.client.Priority;
import com.arcetis.gwt.jsgantt.client.TaskItem;
import com.br.client.panel.I18N.Tradutor;
import com.br.client.panel.registro.UIPartner;
import com.howmake.client.form.UI.HowMGWTWindow;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelGerenciadorGrantt extends HowMGWTWindow implements UIPartner{

	final TaskItemEditPanel itemEditPanel = new TaskItemEditPanel();

	HTMLPane pane = new HTMLPane();
	
	public PainelGerenciadorGrantt(){
	 start();
	}
	
	private VLayout mainLayout;
	
	public void start(){
		
		this.setWidth100();
		this.setHeight100();
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();

		HTMLPane pane = new HTMLPane();
		pane.setWidth100();
		pane.setHeight100();
		pane.setContents("<div style='width:0px; height:0px' id='GanttChartDIV'></div>");
		mainLayout.addMember(pane);

	    this.addItem(mainLayout);

	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
		genGantt();	    
	}
 
	@Override
	public String getHowMGWTPrograma() {
		return "OCW0001";
	}

	@Override
	public String getHowMGWTTitle() {
		return Tradutor.i18n.formTituloOCW0001();
	}	
	
	
	
	
	
	
	
	
	
	private void genGantt() {

        final GanttChart ganttChart = GanttChart.create();
		
        GanttChartListener ganttChartListener = new GanttChartListener(){
			public void onTaskItemClick(TaskItem item) {
				itemEditPanel.setTask(item);
				SC.say("Tarefa : "+item.getName());
			}
			
        };
        
        ganttChart.setGanttChartListener(ganttChartListener);
        
        if(ganttChart !=null){
        	generateSample(ganttChart);
        	ganttChart.generate(); 
        }
	}



	private void generateSample(GanttChart ganttChart) {
		ganttChart.addTaskItem(createTaskItem("1", "Define Chart API", (Date)null, (Date)null, Priority.BLACK, "", 0, "Brian", 0, true, "0", 1));
       
		ganttChart.addTaskItem(createTaskItem("11", "Chart Object", Format.getDate("2/20/2008"), Format.getDate("2/20/2008"), "ff00ff", "http://www.yahoo.com", 1, "Shlomy", 100, false, "1", 1));
        ganttChart.addTaskItem(createTaskItem("12", "Task Objects", (Date)null, (Date)null, "00ff00", "", 0, "Shlomy", 40, true, "1", 1));
        ganttChart.addTaskItem(createTaskItem("121", "Constructor Proc", Format.getDate("2/21/2008"), Format.getDate("3/9/2008"), "00ffff", "http://www.yahoo.com", 0, "Brian T.", 60, false, "12", 1));
        ganttChart.addTaskItem(createTaskItem("122", "Task Variables", Format.getDate("3/6/2008"), Format.getDate("3/11/2008"), Priority.BLACK, "http://help.com", 0, "", 60, false, "12", 1,"121"));
        ganttChart.addTaskItem(createTaskItem("123", "Task Functions", Format.getDate("3/9/2008"), Format.getDate("3/28/2008"), Priority.BLACK, "http://help.com", 0, "Anyone", 10, false, "12", 1));
        ganttChart.addTaskItem(createTaskItem("2", "Create HTML Shell", Format.getDate("3/24/2008"), Format.getDate("3/25/2008"), "ffff00", "http://help.com", 0, "Brian", 20, false, "0", 1,"122"));
        ganttChart.addTaskItem(createTaskItem("3", "Code Javascript", (Date)null, (Date)null, Priority.BLACK, "http://help.com", 0, "Brian", 0, true, "0", 1));
        ganttChart.addTaskItem(createTaskItem("31", "Define Variables", Format.getDate("2/25/2008"), Format.getDate("3/17/2008"), "ff00ff", "http://help.com", 0, "Brian", 30, false, "3", 1));
        ganttChart.addTaskItem(createTaskItem("32", "Calculate Chart Size", Format.getDate("3/15/2008"), Format.getDate("3/24/2008"), "00ff00", "http://help.com", 0, "Shlomy", 40, false, "3", 1));
        ganttChart.addTaskItem(createTaskItem("33", "Draw Taks Items", (Date)null, (Date)null, "00ff00", "http://help.com", 0, "Someone", 40, true, "3", 1));
        ganttChart.addTaskItem(createTaskItem("332", "Task Label Table", Format.getDate("3/6/2008"), Format.getDate("3/11/2008"), Priority.ORANGE, "http://help.com", 0, "Brian", 60, false, "33", 1));
        ganttChart.addTaskItem(createTaskItem("333", "Task Scrolling Grid", Format.getDate("3/9/2008"), Format.getDate("3/29/2008"), Priority.ORANGE, "http://help.com", 0, "Brian", 60, false, "33", 1));
        ganttChart.addTaskItem(createTaskItem("34", "Draw Task Bars", (Date)null, (Date)null, "990000", "http://help.com", 0, "Anybody", 60, true, "3", 1));
        ganttChart.addTaskItem(createTaskItem("341", "Loop each Task", Format.getDate("3/26/2008"), Format.getDate("4/11/2008"), Priority.BLACK, "http://help.com", 0, "Brian", 60, false, "34", 1));
        ganttChart.addTaskItem(createTaskItem("342", "Calculate Start/Stop", Format.getDate("4/12/2008"), Format.getDate("5/18/2008"), "ff6666", "http://help.com", 0, "Brian", 60, false, "34", 1));
        ganttChart.addTaskItem(createTaskItem("343", "Draw Task Div", Format.getDate("5/13/2008"), Format.getDate("5/17/2008"), Priority.BLACK, "http://help.com", 0, "Brian", 60, false, "34", 1));
        ganttChart.addTaskItem(createTaskItem("344", "Draw Completion Div", Format.getDate("5/17/2008"), Format.getDate("6/04/2008"), Priority.BLACK, "http://help.com", 0, "Brian", 60, false, "34", 1));
        
	}
	private TaskItem createTaskItem(String pID, final String pName, Date pStart, Date pEnd, String pColor, String pLink, int pMile, String pResponsible, int pComp, boolean isGroup, String pParent, int pOpen) {
		fillList(pID, pName, isGroup);
		TaskItem task = TaskItem.create(pID, pName, pStart, pEnd, pColor, pLink, pMile, pResponsible, pComp, isGroup, pParent, pOpen);
		
		return  task;
	}
	private TaskItem createTaskItem(String pID, String pName, Date pStart, Date pEnd, String pColor, String pLink, int pMile, String pResponsible, int pComp, boolean isGroup, String pParent, int pOpen, String pDependsOn) {
		fillList(pID, pName, isGroup);	
		return TaskItem.create(pID, pName, pStart, pEnd, pColor, pLink, pMile, pResponsible, pComp, isGroup, pParent, pOpen, pDependsOn);
	}

	private void fillList(String pID, String pName, boolean isGroup) {
		if(isGroup){
			itemEditPanel.getParentField().addItem(pName, pID);
		}
		itemEditPanel.getDependField().addItem(pName, pID);
	}    	
}