package com.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_location")
    private Integer id;

    @Basic
    private String name;

    @Basic
    @Column(name = "url_image")
    private String urlImage;

    @Basic
    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Basic
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_site")
    @JsonIgnore
    private Site site;

    @Basic
    @Column(name = "number_places")
    private int numberPlaces;

    @Basic
    @Column(name = "number_user")
    private int numberUser;

    @OneToMany(mappedBy = "location", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<PointXY> pointXYList;

    @OneToMany(mappedBy = "location", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Sensors> sensorsList;

    public Location() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public int getNumberPlaces() {
        return numberPlaces;
    }

    public void setNumberPlaces(int numberPlaces) {
        this.numberPlaces = numberPlaces;
    }

    public int getNumberUser() {
        return numberUser;
    }

    public void setNumberUser(int numberUser) {
        this.numberUser = numberUser;
    }

    public List<PointXY> getPointXYList() {
        return pointXYList;
    }

    public void setPointXYList(List<PointXY> pointXYList) {
        this.pointXYList = pointXYList;
    }

    public List<Sensors> getSensorsList() {
        return sensorsList;
    }

    public void setSensorsList(List<Sensors> sensorsList) {
        this.sensorsList = sensorsList;
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
