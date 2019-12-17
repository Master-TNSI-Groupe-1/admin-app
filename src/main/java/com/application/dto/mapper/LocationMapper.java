package com.application.dto.mapper;

import com.application.dto.LocationDTO;
import com.application.dto.PointXYDTO;
import com.application.dto.SensorsDTO;
import com.application.entity.Location;
import com.application.entity.PointXY;
import com.application.entity.Sensors;

public class LocationMapper {

    public static LocationDTO entityToDTO(Location location) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setUrlImage(location.getUrlImage());
        for(PointXY pointXY : location.getPointXYList()) {
            locationDTO.getPointXYList().add(PointXYMapper.entityToDTO(pointXY));
        }
        locationDTO.setName(location.getName());
        locationDTO.setIdLocation(location.getIdLocation());
        locationDTO.setEnabled(location.isEnabled());
        for(Sensors sensors : location.getSensorsList()) {
            locationDTO.getSensorsList().add(SensorsMapper.entityToDTO(sensors));
        }
        return locationDTO;
    }

    public static Location dtoToEntity(LocationDTO locationDTO) {
        Location location = new Location();
        location.setUrlImage(locationDTO.getUrlImage());
        for(PointXYDTO pointXYDTO : locationDTO.getPointXYList()) {
            location.getPointXYList().add(PointXYMapper.dtoToEntity(pointXYDTO));
        }
        location.setName(locationDTO.getName());
        location.setIdLocation(locationDTO.getIdLocation());
        location.setEnabled(locationDTO.isEnabled());
        for(SensorsDTO sensorsDTO : locationDTO.getSensorsList()) {
            location.getSensorsList().add(SensorsMapper.dtoToEntity(sensorsDTO));
        }
        return location;
    }
}
