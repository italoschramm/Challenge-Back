package com.italoschramm.breathfantasy;

public enum EnumTurnHero {
	
	HERO1,
    HERO2;
	
	public static EnumTurnHero get(int round) {
		if(round % 2 == 0)
			return HERO2;
		else
			return HERO1;
	}
}
