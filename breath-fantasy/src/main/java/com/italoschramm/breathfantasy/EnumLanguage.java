package com.italoschramm.breathfantasy;

import java.util.Locale;

public enum EnumLanguage {

	PT_BR((byte) 0, new Locale("pt","BR")),
	EN_US((byte) 1, Locale.US),
	ES_SP((byte) 2, new Locale("es", "SP")),
    FR_FR((byte) 3, Locale.FRENCH);
	
	private Locale locale;
	private byte codigo;
	
	private EnumLanguage(byte codigo, Locale locale) {
		this.locale = locale;
		this.codigo = codigo;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	public static EnumLanguage getLanguage(byte codigo) {
		for (EnumLanguage enm : EnumLanguage.values()) {
			if(enm.codigo == codigo){
				return enm;
			}
		}
		return null;
	}
}
