package com.application.service;


import com.application.dto.UpdateLocationDTO;
import com.application.entity.Location;

import java.util.Collection;

public interface LocationService {

    Collection<Location> findAll();

    Location findById(Integer id);

    Location update(UpdateLocationDTO updateLocationDTO);

    Location create(Location location);
};
