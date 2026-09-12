package com.howmake.client.form.partner;

import com.google.gwt.user.client.Window;

public class HowMGWTNavigator {
	static final String[] MOBILE_SPECIFIC_SUBSTRING = {  
	      "iPhone","Android","MIDP","Opera Mobi",  
	      "Opera Mini","BlackBerry","HP iPAQ","IEMobile",  
	      "MSIEMobile","Windows Phone","HTC","LG",  
	      "MOT","Nokia","Symbian","Fennec",  
	      "Maemo","Tear","Midori","armv",  
	      "Windows CE","WindowsCE","Smartphone","240x320",  
	      "176x220","320x320","160x160","webOS",  
	      "Palm","Sagem","Samsung","SGH",  
	      "SIE","SonyEricsson","MMP","UCWEB"
	}; 
	
    /**
     * @return retorna true se estiver executando em um browser mobile.
     */
    public static boolean isMobile() {  
          String userAgent = Window.Navigator.getUserAgent();  
         for (String mobile: MOBILE_SPECIFIC_SUBSTRING){  
               if (userAgent.contains(mobile)  
                 || userAgent.contains(mobile.toUpperCase())  
                 || userAgent.contains(mobile.toLowerCase())){  
                      return true;  
              }  
         }  
         return false;  
    }  
    
    public static boolean isTabbletApple(){
    	return false;
    }
    
    public static boolean isTabbletGalaxy(){
    	return false;
    }
    
    public static boolean isSafari(){
    	return !isChrome() && Window.Navigator.getUserAgent().indexOf("Safari") >= 0;    
    }
    
    public static boolean isIE(){
    	return Window.Navigator.getAppName().trim().equalsIgnoreCase( "Microsoft Internet Explorer");
    }
    
    public static boolean isFirefox(){
    	return Window.Navigator.getUserAgent().indexOf("Firefox") >= 0;
    }
    
    public static boolean isChrome(){   	
    	return Window.Navigator.getUserAgent().indexOf("Chrome") >= 0;
    }
    
    
    public static void showAgentBrowser(){
    	String navigator = "";
    	navigator += "Browser  : "+Window.Navigator.getUserAgent();
    	navigator += "\n";
    	navigator += "System   : "+Window.Navigator.getPlatform();
    	navigator += "\n";
    	navigator += "Version  : "+Window.Navigator.getAppVersion();
    	navigator += "\n";
    	navigator += "Cod Name : "+Window.Navigator.getAppCodeName();
    	navigator += "\n";
    	navigator += "App Name : "+Window.Navigator.getAppName();
    	Window.alert(navigator);
    }
    
}