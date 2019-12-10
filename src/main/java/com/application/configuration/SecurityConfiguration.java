package com.application.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{

	@Autowired
    PasswordEncoder passwordEncoder;
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("Jimmy").password(passwordEncoder.encode("Trackoen")).roles("admin");
		auth.inMemoryAuthentication().withUser("Simon").password(passwordEncoder.encode("testeur")).roles("admin");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic()
		.and()
			.authorizeRequests()
				.antMatchers( "/" , "/test").permitAll()

			.antMatchers("/authenticated")
				.authenticated().and()
				.csrf().disable()
				.logout()
				.logoutSuccessUrl("/").and()
				.rememberMe();
	}
	
	
	 
	@Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    
}
