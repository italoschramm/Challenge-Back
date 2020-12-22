package com.italoschramm.apivotacao.model;

public enum EnumAccountType {

	PRODUCTION((byte) 1),
	VOTER((byte) 0);
	
	private byte code;
	
	private EnumAccountType(byte code) {
		this.code = code;
	}

	public byte getCode() {
		return code;
	}

	public void setCode(byte code) {
		this.code = code;
	}

}
