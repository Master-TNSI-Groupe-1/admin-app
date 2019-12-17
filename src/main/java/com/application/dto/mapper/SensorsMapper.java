package com.application.dto.mapper;

import com.application.dto.PointXYDTO;
import com.application.dto.SensorsDTO;
import com.application.entity.PointXY;
import com.application.entity.Sensors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SensorsMapper {

    public static SensorsDTO entityToDTO(Sensors sensors) {
        SensorsDTO sensorsDTO = new SensorsDTO();
        sensorsDTO.setEnabled(sensors.isEnabled());
        sensorsDTO.setIdSensor(sensors.getIdSensor());
        sensorsDTO.setInput(sensors.isInput());
        sensorsDTO.setIpConfig(sensors.getIpConfig());
        return sensorsDTO;
    }

    public static Collection<SensorsDTO> entityToDTO(Collection<Sensors> sensors) {
        List<SensorsDTO> sensorsDTOs = new ArrayList<>();
        for (Sensors sensor : sensors) {
            sensorsDTOs.add(entityToDTO(sensor));
        }
        return sensorsDTOs;
    }

    public static Sensors dtoToEntity(SensorsDTO sensorsDTO) {
        Sensors sensors = new Sensors();
        sensors.setEnabled(sensorsDTO.isEnabled());
        sensors.setIdSensor(sensorsDTO.getIdSensor());
        sensors.setInput(sensorsDTO.isInput());
        sensors.setIpConfig(sensorsDTO.getIpConfig());
        return sensors;
    }

    public static Collection<Sensors> dtoToEntity(Collection<SensorsDTO> sensorsDTOs) {
        List<Sensors> sensors = new ArrayList<>();
        for (SensorsDTO sensorsDTO : sensorsDTOs) {
            sensors.add(dtoToEntity(sensorsDTO));
        }
        return sensors;
    }
}
