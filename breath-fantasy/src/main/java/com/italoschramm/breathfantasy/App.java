package com.italoschramm.breathfantasy;

import java.util.Scanner;

public class App {
	
	private static LocaleLanguage language = LocaleLanguage.getInstance();
	
    public static void main( String[] args ){	
    	
    	Scanner sc1 = new Scanner(System.in);
    	System.out.println(language.getMessage("enter.first.character"));
    	String[] value1 = sc1.nextLine().split(" ");
    	Hero hero1 = new Hero(value1[0], Integer.parseInt(value1[1]), Integer.parseInt(value1[2])); 
    	
    	System.out.println(language.getMessage("enter.second.character"));
    	String[] value2 = sc1.nextLine().split(" ");
    	Hero hero2 = new Hero(value2[0], Integer.parseInt(value2[1]), Integer.parseInt(value2[2])); 
    	
    	Battle battle = new Battle(hero1, hero2);
    	battle.initBattle();
    	sc1.close();
    	
    }
}
