package com.italoschramm.convertemedidas;


import com.italoschramm.convertemedidas.unidades.EnumUnits;
import com.italoschramm.convertemedidas.unidades.Unity;
import com.italoschramm.convertemedidas.unidades.time.Time;

import junit.framework.TestCase;

public class TimeTest extends TestCase{

	public void testGetUnity() {
		
		Unity unity = new Time();
		
		assertEquals(unity.getUnity("999"), EnumUnits.MS);
		assertEquals(unity.getUnity("10000"), EnumUnits.S);
		assertEquals(unity.getUnity("100000"), EnumUnits.MIN);
		assertEquals(unity.getUnity("10000000"), EnumUnits.H);
	}
	
	public void testConverted() {
		
		Unity unity = new Time();
		
		assertEquals(unity.getConverted(EnumUnits.MS, "999"), "999");
		assertEquals(unity.getConverted(EnumUnits.S, "10000"), "10");
		assertEquals(unity.getConverted(EnumUnits.MIN, "120000"), "2");
		assertEquals(unity.getConverted(EnumUnits.H, "7200000"), "2");
	}
}
