package com.italoschramm.apivotacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IDUSER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE_USER")
	@SequenceGenerator(name="SEQUENCE_USER", sequenceName="SEQ_USER", allocationSize=1)
	private long id;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "ACCOUNTTYPE")
	private byte accountType; 
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
