package com.application.service;


import com.application.dto.UpdateLocationDTO;
import com.application.entity.Location;

import java.util.Collection;

public interface LocationService {

    Collection<Location> findAllBySite(final int idSite);

    Location findById(final Integer id);

    Location update(final UpdateLocationDTO updateLocationDTO);

    Location create(final Location location);
};
