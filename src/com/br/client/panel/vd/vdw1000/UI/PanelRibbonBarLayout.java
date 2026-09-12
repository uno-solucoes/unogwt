package com.br.client.panel.vd.vdw1000.UI;

import com.smartgwt.client.widgets.IconButton;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.IconMenuButton;
import com.smartgwt.client.widgets.menu.Menu;

public class PanelRibbonBarLayout extends VLayout{

    protected IconButton getIconButton(String title, String iconName, boolean vertical) {  
        IconButton button = new IconButton(title);  
        button.setTitle(title);  
        button.setIcon("nfs/menu/" + iconName + ".png");  
        button.setLargeIcon("nfe/menu/" + iconName + ".png");  
        if (vertical == true){ 
        	button.setOrientation("vertical");
        }
        return button;  
    }  

    protected IconMenuButton getIconMenuButton(String title, String iconName, Menu menu, boolean vertical) {  
        IconMenuButton button = new IconMenuButton();
        button.setTitle(title);  
        if (iconName == null) 
        	button.setIcon("nfse/menu/" + iconName + ".png");  
        	button.setLargeIcon("nfe/menu/" + iconName + ".png"); 
        if (vertical == true){ 
        	button.setOrientation("vertical");
        }
        if (menu != null){ 
        	button.setMenu(menu);
        }
  
        button.setShowMenuIcon(true);  
        return button;  
    }  

}