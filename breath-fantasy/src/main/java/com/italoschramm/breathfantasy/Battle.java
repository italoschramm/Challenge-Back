package com.italoschramm.breathfantasy;

import java.util.Random;

public class Battle {

	private Hero hero1;
	
	private Hero hero2;
	
	private LocaleLanguage language = LocaleLanguage.getInstance();
	
	public Battle(Hero hero1, Hero hero2) {
		this.hero1 = hero1;
		this.hero2 = hero2;
	}
	
	public void initBattle() {
		System.out.println(language.getMessage("the.game.started"));
		System.out.println(language.getMessage("battle.between.hero1.and.hero2", hero1.getName(),hero2.getName()));
		boolean endFight = false;
		int round = 0;
		while(!endFight) {
			round ++;
			if(EnumTurnHero.HERO1 == EnumTurnHero.get(round))
				endFight = attack(hero1, hero2);
			else
				endFight = attack(hero2, hero1);	
		}
			
	}
	
	public boolean attack(Hero attacker, Hero defender) {
		System.out.println(language.getMessage("attacked", hero1.getName(), hero2.getName()));
		defender.setEnergyPoints(defender.getEnergyPoints() - getDamage(attacker.getPowerPoints()));

		if(defender.getEnergyPoints() <= 0) {
			attacker.setWon(true);
			System.out.println(language.getMessage("game.is.over.the.winner", attacker.getName(), String.valueOf(attacker.getEnergyPoints())));
		}
			
		
		return hero1.isWon() || hero2.isWon() ? true : false;
	}
	
	public int getDamage(int powerPoints) {
		Random generator = new Random();
		int luckNumber = generator.nextInt(100);
		int resultPoints = powerPoints;
		int damage = 0;
		if((luckNumber >= 0) && (luckNumber <= 15)) {
			System.out.println(language.getMessage("luck.error"));
		}else if((luckNumber >= 16) && (luckNumber <= 70)) {
			damage = (resultPoints/3);
			LocaleLanguage.getInstance();
			System.out.println(language.getMessage("luck.normal", String.valueOf(damage)));
		}else if((luckNumber >= 71) && (luckNumber <= 96)) {
			damage = ((resultPoints/3) * 20/100) + (resultPoints/3);
			System.out.println(language.getMessage("luck.luck", String.valueOf(damage)));
		}else {
			damage = (resultPoints/3) * 2;
			System.out.println(language.getMessage("luck.critical", String.valueOf(damage)));
		}
		return damage;
	}
	
}
