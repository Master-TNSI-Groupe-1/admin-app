package com.application.dto.mapper;

import com.application.dto.SensorsDTO;
import com.application.entity.Sensors;

public class SensorsMapper {

    public static SensorsDTO entityToDTO(Sensors sensors) {
        SensorsDTO sensorsDTO = new SensorsDTO();
        sensorsDTO.setEnabled(sensors.isEnabled());
        sensorsDTO.setIdSensor(sensors.getIdSensor());
        sensorsDTO.setInput(sensors.isInput());
        sensorsDTO.setIpConfig(sensors.getIpConfig());
        return sensorsDTO;
    }

    public static Sensors dtoToEntity(SensorsDTO sensorsDTO) {
        Sensors sensors = new Sensors();
        sensors.setEnabled(sensorsDTO.isEnabled());
        sensors.setIdSensor(sensorsDTO.getIdSensor());
        sensors.setInput(sensorsDTO.isInput());
        sensors.setIpConfig(sensorsDTO.getIpConfig());
        return sensors;
    }
}
