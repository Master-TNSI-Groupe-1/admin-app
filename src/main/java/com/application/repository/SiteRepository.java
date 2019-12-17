package com.application.repository;

import com.application.entity.Site;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteRepository extends CrudRepository<Site, Integer> {

    List<Site> findAll();
}
