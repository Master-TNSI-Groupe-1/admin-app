package com.application.service.impl;

import com.application.entity.Users;
import com.application.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class IUserService implements UserService {

    @Override
    public Users getLoggedUser() {
        return (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
