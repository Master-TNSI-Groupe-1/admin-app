package com.application.dto.mapper;

import com.application.dto.SiteDTO;
import com.application.entity.Site;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;

public class SiteMapper {

    public static SiteDTO entityToDTO(Site site) {
        SiteDTO siteDTO = new SiteDTO();
        siteDTO.setIdSite(site.getIdSite());
        siteDTO.setCity(site.getCity());
        siteDTO.setEnabled(site.isEnabled());
        if(CollectionUtils.isNotEmpty(site.getLocationList())) {
            siteDTO.setLocationList(new ArrayList<>(LocationMapper.entityToDTO(site.getLocationList())));
        }
        siteDTO.setName(site.getName());
        siteDTO.setUrlImage(site.getUrlImage());
        return siteDTO;
    }

    public static Site dtoToEntity(SiteDTO siteDTO) {
        Site site = new Site();
        site.setIdSite(siteDTO.getIdSite());
        site.setCity(siteDTO.getCity());
        site.setEnabled(siteDTO.isEnabled());
        if(CollectionUtils.isNotEmpty(siteDTO.getLocationList())) {
            site.setLocationList(new ArrayList<>(LocationMapper.dtoToEntity(siteDTO.getLocationList())));
        }
        site.setName(siteDTO.getName());
        site.setUrlImage(siteDTO.getUrlImage());
        return site;
    }
}
