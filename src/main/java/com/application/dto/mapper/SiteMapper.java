package com.application.dto.mapper;

import com.application.dto.LocationDTO;
import com.application.dto.SiteDTO;
import com.application.dto.UsersDTO;
import com.application.entity.Location;
import com.application.entity.Site;
import com.application.entity.Users;

public class SiteMapper {

    public static SiteDTO entityToDTO(Site site) {
        SiteDTO siteDTO = new SiteDTO();
        siteDTO.setIdSite(site.getIdSite());
        siteDTO.setCity(site.getCity());
        siteDTO.setEnabled(site.isEnabled());
        for(Location location : site.getLocationList()) {
            siteDTO.getLocationList().add(LocationMapper.entityToDTO(location));
        }
        siteDTO.setName(site.getName());
        siteDTO.setUrlImage(site.getUrlImage());
        for(Users users : site.getUsersList()) {
            siteDTO.getUsersList().add(UsersMapper.entityToDTO(users));
        }
        return siteDTO;
    }

    public static Site dtoToEntity(SiteDTO siteDTO) {
        Site site = new Site();
        site.setIdSite(siteDTO.getIdSite());
        site.setCity(siteDTO.getCity());
        site.setEnabled(siteDTO.isEnabled());
        for(LocationDTO locationDTO : siteDTO.getLocationList()) {
            site.getLocationList().add(LocationMapper.dtoToEntity(locationDTO));
        }
        site.setName(siteDTO.getName());
        site.setUrlImage(siteDTO.getUrlImage());
        for(UsersDTO usersDTO : siteDTO.getUsersList()) {
            site.getUsersList().add(UsersMapper.dtoToEntity(usersDTO));
        }
        return site;
    }
}
