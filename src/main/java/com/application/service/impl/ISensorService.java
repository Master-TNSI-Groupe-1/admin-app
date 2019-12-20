package com.application.service.impl;

import com.application.entity.Sensors;
import com.application.repository.SensorsRepository;
import com.application.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ISensorService implements SensorService {

    @Autowired
    SensorsRepository sensorsRepository;

    @Override
    public void update(final Sensors sensors) {
        sensorsRepository.save(sensors);
    }
}
