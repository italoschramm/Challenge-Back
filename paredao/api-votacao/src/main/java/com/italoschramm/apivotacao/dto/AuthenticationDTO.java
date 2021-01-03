package com.italoschramm.apivotacao.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class AuthenticationDTO {

	private String token;
	
	private String[] authorizations;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public void setAuthorizations(String[] authorizations) {
		this.authorizations = authorizations;
	}

	public String[] getAuthorizations() {
		return authorizations;
	}
	
	public void setAuthorizations(Collection<? extends GrantedAuthority> authorizations) {
		int i = 0;
		this.authorizations = new String[authorizations.size()];
		for(GrantedAuthority auth: authorizations) {
			this.authorizations[i] = auth.getAuthority();
			i ++;
		}
	}
	

//	public Collection<? extends GrantedAuthority> getAuthorizations() {
//		return authorizations;
//	}
//
//	public void setAuthorizations(Collection<? extends GrantedAuthority> authorizations) {
//		this.authorizations = authorizations;
//	}
//	
}
