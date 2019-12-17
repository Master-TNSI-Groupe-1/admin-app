package com.application.dto.mapper;

import com.application.dto.LocationDTO;
import com.application.entity.Location;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LocationMapper {

    public static LocationDTO entityToDTO(Location location) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setUrlImage(location.getUrlImage());
        if(CollectionUtils.isNotEmpty(location.getPointXYList())) {
            locationDTO.setPointXYList(new ArrayList<>(PointXYMapper.entityToDTO(location.getPointXYList())));
        }
        locationDTO.setName(location.getName());
        locationDTO.setIdLocation(location.getIdLocation());
        locationDTO.setEnabled(location.isEnabled());
        if(CollectionUtils.isNotEmpty(location.getSensorsList())) {
            locationDTO.setSensorsList(new ArrayList<>(SensorsMapper.entityToDTO(location.getSensorsList())));
        }
        locationDTO.setNumberPlaces(location.getNumberPlaces());
        locationDTO.setNumberUser(location.getNumberUser());
        return locationDTO;
    }

    public static Collection<LocationDTO> entityToDTO(Collection<Location> locations) {
        List<LocationDTO> locationDTOS = new ArrayList<>();
        for (Location location : locations) {
            locationDTOS.add(entityToDTO(location));
        }
        return locationDTOS;
    }


    public static Location dtoToEntity(LocationDTO locationDTO) {
        Location location = new Location();
        location.setUrlImage(locationDTO.getUrlImage());
        if(CollectionUtils.isNotEmpty(locationDTO.getPointXYList())) {
            location.setPointXYList(new ArrayList<>(PointXYMapper.dtoToEntity(locationDTO.getPointXYList())));
        }
        location.setName(locationDTO.getName());
        location.setIdLocation(locationDTO.getIdLocation());
        location.setEnabled(locationDTO.isEnabled());
        if(CollectionUtils.isNotEmpty(locationDTO.getSensorsList())) {
            location.setSensorsList(new ArrayList<>(SensorsMapper.dtoToEntity(locationDTO.getSensorsList())));
        }
        location.setNumberPlaces(locationDTO.getNumberPlaces());
        location.setNumberUser(locationDTO.getNumberUser());
        return location;
    }

    public static Collection<Location> dtoToEntity(Collection<LocationDTO> locationDTOS) {
        List<Location> locations = new ArrayList<>();
        for (LocationDTO locationDTO : locationDTOS) {
            locations.add(dtoToEntity(locationDTO));
        }
        return locations;
    }
}
