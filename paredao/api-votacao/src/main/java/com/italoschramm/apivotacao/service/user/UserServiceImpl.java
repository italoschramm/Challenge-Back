package com.italoschramm.apivotacao.service.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.italoschramm.apivotacao.model.EnumRoles;
import com.italoschramm.apivotacao.model.User;
import com.italoschramm.apivotacao.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getUserById(long idUser) {
		User user = userRepository.findById(idUser).orElse(null); 
		return user;
	}
	
	@Override
	public boolean registerUser(String username, String password, byte accountType) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setAccountType(accountType);
		try {
			userRepository.save(user);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean existsUser(String login) {
		User userConsult = userRepository.findByUserLogin(login);
		if(userConsult != null)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean login(String username, String password) {
		User userConsult = userRepository.findByLoginPassword(username, password);
		if(userConsult != null)
			return true;
		else
			return false;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(String user){
    	Set<SimpleGrantedAuthority> authorities = new HashSet<>();
    	User userResult = userRepository.findByUserLogin(user);
    	if(userResult != null) {
    		if(userResult.getAccountType() == 1)
    			authorities.add(new SimpleGrantedAuthority(EnumRoles.PRODUCTION.getRole()));
    		else
    			authorities.add(new SimpleGrantedAuthority(EnumRoles.VOTER.getRole()));
    	}
    	return authorities;
	}
}
