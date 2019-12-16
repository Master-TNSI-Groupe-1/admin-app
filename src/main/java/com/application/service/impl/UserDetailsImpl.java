package com.application.service.impl;

import com.application.configuration.ErrorMessage;
import com.application.repository.UsersRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(@NotNull final String username) throws AuthenticationException {
        return usersRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(ErrorMessage.userNotFound));
    }
}
