package com.application.consumer;

import com.application.dto.UsersDTO;

import java.util.Optional;

public interface UserConsumer {

    Optional<UsersDTO> getUserByUsername(final String username);
}
