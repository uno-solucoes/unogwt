package com.howmake.client.form.partner;

public interface HowMGWTFormField {
	public void setHowMValue(Object value);
	public Object getHowMValue();
	public String getHowMValueAsString();
	public void setHowMBound(int widthLabel, int widthField);
	public void setHowMDisable(Boolean disabled);
	public String getHowMLabelTitle();
}
