package com.application.consumer;

import com.application.entity.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class TestConsumer {

    private final static String GET_EMPLOYEES_ENDPOINT_URL = "https://gturnquist-quoters.cfapps.io/api";
    private static RestTemplate restTemplate = new RestTemplate();

    public List<Test> getAllTest() {
        ResponseEntity<List<Test>> response = restTemplate.exchange(
                GET_EMPLOYEES_ENDPOINT_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>(){});
        return response.getBody();
    }
}
