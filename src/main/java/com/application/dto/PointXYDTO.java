package com.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PointXYDTO implements Serializable {

    private Integer idPoint;

    private int latitude;

    private int longitude;

    private LocationDTO location;

    public PointXYDTO() {
        location = new LocationDTO();
    }

    public Integer getIdPoint() {
        return idPoint;
    }

    public void setIdPoint(Integer idPoint) {
        this.idPoint = idPoint;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "PointXYDTO{" +
                "idPoint=" + idPoint +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", location=" + location +
                '}';
    }
}
