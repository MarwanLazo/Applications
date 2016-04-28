package com.sprapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {
	  @Autowired
	    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication().withUser("bill").password("root123").roles("USER");
	        auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
	        auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");//dba have two roles.
	    }
	     
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	  
	      http.authorizeRequests()
	       
	        .antMatchers("/rest/admin/**").access("hasRole('ADMIN')")
	        .antMatchers("/rest/dba/**").access("hasRole('DBA') ") //and hasRole('')
	        .and().formLogin()
	        .and().httpBasic();
	  
	    }

}
