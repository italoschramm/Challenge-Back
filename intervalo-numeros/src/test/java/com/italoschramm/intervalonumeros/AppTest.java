package com.italoschramm.intervalonumeros;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class AppTest  extends TestCase{

	public void testIntervalNumbers() {
		String numbersEntry = "1, 2, 3, 5, 6, 7, 8, 70, 71, 72, 88, 90";
		List<List<Integer>> listResult = new ArrayList<List<Integer>>();
		List<Integer> simpleList = new ArrayList<Integer>();
		simpleList.add(1);
		simpleList.add(3);
		listResult.add(simpleList);
		
		simpleList = new ArrayList<Integer>();
		simpleList.add(5);
		simpleList.add(8);
		listResult.add(simpleList);
		
		simpleList = new ArrayList<Integer>();
		simpleList.add(70);
		simpleList.add(72);
		listResult.add(simpleList);
		
		simpleList = new ArrayList<Integer>();
		simpleList.add(88);
		listResult.add(simpleList);
		
		simpleList = new ArrayList<Integer>();
		simpleList.add(90);
		listResult.add(simpleList);
		
		assertEquals(App.intervalNumbers(numbersEntry), listResult);
	}
}
