package com.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

@JsonIgnoreProperties
public class SensorsDTO implements Serializable {

    private Integer idSensor;
    private String ipConfig;
    private boolean isEnabled;
    private boolean isInput;

    public SensorsDTO() {}

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
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
