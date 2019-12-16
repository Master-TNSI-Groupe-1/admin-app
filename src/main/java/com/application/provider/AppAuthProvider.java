package com.application.provider;


import com.application.configuration.ErrorMessage;
import com.application.service.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class AppAuthProvider extends DaoAuthenticationProvider {

    @Autowired
    UserDetailsImpl userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        String name = auth.getName();

        UserDetails user = userService.loadUserByUsername(name);
        if (user == null) {
            throw new BadCredentialsException(ErrorMessage.badCredential);
        }
        return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}