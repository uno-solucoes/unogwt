package com.br.client.panel.aj.ajw0001;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.RichTextEditor;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

public class PainelEditar extends VLayout{
	RichTextEditor richTextEditor = new RichTextEditor();  
    IButton button = new IButton("Gravar");  
	
    public PainelEditar(){
		richTextEditor.setHeight(155);  
	    richTextEditor.setOverflow(Overflow.AUTO);  
	    richTextEditor.setCanDragResize(true);  
	    richTextEditor.setShowEdges(true);  
	    
	    
	    button.setWidth(100);  
	    button.addClickHandler(new ClickHandler(){  
	        public void onClick(ClickEvent event) {  
	        }
	    });  
    }
}
