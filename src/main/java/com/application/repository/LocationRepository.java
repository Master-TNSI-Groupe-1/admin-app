package com.application.repository;

import com.application.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class LocationRepository implements CrudRepository<Location, Integer> {
}
