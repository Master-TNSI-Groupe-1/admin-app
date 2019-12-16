package com.application.repository;

import com.application.entity.Sensors;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorsRepository extends CrudRepository<Sensors, Integer> {
}
