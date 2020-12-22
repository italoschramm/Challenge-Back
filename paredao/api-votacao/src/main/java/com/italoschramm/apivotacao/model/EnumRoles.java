package com.italoschramm.apivotacao.model;

public enum EnumRoles {

	PRODUCTION("ROLE_PRODUCTION"),
	VOTER("ROLE_VOTER");
	
	private final String role;
	
	private EnumRoles(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}
