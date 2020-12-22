package com.italoschramm.convertemedidas;

import com.italoschramm.convertemedidas.unidades.EnumUnits;
import com.italoschramm.convertemedidas.unidades.Unity;
import com.italoschramm.convertemedidas.unidades.percentage.Percentage;

import junit.framework.TestCase;

public class PercentageTest extends TestCase{

	public void testConverted() {
		
		Unity unity = new Percentage();
		
		assertEquals(unity.getConverted(EnumUnits.PE, "98"), "0.98");
	}	
	
}
