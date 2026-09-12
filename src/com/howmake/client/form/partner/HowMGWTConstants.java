package com.howmake.client.form.partner;

public class HowMGWTConstants {
	public static final int WINDOW_MODAL_MASK_OPACITY = 5;
	
//	public static final String MASK_CNPJ						= Tradutor.i18n.formMaskCNPJ();
//	public static final String MASK_CPF							= Tradutor.i18n.formMaskCPF();
	public static final String VALID_EMAIL						= "VALID-EMAIL";
	

	public static String GLOBAL_SYSTEM_CONTEXT 					= "";
	public static String GLOBAL_SYSTEM_CONTEXT_MENU 			= "";
	public static String GLOBAL_SYSTEM_CONTEXT_LOJA 			= "";
	

	public static String GLOBAL_FILES_SYSTEM_IMAGE_CONTEXT 		= "";
	public static String GLOBAL_FILES_SYSTEM_IMAGE_CONTEXT_MENU = "";

	public static String DOMINIO_TIPO_GRUPO_ACESSO_PUBLIC 		= "PUBLIC";
	public static String DOMINIO_TIPO_GRUPO_ACESSO_PRIVATE		= "PRIVATE";


	public static String getContextImage(String img){
		return GLOBAL_FILES_SYSTEM_IMAGE_CONTEXT+img;
	}

	public static String getContextImageMenu(String img){
		return GLOBAL_FILES_SYSTEM_IMAGE_CONTEXT_MENU+img;
	}	
}
