package com.application.configuration;

import com.application.provider.AppAuthProvider;
import com.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{

	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final int MAXIMUM_SESSIONS = 1;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf();

		// The pages does not require login
		http.authorizeRequests().antMatchers(PageURL.all, PageURL.login, PageURL.loginError, PageURL.css, PageURL.js, PageURL.webjars).permitAll();

		// If no login, it will redirect to /login page.
		http.authorizeRequests().anyRequest().authenticated();

		// Config for Login Form
		http.authorizeRequests().and().authenticationProvider(getProvider())
				.formLogin().loginPage(PageURL.login).defaultSuccessUrl(PageURL.home).failureUrl(PageURL.loginError)
				.usernameParameter(USERNAME).passwordParameter(PASSWORD)
				.and()
				// Config for Logout Page
				.logout().invalidateHttpSession(true).logoutUrl(PageURL.logout).logoutSuccessUrl(PageURL.login);
		// config number session
		http.sessionManagement().maximumSessions(MAXIMUM_SESSIONS).expiredUrl(PageURL.login);
	}

	@Bean
	public AuthenticationProvider getProvider() {
		AppAuthProvider provider = new AppAuthProvider();
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}


	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
