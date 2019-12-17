package com.application.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_location")
    private Integer idLocation;

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
    private Site site;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PointXY> pointXYList;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sensors> sensorsList;

    public Location() { }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
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

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }
}
