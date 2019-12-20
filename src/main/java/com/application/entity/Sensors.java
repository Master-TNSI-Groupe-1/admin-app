package com.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Sensors implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sensor")
    private Integer id;

    @Basic
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_location")
    @JsonIgnore
    private Location location;

    @Basic
    @Column(name = "ip_config", length = 50)
    private String ipConfig;

    @Basic
    @Column(name = "is_enabled")
    @JsonProperty
    private boolean isEnabled;

    @Basic
    @Column(name = "is_input")
    @JsonProperty
    private boolean isInput;

    @Basic
    @Column(name = "sensor_name")
    private Integer sensorName;

    public Sensors() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
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

    public Integer getSensorName() {
        return sensorName;
    }

    public void setSensorName(Integer sensorName) {
        this.sensorName = sensorName;
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
