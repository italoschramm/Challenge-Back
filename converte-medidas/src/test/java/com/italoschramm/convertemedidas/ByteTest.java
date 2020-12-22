package com.italoschramm.convertemedidas;

import com.italoschramm.convertemedidas.unidades.EnumUnits;
import com.italoschramm.convertemedidas.unidades.Unity;
import com.italoschramm.convertemedidas.unidades.bytes.Byte;

import junit.framework.TestCase;

public class ByteTest extends TestCase{

	public void testGetUnity() {
		
		Unity unity = new Byte();
		
		assertEquals(unity.getUnity("999"), EnumUnits.B);
		assertEquals(unity.getUnity("999999"), EnumUnits.KB);
		assertEquals(unity.getUnity("1000000"), EnumUnits.MB);
	}
	
	public void testConverted() {
		
		Unity unity = new Byte();
		
		assertEquals(unity.getConverted(EnumUnits.B, "999"), "999");
		assertEquals(unity.getConverted(EnumUnits.KB, "200000"), "200");
		assertEquals(unity.getConverted(EnumUnits.MB, "200000000"), "200");
	}	
}
