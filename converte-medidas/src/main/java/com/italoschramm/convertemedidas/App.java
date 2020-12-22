package com.italoschramm.convertemedidas;

import java.util.Scanner;

import com.italoschramm.convertemedidas.unidades.EnumUnits;
import com.italoschramm.convertemedidas.unidades.Unity;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc1 = new Scanner(System.in);
    	System.out.println("Digite o valor e medida:");
    	String[] value = sc1.nextLine().split(" ");
    	
    	int posArray = value.length == 2 ? 1 : 0;
    	Unity unity = EnumUnits.getService(value[posArray]);
    	System.out.println(unity.convertUnity(value[0]));
    	sc1.close();
    }
}
