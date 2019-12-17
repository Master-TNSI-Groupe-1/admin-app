package com.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDTO implements Serializable {

    private Integer idLocation;
    private String name;
    private String urlImage;
    private boolean isEnabled;
    private List<PointXYDTO> pointXYList;
    private List<SensorsDTO> sensorsList;

    public LocationDTO() {
        pointXYList = new ArrayList<>();
        sensorsList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public List<PointXYDTO> getPointXYList() {
        return pointXYList;
    }

    public void setPointXYList(List<PointXYDTO> pointXYList) {
        this.pointXYList = pointXYList;
    }

    public List<SensorsDTO> getSensorsList() {
        return sensorsList;
    }

    public void setSensorsList(List<SensorsDTO> sensorsList) {
        this.sensorsList = sensorsList;
    }

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    @Override
    public String toString() {
        return "LocationDTO{" +
                "idLocation=" + idLocation +
                ", name='" + name + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", isEnabled=" + isEnabled +
                ", pointXYList=" + pointXYList +
                ", sensorsList=" + sensorsList +
                '}';
    }
}
