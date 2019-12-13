package com.application.service;

import com.application.configuration.ErrorMessage;
import com.application.consumer.UserConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserConsumer userConsumer;

    @Override
    public UserDetails loadUserByUsername(@NotNull final String username) throws AuthenticationException {
        return userConsumer.getUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(ErrorMessage.userNotFound));
    }
}
