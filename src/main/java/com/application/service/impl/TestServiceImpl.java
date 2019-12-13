package com.application.service.impl;

import com.application.consumer.TestConsumer;
import com.application.dto.Test;
import com.application.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestConsumer testConsumer;

    @Override
    public List<Test> getAllTest() {
        return testConsumer.getAllTest();
    }
}
