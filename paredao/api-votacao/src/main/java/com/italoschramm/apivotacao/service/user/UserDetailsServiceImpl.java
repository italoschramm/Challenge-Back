package com.italoschramm.apivotacao.service.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.italoschramm.apivotacao.model.User;
import com.italoschramm.apivotacao.repository.UserRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
    private UserRepository userRepository;

	public UserDetailsServiceImpl() {
		
	}
	
	@Autowired
    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUserLogin(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        BCryptPasswordEncoder password = new BCryptPasswordEncoder();
        return new org.springframework.security.core.userdetails.User(user.getUsername(), password.encode(user.getPassword()), getAuthorities());
    }
    
    public Collection<? extends GrantedAuthority> getAuthorities(){
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_PRODUCTION"));
		return authorities;
	}
}
