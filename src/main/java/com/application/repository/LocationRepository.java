package com.application.repository;

import com.application.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

    Location findById(int id);

    Collection<Location> findAll();
}
