package com.italoschramm.apivotacao.service.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.italoschramm.apivotacao.model.User;

public interface UserService {

	
	public User getUserById(long idUser);
	public boolean registerUser(String email, String password, byte accountType);
	public boolean existsUser(String username);
	public boolean login(String username, String password);
	public Collection<? extends GrantedAuthority> getAuthorities(String user);
}
