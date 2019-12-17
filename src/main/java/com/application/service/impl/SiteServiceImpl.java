package com.application.service.impl;

import com.application.entity.Site;
import com.application.repository.SiteRepository;
import com.application.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    SiteRepository siteRepository;

    @Override
    public List<Site> findAllSite() {
        return siteRepository.findAll();
    }
}
