package com.italoschramm.troco;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Util {

	 public static String formatMoney(double value) {
	    double returnValue = value;
	    DecimalFormat format = new DecimalFormat("###,##0.00");
	    return format.format(returnValue);
	 }
	    
	 public static Map<Double, Integer> orderMap(Map<Double, Integer> map){
	    Map<Double, Integer> orderedMap = new TreeMap<>(Collections.reverseOrder());
	    orderedMap.putAll(map);
	    	
		return orderedMap;
	 }
}
