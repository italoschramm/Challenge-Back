package com.italoschramm.convertemedidas.unidades.percentage;

import com.italoschramm.convertemedidas.unidades.EnumUnits;
import com.italoschramm.convertemedidas.unidades.Unity;

public class Percentage implements Unity{

	@Override
	public String convertUnity(String number) {
		EnumUnits unity = getUnity(number);
		String converted = getConverted(unity, number);
		return converted + " " + unity.getUnity();
	}

	@Override
	public EnumUnits getUnity(String value) {
		return EnumUnits.PE;
	}

	@Override
	public String getConverted(EnumUnits unity, String value) {
		double number = Double.parseDouble(value)/100;
		return String.valueOf(number);
	}

}
