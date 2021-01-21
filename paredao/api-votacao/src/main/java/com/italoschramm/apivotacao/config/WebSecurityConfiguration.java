package com.italoschramm.apivotacao.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.italoschramm.apivotacao.service.user.UserDetailsServiceImpl;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
    
	@Bean
	public UserDetailsServiceImpl userDetailsService() {
	    return new UserDetailsServiceImpl();
	};
	
    private static final String[] AUTH_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/h2",
            "/h2/**",
            "/h2/header.jsp?",
            "/h2/*",
            "/h2/login.do?jsessionid=",
			"/h2-console/**",
			"/console/*"
     };

    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable().cors().and().authorizeRequests()
        		.antMatchers(HttpMethod.GET, "/system/**").access("hasRole('PRODUCTION')")
        		.antMatchers(HttpMethod.GET, "/system/version").access("hasRole('PRODUCTION')")
        		.antMatchers(HttpMethod.GET, "/system").access("hasRole('PRODUCTION')")
        		.antMatchers(HttpMethod.GET, "/system/*").access("hasRole('PRODUCTION')")
        		.antMatchers("/participant/**").hasRole("PRODUCTION")
        		.antMatchers(HttpMethod.POST, "/user/register").permitAll()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .anyRequest().authenticated()
                .and().addFilter(new AuthenticationFilter(authenticationManager()))
                .addFilter(new AuthorizationFilter(authenticationManager(), getApplicationContext()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.headers().frameOptions().disable();
    }

    public void configure(AuthenticationManagerBuilder auth) throws Exception{
    	auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }
    
    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration cors = new CorsConfiguration();
        List<String> methodsAllowed = new ArrayList<String>();
        methodsAllowed.add(HttpMethod.GET.name());
        methodsAllowed.add(HttpMethod.POST.name());
        methodsAllowed.add(HttpMethod.DELETE.name());
        methodsAllowed.add(HttpMethod.PUT.name());
        cors.setAllowedMethods(methodsAllowed);
        cors.applyPermitDefaultValues();
        source.registerCorsConfiguration("/**", cors);
        return source;
    }
    
}
