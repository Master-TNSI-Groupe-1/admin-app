package com.application.service.impl;

import com.application.dto.UsersDTO;
import com.application.dto.mapper.UsersMapper;
import com.application.entity.Users;
import com.application.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UsersDTO getLoggedUser() {
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return UsersMapper.entityToDTO(users);
    }
}
