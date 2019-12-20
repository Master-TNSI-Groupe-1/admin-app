package com.application.repository;

import com.application.entity.PointXY;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointXYRepository extends CrudRepository<PointXY, Integer> {

}
