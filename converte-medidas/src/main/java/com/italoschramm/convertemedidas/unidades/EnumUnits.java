package com.italoschramm.convertemedidas.unidades;

import com.italoschramm.convertemedidas.unidades.bytes.Byte;
import com.italoschramm.convertemedidas.unidades.percentage.Percentage;
import com.italoschramm.convertemedidas.unidades.time.Time;

public enum EnumUnits {

	MS("ms"),
	S("s"),
	MIN("min"),
	H("h"),
	B("b"),
	KB("kb"),
	MB("mb"),
	PE("%");
	
	private String unity;
	
	private EnumUnits(String unity) {
		this.unity = unity;
	}

	public String getUnity() {
		return unity;
	}

	public void setUnity(String unity) {
		this.unity = unity;
	}
	
	public static Unity getService(String unity) {	
		if(EnumUnits.MS.getUnity().equals(unity.toLowerCase()))
			return new Time();
		else if(EnumUnits.B.getUnity().equals(unity.toLowerCase()))
			return new Byte();
		else
			return new Percentage();
	}
	
	public static EnumUnits getUnit(String unity) {
		for (EnumUnits enm : EnumUnits.values()) {
			if(enm.unity.equals(unity.toLowerCase())){
				return enm;
			}
		}
		return null;
	}
}
