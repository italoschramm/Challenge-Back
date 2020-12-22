package com.italoschramm.convertemedidas.unidades.bytes;

import com.italoschramm.convertemedidas.unidades.EnumUnits;
import com.italoschramm.convertemedidas.unidades.Unity;

public class Byte implements Unity{
	
	@Override
	public String convertUnity(String number) {
		EnumUnits unity = getUnity(number);
		String converted = getConverted(unity, number);
		return converted + " " + unity.getUnity();
	}

	@Override
	public EnumUnits getUnity(String value) {
		Long number = Long.parseLong(value);
		if(number < 1000)
			return EnumUnits.B;
		else if(number < 1000 * 1000)
			return EnumUnits.KB;
		else if(number >= 1000 * 1000)
			return EnumUnits.MB;
		else
			return null;
	}

	@Override
	public String getConverted(EnumUnits unity, String value) {
		String result = "";
		Long number = Long.parseLong(value);
		switch (unity) {
			case B:
				result = String.valueOf(number);
				break;
			case KB:
				result = String.valueOf(number/1000L);
				break;
			case MB:
				result = String.valueOf((number/1000L)/1000L);
				break;
			default:
				break;
		}
		return result;
	}

}
