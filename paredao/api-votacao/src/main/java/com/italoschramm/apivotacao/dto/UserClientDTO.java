package com.italoschramm.apivotacao.dto;

public class UserClientDTO {
	
	private String username;
	private String password;
	private byte accountType;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getAccountType() {
		return accountType;
	}

	public void setAccountType(byte accountType) {
		this.accountType = accountType;
	}

}
