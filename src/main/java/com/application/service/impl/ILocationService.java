package com.application.service.impl;

import com.application.configuration.ErrorMessage;
import com.application.dto.UpdateLocationDTO;
import com.application.entity.Location;
import com.application.entity.PointXY;
import com.application.entity.Sensors;
import com.application.repository.LocationRepository;
import com.application.service.LocationService;
import com.application.service.PointXYService;
import com.application.service.SensorService;
import com.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ILocationService implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    UserService userService;

    @Autowired
    PointXYService pointXYService;

    @Autowired
    SensorService sensorService;

    @Override
    public Collection<Location> findAllBySite(final int idSite) {
        return locationRepository.findAllBySite_Id(idSite);
    }

    @Override
    public Location findById(final Integer id) {
        return locationRepository.findById(id).orElseThrow(() -> new NullPointerException(ErrorMessage.locationNotFound));
    }

    @Override
    public Location update(final UpdateLocationDTO updateLocationDTO) {
        final Location location = locationRepository.findById(updateLocationDTO.getId()).orElseThrow(() -> new NullPointerException(ErrorMessage.locationNotFound));
        location.setName(updateLocationDTO.getName());
        location.setNumberPlaces(updateLocationDTO.getNumberPlaces());
        return locationRepository.save(location);
    }

    @Override
    public Location create(final Location location) {
        location.setSite(userService.getLoggedUser().getSite());
        final Location newLocation = locationRepository.save(location);

        for(PointXY pointXY : newLocation.getPointXYList()) {
            pointXY.setLocation(newLocation);
            pointXYService.update(pointXY);
        }

        for(Sensors sensors : newLocation.getSensorsList()) {
            sensors.setLocation(newLocation);
            sensorService.update(sensors);
        }

        return findById(location.getId());
    }
}
