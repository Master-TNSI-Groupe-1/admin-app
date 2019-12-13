package com.application.consumer.impl;

import com.application.consumer.UserConsumer;
import com.application.dto.UsersDTO;
import com.application.utils.BCryptManagerUtil;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserConsumerImpl implements UserConsumer {

    @Override
    public Optional<UsersDTO> getUserByUsername(final String username) {
        Optional<UsersDTO> usersDTO = Optional.empty();
        //TODO MOCK
        if(username.equals("Pierre")) {
            usersDTO = Optional.of(new UsersDTO());
            usersDTO.get().setIdUser(1);
            usersDTO.get().setIdSite(2);
            usersDTO.get().setUserName(username);
            usersDTO.get().setPassword(BCryptManagerUtil.passwordencoder().encode("test"));
            usersDTO.get().setFirstName("Pierre");
            usersDTO.get().setLastName("Candelier");
            usersDTO.get().setEnabled(true);
        }
        return usersDTO;
    }

//    public List<Test> getAllTest() {
//        ResponseEntity<List<Test>> response = restTemplate.exchange(
//                ApiEndPoint.GET_EMPLOYEES_ENDPOINT_URL,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<>(){});
//        return response.getBody();
//    }
}
