package com.application.consumer;

import com.application.configuration.ApiEndPoint;
import com.application.dto.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class TestConsumer {

    private static RestTemplate restTemplate = new RestTemplate();

    public List<Test> getAllTest() {
        ResponseEntity<List<Test>> response = restTemplate.exchange(
                ApiEndPoint.GET_EMPLOYEES_ENDPOINT_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>(){});
        return response.getBody();
    }
}
