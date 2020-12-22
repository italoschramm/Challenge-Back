package com.italoschramm.troco;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class AppTest extends TestCase{
   
	public void testGetBetterCash() {
		double change = 10.20;
		Map<Double, Integer> mapCash = new HashMap<Double, Integer>();
		mapCash.put(10.0, 1);
		mapCash.put(0.10, 2);
		
		assertEquals(App.getBetterCash(change), mapCash);
		
		change = 3.05;
		mapCash.clear();
		mapCash.put(2.0, 1);
		mapCash.put(1.0, 1);
		mapCash.put(0.05, 1);
		assertEquals(App.getBetterCash(change), mapCash);
		
		change = 88.95;
		mapCash.clear();
		mapCash.put(50.0, 1);
		mapCash.put(20.0, 1);
		mapCash.put(10.0, 1);
		mapCash.put(5.0, 1);
		mapCash.put(2.0, 1);
		mapCash.put(1.0, 1);
		mapCash.put(0.50, 1);
		mapCash.put(0.25, 1);
		mapCash.put(0.10, 2);
		assertEquals(App.getBetterCash(change), mapCash);
	}
	
	public void testGetChange() {
		try {
			assertEquals(App.calcChange(55.60, 100.0), 44.40);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
