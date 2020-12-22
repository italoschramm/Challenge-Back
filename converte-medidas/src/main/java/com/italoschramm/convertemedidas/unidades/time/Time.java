package com.italoschramm.convertemedidas.unidades.time;

import java.util.concurrent.TimeUnit;

import com.italoschramm.convertemedidas.unidades.EnumUnits;
import com.italoschramm.convertemedidas.unidades.Unity;

public class Time implements Unity{
	
	@Override
	public String convertUnity(String number) {
		EnumUnits unity = getUnity(number);
		String converted = getConverted(unity, number);
		return converted + " " + unity.getUnity();
	}
	
	public EnumUnits getUnity(String value) {
		Long number = Long.parseLong(value);
		if(TimeUnit.MILLISECONDS.toSeconds(number) < 1)
			return EnumUnits.MS;
		else if(TimeUnit.MILLISECONDS.toSeconds(number) < 60)
			return EnumUnits.S;
		else if(TimeUnit.MILLISECONDS.toMinutes(number) < 60)
			return EnumUnits.MIN;
		else if(TimeUnit.MILLISECONDS.toMinutes(number) >= 60)
			return EnumUnits.H;
		else
			return null;
	}
	
	public String getConverted(EnumUnits unity, String value) {
		String result = "";
		Long number = Long.parseLong(value);
		switch (unity) {
			case MS:
				result = String.valueOf(number);
				break;
			case S:
				result = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(number));
				break;
			case MIN:
				result = String.valueOf(TimeUnit.MILLISECONDS.toMinutes(number));
				break;
			case H:
				result = String.valueOf(TimeUnit.MILLISECONDS.toHours(number));
				break;
			default:
				break;
		}
		return result;
	}

}
