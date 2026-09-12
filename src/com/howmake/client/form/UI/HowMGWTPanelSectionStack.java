package com.howmake.client.form.UI;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;

public class HowMGWTPanelSectionStack extends SectionStack{

	SectionStackSection session = new SectionStackSection();

	
	public HowMGWTPanelSectionStack(String title,  Canvas canvas, boolean colapse, boolean expanded){
	    // ---------------------------------------------------------------- 
			session.setCanCollapse(colapse);
	    
			session.setExpanded(expanded);
			session.setShowHeader(true);
			session.setTitle(title);
			
	        canvas.setWidth100();
	        canvas.setHeight100();
	        
	        session.setItems(canvas);
	   
			this.setSections(session); 
		}
	
	public HowMGWTPanelSectionStack(String title,  Canvas canvas){
    // ---------------------------------------------------------------- 
//		session.setCanCollapse(false);
//    
//		session.setExpanded(true);
//		session.setShowHeader(true);
//		session.setTitle(title);
//		
//        canvas.setWidth100();
//        canvas.setHeight100();
//        
//        session.setItems(canvas);
//   
//		this.setSections(session); 
		this(title,canvas,false, true);
	}

	/**
	 * @return the session
	 */
	public SectionStackSection getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(SectionStackSection session) {
		this.session = session;
	}
	
	
}
