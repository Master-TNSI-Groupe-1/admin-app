package com.application.service.impl;

import com.application.dto.SiteDTO;
import com.application.dto.mapper.SiteMapper;
import com.application.entity.Site;
import com.application.repository.SiteRepository;
import com.application.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    SiteRepository siteRepository;

    @Override
    public List<SiteDTO> findAllSite() {
        List<SiteDTO> siteDTOList = new ArrayList<>();
        for(Site site : siteRepository.findAll()) {
            //System.out.println(site.getName() + site.getUserOwner().getFirstname());

            // La condition a implementé c'est
            // Si l'utilisateur de la session est égale a l'utilisateur du site courant.
            if(site.getUserOwner() != null)
                siteDTOList.add(SiteMapper.entityToDTO(site));
        }
        return siteDTOList;
    }
}
