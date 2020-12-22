package com.italoschramm.convertemedidas.unidades;

public interface Unity {

	public String convertUnity(String number);
	
	public EnumUnits getUnity(String value);
	
	public String getConverted(EnumUnits unity, String value);
}
