package com.application.dto.mapper;

import com.application.dto.UsersDTO;
import com.application.entity.Users;

public class UsersMapper {

    public static UsersDTO entityToDTO(Users users) {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setEnabled(users.isEnabled());
        usersDTO.setFirstname(users.getFirstname());
        usersDTO.setLastname(users.getLastname());
        usersDTO.setUsername(users.getUsername());
        usersDTO.setIdUser(users.getIdUser());
        usersDTO.setSite(SiteMapper.entityToDTO(users.getSite()));
        return usersDTO;
    }

    public static Users dtoToEntity(UsersDTO usersDTO) {
        Users users = new Users();
        users.setEnabled(usersDTO.isEnabled());
        users.setFirstname(usersDTO.getFirstname());
        users.setIdUser(usersDTO.getIdUser());
        users.setLastname(usersDTO.getLastname());
        users.setUsername(usersDTO.getUsername());
        users.setSite(SiteMapper.dtoToEntity(usersDTO.getSite()));
        return users;
    }
}
