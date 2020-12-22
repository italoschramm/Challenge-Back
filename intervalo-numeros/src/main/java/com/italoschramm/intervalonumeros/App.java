package com.italoschramm.intervalonumeros;

import java.util.ArrayList;
import java.util.List;

/**
 * @author italoschramm
 *
 */
public class App 
{
    public static void main( String[] args ){
    	String numbersEntry = "100, 101, 102, 103, 104, 105, 110, 111, 113, 114, 115, 150";
    	System.out.println(intervalNumbers(numbersEntry));
    }
    
    public static List<List<Integer>> intervalNumbers(String numbersList) {
    	String[] numbers = numbersList.split(", ");
    	List<Integer> listInt = new ArrayList<Integer>();
    	List<List<Integer>> resultList= new ArrayList<List<Integer>>(); 
    	
    	int previousNumber = -1;
    	
    	for(int i = 0; i < numbers.length; i++) {
    		int currentlyNumber = Integer.parseInt(numbers[i]);
    		if(previousNumber !=  currentlyNumber - 1) {
    			if(listInt.isEmpty()) {
    				listInt.add(currentlyNumber);
    			}
    			else {
    				if(listInt.get(0) != previousNumber)
    					listInt.add(previousNumber);
    				resultList.add(listInt);
    				listInt = new ArrayList<Integer>();
    				listInt.add(currentlyNumber);
    			}
    		}
    		previousNumber = currentlyNumber;
    	}
    	if(listInt.size() == 1)
    		resultList.add(listInt);
    	return resultList;
    }
}
    	


