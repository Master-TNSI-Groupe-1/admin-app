package com.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties
public class SensorsDTO implements Serializable {

    private Integer idSensor;

    private LocationDTO location;

    private String ipConfig;

    private boolean isEnabled;

    private boolean isInput;

    public SensorsDTO() {
        location = new LocationDTO();
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    public String getIpConfig() {
        return ipConfig;
    }

    public void setIpConfig(String ipConfig) {
        this.ipConfig = ipConfig;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isInput() {
        return isInput;
    }

    public void setInput(boolean input) {
        isInput = input;
    }

    public Integer getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(Integer idSensor) {
        this.idSensor = idSensor;
    }

    @Override
    public String toString() {
        return "SensorsDTO{" +
                "idSensor=" + idSensor +
                ", location=" + location +
                ", ipConfig='" + ipConfig + '\'' +
                ", isEnabled=" + isEnabled +
                ", isInput=" + isInput +
                '}';
    }
}
