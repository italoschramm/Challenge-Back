package com.italoschramm.breathfantasy;

import junit.framework.TestCase;

public class BattleTest extends TestCase{
	
	public void testGetDamage() {
		Hero hero1 = new Hero("Hero1", 100, 100);
		Hero hero2 = new Hero("Hero2", 100, 100);
		
		Battle battle = new Battle(hero1, hero2);
		
		int powerPoints = battle.getDamage(hero1.getPowerPoints());
		
		assertTrue((powerPoints == 0)  ||
				   (powerPoints == 33)	||
				   (powerPoints == 39) ||
				   (powerPoints == 66));
	}
	
}
