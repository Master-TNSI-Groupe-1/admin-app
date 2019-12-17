package com.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PointXYDTO implements Serializable {

    private Integer idPoint;

    private int latitude;

    private int longitude;

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

    @Override
    public String toString() {
        return "PointXYDTO{" +
                "idPoint=" + idPoint +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
