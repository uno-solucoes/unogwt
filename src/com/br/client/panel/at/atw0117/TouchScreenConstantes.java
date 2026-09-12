package com.br.client.panel.at.atw0117;

public class TouchScreenConstantes {
	
	public static final int DEFAULT_MAX_DAY								= 10;
	public static final double DEFAULT_PERCENT_AMPLIADO 				= 0.70;
	public static final int DEFAULT_WIDTH_OPTIONS 						= 142;
	public static final int DEFAULT_WIDTH_ACTION_BUTTON_CALENDAR 		= 60;
	public static final int DEFAULT_WIDTH_ACTION_BUTTON_ESPACO_LOCAL	= 170;
	public static final int DEFAULT_HEIGHT_ACTION_BUTTON_ESPACO_LOCAL	= 54;
	
	/**
	 * Define os tipos de áreas de lotação da agenda.
	 */
	public static final int TIPO_ESPACO									= 1;
	public static final int TIPO_LOCAL 									= 2;


	public static String getColorTipoArea(int tipoArea){
		if ( tipoArea == TIPO_ESPACO )
			return "agendaVillaButtonRed";
		else if ( tipoArea == TIPO_LOCAL )
			return "agendaVillaButtonYellow";
		return "agendaVillaButtonNormal";
	}
	
	public static String getImageTipoArea(int tipoArea){
		if ( tipoArea == TIPO_ESPACO )
			return "agenda/actionDescricaoRed.png";
		else if ( tipoArea == TIPO_LOCAL )
			return "agenda/actionDescricaoYellow.png";
		return "action/actionDescricaoNormal.png";
	}
	
}