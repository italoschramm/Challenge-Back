package com.italoschramm.breathfantasy;

public class Hero {
	
	private String name;
	
	private int energyPoints;
	
	private int powerPoints;
	
	private boolean won;
	
	public Hero(String name, int energyPoints, int powerPoints) {
		this.name = name;
		this.energyPoints = energyPoints;
		this.powerPoints = powerPoints;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEnergyPoints() {
		return energyPoints;
	}

	public void setEnergyPoints(int energyPoints) {
		this.energyPoints = energyPoints;
	}

	public int getPowerPoints() {
		return powerPoints;
	}

	public void setPowerPoints(int powerPoints) {
		this.powerPoints = powerPoints;
	}

	public boolean isWon() {
		return won;
	}

	public void setWon(boolean won) {
		this.won = won;
	}

}
